/*
 * papillon 
 *
 * Enhydra super-servlet
 * 
 * © Mathieu Mangeot & Jibiki team - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 *-----------------------------------------------
 * Lookup Volume page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import org.enhydra.xml.xmlc.XMLObject;

// Standard imports
import java.io.IOException;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

public class ConsultPage extends DilafBasePO {

	private ConsultPageXHTML content = null;
	private String volume = "";


    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean userMayUseThisPO() {
        return true;
    }

    protected  int getCurrentSection() {
        return NO_SECTION;
    }
	
    public org.w3c.dom.Node getContent() throws HttpPresentationException,
	java.io.IOException,
	ClassNotFoundException, fr.imag.clips.papillon.business.PapillonBusinessException 
	{
		String status = myGetParameter(ConsultPageXHTML.NAME_STATUS);
		volume = myGetParameter(ConsultPageXHTML.NAME_VOLUME);

        // Création du contenu
		content =
            (ConsultPageXHTML)MultilingualXHtmlTemplateFactory.createTemplate("ConsultPageXHTML", this.getComms(), this.getSessionData());

		org.enhydra.xml.xhtml.dom.XHTMLElement volumeLabel = content.getElementVolumeLabel();
		
			// Adding the volume list
			org.enhydra.xml.xhtml.dom.XHTMLSelectElement volumeSelect = content.getElementVOLUME();
			org.enhydra.xml.xhtml.dom.XHTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
			volumeOptionTemplate.removeAttribute("id");
			org.w3c.dom.Text volumeTextTemplate = (org.w3c.dom.Text)volumeOptionTemplate.getFirstChild();
			java.util.Collection AllVolumes = fr.imag.clips.papillon.business.dictionary.VolumesFactory.getVolumesArray();
			for (java.util.Iterator iter = AllVolumes.iterator(); iter.hasNext(); ) {
				fr.imag.clips.papillon.business.dictionary.Volume myVolume = (fr.imag.clips.papillon.business.dictionary.Volume)iter.next();
				volumeOptionTemplate.setValue(myVolume.getName());
				volumeOptionTemplate.setLabel(myVolume.getName());
				// Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
				// specs W3C.
				volumeTextTemplate.setData(myVolume.getName());
				if (myVolume.getName().equals(volume)) {
					volumeOptionTemplate.setAttribute("selected","selected");
				}
				else {
					volumeOptionTemplate.removeAttribute("selected");
				}
				volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
            }
			volumeSelect.removeChild(volumeOptionTemplate);
		
		if (status != null && !status.equals("")) {
			org.enhydra.xml.xhtml.dom.XHTMLInputElement statusInput = content.getElementSTATUS();
			statusInput.setValue(status);
		}
		//On rend le contenu correct
       return content.getElementMainContent();
    }
	
    public org.w3c.dom.Node getBannerContent() throws HttpPresentationException,
	java.io.IOException,
	ClassNotFoundException, fr.imag.clips.papillon.business.PapillonBusinessException 
	{
		//On rend le contenu correct
		org.enhydra.xml.xhtml.dom.XHTMLElement selectedVolume = (org.enhydra.xml.xhtml.dom.XHTMLElement) content.getElementById("Description_"+volume);
		if (selectedVolume!=null) {
			selectedVolume.setAttribute("style","display:block");
		}
		else {
			selectedVolume = (org.enhydra.xml.xhtml.dom.XHTMLElement) content.getElementById("Description_Default");
			if (selectedVolume!=null) {
				selectedVolume.setAttribute("style","display:block");
			}
		}
		org.w3c.dom.Node banner = content.getElementBannerContent();
		return banner;
		//return null;
    }

	public org.w3c.dom.Node getContextualMenuContent() throws HttpPresentationException,
	java.io.IOException,
	ClassNotFoundException, fr.imag.clips.papillon.business.PapillonBusinessException 
	{
		//On rend le contenu correct
		return content.getElementContextualMenuContent();
		//return null;
    }
	

}
