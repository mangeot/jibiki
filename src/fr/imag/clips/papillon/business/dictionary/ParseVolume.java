/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.29  2006/02/22 19:05:56  mangeot
 * MM: Added default status choice when importing entries
 *
 * Revision 1.28  2006/02/09 10:49:28  mangeot
 * Added 3 new options when importing entries:
 * - ParseVolume.ReplaceExistingEntry_CopyAnyway
 * - ParseVolume.ReplaceExistingEntry_CopyIfSameStatus
 * - ParseVolume.ReplaceExistingEntry_CopyIfFinished
 * Creates a new entry id before importing the entry in the database
 * And added a log for the ParseVolume.MAX_DISCARDED_ENTRIES_LOGGED = 500
 * first entries that are discarded (not imported)
 *
 * Revision 1.27  2006/01/25 14:05:21  mangeot
 * MM: I modified the import of entries
 * Now, I check if an existing entry with the same id already exists in the database.
 * If yes, the user has to choose with several strategies:
 * - ParseVolume.ReplaceExistingEntry_Ignore
 * 	Do not import the new entry if there is already one in the
 * 	DB with the same entry
 * - ParseVolume.ReplaceExistingEntry_ReplaceAnyway
 * 	Replace the existing entry by the new one
 * - ParseVolume.ReplaceExistingEntry_ReplaceIfSameStatus
 * 	Replace the existing entry by the new one if their status is the same
 * - ParseVolume.ReplaceExistingEntry_ReplaceIfFinished
 * 	Replace the existing entry by the new one if the status of the
 * 	existing entry is 'not_finished' and the one of the new entry is
 * 	'finished'
 *
 * Revision 1.26  2005/12/04 15:22:39  mangeot
 * Fixed the volume parsing when the volume element is not the root element
 *
 * Revision 1.25  2005/12/01 16:13:42  mangeot
 * *** empty log message ***
 *
 * Revision 1.24  2005/11/16 14:36:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.23  2005/11/14 21:52:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.22  2005/11/14 21:46:25  mangeot
 * *** empty log message ***
 *
 * Revision 1.21  2005/11/10 17:31:21  mangeot
 * *** empty log message ***
 *
 * Revision 1.20  2005/11/10 17:25:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.19  2005/11/10 17:17:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.18  2005/11/10 17:08:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.17  2005/11/10 14:59:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.16  2005/11/10 13:35:09  mangeot
 * *** empty log message ***
 *
 * Revision 1.15  2005/11/10 13:12:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.14  2005/11/09 17:38:59  mangeot
 * small bug fixes
 *
 * Revision 1.13  2005/09/17 11:32:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.12  2005/09/17 11:15:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.11  2005/07/16 16:25:26  mangeot
 * Adapted the linker to the GDEF project + bug fixes
 *
 * Revision 1.10  2005/06/24 10:35:57  mangeot
 * Minor bug fixes
 *
 * Revision 1.9  2005/06/23 09:48:17  mangeot
 * Bug fix in xpath completion and creation-date cdm element
 *
 * Revision 1.8  2005/06/22 15:55:53  mangeot
 * Solved an unresolved prefix bug when the dml prefix was not in the template entry.
 * Now we use the DmlPrefixResolver to solve this issue.
 *
 * Revision 1.7  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 *-----------------------------------------------
 *
 * Created by Mathieu MANGEOT on Mon Sep 29 2003.
 *  Copyright (c) 2003-2005 mangeot & serasset CLIPS. All rights reserved.
 */

package fr.imag.clips.papillon.business.dictionary;

// internal imports
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.utility.Utility;

import java.util.Vector;
import java.util.Hashtable;

public class ParseVolume {
	
	// constants
	// public constants for import
	public static final int ReplaceExistingEntry_Ignore = 0;
	public static final int ReplaceExistingEntry_ReplaceAnyway = 1;
	public static final int ReplaceExistingEntry_ReplaceIfSameStatus = 2;
	public static final int ReplaceExistingEntry_ReplaceIfFinished = 3;
	public static final int ReplaceExistingEntry_CopyAnyway = 4;
	public static final int ReplaceExistingEntry_CopyIfSameStatus = 5;
	public static final int ReplaceExistingEntry_CopyIfFinished = 6;
	
	public static final int MAX_DISCARDED_ENTRIES_LOGGED = 500;

	// constants for Foks
	protected static final int FOKS_TOKENS = 4;
	protected static final String FOKS_DELIMITER = "\t";
	protected static final String FOKS_ENCODING = "EUC-JP";
	protected static final String FOKSEDICT_VOLUME = "FoksEdict_jpn";
	
	// constants
	protected static final String ENCODING = "encoding";
	protected static final String DEFAULT_ENCODING = "UTF-8";
	protected static final String XMLHEADER = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>";
	protected static final String XMLDECLSTART = "<?xml ";
	protected static final int MAX_TRY = 5;

	
	public static int parseFoksVolume (String url) throws PapillonBusinessException {
		return parseFoksVolume(url, FOKS_ENCODING, FOKS_DELIMITER,FOKS_TOKENS);
	}
	
	protected static int parseFoksVolume (String urlString, String encoding, String delimiter, int tokensNb) 
		throws PapillonBusinessException {
			int entry = 0;
			try {
				java.net.URL url = new java.net.URL(urlString);
				java.net.URLConnection connection = url.openConnection();
				
				java.io.InputStreamReader inReader = new java.io.InputStreamReader(connection.getInputStream(), encoding);
				java.io.BufferedReader buffer = new java.io.BufferedReader(inReader);
				String str = "";
				while (buffer.ready()) {
					str = buffer.readLine();
					java.util.StringTokenizer myTokenizer = new java.util.StringTokenizer(str,delimiter);
					if (myTokenizer.countTokens() == tokensNb) {
						FoksEntry myEntry = new FoksEntry(myTokenizer.nextToken(),
														  myTokenizer.nextToken(),
														  myTokenizer.nextToken(),
														  myTokenizer.nextToken());
						if (myEntry != null && !myEntry.isEmpty()) {
							myEntry.save();
							entry++;
						}
						if ((entry % 1000) == 0) {
							PapillonLogger.writeDebugMsg("Foks Volume: " + entry + " entries parsed");
						}
					}
                }
                buffer.close();
                PapillonLogger.writeDebugMsg("Foks Volume Parsed, " + entry + " entries added!");
			} catch (java.io.FileNotFoundException exp) {
				throw new PapillonBusinessException("ParseVolume.parseFoksVolume, error FileNotFoundException: " + urlString);
				
			} catch (java.io.IOException exp) {
				throw new PapillonBusinessException("ParseVolume.parseFoksVolume, error IOException");
			}
			return entry;
		}
	
	public static String parseVolume (String volumeName, String URL, String defaultStatus, int replaceExisting, boolean logContribs)
        throws PapillonBusinessException {
			String message = "";
			Volume volume = VolumesFactory.findVolumeByName(volumeName);
			Dictionary dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            if (!volume.isEmpty()) {
                message = parseVolume(dict, volume,URL, defaultStatus, replaceExisting, logContribs);
            }
			else {
				message = "The volume does not exist!";
			}
			return message;
        }
	
	protected static String parseVolume (Dictionary myDict, Volume myVolume, String url, boolean logContribs) throws PapillonBusinessException {
		String xmlHeader = getXMLHeader(url, myVolume.getCdmEntry());
		String encoding = getEncoding(xmlHeader);
		return parseEntries(myDict, myVolume, url, encoding, VolumeEntry.FINISHED_STATUS, ReplaceExistingEntry_Ignore, logContribs);
	}
	
	protected static String parseVolume (Dictionary myDict, Volume myVolume, String url, String defaultStatus, int replaceExisting, boolean logContribs) throws PapillonBusinessException {
		String xmlHeader = getXMLHeader(url, myVolume.getCdmEntry());
		String encoding = getEncoding(xmlHeader);
		return parseEntries(myDict, myVolume, url, encoding, defaultStatus, replaceExisting, logContribs);
	}
	
	protected static String getXMLHeader(String url, String CDM_entry) throws PapillonBusinessException {
		String res = XMLHEADER;
		try {
			java.net.URL myUrl = new java.net.URL(url);
			java.io.InputStream inStream = myUrl.openStream();
			// throws FileNotFoundException
			java.io.InputStreamReader inReader = new java.io.InputStreamReader(inStream, DEFAULT_ENCODING);
			// throws UnsupportedEncodingException
			java.io.BufferedReader buffer = new java.io.BufferedReader(inReader);
			String str = "";
			String header = "";
			int countTry = 0;
			while (buffer.ready() && (countTry <=MAX_TRY)) {
				str = buffer.readLine();
				countTry++;
				if (str.indexOf(XMLDECLSTART)>=0) {
					res = str;
					break;
				}
				if ((str.indexOf("<" + CDM_entry + " ")>=0) ||
					(str.indexOf("<" + CDM_entry + "\t")>=0) ||
					(str.indexOf("<" + CDM_entry + "\n")>=0) ||
					(str.indexOf("<" + CDM_entry + ">")>=0)){
					break;
				}
			}
			inStream.close();
		} catch (java.io.IOException exp) {
			throw new PapillonBusinessException("ParseVolume.getXMLHeader, error IOException URL: " + url, exp);
		}
		return res;
	}
	
	protected static String getEncoding(String XMLHeader) {
		String res = DEFAULT_ENCODING;
		int start = XMLHeader.indexOf(ENCODING);
		if (start>0) {
			// looking for the string encoding
			String tmpString = XMLHeader.substring(start+ENCODING.length());
			tmpString = tmpString.trim();
			// looking for the '='
			start = tmpString.indexOf('=');
			if (start>=0) {
				tmpString = tmpString.substring(start+1);
				tmpString = tmpString.trim();
				// cut the quotes
				if (tmpString.length()>2) {
					String quote = tmpString.substring(0,1);
					tmpString =  tmpString.substring(1);
					int end = tmpString.indexOf(quote);
					if (end>0) {
						res = tmpString.substring(0,end);
					}
				}
			}
		}
		return res;
	}
	
	protected static String parseEntries(Dictionary myDict, Volume myVolume, String url, String encoding, String defaultStatus, int replaceExisting, boolean logContribs) throws PapillonBusinessException {
		PapillonLogger.writeDebugMsg("parseEntries, encoding: [" + encoding + "]");
		int countEntries = 0;
		String message = "";
		java.util.Vector DiscardedEntries = new Vector();
		try {
			java.net.URL myUrl = new java.net.URL(url);
			java.io.InputStream inStream = myUrl.openStream();
			java.io.InputStreamReader inReader = new java.io.InputStreamReader(inStream, encoding);
			// throws UnsupportedEncodingException
			java.io.BufferedReader buffer = new java.io.BufferedReader(inReader);
			StringBuffer xmlHeaderBuffer = new StringBuffer();
			String CDM_Volume = myVolume.getCdmVolume();
			// FIXME upload des dicos sans contribs à prévoir ...
			String CDM_Entry = myVolume.getCdmEntry();
			String CDM_Contribution =  myVolume.getCdmContribution();
			boolean isContributionVolume = false;
			
			PapillonLogger.writeDebugMsg("parseEntries, logContribs: [" + logContribs + "]");
			PapillonLogger.writeDebugMsg("parseEntries, CDM_Volume: [" + CDM_Volume + "]");
			PapillonLogger.writeDebugMsg("parseEntries, CDM_Entry: [" + CDM_Entry + "]");
			String bufferLine = "";
			int firstEntryIndex = -1;
			while (buffer.ready() && firstEntryIndex <0) {
				bufferLine = buffer.readLine();
				firstEntryIndex = bufferLine.indexOf("<" + CDM_Entry + " ");
				if (firstEntryIndex < 0) {
					firstEntryIndex = bufferLine.indexOf("<" + CDM_Entry + "\t");
				}
				if (firstEntryIndex < 0) {
					firstEntryIndex = bufferLine.indexOf("<" + CDM_Entry + ">");
				}
				if (firstEntryIndex < 0) {
					firstEntryIndex = bufferLine.indexOf("<" + CDM_Contribution);
					isContributionVolume = (firstEntryIndex >=0);
				}
				if (firstEntryIndex >=0) {
					if (firstEntryIndex>0) {
						xmlHeaderBuffer.append(bufferLine.substring(0,firstEntryIndex));
						xmlHeaderBuffer.append("\n");
						bufferLine = bufferLine.substring(firstEntryIndex);
					}
				}
				else {
					xmlHeaderBuffer.append(bufferLine);
					xmlHeaderBuffer.append("\n");
				}
			}
			StringBuffer xmlFooterBuffer= new StringBuffer();
			if (isContributionVolume) {
				CDM_Entry = CDM_Contribution;
			}
			else {
				xmlHeaderBuffer.append(VolumeEntry.ContributionHeader);
				xmlFooterBuffer.append(VolumeEntry.ContributionFooter);
			}
			xmlFooterBuffer.append(myVolume.getXmlFooter());
			StringBuffer entryBuffer = new StringBuffer();
			entryBuffer.append(xmlHeaderBuffer);
			while (buffer.ready() && bufferLine.indexOf("</" + CDM_Volume + ">")<0) {
				int entryIndex = bufferLine.indexOf("<" + CDM_Entry);
				while (entryIndex>=0) {
					if (entryIndex>0) {
						entryBuffer.append(bufferLine.substring(0,entryIndex));
						entryBuffer.append("\n");
						bufferLine = bufferLine.substring(entryIndex);
					}
					if (entryBuffer.length()>xmlHeaderBuffer.length()) {
						if (parseEntry(myDict,myVolume,entryBuffer.append(xmlFooterBuffer), defaultStatus, replaceExisting, logContribs, DiscardedEntries)) {
							countEntries++;
						}
						entryBuffer = new StringBuffer();
						entryBuffer.append(xmlHeaderBuffer);
					}
					entryIndex = bufferLine.indexOf("<" + CDM_Entry,entryIndex+CDM_Entry.length()+1);
				}
				entryBuffer.append(bufferLine);
				entryBuffer.append("\n");
				bufferLine = buffer.readLine();
			}
			buffer.close();
			inStream.close();
			if (parseEntry(myDict,myVolume,entryBuffer.append(xmlFooterBuffer), defaultStatus, replaceExisting, logContribs, DiscardedEntries)) {
				countEntries++;
			}
			message = "volume parsed, " + countEntries + " entries added.";
			PapillonLogger.writeDebugMsg(message);
			message += " Entries discarded: ";
			for (java.util.Iterator iter = DiscardedEntries.iterator(); iter.hasNext();) {
               message +=  (String) iter.next() + ", ";
			} 
		}
		catch (java.io.FileNotFoundException exp) {
			throw new PapillonBusinessException("FileNotFoundException: " + myVolume.getVolumeRef(), exp);
			
		} catch (java.io.IOException exp) {
			throw new PapillonBusinessException("ParseVolume.parseFoksVolume, error IOException", exp);
		}
		return message;
	}
	
	protected static boolean parseEntry(Dictionary myDict, Volume myVolume, StringBuffer entryBuffer, String defaultStatus, int replaceExisting, boolean logContribs, java.util.Vector DiscardedEntries) throws PapillonBusinessException {
		return parseEntry(myDict, myVolume, entryBuffer.toString(), defaultStatus, replaceExisting, logContribs, DiscardedEntries);
	}
	
	protected static boolean parseEntry(Dictionary myDict, Volume myVolume, String entryString, String defaultStatus, int replaceExisting, boolean logContribs, java.util.Vector DiscardedEntries) throws PapillonBusinessException {
		boolean result=false;
			// PapillonLogger.writeDebugMsg("Parse entry [" + entryString + "]");
		org.w3c.dom.Document myDoc = Utility.buildDOMTree(entryString);
		if (myDoc!=null) {
			VolumeEntry newEntry = new VolumeEntry(myDict, myVolume);
			// newEntry.setXmlCode(entryString) is called by myEntry.save();
			newEntry.setDom(myDoc);
			newEntry.setAuthor();
			newEntry.setCreationDate();
			newEntry.setHeadword();
			newEntry.setStatusIfNotNull(defaultStatus);
			// parseEntry(newEntry) is called by myEntry.save();
			String entryId = newEntry.getEntryId();
			if (entryId != null) {
				VolumeEntry existingEntry = VolumeEntriesFactory.findEntryByEntryId(myDict, myVolume, entryId);
				if (existingEntry != null && !existingEntry.isEmpty()) {
					switch (replaceExisting) {
						case ReplaceExistingEntry_Ignore:
							break;
						case ReplaceExistingEntry_ReplaceAnyway:
							existingEntry.delete();
							result = newEntry.save();
							break;
						case ReplaceExistingEntry_ReplaceIfSameStatus:
							if (newEntry.getStatus().equals(existingEntry.getStatus())) {
								existingEntry.delete();
								result = newEntry.save();
							}
							break;
						case ReplaceExistingEntry_ReplaceIfFinished:
							if (existingEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) &&
								newEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS)) {
								existingEntry.delete();
								result = newEntry.save();
							}
							break;
						case ReplaceExistingEntry_CopyAnyway:
							newEntry.setEntryId();
							result = newEntry.save();
							break;
						case ReplaceExistingEntry_CopyIfSameStatus:
							if (newEntry.getStatus().equals(existingEntry.getStatus())) {
								newEntry.setEntryId();
								result = newEntry.save();
							}
							break;
						case ReplaceExistingEntry_CopyIfFinished:
							if (existingEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) &&
								newEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS)) {
								newEntry.setEntryId();
								result = newEntry.save();
							}
							break;
						default:
							break;
					}
				}
				else {
					result = newEntry.save();
				}
			}
			if (result) {
				if (logContribs) {
					ContributionsFactory.createContributionLogsFromExistingEntry(newEntry);
				}
				PapillonLogger.writeDebugMsg("Adding entry " + newEntry.getHeadword() + " // " + newEntry.getId());
			}
			else {
				PapillonLogger.writeDebugMsg("Discarding entry " + newEntry.getHeadword() + " // " + newEntry.getId());
				if (DiscardedEntries.size()<MAX_DISCARDED_ENTRIES_LOGGED) {
					DiscardedEntries.add(entryId);
				}
			}			
		}
		else {
			PapillonLogger.writeDebugMsg("Entry not valid: " + entryString);
		}
		return result;
	}
	
	public static boolean parseEntry(VolumeEntry myEntry) throws PapillonBusinessException {
		org.w3c.dom.Document entryDoc = myEntry.getDom();
		boolean result=false;
		if (entryDoc!=null) {
			org.w3c.dom.Element myRootElt = entryDoc.getDocumentElement();
			org.apache.xml.utils.PrefixResolver myPrefixResolver = new org.apache.xml.utils.PrefixResolverDefault(myRootElt);
			java.util.Hashtable CdmElementsTable = myEntry.getVolume().getCdmElements();
			result = true;
			for (java.util.Enumeration langKeys = CdmElementsTable.keys(); langKeys.hasMoreElements();) {
				String lang = (String) langKeys.nextElement();
				java.util.Hashtable tmpTable =  (java.util.Hashtable) CdmElementsTable.get(lang);
				for (java.util.Enumeration keys = tmpTable.keys(); keys.hasMoreElements();) {
					String CdmElement = (String) keys.nextElement();
					// PapillonLogger.writeDebugMsg("Parse entry, key " + CdmElement + ":");
					java.util.Vector myVector = (java.util.Vector) tmpTable.get(CdmElement);
					org.apache.xpath.XPath myXPath = null;
					boolean isIndex = false;
					if (myVector != null) {
						if (myVector.size()==3) {
							isIndex = ((Boolean) myVector.elementAt(1)).booleanValue();
							if (isIndex) {
								myXPath =  (org.apache.xpath.XPath) myVector.elementAt(2);
							}
						}
						else if (myVector.size()==2) {
							isIndex = ((Boolean) myVector.elementAt(1)).booleanValue();
							if (isIndex) {
								String xpathString = (String) myVector.elementAt(0);
								myXPath = ParseVolume.compileXPath(xpathString, myRootElt);
								myVector.add(myXPath);
							}
						}
						//PapillonLogger.writeDebugMsg("Parse entry, key " + CdmElement + " /xpath: " + (String) myVector.elementAt(0));
					}
					if (myXPath != null) {
						org.w3c.dom.NodeList resNodeList = null;
						try {
							org.apache.xpath.objects.XObject myXObject = myXPath.execute(new org.apache.xpath.XPathContext(),myRootElt,myPrefixResolver);
							resNodeList = myXObject.nodelist();
						}
						catch (javax.xml.transform.TransformerException e) {
							throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
						}
						if (resNodeList !=null) { 
							for (int i=0; i<resNodeList.getLength();i++) {
								org.w3c.dom.Node myNode = resNodeList.item(i);
								String value = myNode.getNodeValue();
								//PapillonLogger.writeDebugMsg("Parse entry, node " + myNode.getNodeName() + " /value: " + value);
								if (value != null) { 
									value = value.trim();
									if (!value.equals("")) {
											//PapillonLogger.writeDebugMsg("Parse entry, node value: " + value);
										Index myIndex = IndexFactory.newIndex(myEntry.getVolume().getIndexDbname(),CdmElement,lang,value, myEntry.getHandle());
										if (myIndex != null && !myIndex.isEmpty()) {
											myIndex.save();
										}
									}
								}
							}
						}
						else {
							// PapillonLogger.writeDebugMsg("Parse entry, node list null for CdmElement: " + CdmElement + ":");
						}
					}
				}
			}
		}
		return result;
	}
	
	public static boolean parseAxie(Axie myEntry) throws PapillonBusinessException {
		org.w3c.dom.Document entryDoc = myEntry.getDom();
		boolean result=false;
		if (entryDoc!=null) {
			java.util.Hashtable LexiesHashtable = new java.util.Hashtable();
			java.util.Vector SynonymsVector = new java.util.Vector();			
			org.w3c.dom.Element myRootElt = entryDoc.getDocumentElement();
			org.apache.xml.utils.PrefixResolver myPrefixResolver = new org.apache.xml.utils.PrefixResolverDefault(myRootElt);
			java.util.Hashtable CdmElementsTable = myEntry.getVolume().getCdmElements();
			result = true;
			for (java.util.Enumeration langKeys = CdmElementsTable.keys(); langKeys.hasMoreElements();) {
				String lang = (String) langKeys.nextElement();
				java.util.Hashtable tmpTable =  (java.util.Hashtable) CdmElementsTable.get(lang);
				for (java.util.Enumeration keys = tmpTable.keys(); keys.hasMoreElements();) {
					String CdmElement = (String) keys.nextElement();
					//	PapillonLogger.writeDebugMsg("Parse entry, key " + CDM_element + ":");
					java.util.Vector myVector = (java.util.Vector) tmpTable.get(CdmElement);
					org.apache.xpath.XPath myXPath = null;
					boolean isIndex = false;
					if (myVector != null) {
						if (myVector.size()==3) {
							isIndex = ((Boolean) myVector.elementAt(1)).booleanValue();
							if (isIndex) {
								myXPath =  (org.apache.xpath.XPath) myVector.elementAt(2);
							}
						}
						else if (myVector.size()==2) {
							isIndex = ((Boolean) myVector.elementAt(1)).booleanValue();
							if (isIndex) {
								String xpathString = (String) myVector.elementAt(0);
								myXPath = ParseVolume.compileXPath(xpathString, myRootElt);
								myVector.add(myXPath);
							}
						}
					}
					if (myXPath != null) {
						org.w3c.dom.NodeList resNodeList = null;
						try {
							org.apache.xpath.objects.XObject myXObject = myXPath.execute(new org.apache.xpath.XPathContext(),myRootElt,myPrefixResolver);
							resNodeList = myXObject.nodelist();
							for (int i=0; i<resNodeList.getLength();i++) {
								org.w3c.dom.Node myNode = resNodeList.item(i);
								if (CdmElement.equals(Volume.CDM_axiLanguage)) {
									java.util.Hashtable defaultTable = (java.util.Hashtable) CdmElementsTable.get(Volume.DEFAULT_LANG);
									if (defaultTable != null) {
										org.apache.xpath.XPath langXPath =  (org.apache.xpath.XPath) defaultTable.get(Volume.CDM_axiLanguageAttribute);
										org.apache.xpath.objects.XObject langXObject = langXPath.execute(new org.apache.xpath.XPathContext(),myNode,myPrefixResolver);
										org.w3c.dom.NodeList langNodeList = langXObject.nodelist();
										if (langNodeList != null && langNodeList.getLength()>0) {
											String reflexieLang = langNodeList.item(0).getNodeValue();
											java.util.Vector reflexieVector = new java.util.Vector();
											org.apache.xpath.XPath reflexieXPath =  (org.apache.xpath.XPath) defaultTable.get(Volume.CDM_axiReflexie);
											org.apache.xpath.objects.XObject reflexieXObject = reflexieXPath.execute(new org.apache.xpath.XPathContext(),myNode,myPrefixResolver);
											org.w3c.dom.NodeList reflexieNodeList = reflexieXObject.nodelist();
											for (int j=0; j<reflexieNodeList.getLength();j++) {
												String reflexie = reflexieNodeList.item(j).getNodeValue();
												reflexieVector.add(reflexie);
												Index myIndex = IndexFactory.newIndex(myEntry.getVolume().getIndexDbname(),Volume.CDM_axiReflexie,reflexieLang,reflexie, myEntry.getHandle());
												myIndex.save();
											}
											LexiesHashtable.put(reflexieLang, reflexieVector);
										}
									}
								}
								else {
									String value = myNode.getNodeValue();
									if (value != null) {
										//	PapillonLogger.writeDebugMsg("Parse entry, node value: " + value);
										if (CdmElement.equals(Volume.CDM_entryId)) {
											myEntry.setId(value);
										}
										else if (CdmElement.equals(Volume.CDM_axiSemanticCat)) {
											myEntry.setSemanticCat(value);
										}
										else if (CdmElement.equals(Volume.CDM_axiSynonyms)) {
											SynonymsVector.add(value);
										}
										Index myIndex = IndexFactory.newIndex(myEntry.getVolume().getIndexDbname(),CdmElement,lang,value, myEntry.getHandle());
										myIndex.save();
									}
								}
							}
						}
						catch (javax.xml.transform.TransformerException e) {
							throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
						}
					}
				}
			}
			myEntry.setSynonyms(SynonymsVector);
			myEntry.setLexies(LexiesHashtable);
		}
		return result;
	}
	
	public static org.apache.xpath.XPath compileXPath(String xpathString, org.w3c.dom.Element myRootElt)  throws PapillonBusinessException {
		javax.xml.transform.SourceLocator mySourceLocator = new org.apache.xml.utils.SAXSourceLocator();
		DmlPrefixResolver myPrefixResolver = new DmlPrefixResolver(myRootElt);
		org.apache.xpath.XPath myXPath = null;
		try	{
			myXPath = new org.apache.xpath.XPath(xpathString,mySourceLocator,myPrefixResolver,org.apache.xpath.XPath.SELECT);
		}
		catch (javax.xml.transform.TransformerException e) {
			throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
		}
		return myXPath;
	}
    
    public static org.apache.xpath.XPath compileXPath(String xpathString, org.apache.xml.utils.PrefixResolver aPrefixResolver)  throws PapillonBusinessException {
		javax.xml.transform.SourceLocator mySourceLocator = new org.apache.xml.utils.SAXSourceLocator();
		org.apache.xpath.XPath myXPath = null;
		try	{
			myXPath = new org.apache.xpath.XPath(xpathString,mySourceLocator,aPrefixResolver,org.apache.xpath.XPath.SELECT);
		}
		catch (javax.xml.transform.TransformerException e) {
			throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
		}
		return myXPath;
	}
	
	/* cdmElements Hashtable = {lang => Hashtable} = {CDM_element => Vector} = (xpathString, isIndex, XPath)*/
	protected static boolean compileXPathTable(java.util.Hashtable cdmElements, org.w3c.dom.Element myRootElt) throws PapillonBusinessException {
		boolean result = false;
		for (java.util.Enumeration langKeys = cdmElements.keys(); langKeys.hasMoreElements();) {
			String lang = (String) langKeys.nextElement();
			java.util.Hashtable tmpTable =  (java.util.Hashtable) cdmElements.get(lang);
			for (java.util.Enumeration keys = tmpTable.keys(); keys.hasMoreElements();) {
				String CDM_element = (String) keys.nextElement();
				java.util.Vector eltVector = (java.util.Vector) tmpTable.get(CDM_element);
				if (eltVector != null && eltVector.size()==2) {
					String xpathString =  (String) eltVector.elementAt(0);
					org.apache.xpath.XPath myXPath = compileXPath(xpathString, myRootElt);
					if (myXPath != null) {
						PapillonLogger.writeDebugMsg("compileXPathTable: CDM element: " + CDM_element + " xpath not null: " + xpathString);
						eltVector.add(myXPath);
						result = true;
					}
					else {
						PapillonLogger.writeDebugMsg("compileXPathTable: CDM element: " + CDM_element + " xpath null: " + xpathString);
					}
				}
			}
		}
		return result;
	}
	
    /**
		* Gets a CDM element of the VolumeEntry
     *
     * @param the name of the CDM element as a String.
     * @param the language of the CDM element as a ISO 639-2/T 3 letters String.
     * @return the CDM volume as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public static org.w3c.dom.NodeList getCdmElements(IAnswer myEntry, String CdmElement) 
		throws PapillonBusinessException {
			return getCdmElements(myEntry, CdmElement, Volume.DEFAULT_LANG);
		}
	
	public static org.w3c.dom.NodeList getCdmElements(IAnswer myEntry, String CdmElement, String lang) 
		throws PapillonBusinessException {
			return getCdmElements(myEntry.getDom(), CdmElement, lang, myEntry.getVolume().getCdmElements());
		}
	
	public static org.w3c.dom.NodeList getCdmElements(org.w3c.dom.Document myEntryDOM, String CdmElement, String lang, java.util.Hashtable CdmElementsTable) 
		throws PapillonBusinessException {
			org.w3c.dom.NodeList resNodeList = null;
			// fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: " + CdmElement + " " + lang);
			if (lang != null && !lang.equals("") && CdmElementsTable != null) {
				org.w3c.dom.Element rootElt = myEntryDOM.getDocumentElement();
				org.apache.xml.utils.PrefixResolver tmpPrefixResolver = new org.apache.xml.utils.PrefixResolverDefault(rootElt);
				java.util.Hashtable tmpTable = (java.util.Hashtable) CdmElementsTable.get(lang);
				if (tmpTable != null) {
					java.util.Vector myVector = (java.util.Vector) tmpTable.get(CdmElement);
					org.apache.xpath.XPath myXPath = null;
					if (myVector!= null && myVector.size()==3) {
						myXPath =  (org.apache.xpath.XPath) myVector.elementAt(2);
						if (myXPath != null && myEntryDOM != null) {
							try {
								org.apache.xpath.objects.XObject myXObject = myXPath.execute(new org.apache.xpath.XPathContext(),myEntryDOM.getDocumentElement(),tmpPrefixResolver);
								resNodeList = myXObject.nodelist();
							}
							catch (javax.xml.transform.TransformerException e) {
								throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
							}
						}
						else {
							fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: myXPath: null for XPathString: " + (String) myVector.elementAt(0));
						}
					}
					else {
						fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: Vector: null for CdmElement: " + CdmElement + " lang: " + lang);
					}
				}
				else {
					fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: " + CdmElement + " tmpTable == null for lang: " + lang);
				}
			}
			else {
				fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmElements: " + CdmElement + " CdmElementsTable == null");
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
			org.w3c.dom.NodeList myList = ParseVolume.getCdmElements(myEntry,CdmElement,lang);
			if (myList != null && myList.getLength()>0) {
				resNode = myList.item(0);
			}
			return resNode;
		}
	
	public static String getCdmString (IAnswer myEntry, String CdmElement)
		throws PapillonBusinessException {
			return getCdmString(myEntry, CdmElement, Volume.DEFAULT_LANG);
		}
	
	public static String getCdmString (IAnswer myEntry, String CdmElement, String lang)
		throws PapillonBusinessException {
			String resString = "";
			org.w3c.dom.Node myNode = ParseVolume.getCdmElement(myEntry,CdmElement,lang);
			if (myNode != null) {
				resString = myNode.getNodeValue();
			}
			return resString;
		}
	
	public static String[] getCdmStrings (IAnswer myEntry, String CdmElement)
		throws PapillonBusinessException {
			return getCdmStrings(myEntry, CdmElement, Volume.DEFAULT_LANG);
		}
	
	public static String[] getCdmStrings (IAnswer myEntry, String CdmElement, String lang)
		throws PapillonBusinessException {
			String[] ResStrings = null;
			org.w3c.dom.Node resNode = null;
			org.w3c.dom.NodeList myList = ParseVolume.getCdmElements(myEntry,CdmElement,lang);
			if (myList != null && myList.getLength()>0) {
				ResStrings = new String[myList.getLength()+1];
				for (int i=0; i<myList.getLength();i++) {
					org.w3c.dom.Node tmpNode = myList.item(i);
					if (tmpNode != null) {
						ResStrings[i] = tmpNode.getNodeValue();
					}
					else {
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
					for (int i=0; i<childNodes.getLength(); i++) {
						eltNode.removeChild(childNodes.item(i));
					}
				}
				eltNode.appendChild(textNode);
			}
		}
	
}
