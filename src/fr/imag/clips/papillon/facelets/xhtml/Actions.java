/*
 *  Jibiki plateform
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1.2.1  2007/07/23 14:23:50  serasset
 * Commiting most changes done for the XALAN27_NEWDISPLAY on the branch
 *  - Added XSL extensions callable during xsl transformations
 *  - Implemented new display of query results as requested by EURAC team
 *  - Modified edition interface generator to adapt it to xalan 2.7.0
 *  - Added autocompletion feature to simple search fields
 *  - Moved some old pages to "deprecated" folder (this will forbid direct use of this code for papillon/GDEF)
 *
 *
 */
package fr.imag.clips.papillon.facelets.xhtml;

import java.util.Collection;
import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.enhydra.xml.xhtml.dom.*;

import fr.imag.clips.papillon.presentation.xhtml.orig.ActionNodesXHTML;
import fr.imag.clips.papillon.presentation.MultilingualXHtmlTemplateFactory;
import fr.imag.clips.papillon.CurrentRequestContext;
import fr.imag.clips.papillon.facelets.util.JibikiContext;

import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;

import fr.imag.clips.papillon.business.PapillonBusinessException;

import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.PapillonPivotFactory;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.QueryParameter;
import fr.imag.clips.papillon.business.dictionary.QueryCriteria;

import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.EditEntryInitFactory;
import fr.imag.clips.papillon.presentation.AdvancedQueryForm;
import fr.imag.clips.papillon.presentation.PapillonSessionData;

import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.user.Group;


// import org.apache.xalan.xslt.*;

public class Actions implements fr.imag.clips.papillon.facelets.api.Actions {
    protected final static String HistoryURL = "History.po";
    protected final static String Action = "action";
    
    public Actions() {
        
    }
    
    public Node getActions(String entryid) throws PapillonBusinessException {
        JibikiContext context = CurrentRequestContext.get();
        
        // FIXME: This will be long enough... We really need to work on caching and multiple volume handling (maybe an explicit id...)
       PapillonLogger.writeDebugMsg("Pourquoi on refait une requête pour chercher l'entrée ???");
		 VolumeEntry ve = VolumeEntriesFactory.findEntryByEntryId(((PapillonSessionData) context.get("sessionData")).getUser(),entryid);
        return this.getActions(ve);
    }
    
    public Node getActions(VolumeEntry myEntry) throws PapillonBusinessException {
        
        // I need a context object that will contain the comms and sessionData...
        JibikiContext context = CurrentRequestContext.get();
        PapillonSessionData sdata = (PapillonSessionData) context.get("sessionData");
        HttpPresentationComms scomms = (HttpPresentationComms) context.get("comms");

        User user = (null == sdata) ? null : sdata.getUser();

        String url = (String) context.get("url");
        
        ActionNodesXHTML content;
        try {
            content = (ActionNodesXHTML) 
            MultilingualXHtmlTemplateFactory.createTemplate("ActionNodesXHTML", scomms, sdata);
        } catch (HttpPresentationException e) {
            throw new PapillonBusinessException("Fail to instanciate XHTML Action Node Template.", e);
        }
        
        XHTMLElement actionsNode = content.getElementActionsNode();
        // Actions
        XHTMLAnchorElement editAnchor = content.getElementEditEntryAnchor();
        XHTMLAnchorElement duplicateAnchor = content.getElementDuplicateEntryAnchor();
        XHTMLAnchorElement deleteAnchor = content.getElementDeleteEntryAnchor();
        XHTMLAnchorElement undeleteAnchor = content.getElementUndeleteEntryAnchor();
        XHTMLAnchorElement viewAxieAnchor = content.getElementViewAxieAnchor();
        XHTMLAnchorElement viewHistoryEntryAnchor = content.getElementViewHistoryEntryAnchor();
        XHTMLAnchorElement viewXmlAnchor = content.getElementViewXmlAnchor();
        XHTMLSpanElement entryAuthor = content.getElementEntryAuthor();
        XHTMLSpanElement entryStatus = content.getElementEntryStatus();
        XHTMLSpanElement entryGroups = content.getElementEntryGroups();
        
        actionsNode.removeAttribute("id");
        editAnchor.removeAttribute("id");
        duplicateAnchor.removeAttribute("id");
        deleteAnchor.removeAttribute("id");
        undeleteAnchor.removeAttribute("id");
        viewAxieAnchor.removeAttribute("id");
        viewHistoryEntryAnchor.removeAttribute("id");
        viewXmlAnchor.removeAttribute("id");
        entryAuthor.removeAttribute("id");
        entryStatus.removeAttribute("id");
        entryGroups.removeAttribute("id");
        
        // init
		String level = Utility.getStars(myEntry.getGroups());
        Text textGroup = content.createTextNode(level);
        entryGroups.appendChild(textGroup);

        Text textAuthor = content.createTextNode("unknown");
        entryAuthor.appendChild(textAuthor);
        Text textStatus = content.createTextNode("unknown");
        entryStatus.appendChild(textStatus);
		
        textAuthor.setNodeValue(myEntry.getModificationAuthor());

        // Status
        if (myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS)) {
            textStatus.setNodeValue(VolumeEntry.FINISHED_STATUS);
            
            //            if (myEntry.getModificationAuthor().equals(user.getLogin())) {
            //                entryNode.setAttribute("class", "myFinishedEntry");
            //            } else {
            //                entryNode.setAttribute("class", "finishedEntry");
            //            }
            
        } else if (myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS)) {
            textStatus.setNodeValue("under edition");
            //            entryNode.setAttribute("class", "modifiedEntry");
            
        } else if (myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)) {
            textStatus.setNodeValue(VolumeEntry.DELETED_STATUS);
            //            entryNode.setAttribute("class", "modifiedEntry");
            
        } else if (myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
            
            if (myEntry.getModificationAuthor().equals(user.getLogin())) {
                textStatus.setNodeValue("proceed edition");
                //                entryNode.setAttribute("class", "myNotFinishedEntry");
            } else {
                textStatus.setNodeValue("under edition");
                //                entryNode.setAttribute("class", "notFinishedEntry");
            }
        }
        
        //
        String href = url + "?"
            + EditEntryInitFactory.VOLUME_PARAMETER + "="
            + myEntry.getVolumeName() + "&"
            + EditEntryInitFactory.HANDLE_PARAMETER + "="
            + myEntry.getHandle() + "&"
            + EditEntryInitFactory.ACTION_PARAMETER + "=";
        
        // Actions
        if (((!myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS))
             && (!myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS)))
            
            || (myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)
                && (myEntry.getModificationAuthor().equals(user.getLogin())
                    || user.isInGroup(Group.ADMIN_GROUP)))
            ) 
        {
            
            // Edit button
            if (!myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)) {
                editAnchor.setHref(href + "edit");
                editAnchor.setAttribute("target", "_blank");
                editAnchor.setAttribute("class", "action");
            } else {
                editAnchor.setHref("");
                editAnchor.setAttribute("class", "hidden");
            }
            
            // Duplicate button
            if (!myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)
                && !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                duplicateAnchor.setHref(href + "duplicate");
                duplicateAnchor.setAttribute("target", "_blank");
                duplicateAnchor.setAttribute("class", "action");
            } else {
                duplicateAnchor.setHref("");
                duplicateAnchor.setAttribute("class", "hidden");
            }
            
            // Delete button
            if (!myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)) {
                //&& !myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) {
                
                // action delete and refresh query with last parameters
                deleteAnchor.setHref(href + "delete");
                deleteAnchor.setAttribute("class", "action");
                } else {
                    deleteAnchor.setHref("");
                    deleteAnchor.setAttribute("class", "hidden");
                }
            
            // Undelete button
            if (myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)) {
                
                // action undelete and refresh query with last parameters
                undeleteAnchor.setHref(href + "undelete");
                undeleteAnchor.setAttribute("class", "action");
                undeleteAnchor.setAttribute("target", "_blank");
            } else {
                undeleteAnchor.setHref("");
                undeleteAnchor.setAttribute("class", "hidden");
            }
            
        } else {
            // Edit button
            editAnchor.setHref("");
            editAnchor.setAttribute("class", "hidden");
            
            // Duplicate button
            duplicateAnchor.setHref("");
            duplicateAnchor.setAttribute("class", "hidden");
            
            // Delete button
            deleteAnchor.setHref("");
            deleteAnchor.setAttribute("class", "hidden");
            
            // Undelete button
            undeleteAnchor.setHref("");
            undeleteAnchor.setAttribute("class", "hidden");
        }
        
        // History view
        // FIXME: Create static variable ... VolumeName and EntryHandle ...
        viewHistoryEntryAnchor.setHref(HistoryURL + "?" + "VolumeName" + "=" + myEntry.getVolumeName() + "&" + "EntryHandle" + "=" + myEntry.getHandle());
        viewHistoryEntryAnchor.setAttribute("class", "action");


        if (! "axi".equals(myEntry.getVolume().getSourceLanguage())) {
            Collection axies = PapillonPivotFactory.findAxiesByLexie(myEntry, user);
            if (axies != null && axies.size() > 0) {
                // FIXME: Only view ONE axie... we should consider changing the API for it to return only one
                VolumeEntry myAxie = (VolumeEntry) axies.iterator().next();

                // View axie
                QueryParameter qpaxie = new QueryParameter();
                qpaxie.setXsl("Default");
                ArrayList adicts = new ArrayList();
                adicts.add(myEntry.getDictionary());
                qpaxie.setDictionaries(adicts);
                ArrayList acrit = new ArrayList();
                String[] axiec = new String[4];
                axiec[0] = Volume.CDM_entryId;
                axiec[1] = null;
                axiec[2] = myAxie.getEntryId();
                axiec[3] = QueryCriteria.EQUAL;
                acrit.add(axiec);
                qpaxie.setCriteria(acrit);
                viewAxieAnchor.setHref(
                        url + "?" + EditEntryInitFactory.ACTION_PARAMETER + "=lookup&" + AdvancedQueryForm.getEncodedUrlForParameter(
                                qpaxie));
                viewAxieAnchor.setAttribute("class", "action");
            } else {
                viewAxieAnchor.setHref("");
                viewAxieAnchor.setAttribute("class", "hidden");
            }
        } else {
                viewAxieAnchor.setHref("");
                viewAxieAnchor.setAttribute("class", "hidden");
        }
        
        // XML view
        if (user != null && user.isInGroup(Group.ADMIN_GROUP)) {

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
            viewXmlAnchor.setAttribute("class", "action");
            
        } else {
            viewXmlAnchor.setAttribute("class", "hidden");
        }
        
        return actionsNode;
    }
        
    
}