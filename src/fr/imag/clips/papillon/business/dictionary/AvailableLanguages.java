/*
 *  LanguageListsFactory.java
 *  papillon
 *
 *  Created by Mathieu Mangeot on Sat Mar 09 2002.
 *  Copyright (c) 2002 GETA_CLIPS_IMAG. All rights reserved.
 *
 *---------------------------------------------------------
 * $Id$
 *---------------------------------------------------------
 * $Log$
 * Revision 1.4  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.3.10.1  2006/02/17 13:21:25  mangeot
 *
 * MM: modified AdvancedQueryForm. getAllTargetLanguages, getAllSourceLanguages and getCdmElementsWithDefaultLanguage are now static in AvailableLanguages.java in order to accelerate the execution.
 *
 * Revision 1.3  2005/01/23 17:21:16  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *---------------------------------------------------------
 */

package fr.imag.clips.papillon.business.dictionary;

// For the TreMap & TreeSet & Array
import java.util.*;

public class AvailableLanguages {

    protected static TreeMap MapLanguages = null;
    protected static String[] SourceLanguagesArray = null;
    protected static String[] TargetLanguagesArray = null;
    protected static String[] AllLanguagesArray = null;
	
	protected static Set CdmElementsWithDefaultLanguage = null;


	/**
        * return the list of source languages as known by the database
     */
    protected static TreeMap getAvailableLanguagesMap()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			if (MapLanguages==null) {
            Dictionary[] DictsArray = DictionariesFactory.getDictionariesArray();
            MapLanguages = new TreeMap();
            TreeSet targetSet;

             for (int i=0; i< DictsArray.length; i++) {
                String[] Sources =  DictsArray[i].getSourceLanguagesArray();
                for (int j=0; j< Sources.length; j++) {
                    String source = Sources[j];
                    if (null != source && !source.equals("") && !source.equals("axi")) {
                        if (MapLanguages.containsKey(source)) {
                            targetSet=(TreeSet) MapLanguages.get(source);
                        }
                        else {
                            targetSet = new TreeSet();
                        }
                        String[] Targets =  DictsArray[i].getTargetLanguagesArray();
                        for (int k=0; k<Targets.length; k++) {
                            String target = Targets[k];
                            if (null != target && !target.equals("") && !target.equals("axi") && !target.equals(source)) {
                                targetSet.add(target);
                            }
                        }
                        MapLanguages.put(source,targetSet);
                    }
                }
            }
			}
            return MapLanguages;
        }

    /**
        * return the list of source languages as known by the database
     */
    public static String[] getSourceLanguagesArray()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			if (SourceLanguagesArray == null) {
				SourceLanguagesArray = (String[])(getAvailableLanguagesMap().keySet().toArray(new String[0]));
			}
            return SourceLanguagesArray;
        }

    public static String[] getTargetLanguagesArray(String lang)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            String [] result = null;
            TreeSet mySet = null;
            if (getAvailableLanguagesMap().containsKey(lang)) {
                mySet = (TreeSet)getAvailableLanguagesMap().get(lang);
                result =  (String[])mySet.toArray(new String[0]);
            }
            return result;
        }

    public static String[] getAllLanguagesArray()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			if (AllLanguagesArray == null) {
				String[] SourceLanguages = getSourceLanguagesArray();
				TreeSet mySet = new TreeSet();
				mySet.addAll(getAvailableLanguagesMap().keySet());
				for (int i=0;i<SourceLanguages.length;i++) {
					mySet.addAll((TreeSet)getAvailableLanguagesMap().get(SourceLanguages[i]));
				}
				AllLanguagesArray = (String[])mySet.toArray(new String[0]);
			}
			return AllLanguagesArray;
        }

    public static String[] getSourceLanguagesArrayForDict(String dict)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            Dictionary myDict = DictionariesFactory.findDictionaryByName(dict);
            TreeSet mySet = new TreeSet();
            mySet.addAll(Arrays.asList(myDict.getSourceLanguagesArray()));
            mySet.remove("axi");
            mySet.remove("");
			return (String[])mySet.toArray(new String[0]);
        }
	
    public static String[] getTargetLanguagesArray()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			if (TargetLanguagesArray == null) {
				Dictionary[] DictsArray = DictionariesFactory.getDictionariesArray();
				TreeSet mySet = new TreeSet();
				for (int i=0; i< DictsArray.length; i++) {
					String[] Targets =  DictsArray[i].getTargetLanguagesArray();
					mySet.addAll(Arrays.asList(Targets));
				}
				mySet.remove("axi");
				mySet.remove("");
				TargetLanguagesArray = (String[])mySet.toArray(new String[0]);
			}
			return TargetLanguagesArray;
        }
	
	public static Set getCdmElementsWithDefaultLanguage ()
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		if (CdmElementsWithDefaultLanguage == null) {
			//
			Volume[] volumes = VolumesFactory.getVolumesArray();
			CdmElementsWithDefaultLanguage = new java.util.TreeSet();
			
			//
			for (int i = 0; i < volumes.length; i++) {
				// get all cdm-elements with Volume.DEFAULT_LANG language
				Volume volume = volumes[i];
				Hashtable CdmElementsTable = volume.getCdmElements();
				Hashtable CdmElementsTableDefaultLang = (Hashtable) CdmElementsTable.get(Volume.DEFAULT_LANG);
				
				CdmElementsWithDefaultLanguage.addAll(CdmElementsTableDefaultLang.keySet());
			}
		}
		return CdmElementsWithDefaultLanguage;
	} 
	
	public static boolean resetCache () {
		TreeMap MapLanguages = null;
		SourceLanguagesArray = null;
		TargetLanguagesArray = null;
		AllLanguagesArray = null;
		
		CdmElementsWithDefaultLanguage = null;
		
		return true;
	}
	
}
