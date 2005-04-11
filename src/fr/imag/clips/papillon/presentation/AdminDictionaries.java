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
 *  Revision 1.3  2005/04/11 08:01:02  fbrunet
 *  Passage en xhtml des ressources Papillon.
 *
 *  Revision 1.2  2004/12/24 14:31:28  mangeot
 *  I merged the latest developments of Papillon5.0 with this version 5.1.
 *  Have to be tested more ...
 *
 *  Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 *  Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 *  There are still bugs in the code.
 *
 *  Revision 1.6  2004/10/28 10:56:21  mangeot
 *  Added the list of connected users on AdminUsers.java,
 *  Added the possibility to sort in columns for some pages
 *  Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
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

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

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
    protected static AdminDictionariesXHTML content;


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
        content = (AdminDictionariesXHTML) MultilingualXHtmlTemplateFactory.createTemplate("AdminDictionariesXHTML", this.getComms(), this.getSessionData());

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
