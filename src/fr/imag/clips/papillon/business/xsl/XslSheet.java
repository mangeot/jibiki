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
 * Revision 1.4  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.2  2005/03/29 09:41:33  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2.2.1  2005/03/16 13:24:31  serasset
 * Modified all boolean fields in table to CHAR(1) in order to be more db independant.
 * Suppressed ant.jar from class path, informationfiles (which rely on it) should be corrected.
 * The version of Xerces is now displayed on application init.
 *
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:38  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.xsl;
import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.CurrentDBTransaction;

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
            this.myDO = XslSheetDO.createVirgin(CurrentDBTransaction.get());  
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
	  
	 public boolean isEmpty()
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
            String def =  this.myDO.getDefaultxsl();
            return ((def != null) && (def.equals("Y")));
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting XslSheet's defaultxls", ex);
        }
    }

 
    public void setDefaultxsl (boolean Defaultxsl) throws PapillonBusinessException {
        try {
            myDO.setDefaultxsl(Defaultxsl ? "Y" : "N");   
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
