/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Mathieu Mangeot & Gilles Serasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.4  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.8  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2.2.7  2005/03/16 13:24:31  serasset
 * Modified all boolean fields in table to CHAR(1) in order to be more db independant.
 * Suppressed ant.jar from class path, informationfiles (which rely on it) should be corrected.
 * The version of Xerces is now displayed on application init.
 *
 * Revision 1.2.2.6  2005/02/06 22:43:49  mangeot
 * Merged the 2 Hashtables CDM Elements and XPaths into one
 * Added a boolean (reverse-lookup) in the volume metadata and functionalities in order to perform a reverse lookup when no direct lookup result is found
 * Added a boolean (index) in the volume metadata for indexing the only specified CDM Elements
 *
 * Revision 1.2.2.5  2005/01/28 23:01:09  mangeot
 * Fixed bugs in the editor. It seems to work now. More testing needed anyway...
 *
 * Revision 1.2.2.4  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.2.2.3  2005/01/27 23:55:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.2  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
 * Revision 1.2.2.1  2005/01/25 13:54:54  mangeot
 * changed the volume volumeEntry and index objects. Does not compile but need a backup...
 *
 * Revision 1.2  2005/01/18 09:41:11  mangeot
 * Recoded the countRows method with a new method that appeared with DODS 5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.12  2004/02/12 14:45:02  mangeot
 * Added history directly in the entries
 *
 * Revision 1.11  2004/02/12 13:30:22  mangeot
 * added boolean CDMElementsLoaded
 *
 * Revision 1.10  2004/02/10 05:27:13  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.papillon_data.*;
import fr.imag.clips.papillon.CurrentDBTransaction;

import fr.imag.clips.papillon.business.PapillonBusinessException;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

import java.io.*;
//Dom objects
import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

// pour les transforamtion
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;
import org.xml.sax.InputSource;

//  Imported JAVA API for XML Parsing classes
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//pour le debugage
import fr.imag.clips.papillon.business.utility.Utility;


/**
* Represents a Volume. 
 */
public class Volume {
	
	public final static String LOCAL_LOCATION = "local";
	public final static String REMOTE_LOCATION = "remote";
	
	// All CDM elements
    public static final String CDM_volume = "cdm-volume";
    public static final  String CDM_entry = "cdm-entry";
    public static final  String CDM_entryId = "cdm-entry-id";
    public static final  String CDM_headword = "cdm-headword";
    public static final  String CDM_homographNumber = "cdm-homograph-number";
    public static final  String CDM_headwordVariant = "cdm-headword-variant";
    public static final  String CDM_reading = "cdm-reading";
    public static final  String CDM_writing = "cdm-writing";
    public static final  String CDM_pos = "cdm-pos";
    public static final  String CDM_pronunciation = "cdm-pronunciation";
    public static final  String CDM_definition = "cdm-definition";
    public static final  String CDM_translation = "cdm-translation";
    // FIXME: Added by Gilles for distinction between translations in a bilingual dictionary and
    // FIXME: translation links to target entries in another volume.
    public static final  String CDM_translationReflexie = "cdm-translation-ref";
    public static final  String CDM_example = "cdm-example";
    public static final  String CDM_idiom = "cdm-idiom";
    public static final  String CDM_key1 = "cdm-key1";
    public static final  String CDM_key2 = "cdm-key2";	
  
	// history tags
	public static final  String CDM_history = "cdm-history";
	public static final  String CDM_modification = "cdm-modification";
	public static final  String CDM_modificationAuthor = "cdm-modification-author";
	public static final  String CDM_modificationDate = "cdm-modification-date";
	public static final  String CDM_modificationComment = "cdm-modification-comment";
	
	// constants added to manage axies, it should be generic...
    public static final  String CDM_axiSemanticCat = "axi-semantic-cat";
    public static final  String CDM_axiSynonyms = "axi-synonyms";
    public static final  String CDM_axiLanguage = "axi-language";
    public static final  String CDM_axiLanguageAttribute = "axi-language-attribute";
    public static final  String CDM_axiReflexie = "axi-reflexie";
    public static final  String CDM_axiRefaxie = "axi-refaxie";

	// gdef tags
	public static final  String CDM_gdefEstParticule = "gdef-est-particule";
  
	// other constants
	public final static String DEFAULT_LANG = "#NA";
		
	// local variables
/*
 * table schema:
 * String lang (ISO 639-2/T) -> CDM_element -> Vector (String xpath, boolean is_index, XPath xpath_compiled) 
 */
	protected java.util.Hashtable CDM_elements =  null;
	
    /**
		* The DO of the Volume.
     */
    protected VolumeDO myDO = null;
	
    /**
		* The public constructor.
     */
    public Volume() throws PapillonBusinessException {
        try {
		    this.CDM_elements = new java.util.Hashtable();
            this.myDO = VolumeDO.createVirgin(CurrentDBTransaction.get());  
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty Volume", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty Volume", ex);
        }
    }
	
    /** The protected constructor
		*
		* @param theDisc. The data object of the Volume.
		*/
    protected Volume(VolumeDO theVolumeDO) 
        throws PapillonBusinessException  {
			try {
				if (theVolumeDO != null) {
					this.CDM_elements = Utility.deSerializeHashtable(theVolumeDO.getCdmElements());
				}
				this.myDO = theVolumeDO;
			}
			catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error creating volume ", ex);
			}
		}
	
    public boolean isEmpty() {
        return (this.myDO==null) ;
    }
	
	
    /**
		* Gets the object id for the Volume
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
			} catch(DatabaseManagerException ex) {
				throw new PapillonBusinessException("Error getting Volumes's handle", ex);
			}
		}
	
    /**
		* Gets the name of the Volume
     *
     * @return the name.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getName()
        throws PapillonBusinessException {
            try {
                return myDO.getName();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting Volume's name", ex);
            }
        }
    public void setName(String volume)
        throws PapillonBusinessException {
            try {
                myDO.setName(volume);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting Volume's name", ex);
            }
        }
    
	
    /**
		* Gets the dictname of the Volume
     *
     * @return the dictname.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getDictname() 
        throws PapillonBusinessException {
			try {
				return myDO.getDictname();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's dictname", ex);
			}
		}
	public void setDictname(String dictname) 
        throws PapillonBusinessException {
			try {
				myDO.setDictname(dictname);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting Volume's dictname", ex);
			}
		}
	
	
    /**
        * Gets the dbname of the Volume
     *
     * @return the dbname.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    public String getDbname()
        throws PapillonBusinessException {
            try {
                return myDO.getDbname();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting Volume's Dbname", ex);
            }
        }
    public void setDbname(String dbname)
        throws PapillonBusinessException {
            try {
                myDO.setDbname(dbname);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting Volume's dbname", ex);
            }
        }
	
	
    public String getIndexDbname()
        throws PapillonBusinessException {
			return IndexFactory.INDEX_TABLE_PREFIX + getDbname();
		}
	
    /**
        * Gets the location of the Volume
     *
     * @return the dbname.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    public String getLocation()
        throws PapillonBusinessException {
            try {
                return myDO.getLocation();
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error getting Volume's location", ex);
            }
        }
    public void setLocation(String location)
        throws PapillonBusinessException {
            try {
                myDO.setLocation(location);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting Volume's location", ex);
            }
        }
	
	
    /**
		* Gets the source language of the Volume
     *
     * @return the source language.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getSourceLanguage() 
        throws PapillonBusinessException {
			try {
				return myDO.getSourceLanguage();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's source language", ex);
			}
		}
	public void setSourceLanguage(String lang) 
        throws PapillonBusinessException {
			try {
				myDO.setSourceLanguage(lang);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting Volume's source language", ex);
			}
		}
	
	
    /**
		* Gets the target languages of the Volume
     *
     * @return the target languages.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getTargetLanguages() 
        throws PapillonBusinessException {
			try {
				return myDO.getTargetLanguages();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's target languages", ex);
			}
		}

	public String[] getTargetLanguagesArray() throws PapillonBusinessException {
			return getTargetLanguages().split("\\s");
    }

	public void setTargetLanguages(String langs) 
        throws PapillonBusinessException {
			try {
				myDO.setTargetLanguages(langs);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting Volume's target languages", ex);
			}
		}
	
	
    /**
		* Gets the href of the Volume
     *
     * @return the href.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getVolumeRef() 
        throws PapillonBusinessException {
			try {
				return myDO.getVolumeRef();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's href", ex);
			}
		}
	public void setVolumeRef(String href) 
        throws PapillonBusinessException {
			try {
				myDO.setVolumeRef(href);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting Volume's href", ex);
			}
		}
	
    /**
		* Gets the CDM elements Hashtable of the Volume
     *
     * @return the  CDM elements Hashtable.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public java.util.Hashtable getCdmElements() {
		return this.CDM_elements;
	}
	
    /**
		* Gets a CDM XPath of the Volume
     *
     * @param the name of the CDM XPath as a String.
     * @return the CDM XPath as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    protected String getCdmXPathString(String name) {
		return getCdmXPathString(name,DEFAULT_LANG);
	}
	
    /**
		* Gets a CDM XPath of the Volume
     *
     * @param the name of the CDM element as a String.
     * @param the language of the CDM element as a ISO 639-2/T 3 letters String.
     * @return the CDM XPath as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    protected String getCdmXPathString(String name, String lang) {
		String res = null;
		java.util.Hashtable tmpTable = (java.util.Hashtable) this.CDM_elements.get(lang);
		if (tmpTable != null) {
			java.util.Vector myVector = (java.util.Vector) tmpTable.get(name);
			if (myVector != null && myVector.size()>0) {
				res = (String) myVector.elementAt(0);
			}
		}
		else {
			fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Error 1: CDM Element null for name: " + name + " " + lang + " Hashtable: " + this.CDM_elements.toString());
		}
		if (res == null || res.equals("")) {
			fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Error 2: CDM Element null for name: " + name + " " + lang + " Hashtable: " + this.CDM_elements.toString());
		}
		return res;
	}
	
	protected String getTagNameFromXPath (String xPathString) {
		String res = xPathString;
		if (res != null) {
			int text = res.indexOf("/text()");
			if (text>0) {
				res = res.substring(0,text);
			}
			int index = res.lastIndexOf("/");
			if (index>=0) {
				res = res.substring(index+1);
			}
			int colon = res.lastIndexOf(":");
			if (colon>=0) {
				res = res.substring(colon+1);
			}
		}
		return res;
	}
	
    /**
		* Gets the CDM volume of the Volume
     *
     * @return the CDM volume tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmVolume() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_volume));
	}

    /**
		* Gets the CDM entry of the Volume
     *
     * @return the  CDM entry tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmEntry() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_entry));
	}

    /**
		* Gets the CDM headword of the Volume
     *
     * @return the  CDM headword tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmHeadword() throws fr.imag.clips.papillon.business.PapillonBusinessException {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_headword, this.getSourceLanguage()));
	}

    /**
		* Gets the CDM history of the Volume
     *
     * @return the  CDM history tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmHistory() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_history));
	}

    /**
		* Gets the CDM modification of the Volume
     *
     * @return the  CDM modification tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmModification() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modification));
	}

    /**
		* Gets the CDM author of the Volume
     *
     * @return the  CDM author tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmAuthor() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationAuthor));
	}

    /**
		* Gets the CDM date of the Volume
     *
     * @return the  CDM date tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmDate() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationDate));
	}

    /**
		* Gets the CDM comment of the Volume
     *
     * @return the CDM comment tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getCdmComment() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationComment));
	}

	/**
		* Sets the CDM elements Hashtable of the Volume
     *
     * @param the CDM elements as an Hashtable.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public void setCdmElements(java.util.Hashtable elements) {
        this.CDM_elements = elements;
	}
	
    /**
		* Gets the xml code of the volume metadata file
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getXmlCode()
        throws PapillonBusinessException {
			try {
				return this.myDO.getXmlCode();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's xmlcode", ex);
			} 
		}
	public void setXmlCode(String code)
        throws PapillonBusinessException {
			try {
		  		myDO.setXmlCode(code);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's xmlcode", ex);
			}
		}	
	
    public String getFormatterClassName() throws PapillonBusinessException {
        NodeList formatters = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-formatter"); 
        String classname = null;
        if ((null != formatters) && (formatters.getLength() > 0)) {
            classname = ((Element) formatters.item(0).getFirstChild()).getAttribute("class-name");
        }
        return classname;
	}
    
    
    /**
		* Gets the xml code of the volume xml schema file
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getXmlSchema() throws PapillonBusinessException {
        try {
			return this.myDO.getXmlSchema();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting Volume's xmlschema code", ex);
        } 
	}
    
	public void setXmlSchema(String code)
        throws PapillonBusinessException {
			try {
		  		myDO.setXmlSchema(code);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's xmlschema code", ex);
			}
		}
	
	/**
		* Gets the xml code of the edition interface template
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getTemplateInterface()
		throws PapillonBusinessException {
			try {
				return this.myDO.getTemplateItf();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume TemplateItf", ex);
			}
		}
    
	/**
		* Sets the xml code of the edition interface template
     *
     * @param the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
	public void setTemplateInterface(String code)
        throws PapillonBusinessException {
			try {
		  		myDO.setTemplateItf(code);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting volume's TemplateItf code", ex);
			}
		}
	
    /**
		* Gets the xml code of  template entry of the volume
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public String getTemplateEntry()
		throws PapillonBusinessException {
			try {
				return this.myDO.getTemplateEntry();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume template entry code", ex);
			}
		}
	
	public void setTemplateEntry(String code)
		throws PapillonBusinessException {
			try {
				myDO.setTemplateEntry(code);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume template entry code", ex);
			}
		}
	
    /**
		* Gets the xml code of  template entry of the volume
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public boolean IsReverseLookup()
		throws PapillonBusinessException {
			try {
                String rev = this.myDO.getReverse();
				return ((rev != null) && rev.equals("Y"));
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume reverse lookup", ex);
			}
		}
	
	public void setReverseLookup(boolean reverse)
		throws PapillonBusinessException {
			try {
				myDO.setReverse(reverse ? "Y" : "N");
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting volume reverse lookup", ex);
			}
		}
	
    /**
		* count entries of the volume
     *
     * @return the number of entries as an integer.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public int countEntries() throws PapillonBusinessException {
        return VolumeEntriesFactory.getCount(this);
    }
	
    /**
		* Saves the Volume into the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
						*   error).
     */
    public void save() 
        throws PapillonBusinessException {
			try {
				this.myDO.setCdmElements(Utility.serializeHashtable(this.CDM_elements));
				this.myDO.commit();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error saving Volume", ex);
			}
		}
    
    /**
		* Deletes the Volume from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
						*   error).
     */
    public void deleteAll() 
        throws PapillonBusinessException {
			try {
				if (this.getLocation().equals(LOCAL_LOCATION)) {
					VolumeEntriesFactory.dropVolumeTables(this);
				}
				ContributionsFactory.removeContributions(this);
				this.myDO.delete();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error deleting Volume", ex);
			}
		}
	
    public void delete() 
        throws PapillonBusinessException {
			try {
				this.myDO.delete();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error deleting Volume", ex);
			}
		}
}				
