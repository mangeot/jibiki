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
 * Revision 1.9  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.8  2004/09/21 14:35:42  mangeot
 * Adding resetCache
 *
 * Revision 1.7  2004/02/10 05:27:14  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.6.2.1  2004/01/20 09:07:59  mangeot
 * Lots of changes for version 2 of UIGenerator: interface description files are loaded
 * into the database.
 *
 * Revision 1.6  2003/10/08 03:43:12  mangeot
 * Added language cache management
 *
 * Revision 1.5  2003/09/29 10:54:26  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/09/24 15:29:14  serasset
 * Hiding of mail addresses in the Papillon Mailing List archive.
 *
 * Revision 1.3  2003/08/22 05:46:22  mangeot
 * THE release !!!
 *
 * Revision 1.2  2003/08/14 08:30:15  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:20  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.9  2002/07/26 10:00:20  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.8.6.1  2002/07/12 13:50:41  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.8  2002/05/24 16:49:02  mangeot
 * login and admin group disabled
 *
 * Revision 1.7  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.6  2002/04/26 11:33:36  serasset
 * MailingList managment and interface polished. Insertion of a new feature to display
 * messages to the user from most business objects (PapillonUserLogger class).
 *
 * Revision 1.5  2001/07/31 08:36:36  serasset
 * enommage des fichiers HTML pour eviter un eventuel ecrasement par xmlc.
 *
 * Revision 1.4  2001/07/10 10:15:49  serasset
 * Integration de xalan.
 * getContent retourne un NOde et non plus un HTMLElement.
 *
 * Revision 1.3  2001/07/09 16:37:31  serasset
 * Liens entre l'application enhydra et la base de donnees PostgreSQL.
 * Suppression du dossier data de la hierarchie CVS
 * Premiere version de la mailing list.
 *
 * Revision 1.1  2001/07/04 17:40:22  serasset
 * Creation d'une page web d'administration de la base.
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
import fr.imag.clips.papillon.business.xmlschema.UserInterface;
import fr.imag.clips.papillon.business.xmlschema.XmlSchemaFactory;
import fr.imag.clips.papillon.business.transformation.XslTransformation;
import fr.imag.clips.papillon.business.locales.Languages;

import fr.imag.clips.papillon.presentation.html.orig.*;

public class Admin extends BasePO {

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
        throws HttpPresentationException, IOException {
        AdminTmplHTML content;
        
        // Création du contenu
        content = (AdminTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("AdminTmplHTML", this.getComms(), this.getSessionData());
                
        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            // Get the main parameters
            String mhonarcFolder = req.getParameter(content.NAME_Folder);
     //       String dbUrl= req.getParameter(DB_URL);
            
            // Get the requested action, THERE IS NO DEFAULT...
            if (null != req.getParameter(content.NAME_AdminMessageSubmit)) {
                BasePO.adminMessage=req.getParameter(content.NAME_AdminMessage);
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
				UserInterface.resetCache();
				fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
            }
			else if (null != req.getParameter(content.NAME_ResetXslSheetTransformersCache)) {
				XslTransformation.resetCache();
            }
			else if (null != req.getParameter(content.NAME_ResetLanguagesCache)) {
				Languages.resetCache();
            }
        }

        //On rends le contenu correct
        return content.getElementHomeContent();
    }
}
