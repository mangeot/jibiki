/*
 * papillon
 *
 * Enhydra super-servlet
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *-----------------------------------------------
 * Papillon Admin page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import fr.imag.clips.papillon.business.message.MessageDBLoader;

// Standard imports
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.text.DateFormat;
import java.io.*;


//pour le dictionary
import fr.imag.clips.papillon.business.dictionary.*;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.user.*;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.xsl.*;
import fr.imag.clips.papillon.business.locales.Languages;


import fr.imag.clips.papillon.presentation.html.orig.*;

// Imported JAVA API for XML Parsing classes
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

// Imported TraX classes
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;


public class LookupAxies extends BasePO {

    protected final static int MaxDisplayedEntries= 5;

    protected final static String VIEW_AXIE_PARAMETER="ViewAxie";
    protected final static String XSLID="xslid";


    protected static LookupAxiesTmplHTML content;

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean adminUserRequired() {
        return false;
    }

    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws HttpPresentationException,
        IOException,
        TransformerConfigurationException,
        org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException,
        java.io.IOException,
        javax.xml.transform.TransformerException,
        ClassNotFoundException,
        PapillonBusinessException {

            // Création du contenu
            content = (LookupAxiesTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("LookupAxiesTmplHTML", this.getComms(), this.getSessionData());

            HttpPresentationRequest req = this.getComms().request;

            //TEMPORAIRE :avec l URL
            //AJOUT D ENTREE DE DICO

            String lookupAxie = myGetParameter(content.NAME_LookupAxie);
            String lookupLexie = myGetParameter(content.NAME_LookupLexie);
            String sourceLanguage = myGetParameter(content.NAME_SOURCE);
            String entryId = myGetParameter(content.NAME_ENTRYID);
            String headword = myGetParameter(content.NAME_HEADWORD);
            String xslid = myGetParameter(XSLID);

						String strategyString = myGetParameter(content.NAME_Strategy);
						int strategy=IQuery.STRATEGY_EXACT;
						if (null != strategyString && !strategyString.equals("")) {
							strategy=IQuery.STRATEGY_SUBSTRING;
						}
						

            Axie myAxie = null;
            Collection myAxies = null;
            String userMessage = null;

						Volume papillonAxiVolume = VolumesFactory.findVolumeByName(PapillonPivotFactory.VOLUMENAME);
						Dictionary papillonDictionary = DictionariesFactory.findDictionaryByName(PapillonPivotFactory.DICTNAME);


            // looking for an axie with a lexie id linked to the axie
            if (null != req.getParameter(content.NAME_LookupAxie) && null != entryId) {
                    myAxies = PapillonPivotFactory.getAxiesCollection(papillonDictionary, papillonAxiVolume, entryId, null);
						}
						else if (null != req.getParameter(content.NAME_LookupLexie) && null != headword) {
                    myAxies = DictionariesFactory.getAxiesCollectionByHeadword(papillonDictionary, sourceLanguage, this.getUser(), headword, strategy);
						}
            // looking for an axie with its id
            else if (null != req.getParameter(VIEW_AXIE_PARAMETER) &&
                     null != entryId &&
                     !entryId.equals("")) {
                myAxie = PapillonPivotFactory.findAxieByHandle(papillonDictionary, papillonAxiVolume, entryId);
            }
            if (null != userMessage && !userMessage.equals("")){
                this.getSessionData().writeUserMessage(userMessage);
                PapillonLogger.writeDebugMsg(userMessage);
            }

            addConsultForm();

            // Add Axies Table
            if (null != myAxies && myAxies.size()>0) {
                addAxieTable(myAxies);
            }

            // Add Axie in XML
            if (null != req.getParameter(VIEW_AXIE_PARAMETER) &&
                myAxie !=null &&
                !myAxie.IsEmpty()) {
                addXml(myAxie.getXmlCode());
            }


            removeTemplateRows();

            //On rend le contenu correct
            return content.getElementFormulaire();
        }
    protected void addConsultForm()
        throws fr.imag.clips.papillon.business.PapillonBusinessException,
        HttpPresentationException,
        java.io.UnsupportedEncodingException {
            // Adding the appropriate source languages to the source list
            HTMLOptionElement sourceOptionTemplate = content.getElementSourceOptionTemplate();
            Node sourceSelect = sourceOptionTemplate.getParentNode();
            sourceOptionTemplate.removeAttribute("id");
            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            Text sourceTextTemplate = (Text)sourceOptionTemplate.getFirstChild();
            
            String sourceLanguage = myGetParameter(content.NAME_SOURCE);
            // FIXME: Just get the first language for the moment. Architecture of this part should be revised.
            String[] SourceLanguages = AvailableLanguages.getSourceLanguagesArrayForDict(PapillonPivotFactory.DICTNAME);
						String langLoc = this.getUserPreferredLanguage();
            for (int i = 0; i < SourceLanguages.length; i++) {
							if (!SourceLanguages[i].equals("axi")) {
							sourceOptionTemplate.setValue(SourceLanguages[i]);
							if (this.IsClientWithLabelDisplayProblems()) {
                    sourceOptionTemplate.setLabel(Languages.localizeLabel(langLoc,SourceLanguages[i]));
                }
                else {
                    sourceOptionTemplate.setLabel(Languages.localizeName(langLoc,SourceLanguages[i]));
                }
                sourceOptionTemplate.setSelected(SourceLanguages[i].equals(sourceLanguage));
                // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
                // specs W3C.
                sourceTextTemplate.setData(Languages.localizeName(langLoc,SourceLanguages[i]));
                sourceSelect.appendChild(sourceOptionTemplate.cloneNode(true));
							}
            }
            sourceSelect.removeChild(sourceOptionTemplate);            
        }

    protected void addAxieTable (Collection AxieCollection)
        throws PapillonBusinessException,
        java.io.UnsupportedEncodingException {

            // On récupère les éléments du layout
            HTMLTableRowElement entryListRow = content.getElementEntryListRow();
            HTMLElement theId = content.getElementAxieId();
            HTMLElement theSemCat = content.getElementSemCat();
            HTMLElement theLexies = content.getElementLexies();
            HTMLAnchorElement viewXmlAnchor = content.getElementViewXmlAnchor();

            theId.removeAttribute("id");
            theSemCat.removeAttribute("id");
            theLexies.removeAttribute("id");
            viewXmlAnchor.removeAttribute("id");

            // On récupère le noeud contenant la table...
            Node entryTable = entryListRow.getParentNode();
            if (null != AxieCollection) {
                for(Iterator axiesIterator = AxieCollection.iterator(); axiesIterator.hasNext();) {
                    Axie myAxie = (Axie) axiesIterator.next();

                    content.setTextAxieId(myAxie.getId().toString());
                    content.setTextSemCat(myAxie.getSemanticCat().toString());
                    content.setTextLexies(myAxie.getLexies().toString());
					
                    XslSheet xmlSheet = XslSheetFactory.findXslSheetByName("XML");
                    String xslid = "";
                    if (null != xmlSheet && !xmlSheet.IsEmpty()) {
                        xslid = xmlSheet.getHandle();
                    }

                    viewXmlAnchor.setHref(this.getUrl() + "?"
                                          + VIEW_AXIE_PARAMETER + "=on&"
                                          + content.NAME_ENTRYID + "="
                                          + myAxie.getHandle() + "&"
                                          + XSLID + "="
                                          + xslid);

                    HTMLElement clone = (HTMLElement)entryListRow.cloneNode(true);
                    //      we have to take off the id attribute because we did not take it off the original
                    clone.removeAttribute("id");
                    entryTable.appendChild(clone);
                }
            }
        }

    protected void addXml(String xmlString)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {

            Node xmlNode = XslTransformation.applyXslSheetForXml(xmlString);

            //where we must insert the xml
            HTMLElement theXml = content.getElementXml();

            Node theXmlParent = theXml.getParentNode();

            theXmlParent.appendChild(content.importNode(xmlNode,true));
            theXmlParent.removeChild(theXml);
        }


    protected void removeTemplateRows() {
        // EntryListRow
        Element entryListRow = content.getElementEntryListRow();
        Node entryListRowParent = entryListRow.getParentNode();
        entryListRowParent.removeChild(entryListRow);
    }

}
