/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.2  2005/06/15 16:48:28  mangeot
 *  Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
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
 *  Revision 1.7  2005/04/22 14:13:21  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.6  2005/04/11 12:29:59  mangeot
 *  Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 *  Revision 1.5.2.2  2005/03/29 09:41:33  serasset
 *  Added transaction support. Use CurrentDBTransaction class to define a transaction
 *  context in which all db commands will be executed.
 *
 *  Revision 1.5.2.1  2005/02/25 10:21:21  mangeot
 *  Added a new method getReferrer in order to get the client referrer
 *
 *  Revision 1.5  2005/01/15 20:02:19  mangeot
 *  Added new search options for ReviewContributions
 *
 *  Revision 1.4  2005/01/14 22:33:57  mangeot
 *  Fixed the BasePO.setSelected
 *  It seems that the enhydra setSelectedIndex does not work any more with enhydra5.1
 *
 *  Revision 1.3  2004/12/24 14:31:28  mangeot
 *  I merged the latest developments of Papillon5.0 with this version 5.1.
 *  Have to be tested more ...
 *
 *  Revision 1.2  2004/12/24 08:57:44  serasset
 *  Premiere version de l'interface avec fond papillon et transparence.
 *
 *  Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 *  Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 *  There are still bugs in the code.
 *
 *  Revision 1.14  2004/10/28 10:56:21  mangeot
 *  Added the list of connected users on AdminUsers.java,
 *  Added the possibility to sort in columns for some pages
 *  Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 *
 *  -----------------------------------------------
 *  Abstract class implementing the Base layout of all papillon presentations.
 */
package fr.imag.clips.papillon.presentation;

// Papillon import
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.presentation.xhtml.orig.*;
import fr.imag.clips.papillon.presentation.HTMLTransformFactory;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import com.lutris.appserver.server.Enhydra;
//import org.enhydra.xml.xmlc.XMLObject;
//import org.w3c.dom.html.*;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLOptionElement;
import org.w3c.dom.html.HTMLSelectElement;

import org.enhydra.xml.xhtml.dom.*;

import org.enhydra.xml.xmlc.*;
//import org.enhydra.xml.xmlc.html.*;
import com.lutris.logging.*;
import com.lutris.util.*;

// For the cookies
import javax.servlet.http.Cookie;
import fr.imag.clips.papillon.business.user.UsersFactory;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.text.DateFormat;

//pour le debogage
import fr.imag.clips.papillon.business.utility.*;
import fr.imag.clips.papillon.business.PapillonLogger;

import org.enhydra.xml.io.OutputOptions;
import org.enhydra.xml.io.DOMFormatter;

/**
*  Description of the Class
 *
 * @author     serasset
 * @created    December 8, 2004
 */
public abstract class PapillonBasePO extends AbstractPO {
    
    /**
    *  Description of the Field
     */
    protected final static String LANG_PARAMETER = "lang";
    
    // JavaScript to add in the header
    /**
        *  Description of the Field
     */
    protected String headerScript = "";
    
    // Known sections
    /**
        *  Description of the Field
     */
    public static int NO_SECTION = 0;
    /**
        *  Description of the Field
     */
    public static int INFORMATIONS_SECTION = 1;
    /**
        *  Description of the Field
     */
    public static int CONSULT_SECTION = 2;
    /**
        *  Description of the Field
     */
    public static int EDITION_SECTION = 3;
    /**
        *  Description of the Field
     */
    public static int CONTACTS_SECTION = 4;
    /**
        *  Description of the Field
     */
    public static int HELP_SECTION = 5;
    
    
    /**
        *  This is the procedure that is called when an HTML request occurs.
     *
     * @return                XMLObject The XMLObject (in HTML format) that is
     *      to be included in the standard layout.
     * @exception  Exception  Description of the Exception
     */
    public abstract Node getContent() throws Exception;
    
    
    
    /**
        *  This is the procedure that is called to know in what section we
     *  currently are in order for the header to be modified appropriately.
     *
     * @return    XMLObject The XMLObject (in HTML fomat) that is to be included
     *      in the standard layout.
     */
    protected abstract int getCurrentSection();
    
    /**
        *  Reference to the user logged in to the session
     */
    //protected User myUser = null;
    
    
    /**
        *  Sets the headerScript attribute of the PapillonBasePO object
     *
     * @param  newScript                          The new headerScript value
     * @exception  PapillonPresentationException  Description of the Exception
     */
    public void setHeaderScript(String newScript)
        throws PapillonPresentationException {
            this.headerScript = newScript;
        }
    
    /**
        *  Returns the complete document.
     *
     * @exception  Exception
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  IOException                Description of the Exception
     */
    public Node getDocument()
        throws HttpPresentationException, IOException, Exception {
            
            StdLayout stdLayout;
            Node content;
            Node finalContent;
            
            // Creation du contenu
            String lang = myGetParameter(LANG_PARAMETER);
            
            if (null != lang) {
                this.setUserPreferredLanguage(lang);
            }
            
            // I put getContent before stdLayout because I can change dynamically the Lang
            content = getContent();
            
            // Creation du document vide
            stdLayout = StandardLayoutFactory.createStandardLayout(getComms(), this.getSessionData(), this.getUrl(), this.headerScript);
            //stdLayout = new StdLayout(getComms(), this.getSessionData(), this.getUrl(), this.headerScript);
            
            // FIXME: Modification done by Olivier Tache not generic !
            // if content is returned by ConsultInformations, find <HEAD> elements
            // and try to move them to layout's <HEAD>
            if (content.getNodeName().equals("#document")) {
                // the content is returned by ConsultInformations
                // place the document's body in a <DIV> tag
                HTMLTransformFactory transf = new HTMLTransformFactory();
                finalContent = transf.mkDivFromBody(stdLayout.getLayout(), (Element) ((Document) content).getElementsByTagName("body").item(0));
            } else {
                // the content is returned by another presentation object.
                finalContent = content;
            }
            
            // Affichage en debut de document d'un eventuel message administatif a l'utilisateur.
            handleAdminMessage(stdLayout);
            
            // Affichage en debut de document d'un eventuel message a l'utilisateur.
            handleUserMessage(stdLayout);
            
            //Insertion du contenu dans le document vide.
            stdLayout.getContentPlaceHolder().appendChild(stdLayout.getLayout().importNode(finalContent, true));
            
            return (Node) stdLayout.getLayout();
        }
    
    
    /**
        *  Method to put an eventual message for the user into the layout
     *
     * @param  stdLayout                      Description of the Parameter
     * @exception  HttpPresentationException  Description of the Exception
     */
    protected void handleUserMessage(StdLayout stdLayout) throws HttpPresentationException {
        // don't do anything if there is no message...
        String userMessageText = this.getSessionData().getUserMessage();
        if (userMessageText.length() != 0) {
            UserMessageXHTML messageBlock = (UserMessageXHTML) MultilingualXHtmlTemplateFactory.createTemplate("UserMessageXHTML", this.getComms(), this.getSessionData());
            messageBlock.setTextUserMessageText(userMessageText);
            this.getSessionData().flushUserMessage();
            stdLayout.getContentPlaceHolder().appendChild(stdLayout.getLayout().importNode(messageBlock.getElementUserMessage(), true));
        }
    }
    
    
    /**
        *  Description of the Method
     *
     * @param  stdLayout                      Description of the Parameter
     * @exception  HttpPresentationException  Description of the Exception
     */
    protected void handleAdminMessage(StdLayout stdLayout) throws HttpPresentationException {
        if (this.adminMessage != null && !this.adminMessage.equals("")) {
            AdminMessageXHTML messageBlock = (AdminMessageXHTML) MultilingualXHtmlTemplateFactory.createTemplate("AdminMessageXHTML", this.getComms(), this.getSessionData());
            messageBlock.setTextAdminMessageText(this.adminMessage);
            stdLayout.getContentPlaceHolder().appendChild(stdLayout.getLayout().importNode(messageBlock.getElementAdminMessage(), true));
        }
    }
    
    
    /**
        *  Method to get or create the AgSessionData object from the user session
     *  This object is saved in the EbrokerPresentation object
     *
     * @param  comms
     *      Description of the Parameter
     * @exception  PapillonPresentationException
     * @exception  HttpPresentationException
     *      Description of the Exception
     * @exception  com.lutris.appserver.server.session.SessionException
     *      Description of the Exception
     */
    protected void initSessionData() throws HttpPresentationException {
        super.initSessionData();
        // initialize the accept language for the session
        ArrayList browserAcceptLanguages = MultilingualHtmlTemplateFactory.getAcceptLanguages(getComms().request);
        // Add a prefered language to this list (The first language in the list
        // may explicitely be modified by the user. befor that, it's a copy of the first browser accept
        // language).
        ArrayList userAcceptLanguage = new ArrayList();
        userAcceptLanguage.add(browserAcceptLanguages.get(0));
        userAcceptLanguage.addAll(browserAcceptLanguages);
        
        // We recuperate a permanent cookie if the user has logged before
        if (this.getUser() == null || this.getUser().isEmpty()) {
            User cookieUser = this.getLoginCookieUser();
            if (cookieUser != null && !cookieUser.isEmpty()) {
                PapillonLogger.writeDebugMsg("User from cookie: "
                                             + cookieUser.getName());
            }
            getSessionData().setUser(cookieUser);
            getSessionData().setUserAcceptLanguages(userAcceptLanguage);
            if (cookieUser != null && !cookieUser.isEmpty()) {
                getSessionData().setUserPreferredLanguage(cookieUser.getLang());
            }
            getSessionData().setClientWithLabelDisplayProblems(getComms().request.getHeader("User-Agent"));
            
            if (cookieUser == null) {
                cookieUser = new User();
                cookieUser.setName(getComms().request.getRemoteHost());
                cookieUser.setLogin("Not registered");
                cookieUser.setEmail(getComms().request.getRemoteUser() + "@" + getComms().request.getRemoteAddr());
            }
            PapillonSessionManager.addNewSession(getComms().session, cookieUser);
        }
    }
    
    /**
        *  Checks the session data for a User admin, if not there then redirects to
     *  the register page
     *
     * @exception  ClientPageRedirectException    Description of the Exception
     * @exception  PapillonPresentationException  Description of the Exception
     */
    
    //    protected void checkForUserAdmin()
    //             throws ClientPageRedirectException, PapillonPresentationException {
    //        try {
    //            if (!this.getUser().isAdmin()) {
    //                PapillonLogger.writeDebugMsg("USER NOT ADMIN");
    //                this.getSessionData().writeUserMessage("User not Admin");
    //                //send to LoginPage if a logged in user is required.
    //                String requestedPO = myComms.request.getRequestURI();
    //                PapillonLogger.writeDebugMsg("PO: " + requestedPO);
    //                // Call the subclass's implemented method
    //                PapillonLogger.writeDebugMsg("REDIRECTING TO REGISTER PAGE");
    //                throw new ClientPageRedirectException(REGISTER_PAGE);
    //            }
    //        } catch (Exception ex) {
    //            throw new PapillonPresentationException("Trouble checking for user admin status", ex);
    //        }
    //    }
    
    
    /**
        * converts a table of Strings for writing an URL
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
	public static String serializeParameterForUrl(String parameter, String[] table) {
		String parameterSeparator = "&";
		String result = "";
		if (table != null) {
			for (int i=0;i<table.length;i++) {
				result += parameter + "=" + myUrlEncode(table[i]) + parameterSeparator;
			}
		}
		if (result.endsWith(parameterSeparator)) {
			result = result.substring(0,result.lastIndexOf(parameterSeparator));
		}
		return result;
	}
    
    
    
    
    /**
        *  Gets the userAcceptLanguages attribute of the PapillonBasePO object
     *
     * @return    The userAcceptLanguages value
     */
    public ArrayList getUserAcceptLanguages() {
        return this.getSessionData().getUserAcceptLanguages();
    }
    
    
    /**
        *  Gets the preference attribute of the PapillonBasePO object
     *
     * @param  name
     *      Description of the Parameter
     * @return
     *      The preference value
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    public String getPreference(String name)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            return this.getSessionData().getPreference(getUrl(), name);
        }
    
    
    /**
        *  Sets the preference attribute of the PapillonBasePO object
     *
     * @param  name
     *      The new preference value
     * @param  value
     *      The new preference value
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    public void setPreference(String name, String value)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            this.getSessionData().setPreference(getUrl(), name, value);
        }
    
    
    /**
        *  Sets the preference attribute of the PapillonBasePO object
     *
     * @param  name
     *      The new preference value
     * @param  value
     *      The new preference value
     * @param  persistent
     *      The new preference value
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    public void setPreference(String name, String value, boolean persistent)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            this.getSessionData().setPreference(getUrl(), name, value, persistent);
        }
    
    
    /**
        *  Sets the userPreferredLanguage attribute of the PapillonBasePO object
     *
     * @param  lang
     *      The new userPreferredLanguage value
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    public void setUserPreferredLanguage(String lang) throws
        fr.imag.clips.papillon.business.PapillonBusinessException {
            User myUser = this.getUser();
            if (myUser != null && !myUser.isEmpty()) {
                this.getUser().setLang(lang);
                this.getUser().save();
            }
            this.getSessionData().setUserPreferredLanguage(lang);
        }
    
    
    /**
        *  Gets the userPreferredLanguage attribute of the PapillonBasePO object
     *
     * @return    The userPreferredLanguage value
     */
    public String getUserPreferredLanguage() {
        return this.getSessionData().getUserPreferredLanguage();
    }
    
    
    /**
        *  Gets the referrer request-header field that allows the client to specify,  
	 *  for the server's benefit, the address (URI) of the resource from  which the
	 *  Request-URI was obtained (the "referrer", although the  header field is misspelled.)
     *
     * @return  String  The referrer value
     */
    public String getReferrer() throws
        fr.imag.clips.papillon.business.PapillonBusinessException {
			String referrer = "";
			try {
				referrer = this.getComms().request.getHeader("Referer");
			}
			catch (com.lutris.appserver.server.httpPresentation.HttpPresentationException ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Error in PapillonBasePO.getReferrer: ", ex);
			}
            return referrer;
        }
    
    
    
    /**
        *  Sets the cookie attribute of the PapillonBasePO object
     *
     * @param  key                            The new cookie value
     * @param  value                          The new cookie value
     * @exception  HttpPresentationException  Description of the Exception
     */
    public void setCookie(String key, String value)
        throws HttpPresentationException {
            Cookie myCookie;
            try {
                myCookie = new Cookie(key, value);
                myCookie.setMaxAge(365 * 30 * 24 * 60 * 60);// valid for 1 year
                    this.getComms().response.addCookie(myCookie);
            } catch (Exception ex) {
                throw new PapillonPresentationException("Trouble setting cookie", ex);
            }
        }
    
    
    /**
        *  Gets the cookies attribute of the PapillonBasePO object
     *
     * @return                                The cookies value
     * @exception  HttpPresentationException  Description of the Exception
     */
    public Cookie[] getCookies()
        throws HttpPresentationException {
            return this.getComms().request.getCookies();
        }
    
    
    /**
        *  Gets the loginCookieUser attribute of the PapillonBasePO object
     *
     * @return                                The loginCookieUser value
     * @exception  HttpPresentationException  Description of the Exception
     */
    public User getLoginCookieUser()
        throws HttpPresentationException {
            User cookieUser = null;
            Cookie[] myCookies = this.getCookies();
            int i = 0;
            while (i < myCookies.length && cookieUser == null) {
                Cookie myCookie = myCookies[i];
                if (myCookie.getName().equals(LOGIN_COOKIE)) {
                    cookieUser = UsersFactory.findUserById(myCookie.getValue());
                }
                i++;
            }
            return cookieUser;
        }
    
    
    /**
        *  Description of the Method
     *
     * @return                                Description of the Return Value
     * @exception  HttpPresentationException  Description of the Exception
     */
    public boolean IsClientWithLabelDisplayProblems()
        throws HttpPresentationException {
            return this.getSessionData().getClientWithLabelDisplayProblems();
        }
    
    
    /**
        *  Sets the selected attribute of the PapillonBasePO class
     *
     * @param  mySelect  The new selected value
     * @param  myArray   The new selected value
     */
    public static void setSelected(XHTMLSelectElement mySelect, String[] myArray) {
        Vector myVector = new Vector();
        myVector.addAll(Arrays.asList(myArray));
        setSelected(mySelect, myVector);
    }
    
    
    /**
        *  Sets the selected attribute of the PapillonBasePO class
     *
     * @param  mySelect  The new selected value
     * @param  myValue   The new selected value
     */
    public static void setSelected(XHTMLSelectElement mySelect, String myValue) {
        if (myValue != null && !myValue.equals("")) {
            HTMLCollection myCollection = mySelect.getOptions();
            int i = 0;
            while (i < myCollection.getLength()) {
                if (((XHTMLOptionElement) myCollection.item(i)).getValue().equals(myValue)) {
                    // This method does not work any more with enhydra5.1...
                    // mySelect.setSelectedIndex(i);
					((XHTMLOptionElement) myCollection.item(i)).setSelected(true);
                    break;
                }
                i++;
            }
        }
    }
    
    
    /**
        *  Sets the selected attribute of the PapillonBasePO class
     *
     * @param  mySelect  The new selected value
     * @param  myValue   The new selected value
     */
    public static void setSelected(HTMLSelectElement mySelect, String myValue) {
        if (myValue != null && !myValue.equals("")) {
            HTMLCollection myCollection = mySelect.getOptions();
            int i = 0;
            while (i < myCollection.getLength()) {
                if (((HTMLOptionElement) myCollection.item(i)).getValue().equals(myValue)) {
                    // This method does not work any more with enhydra5.1...
                    // mySelect.setSelectedIndex(i);
					((HTMLOptionElement) myCollection.item(i)).setSelected(true);
                    break;
                }
                i++;
            }
        }
    }
    
    
    /**
        *  Sets the selected attribute of the PapillonBasePO class
     *
     * @param  mySelect  The new selected value
     * @param  myVector  The new selected value
     */
    public static void setSelected(XHTMLSelectElement mySelect, Vector myVector) {
        if (myVector != null && myVector.size() > 0) {
            HTMLCollection myCollection = mySelect.getOptions();
            int i = 0;
            while (i < myCollection.getLength() && myVector.size() > 0) {
                XHTMLOptionElement myOptionElement = (XHTMLOptionElement) myCollection.item(i);
                String myOption = myOptionElement.getValue();
                if (myVector.contains(myOption)) {
                    myOptionElement.setSelected(true);
                    myVector.remove(myOption);
                }
                i++;
            }
        }
    }
    
    
    /**
        *  Sets the unicodeLabels attribute of the PapillonBasePO class
     *
     * @param  mySelect  The new unicodeLabels value
     */
    public static void setUnicodeLabels(XHTMLSelectElement mySelect) {
        HTMLCollection myCollection = mySelect.getOptions();
        for (int i = 0; i < myCollection.getLength(); i++) {
            XHTMLOptionElement myOption = (XHTMLOptionElement) myCollection.item(i);
            myOption.setLabel(myOption.getText());
        }
    }
}
