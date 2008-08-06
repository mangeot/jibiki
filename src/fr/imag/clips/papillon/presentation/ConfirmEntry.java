/*
 * papillon 
 *
 * Enhydra super-servlet
 * 
 * © Francis Brunet-Manquat, Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.9  2007/02/09 08:49:10  fbrunet
 * *** empty log message ***
 *
 * Revision 1.8  2007/02/07 13:58:57  fbrunet
 * added message before axies are merged and undo process if the merge is not correct.
 *
 * Revision 1.7  2007/01/08 15:13:42  fbrunet
 * Correction of th xml attribut bug in ContributionHeader (VolumeEntry class)
 *
 * Revision 1.6  2006/08/10 22:17:13  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 * Revision 1.5  2006/06/01 22:05:05  fbrunet
 * New interface, quick search, new contribution management (the first edition not create new contribution. New contribution is created after add, remove element, update, save, etc. in the interface window)
 *
 * Revision 1.4  2006/05/22 22:45:54  fbrunet
 * LexALP: add merge method in post-save processing (merge axies with same referenced lexies)
 *
 * Revision 1.3  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
 * Revision 1.2  2006/03/01 15:41:13  mangeot
 * bug fixes
 *
 * Revision 1.1  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.presentation;

//
import java.util.Iterator;
import java.util.Collection;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

//import org.enhydra.xml.xmlc.XMLObject;
import org.enhydra.xml.xhtml.dom.*;
import org.w3c.dom.*;

// internal imports
import fr.imag.clips.papillon.business.dictionary.ParseVolume;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.presentation.xhtml.orig.*;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;



public class ConfirmEntry extends EditingBasePO {
    
    //
    private final boolean DEBUG = true;
    
    //
    public static String EntryHandle_PARAMETER = EditEntry.EntryHandle_PARAMETER;
    public static String VolumeName_PARAMETER = EditEntry.VolumeName_PARAMETER;  
    public static String Message_PARAMETER = "message";
    public static String Button_PARAMETER = "button";
    
    //
    protected final static String EditEntryURL = "EditEntry.po";
    public static String EditingErrorURL = EditEntry.EditingErrorURL; 
	
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
			
            //
            if (DEBUG) PapillonLogger.writeDebugMsg ("ConfirmEntry : getContent");   
            
			// Management of the parameters
			String volumeName = myGetParameter(VolumeName_PARAMETER);
			String entryHandle = myGetParameter(EntryHandle_PARAMETER);
            String message = myGetParameter(Message_PARAMETER);
            String button = myGetParameter(Button_PARAMETER);
			
			// Manage VolumeEntry
			VolumeEntry myVolumeEntry = null;
			if (volumeName!=null && !volumeName.equals("")
				&& entryHandle!=null && !entryHandle.equals("")) {
                
				// VolumeEntry
				myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName, entryHandle);
                if (DEBUG) {
                    PapillonLogger.writeDebugMsg ("ConfirmEntry : Contribution ID " + myVolumeEntry.getContributionId());
                    Collection collection = myVolumeEntry.getClassifiedFinishedContributionIdCollection();
                    for (Iterator iter = collection.iterator(); iter.hasNext();) {
                        PapillonLogger.writeDebugMsg ("ConfirmEntry : Previous ID " + (String)iter.next());
                    }
                }
                
				// Verification 
				if ( !(myVolumeEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) 
					   && myVolumeEntry.getModificationAuthor().equals(this.getUser().getLogin())) ) {
					
					// Error page
					throw new ClientPageRedirectException(EditingErrorURL);
				}
				
				// adding author groups in entry
				myVolumeEntry.setGroups(Utility.ArrayUnion(myVolumeEntry.getGroups(),this.getUser().getGroupsArray()));
				myVolumeEntry.save();
				
			}
			
			//
			ConfirmEntryXHTML content = (ConfirmEntryXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ConfirmEntryXHTML", this.myComms, this.sessionData);
            
			//
			QueryResult qr = new QueryResult(1, myVolumeEntry);
			ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, null, ResultFormatterFactory.XHTML_DIALECT, null);
			Element resultElement = (Element)rf.getFormattedResult(qr, this.getUser());
			
			//
			XHTMLDivElement editingResultViewElement = content.getElementEditingResultView();
			editingResultViewElement.appendChild(content.importNode(resultElement, true));
            
            // Message
            if (message!=null) {
                content.setTextMessage(message);
            }
            
            //
            // ACTION
			// undo, redit ...
            
            // Re-edit button 
            //XHTMLElement reEditForm = content.getElementReEditForm();
            //reEditForm.setAttribute("action", EditEntryURL);
            //reEditForm.removeAttribute("id");
            XHTMLElement value1 = content.getElementValue1();
            value1.setAttribute("name", LaunchAction.VOLUME_NAME_PARAMETER);
            value1.setAttribute("value", myVolumeEntry.getVolumeName());
            value1.removeAttribute("id");
            XHTMLElement value2 = content.getElementValue2();
            value2.setAttribute("name", LaunchAction.HANDLE_PARAMETER);
            value2.setAttribute("value", myVolumeEntry.getHandle());
            value2.removeAttribute("id");
            
			//
			return content.getElementConfirmEntryContent();
		}
}
