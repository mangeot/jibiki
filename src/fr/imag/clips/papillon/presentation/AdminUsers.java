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
 * Papillon Admin Users page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.session.Session;

//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import fr.imag.clips.papillon.business.message.MessageDBLoader;

import fr.imag.clips.papillon.presentation.PapillonSessionData;

//import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;

// for users
import fr.imag.clips.papillon.business.user.*;
import fr.imag.clips.papillon.presentation.xhtml.orig.AdminUsersTmplXHTML;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonLogger;


public class AdminUsers extends BasePO {

    protected final static String SEE_PARAMETER="See";
    protected final static String REMOVE_PARAMETER="Remove";
    protected final static String MAKEADMIN_PARAMETER="MakeAdmin";
    protected final static String RESETPASSWORD_PARAMETER="ResetPassword";
    protected final static String MAKESPECIALIST_PARAMETER="MakeSpecialist";
    protected final static String SORTBY_PARAMETER="SortBy";

    
    protected static AdminUsersTmplXHTML content;

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean adminUserRequired() {
        return true;
    }

    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws javax.xml.parsers.ParserConfigurationException,
			HttpPresentationException,
		    IOException, org.xml.sax.SAXException,
			javax.xml.transform.TransformerException,
			fr.imag.clips.papillon.presentation.PapillonPresentationException {
        
        // Création du contenu
        content = (AdminUsersTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("AdminUsersTmplXHTML", this.getComms(), this.getSessionData());
	  
        HttpPresentationRequest req = this.getComms().request;

        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {

            //TEMPORAIRE :avec l URL
            //AJOUT DE DICO
            String userMessage = null;
            if (null != myGetParameter(REMOVE_PARAMETER)) {
                User myUser = UsersFactory.findUserById(myGetParameter(REMOVE_PARAMETER));
								if (myUser !=null && !myUser.IsEmpty()) {
									String userName = myUser.getName();
									myUser.delete();
									userMessage = "User "+  userName + " has been deleted";
								}
								else {
                    userMessage = "User not in database";
								}
            }
            else if (null != myGetParameter(MAKEADMIN_PARAMETER)) {
                User myUser = UsersFactory.findUserById(myGetParameter(MAKEADMIN_PARAMETER));
                if (null != myUser && !myUser.IsEmpty()) {
                    myUser.addGroup(User.ADMIN_GROUP);
                    myUser.save();
                    userMessage = "User "+ myUser.getName() + " is admin";
                } else {
                    userMessage = "Ignoring user";
                }
            }
            else if (null != myGetParameter(RESETPASSWORD_PARAMETER)) {
                User myUser = UsersFactory.findUserById(myGetParameter(RESETPASSWORD_PARAMETER));
                if (null != myUser && !myUser.IsEmpty()) {
                    myUser.setPassword(myUser.getLogin());
                    myUser.save();
                    userMessage = "User "+ myUser.getName() + " has a new password with the login " + myUser.getLogin() + " for value";
                } else {
                    userMessage = "Ignoring user";
                }
            }
            else if (null != myGetParameter(MAKESPECIALIST_PARAMETER)) {
                User myUser = UsersFactory.findUserById(myGetParameter(MAKESPECIALIST_PARAMETER));
                if (null != myUser && !myUser.IsEmpty()) {
                    myUser.addGroup(User.SPECIALIST_GROUP);
                    myUser.save();
                    userMessage = "User "+ myUser.getName() + " is a specialist";
                } else {
                    userMessage = "Ignoring user";
                }
            }
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
        }
		
		String sortBy = myGetParameter(SORTBY_PARAMETER);
		
        addLoggedUsersArray();
        addUsersArray(sortBy);
        
        //On rend le contenu correct
        return content.getElementFormulaire();
    }

	protected void addLoggedUsersArray()
        throws fr.imag.clips.papillon.business.PapillonBusinessException,
		 fr.imag.clips.papillon.presentation.PapillonPresentationException {
		
			java.util.Vector ActiveUsersVector = PapillonSessionManager.getActiveUsersVector();	

            //where we must insert the form
            HTMLTableRowElement theRow = content.getElementLoggedTemplateRow();
            HTMLElement theCount = content.getElementLoggedUsers();
            HTMLElement theName = content.getElementLoggedName();
            HTMLElement theLogin = content.getElementLoggedLogin();
            HTMLElement theEmail = content.getElementLoggedEmail();
 
            Node theRowParent = theRow.getParentNode();

            theRow.removeAttribute("id");
            theCount.removeAttribute("id");
            theName.removeAttribute("id");
            theLogin.removeAttribute("id");
            theEmail.removeAttribute("id");

			content.setTextLoggedUsers("" + ActiveUsersVector.size());

            //adding the logged users
            for ( int i = 0; i < ActiveUsersVector.size(); i++ ) {
				User myUser = (User) ActiveUsersVector.elementAt(i);
				if (myUser != null) {
					content.setTextLoggedName(myUser.getName());
					content.setTextLoggedLogin(myUser.getLogin());
					content.setTextLoggedEmail(myUser.getEmail());
				}
				else {
					content.setTextLoggedName("");
					content.setTextLoggedLogin("Not registered");
					content.setTextLoggedEmail("");
				} 
				theRowParent.appendChild(theRow.cloneNode(true));
            }
            theRowParent.removeChild(theRow);
        }


    protected void addUsersArray(String sortBy)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {

            User[] UsersTable=UsersFactory.getUsersArray(sortBy);
            //where we must insert the form
            HTMLTableRowElement theRow = content.getElementTemplateRow();
            HTMLElement theCount = content.getElementExistingUsers();
            HTMLElement theName = content.getElementName();
            HTMLElement theLogin = content.getElementLogin();
            HTMLElement theEmail = content.getElementEmail();
            HTMLElement theGroups = content.getElementGroups();
            HTMLAnchorElement theMakeAdminAnchor = content.getElementMakeAdminAnchor();
            HTMLAnchorElement theResetPasswordAnchor = content.getElementResetPasswordAnchor();
            HTMLAnchorElement theMakeSpecialistAnchor = content.getElementMakeSpecialistAnchor();
            HTMLAnchorElement theSeeAnchor = content.getElementSeeAnchor();
            HTMLAnchorElement theRemoveAnchor = content.getElementRemoveAnchor();

            Node theRowParent = theRow.getParentNode();

            theRow.removeAttribute("id");
            theCount.removeAttribute("id");
            theName.removeAttribute("id");
            theLogin.removeAttribute("id");
            theEmail.removeAttribute("id");
            theGroups.removeAttribute("id");
            theMakeAdminAnchor.removeAttribute("id");
            theResetPasswordAnchor.removeAttribute("id");
            theMakeSpecialistAnchor.removeAttribute("id");
            theSeeAnchor.removeAttribute("id");
            theRemoveAnchor.removeAttribute("id");
			
			content.setTextExistingUsers("" + UsersTable.length);

            //adding the volumes description
            for ( int i = 0; i < UsersTable.length; i++ ) {
                content.setTextName(UsersTable[i].getName());
                content.setTextLogin(UsersTable[i].getLogin());
                content.setTextEmail(UsersTable[i].getEmail());
				String [] Groups = UsersTable[i].getGroupsArray();
				String groupsString = "";
				if (Groups != null && Groups.length>0)
					for (int j=0; j<Groups.length;j++) {
						groupsString += " " + Groups[j];
					}
                content.setTextGroups(groupsString);

                theMakeAdminAnchor.setHref(this.getUrl() + "?" + MAKEADMIN_PARAMETER +
                                           "=" + UsersTable[i].getHandle());
                theResetPasswordAnchor.setHref(this.getUrl() + "?" + RESETPASSWORD_PARAMETER +
                                           "=" + UsersTable[i].getHandle());
                theMakeSpecialistAnchor.setHref(this.getUrl() + "?" + MAKESPECIALIST_PARAMETER +
                                           "=" + UsersTable[i].getHandle());
                theSeeAnchor.setHref(this.getUrl() + "?" + SEE_PARAMETER +
                                     "=" + UsersTable[i].getHandle());
                theRemoveAnchor.setHref(this.getUrl() + "?" + REMOVE_PARAMETER +
                                        "=" + UsersTable[i].getHandle());

                theRowParent.appendChild(theRow.cloneNode(true));
            }

            theRowParent.removeChild(theRow);
        }
}
