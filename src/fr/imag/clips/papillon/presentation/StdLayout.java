/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © 2001 Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.16  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.15  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.14.2.2  2004/01/24 04:35:02  mangeot
 * Added accesskey for the main lookup form. Beware, it can interfere with the built-in browser accesskeys!
 *
 * Revision 1.14.2.1  2004/01/22 05:36:05  mangeot
 * Improving accessibility for non javascripts enabled users and added confirmations for javacsripts enabled browsers
 *
 * Revision 1.14  2003/10/11 02:59:15  mangeot
 * *** empty log message ***
 *
 * Revision 1.13  2003/10/06 06:44:35  mangeot
 * Corrected a bug in HTML display
 *
 * Revision 1.12  2003/10/03 05:55:59  mangeot
 * Put the lang select menu in a separate file because it is language independent
 * Stick the input parameters in the ConsultExpert interface
 *
 * Revision 1.11  2003/10/03 05:34:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.10  2003/08/25 07:35:23  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2003/08/22 11:11:04  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2003/08/20 08:15:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2003/08/20 02:28:08  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2003/08/19 06:21:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2003/08/14 08:30:18  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.4  2003/06/04 16:43:30  serasset
 * Correction de la fonction de login erronee de liu.
 *
 * Revision 1.3  2003/06/04 15:37:46  serasset
 * Mise en place de la nouvelle version de la gestion des utilisateurs.
 *
 * Revision 1.2.2.1  2003/08/12 04:58:14  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/01/10 08:11:57  mangeot
 * Problem with labels and UTF-8 fixed for internet explorer and icab
 * Problem with language identification fixed eg: en-US
 *
 * Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.6  2002/10/25 14:10:35  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.5.2.2  2002/10/23 09:51:12  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.5.2.1  2002/10/09 07:30:11  mangeot
 * Added the logout function
 *
 * Revision 1.5  2002/09/16 13:34:24  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.4.2.3  2002/08/08 09:11:58  mangeot
 * New Home page with simplified interface a lot of work
 * + localization in german
 *
 * Revision 1.4.2.2  2002/08/02 08:12:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.2.1  2002/08/01 10:52:10  mangeot
 * added the language shift directly into BasePo
 * Modified the consult html
 * added the login user into stdlayout
 *
 * Revision 1.4  2002/07/26 10:00:30  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.3.2.1  2002/07/12 13:50:50  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.3  2002/06/10 11:07:58  mangeot
 * I began to implement the localization but very rapidly ...
 *
 * Revision 1.2  2001/07/04 12:50:50  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * 
 * Cette classe implémente le layout par défaut de l'ensemble des pages de papillon
 * Les pages utilisent une instance de Layout et se contentent de remplir son contenu
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
import org.w3c.dom.html.*;
import java.io.*;


// For the user
import fr.imag.clips.papillon.business.user.*;
import fr.imag.clips.papillon.business.locales.*;
import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.utility.Utility;

import fr.imag.clips.papillon.presentation.html.orig.*;
import fr.imag.clips.papillon.presentation.PapillonSessionData;
//for debug
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;


// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;

//import java.io.*;

public class StdLayout {
    LayoutHTML layout;
	  MenuHTML menu;
    
    // Constructeurs

    // Constructeur de base
    public StdLayout(HttpPresentationComms comms, PapillonSessionData sessionData, String url)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException, UnsupportedEncodingException
{
        this.layout = new StdLayout(comms,sessionData,url,"").layout;
    }

        // Constructeur avec script
        public StdLayout(HttpPresentationComms comms, PapillonSessionData sessionData, String url, String script)
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException, UnsupportedEncodingException
    {
	Node headerNode;
        Node menuNode;
        HTMLSelectElement langSelectElement;

        // Création du document
        layout = (LayoutHTML)MultilingualHtmlTemplateFactory.createTemplate("LayoutHTML", comms, sessionData);
        menu = (MenuHTML)MultilingualHtmlTemplateFactory.createTemplate("MenuHTML", comms, sessionData);
        HeaderHTML header = (HeaderHTML)MultilingualHtmlTemplateFactory.createTemplate("HeaderHTML", comms, sessionData);
        headerNode = header.getElementHeader();
        UserLanguageSelectHTML langSelect = (UserLanguageSelectHTML)MultilingualHtmlTemplateFactory.createTemplate("UserLanguageSelectHTML", comms, sessionData);
        langSelectElement = (HTMLSelectElement) langSelect.getElementLang();


        // adding a script if needed
        HTMLScriptElement scriptElement = (HTMLScriptElement)layout.getElementScript();
		if (null != script && !script.equals("")) {
            scriptElement.setText(scriptElement.getText() + script);
        }
		scriptElement.removeAttribute("id");

        // Insertion du header et du footer
				layout.getElementHeaderPlace().appendChild(layout.importNode(headerNode,true));
				layout.getElementFooterPlace().appendChild(layout.importNode(headerNode,true));

        // Gestion du menu :
        // Si les utilisateurs sont logues, on met leur login

        // menu
				addLangForm(sessionData, langSelectElement, url);
				
				addLoginMenu(sessionData.getUser());

				addConsultForm(sessionData);

				addLoggedUserMenu(sessionData.getUser());

				addReviewerMenu(sessionData.getUser());

				addAdminMenu(sessionData.getUser());
				
        menuNode = menu.getElementMenu();


        // On inclue le noeud menu du document menu dans le noeud correspondant
        // dans le document layout.
        layout.getElementMenuPlace().appendChild(layout.importNode(menuNode,true));

    }
    
    public LayoutHTML getLayout() {
        return layout;
    }

		protected void addLangForm(PapillonSessionData sessionData, HTMLSelectElement langSelect, String url) {
			// I select by default the user preferred language for the languages menu
				if (!sessionData.getClientWithLabelDisplayProblems()) {
					BasePO.setUnicodeLabels(langSelect);
				}
			BasePO.setSelected(langSelect, sessionData.getUserPreferredLanguage());

			// I add the LangSelectElement in the menu
			menu.getElementLangSelectPlace().appendChild(menu.importNode(langSelect,true));
			menu.getElementLangSelectPlace().removeAttribute("id");

			// I add the URL of the page for the action of the language form
			HTMLFormElement langForm = (HTMLFormElement) menu.getElementLangForm();
			langForm.setAction(url);			
		}

		protected void addLoginMenu(User myUser)
			throws PapillonBusinessException {
				// If the user is logged
        if (null != myUser && !myUser.IsEmpty()) {
					menu.setTextUserLogin(myUser.getLogin());
					Utility.removeElement(menu.getElementLoginAnchor());
				}
				// If the user is not logged
				else {
					menu.setTextUserLogin("");
					Utility.removeElement(menu.getElementUserProfileAnchor());
					Utility.removeElement(menu.getElementLogoutAnchor());
				}
			}
		
		protected void addConsultForm(PapillonSessionData sessionData)
			throws PapillonBusinessException,
			HttpPresentationException,
			UnsupportedEncodingException {
				AvailableLanguages MyAvailableLanguages = new AvailableLanguages();

        String[] allSourceLanguages=MyAvailableLanguages.getSourceLanguagesArray();
        String[] allTargetLanguages=MyAvailableLanguages.getTargetLanguagesArray();

				HTMLInputElement headwordInput = menu.getElementHeadwordInput();
				String headtmp = sessionData.getPreference("Home.po",headwordInput.getName());
				if (headtmp !=null) {
					headwordInput.setValue(headtmp);
				}

				// Adding the appropriate source languages to the source list
				HTMLOptionElement sourceOptionTemplate = menu.getElementSourceOptionTemplate();
				HTMLSelectElement sourceSelect = (HTMLSelectElement) sourceOptionTemplate.getParentNode();
				sourceOptionTemplate.removeAttribute("id");
				// We assume that the option element has only one text child
		// (it should be this way if the HTML is valid...)

				Text sourceTextTemplate = (Text)sourceOptionTemplate.getFirstChild();
				String langLoc = sessionData.getUserPreferredLanguage();
				String prefSrcLang = sessionData.getPreference("Home.po",sourceSelect.getName());
				if (prefSrcLang == null || prefSrcLang.equals("")) {
					prefSrcLang = langLoc;
					sessionData.setPreference("Home.po",sourceSelect.getName(),prefSrcLang);	
				}

				for (int i = 0; i < allSourceLanguages.length; i++) {
					String langi = allSourceLanguages[i];

					sourceOptionTemplate.setValue(langi);
					// Certains navigateurs ne sont pas conformes aux specs
		 // pour eux,je dois mettre un label en ascii
					if (sessionData.getClientWithLabelDisplayProblems()) {
						sourceOptionTemplate.setLabel(Languages.localizeLabel(langLoc,langi));
					}
					else {
						sourceOptionTemplate.setLabel(Languages.localizeName(langLoc,langi));
					}
					sourceOptionTemplate.setSelected(langi.equals(prefSrcLang));

					sourceTextTemplate.setData(Languages.localizeName(langLoc,langi));
					sourceSelect.appendChild(sourceOptionTemplate.cloneNode(true));
				}
				sourceSelect.removeChild(sourceOptionTemplate);

				// Adding the appropriate target languages to the target list
				HTMLOptionElement targetOptionTemplate = menu.getElementTargetOptionTemplate();
				HTMLSelectElement targetSelect = (HTMLSelectElement) targetOptionTemplate.getParentNode();
				if (!sessionData.getClientWithLabelDisplayProblems()) {
					BasePO.setUnicodeLabels(targetSelect);
				}
				targetOptionTemplate.removeAttribute("id");
				// We assume that the option element has only one text child
		// (it should be this way if the HTML is valid...)
				Text targetTextTemplate = (Text)targetOptionTemplate.getFirstChild();
				String prefTrgLang = sessionData.getPreference("Home.po",targetSelect.getName());
				if (prefTrgLang == null || prefTrgLang.equals("")) {
					prefTrgLang = Home.ALL_TARGETS;
					sessionData.setPreference("Home.po",targetSelect.getName(),prefTrgLang);
				}
				
				for (int i = 0; i < allTargetLanguages.length; i++) {
					String langi = allTargetLanguages[i];
					targetOptionTemplate.setValue(langi);
					if (sessionData.getClientWithLabelDisplayProblems()) {
						targetOptionTemplate.setLabel(Languages.localizeLabel(langLoc, langi));
					}
					else {
						targetOptionTemplate.setLabel(Languages.localizeName(langLoc, langi));
					}
					// We should select the previously selected target languages...
					targetTextTemplate.setData(Languages.localizeName(langLoc, langi));
					targetSelect.appendChild(targetOptionTemplate.cloneNode(true));
				}
				targetSelect.removeChild(targetOptionTemplate);
                BasePO.setSelected(menu.getElementTarget(),prefTrgLang);
			}

				protected void addLoggedUserMenu(User myUser)
			throws PapillonBusinessException {
				// If the user is not logged
        if (null == myUser || myUser.IsEmpty()) {
					Utility.removeElement(menu.getElementLexieMenuTable());
					Utility.removeElement(menu.getElementAxieMenuTable());
				}
			}

				protected void addReviewerMenu(User myUser)
			throws PapillonBusinessException {
				// If the user is not a specialist reviewer
        if (null == myUser || myUser.IsEmpty() ||
						!myUser.IsSpecialist()) {
					Utility.removeElement(menu.getElementReviewMenuTable());
				}
			}

				protected void addAdminMenu(User myUser)
			throws PapillonBusinessException {
				// If the user is not logged
        if (null == myUser || myUser.IsEmpty() ||
						!myUser.IsAdmin()) {
					Utility.removeElement(menu.getElementAdminMenuTable());
				}
			}
		
}
