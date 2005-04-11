/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
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

/* For the SQL statements */
import fr.imag.clips.papillon.data.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
* Used to find the instances of xslsheet.
 */
public class VolumeEntriesFactory {
	
	// variables used in setGDEFFrenchTranslations
	protected final static String VOLUME_GDEF_est = "GDEF_est";
	protected final static String VOLUME_GDEF_fra = "GDEF_fra";
	protected final static String VOLUME_GDEF_est_sep = "#";
	protected final static String VOLUME_GDEF_est_prefix = "fra.";
	
    /**
        * The getVolumeEntriesArray method performs a database query to
     * return an array of Dictionary entries
     * @return
     *     array of discs.
     * @exception PapillonBusinessException
     *   If there is a problem retrieving disc information.
     */
	
	
	
    public static Vector getVolumeEntriesVector(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy) throws PapillonBusinessException {
		return getVolumeEntriesVector(dict, volume, id, Headwords, strategy,
									  null, null, null, null, null, null, null, null,0);
	}
	
	public static Vector getVolumeEntriesVector(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pos, String pron, String reading, String trans, String transLang, String key1,String key2,String any, int offset) throws PapillonBusinessException {
        Vector MyTable = null;
		String headword = "";
		if (Headwords != null && Headwords.length>0) {
			headword = Headwords[0];
		}
		else {
			headword = trans;
		}
		PapillonLogger.writeDebugMsg("getVolumeEntriesVector: " + volume.getName() + " hw:" + headword);
        if (null != volume) {
            if (volume.getLocation().equals(Volume.LOCAL_LOCATION)) {
                MyTable = getDbTableEntriesVector(dict, volume,id,Headwords,strategy,pos,pron,reading,trans,transLang, key1,key2,any, offset);
            }
            else if (volume.getLocation().equals(Volume.REMOTE_LOCATION)) {
                MyTable = getRemoteVolumeEntriesVector(dict,volume,id,Headwords,pos,pron,reading, trans,transLang, key1,key2,any);
            }
        }
        return MyTable;
    }
	
	
    public static Vector getRemoteVolumeEntriesVector(Dictionary dict,
                                                      Volume volume,
                                                      String id,
                                                      String[] Headwords,
                                                      String pos,
                                                      String pron,
                                                      String reading,
                                                      String trans,
                                                      String transLang,
                                                      String key1,
                                                      String key2,
                                                      String any) throws PapillonBusinessException {
														  Vector theEntries = new Vector();
														  try {
															  if (null != volume) {
																  fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Remote Volume: " + volume.getName());
																  if (volume.getName().equals("Lexico_eng")) {
																	  Wrapper myWrapper = WrappersFactory.createLexicoWrapper();
																	  RemoteEntry myEntry = new RemoteEntry();
																	  myEntry.setDictionary(dict);
																	  myEntry.setVolume(volume);
																	  if (null != Headwords && Headwords.length >0) {
																		  myEntry.setHeadword(Headwords[0]);
																	  }
																	  myEntry.setXmlCode(myWrapper.getResultXmlCode(Headwords));
																	  //               theEntries.put(myEntry.getHandle(),myEntry);
																	  theEntries.add(myEntry);
																  }
															  }
														  }
														  catch(Exception ex) {
															  throw new PapillonBusinessException("Exception in getVolumeEntriesArray()", ex);
														  }
														  return theEntries;
													  }
	
	public static Vector getVolumeNameEntriesVector(String volumeName,
													String id,
													String[] Headwords,
													int strategy)
		throws PapillonBusinessException {
			return getVolumeNameEntriesVector(volumeName, id, Headwords, strategy,
											  null, null, null, null, null, null, null, null);
		}
	
    public static Vector getVolumeNameEntriesVector(String volumeName,
                                                    String id,
                                                    String[] Headwords,
                                                    int strategy,
													String pos,
                                                    String pron,
                                                    String reading,
                                                    String trans,
                                                    String transLang,
                                                    String key1,
                                                    String key2,
                                                    String any)
        throws PapillonBusinessException {
            Volume volume;
            Dictionary dict;
            try {
                volume = VolumesFactory.findVolumeByName(volumeName);
                dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumeNameEntriesVector()", ex);
            }
            return getDbTableEntriesVector(dict, volume, id, Headwords, strategy, pos, pron, reading, trans, transLang, key1,key2,any, 0);
        }
	
    protected static Vector getDbTableEntriesVector(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pos, String pron, String reading, String trans, String transLang, String key1,String key2,String any, int offset) throws PapillonBusinessException {
        Vector theEntries = new Vector();
		
		// In this case, we can use the Index file !		
		//	((pos == null || pos.equals("")) &&
		//	 (trans == null || trans.equals("")) &&
		if	 (any == null || any.equals("")) {
			theEntries = IndexFactory.getEntriesVector(dict, volume, id, Headwords, strategy, pron, reading, trans, transLang, key1, key2, offset);
		}
		// MM-FIXME: a revoir
		/*		else
			try {
				String volumeTable = volume.getDbname();
				if (null != volumeTable) {
					// I know, it is an uggly code !
					// If you have a nicer solution...
					if (null == Headwords || Headwords.length == 0) {
						Headwords = new String[1];
						Headwords[0] = null;
					}
					String CIC = QueryBuilder.CASE_INSENSITIVE_CONTAINS;
					String CSC = QueryBuilder.CASE_SENSITIVE_CONTAINS;
					String CIE = QueryBuilder.CASE_INSENSITIVE_EQUAL;
					String CSE = QueryBuilder.EQUAL;
					String CIS = QueryBuilder.CASE_INSENSITIVE_STARTS_WITH;
					String CSS = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
					String cmp_op = CIE;
					
					// initialization of the variables
					// the headword is initialized afterwards
					for (int i=0; i < Headwords.length; i++) {
						String headword = Headwords[i];
						fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Sequencial request table: " + volumeTable + " word: " + headword);
						
						// consultation of a local volume
						VolumeEntryQuery query = new VolumeEntryQuery(volumeTable, CurrentDBTransaction.get());
						
						if (null == headword) {headword = "";}
						else {headword = headword.trim();}
						
						// Different strategies
						if (strategy == IQuery.STRATEGY_EXACT) {
							cmp_op = CSS;
						}
						else if (strategy == IQuery.STRATEGY_PREFIX) {
							cmp_op = CSS;
						}
						else if (strategy == IQuery.STRATEGY_SUFFIX) {
							cmp_op = CSC;
						}
						if (strategy == IQuery.STRATEGY_INSENSITIVE_EXACT) {
							cmp_op = CIS;
						}
						else if (strategy == IQuery.STRATEGY_INSENSITIVE_PREFIX) {
							cmp_op = CIS;
						}
						else if (strategy == IQuery.STRATEGY_INSENSITIVE_SUFFIX) {
							cmp_op = CIC;
						}
						else if (strategy == IQuery.STRATEGY_INSENSITIVE_SUBSTRING) {
							cmp_op = CIC;
						}
						else {
							cmp_op = CIC;
						}
						
						
						// building the query
						if (!headword.equals("")) {
							query.getQueryBuilder().addWhereClause("headword", headword, cmp_op);
						}
						if (!any.equals("")) {
							query.getQueryBuilder().addWhereClause("xmlcode", any, CIC);
						}
						
						// query.addOrderByHeadword(true);
						//	query.getQueryBuilder().addEndClause("ORDER BY " + volume.getSourceLanguage()+"_sort(headword)");
						query.getQueryBuilder().setMaxRows(DictionariesFactory.MaxRetrievedEntries);
						query.getQueryBuilder().addEndClause("OFFSET " + offset);						
						//		query.getQueryBuilder().addOrderByColumn(volume.getSourceLanguage()+"_sort(headword)","");
						VolumeEntryDO[] DOarray = query.getDOArray();
						if (null != DOarray) {
							for (int j=0; j < DOarray.length; j++) {
								VolumeEntry tempEntry = new VolumeEntry(dict, volume,DOarray[j]);
								theEntries.add(tempEntry);
							}
						}
					}
				}
			}
        catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getDbtableEntriesVector()", ex);
        }
		*/
        return theEntries;
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
		String[] Headwords = new String[] {headword};
        try {
			Volume volume = VolumesFactory.findVolumeByName("JMDict_jpn_eng");
			if (volume != null && !volume.IsEmpty()) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(volume.getDictname());
				theEntries = IndexFactory.getEntriesVector(myDict, volume, null, Headwords, IQuery.STRATEGY_EXACT, null, null, null, null, null, null,0);
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
				query.getQueryBuilder().addWhereClause("lang", lang, QueryBuilder.EQUAL);
				query.getQueryBuilder().addWhereClause("value", value, QueryBuilder.EQUAL);
				query.getQueryBuilder().setMaxRows(1);
				IndexDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
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
	
	/*    public static void parseVolume (String volumeName, String URL)
        throws PapillonBusinessException {
			Volume volume = VolumesFactory.findVolumeByName(volumeName);
			Dictionary dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            if (!volume.IsEmpty()) {
                parseVolume(dict, volume,URL);
            }
        }
	
	
    public static void parseVolume (Dictionary dict, Volume volume, String URL)
        throws PapillonBusinessException {
			if (volume.getName().equals(ParseVolume.FOKSEDICT_VOLUME)) {
				ParseVolume.parseFoksVolume(URL);
			}
			else
				try {
					// Tools for parsing with a SAX parser
					SAXParserFactory mySAXParserFactory = SAXParserFactory.newInstance();
					//indicate here if you want the parser to be namespace aware or not
					mySAXParserFactory.setNamespaceAware(true);
					// test if this dictionary will be edited.
					// if yes, the content should be validated!
					// FIXME: should be a lot more explicit
					String schema = volume.getXmlSchema();
					String templateEntry = volume.getTemplateEntry();
					if ((schema != null && !schema.equals("")) &&
						(templateEntry != null && !templateEntry.equals(""))) {
						PapillonLogger.writeDebugMsg("The XML parser will validate!");
						mySAXParserFactory.setValidating(true);
					}
					//building the constructor of the document
					SAXParser mySAXParser = mySAXParserFactory.newSAXParser();
					VolumeHandler myHandler = new VolumeHandler(dict, volume);
					
					mySAXParser.parse(URL, myHandler);
					VolumesFactory.setCountEntries(volume);
				}
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in parseVolume(): " + URL, ex);
            }
        }
	*/
	
    public static VolumeEntry newEntry(Dictionary dict, Volume volume, String headword, org.w3c.dom.Document docdom)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
            VolumeEntry newEntry=new VolumeEntry(dict, volume);
            //headword
            newEntry.setHeadword(headword);
            //dom
            newEntry.setDom((org.w3c.dom.Document) docdom.cloneNode(true));
			
			newEntry.setId();
            
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
		if (myVolume != null && !myVolume.IsEmpty()) {
			Dictionary myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
			if (myDict != null && !myDict.IsEmpty()) {
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
				VolumesFactory.resetCountEntries(volume);
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in emptyVolumeEntries with volume: " + volume, e);
            }
        }
	
	public static int getCount(Volume myVolume) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			int count = -1;
			try {
                VolumeEntryQuery query = new VolumeEntryQuery(myVolume.getDbname(), CurrentDBTransaction.get());
				count = query.getCount();
			}
			catch (com.lutris.appserver.server.sql.DatabaseManagerException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			catch (java.sql.SQLException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			catch (com.lutris.dods.builder.generator.query.DataObjectException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			catch (com.lutris.dods.builder.generator.query.NonUniqueQueryException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			return count;
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
					VolumesFactory.resetCountEntries(volume.getDbname());
                }
                else {
                    ManageDatabase.dropTable(volume.getDbname());
					VolumesFactory.deleteCountEntries(volume.getDbname());
                }
				IndexFactory.dropIndexTable(volume.getIndexDbname());
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in deleteVolumeTable with volume: " + volume, e);
            }
        }
	
	public static void setGDEFFrenchTranslations(IAnswer myAnswer) throws PapillonBusinessException {
		
		Volume myVolume = myAnswer.getVolume();
		if (myVolume.getName().equals(VOLUME_GDEF_est)) {
			NodeList myNodeList = ParseVolume.getCdmElements((VolumeEntry)myAnswer,Volume.CDM_translation,"fra");
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
						String[] Headwords = new String[]{word};
						Vector myTable = getVolumeNameEntriesVector(VOLUME_GDEF_fra,
																	null,
																	Headwords,
																	IQuery.STRATEGY_EXACT);
						if (myTable.size()==1) {
							IAnswer newAnswer = (IAnswer) myTable.elements().nextElement();
							myNode.setNodeValue(newAnswer.getId());
						}
						else {
							myNode.setNodeValue(VOLUME_GDEF_est_sep + myTable.size() + VOLUME_GDEF_est_sep + word);
						}
					}
				}
			}
		}
	}
	
	
}

