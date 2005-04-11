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
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.11  2005/03/30 11:17:07  mangeot
 * Modified table contributions: replaced originalhandle by originalid
 * Corrected a few bugs when validating an already existing entry
 *
 * Revision 1.2.2.10  2005/03/29 15:27:09  mangeot
 * Bug fix when trying to create a contribution from an existing entry
 *
 * Revision 1.2.2.9  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2.2.8  2005/03/14 08:47:11  mangeot
 * MemoryOverflow bug resolved. Occured wuth the XPathContext. It stores its context each time an execute is executed so it is better to create a new XPathContext everytime.
 *
 * Revision 1.2.2.7  2005/01/28 23:01:09  mangeot
 * Fixed bugs in the editor. It seems to work now. More testing needed anyway...
 *
 * Revision 1.2.2.6  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.2.2.5  2005/01/27 23:55:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.4  2005/01/27 19:29:21  mangeot
 * Implemented the HtmlDom cache, it increases speed drastically.
 * Still does not compile after an ant clean
 *
 * Revision 1.2.2.3  2005/01/27 18:09:28  mangeot
 * Simple dictionary lookup is now working for GDEF.
 * Does not compile yet but cvs commit for backup
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
 * Revision 1.12  2004/10/28 10:38:11  mangeot
 * Fixed some bugs that affected the dictd server
 * Modified some methods in order to display a text entry in the dictd server
 *
 * Revision 1.11  2004/03/11 16:12:23  mangeot
 * *** empty log message ***
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

import java.util.Locale;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.CurrentDBTransaction;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.Utility;

/**
* Represents a Dictionary Entry. 
 */
public class VolumeEntry implements IAnswer {    

	public static boolean CACHE_HTMLDOM = true; 

    /**
	* The DO of the Dictionary.
     */
    protected org.w3c.dom.Document dom = null;
    protected org.w3c.dom.Document htmldom = null;
    protected Dictionary theDictionary;
    protected Volume theVolume;
    
    protected VolumeEntryDO myDO = null;
	
    /**
		* The public constructor.
     * Should find a better method instead of these if elsif elsif
     * How to do it ?
     */
	
    public VolumeEntry(Dictionary newDict, Volume newVolume) throws PapillonBusinessException {
        try {
            this.myDO = VolumeEntryDO.createVirgin(newVolume.getDbname(), CurrentDBTransaction.get());
			this.setVolume(newVolume);
			this.setDictionary(newDict);
        }
        catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty Volume", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty Volume", ex);
        }
    }
	
    /** The protected constructor
		*
		* @param theDisc. The data object of the Volume.
		*/
    protected VolumeEntry(Dictionary newDict, Volume newVolume, VolumeEntryDO theVolumeEntryDO) 
        throws PapillonBusinessException  {
			try {
				this.myDO = theVolumeEntryDO;
				this.dom = Utility.deSerializeDocument(theVolumeEntryDO.getDom());
				this.htmldom = Utility.deSerializeDocument(theVolumeEntryDO.getHtmldom());
				this.setVolume(newVolume);
				this.setDictionary(newDict);
			}
			catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error creating axie ", ex);
			}
			
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
				throw new PapillonBusinessException("Error getting Volume's handle", ex);
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
		return this.myDO.getTableName(); 
	}
	
	/**
		* Gets the headword of the volumeEntry
	 *
	 * @return the subject.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String getHeadword() throws PapillonBusinessException {
		try {
			return this.myDO.getHeadword();
		} catch(DataObjectException ex) {
			throw new PapillonBusinessException("Error getting volumeEntry's headword", ex);
		} 
	}
	
	public void setHeadword(String word)
		throws PapillonBusinessException {
			try {
				myDO.setHeadword(word);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting volumeEntry's headword", ex);
			}
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
	
	
	/**
		* Gets the html dom of the entry
	 *
	 * @return the html dom of the entry.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 **/
	public org.w3c.dom.Document getHtmlDom() {
		if (CACHE_HTMLDOM) {
			return this.htmldom;
		}
		else {
			return null;
		}
	}
	
	/**
		* Sets the html dom of the entry
	 *
	 * @return void.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 **/
	public void setHtmlDom(org.w3c.dom.Document myDoc) {
		this.htmldom = myDoc;
	}
	
	
	/**
		* Gets the xmlCode of the volumeEntry
	 *
	 * @return the subject.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String getXmlCode()
		throws PapillonBusinessException {
			try {
				return this.myDO.getXmlCode();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting volume's xml code", ex);
			} 
		}
	
	public void setXmlCode(String code)
		throws PapillonBusinessException {
			try {
				myDO.setXmlCode(code);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting entry xmlcode", ex);
			}
		}
	
	/* Methods added for compatibility with IAnswer interface */
	public void setId() throws PapillonBusinessException {
		this.setId(this.createNewId());
	}
	
	protected void setId(String newId) throws PapillonBusinessException {
		org.w3c.dom.Node idNode = ParseVolume.getCdmElement(this, Volume.CDM_entryId);
		if (idNode != null) {
			idNode.setNodeValue(newId);
		}
	}
	
	public String getId()  throws PapillonBusinessException {
		return ParseVolume.getCdmString(this, Volume.CDM_entryId);
	}

	public String getPos()  throws PapillonBusinessException {
		return ParseVolume.getCdmString(this, Volume.CDM_pos,this.getSourceLanguage());
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
	
	public int getType() {
		return IAnswer.LocalEntry;
	}
	
	protected String createNewId (String headword) throws PapillonBusinessException {
		String entryId = this.getSourceLanguage() + "." +
		headword + "." + this.getHandle();
		entryId = entryId.replace(' ', '_');
		return Utility.encodeXMLEntities(entryId);
	}
	
	protected String createNewId () throws PapillonBusinessException {
		return createNewId(this.getHeadword());
	}
	
	public void setModification(String author, String comment) throws PapillonBusinessException {
		Volume myVolume = this.getVolume();	
		Document myDocument = this.getDom();	
		org.w3c.dom.Node myEntry = ParseVolume.getCdmElement(this, Volume.CDM_entry);
		fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("setModification: " + Volume.CDM_entry);
		org.w3c.dom.Node myHistory = ParseVolume.getCdmElement(this, Volume.CDM_history);
		if (myHistory == null) {
			fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("setModification: myHistory null");
			myHistory = myDocument.createElement(myVolume.getCdmHistory());
			myEntry.appendChild(myHistory);			
		}
		org.w3c.dom.Node myModification = myDocument.createElement(myVolume.getCdmModification());
		org.w3c.dom.Element myAuthor = myDocument.createElement(myVolume.getCdmAuthor());
		org.w3c.dom.Element myComment = myDocument.createElement(myVolume.getCdmComment());
		org.w3c.dom.Element myDate = myDocument.createElement(myVolume.getCdmDate());
		Utility.setText(myAuthor,author);
		Utility.setText(myDate,new java.util.Date().toString());
		Utility.setText(myComment,comment);
		myModification.appendChild(myAuthor);
		myModification.appendChild(myComment);
		myModification.appendChild(myDate);
		myHistory.appendChild(myModification);
	}
	
    /**
     * getDefinition
     *
	 * function 
	 * retrives the definition.
	 * 
     * @exception PapillonBusinessException if an error occurs
     *   replacing data (usually due to an underlying data layer
	 *   error).
     */
	public String getDefinition() throws PapillonBusinessException {
		String definition = "   ";
		org.w3c.dom.Node myNode = ParseVolume.getCdmElement(this,Volume.CDM_definition);
		if (myNode != null) {
			definition = myNode.getNodeValue();
		}
		return definition;
	}
	
	
    /**
        * replaceData replaces all the data except the handle
     *
     * @exception PapillonBusinessException if an error occurs
     *   replacing data (usually due to an underlying data layer
                        *   error).
     */
	 public boolean replaceData(VolumeEntry otherEntry) throws PapillonBusinessException {
		boolean res = false;
		if (getVolumeName().equals(otherEntry.getVolumeName()) &&
			getTableName().equals(otherEntry.getTableName())) {
			setHeadword(otherEntry.getHeadword());
			// Do we have to copy the id? Quid of the existing links?
			// setId(otherEntry.getId());
			String oldId = this.getId();
			setDom((org.w3c.dom.Document) otherEntry.getDom().cloneNode(true));
			setId(oldId);
			setHtmlDom(otherEntry.getHtmlDom());
			res= true;
		}
		return res;
	 }

    /**
     * getParticule
     *
	 * function specific for the GDEF dictionary
	 * retrives the value of the <particule> tag.
	 * 
     * @exception PapillonBusinessException if an error occurs
     *   replacing data (usually due to an underlying data layer
	 *   error).
     */
	 public String getParticule() throws fr.imag.clips.papillon.business.PapillonBusinessException {
		String res = "";
		
		if (this.getVolumeName().equals("GDEF_est")) {
			org.w3c.dom.Node myNode = ParseVolume.getCdmElement(this,Volume.CDM_gdefEstParticule,this.getSourceLanguage());
			if (myNode != null) {
				res = myNode.getNodeValue();
			}
		}
		return res;
	 }
	
	public static void setCacheHtmlDom(boolean cache) {
		CACHE_HTMLDOM = cache;
	}
	
	
	/**
		* Saves the volume entry into the database.
	 *
	 * @exception PapillonBusinessException if an error occurs
	 *   deleting data (usually due to an underlying data layer
						*   error).
	 */	
	public boolean save() 
		throws PapillonBusinessException {
			boolean res = false;
			try {
				IndexFactory.deleteIndexForEntryId(this.getVolume().getIndexDbname(), this.getHandle());
				res = ParseVolume.parseEntry(this);
				this.myDO.setXmlCode(Utility.NodeToString(this.dom));
				this.myDO.setDom(Utility.serializeDocument(this.dom));
				this.myDO.setHtmldom(Utility.serializeDocument(this.htmldom));
				this.myDO.commit();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error saving volumeEntry", ex);
			}
			return res;
		}
	
	/**
		* Deletes the volume entry from the database.
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
	
	public void delete(String indexDbname) 
		throws PapillonBusinessException {
			try {
				IndexFactory.deleteIndexForEntryId(indexDbname, this.getHandle());
				this.myDO.delete();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error deleting VolumeEntry", ex);
			}
		}
}
