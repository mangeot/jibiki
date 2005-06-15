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
 * Revision 1.7  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.6  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.5.4.4  2005/06/09 11:07:45  mangeot
 * Deleted the countEntriesCache. entries counts are not cached any more.
 * Fixed a few bugs.
 *
 * Revision 1.5.4.3  2005/06/01 08:38:43  mangeot
 * Multi bug correction + added the possibility of disabling data edition
 * via the Admin.po page
 *
 * Revision 1.5.4.2  2005/05/25 22:06:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.5.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
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

import org.enhydra.xml.xhtml.dom.*;
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

	/* by default, data is editable */
	public static boolean EDIT_DATA = true;

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
		
		boolean cacheSet = fr.imag.clips.papillon.business.dictionary.VolumeEntry.CACHE_HTMLDOM;

		
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
				String setCacheString = myGetParameter(content.NAME_HTMLDomCaches);
				cacheSet = (setCacheString!=null && !setCacheString.equals(""));
				fr.imag.clips.papillon.business.dictionary.VolumeEntry.setCacheHtmlDom(cacheSet);
                this.getSessionData().writeUserMessage("HTML DOM cache is set? " + cacheSet);
            }
			else if (null != req.getParameter(content.NAME_SetEditData)) {
				String editDataString = myGetParameter(content.NAME_EditData);
				EDIT_DATA = (editDataString!=null && !editDataString.equals(""));
                this.getSessionData().writeUserMessage("Data is editable? " + EDIT_DATA);
            }
        }
		
		addAdminForm(content, cacheSet, EDIT_DATA);

        //On rends le contenu correct
        return content.getElementHomeContent();
    }
	
	protected static void addAdminForm (AdminTmplXHTML content, boolean cacheSet, boolean editData) {
	
		XHTMLInputElement cacheElement = content.getElementHTMLDomCaches();
		cacheElement.setChecked(cacheSet);
		
		XHTMLInputElement editDataElement = content.getElementEditData();
		editDataElement.setChecked(editData);
		
	}
	
	
}
