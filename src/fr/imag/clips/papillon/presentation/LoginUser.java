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
 * Revision 1.3  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
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

import fr.imag.clips.papillon.presentation.xhtml.orig.*;


public class LoginUser extends BasePO {
    protected final static String LOGIN_PARAMETER="Login";
    protected final static String REMEMBER_LOGIN_PARAMETER="RememberLogin";
    protected final static String PASSWORD_PARAMETER="Password";
    protected final static String LOGOUT_PARAMETER="Logout";
    // Now called DESTINATION_AFTER_LOGIN_PARAMETER and inherited from BasePO
    //protected final static String DESTINATION_PARAMETER="Destination";

    protected final static String SUBMIT_PARAMETER="Submit";
    
    protected static LoginUserTmplXHTML content;


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
        content = (LoginUserTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("LoginUserTmplXHTML", this.getComms(), this.getSessionData());

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
