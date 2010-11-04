/*
 *
 *-----------------------
 * $Id: LexALPFormatter.java,v 1.14 2007/02/07 13:58:57 fbrunet Exp $
 *------------------------
 * $Log: LexALPFormatter.java,v $
 * Revision 1.14  2007/02/07 13:58:57  fbrunet
 * added message before axies are merged and undo process if the merge is not correct.
 *
 * Revision 1.13  2007/01/15 17:12:18  serasset
 * Several notes added, suppressed the HTMLDOM_CACHE stuff.
 *
 * Revision 1.12  2007/01/08 15:13:42  fbrunet
 * Correction of th xml attribut bug in ContributionHeader (VolumeEntry class)
 *
 * Revision 1.11  2006/11/09 09:04:42  fbrunet
 * *** empty log message ***
 *
 * Revision 1.10  2006/09/19 08:15:22  fbrunet
 * *** empty log message ***
 *
 * Revision 1.9  2006/09/18 12:24:54  fbrunet
 * - add xsl cascading to lexalp formatter (in xsl view, add tag nextXsl with dictionaryName, volumeName and xslName attributes)
 *
 * Revision 1.8  2006/09/11 19:57:48  fbrunet
 * - bug correction : interface edition (link axie to another axi)
 *
 * Revision 1.7  2006/08/10 22:17:13  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
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

package fr.imag.clips.papillon.business.pivax;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.xml.sax.SAXException;

import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.dictionary.IAnswer;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import fr.imag.clips.papillon.presentation.Quick;

public class PivaxQuickFormatter implements ResultFormatter {
    
    
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
    
    //
    private final boolean DEBUG = false;
    
    //
    private String XsltQuickName = "Quick";
    
    //
    public void initializeFormatter(Dictionary dictionary, Volume volume, Object parameter, int dialect, String lang) throws PapillonBusinessException {
        
        try {
            
            //
            String dictionaryName = dictionary.getName();
            String volumeName = volume.getName();
            
            //
            if (myDocumentBuilder==null) {
                myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
            }
            
            //
            dictXsl = getXslSheet(dictionaryName, volumeName, (String) parameter);
            
            //PapillonLogger.writeDebugMsg("PivaxFormatter.initializeFormatter() dictXsl.getName(): " + dictXsl.getName());
                            
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new PapillonBusinessException("CRITICAL: error initializing document builder !", e);
        }
        
    }
    
    
    //
    public Node getFormattedResult(QueryResult qr, User usr) throws PapillonBusinessException {
        try {
            //
            if (DEBUG) PapillonLogger.writeDebugMsg("PivaxFormatrer : begin getFormattedResult");
            
            // Get document source
            Document docSource = qr.getSourceEntry().getDom();
            Element handler = docSource.createElement("handler");
            handler.setAttribute("handler", String.valueOf(qr.getSourceEntry().getHandle()));
            docSource.appendChild(handler);
    
            // Create document result
            Document res = myDocumentBuilder.newDocument();
            Element div = res.createElement("div");
            res.appendChild(div);
            
            
            //
            if (null != dictXsl && !dictXsl.isEmpty()) {

                //PapillonLogger.writeDebugMsg("PivaxFormatter.getFormattedResult dictXsl.getCode(): " + dictXsl.getCode());
                //PapillonLogger.writeDebugMsg("PivaxFormatter.getFormattedResult qr.getResultKind(): " + qr.getResultKind());
                
                // Format document source
                Node resultNode = formatResult(docSource, dictXsl, usr);
                Node srcEntry = addButtons(resultNode, qr.getSourceEntry());
                div.appendChild(res.importNode(srcEntry, true));
            }
            
            // Add 
            // FIXME : supress, find another solution ()
            if (qr.getResultKind() == QueryResult.AXIE_COLLECTION_RESULT) {
            	
            	// PapillonLogger.writeDebugMsg("PivaxFormatter.getFormattedResult qr.getLexiesCollection(): " + qr.getLexiesCollection().size());
            	
                // Then append each translation
                Iterator iter = qr.getLexiesCollection().iterator();
                while (iter.hasNext()) {
                    VolumeEntry ve = (VolumeEntry) iter.next();
                    
                    //
                    if (ve.getHandle() != qr.getSourceEntry().getHandle() ) { //don't show reverse
                        Document doc = ve.getDom();
                        
                        //
                        if (null != dictXsl && ! dictXsl.isEmpty()) {
                            
                        	// PapillonLogger.writeDebugMsg("docSourceLexieRef: " + dictXsl.getName() + " " + XMLServices.xmlCodePrettyPrinted(doc));
                            //
                            Element resultNode = (Element)formatResult(doc, dictXsl, usr);
                            resultNode.setAttribute("class", "translation");
                            Node targetNode = addButtons(resultNode, ve);
                            div.appendChild(res.importNode(targetNode, true));
                        } else
                        	PapillonLogger.writeDebugMsg("PivaxFormatter.getFormattedResult dictXsl is NULL");
                    }
                }
            }            
            
            //
            if (DEBUG) PapillonLogger.writeDebugMsg("PivaxFormatrer : end getFormattedResult");
            
            // PapillonLogger.writeDebugMsg("docSourceRoot: " + XMLServices.xmlCodePrettyPrinted(res));
            
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
        	//Test
        	PapillonLogger.writeDebugMsg(xsl.getName());
        	PapillonLogger.writeDebugMsg(XMLServices.xmlCodePrettyPrinted(docSource));
        	
            // init
            boolean isTransform = true;
            Document docCible = null;
                
            //
            while (isTransform) {
                
                // Transform
                docCible = Transform(docSource, xsl);
                
                // Replace FindReference element by ResultReference
                // attributes :  termReference, lang, xpath, xslName, dictionaryName, volumeName, ...
                NodeList list = docCible.getElementsByTagName("FindReference");
                while (list.getLength() > 0) {
                    Node node = list.item(0);
                    Node parentNode = node.getParentNode();
                    
                    
                    //
                    Node termRefAttribut = node.getAttributes().getNamedItem("termReference");
                    String termRef = termRefAttribut.getNodeValue();
                    if (DEBUG) PapillonLogger.writeDebugMsg("PivaxFormatter: " + termRef);
                    Node langAttribut = node.getAttributes().getNamedItem("lang");
                    String lang = langAttribut.getNodeValue();
                    if (DEBUG) PapillonLogger.writeDebugMsg("PivaxFormatter: " + lang);
                    Node xpathAttribut = node.getAttributes().getNamedItem("xpath");
                    String xpath = xpathAttribut.getNodeValue();
                    if (DEBUG) PapillonLogger.writeDebugMsg("PivaxFormatter: " + xpath);
                    Node xslNameAttribut = node.getAttributes().getNamedItem("xslName");
                    Node dictionaryNameAttribut = node.getAttributes().getNamedItem("dictionaryName");
                    Node volumeNameAttribut = node.getAttributes().getNamedItem("volumeName");
                    //Node namespaceAttribut = node.getAttributes().getNamedItem("namespace");
                    
                    //
                    String xslName = "";
                    if ( xslNameAttribut != null ) { xslName = xslNameAttribut.getNodeValue(); }
                    
                    //
                    String dictionaryName = "";
                    if ( dictionaryNameAttribut != null ) { dictionaryName = dictionaryNameAttribut.getNodeValue(); }
                    
                    //
                    String volumeName = "";
                    if ( volumeNameAttribut != null ) { volumeName = volumeNameAttribut.getNodeValue(); }
                    
                    //FIXME: search the specified entry, then gets its dictionary and volume to correctly select the XSL
                    //newXsl = XslSheetFactory.findXslSheetByName(xslNameAttribut.getNodeValue());
                    XslSheet newXsl = XslSheetFactory.getXslSheet(dictionaryName, volumeName, xslName);
                    //System.out.println("XslSheetFactory.getXslSheet(" + dictionaryName + ", " + volumeName + ", " + xslName + ") -> " + xpath);
                    
                    
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
                    // FIXME : Change DB to do quick entry id search !
                    QueryRequest queryReq = new QueryRequest(VolumesFactory.getVolumesArray(null, lang, null));
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
                    
                    //
                    Iterator iter = qrset.iterator();
                    while(iter.hasNext()) {
                        QueryResult relatedQr = (QueryResult) iter.next();
                        
                        // Find nodes with xpath
                        NodeList nodeL = relatedQr.getSourceEntry().getNodes(xpath);
                        
                        // Insert new nodes
                        for (int j=0; j <  nodeL.getLength(); j++) {
                            Document docXpath = myDocumentBuilder.newDocument();
                            Element result = docXpath.createElement("ResultReference");
                            docXpath.appendChild(result);                        
                            Node nodeXpath = docXpath.importNode(nodeL.item(j), true);
                            result.appendChild(nodeXpath);
                            
                            //
                            if ( newXsl != null ) {
                                result = (Element) formatResult(docXpath, newXsl, usr);
                            }
                            
                            //
                            if (DEBUG) PapillonLogger.writeDebugMsg("PivaxFormatter: " +  fr.imag.clips.papillon.business.xml.XMLServices.NodeToString(result));
                            parentNode.insertBefore(docCible.importNode(result, true), node);
                        }
                    }
                    
                    //
                    parentNode.removeChild(node);
                    
                    // Here because Res change after removeChild and appendChild methods
                    list = docCible.getElementsByTagName("FindReference");
                }
                
                // Manage xsl cascading !!
                NodeList nextXslList = docCible.getElementsByTagName("nextXsl"); 
                /// fixme : id !!! supress ... not in xsl file !
                
                if (nextXslList.getLength() > 0) {
                    Node nextXsl = nextXslList.item(0);
                    
                    //
                    Node nextXslNameAttribut = nextXsl.getAttributes().getNamedItem("xslName");
                    Node nextDictionaryNameAttribut = nextXsl.getAttributes().getNamedItem("dictionaryName");
                    Node nextVolumeNameAttribut = nextXsl.getAttributes().getNamedItem("volumeName");
                    
                    //
                    String nextXslName = "";
                    if ( nextXslNameAttribut != null ) { nextXslName = nextXslNameAttribut.getNodeValue(); }
                    
                    //
                    String nextDictionaryName = "";
                    if ( nextDictionaryNameAttribut != null ) { nextDictionaryName = nextDictionaryNameAttribut.getNodeValue(); }
                    
                    //
                    String nextVolumeName = "";
                    if ( nextVolumeNameAttribut != null ) { nextVolumeName = nextVolumeNameAttribut.getNodeValue(); }
                    
                    //
                    xsl = XslSheetFactory.getXslSheet(nextDictionaryName, nextVolumeName, nextXslName);
                    isTransform = true;
                    docSource = docCible;
                    
                    // erase node nextXsl !!!!
                        
                } else {
                    isTransform = false;
                }
                
            }
            
            /*
            // Manage entry actions
            Element actionElement = docCible.getElementById("actions");
            if (true && (actionElement!=null)) {
                // Replace actions
                
                
            } else if (actionElement!=null) {
                // Delete actions ...
                
                actionElement.getParentNode().removeChild(actionElement);
                
            }
            */
            
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
            
            // Find transformer
            // FIXME: if transformer is null ? 
			Transformer myTransformer = xslSheet.getTransformer();
            
			// The source
			if (myDocumentBuilder==null) {
				myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
			}
			Document newDocument= myDocumentBuilder.newDocument();
			
            //
			myTransformer.transform (new DOMSource(xmlSource), new DOMResult(newDocument));
			
            //
            return newDocument;
		}


/** 
* Return the xsl sheet corresponding to the name, dictionary name and volumename
*
* @param String
* @param String
* @param String
*
* @return XslSheet
*     
* @exception PapillonBusinessException
*/    
public static XslSheet getXslSheet(String dictionaryName, String volumeName, String Name) 
throws PapillonBusinessException {
    
    XslSheet theXsl = null;
    
    // find specific xsl
    
    // PapillonLogger.writeDebugMsg("PivaxFormatter.getXslSheet() " + dictionaryName + " " + volumeName + " " + Name);
    theXsl = XslSheetFactory.getXslSheet(dictionaryName, volumeName, Name);
    
    // find specific xsl
    if (theXsl == null) {
        theXsl =  XslSheetFactory.getXslSheet(dictionaryName, "", Name);
    }
    
    // find specific xsl
    if (theXsl == null) {
        theXsl =  XslSheetFactory.getXslSheet("", "", Name);
    }    
    
    // find defaut
    if (theXsl == null) {
        theXsl =  XslSheetFactory.getXslSheet(dictionaryName, volumeName, "");
    }
    
    // find defaut
    if (theXsl == null) {
        theXsl =  XslSheetFactory.getXslSheet(dictionaryName, "", "");
    }
    
    
    // find defaut
    if (theXsl == null) {
        theXsl =  XslSheetFactory.getXslSheet("", "", "");
    }
    
    if (theXsl == null)
    	PapillonLogger.writeDebugMsg("PivaxFormatter.getXslSheet() XslSheet is NULL");
    //
    return theXsl;
}

	/**
	 * 
	 * @param entryNode: la présentation HTML d'une entrée
	 * @param entry: Contenue d'entrée
	 * @return Node racine de la présentation HTML d'un tableau contenant la présentation d'entrée avec les buttons à manipuler 
	 */
	private Node addButtons(Node entryNode, VolumeEntry entry) {
		String tableau = "<table>";
		tableau += "<tr><td> </td><td> </td></tr>";
		tableau += "</table>";
		try {
			Document doc = myDocumentBuilder.parse(tableau);
			Element tdContent = (Element) doc.getElementsByTagName("td").item(0);
			Element tdButtons = (Element) doc.getElementsByTagName("td").item(1);
			
			tdContent.appendChild(doc.importNode(entryNode, true));
			tdButtons.appendChild(doc.importNode(new Quick().getButtons(entry), true));
			
			return doc.getElementsByTagName("table").item(0);
		} catch (SAXException ex) {
			
		} catch (IOException exIO) {
			
		}
		return null;
	}
}



















