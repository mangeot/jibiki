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
 * Revision 1.10  2007/01/05 12:57:49  fbrunet
 * Add undo draft method (bug in EditEntry.java : undo after last finish contribution)
 * Modify transformation method
 *
 * Revision 1.9  2006/12/13 09:32:00  fbrunet
 * *** empty log message ***
 *
 * Revision 1.8  2006/08/10 22:17:13  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 * Revision 1.7  2006/06/19 15:27:01  fbrunet
 * Jibiki : improvement of the search result display
 * Lexalp : add help menu (link to wiki and bug tracker)
 *
 * Revision 1.6  2006/06/06 09:15:10  fbrunet
 * Bug correction : view action in advanced search page if user is registered.
 *
 * Revision 1.5  2006/06/01 22:05:05  fbrunet
 * New interface, quick search, new contribution management (the first edition not create new contribution. New contribution is created after add, remove element, update, save, etc. in the interface window)
 *
 * Revision 1.4  2006/05/22 22:45:54  fbrunet
 * LexALP: add merge method in post-save processing (merge axies with same referenced lexies)
 *
 * Revision 1.3  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
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
    protected final static String Action = "action";
   
    protected static Node createNodeResult (HttpPresentationComms comms, PapillonSessionData sessionData, String url, User user, Collection qrset, QueryParameter qp, boolean viewActions)  
    throws  HttpPresentationException,
            java.io.UnsupportedEncodingException,
            java.io.IOException,
        fr.imag.clips.papillon.business.PapillonBusinessException {
            
            //
            ViewQueryResultXHTML content = (ViewQueryResultXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ViewQueryResultXHTML", comms, sessionData);
            
            // Entry
            XHTMLElement entryNode = content.getElementEntryNode();
            XHTMLElement contributionNode = content.getElementContributionNode();
            XHTMLElement actionsNode = content.getElementActionsNode();
            
            // Actions
            XHTMLAnchorElement editAnchor = content.getElementEditEntryAnchor();
            XHTMLAnchorElement duplicateAnchor = content.getElementDuplicateEntryAnchor();
            XHTMLAnchorElement deleteAnchor = content.getElementDeleteEntryAnchor();
            XHTMLAnchorElement undeleteAnchor = content.getElementUndeleteEntryAnchor();
            XHTMLAnchorElement ViewHistoryEntryAnchor = content.getElementViewHistoryEntryAnchor();
            XHTMLAnchorElement viewXmlAnchor = content.getElementViewXmlAnchor();

            //
            XHTMLAnchorElement previousAnchorTop = content.getElementPreviousAnchorTop();
            XHTMLAnchorElement nextAnchorTop = content.getElementNextAnchorTop();
            XHTMLAnchorElement previousAnchorBottom = content.getElementPreviousAnchorBottom();
            XHTMLAnchorElement nextAnchorBottom = content.getElementNextAnchorBottom();
            XHTMLSpanElement entryAuthor = content.getElementEntryAuthor();
            XHTMLSpanElement entryStatus = content.getElementEntryStatus();
            
            // remove ID
            entryNode.removeAttribute("id");
            contributionNode.removeAttribute("id");
            actionsNode.removeAttribute("id");
            editAnchor.removeAttribute("id");
            duplicateAnchor.removeAttribute("id");
            deleteAnchor.removeAttribute("id");
            undeleteAnchor.removeAttribute("id");
            ViewHistoryEntryAnchor.removeAttribute("id");
            viewXmlAnchor.removeAttribute("id");
            previousAnchorTop.removeAttribute("id");
            nextAnchorTop.removeAttribute("id");
            previousAnchorBottom.removeAttribute("id");
            nextAnchorBottom.removeAttribute("id");
            entryAuthor.removeAttribute("id");
            entryStatus.removeAttribute("id");
            
            // init
            Text textAuthor = content.createTextNode("unknown");
            entryAuthor.appendChild(textAuthor);
            Text textStatus = content.createTextNode("unknown");
            entryStatus.appendChild(textStatus);
             
            // remove action list
            if (!viewActions) {
                actionsNode.getParentNode().removeChild(actionsNode);
            }
            
            // Set result number
            content.setTextNbResults(Integer.toString(qrset.size()));
            
            
            // Create display
            Node parentNode = contributionNode.getParentNode();
            for (Iterator iter = qrset.iterator(); iter.hasNext();) {
                
                // FIXME: create a original template AND tempory template 
                // -> don't set attribute class here (setAttribute("class","action")), only if jibiki hidden anchor (setAttribute("class","hidden"))
                // use NAME (like AdminXslTmplXHTML.NAME_defaultxsl) and duplicate node !
                
                //
                QueryResult qr = (QueryResult) iter.next();
                VolumeEntry myEntry = qr.getSourceEntry();  
                //System.out.println("ViewQueryResult : " + qp.getXsl());
                ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, qp.getXsl(), ResultFormatterFactory.XHTML_DIALECT, null);
                Utility.removeChildNodes(entryNode);
                Node entryDOM = (Node)rf.getFormattedResult(qr, user);
                entryNode.appendChild(content.importNode(entryDOM, true));
                entryNode.setAttribute("class", "entry");
                
                //
                if (viewActions) {
                    textAuthor.setNodeValue(myEntry.getModificationAuthor());
                    
                    // Status
                    if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
                        textStatus.setNodeValue(VolumeEntry.FINISHED_STATUS);
                        
                        if ( myEntry.getModificationAuthor().equals(user.getLogin())) {
                            entryNode.setAttribute("class", "myFinishedEntry");
                        } else {
                            entryNode.setAttribute("class", "finishedEntry");
                        }
                        
                    } else if ( myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS) ) {
                        textStatus.setNodeValue("under edition");
                        entryNode.setAttribute("class", "modifiedEntry");
                    
                    } else if ( myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                        textStatus.setNodeValue(VolumeEntry.DELETED_STATUS);
                        entryNode.setAttribute("class", "modifiedEntry");
                        
                    } else if ( myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) ) {
                        
                        if ( myEntry.getModificationAuthor().equals(user.getLogin()) ) {
                            textStatus.setNodeValue("proceed edition");
                            entryNode.setAttribute("class", "myNotFinishedEntry");
                        } else {
                            textStatus.setNodeValue("under edition");
                            entryNode.setAttribute("class", "notFinishedEntry");
                        }
                        
                    }
                    
                    
                    /*
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
                     }*/
                    
                    //
                    String href = url + "?"
                    + EditEntryInitFactory.VOLUME_PARAMETER + "="
                    + myEntry.getVolumeName() + "&"
                    + EditEntryInitFactory.HANDLE_PARAMETER + "="
                    + myEntry.getEntryId() + "&"
                    + EditEntryInitFactory.ACTION_PARAMETER + "=";
                    
                    // Actions
                    if ( (   (  !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) 
                                && (!myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS)) )
                         
                         ||  ( myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)
                               && (myEntry.getModificationAuthor().equals(user.getLogin())
                                   || user.isInGroup(Group.ADMIN_GROUP)))
                         ) {
                        
                        // Edit button
                        if ( !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                            editAnchor.setHref(href + "edit");
                            editAnchor.setAttribute("target","_blank");
                            editAnchor.setAttribute("class","action");
                        } else {
                            editAnchor.setHref("");
                            editAnchor.setAttribute("class","hidden");
                        }
                        
                        // Duplicate button
                        if ( !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)
                             && !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                            duplicateAnchor.setHref(href + "duplicate");
                            duplicateAnchor.setAttribute("target","_blank");
                            duplicateAnchor.setAttribute("class","action");
                        } else {
                            duplicateAnchor.setHref("");
                            duplicateAnchor.setAttribute("class","hidden");
                        }
                        
                        // Delete button
                        if (    !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                                //&& !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                            
                            // action delete and refresh query with last parameters
                            deleteAnchor.setHref(href + "delete" + "&" + AdvancedQueryForm.getEncodedUrlForParameter(qp));
                            deleteAnchor.setAttribute("class","action");
                        } else {
                            deleteAnchor.setHref("");
                            deleteAnchor.setAttribute("class","hidden");
                        }
                        
                        // Undelete button
                        if ( myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                            
                            // action undelete and refresh query with last parameters
                            undeleteAnchor.setHref(href + "undelete" + "&" + AdvancedQueryForm.getEncodedUrlForParameter(qp));
                            undeleteAnchor.setAttribute("class","action");
                            undeleteAnchor.setAttribute("target","_blank");
                        } else {
                            undeleteAnchor.setHref("");
                            undeleteAnchor.setAttribute("class","hidden");
                        }
                        
                    } else {
                        // Edit button
                        editAnchor.setHref("");
                        editAnchor.setAttribute("class","hidden");
                        
                        // Duplicate button
                        duplicateAnchor.setHref("");
                        duplicateAnchor.setAttribute("class","hidden");
                        
                        // Delete button
                        deleteAnchor.setHref("");
                        deleteAnchor.setAttribute("class","hidden");
                        
                        // Undelete button
                        undeleteAnchor.setHref("");
                        undeleteAnchor.setAttribute("class","hidden");
                    }
                    
                    
                    // History view
                    // FIXME: Create static variable ... VolumeName and EntryHandle ... 
                    ViewHistoryEntryAnchor.setHref(HistoryURL + "?" + "VolumeName" + "=" + myEntry.getVolumeName() + "&" + "EntryHandle" + "=" + myEntry.getHandle());
                    ViewHistoryEntryAnchor.setAttribute("class","action");
                    
                    // XML view
                    if (user.isInGroup(Group.ADMIN_GROUP)) {
                        
                        // FIXME : create new page.po like history
                        QueryParameter qpxml = new QueryParameter();
                        qpxml.setXsl("XML");
                        ArrayList dicts = new ArrayList();
                        dicts.add(myEntry.getDictionary());
                        qpxml.setDictionaries(dicts);
                        ArrayList crit = new ArrayList();
                        String[] idc = new String[4];
                        idc[0] = Volume.CDM_entryId;
                        idc[1] = null;
                        idc[2] = myEntry.getEntryId(); 
                        idc[3] = QueryCriteria.EQUAL;
                        crit.add(idc);
                        qpxml.setCriteria(crit);
                        
                        //
                        viewXmlAnchor.setHref(url + "?" + EditEntryInitFactory.ACTION_PARAMETER + "=lookup&" + AdvancedQueryForm.getEncodedUrlForParameter(qpxml));
                        viewXmlAnchor.setAttribute("class","action");
                        
                    } else {
                        viewXmlAnchor.setAttribute("class","hidden");
                    }
                }
                    
                //
                XHTMLElement cloneContribution = (XHTMLElement)contributionNode.cloneNode(true);
                // we have to take off the id attribute because we did not take it off the original
                cloneContribution.removeAttribute("id");
                parentNode.appendChild(cloneContribution);
                //entryNode.getParentNode().insertBefore(entryNode.cloneNode(true), entryNode);
            }
            
            // the previous button
            if ( qp.getOffset() != 0 ) {

                // ATTENTION NO DEEP COPY in QueryParameter duplicate method
                QueryParameter previousQp = (QueryParameter) qp.duplicate();
                previousQp.setOffset(qp.getOffset() - qp.getLimit());
                // Top
                previousAnchorTop.setHref(url + "?" + EditEntryInitFactory.ACTION_PARAMETER + "=lookup&" + AdvancedQueryForm.getEncodedUrlForParameter(previousQp));
                previousAnchorTop.setAttribute("class","pagination");
                // Bottom
                previousAnchorBottom.setHref(url + "?" + EditEntryInitFactory.ACTION_PARAMETER + "=lookup&" + AdvancedQueryForm.getEncodedUrlForParameter(previousQp));
                previousAnchorBottom.setAttribute("class","pagination");
                
            } else {
                
                // Top
                previousAnchorTop.setHref("");
                previousAnchorTop.setAttribute("class","hidden");
                // Bottom
                previousAnchorBottom.setHref("");
                previousAnchorBottom.setAttribute("class","hidden");
            }
            
            // the next button
            if ( qrset.size() >= qp.getLimit() ) {
                
                QueryParameter nextQp = (QueryParameter) qp.duplicate();
                nextQp.setOffset(qp.getOffset() + qp.getLimit());
                // Top
                nextAnchorTop.setHref(url + "?" + EditEntryInitFactory.ACTION_PARAMETER + "=lookup&" + AdvancedQueryForm.getEncodedUrlForParameter(nextQp));
                nextAnchorTop.setAttribute("class","pagination");
                // Bottom
                nextAnchorBottom.setHref(url + "?" + EditEntryInitFactory.ACTION_PARAMETER + "=lookup&" + AdvancedQueryForm.getEncodedUrlForParameter(nextQp));
                nextAnchorBottom.setAttribute("class","pagination");
                
            } else {
                
                // Top
                nextAnchorTop.setHref("");
                nextAnchorTop.setAttribute("class","hidden");
                // Bottom
                nextAnchorBottom.setHref("");
                nextAnchorBottom.setAttribute("class","hidden");
            }
            
            
            //
            parentNode.removeChild(contributionNode);
            //removeEntryListTemplate(content);
            
            //
            XHTMLElement queryResultForm = content.getElementQueryResultForm();
            queryResultForm.removeAttribute("id");
            return queryResultForm;
        }
/*
private static void removeEntryListTemplate(ViewQueryResultXHTML content) {
    Element myElement = content.getElementEntryListRow();
    Node myParent = myElement.getParentNode();
    if (myParent != null)
        myParent.removeChild(myElement);
}
*/
}
