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

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

/* for regular expressions */
import org.apache.regexp.*;
import java.util.Vector;

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
            this.myDO = DictionaryDO.createVirgin();  
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

    public boolean IsEmpty() {
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
        try {
					org.apache.regexp.RE myRegExp = new org.apache.regexp.RE("[:space:]");
					return myRegExp.split(getSourceLanguages());
				}
				catch(RESyntaxException ex) {
					throw new PapillonBusinessException("Error building the regular expression in Dictionary.getTargetLanguages", ex);
				}
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

		public String[] getTargetLanguagesArray() 
        throws PapillonBusinessException {
        try {
					org.apache.regexp.RE myRegExp = new org.apache.regexp.RE("[:space:]");
					return myRegExp.split(getTargetLanguages());
				}
					catch(RESyntaxException ex) {
						throw new PapillonBusinessException("Error building the regular expression in Dictionary.getTargetLanguages", ex);
					}
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
