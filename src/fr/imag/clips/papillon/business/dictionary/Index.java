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
 * Revision 1.2  2003/08/14 08:30:11  mangeot
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
 * Revision 1.1.2.3  2003/08/07 06:29:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.2  2003/07/31 16:15:59  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.1  2003/07/31 12:51:18  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.5  2003/06/25 09:54:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.4  2003/06/23 09:30:29  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.3  2003/05/28 09:17:16  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1.2.2  2003/05/21 10:15:08  mangeot
 * Travail sur l'interface d'edition
 *
 * Revision 1.1.1.1.2.1  2003/05/20 10:51:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.13  2002/10/25 14:10:29  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.12.2.2  2002/10/23 09:51:07  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.12.2.1  2002/10/02 16:28:41  serasset
 * The headword is now correctly encoded (UTF-8), as it is a longvarchar.
 *
 * Revision 1.12  2002/09/17 17:13:21  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.11  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.10  2002/09/12 06:50:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.9.8.1  2002/08/09 09:15:13  mangeot
 * Improvements for the simple consultation
 * adding text for help,
 * correcting consultation bugs
 *
 * Revision 1.9  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.8  2002/05/08 13:14:46  mangeot
 * I rewrote some files of the data layer in order to be dependent
 * from the number of tables for the Volum Entries.
 * The next step is to generate tables on the fly with the pgsql jdbc driver
 *
 * Revision 1.7  2002/04/17 17:09:23  mangeot
 * Travail sur les stylesheets
 *
 * Revision 1.6  2002/04/14 09:47:12  mangeot
 * lecture des elements CDM ds les fichiers volume-metadata
 * et upload des entrees
 *
 * Revision 1.5  2002/03/27 09:51:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/03/25 09:50:40  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/03/20 09:36:20  mangeot
 * Now the consultation is done in a separate db table for each volume
 * A big pb remaining: the data directory has to be remodified by hands...
 *
 * Revision 1.2  2002/03/19 09:11:40  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/03/11 11:15:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/12/18 13:41:36  serasset
 * *** empty log message ***
 *
 * Revision 1.5  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.4  2001/07/12 20:56:38  salvati
 * ratrapage de la perte du fichier
 *
 * Revision 1.4  2001/07/11 15:30:25  serasset
 * Suppression des tables author et threads. Utilisation d'une table unique "Dictionarys".
 *
 * Revision 1.3  2001/07/09 16:37:29  serasset
 * Liens entre l'application enhydra et la base de donnees PostgreSQL.
 * Suppression du dossier data de la hierarchie CVS
 * Premiere version de la mailing list.
 *
 * Revision 1.2  2001/07/04 12:50:43  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
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
public class Index {
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
            this.myDO = IndexDO.createVirgin(tableName);
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
		* Gets the key of the index
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public String getEntryId()
        throws PapillonBusinessException {
			try {
				return myDO.getEntryId();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting index's entry", ex);
			}
		}

    public void setEntryId(String entryId)
        throws PapillonBusinessException {
            try {
                myDO.setEntryId(entryId);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting index's entry", ex);
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
