/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 *  © 2001 Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id $
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.8  2007/04/09 15:27:19  serasset
 *  Modified xhtml files and applications layout, because the "Targets" id was duplicated
 *  between QueryMenu and AdvancedSearch.
 *  Corrected problems with the Lexalp italian home page and advanced query form.
 *  Added a link to axie when searching for a lexie and user is logged in.
 *
 *  Revision 1.7  2007/01/15 17:24:28  serasset
 *  Merged Modification made for the DRI instance with main trunk modifications.
 *
 *  Revision 1.6.2.1  2006/12/14 12:19:29  serasset
 *  Added DRI application specific files
 *  Modified the LexalpLayout to make it more generic
 *
 *  Revision 1.6  2006/08/10 22:17:13  fbrunet
 *  - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 *  - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 *  - Bug correction : +/- in advanced search
 *
 *  Revision 1.5  2006/06/19 15:27:01  fbrunet
 *  Jibiki : improvement of the search result display
 *  Lexalp : add help menu (link to wiki and bug tracker)
 *
 *  Revision 1.4  2006/06/09 10:10:43  fbrunet
 *  Add generic components (AdvancedQueryForm, QueryRequest and ViewQueryResult) in Home.java
 *
 *  Revision 1.3  2006/04/06 15:06:39  fbrunet
 *  New class 'creationEditInit' : create new entry
 *  Modify LexALPEditEntry : only edit entry
 *
 *  Revision 1.2  2006/03/01 15:12:31  mangeot
 *  Merge between maintrunk and LEXALP_1_1 branch
 *
 *  Revision 1.1.4.2  2006/02/17 13:21:25  mangeot
 *
 *  MM: modified AdvancedQueryForm. getAllTargetLanguages, getAllSourceLanguages and getCdmElementsWithDefaultLanguage are now static in AvailableLanguages.java in order to accelerate the execution.
 *
 *  Revision 1.1.4.1  2005/08/31 15:01:39  serasset
 *  Applied modifications done on the LEXALP_1_0 branch to updated sources of the
 *  trunk to create a new updated LEXALP_1_1 branch.
 *
 *  Revision 1.1.2.1  2005/07/22 13:28:32  serasset
 *  Modified EditEntryInit for Lexalp. It now serves as a main page for db maintenance.
 *  Added a function to get url for QueryParameter.
 *  Modified the way xslsheets are handled in order to allow several xslsheet with the same name, different dicts.
 *
 *  Revision 1.1  2005/05/24 12:51:22  serasset
 *  Updated many aspect of the Papillon project to handle lexalp project.
 *  1. Layout is now parametrable in the application configuration file.
 *  2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 *  3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 *  4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 *  5. It is now possible to give a name to the cookie key in the app conf file
 *  6. Several bug fixes.
 *
 *  -----------------------------------------------
 *
 *  Cette classe implémente le layout par défaut de l'ensemble des pages de papillon
 *  Les pages utilisent une instance de Layout et se contentent de remplir son contenu
 *
 */
package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;
// For the node
import org.w3c.dom.*;
//import org.w3c.dom.html.*;
import org.enhydra.xml.xhtml.dom.*;

import java.io.*;

// For the user
import fr.imag.clips.papillon.business.user.*;
import fr.imag.clips.papillon.business.locales.*;
import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.utility.Utility;

import fr.imag.clips.papillon.presentation.xhtmllexalp.orig.*;
import fr.imag.clips.papillon.presentation.PapillonSessionData;
//for debug
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.text.DateFormat;

//import java.io.*;

/**
*  Description of the Class
 *
 * @author     serasset
 * @created    December 8, 2004
 */
public class LexALPLayout implements StdLayout {
    LayoutXHTML layout;
        // Constructeurs
    
    /**
        *  Constructor for the StdLayout object
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @param  url
     *      Description of the Parameter
     * @param  script
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     * @exception  UnsupportedEncodingException
     *      Description of the Exception
     */
    public void initLayout(HttpPresentationComms comms, PapillonSessionData sessionData, String url, XHTMLScriptElement script)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException, UnsupportedEncodingException {
            
            // Création du document
            layout = (LayoutXHTML) MultilingualXHtmlTemplateFactory.createTemplate("LayoutXHTML", comms, sessionData);
            
            // adding a new script if needed
            XHTMLScriptElement scriptElement = (XHTMLScriptElement) layout.getElementScript();
            if (null != script) {
                Node scriptParent = scriptElement.getParentNode();
                scriptParent.removeChild(scriptElement);
                scriptParent.appendChild(layout.importNode(script, true));
            }
            scriptElement.removeAttribute("id");
            
            // Gestion du menu :
            // Si les utilisateurs sont logues, on met leur login
            
            // menu
            handleLangForm(comms, sessionData, url);
            handleConsultForm(comms, sessionData);
            handleLexieMenu(comms, sessionData);
            handleHelpMenu(comms, sessionData);
            //handleAxieMenu(comms, sessionData);
            //handleReviewerMenu(comms, sessionData);
            handleAdministratorMenu(comms, sessionData);
            removeMenuBlockPlaceHolder();
        }
    
    
    /**
        *  Gets the layout attribute of the StdLayout object
     *
     * @return    The layout value
     */
    public Document getLayout() {
        return layout;
    }
    
    /**
        *  Gets the layout attribute of the StdLayout object
     *
     * @return    The layout value
     */
    public Node getContentPlaceHolder() {
        return layout.getElementMainColumn();
    }
    
	public Node getBannerPlaceHolder() {
        return layout.getElementBannerPlaceHolder();
    }
    
	public Node getContextualMenuPlaceHolder() {
        return layout.getElementMenuColumn();
    }
    
	public Node getBannerContent() {
        return layout.getElementBannerContent();
    }
	
    
    /**
        *  Description of the Method
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @param  url
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     * @exception  PapillonBusinessException
     *      Description of the Exception
     */
    protected void handleLangForm(HttpPresentationComms comms, PapillonSessionData sessionData, String url)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException, PapillonBusinessException {
            
            UserLanguageSelectXHTML langSelect = (UserLanguageSelectXHTML) MultilingualXHtmlTemplateFactory.createTemplate("UserLanguageSelectXHTML", comms, sessionData);
            XHTMLSelectElement langSelectElement = (XHTMLSelectElement) langSelect.getElementLang();
            
            // I select by default the user preferred language for the languages menu
            if (!sessionData.getClientWithLabelDisplayProblems()) {
                PapillonBasePO.setUnicodeLabels(langSelectElement);
            }
            PapillonBasePO.setSelected(langSelectElement, sessionData.getUserPreferredLanguage());
            
            LangAndUserXHTML userMenu = (LangAndUserXHTML) MultilingualXHtmlTemplateFactory.createTemplate("LangAndUserXHTML", comms, sessionData);
            // I add the LangSelectElement in the menu
            Node selectHolder = userMenu.getElementLangSelectPlace();
            selectHolder.getParentNode().replaceChild(userMenu.importNode(langSelectElement, true), selectHolder);
            
            // I add the URL of the page for the action of the language form
            XHTMLFormElement umLangForm = (XHTMLFormElement) userMenu.getElementLangForm();
            umLangForm.setAction(url);
            
            // Handle the user part of the block
            handleUserLogin(userMenu, sessionData.getUser());
            
            Node placeHolder = layout.getElementMenuBlockPlaceHolder();
            Node placeHolderMother = placeHolder.getParentNode();
            placeHolderMother.insertBefore(layout.importNode(userMenu.getElementLanguageAndUser(), true),placeHolder);
            //layout.getElementMenuColumn().appendChild(layout.importNode(userMenu.getElementLanguageAndUser(), true));
        }
    
    
    /**
        *  Description of the Method
     *
     * @param  userMenu                       Description of the Parameter
     * @param  myUser                         Description of the Parameter
     * @exception  PapillonBusinessException  Description of the Exception
     */
    protected void handleUserLogin(LangAndUserXHTML userMenu, User myUser)
        throws PapillonBusinessException {
            // If the user is logged
            if (null != myUser && !myUser.isEmpty()) {
                userMenu.setTextUserLogin(myUser.getLogin());
                Utility.removeElement(userMenu.getElementLoginAnchor());
            }                                         // If the user is not logged
            else {
                userMenu.setTextUserLogin("");
                Utility.removeElement(userMenu.getElementUserProfileAnchor());
                Utility.removeElement(userMenu.getElementLogoutAnchor());
            }
        }
    
    
    /**
        *  Description of the Method
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     * @exception  PapillonBusinessException
     *      Description of the Exception
     * @exception  HttpPresentationException
     *      Description of the Exception
     * @exception  UnsupportedEncodingException
     *      Description of the Exception
     */
    protected void handleConsultForm(HttpPresentationComms comms, PapillonSessionData sessionData)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException,
        PapillonBusinessException,
        HttpPresentationException,
        UnsupportedEncodingException {
            
            
            QueryMenuXHTML queryMenu = (QueryMenuXHTML) MultilingualXHtmlTemplateFactory.createTemplate("QueryMenuXHTML", comms, sessionData);
            //XHTMLInputElement headwordInput = queryMenu.getElementHeadwordInput();
            XHTMLInputElement headwordInput = queryMenu.getElementValueField();
            String headtmp = sessionData.getPreference("Home.po", headwordInput.getName());
            if (headtmp != null) {
                headwordInput.setValue(headtmp);
            }
            
            // Adding the appropriate source languages to the source list
            XHTMLOptionElement sourceOptionTemplate = queryMenu.getElementSourceOptionTemplate();
            XHTMLSelectElement sourceSelect = (XHTMLSelectElement) sourceOptionTemplate.getParentNode();
            sourceOptionTemplate.removeAttribute("id");
            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            
            Text sourceTextTemplate = (Text) sourceOptionTemplate.getFirstChild();
            String langLoc = sessionData.getUserPreferredLanguage();
            String prefSrcLang = sessionData.getPreference("Home.po", sourceSelect.getName());
            if (prefSrcLang == null || prefSrcLang.equals("")) {
                prefSrcLang = langLoc;
                sessionData.setPreference("Home.po", sourceSelect.getName(), prefSrcLang);
            }
            
            for (Iterator iter = AvailableLanguages.getSourceLanguagesArray().iterator(); iter.hasNext();) {
                String langi = (String)iter.next();
                
                sourceOptionTemplate.setValue(langi);
                // Certains navigateurs ne sont pas conformes aux specs
                // pour eux,je dois mettre un label en ascii
                if (sessionData.getClientWithLabelDisplayProblems()) {
                    sourceOptionTemplate.setLabel(Languages.localizeLabel(langLoc, langi));
                } else {
                    sourceOptionTemplate.setLabel(Languages.localizeName(langLoc, langi));
                }
                sourceOptionTemplate.setSelected(langi.equals(prefSrcLang));
                
                sourceTextTemplate.setData(Languages.localizeName(langLoc, langi));
                sourceSelect.appendChild(sourceOptionTemplate.cloneNode(true));
            }
            sourceSelect.removeChild(sourceOptionTemplate);
            
            // Adding the appropriate target languages to the target list
            //XHTMLOptionElement targetOptionTemplate = queryMenu.getElementTargetOptionTemplate();
            XHTMLOptionElement targetOptionTemplate = queryMenu.getElementTargetTmpl();
            XHTMLSelectElement targetSelect = (XHTMLSelectElement) targetOptionTemplate.getParentNode();
            if (!sessionData.getClientWithLabelDisplayProblems()) {
                PapillonBasePO.setUnicodeLabels(targetSelect);
            }
            targetOptionTemplate.removeAttribute("id");
            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            Text targetTextTemplate = (Text) targetOptionTemplate.getFirstChild();
            String prefTrgLang = sessionData.getPreference("Home.po", targetSelect.getName());
            if (prefTrgLang == null || prefTrgLang.equals("")) {
                prefTrgLang = Home.ALL_TARGETS;
                sessionData.setPreference("Home.po", targetSelect.getName(), prefTrgLang);
            }
            
            //
            for (Iterator iter = AvailableLanguages.getTargetLanguagesArray().iterator(); iter.hasNext();) {
                String langi = (String)iter.next();
                
                //
                targetOptionTemplate.setValue(langi);
                if (sessionData.getClientWithLabelDisplayProblems()) {
                    targetOptionTemplate.setLabel(Languages.localizeLabel(langLoc, langi));
                } else {
                    targetOptionTemplate.setLabel(Languages.localizeName(langLoc, langi));
                }
                // We should select the previously selected target languages...
                targetTextTemplate.setData(Languages.localizeName(langLoc, langi));
                targetSelect.appendChild(targetOptionTemplate.cloneNode(true));
            }
            targetSelect.removeChild(targetOptionTemplate);
            //PapillonBasePO.setSelected(queryMenu.getElementTarget(), prefTrgLang);
            PapillonBasePO.setSelected(queryMenu.getElementQMTargets(), prefTrgLang);
            
            // Add the menu to the Page
            Node placeHolder = layout.getElementMenuBlockPlaceHolder();
            Node placeHolderMother = placeHolder.getParentNode();
            placeHolderMother.insertBefore(layout.importNode(queryMenu.getElementQueryMenu(), true), placeHolder);
            //layout.getElementMenuColumn().appendChild(layout.importNode(queryMenu.getElementQueryMenu(), true));
        }
    
    
    /**
        *  Description of the Method
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     */
    protected void handleLexieMenu(HttpPresentationComms comms, PapillonSessionData sessionData)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException {
            // If the user is logged in add the lexie menu
            User myUser = sessionData.getUser();
            if (null != myUser && !myUser.isEmpty()) {
                LexiesManagementXHTML lexiesMenu = (LexiesManagementXHTML) MultilingualXHtmlTemplateFactory.createTemplate("LexiesManagementXHTML", comms, sessionData);
                
                Node placeHolder = layout.getElementMenuBlockPlaceHolder();
                Node placeHolderMother = placeHolder.getParentNode();
                placeHolderMother.insertBefore(layout.importNode(lexiesMenu.getElementLexiesManagement(), true), placeHolder);
                
                //layout.getElementMenuColumn().appendChild(layout.importNode(lexiesMenu.getElementLexiesManagement(), true));
            }
        }
    
    
    /**
        *  Description of the Method
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     */
    protected void handleHelpMenu(HttpPresentationComms comms, PapillonSessionData sessionData)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException {
            // If the user is logged in add the help menu
            User myUser = sessionData.getUser();
            if (null != myUser && !myUser.isEmpty()) {
                HelpMenuXHTML helpMenu = (HelpMenuXHTML) MultilingualXHtmlTemplateFactory.createTemplate("HelpMenuXHTML", comms, sessionData);
                
                Node placeHolder = layout.getElementMenuBlockPlaceHolder();
                Node placeHolderMother = placeHolder.getParentNode();
                placeHolderMother.insertBefore(layout.importNode(helpMenu.getElementHelpMenu(), true), placeHolder);
                
                //layout.getElementMenuColumn().appendChild(layout.importNode(lexiesMenu.getElementLexiesManagement(), true));
            }
        }
    
    
    /**
        *  Description of the Method
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     */
    protected void handleAxieMenu(HttpPresentationComms comms, PapillonSessionData sessionData)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException {
            // If the user is logged in add the lexie menu
            User myUser = sessionData.getUser();
            if (null != myUser && !myUser.isEmpty()) {
                AxiesManagementXHTML axiesMenu = (AxiesManagementXHTML) MultilingualXHtmlTemplateFactory.createTemplate("AxiesManagementXHTML", comms, sessionData);
                
                Node placeHolder = layout.getElementMenuBlockPlaceHolder();
                Node placeHolderMother = placeHolder.getParentNode();
                placeHolderMother.insertBefore(layout.importNode(axiesMenu.getElementAxiesManagement(), true), placeHolder);
                
                //layout.getElementMenuColumn().appendChild(layout.importNode(axiesMenu.getElementAxiesManagement(), true));
            }
        }
    
    
    /**
        *  Description of the Method
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     */
    protected void handleReviewerMenu(HttpPresentationComms comms, PapillonSessionData sessionData)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException {
            // If the user is not a specialist reviewer
            User myUser = sessionData.getUser();
            if (null != myUser && !myUser.isEmpty() && myUser.isSpecialist()) {
                ReviewerMenuXHTML reviewerMenu = (ReviewerMenuXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ReviewerMenuXHTML", comms, sessionData);

                Node placeHolder = layout.getElementMenuBlockPlaceHolder();
                Node placeHolderMother = placeHolder.getParentNode();
                placeHolderMother.insertBefore(layout.importNode(reviewerMenu.getElementReviewerMenu(), true), placeHolder);
                
                //layout.getElementMenuColumn().appendChild(layout.importNode(reviewerMenu.getElementReviewerMenu(), true));
            }
        }
    
    
    /**
        *  Description of the Method
     *
     * @param  comms
     *      Description of the Parameter
     * @param  sessionData
     *      Description of the Parameter
     * @exception  com.lutris.appserver.server.httpPresentation.HttpPresentationException
     *      Description of the Exception
     */
    protected void handleAdministratorMenu(HttpPresentationComms comms, PapillonSessionData sessionData)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException {
            // If the user is not a specialist reviewer
            User myUser = sessionData.getUser();
            if (null != myUser && !myUser.isEmpty() && myUser.isAdmin()) {
                AdministrationMenuXHTML adminMenu = (AdministrationMenuXHTML) MultilingualXHtmlTemplateFactory.createTemplate("AdministrationMenuXHTML", comms, sessionData);
                
                Node placeHolder = layout.getElementMenuBlockPlaceHolder();
                Node placeHolderMother = placeHolder.getParentNode();
                placeHolderMother.insertBefore(layout.importNode(adminMenu.getElementAdministrationMenu(), true), placeHolder);
                
                //layout.getElementMenuColumn().appendChild(layout.importNode(adminMenu.getElementAdministrationMenu(), true));
            }
        }
    
protected void removeMenuBlockPlaceHolder() {
    Node placeHolder = layout.getElementMenuBlockPlaceHolder();
    Node placeHolderMother = placeHolder.getParentNode();
    placeHolderMother.removeChild(placeHolder);
}
}
