/*
 *  Created by Mathieu Mangeot on 28/04/05.
 *  Copyright 2005 Mangeot-Sérasset. All rights reserved.
 ------------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.1.2.2  2005/05/20 16:54:53  mangeot
 * Added ExportVolume functionnality
 *
 * Revision 1.1.2.1  2005/05/20 14:44:29  mangeot
 * *** empty log message ***
 *
 *
 *-----------------------------------------------
 */ 

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

public class ExportVolumeEntryProcessor implements IVolumeEntryProcessor {

	protected static java.io.OutputStream outStream = null;

	public ExportVolumeEntryProcessor(java.io.OutputStream newOutStream) {
		outStream = newOutStream;
	}

	public void process(VolumeEntry myEntry) throws PapillonBusinessException {
		Volume myVolume = myEntry.getVolume();
		String contribString = myVolume.getCdmContribution();
		String xmlCode = myEntry.getXmlCode();
			
		if (xmlCode.indexOf("<" + contribString)>0) {
			xmlCode= xmlCode.substring(xmlCode.indexOf("<" + contribString)); 
			String endTag = "</" + contribString + ">";
			xmlCode = xmlCode.substring(0,xmlCode.indexOf(endTag) + endTag.length());
			xmlCode += "\n";
		}
		try {
			outStream.write(xmlCode.getBytes("UTF-8"));	
		}
		catch (Exception ex) {
			throw new PapillonBusinessException("Error in writing an UTF-8 String: ", ex);
		}
	}

}
