/*
 *  Created by Mathieu Mangeot on 13/06/05.
 *  Copyright 2005 Mangeot-Sérasset. All rights reserved.
 ------------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
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

public class ChangeAuthorProcessor implements IVolumeEntryProcessor {

	protected static String newAuthor = null;

	public ChangeAuthorProcessor(String author) {
		newAuthor = author;
	}

	public void process(VolumeEntry myEntry) throws PapillonBusinessException {
		try {
			if (newAuthor != null && ! newAuthor.equals("")) {
				myEntry.setAuthor(newAuthor);	
				myEntry.save();
			}
		}
		catch (Exception ex) {
			throw new PapillonBusinessException("Error in ChangeAuthorProcessor: ", ex);
		}
	}

}
