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

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.utility.Utility;
import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;


/* standards imports */
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/* W3C imports */
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Represents a Mailing list Dictionary. 
 */
public class Axie implements IAnswer {
    /**
     * The DO of the Dictionary.
     */
	protected final static String DML_URI = "http://www-clips.imag.fr/geta/services/dml";
	protected final static String XLINK_URI = "http://www.w3.org/1999/xlink";
	
	protected final static String SYNONYMS_SEPARATOR_STRING = "#";
		 
	protected final static String ENTRY_ELEMENT = "axie";
	protected final static String SEMANTIC_CAT_ELEMENT = "semantic_cat";
	protected final static String LANGUAGE_LINKS_ELEMENT = "language-links";
	protected final static String LANGUAGE_ELEMENT = "language";
	protected final static String LANG_ATTRIBUTE = "lang";
	protected final static String REFLEXIE_ELEMENT = "reflexie";
	protected final static String HREF_ATTRIBUTE = "href";

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
            this.myDO = PapillonAxiDO.createVirgin();
        }
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty axie volume", ex);
        }
        catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty axie volume", ex);
        }

    }
    
    /** The protected constructor
     *
     * @param theDisc. The data object of the Volume.
     */
    protected Axie(Dictionary dict, Volume vol, PapillonAxiDO theAxie) 
        throws PapillonBusinessException  {
			try {
				this.myDO = theAxie;
				this.lexies = deSerializeHashtable(theAxie.getLexies());
				this.theVolume = vol;
				this.theDictionary = dict;
			}
			catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error creating axie ", ex);
			}
			this.myDO = theAxie;
    }

    public boolean IsEmpty() {
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

	public String getHeadwords()
        throws PapillonBusinessException {
			return this.getHeadword();
	}

    public String getId()
        throws PapillonBusinessException {
        try {
            return myDO.getId();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume's headword", ex);
        }
    }

   public void setId(String id)
        throws PapillonBusinessException {
        try {
		  		myDO.setId(id);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume's headword", ex);
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
		
		Document myDoc = Utility.buildDOMTree(this.getXmlCode());
		myDoc = addLanguageLink(myDoc,lang, lexieID);
		
		this.setXmlCode(Utility.NodeToString(myDoc));
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
		
		Document myDoc = Utility.buildDOMTree(this.getXmlCode());
		myDoc = removeLanguageLink(myDoc,lang, lexieID);
		
		this.setXmlCode(Utility.NodeToString(myDoc));
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
	
    public void save() 
        throws PapillonBusinessException {
				Volume myVolume = this.getVolume();
				if (myVolume == null || myVolume.IsEmpty()) {
					myVolume = VolumesFactory.findVolumeByDbname(this.getTableName());
				}
			if (myVolume!=null && ! myVolume.IsEmpty()) {
				this.save(myVolume.getIndexDbname());
			}
			else {
				try {
							this.myDO.setLexies(serializeHashtable(this.lexies));
							this.myDO.commit();
					} catch(Exception ex) {
							throw new PapillonBusinessException("Error saving volumeEntry", ex);
					}
				throw new PapillonBusinessException("Error saving volumeEntry, there is no volume so no index entered!");
			}
		}
    
    public void save(String indexDbname) 
        throws PapillonBusinessException {
        try {
						IndexFactory.deleteIndexForEntryId(indexDbname,this.getHandle());
						IndexFactory.createIndexForHashtable(indexDbname,this);
						this.myDO.setLexies(serializeHashtable(this.lexies));
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving volume", ex);
        }
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
				if (myVolume == null || myVolume.IsEmpty()) {
					myVolume = VolumesFactory.findVolumeByDbname(this.getTableName());
				}
			if (myVolume!=null && ! myVolume.IsEmpty()) {
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


	protected byte[] serializeHashtable(Hashtable myTable) throws PapillonBusinessException {
		byte[] resultArray = null;
		try {
			ByteArrayOutputStream myByteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myByteArrayOutputStream);
			myObjectOutputStream.writeObject (myTable);
			resultArray = myByteArrayOutputStream.toByteArray();
			myByteArrayOutputStream.flush();
		}
		catch(Exception ex) {
            throw new PapillonBusinessException("Error in Axie.deSerializeHashtable", ex);
        }
		return resultArray;
	}
	
	protected Hashtable deSerializeHashtable(byte[] myByteArray) throws PapillonBusinessException {
		Hashtable myRes = null;
		try {
			ObjectInputStream myOIStream = new ObjectInputStream(new ByteArrayInputStream(myByteArray));
			myRes = (Hashtable) myOIStream.readObject();
		}
		catch(Exception ex) {
            throw new PapillonBusinessException("Error in Axie.deSerializeHashtable", ex);
        }
		return myRes;
	}
}
