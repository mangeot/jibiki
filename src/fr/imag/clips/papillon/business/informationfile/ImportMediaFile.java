/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
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
 * Revision 1.4  2003/09/03 10:15:45  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.3  2003/08/25 08:27:27  mangeot
 * *** empty log message ***
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
 * Revision 1.7  2002/08/16 11:46:09  tache
 * Improved errors handle. Now all kind of exceptions thrown during the
 * import are caught.
 *
 * Revision 1.6  2002/08/01 12:40:00  tache
 * Cleaned up a lot of code in import classes. Moved HTML parsing methods from
 * ImportHTMLFile to new class HTMLParser to reuse them in ImportArchive.
 * Moved XMLTitleParser to fr.imag.clips.papillon.presentation.
 *
 * Revision 1.5  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.4  2002/05/22 08:56:18  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.3  2002/02/06 10:39:39  serasset
 * Remove document is now implemented.
 * The information sections are now defined in papillon's config file and handled in the Administration page.
 *
 * Revision 1.2  2002/01/28 13:48:35  serasset
 * A single media file is now correctly indentified as the index of a document.
 *
 * Revision 1.1  2001/11/15 15:13:41  serasset
 * Ajout de l'import d'un fichier image/pdf/autre par stockage sur disque dur.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonImportException;
import fr.imag.clips.papillon.business.PapillonLogger;

public class ImportMediaFile extends InformationFileAction {
    MediaPreferences prefs;


    // Constructor...
    public ImportMediaFile() {
        handlerName = "ImportMediaFile";
        prefs = new MediaPreferences();
    }
    
    /**
     * perform the file addition.
     */
    public void addFile( de.opus5.servlet.UploadedFile file,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang)
            throws PapillonBusinessException ,PapillonImportException{
        String name = file.getName();
        PapillonLogger.writeDebugMsg("importing Media File \""+ name);
        try {
            // WARNING: we assume that the imported file is a DiskFile...
            // We should not. The location of the tmp folder should be known...
            // First, computing the output name
            String path = file.getFile().getCanonicalPath();
            String oid = env.getFileIDForURL(path);
                        
            InputStream is = file.getInputStream();
//            PapillonLogger.writeDebugMsg("oid --> \""+ oid + "\"; path --> \"" + path + "\"");

            this.addFile(is, name, oid, doc, lang);
         } catch (java.io.IOException e) {
            PapillonLogger.writeDebugMsg("IOException encountered while importing Media file.");
        }
        
        PapillonLogger.writeDebugMsg("Media File \""+ name + "\"Imported !");
    }
           
    public void addFile( java.io.File file,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang)
            throws PapillonBusinessException ,PapillonImportException{
        String name = file.getName();
        PapillonLogger.writeDebugMsg("copying File \""+ name);
        try {
            String path = file.getCanonicalPath();
            String oid = env.getFileIDForURL(path);
            
            InputStream is = (InputStream) new FileInputStream(file);
            
            this.addFile(is, name, oid, doc, lang);
        } catch (java.io.IOException e) {
            PapillonLogger.writeDebugMsg("IOException encountered while importing Media file.");
        } 
        
        PapillonLogger.writeDebugMsg("Media File \""+ name + "\" Imported !");
    }

    public void addFile( InputStream is,
                         String name,
                         String oid,
                         InformationDocument doc,
			 String lang) throws java.io.IOException,
                                             fr.imag.clips.papillon.business.PapillonBusinessException ,PapillonImportException{
            
        if (is.available() == 0) {
            PapillonLogger.writeDebugMsg("ImportMediaFile: Encountered an empty media file.");
	    throw new PapillonImportException("a Media file is empty.");
        } else {
            // copy the file to dest.
            if (null == oid) {
                // The file object has not been created already because it is the document (and not a part of it)
		// check that the document has a title
                if (doc.getTitle().equals("")) {
		    throw new PapillonImportException("please, enter a title for this document");
		}
		int dot = name.lastIndexOf(".");
                String ext = name.substring(dot+1);
                InformationFile theFileObject=InformationFileFactory.RegisterNewInformationFile("", ext, "", doc);
                oid = theFileObject.getHandle();
		theFileObject.setFilename(this.getNameOnServer(name, oid));
                theFileObject.setIsIndexFile(true);
		theFileObject.setLanguage(lang);
                theFileObject.save();
            }
            String dest = prefs.getBaseDirName() + this.getNameOnServer(name, oid);

            FileOutputStream out = null;
            try {
                out = new FileOutputStream(dest);
                byte[] buffer = new byte[8 * 1024];
                int count = 0;
                do {
                    out.write(buffer, 0, count);
                    count = is.read(buffer, 0, buffer.length);
                } while (count != -1);
            } catch (IOException ioe) {
                String msg = "Problem copying media file: " + ioe.getMessage();
                PapillonLogger.writeDebugMsg(msg);
                throw new PapillonBusinessException(msg, ioe);
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException ioex) {}
                }
            }
        }
    }

    /**
     * Return the url where the given file will be found after an import...
     */
    public String getNameOnServer(String filename, String oid) {
        int dot = filename.lastIndexOf(".");
        String ext = filename.substring(dot+1);
        
        return prefs.getMediaDirName() + oid + "." + ext;
    }
 
}

