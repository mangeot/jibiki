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
 * Revision 1.3  2004/01/21 11:47:22  serasset
 * Merged Trunk with PAPILLON_DEBUG_FOR_JDK14
 *
 * Revision 1.2.4.1  2004/01/06 14:55:50  serasset
 * Suppressed late reencoding of large text data incorrectly read by DODS.
 * These text fields are now correctly encoded by the patched enhydra 5.0.
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
 * Revision 1.9  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.8  2002/02/06 15:03:02  serasset
 * Consultation and Administration of the information files now correctly use the Sections.
 * We do not display the files directly anymore, but display a document. This allows the display of
 * images as embedded docs in the default layout.
 *
 * Revision 1.7  2002/02/06 10:39:39  serasset
 * Remove document is now implemented.
 * The information sections are now defined in papillon's config file and handled in the Administration page.
 *
 * Revision 1.6  2001/11/15 15:13:41  serasset
 * Ajout de l'import d'un fichier image/pdf/autre par stockage sur disque dur.
 *
 * Revision 1.5  2001/10/29 13:32:18  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 * Revision 1.4  2001/10/17 12:59:56  serasset
 * L'ajout de document d'information se fait via une action specifique par type de fichier.
 * Distinction entre Document (abstrait) et Fichier (qui composent concretement un document).
 *
 * Revision 1.3  2001/08/28 17:58:32  salvati
 * Added the mainFile attribut and then the good listing.
 *
 * Revision 1.2  2001/08/28 14:29:23  salvati
 * Added fileCode field.
 *
 * Revision 1.1  2001/08/01 15:15:29  salvati
 * Adding the interface with database.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;
import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.informationfile.MediaPreferences;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

import java.io.File;

// Enhydra SuperServlet imports

public class InformationFile {
    protected InformationFileDO myDO = null;
    
    /**
     * The public constructor.
     */
    public InformationFile() throws PapillonBusinessException {
        try {
            this.myDO = InformationFileDO.createVirgin();  
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty InformationFile", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty InformationFile", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the message.
     */
    protected InformationFile(InformationFileDO theFile) 
        throws PapillonBusinessException  {
        this.myDO = theFile;
    }

    /**
     * Gets the object id for the message
     *
     * @return the object id.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	  	  
    public String getHandle()
        throws PapillonBusinessException {
        try {
            return this.myDO.getHandle();
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting InformationFile's handle", ex);
        }
    }

////////////////////////// data member language

    /**
     * Get the language of the InformationFile.
     *
     * @return the language of the InformationFile.
     *
     * @exception PapillonBusinessException
     *  If the object is not found in the database.
     */
    public String getLanguage() throws PapillonBusinessException {
	try {
	    return this.myDO.getLanguage();
	} catch(DataObjectException ex) {
	    throw new PapillonBusinessException("Error getting InformationFile's language", ex);
	}
    }

    /**
     * Set the language of the InformationFile.
     *
     * @param lang the language of the InformationFile.
     *
     * @exception PapillonBusinessException
     *  If the object is not found in the database.
     */
    public void setLanguage(String lang) throws PapillonBusinessException {
	try {
	    this.myDO.setLanguage(lang);
	} catch(DataObjectException ex) {
	    throw new PapillonBusinessException("Error setting InformationFile's language", ex);
	}
    }




////////////////////////// data member Name


   /**
    * Get name of the InformationFile
    *
    * @return name of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public String getFilename () throws PapillonBusinessException {
        try {
            //byte [] buf = this.myDO.getFilename().getBytes();
            //return new String(buf, "UTF-8");
            return this.myDO.getFilename();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationFile's filename", ex);
        } //catch(java.io.UnsupportedEncodingException ex) {
          //  throw new PapillonBusinessException("Error getting InformationDocument's filename", ex);
        //}
    }

   
   /**
    * Set name of the InformationFile
    *
    * @param name of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setFilename ( String name ) throws PapillonBusinessException {
        try {
            myDO.setFilename(name);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationFile's filename", ex);
        }
    }
 
////////////////////////// data member FileType

   /**
    * Get FileType of the InformationFile
    *
    * @return FileType of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public String getFiletype () throws PapillonBusinessException {
        try {
            //byte [] buf = this.myDO.getFiletype().getBytes();
            //return new String(buf, "UTF-8");
            return this.myDO.getFiletype();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationFile's FileType", ex);
        } //catch(java.io.UnsupportedEncodingException ex) {
          //  throw new PapillonBusinessException("Error getting InformationDocument's FileType", ex);
        //}
    }

   
   /**
    * Set name of the InformationFile
    *
    * @param name of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setFiletype ( String fileType ) throws PapillonBusinessException {
        try {
            myDO.setFiletype(fileType);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationFile's FileType", ex);
        }
    }

////////////////////////// data member FileCode

   /**
    * Get FileCode of the InformationFile
    *
    * @return FileCode of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public String getFilecode () throws PapillonBusinessException {
        try {
            //byte [] buf = this.myDO.getFilecode().getBytes();
            //return new String(buf, "UTF-8");
            return this.myDO.getFilecode();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationFile's FileCode", ex);
        } //catch(java.io.UnsupportedEncodingException ex) {
          //  throw new PapillonBusinessException("Error getting InformationDocument's FileCode", ex);
        //}
    }

   
   /**
    * Set name of the InformationFile
    *
    * @param name of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setFilecode ( String FileCode ) throws PapillonBusinessException {
        try {
            myDO.setFilecode(FileCode);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationFile's FileCode", ex);
        }
    }

////////////////////////// data member document

   /**
    * Get document of the InformationFile
    *
    * @return document of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public fr.imag.clips.papillon.data.InformationDocumentDO getDocument () throws PapillonBusinessException {
        try {
            return this.myDO.getDocument();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationFile's document", ex);
        }
    }

   
   /**
    * Set document of the InformationFile
    *
    * @param document of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setDocument ( fr.imag.clips.papillon.data.InformationDocumentDO document ) throws PapillonBusinessException {
        try {
            myDO.setDocument(document);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationFile's document", ex);
        }
    }

////////////////////////// data member isIndexFile

   /**
    * Get isIndexFile of the InformationFile
    *
    * @return isIndexFile of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public boolean getIsIndexFile () throws PapillonBusinessException {
        try {
            return this.myDO.getIsIndexFile();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationFile's isIndexFile", ex);
        }
    }

   
   /**
    * Set isIndexFile of the InformationFile
    *
    * @param isIndexFile of the InformationFile
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setIsIndexFile ( boolean isIndexFile ) throws PapillonBusinessException {
        try {
            myDO.setIsIndexFile(isIndexFile);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationFile's isIndexFile", ex);
        }
    }


 
    public void save() 
        throws PapillonBusinessException {
        try {
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving InformationFile", ex);
        }
    }
    
    /**
     * Deletes the message from the database, and, if the file is stored on disk (image file...).
     * delete it also from the disk.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
     *   error).
     */
    public void delete() 
        throws PapillonBusinessException {
        try {
            // If the information file is stored on disk (image, etc...), then delete the file also...
            MediaPreferences prefs = new MediaPreferences();
            
            String fileName = this.getFilename();
            if (fileName.startsWith(prefs.getMediaDirName())) {
                File mediaFile = new File(prefs.getBaseDirName() + fileName);
                mediaFile.delete();
            }
            this.myDO.delete();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error deleting InformationFile", ex);
        }
    }
     
    /**
     * Check if the informationFile is connected to a data object
     *
     */   
    public boolean IsEmpty() {
        return (this.myDO==null) ;
    }

    public boolean isAnImage() {
        try {
            MediaPreferences prefs = new MediaPreferences();
            
            String fileName = this.getFilename();
            int dot = fileName.lastIndexOf(".");
            String ext = fileName.substring(dot+1).toUpperCase();
            return ((fileName.startsWith(prefs.getMediaDirName())) && (
                ext.endsWith("JPG") ||
                ext.endsWith("JPEG") ||
                ext.endsWith("GIF") ||
                ext.endsWith("TIFF")
                ));
        } catch (PapillonBusinessException e) {
            // This may come only from a corrupted InformationFile...
            return false;
        }

    }

    public boolean isAHTMLFile() {
        // For now, just say that all files with a non empty fileCode is a HTML element...
        try {
            return !(this.getFilecode().trim().equals(""));
        } catch (PapillonBusinessException e) {
            // This may come only from a corrupted InformationFile...
            return false;
        }
    }

}
