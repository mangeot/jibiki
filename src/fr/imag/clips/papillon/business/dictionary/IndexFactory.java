/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.4  2005/01/18 12:16:10  mangeot
 * Implemented the SQL LIMIT and OFFSET keywords. It allows us to retrieve the entries as blocks and page them. The LIMIT is the DictionariesFactory.MaxRetrievedEntries constant.
 * The implementation may need further tuning
 *
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
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

    protected static Vector getEntriesVector(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pron, String reading, String key1,String key2, int offset) throws PapillonBusinessException {
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
		return getEntriesVector(dict, volume, strategy, theIndex, offset);
	}

	protected static Vector getEntriesVector(Dictionary dict, Volume volume, int strategy, Vector theIndex, int offset) throws PapillonBusinessException {
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
						//query.getQueryBuilder().distinct();
						query.getQueryBuilder().setMaxRows(DictionariesFactory.MaxRetrievedEntries);
						query.getQueryBuilder().addEndClause("OFFSET " + offset);						
						query.getQueryBuilder().addOrderByColumn(volume.getSourceLanguage()+"_sort(key)","");
						IndexDO[] DOarray = query.getDOArray();
						if (null != DOarray) {
							for (int j=0; j < DOarray.length; j++) {
								Index myIndex = new Index(DOarray[j]);
								myEntry = VolumeEntriesFactory.findEntryByHandle(dict, volume, myIndex.getEntryId());
								theEntries.add(myEntry);
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

