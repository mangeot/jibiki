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
 * Revision 1.3  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.*;

//pour les erreurs dans l'importation de fichiers
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;


//pour les upload
import com.lutris.mime.*;

//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.Document;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;

//import fr.imag.clips.papillon.business.message.MessageDBLoader;
import com.lutris.util.KeywordValueTable;
import com.lutris.util.Config;
import com.lutris.util.KeywordValueException;
import com.lutris.util.ConfigException;
import com.lutris.appserver.server.Enhydra;



// Standard imports
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import java.util.ArrayList;
import java.text.DateFormat;
import java.io.*;
import java.lang.Integer;

//pour les Information file
import fr.imag.clips.papillon.business.informationfile.*;
//for the choice of the type and encoding
import fr.imag.clips.papillon.business.filetype.*;
import fr.imag.clips.papillon.business.encoding.*;


import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.*;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.locales.Languages;
import fr.imag.clips.papillon.business.dictionary.AvailableLanguages;

import de.opus5.servlet.*;

import fr.imag.clips.papillon.business.PapillonImportException;

import fr.imag.clips.papillon.presentation.PapillonPresentationException;
import fr.imag.clips.papillon.presentation.xhtml.orig.*;
import fr.imag.clips.papillon.presentation.XMLTitleParser;

public class AdminInformations extends BasePO {

    //the parameters
    //protected final static String SEE_URL="ConsultInformations.po?fileid=";
    protected final static String REMOVE_PARAM = "remove";
    protected final static String ADD="Add";
    protected final static String REPLACE="Replace";
    protected final static String FLUSH="Flush";

    protected final static String FILE_TITLE="title";
    protected final static String FILE_FIELD="file";
    protected final static String FILE_SECTION="section";
    protected final static String FILE_AUTHOR="author";
    protected final static String FILE_LANGUAGE="language";
    protected final static String FILE_YEAR="year";
    protected final static String FILE_MONTH="month";
    protected final static String FILE_DAY="day";
    protected final static String FILE_REFERENCE="Reference";

    //protected final static String UPLOAD_DIRECTORY="/Users/enhydra/papillon/classes/upload/";
    protected final static String TMP_DIR_CONFIG="Papillon.Informations.tmpDir";
    protected final static String IMPORT_HELP_PAGE = "ImportHelp.po";

    protected fr.imag.clips.papillon.business.informationfile.MediaPreferences prefs;

    protected AdminInformationsTmplXHTML content;

    protected Languages Languages;



    public AdminInformations () {
        prefs = new MediaPreferences();
    }

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean adminUserRequired() {
        return false;
    }

    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    private void removeInformationDocument(String docID)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            InformationDocumentFactory.deleteInformationDocument(docID);
        }


    public Node getContent() throws javax.xml.parsers.ParserConfigurationException,
				    PapillonPresentationException,
        HttpPresentationException,
        IOException,
        IllegalArgumentException ,
        com.lutris.mime.MimeException,
        javax.xml.transform.TransformerConfigurationException,
        javax.xml.transform.TransformerException,
        org.xml.sax.SAXException
    {

        /*********************************/
        // Reading the request
        /*********************************/
        // Avant toute chose, on récupère les paramêtres selon la méthode que le client a utilisé
        // Ce peut-être du GET (c'est standard), du POST en url-encoded (c'est standard aussi dans enhydra)
        // ou bien du POST en multipart (non géré par enhydra, mais par le multipart request).
        HttpPresentationComms comms=this.getComms();

        String contentType = comms.request.getContentType();
        if (contentType == null) {
            contentType = "";
        }
        ContentHeader contentHdr =new ContentHeader("Content-Type: " + contentType);
        javax.servlet.http.HttpServletRequest req = null;

        if (contentHdr.getValue().toLowerCase().startsWith("multipart/")) {
            // On a affaire à un multipart request, on construit donc la requête appropriée.
            // ATTENTION: Pour simplifier la gestion du fichier chargé plus tard, je choisi le constructeur
            // qui force la sauvegarde des données dans un fichier temporaire.
					PapillonLogger.writeDebugMsg("Multipart request");
            String tmpDir="/tmp/";      // Dangereux ???
            try {
                tmpDir = Enhydra.getApplication().getConfig().getString(TMP_DIR_CONFIG);
                if (! tmpDir.endsWith(File.separator)) {
                    tmpDir = tmpDir + File.separator;
                }
            } catch (KeywordValueException kve) {
                PapillonLogger.writeDebugMsg("Unexpected Error: Incorrect configuration file for group: "
                                             + TMP_DIR_CONFIG);
            }
            req = new MultipartRequest(comms.request.getHttpServletRequest(), 30000000, tmpDir,"papillon-tmp", false);
        }
				else {
					PapillonLogger.writeDebugMsg("Normal request");
					req = comms.request.getHttpServletRequest();
				}

        /*********************************/
        // Managing the request, it may be a flush, remove or add action.
        /*********************************/
        if (req.getParameter(FLUSH)!=null) {
            // InformationFile[] fileArray=InformationFileFactory.getInformationFilesArray();
            // for(int file=0;file<fileArray.length;file++) {
            //     removeInformationFile(fileArray[file]);
            // }
            // writeDebugMsg("database erased...");
        } else if (req.getParameter(REMOVE_PARAM) != null) {
            removeInformationDocument(req.getParameter(REMOVE_PARAM));
        } else {
            // Requête par défaut !
            // On a une demande d'ajout de document. On la traite...
            addInformationDocument(req);
        }

        /*********************************/
        // Creating the document Layout
        /*********************************/
        content = (AdminInformationsTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("AdminInformationsTmplXHTML", this.getComms(), this.getSessionData());

        addConsultForm();

        addFileListing();

        return content.getElementFormulaire();

    }

    protected void addFileListing ()
        throws fr.imag.clips.papillon.business.PapillonBusinessException,
        PapillonPresentationException {

        /*********************************/
        //adding the file listing
        /*********************************/

        InformationDocument[] docTable=InformationDocumentFactory.getInformationDocumentArray();

        HTMLTableRowElement theRow = content.getElementTemplateRow();
        HTMLElement theDocTitle = content.getElementDocumentTitle();
        HTMLElement theAuthor = content.getElementDocumentAuthor();
        HTMLElement theDate = content.getElementDocumentDate();
        HTMLElement theReference = content.getElementDocumentReference();
        HTMLAnchorElement theDocumentAnchor = content.getElementDocumentAnchor();
        HTMLInputElement theReplaceButton = content.getElementReplaceButton();
        HTMLAnchorElement theRemoveAnchor = content.getElementRemoveAnchor();
        HTMLElement theSpaces = content.getElementNBSpace();

        Node theTitleCell = theDocumentAnchor.getParentNode();

        theRow.removeAttribute("id");
        theDocTitle.removeAttribute("id");
        theAuthor.removeAttribute("id");
        theDate.removeAttribute("id");
        theReference.removeAttribute("id");
        theReplaceButton.removeAttribute("id");
        theRemoveAnchor.removeAttribute("id");
        theSpaces.removeAttribute("id");
        theDocumentAnchor.removeAttribute("id");
        

    Node theRowParent = theRow.getParentNode();
    Node theReplaceButtonParent = theReplaceButton.getParentNode();
    Node theRemoveAnchorParent = theRemoveAnchor.getParentNode();

        //adding the file list
        for ( int i = 0; i < docTable.length; i++ ) {
            theReplaceButtonParent.removeChild(theReplaceButtonParent.getFirstChild());
            theRemoveAnchorParent.removeChild(theRemoveAnchorParent.getFirstChild());
            content.setTextDocumentAuthor(docTable[i].getAuthor());
            content.setTextDocumentDate(docTable[i].getCreationDate().toString());
            content.setTextDocumentReference(docTable[i].getReference());

            //parse the XML title stored in the DB
            XMLTitleParser xtp = new XMLTitleParser();

            // get available languages
            // the first language of the vector is the one to use to display the title
            Vector theLangs = xtp.buildLangs(docTable[i], this.getSessionData().getUserAcceptLanguages());

            // add available languages next to the document title
            // we should replace this by flags pictures
            
            for (int j = 1; j < theLangs.size(); j++) {
                String langCode = (String)theLangs.get(j);
                String locLang = Languages.localizeName(getUserPreferredLanguage(),langCode);
                content.setTextDocumentTitle(locLang);
                theDocumentAnchor.setHref(prefs.getConsultDocumentUrl() +
                                          docTable[i].getHandle() + "&" +
                                          prefs.DOC_LANG_PARAMETER + "=" +
                                          langCode);
                theTitleCell.appendChild(theDocumentAnchor.cloneNode(true));
                theTitleCell.appendChild(theSpaces.cloneNode(true));
            }

            // add the title in the preferred language
            String title = xtp.getTitle((String)theLangs.get(0));

            // it should not happen
            if (title.trim().equals("")) title = "Untitled Document";
            content.setTextDocumentTitle(title);
            theDocumentAnchor.setHref(prefs.getConsultDocumentUrl() +
                                      docTable[i].getHandle() + "&" +
                                      prefs.DOC_LANG_PARAMETER + "=" +
                                      theLangs.get(0));

            // The replace button and remove anchor are put only if
            // - the user logged is the owner of the document or
            // - the user is admin
            String replaceString = "this.form." + REPLACE + ".value='" + 
            docTable[i].getHandle() + "'";

            if (this.getUser().IsAdmin() ||
                this.getUser().getLogin().equals(docTable[i].getOwner())) {
                theReplaceButton.setAttribute("onclick", replaceString);
                theRemoveAnchor.setHref(this.getUrl() + "?" + REMOVE_PARAM + "=" +
                                        docTable[i].getHandle());
                theReplaceButtonParent.appendChild(theReplaceButton.cloneNode(true));
                theRemoveAnchorParent.appendChild(theRemoveAnchor.cloneNode(true));
            }
            theRowParent.appendChild(theRow.cloneNode(true));
            // Here I remove the childs precedently added for multilingual docs
            if (theLangs.size() > 1) {
                int nbChilds = theTitleCell.getChildNodes().getLength();
                for (int j = 0; j <= theLangs.size()-1; j++) {
                    theTitleCell.removeChild(theTitleCell.getLastChild());

                }
            }
        }
        theRowParent.removeChild(theRow);
    }


    public void addInformationDocument(javax.servlet.http.HttpServletRequest mReq)
        throws 	javax.xml.parsers.ParserConfigurationException,
        HttpPresentationException,
        IOException,
        IllegalArgumentException ,
        com.lutris.mime.MimeException,
        javax.xml.transform.TransformerConfigurationException,
        javax.xml.transform.TransformerException,
        org.xml.sax.SAXException  {

            // Perhaps we should give default values (problem: in what language ?)

            String docTitle=mReq.getParameter(FILE_TITLE);
            PapillonLogger.writeDebugMsg("FILE_TITLE :"+docTitle);
            //file author
            String docAuthor=mReq.getParameter(FILE_AUTHOR);
            PapillonLogger.writeDebugMsg("FILE_AUTHOR :"+docAuthor);
            //file section
            String docSection=mReq.getParameter(FILE_SECTION);
            PapillonLogger.writeDebugMsg("FILE_SECTION :"+docSection);
            //file language
            String docLanguage=mReq.getParameter(FILE_LANGUAGE);
            PapillonLogger.writeDebugMsg("FILE_LANGUAGE :"+docLanguage);
            //file date
            String docYear=mReq.getParameter(FILE_YEAR);
            String docMonth=mReq.getParameter(FILE_MONTH);
            String docDay=mReq.getParameter(FILE_DAY);
            String docDate = "";
            if (null != docDay && !docDay.trim().equals("")) {
                docDate = docDay + "/" + docMonth + "/" + docYear;
            }
            PapillonLogger.writeDebugMsg("FILE_DATE :"+docDate);
            //file reference
            String docReference=mReq.getParameter(FILE_REFERENCE);
            PapillonLogger.writeDebugMsg("FILE_REFERENCE :"+docReference);


            // In case of Replace, existing doc id
            String docId=mReq.getParameter(REPLACE);
            PapillonLogger.writeDebugMsg("Existing Doc Id: "+docId);

            String docOwner = this.getUser().getLogin();
			String userMessage = "";
            
            // these strings should not be null !!
            if (null == docTitle) { docTitle = ""; }
            if (null == docAuthor) { docAuthor = ""; }
            if (null == docSection) { docSection = ""; }
            if (null == docOwner) { docOwner = ""; }
            if (null == docLanguage) { docLanguage = ""; }
            if (null == docDate) { docDate = ""; }
            if (null == docReference) { docReference = ""; }
						PapillonLogger.writeDebugMsg("Multipart Request Class Name: " + mReq.getClass().getName());

            if (mReq.getClass().getName().equals("de.opus5.servlet.MultipartRequest")) {

                de.opus5.servlet.UploadedFile f = ((MultipartRequest)mReq).getUploadedFile(FILE_FIELD);
                if (null != f && !f.getName().equals("")) {
                    try {
                        if (null != docId && !docId.equals("")){
                            InformationDocumentFactory.replaceInformationDocument(docId,
                                                                                  ((MultipartRequest)mReq).getUploadedFile(FILE_FIELD),
                                                                                  docTitle, docAuthor, docLanguage, docDate, docReference);
                        }
                        else {
                            InformationDocumentFactory.addNewInformationDocument(((MultipartRequest)mReq).getUploadedFile(FILE_FIELD),
                                                                                 docTitle, docAuthor, docOwner, docSection, docLanguage, docDate, docReference);
                        }
                    } catch(PapillonImportException pie) {
                        this.getSessionData().writeUserMessage("ERROR IMPORTING DOCUMENT: "+pie.getMessage());
                        // redirect the user to import help page
                        throw new ClientPageRedirectException(IMPORT_HELP_PAGE);
                    } catch(Exception e) {
						 userMessage = "ERROR IMPORTING DOCUMENT: "+e.getMessage();
                    }
					if (userMessage==null || userMessage.equals("")) {
					 userMessage = "Document imported";
					}
					 this.getSessionData().writeUserMessage(userMessage);
                }

            }
        }

    protected void addConsultForm()
        throws fr.imag.clips.papillon.business.PapillonBusinessException,
        HttpPresentationException,
        java.io.UnsupportedEncodingException {


            /*********************************/
            // Adding the javascript for the date
            /*********************************/
            HTMLScriptElement scriptElement = (HTMLScriptElement)content.getElementScript();
            this.setHeaderScript(scriptElement.getText());

            /*********************************/
            // Adding the appropriate options to the sections list
            /*********************************/
            HTMLInputElement theAuthorInputTemplate = content.getElementAuthor();
            HTMLOptionElement theOptionTemplate = content.getElementOptionTemplate();
            HTMLOptionElement theLanguageTemplate = content.getElementLanguageTemplate();
            Node theSelect = theOptionTemplate.getParentNode();
            Node theLanguageSelect = theLanguageTemplate.getParentNode();

            theOptionTemplate.removeAttribute("id");
            theLanguageTemplate.removeAttribute("id");

            theAuthorInputTemplate.setValue(this.getUser().getName());

            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            Text theTextTemplate = (Text)theOptionTemplate.getFirstChild();
            Text theLanguageTextTemplate = (Text)theLanguageTemplate.getFirstChild();

            InformationSections sections = new InformationSections();

            String[] sectionNames = sections.getInformationSectionArray();

            String[] sectionLocalizedNames =
                sections.getAcceptedLocalizedSectionArray((ArrayList)this.getSessionData().getUserAcceptLanguages());
            for (int i = 0; i < sectionNames.length; i++) {
                theOptionTemplate.setValue(sectionNames[i]);
                theOptionTemplate.setLabel(sectionLocalizedNames[i]);
                // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
                // specs W3C.
                theTextTemplate.setData(sectionLocalizedNames[i]);
                theSelect.appendChild(theOptionTemplate.cloneNode(true));
            }
						

            /*********************************/
            // Adding the languages list
            /*********************************/

            String[] allLanguages = Languages.getArray();
						String langLoc = getUserPreferredLanguage();
						for (int i = 0; i < allLanguages.length; i++) {
							String langi = allLanguages[i];
							theLanguageTemplate.setValue(langi);
							if (this.IsClientWithLabelDisplayProblems()) {
								theLanguageTemplate.setLabel(Languages.localizeLabel(langLoc,langi));
							}
							else {
								theLanguageTemplate.setLabel(Languages.localizeName(langLoc,langi));
							}
							theLanguageTemplate.setSelected(langi.equals(langLoc));

							// Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
			 // specs W3C.
							theLanguageTextTemplate.setData(Languages.localizeName(langLoc, langi));
							theLanguageSelect.appendChild(theLanguageTemplate.cloneNode(true));
            }
						

            theSelect.removeChild(theOptionTemplate);
            theLanguageSelect.removeChild(theLanguageTemplate);
        }
}














