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
 * Revision 1.25  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 *
 *-----------------------------------------------
 * Papillon Login page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

//import org.enhydra.xml.xmlc.XMLObject;
import org.enhydra.xml.xhtml.dom.*;
import org.w3c.dom.Element;

// internal imports
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.edition.UIGenerator;
import fr.imag.clips.papillon.business.edition.UITemplates;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.user.User;


import fr.imag.clips.papillon.presentation.xhtml.orig.*;


public class EditEntry extends EditingBasePO {
    
    public static String EntryHandle_PARAMETER = "EntryHandle";
    public static String VolumeName_PARAMETER = "VolumeName";  
	public static String Referrer_PARAMETER = "Referrer";
		
	protected final static String EditEntryInitURL = "EditEntryInit.po";
    protected final static String EditingErrorURL = "EditingError.po";
		
    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean userMayUseThisPO() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public org.w3c.dom.Node getContent() 
		throws java.io.UnsupportedEncodingException, 
			HttpPresentationException {

        // Management of the parameters
	    String volumeName = myGetParameter(VolumeName_PARAMETER);
		String entryHandle = myGetParameter(EntryHandle_PARAMETER);
	    String referrer = myGetParameter(Referrer_PARAMETER);
				
		// Recuperation of parameters
		if (referrer== null || referrer.equals("")) {
			referrer = this.getReferrer();
		}
		
		EditEntryXHTML content = (EditEntryXHTML) MultilingualXHtmlTemplateFactory.createTemplate("EditEntryXHTML", this.myComms, this.sessionData);

		// Manage VolumeEntry
		VolumeEntry myVolumeEntry = null;
		if (volumeName!=null && !volumeName.equals("")
			&& entryHandle!=null &&!entryHandle.equals("")) {
			
			// VolumeEntry
			myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName, entryHandle);
			
			// Verification 
			if (myVolumeEntry!=null && !myVolumeEntry.isEmpty()
				&& !(myVolumeEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) 
					 && myVolumeEntry.getModificationAuthor().equals(this.getUser().getLogin())) ) {
				throw new ClientPageRedirectException(EditingErrorURL);
			}
			// Verification of the DOM
			if (myVolumeEntry.getDom() == null) {
				throw new ClientPageRedirectException(EditingErrorURL);
			}
		}
		// TODO answer if no arguments
		else {
			throw new ClientPageRedirectException(EditEntryInitURL);
		}
		Element myTemplateEntry = UITemplates.getTemplateEntry(volumeName);
		
			// fill template
		Element myInterface = UITemplates.getInterface(volumeName, UITemplates.DEFAULT_FORM,this.getSessionData().getUserAcceptLanguages()); 
		Element myItfTemplate = null;	
		
		if (myInterface!=null) {
			myInterface = (Element) myInterface.cloneNode(true);
			myItfTemplate = (Element) myInterface.cloneNode(true);	
		}
		
	// add volume name & entry handle in the form	
		UIGenerator.setValueInput(myInterface, VolumeName_PARAMETER, volumeName);
		UIGenerator.setValueInput(myInterface, EntryHandle_PARAMETER, entryHandle);
		UIGenerator.setValueInput(myInterface, Referrer_PARAMETER, referrer);
		
				
	// fillInterfaceTemplate
		UIGenerator.fillInterfaceTemplate(myVolumeEntry.getDom().getDocumentElement(),myInterface, myItfTemplate);
		                
		//
		XHTMLElement editingInterfaceElement = content.getElementEditingInterface();
		editingInterfaceElement.appendChild(content.importNode(myInterface, true));            

		return content.getElementEditEntryContent();
        }   
}
