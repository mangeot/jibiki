/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.12  2005/04/18 13:22:47  mangeot
 *  Fixed a bug with the strategy
 *
 *  Revision 1.11  2005/04/18 11:06:55  mangeot
 *  Bug fix
 *
 *  Revision 1.10  2005/04/15 11:50:20  mangeot
 *  Fixed the same bug for search2text
 *
 *  Revision 1.9  2005/04/15 11:47:10  mangeot
 *  Fixed a bug when search2 can be null
 *
 *  Revision 1.8  2005/04/13 14:34:38  mangeot
 *  Simplified the expert lookup. Now lookup directly the cdm element name
 *
 *  Revision 1.7  2005/04/11 12:29:59  mangeot
 *  Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 *  Revision 1.6.2.3  2005/02/06 22:43:49  mangeot
 *  Merged the 2 Hashtables CDM Elements and XPaths into one
 *  Added a boolean (reverse-lookup) in the volume metadata and functionalities in order to perform a reverse lookup when no direct lookup result is found
 *  Added a boolean (index) in the volume metadata for indexing the only specified CDM Elements
 *
 *  Revision 1.6.2.2  2005/01/28 19:45:55  mangeot
 *  First version that runs basically.
 *  Should compile after an ant clean.
 *  XPath loading and virtual volumes for terminological lexicons are OK.
 *  Bugs remain, needs more testings like the editor for example.
 *
 *  Revision 1.6.2.1  2005/01/27 19:29:21  mangeot
 *  Implemented the HtmlDom cache, it increases speed drastically.
 *  Still does not compile after an ant clean
 *
 *  Revision 1.6  2005/01/18 12:16:10  mangeot
 *  Implemented the SQL LIMIT and OFFSET keywords. It allows us to retrieve the entries as blocks and page them. The LIMIT is the DictionariesFactory.MaxRetrievedEntries constant.
 *  The implementation may need further tuning
 *
 *  Revision 1.5  2005/01/15 12:51:24  mangeot
 *  Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 *  Revision 1.4  2005/01/14 23:08:13  mangeot
 *  Fixed some bugs in ConsultExpert + code cleaning
 *
 *  Revision 1.3  2004/12/24 14:31:28  mangeot
 *  I merged the latest developments of Papillon5.0 with this version 5.1.
 *  Have to be tested more ...
 *
 *  Revision 1.2  2004/12/24 08:57:44  serasset
 *  Premiere version de l'interface avec fond papillon et transparence.
 *
 *  Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 *  Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 *  There are still bugs in the code.
 *
 *
 *
 */
package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
//import org.w3c.dom.html.HTMLElement;
import org.enhydra.xml.xhtml.dom.*;

//import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// Standard imports
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;

// Imported TraX classes
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;
import org.xml.sax.InputSource;

// Imported DOM classes
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

// Imported JAVA API for XML Parsing classes
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//for debug
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.user.*;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.utility.*;
import fr.imag.clips.papillon.business.locales.Languages;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

/**
 *  Description of the Class
 *
 * @author     serasset
 * @created    December 17, 2004
 */
public class ConsultExpert extends BasePO {

    /**
     *  Description of the Field
     */
    protected final static String TEXTE = "texte";
    /**
     *  Description of the Field
     */
    protected final static String XML = "xml";

    /**
     *  Description of the Field
     */
    protected final static String HANDLE = "handle";
    /**
     *  Description of the Field
     */
    protected final static String XSLID = "xslid";

    /**
     *  Description of the Field
     */
    protected final static String VOLUME_PARAMETER = "VOLUME";
    /**
     *  Description of the Field
     */
    protected final static String AnyContains_PARAMETER = "AnyContains";

    /**
     *  Description of the Field
     */
    protected final static String ContributionsURL = "AdminContributions.po";
    /**
     *  Description of the Field
     */
    protected final static String ContributionsVolumeParameter = "VOLUME";

    /**
     *  Description of the Field
     */
    protected final static String ANY_RESOURCE = "*ANY*";
    /**
     *  Description of the Field
     */
    protected final static String ANY_TARGET = "*ANY*";

	/**
	*  Description of the Field
	*/
   protected final static String OFFSET_PARAMETER = "OFFSET";

    /**
     *  Description of the Field
     */
    protected String languagesScript = "";

    /**
     *  Description of the Field
     */
    protected int XslSheetsNumber = 1;

    /**
     *  Description of the Field
     */
    protected Languages Languages;
    /**
     *  Description of the Field
     */
    protected AvailableLanguages MyAvailableLanguages;

    /**
     *  Description of the Field
     */
    protected String[] allSourceLanguages;
    /**
     *  Description of the Field
     */
    protected String[] allTargetLanguages;
    /**
     *  Description of the Field
     */
    protected String[] allResources;

    /**
     *  Description of the Field
     */
    protected String sourceLanguage;
    /**
     *  Description of the Field
     */
    protected String[] targetLanguages;
    /**
     *  Description of the Field
     */
    protected String[] originalTargets;
    /**
     *  Description of the Field
     */
    protected String[] resources;
    /**
     *  Description of the Field
     */
    protected String[] originalResources;
    /**
     *  Description of the Field
     */
    protected String login = null;
    /**
     *  Description of the Field
     */
    protected String search1;
    /**
     *  Description of the Field
     */
    protected String search1text;
    /**
     *  Description of the Field
     */
    protected String search2;
    /**
     *  Description of the Field
     */
    protected String search2text;
    /**
     *  Description of the Field
     */
    protected String strategyString;
    /**
     *  Description of the Field
     */
    protected int strategy = IQuery.STRATEGY_NONE;

    /**
     *  Description of the Field
     */
    protected ConsultExpertXHTML content;


    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return false;
    }


    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    protected boolean adminUserRequired() {
        return false;
    }


    /**
     *  Gets the currentSection attribute of the ConsultExpert object
     *
     * @return    The currentSection value
     */
    protected int getCurrentSection() {
        return NO_SECTION;
    }


    /**
     *  Gets the content attribute of the ConsultExpert object
     *
     * @return                                                     The content
     *      value
     * @exception  HttpPresentationException                       Description
     *      of the Exception
     * @exception  IOException                                     Description
     *      of the Exception
     * @exception  TransformerConfigurationException               Description
     *      of the Exception
     * @exception  org.xml.sax.SAXException                        Description
     *      of the Exception
     * @exception  javax.xml.parsers.ParserConfigurationException  Description
     *      of the Exception
     * @exception  java.io.IOException                             Description
     *      of the Exception
     * @exception  javax.xml.transform.TransformerException        Description
     *      of the Exception
     * @exception  ClassNotFoundException                          Description
     *      of the Exception
     * @exception  PapillonBusinessException                       Description
     *      of the Exception
     * @exception  UnsupportedEncodingException                    Description
     *      of the Exception
     */
    public Node getContent()
             throws HttpPresentationException,
            IOException,
            TransformerConfigurationException,
            org.xml.sax.SAXException,
            javax.xml.parsers.ParserConfigurationException,
            java.io.IOException,
            javax.xml.transform.TransformerException,
            ClassNotFoundException,
            PapillonBusinessException,
            UnsupportedEncodingException {

        // Content creation
        content = (ConsultExpertXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ConsultExpertXHTML", this.getComms(), this.getSessionData());

        // On regarde d'abord les parametres qui nous sont demandes.
        String submit = myGetParameter(content.NAME_lookup);
        sourceLanguage = myGetParameter(content.NAME_SOURCE);
        if (sourceLanguage != null && !sourceLanguage.equals("")) {
            this.setPreference(content.NAME_SOURCE, sourceLanguage);
        } else {
            sourceLanguage = this.getPreference(content.NAME_SOURCE);
        }
        targetLanguages = myGetParameterValues(content.NAME_TARGETS);
        originalTargets = targetLanguages;
        resources = myGetParameterValues(content.NAME_RESOURCES);
        originalResources = resources;
        String volume = myGetParameter(VOLUME_PARAMETER);

        search1 = myGetParameter(content.NAME_search1);
        if (search1 != null && !search1.equals("")) {
            this.setPreference(content.NAME_search1, search1);
        } else {
            search1 = this.getPreference(content.NAME_search1);
        }

        search1text = myGetParameter(content.NAME_search1text);
        search2 = myGetParameter(content.NAME_search2);
        if (search2 != null && !search2.equals("")) {
            this.setPreference(content.NAME_search2, search2);
        } else {
            search2 = this.getPreference(content.NAME_search2);
        }

        search2text = myGetParameter(content.NAME_search2text);

        String anyContains = null;


        if (null != search1 && null != search1text && !search1text.equals("")) {
            if (search1.equals(AnyContains_PARAMETER)) {
                anyContains = search1text;
            }
        }

        if (null != search2 && null != search2text && !search2text.equals("")) {
            if (search2.equals(AnyContains_PARAMETER)) {
                anyContains = search2text;
            }
        }
        strategyString = myGetParameter(content.NAME_Strategy);
        if (strategyString != null && !strategyString.equals("")) {
            this.setPreference(content.NAME_Strategy, strategyString);
        } else {
            strategyString = this.getPreference(content.NAME_Strategy);
        }

        strategy = IQuery.STRATEGY_NONE;
        if (null != strategyString && !strategyString.equals("")) {
            strategy = Integer.parseInt(strategyString);
        }

        int offset = 0;
        String offsetString = myGetParameter(OFFSET_PARAMETER);
        if (offsetString != null && !offsetString.equals("")) {
            offset = Integer.parseInt(offsetString);
		}

        String handle = myGetParameter(HANDLE);
        String xslid = myGetParameter(XSLID);

        if (handle != null && !handle.equals("")) {
            submit = "lookup";
        }

        // Consultation of several headwords at one time
        String[] Headwords = new String[1];
		if (search1 !=null && search1.equals(Volume.CDM_headword)) {
			Headwords[0] = search1text;
			search1text = "";
		}
		else if (search2 !=null && search2.equals(Volume.CDM_headword)) {
			Headwords[0] = search2text;
			search2text = "";
		}
		else {
			Headwords = new String[0];
		}

        // FIXME: Just get the first language for the moment. Architecture of this part should be revised.
        MyAvailableLanguages = new AvailableLanguages();

        allSourceLanguages = MyAvailableLanguages.getSourceLanguagesArray();
        allTargetLanguages = MyAvailableLanguages.getTargetLanguagesArray();
        allResources = DictionariesFactory.getDictionariesNamesArray();

        if (null != targetLanguages && targetLanguages.length > 0) {
            if (targetLanguages[0].equals(ANY_TARGET)) {
                targetLanguages = allTargetLanguages;
            }
        }
        if (null != resources && resources.length > 0) {
            if (resources[0].equals(ANY_RESOURCE)) {
                resources = allResources;
            }
        }

        // Header Script
        //     setHeaderScript(buildLanguagesScript());

        // Content creation
        // Adding the Consult HTML form
        addConsultForm();

        if (null != submit && !submit.equals("")) {
            // Lemmatize the entry Testing phase ...
            if (strategy == IQuery.STRATEGY_LEMMATIZE) {
                Wrapper myWrapper = WrappersFactory.createXRCEAnalyzerWrapper(sourceLanguage);
                String result = myWrapper.getResultString(Headwords);
                String[] Results = WrappersFactory.getXRCEAnalyzerAnswers(result);
                if (Results != null && Results.length > 0) {
                    Headwords = Results;
                }
                strategy = IQuery.STRATEGY_EXACT;
            }
            // Using FOKS module Testing phase ...
            if (strategy == IQuery.STRATEGY_FOKS && sourceLanguage.equals("jpn")) {
                Vector foksVector = VolumeEntriesFactory.getFoksEntriesVector(Headwords[0]);
                if (foksVector != null && foksVector.size() > 0) {
                    addFoksEntryTable(foksVector);
                    strategy = IQuery.STRATEGY_EXACT;
                    Utility.removeElement(content.getElementSorryMessage());
                } else {
                    Utility.removeElement(content.getElementFoksEntries());
                }
                Utility.removeElement(content.getElementEntryListTable());
                Utility.removeElement(content.getElementVolumeEntries());
            } else {
                // If there is a query, executing it
				// constructions of the Keys vector
				Vector myKeys = new Vector();
				if (search1 !=null && !search1.equals("")  &&
					search1text != null && !search1text.equals("")) {
					String[] key1 = new String[3];
					key1[0] = search1;
					key1[2] = search1text;
					myKeys.add(key1);
				}
				if (search2 !=null && !search2.equals("") &&
					search2text != null && !search2text.equals("")) {
					String[] key2 = new String[3];
					key2[0] = search2;
					key2[2] = search2text;
					myKeys.add(key2);
				}
				for (int i=0; i< Headwords.length;i++) {
					String[] Headword = new String[3];
					Headword[0] = Volume.CDM_headword;
					Headword[1] = sourceLanguage;
					Headword[2] = Headwords[i];
					myKeys.add(Headword);
				}

                addEntries(resources, volume, sourceLanguage, targetLanguages, myKeys, anyContains, strategy, handle, xslid, this.getUser(), offset);
                Utility.removeElement(content.getElementFoksEntries());
            }
        } else {
            // If there is no query, ie connection for the first time, adding the Home content
            Utility.removeElement(content.getElementEntryListTable());
            Utility.removeElement(content.getElementVolumeEntries());
            Utility.removeElement(content.getElementFoksEntries());
            Utility.removeElement(content.getElementSorryMessage());
        }

        return content.getElementConsultContent();
    }


    /**
     *  Adds a feature to the ConsultForm attribute of the ConsultExpert object
     *
     * @exception  PapillonBusinessException     Description of the Exception
     * @exception  HttpPresentationException     Description of the Exception
     * @exception  UnsupportedEncodingException  Description of the Exception
     */
    protected void addConsultForm()
             throws PapillonBusinessException,
            HttpPresentationException,
            UnsupportedEncodingException {

        // Adding the appropriate source languages to the source list
        XHTMLOptionElement sourceOptionTemplate = content.getElementSourceOptionTemplate();
        Node sourceSelect = sourceOptionTemplate.getParentNode();
        sourceOptionTemplate.removeAttribute("id");
        // We assume that the option element has only one text child
        // (it should be this way if the HTML is valid...)
        Text sourceTextTemplate = (Text) sourceOptionTemplate.getFirstChild();
        String langLoc = getUserPreferredLanguage();
        if (null == sourceLanguage || sourceLanguage.equals("")) {
            sourceLanguage = langLoc;
        }
        for (int i = 0; i < allSourceLanguages.length; i++) {
            String langi = allSourceLanguages[i];
            sourceOptionTemplate.setValue(langi);
            if (this.IsClientWithLabelDisplayProblems()) {
                sourceOptionTemplate.setLabel(Languages.localizeLabel(langLoc, langi));
            } else {
                sourceOptionTemplate.setLabel(Languages.localizeName(langLoc, langi));
            }
            sourceOptionTemplate.setSelected(langi.equals(sourceLanguage));

            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
            // specs W3C.
            sourceTextTemplate.setData(Languages.localizeName(langLoc, langi));
            sourceSelect.appendChild(sourceOptionTemplate.cloneNode(true));
        }
        sourceSelect.removeChild(sourceOptionTemplate);

        // Strategy select
        XHTMLSelectElement strategySelect = (XHTMLSelectElement) content.getElementStrategy();
		this.setSelected(strategySelect, "" + strategy);

        // Adding the appropriate target languages to the target list
        if (originalTargets == null || originalTargets.length == 0) {
            originalTargets = new String[]{ANY_TARGET};
        }
        XHTMLOptionElement targetOptionTemplate = content.getElementTargetOptionTemplate();
        XHTMLSelectElement targetSelect = (XHTMLSelectElement) targetOptionTemplate.getParentNode();
        if (!this.IsClientWithLabelDisplayProblems()) {
            this.setUnicodeLabels(targetSelect);
        }
        targetOptionTemplate.removeAttribute("id");
        // We assume that the option element has only one text child
        // (it should be this way if the HTML is valid...)
        Text targetTextTemplate = (Text) targetOptionTemplate.getFirstChild();

        for (int i = 0; i < allTargetLanguages.length; i++) {
            String langi = allTargetLanguages[i];
            targetOptionTemplate.setValue(langi);
            if (this.IsClientWithLabelDisplayProblems()) {
                targetOptionTemplate.setLabel(Languages.localizeLabel(langLoc, langi));
            } else {
                targetOptionTemplate.setLabel(Languages.localizeName(langLoc, langi));
            }
            // We should select the previously selected target languages...
            targetTextTemplate.setData(Languages.localizeName(langLoc, langi));
            targetSelect.appendChild(targetOptionTemplate.cloneNode(true));
        }
        targetSelect.removeChild(targetOptionTemplate);
        this.setSelected(content.getElementTargets(), originalTargets);

        // Adding the appropriate resources languages to the resources list
        if (originalResources == null || originalResources.length == 0) {
            originalResources = new String[]{ANY_RESOURCE};
        }
        XHTMLOptionElement resourceOptionTemplate = content.getElementResourceOptionTemplate();
        XHTMLSelectElement resourceSelect = (XHTMLSelectElement) resourceOptionTemplate.getParentNode();
        if (!this.IsClientWithLabelDisplayProblems()) {
            this.setUnicodeLabels(resourceSelect);
        }
        resourceOptionTemplate.removeAttribute("id");
        // We assume that the option element has only one text child
        // (it should be this way if the HTML is valid...)
        Text resourceTextTemplate = (Text) resourceOptionTemplate.getFirstChild();
        for (int i = 0; i < allResources.length; i++) {
            String resource = allResources[i];
            resourceOptionTemplate.setValue(resource);
            resourceOptionTemplate.setLabel(resource);
            // We should select the previously selected resources...
            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
            // specs W3C.
            resourceTextTemplate.setData(resource);
            resourceSelect.appendChild(resourceOptionTemplate.cloneNode(true));
        }
        resourceSelect.removeChild(resourceOptionTemplate);
        this.setSelected(content.getElementResources(), originalResources);

        // strategy
        if (!this.IsClientWithLabelDisplayProblems()) {
            this.setUnicodeLabels(content.getElementStrategy());
        }

        // Search1 field
        if (search1 == null || search1.equals("")) {
            search1 = Volume.CDM_headword;
        }
        if (!this.IsClientWithLabelDisplayProblems()) {
            this.setUnicodeLabels(content.getElementSearch1());
        }
        this.setSelected(content.getElementSearch1(), search1);

        XHTMLInputElement search1Input = content.getElementSearch1text();
        search1Input.setValue(search1text);

        // Search2 field
        if (search2 == null || search2.equals("")) {
            search2 = Volume.CDM_pos;
        }
        if (!this.IsClientWithLabelDisplayProblems()) {
            this.setUnicodeLabels(content.getElementSearch2());
        }
        this.setSelected(content.getElementSearch2(), search2);

        XHTMLInputElement search2Input = content.getElementSearch2text();
        search2Input.setValue(search2text);
    }


    /**
     *  Adds a feature to the Entries attribute of the ConsultExpert object
     *
     * @param  resources                                           The feature
     *      to be added to the Entries attribute
     * @param  volume                                              The feature
     *      to be added to the Entries attribute
     * @param  source                                              The feature
     *      to be added to the Entries attribute
     * @param  targets                                             The feature
     *      to be added to the Entries attribute
     * @param  Headwords                                           The feature
     *      to be added to the Entries attribute
     * @param  strategy                                            The feature
     *      to be added to the Entries attribute
     * @param  posContains                                         The feature
     *      to be added to the Entries attribute
     * @param  pronContains                                        The feature
     *      to be added to the Entries attribute
     * @param  readingContains                                     The feature
     *      to be added to the Entries attribute
     * @param  transContains                                       The feature
     *      to be added to the Entries attribute
     * @param  anyContains                                         The feature
     *      to be added to the Entries attribute
     * @param  handle                                              The feature
     *      to be added to the Entries attribute
     * @param  xslid                                               The feature
     *      to be added to the Entries attribute
     * @param  myUser                                              The feature
     *      to be added to the Entries attribute
     * @exception  PapillonBusinessException                       Description
     *      of the Exception
     * @exception  ClassNotFoundException                          Description
     *      of the Exception
     * @exception  HttpPresentationException                       Description
     *      of the Exception
     * @exception  IOException                                     Description
     *      of the Exception
     * @exception  TransformerConfigurationException               Description
     *      of the Exception
     * @exception  org.xml.sax.SAXException                        Description
     *      of the Exception
     * @exception  javax.xml.parsers.ParserConfigurationException  Description
     *      of the Exception
     * @exception  javax.xml.transform.TransformerException        Description
     *      of the Exception
     */
    protected void addEntries(String[] resources, String volume, String source, String[] targets, Vector myKeys,  String anyContains, int strategy, String handle, String xslid, User myUser, int offset)
             throws PapillonBusinessException,
            ClassNotFoundException,
            HttpPresentationException,
            IOException,
            TransformerConfigurationException,
            org.xml.sax.SAXException,
            javax.xml.parsers.ParserConfigurationException,
            javax.xml.transform.TransformerException {

        Collection EntryCollection = null;
		boolean reverseLookup = false;

        if (null != handle && null != volume) {
            EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, myUser);
        } else if (null != volume) {
            EntryCollection = VolumeEntriesFactory.getVolumeNameEntriesVector(volume, myKeys, null, strategy);
        } else {
            EntryCollection = DictionariesFactory.getDictionariesEntriesCollection(resources, source, targets, myKeys, anyContains, strategy, myUser, offset);
 			if (EntryCollection==null || EntryCollection.size()==0) {
				PapillonLogger.writeDebugMsg("EntryCollection null, getDictionariesReverseEntriesCollection");
				EntryCollection = DictionariesFactory.getDictionariesReverseEntriesCollection(resources, source, targets, myKeys, anyContains, strategy, myUser,offset);
				reverseLookup = (EntryCollection!=null && EntryCollection.size()>0);
			}
       }
        // If there are too much entries ie > DictionariesFactory.MaxDisplayedEntries,
        // we display a table of entries instead of the entries
        if (null != EntryCollection && EntryCollection.size() > 0) {
			if (reverseLookup) {
				XHTMLElement reverseLookupMsg = content.getElementReverseLookupMessage();
				reverseLookupMsg.setAttribute("class","");
			}
            if (EntryCollection.size() > DictionariesFactory.MaxDisplayedEntries) {
                Utility.removeElement(content.getElementVolumeEntries());
                addEntryTable(EntryCollection, targets, offset);
            } else {
                Utility.removeElement(content.getElementEntryListTable());
                addFewEntries(EntryCollection, xslid);
                // If the entry is remote, it is already an HTML node
            }
            Utility.removeElement(content.getElementSorryMessage());
        } else {
            Utility.removeElement(content.getElementVolumeEntries());
            Utility.removeElement(content.getElementEntryListTable());
        }
    }


    /**
     *  Adds a feature to the EntryTable attribute of the ConsultExpert object
     *
     * @param  EntryCollection                           The feature to be added
     *      to the EntryTable attribute
     * @param  targets                                   The feature to be added
     *      to the EntryTable attribute
     * @exception  PapillonBusinessException             Description of the
     *      Exception
     * @exception  java.io.UnsupportedEncodingException  Description of the
     *      Exception
     */
    protected void addEntryTable(Collection EntryCollection, String[] targets, int offset)
             throws PapillonBusinessException,
            java.io.UnsupportedEncodingException {

        PapillonLogger.writeDebugMsg("addEntryTable, size: " + EntryCollection.size());
        // On récupère les éléments du layout
        XHTMLTableRowElement entryListRow = content.getElementEntryListRow();
        XHTMLElement vocable = content.getElementVocable();
        XHTMLAnchorElement entryAnchor = content.getElementEntryAnchor();
        XHTMLElement entryId = content.getElementEntryIdList();
        XHTMLAnchorElement contribAnchor = content.getElementContribAnchor();
        XHTMLElement pos = content.getElementPosEntry();
        XHTMLElement dictname = content.getElementDictionaryName();

        // Recuperating the elements for the formula
        XHTMLTableRowElement formulaRow = content.getElementFormulaRow();
        XHTMLElement formulaElement = content.getElementFormula();
		
		XHTMLElement entryNumberElement = content.getElementEntryNumber();
		XHTMLAnchorElement previousEntriesAnchor = content.getElementPreviousEntriesAnchor();
		XHTMLAnchorElement nextEntriesAnchor = content.getElementNextEntriesAnchor();

        //      we don't take off the id attribute because we will take the element off later...
        //      entryListRow.removeAttribute("id");
        vocable.removeAttribute("id");
        entryAnchor.removeAttribute("id");
        entryId.removeAttribute("id");
        contribAnchor.removeAttribute("id");
        pos.removeAttribute("id");
        dictname.removeAttribute("id");
        formulaElement.removeAttribute("id");
        entryNumberElement.removeAttribute("id");
        previousEntriesAnchor.removeAttribute("id");
        nextEntriesAnchor.removeAttribute("id");
		
		content.setTextEntryNumber(""+EntryCollection.size());
		
		
        String href = this.getUrl() + "?"
			+ serializeParameterForUrl(content.NAME_RESOURCES, originalResources)
			+ content.NAME_search1 + "=" + search1 + "&"
			+ content.NAME_search1text + "=" + search1text + "&"
			+ content.NAME_search2 + "=" + search2 + "&"
			+ content.NAME_search2text + "=" + search2text + "&"
			+ content.NAME_SOURCE + "=" + sourceLanguage + "&"
			+ serializeParameterForUrl(content.NAME_TARGETS, originalTargets)
			+ content.NAME_Strategy + "=" + strategyString + "&"
			+ content.NAME_lookup + "=" + content.NAME_lookup + "&"
			+ OFFSET_PARAMETER + "=";
		if (offset >= DictionariesFactory.MaxRetrievedEntries) {
			int prevOffset = offset-DictionariesFactory.MaxRetrievedEntries;
			previousEntriesAnchor.setHref(href+prevOffset);
		}
		else {
			previousEntriesAnchor.setHref("");
			content.setTextPreviousEntriesAnchor("");			
		}
		int nextOffset = offset+DictionariesFactory.MaxRetrievedEntries;
		nextEntriesAnchor.setHref(href+nextOffset);

        // On récupère le noeud contenant la table...
        Node lexieTable = entryListRow.getParentNode();
        if (null != EntryCollection) {
            for (Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {
                IAnswer myEntry = (IAnswer) myIterator.next();

                // Le vocable
                content.setTextVocable(myEntry.getHeadword());

                // l'entry
                href = this.getUrl() + "?"
                         + VOLUME_PARAMETER + "="
                         + myEntry.getVolumeName() + "&"
                         + HANDLE + "="
                         + myEntry.getHandle() + "&"
                         + content.NAME_SOURCE + "=" + myEntry.getSourceLanguage() + "&"
                         + serializeParameterForUrl(content.NAME_TARGETS, targets)
                         + content.NAME_Strategy + "="
                         + strategyString + "&"
                         + content.NAME_lookup + "="
                         + content.NAME_lookup;
                entryAnchor.setHref(href);
                content.setTextEntryIdList(myEntry.getId());

                // The contribution
                if (myEntry.getType() == IAnswer.Contribution) {
                    Contribution myContrib = (Contribution) myEntry;

                    String contribHref = ContributionsURL + "?"
                             + ContributionsVolumeParameter + "="
                             + myEntry.getVolumeName();
                    contribAnchor.setHref(contribHref);

                    content.setTextContribution(myContrib.getCreationDate() + " " + myContrib.getHandle());
                } else {
                    content.setTextContribution("");
                }

                // Le pos
                String posstr = null;
                if (myEntry.getType() == IAnswer.LocalEntry) {
					posstr = ((VolumeEntry) myEntry).getPos();
                }
                if (null == posstr || posstr.equals("")) {
                    posstr = "+";
                }
                content.setTextPosEntry(posstr);

                // dictname
                content.setTextDictionaryName(myEntry.getDictionaryName());

                // The formula
                 if (myEntry.getType() == IAnswer.LocalEntry) {
					 content.setTextFormula(((VolumeEntry) myEntry).getDefinition());
                }

                XHTMLElement cloneEntry = (XHTMLElement) entryListRow.cloneNode(true);
                XHTMLElement cloneFormula = (XHTMLElement) formulaRow.cloneNode(true);
                //      we have to take off the id attribute because we did not take it off the original
                cloneEntry.removeAttribute("id");
                cloneFormula.removeAttribute("id");
                lexieTable.appendChild(cloneEntry);
                lexieTable.appendChild(cloneFormula);

            }
        }
        lexieTable.removeChild(entryListRow);
        lexieTable.removeChild(formulaRow);
    }


    /**
     *  Adds a feature to the FoksEntryTable attribute of the ConsultExpert
     *  object
     *
     * @param  EntryVector                               The feature to be added
     *      to the FoksEntryTable attribute
     * @exception  PapillonBusinessException             Description of the
     *      Exception
     * @exception  java.io.UnsupportedEncodingException  Description of the
     *      Exception
     */
    protected void addFoksEntryTable(Vector EntryVector)
             throws PapillonBusinessException,
            java.io.UnsupportedEncodingException {

        // On récupère les éléments du layout
        XHTMLTableRowElement entryListRow = content.getElementFoksRow();
        XHTMLElement foksEntry = content.getElementFoksEntry();
        XHTMLElement foksWriting = content.getElementFoksWriting();
        XHTMLElement foksGrade = content.getElementFoksGrade();
        XHTMLAnchorElement foksHref = content.getElementFoksHref();

        //      we don't take off the id attribute because we will take the element off later...
        //      entryListRow.removeAttribute("id");
        foksEntry.removeAttribute("id");
        foksWriting.removeAttribute("id");
        foksGrade.removeAttribute("id");
        foksHref.removeAttribute("id");

        // On récupère le noeud contenant la table...
        Node lexieTable = entryListRow.getParentNode();
        if (null != EntryVector) {
            for (int i = 0; i < EntryVector.size(); i++) {
                String href;
                FoksEntry myEntry = (FoksEntry) EntryVector.get(i);
                String headword = myEntry.getHeadword();
                content.setTextFoksEntry(headword);
                String myWriting = "";
                VolumeEntry myWritingEntry = VolumeEntriesFactory.getJMDictVolumeEntry(headword);
                if (myWritingEntry != null && !myWritingEntry.IsEmpty()) {
                    //NOTE: I store the writing of the Japanese entries in the Key1 field.
                    // The reading field is used for transcriptions like romaji
					myWriting = ParseVolume.getCdmString(myWritingEntry,Volume.CDM_writing,"jpn");
                }
                content.setTextFoksWriting(myWriting);
                // Le grade
                content.setTextFoksGrade(myEntry.getScoreString());

                href = this.getUrl() + "?"
                         + content.NAME_SOURCE + "="
                         + sourceLanguage + "&"
                         + serializeParameterForUrl(content.NAME_TARGETS, originalTargets)
                         + serializeParameterForUrl(content.NAME_RESOURCES, originalResources)
                         + content.NAME_search1 + "=" + Volume.CDM_headword + "&"
                         + content.NAME_search1text + "="
                         + Utility.convertToUrlForEncoding(headword, "UTF-8") + "&"
                         + content.NAME_Strategy + "="
                         + IQuery.STRATEGY_EXACT + "&"
                         + content.NAME_lookup + "="
                         + "lookup";
                foksHref.setHref(href);
                XHTMLElement clone = (XHTMLElement) entryListRow.cloneNode(true);
                //      we have to take off the id attribute because we did not take it off the original
                clone.removeAttribute("id");
                lexieTable.appendChild(clone);
            }
        }
        lexieTable.removeChild(entryListRow);
    }


    /**
     *  Gets the xslTable attribute of the ConsultExpert object
     *
     * @param  volume                         Description of the Parameter
     * @param  handle                         Description of the Parameter
     * @param  type                           Description of the Parameter
     * @return                                The xslTable value
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  PapillonBusinessException  Description of the Exception
     */
    protected Node getXslTable(String volume, String handle, int type)
             throws HttpPresentationException,
            PapillonBusinessException {

        XHTMLElement stylesheetRow = null;

        try {

            Vector xslList = new Vector();

            XslSheet myXmlSheet = XslSheetFactory.findXslSheetByName("XML");
            if (myXmlSheet != null && !myXmlSheet.IsEmpty()) {
                xslList.add(myXmlSheet);
            }
            // FIXME: We have too much XslSheets so I put only XML and DEC
            // but it should not be hardcoded!
            XslSheet myDECSheet = XslSheetFactory.findXslSheetByName("DEC");
            if (myDECSheet != null && !myDECSheet.IsEmpty()) {
                xslList.add(myDECSheet);
            }
            // size + 1 for the default xsl sheet
            XslSheetsNumber = xslList.size() + 1;
            //  XslSheetsNumber = xslList.size();
            //for the stylesheet content
            // On récupère le noeud contenant la table...
            XHTMLTableRowElement originalStylesheetRow = content.getElementStylesheetRow();

            stylesheetRow = (XHTMLElement) originalStylesheetRow.cloneNode(true);
            // The cell element is added in proder to be parsed by enhydra
            // but here we remove it
            XHTMLElement stylesheetCell = (XHTMLElement) stylesheetRow.getFirstChild();

            stylesheetRow.removeAttribute("id");
            stylesheetRow.removeChild(stylesheetCell);

            Document theDoc = stylesheetRow.getOwnerDocument();

            // default XSL = null !
            Element cell = theDoc.createElement("TD");
            Element anchor = theDoc.createElement("A");
            Text xslName = theDoc.createTextNode("Default");
            anchor.setAttribute("href", this.getUrl() + "?" +
                    VOLUME_PARAMETER + "=" + volume + "&" +
                    HANDLE + "=" + handle + "&" +
                    content.NAME_lookup + "=" + "lookup");
            anchor.appendChild(xslName);
            cell.appendChild(anchor);
            stylesheetRow.appendChild(cell);

            //adding xslchoice
            for (int i = 0; i < xslList.size(); i++) {
                // Le nom de la stylesheet
                String name = ((XslSheet) xslList.elementAt(i)).getName();
                //creation de la data cell
                cell = theDoc.createElement("TD");
                anchor = theDoc.createElement("A");
                xslName = theDoc.createTextNode(name);
                anchor.setAttribute("href", this.getUrl() + "?" +
                        VOLUME_PARAMETER + "=" + volume + "&" +
                        HANDLE + "=" + handle + "&" +
                        XSLID + "=" + ((XslSheet) xslList.elementAt(i)).getHandle() + "&" +
                        content.NAME_lookup + "=" + "lookup");
                anchor.appendChild(xslName);
                cell.appendChild(anchor);
                stylesheetRow.appendChild(cell);
            }
        } catch (Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in getXslTable()", ex);
        }
        return stylesheetRow;
    }


    /**
     *  Adds a feature to the Element attribute of the ConsultExpert object
     *
     * @param  element                        The feature to be added to the
     *      Element attribute
     * @param  table                          The feature to be added to the
     *      Element attribute
     * @param  handle                         The feature to be added to the
     *      Element attribute
     * @param  resource                       The feature to be added to the
     *      Element attribute
     * @param  type                           The feature to be added to the
     *      Element attribute
     * @exception  PapillonBusinessException  Description of the Exception
     */
    protected void addElement(Element element, String table, String handle, String resource, int type)
             throws PapillonBusinessException {
        try {
            //for the entry content
            XHTMLTableRowElement originalEntryRow = content.getElementEntryRow();
            Node entryTable = originalEntryRow.getParentNode();
            //for the entry content

            content.setTextResourceName(resource);

            //for the lexie content
            XHTMLTableCellElement entryCell = (XHTMLTableCellElement) originalEntryRow.getFirstChild();

            if (null != table && null != handle) {
                // If we want to put the XSL menu ...
                entryTable.appendChild(getXslTable(table, handle, type));
                entryCell.setColSpan(XslSheetsNumber);
            }
            XHTMLElement entryDiv = (XHTMLElement) content.getElementEntryDiv();
            entryDiv.removeAttribute("id");

            if (entryDiv.getChildNodes().getLength() > 0) {
                entryDiv.removeChild(entryDiv.getFirstChild());
            }

            entryDiv.appendChild(content.importNode(element, true));

            XHTMLTableRowElement entryRow = (XHTMLTableRowElement) originalEntryRow.cloneNode(true);
            entryRow.removeAttribute("id");

            entryTable.appendChild(entryRow);
            // Don't remove the original node in order to add more entries ...
            //entryTable.removeChild(entryRow);
        } catch (Exception ex) {
            throw new PapillonBusinessException("Exception in addEntries: ", ex);
        }
    }


    /**
     *  Adds a feature to the FewEntries attribute of the ConsultExpert object
     *
     * @param  EntryCollection
     *      The feature to be added to the FewEntries attribute
     * @param  xslid
     *      The feature to be added to the FewEntries attribute
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    protected void addFewEntries(Collection EntryCollection, String xslid)
             throws fr.imag.clips.papillon.business.PapillonBusinessException {
        if (EntryCollection != null && EntryCollection.size() > 0) {
            for (Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {
				addEntry((IAnswer) myIterator.next(), xslid);
            }
        } else {
            Utility.removeElement(content.getElementEntryListTable());
        }
        // removing
        Utility.removeElement(content.getElementStylesheetRow());
        Utility.removeElement(content.getElementEntryRow());
    }

    /**
     *  Adds an Entry to the Home object
     *
     * @param  EntryCollection
     *      The feature to be added to the FewEntries attribute
     * @param  xslid
     *      The feature to be added to the FewEntries attribute
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    protected void addEntry(IAnswer myEntry, String xslid)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			org.w3c.dom.Element myHtmlElt = null;
			org.w3c.dom.Document myHtmlDoc = myEntry.getHtmlDom();
			if (xslid != null || myHtmlDoc == null) {
				myHtmlElt = XslTransformation.applyXslSheets(myEntry, xslid);
				myHtmlDoc = myHtmlElt.getOwnerDocument();
				if (xslid == null) {
					myEntry.setHtmlDom(myHtmlDoc);
					myEntry.save();
				}
			}
			else {
				myHtmlElt = myHtmlDoc.getDocumentElement();
			}
			addElement(myHtmlElt, myEntry.getVolumeName(), myEntry.getHandle(),  myEntry.getDictionaryName(), myEntry.getType());
		}
	
    /**
     *  Description of the Method
     *
     * @return
     *      Description of the Return Value
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    protected String buildLanguagesScript()
             throws fr.imag.clips.papillon.business.PapillonBusinessException {

        String[] AllLanguages = MyAvailableLanguages.getAllLanguagesArray();
        String script;

        // Heading of the script
        script = "\n<!--\nfunction UpdateList(object) {\n" +
                "     // Remove all existing items from TARGETS list\n" +
                "     object.TARGETS.options.length = 0;\n\n" +
                "     var defaultSelected = false;\n" +
                "     var selected = false;\n\n";

        // Writing one Option variable for each existing language
        String langLoc = getUserPreferredLanguage();
        for (int i = 0; i < AllLanguages.length; i++) {
            String myLang = AllLanguages[i];
            String varLang = "  var " + myLang + " = new Option(\"" +
                    Languages.localizeName(langLoc, myLang) + "\", \"" + myLang + "\");";
            script = script + "\n" + varLang;
        }

        script = script + "\n\n";

        // Writing one if instruction for each source language
        for (int i = 0; i < allSourceLanguages.length; i++) {
            String mySource = allSourceLanguages[i];
            String ifScript = "  if (object.SOURCE.options[object.SOURCE.selectedIndex].value == \"" + mySource + "\") {";
            String[] myTargets = MyAvailableLanguages.getTargetLanguagesArray(mySource);
            for (int j = 0; j < myTargets.length; j++) {
                ifScript = ifScript + "\n" + "    object.TARGETS.options["
                         + j + "] = " + myTargets[j] + ";";
            }
            script = script + "\n" + ifScript + "\n}";
        }

        // Tail of the script
        script = script + "\n}\n-->\n";

        return script;
    }
}

