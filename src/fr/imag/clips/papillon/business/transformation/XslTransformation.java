/*
 *
 *-----------------------
 *$Id$
 *------------------------
 *$Log$
 *Revision 1.12  2006/03/01 15:12:31  mangeot
 *Merge between maintrunk and LEXALP_1_1 branch
 *
 *Revision 1.11.2.2  2006/02/17 15:16:42  mangeot
 *Do not display the list of all XSL on the search form any more. Displays only a list of XSL descriptions
 *
 *Revision 1.11.2.1  2006/01/24 13:39:49  fbrunet
 *Modification view management
 *Modification LexALP postprocessing
 *
 *Revision 1.11  2005/08/05 18:44:38  mangeot
 *Bug fixes + ProcessVolume.po page creation
 *
 *Revision 1.10  2005/08/02 14:41:49  mangeot
 *Work on stylesheets and
 *added a reset button for Review and AdminContrib forms
 *
 *Revision 1.9  2005/07/28 13:06:47  mangeot
 *- Added the possibility to export in PDF format. The conversion into PDF is don
 *e via the fop package that has to be installed (see ToolsForPapillon)
 *
 *Revision 1.8  2005/07/16 16:25:26  mangeot
 *Adapted the linker to the GDEF project + bug fixes
 *
 *Revision 1.7  2005/07/16 13:59:45  mangeot
 *Fixed XML view bug
 *
 *Revision 1.6  2005/07/16 12:58:31  serasset
 *Added limit parameter to query functions
 *Added a parameter to Formater initializations
 *Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 *Revision 1.5  2005/06/17 12:38:56  mangeot
 *Changed lexiesCollection into lexiesHashtable in order to implement the getDirectTranslations
 *
 *Revision 1.4  2005/06/16 13:41:15  mangeot
 *Bugfixed in the default formatter
 *
 *Revision 1.3  2005/05/24 12:51:21  serasset
 *Updated many aspect of the Papillon project to handle lexalp project.
 *1. Layout is now parametrable in the application configuration file.
 *2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 *3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 *4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 *5. It is now possible to give a name to the cookie key in the app conf file
 *6. Several bug fixes.
 *
 *Revision 1.2  2005/04/11 12:29:59  mangeot
 *Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 *Revision 1.1.1.1.2.1  2005/01/28 19:45:55  mangeot
 *First version that runs basically.
 *Should compile after an ant clean.
 *XPath loading and virtual volumes for terminological lexicons are OK.
 *Bugs remain, needs more testings like the editor for example.
 *
 *Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 *Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 *There are still bugs in the code.
 *
 *Revision 1.15  2004/10/28 10:36:13  mangeot
 *MM: I added a transformation method in order to produce a text version from an XML entry. It is used in dictd to display a text entry
 *
 *Revision 1.14  2004/05/12 15:35:22  serasset
 *The xml processing instruction also has to be suppressed in the source language
 *entry, when building the artificial Papillon entry.
 *
 *Revision 1.13  2004/05/11 16:15:47  serasset
 *The database now bear a <?xml instruction in the beginning of newly created
 *files.Hence, when building a fake Papillon entry 1 source -> n targets, each
 *translation is preceded by an invalid instruction. Hence the entry could not
 *be parsed for Xsl transformation. As a result, Papillon returned a null pointer
 *exception. Fixed with a hack that suppress the instruction directly in the xml
 *code when the fake entry is built.
 *
 *Revision 1.12  2004/02/10 05:27:13  mangeot
 *The version UIGEN_V2 has been merged with the trunk by MM
 *Be careful because the Volumes and contributions database tables have been modified.
 *You have to drop and rebuild them unless you modify them by hands.
 *
 *------------------------
 */

package fr.imag.clips.papillon.business.transformation;

import java.util.Hashtable;
import java.util.Vector;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.dictionary.IAnswer;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.ParseVolume;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;


public class XslTransformation implements ResultFormatter {

	public static final String XML_FORMATTER = "XML";
	
	// Constants
	// Note: I use constants extensively because the XSL transformations are a little
	// bit slow
	protected static Hashtable XslSheetCache = new Hashtable();
	
    protected Vector currentXslSheetSequence = null;
    
    public void initializeFormatter(Dictionary dict, Volume vol, Object parameter, int dialect, String lang) throws PapillonBusinessException {
        // Find the correct XslSheet or xslsheet sequence for the given parameters.
        // FIXME: I currently use the same strategy, but this has to be redefined.
        currentXslSheetSequence = new Vector();
		
		String formatter = (String) parameter;
		
		if (formatter!=null && !formatter.equals("")) {
			currentXslSheetSequence.add(XslSheetFactory.findXslSheetByName(formatter));
		}
		else {
			// Get the dictionary sheet...
			currentXslSheetSequence.add(XslSheetFactory.findXslSheetByName(dict.getName()));
			// Then the volume one...
			currentXslSheetSequence.add(XslSheetFactory.findXslSheetByName(vol.getName()));
			// Last, the defaut one
			currentXslSheetSequence.add(XslSheetFactory.findXslSheetByName("DEFAULT"));
		}
        // FIXME: How can the user specify a xsl if there is the choice between several...
        
    }
    
    public Node getFormattedResult(QueryResult qr, User usr) throws PapillonBusinessException {
        Node doc = null;
        try {
            if ((qr.getResultKind() == QueryResult.UNIQUE_RESULT) || 
                (qr.getResultKind() == QueryResult.REVERSE_UNIQUE_RESULT)) {
                doc = (Node) qr.getSourceEntry().getDom();
                for (int i=0; i < currentXslSheetSequence.size(); i++) {
                    XslSheet xsl = (XslSheet) currentXslSheetSequence.elementAt(i);
                    if (null != xsl && ! xsl.isEmpty()) {
                        doc = Transform(doc, xsl);
                    }
                }
            } 
			else if (qr.getResultKind() == QueryResult.AXIE_COLLECTION_RESULT) {
                // FIXME: What should I do in this case ?
                doc = (Node)qr.getSourceEntry().getDom();
            }
			else if (qr.getResultKind() == QueryResult.DIRECT_TRANSLATIONS_RESULT) {
				VolumeEntry myAnswer = qr.getSourceEntry();
				if (myAnswer.getHtmlDom() == null) {					
					Volume myVolume = myAnswer.getVolume();
					Dictionary myDictionary = myAnswer.getDictionary();
					String[] targets = myVolume.getTargetLanguagesArray();
					for (int j=0;j<targets.length;j++) {
						String target = targets[j];
						if (target != null && !target.equals("")) {
						NodeList myNodeList = ParseVolume.getCdmElements(myAnswer, Volume.CDM_translationReflexie, target);
						if ((myNodeList != null) && (myNodeList.getLength()>0)) {
							for (int i=0; i<myNodeList.getLength();i++) {
								Node myNode = myNodeList.item(i);
								String translationId = myNode.getNodeValue();
								if (myNode.getNodeType()==Node.TEXT_NODE) {
									Node textNode = myNode;
									myNode = myNode.getParentNode();
									myNode.removeChild(textNode);
								}
								VolumeEntry newEntry = (VolumeEntry) qr.getLexiesHashtable().get(translationId);
								if (newEntry != null && !newEntry.isEmpty()) {
									Node tempNode = myAnswer.getDom().importNode((Node)newEntry.getDom().getDocumentElement(),true);
									myNode.appendChild(tempNode);
								}
							}
						}
					}
					}
					doc = (Node)myAnswer.getDom();
					for (int i=0; i < currentXslSheetSequence.size(); i++) {
						XslSheet xsl = (XslSheet) currentXslSheetSequence.elementAt(i);
						if (null != xsl && ! xsl.isEmpty()) {
							doc = Transform(doc, xsl);
						}
					}
				}
				else {
					doc = (Node)myAnswer.getHtmlDom();
				}
			}
		} 
		catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in getFormattedResult()", ex);
        }	
		if (doc != null && doc.getNodeType()==Node.DOCUMENT_NODE) { 
			doc = (Node)((Document)doc).getDocumentElement();
		}
		return doc;
	}

    
	//outils pour les transformation
	protected static final TransformerFactory myTransformerFactory = TransformerFactory.newInstance();
	// preparation du resultat//usine a document duilder
	protected static final DocumentBuilderFactory myDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
	//on cree le constructeur de document
	protected static DocumentBuilder myDocumentBuilder = null; 	
	/**
    Transform the xml source by processing it with an xsl sheet.
	 */
    public static Document Transform(Node xmlSource, XslSheet xslSheet)
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
			Document newDocument=myDocumentBuilder.newDocument();
			//the transformation
			// is there a way to obtain a dom result which is a text string?
			myTransformer.transform (new DOMSource(xmlSource),new DOMResult(newDocument));
			return newDocument;
		}

    protected static String TransformToText(Node xmlSource, XslSheet xslSheet)
		throws fr.imag.clips.papillon.business.PapillonBusinessException,
		javax.xml.transform.TransformerConfigurationException,
		javax.xml.parsers.ParserConfigurationException,
		javax.xml.transform.TransformerException,
		java.io.UnsupportedEncodingException,
		java.io.IOException {

			String resultString = "";
			Transformer myTransformer = (Transformer)XslSheetCache.get(xslSheet.getHandle());
			if (myTransformer==null) {
				myTransformer = myTransformerFactory.newTransformer(new StreamSource(new StringReader (xslSheet.getCode())));
				XslSheetCache.put(xslSheet.getHandle(),myTransformer);
			}
			//the result
			if (myDocumentBuilder==null) {
				myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
			}
			Document newDocument=myDocumentBuilder.newDocument();
			//the transformation
			// is there a way to obtain a dom result which is a text string?
		//	myTransformer.transform (new DOMSource(xmlSource),new DOMResult(newDocument));
			ByteArrayOutputStream bytearrayout = new ByteArrayOutputStream();
			myTransformer.transform (new DOMSource(xmlSource),new StreamResult(bytearrayout));
			resultString = bytearrayout.toString("UTF-8");
			bytearrayout.close();
			return resultString;
		}

	
	public static String applyXslSheetsAndSerialize(IAnswer answer)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
		return Utility.NodeToString(applyXslSheets(answer));
	}
	
	public static Element applyXslSheets(IAnswer answer)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		org.w3c.dom.Document result = answer.getDom();
            try {
				// We apply cascades of XSL
				// First, the one for the dictionary if there is
				XslSheet theXslSheet = XslSheetFactory.findXslSheetByName(answer.getDictionaryName());
				if (!theXslSheet.isEmpty()) {
					result = Transform((Node)result, theXslSheet);					
					// Second, the one for the volume if there is
					theXslSheet = XslSheetFactory.findXslSheetByName(answer.getVolumeName());
					if (null != theXslSheet && !theXslSheet.isEmpty()) {
						result = Transform((Node)result, theXslSheet);
					}
					// Last, the default one
					theXslSheet = XslSheetFactory.findDefaultXslSheet();
					if (!theXslSheet.isEmpty()) {
						result = XslTransformation.Transform((Node)result, theXslSheet);
					}
				}
			}
			catch(Exception ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheets()", ex);
			}	
			return result.getDocumentElement();
	}

	public static Element applyXslSheets(IAnswer answer, String xslid)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
				org.w3c.dom.Document result = answer.getDom();
			try {

				XslSheet theXslSheet;

				// If the user selected one precise XSL
				if ((null != xslid) && (!xslid.trim().equals(""))) {
					theXslSheet = XslSheetFactory.findXslSheetByHandle(xslid);
					result = XslTransformation.Transform((Node)result, theXslSheet);
				}
				else {
					return applyXslSheets(answer);
				} 
			}
			catch(Exception ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheets()", ex);
			}
			return result.getDocumentElement();
	}

	public static Node applyXslSheetForXml(String xmlString)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {

		Node result = null;
		XslSheet theXslSheet;
		Document resultDoc = Utility.buildDOMTree(xmlString);
		if (resultDoc != null) {
		try {
			// If there is one XSL sheet for XML
			theXslSheet = XslSheetFactory.findXslSheetByName(XslSheet.XML_view);
			if (!theXslSheet.isEmpty()) {
				result = XslTransformation.Transform(resultDoc, theXslSheet).getDocumentElement();
			}
			else {
				PapillonLogger.writeDebugMsg("applyXslSheetForXml: The XML xslsheet is not in the database");
			}
		}
		catch(Exception ex) {
			throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheetForXml()", ex);
		}
		}
		else {
				PapillonLogger.writeDebugMsg("applyXslSheetForXml: This string is not an XML document: " + xmlString);
		}
		return result;
	}


    // FIXME: This is only called by DictEngine (dictd protocol). This should be handled via the notion of "dialect" of xslsheets.
	public static String applyXslSheetsForText(IAnswer answer)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
			org.w3c.dom.Document resultDOM = answer.getDom();
			String resultString = "";
			try {
				// We apply cascades of XSL
				// First, the one for the dictionary if there is
				XslSheet theXslSheet = XslSheetFactory.findXslSheetByName(answer.getDictionaryName());
				if (!theXslSheet.isEmpty()) {
					resultDOM = Transform((Node)resultDOM, theXslSheet);					
					// Second, the one for the volume if there is
					theXslSheet = XslSheetFactory.findXslSheetByName(answer.getVolumeName());
					if (null != theXslSheet && !theXslSheet.isEmpty()) {
						resultDOM = Transform((Node)resultDOM, theXslSheet);
					}
				}
				// Last, the default one
				theXslSheet = XslSheetFactory.findXslSheetByName(XslSheet.TEXT_view);
				if (!theXslSheet.isEmpty()) {
					resultString = XslTransformation.TransformToText((Node)resultDOM, theXslSheet);
				}
				if (resultString == null || resultString.equals("")) {
					resultString = answer.getXmlCode();
				}
				
/*				theXslSheet = XslSheetFactory.findXslSheetByName(answer.getVolumeName() + XslSheet.TEXT_suffix);
				if (theXslSheet.isEmpty()) {
					theXslSheet = XslSheetFactory.findXslSheetByName(answer.getDictionaryName() + XslSheet.TEXT_suffix);
				}
 
				if (theXslSheet.isEmpty()) {
					theXslSheet = XslSheetFactory.findXslSheetByName(XslSheet.TEXT_view);
				}

				if (!theXslSheet.isEmpty()) {	
					Document resultDoc = answer.getDom();				
					result = TransformToText((Node)resultDoc, theXslSheet);
				}
				else {
					result = answer.getXmlCode();
				} */
			}
			catch(Exception ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheetForXml()", ex);
			}
			return resultString;
		}
	
    // This should be handled via the notion of "dialect" of xslsheets.
	public static Element applyXslSheetsForFo(IAnswer answer)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			org.w3c.dom.Document result = answer.getDom();
            try {
				// We apply cascades of XSL
				// First, the one for the dictionary if there is
				XslSheet theXslSheet = XslSheetFactory.findXslSheetByName(answer.getDictionaryName());
				if (!theXslSheet.isEmpty()) {
					result = Transform((Node)result, theXslSheet);					
					// Second, the one for the volume if there is
					theXslSheet = XslSheetFactory.findXslSheetByName(answer.getVolumeName());
					if (null != theXslSheet && !theXslSheet.isEmpty()) {
						result = Transform((Node)result, theXslSheet);
					}
				}
				// Last, the default one
				theXslSheet = XslSheetFactory.findXslSheetByName(XslSheet.FO_view);
				if (!theXslSheet.isEmpty()) {
					result = XslTransformation.Transform((Node)result, theXslSheet);
				}
			}
			catch(Exception ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheets()", ex);
			}	
			return result.getDocumentElement();
		}
		
	public static void resetCache() {
		XslSheetCache = new Hashtable();
	}

}


















