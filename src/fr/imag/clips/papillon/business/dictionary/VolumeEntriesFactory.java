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
	protected final static String VOLUME_GDEF_est_translation = "mot-princ";
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
								null, null, null, null, null, null, null);
	}

 		public static Vector getVolumeEntriesVector(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pos, String pron, String reading, String trans, String key1,String key2,String any) throws PapillonBusinessException {
        Vector MyTable = null;
        if (null != volume) {
            if (volume.getLocation().equals(Volume.LOCAL_LOCATION)) {
                MyTable = getDbTableEntriesVector(dict, volume,id,Headwords,strategy,pos,pron,reading,trans,key1,key2,any);
            }
            else if (volume.getLocation().equals(Volume.REMOTE_LOCATION)) {
                MyTable = getRemoteVolumeEntriesVector(dict,volume,id,Headwords,pos,pron,reading, trans,key1,key2,any);
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
									 null, null, null, null, null, null, null);
		}
	
    public static Vector getVolumeNameEntriesVector(String volumeName,
                                                    String id,
                                                    String[] Headwords,
                                                    int strategy,
																										String pos,
                                                    String pron,
                                                    String reading,
                                                    String trans,
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
            return getDbTableEntriesVector(dict, volume, id, Headwords, strategy, pos, pron, reading, trans, key1,key2,any);
        }

    protected static Vector getDbTableEntriesVector(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pos, String pron, String reading, String trans, String key1,String key2,String any) throws PapillonBusinessException {
        Vector theEntries = new Vector();
		
		// In this cases, we can use the Index file !		
		if ((strategy == IQuery.STRATEGY_NONE ||
			 strategy == IQuery.STRATEGY_EXACT ||
			 strategy == IQuery.STRATEGY_PREFIX) &&
			
			((pos == null || pos.equals("")) &&
			 (trans == null || trans.equals("")) &&
			 (any == null || any.equals("")))
			) {
			theEntries = IndexFactory.getEntriesVector(dict, volume, id, Headwords, strategy, pron, reading, key1, key2);
		}
		else
			
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

                if (null == id) {id = "";}
                else {id = id.trim();}

                if (null == pos) {pos = "";}
                else {pos = pos.trim();}

                if (null == pron) {pron = "";}
                else {pron = pron.trim();}

                if (null == reading) {reading = "";}
                else {reading = reading.trim();}

                if (null == trans) {trans = "";}
                else {trans = trans.trim();}

                if (null == key1) {key1 = "";}
                else {key1 = key1.trim();}

                if (null == key2) {key2 = "";}
                else {key2 = key2.trim();}

				if (null == any) {any = "";}
                    else {any = any.trim();}

				if (!pos.equals("")) {
                    pos = "#" + pos + "#";
                }
                if (!pron.equals("")) {
                    pron = "#" + pron + "#";
                }
                if (!key1.equals("")) {
                    key1 = "#" + key1 + "#";
                }
                if (!key2.equals("")) {
                    key2 = "#" + key2 + "#";
                }

                for (int i=0; i < Headwords.length; i++) {
                    String headword = Headwords[i];
                    fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Sequencial request table: " + volumeTable + " word: " + headword);

                    // consultation of a local volume
                    VolumeEntryQuery query = new VolumeEntryQuery(volumeTable);

                    if (null == headword) {headword = "";}
                    else {headword = headword.trim();}

                    // Different strategies
                    if (strategy == IQuery.STRATEGY_EXACT) {
                        cmp_op = CSS;
                        if (!headword.equals("")) {
                            headword = "#" + headword + "#";
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans + "#";
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading + "#";
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_PREFIX) {
                        cmp_op = CSS;
                        if (!headword.equals("")) {
                            headword = "#" + headword;
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans;
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading;
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_SUFFIX) {
                        cmp_op = CSC;
                        if (!headword.equals("")) {
                            headword += "#";
                        }
                        if (!trans.equals("")) {
                            trans += "#";
                        }
                        if (!reading.equals("")) {
                            reading += "#";
                        }
                    }
					if (strategy == IQuery.STRATEGY_INSENSITIVE_EXACT) {
                        cmp_op = CIS;
                        if (!headword.equals("")) {
                            headword = "#" + headword + "#";
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans + "#";
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading + "#";
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_INSENSITIVE_PREFIX) {
                        cmp_op = CIS;
                        if (!headword.equals("")) {
                            headword = "#" + headword;
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans;
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading;
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_INSENSITIVE_SUFFIX) {
                        cmp_op = CIC;
                        if (!headword.equals("")) {
                            headword += "#";
                        }
                        if (!trans.equals("")) {
                            trans += "#";
                        }
                        if (!reading.equals("")) {
                            reading += "#";
                        }
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
                    if (!id.equals("")) {
                        query.getQueryBuilder().addWhereClause("id", id, CSE);
                    }
                    if (!pos.equals("")) {
                        query.getQueryBuilder().addWhereClause("pos", pos, cmp_op);
                    }
                    if (!pron.equals("")) {
                        query.getQueryBuilder().addWhereClause("pronunciation", pron, cmp_op);
                    }
                    if (!pron.equals("")) {
                        query.getQueryBuilder().addWhereClause("reading", pron, cmp_op);
                    }
                    if (!trans.equals("")) {
                        query.getQueryBuilder().addWhereClause("translation", trans, cmp_op);
                    }
                    if (!key1.equals("")) {
                        query.getQueryBuilder().addWhereClause("key1", key1, cmp_op);
                    }
                    if (!key2.equals("")) {
                        query.getQueryBuilder().addWhereClause("key2", key2, cmp_op);
                    }
                    if (!any.equals("")) {
                        query.getQueryBuilder().addWhereClause("xmlcode", any, CIC);
                    }

                    // query.addOrderByHeadword(true);
				//	query.getQueryBuilder().addEndClause("ORDER BY " + volume.getSourceLanguage()+"_sort(headword)");
					query.getQueryBuilder().addOrderByColumn(volume.getSourceLanguage()+"_sort(headword)","");
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
        return theEntries;
    }

	public static Vector getFoksEntriesVector(String headword) throws PapillonBusinessException {
        Vector theEntries = new Vector();
        try {

					// consultation of a local volume
					FoksEntryQuery query = new FoksEntryQuery();
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
				theEntries = IndexFactory.getEntriesVector(myDict, volume, null, Headwords, IQuery.STRATEGY_EXACT, null, null, null, null);
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
                VolumeEntryQuery query = new VolumeEntryQuery(myVolume.getDbname());
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
        * The findEntryByHandle method performs a database query to
     * return a id object
     *
     * @param id, the object id of the entries table.
     * @return
     *     the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */

	public static VolumeEntry findEntryByEntryId(String volumeName, String id)
        throws PapillonBusinessException {
			Volume volume;
            Dictionary dict;
            try {
                volume = VolumesFactory.findVolumeByName(volumeName);
                dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findEntryByHandle(String volumeName, String id)", ex);
            }
			return findEntryByEntryId(dict, volume, id);
		}
	
 	public static VolumeEntry findEntryByEntryId(Dictionary myDict, Volume myVolume, String id)
        throws PapillonBusinessException {
            VolumeEntry theEntry = null;
            VolumeEntryDO theVolumeEntryDO = null;

            try {
                VolumeEntryQuery query = new VolumeEntryQuery(myVolume.getDbname());
                //set query
                query.setQueryId(id);
                // Throw an exception if more than one message is found
          //      query.requireUniqueInstance();
                theVolumeEntryDO = query.getNextDO();
				if (theVolumeEntryDO != null) {
					theEntry = new VolumeEntry(myDict, myVolume,theVolumeEntryDO);
				}
                return theEntry;
            }catch(Exception ex) {
				return theEntry;
          //      throw new PapillonBusinessException("Exception in findEntryByEntryId()", ex);
            }
        }

    public static void parseVolume (String volumeName, String URL)
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

    public static VolumeEntry newEntry(Dictionary dict, Volume volume, String id, String xmlCode, Vector headwords,  Vector variants, Vector writings, Vector readings, Vector poss, Vector pronunciations, Vector translations, Vector key1s, Vector key2s)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Vector newHeadwords = headwords;
			if (variants != null && variants.size()>0) {
				newHeadwords.addAll(variants);
			}
			if (writings != null && writings.size()>0) {
				newHeadwords.addAll(writings);
            //FIXME: the writing is used only for Japanese, so I put it in the key1 field
            // in order to retrieve it easily for the FOKS lookup
                            if (key1s == null || key1s.size()==0) {
                                key1s = writings;
                            }
                         }

            VolumeEntry newEntry=new VolumeEntry(dict, volume);
            // external id
					if (id != null) {
						id = id.replace(' ', '_');
					}
					newEntry.setId(id);
            //xml code
            newEntry.setXmlCode(xmlCode);
            //headword
            newEntry.setHeadwords(newHeadwords);
            //Key1
            newEntry.setPoss(poss);
            //Key1
            newEntry.setPronunciations(pronunciations);
            //Key1
            newEntry.setReadings(readings);
            //Key2
            newEntry.setTranslations(translations);
            //Key2
            newEntry.setKey1s(key1s);
            //Key2
            newEntry.setKey2s(key2s);
            
            return newEntry;
        }

	public static VolumeEntry newEntryFromExisting(VolumeEntry myEntry) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		VolumeEntry resEntry = null;
		if (myEntry !=null && !myEntry.IsEmpty()) {
			resEntry = newEntry(myEntry.getDictionary(), myEntry.getVolume(), "", "", null, null, null, null, null, null, null ,null ,null);
		}
		return resEntry;
	}

	public static VolumeEntry createAndSaveEntry (Dictionary dict, Volume volume, String id, String xmlCode, Vector headwords,  Vector variants, Vector writings, Vector readings, Vector poss, Vector pronunciations, Vector translations, Vector key1s, Vector key2s)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			VolumeEntry myEntry = newEntry(dict, volume, id, xmlCode, headwords, variants, writings, readings, poss, pronunciations, translations, key1s, key2s);
			if (myEntry.IsEmpty()) {
				myEntry = null;
			}
			else {
				// FIXME: small hack, for the moment only Papillon volume entries must have an id!
				if (dict.getName().equals(PapillonPivotFactory.DICTNAME)) {
					IAnswerFactory.checkAndSetNewId(myEntry);
				}
				myEntry.save();
			}
			return myEntry;
	}

	public static VolumeEntry createEmptyEntry(String volumeName) throws
		PapillonBusinessException {
			VolumeEntry resEntry = null;
			Volume myVolume = VolumesFactory.findVolumeByName(volumeName);

			if ((myVolume != null) && (!myVolume.IsEmpty())) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
				String templateEntry = myVolume.getTemplateEntry();
				resEntry = newEntry(myDict, myVolume, "", templateEntry, null, null, null, null, null, null, null ,null ,null);
			}
			return resEntry;
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
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in createVolumeTables with volume: " + volume.getName(), e);
            }			
		}


	
    public static void dropVolumeTable(Volume volume)
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

	public static void setGDEFFrenchTranslations(IAnswer myAnswer, Document myDocument) throws PapillonBusinessException {
		
		Volume myVolume = myAnswer.getVolume();
		if (myVolume.getName().equals(VOLUME_GDEF_est)) {
			myVolume.loadCDMElements();
			if (myVolume.CDM_entry != null && !myVolume.CDM_entry.equals("")) {
				NodeList myNodeList = myDocument.getElementsByTagName(VOLUME_GDEF_est_translation);
				if ((myNodeList != null) && (myNodeList.getLength()>0)) {
					for (int i=0; i<myNodeList.getLength();i++) {
						Element myElement = (Element) myNodeList.item(i);
						String word = Utility.getText(myElement);
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
								Utility.setText(myElement,newAnswer.getId());
							}
							else {
								Utility.setText(myElement,VOLUME_GDEF_est_sep + myTable.size() + VOLUME_GDEF_est_sep + word);
							}
						}
					}
				}
			}
		}
	}
	
	
}

