/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2004/12/24 08:57:44  serasset
 * Premiere version de l'interface avec fond papillon et transparence.
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.4  2003/09/27 04:39:41  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/09/24 15:29:14  serasset
 * Hiding of mail addresses in the Papillon Mailing List archive.
 *
 * Revision 1.2  2003/08/14 08:30:18  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:23  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.20  2002/10/25 14:10:34  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.19.2.1  2002/10/02 16:26:46  serasset
 * Parameters are now correctly decoded.
 *
 * Revision 1.19  2002/09/16 13:34:23  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.18.2.1  2002/08/02 13:55:49  mangeot
 * Corrected the encoding problem while connection to the XRCE analyzers
 *
 * Revision 1.18  2002/07/26 10:00:27  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.17.2.1  2002/07/12 13:50:47  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.17  2002/06/12 14:44:39  serasset
 * Corrected bug in MailingList.po (with getacceptLanguage)
 *
 * Revision 1.16  2002/06/10 11:24:15  mangeot
 * *** empty log message ***
 *
 * Revision 1.15  2002/06/03 10:08:02  serasset
 * Managing pages when viewing messages in the mailing list.
 *
 * Revision 1.14  2002/05/23 16:14:43  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.13  2002/05/13 12:46:15  serasset
 * The mailing list presents only 20 mail headers in one page.
 *
 * Revision 1.12  2002/04/26 11:33:36  serasset
 * MailingList managment and interface polished. Insertion of a new feature to display
 * messages to the user from most business objects (PapillonUserLogger class).
 *
 * Revision 1.11  2001/11/15 15:15:53  serasset
 * *** empty log message ***
 *
 * Revision 1.10  2001/07/12 16:36:46  serasset
 * Ajout des fonctionalites de recherche dans la mailing list.
 *
 * Revision 1.9  2001/07/11 15:30:26  serasset
 * Suppression des tables author et threads. Utilisation d'une table unique "messages".
 *
 * Revision 1.8  2001/07/11 15:08:11  serasset
 * Ajout des tris par date, auteur, sujet dans la liste des messages.
 *
 * Revision 1.7  2001/07/10 16:10:18  serasset
 * On insere maintenant les messages en tant que texte et non plus en les parsant.
 *
 * Revision 1.6  2001/07/10 13:15:12  serasset
 * Premiere version de l'affichage d'un message.
 *
 * Revision 1.5  2001/07/10 11:53:03  serasset
 * Ajout des scripts SL de maintenance de la base PostgreSGL.
 *
 * Revision 1.4  2001/07/10 10:15:49  serasset
 * Integration de xalan.
 * getContent retourne un NOde et non plus un HTMLElement.
 *
 * Revision 1.3  2001/07/09 16:37:31  serasset
 * Liens entre l'application enhydra et la base de donnees PostgreSQL.
 * Suppression du dossier data de la hierarchie CVS
 * Premiere version de la mailing list.
 *
 * Revision 1.2  2001/07/04 12:50:50  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;
import com.lutris.dods.builder.generator.query.DataObjectException;
// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;


// Other imports
import java.util.*;
import java.io.*;

//import com.lutris.xml.xmlc.*;
import com.lutris.appserver.server.httpPresentation.*;
//import org.w3c.dom.html.*;
import org.enhydra.xml.xhtml.dom.*;
import org.w3c.dom.*;

import org.enhydra.xml.io.OutputOptions;
import org.enhydra.xml.io.DOMFormatter;
// Imported JAVA API for XML Parsing classes
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import org.xml.sax.InputSource;
//import org.xml.sax.SAXException;

import fr.imag.clips.papillon.business.message.*;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

public class MailingList extends BasePO {
    protected final static String ID="Id";
    protected final static String BODYPLACE="@@MESSAGE_BODY@@";
    protected final static String SORT_PARAMETER="sort";
    protected final static String THREAD_PARAMETER="thread";
    protected final static String AUTHOR_CONTAINS_PARAMETER="authorcontains";
    protected final static String SUBJECT_CONTAINS_PARAMETER="subjectcontains";
    protected final static String MESSAGE_CONTAINS_PARAMETER="messagecontains";
    protected final static String OFFSET_PARAMETER="offset";
    protected final static String LIMIT_PARAMETER="limit";
    protected final static String NEXT_BUTTON_PARAMETER="next.x";
    protected final static String PREVIOUS_BUTTON_PARAMETER="previous.x";

    protected final static int DEFAULT_LIMIT = 20;
    protected final static int DEFAULT_OFFSET = 0;

    protected  int getCurrentSection() {
        return INFORMATIONS_SECTION;
    }

    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean adminUserRequired() {
        return false;
    }
    
    public Node getContent() throws Exception {
        throw new Exception("Unexpected call to getContent in the Mailing list.");
    }

    public Node getMessageList() throws HttpPresentationException, 
                                        IOException, 
                                        DataObjectException {
                                        
        // On regarde d'abord les paramètres qui nous sont demandés.
        String sort = this.getComms().request.getParameter(SORT_PARAMETER);
        String thread = myGetParameter(THREAD_PARAMETER);
        
        String authorcontains = myGetParameter(AUTHOR_CONTAINS_PARAMETER);
        String subjectcontains = myGetParameter(SUBJECT_CONTAINS_PARAMETER);
        String messagecontains = myGetParameter(MESSAGE_CONTAINS_PARAMETER);
        String offsetString = myGetParameter(OFFSET_PARAMETER);
        String limitString = myGetParameter(LIMIT_PARAMETER);
        String nextButton = myGetParameter(NEXT_BUTTON_PARAMETER);
        String previousButton = myGetParameter(PREVIOUS_BUTTON_PARAMETER);

        int offset = DEFAULT_OFFSET;
        if (offsetString != null) {
            try {
                offset = Integer.parseInt(offsetString);
            } catch (java.lang.NumberFormatException e) {
                // nothing...
            }
        }
        
        int limit = DEFAULT_LIMIT;
        if (limitString != null) {
            try {
                limit = Integer.parseInt(limitString);
            } catch (java.lang.NumberFormatException e) {
                // nothing...
            }
        }
        
        if (null != nextButton) {
            // if the next button has been pushed, get the next page...
            offset = offset + limit;
        } else if (null != previousButton) {
            // if the previous button has been pushed, get the previous page...
            if (offset > limit) offset = offset-limit; else offset=0;
        } else {
            // else, it's a new request => give the first page
            offset = 0;
        }

        Message[] theMessageArray;
        
        theMessageArray = MessageFactory.getMessagesArray(authorcontains, subjectcontains, messagecontains,
                                                          thread, sort, offset, limit);
        int nbMsg = MessageFactory.getMessagesCount(authorcontains, subjectcontains, messagecontains,
                                                    thread, sort);
        
        //Pass the array to the formatter
        MessageListXHTML messageList = getMessageList(theMessageArray);
        
        //Then, set the appropriate values in the form elements
        XHTMLInputElement authorContainsInput = messageList.getElementAuthorContains();
        XHTMLInputElement subjectContainsInput = messageList.getElementSubjectContains();
        XHTMLInputElement messageContainsInput = messageList.getElementMessageContains();
        XHTMLOptionElement dateOption= messageList.getElementSortByDate();
        XHTMLOptionElement subjectOption= messageList.getElementSortBySubject();
        XHTMLOptionElement authorOption= messageList.getElementSortByAuthor();

        XHTMLInputElement currentLimitInput = messageList.getElementCurrentLimit();
        XHTMLInputElement currentOffsetInput = messageList.getElementCurrentOffset();
        
        XHTMLInputElement buttonPrevious = messageList.getElementButtonPrevious();
        XHTMLInputElement buttonNext = messageList.getElementButtonNext();
        
        authorContainsInput.setValue(authorcontains);
        subjectContainsInput.setValue(subjectcontains);
        messageContainsInput.setValue(messagecontains);
        currentLimitInput.setValue(limitString);
        currentOffsetInput.setValue(String.valueOf(offset));
        
        if ((null != sort) && (sort.equals("author"))) {
            authorOption.setSelected(true);
        } else if ((null != sort) && (sort.equals("subject"))) {
            subjectOption.setSelected(true);
        } else {
            dateOption.setSelected(true);
        }
        
        // Remove the previous button if we are already presenting the first message
        if (0 >= offset) {
            Node parent=buttonPrevious.getParentNode();
            parent.removeChild(buttonPrevious);
        }
        
        // remove the next button if we are already presenting the last message.
        if (offset+limit >= nbMsg) {
            Node parent=buttonNext.getParentNode();
            parent.removeChild(buttonNext);
        }
        
        // show the range of the currently displayed messages
        int lastMsg = (offset+limit >= nbMsg) ? nbMsg : (offset + limit);
        int firstMsg = offset + 1;
        messageList.setTextMessageRange(firstMsg + "-" + lastMsg);
        
        return messageList.getElementDiscussion();
    }
    
    public MessageListXHTML getMessageList(Message[] theMessageArray)
        throws HttpPresentationException, IOException, DataObjectException
    {
        MessageListXHTML messageList;
                
        // On initialise le layout
        messageList = (MessageListXHTML)MultilingualXHtmlTemplateFactory.createTemplate("MessageListXHTML", this.getComms(), this.getSessionData());

        // On récupère les éléments du layout
        XHTMLTableRowElement templateRow = messageList.getElementTemplateRow();
        XHTMLElement dateCellTemplate = messageList.getElementDate();
        XHTMLInputElement autInput = messageList.getElementAuthorInput();
        XHTMLElement auteurCellTemplate = messageList.getElementAuthor();
        XHTMLAnchorElement sujAnchor = messageList.getElementSubjectAnchor();
        XHTMLElement sujetCellTemplate = messageList.getElementSubject();
        XHTMLAnchorElement threadAnchor = messageList.getElementThreadAnchor();
        XHTMLElement threadCellTemplate = messageList.getElementThreads();
	
        // On supprime les identificateurs de ces éléments, car on va les dupliquer
        // et il ne peut y avoir 2 éléments de même id dans un document XML
        templateRow.removeAttribute("id");
        dateCellTemplate.removeAttribute("id");
        autInput.removeAttribute("id");
        auteurCellTemplate.removeAttribute("id");
        sujetCellTemplate.removeAttribute("id");
        sujAnchor.removeAttribute("id");
        threadCellTemplate.removeAttribute("id");
        threadAnchor.removeAttribute("id");
	
        // On récupère le noeud contenant la table...
        Node messageTable = templateRow.getParentNode();
	
        for(int i = 0; i < theMessageArray.length; i++) {                
            //la date
            java.sql.Date date=theMessageArray[i].getDate();
            DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
            messageList.setTextDate(df.format(date));
            
            // L'auteur
            String authorName = theMessageArray[i].getAuthor();
            String authorAddress = theMessageArray[i].getAuthorAddress();
            messageList.setTextAuthor(this.maskAddress(authorName));
	    // Split the address in 2 parts
	    int arobasPos=authorAddress.indexOf("@", 0);
	    if (arobasPos != -1) {
		autInput.setName(authorAddress.substring(0, arobasPos));
		autInput.setValue(authorAddress.substring(arobasPos+1));
	    }
            //autAnchor.setHref("mailto:"+authorAddress);
            
            // Le sujet
            String subject = theMessageArray[i].getSubject();
            if(null == subject || "" == subject.trim()) {
                messageList.setTextSubject("no subject");
            } else {
                messageList.setTextSubject(subject);
            }
            sujAnchor.setHref("MailingList.po?Id="+theMessageArray[i].getHandle());

            // Le nombre de réponses
            int nbth = MessageFactory.numberOfMessagesWithThread(theMessageArray[i].getThread());
            
            messageList.setTextThreads(String.valueOf(nbth));
            threadAnchor.setHref("MailingList.po?thread="+myUrlEncode(theMessageArray[i].getThread()));

            Node clone=templateRow.cloneNode(true);
            messageTable.appendChild(clone);
        }
        messageTable.removeChild(templateRow);
        
        
        return messageList;
    }
    
    public Node getMessage() throws HttpPresentationException, 
                                    IOException, 
                                    DataObjectException
                                    {
        MessageXHTML messageLayout;
        HttpPresentationRequest req = this.getComms().request;

        // Récupération du message demandé.
        Message theMessage = MessageFactory.findMessageByID(req.getParameter(ID));
        
        // Création du layout
        messageLayout = (MessageXHTML)MultilingualXHtmlTemplateFactory.createTemplate("MessageXHTML", this.getComms(), this.getSessionData());

        //la date
        java.sql.Date date = theMessage.getDate();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
        messageLayout.setTextDate(df.format(date));
            
        // L'auteur
        XHTMLInputElement autInput = messageLayout.getElementAuthorInput();

        String authorName = theMessage.getAuthor();
        String authorAddress = theMessage.getAuthorAddress();
	messageLayout.setTextAuthor(this.maskAddress(authorName));
	// Split the address in 2 parts
	int arobasPos=authorAddress.indexOf("@", 0);
	if (arobasPos != -1) {
	    autInput.setName(authorAddress.substring(0, arobasPos));
	    autInput.setValue(authorAddress.substring(arobasPos+1));
	}
	//messageLayout.setTextAuthor(authorName);
	//autAnchor.setHref("mailto:"+authorAddress);
        
        String subject = theMessage.getSubject();
        messageLayout.setTextSubject(subject);
        return messageLayout.getElementMessage();
    }
 
    /**
     * This implements the run method in MailingList.
     * I overrided the BasePO.run method because I don't want to parse the
     * message body (as many of then are ill-formed).
     *
     * @param HttpPresentationComms
     * @exception Exception
     */
    public void run(HttpPresentationComms comms)
        throws HttpPresentationException, IOException, Exception {
                 
        // Initialize new or get the existing session data
        initSessionData(comms);
        // Check if the user needs to be logged in for this request.
        if(this.loggedInUserRequired()) {
            checkForUserLogin();   // This will redirect the user to the login page if necessary
        }

        HttpPresentationOutputStream out;
        StdLayout stdLayout;
        Node content;
        byte[] buffer;
	String resStr;
	// Creation du contenu
	String lang = myGetParameter(BasePO.LANG_PARAMETER);

	if (null != lang) {
		this.setUserPreferredLanguage(lang);
	}
	
        
	// Creating the empty page
        stdLayout = new StdLayout(comms, this.getSessionData(),this.getUrl());
        
	// Creating the content of the page --> returning the byte array
        HttpPresentationRequest req = this.getComms().request;
        // If the page is called with the Id parameter, present the requested message,
        // else present the message list.
        if (null != req.getParameter(ID)) { 
            //Insertion du contenu sans corps de message dans le document vide.
            stdLayout.getLayout().getElementMainColumn().appendChild(
                stdLayout.getLayout().importNode(this.getMessage(),true));
            
            // Handling user Messages
            handleUserMessage(stdLayout);
            
            // Création du document HTML résultant
            OutputOptions options = new OutputOptions();
            options.setDropHtmlSpanIds(true);
            options.setXmlEncoding("UTF-8");
            DOMFormatter fFormatter = new DOMFormatter(options);
            
            String docStr = fFormatter.toString(stdLayout.getLayout());
            int bodyStartPos = docStr.lastIndexOf(BODYPLACE);
 
            // Récupération du body du message demandé.
            Message theMessage = MessageFactory.findMessageByID(this.getComms().request.getParameter(ID));
        
            resStr = docStr.substring(0, bodyStartPos) + theMessage.getMsg() + 
                     docStr.substring(bodyStartPos + BODYPLACE.length());
            buffer = resStr.getBytes("UTF-8");
        } else {
            //Insertion du contenu dans le document vide.
            stdLayout.getLayout().getElementMainColumn().appendChild(
                stdLayout.getLayout().importNode(this.getMessageList(),true));
            
            // Handling user Messages
            handleUserMessage(stdLayout);
            
            // Création du document HTML résultant
            OutputOptions options = new OutputOptions();
            options.setDropHtmlSpanIds(true);
            options.setXmlEncoding("UTF-8");
            DOMFormatter fFormatter = new DOMFormatter(options);
            
            buffer = fFormatter.toBytes(stdLayout.getLayout());
        }
        
	// envoi de la réponse
        
        comms.response.setContentType( "text/html; charset=UTF-8" );        
        comms.response.setContentLength( buffer.length );
        out = comms.response.getOutputStream();
        out.write(buffer);
        out.flush();
    }
    
    public static String maskAddress(String address) {
	int arobasPos = address.indexOf("@", 0);
	if (arobasPos != -1) {
	    // Suppress the address, only keep the login id
	    return address.substring(0, arobasPos);
	} else {
	    return address;
	}
    }

}
