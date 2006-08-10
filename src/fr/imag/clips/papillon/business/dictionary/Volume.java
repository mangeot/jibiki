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
 * Revision 1.28  2006/08/10 22:17:12  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 * Revision 1.27  2006/06/01 22:05:05  fbrunet
 * New interface, quick search, new contribution management (the first edition not create new contribution. New contribution is created after add, remove element, update, save, etc. in the interface window)
 *
 * Revision 1.26  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
 * Revision 1.25  2006/03/29 10:17:36  mangeot
 * FIXME: Added CDM_gdefEstParticule...
 *
 * Revision 1.24  2006/03/27 11:24:12  mangeot
 * finition-date bug fix
 *
 * Revision 1.23  2006/03/27 10:51:42  mangeot
 * Added getCdmXXXElement()
 *
 * Revision 1.22  2006/03/27 10:48:03  mangeot
 * Added finition-date in contribution metadata
 *
 * Revision 1.21  2006/03/15 13:38:25  mangeot
 * added isDefaultLangCDMElement
 *
 * Revision 1.20  2006/03/12 23:19:18  mangeot
 * Fixed a bug that forbed to retrieve entries by translation ids
 *
 * Revision 1.19  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.18  2006/02/21 13:37:54  mangeot
 * *** empty log message ***
 *
 * Revision 1.17  2006/01/25 17:06:09  mangeot
 * Fixed the sort buttons
 *
 * Revision 1.16  2005/12/04 15:22:39  mangeot
 * Fixed the volume parsing when the volume element is not the root element
 *
 * Revision 1.15  2005/11/23 13:42:27  mangeot
 * Added cdmEntryIdElement for setting the entry id even if it is not an attribute
 *
 * Revision 1.8  2005/11/10 13:12:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.4.4  2006/02/17 13:21:25  mangeot
 *
 * MM: modified AdvancedQueryForm. getAllTargetLanguages, getAllSourceLanguages and getCdmElementsWithDefaultLanguage are now static in AvailableLanguages.java in order to accelerate the execution.
 *
 * Revision 1.7.4.3  2006/01/25 15:22:23  fbrunet
 * Improvement of QueryRequest
 * Add new search criteria
 * Add modified status
 *
 * Revision 1.7.4.2  2005/12/02 10:04:09  fbrunet
 * Add Pre/Post edition processing
 * Add index reconstruction
 * Add new query request
 * Add fuzzy search
 * Add new contribution administration
 * Add xsl transformation volume
 *
 * Revision 1.7.4.1  2005/10/24 16:29:19  fbrunet
 * Added fuzzy search capabilities.
 * Added possibility to rebuild the index DB tables.
 * Added Pre and post processors that could be defined by the user.
 *
 * Revision 1.7  2005/06/17 16:49:47  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2005/06/17 12:38:56  mangeot
 * Changed lexiesCollection into lexiesHashtable in order to implement the getDirectTranslations
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
 * Revision 1.3.4.7  2005/06/14 11:56:16  mangeot
 * Added a new page ChangeAuthor for changing the author of a set of previously selected contributions
 *
 * Revision 1.3.4.6  2005/06/09 11:28:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.4.5  2005/06/09 11:07:45  mangeot
 * Deleted the countEntriesCache. entries counts are not cached any more.
 * Fixed a few bugs.
 *
 * Revision 1.3.4.4  2005/06/01 08:38:43  mangeot
 * Multi bug correction + added the possibility of disabling data edition
 * via the Admin.po page
 *
 * Revision 1.3.4.3  2005/05/19 17:02:22  mangeot
 * Importing entries without the contribution element
 *
 * Revision 1.3.4.2  2005/04/29 19:22:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
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
import fr.imag.clips.papillon.CurrentDBTransaction;
import com.lutris.appserver.server.sql.DBTransaction;

//for URLs
import java.net.URL;
import java.net.MalformedURLException;


//pour parser le document avec le DOM
import org.w3c.dom.*;

import com.lutris.dods.builder.generator.query.QueryBuilder;




import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.papillon_data.*;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.user.User;


import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

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
    public static final  String CDM_templateEntry = "cdm-template-entry";
    public static final  String CDM_translation = "cdm-translation";
    // FIXME: Added by Gilles for distinction between translations in a bilingual dictionary and
    // FIXME: translation links to target entries in another volume.
    public static final  String CDM_translationReflexie = "cdm-translation-ref";
    public static final  String CDM_example = "cdm-example";
    public static final  String CDM_idiom = "cdm-idiom";
	// xpaths calculated from previous ones
    public static final  String CDM_headwordElement = "cdm-headword-element";
	public static final  String CDM_entryIdElement = "cdm-entry-id-element";
      
	// history tags
	public static final  String CDM_history = "cdm-history";
	public static final  String CDM_modification = "cdm-modification";
	public static final  String CDM_modificationAuthor = "cdm-modification-author";
    public static final  String CDM_modificationAuthorElement = "cdm-modification-author-element";
	public static final  String CDM_modificationDate = "cdm-modification-date";
    public static final  String CDM_modificationDateElement = "cdm-modification-date-element";
	public static final  String CDM_modificationComment = "cdm-modification-comment";
    public static final  String CDM_modificationCommentElement = "cdm-modification-comment-element";

	// contribution tags
    public static final  String CDM_contribution = "cdm-contribution";
    public static final  String CDM_contributionAuthor = "cdm-contribution-author";
    public static final  String CDM_contributionAuthorElement = "cdm-contribution-author-element";
    public static final  String CDM_contributionCreationDate = "cdm-contribution-creation-date";
    public static final  String CDM_contributionCreationDateElement = "cdm-contribution-creation-date-element";
    public static final  String CDM_contributionGroup = "cdm-contribution-group";
    public static final  String CDM_contributionGroups = "cdm-contribution-groups";
    public static final  String CDM_contributionId = "cdm-contribution-id";
    public static final  String CDM_contributionFinitionDate = "cdm-contribution-finition-date";
    public static final  String CDM_contributionFinitionDateElement = "cdm-contribution-finition-date-element";
    public static final  String CDM_contributionReviewDate = "cdm-contribution-review-date";
    public static final  String CDM_contributionReviewDateElement = "cdm-contribution-review-date-element";
    public static final  String CDM_contributionReviewer = "cdm-contribution-reviewer";
    public static final  String CDM_contributionReviewerElement = "cdm-contribution-reviewer-element";
    public static final  String CDM_contributionValidationDate = "cdm-contribution-validation-date";
    public static final  String CDM_contributionValidationDateElement = "cdm-contribution-validation-date-element";
    public static final  String CDM_contributionValidator = "cdm-contribution-validator";
    public static final  String CDM_contributionValidatorElement = "cdm-contribution-validator-element";
    public static final  String CDM_contributionStatus = "cdm-contribution-status";
    public static final  String CDM_contributionStatusElement = "cdm-contribution-status-element";
    public static final  String CDM_contributionDataElement = "cdm-contribution-data-element";
    public static final  String CDM_originalContributionId = "cdm-original-contribution-id";
    // FBM: Added by francis
    // link to previous classified finished/not-finished contribution
    public static final  String CDM_previousClassifiedFinishedContribution = "cdm-previous-classified-finished-contribution";
    public static final  String CDM_previousClassifiedFinishedContributionElement = "cdm-previous-classified-finished-contribution-element";
    public static final  String CDM_previousClassifiedNotFinishedContribution = "cdm-previous-classified-not-finished-contribution";
    public static final  String CDM_previousClassifiedNotFinishedContributionElement = "cdm-previous-classified-not-finished-contribution-element";
    // link to next contribution author
    public static final  String CDM_nextContributionAuthor = "cdm-next-contribution-author";
    public static final  String CDM_nextContributionAuthorElement = "cdm-next-contribution-author-element";

	
	/* constants added to manage axies, it should be generic...*/
    public static final  String CDM_axiSemanticCat = "axi-semantic-cat";
    public static final  String CDM_axiSynonyms = "axi-synonyms";
    public static final  String CDM_axiLanguage = "axi-language";
    public static final  String CDM_axiLanguageAttribute = "axi-language-attribute";
    public static final  String CDM_axiReflexie = "axi-reflexie";
    public static final  String CDM_axiRefaxie = "axi-refaxie"; 

	// gdef tags
	public static final  String CDM_gdefEstParticule = "gdef-est-particule";
	public static final  String CDM_gdefEstFrequence = "gdef-est-frequence";
  
	// other constants
	public final static String DEFAULT_LANG = "#NA";
	
	public final static String[] indexElements = { 
		CDM_entryId, 
		CDM_headword,
		CDM_reading,
		CDM_writing,
		CDM_pronunciation,
		CDM_pos,
		CDM_example,
		CDM_idiom,
		CDM_translation,
		CDM_translationReflexie,
		
// contribution CDM elements
		CDM_contributionId,
		CDM_originalContributionId,
		CDM_contributionAuthor,
		CDM_contributionGroup,
		CDM_contributionGroups,
		CDM_contributionCreationDate,
		CDM_contributionFinitionDate,
		CDM_contributionReviewDate,
		CDM_contributionReviewer,
		CDM_contributionValidationDate,
		CDM_contributionValidator,
		CDM_contributionStatus,
		
// gdef-est elements
		CDM_gdefEstParticule,
		CDM_gdefEstFrequence
		
	};
		
	public final static String[] langElements = { 
		CDM_headword,
		CDM_homographNumber,
		CDM_headwordVariant,
		CDM_reading,
		CDM_writing,
		CDM_pronunciation,
		CDM_pos,
		CDM_example,
		CDM_idiom,
		CDM_translation,
		CDM_translationReflexie,
		// gdef-est elements
		CDM_gdefEstParticule,
		CDM_gdefEstFrequence

	};
	
	public final static String[] defaultLangElements = { 
		CDM_volume, 
		CDM_entry, 
		CDM_entryId, 
		CDM_contributionId,
		CDM_originalContributionId,
		CDM_contributionAuthor,
		CDM_contributionGroup,
		CDM_contributionCreationDate,
		CDM_contributionFinitionDate,
		CDM_contributionReviewDate,
		CDM_contributionReviewer,
		CDM_contributionValidationDate,
		CDM_contributionValidator,
		CDM_contributionStatus,
		CDM_previousClassifiedFinishedContribution,
		CDM_previousClassifiedNotFinishedContribution,
		CDM_nextContributionAuthor
	};
	
	public final static String[] sourceLangElements = { 
		CDM_headword,
		CDM_homographNumber,
		CDM_headwordVariant,
		CDM_reading,
		CDM_writing,
		CDM_pronunciation,
		CDM_pos,
		CDM_example,
		CDM_idiom,
		// gdef-est elements
		CDM_gdefEstParticule,
		CDM_gdefEstFrequence
	};
	
	// local variables
	protected final static String XmlFooterSeparator = "$$$###$$$";

/*
 * table schema:
 * String lang (ISO 639-2/T) -> CDM_element -> Vector (String xpath, boolean is_index, XPath xpath_compiled) 
 */
    /*
     * table schema:
     * Hastable with key [String lang (ISO 639-2/T)] 
     * OF Hastable with key [CDM_element] 
     * OF Vector (String xpath, boolean is_index, XPath xpath_compiled) 
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
    
    // FIXME: change String to Collection
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
    // FIXME: change String to Collection
    // FIXME: supress getTargetLanguagesArray ? or getTargetLanguages ?
    public String getTargetLanguages() 
        throws PapillonBusinessException {
			try {
				return myDO.getTargetLanguages();   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's target languages", ex);
			}
		}

	public Collection getTargetLanguagesArray() throws PapillonBusinessException {
			
        //return getTargetLanguages().split("\\s");
        // FIXME: add target collection in volume
        String[] targetsString = getTargetLanguages().split("\\s");
        ArrayList targets = new ArrayList();
        for (int i = 0; i < targetsString.length; i++) {
            targets.add(targetsString[i]);
        }
        
        return targets;
    }

    // FIXME: change String to Collection
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
		// fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getCdmXPathString: " + name + " : " + res);
		return res;
	}
	
	public static String getTagNameFromXPath (String xPathString) {
		return getTagNameFromXPath(xPathString, true);
	}
	
	protected static String getTagNameFromXPath (String xPathString, boolean letNamespacePrefix) {
		// fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getTagNameFromXPath: " + xPathString);
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
			if (!letNamespacePrefix) {
				int colon = res.lastIndexOf(":");
				if (colon>=0) {
					res = res.substring(colon+1);
				}
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
	 * Gets the local tag name of the CDM entry of the Volume
     *
     * @return the  CDM entry tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public String getCdmLocalEntry() {
		return Utility.getLocalTagName(getTagNameFromXPath(getCdmXPathString(this.CDM_entry)));
	}

    public String getCdmContribution() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_contribution));
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
    public String getCdmModificationAuthor() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationAuthor));
	}
	
    public String getCdmModificationAuthorElement() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationAuthorElement));
	}
	
    /**
	 * Gets the CDM date of the Volume
     *
     * @return the  CDM date tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public String getCdmModificationDate() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationDate));
	}

    public String getCdmModificationDateElement() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationDateElement));
	}
	
    /**
	 * Gets the CDM comment of the Volume
     *
     * @return the CDM comment tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public String getCdmModificationComment() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationComment));
	}

	public String getCdmModificationCommentElement() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_modificationCommentElement));
	}
	
    /**
	 * Gets the CDM groups element of the Volume
     *
     * @return the CDM comment tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public String getCdmContributionGroups() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_contributionGroups));
	}
	
    /**
	 * Gets the CDM group of the Volume
     *
     * @return the CDM comment tag name as a String.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public String getCdmContributionGroup() {
		return getTagNameFromXPath(getCdmXPathString(this.CDM_contributionGroup));
	}
	
	/**
	 * Sets the CDM elements Hashtable of the Volume
     *
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
	public void setCdmElements() 
        throws PapillonBusinessException {
			this.CDM_elements = VolumesFactory.buildCdmElementsTable(this.getXmlCode(), this.getTemplateEntry(), this.getSourceLanguage());
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
            // FIXME : no .getFirstChild needs
            classname = ((Element) formatters.item(0).getFirstChild()).getAttribute("class-name");
        }
        return classname;
	}
   
    public String getPreProcessorClassName() throws PapillonBusinessException {
        NodeList preProcessor = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-preprocessor"); 
        String classname = null;
        if ((null != preProcessor) && (preProcessor.getLength() > 0)) {
            // FIXME : no .getFirstChild needs
            classname = ((Element) preProcessor.item(0).getFirstChild()).getAttribute("class-name");
        }
        return classname;
	}
    
    public String getPostUpdateProcessorClassName() throws PapillonBusinessException {
        NodeList postProcessor = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-postupdateprocessor"); 
        String classname = null;
        if ((null != postProcessor) && (postProcessor.getLength() > 0)) {
            // FIXME : no .getFirstChild needs
            classname = ((Element) postProcessor.item(0).getFirstChild()).getAttribute("class-name");
        }
        return classname;
	}
    
    public String getPostSaveProcessorClassName() throws PapillonBusinessException {
        NodeList postProcessor = Utility.buildDOMTree(this.getXmlCode()).getElementsByTagName("result-postsaveprocessor"); 
        String classname = null;
        if ((null != postProcessor) && (postProcessor.getLength() > 0)) {
            // FIXME : no .getFirstChild needs
            classname = ((Element) postProcessor.item(0).getFirstChild()).getAttribute("class-name");
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
		* IsIndexCDMElement tells if the CDM element has to be indexed in the db
     *
     * @return a boolean.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public static boolean isIndexCDMElement(String eltName) {
		return java.util.Arrays.asList(indexElements).contains(eltName);
	}
	
    /**
		* IsLangCDMElement tells if the CDM element needs a language 
	 * if yes, we will add the source languageif no one was specified
     *
     * @return a boolean.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public static boolean isLangCDMElement(String eltName) {
		return java.util.Arrays.asList(langElements).contains(eltName);
	}
	
    /**
		* IsSourceLangCDMElement tells if the CDM element needs a language 
	 * if yes, we will add the source language if no one was specified
     *
     * @return a boolean.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public static boolean isSourceLangCDMElement(String eltName) {
		return java.util.Arrays.asList(sourceLangElements).contains(eltName);
	}
	
    /**
		* IsDefaultLangCDMElement tells if the CDM element needs a language 
	 * if yes, we will add the source language if no one was specified
     *
     * @return a boolean.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    public static boolean isDefaultLangCDMElement(String eltName) {
		return java.util.Arrays.asList(defaultLangElements).contains(eltName);
	}
	
    /**
	 * Gets the xml code footer of the volume
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
    public String getXmlFooter()
		throws PapillonBusinessException {
			
			String xmlFooter = "</" + this.getCdmVolume() + ">";
			
			String templateEntry = this.getTemplateEntry();
			
			org.w3c.dom.Document templateDoc = Utility.buildDOMTree(templateEntry);
			
			org.w3c.dom.NodeList volumeNodes = ParseVolume.getCdmElements(templateDoc, Volume.CDM_volume, Volume.DEFAULT_LANG, this.getCdmElements()); 

			if (volumeNodes != null && volumeNodes.getLength() >0) {
				org.w3c.dom.Node volumeNode = volumeNodes.item(0);
				org.w3c.dom.Text myTextNode = templateDoc.createTextNode(Volume.XmlFooterSeparator);
				volumeNode.appendChild(myTextNode);
				templateEntry = Utility.NodeToString(templateDoc);
				int XmlFooterSeparatorIndex = templateEntry.lastIndexOf(Volume.XmlFooterSeparator);
				
				xmlFooter = templateEntry.substring(XmlFooterSeparatorIndex+Volume.XmlFooterSeparator.length());
			}
			else {
				fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getXmlFooter: volumesNodes null: " + xmlFooter);
			}
			fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getXmlFooter: " + xmlFooter);
			return xmlFooter;
 		}

    /**
	 * getCount get entries number of the volume
     *
     * @return the number of entries as an integer.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
	public int getCount()  
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			return VolumeEntriesFactory.getVolumeEntriesCount(this);
	}

	public int getCount(String status) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			return VolumeEntriesFactory.getVolumeEntriesCount(this, status);
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
				// Reset AvailableLanguages caches before saving because it will be modified
				fr.imag.clips.papillon.business.dictionary.AvailableLanguages.resetCache();
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
    
    
    public void launchTransformation(String xslTransformation, User user) 
        throws PapillonBusinessException {
			/*
            try {
                //
                TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
                Transformer myTransformer = myTransformerFactory.newTransformer(new StreamSource(new StringReader(xslTransformation)));
                
                //
                ArrayList allEntries = QueryRequest.findAllLexies(this.getName(), user);
                
                //
                for (int i = 0; i < allEntries.size(); i++) {
                    //
                    QueryResult qr = (QueryResult) allEntries.get(i);
                    VolumeEntry ve = qr.getSourceEntry();
                    
                    //
                    DOMSource xmlSource = new DOMSource(Utility.buildDOMTree(ve.getXmlCode()));
                    DOMResult xmlTarget = new DOMResult();
                    
                    //
                    myTransformer.transform(xmlSource, xmlTarget);
                    
                    //
                    //System.out.println(ve.getXmlCode());
                    //System.out.println(Utility.NodeToString((Document) xmlTarget.getNode()))
                    
                    //
                    ve.setDom((Document) xmlTarget.getNode());
                    ve.save();
                }
            } catch(Exception ex) {
				throw new PapillonBusinessException("Error deleting Volume", ex);
			}
            */
            
            
            // Begin transaction
            CurrentDBTransaction.registerNewDBTransaction();
            
            try {
                    // Get transformer
                    TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
                    Transformer myTransformer = myTransformerFactory.newTransformer(new StreamSource(new StringReader(xslTransformation)));
                    
                    // Truncate index volumes 
                    IndexFactory.truncateIndexTable(this);
                    
                    //
                    int count = this.getCount();
                    int delta = 10; // buffer limit
                    for (int z = 0; z < count; z=z+delta) {
                        
                        //
                        System.out.println("Z + delta : " + Integer.toString(z));
                        
                        // Buffer volumeEntries
                        Collection bufferResults = VolumeEntriesFactory.getVolumeEntriesVector(DictionariesFactory.getDictionaryByName(this.getDictname()), this, null, null, null, z, delta);
                        
                        // Index volumeEntries
                        Iterator buffer = bufferResults.iterator();
                        while ( buffer.hasNext() ) {
                            VolumeEntry ve = (VolumeEntry)buffer.next();
                            
                            //
                            DOMSource xmlSource = new DOMSource(Utility.buildDOMTree(ve.getXmlCode()));
                            DOMResult xmlTarget = new DOMResult();
                            
                            //
                            myTransformer.transform(xmlSource, xmlTarget);
                            
                            //
                            //System.out.println(ve.getXmlCode());
                            //System.out.println(Utility.NodeToString((Document) xmlTarget.getNode()))
                            
                            //
                            ve.setDom((Document) xmlTarget.getNode());
                            ve.save();
                        }
                    }
                    
                    // End transaction
                    // a part was correct, commit the transaction ...
                    ((DBTransaction) CurrentDBTransaction.get()).commit();
                
            } catch (Exception e) {
                String userMessage = "Problems when transform entries.";
                PapillonLogger.writeDebugMsg(userMessage);
                e.printStackTrace();
                try {
                    ((DBTransaction) CurrentDBTransaction.get()).rollback();
                } catch (java.sql.SQLException sqle) {
                    PapillonLogger.writeDebugMsg("launchTransformation: SQLException while rolling back failed transaction.");
                    sqle.printStackTrace();
                }
            } finally {
                CurrentDBTransaction.releaseCurrentDBTransaction();
            }
		}
    
}				
