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
 *  Revision 1.8  2005/05/24 12:51:22  serasset
 *  Updated many aspect of the Papillon project to handle lexalp project.
 *  1. Layout is now parametrable in the application configuration file.
 *  2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 *  3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 *  4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 *  5. It is now possible to give a name to the cookie key in the app conf file
 *  6. Several bug fixes.
 *
 *  Revision 1.7  2005/04/20 10:51:14  mangeot
 *  Correction de AddDirectTranslations
 *
 *  Revision 1.6  2005/04/13 14:34:38  mangeot
 *  Simplified the expert lookup. Now lookup directly the cdm element name
 *
 *  Revision 1.5  2005/04/11 12:29:59  mangeot
 *  Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 *  Revision 1.4.2.5  2005/04/01 15:16:05  mangeot
 *  Added validated contributions count on GDEF homepage
 *
 *  Revision 1.4.2.4  2005/02/25 10:22:08  mangeot
 *  Bug fixes and added the use of referrer when exiting from Reviewcontributions.po
 * 
 *  Revision 1.4.2.3  2005/02/06 22:43:49  mangeot
 *  Merged the 2 Hashtables CDM Elements and XPaths into one
 *  Added a boolean (reverse-lookup) in the volume metadata and functionalities in order to perform a reverse lookup when no direct lookup result is found
 *  Added a boolean (index) in the volume metadata for indexing the only specified CDM Elements
 *
 *  Revision 1.4.2.2  2005/01/28 19:45:55  mangeot
 *  First version that runs basically.
 *  Should compile after an ant clean.
 *  XPath loading and virtual volumes for terminological lexicons are OK.
 *  Bugs remain, needs more testings like the editor for example.
 *
 *  Revision 1.4.2.1  2005/01/27 19:29:21  mangeot
 *  Implemented the HtmlDom cache, it increases speed drastically.
 *  Still does not compile after an ant clean
 *
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
public class Home extends PapillonBasePO {

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
    protected boolean userMayUseThisPO() {
        return true;
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
            return performAndDisplayQuery(resources, volume, sourceLanguage, originalTargetLanguage, targetLanguages, headword, strategy, handle, xslid, formname, this.getUser(), offset);
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
    protected Node performAndDisplayQuery(String[] resources, String volume, String source, String originalTarget, String[] targets, String headword, int strategy, String handle, String xslid, String formname, User user, int offset)
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
        boolean QueryLogging = false;
		
		//Headword[0] = key
		//Headword[1] = lang
		//Headword[2] = value
		String[] Headword = new String[3];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = source;
		Headword[2] = headword;
		Vector myKey = new Vector();
		myKey.add(Headword);


        if (null != handle && null != volume) {
            EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, user);
        } else if (null != volume) {
            EntryCollection =  (Collection) VolumeEntriesFactory.getVolumeNameEntriesVector(volume, myKey, null, strategy);
        } else {
            EntryCollection = DictionariesFactory.getDictionariesEntriesCollection(resources, source, targets, myKey, null, strategy, user,offset);
			if (EntryCollection==null || EntryCollection.size()==0) {
				PapillonLogger.writeDebugMsg("EntryCollection null, getDictionariesReverseEntriesCollection");
				EntryCollection = DictionariesFactory.getDictionariesReverseEntriesCollection(resources, source, targets, myKey, null, strategy, user,offset);
				reverseLookup = (EntryCollection!=null && EntryCollection.size()>0);
			}
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
                    Object myAnswer = myIterator.next();
                    if (myAnswer instanceof Collection) {
                        results[i][0] = "PivotDict";
                        results[i][1] = "Some Collection...";
                    } else if (myAnswer instanceof IAnswer) {
                        IAnswer myEntry = (IAnswer) myAnswer;
                        results[i][0] = myEntry.getDictionaryName();
                        results[i][1] = myEntry.getHeadword();
                    }
                    i++;
                }
            }
            String login = "";
            if (user != null && !user.isEmpty()) {
                login = user.getLogin();
            }
            QueryLog myQueryLog = QueryLogsFactory.newQueryLog(login,
                    this.getUrl(),
                    this.getUserPreferredLanguage(),
                    headword,
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
			if (reverseLookup) {
				XHTMLElement reverseLookupMsg = content.getElementReverseLookupMessage();
				reverseLookupMsg.setAttribute("class","");
			}
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
    protected void addEntryTable(ConsultXHTML content, Collection qrset, String source, String target, int strategy, int offset)
             throws PapillonBusinessException,
            java.io.UnsupportedEncodingException {

        PapillonLogger.writeDebugMsg("addEntryTable, size: " + qrset.size());
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
		
		content.setTextEntryNumber(""+qrset.size());
		
		
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
        if (null != qrset) {
            for (Iterator myIterator = qrset.iterator(); myIterator.hasNext(); ) {
                QueryResult myQueryResult = (QueryResult) myIterator.next();
                VolumeEntry myEntry = myQueryResult.getSourceEntry();
                
                // Le vocable
                //            String vocable = theDicArray[i].getKey1();
                content.setTextVocable(myEntry.getHeadword());
                
                // l'entry id
                href = this.getUrl() + "?"
                    + VOLUME_PARAMETER + "=" + myEntry.getVolumeName() + "&"
                    + HANDLE + "=" + myEntry.getHandle() + "&"
                    + SOURCE_PARAMETER + "=" + myEntry.getSourceLanguage() + "&"
                    + TARGETS_PARAMETER + "=" + target + "&"
                    + PartialMatch_PARAMETER + "=" + partialMatch + "&"
                    + LOOKUP_PARAMETER + "=" + LOOKUP_PARAMETER;
                entryAnchor.setHref(href);
                
                String id = myEntry.getId();
                if (id == null) {
                    id = "";
                }
                content.setTextEntryIdList(id);
                
                // The contribution
                // FIXME: seems to be incompatible with current contrib stuff...
//                if (myEntry.getType() == IAnswer.Contribution) {
//                    Contribution myContrib = (Contribution) myEntry;
//                    
//                    String contribHref = ContributionsURL + "?"
//                        + ContributionsVolumeParameter + "="
//                        + myEntry.getVolumeName();
//                    contribAnchor.setHref(contribHref);
//                    
//                    content.setTextContribution(myContrib.getCreationDate() + " " + myContrib.getHandle());
//                } else {
//                    content.setTextContribution("");
//                }
                
                // Le pos
                String posstr = null;
                // FIXME: Apparently, volumeEntries ALWAYS return LocalEntry.... can we have remote entries here ?
                if (myEntry.getType() == IAnswer.LocalEntry) {
                    posstr = ((VolumeEntry) myEntry).getPos();
                }
                if (null == posstr || posstr.equals("")) {
                    posstr = "+";
                }
                content.setTextPosEntry(posstr);
                
                // The volume
                content.setTextDictionaryName(myEntry.getDictionaryName());
                
                // The formula
                // FIXME: Apparently, volumeEntries ALWAYS return LocalEntry.... can we have remote entries here ?
                if (myEntry.getType() == IAnswer.LocalEntry) {
                    content.setTextFormula(((VolumeEntry) myEntry).getDefinition());
                }
                
                
                XHTMLElement cloneEntry = (XHTMLElement) entryListRow.cloneNode(true);
                XHTMLElement cloneFormula = (XHTMLElement) formulaRow.cloneNode(true);
                //      we have to take off the id attribute because we did not take it off the original
                // FIXME: why did we not tae it off in the original ?
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

            content.getElementResourceName().removeAttribute("id");
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
    protected void addFewEntries(ConsultXHTML content, Collection qrset, String xslid)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
        if (qrset != null && qrset.size() > 0) {
            for (Iterator myIterator = qrset.iterator(); myIterator.hasNext(); ) {
				addEntry(content, (QueryResult) myIterator.next(), xslid);
             }
        } else {
            Utility.removeElement(content.getElementEntryListTable());
        }
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
    protected void addEntry(ConsultXHTML content, QueryResult qr, String xslid)
		throws fr.imag.clips.papillon.business.PapillonBusinessException
    {
        // get the apropriate transformer.
        ResultFormatter rf = ResultFormatterFactory.getFormatter(qr,ResultFormatterFactory.XHTML_DIALECT,null);
        rf.initializeFormatter(qr.getSourceEntry().getDictionary(), qr.getSourceEntry().getVolume() ,ResultFormatterFactory.XHTML_DIALECT,null);
        
        addElement(content, (Element)rf.getFormattedResult(qr), qr.getSourceEntry().getDictionaryName());
                   
        //VolumeEntry myEntry = qr.getSourceEntry();
//        org.w3c.dom.Element myHtmlElt = null;
//        org.w3c.dom.Document myHtmlDoc = myEntry.getHtmlDom();
//        if (xslid != null || myHtmlDoc == null) {
//            myHtmlElt = XslTransformation.applyXslSheets(myEntry, xslid);
//            myHtmlDoc = myHtmlElt.getOwnerDocument();
//            if (xslid == null) {
//                myEntry.setHtmlDom(myHtmlDoc);
//                ((VolumeEntry)myEntry).saveHTML();
//            }
//        }
//        else {
//            myHtmlElt = myHtmlDoc.getDocumentElement();
//        }
//        addElement(content, myHtmlElt, myEntry.getDictionaryName());
        
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
		// code spécifique pour le GDEF
		Element GDEFEntryCountFra = home.getOwnerDocument().getElementById("GDEFEntryCountFra");
		Element GDEFEntryCountEst = home.getOwnerDocument().getElementById("GDEFEntryCountEst");
		if (GDEFEntryCountFra != null && GDEFEntryCountEst != null ) {
			Volume GDEFVolume = VolumesFactory.findVolumeByName("GDEF_est");
			if (GDEFVolume!=null) {
				Utility.setText(GDEFEntryCountFra,"" + ContributionsFactory.getCount(GDEFVolume));
				Utility.setText(GDEFEntryCountEst,"" + ContributionsFactory.getCount(GDEFVolume));
			}
		}
		
        //Element homeParent = content.getElementHomeContent();
        //homeParent.appendChild(content.importNode(home, true));
        //homeParent.removeAttribute("id");
        return (Node) home;
    }
}

