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
 * Revision 1.1  2003/10/04 03:19:18  mangeot
 * FoksEntry is a special entry designed for the FoksEdict volume created
 * by Slaven Bilac for the FOKS query module.
 * It is not used in the main program but I keep it for future use.
 *
 * Revision 1.2  2003/08/14 08:30:11  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
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

/**
 * Represents a volume index. 
 */
public class FoksEntry {
	// Beware, for the text database columns, there is an UTF-8 conversion needed
	// but for the character columns, no need !
    
    /**
     * The DO of the Dictionary.
     */
    
    protected FoksEntryDO myDO = null;

    /**
     * The public constructor.
     */

    public FoksEntry() throws PapillonBusinessException {
        try {
            this.myDO = FoksEntryDO.createVirgin();
        }
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty index", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty index", ex);
        }
    }

    public FoksEntry(String id, String headword, String reading, String score) throws PapillonBusinessException {
        try {
            this.myDO = FoksEntryDO.createVirgin();
            this.setId(id);
            this.setHeadword(headword);
            this.setReading(reading);
            this.setScore(score);
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
    protected FoksEntry(FoksEntryDO theEntry) 
        throws PapillonBusinessException  {
        this.myDO = theEntry;
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
        } 
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting FoksEntry's handle", ex);
        }
    }

    /**
		* Gets the id of the FoksEntry
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
     
     
	public int getId()
        throws PapillonBusinessException {
            try {
		return myDO.getId();
		} catch(DataObjectException ex) {
		throw new PapillonBusinessException("Error getting FoksEntry id", ex);
		}
	}

     public void setId(String id)
        throws PapillonBusinessException {
        try {
            this.setId(Integer.parseInt(id));
        } 
        catch(Exception ex) {
                throw new PapillonBusinessException("Error setting FoksEntry's id ", ex);
        }
    }

    public void setId(int id)
        throws PapillonBusinessException {
            try {
                myDO.setId(id);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting FoksEntry's id ", ex);
            }
        }

    /**
		* Gets the headword of the FoksEntry's
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public String getHeadword()
        throws PapillonBusinessException {
	try {
            return myDO.getHeadword();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting FoksEntry's headword", ex);
        }
    }

    public void setHeadword(String headword)
        throws PapillonBusinessException {
            try {
                myDO.setHeadword(headword);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting FoksEntry's headword", ex);
            }
        }

    /**
		* Gets the reading of the FoksEntry's
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public String getReading()
        throws PapillonBusinessException {
	try {
            return myDO.getReading();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting FoksEntry's reading", ex);
        }
    }

    public void setReading(String reading)
        throws PapillonBusinessException {
            try {
                myDO.setReading(reading);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting FoksEntry's reading", ex);
            }
        }


    /**
		* Gets the score of the FoksEntry
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public String getScoreString() throws PapillonBusinessException {
            try {
                float score = this.getScore();
                return Float.toString(score);
            } catch(Exception ex) {
		throw new PapillonBusinessException("Error getting FoksEntry score", ex);
            }
	}

	public float getScore()
        throws PapillonBusinessException {
            try {
		return myDO.getScore();
		} catch(DataObjectException ex) {
		throw new PapillonBusinessException("Error getting FoksEntry score", ex);
		}
	}

     public void setScore(String score)
        throws PapillonBusinessException {
        try {
            this.setScore(Float.parseFloat(score));
        } 
        catch(Exception ex) {
                throw new PapillonBusinessException("Error setting FoksEntry's score ", ex);
        }
    }
    public void setScore(float score)
        throws PapillonBusinessException {
            try {
                myDO.setScore(score);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting FoksEntry's score", ex);
            }
        }



    /**
        * Saves the volume entry from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
                        *   error).
     */
    public void save() 
        throws PapillonBusinessException {
        try {
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving FoksEntry", ex);
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
            throw new PapillonBusinessException("Error deleting FoksEntry", ex);
        }
    }
}
