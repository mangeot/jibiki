/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
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
 * Revision 1.6  2005/06/22 15:55:53  mangeot
 * Solved an unresolved prefix bug when the dml prefix was not in the template entry.
 * Now we use the DmlPrefixResolver to solve this issue.
 *
 * Revision 1.5  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.4  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.3.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.4  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2.2.3  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.2.2.2  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
 * Revision 1.2.2.1  2005/01/25 13:54:54  mangeot
 * changed the volume volumeEntry and index objects. Does not compile but need a backup...
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.6  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.dictionary;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.data.PapillonAxiDO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
* Represents a Mailing list Dictionary. 
 */
public class Axie implements IAnswer {
    /**
	* The DO of the Dictionary.
     */
	protected final static String DML_URI = DmlPrefixResolver.DML_URI;
	protected final static String XLINK_URI = DmlPrefixResolver.XLINK_URI;
	
	protected final static String SYNONYMS_SEPARATOR_STRING = "#";
	
	protected final static String ENTRY_ELEMENT = "axie";
	protected final static String SEMANTIC_CAT_ELEMENT = "semantic_cat";
	protected final static String LANGUAGE_LINKS_ELEMENT = "language-links";
	protected final static String LANGUAGE_ELEMENT = "language";
	protected final static String LANG = "axi";
	protected final static String LANG_ATTRIBUTE = "lang";
	protected final static String REFLEXIE_ELEMENT = "reflexie";
	protected final static String HREF_ATTRIBUTE = "href";
	
    protected org.w3c.dom.Document dom = null;
    protected org.w3c.dom.Document htmldom = null;

    protected PapillonAxiDO myDO = null;
	protected Hashtable lexies = null;
	
	protected Dictionary theDictionary = null;
	protected Volume theVolume = null;
	
	
    /**
		* The public constructor.
     * Should find a better method instead of these if elsif elsif
     * How to do it ?
     */
    public Axie(Dictionary newDict, Volume newVolume) throws PapillonBusinessException {
		this.lexies = new Hashtable();
		this.theDictionary = newDict;
		this.theVolume = newVolume;
        try {
            this.myDO = PapillonAxiDO.createVirgin(CurrentDBTransaction.get());
        }
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty axie volume", ex);
        }
        catch(ObjectIdException ex) {
        }
		
    }
    
    /** The protected constructor
		*
		* @param theDisc. The data object of the Volume.
		*/
    protected Axie(Dictionary dict, Volume vol, PapillonAxiDO theAxieDO) 
        throws PapillonBusinessException  {
			try {
				this.myDO = theAxieDO;
				this.lexies = Utility.deSerializeHashtable(theAxieDO.getLexies());
				this.dom = Utility.deSerializeDocument(theAxieDO.getDom());
				this.htmldom = Utility.deSerializeDocument(theAxieDO.getHtmldom());
				this.theVolume = vol;
				this.theDictionary = dict;
			}
			catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error creating axie ", ex);
			}
		}
	
    public boolean isEmpty() {
        return (this.myDO==null) ;
    }
	
	
    /**
		* Gets the object id for the Dictionary
     *
     * @return the object id.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getHandle()
        throws PapillonBusinessException {
			try {
				return this.myDO.getHandle();
			} 
			catch(DatabaseManagerException ex) {
				throw new PapillonBusinessException("Error getting Axie's handle", ex);
			}
		}
	
    /**
		* Gets the subject of the Dictionary
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getTableName() {
        return myDO.getTableName(); 
    }
    
	
    /**
		* Gets the headword of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getHeadword()
        throws PapillonBusinessException {
			try {
				return myDO.getId();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume's headword", ex);
			}
		}
	
    public String getId()
        throws PapillonBusinessException {
			try {
				return myDO.getId();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume's id", ex);
			}
		}
	
	public void setId() throws PapillonBusinessException {
		String id = this.getSourceLanguage() + "." + this.getSemanticCat() + "." + this.getHandle();
		id = id.replace(' ', '_');
		this.setId(Utility.encodeXMLEntities(id));
	}
	
	public void setId(String id)
        throws PapillonBusinessException {
			org.w3c.dom.Node idNode = ParseVolume.getCdmElement(this, this.getVolume().CDM_entryId);
			if (idNode != null) {
				idNode.setNodeValue(id);
			}
			try {
		  		myDO.setId(id);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume's id", ex);
			}
		}
	
    /**
		* Gets the pos of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getSemanticCat()
        throws PapillonBusinessException {
			try {
				return myDO.getSemanticCat();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume's semanticCat", ex);
			}
		}
	
    public void setSemanticCat(String semanticCat)
        throws PapillonBusinessException {
			try {
		  		myDO.setSemanticCat(semanticCat);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume's semanticCat", ex);
			}
		}
	
    // Axie refinement links
	/*    public String getRefinements()
        throws PapillonBusinessException {
			try {
				return myDO.getRefinements();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting axie refinements", ex);
			}
		}
    public void setRefinements(String refinements)
        throws PapillonBusinessException {
			try {
				myDO.setRefinements(refinements);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting axie refinements", ex);
			}
		}
	*/
    // Axie generalisation links
	/*    public String getGeneralisations()
        throws PapillonBusinessException {
			try {
				return myDO.getGeneralisations();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting axie generalisations", ex);
			}
		}
    public void setGeneralisations(String generalisations)
        throws PapillonBusinessException {
			try {
				myDO.setGeneralisations(generalisations);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting axie generalisations", ex);
			}
		}*/
	
    // Axie synonyms links
    protected String getSynonymsString()
        throws PapillonBusinessException {
			try {
				return myDO.getSynonyms();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting axie synonyms", ex);
			}
		}
	
	public String getSynonyms () throws PapillonBusinessException {
		String synonyms = this.getSynonymsString();
		return synonyms.replace('#',' ').trim();
	}
	
	public Vector getSynonymsVector()
		throws PapillonBusinessException {
			Vector SynonymsVector = new Vector();
			String[] Synonyms = null;
			String synonymsString = getSynonymsString();
			if (null != synonymsString && !synonymsString.equals("")){
				Synonyms = synonymsString.split(SYNONYMS_SEPARATOR_STRING);
			}
			if (Synonyms !=null && Synonyms.length>0) {
				for (int i=0;i<Synonyms.length;i++) {
					SynonymsVector.add(Synonyms[i]);
				}
			}
			return SynonymsVector;
		}
	
	
    public void setSynonyms(Vector synonyms)
        throws PapillonBusinessException {
			this.setSynonyms(concatenateVector(synonyms));
		}
	
    public void setSynonyms(String synonyms)
        throws PapillonBusinessException {
			try {
				myDO.setSynonyms(synonyms);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting axie synonyms", ex);
			}
		}
	
	// Lexies hashtable
    public Hashtable getLexies() {
		return this.lexies;
	}
	
	public Vector getLexiesVector() {
		return getVectorFromLexies(this.getLexies());
	}
	
	public static Vector getVectorFromLexies(Hashtable lexiesTable) {
		Vector res = new Vector();
		for (Enumeration langs = lexiesTable.keys(); langs.hasMoreElements();) {
			String lang = (String) langs.nextElement();
			res.addAll((Vector)lexiesTable.get(lang));
		}
		return res;
	}
	
	public Vector getIndexVector()  throws PapillonBusinessException {
		Vector myVector = getLexiesVector();
		myVector.add(this.getId());
		return myVector;
	}
	
	
	public Dictionary getDictionary() {
		return theDictionary;
	}
	
    public Volume getVolume() {
        return theVolume;
    }
	
    protected void setVolume(Volume volume) {
        theVolume = volume;
    }
	
    public String getDictionaryName() throws PapillonBusinessException {
        return theDictionary.getName();
    }
	
    public String getDictionaryFullName() throws PapillonBusinessException {
        return theDictionary.getFullName();
    }
	
    public String getVolumeName() throws PapillonBusinessException {
        return theVolume.getName();
    }
	
	public String getSourceLanguage() throws PapillonBusinessException {
        return theVolume.getSourceLanguage();
    }	
	
	// A general method
    public void setLexies(Hashtable myLexies) {
		this.lexies = myLexies;
	}
	
	// A general method
    public Vector getLang(String lang) {
		return (Vector) this.lexies.get(lang);
	}
	
	// A general method
    public void setLang(String lang, String value) {
		Vector myVector = (Vector) this.lexies.get(lang);
		if (myVector == null) {
			myVector = new Vector();
		}
		myVector.add(value);
		this.lexies.put(lang, myVector);
	}
	
	/**
		* Gets the dom of the entry
	 *
	 * @return the dom of the entry.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 **/
	public org.w3c.dom.Document getDom() {
		return this.dom;
	}
	
	/**
		* Sets the dom of the entry
	 *
	 * @return void.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 **/
	public void setDom(org.w3c.dom.Document myDoc) {
		this.dom = myDoc;
	}
	
	
//	/**
//		* Gets the html dom of the entry
//	 *
//	 * @return the html dom of the entry.
//	 * @exception PapillonBusinessException if an error occurs
//	 *   retrieving data (usually due to an underlying data layer
//						  *   error).
//	 **/
//	public org.w3c.dom.Document getHtmlDom() {
//		return this.htmldom;
//	}
//
//	/**
//		* Sets the html dom of the entry
//	 *
//	 * @return void.
//	 * @exception PapillonBusinessException if an error occurs
//	 *   retrieving data (usually due to an underlying data layer
//						  *   error).
//	 **/
//	public void setHtmlDom(org.w3c.dom.Document myDoc) {
//		this.htmldom = myDoc;
//	}
	
	// XML code
    public String getXmlCode()
        throws PapillonBusinessException {
			try {
				return this.myDO.getXmlCode();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume's xmlcode", ex);
			}
		}
    
    public void setXmlCode(String code)
        throws PapillonBusinessException {
			try {
				myDO.setXmlCode(code);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting volume's xmlcode", ex);
			}
		}	
	
	public void addLanguageLink(String lang, String lexieID) throws PapillonBusinessException {
		Hashtable theLexies = this.getLexies();
		if (theLexies==null) {
			theLexies = new Hashtable();
		}
		Vector lexiesVector = (Vector) theLexies.get(lang);
		if (lexiesVector==null) {
			lexiesVector = new Vector();
		}
		lexiesVector.add(lexieID);
		theLexies.remove(lang);
		theLexies.put(lang,lexiesVector);
		this.setLexies(theLexies);
		
		addLanguageLink(this.getDom(), lang, lexieID);
	}
	
	
	
	public static Document addLanguageLink(Document myDoc, String lang, String lexieID) {
	
		Element languageTemplate = null;
		Element reflexieTemplate = null;
		
		NodeList entryLinksList = myDoc.getElementsByTagName(ENTRY_ELEMENT);
		if (entryLinksList != null && entryLinksList.getLength()>0) {
			Element myAxie = (Element) entryLinksList.item(0);
			NodeList languageLinksList = myAxie.getElementsByTagName(LANGUAGE_LINKS_ELEMENT);
			if (languageLinksList != null && languageLinksList.getLength()>0) {
				Element languageLinks = (Element) languageLinksList.item(0);
				NodeList languagesList = languageLinks.getElementsByTagName(LANGUAGE_ELEMENT);
				if (languagesList != null && languagesList.getLength()>0) {
					languageTemplate = (Element)languagesList.item(0).cloneNode(true);
					NodeList reflexieList = languageTemplate.getElementsByTagName(REFLEXIE_ELEMENT);
					if (reflexieList != null && reflexieList.getLength()>0) {
						reflexieTemplate = (Element)reflexieList.item(0).cloneNode(true);
						reflexieTemplate.setAttributeNS(XLINK_URI,HREF_ATTRIBUTE,lexieID);
						for (int i=0; i< reflexieList.getLength();i++) {
							languageTemplate.removeChild(reflexieList.item(i));
						}
					}
					boolean inserted = false;
					int i=0;
					while (!inserted && i<languagesList.getLength()) {
						Element language = (Element)languagesList.item(i);
						String langValue = language.getAttributeNS(DML_URI,LANG_ATTRIBUTE);
						if (lang.equals(langValue)) {
							language.appendChild(reflexieTemplate);
							inserted=true;
							break;
						}
						i++;
					}
					if (!inserted) {
						languageTemplate.setAttributeNS(DML_URI,LANG_ATTRIBUTE,lang);
						languageTemplate.appendChild(reflexieTemplate);
						languageLinks.appendChild(languageTemplate);
					}
				}
			}
		}
		return myDoc;
	}  
	
	public void removeLanguageLink(String lang, String lexieID) throws PapillonBusinessException {
		Hashtable theLexies = this.getLexies();
		Vector lexiesVector = (Vector) theLexies.get(lang);
		if (lexiesVector!=null) {
			lexiesVector.remove(lexieID);
			if (lexiesVector.size()==0) {
				theLexies.remove(lang);
			}
		}
		this.setLexies(theLexies);
		
		Document myDoc = this.getDom();
		myDoc = removeLanguageLink(myDoc,lang, lexieID);
		this.save();
	}
	
	public Document removeLanguageLink(Document myDoc, String lang, String lexieID) {
		NodeList languageLinksList = myDoc.getElementsByTagName(LANGUAGE_LINKS_ELEMENT);
		if (languageLinksList != null && languageLinksList.getLength()>0) {
			Element languageLinks = (Element) languageLinksList.item(0);
			NodeList languagesList = myDoc.getElementsByTagName(LANGUAGE_ELEMENT);
			if (languagesList != null && languagesList.getLength()>0) {
				boolean deleted = false;
				int i=0;
				while (i<languagesList.getLength() &&!deleted) {
					Element language = (Element)languagesList.item(i);
					String langValue = language.getAttributeNS(DML_URI,LANG_ATTRIBUTE);
					if (lang.equals(langValue)) {
						NodeList lreflexiesList = language.getElementsByTagName(REFLEXIE_ELEMENT);
						int j=0;
						while (j<lreflexiesList.getLength() &&!deleted) {
							Element reflexie = (Element) lreflexiesList.item(j);
							if (lexieID.equals(reflexie.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE))) {
								language.removeChild(reflexie);
								deleted=true;
							}
							j++;
						}
					}
					i++;
				}
			}
		}
		return myDoc;
	}  
	
	public int getType() {
        return IAnswer.LocalAxie;
    }
	
	public String createNewId () throws PapillonBusinessException {
		return createNewId(this.getSemanticCat());
	}
	
	public String createNewId (String headword) throws PapillonBusinessException {
		String entryId = this.getSourceLanguage() + "." +
		this.getSemanticCat() + "." + this.getHandle();
		entryId = entryId.replace(' ', '_');
		return Utility.encodeXMLEntities(entryId);
	}
	
	protected static String concatenateVector(Vector myVector) {
		String res = "";
		String end = "";
		if (myVector != null && myVector.size()>0) {
			for (int i=0; i< myVector.size();i++) {
				Object myObject =  myVector.elementAt(i);
				if (myObject != null) {
					String myString = (String) myObject;
					if (!myString.equals("")) {
						res += "#" + myString;
						end = "#";
					}
				}
			}
			res += end;
		}
		return res;
	}
	    
    public boolean save() 
        throws PapillonBusinessException {
			boolean res = false;
			try {
				IndexFactory.deleteIndexForEntryId(this.getVolume().getIndexDbname(),this.getHandle());
				res = ParseVolume.parseAxie(this);
				this.myDO.setXmlCode(XMLServices.xmlCode(this.dom));
				this.myDO.setDom(Utility.serializeDocument(this.dom));
				this.myDO.setHtmldom(Utility.serializeDocument(this.htmldom));
				this.myDO.setLexies(Utility.serializeHashtable(this.lexies));
				this.myDO.commit();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error saving volume", ex);
			}
			return res;
		}
	
    /**
		* Deletes the volume from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
						*   error).
     */
    public void delete() 
        throws PapillonBusinessException {
			Volume myVolume = this.getVolume();
			if (myVolume == null || myVolume.isEmpty()) {
				//myVolume = VolumesFactory.findVolumeByDbname(this.getTableName());
                myVolume = VolumesFactory.getVolumeByName(this.getVolumeName());
			}
			if (myVolume!=null && ! myVolume.isEmpty()) {
				this.delete(myVolume.getIndexDbname());
			}
			else {
				try {
					this.myDO.commit();
				} catch(Exception ex) {
					throw new PapillonBusinessException("Error saving volumeEntry", ex);
				}
				throw new PapillonBusinessException("Error saving volumeEntry, there is no volume so no index entered!");
			}
		}
	
	public void delete(String indexDbname) throws PapillonBusinessException {
        try {
			IndexFactory.deleteIndexForEntryId(indexDbname,this.getHandle());
            this.myDO.delete();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error deleting volume", ex);
        }
    }
}
