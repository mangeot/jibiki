/*
 *  papillon
 *
 *  Created by Mathieu Mangeot on Thu Sep 16 2004.
 *  Copyright (c) 2002 GETA_CLIPS_IMAG. All rights reserved.
 *
 *---------------------------------------------------------
 * $Id$
 *---------------------------------------------------------
 * $Log$
 * Revision 1.5  2005/06/22 15:55:53  mangeot
 * Solved an unresolved prefix bug when the dml prefix was not in the template entry.
 * Now we use the DmlPrefixResolver to solve this issue.
 *
 * Revision 1.4  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 *
 *---------------------------------------------------------
 */

package fr.imag.clips.papillon.business.edition;

import java.util.ArrayList;
import java.util.Hashtable;

import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.business.PapillonBusinessException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class UITemplates {
	
	// constants
	protected final static String DML_URI = fr.imag.clips.papillon.business.dictionary.DmlPrefixResolver.DML_URI;
	public static final String DEFAULT_FORM = "default";
	
	protected static Hashtable defaultTypeTable = new Hashtable();
	protected static Hashtable defaultLangTable = new Hashtable();
	protected static Hashtable interfaceTable = new Hashtable();
	protected static Hashtable entryTemplateTable = new Hashtable();
	
	
	// public methods
	public static Element getInterface(String volumeName, String type, ArrayList languages) 
		throws PapillonBusinessException {
		PapillonLogger.writeDebugMsg("UITemplates.getInterface: volume: " +  volumeName + " type: " + type);
		Element initElt = null;
		Element resultElt = null;
		if (volumeName!=null && !volumeName.equals("")) {
			Hashtable typeTable = (Hashtable) interfaceTable.get(volumeName);
			if (typeTable == null) {
				Volume myVolume = fr.imag.clips.papillon.business.dictionary.VolumesFactory.findVolumeByName(volumeName);
			//	initElt = Utility.buildDOMTreeFromUrl("file:///Projects/NewUIGenerator/interface.xhtml").getDocumentElement();
				initElt = Utility.buildDOMTree(myVolume.getTemplateInterface()).getDocumentElement();
				if (initElt!=null) {
					initInterfaceTable(initElt,volumeName);
				}
			}
			typeTable = (Hashtable) interfaceTable.get(volumeName);
			if (typeTable != null) {
				String defaultType = (String) defaultTypeTable.get(volumeName);
				String defaultLang = (String) defaultLangTable.get(volumeName);
				if (typeTable!=null) {
					Hashtable langTable = (Hashtable) typeTable.get(type);
					if (langTable==null && defaultType!=null && !defaultType.equals("")) {
						langTable = (Hashtable) typeTable.get(defaultType);
					}
					if (langTable !=null) {
						int i = 0;
						while (i != languages.size() && resultElt == null) {
							resultElt = (Element) langTable.get(languages.get(i));
							i++;
						}
						if (resultElt == null && defaultLang!=null && !defaultLang.equals("")) {
							resultElt = (Element) langTable.get(defaultLang);
						}
						if (resultElt==null) {
							PapillonLogger.writeDebugMsg("No form for default lang: " + defaultLang);
						}
					}
					else {
						PapillonLogger.writeDebugMsg("No form for default type: " + defaultType);
					}
				}
				else {
					PapillonLogger.writeDebugMsg("No form for volume: " + volumeName);
				}
			}
			else {
				PapillonLogger.writeDebugMsg("UITemplates.getInterface: typeTable is null for volume: " + 
				volumeName + " itfTable: " + interfaceTable.toString());
			}
		}
		else {
			throw new PapillonBusinessException("UITemplates.getInterface: volumeName is null");
		}
		if (resultElt == null) {
			resultElt = initElt;
		}
		return resultElt;
	}
	
	public static Element getTemplateEntry(String volumeName) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Element resEntry = null;
		if (volumeName!=null) {
			resEntry = (Element) entryTemplateTable.get(volumeName);
			if (resEntry==null) {
				Volume myVolume = fr.imag.clips.papillon.business.dictionary.VolumesFactory.findVolumeByName(volumeName);
			//	resEntry = Utility.buildDOMTreeFromUrl("file:///Projects/NewUIGenerator/entry-template.xml").getDocumentElement();
				resEntry = Utility.buildDOMTree(myVolume.getTemplateEntry()).getDocumentElement();
				entryTemplateTable.put(volumeName, resEntry);
			}
		}
		else {
			PapillonLogger.writeDebugMsg("UITemplates.getTemplateEntry: volumeName is null");
		}
		return resEntry;
	}
	
	// protected methods
	protected static void initInterfaceTable(Element itfElt, String volumeName) {
		PapillonLogger.writeDebugMsg("initInterfaceTable: Element " + itfElt.toString() + " volume: " + volumeName);
		if (volumeName!=null && !volumeName.equals("")) {
			NodeList myNodeList = itfElt.getElementsByTagName("form");		
			Hashtable typeTable = new Hashtable();
			if (myNodeList.getLength()>0) {
				for (int i=0;i<myNodeList.getLength();i++) {
					Element myForm = (Element) myNodeList.item(i);
					String type = myForm.getAttribute("name");
					Hashtable langTable = (Hashtable) typeTable.get(type);
					if (langTable == null) {
						langTable = new Hashtable();
					}
					String lang = myForm.getAttributeNS(DML_URI,"lang");
                    if (null == lang || lang.equals("")) {
                        lang = "default";
                    }
					langTable.put(lang, myForm);
					typeTable.put(type,langTable);
					String defaultForm = myForm.getAttribute("id");
					if (defaultForm!=null && defaultForm.equals(DEFAULT_FORM)) {
						defaultTypeTable.put(volumeName,type);
						defaultLangTable.put(volumeName,lang);
					}	
					// PapillonLogger.writeDebugMsg("initInterfaceTableResult: " + myForm.toString() +" type " + type + " lang: " + lang);
				}
				interfaceTable.put(volumeName,typeTable);
			}
			else {
				PapillonLogger.writeDebugMsg("initInterfaceTable: no form element found");
			}
		}
		else {
			PapillonLogger.writeDebugMsg("initInterfaceTable: volumeName is null");
		}
	}
	
	public static void resetCache () {
		defaultTypeTable = new Hashtable();
		defaultLangTable = new Hashtable();
		interfaceTable = new Hashtable();
		entryTemplateTable = new Hashtable();
	}
	

}
