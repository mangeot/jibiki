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
 * Revision 1.7  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
 * Revision 1.6  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.5.4.1  2005/10/24 16:29:19  fbrunet
 * Added fuzzy search capabilities.
 * Added possibility to rebuild the index DB tables.
 * Added Pre and post processors that could be defined by the user.
 *
 * Revision 1.5  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.4  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.3.4.1  2005/05/27 11:53:21  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.1  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.5  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.CurrentDBTransaction;

import fr.imag.clips.papillon.business.utility.Utility;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

import java.util.Vector;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;


/**
 * Represents a Dictionary. 
 */
public class Dictionary {
    /**
     * The DO of the Dictionary.
     */
    protected DictionaryDO myDO = null;
	
    /**
     * The public constructor.
     */
    public Dictionary() throws PapillonBusinessException {
        try {
            this.myDO = DictionaryDO.createVirgin(CurrentDBTransaction.get());  
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty Dictionary", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty Dictionary", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the Dictionary.
     */
    protected Dictionary(DictionaryDO theDictionary) 
        throws PapillonBusinessException  {
        this.myDO = theDictionary;
    }

    public boolean isEmpty() {
        return (this.myDO==null) ;
    }


    /**
     * Gets the object id for the Dictionary
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
            throw new PapillonBusinessException("Error getting Dictionarys's handle", ex);
        }
    }

    /**
     * Gets the subject of the Dictionary
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getName() 
        throws PapillonBusinessException {
        try {
            return myDO.getName();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's name", ex);
        }
    }
	 public void setName(String dico) 
        throws PapillonBusinessException {
        try {
            myDO.setName(dico);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's name", ex);
        }
    }
    
  
    public String getFullName() 
        throws PapillonBusinessException {
        try {
            return myDO.getFullName();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's full name", ex);
        }
    }
	 public void setFullName(String dico) 
        throws PapillonBusinessException {
        try {
            myDO.setFullName(dico);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's full name", ex);
        }
    }
 
        public String getCategory() 
        throws PapillonBusinessException {
        try {
            return myDO.getCategory();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's category", ex);
        }
    }
	 public void setCategory(String cat) 
        throws PapillonBusinessException {
        try {
            myDO.setCategory(cat);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's category", ex);
        }
    }
    
        public String getType() 
        throws PapillonBusinessException {
        try {
            return myDO.getType();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's type", ex);
        }
    }
	 public void setType(String type) 
        throws PapillonBusinessException {
        try {
            myDO.setType(type);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's type", ex);
        }
    }
    
        public String getDomain() 
        throws PapillonBusinessException {
        try {
            return myDO.getDomain();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's domain", ex);
        }
    }
	 public void setDomain(String domain) 
        throws PapillonBusinessException {
        try {
            myDO.setDomain(domain);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's domain", ex);
        }
    }
    
        public String getLegal() 
        throws PapillonBusinessException {
        try {
            return myDO.getLegal();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's legal", ex);
        }
    }
	 public void setLegal(String legal) 
        throws PapillonBusinessException {
        try {
            myDO.setLegal(legal);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's legal", ex);
        }
    }
    
         public String getSourceLanguages() 
        throws PapillonBusinessException {
        try {
            return myDO.getSourceLanguages();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's sources", ex);
        }
    }
		
		public String[] getSourceLanguagesArray()
			throws PapillonBusinessException {
					return getSourceLanguages().split("\\s");
			}

		public void setSourceLanguages(String sources) 
        throws PapillonBusinessException {
        try {
            myDO.setSourceLanguages(sources);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's sources", ex);
        }
    }

		public String getTargetLanguages()
			throws PapillonBusinessException {
        try {
					return myDO.getTargetLanguages();
				}
				catch(DataObjectException ex) {
					throw new PapillonBusinessException("Error getting Dictionary's targets", ex);
        }
			}

		public String[] getTargetLanguagesArray() throws PapillonBusinessException {
			return getTargetLanguages().split("\\s");
    }
		
	 public void setTargetLanguages(String targets) 
        throws PapillonBusinessException {
        try {
            myDO.setTargetLanguages(targets);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Dictionary's targets", ex);
        }
    }
   
    public String getXmlCode()
        throws PapillonBusinessException {
        try {
	    return this.myDO.getXmlCode();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's xmlcode", ex);
        } 
    }
	  public void setXmlCode(String code)
        throws PapillonBusinessException {
        try {
		  		myDO.setXmlCode(code);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Dictionary's xmlcode", ex);
        }
    }

    public String getFormatterClassName() throws PapillonBusinessException {
        NodeList formatters = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-formatter"); 
        String classname = null;
        if ((null != formatters) && (formatters.getLength() > 0)) {
            classname = ((Element) formatters.item(0)).getAttribute("class-name");
        }
        return classname;
    }
  
    public String getPreProcessorClassName() throws PapillonBusinessException {
        NodeList preProcessor = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-preprocessor"); 
        String classname = null;
        if ((null != preProcessor) && (preProcessor.getLength() > 0)) {
            classname = ((Element) preProcessor.item(0)).getAttribute("class-name");
        }
        return classname;
	}
    
    public String getPostUpdateProcessorClassName() throws PapillonBusinessException {
        NodeList postProcessor = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-postupdateprocessor"); 
        String classname = null;
        if ((null != postProcessor) && (postProcessor.getLength() > 0)) {
            classname = ((Element) postProcessor.item(0)).getAttribute("class-name");
        }
        return classname;
	}
    
    public String getPostSaveProcessorClassName() throws PapillonBusinessException {
        NodeList postProcessor = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-postsaveprocessor"); 
        String classname = null;
        if ((null != postProcessor) && (postProcessor.getLength() > 0)) {
            classname = ((Element) postProcessor.item(0)).getAttribute("class-name");
        }
        return classname;
	}
   
    public void save() 
        throws PapillonBusinessException {
        try {
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving Dictionary", ex);
        }
    }
    
    /**
     * Deletes the Dictionary from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
     *   error).
     */
    public void deleteAll() throws PapillonBusinessException {
		Volume[] TheVolumes = VolumesFactory.getVolumesArray(this.getName());
		if (null != TheVolumes && TheVolumes.length > 0) {
			for (int i=0; i< TheVolumes.length; i++) {
				TheVolumes[i].deleteAll();
			}
		}
		this.delete();
	}

    public void delete() 
        throws PapillonBusinessException {
        try {
            this.myDO.delete();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error deleting Dictionary", ex);
        }
    }
}
