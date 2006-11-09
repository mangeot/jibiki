/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 * © Francis Brunet-Manquat - GETA CLIPS IMAG
 * Projet Papillon
 *
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.8  2006/11/09 09:04:42  fbrunet
 * *** empty log message ***
 *
 * Revision 1.7  2006/06/19 15:27:01  fbrunet
 * Jibiki : improvement of the search result display
 * Lexalp : add help menu (link to wiki and bug tracker)
 *
 * Revision 1.6  2006/05/23 07:57:51  fbrunet
 * Modify edit management : When an user edit a lexie, this lexie doesn't change until an upgrade/finish action (then a new contibution is created link to lexie with a not-finished status).
 *
 * Revision 1.5  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
 * Revision 1.4  2006/04/24 13:50:37  fbrunet
 * *** empty log message ***
 *
 * Revision 1.3  2006/04/24 13:43:29  fbrunet
 * Add new class ViewQueryResult : allow to use one class to create result display in advancedSearch and EditEntryInit (like advancedQueryForm)
 * Improve result display : view n results per page
 *
 * Revision 1.2  2006/04/18 14:30:24  fbrunet
 * Authorize admin to edit all entries
 *
 * Revision 1.1  2006/04/06 15:06:39  fbrunet
 * New class 'creationEditInit' : create new entry
 * Modify LexALPEditEntry : only edit entry
 *
 *
 */ 

package fr.imag.clips.papillon.presentation;

//General java imports
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Hashtable;

// DOM imports
import org.w3c.dom.html.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.enhydra.xml.xhtml.dom.*;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

//local imports
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;
import fr.imag.clips.papillon.business.dictionary.QueryParameter;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.user.Group;
import fr.imag.clips.papillon.presentation.EditEntry;



public class EditEntryInitFactory {

    //
    protected final static String EditEntryURL = "EditEntry.po";
    protected final static String EditingErrorURL = "EditingError.po";
    
    // URL parameters
    protected final static String HANDLE_PARAMETER = "handle";
    protected final static String FORMATTER_PARAMETER = "formatter";
    protected final static String ACTION_PARAMETER = "action";
    protected final static String VOLUME_PARAMETER = "VOLUME";
    protected final static String VOLUME_ANYWAY_PARAMETER = "volumeanyway";
    protected final static String HEADWORD_ANYWAY_PARAMETER = "headwordanyway";
    
    /*
    // Key for contentParameters hastable (addEntriesTable method)
    protected final static String entryNode = "entryNode";
    protected final static String entryListRow = "entryListRow";
    protected final static String authorElement = "authorElement";
    protected final static String editAnchor = "editAnchor";
    protected final static String duplicateAnchor = "duplicateAnchor";
    protected final static String deleteAnchor = "deleteAnchor";
    protected final static String undeleteAnchor = "undeleteAnchor";
    protected final static String ViewHistoryEntryAnchor = "ViewHistoryEntryAnchor";
    protected final static String viewXmlAnchor = "viewXmlAnchor";
    protected final static String underEdition = "underEdition";
    protected final static String proceedEdition = "proceedEdition";
    */
    
    /**
    * The createEntry method create a not finished entry and redirect to edition interface
     * 
     * @param String volumeName
     * @param String headword
     * @param User user
     *
     */    
    protected static void createEntry(String volumeName, String headword, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        VolumeEntry myEntry = VolumeEntriesFactory.createEmptyEntry(volumeName);
        myEntry.setCreationDate();
        myEntry.setHeadword(headword);
        myEntry.setAuthor(user.getLogin());
        myEntry.setModification(user.getLogin(), "create");
        myEntry.setGroups(user.getGroupsArray());
        myEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
        myEntry.save();
        
        //
        throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                              EditEntry.VolumeName_PARAMETER + "=" + volumeName + 
                                              "&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
    }
    
    
    /**
     * The editEntry method edit a finished or a not finished entry and redirect to edition interface
     * if finished entry, we create a new not finished contribution to represent entry and link its contribution to last finished contribution of the entry.
     * if not finished entry, we edit it. 
     *
     * @param VolumeEntry
     * @param User
     *
     */    
    protected static void editEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        // Nothing to do
        throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                              EditEntry.VolumeName_PARAMETER + "=" + myEntry.getVolumeName() + 
                                              "&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
         /*   
        // Edit contribution finished
        if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
            
            // Create new contribution with NOT_FINISHED_STATUS
            VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
            newEntry.setClassifiedFinishedContribution(myEntry);
            newEntry.setModification(user.getLogin(), "edit");
            newEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
            newEntry.save();
            
            // Old entry modification
            myEntry.setStatus(VolumeEntry.MODIFIED_STATUS);
            myEntry.setNextContributionAuthor(user.getLogin());
            myEntry.save();
            
            //
            throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                  EditEntry.VolumeName_PARAMETER + "=" + newEntry.getVolumeName() + 
                                                  "&" + EditEntry.EntryHandle_PARAMETER + "=" + newEntry.getHandle());
            
        // Edit contribtion not-finished
        } else if ( myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) 
                    && 
                       (myEntry.getModificationAuthor().equals(user.getLogin()) 
                        || user.isInGroup(Group.ADMIN_GROUP))) {
            
            // Nothing to do
            throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                  EditEntry.VolumeName_PARAMETER + "=" + myEntry.getVolumeName() + 
                                                  "&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
            
        }  else {
            
            // Error page
            throw new ClientPageRedirectException(EditingErrorURL);
        }
            */
    }
    
    
    /**
     * The duplicateEntry method duplicate a finished entry A to new entry B (without history of entry A) and redirect entry B to edition interface
     *
     * @param VolumeEntry
     * @param User
     *
     */    
    protected static void duplicateEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
            
            // Create contribution base on myEntry, history not copied !
            VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
            newEntry.setEntryId();
            newEntry.setAuthor(user.getLogin());
            newEntry.setGroups(user.getGroupsArray());
            newEntry.setContributionId();
            newEntry.setOriginalContributionId(myEntry.getContributionId());
            newEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
            newEntry.setModification(user.getLogin(), "duplicate");
            newEntry.setClassifiedFinishedContribution();
            newEntry.setClassifiedNotFinishedContribution();
            newEntry.setNextContributionAuthor("");
            newEntry.save();
            
            //
            throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                  EditEntry.VolumeName_PARAMETER + "=" + newEntry.getVolumeName() + 
                                                  "&" + EditEntry.EntryHandle_PARAMETER + "=" + newEntry.getHandle());
        }  else {
            
            // Error page
            throw new ClientPageRedirectException(EditingErrorURL);
        }
    }
    
    
    /**
     * The deleteEntry method delete a finished entry.
     * if finished entry, we create a new deleted contribution to represent entry and link its contribution to last finished contribution of the entry.
     *
     * @param VolumeEntry
     * @param User
     *
     */    
    protected static void deleteEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
             
            // Create contribution base on myEntry with status Delete !
            VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
            newEntry.setClassifiedFinishedContribution(myEntry);
            newEntry.setClassifiedNotFinishedContribution();
            newEntry.setModification(user.getLogin(), "delete");
            newEntry.setStatus(VolumeEntry.DELETED_STATUS);
            newEntry.save();
            
            // Change myEntry status
            myEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
            myEntry.save();
            
            
        } else if (myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) && myEntry.getModificationAuthor().equals(user.getLogin())) {
            
            //
            String lastFinishEntryId = myEntry.getClassifiedFinishedContributionId(); 
            if ((lastFinishEntryId != null) && (!lastFinishEntryId.equals(""))) {
                
                // Change status of last finish contribution
                VolumeEntry lastFinishEntry = VolumeEntriesFactory.findEntryByEntryId(user, myEntry.getVolume(), lastFinishEntryId);
                lastFinishEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);  // MODIFIED_STATUS -> CLASSIFIED_FINISHED_STATUS
                lastFinishEntry.save();
            }
            
            // Create contribution base on myEntry with status Delete !
            VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
            if (lastFinishEntryId != null) newEntry.setClassifiedFinishedContribution(lastFinishEntryId);
            newEntry.setClassifiedNotFinishedContribution(myEntry);
            newEntry.setModification(user.getLogin(), "delete");
            newEntry.setStatus(VolumeEntry.DELETED_STATUS);
            newEntry.save();
            
            // Change myEntry status
            myEntry.setStatus(VolumeEntry.CLASSIFIED_NOT_FINISHED_STATUS);
            myEntry.save();
            
        }  else {
            
            // Error message
            //this.getSessionData().writeUserMessage("Error deleting " + myEntry.getId());
            
            // Error page
            throw new ClientPageRedirectException(EditingErrorURL);
        }
    }   
    
    
    /**
     * The undeleteEntry method undelete a deleted entry.
     * if deleted entry, we create a new finished contribution to represent entry and link its contribution to last deleted contribution of the entry.
     *
     * @param VolumeEntry
     * @param User
     *
     */    
    protected static void undeleteEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        if ( myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
            
            // Change status previous contribution of myEntry
            VolumeEntry previousEntry = VolumeEntriesFactory.findEntryByEntryId(user, myEntry.getVolume(), myEntry.getClassifiedFinishedContributionId());
            previousEntry.setStatus(VolumeEntry.FINISHED_STATUS);
                
            // Remove contribution with status delete
            myEntry.delete();
            
            /*
             // Keep entry deleted !
            VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
            newEntry.setClassifiedFinishedContribution(myEntry);
            newEntry.setModification(user.getLogin(), "undelete");
            newEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
            myEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
            myEntry.save();
            newEntry.save();
            */
            
            //
            throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                  EditEntry.VolumeName_PARAMETER + "=" + myEntry.getVolumeName() + 
                                                  "&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
            
        }  else {
            
            // Error message
            //this.getSessionData().writeUserMessage("Error undeleting " + myEntry.getId());
            
            // Error page
            throw new ClientPageRedirectException(EditingErrorURL);
        }
    }
}
