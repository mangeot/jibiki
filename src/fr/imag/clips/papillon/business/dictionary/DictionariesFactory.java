/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.31  2006/03/10 16:42:31  mangeot
 * Fix for targets.length==0 not satisfied
 *
 * Revision 1.30  2006/03/10 16:21:00  mangeot
 * Hack for targets.length==0, I am not satisfied..
 *
 * Revision 1.29  2006/03/10 15:47:25  mangeot
 * Hack when targets==null added to the findAnswerAndTranslations
 * I am not satified with that.
 *
 * Revision 1.28  2006/03/05 11:07:21  mangeot
 * *** empty log message ***
 *
 * Revision 1.27  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.26  2005/11/24 11:09:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.25  2005/11/24 11:07:43  mangeot
 * *** empty log message ***
 *
 * Revision 1.24  2005/11/24 11:05:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.23  2005/11/14 23:21:57  mangeot
 * *** empty log message ***
 *
 * Revision 1.22  2005/11/14 22:57:27  mangeot
 * *** empty log message ***
 *
 * Revision 1.21  2005/11/14 22:49:06  mangeot
 * *** empty log message ***
 *
 * Revision 1.20  2005/11/14 22:28:45  mangeot
 * *** empty log message ***
 *
 * Revision 1.19  2005/11/09 15:28:44  mangeot
 * *** empty log message ***
 *
 * Revision 1.18  2005/11/09 13:30:31  mangeot
 * *** empty log message ***
 *
 * Revision 1.17.4.2  2006/01/25 15:22:23  fbrunet
 * Improvement of QueryRequest
 * Add new search criteria
 * Add modified status
 *
 * Revision 1.17.4.1  2005/12/02 10:04:09  fbrunet
 * Add Pre/Post edition processing
 * Add index reconstruction
 * Add new query request
 * Add fuzzy search
 * Add new contribution administration
 * Add xsl transformation volume
 *
 * Revision 1.17  2005/07/16 12:58:31  serasset
 * Added limit parameter to query functions
 * Added a parameter to Formater initializations
 * Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 * Revision 1.16  2005/07/14 13:48:53  serasset
 * Added columns dictionaryname and volumename to the xslsheets.
 * Modified the XslSheet and XslSheetFactory accordingly.
 * Modified AdminXsl interface accordingly.
 * Modified DictionariesFactory and VolumesFactory to allow several xsl-sheets and to
 * correctly provide dictionaryName/volumeName to XslSheetFactory.
 * Cleanup of several errors in papillon_static doml file.
 *
 * Revision 1.15  2005/07/05 09:21:59  serasset
 * Template interface generator now correctly generates attribute names (with an @).
 * Target languages are now correctly handled when querying a pivot multilingual dictionary.
 *
 * Revision 1.14  2005/06/24 10:35:57  mangeot
 * Minor bug fixes
 *
 * Revision 1.13  2005/06/22 15:55:53  mangeot
 * Solved an unresolved prefix bug when the dml prefix was not in the template entry.
 * Now we use the DmlPrefixResolver to solve this issue.
 *
 * Revision 1.12  2005/06/20 16:55:02  mangeot
 * multiple bug fixes
 *
 * Revision 1.11  2005/06/17 12:38:56  mangeot
 * Changed lexiesCollection into lexiesHashtable in order to implement the getDirectTranslations
 *
 * Revision 1.10  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.9  2005/05/25 13:31:08  serasset
 * Return a monolingual entry even if the lexie is not linked to an axie.
 * LexALP transformer now formats simple monolingual query results.
 *
 * Revision 1.8  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.7.4.4  2005/06/01 15:20:33  mangeot
 * Added a boolean for contributionslog
 *
 * Revision 1.7.4.3  2005/05/27 11:53:21  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.4.2  2005/04/29 17:30:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.7  2005/04/20 10:51:14  mangeot
 * Correction de AddDirectTranslations
 *
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
import fr.imag.clips.papillon.business.dictionary.QueryParameter;
import fr.imag.clips.papillon.business.dictionary.Dictionary;

import com.lutris.appserver.server.sql.ObjectId;

import java.util.Collection;
import java.util.Vector;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Enumeration;

// For URLs
import java.net.*;

import fr.imag.clips.papillon.business.utility.*;

import fr.imag.clips.papillon.CurrentDBTransaction;

/**
* Used to find the instances of xslsheet.
 */
public class DictionariesFactory {
	
	public final static int MaxDisplayedEntries = 5;
	public final static int MaxRetrievedEntries = 500;
    protected final static String DML_URI = DmlPrefixResolver.DML_URI;
    protected final static String XLINK_URI = DmlPrefixResolver.XLINK_URI;
    protected final static String DICTIONARY_TAG="dictionary-metadata";
    protected final static String VOLUME_REF_TAG="volume-metadata-ref";
    protected final static String XSLSHEET_TAG="xsl-stylesheet";
    protected final static String HREF_ATTRIBUTE="href";
    protected final static String NAME_ATTRIBUTE="name";
	protected final static String DEFAULT_ATTRIBUTE="default";
    
    public final static String PAPILLONAXI="Papillon_axi";
	
	
    // FIXME: Most attributes should belong to the dml name space. Currently, only the lang attribute do belong to dml...
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
                    targets = targets + " " +  tempElt.getAttributeNS(DML_URI, "lang");
                }
            }
            targets.trim();
			
            // FIXME: Should we store the DOM ?
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
                if (Existe.isEmpty()) {//does'nt exist, create :
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
		(URL fileURL, boolean loadVolumes, boolean loadEntries, boolean logContribs)
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
					
                    // DONE: allow several stylesheets in metadata
                    NodeList stylesheets =(NodeList)docXml.getElementsByTagName(XSLSHEET_TAG);
                    
					for (int i=0; i<stylesheets.getLength(); i++) {
                        Element stylesheet = (Element) stylesheets.item(i);
                        
                        if (null != stylesheet) {
                            String ref = stylesheet.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE);
                            String name = stylesheet.getAttribute(NAME_ATTRIBUTE);
							if (name == null || name.equals("")) {
								name = myDict.getName() + "." + myDict.getHandle();
							}
                            String isDefault = stylesheet.getAttribute(DEFAULT_ATTRIBUTE);
                            boolean isDefaultXsl = (null != isDefault && isDefault.equals("true"));
                            URL resultURL = new URL(fileURL,ref);
                            String xslString = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(resultURL);
                            fr.imag.clips.papillon.business.xsl.XslSheetFactory.AddXslSheet(name, myDict.getName(), null ,null, xslString,isDefaultXsl);
                        }
					}
                    if (loadVolumes || loadEntries) {
                        NodeList links = dictionary.getElementsByTagName(VOLUME_REF_TAG);
                        if (null != links && links.getLength() > 0) {
                            for (int i=0; i<links.getLength(); i++) {
                                Element tempElt = (Element)links.item(i);
                                String ref = tempElt.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE);
                                URL resultURL = new URL(fileURL,ref);
                                VolumesFactory.parseVolumeMetadata(myDict, resultURL, loadEntries, logContribs);
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
			
			// FIXME: The foksEdict dicitonary is particular. It cannot be queried
            // FIXME: Foks is not a dictionary, it should not be treated as the other dictionaries.
			Dictionary foksDict = findDictionaryByName("FoksEdict");
			if (foksDict != null && !foksDict.isEmpty()) {
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
	
    // FIXME: Test this, shouldn't the source language be known ?
    public static Collection getAllDictionariesEntriesCollection(Vector Keys1,
																 Vector Keys2,
																 String anyContains,
																 User user)
        throws PapillonBusinessException {
            Vector entries = new Vector();
            Dictionary[] resources = getDictionariesArray();
            if (null != resources && resources.length > 0) {
                for (int i=0; i < resources.length; i++) {
                    entries.addAll(getDictionaryEntriesCollection(resources[i],
                                                                  null,
                                                                  null,
                                                                  Keys1,
																  Keys2,
																  anyContains,
                                                                  user,
																  0));
                }
            }
            return entries;
        }
	
    // FIXME: Why Keys1 and Keys2 ? What are they ?
    public static Collection getDictionariesEntriesCollection(String [] resources,
															  String source,
															  String[] targets,
															  Vector Keys1,
															  Vector Keys2,
															  String anyContains,
															  User user,
															  int offset)
        throws PapillonBusinessException {
			Vector entries = new Vector();
			
			if (null != resources && resources.length > 0) {
				for (int i=0; i < resources.length; i++) {
					Collection myColl = getDictionaryNameEntriesCollection(resources[i],
																		   source,
																		   targets,
																		   Keys1,
																		   Keys2,
																		   anyContains,
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
																Vector Keys1,
																Vector Keys2,
																String anyContains,
																User user,
																int offset) 
		throws PapillonBusinessException {
			Dictionary dict = findDictionaryByName(resource);
			return getDictionaryEntriesCollection(dict, source,
												  targets,Keys1, 
												  Keys2, anyContains, 
												  user, offset);
		}
	
	// Returns a collection of results for a set of headword.
    public static Collection getDictionaryEntriesCollection(Dictionary dict,
															String source,
															String[] targets,
															Vector Keys1,
															Vector Keys2,
															String anyContains,
															User user,
															int offset) 
		throws PapillonBusinessException {
			//	Collection qrset = new HashSet();
            Collection qrset = new Vector();
			if (null != dict 
				&& Utility.IsInArray(source, dict.getSourceLanguagesArray())
				&& Utility.IsInArray(targets, dict.getTargetLanguagesArray())) {
				Volume[] volumes = VolumesFactory.getVolumesArray(dict.getName(), source, null);
				if (null != volumes && volumes.length > 0) {
					for (int i=0;i<volumes.length;i++) {
						Volume myVolume = volumes[i];
                        // FIXME: get the limit argument
						Vector entriesVector = VolumeEntriesFactory.getVolumeEntriesVector(dict, myVolume, Keys1, Keys2, anyContains, offset, 0);
						//FIXME: hack for targets array. If the array is null, it means that all targets are asked
						if (targets == null) {
							targets = myVolume.getTargetLanguagesArray();
						}
                        Iterator iter = entriesVector.iterator();
						while (iter.hasNext()) {
							VolumeEntry ve = (VolumeEntry) iter.next();
							qrset.addAll(expandResult(ve,targets,user));
						}
					}
				}
			}
			return qrset;
		}
	
	
    public static Collection getAllDictionariesReverseEntriesCollection(Vector Keys1,
																 Vector Keys2,
																 String anyContains,
																 User user)
        throws PapillonBusinessException {
            Vector entries = new Vector();
            Dictionary[] resources = getDictionariesArray();
            if (null != resources && resources.length > 0) {
                for (int i=0; i < resources.length; i++) {
                    entries.addAll(getDictionaryReverseEntriesCollection(resources[i],
                                                                  null,
                                                                  null,
                                                                  Keys1,
																  Keys2,
                                                                  anyContains,
                                                                  user,
																  0));
                }
            }
            return entries;
        }
	
    public static Collection getDictionariesReverseEntriesCollection(String [] resources,
															  String source,
															  String[] targets,
															  Vector Keys1,
															  Vector Keys2,
															  String anyContains,
															  User user,
															  int offset)
        throws PapillonBusinessException {
			Vector entries = new Vector();
			
			if (null != resources && resources.length > 0) {
				for (int i=0; i < resources.length; i++) {
					Collection myColl = getDictionaryNameReverseEntriesCollection(resources[i],
																		   source,
																		   targets,
																		   Keys1,
																		   Keys2,
																		   anyContains,
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
																	   Vector Keys1,
																	   Vector Keys2,
																	   String anyContains,
																	   User user,
																	   int offset) 
		throws PapillonBusinessException {
			Dictionary dict = findDictionaryByName(resource);
			return getDictionaryReverseEntriesCollection(dict, source,
														 targets,Keys1, 
														 Keys2, anyContains,
														 user, offset);
		}
	
	
	public static Collection getDictionaryReverseEntriesCollection(Dictionary dict,
																   String source,
																   String[] targets,
																   Vector theKeys1,
																   Vector theKeys2,
																   String anyContains,
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
							&& theKeys1.size()>0) {
							PapillonLogger.writeDebugMsg("Volume Reverse Lookup: " + myVolume.getName() + " " + source + " -> " + myVolume.getSourceLanguage());
							for (java.util.Enumeration enumKeys = theKeys1.elements(); enumKeys.hasMoreElements();) {
								//myKey[0] = key
								//myKey[1] = lang
								//myKey[2] = value
								String[] myKey = (String[]) enumKeys.nextElement();
								if (myKey[0].equals(Volume.CDM_headword)) {
									myKey[0]= Volume.CDM_translation;
								}
							}
                            // FIXME: get the limit argument
							Vector entriesVector = VolumeEntriesFactory.getVolumeEntriesVector(dict, myVolume, theKeys1, theKeys2, anyContains, offset, 0);
                            // TODO: Do we have to expand translations in this case ? Is reverse lookup only for direct dictionaries ?
                            Iterator iter = entriesVector.iterator();
                            while (iter.hasNext()) {
                                VolumeEntry ve = (VolumeEntry) iter.next();
                                QueryResult qr = new QueryResult(QueryResult.REVERSE_UNIQUE_RESULT, ve);
                                entriesCollection.add(qr);
                            }
						}
					}
				}
			}
			return entriesCollection;
		}
	
	// Returns a collection of Volume Entries (WARN: not a collection of QueryResults)	
	public static Collection getVolumeEntriesCollection(String volumeName, User user, Vector Keys) throws PapillonBusinessException {
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
		entriesTable = VolumeEntriesFactory.getVolumeEntriesVector(dict, volume,Keys, null, null,0, 0);
		return entriesTable;
	}
    
    //*********************************************
    // New set of queries, using QueryParameters
    // These queries are different, because they do not use a global notion of source language
    // The source language is attached in the keys of the parameter, meaning we can ask
    // for entries with a french headword and a german headword...
    // Question is: what does this mean (german headword is translation or it is a term bank ?)
    // Problem: One meaning is find an entry with xxx in french, connected to an entry with yyy in german
    //          Which is meaningfull in the case of a pivot dictionary, but which means that we should detect it
    //          and make the appropriate query on the axie level...
	//*********************************************
    public static Collection doQuery(QueryParameter qp, User user) throws PapillonBusinessException {
        // FIXME: what about reverse access ?
        Collection qrset = new Vector();
        try {
            // Iterate on all the dictionaries and then on all the volumes...
            for (int id = 0; id < qp.getDictionaryNames().length; id++) {
                Dictionary d = findDictionaryByName(qp.getDictionaryNames()[id]);
                // FIXME: There, I should determine the type of dictionary.
                // FIXME: and perform the corresponding request
                Volume[] volumes = VolumesFactory.getVolumesArray(d.getName());
                for (int iv=0; iv < volumes.length; iv++) {
                    Volume vol = volumes[iv];
                    Vector entriesVector = VolumeEntriesFactory.getVolumeEntriesVector(d, vol, qp.getCriteria(), null, null, qp.getOffset(), qp.getLimit());
                    Iterator iter = entriesVector.iterator();
                    while (iter.hasNext()) {
                        VolumeEntry ve = (VolumeEntry) iter.next();
                        qrset.addAll(expandResult(ve,qp.getTargets(),user));
                    }
                    
                }
            }
        } catch (PapillonBusinessException e) {
            throw e;
        }
        return qrset;
    }
    
    
    
    //*********************************************
    
    
	public static Collection getAxiesCollectionByHeadword(Dictionary dict, String source, User user, String headword, int strategy) throws PapillonBusinessException {
		Collection axies = new Vector();
		String[] Headword = new String[4];
			//Headword[0] = key
			//Headword[1] = lang
			//Headword[2] = value
		Headword[0] = Volume.CDM_headword;
		Headword[1] = source;
		Headword[2] = headword;
		Headword[3] = "" + strategy;
		
		Vector myKey = new Vector();
		myKey.add(Headword);
				
		Collection entries = getDictionaryEntriesCollection(dict,
															source,
															null,
															myKey,
															null,
															null,
															user,
															0);
//		if (entries != null && entries.size()>0) {
//			for (Iterator myIterator = entries.iterator(); myIterator.hasNext();) {
//				axies.addAll(PapillonPivotFactory.findAxiesByLexie((IAnswer)myIterator.next(),user));
//			}
//		}
		return entries;
	}
	
	public static Collection findAnswerAndTranslations(String volumeName, String handle, String[] targets, User user) throws PapillonBusinessException {
        // FIXME: should be VolumeEntry...
		VolumeEntry myAnswer = VolumeEntriesFactory.findEntryByHandle(volumeName, handle);
		//FIXME: hack for targets array. If the array is null, it means that all targets are asked
		String[] newTargets = null;
		if (targets == null || targets.length==0) {
			newTargets = myAnswer.getVolume().getTargetLanguagesArray();
		}
		else {
			newTargets = Utility.ArrayIntersection(myAnswer.getVolume().getTargetLanguagesArray(),targets);
		}
		
        return expandResult(myAnswer, newTargets, user);
	}
	
    // Create a query result collection that contains all translations of the current entry, for the requested target languages.
    public static Collection expandResult(VolumeEntry ve, String[] targets, User user) 
        throws PapillonBusinessException {
        Collection myVector = new Vector();
        QueryResult qr = new QueryResult();
        qr.setSourceEntry(ve);
		String category = ve.getDictionary().getCategory();
		if (!category.equals("monolingual")) {
			String type = ve.getDictionary().getType();
			if (type.equals("pivot")) {
                String[] realTargets = Utility.ArrayIntersection(ve.getDictionary().getTargetLanguagesArray(), targets);
                qr.setResultKind(QueryResult.AXIE_COLLECTION_RESULT);
				myVector = getPivotResults(qr, ve.getSourceLanguage(), realTargets, user);
			}
			else if (type.equals("direct")) {
                String[] realTargets = Utility.ArrayIntersection(ve.getVolume().getTargetLanguagesArray(), targets);
                qr.setResultKind(QueryResult.DIRECT_TRANSLATIONS_RESULT);
				myVector = getDirectResults(qr, ve.getSourceLanguage(), realTargets, user);
			}
			else {
				// type monovolume: bilingual in the same file
				// type monodirectional: bilingual in the same file
				qr.setResultKind(QueryResult.UNIQUE_RESULT);
				myVector.add(qr);
			}
		} else {
            // monolingual
            qr.setResultKind(QueryResult.UNIQUE_RESULT);
            myVector.add(qr);
        }
		return myVector;
    }
    
	public static IAnswer findAnswerByHandle(String volumeName, String handle) throws PapillonBusinessException {
        IAnswer myAnswer = VolumeEntriesFactory.findEntryByHandle(volumeName, handle);
        // FIXME: Papillon Axies should be treated as ANY other volume entry...
		if (myAnswer==null || myAnswer.isEmpty()) {
			myAnswer = PapillonPivotFactory.findAxieByHandle(volumeName, handle);
		}
		return myAnswer;
	}
	
	public static IAnswer findEntryByEntryId(String volumeName, String entryId) throws PapillonBusinessException {
		IAnswer myAnswer = VolumeEntriesFactory.findEntryByEntryId(volumeName, entryId);
		return myAnswer;
		
	}
	
    // returns a collection of Pivot Query Results
    // There is one query result by axie linked to the proto lexie.
    protected static Collection getPivotResults(QueryResult proto, String source, String[] targets, User myUser) throws PapillonBusinessException {
        Collection qrset = new HashSet();
        if (null != proto && null != proto.getSourceEntry()) {
            // get all axies pointing to the entries
            VolumeEntry mySourceEntry = proto.getSourceEntry();
            //String xmlCode = mySourceEntry.getXmlCode();
            Collection axies = PapillonPivotFactory.findAxiesByLexie(mySourceEntry, myUser);
            
            // If the entry is not connected to an axie, return the proto
            if (axies == null || axies.size() == 0) {
                proto.setResultKind(QueryResult.UNIQUE_RESULT);
                qrset.add(proto);
            }
            
            // For each axie, get the requested set of target lexies.
            else {
				for (Iterator iter = axies.iterator(); iter.hasNext();) {
                // FIXME: Typecasting will not work for papillon until axies are treated normally...
                VolumeEntry myAxie = (VolumeEntry) iter.next();
                
                Hashtable resLexies = new Hashtable();
                
                for (int i = 0; i < targets.length; i++) {
                    Collection tempCollection = PapillonPivotFactory.findLexiesByAxie(myAxie, targets[i]);
                    for (Iterator iterTarget = tempCollection.iterator(); iterTarget.hasNext();) {
                        VolumeEntry myTargetLexie = (VolumeEntry) iterTarget.next();
                        resLexies.put(myTargetLexie.getEntryId(),myTargetLexie);
                    }
                }
                
                QueryResult qr = new QueryResult(proto);
                qr.setResultAxie(myAxie);
                qr.setLexiesHashtable(resLexies);
                
                qrset.add(qr);
                }
            }
            // Return a collection of axieset...
            
        }
        return qrset;
    }
	
    protected static Collection getDirectResults(QueryResult proto, String source, String[] targets, User myUser) throws PapillonBusinessException {
        //Collection qrset = new HashSet();
        Collection qrset = new Vector();
        if (null != proto && null != proto.getSourceEntry()) {
            VolumeEntry mySourceEntry = proto.getSourceEntry();
            Hashtable resLexies = new Hashtable();

            for (int i = 0; i < targets.length; i++) {
                // get all cdm elements pointing to target entries.
                String[] transIds = mySourceEntry.getTranslationsLexieIds(targets[i]);
                Volume[] Volumes = VolumesFactory.getVolumesArray(mySourceEntry.getDictionaryName(),targets[i], null);
                if (null != transIds && Volumes != null && Volumes.length>0) {
                    if (Volumes != null && Volumes.length>0) {
                        Volume firstVolume = Volumes[0];
                        for (int j = 0; j < transIds.length; j++) {
                            VolumeEntry myEntry = (VolumeEntry) DictionariesFactory.findEntryByEntryId(firstVolume.getName(), transIds[j]);
                            if (myEntry != null && ! myEntry.isEmpty()) {
                                resLexies.put(myEntry.getEntryId(),myEntry);
                            } 
                        }
                    }
                }
            }
            
            QueryResult qr = new QueryResult(proto);
            qr.setLexiesHashtable(resLexies);
            
            qrset.add(qr);
            
        }
        return qrset;
        
    }

    /*
    // FIXME: DEAD CODE !!!
	protected static Collection oldaddDirectTranslations(Collection entries, String source, String[] targets, User myUser)
		throws PapillonBusinessException {
			// FIXME: do not modify the current DOM! We have to make a copy! 
			if (null != entries && entries.size() > 0) {
				VolumeEntry myAnswer = null;
				if	(null != targets && targets.length > 0) {
					for (Iterator myIterator = entries.iterator();myIterator.hasNext();) {
						myAnswer = (VolumeEntry) myIterator.next();	
						// FIXME caching the html dom
						if (myAnswer.getHtmlDom() == null) {					
							Volume myVolume = myAnswer.getVolume();
							Dictionary myDictionary = myAnswer.getDictionary();
							for (int j=0;j<targets.length;j++) {
								NodeList myNodeList = ParseVolume.getCdmElements(myAnswer, Volume.CDM_translationReflexie, targets[j]);
								if ((myNodeList != null) && (myNodeList.getLength()>0)) {
									for (int i=0; i<myNodeList.getLength();i++) {
										Node myNode = myNodeList.item(i);
										String word = myNode.getNodeValue();
										if (word !=null && !word.equals("")) {
											Volume[] volumes = VolumesFactory.getVolumesArray(myDictionary.getName(), targets[j], null);
											if (volumes!=null && volumes.length>0) {
												VolumeEntry myEntry = VolumeEntriesFactory.findEntryByEntryId(myDictionary, volumes[0], word);
												Vector myTable = new Vector();
												if (myEntry!=null && !myEntry.isEmpty()) {
													myTable.add(myEntry);
												}
												if (myTable.size()>0) {
													if (myNode.getNodeType()==Node.TEXT_NODE) {
														Node textNode = myNode;
														myNode = myNode.getParentNode();
															myNode.removeChild(textNode);
													}
													for (Enumeration myElements = myTable.elements();myElements.hasMoreElements();) {
														VolumeEntry newEntry = (VolumeEntry) myElements.nextElement();
														Node tempNode = myAnswer.getDom().importNode((Node)newEntry.getDom().getDocumentElement(),true);
														myNode.appendChild(tempNode);
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
     */
    
    
}

