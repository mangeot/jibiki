/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.4  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.3.2.2  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.3.2.1  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
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

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.CurrentDBTransaction;

//pour les nouvelles entrees faire le nettoyage un jour ...
import org.w3c.dom.*;

//For the volume SAX Parser 
import org.xml.sax.*;

//import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;

import fr.imag.clips.papillon.business.utility.*;
import fr.imag.clips.papillon.business.user.User;

/* for the vectors */
import java.util.*;


/**
 * Used to find the instances of xslsheet.
 */
public class PapillonPivotFactory {

    public static final String DICTNAME = "Papillon";
    public static final String VOLUMENAME = "Papillon_axi"; 

    public static Collection getAxiesCollection(Dictionary dict, Volume vol, String id, String semcat)
        throws PapillonBusinessException {
        Collection theAxieVector = null;
        
        try {
            PapillonAxiQuery query = new PapillonAxiQuery(CurrentDBTransaction.get());
            if ((null != id) && (!id.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("id", id, 
                    QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
            else if ((null != semcat) && (!semcat.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("semanticcat", semcat, 
                    QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
            PapillonAxiDO[] DOarray = query.getDOArray();
			theAxieVector = new Vector(); 
            for ( int i = 0; i < DOarray.length; i++ )
	    	theAxieVector.add(new Axie(dict, vol, DOarray[i]));

        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findAxiesByLexie()", ex);
        }
        return theAxieVector;
    }

    /**
    * The findAxieByHandle method performs a database query to
     * return a id object
     *
     * @param id, the object id of the entries table.
     * @return
     *     the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static Axie findAxieByHandle(String volumeName, String handle) throws PapillonBusinessException {
		Axie myAxie = null;
			Volume myVolume = VolumesFactory.findVolumeByName(volumeName);
			if (myVolume!=null && !myVolume.IsEmpty()) {
				Dictionary myDict = DictionariesFactory.findDictionaryByName(myVolume.getDictname());
				if (myDict!=null && !myDict.IsEmpty()) {
					myAxie = findAxieByHandle(myDict, myVolume, handle);
				}
			}
			return myAxie;
		}

    public static Axie findAxieByHandle(Dictionary dict, Volume volume, String handle)
    throws PapillonBusinessException {
			Axie theAxie = null;
			PapillonAxiDO theAxieDO = null;

			int intId = 0;
			try {
				intId = Integer.parseInt(handle);
			}
			catch(NumberFormatException ex) {
				return theAxie;
			}

			try {
				PapillonAxiQuery query = new PapillonAxiQuery(CurrentDBTransaction.get());
				//set query
				query.setQueryOId(new ObjectId(intId));
				// Throw an exception if more than one message is found
				query.requireUniqueInstance();
				theAxieDO = query.getNextDO();
				theAxie = new Axie(dict, volume, theAxieDO);
				return theAxie;
			}
			catch(Exception ex) {
				return null;
			//	throw new PapillonBusinessException("Exception in findAxieByHandle()", ex);
			}
    }
    
		    /**
        * The findAxieById method performs a database query to
     * return a id object
     *
     * @param id, the object id of the entries table.
     * @return
     *     the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */

	public static Axie findAxieById(Dictionary dict, Volume volume, String id)
     throws PapillonBusinessException {
			Axie theAxie = null;
			PapillonAxiDO theAxieDO = null;

			try {
				PapillonAxiQuery query = new PapillonAxiQuery(CurrentDBTransaction.get());
				//set query
				query.setQueryId(id);
				// Throw an exception if more than one message is found
				query.requireUniqueInstance();
				theAxieDO = query.getNextDO();
				theAxie = new Axie(dict, volume, theAxieDO);
				return theAxie;
			}
			catch(Exception ex) {
				return null;
			//	throw new PapillonBusinessException("Exception in findAxieById()", ex);
			}
    }
		
    public static Collection findAxiesByLexie(IAnswer lexie, User myUser)
    throws PapillonBusinessException {
        return findAxiesByLexieID(lexie.getDictionary(), lexie.getId(), myUser);
    }

    public static Collection findAxiesByLexieID(Dictionary dict, String lexieId, User myUser)
    throws PapillonBusinessException {
		Vector axiesTable = null;
		Collection axiesCollection = null;
		//FIXME:  Here there should be some generic code
		// in order to find the name of the pivot volume in a pivot dictionary
		if (dict.getName().equals(DICTNAME)) {
		//	Papillon_axi
			Volume myVolume = VolumesFactory.findVolumeByName(VOLUMENAME);
			axiesTable = IndexFactory.getAxiesVector(dict, myVolume,lexieId);
			axiesCollection = ContributionsFactory.checkContributions(myUser, axiesTable);
			}
		return axiesCollection;
	}
	
    public static Collection findLexiesByAxie(Axie axie, String lang) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Hashtable myEntryTable = new Hashtable();
				Collection myCollection = null;
        
        Vector lexids = axie.getLang(lang);
        Volume[] Volumes = VolumesFactory.getVolumesArray(axie.getDictionaryName(),lang, null);
        if (null != lexids && Volumes != null && Volumes.length>0) {
				if (Volumes != null && Volumes.length>0) {
					Volume firstVolume = Volumes[0];
            for (int i = 0; i < lexids.size(); i++) {
							IAnswer myEntry = DictionariesFactory.findEntryByEntryId(firstVolume.getName(), (String) lexids.elementAt(i));
							if (myEntry != null && ! myEntry.IsEmpty()) {
									myEntryTable.put(myEntry.getHandle(),myEntry);
							} 
            }
					}
        }
			// Is it necessary to check if the user is authorized to see the lexie ?
			//myCollection = ContributionsFactory.checkContributions(myUser, myEntryTable);
		myCollection = myEntryTable.values();
		return myCollection;
	}
			            
    public static Axie newAxie(Dictionary dict, Volume volume, String id, org.w3c.dom.Document docDom, String semanticCat, Vector synonyms, Hashtable lexies)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        // 
        Axie newAxie=new Axie(dict, volume);
        // id
         newAxie.setId(id);
        //semanticCat 
        newAxie.setSemanticCat(semanticCat.trim());
        //synonyms 
        newAxie.setSynonyms(synonyms);
        //Key1 
        newAxie.setLexies(lexies);
        //dom 
        newAxie.setDom(docDom);
        return newAxie;
    }

	public static Axie newAxieFromExisting(Axie existingAxie) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Axie newAxie = newAxie(existingAxie.getDictionary(), existingAxie.getVolume(), null, existingAxie.getDom(), existingAxie.getSemanticCat(), existingAxie.getSynonymsVector(), existingAxie.getLexies());
		newAxie.setId();
		return newAxie;
	}
	
	
	public static Axie createAndSaveAxie (Dictionary dict, Volume volume, String id, org.w3c.dom.Document docdom, String semanticCat, Vector synonyms, Hashtable lexies)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Axie myAxie = newAxie(dict, volume, id, docdom, semanticCat, synonyms, lexies);
			if (myAxie.IsEmpty()) {
				myAxie = null;
			}
			else {
				// FIXME: small hack, only Papillon volume entries must have an id!
				if (dict.getName().equals(PapillonPivotFactory.DICTNAME)) {
					myAxie.setId();
				}
				myAxie.save();
			}
			return myAxie;
		}

	public static Axie createAxieFromLink(String semCat, IAnswer answer1,IAnswer answer2) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Vector Vector1 = new Vector();
		Vector Vector2 = new Vector();
		Hashtable lexies = new Hashtable();

		Volume axieVolume = VolumesFactory.findVolumeByName(VOLUMENAME);
		Dictionary axieDict = null;
		if (axieVolume != null && !axieVolume.IsEmpty()) {
			axieDict = DictionariesFactory.findDictionaryByName(axieVolume.getDictname());
		}
		
		Vector1.add(answer1.getId());
		Vector2.add(answer2.getId());

		lexies.put(answer1.getSourceLanguage(),Vector1);
		lexies.put(answer2.getSourceLanguage(),Vector2);

		Document xmlDoc = createXmlCodeFromScratch (semCat);
		xmlDoc = Axie.addLanguageLink(xmlDoc,answer1.getSourceLanguage(),answer1.getId());
		xmlDoc = Axie.addLanguageLink(xmlDoc,answer2.getSourceLanguage(),answer2.getId());
		
		Axie myAxie = createAndSaveAxie(axieDict,axieVolume, null, xmlDoc, semCat, null,lexies);

		return myAxie;
	}
	
		protected static Document createXmlCodeFromScratch (String semCat)  throws fr.imag.clips.papillon.business.PapillonBusinessException {
		Volume papillonPivotVolume = VolumesFactory.findVolumeByName(VOLUMENAME);
		Document myDoc = Utility.buildDOMTree(papillonPivotVolume.getTemplateEntry());

			NodeList entryList = myDoc.getElementsByTagName(Axie.ENTRY_ELEMENT);
			if (entryList != null && entryList.getLength()>0) {
				Element myAxie = (Element) entryList.item(0);
				NodeList semcatList = myAxie.getElementsByTagName(Axie.SEMANTIC_CAT_ELEMENT);
				if (semcatList != null && semcatList.getLength()>0) {
					Element mySemCat = (Element) semcatList.item(0);
					Node myTextNode = myDoc.createTextNode(semCat);
					mySemCat.appendChild(myTextNode);
				}
			}
			return myDoc;
		}


	public static int deleteLinksInAxies(IAnswer myAnswer, User myUser)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		int res = 0;
			Collection TheAxies = null;
			if (myAnswer != null && !myAnswer.IsEmpty() && myAnswer.getVolumeName().equals(VOLUMENAME)) {
			PapillonLogger.writeDebugMsg("Delete axie links to lexie: " + myAnswer.getHeadword());
			TheAxies = findAxiesByLexie(myAnswer, myUser);
			if (TheAxies!=null && TheAxies.size()>0) { 
			res = TheAxies.size();
			for (Iterator axies = TheAxies.iterator(); axies.hasNext(); ) {
				Axie myAxie = (Axie)axies.next();
				Hashtable lexies = myAxie.getLexies();
				if (lexies!=null) {
				// if the axie is linking only 2 lexies, we delete it anyway!
					if (lexies.values().size()<3) {
						PapillonLogger.writeDebugMsg("Delete axie: " + myAxie.getHandle());
						deleteVector(ContributionsFactory.getContributionsByEntryId(null, myAxie.getHandle()));
						myAxie.delete();
					}
					// if the axie is linking more than 2 lexies, we delete the link only!
					else {
						PapillonLogger.writeDebugMsg("Remove Language Link: " + myAnswer.getId());
						myAxie.removeLanguageLink(myAnswer.getSourceLanguage(), myAnswer.getId());
					}
				}
			}
			}
			}
			return res;
		}
			
	protected static int deleteVector(Vector TheAnswers)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		for ( int i = 0; i < TheAnswers.size(); i++ ) {
			((IAnswer)TheAnswers.elementAt(i)).delete();
		}
		return TheAnswers.size();
	}


	public static int emptyDatabase()
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Volume axieVolume = VolumesFactory.findVolumeByName(VOLUMENAME);
			Dictionary axieDict = null;
			if (axieVolume != null && !axieVolume.IsEmpty()) {
				axieDict = DictionariesFactory.findDictionaryByName(axieVolume.getDictname());
			}
			Collection	TheAxies = getAxiesCollection(axieDict, axieVolume, null, null);
			for (Iterator myIt = TheAxies.iterator(); myIt.hasNext();) {
				((Axie)myIt.next()).delete();
			}
			return TheAxies.size();
		}

		
		public static boolean addLanguageLink(Axie myAxie, String lang, String lexieID) throws PapillonBusinessException {
			myAxie.addLanguageLink(lang, lexieID);
			Index myIndex = IndexFactory.newIndex(myAxie.getVolume().getIndexDbname(), Volume.CDM_axiReflexie, lang, lexieID,myAxie.getHandle());
			myIndex.save();
			return true;
		}
}

