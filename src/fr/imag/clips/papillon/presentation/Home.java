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
 *  Revision 1.4  2005/01/18 12:16:10  mangeot
 *  Implemented the SQL LIMIT and OFFSET keywords. It allows us to retrieve the entries as blocks and page them. The LIMIT is the DictionariesFactory.MaxRetrievedEntries constant.
 *  The implementation may need further tuning
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
 *  Revision 1.36  2004/10/28 10:56:21  mangeot
 *  Added the list of connected users on AdminUsers.java,
 *  Added the possibility to sort in columns for some pages
 *  Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *  -----------------------------------------------
 *
 */
package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
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
//import org.w3c.dom.html.*;

// Imported JAVA API for XML Parsing classes
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//for debug
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.logs.*;
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
 * @created    December 8, 2004
 */
public class Home extends BasePO {

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
    protected final static String ANY_RESOURCE = "*ANY*";
    /**
     *  Description of the Field
     */
    public final static String ALL_TARGETS = "*ALL*";
    /**
     *  Description of the Field
     */
    protected final static String VOLUME_PARAMETER = "VOLUME";

    /**
     *  Description of the Field
     */
    protected final static String LOOKUP_PARAMETER = "lookup";
    /**
     *  Description of the Field
     */
    protected final static String PartialMatch_PARAMETER = "PartialMatch";
    /**
     *  Description of the Field
     */
    protected final static String HEADWORD_PARAMETER = "HEADWORD";
    /**
     *  Description of the Field
     */
    protected final static String RESOURCES_PARAMETER = "RESOURCES";
    /**
     *  Description of the Field
     */
    protected final static String TARGETS_PARAMETER = "TARGETS";
    /**
     *  Description of the Field
     */
    protected final static String SOURCE_PARAMETER = "SOURCE";

    /**
     *  Description of the Field
     */
    protected final static String OFFSET_PARAMETER = "OFFSET";

    /**
     *  Description of the Field
     */
    protected final static String ContributionsURL = "AdminContributions.po";
    /**
     *  Description of the Field
     */
    protected final static String ContributionsVolumeParameter = "VOLUME";

    /*
     *  Parameters used for Sherlock plugin answer
     */
    /**
     *  Description of the Field
     */
    protected final static String FORMNAME = "FORMNAME";
    /**
     *  Description of the Field
     */
    protected final static String SHERLOCK_FORMNAME = "sherlock";

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
    protected String[] allResources;
	
	protected String[] resources;
	
	protected String headword;
	
	protected String partialMatchString;


    /**
     *  Description of the Field
     *
     * @return    Description of the Return Value
     */
    // protected ConsultXHTML content;


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
     *  Gets the currentSection attribute of the Home object
     *
     * @return    The currentSection value
     */
    protected int getCurrentSection() {
        return NO_SECTION;
    }


    /**
     *  Gets the content attribute of the Home object
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

        // On regarde d'abord les parametres qui nous sont demandes.
        String submit = myGetParameter(LOOKUP_PARAMETER);

        String sourceLanguage = myGetParameter(SOURCE_PARAMETER);
        String targetLanguage = myGetParameter(TARGETS_PARAMETER);
		String originalTargetLanguage = targetLanguage;
        String volume = myGetParameter(VOLUME_PARAMETER);
        resources = myGetParameterValues(RESOURCES_PARAMETER);

        headword = myGetParameter(HEADWORD_PARAMETER);
        partialMatchString = myGetParameter(PartialMatch_PARAMETER);
        boolean partialMatch = (null != partialMatchString && !partialMatchString.equals(""));
        int strategy = IQuery.STRATEGY_EXACT;
        if (partialMatch) {
            strategy = IQuery.STRATEGY_SUBSTRING;
        }
		
        int offset = 0;
        String offsetString = myGetParameter(OFFSET_PARAMETER);
        if (offsetString != null && !offsetString.equals("")) {
            offset = Integer.parseInt(offsetString);
		}

        String formname = myGetParameter(FORMNAME);
        String handle = myGetParameter(HANDLE);
        String xslid = myGetParameter(XSLID);

        String login = null;

        // Consultation of several headwords at one time
        String[] Headwords = new String[]{headword};

        // Consultation of several headwords at one time
        String[] targetLanguages = null;

        if (targetLanguage == null || targetLanguage.equals("")) {
            targetLanguages = null;
        } else if (targetLanguage.equals(ALL_TARGETS)) {
            targetLanguages = MyAvailableLanguages.getTargetLanguagesArray();
        } else {
            targetLanguages = new String[]{targetLanguage};
        }

        allResources = DictionariesFactory.getDictionariesNamesArray();

        if (null != resources && resources.length > 0) {
            if (resources[0].equals(ANY_RESOURCE)) {
                resources = allResources;
            }
        }

        if (null != submit && !submit.equals("")) {
            // initializing cache values for next query
            if (null != sourceLanguage && !sourceLanguage.equals("")) {
                this.setPreference(SOURCE_PARAMETER, sourceLanguage);
            }
            if (null != targetLanguage && !targetLanguage.equals("")) {
                this.setPreference(TARGETS_PARAMETER, targetLanguage);
            }
            if (null != headword && !headword.equals("")) {
                this.setPreference(HEADWORD_PARAMETER, headword, false);
            }
            // If there is a query, executing it
            return performAndDisplayQuery(resources, volume, sourceLanguage, originalTargetLanguage, targetLanguages, Headwords, strategy, handle, xslid, formname, this.getUser(), offset);
        } else {
            // If there is no query, ie connection for the first time, adding the Home content
            return createHomeContent();
            //Utility.removeElement(content.getElementVolumeEntriesTable());
            //Utility.removeElement(content.getElementEntryListTable());
            //Utility.removeElement(content.getElementSorryMessage());
        }
    }


    /**
     *  Adds a feature to the Entries attribute of the Home object
     *
     * @param  resources                                           The feature
     *      to be added to the Entries attribute
     * @param  volume                                              The feature
     *      to be added to the Entries attribute
     * @param  source                                              The feature
     *      to be added to the Entries attribute
     * @param  originalTarget                                      The feature
     *      to be added to the Entries attribute
     * @param  targets                                             The feature
     *      to be added to the Entries attribute
     * @param  Headwords                                           The feature
     *      to be added to the Entries attribute
     * @param  strategy                                            The feature
     *      to be added to the Entries attribute
     * @param  handle                                              The feature
     *      to be added to the Entries attribute
     * @param  xslid                                               The feature
     *      to be added to the Entries attribute
     * @param  formname                                            The feature
     *      to be added to the Entries attribute
     * @param  user                                                The feature
     *      to be added to the Entries attribute
     * @return                                                     Description
     *      of the Return Value
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
    protected Node performAndDisplayQuery(String[] resources, String volume, String source, String originalTarget, String[] targets, String[] Headwords, int strategy, String handle, String xslid, String formname, User user, int offset)
             throws PapillonBusinessException,
            ClassNotFoundException,
            HttpPresentationException,
            IOException,
            TransformerConfigurationException,
            org.xml.sax.SAXException,
            javax.xml.parsers.ParserConfigurationException,
            javax.xml.transform.TransformerException {

        Collection EntryCollection = null;
        boolean QueryLogging = false;

        if (null != handle && null != volume) {
            EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, user);
        } else if (null != volume) {
            EntryCollection =  (Collection) VolumeEntriesFactory.getVolumeNameEntriesVector(volume, null, Headwords, strategy);
        } else {
            EntryCollection = DictionariesFactory.getDictionariesEntriesCollection(resources, source, targets, Headwords, strategy, null, null, null, null, null, user,offset);

            QueryLogging = true;
        }

        // Logging the query into the database !

        if (QueryLogging && QueryLogsFactory.StoreQueryLogs()) {
            String[][] results = null;

            if (EntryCollection != null && EntryCollection.size() > 0) {
                results = new String[QueryLog.MAX_LOGGED_RESULTS][2];
                Iterator myIterator = EntryCollection.iterator();
                int i = 0;
                while ((myIterator.hasNext()) && (i < QueryLog.MAX_LOGGED_RESULTS)) {
                    IAnswer myEntry = (IAnswer) myIterator.next();
                    results[i][0] = myEntry.getDictionaryName();
                    results[i][1] = myEntry.getHeadword();
                    i++;
                }
            }
            String login = "";
            if (user != null && !user.IsEmpty()) {
                login = user.getLogin();
            }
            QueryLog myQueryLog = QueryLogsFactory.newQueryLog(login,
                    this.getUrl(),
                    this.getUserPreferredLanguage(),
                    Headwords[0],
                    results,
                    source,
                    targets,
                    new String[]{ANY_RESOURCE},
                    Integer.toString(strategy),
                    "");
            myQueryLog.save();
        }

        // Content creation
        ConsultXHTML content = (ConsultXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ConsultXHTML", this.getComms(), this.getSessionData());

        // If there are too much entries ie > MaxDisplayedEntries,
        // we display a table of entries instead of the entries
        if (EntryCollection != null && EntryCollection.size() > 0) {
            if (EntryCollection.size() > DictionariesFactory.MaxDisplayedEntries) {
                Utility.removeElement(content.getElementVolumeEntriesTable());
                addEntryTable(content, EntryCollection, source, originalTarget, strategy, offset);
            } else {
                Utility.removeElement(content.getElementEntryListTable());
                addFewEntries(content, EntryCollection, xslid);
            }
            Utility.removeElement(content.getElementSorryMessage());
        } else {
            Utility.removeElement(content.getElementVolumeEntriesTable());
            Utility.removeElement(content.getElementEntryListTable());
        }
        return (Node) content.getElementConsultContent();
    }


    /**
     *  Adds a feature to the EntryTable attribute of the Home object
     *
     * @param  EntryCollection                           The feature to be added
     *      to the EntryTable attribute
     * @param  target                                    The feature to be added
     *      to the EntryTable attribute
     * @param  strategy                                  The feature to be added
     *      to the EntryTable attribute
     * @exception  PapillonBusinessException             Description of the
     *      Exception
     * @exception  java.io.UnsupportedEncodingException  Description of the
     *      Exception
     */
    protected void addEntryTable(ConsultXHTML content, Collection EntryCollection, String source, String target, int strategy, int offset)
             throws PapillonBusinessException,
            java.io.UnsupportedEncodingException {

        PapillonLogger.writeDebugMsg("addEntryTable, size: " + EntryCollection.size());
        // init of PartialMatch
        String partialMatch = "";
        if (strategy == IQuery.STRATEGY_SUBSTRING) {
            partialMatch = "on";
        }

        // On récupère les éléments du layout
        XHTMLTableRowElement entryListRow = content.getElementEntryListRow();
        XHTMLElement vocable = content.getElementVocable();
        XHTMLAnchorElement entryAnchor = content.getElementEntryAnchor();
        XHTMLElement entryIdList = content.getElementEntryIdList();
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
        entryIdList.removeAttribute("id");
        pos.removeAttribute("id");
        contribAnchor.removeAttribute("id");
        dictname.removeAttribute("id");
        formulaElement.removeAttribute("id");
        entryNumberElement.removeAttribute("id");
        previousEntriesAnchor.removeAttribute("id");
        nextEntriesAnchor.removeAttribute("id");
		
		content.setTextEntryNumber(""+EntryCollection.size());
		
		
        String href = this.getUrl() + "?"
			+ HEADWORD_PARAMETER + "=" + headword + "&"
			+ serializeParameterForUrl(RESOURCES_PARAMETER, resources)
			+ SOURCE_PARAMETER + "=" + source + "&"
            + TARGETS_PARAMETER + "=" + target + "&"
            + PartialMatch_PARAMETER + "=" + partialMatch + "&"
            + LOOKUP_PARAMETER + "=" + LOOKUP_PARAMETER + "&"
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
                //            String vocable = theDicArray[i].getKey1();
                content.setTextVocable(myEntry.getHeadwords());

                // l'entry id
                href = this.getUrl() + "?"
                         + VOLUME_PARAMETER + "=" + myEntry.getVolumeName() + "&"
                         + HANDLE + "=" + myEntry.getHandle() + "&"
                         + SOURCE_PARAMETER + "=" + myEntry.getSourceLanguage() + "&"
                         + TARGETS_PARAMETER + "=" + target + "&"
                         + PartialMatch_PARAMETER + "=" + partialMatch + "&"
                         + LOOKUP_PARAMETER + "=" + LOOKUP_PARAMETER;
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
                    posstr = ((VolumeEntry) myEntry).getPoss();
                }
                if (null == posstr || posstr.equals("")) {
                    posstr = "+";
                }
                content.setTextPosEntry(posstr);

                // The volume
                content.setTextDictionaryName(myEntry.getDictionaryName());

                // The formula
                content.setTextFormula(IAnswerFactory.getDefinitionString(myEntry));

                XHTMLElement cloneEntry = (XHTMLElement) entryListRow.cloneNode(true);
                XHTMLElement cloneFormula = (XHTMLElement) formulaRow.cloneNode(true);
                //      we have to take off the id attribute because we did not take it off the original
                cloneEntry.removeAttribute("id");
                cloneFormula.removeAttribute("id");
                lexieTable.appendChild(cloneEntry);
                lexieTable.appendChild(cloneFormula);

            }
        }
        Utility.removeElement(content.getElementEntryListRow());
        Utility.removeElement(content.getElementFormulaRow());
    }


    /**
     *  Adds a feature to the Element attribute of the Home object
     *
     * @param  element                        The feature to be added to the
     *      Element attribute
     * @param  resourceName                   The feature to be added to the
     *      Element attribute
     * @exception  PapillonBusinessException  Description of the Exception
     */
    protected void addElement(ConsultXHTML content, Element element, String resourceName)
             throws PapillonBusinessException {

        try {
            //for the entry content
            XHTMLTableRowElement originalEntryRow = content.getElementEntryRow();
            Node entryTable = originalEntryRow.getParentNode();
            //for the entry content


            content.setTextResourceName(resourceName);

            //for the lexie content
            XHTMLElement entryCell = (XHTMLElement) content.getElementEntryDiv();
            entryCell.removeAttribute("id");

            if (entryCell.getChildNodes().getLength() > 0) {
                entryCell.removeChild(entryCell.getFirstChild());
            }
            entryCell.appendChild(content.importNode(element, true));

            XHTMLTableRowElement entryRow = (XHTMLTableRowElement) originalEntryRow.cloneNode(true);
            entryRow.removeAttribute("id");
            entryTable.appendChild(entryRow);
            // Don't remove the original node in order to add more entries ...
            // entryTable.removeChild(entryRow);
        } catch (Exception ex) {
            throw new PapillonBusinessException("Exception in addEntries: ", ex);
        }
    }


    /**
     *  Adds a feature to the FewEntries attribute of the Home object
     *
     * @param  EntryCollection
     *      The feature to be added to the FewEntries attribute
     * @param  xslid
     *      The feature to be added to the FewEntries attribute
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    protected void addFewEntries(ConsultXHTML content, Collection EntryCollection, String xslid)
             throws fr.imag.clips.papillon.business.PapillonBusinessException {
        if (EntryCollection != null && EntryCollection.size() > 0) {
            for (Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {

                IAnswer myEntry = (IAnswer) myIterator.next();
                addElement(content, XslTransformation.applyXslSheets(myEntry, xslid),
                        myEntry.getDictionaryName());
            }
        } else {
            Utility.removeElement(content.getElementEntryListTable());
        }
        Utility.removeElement(content.getElementEntryRow());
    }


    /**
     *  Adds a feature to the HomeContent attribute of the Home object
     *
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  java.io.IOException        Description of the Exception
     */
    public Node createHomeContent()
             throws HttpPresentationException,
            java.io.IOException {
        HomeContentXHTML homeContent = (HomeContentXHTML) MultilingualXHtmlTemplateFactory.createTemplate("HomeContentXHTML", this.getComms(), this.getSessionData());
        Element home = homeContent.getElementHomeContent();
        Element projectDescription = homeContent.getElementProjectDescription();

        /*
         *  In order to avoid a preference in the languages displayed on the home page,
         *  the order of the languages is changed randomly
         *  Beware, this code is tightly boud to the HMTL code of HomeContent.html
         */
        Vector h1Nodes = new Vector();
        Vector pNodes = new Vector();
        NodeList childNodes = projectDescription.getChildNodes();
        if (childNodes != null && childNodes.getLength() > 0) {
            while (childNodes.getLength() > 0) {
                Node myNode = childNodes.item(0);
                if (myNode.getNodeName().equalsIgnoreCase("p")) {
                    pNodes.add(myNode);
                } else if (myNode.getNodeName().equalsIgnoreCase("h1")) {
                    h1Nodes.add(myNode);
                }
                projectDescription.removeChild(myNode);
            }
            int index = 0;
            while (h1Nodes.size() > 0 && pNodes.size() > 0 && h1Nodes.size() == pNodes.size()) {
                index = (int) Math.round(Math.random() * (double) h1Nodes.size());
                if (index >= h1Nodes.size()) {
                    index -= 1;
                }
                Node temph1Node = (Node) h1Nodes.elementAt(index);
                projectDescription.appendChild(temph1Node);
                h1Nodes.remove(temph1Node);

                Node temppNode = (Node) pNodes.elementAt(index);
                projectDescription.appendChild(temppNode);
                pNodes.remove(temppNode);
            }
        }
        //Element homeParent = content.getElementHomeContent();
        //homeParent.appendChild(content.importNode(home, true));
        //homeParent.removeAttribute("id");
        return (Node) home;
    }
}

