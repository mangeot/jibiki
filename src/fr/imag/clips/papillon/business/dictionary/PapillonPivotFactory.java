/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.4  2004/10/28 10:38:11  mangeot
 * Fixed some bugs that affected the dictd server
 * Modified some methods in order to display a text entry in the dictd server
 *
 * Revision 1.3  2004/02/10 05:27:13  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.2.2.5  2004/01/13 02:14:04  mangeot
 * Bug fixes :-(
 *
 * Revision 1.2.2.4  2004/01/09 05:18:57  mangeot
 * Bugs fixes !
 *
 * Revision 1.2.2.3  2004/01/08 15:17:20  mangeot
 * Bugs fixed
 *
 * Revision 1.2.2.2  2004/01/08 09:43:19  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.2.2.1  2004/01/06 09:07:02  mangeot
 * Added transitivity in Axies. I don't build a new axie if a lexie is already linked to an axie !
 * I corrected some bugs with axies and index
 *
 * Revision 1.2  2003/08/14 08:30:11  mangeot
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
 * Revision 1.1.1.1.2.8  2003/08/14 04:15:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.7  2003/08/11 10:24:50  mangeot
 * Debugging ...
 *
 * Revision 1.1.1.1.2.6  2003/08/09 07:21:04  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.1.1.1.2.5  2003/08/07 06:29:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.4  2003/08/05 05:18:46  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.3  2003/07/31 16:15:59  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.2  2003/06/27 02:13:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.1  2003/06/25 09:54:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.13  2002/09/17 20:29:32  mangeot
 * Bug corrected, version deploy 1_4 ready !
 *
 * Revision 1.12  2002/09/17 17:13:21  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.11  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.10  2002/09/05 10:26:00  mangeot
 * dded AdminAxies
 *
 * Revision 1.9.8.1  2002/08/09 09:23:38  mangeot
 * compiling error
 *
 * Revision 1.9  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.8  2002/05/07 10:31:22  mangeot
 * The UTF-8 consultation is now OK,
 * I tested with omniweb, iexplorer and netscape latests versions on macosX
 *
 * Revision 1.7  2002/05/02 07:02:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.5  2002/04/16 14:03:34  mangeot
 * A lot of work to upload dictionaries from metadata files and to parse them with
 * a SAX parser.
 *
 * Revision 1.4  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/04/01 07:46:33  mangeot
 * Added a table for volumes metadata descriptions
 *
 * Revision 1.2  2002/03/27 09:51:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/03/25 09:53:21  mangeot
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
            PapillonAxiQuery query = new PapillonAxiQuery();
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
				PapillonAxiQuery query = new PapillonAxiQuery();
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
				PapillonAxiQuery query = new PapillonAxiQuery();
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
		Hashtable axiesTable = null;
		Collection axiesCollection = null;
		//FIXME:  Here there should be some generic code
		// in order to find the name of the pivot volume in a pivot dictionary
		if (dict.getName().equals(DICTNAME)) {
		//	Papillon_axi
			Volume myVolume = VolumesFactory.findVolumeByName(VOLUMENAME);
			axiesTable = IndexFactory.getAxiesHashtable(dict, myVolume,lexieId);
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
			            
    public static Axie newAxie(Dictionary dict, Volume volume, String id, String xmlCode, String semanticCat, Vector synonyms, Hashtable lexies)
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
        //xml code
        newAxie.setXmlCode(xmlCode);
        return newAxie;
    }

			public static Axie newAxieFromExisting(Axie existingAxie) throws fr.imag.clips.papillon.business.PapillonBusinessException {
				Axie newAxie = newAxie(existingAxie.getDictionary(), existingAxie.getVolume(), null, existingAxie.getXmlCode(), existingAxie.getSemanticCat(), existingAxie.getSynonymsVector(), existingAxie.getLexies());
				IAnswerFactory.checkAndSetNewId(newAxie);
				return newAxie;
			}


	public static Axie createAndSaveAxie (Dictionary dict, Volume volume, String id, String xmlCode, String semanticCat, Vector synonyms, Hashtable lexies)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Axie myAxie = newAxie(dict, volume, id, xmlCode, semanticCat, synonyms, lexies);
			if (myAxie.IsEmpty()) {
				myAxie = null;
			}
			else {
				// FIXME: small hack, only Papillon volume entries must have an id!
				if (dict.getName().equals(PapillonPivotFactory.DICTNAME)) {
					IAnswerFactory.checkAndSetNewId(myAxie);
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
		
		Axie myAxie = createAndSaveAxie(axieDict,axieVolume, null, Utility.NodeToString(xmlDoc), semCat, null,lexies);

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
						IAnswerFactory.deleteVector(ContributionsFactory.getContributionsByEntryId(null, myAxie.getHandle()));
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
			Index myIndex = IndexFactory.newIndex(myAxie.getVolume().getIndexDbname(), lexieID,myAxie.getHandle());
			myIndex.save();
			return true;
		}
}

