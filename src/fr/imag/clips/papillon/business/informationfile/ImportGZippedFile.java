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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:16  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/08/16 11:46:09  tache
 * Improved errors handle. Now all kind of exceptions thrown during the
 * import are caught.
 *
 * Revision 1.4  2002/08/01 12:40:00  tache
 * Cleaned up a lot of code in import classes. Moved HTML parsing methods from
 * ImportHTMLFile to new class HTMLParser to reuse them in ImportArchive.
 * Moved XMLTitleParser to fr.imag.clips.papillon.presentation.
 *
 * Revision 1.3  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.2  2001/10/30 15:23:00  serasset
 * Images and other format are now supported as media files (i.e. files that are locally saved in a special directory).
 *
 * Revision 1.1  2001/10/29 13:32:17  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonImportException;
import fr.imag.clips.papillon.business.PapillonLogger;

import java.util.zip.*;
import java.io.*;

public class ImportGZippedFile extends InformationFileAction {
 
    MediaPreferences prefs;

    // Constructor...
    public ImportGZippedFile() {
        handlerName = "ImportGZippedFile";
	prefs = new MediaPreferences();
    }
    
    /**
     * perform the file addition.
     */
    public void addFile( de.opus5.servlet.UploadedFile file,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang)
            throws PapillonImportException, PapillonBusinessException,
		   javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        PapillonLogger.writeDebugMsg("gunzipping File \""+ file.getName());
        try {
            // WARNING: we assume that the imported file is a DiskFile...
            // We should not. The location of the tmp folder should be known...
            // First, computing the output name
            String source = file.getName();
            String dest = file.getFile().getParent() + File.separator + 
                            "ungz-" + doc.getHandle();
            int len = source.length();
            if (len > 3
                && ".gz".equalsIgnoreCase(source.substring(len-3))) {
                dest = dest + source.substring(0, len-3);
            } else {
                dest = dest + source;
            }

            InputStream is = file.getInputStream();
            
            this.addFile(is, dest, doc, env, lang);
         } catch (java.io.IOException e) {
            PapillonLogger.writeDebugMsg("IOException encountered while importing GZipped file.");
        }
        
        PapillonLogger.writeDebugMsg("File \""+ file.getName() + "\"Imported !");
    }
           
    public void addFile( java.io.File file,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang)
            throws PapillonImportException, PapillonBusinessException,
		   javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        PapillonLogger.writeDebugMsg("gunzipping File \""+ file.getName());
        try {
            // First, computing the output name
            String source = file.getName();
            String dest = file.getParent() + File.separator + 
                            "ungz-" + doc.getHandle();
            int len = source.length();
            if (len > 3
                && ".gz".equalsIgnoreCase(source.substring(len-3))) {
                dest = dest + source.substring(0, len-3);
            } else {
                dest = dest + source;
            }

            
            InputStream is = (InputStream) (new FileInputStream(file));
            this.addFile(is, dest, doc, env, lang);
        } catch (java.io.IOException e) {
            PapillonLogger.writeDebugMsg("IOException encountered while importing GZipped file.");
        } 
        
        PapillonLogger.writeDebugMsg("File \""+ file.getName() + "\"Imported !");
    }

    public void addFile( InputStream is,
                         String dest,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang) throws java.io.IOException,
					     PapillonImportException, fr.imag.clips.papillon.business.PapillonBusinessException,
					     javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
            
        if (is.available() == 0) {
            PapillonLogger.writeDebugMsg("ImportGZippedFile: Encountered an empty GZipped file.");
	    throw new PapillonImportException("the GZipped file is empty.");
        } else {
            // gunzip the file, then apply the appropriate action, based on gunzipped file type.
            
            FileOutputStream out = null;
            GZIPInputStream zIn = null;
            try {
                out = new FileOutputStream(dest);
                zIn = new GZIPInputStream(is);
                byte[] buffer = new byte[8 * 1024];
                int count = 0;
                do {
                    out.write(buffer, 0, count);
                    count = zIn.read(buffer, 0, buffer.length);
                } while (count != -1);
            } catch (IOException ioe) {
                String msg = "Problem expanding gzip " + ioe.getMessage();
                PapillonLogger.writeDebugMsg(msg);
                throw new PapillonBusinessException(msg, ioe);
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException ioex) {}
                }
                if (zIn != null) {
                    try {
                        zIn.close();
                    } catch (IOException ioex) {}
                }
            }
        
        File ungzFile = new File(dest);
        
        // Then, we should recursively call the addFile with the apprpriate handler...
        InformationFileAction handlerObject = InformationFileActionFactory.getAction(ungzFile);
        
        handlerObject.addFile(ungzFile, doc, env, lang);
        ungzFile.deleteOnExit();

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

