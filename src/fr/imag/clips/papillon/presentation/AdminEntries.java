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
 * Revision 1.5  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.4  2003/08/14 08:30:16  mangeot
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
 * Revision 1.3.2.3  2003/07/31 10:51:31  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.2  2003/06/21 17:56:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.1  2003/05/28 09:17:21  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.3  2003/02/13 09:42:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/02/13 09:39:38  mangeot
 * Select the previously selected volume
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/07/26 10:00:21  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.4.6.1  2002/07/12 13:50:41  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.4  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.3  2002/05/22 08:56:18  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.2  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.1  2002/05/09 06:00:38  mangeot
 * *** empty log message ***
 *-----------------------------------------------
 * Papillon Admin page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
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


//pour le dictionary
import fr.imag.clips.papillon.business.dictionary.*;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.html.orig.*;


public class AdminEntries extends BasePO {
    protected final static String ADD_PARAMETER="Add";
    protected final static String EMPTY_PARAMETER="Empty";
    
    protected final static String URL_PARAMETER="url";
    protected final static String VOLUME_PARAMETER="VOLUME";

    protected static AdminEntriesTmplHTML content;

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
        throws HttpPresentationException
    {
        
        // Création du contenu
        content = (AdminEntriesTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("AdminEntriesTmplHTML", this.getComms(), this.getSessionData());

        HttpPresentationRequest req = this.getComms().request;
        
        String volumeString = req.getParameter(VOLUME_PARAMETER);
        
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            //TEMPORAIRE :avec l URL
            //AJOUT D ENTREE DE DICO
            String userMessage = null;
            if (null != req.getParameter(ADD_PARAMETER) &&
                null != req.getParameter(URL_PARAMETER)) {
                String URL = req.getParameter(URL_PARAMETER);
                VolumeEntriesFactory.parseVolume(volumeString, URL);
                userMessage = "Volume: " + volumeString + " / URL: " + URL + " downloaded...";
            }
            else if (null != req.getParameter(EMPTY_PARAMETER)) {
                Volume myVolume = VolumesFactory.findVolumeByName(volumeString);
                VolumeEntriesFactory.emptyVolumeEntries(myVolume.getDbname());
                IndexFactory.emptyIndex(myVolume.getIndexDbname());
                userMessage = "Entries of volume " + volumeString + " removed...";
            }
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
        }
        addConsultForm(volumeString);
        //On rend le contenu correct
        return content.getElementFormulaire();
    }
        protected void addConsultForm(String selectedVolume) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException, 
                HttpPresentationException {
           // Adding the appropriate source languages to the source list
        HTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
        Node volumeSelect = volumeOptionTemplate.getParentNode();
        volumeOptionTemplate.removeAttribute("id");
        // We assume that the option element has only one text child 
        // (it should be this way if the HTML is valid...)
        Text volumeTextTemplate = (Text)volumeOptionTemplate.getFirstChild(); 
                
                
        Volume[] AllVolumes = VolumesFactory.getVolumesArray();
                
        for (int i = 0; i < AllVolumes.length; i++) {
            String volumeName = AllVolumes[i].getName();
            volumeOptionTemplate.setValue(volumeName);
            volumeOptionTemplate.setLabel(volumeName);
            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux 
            // specs W3C.
            volumeTextTemplate.setData(volumeName);
            volumeOptionTemplate.setSelected(volumeName.equals(selectedVolume));
            volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
        }
        volumeSelect.removeChild(volumeOptionTemplate);
    }
    
}
