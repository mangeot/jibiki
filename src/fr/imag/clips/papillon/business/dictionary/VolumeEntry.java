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

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.Utility;

/**
 * Represents a Dictionary Entry. 
 */
public class VolumeEntry implements IAnswer {    
    /**
     * The DO of the Dictionary.
     */
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
            this.myDO = VolumeEntryDO.createVirgin(newVolume.getDbname());
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
    protected VolumeEntry(Dictionary newDict, Volume newVolume, VolumeEntryDO theVolumeDO) 
        throws PapillonBusinessException  {
			this.myDO = theVolumeDO;
			this.setVolume(newVolume);
			this.setDictionary(newDict);
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
     * Gets the headword of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	protected String getHeadwordString() throws PapillonBusinessException {
        try {
					return this.myDO.getHeadword();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume's headword", ex);
        } 
    }
	    
	public String getHeadword () throws PapillonBusinessException {
		return getFirstItem(this.getHeadwordString());
	}

	public String getHeadwords () throws PapillonBusinessException {
		String headword = this.getHeadwordString();
		return headword.replace('#',' ').trim();
	}

    public void setHeadwords(Vector headwords)
        throws PapillonBusinessException {
            this.setHeadwords(concatenateVector(headwords));
        }
	
    public void setHeadwords(String words)
        throws PapillonBusinessException {
            try {
                myDO.setHeadword(words);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's headword", ex);
            }
        }
    /**
     * Gets the id of the entry
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getId()
        throws PapillonBusinessException {
        try {
            return this.myDO.getId();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume's id", ex);
        }
    }

    public void setId(String id)
        throws PapillonBusinessException {
        try {
		  		myDO.setId(id);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting entry id", ex);
        }
    }

    /**
		* Gets the pronunciation of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    protected String getPronunciationString() throws PapillonBusinessException {
		try {
            return this.myDO.getPronunciation();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume pronunciation", ex);
        }
    }

	public String getPronunciation () throws PapillonBusinessException {
		return getFirstItem(this.getPronunciationString());
	}

	public String getPronunciations () throws PapillonBusinessException {
		String myString = this.getPronunciationString();
		return myString.replace('#',' ').trim();
	}

    public void setPronunciations(Vector words)
        throws PapillonBusinessException {
            this.setPronunciations(concatenateVector(words));
        }

    public void setPronunciations(String words)
        throws PapillonBusinessException {
            try {
                myDO.setPronunciation(words);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's Pronunciation", ex);
            }
        }
	
    /**
		* Gets the reading of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
						  *   error).
     */
    protected String getReadingString() throws PapillonBusinessException {
		try {
            return this.myDO.getReading();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume reading", ex);
        }
    }

	public String getReading () throws PapillonBusinessException {
		return getFirstItem(this.getReadingString());
	}

	public String getReadings () throws PapillonBusinessException {
		String myString = this.getReadingString();
		return myString.replace('#',' ').trim();
	}

    public void setReadings(Vector words)
        throws PapillonBusinessException {
            this.setReadings(concatenateVector(words));
        }

    public void setReadings(String words)
        throws PapillonBusinessException {
            try {
                myDO.setReading(words);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's Reading", ex);
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
    protected String getPosString() throws PapillonBusinessException {
		try {
            return this.myDO.getPos();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume pos", ex);
        }
    }

	public String getPos () throws PapillonBusinessException {
		return getFirstItem(this.getPosString());
	}

	public String getPoss () throws PapillonBusinessException {
		String myString = this.getPosString();
		return myString.replace('#',' ').trim();
	}

    public void setPoss(Vector words)
        throws PapillonBusinessException {
            this.setPoss(concatenateVector(words));
        }

    public void setPoss(String words)
        throws PapillonBusinessException {
            try {
                myDO.setPos(words);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's Pos", ex);
            }
        }


	/**
        * Gets the translation of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
    protected String getTranslationString() throws PapillonBusinessException {
        try {
	    return this.myDO.getTranslation();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume's Translation", ex);
        } 
    }
 
		public String getTranslation () throws PapillonBusinessException {
		return getFirstItem(this.getTranslationString());
	}

	public String getTranslations () throws PapillonBusinessException {
		String myString = this.getTranslationString();
		return myString.replace('#',' ').trim();
	}

    public void setTranslations(Vector words)
        throws PapillonBusinessException {
            this.setTranslations(concatenateVector(words));
        }

    public void setTranslations(String words)
        throws PapillonBusinessException {
            try {
                myDO.setTranslation(words);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's Translation", ex);
            }
        }

	/**
        * Gets the xmlCode of the volume
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

	/**
        * Gets the key1 of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
	protected String getKey1String() throws PapillonBusinessException {
		try {
            return this.myDO.getKey1();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume key1", ex);
        }
	}

	public String getKey1 () throws PapillonBusinessException {
		return getFirstItem(this.getKey1String());
	}

	public String getKey1s () throws PapillonBusinessException {
		String myString = this.getKey1String();
		return myString.replace('#',' ').trim();
	}

    public void setKey1s(Vector words)
        throws PapillonBusinessException {
            this.setKey1s(concatenateVector(words));
        }

    public void setKey1s(String words)
        throws PapillonBusinessException {
            try {
                myDO.setKey1(words);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's Key1", ex);
            }
        }


	/**
        * Gets the Key2 of the volume
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
                          *   error).
     */
	protected String getKey2String() throws PapillonBusinessException {
		try {
            return this.myDO.getKey2();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting volume key2", ex);
        }
    }

	public String getKey2 () throws PapillonBusinessException {
		return getFirstItem(this.getKey2String());
	}

	public String getKey2s () throws PapillonBusinessException {
		String myString = this.getKey2String();
		return myString.replace('#',' ').trim();
	}

    public void setKey2s(Vector words)
        throws PapillonBusinessException {
            this.setKey2s(concatenateVector(words));
        }

    public void setKey2s(String words)
        throws PapillonBusinessException {
            try {
                myDO.setKey2(words);
            } catch(DataObjectException ex) {
                throw new PapillonBusinessException("Error setting volume's Key2", ex);
            }
        }


    /* Methods added for compatibility with IAnswer interface */
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

		public String createNewId (String headword) throws PapillonBusinessException {
			String entryId = this.getSourceLanguage() + "." +
			headword + "." + this.getHandle();
			entryId = entryId.replace(' ', '_');
			return Utility.encodeXMLEntities(entryId);
		}
		
		public String createNewId () throws PapillonBusinessException {
			return createNewId(this.getHeadword());
		}
		
		protected static String getFirstItem(String myString) {
		if (myString != null && myString.length()>2) {
			if (myString.startsWith("#")) {
				myString =  myString.substring(1);
			}
			if (myString.endsWith("#")) {
				myString =  myString.substring(0,myString.indexOf('#'));
			}
		}
		return myString;
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
	
	protected String[] getIndexArray() throws PapillonBusinessException {
		String indexString = this.getHeadwordString() + this.getPronunciationString() + this.getReadingString() + this.getTranslationString() + this.getKey1String() + this.getKey2String();
		return indexString.split("#");	 
		}
	
	public Vector getIndexVector()  throws PapillonBusinessException {
		Vector myVect = new Vector();
		String[] array = this.getIndexArray();
		for (int i=0;i<array.length;i++) {
			myVect.add(array[i]);
		}
		
		myVect.add(this.getId());
		
		return myVect;
	}
	
		public void extractDataFromDOM(Document docXml) throws fr.imag.clips.papillon.business.PapillonBusinessException {
			try {

				Volume volume  = this.getVolume();
				volume.loadCDMElements();

	//	PapillonLogger.writeDebugMsg("The xml code:");
	//	PapillonLogger.writeDebugMsg(Utility.NodeToString(docXml));
				Vector myHeadwords = getValues(docXml, volume.CDM_headword, volume.CDM_headword_attribute);
				myHeadwords.addAll(getValues(docXml, volume.CDM_headwordVariant, volume.CDM_headwordVariant_attribute));				
				myHeadwords.addAll(getValues(docXml, volume.CDM_writing, volume.CDM_writing_attribute));				
				this.setHeadwords(myHeadwords);
				
				String newId =	IAnswerFactory.checkAndSetNewId(this, volume, docXml, this.getHeadword());
				this.setId(newId);
				
				this.setPronunciations(getValues(docXml, volume.CDM_pronunciation, volume.CDM_pronunciation_attribute));
				this.setReadings(getValues(docXml, volume.CDM_reading, volume.CDM_reading_attribute));
				this.setPoss(getValues(docXml, volume.CDM_pos, volume.CDM_pos_attribute));
				this.setTranslations(getValues(docXml, volume.CDM_translation, volume.CDM_translation_attribute));
				this.setKey1s(getValues(docXml, volume.CDM_databaseKey1, volume.CDM_databaseKey1_attribute));
				this.setKey2s(getValues(docXml, volume.CDM_databaseKey2, volume.CDM_databaseKey2_attribute));
				this.setXmlCode(Utility.NodeToString(docXml));
				}
				catch(Exception ex) {
					throw new PapillonBusinessException("Exception in extractDataFromDOM()", ex);
				}
			}
	
		public static String getValue(Document docXml, String myTag, String myTagAttribute) {
			Vector res = getValues( docXml, myTag, myTagAttribute);
			String resString = null;
				if (res.size()>0) {
					resString = (String) res.firstElement();
				}
				return resString;
			}
				
			// Recuperation of a value
		public static Vector getValues(Document docXml, String myTag, String myTagAttribute) {
			Vector myValues = new Vector();
			if (myTag!=null && !myTag.equals("")) {
			NodeList myNodes = docXml.getElementsByTagName(myTag);
			if (myNodes!=null && myNodes.getLength()>0) {
				for (int i=0;i< myNodes.getLength();i++) {
					Element myElem =(Element) myNodes.item(i);
					if (myElem != null) {
						if (null != myTagAttribute && !myTagAttribute.equals("")) {
							myValues.add(myElem.getAttribute(myTagAttribute));
						}
						else {
							if (myElem.hasChildNodes()) {
								myValues.add(myElem.getFirstChild().getNodeValue());
							}
						}
					}
				}
			}
			}
			return myValues;
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
		
		if (getTableName().equals("gdefest")) {
			String tmp = getValue(Utility.buildDOMTree(getXmlCode()),"particule",null);
			if (tmp!=null) {
				res = tmp;
			}
		}
		
		return res;
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
			setHeadwords(otherEntry.getHeadwordString());
			setId(otherEntry.getId());
			setPronunciations(otherEntry.getPronunciationString());
			setReadings(otherEntry.getReadingString());
			setPoss(otherEntry.getPosString());
			setTranslations(otherEntry.getTranslationString());
			setXmlCode(otherEntry.getXmlCode());
			setKey1s(otherEntry.getKey1String());
			setKey2s(otherEntry.getKey2String());
			res= true;
		}
		return res;
	 }

    /**
        * Saves the volume entry from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
                        *   error).
     */
		public void save() throws PapillonBusinessException {
			Volume myVolume = this.getVolume();
			if (myVolume == null || myVolume.IsEmpty()) {
					myVolume = VolumesFactory.findVolumeByDbname(this.getTableName());
			}
			if (myVolume!=null && ! myVolume.IsEmpty()) {
				this.save(this.getVolume().getIndexDbname());
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

    public void save(String volumeIndexDbname) 
        throws PapillonBusinessException {
        try {
					IndexFactory.deleteIndexForEntryId(volumeIndexDbname, this.getHandle());
					IndexFactory.createIndexFromVector(volumeIndexDbname,this.getIndexVector(),this.getHandle());
		            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving volumeEntry", ex);
        }
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
            throw new PapillonBusinessException("Error deleting volume", ex);
        }
    }
}
