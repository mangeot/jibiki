/*
 *  papillon
 *
 *  Preference object for the information file management 
 * 
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.2  2003/08/14 08:30:12  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:17  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.4  2002/10/25 14:10:31  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.3.2.1  2002/10/10 06:46:51  mangeot
 * Corrected a bug pb between lang and DocLang in consultInformations
 * Created a new sql function to count the number of entries for the volumes
 * added in Adminvolumes.java and dictd.show server
 *
 * Revision 1.3  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.2  2002/02/06 17:06:55  serasset
 * The media folder was not created correctly.
 *
 * Revision 1.1  2002/02/06 15:03:03  serasset
 * Consultation and Administration of the information files now correctly use the Sections.
 * We do not display the files directly anymore, but display a document. This allows the display of
 * images as embedded docs in the default layout.
 *
 *-----------------------------------------------
 * 
 */
package fr.imag.clips.papillon.business.informationfile;

import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.Enhydra;
import com.lutris.util.KeywordValueException;

import java.io.File;

public class MediaPreferences {
    public final static String MEDIA_DIR_CONFIG = "Papillon.Informations.mediaDir";
    public final static String BASE_DIR_CONFIG = "Papillon.Informations.baseDir";
    public final static String FILE_VIEWER_URL = "ConsultInformations.po";
    public final static String FILE_ID_PARAMETER = "fileid";
    public final static String DOC_ID_PARAMETER = "docid";
    public final static String DOC_LANG_PARAMETER = "docLang";
    
    protected String mediaDir;
    protected String baseDir;

    public MediaPreferences() {
        try {
            mediaDir = Enhydra.getApplication().getConfig().getString(MEDIA_DIR_CONFIG);
            if (! mediaDir.endsWith(File.separator)) {
                mediaDir = mediaDir + File.separator;
            }
            baseDir = Enhydra.getApplication().getConfig().getString(BASE_DIR_CONFIG);
            if (! baseDir.endsWith(File.separator)) {
                baseDir = baseDir + File.separator;
            }
            File baseFolder = new File(baseDir);
            File mediaFolder = new File(baseFolder, mediaDir);
            mediaFolder.mkdirs();
        } catch (KeywordValueException kve) {
            PapillonLogger.writeDebugMsg("Unexpected Error: Incorrect configuration file for group: "
                            + MEDIA_DIR_CONFIG);
        } catch (Exception e) {
            PapillonLogger.writeDebugMsg("Unexpected IO Exception while importing a media file.");
        }

    }
    
    public String getMediaDirName() {
        return mediaDir;
    }
    
    public String getBaseDirName() {
        return baseDir;
    }
    
    public String getConsultFileUrl() {
        return FILE_VIEWER_URL + "?" + FILE_ID_PARAMETER + "=";
    }
    
    public String getConsultDocumentUrl() {
        return FILE_VIEWER_URL + "?" + DOC_ID_PARAMETER + "=";
    }
    
}
