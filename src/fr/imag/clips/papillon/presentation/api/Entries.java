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
	protected static final String ENTRIES_TAIL_XMLSTRING ="</entry-list>";
	
    	
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

	public static org.w3c.dom.Document getEntries(String dictName, String lang, String mode, String word) 
	throws HttpPresentationException, java.io.IOException, Exception {
		
		int limit = 40;
		String allEntries = "";	
		Volume theVolume = null;
		org.w3c.dom.Document resultDoc = null;
		String strategy = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
		
		if (mode !=null && mode.equals("prefix")) {
			strategy = QueryBuilder.CASE_SENSITIVE_STARTS_WITH;
		
		java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
		
		if (volumesCollection !=null && volumesCollection.size()>0) {
			theVolume = (Volume) volumesCollection.iterator().next();
			PapillonLogger.writeDebugMsg("Entries: volume: " + theVolume.getName());
			
			java.util.Vector myKeys = new java.util.Vector();
			String[] Headword = new String[4];
			String[] Status = new String[4];
			Headword[0] = Volume.CDM_headword;
			Headword[1] = theVolume.getSourceLanguage();
			Headword[2] = word;
			Headword[3] = strategy;
			myKeys.add(Headword);
				java.util.Vector resultsVector = IndexFactory.getIndexEntriesVector(theVolume.getIndexDbname(),
																   myKeys,
																   IndexFactory.ORDER_DESCENDING,
																   limit);
			for (int i=0; i<resultsVector.size(); i++) {
				Index myEntry = (Index) resultsVector.elementAt(i);
				allEntries += "<entry><headword>" + myEntry.getValue() + "</headword><handle>" + myEntry.getEntryId() + "</handle></entry>";
			}
			resultDoc = XMLServices.buildDOMTree(ENTRIES_HEAD_XMLSTRING + allEntries + ENTRIES_TAIL_XMLSTRING);
		}
		else {
			System.out.println("Error message no corresponding dict: " + dictName + " & lang: " + lang);
		}
		}
		else if (mode !=null && mode.equals("handle")) {
			java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
			
			if (volumesCollection !=null && volumesCollection.size()>0) {
				theVolume = (Volume) volumesCollection.iterator().next();
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
		return resultDoc;			
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
	
}
