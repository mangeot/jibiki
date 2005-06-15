/*
*  Created by Mathieu Mangeot on 28/04/05.
*  Copyright 2005 Mangeot-Sérasset. All rights reserved.
*----------------------------------------
*$Id$
*------------------------------------------
*$Log$
*Revision 1.2  2005/06/15 16:48:28  mangeot
*Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
*
*Revision 1.1.2.2  2005/06/09 13:29:23  mangeot
*Sorting bug fixes
*
*Revision 1.1.2.1  2005/04/29 15:29:09  mangeot
*Added classes for new version
*
*
*--------------------------------------
*/
package fr.imag.clips.papillon.business.utility;

import fr.imag.clips.papillon.business.dictionary.VolumeEntry;

public class ReviewDateComparator implements java.util.Comparator {
	// Compare two Strings. Callback for sort.
	// effectively returns a-b;
	// e.g. +1 (or any +ve number) if a > b
	// 0 if a == b
	// -1 (or any -ve number) if a < b
	public final int compare ( Object a, Object b) {
		int res = 0;
		try {
			java.util.Date revDateA = ((VolumeEntry)a).getReviewDate();
			java.util.Date revDateB = ((VolumeEntry)b).getReviewDate();
			if (revDateA != null) {
			// a et b ont une reviewDate
				if (revDateB != null)  {
					res = revDateA.compareTo(revDateB);
					if (res == 0) {
						res = new CreationDateComparator().compare(a,b);
					}
				}
			// a seulement a une reviewDate
				else {
					res = 1;
				}
			} 
			else {
			// b seulement a une reviewDate
				if (revDateB != null)  {
					res = -1;
				}
			// ni a ni b n'ont de reviewDate
				else {
					res = new CreationDateComparator().compare(a,b);
				}
			}
		}
		catch (Exception e) {
			res = 0;
		}
		return res;
	}
} 