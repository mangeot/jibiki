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
 *  Abstract class implementing the Base layout of all presentations.
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
public abstract class BasePO implements HttpPresentation {

    /**
     *  Administrator message, to be displayed in all sessions
     */
    public static String adminMessage = "";

    // Cookie keys
    /**
     *  Description of the Field
     */
    public final static String LOGIN_COOKIE = "PapillonLoginCookie";

    /**
     *  Description of the Field
     */
    protected final static String LANG_PARAMETER = "lang";
    // protected static final String USER_KEY = "DiscRackPerson";
    /**
     *  Description of the Field
     */
    protected static String LOGIN_PAGE = "LoginUser.po";
    /**
     *  Description of the Field
     */
    protected static String REGISTER_PAGE = "Register.po";
    /**
     *  Description of the Field
     */
    protected static String DESTINATION_AFTER_LOGIN_PARAMETER = "Destination";

    // JavaScript to add inthe header
    /**
     *  Description of the Field
     */
    protected String headerScript = "";

    // protected static String DISC_CATALOG_PAGE = "/discMgmt/DiscCatalog.po";

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
     *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected abstract boolean loggedInUserRequired();


    /**
     *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected abstract boolean adminUserRequired();


    /**
     *  This is the procedure that is called to know in what section we
     *  currently are in order for the header to be modified appropriately.
     *
     * @return    XMLObject The XMLObject (in HTML fomat) that is to be included
     *      in the standard layout.
     */
    protected abstract int getCurrentSection();


    /**
     *  Saved input and output context, and session data
     */
    protected HttpPresentationComms myComms = null;
    /**
     *  Description of the Field
     */
    protected PapillonSessionData mySessionData = null;

    /**
     *  Reference to the user logged in to the session
     */
    protected User myUser = null;


    /**
     *  Gets HttpPresentation object
     *
     * @return    The saved comms objects to whichever subclass needs it
     */
    public HttpPresentationComms getComms() {
        return this.myComms;
    }


    /**
     *  Gets the session data
     *
     * @return    session data
     */
    public PapillonSessionData getSessionData() {
        return this.mySessionData;
    }


    /**
     *  Sets the headerScript attribute of the BasePO object
     *
     * @param  newScript                          The new headerScript value
     * @exception  PapillonPresentationException  Description of the Exception
     */
    public void setHeaderScript(String newScript)
             throws PapillonPresentationException {
        this.headerScript = newScript;
    }


    /**
     *  Sets the user into the session
     *
     * @param  theUser                            The new user value
     * @exception  PapillonPresentationException
     */
    public void setUser(User theUser)
             throws PapillonPresentationException {
        try {
            this.myComms.session.setUser(theUser);
        } catch (com.lutris.appserver.server.session.SessionException SesEx) {
            throw new PapillonPresentationException("BasePO:Session Error for setUser: ", SesEx);
        }
        this.getSessionData().setUser(theUser);
    }


    /**
     *  Gets the user from the session
     *
     * @return    the person object in the session
     */
    public User getUser() {
        return this.getSessionData().getUser();
    }


    /**
     *  Method to remove the current user from the session
     *
     * @exception  PapillonPresentationException  Description of the Exception
     */
    public void removeUserFromSession()
             throws PapillonPresentationException {
        try {
            this.myComms.session.clearUser();
            User newUser = new User();
            newUser.setName(this.myComms.request.getRemoteHost());
            newUser.setLogin("Not registered");
            newUser.setEmail(this.myComms.request.getRemoteUser() + "@" + this.myComms.request.getRemoteAddr());
            this.myComms.session.setUser(newUser);
        } catch (com.lutris.appserver.server.session.SessionException SesEx) {
            throw new PapillonPresentationException("BasePO:Session Error for clearUser: ", SesEx);
        } catch (com.lutris.appserver.server.httpPresentation.HttpPresentationException HttpEx) {
            throw new PapillonPresentationException("BasePO: Error for request.get...: ", HttpEx);
        }
        this.getSessionData().removeUser();
    }


    /**
     *  This implements the run method in HttpPresentation.
     *
     * @param  comms                          Description of the Parameter
     * @exception  Exception
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  IOException                Description of the Exception
     */
    public void run(HttpPresentationComms comms)
             throws HttpPresentationException, IOException, Exception {

        // Initialize new or get the existing session data
        initSessionData(comms);
        // Check if the user needs to be logged in for this request.
        if (this.loggedInUserRequired()) {
            checkForUserLogin();                  // This will redirect the user to the login page if necessary
        }

        if (this.adminUserRequired()) {
            checkForUserAdmin();                  // This will redirect the user to the login page if necessary
        }

        HttpPresentationOutputStream out;
        StdLayout stdLayout;
        Node content;
        Node finalContent;
        byte[] buffer;

        // Creation du contenu
        String lang = myGetParameter(LANG_PARAMETER);

        if (null != lang) {
            this.setUserPreferredLanguage(lang);
        }

        // I put getContent before stdLayout because I can change dynamically the Lang
        content = getContent();

        // Creation du document vide
        stdLayout = new StdLayout(comms, this.getSessionData(), this.getUrl(), this.headerScript);

        // FIXME: Modification done by Olivier Tache not generic !
        // if content is returned by ConsultInformations, find <HEAD> elements
        // and try to move them to layout's <HEAD>
        if (content.getNodeName().equals("#document")) {
            // the content is returned by ConsultInformations
            // place the document's body in a <DIV> tag
            HTMLTransformFactory transf = new HTMLTransformFactory();
            finalContent = transf.mkDivFromBody(stdLayout.getLayout(), (Element) ((Document) content).getElementsByTagName("body").item(0));
        } else {
            // the content is returned by an other presentation object.
            finalContent = content;
        }

        comms.response.setContentType("text/html; charset=UTF-8");

        // Affichage en debut de document d'un eventuel message administatif a l'utilisateur.
        handleAdminMessage(stdLayout);

        // Affichage en debut de document d'un eventuel message a l'utilisateur.
        handleUserMessage(stdLayout);

        //Insertion du contenu dans le document vide.
        stdLayout.getLayout().getElementMainColumn().appendChild(stdLayout.getLayout().importNode(finalContent, true));

        // Preparation de la sortie...
        OutputOptions options = new OutputOptions();
        options.setDropHtmlSpanIds(true);
        options.setXmlEncoding("UTF-8");
        DOMFormatter fFormatter = new DOMFormatter(options);

        buffer = fFormatter.toBytes(stdLayout.getLayout());
        comms.response.setContentLength(buffer.length);
        out = comms.response.getOutputStream();
        out.write(buffer);
        out.flush();
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
            stdLayout.getLayout().getElementMainColumn().appendChild(stdLayout.getLayout().importNode(messageBlock.getElementUserMessage(), true));
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
            stdLayout.getLayout().getElementMainColumn().appendChild(stdLayout.getLayout().importNode(messageBlock.getElementAdminMessage(), true));
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
    protected void initSessionData(HttpPresentationComms comms)
             throws PapillonPresentationException, HttpPresentationException,
            com.lutris.appserver.server.session.SessionException {
        this.myComms = comms;

        try {
            Object obj = comms.sessionData.get(PapillonSessionData.SESSION_KEY);
            // If we found the session data, save it in a private data member
            if (null != obj) {
                this.mySessionData = (PapillonSessionData) obj;
            } else {

                // initialize the accept language for the session
                ArrayList browserAcceptLanguages = MultilingualHtmlTemplateFactory.getAcceptLanguages(comms.request);
                // Add a prefered language to this list (The first language in the list
                // may explicitely be modified by the user. befor that, it's a copy of the first browser accept
                // language).
                ArrayList userAcceptLanguage = new ArrayList();
                userAcceptLanguage.add(browserAcceptLanguages.get(0));
                userAcceptLanguage.addAll(browserAcceptLanguages);

                // We recuperate a permanent cookie if the user has logged before
                User cookieUser = this.getLoginCookieUser();
                if (cookieUser != null && !cookieUser.IsEmpty()) {
                    PapillonLogger.writeDebugMsg("User from cookie: "
                             + cookieUser.getName());
                }
                // If no session data was found, create a new session data instance
                this.mySessionData = new PapillonSessionData(cookieUser, userAcceptLanguage, this.myComms.request.getHeader("User-Agent"));
                if (cookieUser == null) {
                    cookieUser = new User();
                    cookieUser.setName(comms.request.getRemoteHost());
                    cookieUser.setLogin("Not registered");
                    cookieUser.setEmail(comms.request.getRemoteUser() + "@" + comms.request.getRemoteAddr());
                }
                PapillonSessionManager.addNewSession(comms.session, cookieUser);
                comms.sessionData.set(PapillonSessionData.SESSION_KEY, this.mySessionData);
            }
        } catch (KeywordValueException ex) {
            PapillonLogger.writeDebugMsg("Problem getting session data from session: " +
                    ex.getMessage());
        }
    }


    /**
     *  Checks the session data for a User, if not there then redirects to the
     *  login page
     *
     * @exception  ClientPageRedirectException    Description of the Exception
     * @exception  PapillonPresentationException  Description of the Exception
     */
    protected void checkForUserLogin()
             throws ClientPageRedirectException, PapillonPresentationException {

        try {
            User user = getUser();

            if (null == user || user.IsEmpty()) {
                PapillonLogger.writeDebugMsg("USER NOT FOUND IN SESSION");
                //send to LoginPage if a logged in user is required.
                String requestedPO = myComms.request.getRequestURI();
                //String requestedPO = myComms.request.getPresentationObjectRelativePath();
                PapillonLogger.writeDebugMsg("PO: " + requestedPO);
                // Call the subclass's implemented method
                PapillonLogger.writeDebugMsg("REDIRECTING TO:" + LOGIN_PAGE + "?" +
                        DESTINATION_AFTER_LOGIN_PARAMETER + "=" + myUrlEncode(requestedPO));
                throw new ClientPageRedirectException(LOGIN_PAGE + "?" +
                        DESTINATION_AFTER_LOGIN_PARAMETER + "=" + myUrlEncode(requestedPO));
            } else {
                PapillonLogger.writeDebugMsg("USER ALREADY LOGGED IN WITH A SESSION");
            }
        } catch (Exception ex) {
            throw new PapillonPresentationException("Trouble checking for user login status", ex);
        }
    }


    /**
     *  Checks the session data for a User admin, if not there then redirects to
     *  the register page
     *
     * @exception  ClientPageRedirectException    Description of the Exception
     * @exception  PapillonPresentationException  Description of the Exception
     */

    protected void checkForUserAdmin()
             throws ClientPageRedirectException, PapillonPresentationException {
        try {
            if (!this.getUser().IsAdmin()) {
                PapillonLogger.writeDebugMsg("USER NOT ADMIN");
                this.getSessionData().writeUserMessage("User not Admin");
                //send to LoginPage if a logged in user is required.
                String requestedPO = myComms.request.getRequestURI();
                PapillonLogger.writeDebugMsg("PO: " + requestedPO);
                // Call the subclass's implemented method
                PapillonLogger.writeDebugMsg("REDIRECTING TO REGISTER PAGE");
                throw new ClientPageRedirectException(REGISTER_PAGE);
            }
        } catch (Exception ex) {
            throw new PapillonPresentationException("Trouble checking for user admin status", ex);
        }
    }


    /**
     *  Method 
     *
     * @param  str 
     * @return
	 * @exception  java.io.UnsupportedEncodingException 
	 */

	public static String myUrlEncode(String str) throws java.io.UnsupportedEncodingException {
		return java.net.URLEncoder.encode(str, "UTF-8");
	}

   /**
     * converts a table of Strings for writing an URL
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static String serializeParameterForUrl(String parameter, String[] table)  throws java.io.UnsupportedEncodingException {
		String result = "";
		if (table != null) {
			for (int i=0;i<table.length;i++) {
				result += parameter + "=" + myUrlEncode(table[i]) + "&";
			}
		}
		return result;
	}

    /**
     *  Description of the Method
     *
     * @param  name                                      Description of the
     *      Parameter
     * @return                                           Description of the
     *      Return Value
     * @exception  java.io.UnsupportedEncodingException  Description of the
     *      Exception
     * @exception  HttpPresentationException             Description of the
     *      Exception
     */
    public String myGetParameter(String name)
             throws java.io.UnsupportedEncodingException, HttpPresentationException {
        String res = null;
        String pvalue = this.getComms().request.getParameter(name);
        if (null != pvalue) {
            byte[] pbytes = pvalue.getBytes("ISO-8859-1");
            res = new String(pbytes, "UTF-8");
        }
        return res;
    }


    /**
     *  Description of the Method
     *
     * @param  name                                      Description of the
     *      Parameter
     * @return                                           Description of the
     *      Return Value
     * @exception  java.io.UnsupportedEncodingException  Description of the
     *      Exception
     * @exception  HttpPresentationException             Description of the
     *      Exception
     */
    public String[] myGetParameterValues(String name)
             throws java.io.UnsupportedEncodingException, HttpPresentationException {
        String[] res = this.getComms().request.getParameterValues(name);
        if (null != res && res.length > 0) {
            for (int i = 0; i < res.length; i++) {
                byte[] pbytes = res[i].getBytes("ISO-8859-1");
                res[i] = new String(pbytes, "UTF-8");
            }
        }
        return res;
    }


    /**
     *  Gets the userAcceptLanguages attribute of the BasePO object
     *
     * @return    The userAcceptLanguages value
     */
    public ArrayList getUserAcceptLanguages() {
        return this.getSessionData().getUserAcceptLanguages();
    }


    /**
     *  Gets the preference attribute of the BasePO object
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
     *  Sets the preference attribute of the BasePO object
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
     *  Sets the preference attribute of the BasePO object
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
     *  Sets the userPreferredLanguage attribute of the BasePO object
     *
     * @param  lang
     *      The new userPreferredLanguage value
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    public void setUserPreferredLanguage(String lang) throws
            fr.imag.clips.papillon.business.PapillonBusinessException {
        User myUser = this.getUser();
        if (myUser != null && !myUser.IsEmpty()) {
            this.getUser().setLang(lang);
            this.getUser().save();
        }
        this.getSessionData().setUserPreferredLanguage(lang);
    }


    /**
     *  Gets the userPreferredLanguage attribute of the BasePO object
     *
     * @return    The userPreferredLanguage value
     */
    public String getUserPreferredLanguage() {
        return this.getSessionData().getUserPreferredLanguage();
    }


    /**
     *  Gets the url attribute of the BasePO object
     *
     * @return    The url value
     */
    protected String getUrl() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1) + ".po";
    }


    /**
     *  Sets the cookie attribute of the BasePO object
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
     *  Gets the cookies attribute of the BasePO object
     *
     * @return                                The cookies value
     * @exception  HttpPresentationException  Description of the Exception
     */
    public Cookie[] getCookies()
             throws HttpPresentationException {
        return this.getComms().request.getCookies();
    }


    /**
     *  Gets the loginCookieUser attribute of the BasePO object
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
     *  Sets the selected attribute of the BasePO class
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
     *  Sets the selected attribute of the BasePO class
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
                    mySelect.setSelectedIndex(i);
                    break;
                }
                i++;
            }
        }
    }


    /**
     *  Sets the selected attribute of the BasePO class
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
     *  Sets the unicodeLabels attribute of the BasePO class
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
