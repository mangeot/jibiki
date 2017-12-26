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
 *
 */

package fr.imag.clips.papillon.business.dictionary;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.data.VolumeEntryDO;
import fr.imag.clips.papillon.data.VolumeEntryQuery;
import fr.imag.clips.papillon.papillon_data.ManageDatabase;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.text.Collator;

/**
 * Represents a Dictionary Entry.
 */
// FIXME: All CDM field access should be realized in a superclass to simplify this class.
public class VolumeEntry implements IAnswer, Comparable {
    
    public final static String ORIGINAL_STATUS = "original";    // FIXME: in use ?
    public final static String NOT_FINISHED_STATUS = "not finished";
    public final static String FINISHED_STATUS = "finished";
    public final static String DRAFT_STATUS = "draft";
    public final static String CLASSIFIED_FINISHED_STATUS = "classified";
    public final static String CLASSIFIED_NOT_FINISHED_STATUS = "classified not finished";
    public final static String DEFAULT_STATUS = FINISHED_STATUS;
    
    public final static String REVIEWED_STATUS = "revised";
    public final static String VALIDATED_STATUS = "validated";
    public final static String REPLACED_STATUS = "replaced";
    public final static String DELETED_STATUS = "deleted";
    public final static String MODIFIED_STATUS = "modified";
    
    protected static String DML_PREFIX = "d";
    
    public final static String authorTag = "author";
    public final static String commentTag = "comment";
    public final static String contributionTag = "contribution";
    public final static String contributionIdAttr = "contribid";
    public final static String creationDateTag = "creation-date";
    public final static String dataTag = "data";
    public final static String dateTag = "date";
    public final static String originalContributionIdAttr = "originalcontribid";
    public final static String groupsTag = "groups";
    public final static String groupTag = "group";
    public final static String historyTag = "history";
    public final static String metadataTag = "metadata";
    public final static String modificationTag = "modification";
    public final static String finitionDateTag = "finition-date";
    public final static String reviewDateTag = "review-date";
    public final static String reviewerTag = "reviewer";
    public final static String statusTag = "status";
    public final static String validationDateTag = "validation-date";
    public final static String validatorTag = "validator";
    public final static String previousContributionTag = "previous-contribution";
    public final static String previousClassifiedFinishedContributionTag = "previous-classified-finished-contribution";
    public final static String previousClassifiedNotFinishedContributionTag = "previous-classified-not-finished-contribution";
    public final static String nextContributionAuthorTag = "next-contribution-author";
    
    public final static ArrayList cdmList = new ArrayList();
    
    protected static final String ENTRY_ID_SUFFIX = ".e";
    protected static final String CONTRIBUTION_ID_SUFFIX = ".c";
    
    // by default, the HTML DOM is not cached
    //public static boolean CACHE_HTMLDOM = false;
    
    protected org.w3c.dom.Document dom = null;
    // protected org.w3c.dom.Document htmldom = null;
    protected Dictionary theDictionary;
    protected Volume theVolume;
    
    protected VolumeEntryDO myDO = null;
    
    
    private Collator collator = null;
    
    private Collator getCollator() {
        if (null == collator) {
            try {
                String lang = this.getSourceLanguage();
                if (null != lang && ! "".equals(lang)) {
                    collator = Collator.getInstance(new Locale(lang));
                } else {
                    collator = Collator.getInstance();
                }
            } catch (PapillonBusinessException e) {
                collator = Collator.getInstance();
            }
        }
        return collator;
    }
    
    /**
     * The public constructor.
     * Should find a better method instead of these if elsif elsif
     * How to do it ?
     */
    
    public VolumeEntry(Dictionary newDict, Volume newVolume)
    throws PapillonBusinessException {
        try {
            this.myDO = VolumeEntryDO.createVirgin(newVolume.getDbname(), CurrentDBTransaction.get());
            this.setVolume(newVolume);
            this.setDictionary(newDict);
        } catch (DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating VolumeEntry", ex);
        } catch (ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating VolumeEntry", ex);
        }
    }
    
    
    /**
     * The protected constructor
     *
     * @param newDict
     * @param newVolume
     * @param theVolumeEntryDO
     */
    protected VolumeEntry(Dictionary newDict, Volume newVolume, VolumeEntryDO theVolumeEntryDO)
    throws PapillonBusinessException {
        try {
            this.myDO = theVolumeEntryDO;
            //this.dom = Utility.deSerializeDocument(theVolumeEntryDO.getDom());
            this.dom = XMLServices.buildDOMTree(this.myDO.getXmlCode());
            // this.htmldom = Utility.deSerializeDocument(theVolumeEntryDO.getHtmldom());
            this.setVolume(newVolume);
            this.setDictionary(newDict);
            
            //String xc1 = XMLServices.xmlCode(this.dom);
            //String xc2 = XMLServices.xmlCodePrettyPrinted(this.dom);
            
            //            if (xc1.equals(xc2)) {
            //                System.out.println("ok");
            //            } else {
            //System.out.println("===================================================");
            //System.out.println(xc1);
            //System.out.println("---------------------------------------------------");
            //System.out.println(xc2);
            //System.out.println("===================================================");
            //            }
            
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error creating VolumeEntry", ex);
        }
    }
    
    public boolean isEmpty() {
        return (this.myDO == null);
    }
    
    
    /**
     * Gets the object id for the Dictionary
     *
     * @return the object id.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getHandle()
    throws PapillonBusinessException {
        try {
            return this.myDO.getHandle();
        } catch (DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting Volume's handle", ex);
        }
    }
    
    
    
    /**
     * Gets the subject of the Dictionary
     *
     * @return the subject.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getTableName() {
        return this.myDO.getTableName();
    }
    
    /**
     * Gets the headword of the volumeEntry
     *
     * @return the subject.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    // FIXME: Should not be stored in a column, but should be extracted from the xml using CDM...
    // FIXME: Moreover, an entry may have more than one headword.
    public String getHeadword()
    throws PapillonBusinessException {
        String headword = null;
        try {
            headword = this.myDO.getHeadword();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry's headword", ex);
        }
        if (headword == null || headword.equals("")) {
            headword = getCdmHeadword();
        }
        return headword;
    }
    
    /**
     * Gets the headword, homograph number and particule of the volumeEntry
     *
     * @return the subject.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getCompleteHeadword()
    throws PapillonBusinessException {
        String headword = this.getHeadword();
        String particule = this.getParticule();
        if (particule != null && !particule.equals("")) {
            headword = particule + " " + headword;
        }
        String homograph = this.getHomographNumber();
        if (homograph != null && !homograph.equals("")) {
            headword = headword + " " + homograph;
        }
        return headword;
    }
    
    
    /**
     * Gets the headword of the volumeEntry extracted from the XML
     *
     * @return the subject.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getCdmHeadword()
    throws PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_headword, this.getSourceLanguage());
    }
    
    public void setHeadword()
    throws PapillonBusinessException {
        String word = IndexEntry.getCdmString(this, Volume.CDM_headword, this.getSourceLanguage());
        if (word != null) {
            word = word.trim();
        }
        try {
            myDO.setHeadword(word);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry's headword", ex);
        }
    }
    
    public void setHeadword(String word)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_headwordElement, word, this.getSourceLanguage());
        try {
            myDO.setHeadword(word);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry's headword", ex);
        }
    }
    /**
     * Gets the homograph number of the volumeEntry
     *
     * @return the homograph number as a String.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getHomographNumber()
    throws PapillonBusinessException {
        String hn = "";
        hn = IndexEntry.getCdmString(this, Volume.CDM_homographNumber, this.getSourceLanguage());
        return hn;
    }
    
    /**
     * Gets the dom of the entry
     *
     * @return the dom of the entry.
     */
    public org.w3c.dom.Document getDom() {
        return this.dom;
    }
    
    /**
     * Sets the dom of the entry
     */
    public void setDom(org.w3c.dom.Document myDoc) {
        this.dom = myDoc;
    }
    
    /**
     * Gets the xmlCode of the volumeEntry
     *
     * @return the subject.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getXmlCode()
    throws PapillonBusinessException {
        try {
            return this.myDO.getXmlCode();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume's xml code", ex);
        }
    }
    
    public void setXmlCode(String code)
    throws PapillonBusinessException {
        try {
            myDO.setXmlCode(code);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting entry xmlcode", ex);
        }
    }
    
    
    /* Methods for Entry ID */
    
        /* implementation of IAnswer interface */
    public void setId() throws PapillonBusinessException {
        setEntryId();
    }
    public String getId() throws PapillonBusinessException {
        return getEntryId();
    }
    
    /**
     * setEntryId sets the entry id into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setEntryId() throws PapillonBusinessException {
        String entryId = IndexEntry.getCdmString(this, Volume.CDM_entryId);
        if (entryId == null || entryId.equals("")) {
            entryId = this.createNewId() + ENTRY_ID_SUFFIX;
            IndexEntry.setCdmElement(this, Volume.CDM_entryId, entryId);
        }
        try {
            myDO.setEntryId(entryId);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry id", ex);
        }
    }
    
    
    /**
     * Gets the id of the volumeEntry
     *
     * @return the id.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getEntryId()
    throws PapillonBusinessException {
        String entryId = null;
        try {
            entryId = this.myDO.getEntryId();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry id", ex);
        }
        return entryId;
    }
    
    
    /**
     * setEntryId sets the entry id into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setContributionId() throws PapillonBusinessException {
        String entryId = IndexEntry.getCdmString(this, Volume.CDM_contributionId);
        if (entryId == null || entryId.equals("")) {
            entryId = this.createNewId() + CONTRIBUTION_ID_SUFFIX;
            IndexEntry.setCdmElement(this, Volume.CDM_contributionId, entryId);
        }
        try {
            myDO.setContributionId(entryId);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry id", ex);
        }
    }
    
    
    /**
     * Gets the id of the volumeEntry
     *
     * @return the id.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getContributionId()
    throws PapillonBusinessException {
        String entryId = null;
        try {
            entryId = this.myDO.getContributionId();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry contribution id", ex);
        }
        return entryId;
    }
    
    /**
     * setEntryId sets the entry id into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setOriginalContributionId() throws PapillonBusinessException {
        String entryId = IndexEntry.getCdmString(this, Volume.CDM_originalContributionId);
        if (entryId == null || entryId.equals("")) {
            entryId = this.getContributionId();
            IndexEntry.setCdmElement(this, Volume.CDM_originalContributionId, entryId);
        }
        try {
            myDO.setOriginalContributionId(entryId);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry original contribution id", ex);
        }
    }

    public void setOriginalContributionId(String entryId) throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_originalContributionId, entryId);
        try {
            myDO.setOriginalContributionId(entryId);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry original contribution id", ex);
        }
    }

    
    /**
     * Gets the id of the volumeEntry
     *
     * @return the id.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getOriginalContributionId()
    throws PapillonBusinessException {
        String entryId = null;
        try {
            entryId = this.myDO.getOriginalContributionId();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry original contribution id", ex);
        }
        return entryId;
    }

    /**
     * setEntryId sets the entry id into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setPreviousContributionId(String entryId) throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_previousContributionElement, entryId);
        try {
            myDO.setPreviousContributionId(entryId);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry previous contribution id", ex);
        }
    }
    
    
    /**
     * Gets the id of the volumeEntry
     *
     * @return the id.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getPreviousContributionId()
    throws PapillonBusinessException {
        String entryId = null;
        try {
            entryId = this.myDO.getPreviousContributionId();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry contribution id", ex);
        }
        return entryId;
    }

    
    /* methods for axi-reflinks */
    
    /**
     * returns ids of the lexies that are pointed by this by an axi-reflink, for lang
     */
    public String[] getReferencedLexieIds(String lang)
    throws PapillonBusinessException {
        // utilise table link
        // verifier ou il est utilise
        // si c'est plus pratique, renvoyer une collection au lieu d'un tableau de string
        return IndexEntry.getCdmStrings(this, Volume.CDM_axiReflexie, lang);
    }
    
    /**
     * returns ids of the lexies that are pointed by this by an axi-reflink, for lang
     */
    public String[] getTranslationsLexieIds(String lang)
    throws PapillonBusinessException {
        // utilise table link
        return IndexEntry.getCdmStrings(this, Volume.CDM_translationReflexie, lang);
    }
    
    /**
     * returns ids of the axies that are pointed by this by an axi-reflink
     */
    public String[] getReferencedAxieIds()
    throws PapillonBusinessException {
        // utilise table link
        
        return IndexEntry.getCdmStrings(this, Volume.CDM_axiRefaxie);
    }
    
    /* other methods */
    
    /**
     * setAuthor sets the entry author into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setAuthor() throws PapillonBusinessException {
        String author = IndexEntry.getCdmString(this, Volume.CDM_contributionAuthor);
        if (author == null || author.equals("")) {
            author = "automatic";
            IndexEntry.setCdmElement(this, Volume.CDM_contributionAuthorElement, author);
        }
        try {
            myDO.setAuthor(author);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry author", ex);
        }
    }

    public void setAuthor(String author) throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_contributionAuthorElement, author);
        try {
            myDO.setAuthor(author);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry author", ex);
        }
    }

    /**
     * Gets the author of the volumeEntry
     *
     * @return the id.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getAuthor()
    throws PapillonBusinessException {
        String author = null;
        try {
            author = this.myDO.getAuthor();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry author", ex);
        }
        return author;
    }
    
 
    /**
     * Get CreationDate of the InformationDocument
     *
     * @return CreationDate of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public java.util.Date getCreationDate() throws PapillonBusinessException {
        java.sql.Timestamp myTimestamp = null;
        try {
            myTimestamp = this.myDO.getCreationDate();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting Date", ex);
        }
        return (java.util.Date) myTimestamp;
    }
    
    /**
     * Set Date of the ContributionLog
     *
     * @param Date (as a java.util.Date) of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setCreationDate() throws PapillonBusinessException {
        java.util.Date theDate = null;
        String dateString = IndexEntry.getCdmString(this, Volume.CDM_contributionCreationDate);
        if (dateString != null && !dateString.equals("")) {
            try {
                theDate = Utility.PapillonCDMDateFormat.parse(dateString);
            } catch (java.text.ParseException ex) {
                throw new PapillonBusinessException("Error parsing a date String", ex);
            }
        }
        else {
            theDate = new java.util.Date();
            IndexEntry.setCdmElement(this, Volume.CDM_contributionCreationDateElement,Utility.PapillonCDMDateFormat.format(theDate));
       }
        try {
            myDO.setCreationDate(new java.sql.Timestamp(theDate.getTime()));
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting creation date", ex);
        }
    }

    /**
     * Get CreationDate of the InformationDocument
     *
     * @return CreationDate of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public java.util.Date getLastModificationDate() throws PapillonBusinessException {
        java.sql.Timestamp myTimestamp = null;
        try {
            myTimestamp = this.myDO.getLastModificationDate();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting last modification Date", ex);
        }
        return (java.util.Date) myTimestamp;
    }
    
    /**
     * Set Date of the ContributionLog
     *
     * @param Date (as a java.util.Date) of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLastModificationDate() throws PapillonBusinessException {
        java.util.Date theDate = new java.util.Date();
        IndexEntry.setCdmElement(this, Volume.CDM_contributionCreationDateElement,Utility.PapillonCDMDateFormat.format(theDate));
        try {
            myDO.setLastModificationDate(new java.sql.Timestamp(theDate.getTime()));
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting last modidication date", ex);
        }
    }
    
    /**
     * setAuthor sets the entry author into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setLastModificationAuthor(String author) throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_modificationAuthorElement, author);
        try {
            myDO.setLastModificationAuthor(author);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry last modification author", ex);
        }
    }
    
    /**
     * Gets the author of the volumeEntry
     *
     * @return the id.
     * @throws PapillonBusinessException if an error occurs
     *                                   retrieving data (usually due to an underlying data layer
     *                                   error).
     */
    public String getLastModificationAuthor()
    throws PapillonBusinessException {
        String author = null;
        try {
            author = this.myDO.getLastModificationAuthor();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry author", ex);
        }
        return author;
    }

    
    /**
     * setFinitionDate sets the entry finition date into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setFinitionDate()
    throws PapillonBusinessException {
        String dateString = IndexEntry.getCdmString(this, Volume.CDM_contributionFinitionDate);
        if (dateString == null || dateString.equals("")) {
            setFinitionDate(Utility.PapillonCDMDateFormat.format(new java.util.Date()));
        }
    }
    
    public void setFinitionDate(java.util.Date myDate)
    throws PapillonBusinessException {
        if (myDate != null) {
            setFinitionDate(Utility.PapillonCDMDateFormat.format(myDate));
        }
    }
    
    protected void setFinitionDate(String date)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_contributionFinitionDateElement, date);
    }
    
    /**
     * getFinitionDate gets the entry finition date from the XML code of the entry.
     *
     * @return the review date as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public java.util.Date getFinitionDate()
    throws PapillonBusinessException {
        java.util.Date resDate = null;
        String dateString = IndexEntry.getCdmString(this, Volume.CDM_contributionFinitionDate);
        if (dateString != null && !dateString.equals("")) {
            try {
                resDate = Utility.PapillonCDMDateFormat.parse(dateString);
            } catch (java.text.ParseException ex) {
                throw new PapillonBusinessException("Error parsing a date String", ex);
            }
        }
        return resDate;
    }
    
    /**
     * setReviewDate sets the entry review date into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setReviewDate()
    throws PapillonBusinessException {
        setReviewDate(Utility.PapillonCDMDateFormat.format(new java.util.Date()));
    }
    
    public void setReviewDate(java.util.Date myDate)
    throws PapillonBusinessException {
        if (myDate != null) {
            setReviewDate(Utility.PapillonCDMDateFormat.format(myDate));
        }
    }
    
    protected void setReviewDate(String date)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_contributionReviewDateElement, date);
    }
    
    
    /**
     * getReviewDate gets the entry review date from the XML code of the entry.
     *
     * @return the review date as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public java.util.Date getReviewDate()
    throws PapillonBusinessException {
        java.util.Date resDate = null;
        String dateString = IndexEntry.getCdmString(this, Volume.CDM_contributionReviewDate);
        if (dateString != null && !dateString.equals("")) {
            try {
                resDate = Utility.PapillonCDMDateFormat.parse(dateString);
            } catch (java.text.ParseException ex) {
                throw new PapillonBusinessException("Error parsing a date String", ex);
            }
        }
        return resDate;
    }
    
    /**
     * getReviewer gets the entry author into the XML code of the entry.
     *
     * @return the reviewer as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public String getReviewer()
    throws PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_contributionReviewer);
    }
    
    /**
     * setReviewer sets the entry reviewer into the XML code of the entry.
     *
     * @param the reviewer as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setReviewer(String reviewer)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_contributionReviewerElement, reviewer);
    }
    
    /**
     * getValidationDate gets the entry review date from the XML code of the entry.
     *
     * @return the validation date as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public java.util.Date getValidationDate()
    throws PapillonBusinessException {
        java.util.Date resDate = null;
        String dateString = IndexEntry.getCdmString(this, Volume.CDM_contributionValidationDate);
        if (dateString != null && !dateString.equals("")) {
            try {
                resDate = Utility.PapillonCDMDateFormat.parse(dateString);
            } catch (java.text.ParseException ex) {
                throw new PapillonBusinessException("Error parsing a date String", ex);
            }
        }
        return resDate;
    }
    
    /**
     * setValidationDate sets the entry review date into the XML code of the entry.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setValidationDate()
    throws PapillonBusinessException {
        setValidationDate(Utility.PapillonCDMDateFormat.format(new java.util.Date()));
    }
    
    public void setValidationDate(java.util.Date myDate)
    throws PapillonBusinessException {
        if (myDate != null) {
            setValidationDate(Utility.PapillonCDMDateFormat.format(myDate));
        }
    }
    
    protected void setValidationDate(String date)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_contributionValidationDateElement, date);
    }
    
    /**
     * getReviewer gets the entry author into the XML code of the entry.
     *
     * @return the reviewer as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public String getValidator()
    throws PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_contributionValidator);
    }
    
    /**
     * setValidator sets the entry reviewer into the XML code of the entry.
     *
     * @param the reviewer as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setValidator(String validator)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_contributionValidatorElement, validator);
    }
    
    /**
     * getStatus gets the entry status into the XML code of the entry.
     *
     * @return the status as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public String getStatus()
    throws PapillonBusinessException {
        String status = null;
        try {
            status = this.myDO.getStatus();
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volumeEntry status", ex);
        }
        return status;
    }
    
    /**
     * setStatus sets the entry id into the XML code of the entry.
     *
     * @param the status as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setStatus()
    throws PapillonBusinessException {
        String status = IndexEntry.getCdmString(this, Volume.CDM_contributionStatus);
        if (status == null || status.equals("")) {
            status = DEFAULT_STATUS;
            IndexEntry.setCdmElement(this, Volume.CDM_contributionStatusElement, status);
        }
        try {
            myDO.setStatus(status);
        } catch (DataObjectException ex) {
            throw new PapillonBusinessException("Error setting volumeEntry status", ex);
        }
    }

    public void setStatus(String status)
        throws PapillonBusinessException {
            IndexEntry.setCdmElement(this, Volume.CDM_contributionStatusElement, status);
            try {
                myDO.setStatus(status);
            } catch (DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volumeEntry status", ex);
            }
        }
            
    /**
     * setFinished sets the entry status to finished
     *
     * @param the author as a User
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setFinished(fr.imag.clips.papillon.business.user.User myUser)
    throws PapillonBusinessException {
        if (null != this.getStatus() && this.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
            this.setFinitionDate();
            this.setModification(myUser.getLogin(), VolumeEntry.FINISHED_STATUS);
            this.setStatus(VolumeEntry.FINISHED_STATUS);
            this.save();
            ContributionLog myContribLog = ContributionsFactory.newContributionLog(myUser, this);
            myContribLog.save();
        }
    }
    
    /**
     * setReviewed sets the entry status to reviewed
     *
     * @param the reviewer as a User
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setReviewed(fr.imag.clips.papillon.business.user.User myUser)
    throws PapillonBusinessException {
        if (null != this.getStatus() && this.getStatus().equals(VolumeEntry.FINISHED_STATUS)) {
            this.setReviewer(myUser.getLogin());
            this.setReviewDate();
            this.setModification(myUser.getLogin(), VolumeEntry.REVIEWED_STATUS);
            this.setStatus(VolumeEntry.REVIEWED_STATUS);
            this.save();
            ContributionLog myContribLog = ContributionsFactory.newContributionLog(myUser, this);
            myContribLog.save();
        }
    }
    
    /**
     * setValidated sets the entry status to validated
     *
     * @param the reviewer as a User
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setValidated(fr.imag.clips.papillon.business.user.User myUser)
    throws PapillonBusinessException {
        if (null != this.getStatus() && this.getStatus().equals(VolumeEntry.REVIEWED_STATUS)) {
            this.setValidator(myUser.getLogin());
            this.setValidationDate();
            this.setModification(myUser.getLogin(), VolumeEntry.VALIDATED_STATUS);
            this.setStatus(VolumeEntry.VALIDATED_STATUS);
            this.save();
            String origId = this.getOriginalContributionId();
            if (origId != null && !origId.equals("")) {
                VolumeEntry myEntry = VolumeEntriesFactory.findEntryByEntryId(this.getVolumeName(), origId);
                if (myEntry != null && !myEntry.isEmpty()) {
                    myEntry.setReplaced(myUser);
                }
            }
            ContributionLog myContribLog = ContributionsFactory.newContributionLog(myUser, this);
            myContribLog.save();
        }
    }
    
    /**
     * setReplaced sets the entry status to replaced
     *
     * @param the validator as a User
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setReplaced(fr.imag.clips.papillon.business.user.User myUser)
    throws PapillonBusinessException {
        if (null != this.getStatus() && this.getStatus().equals(VolumeEntry.VALIDATED_STATUS)) {
            this.setModification(myUser.getLogin(), VolumeEntry.REPLACED_STATUS);
            this.setStatus(VolumeEntry.REPLACED_STATUS);
            this.save();
            //				ContributionLog myContribLog = ContributionsFactory.newContributionLog(myUser, this);
            //				myContribLog.save();
        }
    }
    
    
    /**
     * setDeleted sets the entry status to replaced
     *
     * @param the validator as a User
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setDeleted(fr.imag.clips.papillon.business.user.User myUser)
    throws PapillonBusinessException {
        if (null != this.getStatus()) {
            this.setModification(myUser.getLogin(), VolumeEntry.DELETED_STATUS);
            this.setStatus(VolumeEntry.DELETED_STATUS);
            ContributionLog myContribLog = ContributionsFactory.newContributionLog(myUser, this);
            myContribLog.save();
            this.save();
        }
    }
    
    /**
     * getStatus gets the entry status into the XML code of the entry.
     *
     * @return the status as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public String[] getGroups()
    throws PapillonBusinessException {
        return IndexEntry.getCdmStrings(this, Volume.CDM_contributionGroup);
    }
    
    /**
     * setStatus sets the entry id into the XML code of the entry.
     *
     * @param the status as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public void setGroups(String[] groups)
    throws PapillonBusinessException {
        if (groups != null && groups.length > 0) {
            org.w3c.dom.Document myDocument = this.getDom();
            org.w3c.dom.Node groupsNode = IndexEntry.getCdmElement(this, Volume.CDM_contributionGroups);
            if (groupsNode != null) {
                while (groupsNode.hasChildNodes()) {
                    groupsNode.removeChild(groupsNode.getFirstChild());
                }
                for (int i = 0; i < groups.length; i++) {
                    String group = groups[i];
                    if (group != null && !group.equals("")) {
                        org.w3c.dom.Element myGroup = myDocument.createElement(
                                                                               this.getVolume().getCdmContributionGroup());
                        Utility.setText(myGroup, group);
                        groupsNode.appendChild(myGroup);
                    }
                }
            }
        }
    }
    
    /**
     * getPos gets the part-of-speech of the entry.
     *
     * @return the part-of-speech as a String
     * @throws PapillonBusinessException if an error occurs
     *                                   getting data (usually due to an underlying data layer
     *                                   error).
     */
    public String getPos()
    throws PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_pos, this.getSourceLanguage());
    }
    
    protected void setDictionary(Dictionary dict) {
        theDictionary = dict;
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
    
    public String getDictionaryName()
    throws PapillonBusinessException {
        return theDictionary.getName();
    }
    
    public String getDictionaryFullName()
    throws PapillonBusinessException {
        return theDictionary.getFullName();
    }
    
    public String getVolumeName()
    throws PapillonBusinessException {
        return theVolume.getName();
    }
    
    public String getSourceLanguage()
    throws PapillonBusinessException {
        return theVolume.getSourceLanguage();
    }
    
    public int getType() {
        return IAnswer.LocalEntry;
    }
        
    public Collection getClassifiedFinishedContributionIdCollection()
    throws PapillonBusinessException {
        String[] list = IndexEntry.getCdmStrings(this, Volume.CDM_previousClassifiedFinishedContribution);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                String tmp = (String) list[i];
                if ((tmp != null) && !tmp.equals("")) {
                    arrayList.add(tmp);
                }
            }
        }
        return arrayList;
    }
    
    public void initClassifiedFinishedContribution()
    throws PapillonBusinessException {
        IndexEntry.initCdmElement(this, Volume.CDM_previousClassifiedFinishedContributionElement);
    }
    
    public void addClassifiedFinishedContribution(VolumeEntry contribution)
    throws PapillonBusinessException {
        addClassifiedFinishedContribution(contribution.getContributionId());
    }
    
    public void addClassifiedFinishedContribution(String contributionId)
    throws PapillonBusinessException {
        IndexEntry.addCdmElement(this, Volume.CDM_previousClassifiedFinishedContributionElement, contributionId);
    }
    
    public String getClassifiedNotFinishedContributionId()
    throws PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_previousClassifiedNotFinishedContribution);
    }
    
    public void setClassifiedNotFinishedContribution(VolumeEntry contribution)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_previousClassifiedNotFinishedContributionElement,
                                 contribution.getContributionId());
    }
    
    public void setClassifiedNotFinishedContribution(String contributionId)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_previousClassifiedNotFinishedContributionElement, contributionId);
    }
    
    public void initClassifiedNotFinishedContribution()
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_previousClassifiedNotFinishedContributionElement, "");
    }
    
    public String getNextContributionAuthor()
    throws PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_nextContributionAuthor);
    }
    
    public void setNextContributionAuthor(String author)
    throws PapillonBusinessException {
        IndexEntry.setCdmElement(this, Volume.CDM_nextContributionAuthorElement, author);
    }
    
    
    protected String createNewId(String headword)
    throws PapillonBusinessException {
        if (headword != null) {
            headword = headword.trim();
        }
        String entryId = this.getSourceLanguage() + "." + headword + "." + this.getHandle();
        entryId = entryId.replace(' ', '_');
        entryId = entryId.replace('\'', '_');
        //System.out.println("getSourceLanguage = " + this.getSourceLanguage() + " headword = " + headword + " getHandle = " + this.getHandle());
        return Utility.encodeXMLEntities(entryId);
    }
    
    protected String createNewId()
    throws PapillonBusinessException {
        return createNewId(IndexEntry.getCdmString(this, Volume.CDM_headword, this.getSourceLanguage()));
    }
    
    
    public String getLastModificationComment()
    throws PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_modificationComment);
    }
    
    
    public void setModification(String author, String comment)
    throws PapillonBusinessException {
        
        //PapillonLogger.writeDebugMsg("VolumeEntry.setModification: " + author + " comment: " + comment);
        
        // ps pour Mathieu : TU TOUCHES PAS A CA :)
        this.setLastModificationAuthor(author);
        this.setLastModificationDate();
        IndexEntry.setCdmElement(this, Volume.CDM_modificationCommentElement, comment);
    }
    
    /**
     * getDefinition retrieves the definition of the entry
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public String getDefinition()
    throws PapillonBusinessException {
        return "   " + IndexEntry.getCdmString(this, Volume.CDM_definition);
    }
    
    /**
     * replaceData replaces all the data except the handle
     *
     * @exception PapillonBusinessException if an error occurs
     *   replacing data (usually due to an underlying data layer
     *   error).
     *
     public boolean replaceData(VolumeEntry otherEntry) throws PapillonBusinessException {
     boolean res = false;
     if (getVolumeName().equals(otherEntry.getVolumeName()) &&
     getTableName().equals(otherEntry.getTableName())) {
     setHeadword(otherEntry.getHeadword());
     // Do we have to copy the id? Quid of the existing links?
     // setId(otherEntry.getId());
     String oldId = this.getEntryId();
     setDom((org.w3c.dom.Document) otherEntry.getDom().cloneNode(true));
     setEntryId(oldId);
     setHtmlDom(otherEntry.getHtmlDom());
     res= true;
     }
     return res;
     }
     */
    
    
    public static String getContributionHeader(String templateEntry)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        org.w3c.dom.Document myDoc = XMLServices.buildDOMTree(templateEntry);
        String dmlPrefixOrig = VolumesFactory.getDmlPrefix(myDoc.getDocumentElement());
        String dmlPrefix = dmlPrefixOrig;
        String dmlXmlns = VolumesFactory.XMLNAMESPACE;
        if (dmlPrefixOrig!= null && !dmlPrefixOrig.equals("")) {
            dmlPrefix = dmlPrefixOrig + ":";
            dmlXmlns += ":" +  dmlPrefixOrig;
        }
        
        String result = "<" + dmlPrefix + contributionTag +
        " " + dmlXmlns + "=\"" + VolumesFactory.DML_URI +"\"" +
        
        " " + dmlPrefix + contributionIdAttr + "=\"\" " + dmlPrefix + originalContributionIdAttr + "=\"\">" +
        "<" + dmlPrefix + metadataTag + ">" +
        "<" + dmlPrefix + authorTag + "/>" +
        "<" + dmlPrefix + groupsTag + "/>" +
        "<" + dmlPrefix + creationDateTag + "/>" +
        "<" + dmlPrefix + finitionDateTag + "/>" +
        "<" + dmlPrefix + reviewDateTag + "/>" +
        "<" + dmlPrefix + reviewerTag + "/>" +
        "<" + dmlPrefix + validationDateTag + "/>" +
        "<" + dmlPrefix + validatorTag + "/>" +
        "<" + dmlPrefix + statusTag + "/>" +
        "<" + dmlPrefix + historyTag + ">" +
        "<" + dmlPrefix + modificationTag + ">" +
        "<" + dmlPrefix + authorTag + "/>" +
        "<" + dmlPrefix + dateTag + "/>" +
        "<" + dmlPrefix + commentTag + "/>" +
        "</" + dmlPrefix + modificationTag + ">" +
        "</" + dmlPrefix + historyTag + ">" +
        "<" + dmlPrefix + previousContributionTag + "/>" +
        "<" + dmlPrefix + previousClassifiedFinishedContributionTag + "/>" +
        //           "<" + dmlPrefix + previousClassifiedNotFinishedContributionTag + "/>" +
        //           "<" + dmlPrefix + nextContributionAuthorTag + "/>" +
        "</" + dmlPrefix + metadataTag + ">" +
        "<" + dmlPrefix + dataTag + ">";
        return result;
    }
    
    public static String getContributionFooter(String templateEntry)
			 throws fr.imag.clips.papillon.business.PapillonBusinessException {
                 org.w3c.dom.Document myDoc = XMLServices.buildDOMTree(templateEntry);
                 String dmlPrefix = VolumesFactory.getDmlPrefix(myDoc.getDocumentElement());
                 
                 if (dmlPrefix!= null && !dmlPrefix.equals("")) {
                     dmlPrefix += ":";
                 }
                 return "</" + dmlPrefix + dataTag + ">" + "</" + dmlPrefix + contributionTag + ">";
             }
    
    
    /**
     * getParticule
     * <p/>
     * function specific for the GDEF dictionary
     * retrives the value of the <particule> tag.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   replacing data (usually due to an underlying data layer
     *                                   error).
     */
    public String getParticule()
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        return IndexEntry.getCdmString(this, Volume.CDM_gdefEstParticule, this.getSourceLanguage());
    }
    
    public String getCdmString(String cdm_element)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        return IndexEntry.getCdmString(this, cdm_element, this.getSourceLanguage());
    }
    
    public Volume getAxieVolume()
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Volume resVolume = null;
        java.util.Collection axiVolCol = VolumesFactory.getVolumesArray(this.getDictionary().getName(),"axi",null);
        if (axiVolCol.iterator().hasNext()) {
            resVolume = (Volume) axiVolCol.iterator().next();
        }
        return resVolume;
    }
    
    /**
     * Saves the volume entry into the database.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   deleting data (usually due to an underlying data layer
     *                                   error).
     */
    public boolean save() throws PapillonBusinessException {
        return this.save(true);
    }
    
    public boolean save(boolean index)
    throws PapillonBusinessException {
        boolean res = true;
        //PapillonLogger.writeDebugMsg("VolumeEntry.save()");
        try {
            // Reset caches
            VolumeEntriesFactory.resetCountCache(this.getVolume().getName());
            
            // Delete index
            IndexFactory.deleteIndexForEntryId(this.getVolume().getIndexDbname(), this.getHandle());
            //
            this.setEntryId();
            this.setContributionId();
            this.setOriginalContributionId();
            // New index
            if (index) {
                res = IndexEntry.indexEntry(this);
            }
            //
            if (null != this.dom) {
                // If this.dom is null, this means that the dom object has not be accessed nor modified...
                this.myDO.setXmlCode(XMLServices.xmlCode(this.dom));
            }
            
            this.myDO.save();
        } catch (Exception ex) {
            throw new PapillonBusinessException("Error saving volumeEntry", ex);
        }
        
        //
        return res;
    }
    
    /**
     * Deletes the volume entry from the database.
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   deleting data (usually due to an underlying data layer
     *                                   error).
     */
    public void delete()
    throws PapillonBusinessException {
        Volume myVolume = this.getVolume();
        if (myVolume == null || myVolume.isEmpty()) {
            //myVolume = VolumesFactory.findVolumeByDbname(this.getTableName());
            myVolume = VolumesFactory.getVolumeByName(this.getVolumeName());
        }
        if (myVolume != null && !myVolume.isEmpty()) {
            // reset caches
            VolumeEntriesFactory.resetCountCache(myVolume.getName());
            this.delete(myVolume.getIndexDbname());
        } else {
            try {
                this.myDO.commit();
            } catch (Exception ex) {
                throw new PapillonBusinessException("Error saving volumeEntry", ex);
            }
            throw new PapillonBusinessException("Error saving volumeEntry, there is no volume so no index entered!");
        }
    }
    
    public void delete(String indexDbname)
    throws PapillonBusinessException {
        try {
            IndexFactory.deleteIndexForEntryId(indexDbname, this.getHandle());
            this.myDO.delete();
        } catch (Exception ex) {
            throw new PapillonBusinessException("Error deleting VolumeEntry", ex);
        }
    }
    
    
    /**
     * String element ...
     *
     * @throws PapillonBusinessException if an error occurs
     *                                   deleting data (usually due to an underlying data layer
     *                                   error).
     */
    public NodeList getNodes(String xpathString)
    throws PapillonBusinessException {
        try {
            Element myRoot = getDom().getDocumentElement();
            
            return org.apache.xpath.XPathAPI.selectNodeList(getDom(), xpathString);
        } catch (javax.xml.transform.TransformerException e) {
            throw new PapillonBusinessException("javax.xml.transform.TransformerException: ", e);
        }
    }
    
    
    /**
     * Undo the entry with the last classified finished contribution.
     *
     * @throws PapillonBusinessException
     */
    // FIXME: call undoMerge ????
    public VolumeEntry undoFinish()
    throws PapillonBusinessException {
        VolumeEntry previousVolumeEntry = null;
        
        //
        Collection previousFContributionIdCollection = getClassifiedFinishedContributionIdCollection();
        for (Iterator iter = previousFContributionIdCollection.iterator(); iter.hasNext();) {
            String contributionId = (String) iter.next();
            
            //
            VolumeEntry volumeEntry = VolumeEntriesFactory.findEntryByContributionId(getVolumeName(), contributionId);
            if (volumeEntry.getStatus().equals(VolumeEntry.CLASSIFIED_FINISHED_STATUS)) {
                previousVolumeEntry = volumeEntry;
                volumeEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
                volumeEntry.save();
                
                //
                Collection contributionIdCollection = volumeEntry.getClassifiedFinishedContributionIdCollection();
                for (Iterator iter2 = contributionIdCollection.iterator(); iter2.hasNext();) {
                    String contributionId2 = (String) iter2.next();
                    
                    //
                    VolumeEntry volumeEntry2 = VolumeEntriesFactory.findEntryByContributionId(getVolumeName(),
                                                                                              contributionId2);
                    if (volumeEntry2.getStatus().equals(VolumeEntry.CLASSIFIED_FINISHED_STATUS)) {
                        PapillonLogger.writeDebugMsg("undo finish: setStatus: " + VolumeEntry.MODIFIED_STATUS);
                        volumeEntry2.setStatus(VolumeEntry.MODIFIED_STATUS);
                        volumeEntry2.save();
                    }
                }
                
            } else if (volumeEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)) { // FIXME: specific to the merge !!
                volumeEntry.setStatus(VolumeEntry.FINISHED_STATUS);
                volumeEntry.save();
                
            } else {
                throw new PapillonBusinessException("Error in undoFinish()");
            }
        }
        
        // Delete contribution
        delete();
        
        //
        return previousVolumeEntry;
    }
    
    /**
     * Undo the entry with the last classified not finished contribution.
     *
     * @throws PapillonBusinessException
     */
    public VolumeEntry undoNotFinish()
    throws PapillonBusinessException {
        VolumeEntry previousVolumeEntry = null;
        
        //
        String previousNFContributionId = getClassifiedNotFinishedContributionId();
        if ((previousNFContributionId != null) && (!previousNFContributionId.equals(""))) {
            
            //
            previousVolumeEntry = VolumeEntriesFactory.findEntryByContributionId(getVolumeName(),
                                                                                 previousNFContributionId);
            previousVolumeEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
            previousVolumeEntry.save();
            
        } else {
            Collection previousFContributionIdCollection = getClassifiedFinishedContributionIdCollection();
            for (Iterator iter = previousFContributionIdCollection.iterator(); iter.hasNext();) {
                String contributionId = (String) iter.next();
                
                //
                previousVolumeEntry = VolumeEntriesFactory.findEntryByContributionId(getVolumeName(), contributionId);
                if (previousVolumeEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS)) {
                    previousVolumeEntry.setStatus(VolumeEntry.FINISHED_STATUS);
                    previousVolumeEntry.save();
                }
            }
            
        }
        
        // Delete contribution
        delete();
        
        //
        return previousVolumeEntry;
    }
    
    /**
     * Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     *
     * @param o
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * @see java.lang.Comparable#compareTo(Object)
     */
    public int compareTo(Object o) {
        try {
            return this.getCollator().compare(this.getCompleteHeadword(), ((VolumeEntry) o).getCompleteHeadword());
        } catch (PapillonBusinessException e) {
            throw new NullPointerException("Could not access to headword elements");
        }
    }
    
    public String toString() {
        try {
            return this.getCompleteHeadword();
        } catch (PapillonBusinessException e) {
            PapillonLogger.writeErrorMsg("Could not convert VolumeEntry to String: " + e.getLocalizedMessage());
            return "";
        }
    }
    
    
    
}
