/*
 * Jibiki 
 *
 * Enhydra super-servlet
 * 
 * © Francis Brunet-Manquat, Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.12  2006/12/14 20:03:26  fbrunet
 * Add method to normalize value into XML structure.
 *
 * Revision 1.11  2006/12/13 09:32:00  fbrunet
 * *** empty log message ***
 *
 * Revision 1.10  2006/11/09 09:04:42  fbrunet
 * *** empty log message ***
 *
 * Revision 1.9  2006/05/23 07:57:51  fbrunet
 * Modify edit management : When an user edit a lexie, this lexie doesn't change until an upgrade/finish action (then a new contibution is created link to lexie with a not-finished status).
 *
 * Revision 1.8  2006/05/22 22:45:54  fbrunet
 * LexALP: add merge method in post-save processing (merge axies with same referenced lexies)
 *
 * Revision 1.7  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
 * Revision 1.6  2006/04/24 13:43:29  fbrunet
 * Add new class ViewQueryResult : allow to use one class to create result display in advancedSearch and EditEntryInit (like advancedQueryForm)
 * Improve result display : view n results per page
 *
 * Revision 1.5  2006/04/18 14:30:24  fbrunet
 * Authorize admin to edit all entries
 *
 * Revision 1.4  2006/04/06 15:06:39  fbrunet
 * New class 'creationEditInit' : create new entry
 * Modify LexALPEditEntry : only edit entry
 *
 * Revision 1.3  2006/03/13 08:48:00  fbrunet
 * bug corrections before merge
 *
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

// Internal imports
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.dictionary.ContributionsFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.edition.UIGenerator;
import fr.imag.clips.papillon.business.edition.UITemplates;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.ResultPreProcessor;
import fr.imag.clips.papillon.business.transformation.ResultPreProcessorFactory;
import fr.imag.clips.papillon.business.transformation.ResultPostSaveProcessor;
import fr.imag.clips.papillon.business.transformation.ResultPostSaveProcessorFactory;
import fr.imag.clips.papillon.business.transformation.ResultPostUpdateProcessor;
import fr.imag.clips.papillon.business.transformation.ResultPostUpdateProcessorFactory;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;
import fr.imag.clips.papillon.presentation.ConfirmEntry;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.user.Group;

// Dom imports
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class HandleEntryModifications extends EditingBasePO {
    
    // Public parameters
    public static String EntryHandle_PARAMETER = "EntryHandle";
    public static String VolumeName_PARAMETER = "VolumeName";  
	public static String Referrer_PARAMETER = "Referrer";
    public static String AddCall_PARAMETER = "AddCall";
    public static String DelCall_PARAMETER = "DelCall";
    public static String MoveUpCall_PARAMETER = "MoveUpCall";
    public static String MoveDownCall_PARAMETER = "MoveDownCall";
    public static String ChooseCall_PARAMETER = "ChooseCall";
    public static String Update_PARAMETER = "Update";  
    public static String Save_PARAMETER = "Save"; 
    public static String UndoUpdate_PARAMETER = "UndoUpdate";  
    //public static String SaveComment_PARAMETER = "SaveComment";  
    
    // Protected parameters
    protected static String Choose_PARAMETER = UIGenerator.CHOOSE_ATTR_NAME;  
    protected static String Select_PARAMETER = UIGenerator.SELECT_ATTR_NAME;  
    protected static String Boolean_PARAMETER = UIGenerator.BOOLEAN_ATTR_NAME;  
    protected static String BooleanTrue_PARAMETER = UIGenerator.BOOLEAN_TRUE_ATTR_NAME;  
	
    // URL
	protected final static String EditEntryInitURL = "LexalpEditEntryInit.po";
    protected final static String EditingErrorURL = "EditingError.po";
    protected final static String ConfirmEntryURL = "ConfirmEntry.po";
	protected final static String EditEntryURL = "EditEntry.po";
	
    //
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
            String submitUndoUpdate = myGetParameter(UndoUpdate_PARAMETER);
			String select = myGetParameter(Select_PARAMETER);
			String choose = myGetParameter(Choose_PARAMETER);
			String volumeName = myGetParameter(VolumeName_PARAMETER);
			String entryHandle = myGetParameter(EntryHandle_PARAMETER);
			//String saveComment = myGetParameter(SaveComment_PARAMETER);
			String referrer = myGetParameter(Referrer_PARAMETER);
			
            //
			if (volumeName==null || volumeName.equals("") ||
				entryHandle==null || entryHandle.equals("")) {
				                
                // FIXME: Add a user error message !!!
				throw new ClientPageRedirectException(EditEntryInitURL);
			}
		
			// Find VolumeEntry
			VolumeEntry myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName, entryHandle);
			
			// Entry verification
            // FIXME : Modifier sa localisation !!!
            if ( myVolumeEntry!=null && !myVolumeEntry.isEmpty()
                 && myVolumeEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
                // If entry is finished, create draft !
                
                // Create draft : new contribution with NOT_FINISHED_STATUS
                VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myVolumeEntry);
                newEntry.setClassifiedFinishedContribution(myVolumeEntry);
                newEntry.setModification(this.getUser().getLogin(), "edit");
                newEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
                newEntry.save();
                
                // Old entry modification
                myVolumeEntry.setStatus(VolumeEntry.MODIFIED_STATUS);
                myVolumeEntry.setNextContributionAuthor(this.getUser().getLogin());
                myVolumeEntry.save();
                
                //
                myVolumeEntry = newEntry;
            
            } else if (myVolumeEntry!=null && !myVolumeEntry.isEmpty()
                       && !(myVolumeEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) 
                            && (myVolumeEntry.getModificationAuthor().equals(this.getUser().getLogin())
                                || this.getUser().isInGroup(Group.ADMIN_GROUP))) ) {
                
                // Error page redirection
                PapillonLogger.writeDebugMsg("HandleEntryModification : status = " + myVolumeEntry.getStatus() + " modification author = " + myVolumeEntry.getModificationAuthor());
                PapillonLogger.writeDebugMsg("HandleEntryModification : Error entry is not NOT_FINISHED_STATUS and (same user or admin user)");
				throw new ClientPageRedirectException(EditingErrorURL);
			}
			
			// Call PreProcessor
			// FIXME: Here ? TO BE ADDED TO ENDITENTRYINIT
			//ResultPreProcessor preProcessor = ResultPreProcessorFactory.getPreProcessor(myVolumeEntry);
			//preProcessor.transformation(myVolumeEntry, this.getUser());
			
            // Get document element
			Element myEntry = myVolumeEntry.getDom().getDocumentElement();
            
            // Get template entry
			Element myTemplateEntry = UITemplates.getTemplateEntry(volumeName);
			
			// Fill DOM structure
			if (myVolumeEntry!=null) {
				FillDOMStructure(myEntry, this.getComms().request.getParameterNames());
			}
			
			// Add element
			if (submitAdd!=null && !submitAdd.equals("")) {
				int plus =  submitAdd.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
				if (plus > 0) {
					String elementName = submitAdd.substring(0,plus);
					String parentElement = submitAdd.substring(plus+1);
					String[] siblingElements = myGetParameterValues(Select_PARAMETER);
					UIGenerator.addElement(elementName, parentElement, myEntry, myTemplateEntry, siblingElements);
				}
			}
			// Delete elements (MUST be after updateElement because it modifies the element ids.)
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
			// Move elements up
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
			// Move elements Down
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
			
			//
			if (submitUndoUpdate!=null && !submitUndoUpdate.equals("")) {
				// Undo draft
                undoDraftEntry(myVolumeEntry, this.getUser(), referrer);
			
            } else if (submitSave!=null && !submitSave.equals("")) {
				// Save and finish edition
                saveEntry(myVolumeEntry, this.getUser(), referrer);
			
            } else {
				// Save draft and continue edition
				saveDraftEntry(myVolumeEntry, this.getUser().getLogin(), this.getUser(), referrer);
			}
			
        return null;
    }
	
	//
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
    
    //
    protected void FillDOMStructure(Element entryElt, java.util.Enumeration parameterNames)
		throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException {
            
            // Redirect parameters
            while (parameterNames.hasMoreElements()) {
                String parameterName = (String) parameterNames.nextElement();
                if (parameterName.indexOf(UIGenerator.ID_SEPARATOR)>0) {
                    UIGenerator.updateElement(parameterName, myGetParameter(parameterName), entryElt);
                }
            }
            
            //
            updateBooleanElements(myGetParameterValues(Boolean_PARAMETER),myGetParameterValues(BooleanTrue_PARAMETER), entryElt);
        }
	
	//
	protected void saveDraftEntry(VolumeEntry myVolumeEntry, String author, User user, String referrer)
		throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException {
			
            if ( myVolumeEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) ) {
                
                // Save new data
                myVolumeEntry.setStatus(VolumeEntry.CLASSIFIED_NOT_FINISHED_STATUS);
                myVolumeEntry.save();
                
                // Create Not_Finished
                VolumeEntry NFVolumeEntry = VolumeEntriesFactory.newEntryFromExisting(myVolumeEntry);
                NFVolumeEntry.setHeadword(myVolumeEntry.getCdmHeadword());
                NFVolumeEntry.setClassifiedNotFinishedContribution(myVolumeEntry);
                NFVolumeEntry.setModification(author, "update");
                NFVolumeEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
                NFVolumeEntry.save();
                
                //
                //System.out.println("myVolumeEntry CId" + myVolumeEntry.getContributionId() + "-> NFVolumeEntry CId : " + NFVolumeEntry.getContributionId());
                
                // Call PostProcessor
                // FIXME: call specific update PostProcessor !
                ResultPostUpdateProcessor postUpdateProcessor = ResultPostUpdateProcessorFactory.getPostUpdateProcessor(NFVolumeEntry);
                postUpdateProcessor.transformation(NFVolumeEntry, user);
                
                // New current volume entry
                throw new ClientPageRedirectException(
													  EditEntryURL + "?" + 
													  EditEntry.VolumeName_PARAMETER + "=" + NFVolumeEntry.getVolumeName() + "&" + 
													  EditEntry.EntryHandle_PARAMETER + "=" + NFVolumeEntry.getHandle() + "&" +
													  EditEntry.Referrer_PARAMETER + "=" + myUrlEncode(referrer));
                
            }
            
            throw new PapillonBusinessException("Error updating not finished contribution");
        }
	
    //
	protected void saveEntry(VolumeEntry myVolumeEntry, User user, String referrer) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			String author = user.getLogin();
			
            // FIXME: if not change, no new contribution !
            
			// Save not finished contribution
			myVolumeEntry.setHeadword(myVolumeEntry.getCdmHeadword());
			myVolumeEntry.setModification(author, "finish");
			myVolumeEntry.setStatus(VolumeEntry.FINISHED_STATUS);
			myVolumeEntry.save();
			
            //
			String cfcid = myVolumeEntry.getClassifiedFinishedContributionId();
			if ( cfcid != null 
				 && !cfcid.equals("") ) {
				
				VolumeEntry classifiedVolumeEntry = VolumeEntriesFactory.findEntryByContributionId(myVolumeEntry.getVolumeName(), cfcid);
				
				classifiedVolumeEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
				classifiedVolumeEntry.save();
			}
            
            // FIXME: This shoudl be handled by a post processing class or something like this, still to be defined...
			// !!!!!!!!!!!! A DEPLACER EN POST PROCESS !!!!!!!!!!!!
			//myVolumeEntry.setFinished(this.getUser());
			//myVolumeEntry.setReviewed(this.getUser());
			//myVolumeEntry.setValidated(this.getUser());
			
			// Call PostProcessor
			ResultPostSaveProcessor postSaveProcessor = ResultPostSaveProcessorFactory.getPostSaveProcessor(myVolumeEntry);
			postSaveProcessor.transformation(myVolumeEntry, this.getUser());
            
            //
            // Referer is not use !
			throw new ClientPageRedirectException(
												  ConfirmEntryURL + "?" + 
												  ConfirmEntry.VolumeName_PARAMETER + "=" + myVolumeEntry.getVolumeName() + "&" + 
												  ConfirmEntry.EntryHandle_PARAMETER + "=" + myVolumeEntry.getHandle());
        }
    
    //
	protected void undoDraftEntry(VolumeEntry myVolumeEntry, User user, String referrer) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
            /*
            // TEST
            String previousContributionId = myVolumeEntry.getClassifiedNotFinishedContributionId();
            while ((previousContributionId != null) && (!previousContributionId.equals(""))) {
                System.out.println("previousContributionId : " + previousContributionId);
                
                //
                VolumeEntry previousEntry = VolumeEntriesFactory.findEntryByContributionId(myVolumeEntry.getVolume().getName(), previousContributionId);
                previousContributionId = previousEntry.getClassifiedNotFinishedContributionId();
            }
            */
            
            //
            String previousContributionId = myVolumeEntry.getClassifiedNotFinishedContributionId();
            if ((previousContributionId != null) && (!previousContributionId.equals(""))) {
            
                //
                VolumeEntry previousEntry = VolumeEntriesFactory.findEntryByContributionId(myVolumeEntry.getVolume().getName(), previousContributionId);
                previousEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
				previousEntry.save(); 
                
                // Delete contribution
                myVolumeEntry.delete();
        
                // new current volume entry
                throw new ClientPageRedirectException(
                                                      EditEntryURL + "?" + 
                                                      EditEntry.VolumeName_PARAMETER + "=" + previousEntry.getVolumeName() + "&" + 
                                                      EditEntry.EntryHandle_PARAMETER + "=" + previousEntry.getHandle() + "&" +
                                                      EditEntry.Referrer_PARAMETER + "=" + myUrlEncode(referrer));
                
                
            }  else {
                
                // Error page
                PapillonLogger.writeDebugMsg("HandleEntryModification : Error undoDraftEntry method");
                throw new ClientPageRedirectException(EditingErrorURL);
            }
    
        }
    
	
}
