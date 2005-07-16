/*
 *  Created by Mathieu Mangeot on 28/04/05.
 *  Copyright 2005 Mangeot-Sérasset. All rights reserved.
 *
 * Cascade call of comparators when equality:
 *  StatusComparator -> AuthorComparator -> HeadwordComparator -> HomographNumberComparator -> ParticuleComparator
 *  ReviewerComparator -> AuthorComparator -> HeadwordComparator -> HomographNumberComparator -> ParticuleComparator
 *  ReviewDateComparator -> CreationDateComparator -> HeadwordComparator -> HomographNumberComparator -> ParticuleComparator
 *  OriginalContributionIdComparator -> HeadwordComparator -> HomographNumberComparator -> ParticuleComparator
 *
 * Note: the HeadwordComparator might be modified in order to sort following local alphabetical orders
 *
 * FIXME: Particulecomparator is a special sort for Estonian !
 *
 *----------------------------------------
 *$Id$
 *------------------------------------------
 *$Log$
 *Revision 1.2  2005/07/16 12:48:04  mangeot
 **** empty log message ***
 *
 *Revision 1.1  2005/07/16 09:15:58  mangeot
 *Added HomographNumberComparator and ParticuleComparator
 *
 *
 *--------------------------------------
 */
package fr.imag.clips.papillon.business.utility;

import fr.imag.clips.papillon.business.dictionary.VolumeEntry;

public class ParticuleComparator implements java.util.Comparator {
	// Compare two Strings. Callback for sort.
	// effectively returns a-b;
	// e.g. +1 (or any +ve number) if a > b
	// 0 if a == b
	// -1 (or any -ve number) if a < b
	public final int compare (Object a, Object b) {
		int res = 0;
		try {
			if (((VolumeEntry)a).getSourceLanguage().equals("est") &&
				((VolumeEntry)b).getSourceLanguage().equals("est")) {
				String hwA = ((VolumeEntry)a).getParticule();
				String hwB = ((VolumeEntry)b).getParticule();
				if (hwA != null && hwB != null) {
					hwA = hwA.toLowerCase();
					hwB = hwB.toLowerCase();
					
					if (hwA.indexOf("-") == 0) {
						hwA = hwA.substring(1);
					}
					if (hwA.indexOf("+") == 0) {
						hwA = hwA.substring(1);
					}
					if (hwB.indexOf("-") == 0) {
						hwB = hwB.substring(1);
					}
					if (hwB.indexOf("+") == 0) {
						hwB = hwB.substring(1);
					}
					res = hwA.compareTo(hwB);
				}
			}
		}
		catch (Exception e) {
			res = 0;
		}
		return res;
	} 
} 
