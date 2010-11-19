/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id: GetXmlDocument.java 700 2006-09-10 09:18:25Z mangeot $
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.1.2.1  2006/09/10 09:18:25  mangeot
 *  Resoures modified and added for playing with authentic xml plugin
 *
 *  Revision 1.7  2006/07/15 08:55:14  mangeot
 *  The BrowseVolumePage opens an HTML form that is used to lookup a volume in alphabetical order.
 *  The BrowseVolume is the server side of the AJAX script for retrieving the entries in alphabetical order
 *
 *  Revision 1.6  2006/02/27 00:04:01  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.5  2006/02/26 22:05:02  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.4  2006/02/26 20:24:30  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.3  2006/02/26 19:58:18  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.2  2006/02/26 19:21:38  mangeot
 *  Work on BrowseVolume
 *
 *  Revision 1.1  2006/02/26 14:09:32  mangeot
 *  *** empty log message ***
 *
 *
 *  -----------------------------------------------
 *  beta version
 */
package fr.imag.clips.papillon.presentation.api;

import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.Index;
import fr.imag.clips.papillon.business.dictionary.IndexFactory;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.user.UsersFactory;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;

import fr.imag.clips.papillon.business.xml.XMLServices;

/**
*  Description of the Class
 *
 * @author     mangeot
 * @created    February 24, 2006
 */
public class Entries extends fr.imag.clips.papillon.presentation.XmlBasePO {
	
	protected static final String DICTIONARY_PARAMETER = "DICTIONARY";
	protected static final String LANG_PARAMETER = "LANG";
	protected static final String ID_PARAMETER = "ID";
	
	protected static final String ENTRIES_HEAD_XMLSTRING = "<?xml version='1.0' encoding='UTF-8'?><entry-list xmlns='http://www-clips.imag.fr/geta/services/dml'>";
	protected static final String ENTRIES_TAIL_XMLSTRING ="\n</entry-list>";
	
    	
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return false;
    }
    
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean userMayUseThisPO() {
        return true;
    }
	
    /**
        *  Returns the complete document.
     *
     * @exception  Exception
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  IOException                Description of the Exception
     */
    public org.w3c.dom.Document getContent()
        throws HttpPresentationException, java.io.IOException, Exception {
			
			
			String dictName = myGetParameter(DICTIONARY_PARAMETER);
			String lang = myGetParameter(LANG_PARAMETER);
			String entryId = myGetParameter(ID_PARAMETER);
		
			return getEntry(dictName, lang, entryId);			
        }
	
	public static org.w3c.dom.Document getEntry(String dictName, String lang, String entryId) 
	throws HttpPresentationException, java.io.IOException, Exception {

		Volume theVolume = null;
		org.w3c.dom.Document resultDoc = null;
		
		java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
		
		if (volumesCollection !=null && volumesCollection.size()>0) {
			theVolume = (Volume) volumesCollection.iterator().next();
			PapillonLogger.writeDebugMsg("Entries: id: " + entryId + " volume: " + theVolume.getName());
			VolumeEntry myEntry = VolumeEntriesFactory.findEntryByContributionId(theVolume.getName(), entryId);
			if (myEntry != null && !myEntry.isEmpty()) {
				PapillonLogger.writeDebugMsg("Entry: headword: " + myEntry.getHeadword());
				resultDoc = myEntry.getDom();
			}
			else {
				PapillonLogger.writeDebugMsg("Entry null: " + entryId);
			}
		}
		return resultDoc;			
	}

	public static org.w3c.dom.Document getEntries(String dictName, String lang, String criteria, String word, String key, String strategy, String limitString, String offsetString) 
	throws HttpPresentationException, java.io.IOException, Exception {
		int limit = 40;
		if (limitString!=null) {
			limit = Integer.parseInt(limitString);
		}
		int offset = 0;
		if (offsetString!=null) {
			offset = Integer.parseInt(offsetString);
		}
		if (dictName.equals("*")) {
			dictName=null;
		}
		if (lang.equals("*")) {
			lang=null;
		}
		Volume theVolume = null;
		org.w3c.dom.Document resultDoc = null;
		strategy = getStrategy(strategy);
		if (criteria !=null && criteria.equals("handle")) {
			if (key==null) {
				java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
				if (volumesCollection !=null && volumesCollection.size()>0) {
					java.util.Iterator iterator = volumesCollection.iterator();
					while (resultDoc==null && iterator.hasNext()) {
						theVolume = (Volume) iterator.next();
						PapillonLogger.writeDebugMsg("Entries: id: " + word + " volume: " + theVolume.getName());
						VolumeEntry myEntry = VolumeEntriesFactory.findEntryByHandle(theVolume.getName(), word);
						if (myEntry != null && !myEntry.isEmpty()) {
							PapillonLogger.writeDebugMsg("Entry: headword: " + myEntry.getHeadword());
							resultDoc = myEntry.getDom();
						}
						else {
							PapillonLogger.writeDebugMsg("Entry null: " + word);
						}
					}
				}
			}
		}
		else if (criteria !=null && criteria.equals("previous")) {
			if (key==null) {
				java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
				if (volumesCollection !=null && volumesCollection.size()>0) {
					java.util.Iterator iterator = volumesCollection.iterator();
					while (resultDoc==null && iterator.hasNext()) {
						theVolume = (Volume) iterator.next();
						PapillonLogger.writeDebugMsg("Entries: id: " + word + " volume: " + theVolume.getName());
						VolumeEntry myEntry = VolumeEntriesFactory.findPreviousEntryByHeadword(theVolume.getName(), word);
						if (myEntry != null && !myEntry.isEmpty()) {
							PapillonLogger.writeDebugMsg("Entry: headword: " + myEntry.getHeadword());
							resultDoc = myEntry.getDom();
						}
						else {
							PapillonLogger.writeDebugMsg("Entry null: " + word);
						}
					}
				}
			}
		}
		else if (criteria !=null && criteria.equals("next")) {
			if (key==null) {
				java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
				if (volumesCollection !=null && volumesCollection.size()>0) {
					java.util.Iterator iterator = volumesCollection.iterator();
					while (resultDoc==null && iterator.hasNext()) {
						theVolume = (Volume) iterator.next();
						PapillonLogger.writeDebugMsg("Entries: id: " + word + " volume: " + theVolume.getName());
						VolumeEntry myEntry = VolumeEntriesFactory.findNextEntryByHeadword(theVolume.getName(), word);
						if (myEntry != null && !myEntry.isEmpty()) {
							PapillonLogger.writeDebugMsg("Entry: headword: " + myEntry.getHeadword());
							resultDoc = myEntry.getDom();
						}
						else {
							PapillonLogger.writeDebugMsg("Entry null: " + word);
						}
					}
				}
			}
		}
		else if (criteria !=null && criteria.equals("pivax")) {
			java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
			if (volumesCollection !=null && volumesCollection.size()>0) {
				resultDoc = getPivaxEntries((Volume)volumesCollection.iterator().next(), word, strategy, limit);
			}
		}
		else if (criteria !=null) {
			if (criteria.equals("headword")) {
				criteria=Volume.CDM_headword;
			}
			java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
		
		if (volumesCollection !=null && volumesCollection.size()>0) {
			StringBuffer allEntries = new StringBuffer(120 * (limit+1) * volumesCollection.size());	
			allEntries.append(ENTRIES_HEAD_XMLSTRING);
			for (java.util.Iterator iterator = volumesCollection.iterator(); iterator.hasNext(); ) {
				theVolume = (Volume) iterator.next();
				PapillonLogger.writeDebugMsg("Entries: volume: " + theVolume.getName());
				String sourceLang = theVolume.getSourceLanguage();
				String entryString = "\n<entry lang='"+sourceLang+"' dictionary='"+theVolume.getDictname()+"'><criteria value='"+criteria+"'>"; 
				String langCriteria = null;
				if (Volume.isSourceLangCDMElement(criteria)) {
					langCriteria = sourceLang;
				}
				else if (Volume.isDefaultLangCDMElement(criteria)) {
					langCriteria=Volume.DEFAULT_LANG;
				}
				java.util.Vector myKeys = new java.util.Vector();
				String[] Word = new String[4];
				Word[0] = criteria;
				Word[1] = langCriteria;
				Word[2] = word;
				Word[3] = strategy;
				myKeys.add(Word);
				java.util.Vector resultsVector = IndexFactory.getIndexEntriesVector(theVolume.getIndexDbname(),
																					myKeys,
																					IndexFactory.ORDER_DESCENDING,
																					limit,
																					offset);
				for (int i=0; i<resultsVector.size(); i++) {
					Index myEntry = (Index) resultsVector.elementAt(i);
					allEntries.append(entryString);
					allEntries.append(myEntry.getValue());
					allEntries.append("</criteria>");
					if (key !=null) {
						allEntries.append(getIndexValues(theVolume,""+myEntry.getEntryId(),key));
					}
					allEntries.append("<handle>");
					allEntries.append(myEntry.getEntryId());
					allEntries.append("</handle></entry>");
				}
			}
			allEntries.append(ENTRIES_TAIL_XMLSTRING);
			resultDoc = XMLServices.buildDOMTree(allEntries.toString());
		}
		else {
			System.out.println("Error message no corresponding dict: " + dictName + " & lang: " + lang);
		}
		}
		else {
			resultDoc = getIndexValue(dictName, lang, word, key);
		}
		return resultDoc;			
	}

	protected static org.w3c.dom.Document getIndexValue(String dictName, String lang, String handle, String key) 
	throws HttpPresentationException, java.io.IOException, Exception {
		int limit=1;
		if (dictName.equals("*")) {
			dictName=null;
		}
		if (lang.equals("*")) {
			lang=null;
		}
		Volume theVolume = null;
		org.w3c.dom.Document resultDoc = null;
			java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
			
			if (volumesCollection !=null && volumesCollection.size()>0) {
				StringBuffer allEntries = new StringBuffer(160 * (limit+1) * volumesCollection.size());	
				allEntries.append(ENTRIES_HEAD_XMLSTRING);
				for (java.util.Iterator iterator = volumesCollection.iterator(); iterator.hasNext(); ) {
					theVolume = (Volume) iterator.next();
					PapillonLogger.writeDebugMsg("Entries: volume: " + theVolume.getName());
					allEntries.append("\n<entry lang='");
					allEntries.append(theVolume.getSourceLanguage());
					allEntries.append("' dictionary='");
					allEntries.append(theVolume.getDictname());
					allEntries.append("'><handle>");
					allEntries.append(handle);
					allEntries.append("</handle>");
					allEntries.append(getIndexValues(theVolume, handle, key));
					allEntries.append("</entry>");
				}
				allEntries.append(ENTRIES_TAIL_XMLSTRING);
				resultDoc = XMLServices.buildDOMTree(allEntries.toString());
			}
			else {
				System.out.println("Error message no corresponding dict: " + dictName + " & lang: " + lang);
			}
		return resultDoc;			
	}
	
	protected static String getIndexValues(Volume theVolume, String handle, String key) 
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		String sourceLang = theVolume.getSourceLanguage();
		if (key.equals("*")) {
			key=null;
		}
		java.util.Vector resultsVector = IndexFactory.getIndexVectorByEntryId(theVolume, handle);
		StringBuffer allIndexes = new StringBuffer(160 * (resultsVector.size()+1));	
		for (int i=0; i<resultsVector.size(); i++) {
			Index myEntry = (Index) resultsVector.elementAt(i);
			if (key ==null || (key !=null && myEntry.getKey().equals(key))) {
				allIndexes.append("<key value='");
				allIndexes.append(myEntry.getKey());
				allIndexes.append("'");
				if (myEntry.getLang()!=null && 
					!myEntry.getLang().equals(sourceLang) && 
					!myEntry.getLang().equals(Volume.DEFAULT_LANG)
					) {
					allIndexes.append(" lang='");
					allIndexes.append(myEntry.getLang());
					allIndexes.append("'");
				}
				allIndexes.append(">");
				allIndexes.append(myEntry.getValue());
				allIndexes.append("</key>");
			}
		}
		return allIndexes.toString();
	}
	
	public static boolean userCanPutEntry(String login, String password) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		boolean answer = false;
		if (null != login && !login.equals("") &&
			null != password && !password.equals("")) {
			User myUser = UsersFactory.findUserByLogin(login);
			if (null != myUser && !myUser.isEmpty() && (myUser.isAdmin() || myUser.isValidator() || myUser.isSpecialist())) {
				answer=true;
			}
		}
		return answer;
	}
	
	public static org.w3c.dom.Document putEntry(String dictName, String lang, String entryId, String docXml) 
	throws HttpPresentationException, java.io.IOException, Exception {
		
		Volume theVolume = null;
		org.w3c.dom.Document resultDoc = null;
		
		java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
		
		if (volumesCollection !=null && volumesCollection.size()>0) {
			theVolume = (Volume) volumesCollection.iterator().next();
			PapillonLogger.writeDebugMsg("Entry: id: " + entryId + " volume: " + theVolume.getName());
			VolumeEntry myEntry = VolumeEntriesFactory.findEntryByContributionId(theVolume.getName(), entryId);
			if (myEntry != null && !myEntry.isEmpty()) {
				PapillonLogger.writeDebugMsg("Entry: headword: " + myEntry.getHeadword());
				PapillonLogger.writeDebugMsg("Entry: docXML: [" + docXml + "]");
				org.w3c.dom.Document docDom = XMLServices.buildDOMTree(docXml);
				if (docDom != null) {
					myEntry.setDom(docDom);
					myEntry.save();
				}
				resultDoc = myEntry.getDom();
			}
			else {
				PapillonLogger.writeDebugMsg("Entry null: " + entryId);
			}
		}
		return resultDoc;			
	}
	
	public static boolean userCanPostEntry(String login, String password) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		boolean answer = false;
		if (null != login && !login.equals("") &&
			null != password && !password.equals("")) {
			User myUser = UsersFactory.findUserByLogin(login);
			if (null != myUser && !myUser.isEmpty() && (myUser.isAdmin() || myUser.isValidator())) {
				answer=true;
			}
		}
		return answer;
	}

	public static org.w3c.dom.Document postEntry(String dictName, String lang,  String headword, String docXml) 
	throws HttpPresentationException, java.io.IOException, Exception {
		
		Dictionary theDict = null;
		Volume theVolume = null;
		org.w3c.dom.Document resultDoc = null;
		

		theDict = DictionariesFactory.getDictionaryByName(dictName);
		if (theDict !=null) {
			java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
			if (volumesCollection !=null && volumesCollection.size()>0) {
				theVolume = (Volume) volumesCollection.iterator().next();
				PapillonLogger.writeDebugMsg("Entries: headword: " + headword + " volume: " + theVolume.getName());
				org.w3c.dom.Document docDom = XMLServices.buildDOMTree(docXml);
				if (docDom!=null) {
					VolumeEntry newEntry = new VolumeEntry(theDict, theVolume); 
					newEntry.setDom(docDom);
					newEntry.setAuthor();
					newEntry.setCreationDate();
					newEntry.setHeadword();
					newEntry.save();
					resultDoc = newEntry.getDom();
				}
			}
		}
		return resultDoc;			
	}
	
	public static boolean userCanDeleteEntry(String login, String password) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		boolean answer = false;
		if (null != login && !login.equals("") &&
			null != password && !password.equals("")) {
			User myUser = UsersFactory.findUserByLogin(login);
			if (null != myUser && !myUser.isEmpty() && (myUser.isAdmin())) {
				answer=true;
			}
		}
		return answer;
	}
	
	public static org.w3c.dom.Document deleteEntry(String dictName, String lang, String entryId) 
	throws HttpPresentationException, java.io.IOException, Exception {
		
		Volume theVolume = null;
		org.w3c.dom.Document resultDoc = null;
		
		java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
		
		if (volumesCollection !=null && volumesCollection.size()>0) {
			theVolume = (Volume) volumesCollection.iterator().next();
			PapillonLogger.writeDebugMsg("Entries: id: " + entryId + " volume: " + theVolume.getName());
			VolumeEntry myEntry = VolumeEntriesFactory.findEntryByContributionId(theVolume.getName(), entryId);
			if (myEntry != null && !myEntry.isEmpty()) {
				PapillonLogger.writeDebugMsg("Entry: headword: " + myEntry.getHeadword());
				myEntry.delete();
				resultDoc = myEntry.getDom();
			}
			else {
				PapillonLogger.writeDebugMsg("Entry null: " + entryId);
			}
		}
		return resultDoc;			
	}
	
	public static String getStrategy(String strategy) {
		String result = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
		if (strategy !=null) {
			if (strategy.equals("EQUAL")) {
				result = QueryBuilder.EQUAL;
			}
			if (strategy.equals("CASE_SENSITIVE_STARTS_WITH")) {
				result = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
			}
			if (strategy.equals("CASE_SENSITIVE_ENDS_WITH")) {
				result = QueryBuilder.CASE_SENSITIVE_ENDS_WITH;
			}
			if (strategy.equals("CASE_SENSITIVE_CONTAINS")) {
				result = QueryBuilder.CASE_SENSITIVE_CONTAINS;
			}
			if (strategy.equals("CASE_INSENSITIVE_EQUAL")) {
				result = QueryBuilder.CASE_INSENSITIVE_EQUAL;
			}
			if (strategy.equals("CASE_INSENSITIVE_STARTS_WITH")) {
				result = QueryBuilder.CASE_INSENSITIVE_STARTS_WITH;
			}
			if (strategy.equals("CASE_INSENSITIVE_ENDS_WITH")) {
				result = QueryBuilder.CASE_INSENSITIVE_ENDS_WITH;
			}
			if (strategy.equals("CASE_INSENSITIVE_CONTAINS")) {
				result = QueryBuilder.CASE_INSENSITIVE_CONTAINS;
			}
			if (strategy.equals("NOT_EQUAL")) {
				result = QueryBuilder.NOT_EQUAL;
			}
			if (strategy.equals("GREATER_THAN")) {
				result = QueryBuilder.GREATER_THAN;
			}
			if (strategy.equals("GREATER_THAN_OR_EQUAL")) {
				result = QueryBuilder.GREATER_THAN_OR_EQUAL;
			}
			if (strategy.equals("LESS_THAN")) {
				result = QueryBuilder.LESS_THAN;
			}
			if (strategy.equals("LESS_THAN_OR_EQUAL")) {
				result = QueryBuilder.LESS_THAN_OR_EQUAL;
			}			
		}
		return result;
	}
	
	
	protected static org.w3c.dom.Document getPivaxEntries(Volume lexieVolume, String word, String strategy, int limit) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		org.w3c.dom.Document resultDoc = null;
		PapillonLogger.writeDebugMsg("Pivax entries: volume: " + lexieVolume.getName() + " word: " + word);
		String dictName = lexieVolume.getDictname();
		String sourceLang = lexieVolume.getSourceLanguage();
		String axemeLang = sourceLang.toUpperCase();
		String axiLang = "axi";
		String unlAxemeLang = "UNL";
		java.util.Vector myKeys = new java.util.Vector();
		String[] Word = new String[4];
		Word[0] = Volume.CDM_headword;
		Word[1] = sourceLang;
		Word[2] = word;
		Word[3] = strategy;
		myKeys.add(Word);
		java.util.Vector lexiesVector = IndexFactory.getIndexEntriesVector(lexieVolume.getIndexDbname(),
																			myKeys,
																			IndexFactory.ORDER_DESCENDING,
																			limit,
																			0);
		for (int i=0; i<lexiesVector.size(); i++) {
			Index lexieEntry = (Index) lexiesVector.elementAt(i);
			PapillonLogger.writeDebugMsg("Pivax entries: volume lexies: " + lexieVolume.getName() + " word: " + lexieEntry.getEntryId());
			java.util.Vector lexiesResultVector = IndexFactory.getIndexVectorByEntryId(lexieVolume, ""+ lexieEntry.getEntryId());
			for (int p=0; p<lexiesResultVector.size(); p++) {
				Index lexieResultEntry = (Index) lexiesResultVector.elementAt(p);
				if (lexieResultEntry.getKey().equals(Volume.CDM_entryId)) {
			java.util.Collection axemesVolumesCollection = VolumesFactory.getVolumesArray(dictName,axemeLang,null);
			if (axemesVolumesCollection !=null && axemesVolumesCollection.size()>0) {
				Volume axemeVolume = ((Volume)axemesVolumesCollection.iterator().next());
				PapillonLogger.writeDebugMsg("Pivax entries: volume axemes: " + axemeVolume.getName() + " word: " + lexieResultEntry.getValue());
				myKeys = new java.util.Vector();
				Word = new String[4];
				Word[0] = Volume.CDM_translationReflexie;
				Word[1] = axemeLang;
				Word[2] = lexieResultEntry.getValue();
				Word[3] = QueryBuilder.EQUAL;
				myKeys.add(Word);
				java.util.Vector axemesVector = IndexFactory.getIndexEntriesVector(axemeVolume.getIndexDbname(),
																					myKeys,
																					IndexFactory.ORDER_DESCENDING,
																					1,
																					0);
				for (int j=0; j<axemesVector.size(); j++) {
					Index axemeEntry = (Index) axemesVector.elementAt(j);
					PapillonLogger.writeDebugMsg("Pivax entries: volume axemes: " + axemeVolume.getName() + " word: " + axemeEntry.getEntryId());
					java.util.Vector axemesResultVector = IndexFactory.getIndexVectorByEntryId(axemeVolume, ""+ axemeEntry.getEntryId());
					for (int q=0; q<axemesResultVector.size(); q++) {
						Index axemeResultEntry = (Index) axemesResultVector.elementAt(q);
						if (axemeResultEntry.getKey().equals(Volume.CDM_entryId)) {
					java.util.Collection axiesVolumesCollection = VolumesFactory.getVolumesArray(dictName,axiLang,null);
					if (axiesVolumesCollection !=null && axiesVolumesCollection.size()>0) {
						Volume axieVolume = ((Volume)axiesVolumesCollection.iterator().next());
						PapillonLogger.writeDebugMsg("Pivax entries: volume axie: " + axieVolume.getName() + " word: " + axemeResultEntry.getValue());
						myKeys = new java.util.Vector();
						Word = new String[4];
						Word[0] = Volume.CDM_translationReflexie;
						Word[1] = axemeLang;
						Word[2] = axemeResultEntry.getValue();
						Word[3] = QueryBuilder.EQUAL;
						myKeys.add(Word);
						java.util.Vector axiesVector = IndexFactory.getIndexEntriesVector(axieVolume.getIndexDbname(),
																						   myKeys,
																						   IndexFactory.ORDER_DESCENDING,
																						   1,
																						   0);
						for (int k=0; k<axiesVector.size(); k++) {
							Index axieEntry = (Index) axiesVector.elementAt(k);
							java.util.Vector axiesResultVector = IndexFactory.getIndexVectorByEntryId(axieVolume, ""+ axieEntry.getEntryId());
							for (int l=0; l<axiesResultVector.size(); l++) {
								Index axieResultEntry = (Index) axiesResultVector.elementAt(l);
								if (axieResultEntry.getKey().equals(Volume.CDM_translationReflexie) && axieResultEntry.getLang().equals(unlAxemeLang)) {
									java.util.Collection unlAxemesVolumesCollection = VolumesFactory.getVolumesArray(dictName,unlAxemeLang,null);
									if (unlAxemesVolumesCollection !=null && unlAxemesVolumesCollection.size()>0) {
										Volume unlAxemeVolume = ((Volume)unlAxemesVolumesCollection.iterator().next());
										PapillonLogger.writeDebugMsg("Pivax entries: volume unl axeme: " + unlAxemeVolume.getName() + " word: " + axieResultEntry.getValue());
										myKeys = new java.util.Vector();
										Word = new String[4];
										Word[0] = Volume.CDM_entryId;
										Word[1] = Volume.DEFAULT_LANG;
										Word[2] = axieResultEntry.getValue();
										Word[3] = QueryBuilder.EQUAL;
										myKeys.add(Word);
										java.util.Vector unlAxemesVector = IndexFactory.getIndexEntriesVector(unlAxemeVolume.getIndexDbname(),
																										  myKeys,
																										  IndexFactory.ORDER_DESCENDING,
																										  1,
																										  0);
										for (int m=0; m<unlAxemesVector.size(); m++) {
											Index unlAxemeEntry = (Index) unlAxemesVector.elementAt(m);
											java.util.Vector unlAxemesResultVector = IndexFactory.getIndexVectorByEntryId(unlAxemeVolume, ""+unlAxemeEntry.getEntryId());
											PapillonLogger.writeDebugMsg("Pivax entries: volume unl axeme: " + unlAxemeVolume.getName() + " word: " + unlAxemeEntry.getEntryId());
											for (int n=0; n<unlAxemesResultVector.size(); n++) {
												Index unlAxemeResultEntry = (Index) unlAxemesResultVector.elementAt(n);
												if (unlAxemeResultEntry.getKey().equals(Volume.CDM_translationReflexie) && unlAxemeResultEntry.getLang().equals(unlAxemeLang)) {
													String unlLang = "unl";
													java.util.Collection unlVolumesCollection = VolumesFactory.getVolumesArray(dictName,unlLang,null);
													if (unlVolumesCollection !=null && unlVolumesCollection.size()>0) {
														Volume unlVolume = ((Volume)unlVolumesCollection.iterator().next());
														PapillonLogger.writeDebugMsg("Pivax entries: volume unl: " + unlVolume.getName() + " word: " + unlAxemeResultEntry.getValue());
														myKeys = new java.util.Vector();
														Word = new String[4];
														Word[0] = Volume.CDM_entryId;
														Word[1] = unlLang;
														Word[2] = unlAxemeResultEntry.getValue();
														Word[3] = QueryBuilder.EQUAL;
														myKeys.add(Word);
														java.util.Vector unlLexiesVector = IndexFactory.getIndexEntriesVector(unlVolume.getIndexDbname(),
																															  myKeys,
																															  IndexFactory.ORDER_DESCENDING,
																															  1,
																															  0);
														for (int o=0; i<unlLexiesVector.size(); o++) {
															Index unlIndexEntry = (Index) unlLexiesVector.elementAt(o);
															VolumeEntry unlEntry = VolumeEntriesFactory.findEntryByHandle(unlVolume.getName(), ""+unlIndexEntry.getEntryId());
															if (unlEntry != null && !unlEntry.isEmpty()) {
																PapillonLogger.writeDebugMsg("Pivax entries: Entry: headword: " + unlEntry.getHeadword());
																resultDoc = unlEntry.getDom();
															}
															else {
																PapillonLogger.writeDebugMsg("Pivax entries: Entry null: " + word);
															}
															
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					}
					}
				}
			}
			}
			}
			
		}
		return resultDoc;
	}
}
