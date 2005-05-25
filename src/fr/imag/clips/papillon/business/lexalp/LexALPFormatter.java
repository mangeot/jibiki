/*
 *
 *-----------------------
 * $Id$
 *------------------------
 * $Log$
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
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;

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

    
    protected Dictionary currentDictionary;
    protected Volume sourceVolume;
    
    public void initializeFormatter(Dictionary dict, Volume vol, int dialect, String lang) throws PapillonBusinessException {
        currentDictionary = dict;
        sourceVolume = vol;
        try {
            if (myDocumentBuilder==null) {
                myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
            } 
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new PapillonBusinessException("CRITICAL: error initializing document builder !", e);
        }
        // FIXME: How can the user specify a xsl if there is the choice between several...
        
    }
        
    public Node getFormattedResult(QueryResult qr) throws PapillonBusinessException {
        try {
            Document res = myDocumentBuilder.newDocument();
            Element div = res.createElement("div");
            res.appendChild(div);
            // First format the source entry
            XslSheet dictXsl = XslSheetFactory.findXslSheetByName(currentDictionary.getName());
            Document doc = qr.getSourceEntry().getDom();
            
            if (null != dictXsl && ! dictXsl.isEmpty()) {
                doc = Transform(doc, dictXsl);
            }
            div.appendChild(res.importNode(doc.getDocumentElement(),true));
            
            if (qr.getResultKind() == QueryResult.AXIE_COLLECTION_RESULT) {
                // Then append each translation
                Iterator iter = qr.getLexiesCollection().iterator();
                while (iter.hasNext()) {
                    VolumeEntry ve = (VolumeEntry) iter.next();
                    if (! ve.getHandle().equals(qr.getSourceEntry().getHandle()) ) {
                        doc = ve.getDom();
                        if (null != dictXsl && ! dictXsl.isEmpty()) {
                            doc = Transform(doc, dictXsl);
                        }
                        div.appendChild(res.importNode(doc.getDocumentElement(),true));
                    }
                }
            } 
            return (Node) res.getDocumentElement();

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
			Document newDocument=myDocumentBuilder.newDocument();
			//the transformation
			// is there a way to obtain a dom result which is a text string?
			myTransformer.transform (new DOMSource(xmlSource),new DOMResult(newDocument));
			return newDocument;
		}
}


















