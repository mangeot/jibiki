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
 * Revision 1.1  2005/07/16 12:58:31  serasset
 * Added limit parameter to query functions
 * Added a parameter to Formater initializations
 * Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.Enhydra;
import com.lutris.appserver.server.session.SessionManager;
import com.lutris.appserver.server.session.SessionException;
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.enhydra.xml.xhtml.dom.*;
import org.w3c.dom.*;

import fr.imag.clips.papillon.business.message.MessageDBLoader;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.QueryParameter;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;

import fr.imag.clips.papillon.presentation.AdvancedQueryForm;

// Standard imports
import java.io.IOException;

import java.lang.System;
import java.util.Properties;
import java.util.Enumeration;
import java.util.Collection;
import java.util.Iterator;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

public class AdvancedSearch extends PapillonBasePO {

    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean userMayUseThisPO() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
    throws HttpPresentationException, IOException, SessionException {
        AdvancedSearchXHTML doc = (AdvancedSearchXHTML) MultilingualXHtmlTemplateFactory.createTemplate("AdvancedSearchXHTML", this.myComms, this.sessionData);
        AdvancedQueryForm qf = new AdvancedQueryForm(this.getComms(), this.getSessionData());
        Collection qrset = null;
        
        QueryParameter qp = qf.getQueryParameter();
        
        if (!qf.actionOnFormRequested()) {
            // Perform the request
            // FIXME: See how the QueryParameter object could be use for all the query function
            qrset = DictionariesFactory.doQuery(qp, this.getUser());
            
            XHTMLElement entryNode = doc.getElementResultEntry();
            entryNode.removeAttribute("id");
            
            doc.setTextNbResults(Integer.toString(qrset.size()));
            
            Iterator iter = qrset.iterator();
            while(iter.hasNext()) {
                QueryResult qr = (QueryResult) iter.next();
                ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, qp.getXsl(), ResultFormatterFactory.XHTML_DIALECT, null);
                Utility.removeChildNodes(entryNode);
                Node entryDOM = (Node)rf.getFormattedResult(qr);
                entryNode.appendChild(doc.importNode(entryDOM, true));
                entryNode.getParentNode().insertBefore(entryNode.cloneNode(true), entryNode);
            }
            
            entryNode.getParentNode().removeChild(entryNode);
            
            //On rends le contenu correct
            
        }
        XHTMLElement formHolder = doc.getElementQueryForm();
        formHolder.appendChild(doc.importNode(qf.getQueryFormNode("AdvancedSearch.po"), true));
        
        return doc.getElementAdvancedSearchPage();
    }

}

