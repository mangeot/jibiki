/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.1  2004/12/06 16:38:42  serasset
 *  Initial revision
 *
 *  Revision 1.6  2004/10/28 10:56:21  mangeot
 *  Added the list of connected users on AdminUsers.java,
 *  Added the possibility to sort in columns for some pages
 *  Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 *  Revision 1.5  2004/02/10 05:27:14  mangeot
 *  The version UIGEN_V2 has been merged with the trunk by MM
 *  Be careful because the Volumes and contributions database tables have been modified.
 *  You have to drop and rebuild them unless you modify them by hands.
 *
 *  Revision 1.4.2.4  2004/02/08 04:29:19  mangeot
 *  asdded deleteAll in Dictionary.java
 *
 *  Revision 1.4.2.3  2004/02/08 03:46:25  mangeot
 *  bug fixes, cleaning code
 *
 *  Revision 1.4.2.2  2004/02/02 07:53:53  mangeot
 *  Bug fixes in encoding and UserInterface
 *
 *  Revision 1.4.2.1  2004/01/20 09:08:00  mangeot
 *  Lots of changes for version 2 of UIGenerator: interface description files are loaded
 *  into the database.
 *
 *  Revision 1.4  2003/10/19 13:25:20  mangeot
 *  Do not display null user messages any more
 *
 *  Revision 1.3  2003/08/14 08:30:16  mangeot
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
 *  Revision 1.2.2.3  2003/07/31 10:51:30  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.2.2.2  2003/06/21 17:56:38  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.2.2.1  2003/05/28 09:17:20  mangeot
 *  Changement du copyright sur les fichiers
 *
 *  Revision 1.2  2003/02/13 09:43:04  mangeot
 *  Space added for display message
 *
 *  Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 *  Creation of the papillon CVS repository for enhydra 5.0
 *
 *  Revision 1.16  2002/10/25 14:10:34  mangeot
 *  merge between PAPILLON_1_4 and trunk
 *  CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 *  Revision 1.15.2.1  2002/10/01 05:49:17  mangeot
 *  Corrected a few bugs for AdminInformations.java
 *
 *  Revision 1.15  2002/09/16 13:34:22  mangeot
 *  Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 *  Revision 1.14.2.1  2002/08/02 08:25:09  mangeot
 *  Replaced PAGENAME variable by this.getUrl() method
 *
 *  Revision 1.14  2002/07/26 10:00:21  serasset
 *  Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 *  Revision 1.13.2.1  2002/07/12 13:50:41  serasset
 *  A new architecture for HTML template localization has been integrated.
 *
 *  Revision 1.13  2002/06/08 06:00:01  mangeot
 *  VolumeHandler modified to take into account the thai dictionary,
 *  headword and pos into attribute values
 *
 *  Revision 1.12  2002/05/23 16:14:41  mangeot
 *  Adding admin group for presentation pages
 *
 *  Revision 1.11  2002/05/22 08:56:18  mangeot
 *  MML added user login and register:
 *  LoginUser.po RegisterUser.po AdminUsers.po
 *
 *  Revision 1.10  2002/05/10 16:43:19  mangeot
 *  Integration of HTML code from remote dictionary servers on the Web
 *  iUse of HTMLTidy, conversion problem remaining ...
 *
 *  Revision 1.9  2002/05/09 08:20:04  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.8  2002/04/18 11:42:35  mangeot
 *  Fait l'affichage des donnees XML metadata + stylesheets
 *  Ameliore les stylesheets
 *  corrige le bug du parsage du FeM
 *
 *  Revision 1.7  2002/04/17 20:44:01  mangeot
 *  Now I load a XSL stylesheet from an URI instead of a file.
 *  I load automatically XSL sheets included in dicts and vols metadata files
 *
 *  Revision 1.6  2002/04/16 10:17:24  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.5  2002/04/16 04:57:23  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.4  2002/04/16 02:44:03  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.3  2002/04/14 09:47:12  mangeot
 *  lecture des elements CDM ds les fichiers volume-metadata
 *  et upload des entrees
 *
 *  Revision 1.2  2002/04/01 07:46:33  mangeot
 *  Added a table for volumes metadata descriptions
 *
 *  Revision 1.1  2002/03/11 11:13:55  mangeot
 *  *** empty log message ***
 *
 *  -----------------------------------------------
 *  Papillon Admin page.
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

//import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;

import java.net.URL;

//pour les dictionary
import fr.imag.clips.papillon.business.dictionary.*;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.html.orig.*;

/**
 *  Description of the Class
 *
 * @author     serasset
 * @created    December 2, 2004
 */
public class AdminDictionaries extends BasePO {

    /**
     *  Description of the Field
     */
    protected final static String SEE_PARAMETER = "See";
    /**
     *  Description of the Field
     */
    protected final static String REMOVE_PARAMETER = "Remove";
    /**
     *  Description of the Field
     */
    protected final static String REMOVE_ALL_PARAMETER = "RemoveAll";

    /**
     *  Description of the Field
     */
    protected static AdminDictionariesHTML content;


    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return true;
    }


    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    protected boolean adminUserRequired() {
        return true;
    }


    /**
     *  Gets the currentSection attribute of the AdminDictionaries object
     *
     * @return    The currentSection value
     */
    protected int getCurrentSection() {
        return NO_SECTION;
    }


    /**
     *  Gets the content attribute of the AdminDictionaries object
     *
     * @return                                                     The content
     *      value
     * @exception  javax.xml.parsers.ParserConfigurationException  Description
     *      of the Exception
     * @exception  HttpPresentationException                       Description
     *      of the Exception
     * @exception  IOException                                     Description
     *      of the Exception
     * @exception  org.xml.sax.SAXException                        Description
     *      of the Exception
     * @exception  javax.xml.transform.TransformerException        Description
     *      of the Exception
     */
    public Node getContent()
             throws javax.xml.parsers.ParserConfigurationException, HttpPresentationException,
            IOException, org.xml.sax.SAXException, javax.xml.transform.TransformerException {

        // Création du contenu
        content = (AdminDictionariesHTML) MultilingualHtmlTemplateFactory.createTemplate("AdminDictionariesHTML", this.getComms(), this.getSessionData());

        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            //TEMPORAIRE :avec l URL
            //AJOUT DE DICO
            String userMessage = "";
            String urlString = req.getParameter(content.NAME_url);
            if (null != urlString && !urlString.equals("")) {
                URL myURL = new URL(urlString);
                PapillonLogger.writeDebugMsg(myURL.toString());

                Dictionary myDict = DictionariesFactory.parseDictionaryMetadata(myURL,
                        req.getParameter(content.NAME_AddVolumes),
                        req.getParameter(content.NAME_AddVolumesAndEntries));

                if (null != myDict && !myDict.IsEmpty()) {
                    userMessage = "adding " + myDict.getName() + " dictionary" + " // " + myDict.getCategory() + " // " + myDict.getType() + " // " + myDict.getDomain() + " // " + myDict.getLegal() + " // " + myDict.getSourceLanguages() + " // " + myDict.getTargetLanguages();
                    myDict.save();
                } else {
                    userMessage = "Ignoring dictionary";
                }
            } else if (null != req.getParameter(SEE_PARAMETER)) {
                String handle = req.getParameter(SEE_PARAMETER);
                Dictionary dict = DictionariesFactory.findDictionaryByID(handle);
                //adding an XML file
                addXml(dict.getXmlCode());

            } else if (null != req.getParameter(REMOVE_PARAMETER)) {
                String handle = req.getParameter(REMOVE_PARAMETER);
                Dictionary dict = DictionariesFactory.findDictionaryByID(handle);
                dict.delete();
                userMessage = "Dictionary " + dict.getName() + " metadata  erased...";
            } else if (null != req.getParameter(REMOVE_ALL_PARAMETER)) {
                String handle = req.getParameter(REMOVE_ALL_PARAMETER);
                Dictionary dict = DictionariesFactory.findDictionaryByID(handle);
                // here we should use a truncate sql statement with volume.getDbname();
                dict.deleteAll();
                userMessage = "Dictionary " + dict.getName() + " metadata and volumes erased...";
            }
            if (userMessage != null) {
                this.getSessionData().writeUserMessage(userMessage);
                PapillonLogger.writeDebugMsg(userMessage);
            }
        }

        //adding the content of the dictionaries table
        addDictionariesArray();

        //On rend le contenu correct
        return content.getElementFormulaire();
    }


    /**
     *  Adds a feature to the Xml attribute of the AdminDictionaries object
     *
     * @param  xmlString
     *      The feature to be added to the Xml attribute
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    protected void addXml(String xmlString)
             throws fr.imag.clips.papillon.business.PapillonBusinessException {

        Node xmlNode = XslTransformation.applyXslSheetForXml(xmlString);

        //where we must insert the xml
        HTMLElement theXml = content.getElementXml();

        Node theXmlParent = theXml.getParentNode();

        theXmlParent.appendChild(content.importNode(xmlNode, true));
        theXmlParent.removeChild(theXml);
    }



    /**
     *  Adds a feature to the DictionariesArray attribute of the
     *  AdminDictionaries object
     *
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    protected void addDictionariesArray()
             throws fr.imag.clips.papillon.business.PapillonBusinessException {

        Dictionary[] DictsTable = DictionariesFactory.getDictionariesArray();
        //where we must insert the form
        HTMLTableRowElement theRow = content.getElementTemplateRow();
        HTMLElement theName = content.getElementName();
        HTMLElement theCategory = content.getElementCategory();
        HTMLElement theType = content.getElementType();
        HTMLElement theSources = content.getElementSources();
        HTMLElement theTargets = content.getElementTargets();
        HTMLElement theDomain = content.getElementDomain();
        HTMLElement theLegal = content.getElementLegal();
        HTMLAnchorElement theSeeAnchor = content.getElementSeeAnchor();
        HTMLAnchorElement theRemoveAnchor = content.getElementRemoveAnchor();
        HTMLAnchorElement theRemoveAllAnchor = content.getElementRemoveAllAnchor();

        Node theRowParent = theRow.getParentNode();

        theRow.removeAttribute("id");
        theName.removeAttribute("id");
        theCategory.removeAttribute("id");
        theType.removeAttribute("id");
        theSources.removeAttribute("id");
        theTargets.removeAttribute("id");
        theDomain.removeAttribute("id");
        theLegal.removeAttribute("id");
        theSeeAnchor.removeAttribute("id");
        theRemoveAnchor.removeAttribute("id");
        theRemoveAllAnchor.removeAttribute("id");

        //adding the volumes description
        for (int i = 0; i < DictsTable.length; i++) {
            content.setTextName(DictsTable[i].getName());
            content.setTextCategory(DictsTable[i].getCategory());
            content.setTextType(DictsTable[i].getType());
            content.setTextSources(DictsTable[i].getSourceLanguages());
            content.setTextTargets(DictsTable[i].getTargetLanguages());
            content.setTextDomain(DictsTable[i].getDomain());
            content.setTextLegal(DictsTable[i].getLegal());

            theSeeAnchor.setHref(this.getUrl() + "?" + SEE_PARAMETER + "=" + DictsTable[i].getHandle());
            theRemoveAnchor.setHref(this.getUrl() + "?" + REMOVE_PARAMETER + "=" + DictsTable[i].getHandle());
            theRemoveAllAnchor.setHref(this.getUrl() + "?" + REMOVE_ALL_PARAMETER + "=" + DictsTable[i].getHandle());

            theRowParent.appendChild(theRow.cloneNode(true));
        }

        theRowParent.removeChild(theRow);
    }

}
