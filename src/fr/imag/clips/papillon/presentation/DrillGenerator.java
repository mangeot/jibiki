/*
 * papillon 
 *
 * Enhydra super-servlet
 * 
 * © Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.4  2004/01/21 11:47:22  serasset
 * Merged Trunk with PAPILLON_DEBUG_FOR_JDK14
 *
 * Revision 1.3.4.1  2004/01/09 09:29:24  mangeot
 * Modified the newdata files and removed the getXmlCodeWithDefaultEncoding
 * but there is still a big encodign problem. It is not running yet
 *
 * Revision 1.3  2003/09/29 10:54:26  mangeot
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
 * Revision 1.1.2.6  2003/08/09 07:21:06  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.1.2.5  2003/08/07 06:29:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.4  2003/06/21 17:56:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.3  2003/05/23 13:37:29  mangeot
 * I added getHeadwordText instead of getHeadword
 *
 * Revision 1.1.2.2  2003/05/23 13:04:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.1  2003/05/08 07:43:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/02/13 04:00:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/02/12 15:13:47  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/02/12 15:01:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.2  2002/09/16 13:34:24  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.1.2.1  2002/08/08 09:14:00  mangeot
 * Added files
 *
 * Revision 1.14.2.1  2002/08/02 08:25:09  mangeot
 * Replaced PAGENAME variable by this.getUrl() method
 *
 * Revision 1.14  2002/07/26 10:00:21  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.13.2.1  2002/07/12 13:50:41  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.13  2002/06/08 06:00:01  mangeot
 * VolumeHandler modified to take into account the thai dictionary,
 * headword and pos into attribute values
 *
 * Revision 1.12  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.11  2002/05/22 08:56:18  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.10  2002/05/10 16:43:19  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.9  2002/05/09 08:20:04  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2002/04/18 11:42:35  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.7  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.6  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2002/04/16 04:57:23  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/04/16 02:44:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/04/14 09:47:12  mangeot
 * lecture des elements CDM ds les fichiers volume-metadata
 * et upload des entrees
 *
 * Revision 1.2  2002/04/01 07:46:33  mangeot
 * Added a table for volumes metadata descriptions
 *
 * Revision 1.1  2002/03/11 11:13:55  mangeot
 * *** empty log message ***
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
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;


// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;

//Dom objects
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//pour les dictionary
import fr.imag.clips.papillon.business.dictionary.*;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import fr.imag.clips.papillon.presentation.html.orig.*;


public class DrillGenerator extends BasePO {

    protected static String volumeName = "Papillon_fra";

    protected static String[] Entries = {"ABDIQUER.1","ACCUSER.1","COLLER.1","CRIER.1","REGRETTER.1"};

    protected static DrillGeneratorHTML content;

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
        throws javax.xml.parsers.ParserConfigurationException,HttpPresentationException,
        IOException, org.xml.sax.SAXException,javax.xml.transform.TransformerException
    {
        
        // Création du contenu
        content = (DrillGeneratorHTML)MultilingualHtmlTemplateFactory.createTemplate("DrillGeneratorHTML", this.getComms(), this.getSessionData());
                           
        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
        }
        
        //adding the content of the dictionaries table
        addTemplatesArray();

        //On rend le contenu correct
        return content.getElementFormulaire();
    }
    
    
        protected void addTemplatesArray() 
        throws fr.imag.clips.papillon.business.PapillonBusinessException,java.io.IOException {

	    VolumeEntry[] EntriesTable= new VolumeEntry[Entries.length];
	    for (int i=0; i<Entries.length; i++) {
		Volume myVolume = VolumesFactory.findVolumeByName(volumeName);
			Dictionary myDict = null;
			try {
                myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
            }
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in addTemplatesArray()", ex);
		}
		
		EntriesTable[i] = VolumeEntriesFactory.findEntryByEntryId(myDict, myVolume, Entries[i]);
	    }
        //where we must insert the form
        HTMLTableRowElement theRow = content.getElementTemplateRow();
        HTMLElement theHeadword = content.getElementHeadword();
        HTMLElement theId = content.getElementId();
        HTMLElement thePos = content.getElementPos();
        HTMLElement theTemplate = content.getElementTemplate();

        Node theRowParent = theRow.getParentNode();

        theRow.removeAttribute("id");
        theHeadword.removeAttribute("id");
        theId.removeAttribute("id");
        thePos.removeAttribute("id");
        theTemplate.removeAttribute("id");

        //adding the volumes description
	for ( int i = 0; i < EntriesTable.length; i++ ) {
	    String xmlcode = EntriesTable[i].getXmlCode();
	    String formula = "Formula";
	    
	    Document myDocument = Utility.buildDOMTree(xmlcode);

	    NodeList myNodeList = myDocument.getElementsByTagName("semantic-formula");

	    if ((myNodeList != null) && (myNodeList.getLength()>0)) {
		Element myElt = (Element) myNodeList.item(0);
		formula = Utility.NodeToString(myElt);
	    }
        content.setTextHeadword(EntriesTable[i].getHeadword());
        content.setTextId(EntriesTable[i].getId());
        content.setTextPos(EntriesTable[i].getPoss());
        content.setTextTemplate(formula);
                        
        theRowParent.appendChild(theRow.cloneNode(true));
	
        }
        
        theRowParent.removeChild(theRow);
    }

}
