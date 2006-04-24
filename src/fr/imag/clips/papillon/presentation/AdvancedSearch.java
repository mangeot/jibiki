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
 * Revision 1.4  2006/04/24 13:43:29  fbrunet
 * Add new class ViewQueryResult : allow to use one class to create result display in advancedSearch and EditEntryInit (like advancedQueryForm)
 * Improve result display : view n results per page
 *
 * Revision 1.3  2006/04/06 15:06:39  fbrunet
 * New class 'creationEditInit' : create new entry
 * Modify LexALPEditEntry : only edit entry
 *
 * Revision 1.2  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.1.4.8  2006/02/17 15:16:42  mangeot
 * Do not display the list of all XSL on the search form any more. Displays only a list of XSL descriptions
 *
 * Revision 1.1.4.7  2006/02/17 13:21:25  mangeot
 *
 * MM: modified AdvancedQueryForm. getAllTargetLanguages, getAllSourceLanguages 
 * and getCdmElementsWithDefaultLanguage are now static in AvailableLanguages.java in order to accelerate the execution.
 *
 * Revision 1.1.4.6  2006/01/25 16:51:46  fbrunet
 * *** empty log message ***
 *
 * Revision 1.1.4.5  2006/01/25 15:22:23  fbrunet
 * Improvement of QueryRequest
 * Add new search criteria
 * Add modified status
 *
 * Revision 1.1.4.4  2006/01/24 13:39:49  fbrunet
 * Modification view management
 * Modification LexALP postprocessing
 *
 * Revision 1.1.4.3  2005/12/08 13:44:53  fbrunet
 * *** empty log message ***
 *
 * Revision 1.1.4.2  2005/12/02 10:04:09  fbrunet
 * Add Pre/Post edition processing
 * Add index reconstruction
 * Add new query request
 * Add fuzzy search
 * Add new contribution administration
 * Add xsl transformation volume
 *
 * Revision 1.1.4.1  2005/08/31 15:01:39  serasset
 * Applied modifications done on the LEXALP_1_0 branch to updated sources of the
 * trunk to create a new updated LEXALP_1_1 branch.
 *
 * Revision 1.1.2.2  2005/07/22 13:28:32  serasset
 * Modified EditEntryInit for Lexalp. It now serves as a main page for db maintenance.
 * Added a function to get url for QueryParameter.
 * Modified the way xslsheets are handled in order to allow several xslsheet with the same name, different dicts.
 *
 * Revision 1.1.2.1  2005/07/21 12:37:43  serasset
 * Added flags for new legal systems
 * AdvancedSearch now does not query the db when no parameter is given.
 *
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
import com.lutris.dods.builder.generator.query.QueryBuilder;


import fr.imag.clips.papillon.business.message.MessageDBLoader;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.presentation.QueryParameter;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.Volume;
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
import java.util.ArrayList;

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
        
        //
        AdvancedSearchXHTML doc = (AdvancedSearchXHTML) MultilingualXHtmlTemplateFactory.createTemplate("AdvancedSearchXHTML", this.myComms, this.sessionData);
        AdvancedQueryForm qf = new AdvancedQueryForm(this.getComms(), this.getSessionData(), true);

        //
        QueryRequest queryReq = qf.getQueryRequest();
        
        // no search criteria
        if (!queryReq.isEmpty()) {
            /*
             QueryCriteria criteriaStatus = new QueryCriteria();
             criteriaStatus.add("key", "=", Volume.CDM_contributionStatus);
             // FIXME: depend on user ?
             criteriaStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.FINISHED_STATUS);
             queryReq.addCriteria(criteriaStatus);
             */
            
            ArrayList listStatus = new ArrayList();
            
            QueryCriteria criteriaFinishedStatus = new QueryCriteria();
            criteriaFinishedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
            criteriaFinishedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.FINISHED_STATUS);
            listStatus.add(criteriaFinishedStatus);
            
            QueryCriteria criteriaModifiedStatus = new QueryCriteria();
            criteriaModifiedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);
            criteriaModifiedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.MODIFIED_STATUS);
            listStatus.add(criteriaModifiedStatus);
            
            queryReq.addOrCriteriaList(listStatus);
            
            /*
             QueryParameter qp = qf.getQueryParameter();
             // Restrict query to not deleted entries
             String[] validatedCriteria = new String[4];
             validatedCriteria[0] = Volume.CDM_contributionStatus;
             validatedCriteria[1] = null;
             validatedCriteria[2] = VolumeEntry.DELETED_STATUS;
             validatedCriteria[3] = QueryBuilder.NOT_EQUAL;
             qp.getCriteria().add(validatedCriteria);
             */
            
            // Display query result if no action on form (add ou remove criteria)
            if ( !qf.actionOnFormRequested() ) { 
                //if (!qf.actionOnFormRequested() || qp.getCriteria().size() != 0) {
                
                // Perform the request
                Collection qrset = queryReq.findLexieAndTranslation(this.getUser());
                //Collection qrset = DictionariesFactory.doQuery(qp, this.getUser());
                
                // Display result
                XHTMLElement entryNode = doc.getElementResultEntry();
                entryNode.removeAttribute("id");
                doc.setTextNbResults(Integer.toString(qrset.size()));
                Iterator iter = qrset.iterator();
                while(iter.hasNext()) {
                    QueryResult qr = (QueryResult) iter.next();
                    ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, queryReq.getXsl(), ResultFormatterFactory.XHTML_DIALECT, null);
                    Utility.removeChildNodes(entryNode);
                    Node entryDOM = (Node)rf.getFormattedResult(qr, this.getUser());
                    entryNode.appendChild(doc.importNode(entryDOM, true));
                    entryNode.getParentNode().insertBefore(entryNode.cloneNode(true), entryNode);
                } 
                entryNode.getParentNode().removeChild(entryNode);  
                }
            }
        
        //
        XHTMLElement formHolder = doc.getElementQueryForm();
        formHolder.appendChild(doc.importNode(qf.getQueryFormNode("AdvancedSearch.po"), true));
        
        return doc.getElementAdvancedSearchPage();
    }

}

