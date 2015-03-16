/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  ¬© Mathieu Mangeot & Gilles S√©rasset - GETA CLIPS IMAG
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.Index;
import fr.imag.clips.papillon.business.dictionary.IndexFactory;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.user.UsersFactory;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.utility.Utility;
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
	protected static final int DEFAULT_LIMIT = 100;
	
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

	public static org.w3c.dom.Document getEntries(String dictName, String lang, String criteria, String word, String key, String strategyString, String limitString, String offsetString, String login, String password) 
	throws HttpPresentationException, java.io.IOException, Exception {
		User theUser = getUser(login, password);
		int limit = DEFAULT_LIMIT;
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
		String strategy = getStrategy(strategyString);
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
		else if (criteria !=null && (criteria.equals("link")||criteria.equals("cdm-link"))){
			criteria =  Volume.CDM_link;
			//Dictionary dicEntry = DictionariesFactory.getDictionaryByName(dictName);
			//Collection targetsCollection = dicEntry.getTargetLanguagesArray();
			java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null); //return volume collection，if dictName = ＊，then return all volumes
			if (volumesCollection !=null && volumesCollection.size()>0) {
				StringBuffer allEntries = new StringBuffer(120 * (limit+1) * volumesCollection.size());	
				allEntries.append(ENTRIES_HEAD_XMLSTRING);
				java.util.Iterator iterator = volumesCollection.iterator();
				while (resultDoc==null && iterator.hasNext()) {
					theVolume = (Volume) iterator.next();
					QueryRequest qrset = new QueryRequest(theVolume);
					Collection targetsCollection = DictionariesFactory.getDictionaryByName(theVolume.getDictname()).getTargetLanguagesArray();
//					PapillonLogger.writeDebugMsg("targetsCollection = "+targetsCollection);
					qrset.setTargets(targetsCollection);
					User user = new User();
					HashMap translations = qrset.findLexieAndTranslationForRest(theVolume.getName(), word, user);
//					PapillonLogger.writeDebugMsg("translations : "+translations);
					ArrayList listValues = new ArrayList();
					ArrayList listKeys = new ArrayList();
					Iterator it = translations.keySet().iterator();
					while(it.hasNext()){
						String myKey = it.next().toString();
						listKeys.add(myKey);
						listValues.add(translations.get(myKey));
//						PapillonLogger.writeDebugMsg("myKey = "+myKey+", value = "+translations.get(myKey));
					}
				
					
					for(int i=0; i<listValues.size();i++){
						
						allEntries.append("<entry dictionary=\""+((VolumeEntry)listValues.get(i)).getDictionaryName()+"\" lang=\""+((VolumeEntry)listValues.get(i)).getSourceLanguage()+"\">\n");
						allEntries.append("\t<entryId>");
						String id =((String) listKeys.get(i)).replace("&", "&amp;");
						id = id.replace(">", "&gt;");
						id = id.replace("<", "&lt;");
						id = id.replace("'", "&apos;");
						id = id.replace("\"", "&quot;");
						allEntries.append(id);
						allEntries.append("</entryId>\n");
						allEntries.append("\t<headword>");
						String e =((VolumeEntry)listValues.get(i)).getHeadword().replace("&", "&amp;");
						e = e.replace(">", "&gt;");
						e = e.replace("<", "&lt;");
						e = e.replace("'", "&apos;");
						e = e.replace("\"", "&quot;");
						allEntries.append(e);
						allEntries.append("</headword>\n");
						allEntries.append("</entry>\n");
					}

					
				}
				allEntries.append(ENTRIES_TAIL_XMLSTRING);
		
				PapillonLogger.writeDebugMsg(allEntries.toString());
				resultDoc = XMLServices.buildDOMTree(allEntries.toString());
				
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
				String entryString = "\n<entry lang='"+sourceLang+"' dictionary='"+theVolume.getDictname()+"'>";
				String langCriteria = null;
				if (Volume.isSourceLangCDMElement(criteria)) {
					langCriteria = sourceLang;
				}
				else if (Volume.isDefaultLangCDMElement(criteria)) {
					langCriteria=Volume.DEFAULT_LANG;
				}				
				
				String[] Words = word.split("\\|");
				for (int i=0, len= Words.length; i<len;i++) {
					String oneWord = Words[i];
					String criteriaString = "<criteria name='"+criteria+"' strategy='"+strategyString+"' value='"+Utility.encodeXMLEntities(oneWord)+"'>"; 
					java.util.Vector myKeys = new java.util.Vector();
					String[] Word = new String[4];
					Word[0] = criteria;
					Word[1] = langCriteria;
					Word[2] = oneWord;
					Word[3] = strategy;
					myKeys.add(Word);
					if (key != null && key.equals("entries")) {
						java.util.Collection targets = theVolume.getTargetLanguagesArray();
						java.util.Collection EntryCollection = DictionariesFactory.getDictionaryNameEntriesCollection(theVolume.getDictname(),
																													  sourceLang,
																													  targets,
																													  myKeys,
																													  null,
																													  null,
																													  theUser,
																													  offset,
																													  limit);
						
						
						if (EntryCollection!=null) {
							for (java.util.Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {
								QueryResult myQueryResult = (QueryResult) myIterator.next();
								allEntries.append(entryString);
								allEntries.append(myQueryResult.getSourceEntry().getXmlCode());
								allEntries.append("</entry>");
							}						
						}
					} 
					else {
						java.util.Collection resultsVector = IndexFactory.getIndexEntriesVector(theVolume.getIndexDbname(),
																								myKeys,
																								IndexFactory.ORDER_DESCENDING,
																								limit,
																								offset);
						for (java.util.Iterator myIterator = resultsVector.iterator(); myIterator.hasNext(); ) {
							Index myEntry = (Index) myIterator.next();
							allEntries.append(entryString);
							allEntries.append(criteriaString);
							allEntries.append(myEntry.getValue());
							allEntries.append("</criteria>");
							if (key !=null) {
								allEntries.append(getIndexValues(theVolume,""+myEntry.getEntryId(),key));
							}
							allEntries.append("<handle>");
							allEntries.append(myEntry.getEntryId());
							allEntries.append("</handle>");
							allEntries.append("</entry>");
						}
					}
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
				for (java.util.Iterator myIterator = volumesCollection.iterator(); myIterator.hasNext(); ) {
					theVolume = (Volume) myIterator.next();
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
		java.util.Collection resultsVector = IndexFactory.getIndexVectorByEntryId(theVolume, handle);
		StringBuffer allIndexes = new StringBuffer(160 * (resultsVector.size()+1));	
		for (java.util.Iterator myIterator = resultsVector.iterator(); myIterator.hasNext(); ) {
			Index myEntry = (Index) myIterator.next();
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
				allIndexes.append(Utility.encodeXMLEntities(myEntry.getValue()));
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
	
	protected static User getUser(String login, String password) 
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		User user = null;
		if (null != login && !login.equals("") &&
			null != password && !password.equals("")) {
			user = UsersFactory.findUserByLogin(login);
		}
		return user;
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
			if (strategy.equalsIgnoreCase("EQUAL")) {
				result = QueryBuilder.EQUAL;
			}
			if (strategy.equalsIgnoreCase("CASE_SENSITIVE_STARTS_WITH")) {
				result = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
			}
			if (strategy.equalsIgnoreCase("CASE_SENSITIVE_ENDS_WITH")) {
				result = QueryBuilder.CASE_SENSITIVE_ENDS_WITH;
			}
			if (strategy.equalsIgnoreCase("CASE_SENSITIVE_CONTAINS")) {
				result = QueryBuilder.CASE_SENSITIVE_CONTAINS;
			}
			if (strategy.equalsIgnoreCase("CASE_INSENSITIVE_EQUAL")) {
				result = QueryBuilder.CASE_INSENSITIVE_EQUAL;
			}
			if (strategy.equalsIgnoreCase("CASE_INSENSITIVE_STARTS_WITH")) {
				result = QueryBuilder.CASE_INSENSITIVE_STARTS_WITH;
			}
			if (strategy.equalsIgnoreCase("CASE_INSENSITIVE_ENDS_WITH")) {
				result = QueryBuilder.CASE_INSENSITIVE_ENDS_WITH;
			}
			if (strategy.equalsIgnoreCase("CASE_INSENSITIVE_CONTAINS")) {
				result = QueryBuilder.CASE_INSENSITIVE_CONTAINS;
			}
			if (strategy.equalsIgnoreCase("NOT_EQUAL")) {
				result = QueryBuilder.NOT_EQUAL;
			}
			if (strategy.equalsIgnoreCase("GREATER_THAN")) {
				result = QueryBuilder.GREATER_THAN;
			}
			if (strategy.equalsIgnoreCase("GREATER_THAN_OR_EQUAL")) {
				result = QueryBuilder.GREATER_THAN_OR_EQUAL;
			}
			if (strategy.equalsIgnoreCase("LESS_THAN")) {
				result = QueryBuilder.LESS_THAN;
			}
			if (strategy.equalsIgnoreCase("LESS_THAN_OR_EQUAL")) {
				result = QueryBuilder.LESS_THAN_OR_EQUAL;
			}			
		}
		return result;
	}
	
	
	protected static org.w3c.dom.Document getPivaxEntries(Volume lexieVolume, String word, String strategy, int limit) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
		org.w3c.dom.Document resultDoc = XMLServices.buildDOMTree(ENTRIES_HEAD_XMLSTRING+ENTRIES_TAIL_XMLSTRING);

		PapillonLogger.writeDebugMsg("Pivax entries: volume: " + lexieVolume.getName() + " word: " + word);
		String dictName = lexieVolume.getDictname();
		String sourceLang = lexieVolume.getSourceLanguage();
		String axemeLang = sourceLang.toUpperCase();
		String axiLang = "axi";
		String unlAxemeLang = "UNL";
		String unlLang = "unl";
		java.util.Vector myKeys = new java.util.Vector();
		String[] Word = new String[4];
		Word[0] = Volume.CDM_headword;
		Word[1] = sourceLang;
		Word[2] = word;
		Word[3] = strategy;
		myKeys.add(Word);
		java.util.Collection lexiesVector = IndexFactory.getIndexEntriesVector(lexieVolume.getIndexDbname(),
																			myKeys,
																			IndexFactory.ORDER_DESCENDING,
																			limit,
																			0);
		for (java.util.Iterator myIterator = lexiesVector.iterator(); myIterator.hasNext(); ) {
			Index lexieEntry = (Index) myIterator.next();
			//PapillonLogger.writeDebugMsg("Pivax entries: volume lexies: " + lexieVolume.getName() + " lexieId: " + lexieEntry.getEntryId());
			java.util.Collection lexiesResultVector = IndexFactory.getIndexVectorByEntryId(lexieVolume, ""+ lexieEntry.getEntryId());
			for (java.util.Iterator myIterator2 = lexiesResultVector.iterator(); myIterator.hasNext(); ) {
				Index lexieResultEntry = (Index) myIterator2.next();
				if (lexieResultEntry.getKey().equals(Volume.CDM_entryId)) {
			java.util.Collection axemesVolumesCollection = VolumesFactory.getVolumesArray(dictName,axemeLang,null);
			if (axemesVolumesCollection !=null && axemesVolumesCollection.size()>0) {
				Volume axemeVolume = ((Volume)axemesVolumesCollection.iterator().next());
				//PapillonLogger.writeDebugMsg("Pivax entries: volume axemes: " + axemeVolume.getName() + " lexieValue: " + lexieResultEntry.getValue());
				myKeys = new java.util.Vector();
				Word = new String[4];
				Word[0] = Volume.CDM_translationReflexie;
				Word[1] = sourceLang;
				Word[2] = lexieResultEntry.getValue();
				Word[3] = QueryBuilder.EQUAL;
				myKeys.add(Word);
				java.util.Collection axemesVector = IndexFactory.getIndexEntriesVector(axemeVolume.getIndexDbname(),
																					myKeys,
																					IndexFactory.ORDER_DESCENDING,
																					1,
																					0);
				for (java.util.Iterator myIterator3 = axemesVector.iterator(); myIterator.hasNext(); ) {
					Index axemeEntry = (Index) myIterator3.next();
					//PapillonLogger.writeDebugMsg("Pivax entries: volume axemes: " + axemeVolume.getName() + " axemeId: " + axemeEntry.getEntryId());
					java.util.Collection axemesResultVector = IndexFactory.getIndexVectorByEntryId(axemeVolume, ""+ axemeEntry.getEntryId());
					for (java.util.Iterator myIterator4 = axemesResultVector.iterator(); myIterator.hasNext(); ) {
						Index axemeResultEntry = (Index) myIterator4.next();
						if (axemeResultEntry.getKey().equals(Volume.CDM_entryId)) {
					java.util.Collection axiesVolumesCollection = VolumesFactory.getVolumesArray(dictName,axiLang,null);
					if (axiesVolumesCollection !=null && axiesVolumesCollection.size()>0) {
						Volume axieVolume = ((Volume)axiesVolumesCollection.iterator().next());
						//PapillonLogger.writeDebugMsg("Pivax entries: volume axie: " + axieVolume.getName() + " axemeValue: " + axemeResultEntry.getValue());
						myKeys = new java.util.Vector();
						Word = new String[4];
						Word[0] = Volume.CDM_translationReflexie;
						Word[1] = axemeLang;
						Word[2] = axemeResultEntry.getValue();
						Word[3] = QueryBuilder.EQUAL;
						myKeys.add(Word);
						java.util.Collection axiesVector = IndexFactory.getIndexEntriesVector(axieVolume.getIndexDbname(),
																						   myKeys,
																						   IndexFactory.ORDER_DESCENDING,
																						   1,
																						   0);
						for (java.util.Iterator myIterator5 = axiesVector.iterator(); myIterator5.hasNext(); ) {
							Index axieEntry = (Index) myIterator5.next();
							java.util.Collection axiesResultVector = IndexFactory.getIndexVectorByEntryId(axieVolume, ""+ axieEntry.getEntryId());
							for (java.util.Iterator myIterator6 = axiesResultVector.iterator(); myIterator6.hasNext(); ) {
								Index axieResultEntry = (Index) myIterator6.next();
								if (axieResultEntry.getKey().equals(Volume.CDM_translationReflexie) && axieResultEntry.getLang().equals(unlAxemeLang)) {
									java.util.Collection unlAxemesVolumesCollection = VolumesFactory.getVolumesArray(dictName,unlAxemeLang,null);
									if (unlAxemesVolumesCollection !=null && unlAxemesVolumesCollection.size()>0) {
										Volume unlAxemeVolume = ((Volume)unlAxemesVolumesCollection.iterator().next());
										//PapillonLogger.writeDebugMsg("Pivax entries: volume unl axeme: " + unlAxemeVolume.getName() + " axieValue: " + axieResultEntry.getValue());
										myKeys = new java.util.Vector();
										Word = new String[4];
										Word[0] = Volume.CDM_entryId;
										Word[1] = Volume.DEFAULT_LANG;
										Word[2] = axieResultEntry.getValue();
										Word[3] = QueryBuilder.EQUAL;
										myKeys.add(Word);
										java.util.Collection unlAxemesVector = IndexFactory.getIndexEntriesVector(unlAxemeVolume.getIndexDbname(),
																										  myKeys,
																										  IndexFactory.ORDER_DESCENDING,
																										  1,
																										  0);
										for (java.util.Iterator myIterator7 = unlAxemesVector.iterator(); myIterator7.hasNext(); ) {
											Index unlAxemeEntry = (Index) myIterator7.next();
											java.util.Collection unlAxemesResultVector = IndexFactory.getIndexVectorByEntryId(unlAxemeVolume, ""+unlAxemeEntry.getEntryId());
											//PapillonLogger.writeDebugMsg("Pivax entries: volume unl axeme: " + unlAxemeVolume.getName() + " unlAxemeId: " + unlAxemeEntry.getEntryId());
											for (java.util.Iterator myIterator8 = unlAxemesResultVector.iterator(); myIterator8.hasNext(); ) {
												Index unlAxemeResultEntry = (Index) myIterator8.next();
												if (unlAxemeResultEntry.getKey().equals(Volume.CDM_translationReflexie) && unlAxemeResultEntry.getLang().equals(unlLang)) {
													java.util.Collection unlVolumesCollection = VolumesFactory.getVolumesArray(dictName,unlLang,null);
													if (unlVolumesCollection !=null && unlVolumesCollection.size()>0) {
														Volume unlVolume = ((Volume)unlVolumesCollection.iterator().next());
														//PapillonLogger.writeDebugMsg("Pivax entries: volume unl: " + unlVolume.getName() + " unlAxemeValue: " + unlAxemeResultEntry.getValue());
														myKeys = new java.util.Vector();
														Word = new String[4];
														Word[0] = Volume.CDM_entryId;
														Word[1] = Volume.DEFAULT_LANG;
														Word[2] = unlAxemeResultEntry.getValue();
														Word[3] = QueryBuilder.EQUAL;
														myKeys.add(Word);
														java.util.Collection unlLexiesVector = IndexFactory.getIndexEntriesVector(unlVolume.getIndexDbname(),
																															  myKeys,
																															  IndexFactory.ORDER_DESCENDING,
																															  1,
																															  0);
														for (java.util.Iterator myIterator9 = unlLexiesVector.iterator(); myIterator9.hasNext(); ) {
															Index unlIndexEntry = (Index) myIterator9.next();
															VolumeEntry unlEntry = VolumeEntriesFactory.findEntryByHandle(unlVolume.getName(), ""+unlIndexEntry.getEntryId());
															if (unlEntry != null && !unlEntry.isEmpty()) {
																PapillonLogger.writeDebugMsg("API: Pivax entries: trg entry: headword: " + unlEntry.getHeadword());
																resultDoc.getDocumentElement().appendChild(resultDoc.importNode((org.w3c.dom.Node)unlEntry.getDom().getDocumentElement(),true));
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
