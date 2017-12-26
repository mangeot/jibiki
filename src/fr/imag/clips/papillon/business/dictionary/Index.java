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
 * 
 */

package fr.imag.clips.papillon.business.dictionary;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.data.IndexDO;

/**
 * Represents a volume index. 
 */
public class Index {

	protected static java.util.regex.Pattern quotePattern = java.util.regex.Pattern.compile("'");
	// Beware, for the text database columns, there is an UTF-8 conversion needed
	// but for the character columns, no need !
    
    /**
     * The DO of the Dictionary.
     */
    
    protected IndexDO myDO = null;

    /**
     * The public constructor.
     * Should find a better method instead of these if elsif elsif
     * How to do it ?
     */

    public Index(String tableName) throws PapillonBusinessException {
        try {
            this.myDO = IndexDO.createVirgin(tableName, CurrentDBTransaction.get());
        }
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty index", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty index", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the Volume.
     */
    protected Index(IndexDO theIndex) 
        throws PapillonBusinessException  {
        this.myDO = theIndex;
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
        } 
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting index's handle", ex);
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
    public String getTableName() {
        return this.myDO.getTableName(); 
    }

    /**
		* Gets the key of the index
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public String getKey()
        throws PapillonBusinessException {
			try {
				return myDO.getKey();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting index's key", ex);
			}
		}

    public void setKey(String key)
        throws PapillonBusinessException {
            try {
                myDO.setKey(key);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's key", ex);
            }
        }

    /**
		* Gets the language of the key
     *
     * @return the language as an ISO-639/2T 3 letters language code (fra, deu, eng, etc.).
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public String getLang()
        throws PapillonBusinessException {
			try {
				return myDO.getLang();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting index lang", ex);
			}
		}

    /**
		* Sets the language of the key
     *
     * @param the language as an ISO-639/2T 3 letters language code (fra, deu, eng, etc.).
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public void setLang(String lang)
        throws PapillonBusinessException {
            try {
                myDO.setLang(lang);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting index lang", ex);
            }
        }

	/**
	 * Gets the msort of the key
     *
     * @return the msort key
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
	public String getMsort()
	throws PapillonBusinessException {
		try {
			return myDO.getMsort();
		} catch(DataObjectException ex) {
			throw new PapillonBusinessException("Error getting index msort", ex);
		}
	}
	

    /**
		* Gets the value of the key
     *
     * @return the value as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public String getValue()
        throws PapillonBusinessException {
			try {
				return myDO.getValue();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting index's value", ex);
			}
		}

    /**
		* Sets the value of the key
     *
     * @param the value as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public void setValue(String value)
        throws PapillonBusinessException {
            try {
                myDO.setValue(value);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting index value", ex);
            }
        }

    /**
     * Gets the EntryId
	 *
     * @return the entry id.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
	public int getEntryId()
        throws PapillonBusinessException {
			try {
				return myDO.getEntryId();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting index's entry id", ex);
			}
		}

    /**
	 * Sets the entry id
     *
     * @param the entry id.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
     public void setEntryId(int entryId)
        throws PapillonBusinessException {
            try {
                myDO.setEntryId(entryId);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting index's entry id", ex);
            }
        }

    /**
        * Saves the index to the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
                        *   error).
     */
    public void save() 
        throws PapillonBusinessException {
        try {
			String msort = fr.imag.clips.papillon.papillon_data.ManageDatabase.multilingual_sort(this.getLang(), this.getValue());
			myDO.setMsort(msort);
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving index", ex);
        }
    }
    
    /**
     * Deletes the volume entry from the database.
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
            throw new PapillonBusinessException("Error deleting index", ex);
        }
    }
}
