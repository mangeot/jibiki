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
 * Revision 1.2  2006/08/10 22:17:13  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 * Revision 1.1  2006/07/15 08:55:14  mangeot
 * The BrowseVolumePage opens an HTML form that is used to lookup a volume in alphabetical order.
 * The BrowseVolume is the server side of the AJAX script for retrieving the entries in alphabetical order
 *
 * Revision 1.4  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
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
 * Papillon Contacts page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import org.enhydra.xml.xmlc.XMLObject;

// Standard imports
import java.util.Collection;
import java.util.Iterator;
import java.io.IOException;

import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.presentation.xhtml.orig.*;

public class BrowseVolumePage extends PapillonBasePO {


    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean userMayUseThisPO() {
        return true;
    }

    protected  int getCurrentSection() {
        return NO_SECTION;
    }

	public org.w3c.dom.Node getContent() throws HttpPresentationException, IOException {
		org.w3c.dom.Node contentNode = null;
		return contentNode;
	}
	
	
    public org.w3c.dom.Node getDocument()
	throws HttpPresentationException, java.io.IOException, Exception {
//    public Node getContent()
//    throws HttpPresentationException, IOException {
		
		String status = myGetParameter(BrowseVolumePageXHTML.NAME_STATUS);
		String volume = myGetParameter(BrowseVolumePageXHTML.NAME_VOLUME);

        // Création du contenu
        BrowseVolumePageXHTML page =
            (BrowseVolumePageXHTML)MultilingualXHtmlTemplateFactory.createTemplate("BrowseVolumePageXHTML", this.getComms(), this.getSessionData());

		// Adding the volume list
		org.enhydra.xml.xhtml.dom.XHTMLSelectElement volumeSelect = page.getElementVOLUME();
		org.enhydra.xml.xhtml.dom.XHTMLOptionElement volumeOptionTemplate = page.getElementVolumeOptionTemplate();
		volumeOptionTemplate.removeAttribute("id");
		// We assume that the option element has only one text child
		// (it should be this way if the HTML is valid...)			
		org.w3c.dom.Text volumeTextTemplate = (org.w3c.dom.Text)volumeOptionTemplate.getFirstChild();
		
		if (volume!=null) {
			org.enhydra.xml.xhtml.dom.XHTMLElement volumeLabel = page.getElementVolumeLabel();
			volumeLabel.setAttribute("style","visibility:hidden");
			volumeOptionTemplate.setValue(volume);
			volumeOptionTemplate.setLabel(volume);
			volumeTextTemplate.setData(volume);
		}
		else {
			
            //
			for (Iterator iter = VolumesFactory.getVolumesArray().iterator(); iter.hasNext();) {
				Volume myVolume = (Volume)iter.next();
				volumeOptionTemplate.setValue(myVolume.getName());
				volumeOptionTemplate.setLabel(myVolume.getName());
				// Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
				// specs W3C.
				volumeTextTemplate.setData(myVolume.getName());
				volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
			}
			volumeSelect.removeChild(volumeOptionTemplate);
		}
		
		if (status != null && !status.equals("")) {
			org.enhydra.xml.xhtml.dom.XHTMLInputElement statusInput = page.getElementSTATUS();
			statusInput.setValue(status);
		}
		//On rend le contenu correct
       return (org.w3c.dom.Document) page;
    }

}
