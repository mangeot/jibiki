/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.29  2004/02/13 00:56:38  mangeot
 * Bug fixes
 *
 * Revision 1.28  2004/02/12 15:55:48  mangeot
 * Added functionnalities for the GDEF
 *
 * Revision 1.27  2004/02/10 05:27:13  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.26.2.3  2004/02/08 03:46:24  mangeot
 * bug fixes, cleaning code
 *
 * Revision 1.26.2.2  2004/02/02 07:53:52  mangeot
 * Bug fixes in encoding and UserInterface
 *
 * Revision 1.26.2.1  2004/01/08 09:43:19  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.26  2003/11/25 07:01:36  mangeot
 * Bug Fix when reediting an existing contribution
 *
 * Revision 1.25  2003/11/20 06:40:40  mangeot
 * Tracked down and fixed the following bug: the reading was not saved into the database. The
 * reason is that I forgot to modify all the parts of VolumeEntryDO.java. Next time, be
 * careful or regenerate it with DODS.
 *
 * Revision 1.24  2003/11/20 04:53:19  mangeot
 * *** empty log message ***
 *
 * Revision 1.23  2003/10/21 15:53:49  mangeot
 * Deleting Logger lines
 *
 * Revision 1.22  2003/10/19 14:53:31  mangeot
 * Modified the newEntry, storing the writing in key1 field
 *
 * Revision 1.21  2003/10/19 13:06:54  mangeot
 * *** empty log message ***
 *
 * Revision 1.20  2003/10/08 01:51:23  mangeot
 * Added a way to parse tab separated files for FoksEdict dictionary
 * Created an FoksEntry table in the .doml file
 * Do not forget to reload create_tables.sql
 *
 * Revision 1.19  2003/10/04 07:55:27  mangeot
 * *** empty log message ***
 *
 * Revision 1.18  2003/10/04 06:48:45  mangeot
 * Bug fixed when I selected multiple targets languages
 *
 * Revision 1.17  2003/10/04 06:01:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.16  2003/10/04 05:43:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.15  2003/10/04 04:30:41  mangeot
 * Debug Foks module
 *
 * Revision 1.14  2003/10/04 04:13:30  mangeot
 * Updated getFoksEntriesVector in order to use the Index tables
 *
 * Revision 1.13  2003/10/03 16:02:39  serasset
 * Suppression du traitement specifique du volume Foks.
 *
 * Revision 1.12  2003/10/02 09:53:16  mangeot
 * *** empty log message ***
 *
 * Revision 1.11  2003/10/02 09:36:11  mangeot
 * Modified email addresses to avoid spams from robots
 *
 * Revision 1.10  2003/08/23 16:46:55  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2003/08/23 15:06:43  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2003/08/23 06:38:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2003/08/23 01:51:02  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2003/08/14 08:30:11  mangeot
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
 * Revision 1.5  2003/03/27 06:54:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/03/26 04:20:50  mangeot
 * Added order in informationdocument and xslsheet queries
 *
 * Revision 1.3.2.31  2003/08/14 04:15:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.30  2003/08/11 10:24:50  mangeot
 * Debugging ...
 *
 * Revision 1.3.2.29  2003/08/11 07:47:47  mangeot
 * bug correction while loading dicitonry entries
 *
 * Revision 1.3.2.28  2003/08/09 07:21:05  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.3.2.27  2003/08/07 06:29:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.26  2003/08/05 05:18:46  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.25  2003/07/31 16:15:59  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.24  2003/07/31 12:51:19  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.23  2003/07/31 10:51:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.22  2003/07/01 07:14:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.21  2003/06/30 13:25:26  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.20  2003/06/30 08:33:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.19  2003/06/30 08:27:18  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.18  2003/06/30 08:01:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.17  2003/06/30 06:58:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.16  2003/06/30 06:26:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.15  2003/06/30 05:56:46  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.14  2003/06/30 05:34:59  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.13  2003/06/30 05:26:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.12  2003/06/30 05:16:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.11  2003/06/30 05:08:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.10  2003/06/30 04:05:40  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.9  2003/06/30 02:58:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.8  2003/06/27 05:28:42  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.7  2003/06/27 02:13:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.6  2003/06/25 09:54:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.5  2003/06/23 04:56:05  mangeot
 * bug fixed
 *
 * Revision 1.3.2.4  2003/06/21 17:56:37  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.3  2003/05/28 09:17:15  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.3.2.2  2003/05/08 07:43:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.1  2003/02/18 03:27:53  mangeot
 * Development for the editing interface
 *
 * Revision 1.3  2003/02/16 05:19:21  mangeot
 * All the keys except the entry id are in multiple value format, ie with a '#' on both sides.
 * Therefore, we have to reload all the dicitonaries if we want to look for pos, pron, etc.
 *
 * Revision 1.2  2002/11/22 13:04:10  mangeot
 * Nouvelle version Papillon enhydra 5.0
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.21  2002/10/25 14:10:29  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.20.2.2  2002/10/23 09:51:07  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.20.2.1  2002/10/10 06:46:51  mangeot
 * Corrected a bug pb between lang and DocLang in consultInformations
 * Created a new sql function to count the number of entries for the volumes
 * added in Adminvolumes.java and dictd.show server
 *
 * Revision 1.20  2002/09/17 20:29:32  mangeot
 * Bug corrected, version deploy 1_4 ready !
 *
 * Revision 1.19  2002/09/17 17:13:21  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.18  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.17  2002/09/11 17:35:08  mangeot
 * Added config from config file for dictd server
 *
 * Revision 1.16  2002/09/11 16:28:13  mangeot
 * Added classes to implement dict protocol rfc 2229
 *
 * Revision 1.15.6.4  2002/08/09 09:15:13  mangeot
 * Improvements for the simple consultation
 * adding text for help,
 * correcting consultation bugs
 *
 * Revision 1.15.6.3  2002/08/08 09:11:57  mangeot
 * New Home page with simplified interface a lot of work
 * + localization in german
 *
 * Revision 1.15.6.2  2002/08/02 16:39:14  mangeot
 * Bug Report, bug not yet fixed:
 * the query of French diacritics is ok on macOsX but not on Linux bushido
 *
 * Revision 1.15.6.1  2002/08/02 16:04:56  mangeot
 * Desole, besoin de tester un bug sur bushido !
 *
 * Revision 1.15  2002/06/04 03:59:39  mangeot
 * bugs corrected for volumeEntriesFactory plus
 * I added the research for title and author in consltInformations
 *
 * Revision 1.14  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.13  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.12  2002/05/08 13:14:46  mangeot
 * I rewrote some files of the data layer in order to be dependent
 * from the number of tables for the Volum Entries.
 * The next step is to generate tables on the fly with the pgsql jdbc driver
 *
 * Revision 1.11  2002/05/07 10:31:22  mangeot
 * The UTF-8 consultation is now OK,
 * I tested with omniweb, iexplorer and netscape latests versions on macosX
 *
 * Revision 1.10  2002/05/02 07:02:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.8  2002/04/17 19:18:22  mangeot
 * I deleted the form AdminXml.po and created another one:
 * AddEntries.po
 * Now you can't add entries without a metadata file associated.
 *
 * Revision 1.7  2002/04/16 14:23:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/03/27 09:51:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/03/25 09:50:40  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/03/20 09:36:20  mangeot
 * Now the consultation is done in a separate db table for each volume
 * A big pb remaining: the data directory has to be remodified by hands...
 *
 * Revision 1.1  2002/03/20 04:30:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2002/03/11 11:15:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/10/17 13:02:03  serasset
 * Distinction entre Doucmuent (abstrait) et fichier (qui constituent concretement un doucument)
 *
 * Revision 1.5  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.4  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.3  2001/07/12 20:38:45  salvati
 * Added Node2String function and use of it
 *
 * Revision 1.2  2001/07/12 17:58:00  salvati
 * end of debug
 * CV: ----------------------------------------------------------------------
 *
 * Revision 1.1  2001/07/12 17:38:08  salvati
 * Renaming DictionaryFactory in DictionarEntriesFactory
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.papillon_data.*;

// For parsing
import java.io.*;

// For vectors
import java.util.*;

// For the SAX parser
import org.apache.xerces.parsers.*;
import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;


//import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;


import fr.imag.clips.papillon.business.utility.*;

/* For the SQL statements */
import fr.imag.clips.papillon.data.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
* Used to find the instances of xslsheet.
 */
public class VolumeEntriesFactory {

	// variables used in setGDEFFrenchTranslations
	protected final static String VOLUME_GDEF_est = "GDEF_est";
	protected final static String VOLUME_GDEF_fra = "GDEF_fra";
	protected final static String VOLUME_GDEF_est_translation = "mot-princ";
	protected final static String VOLUME_GDEF_est_sep = "#";
	protected final static String VOLUME_GDEF_est_prefix = "fra.";

    /**
        * The getVolumeEntriesArray method performs a database query to
     * return an array of Dictionary entries
     * @return
     *     array of discs.
     * @exception PapillonBusinessException
     *   If there is a problem retrieving disc information.
     */



    public static Hashtable getVolumeEntriesHashtable(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy) throws PapillonBusinessException {
		return getVolumeEntriesHashtable(dict, volume, id, Headwords, strategy,
								null, null, null, null, null, null, null);
	}

		public static Hashtable getVolumeEntriesHashtable(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pos, String pron, String reading, String trans, String key1,String key2,String any) throws PapillonBusinessException {
        Hashtable MyTable = null;
        if (null != volume) {
            if (volume.getLocation().equals(Volume.LOCAL_LOCATION)) {
                MyTable = getDbTableEntriesHashtable(dict, volume,id,Headwords,strategy,pos,pron,reading,trans,key1,key2,any);
            }
            else if (volume.getLocation().equals(Volume.REMOTE_LOCATION)) {
                MyTable = getRemoteVolumeEntriesHashtable(dict,volume,id,Headwords,pos,pron,reading, trans,key1,key2,any);
            }
        }
        return MyTable;
    }


    public static Hashtable getRemoteVolumeEntriesHashtable(Dictionary dict,
                                                      Volume volume,
                                                      String id,
                                                      String[] Headwords,
                                                      String pos,
                                                      String pron,
                                                      String reading,
                                                      String trans,
                                                      String key1,
                                                      String key2,
                                                      String any) throws PapillonBusinessException {
        Hashtable theEntries = new Hashtable();
        try {
            if (null != volume) {
                fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Remote Volume: " + volume.getName());
                if (volume.getName().equals("Lexico_eng")) {
                    Wrapper myWrapper = WrappersFactory.createLexicoWrapper();
                    RemoteEntry myEntry = new RemoteEntry();
                    myEntry.setDictionary(dict);
                    myEntry.setVolume(volume);
                    if (null != Headwords && Headwords.length >0) {
                        myEntry.setHeadword(Headwords[0]);
                    }
                    myEntry.setXmlCode(myWrapper.getResultXmlCode(Headwords));
                    theEntries.put(myEntry.getHandle(),myEntry);
                }
            }
        }
        catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getVolumeEntriesArray()", ex);
        }
        return theEntries;
    }

	public static Hashtable getVolumeNameEntriesHashtable(String volumeName,
												 String id,
												 String[] Headwords,
												 int strategy)
		throws PapillonBusinessException {
			return getVolumeNameEntriesHashtable(volumeName, id, Headwords, strategy,
									 null, null, null, null, null, null, null);
		}
	
    public static Hashtable getVolumeNameEntriesHashtable(String volumeName,
                                                    String id,
                                                    String[] Headwords,
                                                    int strategy,
																										String pos,
                                                    String pron,
                                                    String reading,
                                                    String trans,
                                                    String key1,
                                                    String key2,
                                                    String any)
        throws PapillonBusinessException {
            Volume volume;
            Dictionary dict;
            try {
                volume = VolumesFactory.findVolumeByName(volumeName);
                dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumeNameEntriesVector()", ex);
            }
            return getDbTableEntriesHashtable(dict, volume, id, Headwords, strategy, pos, pron, reading, trans, key1,key2,any);
        }

    protected static Hashtable getDbTableEntriesHashtable(Dictionary dict, Volume volume, String id, String[] Headwords, int strategy, String pos, String pron, String reading, String trans, String key1,String key2,String any) throws PapillonBusinessException {
        Hashtable theEntries = new Hashtable();

		// In this cases, we can use the Index file !		
		if ((strategy == IQuery.STRATEGY_NONE ||
	  strategy == IQuery.STRATEGY_EXACT ||
	  strategy == IQuery.STRATEGY_PREFIX) &&

	 ((pos == null || pos.equals("")) &&
   (trans == null || trans.equals("")) &&
   (any == null || any.equals("")))
	  ) {
			theEntries = IndexFactory.getEntriesHashtable(dict, volume, id, Headwords, strategy, pron, reading, key1, key2);
		}
		else
		
        try {
            String volumeTable = volume.getDbname();
            if (null != volumeTable) {
                // I know, it is an uggly code !
                // If you have a nicer solution...
                if (null == Headwords || Headwords.length == 0) {
                    Headwords = new String[1];
                    Headwords[0] = null;
                }
                String CIC = QueryBuilder.CASE_INSENSITIVE_CONTAINS;
                String CSC = QueryBuilder.CASE_SENSITIVE_CONTAINS;
                String CIE = QueryBuilder.CASE_INSENSITIVE_EQUAL;
                String CSE = QueryBuilder.EQUAL;
				String CIS = QueryBuilder.CASE_INSENSITIVE_STARTS_WITH;
				String CSS = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
                String cmp_op = CIE;

                // initialization of the variables
                // the headword is initialized afterwards

                if (null == id) {id = "";}
                else {id = id.trim();}

                if (null == pos) {pos = "";}
                else {pos = pos.trim();}

                if (null == pron) {pron = "";}
                else {pron = pron.trim();}

                if (null == reading) {reading = "";}
                else {reading = reading.trim();}

                if (null == trans) {trans = "";}
                else {trans = trans.trim();}

                if (null == key1) {key1 = "";}
                else {key1 = key1.trim();}

                if (null == key2) {key2 = "";}
                else {key2 = key2.trim();}

				if (null == any) {any = "";}
                    else {any = any.trim();}

				if (!pos.equals("")) {
                    pos = "#" + pos + "#";
                }
                if (!pron.equals("")) {
                    pron = "#" + pron + "#";
                }
                if (!key1.equals("")) {
                    key1 = "#" + key1 + "#";
                }
                if (!key2.equals("")) {
                    key2 = "#" + key2 + "#";
                }

                for (int i=0; i < Headwords.length; i++) {
                    String headword = Headwords[i];
                    fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Sequencial request table: " + volumeTable + " word: " + headword);

                    // consultation of a local volume
                    VolumeEntryQuery query = new VolumeEntryQuery(volumeTable);

                    if (null == headword) {headword = "";}
                    else {headword = headword.trim();}

                    // Different strategies
                    if (strategy == IQuery.STRATEGY_EXACT) {
                        cmp_op = CSS;
                        if (!headword.equals("")) {
                            headword = "#" + headword + "#";
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans + "#";
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading + "#";
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_PREFIX) {
                        cmp_op = CSS;
                        if (!headword.equals("")) {
                            headword = "#" + headword;
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans;
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading;
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_SUFFIX) {
                        cmp_op = CSC;
                        if (!headword.equals("")) {
                            headword += "#";
                        }
                        if (!trans.equals("")) {
                            trans += "#";
                        }
                        if (!reading.equals("")) {
                            reading += "#";
                        }
                    }
					if (strategy == IQuery.STRATEGY_INSENSITIVE_EXACT) {
                        cmp_op = CIS;
                        if (!headword.equals("")) {
                            headword = "#" + headword + "#";
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans + "#";
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading + "#";
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_INSENSITIVE_PREFIX) {
                        cmp_op = CIS;
                        if (!headword.equals("")) {
                            headword = "#" + headword;
                        }
                        if (!trans.equals("")) {
                            trans = "#" + trans;
                        }
                        if (!reading.equals("")) {
                            reading = "#" + reading;
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_INSENSITIVE_SUFFIX) {
                        cmp_op = CIC;
                        if (!headword.equals("")) {
                            headword += "#";
                        }
                        if (!trans.equals("")) {
                            trans += "#";
                        }
                        if (!reading.equals("")) {
                            reading += "#";
                        }
                    }
                    else if (strategy == IQuery.STRATEGY_INSENSITIVE_SUBSTRING) {
                        cmp_op = CIC;
                    }
                    else {
                        cmp_op = CIC;
                    }


                    // building the query
                    if (!headword.equals("")) {
                        query.getQueryBuilder().addWhereClause("headword", headword, cmp_op);
                    }
                    if (!id.equals("")) {
                        query.getQueryBuilder().addWhereClause("id", id, CSE);
                    }
                    if (!pos.equals("")) {
                        query.getQueryBuilder().addWhereClause("pos", pos, cmp_op);
                    }
                    if (!pron.equals("")) {
                        query.getQueryBuilder().addWhereClause("pronunciation", pron, cmp_op);
                    }
                    if (!pron.equals("")) {
                        query.getQueryBuilder().addWhereClause("reading", pron, cmp_op);
                    }
                    if (!trans.equals("")) {
                        query.getQueryBuilder().addWhereClause("translation", trans, cmp_op);
                    }
                    if (!key1.equals("")) {
                        query.getQueryBuilder().addWhereClause("key1", key1, cmp_op);
                    }
                    if (!key2.equals("")) {
                        query.getQueryBuilder().addWhereClause("key2", key2, cmp_op);
                    }
                    if (!any.equals("")) {
                        query.getQueryBuilder().addWhereClause("xmlcode", any, CIC);
                    }

                    query.addOrderByHeadword(true);
                    VolumeEntryDO[] DOarray = query.getDOArray();
                    if (null != DOarray) {
                        for (int j=0; j < DOarray.length; j++) {
                            VolumeEntry tempEntry = new VolumeEntry(dict, volume,DOarray[j]);
                            theEntries.put(tempEntry.getHandle(),tempEntry);
                        }
                    }
                }
            }
        }
        catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getDbtableEntriesVector()", ex);
        }
        return theEntries;
    }

	public static Vector getFoksEntriesVector(String headword) throws PapillonBusinessException {
        Vector theEntries = new Vector();
        try {

					// consultation of a local volume
					FoksEntryQuery query = new FoksEntryQuery();
                //set query
					if (headword != null && !headword.equals("")) {
						fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Indexed request table: foksentry word: " + headword);
					query.setQueryReading(headword);
					query.addOrderByScore(false);
					FoksEntryDO[] DOarray = query.getDOArray();
					if (null != DOarray) {
						for (int i=0; i < DOarray.length; i++) {
							theEntries.add(new FoksEntry(DOarray[i]));
						}
					}
				}
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in getFoksEntriesVector()", ex);
		}
		return theEntries;
	}


	public static VolumeEntry getJMDictVolumeEntry(String headword) throws PapillonBusinessException {
		// FIXME: special code depending on FoksEdict and JmDict dictionaries
        VolumeEntry myAnswer = null;
		Hashtable theEntries = null;
		String[] Headwords = new String[] {headword};
        try {
			Volume volume = VolumesFactory.findVolumeByName("JMDict_jpn_eng");
			if (volume != null && !volume.IsEmpty()) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(volume.getDictname());
				theEntries = IndexFactory.getEntriesHashtable(myDict, volume, null, Headwords, IQuery.STRATEGY_EXACT, null, null, null, null);
			}
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in getJMDictEntriesVector()", ex);
		}
		if (theEntries !=null && theEntries.size()>0) {
			myAnswer = (VolumeEntry) theEntries.elements().nextElement();
		}
		return myAnswer;
	}


    /**
        * The findEntryByHandle method performs a database query to
     * return a id object
     *
     * @param id, the object id of the entries table.
     * @return
     *     the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static VolumeEntry findEntryByHandle(String volumeName, String handle)
        throws PapillonBusinessException {
					  Volume volume;
            Dictionary dict;
            try {
                volume = VolumesFactory.findVolumeByName(volumeName);
                dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            }
            catch(Exception ex) {
							return null;
            }
			return findEntryByHandle(dict, volume, handle);
		}

	protected static VolumeEntry findEntryByHandle(Dictionary myDict, Volume myVolume, String handle)
        throws PapillonBusinessException {
					VolumeEntry theEntry = null;
					VolumeEntryDO theVolumeEntryDO = null;

					int intId = 0;
					try {
						intId = Integer.parseInt(handle);
					}
					catch(NumberFormatException ex) {
						return theEntry;
					}												

            try {
                VolumeEntryQuery query = new VolumeEntryQuery(myVolume.getDbname());
                //set query
                query.setQueryOId(new ObjectId(intId));
                // Throw an exception if more than one message is found
                query.requireUniqueInstance();
                theVolumeEntryDO = query.getNextDO();
                theEntry = new VolumeEntry(myDict, myVolume,theVolumeEntryDO);
                return theEntry;
            } catch(Exception ex) {
				return theEntry;
            }
        }

    /**
        * The findEntryByHandle method performs a database query to
     * return a id object
     *
     * @param id, the object id of the entries table.
     * @return
     *     the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */

	public static VolumeEntry findEntryByEntryId(String volumeName, String id)
        throws PapillonBusinessException {
			Volume volume;
            Dictionary dict;
            try {
                volume = VolumesFactory.findVolumeByName(volumeName);
                dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findEntryByHandle(String volumeName, String id)", ex);
            }
			return findEntryByEntryId(dict, volume, id);
		}
	
 	public static VolumeEntry findEntryByEntryId(Dictionary myDict, Volume myVolume, String id)
        throws PapillonBusinessException {
            VolumeEntry theEntry = null;
            VolumeEntryDO theVolumeEntryDO = null;

            try {
                VolumeEntryQuery query = new VolumeEntryQuery(myVolume.getDbname());
                //set query
                query.setQueryId(id);
                // Throw an exception if more than one message is found
          //      query.requireUniqueInstance();
                theVolumeEntryDO = query.getNextDO();
				if (theVolumeEntryDO != null) {
					theEntry = new VolumeEntry(myDict, myVolume,theVolumeEntryDO);
				}
                return theEntry;
            }catch(Exception ex) {
				return theEntry;
          //      throw new PapillonBusinessException("Exception in findEntryByEntryId()", ex);
            }
        }

    public static void parseVolume (String volumeName, String URL)
        throws PapillonBusinessException {
					Volume volume = VolumesFactory.findVolumeByName(volumeName);
					Dictionary dict = DictionariesFactory.findDictionaryByName(volume.getDictname());
            if (!volume.IsEmpty()) {
                parseVolume(dict, volume,URL);
            }
        }


    public static void parseVolume (Dictionary dict, Volume volume, String URL)
        throws PapillonBusinessException {
        if (volume.getName().equals(ParseVolume.FOKSEDICT_VOLUME)) {
            ParseVolume.parseFoksVolume(URL);
        }
        else
            try {
                // Tools for parsing with a SAX parser
                SAXParserFactory mySAXParserFactory = SAXParserFactory.newInstance();
                //indicate here if you want the parser to be namespace aware or not
                mySAXParserFactory.setNamespaceAware(true);
				// test if this dictionary will be edited.
				// if yes, the content should be validated!
				// FIXME: should be a lot more explicit
				String schema = volume.getXmlSchema();
				String templateEntry = volume.getTemplateEntry();
				if ((schema != null && !schema.equals("")) &&
	            	(templateEntry != null && !templateEntry.equals(""))) {
					PapillonLogger.writeDebugMsg("The XML parser will validate!");
					mySAXParserFactory.setValidating(true);
				}
                //building the constructor of the document
                SAXParser mySAXParser = mySAXParserFactory.newSAXParser();
                VolumeHandler myHandler = new VolumeHandler(dict, volume);

                mySAXParser.parse(URL, myHandler);
				VolumesFactory.setCountEntries(volume);
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in parseVolume(): " + URL, ex);
            }
        }

    public static VolumeEntry newEntry(Dictionary dict, Volume volume, String id, String xmlCode, Vector headwords,  Vector variants, Vector writings, Vector readings, Vector poss, Vector pronunciations, Vector translations, Vector key1s, Vector key2s)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Vector newHeadwords = headwords;
			if (variants != null && variants.size()>0) {
				newHeadwords.addAll(variants);
			}
			if (writings != null && writings.size()>0) {
				newHeadwords.addAll(writings);
            //FIXME: the writing is used only for Japanese, so I put it in the key1 field
            // in order to retrieve it easily for the FOKS lookup
                            if (key1s == null || key1s.size()==0) {
                                key1s = writings;
                            }
                         }

            VolumeEntry newEntry=new VolumeEntry(dict, volume);
            // external id
					if (id != null) {
						id = id.replace(' ', '_');
					}
					newEntry.setId(id);
            //xml code
            newEntry.setXmlCode(xmlCode);
            //headword
            newEntry.setHeadwords(newHeadwords);
            //Key1
            newEntry.setPoss(poss);
            //Key1
            newEntry.setPronunciations(pronunciations);
            //Key1
            newEntry.setReadings(readings);
            //Key2
            newEntry.setTranslations(translations);
            //Key2
            newEntry.setKey1s(key1s);
            //Key2
            newEntry.setKey2s(key2s);
            
            return newEntry;
        }

	public static VolumeEntry newEntryFromExisting(VolumeEntry myEntry) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		VolumeEntry resEntry = null;
		if (myEntry !=null && !myEntry.IsEmpty()) {
			resEntry = newEntry(myEntry.getDictionary(), myEntry.getVolume(), "", "", null, null, null, null, null, null, null ,null ,null);
		}
		return resEntry;
	}

	public static VolumeEntry createAndSaveEntry (Dictionary dict, Volume volume, String id, String xmlCode, Vector headwords,  Vector variants, Vector writings, Vector readings, Vector poss, Vector pronunciations, Vector translations, Vector key1s, Vector key2s)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			VolumeEntry myEntry = newEntry(dict, volume, id, xmlCode, headwords, variants, writings, readings, poss, pronunciations, translations, key1s, key2s);
			if (myEntry.IsEmpty()) {
				myEntry = null;
			}
			else {
				// FIXME: small hack, for the moment only Papillon volume entries must have an id!
				if (dict.getName().equals(PapillonPivotFactory.DICTNAME)) {
					IAnswerFactory.checkAndSetNewId(myEntry);
				}
				myEntry.save();
			}
			return myEntry;
	}

	public static VolumeEntry createEmptyEntry(String volumeName) throws
		PapillonBusinessException {
			VolumeEntry resEntry = null;
			Volume myVolume = VolumesFactory.findVolumeByName(volumeName);

			if ((myVolume != null) && (!myVolume.IsEmpty())) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
				String templateEntry = myVolume.getTemplateEntry();
				resEntry = newEntry(myDict, myVolume, "", templateEntry, null, null, null, null, null, null, null ,null ,null);
			}
			return resEntry;
		}

    public static void emptyVolumeEntries(String volume)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
                ManageDatabase.truncateTable(volume);
				VolumesFactory.resetCountEntries(volume);
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in emptyVolumeEntries with volume: " + volume, e);
            }
        }

	public static void createVolumeTables(Volume volume)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
			// this if is bad code, temporary solution !
			if (!volume.getDbname().equals("papillonaxi")) {
				ManageDatabase.createVolumeTable(volume.getDbname());
			}
				IndexFactory.createIndexTable(volume);
			}
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in createVolumeTables with volume: " + volume.getName(), e);
            }			
		}


	
    public static void dropVolumeTable(Volume volume)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            try {
                //FIXME: this if is bad code, temporary solution !
                if (volume.getName().equals(PapillonPivotFactory.VOLUMENAME)) {
                    ManageDatabase.truncateTable(volume.getDbname());
										VolumesFactory.resetCountEntries(volume.getDbname());
                }
                else {
                    ManageDatabase.dropTable(volume.getDbname());
										VolumesFactory.deleteCountEntries(volume.getDbname());
                }
								IndexFactory.dropIndexTable(volume.getIndexDbname());
            }
            catch (Exception e) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in deleteVolumeTable with volume: " + volume, e);
            }
        }

	public static void setGDEFFrenchTranslations(IAnswer myAnswer, Document myDocument) throws PapillonBusinessException {
		
		Volume myVolume = myAnswer.getVolume();
		if (myVolume.getName().equals(VOLUME_GDEF_est)) {
			myVolume.loadCDMElements();
			if (myVolume.CDM_entry != null && !myVolume.CDM_entry.equals("")) {
				NodeList myNodeList = myDocument.getElementsByTagName(VOLUME_GDEF_est_translation);
				if ((myNodeList != null) && (myNodeList.getLength()>0)) {
					for (int i=0; i<myNodeList.getLength();i++) {
						Element myElement = (Element) myNodeList.item(i);
						String word = Utility.getText(myElement);
						if (word !=null && !word.equals("") && word.indexOf(VOLUME_GDEF_est_prefix)!=0) {
							int lastchar = word.lastIndexOf(VOLUME_GDEF_est_prefix);
							if (lastchar>=0 && word.length()>lastchar) {
								word = word.substring(lastchar+1);
							}
							lastchar = word.lastIndexOf(VOLUME_GDEF_est_sep);
							if (lastchar>=0 && word.length()>lastchar) {
								word = word.substring(lastchar+1);
							}
							String[] Headwords = new String[]{word};
							Hashtable myTable = getVolumeNameEntriesHashtable(VOLUME_GDEF_fra,
												null,
												Headwords,
												IQuery.STRATEGY_EXACT);
							if (myTable.size()==1) {
								IAnswer newAnswer = (IAnswer) myTable.elements().nextElement();
								Utility.setText(myElement,newAnswer.getId());
							}
							else {
								Utility.setText(myElement,VOLUME_GDEF_est_sep + myTable.size() + VOLUME_GDEF_est_sep + word);
							}
						}
					}
				}
			}
		}
	}
	
	
}

