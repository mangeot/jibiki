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
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
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
    public String CDM_volumeMetadata = "volume-metadata";
    public String CDM_volume = "volume";
    public String CDM_entryId = null;
    public String CDM_entryId_attribute = null;
    public String CDM_entryId_attribute_ns = null;
    public String CDM_entry = "entry";
    public String CDM_headword = "headword";
    public String CDM_headword_attribute = null;
    public String CDM_homographNumber = "headword";
    public String CDM_homographNumber_attribute = "hn";
    public String CDM_headwordVariant = "headword-variant";
    public String CDM_headwordVariant_attribute = null;
    public String CDM_reading = "reading";
    public String CDM_reading_attribute = null;
    public String CDM_writing = "writing";
    public String CDM_writing_attribute = null;
    public String CDM_pos = "pos";
    public String CDM_pos_attribute = null;
    public String CDM_pronunciation = "pronunciation";
    public String CDM_pronunciation_attribute = null;
    public String CDM_definition = "definition";
    public String CDM_translation = "translation";
    public String CDM_translation_attribute = null;
    public String CDM_example = "example";
    public String CDM_example_attribute = null;
    public String CDM_idiom = "idiom";
    public String CDM_idiom_attribute = null;
    public String CDM_databaseKey1 = "key1";
    public String CDM_databaseKey1_attribute = null;
    public String CDM_databaseKey2 = "key2";
    public String CDM_databaseKey2_attribute = null;
    
		// history tags
	public String CDM_history = "history";
	public String CDM_modification = "modification";
	public String CDM_modificationAuthor = "author";
	public String CDM_modificationDate = "date";
	public String CDM_modificationComment = "comment";

	
	protected boolean CDMElementsLoaded = false;


    /**
     * The DO of the Volume.
     */
    protected VolumeDO myDO = null;

    /**
     * The public constructor.
     */
    public Volume() throws PapillonBusinessException {
        try {
            this.myDO = VolumeDO.createVirgin();  
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
    protected Volume(VolumeDO theVolume) 
        throws PapillonBusinessException  {
        this.myDO = theVolume;
    }

    public boolean IsEmpty() {
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
     * Gets the xml code of the volume xmu edition interface description file
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getXmuEdition()
			throws PapillonBusinessException {
				try {
					return this.myDO.getXmuEdition();
				} catch(DataObjectException ex) {
					throw new PapillonBusinessException("Error getting volume XmuEdition", ex);
				}
			}
    
	  public void setXmuEdition(String code)
        throws PapillonBusinessException {
        try {
		  		myDO.setXmuEdition(code);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Volume's xmlschema code", ex);
        }
    }

    /**
     * Gets the xml code of the volume xmu visualisation interface description file
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getXmuVisualisation()
			throws PapillonBusinessException {
				try {
					return this.myDO.getXmuVisualisation();
				} catch(DataObjectException ex) {
					throw new PapillonBusinessException("Error getting volume XmuVisualisation", ex);
				}
			}

	  public void setXmuVisualisation(String code)
        throws PapillonBusinessException {
        try {
		  		myDO.setXmuVisualisation(code);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Volume's xmu visualisation xml code", ex);
        }
    }

    /**
     * Gets the xml code of the volume xnf concept instance list
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getXnfConcept()
			throws PapillonBusinessException {
				try {
					return this.myDO.getXnfConcept();
				} catch(DataObjectException ex) {
					throw new PapillonBusinessException("Error getting volume XnfConcept", ex);
				}
			}

	  public void setXnfConcept(String code)
        throws PapillonBusinessException {
        try {
		  		myDO.setXnfConcept(code);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Volume's xnf concept instance list xml code", ex);
        }
    }

    /**
     * Gets the xml code of the volume xnf interface instance list
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getXnfInterface()
			throws PapillonBusinessException {
				try {
					return this.myDO.getXnfInterface();
				} catch(DataObjectException ex) {
					throw new PapillonBusinessException("Error getting volume XnfInterface", ex);
				}
			}

	  public void setXnfInterface(String code)
        throws PapillonBusinessException {
        try {
		  		myDO.setXnfInterface(code);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting Volume's xnf concept instance list xml code", ex);
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

    public int countEntries() throws PapillonBusinessException {
        int entries = -1;
        String dbname = this.getDbname();
        if (null != dbname && !dbname.equals("")) {
            try {
                entries = ManageDatabase.countRows(dbname);
            }
            catch (java.sql.SQLException ex) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException("Error in Volume.countEntries: ",ex);
            }
        }
        return entries;
    }
    

// we should write a CDM class managing everything ...
    public void loadCDMElements() throws 
		fr.imag.clips.papillon.business.PapillonBusinessException {
	if (!this.CDMElementsLoaded) {
			try {
        Document docXml = Utility.buildDOMTree(this.getXmlCode());
 
        NodeList list = null;
        Element myElement = null;
        
        list= docXml.getElementsByTagName("cdm-volume");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_volume = myElement.getAttribute("element");
            }
        list= docXml.getElementsByTagName("cdm-entry");
        if (null != list && list.getLength() > 0) {
             myElement = (Element)list.item(0);
           CDM_entry = myElement.getAttribute("element");
            }
        list= docXml.getElementsByTagName("cdm-entry-id");
        if (null != list && list.getLength() > 0) {
             myElement = (Element)list.item(0);
           CDM_entryId = myElement.getAttribute("element");
           CDM_entryId_attribute = myElement.getAttribute("attribute");
           CDM_entryId_attribute_ns = myElement.getAttribute("attribute-ns");
            }
        list= docXml.getElementsByTagName("cdm-headword");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_headword = myElement.getAttribute("element");
            CDM_headword_attribute = myElement.getAttribute("attribute");
        }
        list= docXml.getElementsByTagName("cdm-headword-variant");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_headwordVariant = myElement.getAttribute("element");
            CDM_headwordVariant_attribute = myElement.getAttribute("attribute");
        }
        list= docXml.getElementsByTagName("cdm-reading");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_reading = myElement.getAttribute("element");
            CDM_reading_attribute = myElement.getAttribute("attribute");
        }
        list= docXml.getElementsByTagName("cdm-writing");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_writing = myElement.getAttribute("element");
            CDM_writing_attribute = myElement.getAttribute("attribute");
        }
        list= docXml.getElementsByTagName("cdm-pos");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_pos = myElement.getAttribute("element");
            CDM_pos_attribute = myElement.getAttribute("attribute");
            }
        list= docXml.getElementsByTagName("cdm-pronunciation");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_pronunciation = myElement.getAttribute("element");
            CDM_pronunciation_attribute = myElement.getAttribute("attribute");
        }
        list= docXml.getElementsByTagName("cdm-pronunciation");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_pronunciation = myElement.getAttribute("element");
            CDM_pronunciation_attribute = myElement.getAttribute("attribute");
        }
        list= docXml.getElementsByTagName("cdm-definition");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_definition = myElement.getAttribute("element");
		}
        list= docXml.getElementsByTagName("cdm-translation");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_translation = myElement.getAttribute("element");
            CDM_translation_attribute = myElement.getAttribute("attribute");
		}
        list= docXml.getElementsByTagName("cdm-idiom");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_idiom = myElement.getAttribute("element");
            CDM_idiom_attribute = myElement.getAttribute("attribute");
            }
        list= docXml.getElementsByTagName("cdm-key1");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_databaseKey1 = myElement.getAttribute("element");
            CDM_databaseKey1_attribute = myElement.getAttribute("attribute");
            }
        list= docXml.getElementsByTagName("cdm-key2");
        if (null != list && list.getLength() > 0) {
            myElement = (Element)list.item(0);
            CDM_databaseKey2 = myElement.getAttribute("element");
            CDM_databaseKey2_attribute = myElement.getAttribute("attribute");
            }
		list= docXml.getElementsByTagName("cdm-history");
        if (null != list && list.getLength() > 0) {
             myElement = (Element)list.item(0);
           CDM_history = myElement.getAttribute("element");
		}
		list= docXml.getElementsByTagName("cdm-modification");
        if (null != list && list.getLength() > 0) {
             myElement = (Element)list.item(0);
           CDM_modification = myElement.getAttribute("element");
		}
		list= docXml.getElementsByTagName("cdm-modification-author");
        if (null != list && list.getLength() > 0) {
             myElement = (Element)list.item(0);
           CDM_modificationAuthor = myElement.getAttribute("element");
		}
		list= docXml.getElementsByTagName("cdm-modification-date");
        if (null != list && list.getLength() > 0) {
             myElement = (Element)list.item(0);
           CDM_modificationDate = myElement.getAttribute("element");
		}
		list= docXml.getElementsByTagName("cdm-modification-comment");
        if (null != list && list.getLength() > 0) {
             myElement = (Element)list.item(0);
           CDM_modificationComment = myElement.getAttribute("element");
		}

			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Error in Volume.loadCDMElements: ", ex);
			}
			this.CDMElementsLoaded = true;
			}
            
        }   
   
    public void save() 
        throws PapillonBusinessException {
        try {
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
				VolumeEntriesFactory.dropVolumeTable(this);
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
