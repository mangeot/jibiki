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
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.5  2004/02/10 05:27:13  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.utility.Utility;

/**
 * Represents a Mailing list Dictionary. 
 */
public class RemoteEntry implements IAnswer {

    protected Dictionary theDictionary;
    protected Volume theVolume;
    protected String xmlCode;
    protected String theHeadword;
    protected String theId;

    public RemoteEntry() throws PapillonBusinessException {
    }

    public boolean IsEmpty() {
        return (this.xmlCode==null || this.xmlCode.equals(""));
    }

    public String getXmlCode() throws PapillonBusinessException {
        return xmlCode;
    }

    public void setXmlCode(String code)
        throws PapillonBusinessException {
            this.xmlCode = code;
    }

    public Dictionary getDictionary() throws PapillonBusinessException {
        return this.theDictionary;
    }

    public void setDictionary(Dictionary dict) {
        this.theDictionary = dict;
    }

    public Volume getVolume() throws PapillonBusinessException {
        return this.theVolume;
    }

    public void setVolume(Volume volume) {
        this.theVolume = volume;
    }

    public String getDictionaryName() throws PapillonBusinessException {
        return this.theDictionary.getName();
    }

    public String getDictionaryFullName() throws PapillonBusinessException {
        return this.theDictionary.getFullName();
    }

    public String getVolumeName() throws PapillonBusinessException {
        return this.theVolume.getName();
    }

    public String getSourceLanguage() throws PapillonBusinessException {
        return this.theVolume.getSourceLanguage();
    }

    public String getHandle() throws PapillonBusinessException {
        return this.theId;
    }

// compatibility with IAnswer interface
    public String getId() throws PapillonBusinessException {
        return this.theId;
    }

	public void setId(String newId) throws PapillonBusinessException {
        this.theId = newId;
    }

	public String createNewId (String headword) throws PapillonBusinessException {
		String entryId = this.getSourceLanguage() + "." +
		headword + ".";
		entryId = entryId.replace(' ', '_');
		return Utility.encodeXMLEntities(entryId);
	}

		public String createNewId () throws PapillonBusinessException {
					return createNewId(this.getHeadword());
				}		
	
    public void setHeadword(String headword) {
        this.theHeadword = headword;
    }

    public String getHeadword() {
			return this.theHeadword;
    }

    public String getHeadwords() {
			return this.theHeadword;
    }

    public int getType() {
        return IAnswer.RemoteEntry;
    }
	
	public void save() {
		;
	}
	public void delete() {
		this.xmlCode =null;
	}
}
