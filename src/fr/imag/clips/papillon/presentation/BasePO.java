/*
 * papillon
 *
 * Enhydra super-servlet
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.14  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.13  2004/09/18 17:26:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.12  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.11.2.2  2004/01/22 05:36:05  mangeot
 * Improving accessibility for non javascripts enabled users and added confirmations for javacsripts enabled browsers
 *
 * Revision 1.11.2.1  2004/01/08 15:17:21  mangeot
 * Bugs fixed
 *
 * Revision 1.11  2003/11/20 05:34:23  mangeot
 * Bug fixes in the parameters
 *
 * Revision 1.10  2003/10/11 02:59:15  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2003/10/03 05:34:09  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2003/08/20 08:15:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2003/08/14 08:30:16  mangeot
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
 * Revision 1.6  2003/06/24 09:05:42  serasset
 * The user is now correctly redirected to the LoginUser.po page when a login is required.
 *
 * Revision 1.5  2003/06/04 15:37:46  serasset
 * Mise en place de la nouvelle version de la gestion des utilisateurs.
 *
 * Revision 1.4.2.3  2003/07/31 04:30:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.2.2  2003/06/30 13:25:27  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.2.1  2003/05/28 09:17:21  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.4  2003/01/10 08:11:57  mangeot
 * Problem with labels and UTF-8 fixed for internet explorer and icab
 * Problem with language identification fixed eg: en-US
 *
 * Revision 1.3  2003/01/09 09:38:59  mangeot
 * Testing the browser for label display problems
 *
 * Revision 1.2  2002/12/09 08:32:02  mangeot
 * Added a permanent cookie for indentification when reconnection
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.23  2002/10/25 14:10:34  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.22.2.1  2002/10/23 09:51:12  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.22  2002/09/16 13:34:23  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.21  2002/08/16 11:42:33  tache
 * Now the <body> of an HTML document is placed in a <div> tag when the
 * document is visualized.
 *
 * Revision 1.20.2.6  2002/09/12 09:45:33  mangeot
 * Modified HTML in order to query the server with Sherlock plugin
 *
 * Revision 1.20.2.5  2002/08/08 09:11:57  mangeot
 * New Home page with simplified interface a lot of work
 * + localization in german
 *
 * Revision 1.20.2.4  2002/08/02 13:55:49  mangeot
 * Corrected the encoding problem while connection to the XRCE analyzers
 *
 * Revision 1.20.2.3  2002/08/02 08:25:10  mangeot
 * Replaced PAGENAME variable by this.getUrl() method
 *
 * Revision 1.20.2.2  2002/08/02 08:12:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.20.2.1  2002/08/01 10:52:10  mangeot
 * added the language shift directly into BasePo
 * Modified the consult html
 * added the login user into stdlayout
 *
 * Revision 1.20  2002/07/26 10:00:23  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.19  2002/07/10 09:53:07  serasset
 * The Users is now redirected to his initial destination after login.
 *
 * Revision 1.18.2.3  2002/07/12 13:50:43  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.18.2.2  2002/07/09 08:32:59  serasset
 * Corrected a cross dependancy issue between LoginUser and BasePO.
 *
 * Revision 1.18.2.1  2002/07/08 16:43:32  serasset
 * The Login page now redirects the user to the originaly requested page after a successful log in.
 *
 * Revision 1.18  2002/06/12 14:44:39  serasset
 * Corrected bug in MailingList.po (with getacceptLanguage)
 *
 * Revision 1.17  2002/06/10 13:26:02  mangeot
 * Continued the localization, added the lang string into the session data
 *
 * Revision 1.16  2002/06/10 11:07:57  mangeot
 * I began to implement the localization but very rapidly ...
 *
 * Revision 1.15  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.14  2002/05/22 08:56:19  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.13  2002/05/07 10:31:22  mangeot
 * The UTF-8 consultation is now OK,
 * I tested with omniweb, iexplorer and netscape latests versions on macosX
 *
 * Revision 1.12  2002/05/02 16:31:01  serasset
 * myUrlencode and myGetParameter added. These method allows the encoding/decoding of UTF-8
 * strings for/from CGI parameters.
 *
 * Revision 1.11  2002/04/26 11:33:36  serasset
 * MailingList managment and interface polished. Insertion of a new feature to display
 * messages to the user from most business objects (PapillonUserLogger class).
 *
 * Revision 1.10  2002/03/11 11:13:55  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2001/11/15 15:15:53  serasset
 * *** empty log message ***
 *
 * Revision 1.8  2001/08/07 13:11:48  salvati
 * Adding ant.jar for untar tools.
 *
 * Revision 1.7  2001/07/27 14:41:15  salvati
 * Adding the possibility to Upload A File...
 *
 * Revision 1.6  2001/07/25 12:48:38  salvati
 * Adding StyleSheet choice in the standard consultation view with a menu on the right.
 *
 * Revision 1.5  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.4  2001/07/10 10:15:49  serasset
 * Integration de xalan.
 * getContent retourne un NOde et non plus un HTMLElement.
 *
 * Revision 1.3  2001/07/05 15:53:09  salvati
 * integration d un mot et changement de HTMLElement en Node
 *
 * Revision 1.2  2001/07/04 12:50:50  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * Abstract class implementing the Base layout of all presentations.
 */

package fr.imag.clips.papillon.presentation;

// Papillon import
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.*;
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
import org.w3c.dom.html.*;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.enhydra.xml.xmlc.*;
import org.enhydra.xml.xmlc.html.*;
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

//pour le debugage
import fr.imag.clips.papillon.business.utility.*;
import fr.imag.clips.papillon.business.PapillonLogger;

import org.enhydra.xml.io.OutputOptions;
import org.enhydra.xml.io.DOMFormatter;

public abstract class BasePO implements HttpPresentation {


	// Administrator message, to be displayed in all sessions
	public static String adminMessage = "";
	
	// Cookie keys
	public final static String LOGIN_COOKIE="PapillonLoginCookie";
	
	protected final static String LANG_PARAMETER="lang";
	// protected static final String USER_KEY = "DiscRackPerson";
	protected static String LOGIN_PAGE = "LoginUser.po";
	protected static String REGISTER_PAGE = "Register.po";
	protected static String DESTINATION_AFTER_LOGIN_PARAMETER = "Destination";

	// JavaScript to add inthe header
	protected String headerScript = "";

	// protected static String DISC_CATALOG_PAGE = "/discMgmt/DiscCatalog.po";

	// Known sections
	public static int NO_SECTION = 0;
	public static int INFORMATIONS_SECTION = 1;
	public static int CONSULT_SECTION = 2;
	public static int EDITION_SECTION = 3;
	public static int CONTACTS_SECTION = 4;
	public static int HELP_SECTION = 5;


	/**
		* This is the procedure that is called when an HTML request occurs.
	 *
	 * @return XMLObject The XMLObject (in HTML format) that is to be included
	 * in the standard layout.
	 */
	public abstract Node getContent() throws Exception;


	/**
		* This method should be implemented in the subclass so that it returns
	 * true if this particular request requires the user to be logged
	 * in, otherwise false.
	 */
	protected abstract boolean loggedInUserRequired();

	/**
		* This method should be implemented in the subclass so that it returns
	 * true if this particular request requires the user to be logged
	 * in, otherwise false.
	 */
	protected abstract boolean adminUserRequired();

	/**
		* This is the procedure that is called to know in what section we currently are
	 * in order for the header to be modified appropriately.
	 *
	 * @return XMLObject The XMLObject (in HTML fomat) that is to be included
	 * in the standard layout.
	 */
	protected abstract int getCurrentSection();

	/**
		* Saved input and output context, and session data
	 */
	protected HttpPresentationComms myComms = null;
	protected PapillonSessionData mySessionData = null;

	/**
		* Reference to the user logged in to the session
	 */
	protected User myUser = null;
	/**
		* Gets HttpPresentation object
	 *
	 * @return The saved comms objects
	 * to whichever subclass needs it
	 */
	public HttpPresentationComms getComms() {
		return this.myComms;
	}

	/**
		* Gets the session data
	 *
	 * @return session data
	 */
	public PapillonSessionData getSessionData() {
		return this.mySessionData;
	}

	public void setHeaderScript(String newScript)
		throws PapillonPresentationException {
			this.headerScript= newScript;
		}

	/**
		* Sets the user into the session
	 *
	 * @param thePerson, the person to be set in the session
	 * @exception PapillonPresentationException
	 */
	public void setUser(User theUser)
		throws PapillonPresentationException {
		try {
			this.myComms.session.setUser(theUser);
			}
		catch (com.lutris.appserver.server.session.SessionException SesEx) {
			throw new PapillonPresentationException("BasePO:Session Error for setUser: ",SesEx);
		}
			this.getSessionData().setUser(theUser);
    }

	/**
		* Gets the user from the session
	 *
	 * @return the person object in the session
	 */
	public User getUser() {
		return this.getSessionData().getUser();
	}

	/**
		* Method to remove the current user from the session
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
			}
		catch (com.lutris.appserver.server.session.SessionException SesEx) {
			throw new PapillonPresentationException("BasePO:Session Error for clearUser: ",SesEx);
		}
		catch (com.lutris.appserver.server.httpPresentation.HttpPresentationException HttpEx) {
			throw new PapillonPresentationException("BasePO: Error for request.get...: ",HttpEx);
		}
		this.getSessionData().removeUser();
	}


	/**
		* This implements the run method in HttpPresentation.
	 *
	 * @param HttpPresentationComms
	 * @exception Exception
	 */
	public void run(HttpPresentationComms comms)
		throws HttpPresentationException, IOException, Exception
	{

		// Initialize new or get the existing session data
		initSessionData(comms);
		// Check if the user needs to be logged in for this request.
		if(this.loggedInUserRequired()) {
			checkForUserLogin();   // This will redirect the user to the login page if necessary
		}

		if(this.adminUserRequired()) {
			checkForUserAdmin();   // This will redirect the user to the login page if necessary
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
		stdLayout = new StdLayout(comms, this.getSessionData(), this.getUrl(),this.headerScript);

		// FIXME: Modification done by Olivier Tache not generic !
	// if content is returned by ConsultInformations, find <HEAD> elements
	// and try to move them to layout's <HEAD>
		if (content.getNodeName().equals("#document")) {
			// the content is returned by ConsultInformations
	 // place the document's body in a <DIV> tag
			HTMLTransformFactory transf = new HTMLTransformFactory();
			finalContent = transf.mkDivFromBody(stdLayout.getLayout(), (Element)((Document)content).getElementsByTagName("body").item(0));
		} else {
			// the content is returned by an other presentation object.
			finalContent=content;
		}


		comms.response.setContentType( "text/html; charset=UTF-8" );

		//Insertion du contenu dans le document vide.
		stdLayout.getLayout().getElementContentPlace().appendChild(stdLayout.getLayout().importNode(finalContent,true));

		// Affichage en debut de document d'un eventuel message administatif a l'utilisateur.
		handleAdminMessage(stdLayout);

		// Affichage en debut de document d'un eventuel message a l'utilisateur.
		handleUserMessage(stdLayout);

		// Preparation de la sortie...
		OutputOptions options = new OutputOptions();
		options.setDropHtmlSpanIds(true);
		options.setXmlEncoding("UTF-8");
		DOMFormatter fFormatter = new DOMFormatter(options);

		buffer = fFormatter.toBytes(stdLayout.getLayout());
		comms.response.setContentLength( buffer.length );
		out = comms.response.getOutputStream();
		out.write(buffer);
		out.flush();
	}


	/**
		* Method to put an eventual message for the user into the layout
	 *
	 * @param StdLayout the layout into which to put an eventual user message
	 */
	protected void handleUserMessage(StdLayout stdLayout) {
		// Affichage en debut de document d'un eventuel message a l'utilisateur.
		Node userMessage = stdLayout.getLayout().getElementUserMessage();
		String userMessageText = this.getSessionData().getUserMessage();

		if (userMessageText.length() == 0) {
			Node mother = userMessage.getParentNode();
			mother.removeChild(userMessage);
		} else {
			stdLayout.getLayout().setTextUserMessageText(userMessageText);
			this.getSessionData().flushUserMessage();
		}
	}

	protected void handleAdminMessage(StdLayout stdLayout) {
		// Affichage en debut de document d'un eventuel message a l'utilisateur.
		Node adminMessageNode = stdLayout.getLayout().getElementAdminMessage();

		if (this.adminMessage == null || this.adminMessage.equals("")) {
			Node mother = adminMessageNode.getParentNode();
			mother.removeChild(adminMessageNode);
		} else {
			stdLayout.getLayout().setTextAdminMessageText(this.adminMessage);
		}
	}

	/**
		* Method to get or create the AgSessionData object from the user session
	 * This object is saved in the EbrokerPresentation object
	 *
	 * @param HttpPresentationComms
	 * @exception PapillonPresentationException
	 */
	protected void initSessionData(HttpPresentationComms comms)
		throws PapillonPresentationException, HttpPresentationException,
		com.lutris.appserver.server.session.SessionException {
			this.myComms = comms;

			try {
				Object obj = comms.sessionData.get(PapillonSessionData.SESSION_KEY);
				// If we found the session data, save it in a private data member
				if(null != obj) {
					this.mySessionData = (PapillonSessionData)obj;
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
					this.mySessionData = new PapillonSessionData(cookieUser,userAcceptLanguage,this.myComms.request.getHeader("User-Agent"));
					if (cookieUser == null) {
						cookieUser = new User();
						cookieUser.setName(comms.request.getRemoteHost());
						cookieUser.setLogin("Not registered");
						cookieUser.setEmail(comms.request.getRemoteUser() + "@" + comms.request.getRemoteAddr());
					}
					PapillonSessionManager.addNewSession(comms.session, cookieUser);
					comms.sessionData.set(PapillonSessionData.SESSION_KEY, this.mySessionData);
				}
			} catch(KeywordValueException ex) {
				PapillonLogger.writeDebugMsg("Problem getting session data from session: " +
																 ex.getMessage());
			}
    }

	/**
		* Checks the session data for a User, if not there then redirects to the login page
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
					PapillonLogger.writeDebugMsg("PO: "+ requestedPO);
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
		* Checks the session data for a User admin, if not there then redirects to the register page
	 */

	protected void checkForUserAdmin()
		throws ClientPageRedirectException, PapillonPresentationException {
			try {
				if (!this.getUser().IsAdmin()) {
					PapillonLogger.writeDebugMsg("USER NOT ADMIN");
					this.getSessionData().writeUserMessage("User not Admin");
					//send to LoginPage if a logged in user is required.
					String requestedPO = myComms.request.getRequestURI();
					PapillonLogger.writeDebugMsg("PO: "+ requestedPO);
					// Call the subclass's implemented method
					PapillonLogger.writeDebugMsg("REDIRECTING TO REGISTER PAGE");
					throw new ClientPageRedirectException(REGISTER_PAGE);
				}
			} catch (Exception ex) {
				throw new PapillonPresentationException("Trouble checking for user admin status", ex);
			}
		}

	/**
		* Method to write a debugging message to the debug log
	 * channel when the DEBUG flag is turned on
	 *
	 * @param msg The message to write to the DEBUG log channel
	 */
	/*    public static void writeDebugMsg(String msg) {
		Enhydra.getLogChannel().write(Logger.DEBUG,msg);
	}
*/
	public String myUrlEncode(String str) throws java.io.UnsupportedEncodingException {

		byte[] theBytestream = str.getBytes("UTF-8");

		return java.net.URLEncoder.encode(new String(theBytestream));
	}

	public String myGetParameter(String name)
		throws java.io.UnsupportedEncodingException, HttpPresentationException {
			String res = null;
			String pvalue = this.getComms().request.getParameter(name);
			if (null != pvalue) {
				byte [] pbytes = pvalue.getBytes("ISO-8859-1");
				res =  new String(pbytes, "UTF-8");
			}
			return res;
		}

	public String[] myGetParameterValues(String name)
		throws java.io.UnsupportedEncodingException, HttpPresentationException {
			String[] res = this.getComms().request.getParameterValues(name);
			if (null != res && res.length>0) {
				for (int i=0;i<res.length;i++) {
					byte [] pbytes = res[i].getBytes("ISO-8859-1");
					res[i] =  new String(pbytes, "UTF-8");
				}
			}
			return res;
		}

	public ArrayList getUserAcceptLanguages() {
		return this.getSessionData().getUserAcceptLanguages();
	}

	public String getPreference(String name) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		return this.getSessionData().getPreference(getUrl(),name);
	}

	public void setPreference(String name,String value) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		this.getSessionData().setPreference(getUrl(),name,value);
	}

	public void setPreference(String name,String value, boolean persistent) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		this.getSessionData().setPreference(getUrl(),name,value, persistent);
	}

	public void setUserPreferredLanguage(String lang) throws
		fr.imag.clips.papillon.business.PapillonBusinessException {
			User myUser = this.getUser();
			if (myUser != null && !myUser.IsEmpty()) {
				this.getUser().setLang(lang);
				this.getUser().save();
			}
			this.getSessionData().setUserPreferredLanguage(lang);
    }

	public String getUserPreferredLanguage() {
		return this.getSessionData().getUserPreferredLanguage();
	}


	protected String getUrl() {
		String className = this.getClass().getName();
		return className.substring(className.lastIndexOf(".")+1) + ".po";
	}

	public void setCookie(String key, String value)
		throws HttpPresentationException {
			Cookie myCookie;
			try {
				myCookie = new Cookie(key, value);
				myCookie.setMaxAge(365*30*24*60*60); // valid for 1 year
				this.getComms().response.addCookie(myCookie);
			} catch (Exception ex) {
				throw new PapillonPresentationException("Trouble setting cookie", ex); }
		}

	public Cookie[] getCookies()
		throws HttpPresentationException {
			return this.getComms().request.getCookies();
    }

	public User getLoginCookieUser()
		throws HttpPresentationException {
			User cookieUser = null;
			Cookie[] myCookies = this.getCookies();
			int i=0;
			while (i<myCookies.length && cookieUser == null) {
				Cookie myCookie = myCookies[i];
				if (myCookie.getName().equals(LOGIN_COOKIE)) {
					cookieUser = UsersFactory.findUserById(myCookie.getValue());
				}
				i++;
			}
			return cookieUser;
		}

	public boolean IsClientWithLabelDisplayProblems()
		throws HttpPresentationException {
			return this.getSessionData().getClientWithLabelDisplayProblems();
		}

	public static void setSelected(HTMLSelectElement mySelect, String[] myArray) {
		Vector myVector = new Vector();
		myVector.addAll(Arrays.asList(myArray));
		setSelected(mySelect, myVector);
	}

	public static void setSelected(HTMLSelectElement mySelect, String myValue) {
		if (myValue != null && !myValue.equals("")) {
			HTMLCollection myCollection = mySelect.getOptions();
			int i=0;
			while (i<myCollection.getLength()) {
				if (((HTMLOptionElement) myCollection.item(i)).getValue().equals(myValue)) {
					mySelect.setSelectedIndex(i);
					break;
				}
				i++;
			}
		}
	}

	public static void setSelected(HTMLSelectElement mySelect, Vector myVector) {
		if (myVector != null && myVector.size()>0) {
			HTMLCollection myCollection = mySelect.getOptions();
			int i=0;
			while (i<myCollection.getLength() && myVector.size()>0) {
				HTMLOptionElement myOptionElement = (HTMLOptionElement) myCollection.item(i);
				String myOption = myOptionElement.getValue();
				if (myVector.contains(myOption)) {
					myOptionElement.setSelected(true);
					myVector.remove(myOption);
				}
				i++;
			}
		}
	}

	public static void setUnicodeLabels(HTMLSelectElement mySelect) {
		HTMLCollection myCollection = mySelect.getOptions();
		for (int i=0; i<myCollection.getLength(); i++) {
						HTMLOptionElement myOption = (HTMLOptionElement) myCollection.item(i);
						myOption.setLabel(myOption.getText());
		}
	}
}
