/*
 *  LanguageListsFactory.java
 *  papillon
 *
 *  Created by Mathieu Mangeot on Sat Mar 09 2002.
 *  Copyright (c) 2002 GETA_CLIPS_IMAG & NII. All rights reserved.
 *
 *---------------------------------------------------------
 * $Id$
 *---------------------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.6  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.5  2003/10/02 06:29:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/09/03 10:08:29  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.3  2003/08/21 09:12:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/08/14 08:30:10  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.1.1.1.2.1  2003/08/05 05:18:46  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:12  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.1  2002/09/17 17:13:20  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.10  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.9  2002/09/05 10:25:59  mangeot
 * dded AdminAxies
 *
 * Revision 1.8  2002/07/26 16:38:06  tache
 * Corrected a language name in French.
 *
 * Revision 1.7.2.3  2002/08/23 06:33:23  mangeot
 * New translations added
 *
 * Revision 1.7.2.2  2002/08/08 09:11:57  mangeot
 * New Home page with simplified interface a lot of work
 * + localization in german
 *
 * Revision 1.7.2.1  2002/08/02 08:25:09  mangeot
 * Replaced PAGENAME variable by this.getUrl() method
 *
 * Revision 1.7  2002/07/26 10:00:20  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.6  2002/07/11 17:31:36  serasset
 * Changed encoding of the source file from MAC to ISO8859-1.
 *
 * Revision 1.5.2.1  2002/07/12 13:50:40  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.5  2002/06/10 13:26:01  mangeot
 * Continued the localization, added the lang string into the session data
 *
 * Revision 1.4  2002/06/10 11:07:57  mangeot
 * I began to implement the localization but very rapidly ...
 *
 * Revision 1.3  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.2  2002/05/22 08:56:18  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.1  2002/04/16 04:13:16  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/03/11 11:15:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/02/06 15:03:03  serasset
 * Consultation and Administration of the information files now correctly use the Sections.
 * We do not display the files directly anymore, but display a document. This allows the display of
 * images as embedded docs in the default layout.
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
