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
 * Revision 1.1  2004/12/06 16:38:38  serasset
 * Initial revision
 *
 * Revision 1.3  2004/10/28 10:39:41  mangeot
 * Added final static variables for handling TEXT xsl files
 *
 * Revision 1.2  2003/08/14 08:30:14  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:20  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/10/25 14:10:32  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.4.10.1  2002/10/23 09:51:11  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.4  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.3  2001/07/24 13:15:32  salvati
 * Adding the defaultxsl field in the database, adding the choice of
 * the default stylesheet when adding stylesheets.
 *
 * Revision 1.2  2001/07/12 16:54:20  salvati
 * Adding IsEmpty, save and delete functionality
 *
 * Revision 1.1  2001/07/11 12:46:39  serasset
 * *** empty log message ***
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.xsl;
import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

// Enhydra SuperServlet imports

public class XslSheet {
	
	public final static String DEFAULT_view = "DEFAULT";
	public final static String TEXT_view = "TEXT";
	public final static String TEXT_suffix = "-text";
	public final static String XML_view = "XML";
    
	protected XslSheetDO myDO = null;
    
    /**
     * The public constructor.
     */
    public XslSheet() throws PapillonBusinessException {
        try {
            this.myDO = XslSheetDO.createVirgin();  
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty XslSheet", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty XslSheet", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the message.
     */
    protected XslSheet(XslSheetDO theSheet) 
        throws PapillonBusinessException  {
        this.myDO = theSheet;
    }

    /**
     * Gets the object id for the message
     *
     * @return the object id.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	  
	 public boolean IsEmpty()
	 {
	 return (this.myDO==null) ;
	 }
	  
    public String getHandle()
        throws PapillonBusinessException {
        try {
            return this.myDO.getHandle();
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting XslSheet's handle", ex);
        }
    }
////////////////////////// data member Name


   /**
    * Get name of the xslsheets
    *
    * @return name of the xslsheets
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public String getName () throws PapillonBusinessException {
        try {
            return this.myDO.getName();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting XslSheet's name", ex);
        }
    }

   
   /**
    * Set name of the xslsheets
    *
    * @param name of the xslsheets
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
    public void setName ( String name ) throws PapillonBusinessException {
        try {
            myDO.setName(name);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting XslSheet's name", ex);
        }
    }
 
////////////////////////// data member Default
 public boolean getDefaultxsl () throws PapillonBusinessException {
        try {
            return this.myDO.getDefaultxsl();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting XslSheet's defaultxls", ex);
        }
    }

 
    public void setDefaultxsl (boolean Defaultxsl) throws PapillonBusinessException {
        try {
            myDO.setDefaultxsl(Defaultxsl);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting XslSheet's defaultxsl", ex);
        }
    }
   
   
////////////////////////// data member Description


   /**
    * Get description of the xslsheets
    *
    * @return description of the xslsheets
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
   public String getDescription () throws PapillonBusinessException {
        try {
            return this.myDO.getDescription();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting XslSheet's description", ex);
        }
    }


   
   /**
    * Set description of the xslsheets
    *
    * @param description of the xslsheets
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
   public void setDescription (String description) throws PapillonBusinessException {
        try {
            myDO.setDescription(description);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting XslSheet's description", ex);
        }
    }
 
   
////////////////////////// data member Code


   /**
    * Get code of the xslsheets
    *
    * @return code of the xslsheets
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
   public String getXmlCode () throws PapillonBusinessException {
        try {
            return this.myDO.getCode();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting XslSheet's code", ex);
        }
    }

   public String getCode () throws PapillonBusinessException {
        try {
            return this.myDO.getCode();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting XslSheet's code", ex);
        }
    }

   
   /**
    * Set code of the xslsheets
    *
    * @param code of the xslsheets
    *
    * @exception DataObjectException
    *   If the object is not found in the database.
    */
   public void setXmlCode ( String code )
   throws PapillonBusinessException {
        try {
            myDO.setCode(code);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting XslSheet's code", ex);
        }
    }
   public void setCode ( String code )
   throws PapillonBusinessException {
        try {
            myDO.setCode(code);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting XslSheet's code", ex);
        }
    }
 
       public void save() 
        throws PapillonBusinessException {
        try {
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving XslSheet", ex);
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
            throw new PapillonBusinessException("Error deleting XslSheet", ex);
        }
    }
     
   

}
