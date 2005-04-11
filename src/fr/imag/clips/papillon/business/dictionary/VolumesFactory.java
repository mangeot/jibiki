/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
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
	
	
	protected final static String DML_URI = "http://www-clips.imag.fr/geta/services/dml";
	protected final static String XLINK_URI = "http://www.w3.org/1999/xlink";
	
	protected final static String VOLUME_TAG = "volume-metadata";
	protected final static String CDM_ELEMENTS_TAG = "cdm-elements";
	protected final static String XSLSHEET_TAG = "xsl-stylesheet";
	protected final static String XMLSCHEMA_TAG = "xmlschema-ref";
	protected final static String TEMPLATE_INTERFACE_TAG = "template-interface-ref";
	protected final static String TEMPLATE_ENTRY_TAG = "template-entry-ref";

	protected final static String HREF_ATTRIBUTE="href";
	protected final static String LANG_ATTRIBUTE="lang";
	protected final static String LOCATION_ATTRIBUTE="location";
	protected final static String VIRTUAL_ATTRIBUTE="virtual";
	protected final static String XPATH_ATTRIBUTE="xpath";
	protected final static String INDEX_ATTRIBUTE="index";
		
	protected final static Hashtable countEntriesCache = new Hashtable(); 
	
	public static Volume newVolume(String dictname, Element volume, URL fileURL)
		throws fr.imag.clips.papillon.business.PapillonBusinessException, java.io.IOException {
		
			Hashtable cdmElements = new Hashtable();
			java.util.Hashtable xpathsTable = null;
            
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
				NodeList cdmChilds = cdmElt.getChildNodes();
				for (int i=0;i<cdmChilds.getLength();i++) {
					Node myNode = cdmChilds.item(i);
					if (myNode.getNodeType() == Node.ELEMENT_NODE) {
						Element myElt = (Element) myNode;
						String eltName = myElt.getTagName();
						String lang = Volume.DEFAULT_LANG;
						Attr langAttr = myElt.getAttributeNodeNS(DML_URI, LANG_ATTRIBUTE);
						if (langAttr != null) {
							lang = langAttr.getValue();
						}
						String xpath = myElt.getAttribute(XPATH_ATTRIBUTE);
						String index = myElt.getAttribute(INDEX_ATTRIBUTE);
						boolean isindex = (index != null && index.equals("true"));
						addCdmElementInTable(cdmElements,eltName,lang,xpath, isindex);
					}
				}
			}
			else {
				PapillonLogger.writeDebugMsg("No volume-ref");   
			} 
			
            String schema = getXmlCode(volume,XMLSCHEMA_TAG, fileURL);
            String tmplInterface = getXmlCode(volume,TEMPLATE_INTERFACE_TAG, fileURL);
            String tmplEntry = getXmlCode(volume,TEMPLATE_ENTRY_TAG, fileURL);
			
			org.w3c.dom.Document myDoc = Utility.buildDOMTree(tmplEntry);
			if (myDoc != null) {
				ParseVolume.compileXPathTable(cdmElements, myDoc.getDocumentElement());
			}
			
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
				if (Existe.IsEmpty())
				{//does'nt exist, create :
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
	
	public static Volume parseVolumeMetadata (Dictionary dict, URL fileURL, String parseEntries) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
            Volume resVolume = null;
			
            try {
                Document docXml = Utility.buildDOMTree(fileURL);
                PapillonLogger.writeDebugMsg("The xml code:");
                PapillonLogger.writeDebugMsg(Utility.NodeToString(docXml));
                
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
                    
					Element stylesheet =(Element)docXml.getElementsByTagName(XSLSHEET_TAG).item(0);
					
					if (null != stylesheet) {
                        String ref = stylesheet.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE);
                        URL resultURL = new URL(fileURL,ref);
                        String xslString = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(resultURL);
                        fr.imag.clips.papillon.business.xsl.XslSheetFactory.AddXslSheet(resVolume.getName(),null,xslString,false);
					}
                    
                    if (resVolume.getLocation().equals(Volume.LOCAL_LOCATION) && !virtual) {
						VolumeEntriesFactory.createVolumeTables(resVolume);
						if (parseEntries != null) {
							URL resultURL = new URL(fileURL,resVolume.getVolumeRef());
						//	VolumeEntriesFactory.parseVolume(dict, resVolume, resultURL.toString());
							ParseVolume.parseVolume(dict, resVolume, resultURL.toString());
						}
                    }
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
	
	public static Volume[] getVolumesArray()
		throws PapillonBusinessException {
			return getVolumesArray(null, null, null);
		}
	
	public static Volume[] getVolumesArray(String dictName)
		throws PapillonBusinessException {
			return getVolumesArray(dictName, null, null);
		}
	
	
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
	
	public static String countEntries(Volume myVolume)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			String result = "-1";
			if (countEntriesCache.containsKey(myVolume.getName())) {
				result = (String) countEntriesCache.get(myVolume.getName());
			}
			else {
				result = String.valueOf(myVolume.countEntries());
				countEntriesCache.put(myVolume.getName(),result);
			}
			return result;
		}
	
	
	public static int intCountEntries(Volume myVolume)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			return Integer.parseInt(countEntries(myVolume));
		}
	
	public static void setCountEntries(Volume myVolume)
		throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			setCountEntries(myVolume.getName(),String.valueOf(myVolume.countEntries()));
		}
	
	public static void resetCountEntries(String myVolumeName)
		throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			setCountEntries(myVolumeName,"0");
		}
	
	protected static void setCountEntries(String myVolumeName, String entries)
		throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			countEntriesCache.put(myVolumeName,entries);
		}
	
	public static void deleteCountEntries(String myVolumeName)
		throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			countEntriesCache.remove(myVolumeName);
		}
	
	public static void resetCountEntriesCache()
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Volume[] Volumes = getVolumesArray();
			for (int i=0;i<Volumes.length;i++) {
				setCountEntries(Volumes[i]);
			}
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
	
	protected static void addCdmElementInTable(Hashtable table, String elt, String lang, String xpathString, boolean isIndex) {
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
	
}

