/*
 *
 *-----------------------
 *$Id$
 *------------------------
 *$Log$
 *Revision 1.14  2007/01/05 13:57:25  serasset
 *multiple code cleanup.
 *separation of XMLServices from the Utility class
 *added an xml parser pool to allow reuse of parser in a multithreaded context
 *added a new field in the db to identify the db layer version
 *added a new system property to know which db version is known by the current app
 *
 *Revision 1.13  2006/08/10 22:17:13  fbrunet
 *- Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 *- Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 *- Bug correction : +/- in advanced search
 *
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

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.IAnswer;
import fr.imag.clips.papillon.business.dictionary.ParseVolume;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.business.xsl.JibikiXsltExtension;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Hashtable;


public class XslTransformation implements ResultFormatter {

    public static final String XML_FORMATTER = "XML";

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


    protected XslSheet dictXsl = null;

    protected Dictionary currentDictionary;
    protected Volume sourceVolume;

    //
    private final boolean DEBUG = false;

    public void initializeFormatter(Dictionary dictionary, Volume volume, Object parameter, int dialect, String lang) throws PapillonBusinessException {
        try {
            //
            String dictionaryName = dictionary.getName();
            String volumeName = volume.getName();

            //
            if (myDocumentBuilder == null) {
                myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
            }

            //
            dictXsl = getXslSheet(dictionaryName, volumeName, (String) parameter);

            //System.out.println("Document Builder Factory is: " + myDocumentBuilderFactory.getClass());
            //System.out.println("Transformer Factory is: " + myTransformerFactory.getClass());
            //System.out.println("Document Builder is: " + myDocumentBuilder.getClass());


        } catch (javax.xml.parsers.ParserConfigurationException e) {
            throw new PapillonBusinessException("CRITICAL: error initializing document builder !", e);
        }

    }

    public Node getFormattedResult(QueryResult qr, User usr)
            throws PapillonBusinessException {

        Document res = myDocumentBuilder.newDocument();
        Element rootdiv = res.createElement("div");
        rootdiv.setAttribute("class", "entry");
        res.appendChild(rootdiv);
		
		// FIXME: determine what to do for direct translation result:
        // hint, use jibikiXsltExtensions to resolve the links and format everything...
		// for the moment, old school way...
		
		if (qr.getResultKind() == QueryResult.DIRECT_TRANSLATIONS_RESULT) {
                VolumeEntry myAnswer = qr.getSourceEntry();

                Volume myVolume = myAnswer.getVolume();
                Dictionary myDictionary = myAnswer.getDictionary();

                //
                Collection targets = myVolume.getTargetLanguagesArray();
                for (Iterator iter = targets.iterator(); iter.hasNext();) {
                    String target = (String) iter.next();

                    //
                    if (target != null && !target.equals("") && target!= myVolume.getSourceLanguage()) {
						//PapillonLogger.writeDebugMsg("getFormattedResult: " + target);
                        NodeList myNodeList = ParseVolume.getCdmElements(myAnswer, Volume.CDM_translationReflexie, target);
                        if ((myNodeList != null) && (myNodeList.getLength() > 0)) {
                            for (int i = 0; i < myNodeList.getLength(); i++) {
                                Node myNode = myNodeList.item(i);
                                String translationId = myNode.getNodeValue();
                                if (myNode.getNodeType() == Node.TEXT_NODE) {
                                    Node textNode = myNode;
                                    myNode = myNode.getParentNode();
                                    myNode.removeChild(textNode);
                                }
                                VolumeEntry newEntry = (VolumeEntry) qr.getLexiesHashtable().get(translationId);
                                if (newEntry != null && !newEntry.isEmpty()) {
                                    Node tempNode = myAnswer.getDom().importNode((Node) newEntry.getDom().getDocumentElement(), true);
                                    myNode.appendChild(tempNode);
                                }
                            }
                        }
                    }
                }
			}


        // Is reverse unique result still in use ?
        if (qr.getResultKind() == QueryResult.UNIQUE_RESULT ||
                (qr.getResultKind() == QueryResult.REVERSE_UNIQUE_RESULT) ||
                (qr.getResultKind() == QueryResult.AXIE_COLLECTION_RESULT) ||
                (qr.getResultKind() == QueryResult.DIRECT_TRANSLATIONS_RESULT)) {
            if (null != dictXsl && !dictXsl.isEmpty()) {
                // Format document source
                Node resultNode = formatResult(qr.getSourceEntry().getDom(), dictXsl, usr);
                rootdiv.appendChild(res.importNode(resultNode, true));
            }
        } 
		
       return rootdiv;
    }

//    public Node getFormattedResultOld(QueryResult qr, User usr) throws PapillonBusinessException {
//        Node doc = null;
//        try {
//            if ((qr.getResultKind() == QueryResult.UNIQUE_RESULT) ||
//                    (qr.getResultKind() == QueryResult.REVERSE_UNIQUE_RESULT)) {
//                Document res = myDocumentBuilder.newDocument();
//                Element rootdiv = res.createElement("div");
//                rootdiv.setAttribute("class", "entry");
//                res.appendChild(rootdiv);
//
//            } else if (qr.getResultKind() == QueryResult.AXIE_COLLECTION_RESULT) {
//                // FIXME: What should I do in this case ?
//                doc = (Node) qr.getSourceEntry().getDom();
//            } else if (qr.getResultKind() == QueryResult.DIRECT_TRANSLATIONS_RESULT) {
//                VolumeEntry myAnswer = qr.getSourceEntry();
//
//                Volume myVolume = myAnswer.getVolume();
//                Dictionary myDictionary = myAnswer.getDictionary();
//
//                //
//                Collection targets = myVolume.getTargetLanguagesArray();
//                for (Iterator iter = targets.iterator(); iter.hasNext();) {
//                    String target = (String) iter.next();
//
//                    //
//                    if (target != null && !target.equals("")) {
//                        NodeList myNodeList = ParseVolume.getCdmElements(myAnswer, Volume.CDM_translationReflexie, target);
//                        if ((myNodeList != null) && (myNodeList.getLength() > 0)) {
//                            for (int i = 0; i < myNodeList.getLength(); i++) {
//                                Node myNode = myNodeList.item(i);
//                                String translationId = myNode.getNodeValue();
//                                if (myNode.getNodeType() == Node.TEXT_NODE) {
//                                    Node textNode = myNode;
//                                    myNode = myNode.getParentNode();
//                                    myNode.removeChild(textNode);
//                                }
//                                VolumeEntry newEntry = (VolumeEntry) qr.getLexiesHashtable().get(translationId);
//                                if (newEntry != null && !newEntry.isEmpty()) {
//                                    Node tempNode = myAnswer.getDom().importNode((Node) newEntry.getDom().getDocumentElement(), true);
//                                    myNode.appendChild(tempNode);
//                                }
//                            }
//                        }
//                    }
//                }
//                doc = (Node) myAnswer.getDom();
//                for (int i = 0; i < currentXslSheetSequence.size(); i++) {
//                    XslSheet xsl = (XslSheet) currentXslSheetSequence.elementAt(i);
//                    if (null != xsl && !xsl.isEmpty()) {
//                        doc = Transform(doc, xsl);
//                    }
//                }
//
//            }
//        }
//        catch (Exception ex) {
//            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in getFormattedResult()", ex);
//        }
//        if (doc != null && doc.getNodeType() == Node.DOCUMENT_NODE) {
//            doc = (Node) ((Document) doc).getDocumentElement();
//        }
//        return doc;
//    }

    /**
     * ...
     *
     * @param docSource DOM version of the volume entry to be formatted
     * @param xsl       XslSheet used for formatting
     * @param usr       User currently requesting the result.
     * @return Root node representing the
     * @throws fr.imag.clips.papillon.business.PapillonBusinessException
     *
     */
    private Node formatResult(Document docSource, XslSheet xsl, User usr)
            throws PapillonBusinessException {
        try {

            // init
            Document docCible = null;
			
            docCible = Transform(docSource, xsl);

            return docCible.getDocumentElement();

        } catch (Exception ex) {
            throw new PapillonBusinessException("Exception in getFormattedResult()", ex);
        }
    }

    /**
     * Transform the xml source by processing it with an xsl sheet.
     */
    public static Document Transform(Node xmlSource, XslSheet xslSheet)
            throws PapillonBusinessException, javax.xml.parsers.ParserConfigurationException,
            javax.xml.transform.TransformerException, java.io.IOException {

        // Find transformer
        // FIXME: if transformer is null ?
        Transformer myTransformer = xslSheet.getTransformer();

        // PapillonLogger.writeDebugMsg("Class: " + myTransformer.getClass());
        // PapillonLogger.writeDebugMsg("Factory: " + TransformerFactory.class.toString());
        // The xalan transformer uses the context class loader instead of the system class loader
        // But in enhydra 5.1, the system class loader is a custom class loader, hence we have
        // to set the context class loader to the enhydra classloader, or the Extension classes
        // would not be visible.
        try {
            Thread currentThread = Thread.currentThread();
            currentThread.setContextClassLoader(JibikiXsltExtension.class.getClassLoader());
        } catch (SecurityException e) {
            PapillonLogger.writeDebugMsg("Could not modify the context class loader.");
        }

        // The source
        if (myDocumentBuilder == null) {
            myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
        }
        Document newDocument = myDocumentBuilder.newDocument();

        //
        myTransformer.transform(new DOMSource(xmlSource), new DOMResult(newDocument));

        //
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
        Transformer myTransformer = xslSheet.getTransformer();

        //the result
        if (myDocumentBuilder == null) {
            myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
        }

        //
        Document newDocument = myDocumentBuilder.newDocument();
        //the transformation
        // is there a way to obtain a dom result which is a text string?
        //	myTransformer.transform (new DOMSource(xmlSource),new DOMResult(newDocument));
        ByteArrayOutputStream bytearrayout = new ByteArrayOutputStream();
        myTransformer.transform(new DOMSource(xmlSource), new StreamResult(bytearrayout));
        resultString = bytearrayout.toString("UTF-8");
        bytearrayout.close();
        return resultString;
    }


    public static String applyXslSheetsAndSerialize(IAnswer answer)
            throws fr.imag.clips.papillon.business.PapillonBusinessException {
        return XMLServices.NodeToString(applyXslSheets(answer));
    }

    public static Element applyXslSheets(IAnswer answer)
            throws fr.imag.clips.papillon.business.PapillonBusinessException {
        org.w3c.dom.Document result = answer.getDom();
        try {
            // We apply cascades of XSL
            // First, the one for the dictionary if there is
            /*
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
            */
            XslSheet theXslSheet = XslSheetFactory.getXslSheet(answer.getDictionaryName(), answer.getVolumeName(), "");
            if (!theXslSheet.isEmpty()) {
                result = XslTransformation.Transform((Node) result, theXslSheet);
            }
        }
        catch (Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheets()", ex);
        }
        return result.getDocumentElement();
    }


    // FIXME: This is only called by DictEngine (dictd protocol). This should be handled via the notion of "dialect" of xslsheets.

    public static String applyXslSheetsForText(IAnswer answer)
            throws fr.imag.clips.papillon.business.PapillonBusinessException {

        org.w3c.dom.Document resultDOM = answer.getDom();
        String resultString = "";
        try {

            //
            XslSheet theXslSheet = XslSheetFactory.getXslSheet(answer.getDictionaryName(), answer.getVolumeName(), XslSheet.TEXT_view);
            if (!theXslSheet.isEmpty()) {
                resultString = XslTransformation.TransformToText((Node) resultDOM, theXslSheet);
            }
            if (resultString == null || resultString.equals("")) {
                resultString = answer.getXmlCode();
            }

            // We apply cascades of XSL
            // First, the one for the dictionary if there is
            /*
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

                   theXslSheet = XslSheetFactory.findXslSheetByName(answer.getVolumeName() + XslSheet.TEXT_suffix);
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
        catch (Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheetForXml()", ex);
        }
        return resultString;
    }

    // This should be handled via the notion of "dialect" of xslsheets.
    public static Element applyXslSheetsForFo(IAnswer answer)
            throws fr.imag.clips.papillon.business.PapillonBusinessException {
        org.w3c.dom.Document result = answer.getDom();
        try {
            XslSheet theXslSheet = XslSheetFactory.getXslSheet(answer.getDictionaryName(), answer.getVolumeName(), XslSheet.FO_view);
            if (!theXslSheet.isEmpty()) {
                result = XslTransformation.Transform((Node) result, theXslSheet);
            }
            /*
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
            */
        }
        catch (Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in applyXslSheets()", ex);
        }
        return result.getDocumentElement();
    }


    public static void resetCache() {
        XslSheetCache = new Hashtable();
    }


    public static XslSheet getXslSheet(String dictionaryName, String volumeName, String name)
            throws PapillonBusinessException {

        XslSheet theXsl = null;

        // find specific xsl
        theXsl = XslSheetFactory.getXslSheet(dictionaryName, volumeName, name);

        // find specific xsl
        if (theXsl == null) {
            theXsl = XslSheetFactory.getXslSheet(dictionaryName, "", name);
        }

        // find specific xsl
        if (theXsl == null) {
            theXsl = XslSheetFactory.getXslSheet("", "", name);
        }

        // find defaut
        if (theXsl == null) {
            theXsl = XslSheetFactory.getXslSheet(dictionaryName, volumeName, "");
        }

        // find defaut
        if (theXsl == null) {
            theXsl = XslSheetFactory.getXslSheet(dictionaryName, "", "");
        }

        // find defaut
        if (theXsl == null) {
            theXsl = XslSheetFactory.getXslSheet("", "", "");
        }

        //
        return theXsl;
    }

}


















