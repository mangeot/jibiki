/*
 *  Created by Mathieu Mangeot on 13/06/05.
 *  Copyright 2005 Mangeot-Sérasset. All rights reserved.
 ------------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2005/08/05 18:47:02  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2005/06/18 23:01:43  mangeot
 * changed the modif comment
 *
 * Revision 1.3  2005/06/17 15:51:32  mangeot
 * Modified changeAuthor
 *
 * Revision 1.2  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.1.2.1  2005/06/14 11:56:16  mangeot
 * Added a new page ChangeAuthor for changing the author of a set of previously selected contributions
 *
 *
 *-----------------------------------------------
 */ 

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

public class ConvertVolumeEntryProcessor implements IVolumeEntryProcessor {

	protected static fr.imag.clips.papillon.business.xsl.XslSheet theStylesheet = null;

	public ConvertVolumeEntryProcessor(String stylesheetName) throws PapillonBusinessException {
		theStylesheet = fr.imag.clips.papillon.business.xsl.XslSheetFactory.findXslSheetByHandle(stylesheetName);
		if (theStylesheet == null || theStylesheet.isEmpty()) {
			System.out.println("Stylesheet empty!");
		}
	}

	public void process(VolumeEntry myEntry) throws PapillonBusinessException {
		try {
			System.out.println(myEntry.getHeadword());
			org.w3c.dom.Document newDoc = fr.imag.clips.papillon.business.transformation.XslTransformation.Transform(myEntry.getDom(), theStylesheet);
			myEntry.setDom(newDoc);
			myEntry.save();
		}
		catch (Exception ex) {
			throw new PapillonBusinessException("Error in ConvertVolumeEntryProcessor: ", ex);
		}
	}

}