/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
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

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.CurrentDBTransaction;
import com.lutris.appserver.server.sql.DBTransaction;

//for URLs
import java.net.URL;
import java.net.MalformedURLException;


//pour parser le document avec le DOM
import org.w3c.dom.*;

import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;

import java.util.*;

import fr.imag.clips.papillon.business.utility.Utility;

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
	
	protected final static String VOLUME_GDEF_est="GDEF_est";
	protected final static String VOLUME_GDEF_tes="GDEF_tes";
	protected final static String VOLUME_GDEF_fra="GDEF_fra";
		
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
						
			org.w3c.dom.Document myDoc = Utility.buildDOMTree(tmplEntry);
			if (myDoc != null) {
				ParseVolume.compileXPathTable(cdmElements, myDoc.getDocumentElement());
			}

			// Embedding the entry into a contribution element
			tmplEntry = updateTemplateEntry(tmplEntry, cdmElements);
			
            String xmlCode=Utility.NodeToString(volume);
            return createUniqueVolume(name, dictname, dbname, location, source, targets, href, cdmElements, xmlCode, schema, tmplInterface, tmplEntry, reverse);
		} 
	
	public static Volume findVolumeByName(String name) 
        throws PapillonBusinessException {
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
					throw new PapillonBusinessException("Exception in findVolumeByName()", ex);
				}
            }
            return theVolume;
		}
    
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
    
	public static Volume createUniqueVolume(String name,
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
				Volume Existe=VolumesFactory.findVolumeByName(name);
				if (Existe == null || Existe.isEmpty()) {
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
	
	public static Volume parseVolumeMetadata (Dictionary dict, URL fileURL, boolean parseEntries, boolean logContribs) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
            Volume resVolume = null;
			
            try {
                Document docXml = Utility.buildDOMTree(fileURL);
             //   PapillonLogger.writeDebugMsg("The xml code:");
              //  PapillonLogger.writeDebugMsg(Utility.NodeToString(docXml));
                
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
							
                            String isDefault = stylesheet.getAttribute(DEFAULT_ATTRIBUTE);
                            boolean isDefaultXsl = (null != isDefault && isDefault.equals("true"));
                            
                            URL resultURL = new URL(fileURL,ref);
                            String xslString = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(resultURL);
                            fr.imag.clips.papillon.business.xsl.XslSheetFactory.AddXslSheet(name, dict.getName(), resVolume.getName(),null,xslString,isDefaultXsl);
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
	
    public static String[] getVolumesArrayName()
		throws PapillonBusinessException {
			return getVolumesArrayName(null, null, null);
		}
    
	public static Volume[] getVolumesArray()
		throws PapillonBusinessException {
			return getVolumesArray(null, null, null);
		}
    
    public static String[] getVolumesArrayName(String dictName)
		throws PapillonBusinessException {
			return getVolumesArrayName(dictName, null, null);
		}
	
	public static Volume[] getVolumesArray(String dictName)
		throws PapillonBusinessException {
			return getVolumesArray(dictName, null, null);
		}
    
    public static String[] getVolumesArrayName(String dictname, String source, String target)
		throws PapillonBusinessException {
            Volume[] volumeList = getVolumesArray(dictname, source, target);
            String[] nameList = new String[ volumeList.length ];
            for ( int i = 0; i < volumeList.length; i++ )
                nameList[i] = volumeList[i].getName();
			return nameList;
		}
	
	// FIXME: should provide the same method with a dictionary instead of a dictionary name. And use it when possible.
    public static Volume[] getVolumesArray(String dictname, String source, String target) 
        throws PapillonBusinessException {
			Volume[] theDictArray = null;
			
			try {
				VolumeQuery query = new VolumeQuery(CurrentDBTransaction.get());            
				if ((null != dictname) && (!dictname.trim().equals(""))) {
					query.getQueryBuilder().addWhereClause("dictname", dictname, 
														   QueryBuilder.EQUAL);
				}
				if ((null != source) && (!source.trim().equals(""))) {
					query.getQueryBuilder().addWhereClause("sourceLanguage", source, 
														   QueryBuilder.EQUAL);
				}
				if ((null != target) && (!dictname.trim().equals(""))) {
					query.getQueryBuilder().addWhereClause("targetLanguages", target, 
														   QueryBuilder.CASE_SENSITIVE_CONTAINS);
				}
				query.addOrderByName(true);  
				VolumeDO[] DOarray = query.getDOArray();
				theDictArray = new Volume[ DOarray.length ];
				for ( int i = 0; i < DOarray.length; i++ )
					theDictArray[i] = new Volume(DOarray[i]);
				
			}catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getVolumesArray()", ex);
			}
			
			return theDictArray;
		}
	
	public static String getSymetricVolumeName(String myVolumeName) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		String resName = "";
			/* FIXME à recoder proprement en utilsant les language-link des metadonnées du dictionnaire 
		Volume myVolume = findVolumeByName(myVolumeName);
		if (myVolume != null && !myVolume.isEmpty()) {
			Volume resVolume = getSymetricVolume(myVolume);
			if (resVolume != null && !resVolume.isEmpty()) {
				resName = resVolume.getName();
			}
		}
			*/
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
					res = Utility.NodeToString(Utility.buildDOMTree(resultURL));
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
	
	/* cdmElements Hashtable = {lang => Hashtable} = {CDM_element => Vector} = (xpathString, isIndex, XPath)*/
	public static Hashtable buildCdmElementsTable(String xmlCode, String tmplEntry, String sourceLanguage) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Hashtable cdmElements = new Hashtable();
		Document docXml = Utility.buildDOMTree(xmlCode);
		NodeList cdmElts = docXml.getElementsByTagName(CDM_ELEMENTS_TAG);
		if (null != cdmElts && cdmElts.getLength()>0) {
			Element cdmElt = (Element)cdmElts.item(0);
			cdmElements = buildCdmElementsTable(cdmElt, sourceLanguage);
		}
		else {
			PapillonLogger.writeDebugMsg("No cdm-elements tag");   
		}
		org.w3c.dom.Document myDoc = Utility.buildDOMTree(tmplEntry);
		if (myDoc != null) {
			ParseVolume.compileXPathTable(cdmElements, myDoc.getDocumentElement());
		}
		return cdmElements;
	}
	
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
	
	// embeds the template entry into a contribution element 
	
	public static String updateTemplateEntry(String tmplEntry, Hashtable cdmElements) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		if (tmplEntry !=null && !tmplEntry.equals("")) {			
			org.w3c.dom.Document templateDoc = Utility.buildDOMTree(tmplEntry);
			org.w3c.dom.NodeList contribNodeList = ParseVolume.getCdmElements(templateDoc, Volume.CDM_contribution, Volume.DEFAULT_LANG, cdmElements);
			org.w3c.dom.NodeList entryNodeList = ParseVolume.getCdmElements(templateDoc, Volume.CDM_templateEntry, Volume.DEFAULT_LANG, cdmElements);
			
			if ((contribNodeList == null || contribNodeList.getLength()==0)
				&& (entryNodeList != null && entryNodeList.getLength()==1)) {
				Node myEntryNode = entryNodeList.item(0);
				String contributionString = VolumeEntry.ContributionHeader + VolumeEntry.ContributionFooter;
				org.w3c.dom.Document contributionDoc = Utility.buildDOMTree(contributionString);
				Node contributionNode = templateDoc.importNode(contributionDoc.getDocumentElement(),true);				
				Node entryParent = myEntryNode.getParentNode();
				entryParent.replaceChild(contributionNode, myEntryNode);
				NodeList dataNodeList = ParseVolume.getCdmElements(templateDoc, Volume.CDM_contributionDataElement, Volume.DEFAULT_LANG, cdmElements);
				if (dataNodeList != null && dataNodeList.getLength()==1) {
					Node dataNode = dataNodeList.item(0);
					dataNode.appendChild(myEntryNode);
					tmplEntry = Utility.NodeToString(templateDoc);
				}
			}
			else {
				PapillonLogger.writeDebugMsg("updateTemplateEntry: contribNodeList null? " + (contribNodeList == null) + " entryNodeList null?: " + (entryNodeList == null));
			}
		}
		PapillonLogger.writeDebugMsg("updateTemplateEntry: templateEntry final: " + tmplEntry);
		return tmplEntry;
	}
	
	
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
	
	protected static String searchAndReplace(String theString, String search, String replace) {
		String searchedRegex = "\\Q" + search + "\\E";
		theString = theString.replaceAll(searchedRegex, replace);
		return theString;
	}
    
    
    //
    public static void reConstructionIndex()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            
            // Begin transaction
            CurrentDBTransaction.registerNewDBTransaction();
            
            try {
                
                //
                Volume[] volumes = getVolumesArray();
                for (int i=0; i < volumes.length; i++) {
                    
                    // Truncate index volumes 
                    IndexFactory.truncateIndexTable(volumes[i]);
                    
                    //
                    int count = volumes[i].getCount();
                    int delta = 10; // buffer limit
                    for (int z = 0; z < count; z=z+delta) {
                                                
                        // Buffer volumeEntries
                        Collection bufferResults = VolumeEntriesFactory.getVolumeEntriesVector(DictionariesFactory.findDictionaryByName(volumes[i].getDictname()), volumes[i], null, null, null, z, delta);
                        
                        // Index volumeEntries
                        Iterator buffer = bufferResults.iterator();
                        while ( buffer.hasNext() ) {
                            VolumeEntry ve = (VolumeEntry)buffer.next();
                            ParseVolume.parseEntry(ve);
                        }
                        
                    }
                }
                
                // End transaction
                // everything was correct, commit the transaction...
                ((DBTransaction) CurrentDBTransaction.get()).commit();
                
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
            }
        }
	
    
    // FIXME : supress
    public static void modifiedStatus(fr.imag.clips.papillon.business.user.User user)
        throws PapillonBusinessException {
			try {
                
                String[] listName = VolumesFactory.getVolumesArrayName();
                for (int j=0; j < listName.length; j++) {
                    
                    //
                    ArrayList allEntries = QueryRequest.findAllLexies(listName[j], user);
                    
                    //
                    for (int i = 0; i < allEntries.size(); i++) {
                        //
                        QueryResult qr = (QueryResult) allEntries.get(i);
                        VolumeEntry ve = qr.getSourceEntry();
                        
                        if (ve.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                            
                            if ( (ve.getClassifiedFinishedContributionId() != null) 
                                 && !ve.getClassifiedFinishedContributionId().equals("")) {
                                
                                VolumeEntry finishedVe = VolumeEntriesFactory.findEntryByContributionId(ve.getVolumeName(), ve.getClassifiedFinishedContributionId());
                                finishedVe.setStatus(VolumeEntry.MODIFIED_STATUS);
                                finishedVe.setNextContributionAuthor(ve.getModificationAuthor());
                                finishedVe.save();
                            }
                            
                        }
                        
                    }
                }

            } catch(Exception ex) {
				throw new PapillonBusinessException("Error when modify status", ex);
			}
		}
}

