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

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

//local imports
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.user.Group;
import fr.imag.clips.papillon.presentation.EditEntry;


public class EditEntryInitFactory {

    //
    protected final static String EditEntryURL = "EditEntry.po";
    protected final static String EditingErrorURL = "EditingError.po";
    
    
    /**
    * The createEntry method create a not finished entry and redirect to edition interface
     * 
     * @param String volumeName
     * @param String headword
     * @param User user
     *
     */    
    public static void createEntry(String volumeName, String headword, User user)
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
    public static void editEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
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
    }
    
    
    /**
     * The duplicateEntry method duplicate a finished entry A to new entry B (without history of entry A) and redirect entry B to edition interface
     *
     * @param VolumeEntry
     * @param User
     *
     */    
    public static void duplicateEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
            
            //
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
    public static void deleteEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
            
            //
            VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
            newEntry.setClassifiedFinishedContribution(myEntry);
            newEntry.setModification(user.getLogin(), "delete");
            newEntry.setStatus(VolumeEntry.DELETED_STATUS);
            myEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
            myEntry.save();
            newEntry.save();
            
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
    public static void undeleteEntry(VolumeEntry myEntry, User user)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        if ( myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
            
            //
            VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
            newEntry.setClassifiedFinishedContribution(myEntry);
            newEntry.setModification(user.getLogin(), "undelete");
            newEntry.setStatus(VolumeEntry.FINISHED_STATUS);
            myEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
            myEntry.save();
            newEntry.save();
            
        }  else {
            
            // Error message
            //this.getSessionData().writeUserMessage("Error undeleting " + myEntry.getId());
            
            // Error page
            throw new ClientPageRedirectException(EditingErrorURL);
        }
    }        
}
