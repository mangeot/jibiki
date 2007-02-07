/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.53  2007/02/07 13:58:57  fbrunet
 * added message before axies are merged and undo process if the merge is not correct.
 *
 * Revision 1.52  2007/01/16 13:28:31  serasset
 * Added cache reinitialization when a metadata is modified.
 *
 * Revision 1.51  2007/01/15 17:24:28  serasset
 * Merged Modification made for the DRI instance with main trunk modifications.
 *
 * Revision 1.50  2007/01/15 17:12:18  serasset
 * Several notes added, suppressed the HTMLDOM_CACHE stuff.
 *
 * Revision 1.49  2007/01/08 15:13:42  fbrunet
 * Correction of th xml attribut bug in ContributionHeader (VolumeEntry class)
 *
 * Revision 1.48  2007/01/05 13:57:25  serasset
 * multiple code cleanup.
 * separation of XMLServices from the Utility class
 * added an xml parser pool to allow reuse of parser in a multithreaded context
 * added a new field in the db to identify the db layer version
 * added a new system property to know which db version is known by the current app
 *
 * Revision 1.46  2006/12/14 20:03:26  fbrunet
 * Add method to normalize value into XML structure.
 *
 * Revision 1.45  2006/12/13 09:32:00  fbrunet
 * *** empty log message ***
 *
 * Revision 1.44  2006/09/12 19:26:10  fbrunet
 * - improve reconstruction index
 *
 * Revision 1.43  2006/08/10 22:17:12  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 * Revision 1.42  2006/06/01 22:05:05  fbrunet
 * New interface, quick search, new contribution management (the first edition not create new contribution. New contribution is created after add, remove element, update, save, etc. in the interface window)
 *
 * Revision 1.41  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
 * Revision 1.40  2006/03/27 10:48:45  mangeot
 * added finition-date in contribution metadata
 *
 * Revision 1.39  2006/03/13 08:48:00  fbrunet
 * bug corrections before merge
 *
 * Revision 1.38  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.37  2006/03/01 08:53:14  mangeot
 * *** empty log message ***
 *
 * Revision 1.36  2005/12/04 15:22:39  mangeot
 * Fixed the volume parsing when the volume element is not the root element
 *
 * Revision 1.35  2005/12/01 15:34:28  mangeot
 * MM: I solved the problem of already created tables by creating an sql query for retrieving the table names. If the name already exists, VolumeEntriesFactory.createVolumeTables do not create the tables.
 * It allows the administrator to delete and reload only the metadata files without dropping the whole data.
 * The method is ManageDatabase.getTableNames() and it returns a vector with all the table names created by the database user (usually "papillon").
 *
 * Revision 1.34  2005/11/23 13:42:27  mangeot
 * Added cdmEntryIdElement for setting the entry id even if it is not an attribute
 *
 * Revision 1.33  2005/11/22 13:21:02  mangeot
 * I moved the VolumeEntriesFactory.createVolumeTables out of the database transactions in AdminDictionaries.java and Adminvolumes.java because otherwise, it is not possible to reload metadata when the data tables already exist (in this case, the transaction does not commit).
 *
 * Revision 1.32  2005/11/22 10:47:04  mangeot
 * *** empty log message ***
 *
 * Revision 1.12  2005/11/09 13:30:31  mangeot
 * *** empty log message ***
 *
 * Revision 1.11.4.4  2006/01/25 15:22:23  fbrunet
 * Improvement of QueryRequest
 * Add new search criteria
 * Add modified status
 *
 * Revision 1.11.4.3  2006/01/24 13:39:49  fbrunet
 * Modification view management
 * Modification LexALP postprocessing
 *
 * Revision 1.11.4.2  2005/12/02 10:04:09  fbrunet
 * Add Pre/Post edition processing
 * Add index reconstruction
 * Add new query request
 * Add fuzzy search
 * Add new contribution administration
 * Add xsl transformation volume
 *
 * Revision 1.11.4.1  2005/10/24 16:29:19  fbrunet
 * Added fuzzy search capabilities.
 * Added possibility to rebuild the index DB tables.
 * Added Pre and post processors that could be defined by the user.
 *
 * Revision 1.11  2005/07/16 12:58:31  serasset
 * Added limit parameter to query functions
 * Added a parameter to Formater initializations
 * Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 * Revision 1.10  2005/07/14 13:48:53  serasset
 * Added columns dictionaryname and volumename to the xslsheets.
 * Modified the XslSheet and XslSheetFactory accordingly.
 * Modified AdminXsl interface accordingly.
 * Modified DictionariesFactory and VolumesFactory to allow several xsl-sheets and to
 * correctly provide dictionaryName/volumeName to XslSheetFactory.
 * Cleanup of several errors in papillon_static doml file.
 *
 * Revision 1.9  2005/06/23 09:48:17  mangeot
 * Bug fix in xpath completion and creation-date cdm element
 *
 * Revision 1.8  2005/06/22 15:55:53  mangeot
 * Solved an unresolved prefix bug when the dml prefix was not in the template entry.
 * Now we use the DmlPrefixResolver to solve this issue.
 *
 * Revision 1.7  2005/06/16 16:09:17  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.5  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.4.4.7  2005/06/09 11:07:45  mangeot
 * Deleted the countEntriesCache. entries counts are not cached any more.
 * Fixed a few bugs.
 *
 * Revision 1.4.4.6  2005/06/01 15:20:33  mangeot
 * Added a boolean for contributionslog
 *
 * Revision 1.4.4.5  2005/06/01 08:38:43  mangeot
 * Multi bug correction + added the possibility of disabling data edition
 * via the Admin.po page
 *
 * Revision 1.4.4.4  2005/05/31 14:22:34  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.4.3  2005/05/27 11:53:21  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.4.2  2005/05/19 17:02:22  mangeot
 * Importing entries without the contribution element
 *
 * Revision 1.4.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.4  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.3.2.5  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.3.2.4  2005/02/06 22:43:49  mangeot
 * Merged the 2 Hashtables CDM Elements and XPaths into one
 * Added a boolean (reverse-lookup) in the volume metadata and functionalities in order to perform a reverse lookup when no direct lookup result is found
 * Added a boolean (index) in the volume metadata for indexing the only specified CDM Elements
 *
 * Revision 1.3.2.3  2005/01/28 23:01:09  mangeot
 * Fixed bugs in the editor. It seems to work now. More testing needed anyway...
 *
 * Revision 1.3.2.2  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.3.2.1  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
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
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.dictionary;

import com.lutris.appserver.server.sql.DBTransaction;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.data.VolumeDO;
import fr.imag.clips.papillon.data.VolumeQuery;
import org.w3c.dom.*;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.io.StringReader;

/**
* Used to find the instances of xslsheet.
 */
public class VolumesFactory {
	
	
	protected final static String DML_URI = DmlPrefixResolver.DML_URI;
	protected final static String XLINK_URI = DmlPrefixResolver.XLINK_URI;
	
	protected final static String VOLUME_TAG = "volume-metadata";
	protected final static String CDM_ELEMENTS_TAG = "cdm-elements";
	protected final static String XSLSHEET_TAG = "xsl-stylesheet";
	protected final static String XMLSCHEMA_TAG = "xmlschema-ref";
	protected final static String TEMPLATE_INTERFACE_TAG = "template-interface-ref";
	protected final static String TEMPLATE_ENTRY_TAG = "template-entry-ref";
	protected final static String XML_FOOTER_TAG = "volume-xml-footer";

	protected final static String HREF_ATTRIBUTE="href";
	protected final static String INDEX_ATTRIBUTE="index";
	protected final static String LANG_ATTRIBUTE="lang";
	protected final static String LOCATION_ATTRIBUTE="location";
	protected final static String VIRTUAL_ATTRIBUTE="virtual";
	protected final static String XPATH_ATTRIBUTE="xpath";
	protected final static String NAME_ATTRIBUTE="name";
	protected final static String DEFAULT_ATTRIBUTE="default";
    protected final static String EXTERNAL_ATTRIBUTE="external";
	
	protected final static String VOLUME_GDEF_est="GDEF_est";
	protected final static String VOLUME_GDEF_tes="GDEF_tes";
	protected final static String VOLUME_GDEF_fra="GDEF_fra";
    
    /** 
        * The initializeVolumeCache method performs a database query to
        * initialize the volume cache
        *
        * @exception PapillonBusinessException
        *   If there is a problem retrieving disc information.
        */
    public static void initializeVolumeCache() 
        throws PapillonBusinessException {
            
            try {
                
                // Initialize cache
                VolumeCache.volumeCacheInit();
                
                // Perform query
                VolumeQuery query = new VolumeQuery(CurrentDBTransaction.get());
                query.addOrderByName(true);
                VolumeDO[] DOarray = query.getDOArray();
                
                // Add volumes in cache (keys are the volume names)
                for ( int i = 0; i < DOarray.length; i++ ) {
                    Volume vol = new Volume(DOarray[i]);
                    VolumeCache.putVolumeInCache(vol.getName(), vol);
                }
                
            }catch(Exception ex) {
                throw new PapillonBusinessException("Exception in initializeVolumeCache()", ex);
            }
        }
    
    
    /** 
        * The newVolume method create a new volume base on volume element into the metadata file
        *
        * @param dictname
        * @param volume : dictionary element into the metadata file
        * @param fileURL
        *
        * @return Volume
        *
        * @exception PapillonBusinessException, IOException
        */
	public static Volume newVolume(String dictname, Element volume, URL fileURL)
		throws fr.imag.clips.papillon.business.PapillonBusinessException, java.io.IOException {
		
			Hashtable cdmElements = null;
            
			// Cette méthode dépend du schéma des volumes.
            String name = volume.getAttribute("name");
            String dbname = volume.getAttribute("dbname");
            String location = volume.getAttribute(LOCATION_ATTRIBUTE);
            String source = volume.getAttribute("source-language");
            String targets = volume.getAttribute("target-languages");
            String reverseLookup = volume.getAttribute("reverse-lookup");
			boolean reverse = (reverseLookup!=null && reverseLookup.equals("true"));
			
            if (null == dbname || dbname.equals("")) {
                dbname = name;
            }
            
			NodeList refNodes = volume.getElementsByTagName("volume-ref");
            String href = "";
            if (null != refNodes && refNodes.getLength()>0) {
                Element tempElt = (Element)refNodes.item(0); 
                href = tempElt.getAttributeNS(XLINK_URI, "href");
			}
			else {
				PapillonLogger.writeDebugMsg("No volume-ref");   
			} 
			
			NodeList cdmElts = volume.getElementsByTagName(CDM_ELEMENTS_TAG);
            if (null != cdmElts && cdmElts.getLength()>0) {
                Element cdmElt = (Element)cdmElts.item(0);
				cdmElements = buildCdmElementsTable(cdmElt, source);
			}
			else {
				PapillonLogger.writeDebugMsg("No cdm-elements tag");   
			} 
			
            String schema = getXmlCode(volume,XMLSCHEMA_TAG, fileURL);
            String tmplInterface = getXmlCode(volume,TEMPLATE_INTERFACE_TAG, fileURL);
            String tmplEntry = getXmlCode(volume,TEMPLATE_ENTRY_TAG, fileURL);
						
			org.w3c.dom.Document myDoc = XMLServices.buildDOMTree(tmplEntry);
			if (myDoc != null) {
				ParseVolume.compileXPathTable(cdmElements, myDoc.getDocumentElement());
			}

			// Embedding the entry into a contribution element
			tmplEntry = updateTemplateEntry(tmplEntry, cdmElements);
			
            String xmlCode= XMLServices.NodeToString(volume);
            
            //
            Volume newVolume = createUniqueVolume(name, dictname, dbname, location, source, targets, href, cdmElements, xmlCode, schema, tmplInterface, tmplEntry, reverse);
            
            // Add in cache
            VolumeCache.putVolumeInCache(newVolume.getName(), newVolume);

            // reset Available languages so that they are correctly computed afterwards
            AvailableLanguages.resetCache();
            
            //
            return newVolume;
		} 
	
    
    /** 
        * Create an unique volume
        *
        * @param String
        * @param String
        * @param String
        * @param String
        * @param String
        * @param String
        * @param String
        * @param Hashtable
        * @param String
        * @param String
        * @param String
        * @param String
        * @param boolean
        *
        * @return Volume
        *
        * @exception PapillonBusinessException
        */
	protected static Volume createUniqueVolume(String name,
											String dictname,
											String dbname,
											String location,
											String source,
											String targets,
											String href,
											java.util.Hashtable cdmElements,
											String xmlCode,
											String xmlSchema,
											String tmplInterface,
											String tmplEntry,
											boolean reverse)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Volume myVolume = null;
			if ((name!=null) && (dictname!=null) && (dbname!=null)
				&& (source!=null) && (href!=null) && (xmlCode!=null)) 
			{
				//search for an existing dictionary
				myVolume = VolumesFactory.getVolumeByName(name);
				if (myVolume == null || myVolume.isEmpty()) {
                    //does'nt exist, create :
					myVolume=new Volume();
					myVolume.setName(name);
					myVolume.setDictname(dictname);
					myVolume.setDbname(dbname);
					myVolume.setLocation(location);
					myVolume.setSourceLanguage(source);
					myVolume.setTargetLanguages(targets);
					myVolume.setVolumeRef(href);
					myVolume.setCdmElements(cdmElements);
					myVolume.setXmlCode(xmlCode);
					myVolume.setXmlSchema(xmlSchema);
					myVolume.setTemplateInterface(tmplInterface);
					myVolume.setTemplateEntry(tmplEntry);
					myVolume.setReverseLookup(reverse);
				} else {
                    PapillonLogger.writeDebugMsg("Volume already in the Database");
				}
			}
			return myVolume;	
		}
    
    /** 
        * Find volume by name
        *
        * @param String
        *
        * @return Volume
        *
        * @exception PapillonBusinessException
        */
	public static Volume getVolumeByName(String name) 
        throws PapillonBusinessException {
			
            //
            return VolumeCache.getVolumeInCache(name);
            
            /*
             Volume theVolume = null;
			
            if (null != name && !name.equals("")) {        
				try {
					VolumeQuery query = new VolumeQuery(CurrentDBTransaction.get());
					//set query
					query.setQueryName(name,QueryBuilder.CASE_INSENSITIVE_EQUAL);
					// Throw an exception if more than one message is found
					query.requireUniqueInstance();
					VolumeDO theVolumeDO = query.getNextDO();
					theVolume = new Volume(theVolumeDO);
				}catch(Exception ex) {
					throw new PapillonBusinessException("Exception in getVolumeByName()", ex);
				}
            }
            return theVolume;
             */
		}
    
    
    /** 
        * Get volume by handle
        *
        * @param String
        *
        * @return Volume
        *
        * @exception PapillonBusinessException
        */
	public static Volume getVolumeByHandle(String handle) 
        throws PapillonBusinessException {
			
            //
            return VolumeCache.getVolumeInCacheByHandle(handle);
		}
    
    
    /** 
        * Find volume by database name
        *
        * @param String
        *
        * @return Volume
        *
        * @exception PapillonBusinessException
        *
	public static Volume findVolumeByDbname(String name) 
        throws PapillonBusinessException {
			Volume theVolume = null;
			if (null != name && !name.equals("")) {
				try {
					VolumeQuery query = new VolumeQuery(CurrentDBTransaction.get());
					//set query
					query.setQueryDbname(name,QueryBuilder.CASE_INSENSITIVE_EQUAL);
					// Throw an exception if more than one message is found
					query.requireUniqueInstance();
					VolumeDO theVolumeDO = query.getNextDO();
					theVolume = new Volume(theVolumeDO);
				}
				catch(Exception ex) {
					throw new PapillonBusinessException("Exception in findVolumeByDbame()", ex);
				}
			}
			return theVolume;
		}
    */
    
    

    /** 
        * Parse url file to create a new volume
        *
        * @param Dictionary
        * @param URL
        * @param boolean
        * @param boolean
        *
        * @return Volume
        *
        * @exception PapillonBusinessException
        */
	public static Volume parseVolumeMetadata (Dictionary dict, URL fileURL, boolean parseEntries, boolean logContribs) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
            Volume resVolume = null;
			
            try {
                Document docXml = XMLServices.buildDOMTree(fileURL);
                PapillonLogger.writeDebugMsg("The xml code:");
                PapillonLogger.writeDebugMsg(XMLServices.xmlCodePrettyPrinted(docXml));
                
				//on recupere le dictionnaire
				Element volume;	
				boolean virtual = false;
				volume=(Element)docXml.getElementsByTagName(VOLUME_TAG).item(0);
				if (volume != null) {
					String virtualString = volume.getAttribute(VIRTUAL_ATTRIBUTE);
					virtual = (virtualString!=null && virtualString.equals("true"));
				}	
				
				// ajout du dico ds la table.
                resVolume = VolumesFactory.newVolume(dict.getName(), volume, fileURL);
                if (null != resVolume) {
                    resVolume.save();
                    
                    NodeList stylesheets =(NodeList)docXml.getElementsByTagName(XSLSHEET_TAG);
                    
					for (int i=0; i<stylesheets.getLength(); i++) {
                        Element stylesheet = (Element) stylesheets.item(i);
                        
                        if (null != stylesheet) {
                            String ref = stylesheet.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE);
                            String name = stylesheet.getAttribute(NAME_ATTRIBUTE);
							if (name == null || name.equals("")) {
								name = resVolume.getName() + "." + resVolume.getHandle();
							}
							
                            //
                            String isDefault = stylesheet.getAttribute(DEFAULT_ATTRIBUTE);
                            boolean isDefaultXsl = (null != isDefault && isDefault.equals("true"));
                            
                            //
                            String isExternal = stylesheet.getAttribute(EXTERNAL_ATTRIBUTE);
                            boolean isExternalXsl = (null != isExternal && isExternal.equals("true"));
                            
                            //
                            URL resultURL = new URL(fileURL,ref);
                            String xslString = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(resultURL);
                            XslSheetFactory.AddXslSheet(name, dict.getName(), resVolume.getName(), null, xslString, isDefaultXsl, isExternalXsl);
                        }
                    }

                    if (resVolume.getLocation().equals(Volume.LOCAL_LOCATION) && !virtual) {
						VolumeEntriesFactory.createVolumeTables(resVolume);
						if (parseEntries) {
							URL resultURL = new URL(fileURL,resVolume.getVolumeRef());
							ParseVolume.parseVolume(dict, resVolume, resultURL.toString(), logContribs);
						}
						else {
							PapillonLogger.writeDebugMsg("parseVolumeMetadata: do not parse entries!");
						}
                    }
                }
				else {
					PapillonLogger.writeDebugMsg("parseVolumeMetadata: volume null!");
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in parseVolumeMetadata()", ex);
			}
			return resVolume;
		}
    
    /*
    public static Volume findVolumeByID(String id) 
        throws PapillonBusinessException {
			Volume theVolume = null;
			VolumeDO theVolumeDO = null;
			
			try {
				VolumeQuery query = new VolumeQuery(CurrentDBTransaction.get());  
				//set query
				query.setQueryOId(new ObjectId(id));
				// Throw an exception if more than one message is found
				query.requireUniqueInstance();
				theVolumeDO = query.getNextDO();
				theVolume = new Volume(theVolumeDO);
				return theVolume;
				
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in findVolumeByID()", ex);
			}
		}
	*/
    
    
    /** 
        * Return a list of volume names
        *
        * @return String[]
        *
        * @exception PapillonBusinessException
        +/
    // FIXME: return Collection
    public static String[] getVolumesArrayName()
		throws PapillonBusinessException {
			return getVolumesArrayName(null, null, null);
		}
    */
    
    /** 
        * Return a list of volumes
        *
        * @return Collection
        *
        * @exception PapillonBusinessException
        */
    public static Collection getVolumesArray()
		throws PapillonBusinessException {
			return getVolumesArray(null, null, null);
		}
    
    
    /** 
        * Return a list of volume names
        *
        * @return String[]
        *
        * @exception PapillonBusinessException
        +/
    // FIXME: return Collection
    public static String[] getVolumesArrayName(String dictName)
		throws PapillonBusinessException {
			return getVolumesArrayName(dictName, null, null);
		}
	*/
    
    /** 
        * Return a list of volumes
        *
        * @return Volume[]
        *
        * @exception PapillonBusinessException
        */
	public static Collection getVolumesArray(String dictName)
		throws PapillonBusinessException {
			return getVolumesArray(dictName, null, null);
		}
    
    
    /** 
        * Return a list of volume names
        *
        * @return String[]
        *
        * @exception PapillonBusinessException
        +/
    // FIXME: return Collection
    public static String[] getVolumesArrayName(String dictname, String source, String target)
		throws PapillonBusinessException {
            Volume[] volumeList = getVolumesArray(dictname, source, target);
            String[] nameList = new String[ volumeList.length ];
            for ( int i = 0; i < volumeList.length; i++ )
                nameList[i] = volumeList[i].getName();
			return nameList;
		}
	*/
    
    /** 
        * Return a list of volumes
        *
        * @return Collection
        *
        * @exception PapillonBusinessException
        */
	// FIXME: should provide the same method with a dictionary instead of a dictionary name. And use it when possible.
    public static Collection getVolumesArray(String dictname, String source, String target) 
        throws PapillonBusinessException {
            
            try {
                
                //
                ArrayList volumes = new ArrayList(VolumeCache.getVolumesInCache());
                
                if ((dictname != null) && !dictname.equals("")) {
                    
                    //
                    Collection volumesByDictionaryName = VolumeCache.getVolumesInCacheByDictionaryName(dictname);
                    volumes.retainAll(volumesByDictionaryName);
                }
                
                if ((source != null) && !source.equals("")) {
                    
                    //
                    Collection volumesBySource = VolumeCache.getVolumesInCacheBySourceLanguage(source);
                    volumes.retainAll(volumesBySource);
                }
                
                if ((target != null) && !target.equals("")) {
                    
                    //
                    Collection volumesByTarget = VolumeCache.getVolumesInCacheByTargetLanguage(target);
                    volumes.retainAll(volumesByTarget);
                }
                
                
                //
                return volumes;
                
                /*
                Volume[] theDictArray = null;
                ArrayList theDictArrayList = new ArrayList();

                for (Iterator iter = volumes.iterator(); iter.hasNext();) {
                    Volume volume = (Volume)iter.next();
                    
                    if ( ((dictname == null) || dictname.equals("")) 
                         && ((source == null) || source.equals("")) 
                         && ((target == null) || target.equals("")) ) { 
                        
                        //
                        theDictArrayList.add(volume);
                        
                    } else if ( (dictname != null) && !dictname.equals("") && dictname.equals(dictname)
                                && ((source == null) || source.equals("")) 
                                && ((target == null) || target.equals("")) ) {
                        
                        //
                        theDictArrayList.add(volume);
                        
                    } else if ( (dictname != null) && !dictname.equals("") && dictname.equals(dictname)
                                && (source != null) && !source.equals("")  && volume.getSourceLanguage().equals(source)
                                && ((target == null) || target.equals("")) ) {
                        
                        //
                        theDictArrayList.add(volume);
                        
                    }  else if ( (dictname != null) && !dictname.equals("") && dictname.equals(dictname)
                                 && (source != null) && !source.equals("") && volume.getSourceLanguage().equals(source)
                                 && (target != null) && !target.equals("") ) {
                        
                        //
                        String[] targets = volume.getTargetLanguagesArray();
                        int j = 0;
                        while ( (j < targets.length) && (!targets[j].equals(target)) ) {
                            j++;
                        }
                        
                        if (j < targets.length) {
                            theDictArrayList.add(volume);
                        }
                    }
                }
                
                // A ENLEVER !  ... mettre Collection a la place de Volume[]
                theDictArray = new Volume[theDictArrayList.size()];
                int i = 0;
				for (Iterator iter = theDictArrayList.iterator(); iter.hasNext();) {
                    theDictArray[i] = (Volume)iter.next();
                    i++;
                }
                 //return theDictArray;
                 */
                
			} catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getVolumesArray()", ex);
			}
			
			
		}
    
    
    /** 
        * Return the collection of all volumes
        *
        * @return Collection
        *
        * @exception PapillonBusinessException
        */
    public static Collection getVolumes() 
        throws PapillonBusinessException {
            
            return VolumeCache.getVolumesInCache();
            
            /*
            Volume[] theDictArray = null;
			
            try {
                VolumeQuery query = new VolumeQuery(CurrentDBTransaction.get());
                
				query.addOrderByName(true);  
				VolumeDO[] DOarray = query.getDOArray();
				theDictArray = new Volume[ DOarray.length ];
				for ( int i = 0; i < DOarray.length; i++ )
					theDictArray[i] = new Volume(DOarray[i]);
				
			}catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getVolumesArray()", ex);
			}
			
			return theDictArray;
             */
		}
    
    /** 
        * Return the list of all source languages
        *
        * @return Enumeration
        *
        * @exception PapillonBusinessException
        */
    public static Enumeration getSourceLanguages() 
        throws PapillonBusinessException {
            
            return VolumeCache.getSourceLanguagesInCache();

		}
    
    /** 
        * Return the list of all target languages
        *
        * @return Enumeration
        *
        * @exception PapillonBusinessException
        */
    public static Enumeration getTargetLanguages() 
        throws PapillonBusinessException {
            
            return VolumeCache.getTargetLanguagesInCache();
            
		}
	
    
    /*
	public static String getSymetricVolumeName(String myVolumeName) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		String resName = "";
			/* FIXME √† recoder proprement en utilsant les language-link des metadonn√©es du dictionnaire 
		Volume myVolume = getVolumeByName(myVolumeName);
		if (myVolume != null && !myVolume.isEmpty()) {
			Volume resVolume = getSymetricVolume(myVolume);
			if (resVolume != null && !resVolume.isEmpty()) {
				resName = resVolume.getName();
			}
		}
			+/
		if (myVolumeName.equals(VOLUME_GDEF_est)
			|| myVolumeName.equals(VOLUME_GDEF_tes)) {
			resName = VOLUME_GDEF_fra;
		}
		else if (myVolumeName.equals(VOLUME_GDEF_fra))  {
			resName = VOLUME_GDEF_est;
		}
		return resName;
	}
	
	
   
	protected static Volume getSymetricVolume(Volume myVolume) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Volume resVolume = null;
		
		Volume[] volumesArray = getVolumesArray(myVolume.getDictname());
		int i=0;
		while (resVolume==null && i<volumesArray.length) {
			Volume tmpVolume = volumesArray[i];
			if (!tmpVolume.getName().equals(myVolume.getName())) {
				resVolume = tmpVolume;
			}
			i++;
		}
		return resVolume;
	}
	*/
	
            
    /** 
    * Return the xml code of a tag in the url file 
    *
    * @param Element
    * @param String
    * @param URL
    *
    * @return String
    *
    * @exception PapillonBusinessException
    */        
	protected static String getXmlCode(Element myDOMElement, String tag, URL fileURL) throws PapillonBusinessException {
		String res = "";
		String href ="";
		try {
			NodeList refNodes = myDOMElement.getElementsByTagName(tag);
			if (null != refNodes && refNodes.getLength()>0) {
				Element tempElt = (Element)refNodes.item(0);
				href = tempElt.getAttributeNS(XLINK_URI, "href");
				if (href!=null && !href.equals("")) {
					URL resultURL = new URL(fileURL,href);
					PapillonLogger.writeDebugMsg("getXmlCode with URL: " + resultURL.toString());
					res = XMLServices.xmlCode(XMLServices.buildDOMTree(resultURL));
				}
			}
			else {
				PapillonLogger.writeDebugMsg("No " + tag);
			}
		}
		catch (MalformedURLException ex) {
			throw new PapillonBusinessException("Error in getXmlCode with the href " + href,ex);
		}
		return res;
	}
	
    
    /** 
        * 
        *
        * @param String
        * @param String
        * @param String
        *
        * @return Hashtable
        *
        * @exception PapillonBusinessException
        */
	/* cdmElements Hashtable = {lang => Hashtable} = {CDM_element => Vector} = (xpathString, isIndex, XPath)*/
	public static Hashtable buildCdmElementsTable(String xmlCode, String tmplEntry, String sourceLanguage) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Hashtable cdmElements = new Hashtable();
		Document docXml = XMLServices.buildDOMTree(xmlCode);
		NodeList cdmElts = docXml.getElementsByTagName(CDM_ELEMENTS_TAG);
		if (null != cdmElts && cdmElts.getLength()>0) {
			Element cdmElt = (Element)cdmElts.item(0);
			cdmElements = buildCdmElementsTable(cdmElt, sourceLanguage);
		}
		else {
			PapillonLogger.writeDebugMsg("No cdm-elements tag");   
		}
		org.w3c.dom.Document myDoc = XMLServices.buildDOMTree(tmplEntry);
		if (myDoc != null) {
			ParseVolume.compileXPathTable(cdmElements, myDoc.getDocumentElement());
		}
		return cdmElements;
	}
	
    
    /** 
        * 
        *
        * @param Node
        * @param String
        *
        * @return Hashtable
        */
	/* cdmElements Hashtable = {lang => Hashtable} = {CDM_element => Vector} = (xpathString, isIndex, XPath)*/
	protected static Hashtable buildCdmElementsTable(Node cdmElt, String sourceLanguage) {
		Hashtable cdmElements = new Hashtable();
		NodeList cdmChilds = cdmElt.getChildNodes();
		for (int i=0;i<cdmChilds.getLength();i++) {
			Node myNode = cdmChilds.item(i);
			if (myNode.getNodeType() == Node.ELEMENT_NODE) {
				Element myElt = (Element) myNode;
				String eltName = myElt.getTagName();
				
				/* determine the language of the cdm element */
				String lang = Volume.DEFAULT_LANG;
				Attr langAttr = myElt.getAttributeNodeNS(DML_URI, LANG_ATTRIBUTE);
				if (langAttr != null) {
					lang = langAttr.getValue();
				}
				else if (Volume.isLangCDMElement(eltName)) {
					lang = sourceLanguage;
				}
				
				/* determine if the cdm element has to be indexed */
				boolean isIndex = false;
				String index = myElt.getAttribute(INDEX_ATTRIBUTE);
				isIndex = (index != null && index.equals("true"));
				if (!isIndex) {
					isIndex = Volume.isIndexCDMElement(eltName);
				}		   

				String xpath = myElt.getAttribute(XPATH_ATTRIBUTE);
				PapillonLogger.writeDebugMsg("addCdmElementInTable: " + eltName + " lang: " + lang + " index: " + isIndex + " xpath: " + xpath);
				addCdmElementInTable(cdmElements,eltName,lang,xpath, isIndex);
			}
		}
		completeCdmElementsTable(cdmElements, sourceLanguage);
		updateCdmElementsTable(cdmElements);
		return cdmElements;
	}
	
    
    /** 
        * 
        *
        * @param Hashtable
        */
	/* cdmElements Hashtable = {lang => Hashtable} = {CDM_element => Vector} = (xpathString, isIndex, XPath)*/
	protected static void updateCdmElementsTable(Hashtable cdmElements) {
	
		String contribPath = getCdmXPathString(cdmElements, Volume.CDM_contribution, Volume.DEFAULT_LANG);
		String entryPath = getCdmXPathString(cdmElements, Volume.CDM_entry, Volume.DEFAULT_LANG);
		String entryTag = Volume.getTagNameFromXPath(entryPath);

		for (java.util.Enumeration langKeys = cdmElements.keys(); langKeys.hasMoreElements();) {
			String lang = (String) langKeys.nextElement();
			java.util.Hashtable tmpTable =  (java.util.Hashtable) cdmElements.get(lang);
			for (java.util.Enumeration keys = tmpTable.keys(); keys.hasMoreElements();) {
				String CDM_element = (String) keys.nextElement();
				java.util.Vector eltVector = (java.util.Vector) tmpTable.get(CDM_element);
				if (eltVector != null && eltVector.size()>=2) {
					String xpathString =  (String) eltVector.elementAt(0);
					if (xpathString.indexOf(contribPath)<0 
						&& xpathString.indexOf(entryPath)==0) {
						xpathString = searchAndReplace(xpathString,entryPath,contribPath + "/" + VolumeEntry.dataTag + "/" + entryTag);
						eltVector.remove(0);
						eltVector.add(0,xpathString);
					}
				}
			}
		}
		/* Here I keep the original entry xpath in order to use it when I load the template entry */
		addCdmElementInTable(cdmElements,Volume.CDM_templateEntry,Volume.DEFAULT_LANG,entryPath, false);
	}
	
    
    /** 
        * 
        *
        * @param Hashtable
        * @param String
        */
	/* cdmElements Hashtable = {lang => Hashtable} = {CDM_element => Vector} = (xpathString, isIndex, XPath)*/
	protected static void completeCdmElementsTable(Hashtable elementsTable, String sourceLanguage) {
		String currentXpath = getCdmXPathString(elementsTable, Volume.CDM_volume, Volume.DEFAULT_LANG);
		// PapillonLogger.writeDebugMsg("completeCdmElementsTable: currentXpath: " + currentXpath);

	// contribution tags
		currentXpath += "/" + VolumeEntry.contributionTag;
		if (getCdmXPathString(elementsTable, Volume.CDM_contribution, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contribution,Volume.DEFAULT_LANG,currentXpath, Volume.isIndexCDMElement(Volume.CDM_contribution));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionId, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionId,Volume.DEFAULT_LANG,currentXpath + "/@" + VolumeEntry.contributionIdAttr, Volume.isIndexCDMElement(Volume.CDM_contributionId));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_originalContributionId, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_originalContributionId,Volume.DEFAULT_LANG,currentXpath + "/@" + VolumeEntry.originalContributionIdAttr, Volume.isIndexCDMElement(Volume.CDM_originalContributionId));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionDataElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionDataElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.dataTag, Volume.isIndexCDMElement(Volume.CDM_contributionDataElement));
		}
		currentXpath += "/" + VolumeEntry.metadataTag;
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionAuthorElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionAuthorElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.authorTag, Volume.isIndexCDMElement(Volume.CDM_contributionAuthorElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionAuthor, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionAuthor,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.authorTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionAuthor));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionGroups, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionGroups,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.groupsTag, Volume.isIndexCDMElement(Volume.CDM_contributionGroups));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionGroup, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionGroup,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.groupsTag + "/" + VolumeEntry.groupTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionGroup));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionCreationDateElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionCreationDateElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.creationDateTag, Volume.isIndexCDMElement(Volume.CDM_contributionCreationDateElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionCreationDate, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionCreationDate,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.creationDateTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionCreationDate));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionFinitionDateElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionFinitionDateElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.finitionDateTag, Volume.isIndexCDMElement(Volume.CDM_contributionFinitionDateElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionFinitionDate, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionFinitionDate,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.finitionDateTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionFinitionDate));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionReviewDateElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionReviewDateElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.reviewDateTag, Volume.isIndexCDMElement(Volume.CDM_contributionReviewDateElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionReviewDate, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionReviewDate,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.reviewDateTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionReviewDate));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionReviewerElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionReviewerElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.reviewerTag, Volume.isIndexCDMElement(Volume.CDM_contributionReviewerElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionReviewer, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionReviewer,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.reviewerTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionReviewer));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionValidationDateElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionValidationDateElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.validationDateTag, Volume.isIndexCDMElement(Volume.CDM_contributionValidationDateElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionValidationDate, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionValidationDate,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.validationDateTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionValidationDate));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionValidatorElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionValidatorElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.validatorTag, Volume.isIndexCDMElement(Volume.CDM_contributionValidatorElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionValidator, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionValidator,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.validatorTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionValidator));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionStatusElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionStatusElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.statusTag, Volume.isIndexCDMElement(Volume.CDM_contributionStatusElement));
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_contributionStatus, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_contributionStatus,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.statusTag + "/text()", Volume.isIndexCDMElement(Volume.CDM_contributionStatus));
		}
        // Previous classified finished contribution
        if (getCdmXPathString(elementsTable, Volume.CDM_previousClassifiedFinishedContributionElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_previousClassifiedFinishedContributionElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.previousClassifiedFinishedContributionTag, false);
		}  
        if (getCdmXPathString(elementsTable, Volume.CDM_previousClassifiedFinishedContribution, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_previousClassifiedFinishedContribution,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.previousClassifiedFinishedContributionTag + "/text()", true);
		}  
        // Previous classified not finished contribution
        if (getCdmXPathString(elementsTable, Volume.CDM_previousClassifiedNotFinishedContributionElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_previousClassifiedNotFinishedContributionElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.previousClassifiedNotFinishedContributionTag, false);
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_previousClassifiedNotFinishedContribution, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_previousClassifiedNotFinishedContribution,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.previousClassifiedNotFinishedContributionTag + "/text()", true);
		}
        // Next contribution author
        if (getCdmXPathString(elementsTable, Volume.CDM_nextContributionAuthorElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_nextContributionAuthorElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.nextContributionAuthorTag, false);
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_nextContributionAuthor, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_nextContributionAuthor,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.nextContributionAuthorTag + "/text()", true);
		}
        
		
		currentXpath += "/" + VolumeEntry.historyTag;
		if (getCdmXPathString(elementsTable, Volume.CDM_history, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_history,Volume.DEFAULT_LANG,currentXpath, Volume.isIndexCDMElement(Volume.CDM_history));
		}

		currentXpath += "/" + VolumeEntry.modificationTag;
		if (getCdmXPathString(elementsTable, Volume.CDM_modification, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_modification,Volume.DEFAULT_LANG,currentXpath, Volume.isIndexCDMElement(Volume.CDM_modification));
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_modificationAuthorElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_modificationAuthorElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.authorTag, false);
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_modificationAuthor, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_modificationAuthor,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.authorTag + "/text()", true);
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_modificationDateElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_modificationDateElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.dateTag, false);
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_modificationDate, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_modificationDate,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.dateTag + "/text()", true);
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_modificationCommentElement, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_modificationCommentElement,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.commentTag, false);
		}
        if (getCdmXPathString(elementsTable, Volume.CDM_modificationComment, Volume.DEFAULT_LANG) == null) {
			addCdmElementInTable(elementsTable,Volume.CDM_modificationComment,Volume.DEFAULT_LANG,currentXpath + "/" + VolumeEntry.commentTag + "/text()", true);
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_headwordElement, sourceLanguage) == null) {
			String headwordXpath = getCdmXPathString(elementsTable, Volume.CDM_headword, sourceLanguage);
			if (headwordXpath != null) {
				if (headwordXpath.indexOf("/text()")>0) {
					headwordXpath = headwordXpath.substring(0,headwordXpath.indexOf("/text()"));
				}
				addCdmElementInTable(elementsTable,Volume.CDM_headwordElement,sourceLanguage,headwordXpath, Volume.isIndexCDMElement(Volume.CDM_headwordElement));
			}
		}
		if (getCdmXPathString(elementsTable, Volume.CDM_entryIdElement, Volume.DEFAULT_LANG) == null) {
			String entryidxpath = getCdmXPathString(elementsTable, Volume.CDM_entryId, Volume.DEFAULT_LANG);
			if (entryidxpath != null) {
				if (entryidxpath.indexOf("/text()")>0) {
					entryidxpath = entryidxpath.substring(0,entryidxpath.indexOf("/text()"));
				}
				addCdmElementInTable(elementsTable, Volume.CDM_entryIdElement, Volume.DEFAULT_LANG, entryidxpath, Volume.isIndexCDMElement(Volume.CDM_entryIdElement));
			}
		}
	}
	
    
    /** 
        * 
        *
        * @param String
        * @param Hashtable
        *
        * @return String
        *
        * @exception PapillonBusinessException
        */
	// embeds the template entry into a contribution element 
	public static String updateTemplateEntry(String tmplEntry, Hashtable cdmElements) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		if (tmplEntry !=null && !tmplEntry.equals("")) {			
			org.w3c.dom.Document templateDoc = XMLServices.buildDOMTree(tmplEntry);
			org.w3c.dom.NodeList contribNodeList = ParseVolume.getCdmElements(templateDoc, Volume.CDM_contribution, Volume.DEFAULT_LANG, cdmElements);
			org.w3c.dom.NodeList entryNodeList = ParseVolume.getCdmElements(templateDoc, Volume.CDM_templateEntry, Volume.DEFAULT_LANG, cdmElements);
			
			if ((contribNodeList == null || contribNodeList.getLength()==0)
				&& (entryNodeList != null && entryNodeList.getLength()==1)) {
				Node myEntryNode = entryNodeList.item(0);
                // FIXME: maybe use XMLC to have an already compiled DOM ?
                String contributionString = VolumeEntry.ContributionHeader + VolumeEntry.ContributionFooter;
                org.w3c.dom.Document contributionDoc = XMLServices.buildDOMTree(contributionString);
				Node contributionNode = templateDoc.importNode(contributionDoc.getDocumentElement(),true);
				Node entryParent = myEntryNode.getParentNode();
				entryParent.replaceChild(contributionNode, myEntryNode);
				NodeList dataNodeList = ParseVolume.getCdmElements(templateDoc, Volume.CDM_contributionDataElement, Volume.DEFAULT_LANG, cdmElements);
				if (dataNodeList != null && dataNodeList.getLength()==1) {
					Node dataNode = dataNodeList.item(0);
					dataNode.appendChild(myEntryNode);
					tmplEntry = XMLServices.xmlCode(templateDoc);
				}
			}
			else {
				PapillonLogger.writeDebugMsg("updateTemplateEntry: contribNodeList null? " + (contribNodeList == null) + " entryNodeList null?: " + (entryNodeList == null));
			}
		}
		PapillonLogger.writeDebugMsg("updateTemplateEntry: templateEntry final: " + tmplEntry);
		return tmplEntry;
	}
	
	
    /** 
        * 
        *
        * @param Hashtable
        * @param String
        * @param String
        *
        * @return String
        */
	protected static String getCdmXPathString(Hashtable table, String name, String lang) {
		String res = null;
		if (table!=null) {
			java.util.Hashtable tmpTable = (java.util.Hashtable) table.get(lang);
			if (tmpTable != null) {
				java.util.Vector myVector = (java.util.Vector) tmpTable.get(name);
				if (myVector != null && myVector.size()>0) {
					res = (String) myVector.elementAt(0);
				}
			}
		}
		return res;
	}

	
    /** 
        * 
        *
        * @param Hashtable
        * @param String
        * @param String
        * @param String
        * @param boolean
        */
	protected static void addCdmElementInTable(Hashtable table, String elt, String lang, String xpathString, boolean isIndex) {
	/* cdmElements Hashtable = {lang => Hashtable} = {CDM_element => Vector} = (xpathString, isIndex, XPath)*/
//		PapillonLogger.writeDebugMsg("addCdmElementInTable: elt: " + elt + " lang: " + lang + " xpath: " + xpathString + " isIndex: " + isIndex);
		Vector xpathAndIndexVector = new Vector();
		xpathAndIndexVector.add(xpathString); 
		xpathAndIndexVector.add(new Boolean(isIndex)); 
		Hashtable tmpTable = (Hashtable) table.get(lang);
		if (tmpTable==null) {
			tmpTable = new Hashtable();
			table.put(lang,tmpTable);
		}
		tmpTable.put(elt,xpathAndIndexVector);
	}
	
    
    /** 
        * 
        *
        * @param String
        * @param String
        * @param String
        *
        * @return String
        */
	protected static String searchAndReplace(String theString, String search, String replace) {
		String searchedRegex = "\\Q" + search + "\\E";
		theString = theString.replaceAll(searchedRegex, replace);
		return theString;
	}
    
    
    /** 
        * The reConstructionIndex rebuild the volume index.
        *
        * @exception PapillonBusinessException
        */
    public static void reConstructionIndex()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            /*
            // Begin transaction
            CurrentDBTransaction.registerNewDBTransaction();
            
            try {
                
                //
                for (Iterator iter = getVolumesArray().iterator(); iter.hasNext(); ) {
                   
                    //
                    Volume volume = (Volume)iter.next();
                    
                    // Truncate index volumes 
                    IndexFactory.truncateIndexTable(volume);
                    
                    //
                    int count = volume.getCount();
                    int delta = 10; // buffer limit
                    for (int z = 0; z < count; z=z+delta) {
                         
                        //
                        PapillonLogger.writeDebugMsg(volume.getName() + " index : " + Integer.toString(z) + "->" + Integer.toString(z+delta-1));
                        
                        // Buffer volumeEntries
                        //Collection bufferResults = VolumeEntriesFactory.getVolumeEntriesVector(DictionariesFactory.getDictionaryByName(volume.getDictname()), volume, null, null, null, z, delta);
                        Collection bufferResults = VolumeEntriesFactory.getVolumeEntries(volume, z, delta);
                        
                        // Index volumeEntries
                        Iterator buffer = bufferResults.iterator();
                        while ( buffer.hasNext() ) {
                            VolumeEntry ve = (VolumeEntry)buffer.next();
                            ParseVolume.parseEntry(ve);
                        }
                        
                        // A part was correct, commit the transaction ...
                        ((DBTransaction) CurrentDBTransaction.get()).commit();
                    }
                    
                    //
                    System.out.println(volume.getName() + " index re-construction succeed !");
                }
                
                
                
            } catch (Exception e) {
                String userMessage = "Problems while adding the specified dictionary.\n";
                userMessage = userMessage + e.getMessage();
                userMessage = userMessage + "\nAll changes to the database have been rolled back.";
                PapillonLogger.writeDebugMsg(userMessage);
                e.printStackTrace();
                try {
                    ((DBTransaction) CurrentDBTransaction.get()).rollback();
                } catch (java.sql.SQLException sqle) {
                    PapillonLogger.writeDebugMsg("AdminDictionaries: SQLException while rolling back failed transaction.");
                    sqle.printStackTrace();
                }
                
            } finally {
                CurrentDBTransaction.releaseCurrentDBTransaction();
                PapillonLogger.writeDebugMsg("Index re-construction succeed !");
            }
            */

            //
            for (Iterator iter = getVolumesArray().iterator(); iter.hasNext(); ) {
                Volume volume = (Volume)iter.next();

                //
                int count = volume.getCount();
                int delta = 20; // buffer limit
                PapillonLogger.writeDebugMsg("Volume : " + volume.getName() + " - " + count + " entries");

                //
                for (int i = 0; i < count; i=i+delta) {

                    try {

                        // Begin transaction
                        CurrentDBTransaction.registerNewDBTransaction();

                        // Buffer volumeEntries
                        Collection bufferResults = VolumeEntriesFactory.getVolumeEntries(volume, i, delta);

                        //
                        Iterator buffer = bufferResults.iterator();
                        while ( buffer.hasNext() ) {
                            VolumeEntry ve = (VolumeEntry)buffer.next();

                            //
                            ParseVolume.parseEntry(ve);

                        }

                        // End transaction : a part was correct, commit the transaction ...
                        ((DBTransaction) CurrentDBTransaction.get()).commit();
                        PapillonLogger.writeDebugMsg(Integer.toString(i) + " to " + Integer.toString(i + delta - 1));

                    } catch (Exception e) {
                        String userMessage = "Problems when re-index entries.";
                        PapillonLogger.writeDebugMsg(userMessage);
                        e.printStackTrace();

                        //
                        try {
                            ((DBTransaction) CurrentDBTransaction.get()).rollback();
                        } catch (java.sql.SQLException sqle) {
                            PapillonLogger.writeDebugMsg("reConstructionIndex: SQLException while rolling back failed transaction.");
                            sqle.printStackTrace();
                        }

                    } finally {
                        CurrentDBTransaction.releaseCurrentDBTransaction();
                    }
                }

                //
                PapillonLogger.writeDebugMsg(volume.getName() + " index re-construction succeed !");

            }

            //
            PapillonLogger.writeDebugMsg("Index re-construction process succeed !");
        }


    /**
        * The modifiedStatus method modify the status of the contributions appearing "before" a not-finished contribution to modified status.
        *
        * @param User
        *
        * @exception PapillonBusinessException
        */
    // FIXME : supress when GDEF and Papillon project will be import in Jibiki
    public static void modifiedStatus(fr.imag.clips.papillon.business.user.User user)
        throws PapillonBusinessException {
			try {
                
                //
                for (Iterator iter = getVolumesArray().iterator(); iter.hasNext(); ) {
                    
                    //
                    Volume volume = (Volume)iter.next();
                    
                    //
                    // FIXME : change request (see launchtransformation in volume.java)
                    ArrayList allEntries = QueryRequest.findAllLexies(volume, user);
                    
                    //
                    for (int i = 0; i < allEntries.size(); i++) {
                        //
                        QueryResult qr = (QueryResult) allEntries.get(i);
                        VolumeEntry ve = qr.getSourceEntry();
                        
                        if (ve.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                            
                            Collection classifiedFinishedContributionIdCollection = ve.getClassifiedFinishedContributionIdCollection();
                            for (Iterator iter2 = classifiedFinishedContributionIdCollection.iterator(); iter2.hasNext();) {
                                VolumeEntry finishedVe = VolumeEntriesFactory.findEntryByContributionId(ve.getVolumeName(), (String)iter2.next());
                                
                                if (finishedVe.getStatus().equals(VolumeEntry.CLASSIFIED_FINISHED_STATUS)) {
                                    finishedVe.setStatus(VolumeEntry.MODIFIED_STATUS);
                                    finishedVe.setNextContributionAuthor(ve.getModificationAuthor());
                                    finishedVe.save();
                                }
                            }
                        }
                        
                    }
                }

            } catch(Exception ex) {
				throw new PapillonBusinessException("Error when modify status", ex);
			}
		}
    
    
    
    /** 
        * Standardization of all volumes.
        *
        * @exception PapillonBusinessException
        */
    public static void standardization()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            
            // Standardization launch on all volumes
            for (Iterator iter = getVolumesArray().iterator(); iter.hasNext(); ) {
                Volume volume = (Volume)iter.next();

                //
                int count = volume.getCount();
                int delta = 20; // buffer limit
                PapillonLogger.writeDebugMsg("Volume : " + volume.getName() + " - " + count + " entries");
                    
                //
                for (int i = 0; i < count; i=i+delta) {
                    
                    try {
                        
                        // Begin transaction
                        CurrentDBTransaction.registerNewDBTransaction();
                        
                        // Buffer volumeEntries
                        Collection bufferResults = VolumeEntriesFactory.getVolumeEntries(volume, i, delta);
                        
                        //
                        Iterator buffer = bufferResults.iterator();
                        while ( buffer.hasNext() ) {
                            VolumeEntry ve = (VolumeEntry)buffer.next();
                            
                            //
                            if (!ve.isEmpty() ) {
                                //&& (ve.getXmlCode() != null)
                                //&& !ve.getXmlCode().equals("")) {
                                
                                //
                                Document dom = ve.getDom();
                                Element root = dom.getDocumentElement();
                                normalizeNode((Node)root);
                                //PapillonLogger.writeDebugMsg(XMLServices.xmlCodePrettyPrinted(dom));
                                ve.save();
                                
                            } else {
                                
                                //
                                PapillonLogger.writeDebugMsg("Database return a null DO while applying a transformation");
                            }
                            
                        }
                        
                        // End transaction : a part was correct, commit the transaction ...
                        ((DBTransaction) CurrentDBTransaction.get()).commit();
                        PapillonLogger.writeDebugMsg(Integer.toString(i) + " to " + Integer.toString(i + delta - 1));                        
                        
                    } catch (Exception e) {
                        String userMessage = "Problems when normalize entries.";
                        PapillonLogger.writeDebugMsg(userMessage);
                        e.printStackTrace();
                        
                        //
                        try {
                            ((DBTransaction) CurrentDBTransaction.get()).rollback();
                        } catch (java.sql.SQLException sqle) {
                            PapillonLogger.writeDebugMsg("standardization: SQLException while rolling back failed transaction.");
                            sqle.printStackTrace();
                        }
                        
                    } finally {
                        CurrentDBTransaction.releaseCurrentDBTransaction();
                    }
                }
                
                //
                PapillonLogger.writeDebugMsg(volume.getName() + " : standardization succeed !");
                
            }
            
            //
            PapillonLogger.writeDebugMsg("Standardization process succeed !");
        }
    
    
    /** 
        * normalize value node and child nodes.
        *
        * @param Node
        *
        * @exception PapillonBusinessException
        */
    private static void normalizeNode(Node node) {
        
        while (node != null) {
            String value = node.getNodeValue();
            
            // Normalize value
            if (value != null && !value.equals("")) {
                node.setNodeValue(VolumeEntriesFactory.normalizeValue(value));
            }
            
            //
            normalizeNode(node.getFirstChild());
            node = node.getNextSibling();
        }
    }


    /**
        * Apply xsl transformation to all entries of the volume
        *
        * @param Node
        *
        * @exception PapillonBusinessException
        */
    public static void launchTransformation(String xslTransformation, Volume volume, User user)
        throws PapillonBusinessException {
			/*
             try {
                 //
                 TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
                 Transformer myTransformer = myTransformerFactory.newTransformer(new StreamSource(new StringReader(xslTransformation)));

                 //
                 ArrayList allEntries = QueryRequest.findAllLexies(this.getName(), user);

                 //
                 for (int i = 0; i < allEntries.size(); i++) {
                     //
                     QueryResult qr = (QueryResult) allEntries.get(i);
                     VolumeEntry ve = qr.getSourceEntry();

                     //
                     DOMSource xmlSource = new DOMSource(Utility.buildDOMTree(ve.getXmlCode()));
                     DOMResult xmlTarget = new DOMResult();

                     //
                     myTransformer.transform(xmlSource, xmlTarget);

                     //
                     //System.out.println(ve.getXmlCode());
                     //System.out.println(Utility.NodeToString((Document) xmlTarget.getNode()))

                     //
                     ve.setDom((Document) xmlTarget.getNode());
                     ve.save();
                 }
             } catch(Exception ex) {
                 throw new PapillonBusinessException("Error deleting Volume", ex);
             }
             */




            try {
                // Get transformer
                TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
                Transformer myTransformer = myTransformerFactory.newTransformer(new StreamSource(new StringReader(xslTransformation)));

                // Truncate index volumes
                IndexFactory.truncateIndexTable(volume);

                //
                int count = volume.getCount();
                int delta = 20; // buffer limit
                PapillonLogger.writeDebugMsg("Volume : " + volume.getName() + " - " + count + " entries");

                //
                for (int i = 0; i < count; i=i+delta) {

                    try {

                        // Begin transaction
                        CurrentDBTransaction.registerNewDBTransaction();

                        // Buffer volumeEntries
                        // Replace getVolumeEntriesVector because "order by" expression
                        //Collection bufferResults = VolumeEntriesFactory.getVolumeEntriesVector(DictionariesFactory.getDictionaryByName(volume.getDictname()), volume, null, null, null, z, delta);
                        Collection bufferResults = VolumeEntriesFactory.getVolumeEntries(volume, i, delta);

                        //
                        Iterator buffer = bufferResults.iterator();
                        while ( buffer.hasNext() ) {
                            VolumeEntry ve = (VolumeEntry)buffer.next();

                            //
                            if ( !ve.isEmpty() ) {
                                //&& (ve.getXmlCode() != null)
                                //&& !ve.getXmlCode().equals("")) {

                                //
                                //PapillonLogger.writeDebugMsg("--------------> Entry ID : " + ve.getEntryId());
                                //PapillonLogger.writeDebugMsg(XMLServices.xmlCodePrettyPrinted((Document)ve.getDom()));

                                //
                                DOMSource xmlSource = new DOMSource(ve.getDom());
                                DOMResult xmlTarget = new DOMResult();

                                //
                                myTransformer.transform(xmlSource, xmlTarget);
                                //PapillonLogger.writeDebugMsg(Utility.NodeToString((Document) xmlTarget.getNode()))

                                //
                                ve.setDom((Document) xmlTarget.getNode());
                                ve.save();

                            } else {

                                //
                                PapillonLogger.writeDebugMsg("Database return a null DO while applying a transformation");
                            }

                        }

                        // End transaction : a part was correct, commit the transaction ...
                        ((DBTransaction) CurrentDBTransaction.get()).commit();
                        PapillonLogger.writeDebugMsg(Integer.toString(i) + " to " + Integer.toString(i + delta -1));


                    } catch (Exception e) {
                        String userMessage = "Problems when transform entries.";
                        PapillonLogger.writeDebugMsg(userMessage);
                        e.printStackTrace();

                        try {
                            ((DBTransaction) CurrentDBTransaction.get()).rollback();
                        } catch (java.sql.SQLException sqle) {
                            PapillonLogger.writeDebugMsg("launchTransformation: SQLException while rolling back failed transaction.");
                            sqle.printStackTrace();
                        }
                    } finally {
                        CurrentDBTransaction.releaseCurrentDBTransaction();
                    }
                }

            } catch (javax.xml.transform.TransformerConfigurationException e) {
                e.printStackTrace();
            }

            //
            PapillonLogger.writeDebugMsg(volume.getName() + " : transformation succeed !");

		}


}

