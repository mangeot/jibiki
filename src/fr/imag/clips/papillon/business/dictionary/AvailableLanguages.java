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

// For the HashMap & TreeSet & Array
import java.util.*;

public class AvailableLanguages {

    protected TreeMap MapLanguages;


    
    // constructor    
    public AvailableLanguages()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
       this.MapLanguages = getAvailableLanguagesMap();
        }

    /**
        * return the list of source languages as known by the database
     */
    private TreeMap getAvailableLanguagesMap()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            Dictionary[] DictsArray = DictionariesFactory.getDictionariesArray();
            TreeMap myTreeMap = new TreeMap();
            TreeSet targetSet;

             for (int i=0; i< DictsArray.length; i++) {
                String[] Sources =  DictsArray[i].getSourceLanguagesArray();
                for (int j=0; j< Sources.length; j++) {
                    String source = Sources[j];
                    if (null != source && !source.equals("") && !source.equals("axi")) {
                        if (myTreeMap.containsKey(source)) {
                            targetSet=(TreeSet)myTreeMap.get(source);
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
                        myTreeMap.put(source,targetSet);
                    }
                }
            }
            return myTreeMap;
        }

    /**
        * return the list of source languages as known by the database
     */
    public String[] getSourceLanguagesArray()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            return (String[])(this.MapLanguages.keySet().toArray(new String[0]));
        }

    public String[] getTargetLanguagesArray(String lang)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            String [] result = null;
            TreeSet mySet = null;
            if (this.MapLanguages.containsKey(lang)) {
                mySet = (TreeSet)this.MapLanguages.get(lang);
                result =  (String[])mySet.toArray(new String[0]);
            }
            return result;
        }

    public String[] getAllLanguagesArray()
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            String[] result = null;
            String[] SourceLanguages = getSourceLanguagesArray();
            TreeSet mySet = new TreeSet();
            mySet.addAll(this.MapLanguages.keySet());
            for (int i=0;i<SourceLanguages.length;i++) {
                mySet.addAll((TreeSet)this.MapLanguages.get(SourceLanguages[i]));
            }
            return (String[])mySet.toArray(new String[0]);
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
            Dictionary[] DictsArray = DictionariesFactory.getDictionariesArray();
            TreeSet mySet = new TreeSet();
            for (int i=0; i< DictsArray.length; i++) {
                String[] Targets =  DictsArray[i].getTargetLanguagesArray();
                mySet.addAll(Arrays.asList(Targets));
            }
            mySet.remove("axi");
            mySet.remove("");
            return (String[])mySet.toArray(new String[0]);
        }
}
