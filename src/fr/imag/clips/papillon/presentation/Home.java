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
 *
 *  Revision 1.35  2004/10/01 15:13:48  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.34  2004/09/14 13:04:40  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.33  2004/05/11 16:15:47  serasset
 *  The database now bear a <?xml instruction in the beginning of newly created
 *  files.Hence, when building a fake Papillon entry 1 source -> n targets, each
 *  translation is preceded by an invalid instruction. Hence the entry could not
 *  be parsed for Xsl transformation. As a result, Papillon returned a null pointer
 *  exception. Fixed with a hack that suppress the instruction directly in the xml
 *  code when the fake entry is built.
 *
 *  Revision 1.32  2004/04/22 13:23:33  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.31  2004/03/23 04:18:24  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.30  2004/02/10 05:27:15  mangeot
 *  The version UIGEN_V2 has been merged with the trunk by MM
 *  Be careful because the Volumes and contributions database tables have been modified.
 *  You have to drop and rebuild them unless you modify them by hands.
 *
 *  Revision 1.29.2.3  2004/01/12 14:47:30  mangeot
 *  bug fix
 *
 *  Revision 1.29.2.2  2004/01/12 14:46:03  mangeot
 *  bug fix
 *
 *  Revision 1.29.2.1  2004/01/08 09:43:21  mangeot
 *  Changed all the mechanism of the management of the contributions
 *  Have to be tested
 *
 *  Revision 1.29  2003/11/20 05:34:24  mangeot
 *  Bug fixes in the parameters
 *
 *  Revision 1.28  2003/10/04 06:48:45  mangeot
 *  Bug fixed when I selected multiple targets languages
 *
 *  Revision 1.27  2003/10/03 05:34:10  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.26  2003/09/16 09:24:54  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.25  2003/09/02 13:55:57  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.24  2003/09/02 12:18:56  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.23  2003/08/28 14:04:07  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.22  2003/08/28 13:59:39  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.21  2003/08/23 16:18:45  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.20  2003/08/23 16:08:08  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.19  2003/08/23 07:44:32  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.18  2003/08/23 06:52:03  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.17  2003/08/23 06:38:13  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.16  2003/08/23 03:58:05  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.15  2003/08/22 06:23:00  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.14  2003/08/21 09:56:51  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.13  2003/08/21 09:41:40  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.12  2003/08/21 04:47:56  mangeot
 *  Cleaning the new menu
 *
 *  Revision 1.11  2003/08/20 08:15:39  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.10  2003/08/19 06:21:56  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.9  2003/08/14 10:36:50  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.8  2003/08/14 08:30:17  mangeot
 *  Important CVS commit
 *  Attention, if you checkout this version, you must empty and
 *
 *  for their work on the editor.
 *  Important CVS commit
 *  Attention, if you checkout this version, you must empty and
 *  relaod all your database because the database schema has been modified a lot.
 *  The entries must be relaoded, the users also
 *  Merging between the stable branch and the development branch done by MM
 *  and David Thevenin for their work on the editor.
 *  It means a lot of improvements for this commit.
 *  Furthermore, the internal structure of the database has been modified in order
 *  to use index in separate db table when there is a query for an entry.
 *
 *  Revision 1.7  2003/06/04 15:37:46  serasset
 *  Mise en place de la nouvelle version de la gestion des utilisateurs.
 *
 *  Revision 1.6.2.8  2003/08/14 04:15:53  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.6.2.7  2003/08/11 10:24:52  mangeot
 *  Debugging ...
 *
 *  Revision 1.6.2.6  2003/08/09 07:21:07  mangeot
 *  Lots of improvements:
 *  possible to create a new axie linking two contributions
 *  possible to delete contributions
 *
 *  Revision 1.6.2.5  2003/07/31 16:16:02  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.6.2.4  2003/06/21 17:56:40  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.6.2.3  2003/05/28 09:17:23  mangeot
 *  Changement du copyright sur les fichiers
 *
 *  Revision 1.6.2.2  2003/05/23 13:37:30  mangeot
 *  I added getHeadwordText instead of getHeadword
 *
 *  Revision 1.6.2.1  2003/05/20 10:51:20  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.6  2003/01/31 10:00:45  mangeot
 *  Added Query Logs into the database
 *  and 2 booleans in Papillon.conf to control
 *  1- the logs
 *  2- the dictd listening server
 *
 *  Revision 1.5  2003/01/21 09:19:49  mangeot
 *  A Few corrections for the HTML rendering
 *
 *  Revision 1.4  2003/01/10 08:11:57  mangeot
 *  Problem with labels and UTF-8 fixed for internet explorer and icab
 *  Problem with language identification fixed eg: en-US
 *
 *  Revision 1.3  2003/01/09 09:38:59  mangeot
 *  Testing the browser for label display problems
 *
 *  Revision 1.2  2002/11/22 13:04:11  mangeot
 *  Nouvelle version Papillon enhydra 5.0
 *
 *  Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 *  Creation of the papillon CVS repository for enhydra 5.0
 *
 *  Revision 1.10  2002/10/25 14:10:34  mangeot
 *  merge between PAPILLON_1_4 and trunk
 *  CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 *  Revision 1.9.2.1  2002/10/23 09:51:12  serasset
 *  Clean up of the source tree,
 *  Every source file is now encoded in ISO-Latin-1,
 *  Every html file is still encoded in UTF8.
 *
 *  Revision 1.9  2002/09/17 20:29:33  mangeot
 *  Bug corrected, version deploy 1_4 ready !
 *
 *  Revision 1.8  2002/09/17 17:13:23  mangeot
 *  Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 *  Revision 1.7  2002/09/16 13:34:23  mangeot
 *  Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 *  Revision 1.6.2.5  2002/09/12 09:45:33  mangeot
 *  Modified HTML in order to query the server with Sherlock plugin
 *
 *  Revision 1.6.2.4  2002/09/12 06:51:46  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.6.2.3  2002/08/09 09:15:14  mangeot
 *  Improvements for the simple consultation
 *  adding text for help,
 *  correcting consultation bugs
 *
 *  Revision 1.6.2.2  2002/08/08 09:11:58  mangeot
 *  New Home page with simplified interface a lot of work
 *  + localization in german
 *
 *  Revision 1.31.2.2  2002/08/02 13:55:49  mangeot
 *  Corrected the encoding problem while connection to the XRCE analyzers
 *
 *  Revision 1.31.2.1  2002/08/02 08:12:22  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.31  2002/07/26 10:00:23  serasset
 *  Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 *  Revision 1.30.2.2  2002/07/25 15:33:20  serasset
 *  Added a French version of Consult.html template.
 *
 *  Revision 1.30.2.1  2002/07/12 13:50:43  serasset
 *  A new architecture for HTML template localization has been integrated.
 *
 *  Revision 1.30  2002/06/10 13:26:03  mangeot
 *  Continued the localization, added the lang string into the session data
 *
 *  Revision 1.29  2002/06/10 11:07:58  mangeot
 *  I began to implement the localization but very rapidly ...
 *
 *  Revision 1.28  2002/05/24 16:29:37  mangeot
 *  Adding colspan for entries
 *
 *  Revision 1.27  2002/05/23 16:14:42  mangeot
 *  Adding admin group for presentation pages
 *
 *  Revision 1.26  2002/05/22 12:43:12  mangeot
 *  bugs correction ...
 *
 *  Revision 1.25  2002/05/22 08:56:19  mangeot
 *  MML added user login and register:
 *  LoginUser.po RegisterUser.po AdminUsers.po
 *
 *  Revision 1.24  2002/05/10 16:43:19  mangeot
 *  Integration of HTML code from remote dictionary servers on the Web
 *  iUse of HTMLTidy, conversion problem remaining ...
 *
 *  Revision 1.23  2002/05/08 13:14:46  mangeot
 *  I rewrote some files of the data layer in order to be dependent
 *  from the number of tables for the Volum Entries.
 *  The next step is to generate tables on the fly with the pgsql jdbc driver
 *
 *  Revision 1.22  2002/05/07 10:31:22  mangeot
 *  The UTF-8 consultation is now OK,
 *  I tested with omniweb, iexplorer and netscape latests versions on macosX
 *
 *  Revision 1.21  2002/05/02 07:02:58  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.20  2002/04/18 11:42:35  mangeot
 *  Fait l'affichage des donnees XML metadata + stylesheets
 *  Ameliore les stylesheets
 *  corrige le bug du parsage du FeM
 *
 *  Revision 1.19  2002/04/17 17:09:24  mangeot
 *  Travail sur les stylesheets
 *
 *  Revision 1.18  2002/04/16 04:13:16  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.17  2002/04/14 09:47:12  mangeot
 *  lecture des elements CDM ds les fichiers volume-metadata
 *  et upload des entrees
 *
 *  Revision 1.16  2002/04/01 07:46:34  mangeot
 *  Added a table for volumes metadata descriptions
 *
 *  Revision 1.15  2002/03/27 09:51:29  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.14  2002/03/22 08:42:14  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.13  2002/03/20 09:36:21  mangeot
 *  Now the consultation is done in a separate db table for each volume
 *  A big pb remaining: the data directory has to be remodified by hands...
 *
 *  Revision 1.12  2002/03/19 09:11:41  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.11  2002/03/11 11:13:55  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.10  2001/12/18 13:39:41  serasset
 *  *** empty log message ***
 *
 *  Revision 1.9  2001/09/07 06:59:23  serasset
 *  Full rewrite of the administration code to generalize the handling of Information Files.
 *
 *  Revision 1.8  2001/08/31 07:45:17  salvati
 *  *** empty log message ***
 *
 *  Revision 1.7  2001/08/27 13:55:37  salvati
 *  Added : in utility: new version of nodeToString.
 *  in Admin Xml and Xsl: file input type.
 *
 *  Revision 1.6  2001/07/31 16:49:17  salvati
 *  The xsl List table is better construct..
 *
 *  Revision 1.5  2001/07/31 15:22:50  salvati
 *  Adding a package for XslTransformation.
 *  Adding Transform(xslid,xmlid) and Transform(XmlNode)(default style sheet)
 *  Some other raffinement to do...
 *
 *  Revision 1.4  2001/07/25 15:35:13  salvati
 *  Moving xsl menu to the top of the form.
 *  Adding Interface to upload file in Informatins.po.
 *
 *  Revision 1.3  2001/07/25 12:48:38  salvati
 *  Adding StyleSheet choice in the standard consultation view with a menu on the right.
 *
 *  Revision 1.2  2001/07/19 17:07:44  salvati
 *  Change the driver of database and adding namespace:too small place in db
 *
 *  Revision 1.1  2001/07/18 12:35:32  serasset
 *  Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
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
        String[] resources = myGetParameterValues(RESOURCES_PARAMETER);

        String headword = myGetParameter(HEADWORD_PARAMETER);
        String partialMatchString = myGetParameter(PartialMatch_PARAMETER);
        boolean partialMatch = (null != partialMatchString && !partialMatchString.equals(""));

        int strategy = IQuery.STRATEGY_EXACT;
        if (partialMatch) {
            strategy = IQuery.STRATEGY_SUBSTRING;
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
            return performAndDisplayQuery(resources, volume, sourceLanguage, originalTargetLanguage, targetLanguages, Headwords, strategy, handle, xslid, formname, this.getUser());
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
    protected Node performAndDisplayQuery(String[] resources, String volume, String source, String originalTarget, String[] targets, String[] Headwords, int strategy, String handle, String xslid, String formname, User user)
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
            EntryCollection = VolumeEntriesFactory.getVolumeNameEntriesHashtable(volume, null, Headwords, strategy).values();
        } else {
            EntryCollection = DictionariesFactory.getDictionariesEntriesCollection(resources, source, targets, Headwords, strategy, null, null, null, null, null, user);

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
                addEntryTable(content, EntryCollection, originalTarget, strategy);
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
    protected void addEntryTable(ConsultXHTML content, Collection EntryCollection, String target, int strategy)
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

        //      we don't take off the id attribute because we will take the element off later...
        //      entryListRow.removeAttribute("id");
        vocable.removeAttribute("id");
        entryAnchor.removeAttribute("id");
        entryIdList.removeAttribute("id");
        pos.removeAttribute("id");
        contribAnchor.removeAttribute("id");
        dictname.removeAttribute("id");
        formulaElement.removeAttribute("id");

        // On récupère le noeud contenant la table...
        Node lexieTable = entryListRow.getParentNode();
        if (null != EntryCollection) {
            for (Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext(); ) {
                String href;
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

