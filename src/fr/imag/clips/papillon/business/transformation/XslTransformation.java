/*
 *
 *-----------------------
 *$Id$
 *------------------------
 *$Log$
 *Revision 1.1  2004/12/06 16:38:31  serasset
 *Initial revision
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

import fr.imag.clips.papillon.business.dictionary.IAnswer;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.utility.Utility;

import fr.imag.clips.papillon.business.PapillonLogger;


public class XslTransformation {


	// Constants
	// Note: I use constants extensively because the XSL transformations are a little
	// bit slow
	protected static Hashtable XslSheetCache = new Hashtable();
	
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

    public static String TransformToText(Node xmlSource, XslSheet xslSheet)
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
		return Utility.NodeToString(applyXslSheets(answer.getXmlCode(), answer));
	}

	public static Element applyXslSheets(IAnswer answer)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
		return applyXslSheets(answer.getXmlCode(), answer);
	}

    public static Element applyXslSheets(IAnswer answer, String xslid)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Element result = null;
		if (answer!=null && !answer.IsEmpty()) {
			if (null != xslid && !xslid.equals("")) {
				result = applyXslSheets(answer.getXmlCode(), xslid);
			}
			else {
				result = applyXslSheets(answer.getXmlCode(), answer);
			}
		}
        return result;
    }

    public static Element applyXslSheets(String xml, IAnswer answer)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {

        Document result = null;

        if (null != xml && !xml.equals("") && answer!=null && !answer.IsEmpty()) {
            try {
                
				//PapillonLogger.writeDebugMsg("XML Code:\n" + xml);
				result = Utility.buildDOMTree(xml);
				// We apply cascades of XSL
				// First, the one for the dictionary if there is
				XslSheet theXslSheet = XslSheetFactory.findXslSheetByName(answer.getDictionaryName());
				if (!theXslSheet.IsEmpty()) {
					
					result = Transform((Node)result, theXslSheet);
					
					// Second, the one for the volume if there is
					theXslSheet = XslSheetFactory.findXslSheetByName(answer.getVolumeName());
					if (null != theXslSheet && !theXslSheet.IsEmpty()) {
						result = Transform((Node)result, theXslSheet);
					}
					
					// Last, the default one
					theXslSheet = XslSheetFactory.findDefaultXslSheet();
					if (!theXslSheet.IsEmpty()) {
						result = XslTransformation.Transform((Node)result, theXslSheet);
					}
				}
			}
			catch(Exception ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheets()", ex);
			}
		}
		return result.getDocumentElement();
	}
	
	public static Element applyXslSheets(String xml, String xslid)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {

		Document result = null;

		if (null != xml && !xml.equals("")) {
			try {
				result = Utility.buildDOMTree(xml);

				XslSheet theXslSheet;

				// If the user selected one precise XSL
				if ((null != xslid) && (!xslid.trim().equals(""))) {
					theXslSheet = XslSheetFactory.findXslSheetByID(xslid);
					result = XslTransformation.Transform((Node)result, theXslSheet);
				}
			}
			catch(Exception ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheets()", ex);
			}
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
			if (!theXslSheet.IsEmpty()) {
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


	public static String applyXslSheetForText(IAnswer answer)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			
			String xmlString = answer.getXmlCode();
			String result = "";
			XslSheet theXslSheet;
			try {
				// We apply one XSL
				// First, the one for the volume if there is
				theXslSheet = XslSheetFactory.findXslSheetByName(answer.getVolumeName() + XslSheet.TEXT_suffix);
				if (theXslSheet.IsEmpty()) {
					theXslSheet = XslSheetFactory.findXslSheetByName(answer.getDictionaryName() + XslSheet.TEXT_suffix);
				}
				// Second, the one for the dictionary if there is
				if (theXslSheet.IsEmpty()) {
					theXslSheet = XslSheetFactory.findXslSheetByName(XslSheet.TEXT_view);
				}
				// Last, the default one
				if (!theXslSheet.IsEmpty()) {	
					Document resultDoc = Utility.buildDOMTree(xmlString);				
					result = TransformToText((Node)resultDoc, theXslSheet);
				}
				else {
					result = xmlString;
				}
			}
			catch(Exception ex) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheetForXml()", ex);
			}
			return result;
		}
	


	public static void resetCache() {
		XslSheetCache = new Hashtable();
	}

}


















