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
 * Revision 1.4.2.8  2005/04/06 10:36:01  mangeot
 * Temporary fix for addDirectTranslations because the DOM must not be modified
 *
 * Revision 1.4.2.7  2005/03/29 14:10:46  mangeot
 * Bug fix in addDirectTranslations
 *
 * Revision 1.4.2.6  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.4.2.5  2005/02/06 22:43:49  mangeot
 * Merged the 2 Hashtables CDM Elements and XPaths into one
 * Added a boolean (reverse-lookup) in the volume metadata and functionalities in order to perform a reverse lookup when no direct lookup result is found
 * Added a boolean (index) in the volume metadata for indexing the only specified CDM Elements
 *
 * Revision 1.4.2.4  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.4.2.3  2005/01/27 19:29:21  mangeot
 * Implemented the HtmlDom cache, it increases speed drastically.
 * Still does not compile after an ant clean
 *
 * Revision 1.4.2.2  2005/01/27 18:09:28  mangeot
 * Simple dictionary lookup is now working for GDEF.
 * Does not compile yet but cvs commit for backup
 *
 * Revision 1.4.2.1  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
 * Revision 1.4  2005/01/18 12:17:39  mangeot
 * Put default values for MaxDisplayedEntries and MAxRetrievedEntries
 *
 * Revision 1.3  2005/01/18 12:16:10  mangeot
 * Implemented the SQL LIMIT and OFFSET keywords. It allows us to retrieve the entries as blocks and page them. The LIMIT is the DictionariesFactory.MaxRetrievedEntries constant.
 * The implementation may need further tuning
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.18  2004/10/28 10:38:11  mangeot
 * Fixed some bugs that affected the dictd server
 * Modified some methods in order to display a text entry in the dictd server
 *
 * Revision 1.17  2004/05/17 15:38:59  mangeot
 * Added links for bilingual direct dictionaries type GDEF
 *
 * Revision 1.16  2004/05/12 15:35:22  serasset
 * The xml processing instruction also has to be suppressed in the source language
 * entry, when building the artificial Papillon entry.
 *
 * Revision 1.15  2004/05/11 16:15:47  serasset
 * The database now bear a <?xml instruction in the beginning of newly created
 * files.Hence, when building a fake Papillon entry 1 source -> n targets, each
 * translation is preceded by an invalid instruction. Hence the entry could not
 * be parsed for Xsl transformation. As a result, Papillon returned a null pointer
 * exception. Fixed with a hack that suppress the instruction directly in the xml
 * code when the fake entry is built.
 *
 * Revision 1.14  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;

//pour les nouvelles entrees
import org.w3c.dom.*;

//import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;

import java.util.*;

// For URLs
import java.net.*;

import fr.imag.clips.papillon.business.utility.*;

import fr.imag.clips.papillon.CurrentDBTransaction;

/**
* Used to find the instances of xslsheet.
 */
public class DictionariesFactory {
	
	public final static int MaxDisplayedEntries = 5;
	public final static int MaxRetrievedEntries = 50;
    protected final static String DML_URI = "http://www-clips.imag.fr/geta/services/dml";
    protected final static String XLINK_URI = "http://www.w3.org/1999/xlink";
    protected final static String DICTIONARY_TAG="dictionary-metadata";
    protected final static String VOLUME_REF_TAG="volume-metadata-ref";
    protected final static String XSLSHEET_TAG="xsl-stylesheet";
    protected final static String HREF_ATTRIBUTE="href";
    protected final static String PAPILLONAXI="Papillon_axi";
	
    public static Dictionary newDictionary(Element dictionary)
        throws fr.imag.clips.papillon.business.PapillonBusinessException, java.io.IOException {
            //on recupere le dictionnaire
			
            // Cette méthode dépend du schéma des dictionnaires.
            String fullname = dictionary.getAttribute("fullname");
            String name = dictionary.getAttribute("name");
            String category = dictionary.getAttribute("category");
            String type = dictionary.getAttribute("type");
			
            NodeList domains = dictionary.getElementsByTagName("domain");
            String domain = null;
            if ((null != domains) && (domains.getLength() > 0)) {
                domain = domains.item(0).getFirstChild().getNodeValue();
            }
			
            NodeList legals = dictionary.getElementsByTagName("legal");
            String legal = null;
            if ((null != legals) && (legals.getLength() > 0)) {
                legal = legals.item(0).getFirstChild().getNodeValue();
            }
			
            PapillonLogger.writeDebugMsg("Legal: " + legal);
			
            NodeList sourceNodes = dictionary.getElementsByTagName("source-language");
            String sources = "";
            if ((null != sourceNodes) && (sourceNodes.getLength() > 0)) {
                for (int i=0; i<sourceNodes.getLength(); i++) {
                    Element tempElt = (Element)sourceNodes.item(i);
                    sources = sources + " " + tempElt.getAttributeNS(DML_URI, "lang");
                }
            }
            sources.trim();
			
            NodeList targetNodes = dictionary.getElementsByTagName("target-language");
            String targets = "";
            if ((null != targetNodes) && (targetNodes.getLength() > 0)) {
                for (int i=0; i<targetNodes.getLength(); i++) {
                    Element tempElt = (Element)targetNodes.item(i);
                    targets = targets + " " +  tempElt.getAttributeNS(DML_URI, "lang");                		}
            }
            targets.trim();
			
            String xmlCode=Utility.NodeToString(dictionary);
			
            return createUniqueDictionary(name, fullname, category, type, domain, legal, sources, targets, xmlCode);
        }
	
    public static Dictionary createUniqueDictionary (String name,
                                                     String fullname,
                                                     String category,
                                                     String type,
                                                     String domain,
                                                     String legal,
                                                     String sources,
                                                     String targets,
                                                     String xmlCode)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            Dictionary myDictionary = null;
            if ((name!=null) && (fullname!=null) && (category!=null) && (type!=null) && (sources!=null) && (xmlCode!=null))
            {
                //search for an existing dictionary
                Dictionary Existe=DictionariesFactory.findDictionaryByName(name);
                if (Existe.IsEmpty()) {//does'nt exist, create :
                    myDictionary=new Dictionary();
                    myDictionary.setName(name);
                    myDictionary.setFullName(fullname);
                    myDictionary.setCategory(category);
                    myDictionary.setType(type);
                    myDictionary.setDomain(domain);
                    myDictionary.setLegal(legal);
                    myDictionary.setSourceLanguages(sources);
                    myDictionary.setTargetLanguages(targets);
                    myDictionary.setXmlCode(xmlCode);
                }
                else {
                    PapillonLogger.writeDebugMsg("Dico deja existant dans la base");
                }
            }
            return myDictionary;
        }
	
    public static Dictionary parseDictionaryMetadata
		(URL fileURL, String loadVolumes, String loadEntries)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            Dictionary myDict = null;
            try {
                Document docXml = Utility.buildDOMTree(fileURL);
                PapillonLogger.writeDebugMsg("The xml");
                PapillonLogger.writeDebugMsg(Utility.NodeToString(docXml));
				
                // on recupere l'element dictionary
                Element dictionary;
                dictionary=(Element)docXml.getElementsByTagName(DICTIONARY_TAG).item(0);
				
                // ajout du dico ds la table.
                myDict = DictionariesFactory.newDictionary(dictionary);
                if (null != myDict) {
					
                    Element stylesheet =(Element)docXml.getElementsByTagName(XSLSHEET_TAG).item(0);
					
                    if (null != stylesheet) {
                        String ref = stylesheet.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE);
                        URL resultURL = new URL(fileURL,ref);
                        String xslString = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(resultURL);
                        fr.imag.clips.papillon.business.xsl.XslSheetFactory.AddXslSheet(myDict.getName(),null,xslString,false);
                    }
					
                    if (null != loadVolumes || null != loadEntries) {
                        NodeList links = dictionary.getElementsByTagName(VOLUME_REF_TAG);
                        if (null != links && links.getLength() > 0) {
                            for (int i=0; i<links.getLength(); i++) {
                                Element tempElt = (Element)links.item(i);
                                String ref = tempElt.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE);
                                URL resultURL = new URL(fileURL,ref);
                                VolumesFactory.parseVolumeMetadata(myDict, resultURL, loadEntries);
                            }
                        }
                    }
                }
				
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in parseDictionaryMetadata()", ex);
            }
            return myDict;
        }
	
	
    public static Dictionary findDictionaryByName(String name)
        throws PapillonBusinessException {
            Dictionary theDictionary = null;
			if (name != null && !name.equals("")) {
				try {
					DictionaryQuery query = new DictionaryQuery(CurrentDBTransaction.get());
					//set query
					query.setQueryName(name,QueryBuilder.CASE_INSENSITIVE_EQUAL);
					// Throw an exception if more than one message is found
					query.requireUniqueInstance();
					DictionaryDO theDictionaryDO = query.getNextDO();
					theDictionary = new Dictionary(theDictionaryDO);
				} catch(Exception ex) {
					throw new PapillonBusinessException("Exception in findDictionaryByName()", ex);
				}
			}
			return theDictionary;
        }
	
    public static Dictionary findDictionaryByID(String id)
        throws PapillonBusinessException {
            Dictionary theDictionary = null;
			
			if (id != null && !id.equals("")) {
				try {
					DictionaryQuery query = new DictionaryQuery(CurrentDBTransaction.get());
					//set query
					query.setQueryOId(new ObjectId(id));
					// Throw an exception if more than one message is found
					query.requireUniqueInstance();
					DictionaryDO theDictionaryDO = query.getNextDO();
					theDictionary = new Dictionary(theDictionaryDO);
				}
				catch(Exception ex) {
					throw new PapillonBusinessException("Exception in findDictionaryByID()", ex);
				}
			}
			return theDictionary;
        }
	
	
    public static Dictionary[] getDictionariesArray()
        throws PapillonBusinessException {
            Dictionary[] theDictArray = null;
			
            try {
                DictionaryQuery query = new DictionaryQuery(CurrentDBTransaction.get());
				
                query.addOrderByName(true);
                DictionaryDO[] DOarray = query.getDOArray();
                theDictArray = new Dictionary[ DOarray.length ];
                for ( int i = 0; i < DOarray.length; i++ )
                    theDictArray[i] = new Dictionary(DOarray[i]);
				
            }catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getDictionariesArray()", ex);
            }
			
            return theDictArray;
        }
	
    public static String[] getDictionariesNamesArray()
        throws PapillonBusinessException {
            Dictionary[] dictionaries = getDictionariesArray();
			String[] names;
			
			//FIXME: The foksEdict dicitonary is particular. It cannot be queried
			Dictionary foksDict = findDictionaryByName("FoksEdict");
			if (foksDict != null && !foksDict.IsEmpty()) {
				names = new String[ dictionaries.length -1];
				int j = 0;
				for (int i=0; i < dictionaries.length; i++) {
					if (!dictionaries[i].getName().equals("FoksEdict")) {
						names[j++] = dictionaries[i].getName();
					}
				}
			}
			else {
				names = new String[ dictionaries.length];
				
				for (int i=0; i < dictionaries.length; i++) {
					names[i] = dictionaries[i].getName();
				}
			}
			
			/*
			 String[] names = new String[ dictionaries.length];
			 
			 for (int i=0; i < dictionaries.length; i++) {
				 names[i] = dictionaries[i].getName();
			 }			 
			 */
            return names;
        }
	
    public static Collection getAllDictionariesEntriesCollection(Vector Keys,
																 String anyContains,
																 int strategy,
																 User user)
        throws PapillonBusinessException {
            Vector entries = new Vector();
            Dictionary[] resources = getDictionariesArray();
            if (null != resources && resources.length > 0) {
                for (int i=0; i < resources.length; i++) {
                    entries.addAll(getDictionaryEntriesCollection(resources[i],
                                                                  null,
                                                                  null,
                                                                  Keys,
																  anyContains,
                                                                  strategy,
                                                                  user,
																  0));
                }
            }
            return entries;
        }
	
    public static Collection getDictionariesEntriesCollection(String [] resources,
															  String source,
															  String[] targets,
															  Vector Keys,
															  String anyContains,
															  int strategy,
															  User user,
															  int offset)
        throws PapillonBusinessException {
			Vector entries = new Vector();
			
			if (null != resources && resources.length > 0) {
				for (int i=0; i < resources.length; i++) {
					Collection myColl = getDictionaryNameEntriesCollection(resources[i],
																		   source,
																		   targets,
																		   Keys,
																		   anyContains,
																		   strategy,
																		   user,
																		   offset);
					if (myColl!=null) {
						entries.addAll(myColl);
					}
				}
			}
			return entries;
		}
	
    public static Collection getDictionaryNameEntriesCollection(String resource,
																String source,
																String[] targets,
																Vector Keys,
																String anyContains,
																int strategy,
																User user,
																int offset) 
		throws PapillonBusinessException {
			Dictionary dict = findDictionaryByName(resource);
			return getDictionaryEntriesCollection(dict, source,
												  targets,Keys,
												  anyContains, strategy,
												  user, offset);
		}
	
	
    public static Collection getDictionaryEntriesCollection(Dictionary dict,
															String source,
															String[] targets,
															Vector Keys,
															String anyContains,
															int strategy,
															User user,
															int offset) 
		throws PapillonBusinessException {
			Collection entriesCollection = null;
			if (null != dict 
				&& Utility.IsInArray(source, dict.getSourceLanguagesArray())
				&& Utility.IsInArray(targets, dict.getTargetLanguagesArray())) {
				Volume[] volumes = VolumesFactory.getVolumesArray(dict.getName(), source, null);
				if (null != volumes && volumes.length > 0) {
					entriesCollection = (Collection) new Vector();
					for (int i=0;i<volumes.length;i++) {
						// FIXME it depends on the architecture of the dictionaries !
						if (!volumes[i].getName().equals(PAPILLONAXI)) {
							Vector entriesVector = VolumeEntriesFactory.getVolumeEntriesVector(dict, volumes[i], Keys, anyContains, strategy, offset);
							Collection tempCollection = ContributionsFactory.checkContributions(user, entriesVector);
							String category = dict.getCategory();
							if (!category.equals("monolingual")) {
								String type = dict.getType();
								if (type.equals("pivot")) {
									tempCollection = addPivotTranslations(tempCollection, source, targets, user);
								}
								if (type.equals("direct")) {
									tempCollection = addDirectTranslations(tempCollection, source, targets, user);
								}
							}
							entriesCollection.addAll(tempCollection);
						}
					}
				}
			}
			return entriesCollection;
		}
	
	
    public static Collection getAllDictionariesReverseEntriesCollection(Vector Keys,
																 String anyContains,
																 int strategy,
																 User user)
        throws PapillonBusinessException {
            Vector entries = new Vector();
            Dictionary[] resources = getDictionariesArray();
            if (null != resources && resources.length > 0) {
                for (int i=0; i < resources.length; i++) {
                    entries.addAll(getDictionaryReverseEntriesCollection(resources[i],
                                                                  null,
                                                                  null,
                                                                  Keys,
                                                                  anyContains,
                                                                  strategy,
                                                                  user,
																  0));
                }
            }
            return entries;
        }
	
    public static Collection getDictionariesReverseEntriesCollection(String [] resources,
															  String source,
															  String[] targets,
															  Vector Keys,
															  String anyContains,
															  int strategy,
															  User user,
															  int offset)
        throws PapillonBusinessException {
			Vector entries = new Vector();
			
			if (null != resources && resources.length > 0) {
				for (int i=0; i < resources.length; i++) {
					Collection myColl = getDictionaryNameReverseEntriesCollection(resources[i],
																		   source,
																		   targets,
																		   Keys,
																		   anyContains,
																		   strategy,
																		   user,
																		   offset);
					if (myColl!=null) {
						entries.addAll(myColl);
					}
				}
			}
			return entries;
		}
	
    public static Collection getDictionaryNameReverseEntriesCollection(String resource,
																	   String source,
																	   String[] targets,
																	   Vector Keys,
																	   String anyContains,
																	   int strategy,
																	   User user,
																	   int offset) 
		throws PapillonBusinessException {
			Dictionary dict = findDictionaryByName(resource);
			return getDictionaryReverseEntriesCollection(dict, source,
														 targets,Keys,
														 anyContains,strategy,
														 user, offset);
		}
	
	
	public static Collection getDictionaryReverseEntriesCollection(Dictionary dict,
																   String source,
																   String[] targets,
																   Vector theKeys,
																   String anyContains,
																   int strategy,
																   User user,
																   int offset) 
		throws PapillonBusinessException {
			Collection entriesCollection = null;
			if (null != dict
				&& Utility.IsInArray(source, dict.getTargetLanguagesArray())) {
				Volume[] volumes = VolumesFactory.getVolumesArray(dict.getName(), null, null);
				if (null != volumes && volumes.length > 0) {
					entriesCollection = (Collection) new Vector();
					for (int i=0;i<volumes.length;i++) {
						// FIXME it depends on the architecture of the dictionaries !
						Volume myVolume = volumes[i];
						if (myVolume.IsReverseLookup() 
							&& !volumes[i].getName().equals(PAPILLONAXI)
							&& Utility.IsInArray(source, myVolume.getTargetLanguagesArray())  
							&& Utility.IsInArray(myVolume.getSourceLanguage(), targets)
							&& theKeys.size()>0) {
							PapillonLogger.writeDebugMsg("Volume Reverse Lookup: " + myVolume.getName() + " " + source + " -> " + myVolume.getSourceLanguage());
							for (java.util.Enumeration enumKeys = theKeys.elements(); enumKeys.hasMoreElements();) {
								//myKey[0] = key
								//myKey[1] = lang
								//myKey[2] = value
								String[] myKey = (String[]) enumKeys.nextElement();
								if (myKey[0].equals(Volume.CDM_headword)) {
									myKey[0]= Volume.CDM_translation;
								}
							}
							Vector entriesVector = VolumeEntriesFactory.getVolumeEntriesVector(dict, myVolume, theKeys, anyContains, strategy, offset);
							Collection tempCollection = ContributionsFactory.checkContributions(user, entriesVector);
							entriesCollection.addAll(tempCollection);
						}
					}
				}
			}
			return entriesCollection;
		}
	
	
	public static Collection getVolumeEntriesCollection(String volumeName, User user, Vector Keys, int strategy) throws PapillonBusinessException {
		Collection entriesCollection = null;
		Vector entriesTable = null;
		Volume volume = null;
		Dictionary dict = null;
		try {
			volume = VolumesFactory.findVolumeByName(volumeName);
			dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in getVolumeNameEntriesVector()", ex);
		}
		entriesTable = VolumeEntriesFactory.getVolumeEntriesVector(dict, volume,Keys, null, strategy,0);
		entriesCollection = ContributionsFactory.checkContributions(user, entriesTable);
		return entriesCollection;
	}
	
	public static Collection getAxiesCollectionByHeadword(Dictionary dict, String source, User user, String headword, int strategy) throws PapillonBusinessException {
		Collection axies = new Vector();
		String[] Headword = new String[3];
			//Headword[0] = key
			//Headword[1] = lang
			//Headword[2] = value
		Headword[0] = Volume.CDM_headword;
		Headword[1] = source;
		Headword[2] = headword;
		
		Vector myKey = new Vector();
		myKey.add(Headword);
				
		Collection entries = getDictionaryEntriesCollection(dict,
															source,
															null,
															myKey,
															null,
															strategy,
															user,
															0);
		if (entries != null && entries.size()>0) {
			for (Iterator myIterator = entries.iterator(); myIterator.hasNext();) {
				axies.addAll(PapillonPivotFactory.findAxiesByLexie((IAnswer)myIterator.next(),user));
			}
		}
		return axies;
	}
	
	public static Collection findAnswerAndTranslations(String volumeName, String handle, String[] targets, User user) throws PapillonBusinessException {
		Collection myVector = new Vector();
		IAnswer myAnswer = findAnswerByHandle(volumeName, handle);
		myVector.add(myAnswer);
		PapillonLogger.writeDebugMsg("Found entry in: " + volumeName + ", handle: " + handle);
		String category = myAnswer.getDictionary().getCategory();
		if (!category.equals("monolingual")) {
			String type = myAnswer.getDictionary().getType();
			if (type.equals("pivot")) {
				myVector = addPivotTranslations(myVector, myAnswer.getSourceLanguage(), targets, user);
			}
			if (type.equals("direct")) {
				myVector = addDirectTranslations(myVector, myAnswer.getSourceLanguage(), targets, user);
			}
		}
		return myVector;
	}
	
	public static IAnswer findAnswerByHandle(String volumeName, String handle) throws PapillonBusinessException {
		IAnswer myAnswer = VolumeEntriesFactory.findEntryByHandle(volumeName, handle);
		if (myAnswer==null || myAnswer.IsEmpty()) {
			myAnswer = PapillonPivotFactory.findAxieByHandle(volumeName, handle);
		}
		return myAnswer;
	}
	
	public static IAnswer findEntryByEntryId(String volumeName, String entryId) throws PapillonBusinessException {
		IAnswer myAnswer = VolumeEntriesFactory.findEntryByEntryId(volumeName, entryId);
		return myAnswer;
		
	}
	
	
	protected static Collection addPivotTranslations(Collection entries, String source, String[] targets, User myUser)
		throws PapillonBusinessException {
			// FIXME: could be much better !
			// have to reprogram it with getDom()
			
			Collection translatedEntries = new Vector();
			boolean translationFound = false;
			if (null != entries && entries.size() > 0) {
				IAnswer myAnswer = null;
				String xmlCode="";
				if	(null != targets && targets.length > 0) {
					boolean sourceInTargets = Utility.IsInArray(source, targets);						
					for (Iterator myIterator = entries.iterator();myIterator.hasNext();) {
						translationFound = sourceInTargets;
						myAnswer = (IAnswer) myIterator.next();
						xmlCode = myAnswer.getXmlCode();
						Collection axieCollection = PapillonPivotFactory.findAxiesByLexie(myAnswer, myUser);
						if (null != axieCollection && axieCollection.size()>0) {
							xmlCode= "<div>" + purgeXmlEncodingFlag(xmlCode) + "<translations>";
							for (Iterator axieIterator = axieCollection.iterator();axieIterator.hasNext();) {
								Axie myAxie = (Axie) axieIterator.next();
								for (int k=0; k< targets.length; k++) {
									if (targets[k] != null && !targets[k].equals(source)) {
										Collection transEntries = PapillonPivotFactory.findLexiesByAxie(myAxie, targets[k]);
										if (null != transEntries && transEntries.size()>0) {
											for (Iterator transIterator = transEntries.iterator();transIterator.hasNext();) {
												IAnswer transAnswer = (IAnswer)transIterator.next();
												if (transAnswer != null && !transAnswer.IsEmpty()) {
													translationFound = true;
													fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Translation source id: " + 
																												 myAnswer.getId() + " target id: " + 
																												 transAnswer.getId());
													xmlCode += "<translation lang='" + targets[k] + "'>" + 
														purgeXmlEncodingFlag(transAnswer.getXmlCode()) + "</translation>";
												}
											}
										}
									}
									else {
										translationFound = true;
									}
								}
							}
							xmlCode = xmlCode + "</translations></div>";
							myAnswer.setXmlCode(xmlCode);
						}
						if (translationFound) {
							translatedEntries.add(myAnswer);
							PapillonLogger.writeDebugMsg("Entry: " + myAnswer.getId());
						}
					}
				}
				else {
					translatedEntries = entries;
				}
			}
			return translatedEntries;
		}
	
	protected static Collection addDirectTranslations(Collection entries, String source, String[] targets, User myUser)
		throws PapillonBusinessException {
			// FIXME: do not modify the current DOM! We have to make a copy! 
			if (null != entries && entries.size() > 0) {
				VolumeEntry myAnswer = null;
				String xmlCode="";
				if	(null != targets && targets.length > 0) {
					for (Iterator myIterator = entries.iterator();myIterator.hasNext();) {
						myAnswer = (VolumeEntry) myIterator.next();	
						// FIXME caching the html dom
						if (myAnswer.getHtmlDom() == null) {					
							Volume myVolume = myAnswer.getVolume();
							Dictionary myDictionary = myAnswer.getDictionary();
							for (int j=0;j<targets.length;j++) {
								NodeList myNodeList = ParseVolume.getCdmElements(myAnswer, Volume.CDM_translation, targets[j]);
								if ((myNodeList != null) && (myNodeList.getLength()>0)) {
									for (int i=0; i<myNodeList.getLength();i++) {
										Node myNode = myNodeList.item(i);
										String word = myNode.getNodeValue();
										if (word !=null && !word.equals("")) {
											Volume[] volumes = VolumesFactory.getVolumesArray(myDictionary.getName(), targets[j], null);
											if (volumes!=null && volumes.length>0) {
												VolumeEntry myEntry = VolumeEntriesFactory.findEntryByEntryId(myDictionary, volumes[0], word);
												Vector myTable = new Vector();
												if (myEntry!=null && !myEntry.IsEmpty()) {
													myTable.add(myEntry);
												}
												/*Vector myTable = VolumeEntriesFactory.getVolumeEntriesVector(myDictionary, volumes[0],
																											 word,
																											 null,
																											 IQuery.STRATEGY_EXACT,
																										 0); */
												if (myTable.size()>0) {
													if (myNode.getNodeType()==Node.TEXT_NODE) {
														Node textNode = myNode;
														myNode = myNode.getParentNode();
														// FIXME: do not modify the current DOM! We have to make a copy! 
														//	myNode.removeChild(textNode);
													}
													for (Enumeration myElements = myTable.elements();myElements.hasMoreElements();) {
														VolumeEntry newEntry = (VolumeEntry) myElements.nextElement();
														Node tempNode = myAnswer.getDom().importNode((Node)newEntry.getDom().getDocumentElement(),true);
												// FIXME: do not modify the current DOM! We have to make a copy! 
												//		myNode.appendChild(tempNode);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			return entries;
		}
	
	
	protected static String purgeXmlEncodingFlag(String xmlCode) {
		// Suppress the <?xml version="1.0" encoding="UTF-8"?> from the xml if necessary
		String flag = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		if (xmlCode.startsWith(flag.substring(0,6))) {
			return xmlCode.substring(flag.length());
		} else {
			return xmlCode;
		}
	}
}

