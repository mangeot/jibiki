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
 * Revision 1.4  2003/06/11 12:48:35  serasset
 * Correction bugs introduit par liu qui empechaient la compilation après un clean.
 * La classe Login n'est plus référencées nulle part.
 *
 * Revision 1.3  2003/06/04 15:37:46  serasset
 * Mise en place de la nouvelle version de la gestion des utilisateurs.
 *
 * Revision 1.2.2.1  2003/05/28 09:17:23  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.2  2002/12/09 08:32:02  mangeot
 * Added a permanent cookie for indentification when reconnection
 *
 * Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.6  2002/10/25 14:10:34  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.5.2.2  2002/10/09 07:30:11  mangeot
 * Added the logout function
 *
 * Revision 1.5.2.1  2002/10/09 06:18:06  mangeot
 * password encoding for protection
 *
 * Revision 1.5  2002/07/26 16:51:12  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.4  2002/07/26 10:00:27  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.3  2002/07/10 09:53:08  serasset
 * The Users is now redirected to his initial destination after login.
 *
 * Revision 1.2.6.2  2002/07/12 13:50:47  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.2.6.1  2002/07/09 08:32:59  serasset
 * Corrected a cross dependancy issue between LoginUser and BasePO.
 *
 * Revision 1.2  2002/05/23 16:14:42  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.1  2002/05/22 08:58:19  mangeot
 * Added files for login user
 *
 *-----------------------------------------------
 * Papillon Login page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import fr.imag.clips.papillon.business.message.MessageDBLoader;

//import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;

import org.apache.xerces.dom.*;

// for users
import fr.imag.clips.papillon.business.user.*;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.html.orig.*;


public class LoginUser extends BasePO {
    protected final static String LOGIN_PARAMETER="Login";
    protected final static String REMEMBER_LOGIN_PARAMETER="RememberLogin";
    protected final static String PASSWORD_PARAMETER="Password";
    protected final static String LOGOUT_PARAMETER="Logout";
    // Now called DESTINATION_AFTER_LOGIN_PARAMETER and inherited from BasePO
    //protected final static String DESTINATION_PARAMETER="Destination";

    protected final static String SUBMIT_PARAMETER="Submit";
    
    protected static LoginUserTmplHTML content;


    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean adminUserRequired() {
        return false;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws javax.xml.parsers.ParserConfigurationException,
	       HttpPresentationException,
	       IOException, org.xml.sax.SAXException,
	       javax.xml.transform.TransformerException
    {

        // Création du contenu
        content = (LoginUserTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("LoginUserTmplHTML", this.getComms(), this.getSessionData());

        HttpPresentationRequest req = this.getComms().request;

        String Login = myGetParameter(LOGIN_PARAMETER);
        String RememberLogin = myGetParameter(REMEMBER_LOGIN_PARAMETER);
        String Logout = myGetParameter(LOGOUT_PARAMETER);
        String Password = myGetParameter(PASSWORD_PARAMETER);
        String Dest = myGetParameter(DESTINATION_AFTER_LOGIN_PARAMETER);
        // If there is no destination, just redirect the user to the home page after a succesfull log in.
        Dest = (Dest != null) ? Dest : req.getAppFileURIPath("/");
        
        String userMessage = "";
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            if (null != myGetParameter(SUBMIT_PARAMETER) &&
                null != Login && !Login.equals("") &&
                null != Password && !Password.equals("")) {
                User myUser = UsersFactory.findUserByLogin(Login);
                if (null != myUser && !myUser.IsEmpty()) { 
                    if (myUser.HasCorrectPassword(Password)) {
                        setUser(myUser);
                        if (RememberLogin != null && !RememberLogin.equals("")) {
                            this.setCookie(this.LOGIN_COOKIE,
                            myUser.getHandle());
                        }
                        throw new ClientPageRedirectException(Dest);                  
                    } else {
                        userMessage = "Wrong password";
                    }
                } else {
                    userMessage = "User unknown";
                }
            }
            if (null != Logout && !Logout.equals("")) {
                this.removeUserFromSession();
                userMessage = "User logged out";
            }
            this.getSessionData().writeUserMessage(userMessage);
            PapillonLogger.writeDebugMsg(userMessage);
        }

            // If the login failed, we have to send the login form with the appropriate Destination
        HTMLInputElement DestElement = (HTMLInputElement) content.getElementDestination();
        DestElement.setValue(Dest);
        
        return content.getElementFormulaire();
    }
    
    
    
    //    protected void addMessage(String xmlString)
    //    throws fr.imag.clips.papillon.business.PapillonBusinessException {

            //where we must insert the xml
    //        HTMLDivElement theXml = (HTMLDivElement) content.getElementMessage();
    //        Text textTemplate = new TextImpl();
      //      textTemplate.setData(xmlString);
        //    theXml.appendChild(textTemplate);
    //  }    
}
