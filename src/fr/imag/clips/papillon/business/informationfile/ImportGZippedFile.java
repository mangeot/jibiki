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
 * Revision 1.4  2006/08/10 17:32:27  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2006/08/10 17:18:34  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
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
        
        PapillonLogger.writeDebugMsg("File \""+ file.getName() + "\" Imported !");
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
        
        PapillonLogger.writeDebugMsg("File \""+ file.getName() + "\" Imported !");
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

