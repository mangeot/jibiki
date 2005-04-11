/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 * Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.4  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.3  2005/01/14 23:08:13  mangeot
 * Fixed some bugs in ConsultExpert + code cleaning
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.4  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.3  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.2.2.3  2004/01/22 05:36:05  mangeot
 * Improving accessibility for non javascripts enabled users and added confirmations for javacsripts enabled browsers
 *
 * Revision 1.2.2.2  2004/01/21 07:50:29  mangeot
 * Added confirm javascript for delete button
 *
 * Revision 1.2  2003/08/19 08:06:43  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2003/08/19 06:21:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/06/11 12:48:35  serasset
 * Correction bugs introduit par liu qui empechaient la compilation après un clean.
 * La classe Login n'est plus référencées nulle part.
 *
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

public class UserProfile extends BasePO {
   
   protected static UserProfileXHTML content;


    protected boolean loggedInUserRequired() {
        return true;
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
        content = (UserProfileXHTML)MultilingualXHtmlTemplateFactory.createTemplate("UserProfileXHTML", this.getComms(), this.getSessionData());
        
        HttpPresentationRequest req = this.getComms().request;
        String login= this.getUser().getLogin();
        String name = "";
        String password = "";
        String newpassword = "";
        String newpassword2 = "";
        String email = "";
        String group = "";
        String groupPassword = "";
				
        
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {

            String userMessage = new String("");

            /* Changing a user password */
            if (null != myGetParameter(content.NAME_ChangePassword)) {
                password = myGetParameter(content.NAME_CPPassword);
                newpassword = myGetParameter(content.NAME_NewPassword);
                newpassword2 = myGetParameter(content.NAME_NewPassword2);
                
                UserAnswer myUserAnswer = UsersFactory.changeUserPassword(login, password, newpassword, newpassword2);
                if (!myUserAnswer.IsEmpty()) {
                    this.setUser(myUserAnswer.getUser());
                }
                userMessage = myUserAnswer.getMessage();
            }

            /* Change name and mail addresse */
            if (null != myGetParameter(content.NAME_ChangeEmail)) {
							email = myGetParameter(content.NAME_Email);
							name = myGetParameter(content.NAME_Name);

							UserAnswer myUserAnswer = UsersFactory.ChangeNameAndEmail(this.getUser(), name, email);
                if (!myUserAnswer.IsEmpty()) {
                    this.setUser(myUserAnswer.getUser());
                }
                userMessage = myUserAnswer.getMessage();
            }

						/* Adding a user into a group */
            if (null != myGetParameter(content.NAME_AddGroup)) {
							group = myGetParameter(content.NAME_Group);
							groupPassword = myGetParameter(content.NAME_GroupPassword);

						UserAnswer myUserAnswer = UsersFactory.addUserInGroup(this.getUser(), group, groupPassword);
							if (!myUserAnswer.IsEmpty()) {
								this.setUser(myUserAnswer.getUser());
							}
							userMessage = myUserAnswer.getMessage();
            }
			
						/* Deleting a user from a group */
            if (null != myGetParameter(content.NAME_DelGroup)) {
							group = myGetParameter(content.NAME_Group);
							groupPassword = myGetParameter(content.NAME_GroupPassword);

						UserAnswer myUserAnswer = UsersFactory.removeUserFromGroup(this.getUser(), group, groupPassword);
						userMessage = myUserAnswer.getMessage();
            }
						
						/* Deleting a user */
            if (null != myGetParameter(content.NAME_Delete)) {
							password = myGetParameter(content.NAME_DPassword);
								UserAnswer myUserAnswer = UsersFactory.deleteUser(this.getUser(), password);
								userMessage = myUserAnswer.getMessage();
            }
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
        }  
    //On rend le contenu correct
				addProfileForm();
				
    return content.getElementFormulaire();
  }

		protected void addProfileForm() throws fr.imag.clips.papillon.business.PapillonBusinessException {

			content.setTextUserName(this.getUser().getName());

			String login = this.getUser().getLogin();
			content.setTextCPLogin(login);
			content.setTextCELogin(login);
			content.setTextAGLogin(login);
			content.setTextDLogin(login);

			HTMLInputElement nameInput = content.getElementNameInput();
			nameInput.setValue(this.getUser().getName());
			
			HTMLInputElement emailInput = content.getElementEmailInput();
			emailInput.setValue(this.getUser().getEmail());
			
		}
}
