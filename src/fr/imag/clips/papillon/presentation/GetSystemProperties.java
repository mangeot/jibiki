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
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
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
