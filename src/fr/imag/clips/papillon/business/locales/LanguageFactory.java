/*
 * papillon
 *
 * LanguageFactory.java
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.6  2003/09/22 10:17:36  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2003/08/14 08:30:12  mangeot
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
 * Revision 1.4  2003/06/04 15:38:30  serasset
 * Mise en place du chinois et de la nouvelle version du login/register
 *
 * Revision 1.3.2.1  2003/05/28 09:17:18  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.3  2003/01/21 09:19:49  mangeot
 * A Few corrections for the HTML rendering
 *
 * Revision 1.2  2003/01/10 08:11:57  mangeot
 * Problem with labels and UTF-8 fixed for internet explorer and icab
 * Problem with language identification fixed eg: en-US
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/09/16 13:34:22  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.4  2002/08/19 11:14:12  tache
 * Minor corrections of code presentation (comments, etc).
 *
 * Revision 1.3  2002/08/07 14:01:48  tache
 * Added some languages in languages array.
 *
 * Revision 1.2.2.1  2002/08/02 08:25:09  mangeot
 * Replaced PAGENAME variable by this.getUrl() method
 *
 * Revision 1.2  2002/07/26 10:00:20  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.1.2.1  2002/07/12 13:50:40  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 *-----------------------------------------------
 * Language Name Factory.
 */

package fr.imag.clips.papillon.business.locales;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import fr.imag.clips.papillon.business.PapillonLogger;

public class LanguageFactory {

		public static final ResourceBundle ISO6391to2TBundle = ResourceBundle.getBundle("fr.imag.clips.papillon.properties.ISO-639-1to2T", Locale.getDefault());
		public static final ResourceBundle ISO6392to1Bundle = ResourceBundle.getBundle("fr.imag.clips.papillon.properties.ISO-639-2to1", Locale.getDefault());

    /**
			* input: a String representing the ISO-639-1 two letter code of a language
		 * output: a String representing the ISO-639/T 3 letter code representing the language
		 * or a String with max 3 characters if the code is not found.
		 *
		 * To add a new language code, please edit the fr.imag.clips.papillon.properties.ISO-639-1to2T.properties
		 *    and fr.imag.clips.papillon.properties.ISO-639-2to1.properties file
		 *
		 * @return ArrayList containing the accepted languages.
		 */
    public static String getISO3LanguageCode(String lang) {
			String res = lang;
			if (lang.length() > 3) {
				lang=lang.substring(0,3);
			}
			if (lang.length() >= 2) {
				try {
					res = ISO6391to2TBundle.getString(lang.substring(0,2));
				}
				catch (Exception e) {
					/* code was not found */
					res=lang;
				}
			}
			return res;
    }

    /**
			* input: a String representing the ISO-639-2 3 letter code of a language
		 * output: a String representing the ISO-639/T 2 letter code representing the language
		 * or a String with max 2 characters if the code is not found.
		 *
		 * To add a new language code, please edit the fr.imag.clips.papillon.properties.ISO-639-2to1.properties file
		 *    and fr.imag.clips.papillon.properties.ISO-639-1to2T.properties file
		 *
		 * @return ArrayList containing the accepted languages.
		 */
    public static String getISO2LanguageCode(String lang) {
			String res = lang;
			if (lang.length() >= 3) {
				lang=lang.substring(0,3);
				try {
					res = ISO6392to1Bundle.getString(lang.substring(0,3));
				}
				catch (Exception e) {
					/* code was not found */
					res=lang.substring(0,2);
				}
			}
			return res;
    }

    /**
    * Returns a List of String representing the languages accepted by the user, in
    * the user's preference order.
    *
    * @return ArrayList containing the accepted languages.
    */
    public static ArrayList decodeAcceptLanguages(String languages) {
        ArrayList result = new ArrayList(); 

        if (null == languages) return result;
        String[] languagesArray = languages.split(",");

        if (null == languagesArray) return result;

        for (int i=0; i<languagesArray.length; i++) {
            String lang =  languagesArray[i];
            String[] langSplit = lang.split(";");
            lang = (null == langSplit || 0 == langSplit.length) ? "" : langSplit[0];

            result.add(getISO3LanguageCode(lang));
        }
        return result;
    }        
}
