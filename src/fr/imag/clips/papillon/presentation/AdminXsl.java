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
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.4  2004/02/10 06:51:37  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.2.2.1  2004/02/02 07:53:53  mangeot
 * Bug fixes in encoding and UserInterface
 *
 * Revision 1.2  2003/08/14 08:30:16  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:21  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.18  2002/09/16 13:34:22  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.17.2.1  2002/08/02 08:25:10  mangeot
 * Replaced PAGENAME variable by this.getUrl() method
 *
 * Revision 1.17  2002/07/26 10:00:22  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.16.6.1  2002/07/12 13:50:43  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.16  2002/05/24 16:29:37  mangeot
 * Adding colspan for entries
 *
 * Revision 1.15  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.14  2002/05/22 08:56:18  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.13  2002/05/10 16:43:19  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.12  2002/04/18 11:42:35  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.11  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.10  2001/08/07 13:11:48  salvati
 * Adding ant.jar for untar tools.
 *
 * Revision 1.9  2001/07/31 13:54:20  salvati
 * Adding debug message.
 *
 * Revision 1.8  2001/07/31 08:36:37  serasset
 * enommage des fichiers HTML pour eviter un eventuel ecrasement par xmlc.
 *
 * Revision 1.7  2001/07/31 08:21:43  serasset
 * *** empty log message ***
 *
 * Revision 1.6  2001/07/27 10:45:54  serasset
 * On ne genere plus de lien "Make Default" lorsque la XSL est deja par defaut.
 *
 * Revision 1.5  2001/07/25 12:48:38  salvati
 * Adding StyleSheet choice in the standard consultation view with a menu on the right.
 *
 * Revision 1.4  2001/07/24 13:15:33  salvati
 * Adding the defaultxsl field in the database, adding the choice of
 * the default stylesheet when adding stylesheets.
 *
 * Revision 1.3  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.2  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.1  2001/07/12 17:02:57  salvati
 * Support adding sheets and empty db
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
import fr.imag.clips.papillon.business.xsl.XslSheetDBop;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.html.orig.*;

public class AdminXsl extends BasePO {
    
    protected final static String SEE_PARAMETER="See";
    protected final static String ADD_PARAMETER="Add";
    protected final static String FLUSH_PARAMETER="Flush";
    
    protected final static String REMOVE_PARAMETER="Remove";

    protected final static String NAME_PARAMETER="name";
    protected final static String DESC_PARAMETER="description";
    protected final static String URL_PARAMETER="url";
    protected final static String DEFAULT_XSL="defaultxsl";
    protected final static String TYPE_XSL="type";    

    protected static AdminXslTmplHTML content;

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean adminUserRequired() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws javax.xml.parsers.ParserConfigurationException,HttpPresentationException, IOException
    {

        // Création du contenu
        content = (AdminXslTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("AdminXslTmplHTML", this.getComms(), this.getSessionData());
		  
        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            String userMessage = null;
            if (null != req.getParameter(FLUSH_PARAMETER)) {
                XslSheetDBop.EmptyDatabase();
                userMessage = "All XslSheets removed...";
            } 
            else if ((null != req.getParameter(NAME_PARAMETER)) && 
                    (null != req.getParameter(URL_PARAMETER))) {
                // Get the main parameters
                String Nom = req.getParameter(NAME_PARAMETER);
            	String Description= req.getParameter(DESC_PARAMETER);
                URL theURL= new URL(req.getParameter(URL_PARAMETER));
                String leCode = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(theURL);

                //recuperation du parametre default xsl
                boolean defaultXsl;
                if ( (null!=req.getParameter(TYPE_XSL)) ) 
                    {defaultXsl=true;
                        XslSheet theOldDefaultSheet=XslSheetFactory.findDefaultXslSheet();
                        if ( !(theOldDefaultSheet.IsEmpty()) ) {
                            theOldDefaultSheet.setDefaultxsl(false);
                            theOldDefaultSheet.save();
                        }                    
                    } else {
                        defaultXsl=false;
                    }
										if (leCode !=null && !leCode.equals("")) {
											XslSheetDBop.AddAndReplaceXslSheet(Nom,Description,leCode,defaultXsl);
											userMessage = "XslSheet " + Nom + " added...";
										}
										else {
											userMessage = "XslSheet " + Nom + " not uploaded, please check the URL...";
										}

            } else if ( (null != req.getParameter(REMOVE_PARAMETER))) {
                String handle = req.getParameter(REMOVE_PARAMETER);
                XslSheet theSheet = XslSheetFactory.findXslSheetByID(handle);
                theSheet.delete();
                userMessage = "XslSheet " + theSheet.getName() + " removed...";
            } else if ((null != req.getParameter(DEFAULT_XSL))) {
                String handle= req.getParameter(DEFAULT_XSL);
                XslSheet theOldDefaultSheet=XslSheetFactory.findDefaultXslSheet();
                if ( !(theOldDefaultSheet.IsEmpty()) )
                    {theOldDefaultSheet.setDefaultxsl(false);
                     theOldDefaultSheet.save();}                     
                XslSheet theSheet = XslSheetFactory.findXslSheetByID(handle);
                theSheet.setDefaultxsl(true);
                theSheet.save();
                userMessage = "XslSheet " + theSheet.getName() + " set default...";
            }
            else if ( (null != req.getParameter(SEE_PARAMETER))) {
                String handle = req.getParameter(SEE_PARAMETER);
                XslSheet theSheet = XslSheetFactory.findXslSheetByID(handle);
                //adding an XML file
                addXml(theSheet.getXmlCode());
            }
            this.getSessionData().writeUserMessage(userMessage);
            PapillonLogger.writeDebugMsg(userMessage);
        }
        
        XslSheet[] XslSheetsTable=XslSheetFactory.getXslSheetsArray();
        //where we must insert the form
        HTMLTableRowElement theRow = content.getElementTemplateRow();
	    HTMLElement theXslName = content.getElementXslName();
        HTMLElement theXslDesc = content.getElementXslDesc();
        HTMLElement theXslDefault = content.getElementXslDefault();
        HTMLAnchorElement theSeeAnchor = content.getElementSeeAnchor();
        HTMLAnchorElement theRemoveAnchor = content.getElementRemoveAnchor();
        HTMLAnchorElement theDefaultAnchor = content.getElementDefaultAnchor();

        Node theRowParent = theRow.getParentNode();

        theRow.removeAttribute("id");
        theXslName.removeAttribute("id");
        theXslDesc.removeAttribute("id");
        theXslDefault.removeAttribute("id");
        theSeeAnchor.removeAttribute("id");	
        theRemoveAnchor.removeAttribute("id");
        theDefaultAnchor.removeAttribute("id");

        //adding the sheet choice
	for ( int i = 0; i < XslSheetsTable.length; i++ ) {
        content.setTextXslName(XslSheetsTable[i].getName());
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
    protected void addXml(String xmlString) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            
        Node xmlNode = XslTransformation.applyXslSheetForXml(xmlString);    
            
        //where we must insert the xml
        HTMLElement theXml = content.getElementXml();

        Node theXmlParent = theXml.getParentNode();

        theXmlParent.appendChild(content.importNode(xmlNode,true));
        theXmlParent.removeChild(theXml);
    }
}
