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
 * Revision 1.2  2005/02/16 16:34:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1  2004/11/13 17:41:27  mangeot
 * New admin page for groups admin
 *
 *-----------------------------------------------
 * Papillon AdminGroups page.
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
import fr.imag.clips.papillon.presentation.html.orig.AdminGroupsTmplHTML;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonLogger;


public class AdminGroups extends BasePO {

    protected final static String REMOVE_PARAMETER="Remove";
    
    protected static AdminGroupsTmplHTML content;

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
        content = (AdminGroupsTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("AdminGroupsTmplHTML", this.getComms(), this.getSessionData());
	  
        HttpPresentationRequest req = this.getComms().request;

        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {

            //TEMPORAIRE :avec l URL
            //AJOUT DE DICO
            String userMessage = null;
            if (myGetParameter(content.NAME_AddGroup)!=null &&
				myGetParameter(content.NAME_GroupName)!=null &&
				myGetParameter(content.NAME_GroupPassword)!=null) {
				String groupName = myGetParameter(content.NAME_GroupName);
				String groupPassword = myGetParameter(content.NAME_GroupPassword);
				String groupPassword2 = myGetParameter(content.NAME_GroupPasswordConfirm);
				
                GroupAnswer myGroupAnswer = GroupsFactory.createUniqueGroup(groupName, groupPassword, groupPassword2, this.getUser().getLogin());
                userMessage = myGroupAnswer.getMessage();
            }
            else if (null != myGetParameter(REMOVE_PARAMETER)) {
                Group myGroup = GroupsFactory.findGroupByHandle(myGetParameter(REMOVE_PARAMETER));
								if (myGroup !=null && !myGroup.IsEmpty()) {
									String groupName = myGroup.getName();
									myGroup.delete();
									userMessage = "Group "+  groupName + " has been deleted";
								}
								else {
									userMessage = "Group not in database";
								}
            }
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
        }
				
        addGroupsArray();
        
        //On rend le contenu correct
        return content.getElementFormulaire();
    }


    protected void addGroupsArray()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {

            Group[] GroupsTable=GroupsFactory.getGroupsArray();
            //where we must insert the form
            HTMLTableRowElement theRow = content.getElementTemplateRow();
            HTMLElement theCount = content.getElementExistingGroups();
            HTMLElement theName = content.getElementName();
            HTMLElement theAdmins = content.getElementAdmins();
            HTMLAnchorElement theRemoveAnchor = content.getElementRemoveAnchor();

            Node theRowParent = theRow.getParentNode();

            theRow.removeAttribute("id");
            theCount.removeAttribute("id");
            theName.removeAttribute("id");
            theAdmins.removeAttribute("id");
            theRemoveAnchor.removeAttribute("id");
			
			content.setTextExistingGroups("" + GroupsTable.length);

            //adding the volumes description
            for ( int i = 0; i < GroupsTable.length; i++ ) {
				Group tempGroup = GroupsTable[i];
                content.setTextName(tempGroup.getName());
				String[] adminsArray = tempGroup.getAdminsArray();
				String groupsString = "";
				for (int j=0;j< adminsArray.length;j++) {
					groupsString += adminsArray[j] + "";
				}
                content.setTextAdmins(groupsString);

			if (tempGroup.IsAdmin(this.getUser().getLogin())) {
                 theRemoveAnchor.setHref(this.getUrl() + "?" + REMOVE_PARAMETER +
                                        "=" + tempGroup.getHandle());

				}
				else {
					theRemoveAnchor.setHref("");
				}
                theRowParent.appendChild(theRow.cloneNode(true));
            }

            theRowParent.removeChild(theRow);
        }
}
