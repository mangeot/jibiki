/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
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
