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
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.Index;
import fr.imag.clips.papillon.business.dictionary.IndexFactory;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.business.utility.Utility;



/**
*  Description of the Class
 *
 * @author     mangeot
 * @created    February 24, 2006
 */
public class LookupVolume extends AbstractPO {
    
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
    public org.w3c.dom.Node getDocument()
	throws HttpPresentationException, java.io.IOException, Exception {
			
			/* initilaize response */
			java.util.Collection EntryCollection = null;
			org.w3c.dom.Document docResponse = (org.w3c.dom.Document)emptyDoc.cloneNode(true);
			// Intialize QueryRequest
			/* volume */
			String volume = myGetParameter("VOLUME");
			String headword = myGetParameter("HEADWORD");
			String handle = myGetParameter("HANDLE");
			String msort = myGetParameter("MSORT");
			if (volume != null && !volume.equals("") && 
				(headword != null && !headword.equals("") || msort != null && !msort.equals(""))) {
				Volume myVolume = VolumesFactory.getVolumeByName(volume);
				int limit = 100;
				String limitString = myGetParameter("LIMIT");
				if (limitString!=null && !limitString.equals("")) {
					limit = Integer.parseInt(limitString);
				}
				String order = myGetParameter("DIRECTION");
				String strategy = QueryBuilder.GREATER_THAN;

				if (order==null || order.equals("")) {
					order = IndexFactory.ORDER_ASCENDING;
				}
				if (order.equals(IndexFactory.ORDER_DESCENDING)) {
					strategy = QueryBuilder.LESS_THAN;
				}
				String source = myVolume.getSourceLanguage();
				
				//$headword = !empty($_REQUEST['HEADWORD']) ? 'msort > multilingual_sort(\'est\',\'' . $_REQUEST['HEADWORD'] . '\')' : 'true';
				//$operator = $direction=='asc' ? '>' : '<';
				//$msort = !empty($_REQUEST['MSORT']) ? 'msort ' . $operator . ' \'' . $_REQUEST['MSORT'] . '\'' : 'true';
				
				if (headword != null && !headword.equals("")) {
					java.util.Vector myKeys = new java.util.Vector();
					String[] Headword = new String[4];
					Headword[0] = Volume.CDM_headword;
					Headword[1] = source;
					Headword[2] = headword;
					Headword[3] = strategy;
					myKeys.add(Headword);
					EntryCollection = IndexFactory.getIndexEntriesVector(myVolume.getIndexDbname(), myKeys, order,limit);
				}
				else if (msort != null && !msort.equals("")) {
					EntryCollection = IndexFactory.getIndexEntriesVector(myVolume.getIndexDbname(), msort, strategy, order,limit);
				
				}
				if (EntryCollection!=null) {
					String stringResponse = "";
					for (java.util.Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {
						Index myIndex = (Index) myIterator.next();
						String entry = "<div class='lookupentry' title='"+ Utility.encodeXMLEntities(myIndex.getMsort())+"'><a href='javascript:void(0);' style='display:block; margin:5px;' onclick=\"lookupVolume('VOLUME="+volume+"&amp;HANDLE="+myIndex.getEntryId()+"');$(this).parent().css('font-weight','bold')\">"+Utility.encodeXMLEntities(myIndex.getValue())+"</a></div>";
						if (order.equals(IndexFactory.ORDER_DESCENDING)) {
							stringResponse = entry + stringResponse;
						}
						else {
							stringResponse += entry;
						}
					}
					stringResponse = "<?xml version='1.0' encoding='UTF-8' ?><div class='entries'>" + stringResponse + "</div>";
					docResponse = XMLServices.buildDOMTree(stringResponse);
				}
			}
			else if (volume != null && !volume.equals("") && 
					 handle != null && !handle.equals("")) {
				Volume myVolume = VolumesFactory.getVolumeByName(volume);
				java.util.Collection targets = myVolume.getTargetLanguagesArray();
				EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, this.getUser());
				
				if (EntryCollection!=null) {
					org.w3c.dom.Element rootElement = docResponse.getDocumentElement();
					for (java.util.Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {
						QueryResult myQueryResult = (QueryResult) myIterator.next();
						ResultFormatter myResultFormater = ResultFormatterFactory.getFormatter(myQueryResult, null, ResultFormatterFactory.XHTML_DIALECT,null);
						org.w3c.dom.Element newEntry = (org.w3c.dom.Element)myResultFormater.getFormattedResult(myQueryResult, this.getUser());
						rootElement.appendChild(docResponse.importNode(newEntry, true));
					}
				}
			}
			return docResponse;			
        }
}
