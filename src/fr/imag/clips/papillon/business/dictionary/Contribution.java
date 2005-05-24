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
 * Revision 1.5  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.4  2005/04/15 11:38:05  mangeot
 * Fixed a bug, not using entryHandle from contributions table any more
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.3  2005/03/30 11:17:07  mangeot
 * Modified table contributions: replaced originalhandle by originalid
 * Corrected a few bugs when validating an already existing entry
 *
 * Revision 1.2.2.2  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2.2.1  2005/03/16 13:24:31  serasset
 * Modified all boolean fields in table to CHAR(1) in order to be more db independant.
 * Suppressed ant.jar from class path, informationfiles (which rely on it) should be corrected.
 * The version of Xerces is now displayed on application init.
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.9  2004/11/19 15:14:31  mangeot
 * Modified these sources in order to use a specific sort function in the database.
 * The lexicographic order depends on the language, thus I wrote a special function for sorting words.
 * In order to use this function, I had to add a column in the contributions table. This column is called sourcelanguage and is used to store the source language of the contrib.
 * Old papillon databases have to be updated this way:
 *
 * alter table contributions add sourcelanguage varchar(255);
 * update contributions set sourcelanguage=volumes.sourcelanguage where volumes.name=contributions.volume;
 * alter table contributions alter sourcelanguage set not null;
 *
 * and the sql script src/sql/multilingual_sort.sql has to be loaded into the database!
 *
 * Revision 1.6  2004/10/16 09:47:47  mangeot
 * New mechanism for reviewing the contributions:
 * Step 1 revision, the status of the contrib is modified
 * Step 2 validation, the status of the contrib is modified
 * Step 3 integration into the database, the contrib is deleted and the entry inserted into the corresponding volume
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

import java.util.Vector;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.CurrentDBTransaction;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;


/**
 * Represents a Mailing list Dictionary. 
 */
public class Contribution {

		public final static String NOT_FINISHED_STATUS = "not finished";
		public final static String FINISHED_STATUS = "finished";
		public final static String REVISED_STATUS = "revised";
		public final static String VALIDATED_STATUS = "validated";
		public final static String INTEGRATED_STATUS = "integrated";

    /**
     * The DO of the Dictionary.
     */
    protected fr.imag.clips.papillon.data.ContributionDO myDO = null;

    /**
     * The public constructor.
     */
    public Contribution() throws PapillonBusinessException {
        try {
			this.myDO = ContributionDO.createVirgin(CurrentDBTransaction.get());

        }
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty contribution", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty contribution", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the Contribution.
     */				
    protected Contribution(ContributionDO theContribution) 
        throws PapillonBusinessException  {
			this.myDO = theContribution;
		}

    public boolean isEmpty() {
        return (this.myDO==null) ;
    }


    /**
     * Gets the handle of the contribution
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
            throw new PapillonBusinessException("Error getting Contribution's handle", ex);
        }
    }


    /**
        * Gets the author of the contribution
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    public String getAuthor()
        throws PapillonBusinessException {
            try {
                return myDO.getAuthor();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting contribution's author", ex);
            }
        }

    public void setAuthor(String author)
        throws PapillonBusinessException {
            try {
                myDO.setAuthor(author);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting contribution's author", ex);
            }
        }


    /**
        * Gets the groups of the contribution
     *
     * @return the groups.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
		public String[] getGroupsArray() throws PapillonBusinessException {
			String[] Groups = null;
			String groups = getGroups();
			if (null != groups && !groups.equals("")){
			// delete the first separator in order to avoid an empty group
				if (groups.indexOf(User.GROUPS_SEPARATOR_STRING) ==0) {
					groups = groups.substring(User.GROUPS_SEPARATOR_STRING.length());
				}
				Groups = groups.split(User.GROUPS_SEPARATOR_STRING);
			}
			return Groups;
		}
        
        protected String getGroups()
            throws PapillonBusinessException {
                try {
                   return myDO.getGroups();

                } catch(DataObjectException ex) {
                    throw new PapillonBusinessException("Error getting user's groups", ex);
                }
            }
        protected void setGroups(String groups)
            throws PapillonBusinessException {
                try {
                myDO.setGroups(groups);

                } catch(DataObjectException ex) {
                    throw new PapillonBusinessException("Error setting user's groups", ex);
                }
            }
        public void setGroupsArray(String[] Groups)
            throws PapillonBusinessException {
                String groups = null;
                if (null != groups && Groups.length >0) {
                    for (int i=0; i< Groups.length; i++) {
                        groups = groups + User.GROUPS_SEPARATOR_STRING + Groups[i];
                    }
                }
                groups.trim();
                setGroups(groups);
            }
    /**
        * Gets the volume name of the contribution
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    public String getVolumeName()
        throws PapillonBusinessException {
            try {
                return myDO.getVolume();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting contribution's volume", ex);
            }
        }

    public void setVolumeName(String volume)
        throws PapillonBusinessException {
            try {
                myDO.setVolume(volume);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting contribution's volume", ex);
            }
        }

    /**
        * Gets the source language of the contribution
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    public String getSourceLanguage()
        throws PapillonBusinessException {
            try {
                return myDO.getSourceLanguage();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting contribution's source language", ex);
            }
        }

    public void setSourceLanguage(String lang)
        throws PapillonBusinessException {
            try {
                myDO.setSourceLanguage(lang);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting contribution's source language", ex);
            }
        }

    /**
        * Gets the headword of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
	public String getHeadword () throws PapillonBusinessException {
        try {
            return this.myDO.getHeadword();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting contribution entry id", ex);
        }
	}

	public String getHeadwords () throws PapillonBusinessException {
		return this.getHeadword();
	}	
		
    public void setHeadword(String headword)
        throws PapillonBusinessException {
            try {
                myDO.setHeadword(headword);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's headword", ex);
            }
        }

    /**
     * Gets the id of the entry created with this contribution
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getEntryId()
        throws PapillonBusinessException {
        try {
            return this.myDO.getEntryId();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting contribution entry id", ex);
        }
    }

		public void setEntryId(String entryId)
        throws PapillonBusinessException {
        try {
		  		myDO.setEntryId(entryId);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting contribution entry id", ex);
        }
    }

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
            throw new PapillonBusinessException("Error setting InformationDocument's FileType", ex);
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
            throw new PapillonBusinessException("Error setting InformationDocument's FileType", ex);
        }
    }

    
    /**
        * Gets the reviewer of the contribution
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    public String getReviewer()
        throws PapillonBusinessException {
            try {
                return myDO.getReviewer();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting contribution's reviewer", ex);
            }
        }

    public void setReviewer(String author)
        throws PapillonBusinessException {
            try {
                myDO.setReviewer(author);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting contribution's reviewer", ex);
            }
        }

    /**
		 * Get getReviewDate of the InformationDocument
     *
     * @return getReviewDate of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public java.sql.Date getReviewDate () throws PapillonBusinessException {
        try {
            return this.myDO.getReviewDate();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting getReviewDate", ex);
        }
    }

    /**
		 * Set ReviewDate of the InformationDocument
     *
     * @param CreationDate of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setReviewDate ( java.sql.Date date ) throws PapillonBusinessException {
        try {
            myDO.setReviewDate(date);
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting setReviewDate", ex);
        }
    }

    /**
        * Set setReviewDate of the InformationDocument
     *
     * @param setReviewDate (as a java.util.Date) of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setReviewDate ( java.util.Date date ) throws PapillonBusinessException {
        try {
            myDO.setReviewDate(new java.sql.Date(date.getTime()));
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's FileType", ex);
        }
    }

    /**
        * Gets the status of the contribution
     *
     * @return the status.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    public String getStatus()
        throws PapillonBusinessException {
            try {
                return myDO.getStatus();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting contribution's status", ex);
            }
        }

    public void setStatus(String status)
        throws PapillonBusinessException {
            try {
                myDO.setStatus(status);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting contribution's status", ex);
            }
        }

    /**
     * boolean newEntry
		 * true if the contribution is an ew entry built from scratch
		 * false if it is a modification of an existing entry or contribution
		 *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
 public boolean IsNewEntry () throws PapillonBusinessException {
        try {
            String ne = this.myDO.getNewEntry();
            return ((ne != null) && ne.equals("Y"));
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting contribution newEntry", ex);
        }
    }

 
    public void setNewEntry (boolean newEntry) throws PapillonBusinessException {
        try {
            myDO.setNewEntry(newEntry ? "Y" : "N");   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting contribution newEntry", ex);
        }
    }
   
    /**
     * Gets the id of the original entry that has been modified with this contribution
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getOriginalId()
        throws PapillonBusinessException {
        try {
            return this.myDO.getOriginalId();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting contribution original entry id", ex);
        }
    }

		public void setOriginalId(String entryId)
        throws PapillonBusinessException {
        try {
		  		myDO.setOriginalId(entryId);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting contribution original entry id", ex);
        }
    }


	  /**
		 * Deletes the volume from the database.
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
            throw new PapillonBusinessException("Error saving contribution", ex);
        }
    }

    /**
     * Deletes the volume from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
     *   error).
     */		
		public void delete() throws PapillonBusinessException {
        try {
            this.myDO.delete();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error deleting contribution", ex);
        }
    }
}
