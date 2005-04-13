/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.6  2005/04/13 14:34:38  mangeot
 * Simplified the expert lookup. Now lookup directly the cdm element name
 *
 * Revision 1.5  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.4.2.7  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.4.2.6  2005/02/06 22:43:49  mangeot
 * Merged the 2 Hashtables CDM Elements and XPaths into one
 * Added a boolean (reverse-lookup) in the volume metadata and functionalities in order to perform a reverse lookup when no direct lookup result is found
 * Added a boolean (index) in the volume metadata for indexing the only specified CDM Elements
 *
 * Revision 1.4.2.5  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.4.2.4  2005/01/27 23:55:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.2.3  2005/01/27 18:09:28  mangeot
 * Simple dictionary lookup is now working for GDEF.
 * Does not compile yet but cvs commit for backup
 *
 * Revision 1.4.2.2  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
 * Revision 1.4.2.1  2005/01/25 13:54:54  mangeot
 * changed the volume volumeEntry and index objects. Does not compile but need a backup...
 *
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
import fr.imag.clips.papillon.CurrentDBTransaction;

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
	
	protected final static String KEY_FIELD = "key";
	protected final static String LANG_FIELD = "lang";
	protected final static String VALUE_FIELD = "value";
	protected final static String ENTRYID_FIELD = "entryid";
	protected final static String CONTRIB_SEP = "$";
		
	protected static Vector getEntriesVector(Dictionary dict, Volume volume, Vector theKeys, int strategy, int offset) throws PapillonBusinessException {
		Vector theEntries = new Vector();
		VolumeEntry myEntry = null;
		
		
		String CSE = QueryBuilder.EQUAL;
		String CSS = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
		String cmp_op = CSE;
		
		if (strategy == IQuery.STRATEGY_PREFIX) {
			cmp_op = CSS;
		}
		
		for (java.util.Enumeration enumKeys = theKeys.elements(); enumKeys.hasMoreElements();) {
			//myKey[0] = key
			//myKey[1] = lang
			//myKey[2] = value
			String[] myKey = (String[]) enumKeys.nextElement();
			if (myKey[2] !=null && !myKey[2].equals("")) {
				try {
					fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Indexed request table: " + volume.getIndexDbname() + " :: " +  myKey[0] + "/" + myKey[1] + "/" + myKey[2]);
					IndexQuery query = new IndexQuery(volume.getIndexDbname(), CurrentDBTransaction.get());
					query.getQueryBuilder().addWhereClause(KEY_FIELD, myKey[0], QueryBuilder.EQUAL);
					if (myKey[1] !=null && !myKey[1].equals("")) {
						query.getQueryBuilder().addWhereClause(LANG_FIELD, myKey[1], QueryBuilder.EQUAL);
					}
					query.getQueryBuilder().addWhereClause(VALUE_FIELD, myKey[2], cmp_op);
					query.getQueryBuilder().setMaxRows(DictionariesFactory.MaxRetrievedEntries);
					query.getQueryBuilder().addEndClause("OFFSET " + offset);
					query.getQueryBuilder().addOrderByColumn("multilingual_sort(lang,value)","");
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
		return theEntries;
	}
	
	protected static Vector getAxiesVector(Dictionary dict, Volume volume, String id) throws PapillonBusinessException {
		Vector theEntries = new Vector();
		
		String cmp_op = QueryBuilder.EQUAL;
		
		if (id != null && !id.equals("")) {
			try {
				IndexQuery query = new IndexQuery(volume.getIndexDbname(), CurrentDBTransaction.get());
				query.getQueryBuilder().addWhereClause(KEY_FIELD, Volume.CDM_entryId, QueryBuilder.EQUAL);
				query.getQueryBuilder().addWhereClause(LANG_FIELD, Axie.LANG, QueryBuilder.EQUAL);
				query.getQueryBuilder().addWhereClause(VALUE_FIELD, id, cmp_op);
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
		
		if (entryId != null && !entryId.equals("")) {
			try {
				IndexQuery query = new IndexQuery(volume.getIndexDbname(), CurrentDBTransaction.get());
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
	
	protected static boolean createIndexForLexiesHashtable(String indexDbname, Axie myAxie)
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
								Index myIndex = IndexFactory.newIndex(indexDbname, Volume.CDM_entryId, Axie.LANG,myString,myAxie.getHandle());
								myIndex.save();
							}
						}
					}
				}				
			}
			return true;
		}	
	
	
	protected static void deleteIndexForEntryId(String indexDbname, String entryId) throws 	PapillonBusinessException {
		Vector theIndex = new Vector();
		
		String cmp_op = QueryBuilder.EQUAL;
		
		if (entryId != null && !entryId.equals("")) {
			try {
				IndexQuery query = new IndexQuery(indexDbname, CurrentDBTransaction.get());
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
	
	public static Index newIndex(String table, String key, String lang, String value, String handle)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			//
			Index newIndex=new Index(table);
			// name of the key
			newIndex.setKey(key);
			// lang of the key
			if (lang.length()==3) {
				newIndex.setLang(lang);
			}
			else {
				newIndex.setLang(Volume.DEFAULT_LANG);
			}
			// value of the key
			newIndex.setValue(value);
			// entry id
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
				ManageDatabase.createIndexForTable(table,KEY_FIELD, KEY_FIELD, LANG_FIELD, VALUE_FIELD);
				ManageDatabase.createIndexForTable(table,ENTRYID_FIELD);
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

