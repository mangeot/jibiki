/*
 *  Jibiki plateform
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1.2.2  2007/10/29 15:11:03  serasset
 * NEW: lexalp css now defines different forms for HARMONISED/REJECTED entries
 * NEW: added new db url/user/password configuration keys in papillon.properties file
 * BUG158: headwords are now harmonised at edition and search time, added a "normalise headword" admin action
 *
 * Revision 1.1.2.1  2007/07/23 14:23:50  serasset
 * Commiting most changes done for the XALAN27_NEWDISPLAY on the branch
 *  - Added XSL extensions callable during xsl transformations
 *  - Implemented new display of query results as requested by EURAC team
 *  - Modified edition interface generator to adapt it to xalan 2.7.0
 *  - Added autocompletion feature to simple search fields
 *  - Moved some old pages to "deprecated" folder (this will forbid direct use of this code for papillon/GDEF)
 *
 *
 */
package fr.imag.clips.papillon.business.xsl;

import org.w3c.dom.Node;
import fr.imag.clips.papillon.facelets.xhtml.Actions;
import fr.imag.clips.papillon.facelets.util.JibikiContext;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.ParseVolume;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.CurrentRequestContext;
import fr.imag.clips.papillon.presentation.PapillonSessionData;

// import org.apache.xalan.xslt.*;

public class JibikiXsltExtension {
    
    public JibikiXsltExtension() {
    }

    public static Node editingCommands(String volume, String entryid) throws PapillonBusinessException {
        Actions act = new Actions();
        return act.getActions(volume, entryid);
    }

    public static Node editingCommands(VolumeEntry entry) throws PapillonBusinessException {
        Actions act = new Actions();
        return act.getActions(entry);
    }

    public static Node linkCommands(String volume, String linkId) throws PapillonBusinessException {
        Actions act = new Actions();
        return act.getLinkActions(volume,linkId);
    }

    public static String getUserLogin() throws PapillonBusinessException {
        try {
            JibikiContext context = CurrentRequestContext.get();
            User currentUser = ((PapillonSessionData) context.get("sessionData")).getUser();
            return currentUser.getLogin();
        } catch (NullPointerException e) {
            return "guest";
        }
    }

    public static String getEntryVolume(String dictionary, String entryId) throws PapillonBusinessException {
        String volumeName = "";
        try {
            VolumeEntry theEntry = VolumeEntriesFactory.findEntryByDictionaryNameAndContributionId(dictionary, entryId);
            if (theEntry!=null &&!theEntry.isEmpty()) {
                volumeName =theEntry.getVolumeName();
            }
        } catch (NullPointerException e) {
            volumeName = "";
        }

        return volumeName;
    }
    

    public static String getEntryStatus(String volume, String entryid) throws PapillonBusinessException {
        try {
            VolumeEntry ve = VolumeEntriesFactory.findEntryByContributionId(volume,entryid);
			
            return ve.getStatus();
        } catch (NullPointerException e) {
            return "finished";
        }
    }
	
	public static String getEntryGroups(String volume,String entryid) throws PapillonBusinessException {
        try {
               VolumeEntry ve = VolumeEntriesFactory.findEntryByContributionId(volume,entryid);
            return  Utility.getStars(ve.getGroups());
        } catch (NullPointerException e) {
            return "";
        }
    }
	
	
	public static String getVolumeSourceLanguage(String volume) throws PapillonBusinessException {
        try {
            Volume theVolume = VolumesFactory.getVolumeByName(volume);
			
            return theVolume.getSourceLanguage();
        } catch (NullPointerException e) {
            return "";
        }
    }
	
	public static String getEntryHeadword(String volume, String entryid) throws PapillonBusinessException {
        try {
            VolumeEntry ve = VolumeEntriesFactory.findEntryByContributionId(volume,entryid);
			
            return ve.getHeadword();
        } catch (NullPointerException e) {
            return "";
        }
    }
	
    public static String getEntryModificationAuthor(String volume, String entryid) throws PapillonBusinessException {
        String author = "vide";
        try {
            VolumeEntry ve = VolumeEntriesFactory.findEntryByContributionId(volume,entryid);
            if (ve.getLastModificationAuthor() != null) {
                author = ve.getLastModificationAuthor();
           }
        } catch (NullPointerException e) {
            author= "unknown " + volume + " " + entryid;
        }
        return author;
    }
}
