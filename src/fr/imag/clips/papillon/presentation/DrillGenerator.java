/*
 * papillon 
 *
 * Enhydra super-servlet
 * 
 * © Mathieu Mangeot - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.4  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
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

import fr.imag.clips.papillon.presentation.xhtml.orig.*;


public class DrillGenerator extends BasePO {

    protected static String volumeName = "Papillon_fra";

    protected static String[] Entries = {"ABDIQUER.1","ACCUSER.1","COLLER.1","CRIER.1","REGRETTER.1"};

    protected static DrillGeneratorXHTML content;

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
        content = (DrillGeneratorXHTML)MultilingualXHtmlTemplateFactory.createTemplate("DrillGeneratorXHTML", this.getComms(), this.getSessionData());
                           
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
