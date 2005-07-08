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
 *  Revision 1.2  2005/07/08 08:22:46  serasset
 *  Reviewed the Abstract/BasePO hierarchy (moved some methods up in the tree).
 *  Added base classes to allow independant browsing window to establish links during edition.
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
 *
 *  -----------------------------------------------
 *  Abstract class implementing the Base layout of all papillon presentations.
 */
package fr.imag.clips.papillon.presentation;

// Papillon import
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.presentation.xhtmllexalp.orig.*;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import com.lutris.appserver.server.Enhydra;

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
public abstract class LexALPBasePO extends AbstractPO {
    
    public static final String PACKAGE = "fr.imag.clips.papillon.presentation.xhtmllexalp";
    
    /**
        *  Description of the Field
     */
    protected final static String LANG_PARAMETER = "lang";
    
    // JavaScript to add in the header
    /**
        *  Description of the Field
     */
    protected String headerScript = "";
    
    
    /**
        *  This is the procedure that is called when an HTML request occurs.
     *
     * @return                XMLObject The XMLObject (in HTML format) that is
     *      to be included in the standard layout.
     * @exception  Exception  Description of the Exception
     */
    public abstract Node getContent() throws Exception;
    
    /**
        *  Sets the headerScript attribute of the PapillonBasePO object
     *
     * @param  newScript                          The new headerScript value
     * @exception  PapillonPresentationException  Description of the Exception
     */
    public void addToHeaderScript(String newScript)
        throws PapillonPresentationException {
            this.headerScript += "\n\n" + newScript;
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
            // and the header script
            content = getContent();
            
            // Creation du document vide
            stdLayout = StandardLayoutFactory.createStandardLayout(getComms(), this.getSessionData(), this.getUrl(), this.headerScript);
            //            stdLayout = new LexALPLayout(getComms(), this.getSessionData(), this.getUrl(), this.headerScript);
            
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
            UserMessageXHTML messageBlock = (UserMessageXHTML) MultilingualXHtmlTemplateFactory.createTemplate(PACKAGE, "UserMessageXHTML", this.getComms(), this.getSessionData());
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
            AdminMessageXHTML messageBlock = (AdminMessageXHTML) MultilingualXHtmlTemplateFactory.createTemplate(PACKAGE, "AdminMessageXHTML", this.getComms(), this.getSessionData());
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
        
        // If no user is logged, we look for a permanent cookie the user may have
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
		String result = "";
		if (table != null) {
			for (int i=0;i<table.length;i++) {
				result += parameter + "=" + myUrlEncode(table[i]) + "&";
			}
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
    
        
}
