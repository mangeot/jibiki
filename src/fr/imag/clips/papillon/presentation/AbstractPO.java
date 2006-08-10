/*
 *  Papillon project
 *
 *  © Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.6  2006/08/10 22:17:13  fbrunet
 *  - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 *  - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 *  - Bug correction : +/- in advanced search
 *
 *  Revision 1.5  2006/02/26 14:04:56  mangeot
 *  Corrected a bug: the content was a static variable, thus there were problems when two users wanted to aces the same page at the same time
 *
 *  Revision 1.4  2005/07/16 12:58:31  serasset
 *  Added limit parameter to query functions
 *  Added a parameter to Formater initializations
 *  Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 *  Revision 1.3  2005/07/08 08:22:46  serasset
 *  Reviewed the Abstract/BasePO hierarchy (moved some methods up in the tree).
 *  Added base classes to allow independant browsing window to establish links during edition.
 *
 *  Revision 1.2  2005/06/15 20:40:41  serasset
 *  Now serve content as text/html instead of application/xhtml+xml
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
 */
package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

import javax.servlet.http.HttpServletRequest;

import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import com.lutris.appserver.server.Enhydra;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.enhydra.xml.xhtml.*;
import org.enhydra.xml.xhtml.dom.*;

import org.enhydra.xml.xmlc.*;
import com.lutris.logging.*;
import com.lutris.util.*;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.text.DateFormat;

import org.enhydra.xml.io.OutputOptions;
import org.enhydra.xml.io.DOMFormatter;

import fr.imag.clips.papillon.Papillon;

import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.business.user.User;


/**
*  Description of the Class
 *
 * @author     serasset
 * @created    March 30, 2005
 */
public abstract class AbstractPO implements HttpPresentation {
    /**  Holds the current Session data */
    public PapillonSessionData sessionData;
    
    // Cookie keys
    /**
    *  Description of the Field
     */
    public final static String LOGIN_COOKIE = ((Papillon)Enhydra.getApplication()).getLoginCookieName();
    
    
    /**
    *  Administrator message, to be displayed in all sessions
     */
    public static String adminMessage = "";

    
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
    
    /**
    *  This is the procedure that is called when an HTML request occurs.
     *
     * @return                XMLObject The XMLObject (in HTML format) that is
     *      to be sent to the user.
     * @exception  Exception  Description of the Exception
     */
    public abstract Node getDocument() throws Exception;
    
    
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
    protected abstract boolean userMayUseThisPO();
    
    
    /**  Saved input and output context, and session data  */
    protected HttpPresentationComms myComms = null;
    //protected PapillonSessionData mySessionData = null;
    
    /**
        *  Gets HttpPresentation object
     *
     * @return    The saved comms objects to whichever subclass needs it
     */
    public HttpPresentationComms getComms() {
        return this.myComms;
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
            this.myComms = comms;
            initSessionData();
            // Check if the user needs to be logged in for this request.
            if (this.loggedInUserRequired()) {
                checkForUserLogin();                  // This will redirect the user to the login page if necessary
            }
            
            // After this point, user is logged in if required...
            
            if (!this.userMayUseThisPO()) {
                userIsNotAuthorized();                // This will redirect the user to the login page if necessary
            }
            
            HttpPresentationOutputStream out;
            Node document;
            byte[] buffer;
            
			// setContentType before calling getDocument
			// because getDocument can change the content type
			this.getComms().response.setContentType("text/html");
			
            document = getDocument();
			

            if (null == document) {
                this.getComms().response.sendError(HttpPresentationResponse.SC_NOT_FOUND, "Page returned a null Document");
            }
                        
            // Preparation de la sortie...
            OutputOptions options = new OutputOptions();
            options.setDropHtmlSpanIds(true);
            options.setXmlEncoding("UTF-8");
            DOMFormatter fFormatter = new DOMFormatter(options);
            
            buffer = fFormatter.toBytes(document);
            comms.response.setContentLength(buffer.length);
            out = comms.response.getOutputStream();
            out.write(buffer);
            out.flush();
        }

    
    /**
        *  Method to get or create the AgSessionData object from the user session
     *  This object is saved in the EbrokerPresentation object
     *
     * @param  comms                              Description of the Parameter
     * @exception  HttpPresentationException      Description of the Exception
     */
    protected void initSessionData()
        throws HttpPresentationException {
            
            try {
                Object obj = getComms().sessionData.get(PapillonSessionData.SESSION_KEY);
                // If we found the session data, save it in a private data member
                if (null != obj) {
                    this.sessionData = (PapillonSessionData) obj;
                } else {
                    // If no session data was found, create a new session data instance
                    this.sessionData = new PapillonSessionData();
                    
                    getComms().sessionData.set(PapillonSessionData.SESSION_KEY, this.sessionData);
                }
            } catch (KeywordValueException ex) {
                System.out.println("Problem getting session data from session: " +
                                   ex.getMessage());
            }
        }
    
    
    /**
        *  Gets the sessionData attribute of the PO object
     *
     * @return    The sessionData value
     */
    public PapillonSessionData getSessionData() {
        return this.sessionData;
    }
    
    /**
        * converts a table of Strings for writing an URL
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
	public static String serializeParameterForUrl(String parameter, Collection table) {
		String result = "";
		if (table != null) {
			for (Iterator iter = table.iterator(); iter.hasNext();) {
				result += parameter + "=" + myUrlEncode((String)iter.next()) + "&";
			}
		}
		return result;
	}    
    
    /**
        *  Description of the Method
     *
     * @param  str                                       Description of the
     *      Parameter
     * @return                                           Description of the
     *      Return Value
     * @exception  java.io.UnsupportedEncodingException  Description of the
     *      Exception
     */
    public static String myUrlEncode(String str) {
        // WARNING Java 1.4.1 specific.
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException ex) {
            PapillonLogger.writeErrorMsg("UTF8 is not supported ??!!");
        }
        return str;
    }
    
    // HACK: For proper decoding of UTF-8 urlencoded values
    /**
        *  Description of the Method
     *
     * @param  name                           Description of the Parameter
     * @return                                Description of the Return Value
     * @exception  HttpPresentationException  Description of the Exception
     */
    public String myGetParameter(String name)
        throws HttpPresentationException {
            String res = null;
            try {
                String pvalue = this.getComms().request.getParameter(name);
                if (null != pvalue) {
                    byte[] pbytes = pvalue.getBytes("ISO-8859-1");
                    res = new String(pbytes, "UTF-8");
                }
            } catch (java.io.UnsupportedEncodingException e) {
                throw new HttpPresentationException("UTF-8 encoding is not supported on this plateform.", e);
            }
            return res;
        }
    
    // HACK: For proper decoding of UTF-8 urlencoded values
    /**
        *  Description of the Method
     *
     * @param  req                            Description of the Parameter
     * @param  name                           Description of the Parameter
     * @return                                Description of the Return Value
     * @exception  HttpPresentationException  Description of the Exception
     */
    public static String myGetParameter(HttpServletRequest req, String name)
        throws HttpPresentationException {
            String res = null;
            try {
                String pvalue = req.getParameter(name);
                if (null != pvalue) {
                    byte[] pbytes = pvalue.getBytes("ISO-8859-1");
                    res = new String(pbytes, "UTF-8");
                }
            } catch (java.io.UnsupportedEncodingException e) {
                throw new HttpPresentationException("UTF-8 encoding is not supported on this plateform.", e);
            }
            return res;
        }
    
    // HACK: For proper decoding of UTF-8 urlencoded values
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
            try {
                String[] res = this.getComms().request.getParameterValues(name);
                if (null != res && res.length > 0) {
                    for (int i = 0; i < res.length; i++) {
                        byte[] pbytes = res[i].getBytes("ISO-8859-1");
                        res[i] = new String(pbytes, "UTF-8");
                    }
                }
                return res;
            } catch (java.io.UnsupportedEncodingException e) {
                throw new HttpPresentationException("UTF-8 encoding is not supported on this plateform.", e);
            }
        }
    
    // HACK: For proper decoding of UTF-8 urlencoded values
    /**
        *  Description of the Method
     *
     * @param  req                                       Description of the
     *      Parameter
     * @param  name                                      Description of the
     *      Parameter
     * @return                                           Description of the
     *      Return Value
     * @exception  java.io.UnsupportedEncodingException  Description of the
     *      Exception
     * @exception  HttpPresentationException             Description of the
     *      Exception
     */
    public static String[] myGetParameterValues(HttpServletRequest req, String name)
        throws java.io.UnsupportedEncodingException, HttpPresentationException {
            try {
                String[] res = req.getParameterValues(name);
                if (null != res && res.length > 0) {
                    for (int i = 0; i < res.length; i++) {
                        byte[] pbytes = res[i].getBytes("ISO-8859-1");
                        res[i] = new String(pbytes, "UTF-8");
                    }
                }
                return res;
            } catch (java.io.UnsupportedEncodingException e) {
                throw new HttpPresentationException("UTF-8 encoding is not supported on this plateform.", e);
            }
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
        *  Sets the selected attribute of the PapillonBasePO class
     *
     * @param  mySelect  The new selected value
     * @param  myVector  The new selected value
     */
    public static void deselectAll(XHTMLSelectElement mySelect) {
        HTMLCollection myCollection = mySelect.getOptions();
        int i = 0;
        while (i < myCollection.getLength()) {
            ((HTMLOptionElement) myCollection.item(i)).setSelected(false);
            i++;
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
    
    
    /**
        *  Gets the url attribute of the PO object
     *
     * @return    The url value
     */
    protected String getUrl() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1) + ".po";
    }
    
    
    /**
        *  Description of the Method
     *
     * @exception  ClientPageRedirectException  Description of the Exception
     * @exception  HttpPresentationException    Description of the Exception
     */
    protected void checkForUserLogin()
        throws ClientPageRedirectException, HttpPresentationException {
            try {
                
                if (!this.getSessionData().userHasBeenIdentified()) {
                    //send to LoginPage if a logged in user is required.
                    String requestedPO = this.getComms().request.getRequestURI();
                    throw new ClientPageRedirectException(LOGIN_PAGE + "?" + DESTINATION_AFTER_LOGIN_PARAMETER + "=" + myUrlEncode(requestedPO));
                }
            } catch (Exception ex) {
                throw new HttpPresentationException("Trouble checking for user login status", ex);
            }
        }
    
    
    /**
        *  Description of the Method
     *
     * @exception  ClientPageRedirectException  Description of the Exception
     * @exception  HttpPresentationException    Description of the Exception
     */
    protected void userIsNotAuthorized()
        throws ClientPageRedirectException, HttpPresentationException {
            this.getSessionData().writeUserMessage("You are not authorized to view the requested page.");
            this.getSessionData().writeUserMessage("Please log in as an authorized user to proceed.");
            
            try {
                String requestedPO = this.getComms().request.getRequestURI();
                throw new ClientPageRedirectException(LOGIN_PAGE + "?" + DESTINATION_AFTER_LOGIN_PARAMETER + "=" + myUrlEncode(requestedPO));
            } catch (Exception ex) {
                throw new HttpPresentationException("Trouble checking for user login status", ex);
            }
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
                throw new PapillonPresentationException("PapillonBasePO:Session Error for setUser: ", SesEx);
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
                throw new PapillonPresentationException("PapillonBasePO:Session Error for clearUser: ", SesEx);
            } catch (com.lutris.appserver.server.httpPresentation.HttpPresentationException HttpEx) {
                throw new PapillonPresentationException("PapillonBasePO: Error for request.get...: ", HttpEx);
            }
            this.getSessionData().removeUser();
        }
    
}
