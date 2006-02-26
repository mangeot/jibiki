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
 * Revision 1.8  2006/02/26 14:04:56  mangeot
 * Corrected a bug: the content was a static variable, thus there were problems when two users wanted to aces the same page at the same time
 *
 * Revision 1.7  2005/08/05 18:44:38  mangeot
 * Bug fixes + ProcessVolume.po page creation
 *
 * Revision 1.6  2005/07/14 13:48:53  serasset
 * Added columns dictionaryname and volumename to the xslsheets.
 * Modified the XslSheet and XslSheetFactory accordingly.
 * Modified AdminXsl interface accordingly.
 * Modified DictionariesFactory and VolumesFactory to allow several xsl-sheets and to
 * correctly provide dictionaryName/volumeName to XslSheetFactory.
 * Cleanup of several errors in papillon_static doml file.
 *
 * Revision 1.5  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.4  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.3  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.2.2.2  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.2.2.1  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
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
//test
import com.lutris.appserver.server.httpPresentation.HttpUtil;
//fin test

import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationInputStream;
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

// For URLs
import java.net.URL;

//pour les stylesheet
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;

public class AdminXsl extends PapillonBasePO {
    
    protected final static String SEE_PARAMETER="See";
    protected final static String ADD_PARAMETER="Add";
    protected final static String FLUSH_PARAMETER="Flush";
    
    protected final static String REMOVE_PARAMETER="Remove";

    protected final static String NAME_PARAMETER="name";
    protected final static String DESC_PARAMETER="description";
    protected final static String URL_PARAMETER="url";
    protected final static String DEFAULT_XSL="defaultxsl";
    protected final static String TYPE_XSL="type";    

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean userMayUseThisPO() {
        try {
            return this.getUser().isAdmin();
        } catch (PapillonBusinessException ex) {
            this.getSessionData().writeUserMessage("Error getting the authorisation to use this PO.");
        }
        return false;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws javax.xml.parsers.ParserConfigurationException,HttpPresentationException, IOException
    {

        // Création du contenu
        AdminXslTmplXHTML content = (AdminXslTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("AdminXslTmplXHTML", this.getComms(), this.getSessionData());
		  
        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            String userMessage = null;
            if (null != req.getParameter(FLUSH_PARAMETER)) {
                XslSheetFactory.emptyDatabase();
                userMessage = "All XslSheets removed...";
            } 
            else if ((null != req.getParameter(AdminXslTmplXHTML.NAME_name)) && 
                    (null != req.getParameter(AdminXslTmplXHTML.NAME_url))) {
                // Get the main parameters
                String Nom = req.getParameter(AdminXslTmplXHTML.NAME_name);
                String dictionaryName = req.getParameter(AdminXslTmplXHTML.NAME_dictionaryName);
                String volumeName = req.getParameter(AdminXslTmplXHTML.NAME_volumeName);
                String Description= req.getParameter(AdminXslTmplXHTML.NAME_description);
                URL theURL= new URL(req.getParameter(AdminXslTmplXHTML.NAME_url));
                String leCode = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(theURL);

                //recuperation du parametre default xsl
                boolean defaultXsl;
                if (null!=req.getParameter(AdminXslTmplXHTML.NAME_type)) {
                    defaultXsl=true;
                    XslSheet theOldDefaultSheet=XslSheetFactory.findDefaultXslSheet();
                    if ( !(theOldDefaultSheet.isEmpty()) ) {
                        theOldDefaultSheet.setDefaultxsl(false);
                        theOldDefaultSheet.save();
                    }                    
                } else {
                    defaultXsl=false;
                }
                if (leCode !=null && !leCode.equals("")) {
                    XslSheetFactory.AddAndReplaceXslSheet(Nom, dictionaryName, volumeName, Description,leCode,defaultXsl);
                    userMessage = "XslSheet " + Nom + " added...";
                }
                else {
                    userMessage = "XslSheet " + Nom + " not uploaded, please check the URL...";
                }
                
            } else if ( (null != req.getParameter(REMOVE_PARAMETER))) {
                String handle = req.getParameter(REMOVE_PARAMETER);
                XslSheet theSheet = XslSheetFactory.findXslSheetByHandle(handle);
                theSheet.delete();
                userMessage = "XslSheet " + theSheet.getName() + " removed...";
            } else if ((null != req.getParameter(DEFAULT_XSL))) {
                String handle= req.getParameter(DEFAULT_XSL);
                XslSheet theOldDefaultSheet=XslSheetFactory.findDefaultXslSheet();
                if ( !(theOldDefaultSheet.isEmpty()) )
                    {theOldDefaultSheet.setDefaultxsl(false);
                     theOldDefaultSheet.save();}                     
                XslSheet theSheet = XslSheetFactory.findXslSheetByHandle(handle);
                theSheet.setDefaultxsl(true);
                theSheet.save();
                userMessage = "XslSheet " + theSheet.getName() + " set default...";
            }
            else if ( (null != req.getParameter(SEE_PARAMETER))) {
                String handle = req.getParameter(SEE_PARAMETER);
                XslSheet theSheet = XslSheetFactory.findXslSheetByHandle(handle);
                //adding an XML file
                addXml(content, theSheet.getXmlCode());
            }
            this.getSessionData().writeUserMessage(userMessage);
            PapillonLogger.writeDebugMsg(userMessage);
        }
        
        XslSheet[] XslSheetsTable=XslSheetFactory.getXslSheetsArray();
        //where we must insert the form
        HTMLTableRowElement theRow = content.getElementTemplateRow();
	    HTMLElement theXslName = content.getElementXslName();
	    HTMLElement theXslDictionaryName = content.getElementXslDictionaryName();
	    HTMLElement theXslVolumeName = content.getElementXslVolumeName();
        HTMLElement theXslDesc = content.getElementXslDesc();
        HTMLElement theXslDefault = content.getElementXslDefault();
        HTMLAnchorElement theSeeAnchor = content.getElementSeeAnchor();
        HTMLAnchorElement theRemoveAnchor = content.getElementRemoveAnchor();
        HTMLAnchorElement theDefaultAnchor = content.getElementDefaultAnchor();

        Node theRowParent = theRow.getParentNode();

        theRow.removeAttribute("id");
        theXslName.removeAttribute("id");
        theXslDictionaryName.removeAttribute("id");
        theXslVolumeName.removeAttribute("id");
        theXslDesc.removeAttribute("id");
        theXslDefault.removeAttribute("id");
        theSeeAnchor.removeAttribute("id");	
        theRemoveAnchor.removeAttribute("id");
        theDefaultAnchor.removeAttribute("id");

        //adding the sheet choice
        for ( int i = 0; i < XslSheetsTable.length; i++ ) {
            content.setTextXslName(XslSheetsTable[i].getName());
            content.setTextXslDictionaryName((null == XslSheetsTable[i].getDictionaryName()) ? "" : XslSheetsTable[i].getDictionaryName());
            content.setTextXslVolumeName((null == XslSheetsTable[i].getVolumeName()) ? "" :  XslSheetsTable[i].getVolumeName());
            content.setTextXslDesc(XslSheetsTable[i].getDescription());
            if (XslSheetsTable[i].getDefaultxsl()) {
                content.setTextXslDefault("Default StyleSheet");
            } else {
                content.setTextXslDefault("");
            }
            
            theSeeAnchor.setHref(this.getUrl() + "?See=" + XslSheetsTable[i].getHandle());
            theRemoveAnchor.setHref(this.getUrl() + "?Remove=" + XslSheetsTable[i].getHandle());
            if (XslSheetsTable[i].getDefaultxsl()) {
                theDefaultAnchor.setHref("");
                theDefaultAnchor.getFirstChild().setNodeValue("");
            } else {
                theDefaultAnchor.setHref(this.getUrl() + "?defaultxsl=" + XslSheetsTable[i].getHandle());
                theDefaultAnchor.getFirstChild().setNodeValue("Make Default");
            }
            
            theRowParent.appendChild(theRow.cloneNode(true));
        }
        
        theRowParent.removeChild(theRow);
        

        //On rends le contenu correst
        return content.getElementFormulaire();
    }
    protected void addXml(AdminXslTmplXHTML content, String xmlString) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            
        Node xmlNode = XslTransformation.applyXslSheetForXml(xmlString);    
            
        //where we must insert the xml
        HTMLElement theXml = content.getElementXml();

        Node theXmlParent = theXml.getParentNode();

        theXmlParent.appendChild(content.importNode(xmlNode,true));
        theXmlParent.removeChild(theXml);
    }
}
