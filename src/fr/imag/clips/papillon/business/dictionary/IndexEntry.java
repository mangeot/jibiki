/*
 -----------------------------
 * $Id: IndexEntry.java 1316 2012-07-26 12:51:38Z zhangying $
 *-----------------------------------------------
 * $Log$
  *
 *-----------------------------------------------
 *
 * Created by Mathieu MANGEOT on Tuesday July 31 2012
 *  Copyright (c) 2003-2012 mangeot & zhangying GETALP-LIG. All rights reserved.
 */

package fr.imag.clips.papillon.business.dictionary;

// internal imports

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.business.dictionary.IndexEntry;
import fr.imag.clips.papillon.CurrentDBTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.awt.List;
import java.sql.SQLException;

public class IndexEntry {

    static HashMap weight = new HashMap();
	public static final String ELEMENT_TYPE = "element";
    
    protected static class IndexData {
        String CdmElement, lang, value, handle;

        public IndexData(String cdme, String lang, String value, String handle) {
            CdmElement = cdme;
            this.lang = lang;
            this.value = value;
            this.handle = handle;
        }

        public Index toIndex(String volumeidx) throws PapillonBusinessException {
            return IndexFactory.newIndex(volumeidx, CdmElement, lang, value, handle);

        }
    }

    public static void saveIndexes(ArrayList indexes, String volumeidx) throws PapillonBusinessException {
        Iterator i = indexes.iterator();
        while (i.hasNext()) {
            IndexData id = (IndexData) i.next();
			if (id==null) {PapillonLogger.writeDebugMsg("Index null!!! ");}
            Index myIndex = id.toIndex(volumeidx);
            if (myIndex != null && !myIndex.isEmpty()) {
                myIndex.save();
            }
        }
    }

    public static void saveLinks(ArrayList links) throws PapillonBusinessException {
        Iterator i = links.iterator();
        while (i.hasNext()) {
            Link myLink = (Link) i.next();
            if (myLink != null && !myLink.isEmpty()) {
                myLink.save();
            }
        }
    }
	
    // boolean yeld = true if everything is OK
    public static boolean indexEntry(VolumeEntry myEntry)
            throws PapillonBusinessException {
				
				//linksEntry(myEntry);
				
        org.w3c.dom.Document entryDoc = myEntry.getDom();
        boolean result = false;
				
			if (entryDoc != null) {
				java.util.Hashtable CdmElementsTable = myEntry.getVolume().getCdmElements();
				org.w3c.dom.Element myRootElt = entryDoc.getDocumentElement();
					
				org.apache.xml.utils.PrefixResolver myPrefixResolver = new org.apache.xml.utils.PrefixResolverDefault(myRootElt);

				ArrayList indexes = indexEntry(CdmElementsTable, myRootElt, myPrefixResolver, myEntry.getHandle());
				String volumeidx = myEntry.getVolume().getIndexDbname();
				saveIndexes(indexes, volumeidx);
								
				ArrayList links = indexEntryLinks(CdmElementsTable, myEntry.getVolume(), myRootElt, myPrefixResolver, myEntry.getHandle());
				saveLinks(links);
			}
         
        return result;
    }
    
    public static ArrayList indexEntry(java.util.Hashtable CdmElementsTable, org.w3c.dom.Element myRootElt, org.apache.xml.utils.PrefixResolver myPrefixResolver, String handle)
            throws PapillonBusinessException {
				ArrayList indexes = new ArrayList();				
				
            for (java.util.Enumeration langKeys = CdmElementsTable.keys(); langKeys.hasMoreElements();) {
                String lang = (String) langKeys.nextElement();
                
                java.util.Hashtable tmpTable = (java.util.Hashtable) CdmElementsTable.get(lang);
                for (java.util.Enumeration keys = tmpTable.keys(); keys.hasMoreElements();) {
                    String CdmElement = (String) keys.nextElement();
      
					//PapillonLogger.writeDebugMsg("Index entry, key " + CdmElement + ":");
                    java.util.Vector myVector = (java.util.Vector) tmpTable.get(CdmElement);
                    org.apache.xpath.XPath myXPath = null;
                    boolean isIndex = false;
                    if (myVector != null) {
						isIndex = ((Boolean) myVector.elementAt(1)).booleanValue();
						if (isIndex && !isLink(CdmElement)) {
							myXPath = (org.apache.xpath.XPath) myVector.elementAt(2);
 							
							//PapillonLogger.writeDebugMsg("Index entry: lang: "+ lang +" /key: " + CdmElement + " /xpath: " + (String) myVector.elementAt(0));
							indexes.addAll(createIndexData (CdmElement, myXPath, 
										  lang, handle,
										  myRootElt,myPrefixResolver
										  ));
						}
					}
                }
            }
        return indexes;
    }
	
	protected static boolean isLink (String xpathName) {
		return (xpathName.startsWith(Volume.CDM_link + VolumesFactory.LINK_NAME_SEPARATOR));
	}
    
	
	protected static ArrayList createIndexData (String theElement, org.apache.xpath.XPath theXPath, String theLang, String theHandle,
										org.w3c.dom.Element theRootElement,
										org.apache.xml.utils.PrefixResolver thePrefixResolver) 
		throws PapillonBusinessException {
		ArrayList resultData = new ArrayList();
		org.w3c.dom.NodeList resNodeList = null;
		try {
			org.apache.xpath.objects.XObject myXObject = theXPath.execute(
																		 new org.apache.xpath.XPathContext(), theRootElement, thePrefixResolver);
			resNodeList = myXObject.nodelist();
			//PapillonLogger.writeDebugMsg("Index entry, xPath.execute res: ");
		} catch (javax.xml.transform.TransformerException e) {
			throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
		}
		if (resNodeList != null) {
			for (int i = 0; i < resNodeList.getLength(); i++) {
				org.w3c.dom.Node myNode = resNodeList.item(i);
				String value = myNode.getNodeValue();
				//PapillonLogger.writeDebugMsg("Index entry, node " + myNode.getNodeName() + " /value: " + value);
				if (value != null) {
					value = value.trim();
					if (!value.equals("")) {
						//PapillonLogger.writeDebugMsg("Index entry, node value: " + value);
						resultData.add(new IndexData(theElement, theLang, value, theHandle));
					}
				}
			}
		} else {
			//PapillonLogger.writeDebugMsg("Index entry, node list null for CdmElement: " + theElement + ":");
		}
		return resultData;
	}

	public static ArrayList indexEntryLinks(java.util.Hashtable CdmElementsTable, Volume theVolume, org.w3c.dom.Element myRootElt, org.apache.xml.utils.PrefixResolver myPrefixResolver, String handle)
	throws PapillonBusinessException {
		ArrayList linksArray = new ArrayList();

		for (java.util.Enumeration langKeys = CdmElementsTable.keys(); langKeys.hasMoreElements();) {
			String lang = (String) langKeys.nextElement();
			java.util.Hashtable linksTable = new java.util.Hashtable();
			
			java.util.Hashtable tmpTable = (java.util.Hashtable) CdmElementsTable.get(lang);
			for (java.util.Enumeration keys = tmpTable.keys(); keys.hasMoreElements();) {
				String CdmElement = (String) keys.nextElement();
				
				//PapillonLogger.writeDebugMsg("Index entry, key " + CdmElement + ":");
				java.util.Vector myVector = (java.util.Vector) tmpTable.get(CdmElement);
				org.apache.xpath.XPath myXPath = null;
				boolean isIndex = false;
				if (myVector != null) {
					isIndex = ((Boolean) myVector.elementAt(1)).booleanValue();
					if (isIndex && isLink(CdmElement)) {
						myXPath = (org.apache.xpath.XPath) myVector.elementAt(2);
						
						//PapillonLogger.writeDebugMsg("Index entry: lang: "+ lang +" /key: " + CdmElement + " /xpath: " + (String) myVector.elementAt(0));
						java.util.StringTokenizer myTokens = new java.util.StringTokenizer(CdmElement,VolumesFactory.LINK_NAME_SEPARATOR);
						myTokens.nextToken();
						String linkName = myTokens.nextToken();
						java.util.Hashtable linkTable = (java.util.Hashtable) linksTable.get(linkName);
						if (linkTable ==null) {
							linkTable = new java.util.Hashtable();
							linksTable.put(linkName, linkTable);
						}
						String type = ELEMENT_TYPE;
						if (myTokens.hasMoreTokens()) {
							type = myTokens.nextToken();
						}
						linkTable.put(type,myXPath);
					}
				}
			}
			linksArray.addAll(indexLinks(linksTable, theVolume, lang, handle, myRootElt, myPrefixResolver));
		}
        return linksArray;
    }
	
	
	protected static ArrayList indexLinks (java.util.Hashtable linksTable, Volume theVolume,
										   String theLang, String theHandle,
										   org.w3c.dom.Element theRootElement,
										   org.apache.xml.utils.PrefixResolver thePrefixResolver) 
	throws PapillonBusinessException {
		ArrayList linksArray = new ArrayList();
		String linkDbtableName = theVolume.getLinkDbname();
		for (java.util.Enumeration linksKeys = linksTable.keys(); linksKeys.hasMoreElements();) {
			String linkName = (String) linksKeys.nextElement();
			java.util.Hashtable linkTable = (java.util.Hashtable) linksTable.get(linkName);
			org.apache.xpath.XPath linkElementXPath = (org.apache.xpath.XPath) linkTable.get(ELEMENT_TYPE);
			linkTable.remove(ELEMENT_TYPE);
			org.w3c.dom.NodeList resNodeList = null;
			try {
				org.apache.xpath.objects.XObject myXObject = linkElementXPath.execute(
																			  new org.apache.xpath.XPathContext(), theRootElement, thePrefixResolver);
				resNodeList = myXObject.nodelist();
				//PapillonLogger.writeDebugMsg("Index entry link, xPath.execute res: ");
			} catch (javax.xml.transform.TransformerException e) {
				throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
			}
			if (resNodeList != null) {
				for (int i = 0; i < resNodeList.getLength(); i++) {
					org.w3c.dom.Node myNode = resNodeList.item(i);
					Link myLink = LinkFactory.newLink(linkDbtableName, linkName, theLang, theHandle);
					
					for (java.util.Enumeration linkKeys = linkTable.keys(); linkKeys.hasMoreElements();) {
						String linkType = (String) linkKeys.nextElement();
						org.apache.xpath.XPath linkXPath = (org.apache.xpath.XPath) linkTable.get(linkType);
						org.w3c.dom.NodeList linkNodeList = null;
						try {
							org.apache.xpath.objects.XObject myXObject = linkXPath.execute(
																						  new org.apache.xpath.XPathContext(), myNode, thePrefixResolver);
							linkNodeList = myXObject.nodelist();
							//PapillonLogger.writeDebugMsg("Index entry, xPath.execute res: ");
						} catch (javax.xml.transform.TransformerException e) {
							throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
						}
						if (linkNodeList != null && linkNodeList.getLength()>0) {
							org.w3c.dom.Node typeNode = linkNodeList.item(0);
							String value = typeNode.getNodeValue();
							//PapillonLogger.writeDebugMsg("Index entry link, node " + typeNode.getNodeName() + " /value: " + value);
							if (value != null) {
								value = value.trim();
								if (!value.equals("")) {
									//PapillonLogger.writeDebugMsg("Index entry link, node value: " + value);
									if (linkType.equals(Volume.CDM_linkWeight)) {
										myLink.setWeight(value);
									}
									if (linkType.equals(Volume.CDM_linkValue)) {
										myLink.setTargetId(value);
									}									
									if (linkType.equals(Volume.CDM_linkVolume)) {
										myLink.setVolumeTarget(value);
									}									
									if (linkType.equals(Volume.CDM_linkLang)) {
										myLink.setLang(value);
									}									
								}
							}
						}
					}
					if (myLink.getVolumeTarget() == null || myLink.getVolumeTarget().equals("")) {
						String targetVolumeName = theVolume.getDefaultTargetVolumeName(theLang);
						myLink.setVolumeTarget(targetVolumeName);
					}						
					
					linksArray.add(myLink);
				}
			} else {
				//PapillonLogger.writeDebugMsg("Index entry link, node list null for CdmElement: " + linkName + ":");
			}
		}
		return linksArray;
	}
    
    /*
     *decide that the recode should be putted into links table or into index table by CdmElement
     * */
    public static boolean chooseTable(String CdmElement){
    	ArrayList cdmList = new ArrayList(); 
    	if(Volume.linkElements.length>0){
    		for (int i = 0; i<Volume.linkElements.length; i++){
    			cdmList.add(Volume.linkElements[i]);
    		}
    	}
//    	cdmList.add("cdm-translation-ref");
//    	cdmList.add("cdm-links-weight");
    	
    	boolean tableIsLinks = cdmList.contains(CdmElement);   	
    	return tableIsLinks;
    }

    public static org.w3c.dom.NodeList getCdmElements(IAnswer myEntry, String CdmElement)
            throws PapillonBusinessException {
        return getCdmElements(myEntry, CdmElement, Volume.DEFAULT_LANG);
    }

    /**
     * Gets a CDM element of the VolumeEntry
     *
     * @param CdmElement the name of the CDM element as a String.
     * @param lang       the language of the CDM element as a ISO 639-2/T 3 letters String.
     * @return the CDM volume as a String.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public static org.w3c.dom.NodeList getCdmElements(IAnswer myEntry, String CdmElement, String lang)
            throws PapillonBusinessException {
//////////
//    	PapillonLogger.writeDebugMsg("myEntry = "+myEntry+", CdmElement ="+CdmElement+" , lang = "+lang);  
        return getCdmElements(myEntry.getDom(), CdmElement, lang, myEntry.getVolume().getCdmElements());
    }

    public static org.w3c.dom.NodeList getCdmElements(org.w3c.dom.Document myEntryDOM, String CdmElement, String lang,
                                                      java.util.Hashtable CdmElementsTable)
            throws PapillonBusinessException {
        org.w3c.dom.NodeList resNodeList = null;
        // fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: " + CdmElement + " " + lang);
        if (lang != null && !lang.equals("") && CdmElementsTable != null) {
            org.w3c.dom.Element rootElt = myEntryDOM.getDocumentElement();
            org.apache.xml.utils.PrefixResolver tmpPrefixResolver = new org.apache.xml.utils.PrefixResolverDefault(
                    rootElt);
            java.util.Hashtable tmpTable = (java.util.Hashtable) CdmElementsTable.get(lang);
            if (tmpTable != null) {
                java.util.Vector myVector = (java.util.Vector) tmpTable.get(CdmElement);
                org.apache.xpath.XPath myXPath = null;
                if (myVector != null && myVector.size() == 3) {
                    myXPath = (org.apache.xpath.XPath) myVector.elementAt(2);
                    if (myXPath != null && myEntryDOM != null) {
                        try {
							//PapillonLogger.writeDebugMsg("executexPath: 0" + myVector.elementAt(0) + " 1"+ myVector.elementAt(1));
                            org.apache.xpath.objects.XObject myXObject = myXPath.execute(
                                    new org.apache.xpath.XPathContext(), myEntryDOM.getDocumentElement(),
                                    tmpPrefixResolver);
                            resNodeList = myXObject.nodelist();
                        } catch (javax.xml.transform.TransformerException e) {
                            throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
                        }
                    } else {
                        //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: myXPath: null for XPathString: " + (String) myVector.elementAt(0));
                    }
                } else {
                    //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: Vector: null for CdmElement: " + CdmElement + " lang: " + lang);
                }
            } else {
                //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: " + CdmElement + " tmpTable == null for lang: " + lang);
            }
        } else {
            //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: " + CdmElement + " CdmElementsTable == null");
        }
        return resNodeList;
    }

    public static org.w3c.dom.Node getCdmElement(IAnswer myEntry, String CdmElement)
            throws PapillonBusinessException {
        return getCdmElement(myEntry, CdmElement, Volume.DEFAULT_LANG);
    }

    public static org.w3c.dom.Node getCdmElement(IAnswer myEntry, String CdmElement, String lang)
            throws PapillonBusinessException {
        org.w3c.dom.Node resNode = null;
        org.w3c.dom.NodeList myList = getCdmElements(myEntry, CdmElement, lang);
        if (myList != null && myList.getLength() > 0) {
            resNode = myList.item(0);
        }
        return resNode;
    }

    public static String getCdmString(IAnswer myEntry, String CdmElement)
            throws PapillonBusinessException {
        return getCdmString(myEntry, CdmElement, Volume.DEFAULT_LANG);
    }

    public static String getCdmString(IAnswer myEntry, String CdmElement, String lang)
            throws PapillonBusinessException {
        String resString = "";
        org.w3c.dom.Node myNode = getCdmElement(myEntry, CdmElement, lang);
        if (myNode != null) {
            resString = myNode.getNodeValue();
        }
		//PapillonLogger.writeDebugMsg("getCdmString: " + CdmElement + " "+ lang + "" + resString);
        return resString;
    }

    public static String[] getCdmStrings(IAnswer myEntry, String CdmElement)
            throws PapillonBusinessException {
        return getCdmStrings(myEntry, CdmElement, Volume.DEFAULT_LANG);
    }

    public static String[] getCdmStrings(IAnswer myEntry, String CdmElement, String lang)
            throws PapillonBusinessException {
        String[] ResStrings = null;
        org.w3c.dom.Node resNode = null;
        org.w3c.dom.NodeList myList = getCdmElements(myEntry, CdmElement, lang);
        if (myList != null && myList.getLength() > 0) {
            ResStrings = new String[myList.getLength()];
            for (int i = 0; i < myList.getLength(); i++) {
                org.w3c.dom.Node tmpNode = myList.item(i);
                if (tmpNode != null) {
                    ResStrings[i] = tmpNode.getNodeValue();
                } else {
                    ResStrings[i] = null;
                }
            }
        }
        return ResStrings;
    }

    public static void setCdmElement(IAnswer myEntry, String CdmElement, String value)
            throws PapillonBusinessException {
        setCdmElement(myEntry, CdmElement, value, Volume.DEFAULT_LANG);
    }

    public static void setCdmElement(IAnswer myEntry, String CdmElement, String value, String lang)
            throws PapillonBusinessException {
        //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("setCdmElement: " + CdmElement + " value: " + value);
        org.w3c.dom.Node eltNode = getCdmElement(myEntry, CdmElement, lang);
        if (eltNode != null) {
            org.w3c.dom.Node textNode = eltNode.getOwnerDocument().createTextNode(value);
            if (eltNode.hasChildNodes()) {
                org.w3c.dom.NodeList childNodes = eltNode.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    eltNode.removeChild(childNodes.item(i));
                }
            }
            eltNode.appendChild(textNode);
        }
    }

    public static void initCdmElement(IAnswer myEntry, String CdmElement)
            throws PapillonBusinessException {
        initCdmElement(myEntry, CdmElement, Volume.DEFAULT_LANG);
    }

    public static void initCdmElement(IAnswer myEntry, String CdmElement, String lang)
            throws PapillonBusinessException {
        org.w3c.dom.NodeList myList = getCdmElements(myEntry, CdmElement, lang);
        if (myList != null && myList.getLength() > 0) {
            org.w3c.dom.Node currentEltNode = (org.w3c.dom.Node) myList.item(0);
            org.w3c.dom.Node parentNode = currentEltNode.getParentNode();
            if (currentEltNode.hasChildNodes()) {
                org.w3c.dom.NodeList childNodes = currentEltNode.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    currentEltNode.removeChild(childNodes.item(i));
                }
            }
            for (int i = 0; i < myList.getLength(); i++) {
                parentNode.removeChild(myList.item(i));
            }
            parentNode.appendChild(currentEltNode);
        }
    }

    public static void addCdmElement(IAnswer myEntry, String CdmElement, String value)
            throws PapillonBusinessException {
        addCdmElement(myEntry, CdmElement, value, Volume.DEFAULT_LANG);
    }

    public static void addCdmElement(IAnswer myEntry, String CdmElement, String value, String lang)
            throws PapillonBusinessException {
        //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("addCdmElement: " + CdmElement + " value: " + value);
        org.w3c.dom.NodeList myList = getCdmElements(myEntry, CdmElement, lang);
        if (myList != null && myList.getLength() > 0) {
            org.w3c.dom.Node eltNode = (org.w3c.dom.Node) myList.item(0);
            org.w3c.dom.Node currentEltNode = (org.w3c.dom.Node) eltNode.cloneNode(true);
            org.w3c.dom.Node textNode = currentEltNode.getOwnerDocument().createTextNode(value);
            if (currentEltNode.hasChildNodes()) {
                org.w3c.dom.NodeList childNodes = currentEltNode.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    currentEltNode.removeChild(childNodes.item(i));
                }
            }
            currentEltNode.appendChild(textNode);
            eltNode.getParentNode().appendChild(currentEltNode);
        }
    }

}
