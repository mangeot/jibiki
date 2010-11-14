/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id: BrowseVolume.java,v 1.7.2.2 2006/11/26 12:04:29 mangeot Exp $
 *  -----------------------------------------------
 *  $Log: BrowseVolume.java,v $
 *  Revision 1.7.2.2  2006/11/26 12:04:29  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.7.2.1  2006/09/10 09:18:25  mangeot
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
package fr.imag.clips.papillon.presentation;

import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;
import fr.imag.clips.papillon.business.xml.XMLServices;



/**
*  Description of the Class
 *
 * @author     mangeot
 * @created    February 24, 2006
 */
public class LookupVolume extends XmlBasePO {
    
	protected static final String ALL_STATUS = "*ALL*";
	
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
	
	protected static org.w3c.dom.Document emptyDoc = null;
	
	static {
		try {
			emptyDoc = XMLServices.buildDOMTree("<?xml version='1.0' encoding='UTF-8' ?><div id='entries'></div>");
		}
		catch (Exception ex) {
			;
		}
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
			
			/* initilaize response */
			java.util.Collection EntryCollection = null;
			org.w3c.dom.Document docResponse = (org.w3c.dom.Document)emptyDoc.cloneNode(true);
			// Intialize QueryRequest
			/* volume */
			String volume = myGetParameter("VOLUME");
			String headword = myGetParameter("HEADWORD");
			String handle = myGetParameter("HANDLE");
			if (volume != null && !volume.equals("") && 
				headword != null && !headword.equals("")) {
				Volume myVolume = VolumesFactory.getVolumeByName(volume);
				QueryRequest query = new QueryRequest(myVolume);
				//query.setTargets(targets);
				//query.setOffset(offset);
				
				/* Limit */
				//String limitString = myGetParameter("LIMIT");			
				String limit = "5";
				/*if (limitString!=null && !limitString.equals("")) {
					limit =Integer.parseInt(limitString);
				}*/
				query.setLimit(limit);	
				
				/* headword criteria */
				QueryCriteria criteria = new QueryCriteria();
				criteria.add("key", QueryCriteria.EQUAL, Volume.CDM_headword);
				criteria.add("value", QueryCriteria.CASE_SENSITIVE_STARTS_WITH, headword);               // match headword (no case sensitive)
				query.addCriteria(criteria);
				
				/* status criteria */
				String status = myGetParameter("STATUS");
				if (status==null || status.equals("")) {
					status="validated";
				}
				if (status!=null && !status.equals(ALL_STATUS)) {
					QueryCriteria criteriaStatus = new QueryCriteria();
					criteriaStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);
					criteriaStatus.add("value", QueryCriteria.EQUAL, status);
					query.addCriteria(criteriaStatus);
				}	
				EntryCollection = query.findLexieAndTranslation(this.getUser());
			}
			else if (volume != null && !volume.equals("") && 
					 handle != null && !handle.equals("")) {
				EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, null, this.getUser());

			}
			if (EntryCollection!=null) {
				org.w3c.dom.Element rootElement = docResponse.getDocumentElement();
				for (java.util.Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {
					QueryResult myQueryResult = (QueryResult) myIterator.next();
					ResultFormatter myResultFormater = ResultFormatterFactory.getFormatter(myQueryResult, null, ResultFormatterFactory.XHTML_DIALECT,null);
					org.w3c.dom.Element newEntry = (org.w3c.dom.Element)myResultFormater.getFormattedResult(myQueryResult, this.getUser());
					rootElement.appendChild(docResponse.importNode(newEntry, true));
				}
			}
			

			return docResponse;			
        }
}
