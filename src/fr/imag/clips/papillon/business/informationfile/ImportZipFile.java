/*
 *  papillon
 *
 *  Zip file importer
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
 * Revision 1.4  2002/08/16 11:46:09  tache
 * Improved errors handle. Now all kind of exceptions thrown during the
 * import are caught.
 *
 * Revision 1.3  2002/08/01 12:40:00  tache
 * Cleaned up a lot of code in import classes. Moved HTML parsing methods from
 * ImportHTMLFile to new class HTMLParser to reuse them in ImportArchive.
 * Moved XMLTitleParser to fr.imag.clips.papillon.presentation.
 *
 * Revision 1.2  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.1  2002/02/08 16:41:16  serasset
 * Addition of ZIP file support in information repository.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;

import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonImportException;
import fr.imag.clips.papillon.business.PapillonLogger;

import org.apache.tools.tar.*;
import java.util.zip.*;

import java.io.*;
import java.util.Vector;
import java.util.Iterator;

public class ImportZipFile extends ImportArchive {

    MediaPreferences prefs;

    // Constructor...
    public ImportZipFile() {
        handlerName = "ImportZipFile";
	prefs = new MediaPreferences();
    }
    
    /**
     * perform the file addition.
     */
    public void addFile( de.opus5.servlet.UploadedFile file,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang)
            throws PapillonImportException, PapillonBusinessException, ClientPageRedirectException,
		   javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        PapillonLogger.writeDebugMsg("untaring File \""+ file.getName());
        try {
            // Get the data
            InputStream is = file.getInputStream();
            String outputDirName = file.getFile().getParent() + File.separator + "unzip-"+ doc.getHandle();

            this.addFile(is, outputDirName, doc, env, lang);
        } catch (java.io.IOException e) {
            PapillonLogger.writeDebugMsg("IOException encountered while importing Tar file.");
        }
        
        PapillonLogger.writeDebugMsg("File \""+ file.getName() + "\"Imported !");
    }
           
           
    public void addFile( java.io.File file,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang)
            throws PapillonImportException, PapillonBusinessException, ClientPageRedirectException,
		   javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {
        PapillonLogger.writeDebugMsg("untaring File \""+ file.getName());
        try {
            InputStream is = (InputStream) new FileInputStream(file);
            String outputDirName = file.getParent() + File.separator + "unzip-"+ doc.getHandle();
            this.addFile(is, outputDirName, doc, env, lang);
        } catch (java.io.IOException e) {
            PapillonLogger.writeDebugMsg("IOException encountered while importing Tar file.");
        }
        
        PapillonLogger.writeDebugMsg("File \""+ file.getName() + "\"Imported !");
    }

    public void addFile( InputStream is,
                         String outputDirName,
                         InformationDocument doc,
                         RelativeURLMapper env,
			 String lang)
            throws java.io.IOException, PapillonImportException, PapillonBusinessException, ClientPageRedirectException,
		   javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException {




        if (is.available() == 0) {
            PapillonLogger.writeDebugMsg("ImportZipFile: Encountered an empty Zip file.");
	    throw new PapillonImportException("the Zip file is empty.");
        } else {
            // Create the output directory
            File outputDir = new File(outputDirName);
            outputDir.mkdirs();
            
            // untar the file, 
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry ze = null;
            Vector files = new Vector();
            
            while ((ze = zis.getNextEntry()) != null) {
                File f = new File(outputDir, ze.getName());            
                PapillonLogger.writeDebugMsg("expanding " + ze.getName() + " to "+ f); 
                File dirF=new File(f.getParent());
                dirF.mkdirs();
                dirF.deleteOnExit();
                if (ze.isDirectory()) {
                    f.mkdirs();
                    f.deleteOnExit();
                } else {
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    FileOutputStream fos = new FileOutputStream(f);
                    while ((length = zis.read(buffer)) >= 0) {
                        fos.write(buffer, 0, length);
                    }
                    fos.close();
                    try {
                         
                        // Create an empty information file object and associates its Handle to its name
                        InformationFile inf = 
                            InformationFileFactory.RegisterNewInformationFile("" , "", "",  doc);
                        env.setFileIDForURL(f.getCanonicalPath(), inf.getHandle());
                        
                        // Calculate its name on the server...
                        InformationFileAction handlerObject = InformationFileActionFactory.getAction(f);
                        inf.setFilename(handlerObject.getNameOnServer(ze.getName(), inf.getHandle()));
                      
                        inf.save();
                        files.addElement(ze.getName());
                    } catch (java.io.IOException e) {
                        PapillonLogger.writeDebugMsg("getCanonicalPath threw an exception !!!");
                    }
                }
            }
            zis.close();
            
	    // Perform effective files addition
	    addArchiveFiles(files, outputDir, doc, env, lang);
          
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


