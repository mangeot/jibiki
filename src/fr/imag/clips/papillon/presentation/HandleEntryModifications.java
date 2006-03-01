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
 * Revision 1.2  2006/03/01 15:47:08  mangeot
 * syntax bug fixes
 *
 * Revision 1.1  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 *-----------------------------------------------
 * Jibiki plate-form: handles entry modifications and redirect to the approriate page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

//import org.enhydra.xml.xmlc.XMLObject;
import org.enhydra.xml.xhtml.dom.*;
import org.w3c.dom.*;

import java.util.ArrayList;

// internal imports
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.dictionary.ContributionsFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.edition.UIGenerator;
import fr.imag.clips.papillon.business.edition.UITemplates;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.ResultPreProcessor;
import fr.imag.clips.papillon.business.transformation.ResultPreProcessorFactory;
import fr.imag.clips.papillon.business.transformation.ResultPostProcessor;
import fr.imag.clips.papillon.business.transformation.ResultPostProcessorFactory;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.user.User;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;


public class HandleEntryModifications extends EditingBasePO {
    
    public static String EntryHandle_PARAMETER = "EntryHandle";
    public static String VolumeName_PARAMETER = "VolumeName";  
	public static String Referrer_PARAMETER = "Referrer";
    public static String AddCall_PARAMETER = "AddCall";
    public static String DelCall_PARAMETER = "DelCall";
    public static String MoveUpCall_PARAMETER = "MoveUpCall";
    public static String MoveDownCall_PARAMETER = "MoveDownCall";
    public static String ChooseCall_PARAMETER = "ChooseCall";
	
    protected static String Choose_PARAMETER = UIGenerator.CHOOSE_ATTR_NAME;  
    protected static String Select_PARAMETER = UIGenerator.SELECT_ATTR_NAME;  
    protected static String Boolean_PARAMETER = UIGenerator.BOOLEAN_ATTR_NAME;  
    protected static String BooleanTrue_PARAMETER = UIGenerator.BOOLEAN_TRUE_ATTR_NAME;  
    protected static String Update_PARAMETER = "Update";  
    protected static String Save_PARAMETER = "Save";  
    protected static String SaveComment_PARAMETER = "SaveComment";  
	
	protected final static String EditEntryInitURL = "EditEntryInit.po";
    protected final static String EditingErrorURL = "EditingError.po";
    protected final static String ConfirmEntryURL = "ConfirmEntry.po";
	protected final static String EditEntryURL = "EditEntry.po";
	
	/* 	protected final static String newBlockRedirectionJavascript = "function loadFunction () {\n" */
	/* 		+ "   window.location.hash='NewBlock';\n" */
	/* 		+ "}\n"; */
	
	
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
			String submitAdd = myGetParameter(AddCall_PARAMETER);
			String submitDelete = myGetParameter(DelCall_PARAMETER);
			String submitMoveUp = myGetParameter(MoveUpCall_PARAMETER);
			String submitMoveDown = myGetParameter(MoveDownCall_PARAMETER);
			String submitChoose = myGetParameter(ChooseCall_PARAMETER);
			String submitUpdate = myGetParameter(Update_PARAMETER);
			String submitSave = myGetParameter(Save_PARAMETER);
			String select = myGetParameter(Select_PARAMETER);
			String choose = myGetParameter(Choose_PARAMETER);
			String volumeName = myGetParameter(VolumeName_PARAMETER);
			String entryHandle = myGetParameter(EntryHandle_PARAMETER);
			String saveComment = myGetParameter(SaveComment_PARAMETER);
			String referrer = myGetParameter(Referrer_PARAMETER);
			
			if (volumeName==null || volumeName.equals("") ||
				entryHandle==null || entryHandle.equals("")) {
				// FIXME: Add a user error message !!!
				throw new ClientPageRedirectException(EditEntryInitURL);
			}
			
			// VolumeEntry
			VolumeEntry myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName, entryHandle);
			
			// Verification 
			if (myVolumeEntry!=null && !myVolumeEntry.isEmpty()
				&& !(myVolumeEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) 
					 && myVolumeEntry.getModificationAuthor().equals(this.getUser().getLogin())) ) {
				// Error page
				throw new ClientPageRedirectException(EditingErrorURL);
			}
			
			// Get Element
			Element myEntry = myVolumeEntry.getDom().getDocumentElement();
			
			// Call PreProcessor
			// FIXME: Here ?
			// TO BO ADDED TO ENDITENTRYINIT
			//ResultPreProcessor preProcessor = ResultPreProcessorFactory.getPreProcessor(myVolumeEntry);
			//preProcessor.transformation(myVolumeEntry, this.getUser());
			
			Element myTemplateEntry = UITemplates.getTemplateEntry(volumeName);
			
			// updateElement update DOM structure
			if (myVolumeEntry!=null) {
				updateEntry(myEntry, this.getComms().request.getParameterNames());
			}
			
			// addElement
			if (submitAdd!=null && !submitAdd.equals("")) {
				int plus =  submitAdd.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
				if (plus > 0) {
					String elementName = submitAdd.substring(0,plus);
					String parentElement = submitAdd.substring(plus+1);
					String[] siblingElements = myGetParameterValues(Select_PARAMETER);
					UIGenerator.addElement(elementName, parentElement, myEntry, myTemplateEntry, siblingElements);
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
					UIGenerator.deleteElements(elementName, parentElement, selectedElements, myEntry, myTemplateEntry);
				}
			}
			// moveElementsUp
			else if (submitMoveUp!=null && !submitMoveUp.equals("")
					 && select != null && !select.equals("")) {
				int plus =  submitMoveUp.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
				if (plus > 0) {
					String elementName = submitMoveUp.substring(0,plus);
					String parentElement = submitMoveUp.substring(plus+1);
					String[] selectedElements = myGetParameterValues(Select_PARAMETER);
					UIGenerator.moveElementsUp(elementName, parentElement, selectedElements, myEntry);
				}
			}
			// move Elements Down
			else if (submitMoveDown!=null && !submitMoveDown.equals("")
					 && select != null && !select.equals("")) {
				int plus =  submitMoveDown.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
				if (plus > 0) {
					String elementName = submitMoveDown.substring(0,plus);
					String parentElement = submitMoveDown.substring(plus+1);
					String[] selectedElements = myGetParameterValues(Select_PARAMETER);
					UIGenerator.moveElementsDown(elementName, parentElement, selectedElements, myEntry);
				}
			}
			// Choose elements 
			else if (submitChoose!=null && !submitChoose.equals("")
					 && choose != null && !choose.equals("")) {
				int plus =  submitChoose.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
				if (plus > 0) {
					String elementId = submitChoose.substring(0,plus);
					String parentId = submitChoose.substring(plus+1);
					UIGenerator.chooseElement(choose,parentId,myEntry, myTemplateEntry);
				}
			}
			
			// saveModifiedEntry
			if (submitSave!=null && !submitSave.equals("")) {
				saveEntry(myVolumeEntry, this.getUser(), saveComment, referrer);
			} else {
				// Save draft and continue edition
				saveDraftEntry(myVolumeEntry, this.getUser().getLogin(), saveComment, this.getUser(), referrer);
			}
			return null;
		}
	
	
	protected void updateBooleanElements(String[] booleanElements, String[] trueElements, Element myEntry) {
		// FIXME: a problem here: the element ids change when one element is deleted.
		// the second element of the same type will not be deleted
		java.util.List myList = java.util.Arrays.asList(trueElements);
		for (int i=0; i<booleanElements.length;i++) {
			String elt = booleanElements[i];
			if (elt != null && !elt.equals("")) {
				if (myList.contains(elt)) {
					UIGenerator.updateElement(elt, "true", myEntry);
				}
				else {
					UIGenerator.updateElement(elt, "false", myEntry);
				}
			}
		}
	}
    
    protected void updateEntry(Element entryElt, java.util.Enumeration parameterNames)
		throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException {
            
            // Redirect parameters
            while (parameterNames.hasMoreElements()) {
                String parameterName = (String) parameterNames.nextElement();
                if (parameterName.indexOf(UIGenerator.ID_SEPARATOR)>0) {
                    UIGenerator.updateElement(parameterName, myGetParameter(parameterName), entryElt);
                }
            }
            updateBooleanElements(myGetParameterValues(Boolean_PARAMETER),myGetParameterValues(BooleanTrue_PARAMETER), entryElt);
        }
    
	
	
	protected void saveDraftEntry(VolumeEntry myVolumeEntry, String author, String saveComment, User user, String referrer)
		throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException {
			
            if ( myVolumeEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) ) {
                
                // Save new data
                myVolumeEntry.setStatus(VolumeEntry.CLASSIFIED_NOT_FINISHED_STATUS);
                myVolumeEntry.save();
                
                // Create Not_Finished
                VolumeEntry NFVolumeEntry = VolumeEntriesFactory.newEntryFromExisting(myVolumeEntry);
                NFVolumeEntry.setClassifiedNotFinishedContribution(myVolumeEntry);
                NFVolumeEntry.setModification(author, saveComment);
                NFVolumeEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
                NFVolumeEntry.save();
                
                // Call PostProcessor
                ResultPostProcessor postProcessor = ResultPostProcessorFactory.getPostProcessor(NFVolumeEntry);
                postProcessor.transformation(NFVolumeEntry, user);
                
                // new current volume entry
                throw new ClientPageRedirectException(
													  EditEntryURL + "?" + 
													  EditEntry.VolumeName_PARAMETER + "=" + NFVolumeEntry.getVolumeName() + "&" + 
													  EditEntry.EntryHandle_PARAMETER + "=" + NFVolumeEntry.getHandle() + "&" +
													  EditEntry.Referrer_PARAMETER + "=" + myUrlEncode(referrer));
                
            }
            
            throw new PapillonBusinessException("Error updating not finished contribution");
        }
	
    // referrer is not use !
	protected void saveEntry(VolumeEntry myVolumeEntry, User user, String saveComment, String referrer) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			String author = user.getLogin();
			
			// Save not finished contribution
			myVolumeEntry.setHeadword(myVolumeEntry.getCdmHeadword());
			myVolumeEntry.setModification(author,saveComment);
			myVolumeEntry.setStatus(VolumeEntry.FINISHED_STATUS);
			myVolumeEntry.save();
			//System.out.println("Save : myVolume = " + myVolumeEntry.getContributionId());
			
			String cfcid = myVolumeEntry.getClassifiedFinishedContributionId();
			if ( cfcid != null 
				 && !cfcid.equals("") ) {
				
				VolumeEntry classifiedVolumeEntry = VolumeEntriesFactory.findEntryByContributionId(myVolumeEntry.getVolumeName(), cfcid);
				
				classifiedVolumeEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
				classifiedVolumeEntry.save();
				//System.out.println("Save : classifiedVolumeE = " + classifiedVolumeEntry.getContributionId());
			}
			
			// FIXME: This shoudl be handled by a post processing class or something like this, still to be defined...
			// !!!!!!!!!!!! A DEPLACER EN POST PROCESS !!!!!!!!!!!!
			//myVolumeEntry.setFinished(this.getUser());
			//myVolumeEntry.setReviewed(this.getUser());
			//myVolumeEntry.setValidated(this.getUser());
			
			// Call PostProcessor
			ResultPostProcessor postProcessor = ResultPostProcessorFactory.getPostProcessor(myVolumeEntry);
			postProcessor.transformation(myVolumeEntry, user);
			
			throw new ClientPageRedirectException(
												  ConfirmEntryURL + "?" + 
												  EditEntry.VolumeName_PARAMETER + "=" + myVolumeEntry.getVolumeName() + "&" + 
												  EditEntry.EntryHandle_PARAMETER + "=" + myVolumeEntry.getHandle() + "&" +
												  EditEntry.Referrer_PARAMETER + "=" + myUrlEncode(referrer));
        }
	
}
