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
 * Revision 1.6  2004/01/21 11:47:22  serasset
 * Merged Trunk with PAPILLON_DEBUG_FOR_JDK14
 *
 * Revision 1.5.4.1  2004/01/06 14:55:49  serasset
 * Suppressed late reencoding of large text data incorrectly read by DODS.
 * These text fields are now correctly encoded by the patched enhydra 5.0.
 *
 * Revision 1.5  2003/12/18 15:17:37  serasset
 * Titles are now correctly reencoded.
 *
 * Revision 1.4  2003/12/08 08:49:39  serasset
 * *** empty log message ***
 *
 * Revision 1.3  2003/08/14 08:30:12  mangeot
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
 * Revision 1.2.2.1  2003/05/28 09:17:17  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.2  2002/11/22 13:04:10  mangeot
 * Nouvelle version Papillon enhydra 5.0
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.4  2002/09/16 09:55:05  mangeot
 * added a field in informationdocument, the reference,
 * tested and modified olivier's code
 *
 * Revision 1.3  2001/11/15 15:13:41  serasset
 * Ajout de l'import d'un fichier image/pdf/autre par stockage sur disque dur.
 *
 * Revision 1.2  2001/10/29 13:32:17  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 * Revision 1.1  2001/10/17 12:59:56  serasset
 * L'ajout de document d'information se fait via une action specifique par type de fichier.
 * Distinction entre Document (abstrait) et Fichier (qui composent concretement un document).
 *
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;
import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

// Enhydra SuperServlet imports

public class InformationDocument {
    protected InformationDocumentDO myDO = null;
    
    /**
     * The public constructor.
     */
    public InformationDocument() throws PapillonBusinessException {
        try {
            this.myDO = InformationDocumentDO.createVirgin();  
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty InformationDocument", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty InformationDocument", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the message.
     */
    protected InformationDocument(InformationDocumentDO theFile) 
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
	  
    public boolean IsEmpty() {
        return (this.myDO==null) ;
    }
	  
    public String getHandle()
        throws PapillonBusinessException {
        try {
            return this.myDO.getHandle();
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting InformationDocument's handle", ex);
        }
    }
////////////////////////// data member Title


   /**
    * Get title of the InformationDocument
    *
    * @return title of the InformationDocument
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public String getTitle () throws PapillonBusinessException {
	try {
            // I have to convert it back to UTF8 as it seems that either enhydra, or the JDBC driver is
            // wrong.
	    //    byte [] buf = this.myDO.getTitle().getBytes();
	    //return new String(buf, "UTF-8");

	    return this.myDO.getTitle();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationDocument's title", ex);
        }// catch(java.io.UnsupportedEncodingException ex) {
	 //   throw new PapillonBusinessException("Error getting InformationDocument's title", ex);
 	//}
    }

   
   /**
    * Set title of the InformationDocument
    *
    * @param title of the InformationDocument
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setTitle ( String title ) throws PapillonBusinessException {
        try {
            myDO.setTitle(title);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's filename", ex);
        }
    }

////////////////////////// data member author

    /**
        * Get author(s) of the InformationDocument
     *
     * @return author(s) of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getAuthor () throws PapillonBusinessException {
        try {
	    //            byte [] buf = this.myDO.getAuthor().getBytes();
	    //            return new String(buf, "UTF-8");
            return this.myDO.getAuthor();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationDocument's Author", ex);
        } //catch(java.io.UnsupportedEncodingException ex) {
          //  throw new PapillonBusinessException("Error getting InformationDocument's Author", ex);
        //}
    }


    /**
        * Set author of the InformationDocument
     *
     * @param author of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setAuthor ( String author ) throws PapillonBusinessException {
        try {
            myDO.setAuthor(author);
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's Author", ex);
        }
    }

    /**
     * Get owner of the InformationDocument
     *owner     
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getOwner()
        throws PapillonBusinessException {
            try {
                return myDO.getOwner();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting user's owner", ex);
            }
        }
    /**
        * Set owner of the InformationDocument
     *owner     * @param author of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setOwner ( String owner ) throws PapillonBusinessException {
        try {
            myDO.setOwner(owner);
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's owner", ex);
        }
    }

    /**
        * Get reference of the InformationDocument
     *
     * @return reference of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getReference () throws PapillonBusinessException {
        try {
            //byte [] buf = this.myDO.getReference().getBytes();
            //return new String(buf, "UTF-8");
	    return this.myDO.getReference();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationDocument's Reference", ex);
        } //catch(java.io.UnsupportedEncodingException ex) {
          //  throw new PapillonBusinessException("Error getting InformationDocument's Reference", ex);
        //}
    }


    /**
        * Set reference of the InformationDocument
     *
     * @param reference of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setReference ( String reference ) throws PapillonBusinessException {
        try {
            myDO.setReference(reference);
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's Reference", ex);
        }
    }

    ////////////////////////// data member CreationDate

   /**
    * Get CreationDate of the InformationDocument
    *
    * @return CreationDate of the InformationDocument
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public java.sql.Date getCreationDate () throws PapillonBusinessException {
        try {
            return this.myDO.getCreationDate();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationDocument's FileType", ex);
        }
    }

   
   /**
    * Set CreationDate of the InformationDocument
    *
    * @param CreationDate of the InformationDocument
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setCreationDate ( java.sql.Date date ) throws PapillonBusinessException {
        try {
            myDO.setCreationDate(date);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's date", ex);
        }
    }

    /**
        * Set CreationDate of the InformationDocument
     *
     * @param CreationDate (as a java.util.Date) of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setCreationDate ( java.util.Date date ) throws PapillonBusinessException {
        try {
            myDO.setCreationDate(new java.sql.Date(date.getTime()));
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's date", ex);
        }
    }

    /**
        * Set CreationDate of the InformationDocument
     *
     * @param CreationDate (as a String) of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setCreationDate (String date) throws PapillonBusinessException {
        try {
            java.text.SimpleDateFormat myDateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
            java.util.Date myDate = myDateFormat.parse(date);
            myDO.setCreationDate(new java.sql.Date(myDate.getTime()));
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's date", ex);
        }
    }

    
////////////////////////// data member Section

   /**
    * Get Section of the InformationDocument
    *
    * @return Section of the InformationDocument
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public String getSection () throws PapillonBusinessException {
        try {
            return this.myDO.getSection();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting InformationDocument's FileCode", ex);
        }
    }

   
   /**
    * Set Section of the InformationDocument
    *
    * @param Section of the InformationDocument
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setSection ( String section ) throws PapillonBusinessException {
        try {
            myDO.setSection(section);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's FileCode", ex);
        }
    }

 
    public void save() 
        throws PapillonBusinessException {
        try {
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving InformationDocument", ex);
        }
    }
    
    /**
     * Deletes the message from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
     *   error).
     */
    public void delete() 
        throws PapillonBusinessException {
        try {
            this.myDO.delete();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error deleting InformationDocument", ex);
        }
    }
     
   

}
