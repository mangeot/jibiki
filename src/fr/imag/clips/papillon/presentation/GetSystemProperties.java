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
 * Revision 1.3  2004/03/25 02:46:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/08/14 08:30:17  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:22  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.3  2002/07/26 10:00:25  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.2.6.1  2002/07/12 13:50:45  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.2  2002/05/23 16:14:42  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.1  2002/01/22 13:20:17  serasset
 * Added the GetSystemProperties po that presents the properties of the VM the server is running on.
 *
 *-----------------------------------------------
 * This page shows the properties defined on the Virtual Machine the server runs on.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.Enhydra;
import com.lutris.appserver.server.session.SessionManager;
import com.lutris.appserver.server.session.SessionException;
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.*;

import fr.imag.clips.papillon.business.message.MessageDBLoader;

// Standard imports
import java.io.IOException;

import java.lang.System;
import java.util.Properties;
import java.util.Enumeration;

import fr.imag.clips.papillon.presentation.html.orig.*;

public class GetSystemProperties extends BasePO {

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
    throws HttpPresentationException, IOException, SessionException {

        SystemPropertiesListHTML content;
        // Création du contenu
        content = (SystemPropertiesListHTML)MultilingualHtmlTemplateFactory.createTemplate("SystemPropertiesListHTML", this.getComms(), this.getSessionData());

        // Enter Session Properties
		SessionManager mySessionManager = Enhydra.getSessionManager();
        content.setTextActiveSessionCount(new Integer(mySessionManager.activeSessionCount()).toString());
        content.setTextMaxSessionCount(new Integer(mySessionManager.maxSessionCount()).toString());
        content.setTextMaxSessionCountDate(mySessionManager.maxSessionCountDate().toString());


        // Enter System Properties List
        HTMLTableRowElement templateRow = content.getElementTemplateRow();
        HTMLElement propCellTemplate = content.getElementProperty();
        HTMLElement valueCellTemplate = content.getElementValue();
        templateRow.removeAttribute("id");
        propCellTemplate.removeAttribute("id");
        valueCellTemplate.removeAttribute("id");
        
        Node propTable = templateRow.getParentNode();

        
        // Get the properties of the system.
        Properties plist = System.getProperties();
        for (Enumeration e = plist.propertyNames() ; e.hasMoreElements() ;) {
            String propKey = e.nextElement().toString();
            String propValue = plist.getProperty(propKey, "");
            
            // Put the xorrect texts in the template
            content.setTextProperty(propKey);
            content.setTextValue(propValue);
            
            // Clone it and add the clone to the table
            Node clone=templateRow.cloneNode(true);
            propTable.appendChild(clone);
        }
        
        // Finally, delete the template
        propTable.removeChild(templateRow);
        
        //On rends le contenu correst
        return content.getElementPropertiesList();
    }

}
