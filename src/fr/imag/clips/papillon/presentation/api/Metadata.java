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

import fr.imag.clips.papillon.business.xml.XMLServices;

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
	
	protected static final String DICTLIST_XMLSTRING = "<?xml version='1.0' encoding='UTF-8'?><dictionary-metadata-list "
	+ "xmlns='http://www-clips.imag.fr/geta/services/dml'>"
	+ "</dictionary-metadata-list>";
    		
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
				if (lang !=null && !lang.equals("")) {
					return getVolumeMetadata(dictName, lang);
				}
				else {
					return getDictionaryMetadata(dictName);
				}
			}
			else {
				return getDictionaryList();			
			}
        }
	
	public static org.w3c.dom.Document getDictionaryList() 
	throws HttpPresentationException, java.io.IOException, Exception {

		org.w3c.dom.Document resultDoc = XMLServices.buildDOMTree(DICTLIST_XMLSTRING);
		
		java.util.Collection dictCollection = DictionariesFactory.getDictionariesArray();
		if (dictCollection !=null && dictCollection.size()>0) {
			java.util.Iterator dictItr = dictCollection.iterator();
			while (dictItr.hasNext()) {
				Dictionary theDict = (Dictionary) dictItr.next();
				org.w3c.dom.Document theDictDom = XMLServices.buildDOMTree(theDict.getXmlCode());
				org.w3c.dom.Node theDictImported = resultDoc.importNode(theDictDom.getDocumentElement(), true);
				resultDoc.getDocumentElement().appendChild(theDictImported);
				PapillonLogger.writeDebugMsg("Dict: " + theDict.getName());
			}
		}
		return resultDoc;			
	}

	public static org.w3c.dom.Document getDictionaryMetadata(String dictName) 
	throws HttpPresentationException, java.io.IOException, Exception {
		
		org.w3c.dom.Document resultDoc = null;
		Dictionary theDict  = DictionariesFactory.getDictionaryByName(dictName);
		if (theDict !=null && !theDict.isEmpty()) {
			resultDoc = XMLServices.buildDOMTree(theDict.getXmlCode());
			PapillonLogger.writeDebugMsg("Dict metadata: " + theDict.getName());
		}
		return resultDoc;
	}
	
	public static org.w3c.dom.Document getVolumeMetadata(String dictName, String lang) 
	throws HttpPresentationException, java.io.IOException, Exception {
		
		org.w3c.dom.Document resultDoc = null;
		java.util.Collection volumesCollection = VolumesFactory.getVolumesArray(dictName,lang,null);
		if (volumesCollection !=null && volumesCollection.size()>0) {
			Volume theVolume = (Volume) volumesCollection.iterator().next();
			PapillonLogger.writeDebugMsg("Volume metadata: " + theVolume.getName());
			resultDoc = XMLServices.buildDOMTree(theVolume.getXmlCode());
		}
		return resultDoc;
	}
	
}