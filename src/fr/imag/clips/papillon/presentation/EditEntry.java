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
 * Revision 1.33  2006/12/13 09:32:00  fbrunet
 * *** empty log message ***
 *
 * Revision 1.32  2006/11/09 09:04:42  fbrunet
 * *** empty log message ***
 *
 * Revision 1.31  2006/05/23 07:57:51  fbrunet
 * Modify edit management : When an user edit a lexie, this lexie doesn't change until an upgrade/finish action (then a new contibution is created link to lexie with a not-finished status).
 *
 * Revision 1.30  2006/04/18 14:30:24  fbrunet
 * Authorize admin to edit all entries
 *
 * Revision 1.29  2006/04/06 15:06:39  fbrunet
 * New class 'creationEditInit' : create new entry
 * Modify LexALPEditEntry : only edit entry
 *
 * Revision 1.28  2006/03/13 08:48:00  fbrunet
 * bug corrections before merge
 *
 * Revision 1.26  2006/03/01 15:41:13  mangeot
 * bug fixes
 *
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
import fr.imag.clips.papillon.business.user.Group;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;


public class EditEntry extends EditingBasePO {
    
    // Public parameters
    public static String VolumeName_PARAMETER = EditEntryXHTML.NAME_VolumeName;  
    public static String EntryHandle_PARAMETER = EditEntryXHTML.NAME_EntryHandle;
	public static String Referrer_PARAMETER = EditEntryXHTML.NAME_Referrer; 
	
    // URL
	protected final static String EditEntryInitURL = "LexalpEditEntryInit.po";
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
	    String volumeName = myGetParameter(EditEntryXHTML.NAME_VolumeName);
		String entryHandle = myGetParameter(EditEntryXHTML.NAME_EntryHandle);
	    String referrer = myGetParameter(EditEntryXHTML.NAME_Referrer);
        
		// Recuperation of parameters
		if (referrer== null || referrer.equals("")) {
			referrer = this.getReferrer();
		}
		
        //
		EditEntryXHTML content = (EditEntryXHTML) MultilingualXHtmlTemplateFactory.createTemplate("EditEntryXHTML", this.myComms, this.sessionData);

		// Manage VolumeEntry
		VolumeEntry myVolumeEntry = null;
		if (volumeName!=null && !volumeName.equals("")
			&& entryHandle!=null && !entryHandle.equals("")) {
			
			// VolumeEntry
			myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName, entryHandle);
			
            /*
			// Verification 
			if (myVolumeEntry!=null && !myVolumeEntry.isEmpty()
				&& !(myVolumeEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) 
					 && (myVolumeEntry.getModificationAuthor().equals(this.getUser().getLogin())
                        || this.getUser().isInGroup(Group.ADMIN_GROUP)) )) {
				throw new ClientPageRedirectException(EditingErrorURL);
			}
            */ 
             
			// Verification of the DOM
			if (myVolumeEntry.getDom() == null) {
                PapillonLogger.writeDebugMsg ("EditEntry : The dom entry is null.");
				throw new ClientPageRedirectException(EditingErrorURL);
			}
		}
		// TODO answer if no arguments
		else {
            PapillonLogger.writeDebugMsg ("EditEntry : No parameters (volumeName & entryHandle)");
			throw new ClientPageRedirectException(EditEntryInitURL);
		}
		
        // fill template
		Element myInterface = UITemplates.getInterface(volumeName, UITemplates.DEFAULT_FORM, this.getSessionData().getUserAcceptLanguages()); 
		Element myItfTemplate = null;	
		
		if (myInterface!=null) {
			myInterface = (Element) myInterface.cloneNode(true);
			myItfTemplate = (Element) myInterface.cloneNode(true);	
		}
		
        // Add volume name & entry handle in the form	
		//UIGenerator.setValueInput(myInterface, VolumeName_PARAMETER, volumeName);
		//UIGenerator.setValueInput(myInterface, EntryHandle_PARAMETER, entryHandle);
		//UIGenerator.setValueInput(myInterface, Referrer_PARAMETER, referrer);
        XHTMLInputElement VolumeNameElement = content.getElementVolumeName();
		VolumeNameElement.setValue(volumeName);
        XHTMLInputElement EntryHandleElement = content.getElementEntryHandle();
		EntryHandleElement.setValue(entryHandle);
        XHTMLInputElement ReferrerElement = content.getElementReferrer();
		ReferrerElement.setValue(referrer);
        
        // Disable undo update button if entry contribution have not old contribution
        /*String previousContributionId = myVolumeEntry.getClassifiedNotFinishedContributionId();
        if ((previousContributionId == null) || (previousContributionId.equals(""))) {
            XHTMLInputElement UndoUpdateElement = content.getElementUndoUpdate();
            UndoUpdateElement.setDisabled(true);	
        }*/
        
        // fillInterfaceTemplate
		UIGenerator.fillInterfaceTemplate(myVolumeEntry.getDom().getDocumentElement(), myInterface, myItfTemplate);
        
		//
		XHTMLElement editingInterfaceElement = content.getElementEditEntryContent();
		editingInterfaceElement.appendChild(content.importNode(myInterface, true));            
        
        //
		return content.getElementEditEntryForm();
        }   
}
