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
 *  Revision 1.8  2004/02/10 05:27:16  mangeot
 *  The version UIGEN_V2 has been merged with the trunk by MM
 *  Be careful because the Volumes and contributions database tables have been modified.
 *  You have to drop and rebuild them unless you modify them by hands.
 *
 *  Revision 1.7.2.1  2004/02/08 03:46:25  mangeot
 *  bug fixes, cleaning code
 *
 *  Revision 1.7  2003/08/24 01:52:23  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.6  2003/08/14 08:30:18  mangeot
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
 *  Revision 1.5  2003/07/25 15:04:20  serasset
 *  ViewDictionaries does not require a logged in user anymore.
 *
 *  Revision 1.4.2.3  2003/07/01 07:14:54  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.4.2.2  2003/06/21 17:56:40  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.4.2.1  2003/05/28 09:17:24  mangeot
 *  Changement du copyright sur les fichiers
 *
 *  Revision 1.4  2003/02/13 04:00:53  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.3  2003/02/12 15:13:47  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.2  2003/02/12 15:01:20  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 *  Creation of the papillon CVS repository for enhydra 5.0
 *
 *  Revision 1.2  2002/09/16 13:34:24  mangeot
 *  Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 *  Revision 1.1.2.1  2002/08/08 09:14:00  mangeot
 *  Added files
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
public class ViewDictionaries extends BasePO {

    /**
     *  Description of the Field
     */
    protected final static String SEE_VOLUME_PARAMETER = "SeeVolume";
    /**
     *  Description of the Field
     */
    protected final static String SEE_DICTIONARY_PARAMETER = "SeeDictionary";

    /**
     *  Description of the Field
     */
    protected static ViewDictionariesHTML content;


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
     *  Gets the currentSection attribute of the ViewDictionaries object
     *
     * @return    The currentSection value
     */
    protected int getCurrentSection() {
        return NO_SECTION;
    }


    /**
     *  Gets the content attribute of the ViewDictionaries object
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
        content = (ViewDictionariesHTML) MultilingualHtmlTemplateFactory.createTemplate("ViewDictionariesHTML", this.getComms(), this.getSessionData());

        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            if (null != req.getParameter(SEE_DICTIONARY_PARAMETER)) {
                String handle = req.getParameter(SEE_DICTIONARY_PARAMETER);
                Dictionary dict = DictionariesFactory.findDictionaryByID(handle);
                //adding an XML file
                addXml(dict.getXmlCode());
            }
            if (null != req.getParameter(SEE_VOLUME_PARAMETER)) {
                String handle = req.getParameter(SEE_VOLUME_PARAMETER);
                Volume vol = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(vol.getXmlCode());
            }
        }

        //adding the content of the dictionaries table
        addDictionariesArray();

        //On rend le contenu correct
        return content.getElementFormulaire();
    }


    /**
     *  Adds a feature to the Xml attribute of the ViewDictionaries object
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
     *  ViewDictionaries object
     *
     * @exception  fr.imag.clips.papillon.business.PapillonBusinessException
     *      Description of the Exception
     */
    protected void addDictionariesArray()
             throws fr.imag.clips.papillon.business.PapillonBusinessException {

        Dictionary[] DictsTable = DictionariesFactory.getDictionariesArray();
        //where we must insert the form
        HTMLTableRowElement theRow = content.getElementTemplateRow();
        HTMLElement theDictionary = content.getElementDictionary();
        HTMLElement theVolume = content.getElementVolume();
        HTMLElement theName = content.getElementName();
        HTMLElement theCategory = content.getElementCategory();
        HTMLElement theType = content.getElementType();
        HTMLElement theSources = content.getElementSources();
        HTMLElement theTargets = content.getElementTargets();
        HTMLElement theEntries = content.getElementEntries();
        HTMLElement theDomain = content.getElementDomain();
        HTMLElement theLegal = content.getElementLegal();
        HTMLAnchorElement theSeeAnchor = content.getElementSeeAnchor();

        Node theRowParent = theRow.getParentNode();

        theRow.removeAttribute("id");
        theName.removeAttribute("id");
        theCategory.removeAttribute("id");
        theType.removeAttribute("id");
        theSources.removeAttribute("id");
        theTargets.removeAttribute("id");
        theEntries.removeAttribute("id");
        theDomain.removeAttribute("id");
        theLegal.removeAttribute("id");
        theSeeAnchor.removeAttribute("id");

        //adding the volumes description
        for (int i = 0; i < DictsTable.length; i++) {
            Utility.removeElement(theVolume);
            content.setTextName(DictsTable[i].getName());
            content.setTextCategory(DictsTable[i].getCategory());
            content.setTextType(DictsTable[i].getType());
            content.setTextSources(DictsTable[i].getSourceLanguages());
            content.setTextTargets(DictsTable[i].getTargetLanguages());
            content.setTextDomain(DictsTable[i].getDomain());
            content.setTextLegal(DictsTable[i].getLegal());
            content.setTextEntries("Entries");

            theSeeAnchor.setHref(this.getUrl() + "?"
                     + SEE_DICTIONARY_PARAMETER + "="
                     + DictsTable[i].getHandle());

            theRowParent.appendChild(theRow.cloneNode(true));
            theDictionary.getParentNode().appendChild(theVolume);

            Volume[] VolsTable = VolumesFactory.getVolumesArray(DictsTable[i].getName());
            for (int j = 0; j < VolsTable.length; j++) {
                Utility.removeElement(theDictionary);
                content.setTextName(VolsTable[j].getName());
                content.setTextCategory("");
                content.setTextType("");
                content.setTextSources(VolsTable[j].getSourceLanguage());
                content.setTextTargets(VolsTable[j].getTargetLanguages());
                content.setTextDomain("");
                content.setTextLegal("");
                String entries = VolumesFactory.countEntries(VolsTable[j]);
                content.setTextEntries(entries);

                theSeeAnchor.setHref(this.getUrl() + "?"
                         + SEE_VOLUME_PARAMETER + "="
                         + VolsTable[j].getHandle());
                theRowParent.appendChild(theRow.cloneNode(true));
                theVolume.getParentNode().appendChild(theDictionary);
            }
        }

        theRowParent.removeChild(theRow);
    }

}
