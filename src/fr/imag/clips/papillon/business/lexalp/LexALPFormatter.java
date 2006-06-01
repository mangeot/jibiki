/*
 *
 *-----------------------
 * $Id$
 *------------------------
 * $Log$
 * Revision 1.6  2006/06/01 22:05:05  fbrunet
 * New interface, quick search, new contribution management (the first edition not create new contribution. New contribution is created after add, remove element, update, save, etc. in the interface window)
 *
 * Revision 1.5  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.4.4.3  2006/01/25 15:22:23  fbrunet
 * Improvement of QueryRequest
 * Add new search criteria
 * Add modified status
 *
 * Revision 1.4.4.2  2006/01/24 13:39:49  fbrunet
 * Modification view management
 * Modification LexALP postprocessing
 *
 * Revision 1.4.4.1  2005/08/31 15:01:39  serasset
 * Applied modifications done on the LEXALP_1_0 branch to updated sources of the
 * trunk to create a new updated LEXALP_1_1 branch.
 *
 * Revision 1.4.2.1  2005/07/22 13:28:32  serasset
 * Modified EditEntryInit for Lexalp. It now serves as a main page for db maintenance.
 * Added a function to get url for QueryParameter.
 * Modified the way xslsheets are handled in order to allow several xslsheet with the same name, different dicts.
 *
 * Revision 1.4  2005/07/21 09:37:47  serasset
 * LexALPLinker had a pb with package since MM modification.
 * Lexalp query menu leads to AdvancedSearch.
 * XslSheetFactory's get default xsl for dict and volume now sets the names to "" during fallback.
 *
 * Revision 1.3  2005/07/16 12:58:31  serasset
 * Added limit parameter to query functions
 * Added a parameter to Formater initializations
 * Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 * Revision 1.2  2005/05/25 13:31:08  serasset
 * Return a monolingual entry even if the lexie is not linked to an axie.
 * LexALP transformer now formats simple monolingual query results.
 *
 * Revision 1.1  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 *------------------------
 */

package fr.imag.clips.papillon.business.lexalp;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.dictionary.IAnswer;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;


public class LexALPFormatter implements ResultFormatter {
    
    
	// Constants
	// Note: I use constants extensively because the XSL transformations are a little
	// bit slow
	protected static Hashtable XslSheetCache = new Hashtable();
    
    //outils pour les transformation
	protected static final TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
	protected static final DocumentBuilderFactory myDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
	protected static DocumentBuilder myDocumentBuilder; 	
    
    protected XslSheet dictXsl = null;
    
    protected Dictionary currentDictionary;
    protected Volume sourceVolume;
    
    public void initializeFormatter(Dictionary dict, Volume vol, Object parameter, int dialect, String lang) throws PapillonBusinessException {
        currentDictionary = dict;
        sourceVolume = vol;
        try {
            if (myDocumentBuilder==null) {
                myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
            }
            // if parameter is given, it is the name of the xsl...
            if (null != parameter) {
                dictXsl = XslSheetFactory.getNamedXslSheet((String) parameter, dict.getName(), vol.getName());
            } else {
                dictXsl = XslSheetFactory.getDefaultXslSheet(dict.getName(), vol.getName());
            }
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new PapillonBusinessException("CRITICAL: error initializing document builder !", e);
        }
        
    }
    
    public Node getFormattedResult(QueryResult qr, User usr) throws PapillonBusinessException {
        try {
            Document res = myDocumentBuilder.newDocument();
            Element div = res.createElement("div");
            res.appendChild(div);
            
            // First format the source entry
            Document docSource = qr.getSourceEntry().getDom();
            
            //
            if (null != dictXsl && ! dictXsl.isEmpty()) {
                Node resultNode = formatResult(docSource, dictXsl, usr);
                div.appendChild(res.importNode(resultNode, true));
            }
            
            // FIXME : supress 
            if (qr.getResultKind() == QueryResult.AXIE_COLLECTION_RESULT) {
                // Then append each translation
                Iterator iter = qr.getLexiesCollection().iterator();
                while (iter.hasNext()) {
                    VolumeEntry ve = (VolumeEntry) iter.next();
                    if (! ve.getHandle().equals(qr.getSourceEntry().getHandle()) ) {
                        Document doc = ve.getDom();
                        if (null != dictXsl && ! dictXsl.isEmpty()) {
                            //doc = Transform(doc, dictXsl);
                            Element resultNode = (Element)formatResult(doc, dictXsl, usr);
                            resultNode.setAttribute("class", "translation");
                            div.appendChild(res.importNode(resultNode, true));
                        }
                    }
                }
            }            
            
            //
            return (Node) res.getDocumentElement();
            
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getFormattedResult()", ex);
        }	
    }
    
    
    /**
        ...
     */
    private Node formatResult(Document docSource, XslSheet xsl, User usr) throws PapillonBusinessException {
        try {
            
            //System.out.println("source " + docSource.getDocumentElement().getNodeName());
            //System.out.println("xsl " + xsl.getName());
            
            // Transform
            Document docCible = Transform(docSource, xsl);
           
            // Replace AUTO element
            NodeList list = docCible.getElementsByTagName("AUTO");
            while (list.getLength() > 0) {
                Node node = list.item(0);
                Node parentNode = node.getParentNode();
                
                //
                Node termRefAttribut = node.getAttributes().getNamedItem("termRef");
                String termRef = termRefAttribut.getNodeValue();
                Node langAttribut = node.getAttributes().getNamedItem("lang");
                String lang = langAttribut.getNodeValue();
                Node xpathAttribut = node.getAttributes().getNamedItem("xpath");
                String xpath = xpathAttribut.getNodeValue();
                Node xslNameAttribut = node.getAttributes().getNamedItem("xslName");
                XslSheet newXsl = new XslSheet();
                if ( xslNameAttribut != null ) {
					//FIXME: search the specified entry, then gets its dictionary and volume to correctly select the XSL
                    newXsl = XslSheetFactory.findXslSheetByName(xslNameAttribut.getNodeValue());
                }
                //Node namespaceAttribut = node.getAttributes().getNamedItem("namespace");
                
                
                /*
                // Find entry
                QueryRequest queryReq = new QueryRequest(VolumesFactory.getVolumesArrayName(null, lang, null));
                QueryCriteria criteria = new QueryCriteria();
                criteria.add("key", QueryCriteria.EQUAL, Volume.CDM_entryId);
                criteria.add("value", QueryCriteria.EQUAL, termRef);     // Termref is an entryid
                queryReq.addCriteria(criteria);
                QueryCriteria criteriaStatus = new QueryCriteria();
                criteriaStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);                  // FINISHED_STATUS
                criteriaStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.FINISHED_STATUS);
                queryReq.addCriteria(criteriaStatus);
                
                //
                Collection qrset = queryReq.findLexie(usr);
                
                // Find not finished entry if no finished entry
                // FIXME: guess user can view not finished status !!!
                if ( qrset.isEmpty()) {
                    queryReq = new QueryRequest(VolumesFactory.getVolumesArrayName(null, lang, null));
                    queryReq.addCriteria(criteria);
                    criteriaStatus = new QueryCriteria();
                    criteriaStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);                  // NOT_FINISHED_STATUS
                    criteriaStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.NOT_FINISHED_STATUS);
                    queryReq.addCriteria(criteriaStatus);
                    
                    //
                    qrset = queryReq.findLexie(usr);
                }
                */
                
                // Find entry
                QueryRequest queryReq = new QueryRequest(VolumesFactory.getVolumesArrayName(null, lang, null));
                QueryCriteria criteria = new QueryCriteria();
                criteria.add("key", QueryCriteria.EQUAL, Volume.CDM_entryId);
                criteria.add("value", QueryCriteria.EQUAL, termRef);     // Termref is an entryid
                queryReq.addCriteria(criteria);
                
                ArrayList listStatus = new ArrayList();
                QueryCriteria criteriaFinishedStatus = new QueryCriteria();
                criteriaFinishedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
                criteriaFinishedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.FINISHED_STATUS);
                listStatus.add(criteriaFinishedStatus);
                QueryCriteria criteriaModifiedStatus = new QueryCriteria();
                criteriaModifiedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);
                criteriaModifiedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.MODIFIED_STATUS);
                listStatus.add(criteriaModifiedStatus);
                queryReq.addOrCriteriaList(listStatus);
                
                //
                Collection qrset = queryReq.findLexie(usr);
                
                //if (qrset.size() == 0) {
                    
                    //
                    //parentNode.insertBefore(docCible.createElement("NORESULT"), node);
                    
                //} else {
                    
                    //
                    Iterator iter = qrset.iterator();
                    while(iter.hasNext()) {
                        QueryResult relatedQr = (QueryResult) iter.next();
                        
                        // Find nodes contingen on xpath
                        NodeList nodeL = relatedQr.getSourceEntry().getNodes(xpath);
                        
                        // Insert new nodes
                        for (int j=0; j <  nodeL.getLength(); j++) {
                            Document docXpath = myDocumentBuilder.newDocument();
                            Element result = docXpath.createElement("RESULT");
                            docXpath.appendChild(result);                        
                            Node nodeXpath = docXpath.importNode(nodeL.item(j), true);
                            result.appendChild(nodeXpath);
                            
                            //
                            if ( xslNameAttribut != null ) {
                                result = (Element) formatResult(docXpath, newXsl, usr);
                            }
                            
                            //
                            parentNode.insertBefore(docCible.importNode(result, true), node);
                        }
                    //}
                }
                
                //
                parentNode.removeChild(node);
                
                // Here because Res change after removeChild and appendChild methods
                list = docCible.getElementsByTagName("AUTO");
                
            }
            
            //
            return docCible.getDocumentElement();
                
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getFormattedResult()", ex);
        }	
    }    
    
    
	/**
        Transform the xml source by processing it with an xsl sheet.
	 */
    protected static Document Transform(Node xmlSource, XslSheet xslSheet)
		throws fr.imag.clips.papillon.business.PapillonBusinessException,
		javax.xml.transform.TransformerConfigurationException,
		javax.xml.parsers.ParserConfigurationException,
		javax.xml.transform.TransformerException,
		java.io.UnsupportedEncodingException,
		java.io.IOException {
            
			Transformer myTransformer = (Transformer)XslSheetCache.get(xslSheet.getHandle());
			if (myTransformer==null) {
				myTransformer = myTransformerFactory.newTransformer(new StreamSource(new StringReader (xslSheet.getCode())));
				XslSheetCache.put(xslSheet.getHandle(),myTransformer);
			}
			//the result
			if (myDocumentBuilder==null) {
				myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
			}
			Document newDocument= myDocumentBuilder.newDocument();
			//the transformation
			// is there a way to obtain a dom result which is a text string?
			myTransformer.transform (new DOMSource(xmlSource), new DOMResult(newDocument));
			return newDocument;
		}
}


















