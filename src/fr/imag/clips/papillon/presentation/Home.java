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
 *  Revision 1.16  2006/03/06 10:06:23  mangeot
 *  Horrible hack sur Home.java pour pouvoir utiliser tout de suite cette version sur le GDEF.
 *  Another thing: the fuzzy search takes a lot of time, so I launch it only if the normal search returns no result.
 *
 *  Revision 1.15  2006/03/01 15:12:31  mangeot
 *  Merge between maintrunk and LEXALP_1_1 branch
 *
 *  Revision 1.14  2006/02/28 18:12:15  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.13.2.6  2006/02/17 13:21:25  mangeot
 *
 *  MM: modified AdvancedQueryForm. getAllTargetLanguages, getAllSourceLanguages and getCdmElementsWithDefaultLanguage are now static in AvailableLanguages.java in order to accelerate the execution.
 *
 *  Revision 1.13.2.5  2006/01/25 15:22:23  fbrunet
 *  Improvement of QueryRequest
 *  Add new search criteria
 *  Add modified status
 *
 *  Revision 1.13.2.4  2006/01/24 13:39:49  fbrunet
 *  Modification view management
 *  Modification LexALP postprocessing
 *
 *  Revision 1.13.2.3  2005/12/02 14:10:29  fbrunet
 *  *** empty log message ***
 *
 *  Revision 1.13.2.2  2005/12/02 10:04:09  fbrunet
 *  Add Pre/Post edition processing
 *  Add index reconstruction
 *  Add new query request
 *  Add fuzzy search
 *  Add new contribution administration
 *  Add xsl transformation volume
 *
 *  Revision 1.13.2.1  2005/10/24 16:29:19  fbrunet
 *  Added fuzzy search capabilities.
 *  Added possibility to rebuild the index DB tables.
 *  Added Pre and post processors that could be defined by the user.
 *
 *  Revision 1.13  2005/08/16 08:09:58  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.12  2005/08/08 07:06:40  mangeot
 *  Added a cache for the validated and reviewed entries count in Home.java
 *
 *  Revision 1.11  2005/08/01 08:34:03  mangeot
 *  Added method getCompleteHeadword for VolumeEntry that concatenates the homograph number and the particule to the headword
 *
 *  Revision 1.10  2005/07/16 12:58:31  serasset
 *  Added limit parameter to query functions
 *  Added a parameter to Formater initializations
 *  Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 *  Revision 1.9  2005/06/15 16:48:28  mangeot
 *  Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 *  Revision 1.8  2005/05/24 12:51:22  serasset
 *  Updated many aspect of the Papillon project to handle lexalp project.
 *  1. Layout is now parametrable in the application configuration file.
 *  2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 *  3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 *  4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 *  5. It is now possible to give a name to the cookie key in the app conf file
 *  6. Several bug fixes.
 *
 *  Revision 1.7.4.5  2005/06/15 10:08:06  mangeot
 *  Removed the AND/OR connector, now only AND criteria can be added for dict lookup
 *
 *  Revision 1.7.4.4  2005/06/09 11:07:45  mangeot
 *  Deleted the countEntriesCache. entries counts are not cached any more.
 *  Fixed a few bugs.
 *
 *  Revision 1.7.4.3  2005/05/27 11:53:34  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.7.4.2  2005/05/11 14:45:30  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.7.4.1  2005/04/29 14:50:25  mangeot
 *  New version with contribution infos embedded in the XML of the entries
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
    protected String[] allResources;
	
	protected String[] resources;
	
	protected String headword;
	
	protected String partialMatchString;
	
	protected static int GDEF_estValidatedEntriesCount = 0;

	protected static int GDEF_estReviewedEntriesCount = 0;
	
	protected static java.util.Calendar myCalendar = new java.util.GregorianCalendar();

	protected static int DAY_OF_MONTH = 0;


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
            //targetLanguages = AvailableLanguages.getTargetLanguagesArray();
            targetLanguages = null;
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
                
        
		boolean reverseLookup = false;
        boolean QueryLogging = false;
		

        // FIXME: Search should be define in business layer
        //==================== CLASSIC ENTRY SEARCH====================
        Collection EntryCollection = null;
        
        // Intialize QueryRequest
        QueryRequest query = new QueryRequest(VolumesFactory.getVolumesArrayName(null, source, null));
        query.setTargets(targets);
        query.setOffset(offset);
                
        /*
        //FIXME: depend on user ?
        QueryCriteria criteriaFinishedStatus = new QueryCriteria();
        criteriaFinishedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
        criteriaFinishedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.FINISHED_STATUS);
        query.addCriteria(criteriaFinishedStatus);
        */
        
        
        //FIXME: add to QueryRequest methods and add to user groups !!!
        ArrayList listStatus = new ArrayList();
        
		
		//FIXME: MM: j'ai bien conscience que c'est un hack monstrueux mais la terre doit continuer de tourner...
		if (((fr.imag.clips.papillon.Papillon)com.lutris.appserver.server.Enhydra.getApplication()).getLoginCookieName().equals("GDEFLoginCookie")) {
			QueryCriteria criteria = new QueryCriteria();
			criteria.add("key", QueryCriteria.EQUAL, Volume.CDM_headword);
			criteria.add("value", QueryCriteria.EQUAL, headword);               // match headword (no case sensitive)
			criteria.add("lang", QueryCriteria.EQUAL, source);
			query.addCriteria(criteria);
			QueryCriteria criteriaValidatedStatus = new QueryCriteria();
			criteriaValidatedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);
			criteriaValidatedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.VALIDATED_STATUS);
			listStatus.add(criteriaValidatedStatus);
			
		}
		else {
			QueryCriteria criteria = new QueryCriteria();
			criteria.add("key", QueryCriteria.EQUAL, Volume.CDM_headword);
			criteria.add("value", QueryCriteria.CASE_INSENSITIVE_EQUAL, headword);               // match headword (no case sensitive)
			criteria.add("lang", QueryCriteria.EQUAL, source);
			query.addCriteria(criteria);
			QueryCriteria criteriaFinishedStatus = new QueryCriteria();
			criteriaFinishedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
			criteriaFinishedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.FINISHED_STATUS);
			listStatus.add(criteriaFinishedStatus);
			
			QueryCriteria criteriaValidatedStatus = new QueryCriteria();
			criteriaValidatedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);
			criteriaValidatedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.MODIFIED_STATUS);
			listStatus.add(criteriaValidatedStatus);
		}
        
        query.addOrCriteriaList(listStatus);
        
        
        // FIXME: add different searches
        //if (null != handle && null != volume) {
        //    EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, user);
        //}
        // Find lexies and translation
        EntryCollection = query.findLexieAndTranslation(user);
            
        /*
        // Old version
		Vector myKey = new Vector();
        Collection EntryCollection = null;

		//Headword[0] = key
		//Headword[1] = lang
		//Headword[2] = value
		//Headword[3] = strategy

		String[] Headword = new String[4];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = source;
		Headword[2] = headword;
		Headword[3] = "ilike";                      // match headword (no case sensitive)
        // Headword[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
        myKey.add(Headword);                                                  
        
		String[] status = new String[4];
		status[0] = Volume.CDM_contributionStatus;
		status[1] = Volume.DEFAULT_LANG;
		status[2] = VolumeEntry.VALIDATED_STATUS;                     
		status[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
		myKey.add(status);


        if (null != handle && null != volume) {
            EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, user);
        } else if (null != volume) {
            EntryCollection =  (Collection) VolumeEntriesFactory.getVolumeNameEntriesVector(volume, myKey, null, null);
        } else {
            EntryCollection = DictionariesFactory.getDictionariesEntriesCollection(resources, source, targets, myKey, null, null, user,offset);
			if (EntryCollection==null || EntryCollection.size()==0) {
				PapillonLogger.writeDebugMsg("EntryCollection null, getDictionariesReverseEntriesCollection");
				EntryCollection = DictionariesFactory.getDictionariesReverseEntriesCollection(resources, source, targets, myKey, null, null, user,offset);
				reverseLookup = (EntryCollection!=null && EntryCollection.size()>0);
			}
            QueryLogging = true;
        }
        */
        
               
        //==================== FUZZY ENTRY SEARCH====================
        // FIXME: introduce fuzzysearch variable in dictionaries like reverse lookup to allow (or not) fuzzy entries search
        Collection FuzzyEntryCollection = null;
        
		// added by MM. the fuzzy search takes a lot of time so I do it if no results 
		if (EntryCollection ==null || EntryCollection.size()==0) {
        // Intialize QueryRequest
        QueryRequest fuzzyQuery = new QueryRequest(VolumesFactory.getVolumesArrayName(null, source, null));
        fuzzyQuery.setTargets(targets);
        
        //
        QueryCriteria criteriaFuzzyMatch = new QueryCriteria();
        criteriaFuzzyMatch.add("key", QueryCriteria.EQUAL, Volume.CDM_headword);
        criteriaFuzzyMatch.addAdvancedValue("value", QueryCriteria.CASE_INSENSITIVE_CONTAINS, headword);    // parse headword to adapt criteria
        //replace criteriaFuzzyMatch.add("value", QueryCriteria.CASE_INSENSITIVE_CONTAINS, headword);       // like headword (no case sensitive)
        criteriaFuzzyMatch.add("value", QueryCriteria.CASE_INSENSITIVE_NOT_EQUAL, headword);                // not match headword (no case sensitive)
        criteriaFuzzyMatch.add("lang", QueryCriteria.EQUAL, source);
        
        fuzzyQuery.addCriteria(criteriaFuzzyMatch);
        //FIXME: depend on user ?
        //fuzzyQuery.addCriteria(criteriaFinishedStatus);
        fuzzyQuery.addOrCriteriaList(listStatus);
        
        // Find lexies and translation
        FuzzyEntryCollection = fuzzyQuery.findLexieAndTranslation(user);
		}
        
        /*
        // Old version
         
        myKey = new Vector();
		//Headword[0] = key
		//Headword[1] = lang
		//Headword[2] = value
		//Headword[3] = strategy
        
		Headword = new String[4];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = source;
		Headword[2] = "%" + headword + "%";            // like headword (no case sensitive)
		Headword[3] = "ilike";
        myKey.add(Headword);
		
		String[] NoHead = new String[4];
		NoHead[0] = Volume.CDM_headword;
		NoHead[1] = source;
		NoHead[2] = headword;
		NoHead[3] =  "not ilike";                       // not match headword (no case sensitive)
		myKey.add(NoHead);
        
		status = new String[4];
		status[0] = Volume.CDM_contributionStatus;
		status[1] = Volume.DEFAULT_LANG;
		status[2] = VolumeEntry.FINISHED_STATUS;
		status[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
		myKey.add(status);
        
        if (null != handle && null != volume) {
            FuzzyEntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, user);
        } else if (null != volume) {
            FuzzyEntryCollection =  (Collection) VolumeEntriesFactory.getVolumeNameEntriesVector(volume, myKey, null, null);
        } else {
            FuzzyEntryCollection = DictionariesFactory.getDictionariesEntriesCollection(resources, source, targets, myKey, null, null, user,offset);
			if (FuzzyEntryCollection==null || FuzzyEntryCollection.size()==0) {
				PapillonLogger.writeDebugMsg("FuzzyEntryCollection null, getDictionariesReverseEntriesCollection");
				FuzzyEntryCollection = DictionariesFactory.getDictionariesReverseEntriesCollection(resources, source, targets, myKey, null, null, user,offset);
				reverseLookup = reverseLookup || (FuzzyEntryCollection!=null && FuzzyEntryCollection.size()>0);
			}
            QueryLogging = true;
        }
        
        // Add Fuzzy entry in entry collection
        //EntryCollection.addAll(FuzzyEntryCollection);
       */
        
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

        // Display entries
        if (    ((EntryCollection != null) || (FuzzyEntryCollection != null)) 
                && ((EntryCollection.size() > 0) || (FuzzyEntryCollection.size() > 0))) {
			
            // Display classic search entries 
            if ((EntryCollection != null) && (EntryCollection.size() > 0)) {
                Utility.removeElement(content.getElementEntryListTable());
                addFewEntries(content, EntryCollection, xslid);
            } else {
                Utility.removeElement(content.getElementEntryListTable());
                Utility.removeElement(content.getElementVolumeEntriesTable());
            }

            // Display fuzzy search entries
            if ((FuzzyEntryCollection != null) && (FuzzyEntryCollection.size() > 0)) {
                // FIxME: merge fuzzy and classic display methods
                addFewFuzzyEntries(content, FuzzyEntryCollection, xslid); 
            } else {
                Utility.removeElement(content.getElementFuzzyTitle());
                Utility.removeElement(content.getElementVolumeFuzzyEntriesTable());
            }
            
            /*
             // FIXME: add reverse lookup method in queryRequest
             //if (reverseLookup) {
             //	XHTMLElement reverseLookupMsg = content.getElementReverseLookupMessage();
             //	reverseLookupMsg.setAttribute("class","");
             //}
             
             // FIXME: Integrate fuzzy entries in addEntryTable method !
             // If there are too much entries ie > MaxDisplayedEntries,
             // we display a table of entries instead of the entries
             if ( (EntryCollection.size() + FuzzyEntryCollection.size()) > DictionariesFactory.MaxDisplayedEntries) {
                 Utility.removeElement(content.getElementVolumeEntriesTable());
                 addEntryTable(content, EntryCollection, source, originalTarget, strategy, offset);
             } else {
                 Utility.removeElement(content.getElementEntryListTable());
                 addFewEntries(content, EntryCollection, xslid);
             }
             */
            
            Utility.removeElement(content.getElementSorryMessage());
        
        } else {
            Utility.removeElement(content.getElementEntryListTable());
            Utility.removeElement(content.getElementVolumeEntriesTable());
            Utility.removeElement(content.getElementFuzzyTitle());
            Utility.removeElement(content.getElementVolumeFuzzyEntriesTable());
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
			+ serializeParameterForUrl(RESOURCES_PARAMETER, resources) + "&"
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
                content.setTextVocable(myEntry.getCompleteHeadword());
                
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
    
    protected void addFuzzyElement(ConsultXHTML content, Element element, String resourceName)
        throws PapillonBusinessException {
            
            try {
                //for the entry content
                XHTMLTableRowElement originalEntryRow = content.getElementFuzzyEntryRow();
                Node entryTable = originalEntryRow.getParentNode();
                //for the entry content
                
                content.getElementFuzzyResourceName().removeAttribute("id");
                content.setTextFuzzyResourceName(resourceName);
                
                //for the lexie content
                XHTMLElement entryCell = (XHTMLElement) content.getElementFuzzyEntryDiv();
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
    
    protected void addFewFuzzyEntries(ConsultXHTML content, Collection qrset, String xslid)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
            if (qrset != null && qrset.size() > 0) {
                for (Iterator myIterator = qrset.iterator(); myIterator.hasNext(); ) {
                    addFuzzyEntry(content, (QueryResult) myIterator.next(), xslid);
                }
            } else {
                Utility.removeElement(content.getElementVolumeFuzzyEntriesTable());
            }
            Utility.removeElement(content.getElementFuzzyEntryRow());
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
        ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, null, ResultFormatterFactory.XHTML_DIALECT,null);
        //rf.initializeFormatter(qr.getSourceEntry().getDictionary(), qr.getSourceEntry().getVolume() , null, ResultFormatterFactory.XHTML_DIALECT,null);
        
        addElement(content, (Element)rf.getFormattedResult(qr, this.getUser()), qr.getSourceEntry().getDictionaryName());
                   
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
	
    protected void addFuzzyEntry(ConsultXHTML content, QueryResult qr, String xslid)
		throws fr.imag.clips.papillon.business.PapillonBusinessException
    {
        // get the apropriate transformer.
        ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, null, ResultFormatterFactory.XHTML_DIALECT,null);        
        addFuzzyElement(content, (Element)rf.getFormattedResult(qr, this.getUser()), qr.getSourceEntry().getDictionaryName());
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
		Element GDEFValidatedEntryCountFra = home.getOwnerDocument().getElementById("GDEFValidatedEntryCountFra");
		Element GDEFValidatedEntryCountEst = home.getOwnerDocument().getElementById("GDEFValidatedEntryCountEst");
		Element GDEFReviewedEntryCountFra = home.getOwnerDocument().getElementById("GDEFReviewedEntryCountFra");
		Element GDEFReviewedEntryCountEst = home.getOwnerDocument().getElementById("GDEFReviewedEntryCountEst");
		if (GDEFValidatedEntryCountFra != null && GDEFValidatedEntryCountEst != null 
			&& GDEFReviewedEntryCountFra != null && GDEFReviewedEntryCountEst != null) {
			Volume GDEFVolume = VolumesFactory.findVolumeByName("GDEF_est");
			if (GDEFVolume!=null) {
				myCalendar = new java.util.GregorianCalendar();
				if (myCalendar.get(myCalendar.DAY_OF_MONTH) != DAY_OF_MONTH) {
					GDEF_estValidatedEntriesCount = GDEFVolume.getCount(VolumeEntry.VALIDATED_STATUS);
					GDEF_estReviewedEntriesCount = GDEFVolume.getCount(VolumeEntry.REVIEWED_STATUS);
					DAY_OF_MONTH = myCalendar.get(myCalendar.DAY_OF_MONTH);
				}
				Utility.setText(GDEFValidatedEntryCountFra,"" + GDEF_estValidatedEntriesCount);
				Utility.setText(GDEFValidatedEntryCountEst,"" + GDEF_estValidatedEntriesCount);
				Utility.setText(GDEFReviewedEntryCountFra,"" + GDEF_estReviewedEntriesCount);
				Utility.setText(GDEFReviewedEntryCountEst,"" + GDEF_estReviewedEntriesCount);
			}
		}
		
        //Element homeParent = content.getElementHomeContent();
        //homeParent.appendChild(content.importNode(home, true));
        //homeParent.removeAttribute("id");
        return (Node) home;
    }
}

