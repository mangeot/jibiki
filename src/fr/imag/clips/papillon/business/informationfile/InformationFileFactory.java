/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.8  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.7  2002/02/06 15:03:02  serasset
 * Consultation and Administration of the information files now correctly use the Sections.
 * We do not display the files directly anymore, but display a document. This allows the display of
 * images as embedded docs in the default layout.
 *
 * Revision 1.6  2002/02/06 10:39:39  serasset
 * Remove document is now implemented.
 * The information sections are now defined in papillon's config file and handled in the Administration page.
 *
 * Revision 1.5  2001/10/29 13:32:18  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 * Revision 1.4  2001/10/17 12:59:56  serasset
 * L'ajout de document d'information se fait via une action specifique par type de fichier.
 * Distinction entre Document (abstrait) et Fichier (qui composent concretement un document).
 *
 * Revision 1.3  2001/09/07 06:53:45  serasset
 * File addition is now done with a set of Handler classes that are invoked depending on
 * the application configuration file.
 *
 * Revision 1.2  2001/08/28 17:58:32  salvati
 * Added the mainFile attribut and then the good listing.
 *
 * Revision 1.1  2001/08/01 15:15:29  salvati
 * Adding the interface with database.
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.data.*;

import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.business.utility.*;

import com.lutris.appserver.server.sql.ObjectId;


/**
 * Used to find the instances of InformationFile.
 */
public class InformationFileFactory {
    
    /** 
     * The getInformationFilesArray method performs a database query to
     * return an array of InformationFile
     * @return
     *     array of InformationFile. 
     * @exception PapillonBusinessException
     *   If there is a problem retrieving data.
     */
    public static InformationFile[] getInformationFilesArray() 
        throws PapillonBusinessException {
        InformationFile[] theFileArray = null;
        
        try {
            InformationFileQuery query = new InformationFileQuery();
         
            InformationFileDO[] DOarray = query.getDOArray();
            theFileArray = new InformationFile[ DOarray.length ];
            for ( int i = 0; i < DOarray.length; i++ )
	    	theFileArray[i] = new InformationFile(DOarray[i]);
        return theFileArray;

        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getInformationFilesArray()", ex);
        }
         
    }
    
    
    
    /** 
     * The findMessageByID method performs a database query to
     * return a <CODE>Message</CODE> object
     * representing the row in the <CODE>message</CODE> table
     * that matches the object id. 
     *
     * @param id, the object id of the message table.
     * @return
     *    the message. null if there isn't a message associated
     *    to the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static InformationFile findInformationFileByID(String id) 
        throws PapillonBusinessException {
        InformationFile theFile = null;
        
        try {
            InformationFileQuery query = new InformationFileQuery();
            //set query
            query.setQueryOId(new ObjectId(id));
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            InformationFileDO theInformationFileDO = query.getNextDO();
            theFile = new InformationFile(theInformationFileDO);
            return theFile;
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findInformationFileByID()", ex);
        }
    }
    
    
    public static InformationFile findInformationFileByName(String name) 
        throws PapillonBusinessException {
        InformationFile theFile = null;
        
        try {
            InformationFileQuery query = new InformationFileQuery();
            //set query
            query.setQueryFilename(name);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            InformationFileDO theInformationFileDO = query.getNextDO();			
				
            theFile = new InformationFile(theInformationFileDO);
            return theFile;
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findInformationFileByName()", ex);
        }
    }
    
    
    /** 
     * The findLocIndexFileForDocument method performs a database query to
     * return an <CODE>InformationFile</CODE> object
     * that is the index file for the passed document in the given lang. 
     *
     * @param doc, the InformationDocument;
     *        lang, the queried language.
     * @return
     *    the InformationFile. null if there isn't an index file associated
     *    to the document with that language
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static InformationFile findLocIndexFileForDocument(InformationDocument doc, String lang) 
        throws PapillonBusinessException {
        InformationFile theFile = null;
        
        try {
            InformationFileQuery query = new InformationFileQuery();
            //set query
            query.setQueryDocument(doc.myDO);
            query.setQueryIsIndexFile(true);
	    query.setQueryLanguage(lang);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            InformationFileDO theInformationFileDO = query.getNextDO();
            if (null != theInformationFileDO) {
                theFile = new InformationFile(theInformationFileDO);
            }
            return theFile;
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findInformationFileByID()", ex);
        }
    }

    
    public static InformationFile RegisterNewInformationFile(
            String filename, 
            String filetype,
	    String lang,
            InformationDocument doc) 
            throws PapillonBusinessException {
        InformationFile f = new InformationFile();
        
        f.setFilename(filename);
        f.setFiletype(filetype);
	f.setLanguage(lang);
        f.setDocument(doc.myDO);
        f.setFilecode("");
        f.save();
        
        return f;
    }
	 
    /** 
     * The getInformationFilesArrayForDocument method performs a database query to
     * return an array of InformationFile that belong to the given document.
     * @param doc, the Information Document
     * @return
     *     array of InformationFile. 
     * @exception PapillonBusinessException
     *   If there is a problem retrieving data.
     */
    public static InformationFile[] getInformationFilesArrayForDocument(InformationDocument doc) 
        throws PapillonBusinessException {
        InformationFile[] theFileArray = null;
        
        try {
            InformationFileQuery query = new InformationFileQuery();
            //set query
            query.setQueryDocument(doc.myDO);
 
            InformationFileDO[] DOarray = query.getDOArray();
            theFileArray = new InformationFile[ DOarray.length ];
            for ( int i = 0; i < DOarray.length; i++ )
	    	theFileArray[i] = new InformationFile(DOarray[i]);
            return theFileArray;
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getInformationFilesArray()", ex);
        }
         
    }

}

