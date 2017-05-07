/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id: GetXmlDocument.java 700 2006-09-10 09:18:25Z mangeot $
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.1.2.1  2006/09/10 09:18:25  mangeot
 *  Resoures modified and added for playing with authentic xml plugin
 *
 *  Revision 1.7  2006/07/15 08:55:14  mangeot
 *  The BrowseVolumePage opens an HTML form that is used to lookup a volume in alphabetical order.
 *  The BrowseVolume is the server side of the AJAX script for retrieving the entries in alphabetical order
 *
 *  Revision 1.6  2006/02/27 00:04:01  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.5  2006/02/26 22:05:02  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.4  2006/02/26 20:24:30  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.3  2006/02/26 19:58:18  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.2  2006/02/26 19:21:38  mangeot
 *  Work on BrowseVolume
 *
 *  Revision 1.1  2006/02/26 14:09:32  mangeot
 *  *** empty log message ***
 *
 *
 *  -----------------------------------------------
 *  beta version
 */
package fr.imag.clips.papillon.presentation.api;

import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.user.Group;
import fr.imag.clips.papillon.business.user.User;

import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;

import fr.imag.clips.papillon.Papillon;


/**
*  Description of the Class
 *
 * @author     mangeot
 * @created    February 24, 2006
 */
public class Metadata extends fr.imag.clips.papillon.presentation.XmlBasePO {
	
	protected static final String DICTIONARY_PARAMETER = "DICTIONARY";
	protected static final String LANG_PARAMETER = "LANG";
	protected static final String ID_PARAMETER = "ID";
	
	protected static final String DICTLIST_XMLSTRING = "<?xml version='1.0' encoding='UTF-8'?><d:dictionary-metadata-list "
	+ "xmlns:d='http://www-clips.imag.fr/geta/services/dml'>"
	+ "</d:dictionary-metadata-list>";
    		
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return false;
    }
    
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean userMayUseThisPO() {
        return true;
    }
	
    /**
        *  Returns the complete document.
     *
     * @exception  Exception
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  IOException                Description of the Exception
     */
    public org.w3c.dom.Document getContent()
        throws HttpPresentationException, java.io.IOException, Exception {
			
			
			String dictName = myGetParameter(DICTIONARY_PARAMETER);
			String lang = myGetParameter(LANG_PARAMETER);
			
			if (dictName != null && !dictName.equals("")) {
                Dictionary theDict  = DictionariesFactory.getDictionaryByName(dictName);
                if (theDict !=null && !theDict.isEmpty()) {
                    if (Metadata.userCanAccessMetadata(this.getUser(),theDict)) {

				if (lang !=null && !lang.equals("")) {
					return getVolumeMetadata(dictName, lang);
				}
				else {
					return getDictionaryMetadata(theDict);
				}
                    }
                    else {
                        return null;
                    }
                }
                else {
                    return null;
                }
			}
			else {
				return getDictionaryList(this.getUser());
			}
        }
    
    public static boolean userCanAccessMetadata(User theUser, Dictionary theDict)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        boolean answer = false;
        if (theDict.getAccess() == null ||
        theDict.getAccess().equals("") ||
        theDict.getAccess().equals(Dictionary.PUBLIC_ACCESS) ||
        (theDict.getAccess().equals(Dictionary.RESTRICTED_ACCESS) && theUser != null) ||
        (theDict.getAccess().equals(Dictionary.PRIVATE_ACCESS) && theUser != null && (theUser.isAdmin() || theUser.isInGroup(Group.ADMIN_DICT_GROUP_PREFIX + theDict.getName()) || theUser.isInGroup(Group.VALIDATOR_DICT_GROUP_PREFIX + theDict.getName()) || theUser.isInGroup(Group.SPECIALIST_DICT_GROUP_PREFIX + theDict.getName()) || theUser.isInGroup(Group.READER_DICT_GROUP_PREFIX + theDict.getName())))
        ) {
            answer=true;
        }
        return answer;
    }

	public static org.w3c.dom.Document getDictionaryList(User theUser)
	throws HttpPresentationException, java.io.IOException, Exception {

		org.w3c.dom.Document resultDoc = XMLServices.buildDOMTree(DICTLIST_XMLSTRING);
		
		java.util.Collection dictCollection = DictionariesFactory.getDictionariesArray();
		if (dictCollection !=null && dictCollection.size()>0) {
			java.util.Iterator dictItr = dictCollection.iterator();
			while (dictItr.hasNext()) {
				Dictionary theDict = (Dictionary) dictItr.next();
                if (userCanAccessMetadata(theUser,theDict)) {
                
                String dictFiles = "<" + DictionariesFactory.DICTIONARY_FILES_TAG + ">"
                    + XMLServices.trimXmlDeclaration(theDict.getXmlCode());
                XslSheet defaultDictXslSheet = XslSheetFactory.getXslSheet(theDict.getName(),null,"");
                if (defaultDictXslSheet!=null) {
                    dictFiles += XMLServices.trimXmlDeclaration(defaultDictXslSheet.getXmlCode());
                }
                dictFiles += "</" + DictionariesFactory.DICTIONARY_FILES_TAG + ">";
                org.w3c.dom.Document theDictDom = XMLServices.buildDOMTree(dictFiles);
                org.w3c.dom.Node theDictImported = resultDoc.importNode(theDictDom.getDocumentElement(), true);
                resultDoc.getDocumentElement().appendChild(theDictImported);
//                PapillonLogger.writeDebugMsg("Dict metadata: " + theDict.getName());
                }
			}
		}
		return resultDoc;			
	}

    public static org.w3c.dom.Document getDictionaryMetadata( Dictionary theDict)
    throws HttpPresentationException, java.io.IOException, Exception {
        
        org.w3c.dom.Document resultDoc = null;
        if (theDict !=null && !theDict.isEmpty()) {
            PapillonLogger.writeDebugMsg("Dict metadata: " + theDict.getName());
            String dictFiles = "<d:" + DictionariesFactory.DICTIONARY_FILES_TAG + " xmlns:d='http://www-clips.imag.fr/geta/services/dml'>"
            + XMLServices.trimXmlDeclaration(theDict.getXmlCode());
            XslSheet defaultDictXslSheet = XslSheetFactory.getXslSheet(theDict.getName(),null,"");
            if (defaultDictXslSheet!=null) {
                dictFiles += XMLServices.trimXmlDeclaration(defaultDictXslSheet.getXmlCode());
            }
            dictFiles += "</d:" + DictionariesFactory.DICTIONARY_FILES_TAG + ">";
            resultDoc = XMLServices.buildDOMTree(dictFiles);
        }
        return resultDoc;
    }
    
    public static org.w3c.dom.Document postDictionary(String dictName, org.w3c.dom.Document dictDoc, User theUser)
    throws HttpPresentationException, java.io.IOException, Exception {
        Dictionary theDict = DictionariesFactory.parseDictionaryMetadata(dictDoc, null, false, false, false);
        org.w3c.dom.Document resultDoc = null;
        if (theDict !=null && !theDict.isEmpty()) {
            String userMessage = "adding " + theDict.getName() + " dictionary" + " // " + theDict.getCategory() + " // " + theDict.getType() + " // " + theDict.getDomain() + " // " + theDict.getLegal() + " // " + theDict.getSourceLanguages() + " // " + theDict.getTargetLanguages();
            PapillonLogger.writeDebugMsg(userMessage);
            theDict.save();
            resultDoc = XMLServices.buildDOMTree(theDict.getXmlCode());
        }
        return resultDoc;
    }
    
    public static org.w3c.dom.Document putDictionary(Dictionary theDict, org.w3c.dom.Document dictDoc, User theUser)
    throws HttpPresentationException, java.io.IOException, Exception {
        theDict.delete();
        theDict = DictionariesFactory.parseDictionaryMetadata(dictDoc, null, false, false, false);
        org.w3c.dom.Document resultDoc = null;
        if (theDict !=null && !theDict.isEmpty()) {
            resultDoc = XMLServices.buildDOMTree(theDict.getXmlCode());
        }
        return resultDoc;
    }
    
    public static org.w3c.dom.Document deleteDictionary(Dictionary theDict, User theUser)
    throws HttpPresentationException, java.io.IOException, Exception {
        org.w3c.dom.Document resultDoc = null;
        if (theDict !=null && !theDict.isEmpty()) {
            resultDoc = XMLServices.buildDOMTree(theDict.getXmlCode());
            theDict.deleteAll();
            Papillon.initializeAllCaches();
        }
        return resultDoc;
    }
    
    public static boolean userCanHandleMetadata(User myUser)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        boolean answer = false;
        if (null != myUser && !myUser.isEmpty() && (myUser.isAdmin())) {
            answer=true;
        }
        return answer;
    }

    public static org.w3c.dom.Document getVolumeMetadata(String dictName, String lang)
	throws HttpPresentationException, java.io.IOException, Exception {
		
		org.w3c.dom.Document resultDoc = null;
		java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
		if (volumesCollection !=null && volumesCollection.size()>0) {
			Volume theVolume = (Volume) volumesCollection.iterator().next();
			PapillonLogger.writeDebugMsg("Volume metadata: " + theVolume.getName());
            String volumeFiles = "<d:" + VolumesFactory.VOLUME_FILES_TAG + " xmlns:d='http://www-clips.imag.fr/geta/services/dml'>"
                                 + XMLServices.trimXmlDeclaration(theVolume.getXmlCode())
                                 + "<d:" + VolumesFactory.TEMPLATE_ENTRY_TAG + ">"
                                 + XMLServices.trimXmlDeclaration(theVolume.getTemplateEntry())
                                 + "</d:" + VolumesFactory.TEMPLATE_ENTRY_TAG + ">";
            if (theVolume.getTemplateInterface()!=null) {
                volumeFiles += "<d:" + VolumesFactory.TEMPLATE_INTERFACE_TAG + ">"
                                + XMLServices.trimXmlDeclaration(theVolume.getTemplateInterface())
                                + "</d:" + VolumesFactory.TEMPLATE_INTERFACE_TAG + ">";
            }
            if (theVolume.getXmlSchema()!=null) {
                volumeFiles += XMLServices.trimXmlDeclaration(theVolume.getXmlSchema());
            }
            XslSheet defaultVolumeXslSheet = XslSheetFactory.getXslSheet(theVolume.getDictname(),theVolume.getName(),"");
            if (defaultVolumeXslSheet!=null) {
                volumeFiles += XMLServices.trimXmlDeclaration(defaultVolumeXslSheet.getXmlCode());
            }
            volumeFiles += "</d:" + VolumesFactory.VOLUME_FILES_TAG + ">";
            //PapillonLogger.writeDebugMsg(volumeFiles);
			resultDoc = XMLServices.buildDOMTree(volumeFiles);
		}
		return resultDoc;
	}
    
    public static org.w3c.dom.Document postVolume(Dictionary theDict, String lang, org.w3c.dom.Document volDoc, User theUser)
    throws HttpPresentationException, java.io.IOException, Exception {
        Volume theVolume = VolumesFactory.parseVolumeMetadata(theDict, volDoc, null, false, false);
        org.w3c.dom.Document resultDoc = null;
        if (theVolume !=null && !theVolume.isEmpty()) {
            String userMessage = "adding " + theVolume.getName() + " volume: " + theVolume.getDictname() + " // "  + theVolume.getDbname() + " // " + theVolume.getSourceLanguage() + " // " + theVolume.getTargetLanguages() + " // " + theVolume.getVolumeRef();
            theVolume.save();
            PapillonLogger.writeDebugMsg(userMessage);
            fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
            VolumeEntriesFactory.resetCountCache(theVolume.getName());
            theVolume.getCount();
            Papillon.initializeAllCaches();

            resultDoc = XMLServices.buildDOMTree(theVolume.getXmlCode());
        }
        return resultDoc;
    }
 
    public static org.w3c.dom.Document putVolume(Dictionary theDict, Volume theVolume, org.w3c.dom.Document volDoc, User theUser)
    throws HttpPresentationException, java.io.IOException, Exception {
        theVolume.delete();
        theVolume = VolumesFactory.parseVolumeMetadata(theDict, volDoc, null, false, false);
        org.w3c.dom.Document resultDoc = null;
        if (theVolume !=null && !theVolume.isEmpty()) {
            resultDoc = XMLServices.buildDOMTree(theVolume.getXmlCode());
        }
        return resultDoc;
    }
    
    public static org.w3c.dom.Document deleteVolume(Volume theVolume, String lang, User theUser)
    throws HttpPresentationException, java.io.IOException, Exception {
        org.w3c.dom.Document resultDoc = null;
        if (theVolume !=null && !theVolume.isEmpty()) {
            resultDoc = XMLServices.buildDOMTree(theVolume.getXmlCode());
            theVolume.deleteAll();
            Papillon.initializeAllCaches();
        }
        return resultDoc;
    }
    
}
