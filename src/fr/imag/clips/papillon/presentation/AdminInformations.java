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
 * Revision 1.8  2004/06/29 16:23:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2003/08/25 08:50:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2003/08/25 07:35:23  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2003/08/14 10:36:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/08/14 08:30:16  mangeot
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
 * Revision 1.3  2003/07/24 12:07:17  serasset
 * Corean and Chinese added in language names factory.
 * New sections added in info_doc.xml file's schema.
 * File upload now accepts up to 20 Mb in Information Files Admin page.
 *
 * Revision 1.2.2.1  2003/05/28 09:17:21  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.2  2002/11/22 13:04:10  mangeot
 * Nouvelle version Papillon enhydra 5.0
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.26  2002/10/25 14:10:34  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.25.2.5  2002/10/10 06:46:52  mangeot
 * Corrected a bug pb between lang and DocLang in consultInformations
 * Created a new sql function to count the number of entries for the volumes
 * added in Adminvolumes.java and dictd.show server
 *
 * Revision 1.25.2.4  2002/10/02 06:45:14  mangeot
 * changed the weird function xtp.removeLastChilds()
 *
 * Revision 1.25.2.3  2002/10/02 05:19:17  mangeot
 * The parser does not verify the encoding of the info_doc.xml file, thus I have to reparse
 * with the serializer the author, reference and title.
 *
 * Revision 1.25.2.2  2002/10/02 02:44:57  mangeot
 * Bugs corrected
 *
 * Revision 1.25.2.1  2002/10/01 05:49:17  mangeot
 * Corrected a few bugs for AdminInformations.java
 *
 * Revision 1.25  2002/09/17 17:13:23  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.24  2002/09/16 13:34:22  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.23  2002/09/16 09:55:05  mangeot
 * added a field in informationdocument, the reference,
 * tested and modified olivier's code
 *
 * Revision 1.22  2002/08/19 11:14:12  tache
 * Minor corrections of code presentation (comments, etc).
 *
 * Revision 1.21  2002/08/16 11:29:33  tache
 * The user is redirected to the help page when an error occurs during
 * document addition or replacement.
 *
 * Revision 1.20  2002/08/08 17:01:23  tache
 * Set loggedInUserRequired and adminUserRequired to true. They were set to
 * false by error.
 *
 * Revision 1.19  2002/08/07 14:09:58  tache
 * The XML information file (info_doc.xml) now can be used for importing
 * monolingual archives and multilingual HTML archives.
 *
 * Revision 1.18  2002/08/01 12:55:31  tache
 * Factorized some code to XMLTitleParser and modified the classes to take
 * into account Gilles' changes to localization.
 *
 * Revision 1.17  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.16  2002/07/26 10:00:21  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.15.2.1  2002/07/12 13:50:42  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.15  2002/06/12 06:54:39  mangeot
 * added a message for the registration to the conference
 * and modified AdminInformation to change a doc
 *
 * Revision 1.14  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.13  2002/02/08 15:03:15  serasset
 * The Option element now contains a text, as main PC browsers do not follow the W3C guidelines
 * about the use of the label attribute in option elements.
 *
 * Revision 1.12  2002/02/06 15:03:03  serasset
 * Consultation and Administration of the information files now correctly use the Sections.
 * We do not display the files directly anymore, but display a document. This allows the display of
 * images as embedded docs in the default layout.
 *
 * Revision 1.11  2002/02/06 10:39:39  serasset
 * Remove document is now implemented.
 * The information sections are now defined in papillon's config file and handled in the Administration page.
 *
 * Revision 1.10  2001/11/19 14:33:53  serasset
 * *** empty log message ***
 *
 * Revision 1.9  2001/11/15 15:15:52  serasset
 * *** empty log message ***
 *
 * Revision 1.8  2001/10/30 15:23:01  serasset
 * Images and other format are now supported as media files (i.e. files that are locally saved in a special directory).
 *
 * Revision 1.7  2001/10/29 13:32:50  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 * Revision 1.6  2001/10/17 13:02:03  serasset
 * Distinction entre Doucmuent (abstrait) et fichier (qui constituent concretement un doucument)
 *
 * Revision 1.5  2001/09/07 06:59:23  serasset
 * Full rewrite of the administration code to generalize the handling of Information Files.
 *
 * Revision 1.4  2001/09/03 14:10:34  serasset
 * *** empty log message ***
 *
 * Revision 1.3  2001/08/29 15:26:06  salvati
 * added schema.
 *
 * Revision 1.2  2001/08/29 14:38:00  salvati
 * Cutting the information file part in consulting and administration.
 *
 * Revision 1.1  2001/08/29 13:34:31  salvati
 * Added Informations admin files and consult files.
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
import fr.imag.clips.papillon.presentation.html.orig.*;
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

    protected AdminInformationsTmplHTML content;

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
        content = (AdminInformationsTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("AdminInformationsTmplHTML", this.getComms(), this.getSessionData());

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














