/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.12  2003/11/20 06:40:40  mangeot
 * Tracked down and fixed the following bug: the reading was not saved into the database. The
 * reason is that I forgot to modify all the parts of VolumeEntryDO.java. Next time, be
 * careful or regenerate it with DODS.
 *
 * Revision 1.11  2003/08/23 15:06:43  mangeot
 * *** empty log message ***
 *
 * Revision 1.10  2003/08/23 02:38:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2003/08/23 01:51:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2003/08/14 08:30:11  mangeot
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
 * Revision 1.7.2.7  2003/08/11 07:47:47  mangeot
 * bug correction while loading dicitonry entries
 *
 * Revision 1.7.2.6  2003/08/09 07:21:05  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.7.2.5  2003/08/05 05:18:47  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.2.4  2003/07/31 10:51:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.2.3  2003/06/25 09:54:57  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.2.2  2003/05/08 07:43:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.2.1  2003/02/18 06:07:44  mangeot
 * Information added
 *
 * Revision 1.7  2003/02/16 05:17:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2003/02/15 05:57:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2003/02/15 05:52:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/02/05 06:32:36  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/01/21 09:19:49  mangeot
 * A Few corrections for the HTML rendering
 *
 * Revision 1.2  2002/11/22 13:04:10  mangeot
 * Nouvelle version Papillon enhydra 5.0
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.18  2002/10/25 14:10:29  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.17.2.1  2002/10/24 04:05:55  mangeot
 * *** empty log message ***
 *
 * Revision 1.17  2002/09/17 20:29:33  mangeot
 * Bug corrected, version deploy 1_4 ready !
 *
 * Revision 1.16  2002/09/17 17:13:21  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.15  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.14.4.1  2002/08/09 09:15:13  mangeot
 * Improvements for the simple consultation
 * adding text for help,
 * correcting consultation bugs
 *
 * Revision 1.14  2002/06/08 06:00:01  mangeot
 * VolumeHandler modified to take into account the thai dictionary,
 * headword and pos into attribute values
 *
 * Revision 1.13  2002/05/24 16:29:36  mangeot
 * Adding colspan for entries
 *
 * Revision 1.12  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.11  2002/05/02 07:02:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.10  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.9  2002/04/17 19:18:22  mangeot
 * I deleted the form AdminXml.po and created another one:
 * AddEntries.po
 * Now you can't add entries without a metadata file associated.
 *
 * Revision 1.8  2002/04/16 14:03:34  mangeot
 * A lot of work to upload dictionaries from metadata files and to parse them with
 * a SAX parser.
 *
 * Revision 1.7  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2002/04/14 09:47:12  mangeot
 * lecture des elements CDM ds les fichiers volume-metadata
 * et upload des entrees
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

import java.util.Hashtable;
import java.util.Vector;

//For the volume SAX Parser 
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import fr.imag.clips.papillon.business.utility.*;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

/* 
* used to parse a volume and to put entries into the database
*/

public class VolumeHandler extends DefaultHandler {


// We should load this from elsewhere ...
	String XLINK_URI = "http://www.w3.org/1999/xlink";
	String DML_URI = "http://www.w3.org/1999/xlink";

// We should load the CDM elements from the dictionary description....
// Maybe we should encode a CDM factory ...

	Volume theVolume = null;
	Dictionary theDict = null;

        String volumeName = "";
        String sourceLanguage = "";
        String entryId = "";

// Keys with multiple values
		
		Vector headwords = new Vector();
        Vector variants =  new Vector();
        Vector writings = new Vector();
        Vector readings = new Vector();
        Vector translations = new Vector();
        Vector poss = new Vector();
        Vector pronunciations = new Vector();
        Vector databaseKey1s = new Vector();
        Vector databaseKey2s = new Vector();
		

// Variables added to manage xml namespaces 
        String namespaces = "";

        String xmlCode = "";
        String content = "";
        String previousElement ="";

        int entryCount = 0;

// Variables added to manage axies, it should be generic and not encoded
// directly in the java code ...

        String CDM_axieSemanticCat = "semantic-cat";
        String CDM_axieSynonyms = "axi-synonyms";
        String CDM_axieLanguageLinks = "language-links";
        String CDM_axi = "axi";
        String CDM_axieLanguage = "language";
        String CDM_axieLanguage_attribute = "lang";
        String CDM_reflexie = "reflexie";
        String CDM_refaxie = "refaxie";
        String CDM_href = "href";

        Vector reflexies = new Vector();
        Vector refaxies = new Vector();
        String axieSemanticCat = "";
        Vector axieSynonyms = new Vector();
        String axieLanguage = "";

        Hashtable lexies = new Hashtable();

		public VolumeHandler (Dictionary myDict, Volume myVolume) throws PapillonBusinessException{
			super();
			theVolume = myVolume;
			theDict = myDict;
		}

		public void characters (char buf [], int offset, int len) throws SAXException {
            content = content + new String(buf, offset, len);
        }

        public void endDocument () {
            fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("end parsing volume, " + entryCount + " entries added");
        }
         
        public void endElement (String namespaceURI,String localName, String qName) {
            previousElement = "";
            xmlCode = xmlCode + Utility.encodeXMLEntities(content) + "</" + qName + ">";
            if (qName.equals(theVolume.CDM_entry)) {
// code added for managing axies. It should be generic and not directly encoded here in java.
            if (!sourceLanguage.equals(CDM_axi)) {
                VolumeEntry myEntry = null;
                
                try {
					myEntry = VolumeEntriesFactory.createAndSaveEntry(theDict,
													   theVolume,
													   entryId, xmlCode,
													   headwords, variants,
													   writings,
													   readings, poss,
													   pronunciations,
													   translations,
													   databaseKey1s,
													   databaseKey2s);
                    if (null != myEntry) {
                        PapillonLogger.writeDebugMsg("adding NB:" + Integer.toString(entryCount+1) + "/ID:" +  myEntry.getId() + "/HW:" + myEntry.getHeadword() + "/POS:" + myEntry.getPos() + "/PRON:" + myEntry.getPronunciation() + "/READ:" + myEntry.getReading() + "/TR:" + myEntry.getTranslation() + "/K1:" + myEntry.getKey1()  + "/K2:" + myEntry.getKey2());	
                        entryCount++;
                    } 
                    else {
                        PapillonLogger.writeDebugMsg("Ignoring entry");		
                    }
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                    fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Exception in VolumeEntriesFactory.newEntry: " + entryId);
                }
            }
            else {
// code added for managing axies. It should be generic and not direclt encoded here in java.
            Axie myAxie = null;
                try {
                    myAxie = PapillonPivotFactory.createAndSaveAxie(theDict, theVolume, entryId, xmlCode, axieSemanticCat.trim(), axieSynonyms, lexies);
                    if (null != myAxie) {
						PapillonLogger.writeDebugMsg("adding NB:" + Integer.toString(entryCount+1) + "/ID:" +   myAxie.getId() + " / " + myAxie.getSemanticCat() + " / " + myAxie.getSynonyms() + " / " + myAxie.getLexies().toString());
						entryCount++;
                    } 
                    else {
                        PapillonLogger.writeDebugMsg("Ignoring axie");		
                    }
                }
                catch(Exception ex) {
                    fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Exception in VolumeHandler.newAxie: " + entryId);
                }
            }
            }

            // Keys with multiple values
            if (qName.equals(theVolume.CDM_headword)) {
                if (null == theVolume.CDM_headword_attribute
                    || theVolume.CDM_headword_attribute.equals("")) {
					headwords.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_headwordVariant)) {
                if (null == theVolume.CDM_headwordVariant_attribute
                    || theVolume.CDM_headwordVariant_attribute.equals("")) {
					variants.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_reading)) {
                if (null == theVolume.CDM_reading_attribute
                    || theVolume.CDM_reading_attribute.equals("")) {
					readings.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_writing)) {
                if (null == theVolume.CDM_writing_attribute
                    || theVolume.CDM_writing_attribute.equals("")) {
					writings.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_translation)) {
                if (null == theVolume.CDM_translation_attribute
                    || theVolume.CDM_translation_attribute.equals("")) {
					translations.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_pos)) {
                if (null == theVolume.CDM_pos_attribute
                    || theVolume.CDM_pos_attribute.equals("")) {
					poss.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_pronunciation)) {
                if (null == theVolume.CDM_pronunciation_attribute
                    || theVolume.CDM_pronunciation_attribute.equals("")) {
					pronunciations.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_databaseKey1)) {
                if (null == theVolume.CDM_databaseKey1_attribute
                    || theVolume.CDM_databaseKey1_attribute.equals("")) {
					databaseKey1s.add(content.trim());
                }
            }
            if (qName.equals(theVolume.CDM_databaseKey2)) {
                if (null == theVolume.CDM_databaseKey2_attribute
                    || theVolume.CDM_databaseKey2_attribute.equals("")) {
					databaseKey2s.add(content.trim());
                }
            }
            // Keys with unique values
            if (qName.equals(theVolume.CDM_entryId)) {
                if (null == theVolume.CDM_entryId_attribute 
                || theVolume.CDM_entryId_attribute.equals("")) {
                entryId = content.trim();
                }
            }
           // Code added to encode axies. It should be generic and not directly encoded in java.
             if (qName.equals(CDM_axieSemanticCat)) {
                axieSemanticCat = content.trim();
            }
             if (qName.equals(CDM_axieSynonyms)) {
                axieSynonyms = refaxies;		
                refaxies.clear();
            }
            if (qName.equals(CDM_axieLanguageLinks)) {
               reflexies.clear();
            }
            if (qName.equals(CDM_axieLanguage)) {
				lexies.put(axieLanguage,reflexies.clone());
                reflexies.clear();
            }
			// be careful to reset the content at the end of the function.. 
            content = "";
        }

        public void startDocument () {
            try {
                theVolume.loadCDMElements();
                sourceLanguage = theVolume.getSourceLanguage();
                volumeName = theVolume.getName();
            }
            catch (Exception ex) {
                fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Exception in Volume.loadCDMElements " + ex);
            }
             fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Start parsing the volume " + volumeName);
        }	
         
        public void startElement (String namespaceURI,String localName, String qName, Attributes attrs) {
            xmlCode = xmlCode + Utility.encodeXMLEntities(content);
            String element = "<" + qName;
            
            for (int i=0; i< attrs.getLength();i++) {
// The code is uggly, need to clean it !
// We should write a table with the pb chars
                String attribute = attrs.getValue(i);

                attribute = Utility.encodeXMLEntities(attribute);

                element = element + " " + attrs.getQName(i) + "='" + attribute + "'";
            }

            // Store the previous strings
            if (!previousElement.equals("")) {
            if (previousElement.equals(theVolume.CDM_headword)	&&
                (theVolume.CDM_headword_attribute == null ||
                 theVolume.CDM_headword_attribute.equals(""))) {
				headwords.add(content.trim());
            }
            if (previousElement.equals(theVolume.CDM_headwordVariant) &&
                (theVolume.CDM_headwordVariant_attribute == null ||
                 theVolume.CDM_headwordVariant_attribute.equals(""))) {
                variants.add(content.trim());
            }
			if 	(previousElement.equals(theVolume.CDM_writing) &&
		         (theVolume.CDM_writing_attribute == null ||
	              theVolume.CDM_writing_attribute.equals(""))) {
					writings.add(content.trim());
				}
				if 	(previousElement.equals(theVolume.CDM_reading) &&
		 (theVolume.CDM_reading_attribute == null ||
	theVolume.CDM_reading_attribute.equals(""))) {
					readings.add(content.trim());
				}
				if 	(previousElement.equals(theVolume.CDM_translation) &&
                 (theVolume.CDM_translation_attribute == null ||
                  theVolume.CDM_translation_attribute.equals(""))) {
                translations.add(content.trim());
            }
            if 	(previousElement.equals(theVolume.CDM_pos) &&
                 (theVolume.CDM_pos_attribute == null ||
                  theVolume.CDM_pos_attribute.equals(""))) {
                poss.add(content.trim());
            }
            if 	(previousElement.equals(theVolume.CDM_pronunciation) &&
                 (theVolume.CDM_pronunciation_attribute == null ||
                  theVolume.CDM_pronunciation_attribute.equals(""))) {
                pronunciations.add(content.trim());
            }
            if 	(previousElement.equals(theVolume.CDM_entryId) &&
                 (theVolume.CDM_entryId_attribute == null ||
                  theVolume.CDM_entryId_attribute.equals(""))) {
                entryId = content.trim();
            }
            if 	(previousElement.equals(theVolume.CDM_databaseKey1) &&
                 (theVolume.CDM_databaseKey1_attribute == null ||
                  theVolume.CDM_databaseKey1_attribute.equals(""))) {
                databaseKey1s.add(content.trim());
            }
            if 	(previousElement.equals(theVolume.CDM_databaseKey2) &&
                 (theVolume.CDM_databaseKey2_attribute == null ||
                  theVolume.CDM_databaseKey2_attribute.equals(""))) {
                databaseKey2s.add(content.trim());
            }
            }

            // empty the buffer
            content = "";
            
            // recuperate attribute values
            if (qName.equals(theVolume.CDM_entry)) {
            // I add the volume xml namespaces to all the entries
                xmlCode = element + namespaces + ">";

                headwords.clear();
                variants.clear();
                writings.clear();
                readings.clear();
                translations.clear();
                poss.clear();
                pronunciations.clear();
                entryId = "";
                databaseKey1s.clear();
                databaseKey2s.clear();

                
// code added to deal with axies. It should be generic and not encoded directly in java.
				lexies.clear();
                reflexies.clear();
                refaxies.clear();
                axieSemanticCat = "";
                axieSynonyms.clear();
				axieLanguage = "";
            }
            else {
                xmlCode = xmlCode + element + ">";
            }
            // Keys with multiple values
            if (qName.equals(theVolume.CDM_headword)) {
                if (null != theVolume.CDM_headword_attribute &&
                    !theVolume.CDM_headword_attribute.equals("")) {
                    headwords.add(attrs.getValue(theVolume.CDM_headword_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_headwordVariant)) {
                if (null != theVolume.CDM_headwordVariant_attribute &&
                    !theVolume.CDM_headwordVariant_attribute.equals("")) {
                    variants.add(attrs.getValue(theVolume.CDM_headwordVariant_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_reading)) {
                if (null != theVolume.CDM_reading_attribute &&
                    !theVolume.CDM_reading_attribute.equals("")) {
					readings.add(attrs.getValue(theVolume.CDM_reading_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_writing)) {
                if (null != theVolume.CDM_writing_attribute &&
                    !theVolume.CDM_writing_attribute.equals("")) {
					writings.add(attrs.getValue(theVolume.CDM_writing_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_translation)) {
                if (null != theVolume.CDM_translation_attribute &&
                    !theVolume.CDM_translation_attribute.equals("")) {
                    translations.add(attrs.getValue(theVolume.CDM_translation_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_pos)) {
                if (null != theVolume.CDM_pos_attribute &&
                    !theVolume.CDM_pos_attribute.equals("")) {
                    poss.add(attrs.getValue(theVolume.CDM_pos_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_pronunciation)) {
                if (null != theVolume.CDM_pronunciation_attribute &&
                    !theVolume.CDM_pronunciation_attribute.equals("")) {
                    pronunciations.add(attrs.getValue(theVolume.CDM_pronunciation_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_databaseKey1)) {
                if (null != theVolume.CDM_databaseKey1_attribute &&
                    !theVolume.CDM_databaseKey1_attribute.equals("")) {
                    databaseKey1s.add(attrs.getValue(theVolume.CDM_databaseKey1_attribute));
                }
            }
            if (qName.equals(theVolume.CDM_databaseKey2)) {
                if (null != theVolume.CDM_databaseKey2_attribute &&
                    !theVolume.CDM_databaseKey2_attribute.equals("")) {
                    databaseKey2s.add(attrs.getValue(theVolume.CDM_databaseKey2_attribute));
                }
            }
            // Keys with unique value
            if (qName.equals(theVolume.CDM_entryId)) {
                entryId = "";
                if (null != theVolume.CDM_entryId_attribute &&
                    !theVolume.CDM_entryId_attribute.equals("")) {
                    if (null != theVolume.CDM_entryId_attribute_ns &&
                        !theVolume.CDM_entryId_attribute_ns.equals("")) {
                        entryId = attrs.getValue(theVolume.CDM_entryId_attribute_ns, theVolume.CDM_entryId_attribute);
                    }
                    else {
                        entryId = attrs.getValue(theVolume.CDM_entryId_attribute);
                    }
                }
            }

// code added to manage axies,it should be generic, etc...
            if (qName.equals(CDM_axieSynonyms)) {
				refaxies.clear();
            }
            if (qName.equals(CDM_axieLanguage)) {
				axieLanguage = attrs.getValue(theVolume.CDM_entryId_attribute_ns,CDM_axieLanguage_attribute);
				reflexies.clear();
            }
            if (qName.equals(CDM_axieLanguageLinks)) {
				reflexies.clear();
            }
            if (qName.equals(CDM_reflexie)) {
             reflexies.add(attrs.getValue(XLINK_URI, CDM_href));         
            }
            if (qName.equals(CDM_refaxie)) {
             refaxies.add(attrs.getValue(XLINK_URI, CDM_href));
            }

            previousElement = qName;
        }
        
        public void startPrefixMapping(String prefix, String uri) {
        namespaces = namespaces + " xmlns";
        if (!prefix.equals("")) {
         namespaces = namespaces + ":" + prefix;
         }
         namespaces = namespaces + "='" + uri + "'";
        }
        
	public void fatalError(SAXParseException e) {
	    PapillonLogger.writeDebugMsg("Fatal XML Parsing Error");
	}        
    }
