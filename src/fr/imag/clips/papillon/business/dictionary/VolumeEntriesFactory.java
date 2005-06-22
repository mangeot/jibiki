/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.13  2005/06/22 15:55:53  mangeot
 * Solved an unresolved prefix bug when the dml prefix was not in the template entry.
 * Now we use the DmlPrefixResolver to solve this issue.
 *
 * Revision 1.12  2005/06/20 16:55:05  mangeot
 * multiple bug fixes
 *
 * Revision 1.11  2005/06/17 15:51:32  mangeot
 * Modified changeAuthor
 *
 * Revision 1.10  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.9  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.8.4.15  2005/06/15 10:08:06  mangeot
 * Removed the AND/OR connector, now only AND criteria can be added for dict lookup
 *
 * Revision 1.8.4.14  2005/06/14 11:56:16  mangeot
 * Added a new page ChangeAuthor for changing the author of a set of previously selected contributions
 *
 * Revision 1.8.4.13  2005/06/10 14:00:40  mangeot
 * Changed Edit to Copy and Edit when a copy of the original entry is done before editing
 *
 * Revision 1.8.4.12  2005/06/09 11:28:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.8.4.11  2005/06/09 11:07:45  mangeot
 * Deleted the countEntriesCache. entries counts are not cached any more.
 * Fixed a few bugs.
 *
 * Revision 1.8.4.10  2005/06/01 08:38:43  mangeot
 * Multi bug correction + added the possibility of disabling data edition
 * via the Admin.po page
 *
 * Revision 1.8.4.9  2005/05/27 11:53:21  mangeot
 * *** empty log message ***
 *
 * Revision 1.8.4.8  2005/05/20 17:02:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.8.4.7  2005/05/20 16:54:53  mangeot
 * Added ExportVolume functionnality
 *
 * Revision 1.8.4.6  2005/05/20 14:43:48  mangeot
 * Repair mismatch in branch tag
 *
 * Revision 1.8.4.5  2005/05/19 09:35:27  mangeot
 * Doing on ly one sql request when querying the volumes
 *
 * Revision 1.8.4.4  2005/05/14 11:56:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.8.4.3  2005/05/11 15:34:00  mangeot
 * *** empty log message ***
 *
 * Revision 1.8.4.2  2005/04/29 17:35:12  mangeot
 * *** empty log message ***
 *
 * Revision 1.8.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.8  2005/04/18 10:50:26  mangeot
 * Bug fix when displaying with IExplorer,
 * Bug fixes when seqencial request
 *
 * Revision 1.7  2005/04/15 13:20:08  mangeot
 * Added setIdIfNull
 *
 * Revision 1.6  2005/04/13 14:34:38  mangeot
 * Simplified the expert lookup. Now lookup directly the cdm element name
 *
 * Revision 1.5  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.4.2.10  2005/03/31 08:54:16  mangeot
 * Do not throw an error if the volume tables already exist
 *
 * Revision 1.4.2.9  2005/03/30 11:17:07  mangeot
 * Modified table contributions: replaced originalhandle by originalid
 * Corrected a few bugs when validating an already existing entry
 *
 * Revision 1.4.2.8  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.4.2.7  2005/02/25 10:23:07  mangeot
 * Bug fixes
 *
 * Revision 1.4.2.6  2005/02/06 22:43:49  mangeot
 * Merged the 2 Hashtables CDM Elements and XPaths into one
 * Added a boolean (reverse-lookup) in the volume metadata and functionalities in order to perform a reverse lookup when no direct lookup result is found
 * Added a boolean (index) in the volume metadata for indexing the only specified CDM Elements
 *
 * Revision 1.4.2.5  2005/01/28 23:01:09  mangeot
 * Fixed bugs in the editor. It seems to work now. More testing needed anyway...
 *
 * Revision 1.4.2.4  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.4.2.3  2005/01/27 23:55:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.2.2  2005/01/27 18:09:28  mangeot
 * Simple dictionary lookup is now working for GDEF.
 * Does not compile yet but cvs commit for backup
 *
 * Revision 1.4.2.1  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
 * Revision 1.4  2005/01/18 12:16:10  mangeot
 * Implemented the SQL LIMIT and OFFSET keywords. It allows us to retrieve the entries as blocks and page them. The LIMIT is the DictionariesFactory.MaxRetrievedEntries constant.
 * The implementation may need further tuning
 *
 * Revision 1.3  2005/01/18 09:41:11  mangeot
 * Recoded the countRows method with a new method that appeared with DODS 5.1
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
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.user.UsersFactory;

/* For the SQL statements */
import fr.imag.clips.papillon.data.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
* Used to find the instances of xslsheet.
 */
public class VolumeEntriesFactory {
	
	
	public final static String AUTHOR_SORT = "AUTHOR_SORT";
	public final static String CREATION_DATE_SORT = "CREATION_DATE_SORT";
	public final static String HEADWORD_SORT = "HEADWORD_SORT";
	public final static String ORIGINAL_CONTRIBUTION_ID_SORT = "ORIGINAL_CONTRIBUTION_ID_SORT";
	public final static String REVIEW_DATE_SORT = "REVIEW_DATE_SORT";
	public final static String REVIEWER_SORT = "REVIEWER_SORT";
	public final static String STATUS_SORT = "STATUS_SORT";
	
	// variables used in setGDEFFrenchTranslations
	protected final static String VOLUME_GDEF_est = "GDEF_est";
	protected final static String VOLUME_GDEF_fra = "GDEF_fra";
	protected final static String VOLUME_GDEF_tes = "GDEF_tes";
	protected final static String VOLUME_GDEF_est_sep = "#";
	protected final static String VOLUME_GDEF_est_prefix = "fra.";
	
	protected static com.lutris.dods.builder.generator.query.RDBColumn[] Columns = new com.lutris.dods.builder.generator.query.RDBColumn[1];
	
    /**
        * The getVolumeEntriesArray method performs a database query to
     * return an array of Dictionary entries
     * @return
     *     array of discs.
     * @exception PapillonBusinessException
     *   If there is a problem retrieving disc information.
     */
	
	
	public static Vector getVolumeEntriesVector(Dictionary dict, Volume volume, Vector Keys1, Vector Keys2, String any, int offset) throws PapillonBusinessException {
        Vector MyTable = null;
		PapillonLogger.writeDebugMsg("getVolumeEntriesVector: " + volume.getName());
        if (null != volume) {
            if (volume.getLocation().equals(Volume.LOCAL_LOCATION)) {
                MyTable = getDbTableEntriesVector(dict, volume,Keys1, Keys2, any, offset);
            }
            else if (volume.getLocation().equals(Volume.REMOTE_LOCATION)) {
                MyTable = getRemoteVolumeEntriesVector(dict, volume, Keys1, Keys2, any);
            }
        }
        return MyTable;
    }
	
	
    public static Vector getRemoteVolumeEntriesVector(Dictionary dict,
                                                      Volume volume,
                                                      Vector Keys1,
                                                      Vector Keys2,
                                                      String any) 
		throws PapillonBusinessException {
			Vector theEntries = new Vector();
			try {
				if (null != volume) {
					fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Remote Volume: " + volume.getName());
					if (volume.getName().equals("Lexico_eng")) {
						Wrapper myWrapper = WrappersFactory.createLexicoWrapper();
						RemoteEntry myEntry = new RemoteEntry();
						myEntry.setDictionary(dict);
						myEntry.setVolume(volume);
						// myEntry.setXmlCode(myWrapper.getResultXmlCode(Headwords));
						//               theEntries.put(myEntry.getHandle(),myEntry);
						//theEntries.add(myEntry);
					}
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getVolumeEntriesArray()", ex);
			}
			return theEntries;
		}
	
    public static Vector getVolumeNameEntriesVector(String volumeName,
                                                    Vector Keys1,
                                                    Vector Keys2,
													String any)
        throws PapillonBusinessException {
			return getVolumeNameEntriesVector(volumeName, Keys1, Keys2, any, 0);
		}
	
    public static Vector getVolumeNameEntriesVector(String volumeName,
                                                    Vector Keys,
                                                    Vector Clauses,
													String any,
													int offset)
        throws PapillonBusinessException {
			Vector resultVector = null;
			if (volumeName != null && !volumeName.equals("")) {
				Volume volume;
				Dictionary dict;
				try {
					volume = VolumesFactory.findVolumeByName(volumeName);
					if (volume != null && !volume.isEmpty()) {
						dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
						if (dict != null && !dict.isEmpty()) {
							resultVector = getDbTableEntriesVector(dict, volume, Keys, Clauses, any, offset);
						}
					}
				}
				catch(Exception ex) {
					throw new PapillonBusinessException("Exception in getVolumeNameEntriesVector()", ex);
				}
			}
			return resultVector;
        }
	
    protected static Vector getDbTableEntriesVector(Dictionary dict, Volume volume, Vector Keys, Vector Clauses, String any, int offset) throws PapillonBusinessException {
        Vector theEntries = theEntries = new Vector();
		
		String volumeTableName = volume.getDbname();
		if (null != volumeTableName) {
			try {
				com.lutris.dods.builder.generator.query.QueryBuilder myQueryBuilder = null; 
				com.lutris.dods.builder.generator.query.RDBColumn entryidColumn = IndexDO.getEntryIdColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn keyColumn = IndexDO.getKeyColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn langColumn = IndexDO.getLangColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn valueColumn = IndexDO.getValueColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBTable volumeEntryTable = new com.lutris.dods.builder.generator.query.RDBTable(volumeTableName);
				VolumeEntryDO myDO = VolumeEntryDO.createVirgin(volumeTableName);
				com.lutris.dods.builder.generator.query.RDBColumn objectidColumn = new com.lutris.dods.builder.generator.query.RDBColumn(volumeEntryTable, myDO.getOIdColumnName());
				// consultation of a local volume
				VolumeEntryQuery query = new VolumeEntryQuery(volumeTableName, CurrentDBTransaction.get());
				
				// distinct avoid to retreive the same entry twice
				// The distinct cannot be combined with an order by...
				// The ORDER BY clause can include items not appearing in the select list. 
				// However, if SELECT DISTINCT is specified, or if the SELECT statement contains a UNION operator,
				// the sort columns must appear in the select list.
				//query.getQueryBuilder().distinct();

				// looking for any string on the XML code, thus Sequencial request
				if (any !=null && !any.equals("")) {
					fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Sequencial request table: " + volumeTableName + " any: " + any);
					com.lutris.dods.builder.generator.query.RDBColumn xmlcodeColumn = VolumeEntryDO.getXmlCodeColumn(volume.getDbname());
					query.getQueryBuilder().addWhere(xmlcodeColumn, any, QueryBuilder.CASE_SENSITIVE_CONTAINS);
				}
				else {
					fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Index request table: " + volumeTableName);
				}
				
				if (Keys != null) {
					for (java.util.Enumeration enumKeys = Keys.elements(); enumKeys.hasMoreElements();) {
						String[] key = (String[]) enumKeys.nextElement();
						if (key!=null && key[2] !=null && !key[2].equals("")) {
							myQueryBuilder = new com.lutris.dods.builder.generator.query.QueryBuilder(Columns);
							if (IndexFactory.databaseVendor != null) {
								myQueryBuilder.setDatabaseVendor(IndexFactory.databaseVendor);
							} else {
								myQueryBuilder.setDatabaseVendor();
							}
							myQueryBuilder.addWhere(keyColumn, key[0], QueryBuilder.EQUAL);
							if (key[1] !=null && !key[1].equals("")) {
								myQueryBuilder.addWhere(langColumn, key[1], QueryBuilder.EQUAL);
							}
							myQueryBuilder.addWhere(valueColumn, key[2],  key[3]);
							myQueryBuilder.resetSelectedFields();
							myQueryBuilder.select(entryidColumn);
							query.getQueryBuilder().addWhereIn(objectidColumn, myQueryBuilder);
						}
					}
				}
				
				if (Clauses != null) {
					for (java.util.Enumeration enumClauses = Clauses.elements(); enumClauses.hasMoreElements();) {
						String clause = (String) enumClauses.nextElement();
						if (clause!=null && !clause.equals("")) {
							myQueryBuilder = new com.lutris.dods.builder.generator.query.QueryBuilder(Columns);
							if (IndexFactory.databaseVendor != null) {
								myQueryBuilder.setDatabaseVendor(IndexFactory.databaseVendor);
							} else {
								myQueryBuilder.setDatabaseVendor();
							}
							myQueryBuilder.addWhere(clause);
							myQueryBuilder.resetSelectedFields();
							myQueryBuilder.select(entryidColumn);
							query.getQueryBuilder().addWhereIn(objectidColumn, myQueryBuilder);
						}
					}
				}
				
				query.getQueryBuilder().setMaxRows(DictionariesFactory.MaxRetrievedEntries);
				query.getQueryBuilder().addEndClause("OFFSET " + offset);
				query.getQueryBuilder().addOrderByColumn(volume.getSourceLanguage()+"_sort(headword)","");
				// debug
				//query.getQueryBuilder().debug();
			
				VolumeEntryDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					// my implementation of the SELECT DISTINCT
					// maybe takes too much time in computation...
					// maybe it isn't needed with a select from where in. To be tested
					/*
					java.util.List myList = java.util.Arrays.asList(DOarray);
					for (int j=0; j < DOarray.length; j++) {
						VolumeEntryDO myTmpDO = DOarray[j];
						if (j==0 || !myList.subList(0,j-1).contains(myTmpDO)) {
							VolumeEntry tempEntry = new VolumeEntry(dict, volume,myTmpDO);
							theEntries.add(tempEntry);
						}
					}
					 */
					for (int j=0; j < DOarray.length; j++) {
						VolumeEntry tempEntry = new VolumeEntry(dict, volume, DOarray[j]);
						theEntries.add(tempEntry);
					}
					
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getDbtableEntriesVector()", ex);
			}
		}
		return theEntries;
	}
	
    public static int getDbTableEntriesCount(Volume volume, Vector Keys, Vector clausesVector, String any) throws PapillonBusinessException {
        int countEntries = 0;
		
		String volumeTableName = volume.getDbname();
		if (null != volumeTableName) {
			try {
				com.lutris.dods.builder.generator.query.QueryBuilder myQueryBuilder = null; 
				com.lutris.dods.builder.generator.query.RDBColumn entryidColumn = IndexDO.getEntryIdColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn keyColumn = IndexDO.getKeyColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn langColumn = IndexDO.getLangColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn valueColumn = IndexDO.getValueColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBTable volumeEntryTable = new com.lutris.dods.builder.generator.query.RDBTable(volumeTableName);
				VolumeEntryDO myDO = VolumeEntryDO.createVirgin(volumeTableName);
				com.lutris.dods.builder.generator.query.RDBColumn objectidColumn = new com.lutris.dods.builder.generator.query.RDBColumn(volumeEntryTable, myDO.getOIdColumnName());
				VolumeEntryQuery query = new VolumeEntryQuery(volumeTableName, CurrentDBTransaction.get());
				if (any !=null && !any.equals("")) {
					fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Sequencial count request table: " + volumeTableName + " any: " + any);
					com.lutris.dods.builder.generator.query.RDBColumn xmlcodeColumn = VolumeEntryDO.getXmlCodeColumn(volume.getDbname());
					query.getQueryBuilder().addWhere(xmlcodeColumn, any, QueryBuilder.CASE_SENSITIVE_CONTAINS);
				}
				else {
					fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Index count request table: " + volumeTableName);
				}
				if (Keys !=null) {
					for (java.util.Enumeration enumKeys = Keys.elements(); enumKeys.hasMoreElements();) {
						String[] key = (String[]) enumKeys.nextElement();
						if (key!=null && key[2] !=null && !key[2].equals("")) {
							myQueryBuilder = new com.lutris.dods.builder.generator.query.QueryBuilder(Columns);
							if (IndexFactory.databaseVendor != null) {
								myQueryBuilder.setDatabaseVendor(IndexFactory.databaseVendor);
							} else {
								myQueryBuilder.setDatabaseVendor();
							}
							myQueryBuilder.addWhere(keyColumn, key[0], QueryBuilder.EQUAL);
							if (key[1] !=null && !key[1].equals("")) {
								myQueryBuilder.addWhere(langColumn, key[1], QueryBuilder.EQUAL);
							}
							myQueryBuilder.addWhere(valueColumn, key[2],  key[3]);
							myQueryBuilder.resetSelectedFields();
							myQueryBuilder.select(entryidColumn);
							query.getQueryBuilder().addWhereIn(objectidColumn, myQueryBuilder);
						}
					}
				}
				
				if (clausesVector != null) {
					for (java.util.Enumeration enumClauses = clausesVector.elements(); enumClauses.hasMoreElements();) {
						String clause = (String) enumClauses.nextElement();
						if (clause!=null && !clause.equals("")) {
							myQueryBuilder = new com.lutris.dods.builder.generator.query.QueryBuilder(Columns);
							if (IndexFactory.databaseVendor != null) {
								myQueryBuilder.setDatabaseVendor(IndexFactory.databaseVendor);
							} else {
								myQueryBuilder.setDatabaseVendor();
							}
							myQueryBuilder.addWhere(clause);
							myQueryBuilder.resetSelectedFields();
							myQueryBuilder.select(entryidColumn);
							query.getQueryBuilder().addWhereIn(objectidColumn, myQueryBuilder);
						}
					}
				}
				query.getQueryBuilder().distinct();
				countEntries += query.getCount();
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getDbtableEntriesCount()", ex);
			}
		}
		return countEntries;
	}
	
    protected static void processVolume(Dictionary dict, Volume volume, Vector myKeys, Vector myClauses, IVolumeEntryProcessor myProcessor) throws PapillonBusinessException {
		final int MaxRetrievedEntries = 500;
		int offset = 0;
		boolean stop = false;
		try {
			String volumeTableName = volume.getDbname();
			if (null != volumeTableName) {
				fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Sequencial process request table: " + volumeTableName);
				
				com.lutris.dods.builder.generator.query.QueryBuilder myQueryBuilder = null; 
				com.lutris.dods.builder.generator.query.RDBColumn entryidColumn = IndexDO.getEntryIdColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn keyColumn = IndexDO.getKeyColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn langColumn = IndexDO.getLangColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBColumn valueColumn = IndexDO.getValueColumn(volume.getIndexDbname());
				com.lutris.dods.builder.generator.query.RDBTable volumeEntryTable = new com.lutris.dods.builder.generator.query.RDBTable(volumeTableName);
				VolumeEntryDO myDO = VolumeEntryDO.createVirgin(volumeTableName);
				com.lutris.dods.builder.generator.query.RDBColumn objectidColumn = new com.lutris.dods.builder.generator.query.RDBColumn(volumeEntryTable, myDO.getOIdColumnName());
				
				// consultation of a local volume
				while (!stop) {
					VolumeEntryQuery query = new VolumeEntryQuery(volumeTableName, CurrentDBTransaction.get());
					
					if (myKeys !=null) { 
						for (java.util.Enumeration enumKeys = myKeys.elements(); enumKeys.hasMoreElements();) {
							String[] key = (String[]) enumKeys.nextElement();
							if (key!=null && key[2] !=null && !key[2].equals("")) {
								myQueryBuilder = new com.lutris.dods.builder.generator.query.QueryBuilder(Columns);
								if (IndexFactory.databaseVendor != null) {
									myQueryBuilder.setDatabaseVendor(IndexFactory.databaseVendor);
								} else {
									myQueryBuilder.setDatabaseVendor();
								}
								myQueryBuilder.addWhere(keyColumn, key[0], QueryBuilder.EQUAL);
								if (key[1] !=null && !key[1].equals("")) {
									myQueryBuilder.addWhere(langColumn, key[1], QueryBuilder.EQUAL);
								}
								myQueryBuilder.addWhere(valueColumn, key[2],  key[3]);
								myQueryBuilder.resetSelectedFields();
								myQueryBuilder.select(entryidColumn);
								query.getQueryBuilder().addWhereIn(objectidColumn, myQueryBuilder);
							}
						}
					}
					
					if (myClauses != null) {
						for (java.util.Enumeration enumClauses = myClauses.elements(); enumClauses.hasMoreElements();) {
							String clause = (String) enumClauses.nextElement();
							if (clause!=null && !clause.equals("")) {
								myQueryBuilder = new com.lutris.dods.builder.generator.query.QueryBuilder(Columns);
								if (IndexFactory.databaseVendor != null) {
									myQueryBuilder.setDatabaseVendor(IndexFactory.databaseVendor);
								} else {
									myQueryBuilder.setDatabaseVendor();
								}
								myQueryBuilder.addWhere(clause);
								myQueryBuilder.resetSelectedFields();
								myQueryBuilder.select(entryidColumn);
								query.getQueryBuilder().addWhereIn(objectidColumn, myQueryBuilder);
							}
						}
					}
					
					query.getQueryBuilder().setMaxRows(MaxRetrievedEntries);
					query.getQueryBuilder().addEndClause("OFFSET " + offset);
					//query.getQueryBuilder().distinct();
					query.getQueryBuilder().addOrderByColumn(volume.getSourceLanguage()+"_sort(headword)","");
					VolumeEntryDO[] DOarray = query.getDOArray();
					if (null != DOarray) {
						for (int j=0; j < DOarray.length; j++) {
							myProcessor.process(new VolumeEntry(dict, volume,DOarray[j]));
						}
						offset += DOarray.length;
					}
					stop = DOarray == null || DOarray.length<MaxRetrievedEntries;
				}
			}
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in processVolume()", ex);
		}
	}
	
	public static void changeAuthor(Volume myVolume, User validator, String newAuthorLogin, Vector myKeys, Vector clausesVector) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
			if (myVolume !=null && !myVolume.isEmpty()) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
				if (myDict !=null && !myDict.isEmpty()) {
					User authorUser = UsersFactory.findUserByLogin(newAuthorLogin);
					if (authorUser == null || authorUser.isEmpty()) {
						authorUser = new User();
						authorUser.setLogin(newAuthorLogin);
					}
					IVolumeEntryProcessor changeAuthorProcessor = new ChangeAuthorProcessor(validator, authorUser);
					processVolume(myDict, myVolume, myKeys, clausesVector, changeAuthorProcessor);
				}
			}
		}


	public static void exportVolume(String volumeName, Vector myKeys, Vector clauseVector, java.io.OutputStream myOutStream) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
			Volume myVolume = VolumesFactory.findVolumeByName(volumeName);
			if (myVolume !=null && !myVolume.isEmpty()) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
				if (myDict !=null && !myDict.isEmpty()) {
					
					String tmplEntry = myVolume.getTemplateEntry();
					String contribString = myVolume.getCdmContribution();
					String xmlHeader = "";
					String xmlFooter = "";
					if (tmplEntry.indexOf("<" + contribString)>=0) {
						xmlHeader = tmplEntry.substring(0,tmplEntry.indexOf("<" + contribString));
						String endTag = "</" + contribString + ">";
						xmlFooter = tmplEntry.substring(tmplEntry.indexOf(endTag)+endTag.length()+1);
					}
					
					fr.imag.clips.papillon.business.dictionary.IVolumeEntryProcessor myProcessor = new fr.imag.clips.papillon.business.dictionary.ExportVolumeEntryProcessor(myOutStream);
					
					PapillonLogger.writeDebugMsg("Start writing volume " + volumeName);
					try {
						myOutStream.write(xmlHeader.getBytes("UTF-8"));
						fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory.processVolume(myDict, myVolume, myKeys, clauseVector, myProcessor);
						myOutStream.write(xmlFooter.getBytes("UTF-8"));
					}
					catch (Exception ex) {
						throw new PapillonBusinessException("Error in writing an UTF-8 String: ", ex);
					}
				}
			}
		}
	
	public static Vector getFoksEntriesVector(String headword) throws PapillonBusinessException {
        Vector theEntries = new Vector();
        try {
			// consultation of a local volume
			FoksEntryQuery query = new FoksEntryQuery(CurrentDBTransaction.get());
			//set query
			if (headword != null && !headword.equals("")) {
				fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Indexed request table: foksentry word: " + headword);
				query.setQueryReading(headword);
				query.addOrderByScore(false);
				FoksEntryDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int i=0; i < DOarray.length; i++) {
						theEntries.add(new FoksEntry(DOarray[i]));
					}
				}
			}
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in getFoksEntriesVector()", ex);
		}
		return theEntries;
	}
	
	
	public static VolumeEntry getJMDictVolumeEntry(String headword) throws PapillonBusinessException {
		// FIXME: special code depending on FoksEdict and JmDict dictionaries
        VolumeEntry myAnswer = null;
		Vector theEntries = null;
		//Headword[0] = key
		//Headword[1] = lang
		//Headword[2] = value
		String[] Headword = new String[4];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = "jpn";
		Headword[2] = headword;
		Headword[3] = "" + IQuery.STRATEGY_EXACT;
		Vector myVector = new Vector();
		myVector.add(Headword);
        try {
			Volume volume = VolumesFactory.findVolumeByName("JMDict_jpn_eng");
			if (volume != null && !volume.isEmpty()) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(volume.getDictname());
				theEntries = IndexFactory.getEntriesVector(myDict, volume, myVector, null,0);
			}
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in getJMDictEntriesVector()", ex);
		}
		if (theEntries !=null && theEntries.size()>0) {
			myAnswer = (VolumeEntry) theEntries.elements().nextElement();
		}
		return myAnswer;
	}
	
	
    /**
        * The findEntryByHandle method performs a database query to
     * return a id object
     *
     * @param id, the object id of the entries table.
     * @return
     *     the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static VolumeEntry findEntryByHandle(String volumeName, String handle)
        throws PapillonBusinessException {
			Volume volume;
            Dictionary dict;
            try {
                volume = VolumesFactory.findVolumeByName(volumeName);
                dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            }
            catch(Exception ex) {
				return null;
            }
			return findEntryByHandle(dict, volume, handle);
		}
	
	protected static VolumeEntry findEntryByHandle(Dictionary myDict, Volume myVolume, String handle)
        throws PapillonBusinessException {
			VolumeEntry theEntry = null;
			VolumeEntryDO theVolumeEntryDO = null;
			
			int intId = 0;
			try {
				intId = Integer.parseInt(handle);
			}
			catch(NumberFormatException ex) {
				return theEntry;
			}												
			
            try {
                VolumeEntryQuery query = new VolumeEntryQuery(myVolume.getDbname(), CurrentDBTransaction.get());
                //set query
                query.setQueryOId(new ObjectId(intId));
                // Throw an exception if more than one message is found
                query.requireUniqueInstance();
                theVolumeEntryDO = query.getNextDO();
                theEntry = new VolumeEntry(myDict, myVolume,theVolumeEntryDO);
                return theEntry;
            } catch(Exception ex) {
				return theEntry;
            }
        }
	
    /**
		* The findEntryByKey method performs a database query to
     * return a VolumeEntry
     *
     * @param Dictionary, Volume, key, lang, value
     * @return the corresponding VolumeEntry
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
	protected static VolumeEntry findEntryByKey(Dictionary myDict, Volume myVolume, String key, String lang, String value) throws PapillonBusinessException {
		VolumeEntry resEntry = null;
		if (value != null && !value.equals("")) {
			try {
				IndexQuery query = new IndexQuery(myVolume.getIndexDbname(), CurrentDBTransaction.get());
				query.getQueryBuilder().addWhereClause("key", key, QueryBuilder.EQUAL);
				if (lang != null) {
					query.getQueryBuilder().addWhereClause("lang", lang, QueryBuilder.EQUAL);
				}
				query.getQueryBuilder().addWhereClause("value", value, QueryBuilder.EQUAL);
				query.getQueryBuilder().setMaxRows(1);
				IndexDO[] DOarray = query.getDOArray();
				if (null != DOarray && DOarray.length>0) {
					Index myIndex = new Index(DOarray[0]);
					resEntry = findEntryByHandle(myDict, myVolume, myIndex.getEntryId());
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in findEntryByKey()", ex);
			}
		}
		return resEntry;
	}
	
    /**
		* The findEntryByEntryId method performs a database query to
     * return a VolumeEntry
     *
     * @param id, the object id of the entries table.
     * @return the corresponding VolumeEntry
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static VolumeEntry findEntryByEntryId(String volumeName, String entryId)
        throws PapillonBusinessException {
			Volume volume;
            Dictionary dict;
            try {
                volume = VolumesFactory.findVolumeByName(volumeName);
                dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            }
            catch(Exception ex) {
				return null;
            }
			return findEntryByEntryId(dict, volume, entryId);
		}
	
	protected static VolumeEntry findEntryByEntryId(Dictionary myDict, Volume myVolume, String entryId)
        throws PapillonBusinessException {
			return findEntryByKey(myDict, myVolume, Volume.CDM_entryId, Volume.DEFAULT_LANG, entryId);
        }
		
    public static VolumeEntry newEntry(Dictionary dict, Volume volume, String headword, org.w3c.dom.Document docdom)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
            VolumeEntry newEntry=new VolumeEntry(dict, volume);
            //dom avant toute chose !
            newEntry.setDom((org.w3c.dom.Document) docdom.cloneNode(true));
            //headword
            newEntry.setHeadword(headword);
			
			newEntry.setEntryId();
            
            return newEntry;
        }
	
	public static VolumeEntry newEntryFromExisting(VolumeEntry existingEntry) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			VolumeEntry resEntry = newEntry(existingEntry.getDictionary(), existingEntry.getVolume(), existingEntry.getHeadword(), existingEntry.getDom());
			return resEntry;
		}
	
	public static VolumeEntry createEmptyEntry(String volume) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		VolumeEntry myEntry = null;
		Volume myVolume = VolumesFactory.findVolumeByName(volume);
		if (myVolume != null && !myVolume.isEmpty()) {
			Dictionary myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
			if (myDict != null && !myDict.isEmpty()) {
				myEntry = new VolumeEntry(myDict, myVolume);
				String templateEntry = myVolume.getTemplateEntry();
				myEntry.setDom(Utility.buildDOMTree(templateEntry));
			}
		}
		return myEntry;
	}
	
    public static void emptyVolumeEntries(String volume)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
                ManageDatabase.truncateTable(volume);
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in emptyVolumeEntries with volume: " + volume, e);
            }
        }
	
	public static void createVolumeTables(Volume volume)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
				// this if is bad code, temporary solution !
				if (!volume.getDbname().equals("papillonaxi")) {
					ManageDatabase.createVolumeTable(volume.getDbname());
				}
				IndexFactory.createIndexTable(volume);
			}
            catch (Exception e) {
				//   throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in createVolumeTables with volume: " + volume.getName(), e);
				PapillonLogger.writeDebugMsg("Exception in createVolumeTables with volume: " + volume.getName() + ", probably the tables already exist.");
            }			
		}
	
	
	
    public static void dropVolumeTables(Volume volume)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
                //FIXME: this if is bad code, temporary solution !
                if (volume.getName().equals(PapillonPivotFactory.VOLUMENAME)) {
                    ManageDatabase.truncateTable(volume.getDbname());
                }
                else {
                    ManageDatabase.dropTable(volume.getDbname());
                }
				IndexFactory.dropIndexTable(volume.getIndexDbname());
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in deleteVolumeTable with volume: " + volume, e);
            }
        }
	
	public static String setGDEFFrenchTranslations(IAnswer myAnswer, String homographId) throws PapillonBusinessException {
		String homographWord = "";
		//Headword[0] = key
		//Headword[1] = lang
		//Headword[2] = value
		//Headword[3] = strategy
		String[] Headword = new String[4];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = "fra";
		Headword[2] = "";
		Headword[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
		
		
		Volume myVolume = myAnswer.getVolume();
		if (myVolume.getName().equals(VOLUME_GDEF_est) ||
			myVolume.getName().equals(VOLUME_GDEF_tes)) {
			NodeList myNodeList = ParseVolume.getCdmElements((VolumeEntry)myAnswer,Volume.CDM_translationReflexie,"fra");
			if ((myNodeList != null) && (myNodeList.getLength()>0)) {
				for (int i=0; i<myNodeList.getLength();i++) {
					org.w3c.dom.Node myNode = myNodeList.item(i);
					String word = myNode.getNodeValue();
					if (word !=null && !word.equals("") && word.indexOf(VOLUME_GDEF_est_prefix)!=0) {
						int lastchar = word.lastIndexOf(VOLUME_GDEF_est_prefix);
						if (lastchar>=0 && word.length()>lastchar) {
							word = word.substring(lastchar+1);
						}
						lastchar = word.lastIndexOf(VOLUME_GDEF_est_sep);
						if (lastchar>=0 && word.length()>lastchar) {
							word = word.substring(lastchar+1);
						}
						Headword[2] = word;
						Vector myVector = new Vector();
						myVector.add(Headword);
						Vector myTable = getVolumeNameEntriesVector(VOLUME_GDEF_fra,
																	myVector,
																	null,
																	null);
						if (myTable.size()==0) {
							myNode.setNodeValue(VOLUME_GDEF_est_sep + myTable.size() + VOLUME_GDEF_est_sep + word);
						}
						else if (myTable.size()==1) {
							VolumeEntry newAnswer = (VolumeEntry) myTable.elements().nextElement();
							myNode.setNodeValue(newAnswer.getId());
						}
						else if (myTable.size()>1 && homographId !=null && !homographId.equals("")) {
							String nodeValue = null;
							int k=0;
							while (homographId!="" && k<myTable.size()) {
								VolumeEntry newAnswer = (VolumeEntry) myTable.elementAt(k);
								if (newAnswer.getEntryId().equals(homographId)) {
									nodeValue = homographId;
									homographId = "";
								}
								k++;
							}
							if (nodeValue == null || nodeValue.equals("")) {
								nodeValue = VOLUME_GDEF_est_sep + myTable.size() + VOLUME_GDEF_est_sep + word;
							}
							myNode.setNodeValue(nodeValue);
						}
						else {
							homographWord = word;
							myNode.setNodeValue(VOLUME_GDEF_est_sep + myTable.size() + VOLUME_GDEF_est_sep + word);
						}
					}
				}
			}
		}
		return homographWord;
	}
	
	public static void sort (Vector EntryVector) {
		sort (EntryVector, HEADWORD_SORT);
	}
	
	public static void sort (Vector EntryVector, String sortBy) {
		if (sortBy.equals(AUTHOR_SORT)) {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.AuthorComparator());
		}
		else if (sortBy.equals(CREATION_DATE_SORT)) {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.CreationDateComparator());
		}
		else if (sortBy.equals(HEADWORD_SORT)) {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.HeadwordComparator());
		}
		else if (sortBy.equals(ORIGINAL_CONTRIBUTION_ID_SORT)) {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.OriginalContributionIdComparator());
		}
		else if (sortBy.equals(REVIEW_DATE_SORT)) {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.ReviewDateComparator());
		}
		else if (sortBy.equals(REVIEWER_SORT)) {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.ReviewerComparator());
		}
		else if (sortBy.equals(STATUS_SORT)) {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.StatusComparator());
		}
		else {
			Collections.sort(EntryVector, new fr.imag.clips.papillon.business.utility.HeadwordComparator());
		}
	}
	
}

