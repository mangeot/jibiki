/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.33  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.32  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.31.2.2  2004/01/24 04:35:02  mangeot
 * Added accesskey for the main lookup form. Beware, it can interfere with the built-in browser accesskeys!
 *
 * Revision 1.31.2.1  2004/01/08 09:43:20  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.31  2003/11/20 05:34:24  mangeot
 * Bug fixes in the parameters
 *
 * Revision 1.30  2003/10/19 14:45:37  mangeot
 * Changed reading into writing for Foks
 *
 * Revision 1.28  2003/10/11 02:59:15  mangeot
 * *** empty log message ***
 *
 * Revision 1.27  2003/10/08 01:51:23  mangeot
 * Added a way to parse tab separated files for FoksEdict dictionary
 * Created an FoksEntry table in the .doml file
 * Do not forget to reload create_tables.sql
 *
 * Revision 1.26  2003/10/04 05:43:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.25  2003/10/04 04:30:41  mangeot
 * Debug Foks module
 *
 * Revision 1.24  2003/10/03 05:34:09  mangeot
 * *** empty log message ***
 *
 * Revision 1.23  2003/10/02 09:53:16  mangeot
 * *** empty log message ***
 *
 * Revision 1.22  2003/10/02 09:36:11  mangeot
 * Modified email addresses to avoid spams from robots
 *
 * Revision 1.21  2003/09/02 13:55:57  mangeot
 * *** empty log message ***
 *
 * Revision 1.20  2003/09/02 12:18:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.19  2003/08/28 14:04:07  mangeot
 * *** empty log message ***
 *
 * Revision 1.18  2003/08/28 13:59:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.17  2003/08/23 16:18:45  mangeot
 * *** empty log message ***
 *
 * Revision 1.16  2003/08/23 16:08:08  mangeot
 * *** empty log message ***
 *
 * Revision 1.15  2003/08/23 07:44:32  mangeot
 * *** empty log message ***
 *
 * Revision 1.14  2003/08/23 03:58:05  mangeot
 * *** empty log message ***
 *
 * Revision 1.13  2003/08/21 04:47:56  mangeot
 * Cleaning the new menu
 *
 * Revision 1.12  2003/08/20 08:15:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.11  2003/08/19 06:52:02  mangeot
 * *** empty log message ***
 *
 * Revision 1.10  2003/08/19 06:21:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2003/08/15 08:56:17  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2003/08/14 10:36:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2003/08/14 08:30:17  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.6.2.20  2003/08/14 04:15:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.19  2003/08/11 10:24:52  mangeot
 * Debugging ...
 *
 * Revision 1.6.2.18  2003/08/09 07:21:06  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.6.2.17  2003/07/31 16:16:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.16  2003/06/30 08:27:18  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.15  2003/06/30 08:01:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.14  2003/06/30 06:26:02  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.13  2003/06/30 05:34:59  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.12  2003/06/30 05:08:11  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.11  2003/06/30 02:58:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.10  2003/06/27 06:36:54  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.9  2003/06/27 06:24:43  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.8  2003/06/27 05:28:42  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.7  2003/06/26 03:37:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.6  2003/06/25 09:54:57  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.5  2003/06/21 17:56:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.4  2003/05/29 03:50:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.3  2003/05/28 09:17:22  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.6.2.2  2003/05/23 13:37:29  mangeot
 * I added getHeadwordText instead of getHeadword
 *
 * Revision 1.6.2.1  2003/02/18 07:19:34  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2003/01/28 08:23:01  mangeot
 * Bug fixed in ConsultExpert.java must be correcting also on Home.java
 * and added xmlSchema to volumes
 *
 * Revision 1.5  2003/01/21 09:19:49  mangeot
 * A Few corrections for the HTML rendering
 *
 * Revision 1.4  2003/01/10 08:11:57  mangeot
 * Problem with labels and UTF-8 fixed for internet explorer and icab
 * Problem with language identification fixed eg: en-US
 *
 * Revision 1.3  2002/11/22 13:46:55  mangeot
 * New bug corrected
 *
 * Revision 1.2  2002/11/22 13:04:10  mangeot
 * Nouvelle version Papillon enhydra 5.0
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/10/25 14:10:34  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.4.2.1  2002/10/23 09:51:12  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.4  2002/09/17 20:29:33  mangeot
 * Bug corrected, version deploy 1_4 ready !
 *
 * Revision 1.3  2002/09/17 17:13:23  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.2  2002/09/16 13:34:23  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.1.2.1  2002/08/08 09:11:58  mangeot
 * New Home page with simplified interface a lot of work
 * + localization in german
 *
 * Revision 1.31.2.2  2002/08/02 13:55:49  mangeot
 * Corrected the encoding problem while connection to the XRCE analyzers
 *
 * Revision 1.31.2.1  2002/08/02 08:12:22  mangeot
 * *** empty log message ***
 *
 * Revision 1.31  2002/07/26 10:00:23  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.30.2.2  2002/07/25 15:33:20  serasset
 * Added a French version of Consult.html template.
 *
 * Revision 1.30.2.1  2002/07/12 13:50:43  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.30  2002/06/10 13:26:03  mangeot
 * Continued the localization, added the lang string into the session data
 *
 * Revision 1.29  2002/06/10 11:07:58  mangeot
 * I began to implement the localization but very rapidly ...
 *
 * Revision 1.28  2002/05/24 16:29:37  mangeot
 * Adding colspan for entries
 *
 * Revision 1.27  2002/05/23 16:14:42  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.26  2002/05/22 12:43:12  mangeot
 * bugs correction ...
 *
 * Revision 1.25  2002/05/22 08:56:19  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.24  2002/05/10 16:43:19  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.23  2002/05/08 13:14:46  mangeot
 * I rewrote some files of the data layer in order to be dependent
 * from the number of tables for the Volum Entries.
 * The next step is to generate tables on the fly with the pgsql jdbc driver
 *
 * Revision 1.22  2002/05/07 10:31:22  mangeot
 * The UTF-8 consultation is now OK,
 * I tested with omniweb, iexplorer and netscape latests versions on macosX
 *
 * Revision 1.21  2002/05/02 07:02:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.20  2002/04/18 11:42:35  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.19  2002/04/17 17:09:24  mangeot
 * Travail sur les stylesheets
 *
 * Revision 1.18  2002/04/16 04:13:16  mangeot
 * *** empty log message ***
 *
 * Revision 1.17  2002/04/14 09:47:12  mangeot
 * lecture des elements CDM ds les fichiers volume-metadata
 * et upload des entrees
 *
 * Revision 1.16  2002/04/01 07:46:34  mangeot
 * Added a table for volumes metadata descriptions
 *
 * Revision 1.15  2002/03/27 09:51:29  mangeot
 * *** empty log message ***
 *
 * Revision 1.14  2002/03/22 08:42:14  mangeot
 * *** empty log message ***
 *
 * Revision 1.13  2002/03/20 09:36:21  mangeot
 * Now the consultation is done in a separate db table for each volume
 * A big pb remaining: the data directory has to be remodified by hands...
 *
 * Revision 1.12  2002/03/19 09:11:41  mangeot
 * *** empty log message ***
 *
 * Revision 1.11  2002/03/11 11:13:55  mangeot
 * *** empty log message ***
 *
 * Revision 1.10  2001/12/18 13:39:41  serasset
 * *** empty log message ***
 *
 * Revision 1.9  2001/09/07 06:59:23  serasset
 * Full rewrite of the administration code to generalize the handling of Information Files.
 *
 * Revision 1.8  2001/08/31 07:45:17  salvati
 * *** empty log message ***
 *
 * Revision 1.7  2001/08/27 13:55:37  salvati
 * Added : in utility: new version of nodeToString.
 * 	in Admin Xml and Xsl: file input type.
 *
 * Revision 1.6  2001/07/31 16:49:17  salvati
 * The xsl List table is better construct..
 *
 * Revision 1.5  2001/07/31 15:22:50  salvati
 * Adding a package for XslTransformation.
 * Adding Transform(xslid,xmlid) and Transform(XmlNode)(default style sheet)
 * Some other raffinement to do...
 *
 * Revision 1.4  2001/07/25 15:35:13  salvati
 * Moving xsl menu to the top of the form.
 * Adding Interface to upload file in Informatins.po.
 *
 * Revision 1.3  2001/07/25 12:48:38  salvati
 * Adding StyleSheet choice in the standard consultation view with a menu on the right.
 *
 * Revision 1.2  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.1  2001/07/18 12:35:32  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.HTMLElement;

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
import org.w3c.dom.html.*;
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

import fr.imag.clips.papillon.presentation.html.orig.*;

public class ConsultExpert extends BasePO {

    protected final static String TEXTE="texte";
    protected final static String XML="xml";

    protected final static String HANDLE="handle";
    protected final static String XSLID="xslid";

    //protected final static String RESOURCES_PARAMETER="RESOURCES";
    protected final static String VOLUME_PARAMETER="VOLUME";
    protected final static String VocContains_PARAMETER="VocContains";
    protected final static String PosContains_PARAMETER="PosContains";
    protected final static String TransContains_PARAMETER="TransContains";
    protected final static String PronContains_PARAMETER="PronContains";
    protected final static String ReadingContains_PARAMETER="ReadingContains";
    protected final static String AnyContains_PARAMETER="AnyContains";
	
    protected final static String SOURCE_PARAMETER="AnyContains";
    protected final static String TARGETS_PARAMETER="AnyContains";

    protected final static String ContributionsURL = "AdminContributions.po";
    protected final static String ContributionsVolumeParameter = "VOLUME";


    protected final static String ANY_RESOURCE="*ANY*";
    protected final static String ANY_TARGET="*ANY*";

    protected String languagesScript = "";

    protected int XslSheetsNumber = 1;

    protected Languages Languages;
    protected AvailableLanguages MyAvailableLanguages;

    protected String[] allSourceLanguages;
    protected String[] allTargetLanguages;
    protected String[] allResources;

    protected String sourceLanguage;
    protected String[] targetLanguages;
    protected String[] originalTargets;
    protected String[] resources;
    protected String[] originalResources;
    protected String login = null;
    protected String search1;
    protected String search1text;
    protected String search2;
    protected String search2text;
    protected String strategyString;
    protected int strategy=IQuery.STRATEGY_NONE;


    protected ConsultExpertHTML content;

    protected boolean loggedInUserRequired() {
        return false;
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
        PapillonBusinessException,
        UnsupportedEncodingException
    {

        // Content creation
        content = (ConsultExpertHTML)MultilingualHtmlTemplateFactory.createTemplate("ConsultExpertHTML", this.getComms(), this.getSessionData());

        // On regarde d'abord les parametres qui nous sont demandes.
        String submit = myGetParameter(content.NAME_lookup);
        sourceLanguage = myGetParameter(content.NAME_SOURCE);
		if (sourceLanguage!=null &&!sourceLanguage.equals("")) {
			this.setPreference(content.NAME_SOURCE,sourceLanguage);
		}
		else {
			sourceLanguage = this.getPreference(content.NAME_SOURCE);
		}
        targetLanguages = myGetParameterValues(content.NAME_TARGETS);
	originalTargets=targetLanguages;
        resources = myGetParameterValues(content.NAME_RESOURCES);
	originalResources=resources;
        String volume = myGetParameter(VOLUME_PARAMETER);		
		if (volume!=null &&!volume.equals("")) {
			this.setPreference(VOLUME_PARAMETER,volume);
		}
		else {
			volume = this.getPreference(VOLUME_PARAMETER);
		}


        search1 = myGetParameter(content.NAME_search1);
 		if (search1!=null &&!search1.equals("")) {
			this.setPreference(content.NAME_search1,search1);
		}
		else {
			search1 = this.getPreference(content.NAME_search1);
		}

       search1text = myGetParameter(content.NAME_search1text);
        search2 = myGetParameter(content.NAME_search2);
 		if (search2!=null &&!search2.equals("")) {
			this.setPreference(content.NAME_search2,search2);
		}
		else {
			search2 = this.getPreference(content.NAME_search2);
		}

        search2text = myGetParameter(content.NAME_search2text);

        String vocContains = myGetParameter(VocContains_PARAMETER);
        String posContains = null;
        String pronContains = null;
        String readingContains = null;
        String transContains = null;
        String anyContains = null;

		

        if (null != search1 && null != search1text && !search1text.equals("")) {
            if (search1.equals(VocContains_PARAMETER)) {
                vocContains = search1text;
            }
            if (search1.equals(PosContains_PARAMETER)) {
                posContains = search1text;
            }
            if (search1.equals(PronContains_PARAMETER)) {
                pronContains = search1text;
            }
            if (search1.equals(ReadingContains_PARAMETER)) {
                readingContains = search1text;
            }
            if (search1.equals(AnyContains_PARAMETER)) {
                anyContains = search1text;
            }
            if (search1.equals(TransContains_PARAMETER)) {
                transContains = search1text;
            }
        }

        if (null != search2 && null != search2text && !search2text.equals("")) {
            if (search2.equals(VocContains_PARAMETER)) {
                vocContains = search2text;
            }
            if (search2.equals(PosContains_PARAMETER)) {
                posContains = search2text;
            }
            if (search2.equals(PronContains_PARAMETER)) {
                pronContains = search2text;
            }
            if (search2.equals(ReadingContains_PARAMETER)) {
                readingContains = search2text;
            }
            if (search2.equals(AnyContains_PARAMETER)) {
                anyContains = search2text;
            }
            if (search2.equals(TransContains_PARAMETER)) {
                transContains = search2text;
            }
        }
        strategyString = myGetParameter(content.NAME_Strategy);
 		if (strategyString!=null &&!strategyString.equals("")) {
			this.setPreference(content.NAME_Strategy,strategyString);
		}
		else {
			strategyString = this.getPreference(content.NAME_Strategy);
		}
		
        strategy=IQuery.STRATEGY_NONE;
        if (null != strategyString && !strategyString.equals("")) {
            strategy=Integer.parseInt(strategyString);
        }
       
        String handle = myGetParameter(HANDLE);
        String xslid = myGetParameter(XSLID);

        if (handle != null && !handle.equals("")) {
   		submit = "lookup";          
        }

        // Consultation of several headwords at one time
        String[] Headwords = new String[1];
        Headwords[0] = vocContains;

        // FIXME: Just get the first language for the moment. Architecture of this part should be revised.
        MyAvailableLanguages = new AvailableLanguages();

        allSourceLanguages=MyAvailableLanguages.getSourceLanguagesArray();
        allTargetLanguages=MyAvailableLanguages.getTargetLanguagesArray();
        allResources=DictionariesFactory.getDictionariesNamesArray();

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
			if (strategy==IQuery.STRATEGY_LEMMATIZE) {
				Wrapper myWrapper = WrappersFactory.createXRCEAnalyzerWrapper(sourceLanguage);
				String result = myWrapper.getResultString(Headwords);
				String[] Results = WrappersFactory.getXRCEAnalyzerAnswers(result);
				if (Results !=null && Results.length>0){
					Headwords = Results;
				}
				strategy = IQuery.STRATEGY_EXACT;
			}
			// Using FOKS module Testing phase ...
			if (strategy==IQuery.STRATEGY_FOKS && sourceLanguage.equals("jpn")) {
				Vector foksVector = VolumeEntriesFactory.getFoksEntriesVector(vocContains);

				if (foksVector != null && foksVector.size()>0) {
					addFoksEntryTable(foksVector);
					strategy = IQuery.STRATEGY_EXACT;
					Utility.removeElement(content.getElementSorryMessage());
				}
				else {
					Utility.removeElement(content.getElementFoksEntries());
				}
                                Utility.removeElement(content.getElementEntryListTable());
                                Utility.removeElement(content.getElementVolumeEntries());
			}
			else {
            // If there is a query, executing it
            addEntries(resources, volume, sourceLanguage, targetLanguages, Headwords, strategy, posContains, pronContains, readingContains, transContains, anyContains, handle, xslid, this.getUser());
				Utility.removeElement(content.getElementFoksEntries());
			}
            }
        else {
            // If there is no query, ie connection for the first time, adding the Home content
			Utility.removeElement(content.getElementEntryListTable());
			Utility.removeElement(content.getElementVolumeEntries());
			Utility.removeElement(content.getElementFoksEntries());
			Utility.removeElement(content.getElementSorryMessage());
        }

        return content.getElementConsultContent();
    }

    protected void addConsultForm()
        throws PapillonBusinessException,
        HttpPresentationException,
        UnsupportedEncodingException {
        
            // Adding the appropriate source languages to the source list
            HTMLOptionElement sourceOptionTemplate = content.getElementSourceOptionTemplate();
            Node sourceSelect = sourceOptionTemplate.getParentNode();
            sourceOptionTemplate.removeAttribute("id");
            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            Text sourceTextTemplate = (Text)sourceOptionTemplate.getFirstChild();
            String langLoc = getUserPreferredLanguage();
            if (null == sourceLanguage || sourceLanguage.equals("")) {
                sourceLanguage = langLoc;
            }
            for (int i = 0; i < allSourceLanguages.length; i++) {
                String langi = allSourceLanguages[i];
                sourceOptionTemplate.setValue(langi);
                if (this.IsClientWithLabelDisplayProblems()) {
                    sourceOptionTemplate.setLabel(Languages.localizeLabel(langLoc,langi));
                }
                else {
                    sourceOptionTemplate.setLabel(Languages.localizeName(langLoc,langi));
                }
                sourceOptionTemplate.setSelected(langi.equals(sourceLanguage));

                // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
                // specs W3C.
                sourceTextTemplate.setData(Languages.localizeName(langLoc, langi));
                sourceSelect.appendChild(sourceOptionTemplate.cloneNode(true));
            }
            sourceSelect.removeChild(sourceOptionTemplate);

            // Strategy select
            HTMLSelectElement strategySelect = content.getElementStrategy();
            strategySelect.setSelectedIndex(strategy);


            // Adding the appropriate target languages to the target list
            if (originalTargets== null || originalTargets.length==0) {
                originalTargets=new String[] {ANY_TARGET};
            }
            HTMLOptionElement targetOptionTemplate = content.getElementTargetOptionTemplate();
            HTMLSelectElement targetSelect = (HTMLSelectElement) targetOptionTemplate.getParentNode();
						if (!this.IsClientWithLabelDisplayProblems()) {
							this.setUnicodeLabels(targetSelect);
						}
            targetOptionTemplate.removeAttribute("id");
            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            Text targetTextTemplate = (Text)targetOptionTemplate.getFirstChild();

            for (int i = 0; i < allTargetLanguages.length; i++) {
                String langi = allTargetLanguages[i];
                targetOptionTemplate.setValue(langi);
                if (this.IsClientWithLabelDisplayProblems()) {
                    targetOptionTemplate.setLabel(Languages.localizeLabel(langLoc,langi));
                }
                else {
                    targetOptionTemplate.setLabel(Languages.localizeName(langLoc,langi));
                }
              // We should select the previously selected target languages...
                targetTextTemplate.setData(Languages.localizeName(langLoc,langi));
                targetSelect.appendChild(targetOptionTemplate.cloneNode(true));
            }
            targetSelect.removeChild(targetOptionTemplate);
            this.setSelected(content.getElementTargets(),originalTargets);

            // Adding the appropriate resources languages to the resources list
            if (originalResources== null || originalResources.length==0) {
                originalResources=new String[] {ANY_RESOURCE};
            }
            HTMLOptionElement resourceOptionTemplate = content.getElementResourceOptionTemplate();
            HTMLSelectElement resourceSelect = (HTMLSelectElement) resourceOptionTemplate.getParentNode();
						if (!this.IsClientWithLabelDisplayProblems()) {
							this.setUnicodeLabels(resourceSelect);
						}
            resourceOptionTemplate.removeAttribute("id");
            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            Text resourceTextTemplate = (Text)resourceOptionTemplate.getFirstChild();
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
            this.setSelected(content.getElementResources(),originalResources);

						// strategy
						if (!this.IsClientWithLabelDisplayProblems()) {
							this.setUnicodeLabels(content.getElementStrategy());
						}
						
						
            // Search1 field
            if (search1==null || search1.equals("")) {
                search1=VocContains_PARAMETER;
            }
						if (!this.IsClientWithLabelDisplayProblems()) {
							this.setUnicodeLabels(content.getElementSearch1());
						}
            this.setSelected(content.getElementSearch1(),search1);

            HTMLInputElement search1Input = content.getElementSearch1text();
            search1Input.setValue(search1text);

            // Search2 field
            if (search2==null || search2.equals("")) {
                search2=PosContains_PARAMETER;
            }
						if (!this.IsClientWithLabelDisplayProblems()) {
							this.setUnicodeLabels(content.getElementSearch2());
						}
            this.setSelected(content.getElementSearch2(),search2);

            HTMLInputElement search2Input = content.getElementSearch2text();
            search2Input.setValue(search2text);
        }

    protected void addEntries(String[] resources, String volume, String source, String[] targets,  String[] Headwords, int strategy,String posContains, String pronContains, String readingContains, String transContains, String anyContains, String handle, String xslid, User myUser)
        throws PapillonBusinessException,
        ClassNotFoundException,
        HttpPresentationException,
        IOException,
        TransformerConfigurationException,
        org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException,
        javax.xml.transform.TransformerException {

            Collection EntryCollection = null;

			if (null != handle && null != volume) {
				EntryCollection = DictionariesFactory.findAnswerAndTranslations(volume, handle, targets, myUser);
			}
            else if (null != volume) {
                EntryCollection = VolumeEntriesFactory.getVolumeNameEntriesHashtable(volume, null, Headwords, strategy).values();
            }
            else {
                EntryCollection = DictionariesFactory.getDictionariesEntriesCollection(resources, source, targets, Headwords, strategy, posContains, pronContains, readingContains, transContains, anyContains, myUser);
            }
            // If there are too much entries ie > DictionariesFactory.MaxDisplayedEntries,
            // we display a table of entries instead of the entries
            if (null != EntryCollection && EntryCollection.size() > 0) {
                if (EntryCollection.size() > DictionariesFactory.MaxDisplayedEntries) {
									Utility.removeElement(content.getElementVolumeEntries());
									addEntryTable(EntryCollection, targets);
                }
                else {
									Utility.removeElement(content.getElementEntryListTable());
									addFewEntries(EntryCollection,xslid);
                    // If the entry is remote, it is already an HTML node
                }
				Utility.removeElement(content.getElementSorryMessage());
            }
			else {
				Utility.removeElement(content.getElementVolumeEntries());
				Utility.removeElement(content.getElementEntryListTable());
			}			
        }

		protected void addEntryTable (Collection EntryCollection, String[] targets)
			throws PapillonBusinessException,
			java.io.UnsupportedEncodingException {

				PapillonLogger.writeDebugMsg("addEntryTable, size: " + EntryCollection.size());
				// On récupère les éléments du layout
				HTMLTableRowElement entryListRow = content.getElementEntryListRow();
				HTMLElement vocable = content.getElementVocable();
				HTMLAnchorElement entryAnchor = content.getElementEntryAnchor();
				HTMLElement entryId = content.getElementEntryIdList();
				HTMLAnchorElement contribAnchor = content.getElementContribAnchor();
				HTMLElement pos = content.getElementPosEntry();
				HTMLElement dictname = content.getElementDictionaryName();


				// Recuperating the elements for the formula
				HTMLTableRowElement formulaRow = content.getElementFormulaRow();
				HTMLElement formulaElement = content.getElementFormula();


				//      we don't take off the id attribute because we will take the element off later...
		//      entryListRow.removeAttribute("id");
				vocable.removeAttribute("id");
				entryAnchor.removeAttribute("id");
				entryId.removeAttribute("id");
				contribAnchor.removeAttribute("id");
				pos.removeAttribute("id");
				dictname.removeAttribute("id");
				formulaElement.removeAttribute("id");

				// On récupère le noeud contenant la table...
				Node lexieTable = entryListRow.getParentNode();
				if (null != EntryCollection) {
					for(Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext();) {
						String href;
						IAnswer myEntry = (IAnswer)myIterator.next();

						// Le vocable
			//            String vocable = theDicArray[i].getKey1();
						content.setTextVocable(myEntry.getHeadwords());

						// l'entry
						href = this.getUrl() + "?"
							+ VOLUME_PARAMETER + "="
							+ myEntry.getVolumeName() + "&"
							+ HANDLE + "="
							+ myEntry.getHandle() + "&"
							+ SOURCE_PARAMETER + "=" + myEntry.getSourceLanguage() + "&"
							+ Utility.serializeParameterForUrl(TARGETS_PARAMETER, targets)
                                                        + content.NAME_Strategy + "="
                                                        + strategyString +  "&"
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
						}
						else {
							content.setTextContribution("");
						}

						// Le pos
						String posstr = null;
						if (myEntry.getType() == IAnswer.LocalEntry) {
							posstr = ((VolumeEntry)myEntry).getPoss();
						}
						if (null == posstr || posstr.equals("")) {
							posstr = "+";
						}
						content.setTextPosEntry(posstr);

						// dictname
						content.setTextDictionaryName(myEntry.getDictionaryName());
						
							// The formula
						content.setTextFormula(IAnswerFactory.getDefinitionString(myEntry));

						HTMLElement cloneEntry = (HTMLElement)entryListRow.cloneNode(true);
						HTMLElement cloneFormula = (HTMLElement)formulaRow.cloneNode(true);
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

		   protected void addFoksEntryTable (Vector EntryVector)
        throws PapillonBusinessException,
        java.io.UnsupportedEncodingException {

            // On récupère les éléments du layout
            HTMLTableRowElement entryListRow = content.getElementFoksRow();
            HTMLElement foksEntry = content.getElementFoksEntry();
            HTMLElement foksWriting = content.getElementFoksWriting();
            HTMLElement foksGrade = content.getElementFoksGrade();
            HTMLAnchorElement foksHref = content.getElementFoksHref();

            //      we don't take off the id attribute because we will take the element off later...
            //      entryListRow.removeAttribute("id");
            foksEntry.removeAttribute("id");
            foksWriting.removeAttribute("id");
            foksGrade.removeAttribute("id");
            foksHref.removeAttribute("id");

            // On récupère le noeud contenant la table...
            Node lexieTable = entryListRow.getParentNode();
            if (null != EntryVector) {
                for(int i = 0; i < EntryVector.size(); i++) {
                    String href;
                    FoksEntry myEntry = (FoksEntry)EntryVector.get(i);
                    String headword = myEntry.getHeadword();
                    content.setTextFoksEntry(headword);
                    String myWriting = "";
                    VolumeEntry myWritingEntry = VolumeEntriesFactory.getJMDictVolumeEntry(headword);
                    if (myWritingEntry != null && !myWritingEntry.IsEmpty()) {
                    //NOTE: I store the writing of the Japanese entries in the Key1 field.
                    // The reading field is used for transcriptions like romaji
                        String writing = myWritingEntry.getKey1();
                        if (writing != null) {
                            myWriting = writing;
                        }
                    }
                    content.setTextFoksWriting(myWriting);
					// Le grade
          content.setTextFoksGrade(myEntry.getScoreString());
					
                    href = this.getUrl() + "?"
                        + content.NAME_SOURCE + "="
                        + sourceLanguage + "&"
			+ Utility.serializeParameterForUrl(content.NAME_TARGETS, originalTargets)
			+ Utility.serializeParameterForUrl(content.NAME_RESOURCES, originalResources)
			+ content.NAME_search1 + "=" + VocContains_PARAMETER + "&"
                        + content.NAME_search1text + "="
			+ Utility.convertToUrlForEncoding(headword,"UTF-8") + "&"
                        + content.NAME_Strategy + "="
                        + IQuery.STRATEGY_EXACT +  "&"
                        + content.NAME_lookup + "="
                        + "lookup";
                    foksHref.setHref(href);
                    HTMLElement clone = (HTMLElement)entryListRow.cloneNode(true);
                    //      we have to take off the id attribute because we did not take it off the original
                    clone.removeAttribute("id");
                    lexieTable.appendChild(clone);
                }
            }
			lexieTable.removeChild(entryListRow);
        }

    protected Node getXslTable (String volume, String handle, int type)
        throws HttpPresentationException,
        PapillonBusinessException {

            HTMLElement stylesheetRow = null;

            try {

                Vector xslList= new Vector();

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
                HTMLTableRowElement originalStylesheetRow = content.getElementStylesheetRow();

                stylesheetRow = (HTMLElement)originalStylesheetRow.cloneNode(true);
                // The cell element is added in proder to be parsed by enhydra
                // but here we remove it
                HTMLElement stylesheetCell= (HTMLElement)stylesheetRow.getFirstChild();

                stylesheetRow.removeAttribute("id");
                stylesheetRow.removeChild(stylesheetCell);

                Document theDoc=stylesheetRow.getOwnerDocument();

				// default XSL = null !
				Element cell=theDoc.createElement("TD");
				Element anchor =theDoc.createElement("A");
				Text xslName=theDoc.createTextNode("Default");
				anchor.setAttribute("href", this.getUrl() + "?" +
						VOLUME_PARAMETER + "=" + volume + "&" +
						HANDLE + "=" + handle + "&" +
						content.NAME_lookup + "=" + "lookup");
				anchor.appendChild(xslName);
				cell.appendChild(anchor);
				stylesheetRow.appendChild(cell);

				//adding xslchoice
                for(int i = 0; i < xslList.size(); i++) {
                    // Le nom de la stylesheet
                    String name = ((XslSheet) xslList.elementAt(i)).getName();
                    //creation de la data cell
                    cell=theDoc.createElement("TD");
                    anchor =theDoc.createElement("A");
                    xslName=theDoc.createTextNode(name);
                    anchor.setAttribute("href", this.getUrl() + "?" +
                     VOLUME_PARAMETER + "=" + volume + "&" + 
                     HANDLE + "=" + handle + "&" + 
                     XSLID +"="+((XslSheet) xslList.elementAt(i)).getHandle() + "&" + 
                     content.NAME_lookup + "=" + "lookup");
                    anchor.appendChild(xslName);
                    cell.appendChild(anchor);
		    stylesheetRow.appendChild(cell);
                }
            }
            catch(Exception ex) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in getXslTable()", ex);
            }
            return stylesheetRow;
        }

    protected void addElement (Element element, String table, String handle, String resource, int type)
        throws  PapillonBusinessException {
			try {
            //for the entry content
					HTMLTableRowElement originalEntryRow = content.getElementEntryRow();
            Node entryTable=originalEntryRow.getParentNode();
            //for the entry content

            content.setTextResourceName(resource);

            //for the lexie content
            HTMLTableCellElement entryCell= (HTMLTableCellElement)originalEntryRow.getFirstChild();

            if (null != table && null != handle) {
                // If we want to put the XSL menu ...
                entryTable.appendChild(getXslTable(table, handle, type));
							entryCell.setColSpan(XslSheetsNumber);
            }
            HTMLElement entryDiv= (HTMLElement)content.getElementEntryDiv();
            entryDiv.removeAttribute("id");

            if (entryDiv.getChildNodes().getLength()>0) {
                entryDiv.removeChild(entryDiv.getFirstChild());
            }            
            
            entryDiv.appendChild(content.importNode(element, true));

            HTMLTableRowElement entryRow = (HTMLTableRowElement)originalEntryRow.cloneNode(true);
            entryRow.removeAttribute("id");

            entryTable.appendChild(entryRow);
            // Don't remove the original node in order to add more entries ...
            //entryTable.removeChild(entryRow);
			}
			catch (Exception ex) {
				throw new PapillonBusinessException("Exception in addEntries: ", ex);
			}
        }

	protected void addFewEntries(Collection EntryCollection, String xslid)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
		if (EntryCollection != null && EntryCollection.size()>0) {
      for(Iterator myIterator = EntryCollection.iterator(); myIterator.hasNext();) {
			IAnswer myEntry = (IAnswer)myIterator.next();
			addElement(XslTransformation.applyXslSheets(myEntry, xslid),myEntry.getVolumeName(), myEntry.getHandle(), myEntry.getDictionaryName(), myEntry.getType());
		}
		}
			else {
				Utility.removeElement(content.getElementEntryListTable());
			}
			// removing
		Utility.removeElement(content.getElementStylesheetRow());
		Utility.removeElement(content.getElementEntryRow());
	}	
	
    protected String buildLanguagesScript()
        throws fr.imag.clips.papillon.business.PapillonBusinessException{

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
            for (int i=0;i<AllLanguages.length;i++) {
                String myLang = AllLanguages[i];
                String varLang = "  var " + myLang + " = new Option(\"" +
                    Languages.localizeName(langLoc,myLang) + "\", \"" + myLang + "\");";
                script = script + "\n" + varLang;
            }

            script =  script + "\n\n";

            // Writing one if instruction for each source language
            for (int i=0;i<allSourceLanguages.length;i++) {
                String mySource = allSourceLanguages[i];
                String ifScript = "  if (object.SOURCE.options[object.SOURCE.selectedIndex].value == \"" + mySource + "\") {";
                String[] myTargets = MyAvailableLanguages.getTargetLanguagesArray(mySource);
                for (int j=0;j<myTargets.length;j++) {
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

