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
 * Revision 1.6  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.5  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.4  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.3.2.1  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *
 *
 *-----------------------------------------------
 * Papillon Admin page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.Node;

import fr.imag.clips.papillon.business.message.MessageDBLoader;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;


// importing the classes where the caches are
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.transformation.XslTransformation;
import fr.imag.clips.papillon.business.locales.Languages;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

public class Admin extends PapillonBasePO {

    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean userMayUseThisPO() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws HttpPresentationException, IOException {
        AdminTmplXHTML content;
        
        // Création du contenu
        content = (AdminTmplXHTML) MultilingualXHtmlTemplateFactory.createTemplate("AdminTmplXHTML", this.getComms(), this.getSessionData());

        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            // Get the main parameters
            String mhonarcFolder = req.getParameter(content.NAME_Folder);
     //       String dbUrl= req.getParameter(DB_URL);
            
            // Get the requested action, THERE IS NO DEFAULT...
            if (null != req.getParameter(content.NAME_AdminMessageSubmit)) {
                AbstractPO.adminMessage=req.getParameter(content.NAME_AdminMessage);
			}
            else if (null != req.getParameter(content.NAME_Flush)) {
                this.getSessionData().writeUserMessage("Flushing is not provided for the moment...");
            } else if (null != req.getParameter(content.NAME_Reload)) {
                this.getSessionData().writeUserMessage("Flushing&Reload is not provided for the moment...");
            } else if (null != req.getParameter(content.NAME_Update)) {
                // Updating is the default action...
                MessageDBLoader loader = new MessageDBLoader(mhonarcFolder);
                loader.updateDatabase();
                this.getSessionData().writeUserMessage(loader.getUserLog());
                this.getSessionData().writeUserMessage("Updating... done.");
            } else if (null != req.getParameter(content.NAME_ResetEntriesCountCache)) {
		VolumesFactory.resetCountEntriesCache();
            } else if (null != req.getParameter(content.NAME_ResetInterfaceDescriptionCache)) {
				fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
            }
			else if (null != req.getParameter(content.NAME_ResetXslSheetTransformersCache)) {
				XslTransformation.resetCache();
            }
			else if (null != req.getParameter(content.NAME_ResetLanguagesCache)) {
				Languages.resetCache();
            }
			else if (null != req.getParameter(content.NAME_SetHTMLDomCaches)) {
				fr.imag.clips.papillon.business.dictionary.VolumeEntry.setCacheHtmlDom(true);
                this.getSessionData().writeUserMessage("HTML DOM will be cached");
            }
			else if (null != req.getParameter(content.NAME_UnsetHTMLDomCaches)) {
				fr.imag.clips.papillon.business.dictionary.VolumeEntry.setCacheHtmlDom(false);
                this.getSessionData().writeUserMessage("HTML DOM will not be cached");
            }
        }

        //On rends le contenu correct
        return content.getElementHomeContent();
    }
}
