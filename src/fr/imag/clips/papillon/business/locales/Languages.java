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
 * Revision 1.11  2003/10/11 02:53:53  mangeot
 * Modified languages, now loading from the properties files when launching the app,
 * there is no need to hard code new language resources when they are added
 * I added also a cache to speed up the process
 *
 * Revision 1.10  2003/10/08 03:43:48  mangeot
 * Managing languages bundles with cache
 *
 * Revision 1.9  2003/09/23 16:18:09  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2003/09/23 15:52:54  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2003/09/03 10:08:30  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.6  2003/08/22 05:46:22  mangeot
 * THE release !!!
 *
 * Revision 1.5  2003/08/14 10:36:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/08/14 08:30:12  mangeot
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
 * Revision 1.3  2003/07/24 12:07:17  serasset
 * Corean and Chinese added in language names factory.
 * New sections added in info_doc.xml file's schema.
 * File upload now accepts up to 20 Mb in Information Files Admin page.
 *
 * Revision 1.2  2003/06/04 15:38:30  serasset
 * Mise en place du chinois et de la nouvelle version du login/register
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.2  2002/10/25 14:10:31  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.1.2.1  2002/10/02 05:19:17  mangeot
 * The parser does not verify the encoding of the info_doc.xml file, thus I have to reparse
 * with the serializer the author, reference and title.
 *
 * Revision 1.1  2002/09/17 17:13:22  mangeot
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

package fr.imag.clips.papillon.business.locales;

// For the HashMap & TreeSet
import java.util.Hashtable;

import java.util.Locale;
import java.util.ResourceBundle;

import com.lutris.appserver.server.Enhydra;
import com.lutris.util.ConfigException;


/* The java bundles files work with ISO-639-1 two letters codes,
* but Papillon plateform uses ISO-639-2T three letters codes.
* Thus, we do not use the locales dynamically. Instead, we load statically
* all the available language lists.
*
* If you want to add a language list, you have to write a Languages.properties
* file and to modify the following code. */

public class Languages {

	/* Constants */
	protected final static String PropertiesPath = "fr.imag.clips.papillon.properties.";
	protected final static String LanguagesFile = "Languages";
	protected final static String LanguagesASCIIFile = "LanguagesASCII";
	protected static Hashtable LanguagesResbundles = new Hashtable();
	protected static Hashtable LanguagesASCIIResbundles = new Hashtable();
	protected final static Locale defaultLocale = Locale.getDefault();

	protected static final String[] LanguagesArray = {
		"deu","eng","esp","fra","hun","ita",
		"jpn","kor","lao","msa","tha","vie",
		"zho"};

	public static String localizeName(String langLoc, String langName) {
		String res = langName;
		try {
			/* lookup the cache */
			ResourceBundle myBundle = (ResourceBundle) LanguagesResbundles.get(langLoc);
			if (myBundle==null) {
				/* if not in the cache, create */
				try {
				myBundle = ResourceBundle.getBundle(PropertiesPath + LanguagesFile + "-" + langLoc, defaultLocale);
				}
				catch (Exception e) {
					/* language bundle was not found */
					myBundle=ResourceBundle.getBundle(PropertiesPath + LanguagesFile, defaultLocale);
				}				
				LanguagesResbundles.put(langLoc,myBundle);
			}
			res=myBundle.getString(langName);
		}
		catch (Exception e) {
			/* language name was not found */
			res=langName;
		}
		return res;
	}

	public static String localizeLabel(String langLoc, String langName) {
		String res = langName;
		try {
			/* lookup the cache */
			ResourceBundle myBundle = (ResourceBundle) LanguagesASCIIResbundles.get(langLoc);
			if (myBundle==null) {
				/* if not in the cache, create */
				try {
					myBundle = ResourceBundle.getBundle(PropertiesPath + LanguagesASCIIFile + "-" + langLoc, defaultLocale);
				}
				catch (Exception e) {
					/* language bundle was not found */
					myBundle=ResourceBundle.getBundle(PropertiesPath + LanguagesASCIIFile, defaultLocale);
				}
				LanguagesASCIIResbundles.put(langLoc,myBundle);
			}
			res=myBundle.getString(langName);
		}
		catch (Exception e) {
			/* language name was not found */
			res=langName;
		}
		return res;
	}

	public static String[] getArray() {
		return LanguagesArray;
	}

	public static boolean resetCache() {
		LanguagesResbundles = new Hashtable();
		LanguagesASCIIResbundles = new Hashtable();
		return true;
	}
}
