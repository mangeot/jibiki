/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.8  2007/01/05 13:57:25  serasset
 * multiple code cleanup.
 * separation of XMLServices from the Utility class
 * added an xml parser pool to allow reuse of parser in a multithreaded context
 * added a new field in the db to identify the db layer version
 * added a new system property to know which db version is known by the current app
 *
 * Revision 1.7  2006/08/10 22:17:12  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 * Revision 1.6  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.5  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
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

import com.lutris.appserver.server.sql.ObjectId;
import com.lutris.dods.builder.generator.query.QueryBuilder;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.data.PapillonAxiDO;
import fr.imag.clips.papillon.data.PapillonAxiQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
            throw new PapillonBusinessException("Exception in getAxiesCollection()", ex);
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
			Volume myVolume = VolumesFactory.getVolumeByName(volumeName);
			if (myVolume!=null && !myVolume.isEmpty()) {
				Dictionary myDict = DictionariesFactory.getDictionaryByName(myVolume.getDictname());
				if (myDict!=null && !myDict.isEmpty()) {
					myAxie = findAxieByHandle(myDict, myVolume, handle);
				}
			}
			return myAxie;
		}

    public static Axie findAxieByHandle(Dictionary dict, Volume volume, String handle)
    throws PapillonBusinessException {
			Axie theAxie = null;
			PapillonAxiDO theAxieDO = null;
            
            // FIXME: The Papillon Axie should be treated as any pivot volume
            // FIXME: In this case, is there a difference between a pivot entry and a normal volume entry
            // FIXME: (which means maybe the whole Axie stuff is to be removed...)
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
        return findAxiesByLexieID(lexie.getDictionary(), lexie.getId(), lexie.getSourceLanguage(), myUser);
    }

    public static Collection findAxiesByLexieID(Dictionary dict, String lexieId, String sourceLanguage, User myUser)
        throws PapillonBusinessException 
    {
        
        // iterate over each volume and look for axies linking to the given lexie...
		ArrayList axiesTable = new ArrayList();
        
        // find pivot volume(s) for the dictionary 
        // FIXME: Currently, a volume with lang="axi" is considered as a pivot.
        // FIXME: this should be a special type in order to cope with eurowordnet, where eng is the pivot language.
        for (Iterator iter = VolumesFactory.getVolumesArray(dict.getName(), "axi", null).iterator(); iter.hasNext();) {
            Volume volume = (Volume)iter.next();
            
            //
            axiesTable.addAll(IndexFactory.getAxiesPointingTo(dict, volume, lexieId, sourceLanguage));
        }
        
        //
        return axiesTable;
    }
    
//    public static Collection findAxiesByLexieID(Dictionary dict, String lexieId, User myUser)
//    throws PapillonBusinessException {
//		Collection axiesCollection = null;
//		//FIXME:  Here there should be some generic code
//		// in order to find the name of the pivot volume in a pivot dictionary
//		if (dict.getName().equals(DICTNAME)) {
//            //	Papillon_axi
//			Volume myVolume = VolumesFactory.getVolumeByName(VOLUMENAME);
//			Vector axiesTable = IndexFactory.getAxiesVector(dict, myVolume,lexieId);
//			axiesCollection = ContributionsFactory.checkContributions(myUser, axiesTable);
//        } else {
//            // find pivot volume(s) for the dictionary
//            Volume[] myVolumes = VolumesFactory.getVolumesArray(dict.getName(), "axi", null);
//            // iterate over each volume and look for axies linking to the given lexie...
//            axiesCollection = new HashSet();
//            for (int i=0; i < myVolumes.length; i++) {
//                Volume vol = myVolumes[i];
//                Vector axiesTable = IndexFactory.getAxiesVector(dict, vol, lexieId);
//                axiesCollection.addAll(ContributionsFactory.checkContributions(myUser, axiesTable));
//            }
//        }
//		return axiesCollection;
//	}
	
    
    public static Collection findLexiesByAxie(VolumeEntry pivotEntry, String lang) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            Collection myCollection = new HashSet();
            
            //
            String[] lexids = pivotEntry.getReferencedLexieIds(lang);
            
            //
            Collection Volumes =  VolumesFactory.getVolumesArray(pivotEntry.getDictionaryName(),lang, null);
            if (null != lexids && !Volumes.isEmpty()) {
                
                //
                Volume firstVolume = (Volume)(Volumes.iterator()).next();
                for (int i = 0; i < lexids.length; i++) {
                    IAnswer myEntry = DictionariesFactory.findEntryByEntryId(firstVolume.getName(), lexids[i]);
                    if (myEntry != null && ! myEntry.isEmpty()) {
                        myCollection.add(myEntry);
                    } 
                }
            }
			// Is it necessary to check if the user is authorized to see the lexie ?
			//myCollection = ContributionsFactory.checkContributions(myUser, myEntryTable);
            return myCollection;
        }
    
    

    // FIXME: SOON: Should not be called anymore. As Papillon Axies should not be treated specialy.
    public static Collection findLexiesByAxie(Axie axie, String lang) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            Hashtable myEntryTable = new Hashtable();
            Collection myCollection = null;
            
            Vector lexids = axie.getLang(lang);
            Collection Volumes = VolumesFactory.getVolumesArray(axie.getDictionaryName(),lang, null);
            if (null != lexids && !Volumes.isEmpty()) {
				
                //
                Iterator iter = Volumes.iterator();
                Volume firstVolume = (Volume)iter.next();
                for (int i = 0; i < lexids.size(); i++) {
                    IAnswer myEntry = DictionariesFactory.findEntryByEntryId(firstVolume.getName(), (String) lexids.elementAt(i));
                    if (myEntry != null && ! myEntry.isEmpty()) {
                        myEntryTable.put(myEntry.getHandle(),myEntry);
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
			if (myAxie.isEmpty()) {
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

		Volume axieVolume = VolumesFactory.getVolumeByName(VOLUMENAME);
		Dictionary axieDict = null;
		if (axieVolume != null && !axieVolume.isEmpty()) {
			axieDict = DictionariesFactory.getDictionaryByName(axieVolume.getDictname());
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
		Volume papillonPivotVolume = VolumesFactory.getVolumeByName(VOLUMENAME);
		Document myDoc = XMLServices.buildDOMTree(papillonPivotVolume.getTemplateEntry());

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
			if (myAnswer != null && !myAnswer.isEmpty() && myAnswer.getVolumeName().equals(VOLUMENAME)) {
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
			Volume axieVolume = VolumesFactory.getVolumeByName(VOLUMENAME);
			Dictionary axieDict = null;
			if (axieVolume != null && !axieVolume.isEmpty()) {
				axieDict = DictionariesFactory.getDictionaryByName(axieVolume.getDictname());
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

