/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.3  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.2.2.4  2004/01/12 14:10:20  mangeot
 * bug fixed
 *
 * Revision 1.2.2.3  2004/01/09 05:18:57  mangeot
 * Bugs fixes !
 *
 * Revision 1.2.2.2  2004/01/08 09:43:19  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.2.2.1  2004/01/06 09:07:02  mangeot
 * Added transitivity in Axies. I don't build a new axie if a lexie is already linked to an axie !
 * I corrected some bugs with axies and index
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
 * Revision 1.1.2.6  2003/08/14 04:15:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.5  2003/08/09 07:21:04  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.1.2.4  2003/08/07 06:29:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.3  2003/08/05 05:18:46  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.2  2003/07/31 16:15:59  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.1  2003/07/31 12:51:19  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.22  2003/07/01 07:14:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.21  2003/06/30 13:25:26  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.20  2003/06/30 08:33:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.19  2003/06/30 08:27:18  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.18  2003/06/30 08:01:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.17  2003/06/30 06:58:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.16  2003/06/30 06:26:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.15  2003/06/30 05:56:46  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.14  2003/06/30 05:34:59  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.13  2003/06/30 05:26:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.12  2003/06/30 05:16:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.11  2003/06/30 05:08:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.10  2003/06/30 04:05:40  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.9  2003/06/30 02:58:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.8  2003/06/27 05:28:42  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.7  2003/06/27 02:13:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.6  2003/06/25 09:54:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.5  2003/06/23 04:56:05  mangeot
 * bug fixed
 *
 * Revision 1.3.2.4  2003/06/21 17:56:37  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.3  2003/05/28 09:17:15  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.3.2.2  2003/05/08 07:43:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.1  2003/02/18 03:27:53  mangeot
 * Development for the editing interface
 *
 * Revision 1.3  2003/02/16 05:19:21  mangeot
 * All the keys except the entry id are in multiple value format, ie with a '#' on both sides.
 * Therefore, we have to reload all the dicitonaries if we want to look for pos, pron, etc.
 *
 * Revision 1.2  2002/11/22 13:04:10  mangeot
 * Nouvelle version Papillon enhydra 5.0
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.21  2002/10/25 14:10:29  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.20.2.2  2002/10/23 09:51:07  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.20.2.1  2002/10/10 06:46:51  mangeot
 * Corrected a bug pb between lang and DocLang in consultInformations
 * Created a new sql function to count the number of entries for the volumes
 * added in Adminvolumes.java and dictd.show server
 *
 * Revision 1.20  2002/09/17 20:29:32  mangeot
 * Bug corrected, version deploy 1_4 ready !
 *
 * Revision 1.19  2002/09/17 17:13:21  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.18  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.17  2002/09/11 17:35:08  mangeot
 * Added config from config file for dictd server
 *
 * Revision 1.16  2002/09/11 16:28:13  mangeot
 * Added classes to implement dict protocol rfc 2229
 *
 * Revision 1.15.6.4  2002/08/09 09:15:13  mangeot
 * Improvements for the simple consultation
 * adding text for help,
 * correcting consultation bugs
 *
 * Revision 1.15.6.3  2002/08/08 09:11:57  mangeot
 * New Home page with simplified interface a lot of work
 * + localization in german
 *
 * Revision 1.15.6.2  2002/08/02 16:39:14  mangeot
 * Bug Report, bug not yet fixed:
 * the query of French diacritics is ok on macOsX but not on Linux bushido
 *
 * Revision 1.15.6.1  2002/08/02 16:04:56  mangeot
 * Desole, besoin de tester un bug sur bushido !
 *
 * Revision 1.15  2002/06/04 03:59:39  mangeot
 * bugs corrected for volumeEntriesFactory plus
 * I added the research for title and author in consltInformations
 *
 * Revision 1.14  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.13  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.12  2002/05/08 13:14:46  mangeot
 * I rewrote some files of the data layer in order to be dependent
 * from the number of tables for the Volum Entries.
 * The next step is to generate tables on the fly with the pgsql jdbc driver
 *
 * Revision 1.11  2002/05/07 10:31:22  mangeot
 * The UTF-8 consultation is now OK,
 * I tested with omniweb, iexplorer and netscape latests versions on macosX
 *
 * Revision 1.10  2002/05/02 07:02:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.8  2002/04/17 19:18:22  mangeot
 * I deleted the form AdminXml.po and created another one:
 * AddEntries.po
 * Now you can't add entries without a metadata file associated.
 *
 * Revision 1.7  2002/04/16 14:23:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/03/27 09:51:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/03/25 09:50:40  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/03/20 09:36:20  mangeot
 * Now the consultation is done in a separate db table for each volume
 * A big pb remaining: the data directory has to be remodified by hands...
 *
 * Revision 1.1  2002/03/20 04:30:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2002/03/11 11:15:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/10/17 13:02:03  serasset
 * Distinction entre Doucmuent (abstrait) et fichier (qui constituent concretement un doucument)
 *
 * Revision 1.5  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.4  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.3  2001/07/12 20:38:45  salvati
 * Added Node2String function and use of it
 *
 * Revision 1.2  2001/07/12 17:58:00  salvati
 * end of debug
 * CV: ----------------------------------------------------------------------
 *
 * Revision 1.1  2001/07/12 17:38:08  salvati
 * Renaming DictionaryFactory in DictionarEntriesFactory
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.papillon_data.*;

// For parsing
import java.io.*;

// For vectors
import java.util.*;

// For the SAX parser
import org.apache.xerces.parsers.*;
import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;


//import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;


import fr.imag.clips.papillon.business.utility.*;

/* For the SQL statements */
import fr.imag.clips.papillon.data.*;

/**
* Used to find the instances of xslsheet.
 */
public class IndexFactory {

	public final static String INDEX_TABLE_PREFIX = "idx";
	
	protected final static String INDEXED_FIELD = "key";
	protected final static String CONTRIB_SEP = "$";

    protected static Vector getEntriesVector(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pron, String reading, String key1,String key2) throws PapillonBusinessException {
        Vector theIndex = new Vector();

		theIndex.add(id);
		theIndex.add(pron);
		theIndex.add(reading);
		theIndex.add(key1);
		theIndex.add(key2);
		if (Headwords != null && Headwords.length>0) {
			for (int i=0; i< Headwords.length;i++) {
				theIndex.add(Headwords[i]);
			}
		}
		return getEntriesVector(dict, volume, strategy, theIndex);
	}

	protected static Vector getEntriesVector(Dictionary dict, Volume volume, int strategy, Vector theIndex) throws PapillonBusinessException {
			Vector theEntries = new Vector();
			VolumeEntry myEntry = null;

		String CSE = QueryBuilder.EQUAL;
		String CSS = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
		String cmp_op = CSE;

		if (strategy == IQuery.STRATEGY_PREFIX) {
			cmp_op = CSS;
		}

		for (int i=0; i< theIndex.size();i++) {
			Object myObject = theIndex.elementAt(i);
			if (myObject != null) {
				String myString = (String) myObject;
				if (!myString.equals("")) {
					try {
						fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Indexed request table: " + volume.getIndexDbname() + " word: " + myString);
						IndexQuery query = new IndexQuery(volume.getIndexDbname());
						query.getQueryBuilder().addWhereClause("key", myString, cmp_op);
						//query.addOrderByKey(true);
						query.getQueryBuilder().addOrderByColumn(volume.getSourceLanguage()+"_sort(key)","");
						IndexDO[] DOarray = query.getDOArray();
						if (null != DOarray) {
							for (int j=0; j < DOarray.length; j++) {
								Index myIndex = new Index(DOarray[j]);
								myEntry = VolumeEntriesFactory.findEntryByHandle(dict, volume, myIndex.getEntryId());
								theEntries.add(myEntry);
							//	theEntries.put(myEntry.getHeadword(),myEntry);
							}
						}
					}
					catch(Exception ex) {
						throw new PapillonBusinessException("Exception in getEntriesVector()", ex);
					}
				}
			}
		}
		return theEntries;
    }
		
	protected static Vector getAxiesVector(Dictionary dict, Volume volume, String id) throws PapillonBusinessException {
        Vector theEntries = new Vector();

		String cmp_op = QueryBuilder.EQUAL;

		if (id != null && !id.equals("")) {
			try {
				IndexQuery query = new IndexQuery(volume.getIndexDbname());
				query.getQueryBuilder().addWhereClause("key", id, cmp_op);
				IndexDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						Index myIndex = new Index(DOarray[j]);
						Axie myAxie = PapillonPivotFactory.findAxieByHandle(dict, volume, myIndex.getEntryId());
						theEntries.add(myAxie);
					}
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getAxiesVector()", ex);
			}
		}
		return theEntries;
    }

	protected static Vector getIndexVectorByEntryId(Volume volume, String entryId) throws PapillonBusinessException {
        Vector theIndex = new Vector();

		String cmp_op = QueryBuilder.EQUAL;

		if (entryId != null && !entryId.equals("")) {
			try {
				IndexQuery query = new IndexQuery(volume.getIndexDbname());
			//	query.getQueryBuilder().addWhereClause("entryid", entryId, cmp_op);
				query.setQueryEntryId(entryId);
				IndexDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						theIndex.add(new Index(DOarray[j]));
					}
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getIndexVectorByEntryId()", ex);
			}
		}
		return theIndex;
    }

	protected static boolean createIndexForHashtable(String indexDbname, Axie myAxie)
		throws PapillonBusinessException {
			Hashtable lexies = myAxie.getLexies();
			if (lexies != null) {
				Iterator myIterator = lexies.values().iterator();
				while (myIterator.hasNext()) {
					Vector myVector = (Vector) myIterator.next();
					if (myVector != null && myVector.size()>0) {
						for (int i=0;i<myVector.size();i++) {
							String myString = (String) myVector.elementAt(i);
							if (myString != null && !myString.equals("")) {
								Index myIndex = IndexFactory.newIndex(indexDbname, myString,myAxie.getHandle());
								myIndex.save();
							}
						}
					}
				}				
			}
			return true;
		}	

		
		protected static boolean createIndexFromVector(String indexDbname, Vector myVector, String handle)
	throws PapillonBusinessException {
			 boolean result = false;
		if (myVector != null && myVector.size()>0) {
			for (int i=0; i< myVector.size();i++) {
					String myString = (String) myVector.elementAt(i);
					createIndexFromString(indexDbname, myString, handle);
			}
			result=true;
		}
		return result;
	}

		protected static boolean createIndexFromString(String indexDbname, String key, String handle) 
		 throws PapillonBusinessException {
		 boolean result = false;
			if (key != null && !key.equals("")) {
						Index myIndex = IndexFactory.newIndex(indexDbname, key,handle);
						myIndex.save();
						result=true;
				}
				return result;
	}



	protected static void deleteIndexForEntryId(String indexDbname, String entryId) throws 	PapillonBusinessException {
		Vector theIndex = new Vector();

		String cmp_op = QueryBuilder.EQUAL;

	if (entryId != null && !entryId.equals("")) {
		try {
			IndexQuery query = new IndexQuery(indexDbname);
			query.setQueryEntryId(entryId);
			IndexDO[] DOarray = query.getDOArray();
			if (null != DOarray) {
				for (int j=0; j < DOarray.length; j++) {
					Index myIndex = new Index(DOarray[j]);
					myIndex.delete();
					}
				}
			}
catch(Exception ex) {
				throw new PapillonBusinessException("Exception in deleteIndexForEntryId()", ex);
}
		}
    }

public static Index newIndex(String table, String index, String handle)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			//
            Index newIndex=new Index(table);
            // external id
            newIndex.setKey(index);
            //xml code
            newIndex.setEntryId(handle);
			return newIndex;
        }

	
	
    public static void emptyIndex(String table)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
                ManageDatabase.truncateTable(table);
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in emptyIndex with table: " + table, e);
            }
        }


	public static void createIndexTable(Volume volume)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
                    ManageDatabase.createIndexTable(volume.getIndexDbname());
				createIndexForTable(volume.getIndexDbname());
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in createIndexTable for volume: " + volume.getName(), e);
            }
        }

	protected static void createIndexForTable(String table)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
                    ManageDatabase.createIndexForTable(table,INDEXED_FIELD);
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in createIndexForTable: " + table, e);
            }
        }

	public static void dropIndexTable(String table)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
				ManageDatabase.dropTable(table);
				// the index is dropped along with the table
	//			ManageDatabase.dropIndexForTable(table,INDEXED_FIELD);
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in dropIndexTable: " + table, e);
            }
        }

	public static void truncateIndexTable(String table)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
				ManageDatabase.truncateTable(table);
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in truncateIndexTable: " + table, e);
            }
        }
}

