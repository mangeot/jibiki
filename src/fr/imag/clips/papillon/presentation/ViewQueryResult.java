/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Francis Brunet-Manquat - GETA CLIPS IMAG
 * Projet Jibiki
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2006/04/24 13:50:37  fbrunet
 * *** empty log message ***
 *
 * Revision 1.1  2006/04/24 13:43:29  fbrunet
 * Add new class ViewQueryResult : allow to use one class to create result display in advancedSearch and EditEntryInit (like advancedQueryForm)
 * Improve result display : view n results per page
 */

package fr.imag.clips.papillon.presentation;

//General java imports
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.ArrayList;

// DOM imports
import org.w3c.dom.html.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.enhydra.xml.xhtml.dom.*;

// Enhydra SuperServlet imports
import fr.imag.clips.papillon.presentation.xhtml.orig.ViewQueryResultXHTML;
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import javax.servlet.http.HttpServletRequest;


//local imports
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.QueryRequest;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;
import fr.imag.clips.papillon.business.dictionary.QueryParameter;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.user.Group;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;



public class ViewQueryResult {

    protected final static String EditEntryInitURL = "LexalpEditEntryInit.po";
    protected final static String HistoryURL = "History.po";
   
    protected static Node createNodeResult (HttpPresentationComms comms, PapillonSessionData sessionData, String url, User user, Collection qrset, QueryParameter qp)  
    throws  HttpPresentationException,
            java.io.UnsupportedEncodingException,
            java.io.IOException,
            fr.imag.clips.papillon.business.PapillonBusinessException {
        
        //
        ViewQueryResultXHTML content = (ViewQueryResultXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ViewQueryResultXHTML", comms, sessionData);
        
        //
        XHTMLElement entryNode = content.getElementEntryNode();
        HTMLTableRowElement entryListRow = content.getElementEntryListRow();
        HTMLElement authorElement = content.getElementEntryAuthorList();
        HTMLAnchorElement editAnchor = content.getElementEditEntryAnchor();
        HTMLAnchorElement duplicateAnchor = content.getElementDuplicateEntryAnchor();
        HTMLAnchorElement deleteAnchor = content.getElementDeleteEntryAnchor();
        HTMLAnchorElement undeleteAnchor = content.getElementUndeleteEntryAnchor();
        HTMLAnchorElement ViewHistoryEntryAnchor = content.getElementViewHistoryEntryAnchor();
        HTMLAnchorElement viewXmlAnchor = content.getElementViewXmlAnchor();
        HTMLAnchorElement previousAnchor = content.getElementPreviousAnchor();
        HTMLAnchorElement nextAnchor = content.getElementNextAnchor();
        HTMLElement underEdition = content.getElementUnderEdition();
        HTMLElement proceedEdition = content.getElementProceedEdition();
        //HTMLAnchorElement entryIdAnchor = content.getElementViewEntryAnchor();
        //HTMLElement headwordElement = content.getElementHeadwordList();
        //HTMLElement posElement = content.getElementPosList();
        //HTMLElement editElement = content.getElementEditMessage();
        //HTMLElement copyElement = content.getElementCopyMessage();
        
        /*
        XHTMLElement entryNode = (XHTMLElement) contentParameters.get(EditEntryInitFactory.entryNode);
        HTMLTableRowElement entryListRow = (HTMLTableRowElement) contentParameters.get(EditEntryInitFactory.entryListRow);
        HTMLElement authorElement = (HTMLElement) contentParameters.get(EditEntryInitFactory.authorElement);
        HTMLAnchorElement editAnchor = (HTMLAnchorElement) contentParameters.get(EditEntryInitFactory.editAnchor);
        HTMLAnchorElement duplicateAnchor = (HTMLAnchorElement) contentParameters.get(EditEntryInitFactory.duplicateAnchor);
        HTMLAnchorElement deleteAnchor = (HTMLAnchorElement) contentParameters.get(EditEntryInitFactory.deleteAnchor);
        HTMLAnchorElement undeleteAnchor = (HTMLAnchorElement) contentParameters.get(EditEntryInitFactory.undeleteAnchor);
        HTMLAnchorElement ViewHistoryEntryAnchor = (HTMLAnchorElement) contentParameters.get(EditEntryInitFactory.ViewHistoryEntryAnchor);
        HTMLAnchorElement viewXmlAnchor = (HTMLAnchorElement) contentParameters.get(EditEntryInitFactory.viewXmlAnchor);
        HTMLElement underEdition = (HTMLElement) contentParameters.get(EditEntryInitFactory.underEdition);
        HTMLElement proceedEdition = (HTMLElement) contentParameters.get(EditEntryInitFactory.proceedEdition);
        //HTMLAnchorElement entryIdAnchor = content.getElementViewEntryAnchor();
        //HTMLElement headwordElement = content.getElementHeadwordList();
        //HTMLElement posElement = content.getElementPosList();            
        //HTMLElement editElement = content.getElementEditMessage();
        //HTMLElement copyElement = content.getElementCopyMessage();
        */
        
        entryNode.removeAttribute("id");
        //entryIdAnchor.removeAttribute("id");
        //headwordElement.removeAttribute("id");
        //posElement.removeAttribute("id");
        editAnchor.removeAttribute("id");
        duplicateAnchor.removeAttribute("id");
        deleteAnchor.removeAttribute("id");
        undeleteAnchor.removeAttribute("id");
        viewXmlAnchor.removeAttribute("id");
        underEdition.removeAttribute("id");
        proceedEdition.removeAttribute("id");
        //editElement.removeAttribute("id");
        //copyElement.removeAttribute("id");
        authorElement.removeAttribute("id");
        
        content.setTextNbResults(Integer.toString(qrset.size()));
        
        Node entryTable = entryListRow.getParentNode();
        
        Iterator iter = qrset.iterator();
        while(iter.hasNext()) {
            QueryResult qr = (QueryResult) iter.next();
            VolumeEntry myEntry = qr.getSourceEntry();             
            ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, qp.getXsl(), ResultFormatterFactory.XHTML_DIALECT, null);
            Utility.removeChildNodes(entryNode);
            Node entryDOM = (Node)rf.getFormattedResult(qr, user);
            entryNode.appendChild(content.importNode(entryDOM, true));
            
            // Edit actions...
            // The entry id
            //String href = ConsultExpertURL + "?"
            // + ConsultExpert.VOLUME_PARAMETER + "="
            // + myEntry.getVolumeName() + "&"
            // + ConsultExpert.HANDLE_PARAMETER + "="
            // + myEntry.getHandle();
            
            //entryIdAnchor.setHref(href);
            
            // the entry id
            //content.setTextEntryIdList(myEntry.getId());
            
            // The pos
            //content.setTextPosList(myEntry.getPos());
            
            // The author
            //content.setTextEntryAuthorList(myEntry.getAuthor());
            content.setTextEntryAuthorList(myEntry.getModificationAuthor());
            
            // The status
            if ( !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) 
                 && !myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS) ) {
                // view status : finished, deleted
                content.setTextEntryStatusList(myEntry.getStatus());
                underEdition.setAttribute("style","display: none;");
                proceedEdition.setAttribute("style","display: none;");
                if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS)
                     && myEntry.getModificationAuthor().equals(user.getLogin()) ) {
                    entryListRow.setAttribute("class", "myContributionTR");
                } else {
                    entryListRow.setAttribute("class", "contributionTR");
                }
                
            } else if ( myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS) ) {
                // view modified status like under edition
                content.setTextEntryStatusList("");
                underEdition.setAttribute("style","display: block;");
                proceedEdition.setAttribute("style","display: none;");
                entryListRow.setAttribute("class", "contributionTR");
                
            } else if ( myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) ) {
                // view not-finished status
                // like proceed edition if my contribution
                // like under edition if not
                if ( myEntry.getModificationAuthor().equals(user.getLogin()) ) {
                    content.setTextEntryStatusList("");
                    underEdition.setAttribute("style","display: none;");
                    proceedEdition.setAttribute("style","display: block;");
                    entryListRow.setAttribute("class", "myProceedContributionTR");
                } else {
                    content.setTextEntryStatusList("");
                    underEdition.setAttribute("style","display: block;");
                    proceedEdition.setAttribute("style","display: none;");
                    entryListRow.setAttribute("class", "contributionTR");
                }
            }
            
            // The edit anchor
            String href = url + "?"
                + EditEntryInitFactory.VOLUME_PARAMETER + "="
                + myEntry.getVolumeName() + "&"
                + EditEntryInitFactory.HANDLE_PARAMETER + "="
                + myEntry.getEntryId() + "&"
                + EditEntryInitFactory.ACTION_PARAMETER + "=";
            
            //
            if ( (   (!myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) 
                     && (!myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS)) )
                 ||  ( myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)
                       && (myEntry.getModificationAuthor().equals(user.getLogin())
                           || user.isInGroup(Group.ADMIN_GROUP)))
                 ) {
                
                // the edit button
                if ( !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                    //if ((myEntry.getAuthor().equals(user.getLogin())
                    //     || user.isInGroup("validator"))
                    //    && !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)) {    
                    editAnchor.setHref(href+"edit");
                    editAnchor.setAttribute("class","");
                    editAnchor.setAttribute("target","_blank");
                    } else {
                        editAnchor.setHref("");
                        editAnchor.setAttribute("class","hidden");
                    }
                
                // the duplicate button
                if ( !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)
                     && !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                    duplicateAnchor.setHref(href+"duplicate");
                    duplicateAnchor.setAttribute("class","");
                    duplicateAnchor.setAttribute("target","_blank");
                } else {
                    duplicateAnchor.setHref("");
                    duplicateAnchor.setAttribute("class","hidden");
                }
                
                // the delete button
                if (    !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)
                        && !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                    //if ((myEntry.getAuthor().equals(user.getLogin())
                    //     || user.isInGroup("validator"))
                    //    && !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)
                    //    && !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                    
                    // action delete and refresh query with last parameters
                    deleteAnchor.setHref(href + "delete" + "&" + AdvancedQueryForm.getEncodedUrlForParameter(qp));
                    //deleteAnchor.setAttribute("class","");
                    deleteAnchor.setAttribute("style","display: block;");
                    } else {
                        deleteAnchor.setHref("");
                        //deleteAnchor.setAttribute("class","hidden");
                        deleteAnchor.setAttribute("style","display: none;");
                    }
                
                // the undelete button
                if ( myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                    //if ( myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)
                    //    && (myEntry.getAuthor().equals(user.getLogin())
                    //        || user.isInGroup("validator"))) {
                    
                    // action undelete and refresh query with last parameters
                    undeleteAnchor.setHref(href + "undelete" + "&" + AdvancedQueryForm.getEncodedUrlForParameter(qp));
                    //undeleteAnchor.setAttribute("class","");
                    undeleteAnchor.setAttribute("style","display: block;");
                    } else {
                        undeleteAnchor.setHref("");
                        //undeleteAnchor.setAttribute("class","hidden");
                        undeleteAnchor.setAttribute("style","display: none;");
                    }
                
                } else {
                    // the edit button
                    editAnchor.setHref("");
                    editAnchor.setAttribute("class","hidden");
                    
                    // the duplicate button
                    duplicateAnchor.setHref("");
                    duplicateAnchor.setAttribute("class","hidden");
                    
                    // the delete button
                    deleteAnchor.setHref("");
                    deleteAnchor.setAttribute("style","display: none;");
                    
                    // the undelete button
                    undeleteAnchor.setHref("");
                    undeleteAnchor.setAttribute("style","display: none;");
                }
            
            
            // view history
            //if (!myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)
            //    && (myEntry.getAuthor().equals(user.getLogin())
            //        || user.isInGroup("validator"))) {
            // FIXME: Create static variable ... VolumeName and EntryHandle ... 
            href = HistoryURL + "?" + "VolumeName" + "=" + myEntry.getVolumeName() + "&" + "EntryHandle" + "=" + myEntry.getHandle();
            ViewHistoryEntryAnchor.setHref(href);
            ViewHistoryEntryAnchor.setAttribute("style","display: block;");
            //} else {
            //    ViewHistoryEntryAnchor.setHref("");
            //     ViewHistoryEntryAnchor.setAttribute("style","display: none;");
            //}
            
            if (user.isInGroup(Group.ADMIN_GROUP)) {
                // The view XML anchor
                // FIXME : create new page.po like history
                QueryParameter qpxml = new QueryParameter();
                qpxml.setXsl("XML");
                String[] dictNames = new String[1];
                dictNames[0] = myEntry.getDictionaryName();
                qpxml.setDictionaryNames(dictNames);
                Vector crit = new Vector();
                String[] idc = new String[4];
                idc[0] = Volume.CDM_entryId;
                idc[1] = null;
                //if (myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)
                //    && myEntry.getModificationAuthor().equals(user.getLogin())) {
                //        idc[2] = myEntry.getClassifiedFinishedContributionId(); 
                //} else {
                idc[2] = myEntry.getEntryId(); 
                //}
                //idc[3] = QueryBuilder.EQUAL;
                idc[3] = QueryCriteria.EQUAL;
                crit.add(idc);
                /*
                 String[] idc = new String[4];
                 idc[0] = Volume.CDM_entryId;
                 idc[1] = null;
                 idc[2] = myEntry.getEntryId();
                 //idc[3] = QueryBuilder.EQUAL;
                 idc[3] = QueryCriteria.EQUAL;
                 crit.add(idc);
                 */
                qpxml.setCriteria(crit);
                
                href = url + "?"
                    + AdvancedQueryForm.getEncodedUrlForParameter(qpxml); 
                
                viewXmlAnchor.setHref(href);
                
            } else {
                
                //
                HTMLElement viewXMLElement = content.getElementViewXML();
                viewXMLElement.setAttribute("style","display: none;");
            }
            
            //
            HTMLElement cloneEntry = (HTMLElement)entryListRow.cloneNode(true);
            // we have to take off the id attribute because we did not take it off the original
            cloneEntry.removeAttribute("id");
            entryTable.appendChild(cloneEntry);
            
            //entryNode.getParentNode().insertBefore(entryNode.cloneNode(true), entryNode);
                }

// the previous button
if ( qp.getOffset() != 0 ) {
    
    //
    QueryParameter previousQp = (QueryParameter) qp.duplicate();
    previousQp.setOffset(qp.getOffset() - qp.getLimit());
    previousAnchor.setHref(url + "?" + AdvancedQueryForm.getEncodedUrlForParameter(previousQp));
    previousAnchor.setAttribute("style","display: inline;");
    
} else {
    
    //
    previousAnchor.setHref("");
    previousAnchor.setAttribute("style","display: none;");
}

// the next button
// FIXME : verify limit and qrest results ... but qrest of multiple volumes
if ( true ) {
    
    //
    QueryParameter nextQp = (QueryParameter) qp.duplicate();
    nextQp.setOffset(qp.getOffset() + qp.getLimit());
    nextAnchor.setHref(url + "?" + AdvancedQueryForm.getEncodedUrlForParameter(nextQp));
    nextAnchor.setAttribute("style","display: inline;");

} else {
    
    //
    nextAnchor.setHref("");
    nextAnchor.setAttribute("style","display: none;");
}


//
entryNode.getParentNode().removeChild(entryNode);
removeEntryListTemplate(content);

return content.getElementQueryResultForm();
                }

private static void removeEntryListTemplate(ViewQueryResultXHTML content) {
    Element myElement = content.getElementEntryListRow();
    Node myParent = myElement.getParentNode();
    if (myParent != null)
        myParent.removeChild(myElement);
}

}
