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
 * Revision 1.3  2004/10/28 10:43:36  mangeot
 * Fixed some bugs
 * Implemented the xsd:choice feature
 *
 * Revision 1.2  2004/09/20 15:12:36  mangeot
 * Bug corrections for the new UIGenerator
 * plus now able to deal with booleans
 *
 * Revision 1.1  2004/09/18 17:27:15  mangeot
 * It is a new version of the editor
 *
 *-----------------------------------------------
 * Papillon Login page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
//import com.lutris.appserver.server.httpPresentation.HttpPresentation;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

import java.util.ArrayList;

// internal imports
import fr.imag.clips.papillon.business.dictionary.Contribution;
import fr.imag.clips.papillon.business.dictionary.ContributionsFactory;
import fr.imag.clips.papillon.business.dictionary.IAnswerFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.edition.UIGenerator;
import fr.imag.clips.papillon.business.edition.UITemplates;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.Utility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EditEntry extends BasePO {
    
    public static String EntryHandle_PARAMETER = "EntryHandle";
    public static String Headword_PARAMETER = "Headword";
    public static String VolumeName_PARAMETER = "VolumeName";  
	
    protected static String AddCall_PARAMETER = "AddCall";
    protected static String DelCall_PARAMETER = "DelCall";
    protected static String ChooseCall_PARAMETER = "ChooseCall";
    protected static String Choose_PARAMETER = UIGenerator.CHOOSE_ATTR_NAME;  
    protected static String Select_PARAMETER = UIGenerator.SELECT_ATTR_NAME;  
    protected static String Boolean_PARAMETER = UIGenerator.BOOLEAN_ATTR_NAME;  
    protected static String Update_PARAMETER = "Update";  
    protected static String Save_PARAMETER = "Save";  
    protected static String SaveComment_PARAMETER = "SaveComment";  
	
	protected final static String EditEntryInitURL = "EditEntryInit.po";
	protected final static String ContributionsURL = "AdminContributions.po";
    protected final static String ContributionsVolumeParameter = "VOLUME";

	
    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean adminUserRequired() {
        return false;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public org.w3c.dom.Node getContent() 
		throws java.io.UnsupportedEncodingException, 
			HttpPresentationException {

        // Management of the paremeters
	    String submitAdd = myGetParameter(AddCall_PARAMETER);
	    String submitDelete = myGetParameter(DelCall_PARAMETER);
	    String submitChoose = myGetParameter(ChooseCall_PARAMETER);
	    String select = myGetParameter(Select_PARAMETER);
	    String choose = myGetParameter(Choose_PARAMETER);
	    String volumeName = myGetParameter(VolumeName_PARAMETER);
		String entryHandle = myGetParameter(EntryHandle_PARAMETER);
		String headword = myGetParameter(Headword_PARAMETER);
	    String submitUpdate = myGetParameter(Update_PARAMETER);
	    String submitSave = myGetParameter(Save_PARAMETER);
	    String saveComment = myGetParameter(SaveComment_PARAMETER);
		
		// Recuperation of parameters
		ArrayList languages = this.getSessionData().getUserAcceptLanguages();

		Element myEntry = null;
		VolumeEntry myVolumeEntry = null;
		if (volumeName!=null && !volumeName.equals("")
			&& entryHandle!=null &&!entryHandle.equals("")) {
			myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName,entryHandle);
			myEntry = Utility.buildDOMTree(myVolumeEntry.getXmlCode()).getDocumentElement();
		}
		// TODO answer if no arguments
		else {
			throw new ClientPageRedirectException(EditEntryInitURL);
		}
		Element myTemplateEntry = UITemplates.getTemplateEntry(volumeName);
		
		// if a new entry is created, we add the headword
		if (headword !=null && !headword.equals("")) {
			myVolumeEntry.getVolume().loadCDMElements();
			UIGenerator.updateElement(myVolumeEntry.getVolume().CDM_headword + UIGenerator.ID_SEPARATOR + "0",headword,myEntry);
		}
		
		// updateElement
		if (myVolumeEntry!=null) {
			updateEntry(myVolumeEntry, myEntry, this.getComms().request.getParameterNames());
		}
		
		// addElement
		if (submitAdd!=null && !submitAdd.equals("")) {
			int plus =  submitAdd.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
			if (plus > 0) {
				String selectedElement = submitAdd.substring(0,plus);
				String parentElement = submitAdd.substring(plus+1);
				UIGenerator.addElement(selectedElement,parentElement,myEntry, myTemplateEntry);
			}
		}
		// deleteElements MUST be after updateElement because it modifies the element ids.
		else if (submitDelete!=null && !submitDelete.equals("")
					&& select != null && !select.equals("")) {
			int plus =  submitDelete.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
			if (plus > 0) {
				String elementName = submitDelete.substring(0,plus);
				String parentElement = submitDelete.substring(plus+1);
				String[] selectedElements = myGetParameterValues(Select_PARAMETER);
				UIGenerator.deleteElements(elementName,selectedElements,myEntry);
			}
		}
		else if (submitChoose!=null && !submitChoose.equals("")
					&& choose != null && !choose.equals("")) {
			PapillonLogger.writeDebugMsg("Choose call: " + submitChoose + " " + choose);
			int plus =  submitChoose.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
			if (plus > 0) {
				String elementId = submitChoose.substring(0,plus);
				String parentId = submitChoose.substring(plus+1);
				PapillonLogger.writeDebugMsg("Choose call: " + parentId + " " + choose);
				UIGenerator.chooseElement(choose,parentId,myEntry, myTemplateEntry);
			}
		}
		
	// saveModifiedEntry
		if (submitSave!=null && !submitSave.equals("")) {
			saveEntry(myVolumeEntry, myEntry, this.getUser().getLogin(),saveComment);
		}

	// saveDOMModifications
		saveDOMModifications(myVolumeEntry, myEntry);
	
			// fill template
		Element myInterface = UITemplates.getInterface(volumeName, UITemplates.DEFAULT_FORM,languages); 
		Element myItfTemplate = null;	
		
		if (myInterface!=null) {
			myInterface = (Element) myInterface.cloneNode(true);
			myItfTemplate = (Element) myInterface.cloneNode(true);	
		}
		
	// add volume name & entry handle in the form	
		UIGenerator.setValueInput(myInterface, VolumeName_PARAMETER, volumeName);
		UIGenerator.setValueInput(myInterface, EntryHandle_PARAMETER, entryHandle);
				
	// fillInterfaceTemplate
		UIGenerator.fillInterfaceTemplate(myEntry,myInterface, myItfTemplate);

	//	System.out.println(Utility.NodeToString(myEntry));
	//	System.out.println(Utility.NodeToString(myInterface));
		
		return myInterface;
	}
	
	protected void updateBooleanElements(String[] elements, Element myEntry) {
	// FIXME: a problem here: the element ids change when one element is deleted.
	// the second element of the same type will not be deleted
		for (int i=0; i<elements.length;i++) {
			String elt = elements[i];
			if (elt != null) {
				UIGenerator.updateElement(elt, "true", myEntry);
			}
		}
	}

	
	protected void updateEntry(VolumeEntry myVolumeEntry, Element entryElt, java.util.Enumeration parameterNames)
		throws java.io.UnsupportedEncodingException,
				com.lutris.appserver.server.httpPresentation.HttpPresentationException {
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			if (parameterName.indexOf(UIGenerator.ID_SEPARATOR)>0) {
				UIGenerator.updateElement(parameterName,myGetParameter(parameterName),entryElt);
			}
		}
		updateBooleanElements(myGetParameterValues(Boolean_PARAMETER),entryElt);
	}
			
	protected void saveDOMModifications(VolumeEntry myVolumeEntry,  Element myDOMEntry) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Document myDOMDoc = myDOMEntry.getOwnerDocument();
		myVolumeEntry.extractDataFromDOM(myDOMDoc);
		myVolumeEntry.save();
		VolumeEntriesFactory.setGDEFFrenchTranslations(myVolumeEntry,myDOMDoc);		
	}
				
	protected void saveEntry(VolumeEntry myVolumeEntry, Element myDOMEntry, String author, String saveComment) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		if (myVolumeEntry!=null) {
			Document myDOMDoc = myDOMEntry.getOwnerDocument();
			IAnswerFactory.setModification(myVolumeEntry,myDOMDoc,author,saveComment);
			myVolumeEntry.extractDataFromDOM(myDOMDoc);
			myVolumeEntry.save();
			Contribution myContrib = ContributionsFactory.findContributionByEntryHandle(myVolumeEntry.getHandle());
			myContrib.setHeadword(myVolumeEntry.getHeadword());
			myContrib.setEntryId(myVolumeEntry.getId());
			myContrib.save();
		}
		throw new ClientPageRedirectException(ContributionsURL + "?" + ContributionsVolumeParameter + "=" + myVolumeEntry.getVolumeName());
	}
       
}
