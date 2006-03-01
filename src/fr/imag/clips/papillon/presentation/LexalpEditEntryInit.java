/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 * © Mathieu Mangeot - GETA CLIPS IMAG
 * Projet Papillon
 *
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.1.4.6  2006/02/17 10:41:49  fbrunet
 * Change QueryCriteria parameters
 * Add new windows when editing an entry
 *
 * Revision 1.1.4.5  2006/01/25 16:51:46  fbrunet
 * *** empty log message ***
 *
 * Revision 1.1.4.4  2006/01/25 15:22:23  fbrunet
 * Improvement of QueryRequest
 * Add new search criteria
 * Add modified status
 *
 * Revision 1.1.4.3  2006/01/24 13:39:49  fbrunet
 * Modification view management
 * Modification LexALP postprocessing
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
 * Revision 1.1.2.1  2005/07/22 13:28:32  serasset
 * Modified EditEntryInit for Lexalp. It now serves as a main page for db maintenance.
 * Added a function to get url for QueryParameter.
 * Modified the way xslsheets are handled in order to allow several xslsheet with the same name, different dicts.
 *
 *
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
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

import com.lutris.dods.builder.generator.query.QueryBuilder;

// HTML source import
import fr.imag.clips.papillon.presentation.xhtmllexalp.orig.*;

//local imports
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.transformation.*;



public class LexalpEditEntryInit extends PapillonBasePO {
    
    protected final static String HANDLE_PARAMETER = "handle";
    protected final static String ACTION_PARAMETER = "action";

    protected final static String ContributionsURL = "AdminContributions.po";
    protected final static String ContributionsVolumeParameter = "VOLUME";
    
    protected final static String ConsultExpertURL = "AdvancedSearch.po";
    protected final static String ConsultExpertVolumeParameter = "VOLUME";
    protected final static String ConsultExpertHandleParameter = "handle";
    protected final static String ConsultExpertFormatterParameter = "xslid";
    protected final static String EditEntryURL = "EditEntry.po";
    protected final static String EditingErrorURL = "EditingError.po";
    
    /*
    protected final static int STEP_INIT = 1;
    protected final static int STEP_LOOKUP_EDIT = 2;
    protected final static int STEP_CREATE = 3;
    protected final static int STEP_EDIT = 4;
    */
    protected LexalpEditEntryInitXHTML content;
    
    protected boolean loggedInUserRequired() {
        return true;
    }
    
    protected boolean userMayUseThisPO() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }
    
    public Node getContent()
        throws HttpPresentationException,
        java.io.UnsupportedEncodingException,
        java.io.IOException,
        fr.imag.clips.papillon.business.PapillonBusinessException {
            
            // Content creation
            content = (LexalpEditEntryInitXHTML)MultilingualXHtmlTemplateFactory.createTemplate("fr.imag.clips.papillon.presentation.xhtmllexalp", "LexalpEditEntryInitXHTML", this.getComms(), this.getSessionData());
            // On regarde d'abord les parametres qui nous sont demandes.
            String submitCreate = myGetParameter(content.NAME_CreateAnyway);		
            String volume = myGetParameter(content.NAME_VOLUME);
            String headword = myGetParameter(content.NAME_Headword);
            String entryHandle = myGetParameter(HANDLE_PARAMETER);
            String action = myGetParameter(ACTION_PARAMETER);		

            //
            System.out.println("Action " + action);
            System.out.println("submitCreate " + submitCreate);
            System.out.println("headword " + headword);
            
            // ??
            if (volume!=null &&!volume.equals("")) {
                this.setPreference(content.NAME_VOLUME,volume);
            } else {
                volume = this.getPreference(content.NAME_VOLUME);
            }
            
            // CREATE NEW ENTRY
            if (submitCreate!=null && !submitCreate.equals("")) {
                if (volume!=null && !volume.equals("") 
                    && headword!=null && !headword.equals("")) {

                    //
                    VolumeEntry myEntry = VolumeEntriesFactory.createEmptyEntry(volume);
                    myEntry.setCreationDate();
                    myEntry.setHeadword(headword);
                    myEntry.setAuthor(this.getUser().getLogin());
                    myEntry.setModification(this.getUser().getLogin(), "Create entry");
                    myEntry.setGroups(this.getUser().getGroupsArray());
                    myEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
                    myEntry.save();
                    String headwordParam = myUrlEncode(headword);
                    throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                          EditEntry.VolumeName_PARAMETER + "=" + volume + 
                                                          "&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
                } else {
                    
                    // Error message
                    this.getSessionData().writeUserMessage("Volumes and Headwords are mandatory for creation");
                }
            }
            
            //
            if (action!=null && !action.equals("")) {
                
                // Search last contribution corresponding to entryId
                VolumeEntry myEntry = VolumeEntriesFactory.findEntryByEntryId(this.getUser(), entryHandle);
                //VolumeEntry myEntry = VolumeEntriesFactory.findEntryByHandle(volume, entryHandle);
                
                
                // EDIT
                if (action.equals("edit")) {
                    
                    // Edit contribution finished
                    if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
                        
                        // Create new contribution with NOT_FINISHED_STATUS
                        VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
                        newEntry.setClassifiedFinishedContribution(myEntry);
                        newEntry.setModification(this.getUser().getLogin(), "create not-finished");
                        newEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
                        newEntry.save();
                        
                        // Old entry modification
                        myEntry.setStatus(VolumeEntry.MODIFIED_STATUS);
                        myEntry.setNextContributionAuthor(this.getUser().getLogin());
                        myEntry.save();
                        
                        //
                        throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                              EditEntry.VolumeName_PARAMETER + "=" + newEntry.getVolumeName() + 
                                                              "&" + EditEntry.EntryHandle_PARAMETER + "=" + newEntry.getHandle());
                        
                    // Edit contribtion not-finished
                    } else if ( myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS) 
                                && myEntry.getModificationAuthor().equals(this.getUser().getLogin()) ) {
                        
                        // Nothing to do
                        throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                              EditEntry.VolumeName_PARAMETER + "=" + myEntry.getVolumeName() + 
                                                              "&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
                        
                    }  else {
                        
                        // Error page
                        throw new ClientPageRedirectException(EditingErrorURL);
                    }
                    
                
                // DUPLICATE
                } else if (action.equals("duplicate")) {
                    
                    //
                    if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
                        
                        //
                        VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
                        newEntry.setEntryId();
                        newEntry.setAuthor(this.getUser().getLogin());
                        newEntry.setGroups(this.getUser().getGroupsArray());
                        newEntry.setContributionId();
                        newEntry.setOriginalContributionId(myEntry.getContributionId());
                        newEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
                        newEntry.setModification(this.getUser().getLogin(), "duplicate");
                        newEntry.setClassifiedFinishedContribution();
                        newEntry.setClassifiedNotFinishedContribution();
                        newEntry.setNextContributionAuthor("");
                        newEntry.save();
                        
                        //
                        throw new ClientPageRedirectException(EditEntryURL + "?" + 
                                                              EditEntry.VolumeName_PARAMETER + "=" + newEntry.getVolumeName() + 
                                                              "&" + EditEntry.EntryHandle_PARAMETER + "=" + newEntry.getHandle());
                    }  else {
                        
                        // Error page
                        throw new ClientPageRedirectException(EditingErrorURL);
                    }
                    
                    
                // DELETE
                } else if (action.equals("delete")) {
                   
                    //
                    if ( myEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) ) {
                        
                        //
                        VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
                        newEntry.setClassifiedFinishedContribution(myEntry);
                        newEntry.setModification(this.getUser().getLogin(), VolumeEntry.DELETED_STATUS);
                        newEntry.setStatus(VolumeEntry.DELETED_STATUS);
                        myEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
                        myEntry.save();
                        newEntry.save();
                        
                    }  else {
                        
                        // Error message
                        this.getSessionData().writeUserMessage("Error deleting " + myEntry.getId());
                    }
                    
                
                // UNDELETE
                } else if (action.equals("undelete")) {
                   
                    //
                    if ( myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                        
                        //
                        VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
                        newEntry.setClassifiedFinishedContribution(myEntry);
                        newEntry.setModification(this.getUser().getLogin(), "undeleted");
                        newEntry.setStatus(VolumeEntry.FINISHED_STATUS);
                        myEntry.setStatus(VolumeEntry.CLASSIFIED_FINISHED_STATUS);
                        myEntry.save();
                        newEntry.save();
                        
                    }  else {
                        
                        // Error message
                        this.getSessionData().writeUserMessage("Error undeleting " + myEntry.getId());
                    }
                }      
            }
            
            //
            updateCreationInterface(volume, headword);
            User myUser = getUser();
            if (null != myUser) {
                content.setTextUserName(myUser.getName());
            }
            
            // Do query !
            AdvancedQueryForm qf = new AdvancedQueryForm(this.getComms(), this.getSessionData());
            
            /*
            //
            QueryRequest queryReq = qf.getQueryRequest();
            
            //
            QueryCriteria criteriaStatus = new QueryCriteria();
            criteriaStatus.add("key", "=", Volume.CDM_contributionStatus);  
            criteriaStatus.add("value", QueryCriteria.NOT_EQUAL, VolumeEntry.CLASSIFIED_FINISHED_STATUS);
            criteriaStatus.add("value", QueryCriteria.NOT_EQUAL, VolumeEntry.CLASSIFIED_NOT_FINISHED_STATUS);
            queryReq.addCriteria(criteriaStatus);
            */
            
            //
            QueryRequest queryReq = new QueryRequest(VolumesFactory.getVolumesArrayName());
            queryReq.setOrTree();   // OR(AND)
            ArrayList criteriaSearchList = qf.getCriteriaList();
                
            
            if ( (criteriaSearchList != null) && (criteriaSearchList.size() != 0) ) {
                //
                ArrayList listFinished = new ArrayList();
                QueryCriteria criteriaFinishedStatus = new QueryCriteria();
                criteriaFinishedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
                criteriaFinishedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.FINISHED_STATUS);
                listFinished.add(criteriaFinishedStatus);
                listFinished.addAll(criteriaSearchList);
                queryReq.addAndCriteriaList(listFinished);
                
                // Group management
                if (!this.getUser().isInGroup()) {
                    //
                    ArrayList listModify = new ArrayList();
                    QueryCriteria criteriaModifiedStatus = new QueryCriteria();
                    criteriaModifiedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
                    criteriaModifiedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.MODIFIED_STATUS);
                    listModify.add(criteriaModifiedStatus);
                    QueryCriteria criteriaNotLogin = new QueryCriteria();
                    criteriaNotLogin.add("key", QueryCriteria.EQUAL, Volume.CDM_nextContributionAuthor);
                    criteriaNotLogin.add("value", QueryCriteria.NOT_EQUAL, this.getUser().getLogin());
                    listModify.add(criteriaNotLogin);
                    listModify.addAll(criteriaSearchList);
                    queryReq.addAndCriteriaList(listModify);
                    
                    //
                    ArrayList listNotFinished = new ArrayList();
                    QueryCriteria criteriaNFStatus = new QueryCriteria();
                    criteriaNFStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
                    criteriaNFStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.NOT_FINISHED_STATUS);
                    listNotFinished.add(criteriaNFStatus);
                    QueryCriteria criteriaLogin = new QueryCriteria();
                    criteriaLogin.add("key", QueryCriteria.EQUAL, Volume.CDM_modificationAuthor);
                    criteriaLogin.add("value", QueryCriteria.EQUAL, this.getUser().getLogin());
                    listNotFinished.add(criteriaLogin);
                    listNotFinished.addAll(criteriaSearchList);
                    queryReq.addAndCriteriaList(listNotFinished);
                } else {
                    //
                    ArrayList listDeleted = new ArrayList();
                    QueryCriteria criteriaDeletedStatus = new QueryCriteria();
                    criteriaDeletedStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
                    criteriaDeletedStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.DELETED_STATUS);
                    listDeleted.add(criteriaDeletedStatus);
                    listDeleted.addAll(criteriaSearchList);
                    queryReq.addAndCriteriaList(listDeleted);
                    
                    //
                    ArrayList listNotFinished = new ArrayList();
                    QueryCriteria criteriaNFStatus = new QueryCriteria();
                    criteriaNFStatus.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionStatus);  
                    criteriaNFStatus.add("value", QueryCriteria.EQUAL, VolumeEntry.NOT_FINISHED_STATUS);
                    listNotFinished.add(criteriaNFStatus);
                    listNotFinished.addAll(criteriaSearchList);
                    queryReq.addAndCriteriaList(listNotFinished);
                }
                
                // FIXME : replace by QueryRequest
                QueryParameter qp = qf.getQueryParameter();
                qp.setTargets(new String[0]);
                
                // Display query result if no action on form (add ou remove criteria)
                if ( !qf.actionOnFormRequested() ) { 
                    //if (!qf.actionOnFormRequested() || qp.getCriteria().size() != 0) {
                    
                    // Perform the request
                    //Collection qrset = queryReq.findLexieForEdition(this.getUser());
                    Collection qrset = queryReq.findLexie(this.getUser());
                    //Collection qrset = DictionariesFactory.doQuery(qp, this.getUser());
                    
                    /*
                     // FIXME: create QueryRequest method !!!! -> created : findLexieForEdition
                     // Remove contribution linked to another (by getClassifiedFinishedContributionId())
                     // FIXME: change getClassifiedFinishedContributionId() method and tag name
                     ArrayList qrsetClone = new ArrayList();
                     qrsetClone.addAll(qrset);
                     int i = 0;
                     while ( i < qrset.size() ) {
                         QueryResult qr = (QueryResult) qrset.get(i);
                         VolumeEntry ve = qr.getSourceEntry();
                         
                         // Search link
                         int j = 0;
                         boolean isRemove = false;
                         while ( (!isRemove) && (j < qrsetClone.size()) ) {
                             QueryResult qrClone = (QueryResult) qrsetClone.get(j);
                             VolumeEntry veClone = qrClone.getSourceEntry();
                             isRemove = ve.getContributionId().equals(veClone.getClassifiedFinishedContributionId());
                             j++;
                         }
                         
                         // Remove contribution linked with another
                         if ( isRemove ) {
                             qrset.remove(i);
                         } else {
                             i++;
                         }
                     }
                     */
                    
                    //
                    addEntriesTable(qrset, qp);
                    
                    } else {
                        //
                        addEntriesTable(new Vector(), qp);
                    }
                } else {
                    removeEntryListTemplate();
                }
                    
                //
                XHTMLElement formHolder = content.getElementQueryForm();
                formHolder.appendChild(content.importNode(qf.getQueryFormNode("LexalpEditEntryInit.po"), true));
           
                //
                return content.getElementEditEntryInitContent();
        }
    
    protected void updateCreationInterface(String volume, String headword)
        throws fr.imag.clips.papillon.business.PapillonBusinessException,
        HttpPresentationException,
        java.io.UnsupportedEncodingException {
            
            // Addin the headword
            HTMLInputElement headwordInputElt = content.getElementHeadword();
            headwordInputElt.setValue(headword);
            
            // Adding the appropriate source languages to the source list
            HTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
            Node volumeSelect = volumeOptionTemplate.getParentNode();
            volumeOptionTemplate.removeAttribute("id");
            // We assume that the option element has only one text child
            // (it should be this way if the HTML is valid...)
            Text volumeTextTemplate = (Text)volumeOptionTemplate.getFirstChild();
            
            Volume[] AllVolumes = VolumesFactory.getVolumesArray();
            
            for (int i = 0; i < AllVolumes.length; i++) {
                Volume myVolume = AllVolumes[i];
                String itf = myVolume.getTemplateInterface();
                // FIXME: trick to avoid displaying Papillon axies...
                if (itf != null && !itf.equals("") && !myVolume.getName().equals(PapillonPivotFactory.VOLUMENAME)) {
                    volumeOptionTemplate.setValue(myVolume.getName());
                    volumeOptionTemplate.setLabel(myVolume.getName());
                    // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
                    // specs W3C.
                    volumeOptionTemplate.setSelected(myVolume.getName().equals(volume));
                    volumeTextTemplate.setData(myVolume.getName());
                    volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
                }
            }
            volumeSelect.removeChild(volumeOptionTemplate);
        }
//    
//    protected void displayLookupResults (String volumeName, String headword, int strategy, String lang)
//        throws PapillonBusinessException,
//        java.io.UnsupportedEncodingException,
//        HttpPresentationException {
//            
//			//Headword[0] = key
//			//Headword[1] = lang
//			//Headword[2] = value
//			//Headword[3] = strategy
//            String[] Headword = new String[4];
//            Headword[0] = Volume.CDM_headword;
//            Headword[1] = null;
//            Headword[2] = headword;
//            Headword[3] = IQuery.QueryBuilderStrategy[strategy+1];
//            Vector myVector = new Vector();
//            myVector.add(Headword);
//            
//            Collection EntryCollection = DictionariesFactory.getVolumeEntriesCollection(volumeName, this.getUser(), myVector);
//            
//            
//            if (EntryCollection != null && EntryCollection.size()>0) {
//                addEntriesTable(EntryCollection);
//            }
//            else {
//                this.getSessionData().writeUserMessage("Sorry, entry not found! Please check the volume.");
//                removeEntryListTable();
//            }
//        }
    
    protected void addEntriesTable (Collection qrset, QueryParameter qp) throws
        fr.imag.clips.papillon.business.PapillonBusinessException {
            
            
            XHTMLElement entryNode = content.getElementEntryNode();
            HTMLTableRowElement entryListRow = content.getElementEntryListRow();
            //HTMLAnchorElement entryIdAnchor = content.getElementViewEntryAnchor();
            //HTMLElement headwordElement = content.getElementHeadwordList();
            //HTMLElement posElement = content.getElementPosList();
            HTMLElement authorElement = content.getElementEntryAuthorList();
            HTMLAnchorElement editAnchor = content.getElementEditEntryAnchor();
            HTMLAnchorElement duplicateAnchor = content.getElementDuplicateEntryAnchor();
            HTMLAnchorElement deleteAnchor = content.getElementDeleteEntryAnchor();
            HTMLAnchorElement undeleteAnchor = content.getElementUndeleteEntryAnchor();
            HTMLAnchorElement ViewHistoryEntryAnchor = content.getElementViewHistoryEntryAnchor();
            HTMLAnchorElement viewXmlAnchor = content.getElementViewXmlAnchor();
            HTMLElement underEdition = content.getElementUnderEdition();
            HTMLElement proceedEdition = content.getElementProceedEdition();
            //HTMLElement editElement = content.getElementEditMessage();
            //HTMLElement copyElement = content.getElementCopyMessage();
            
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
                Node entryDOM = (Node)rf.getFormattedResult(qr, this.getUser());
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
                         && myEntry.getModificationAuthor().equals(this.getUser().getLogin()) ) {
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
                    if ( myEntry.getModificationAuthor().equals(this.getUser().getLogin()) ) {
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
                String href = this.getUrl() + "?"
                    + content.NAME_VOLUME + "="
                    + myEntry.getVolumeName() + "&"
                    + HANDLE_PARAMETER + "="
                    + myEntry.getEntryId() + "&"
                    + ACTION_PARAMETER + "=";
                
                //
                if ( (   (!myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)) 
                         && (!myEntry.getStatus().equals(VolumeEntry.MODIFIED_STATUS)) )
                     ||  ( myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)
                         && myEntry.getModificationAuthor().equals(this.getUser().getLogin())
                    )) {
                    
                    // the edit button
                    if ( !myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS) ) {
                        //if ((myEntry.getAuthor().equals(this.getUser().getLogin())
                        //     || this.getUser().isInGroup("validator"))
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
                    //if ((myEntry.getAuthor().equals(this.getUser().getLogin())
                    //     || this.getUser().isInGroup("validator"))
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
                    //    && (myEntry.getAuthor().equals(this.getUser().getLogin())
                    //        || this.getUser().isInGroup("validator"))) {
                        
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
                //    && (myEntry.getAuthor().equals(this.getUser().getLogin())
                //        || this.getUser().isInGroup("validator"))) {
                    href = "History.po?" + "VolumeName" + "=" + myEntry.getVolumeName() + "&" + "EntryHandle" + "=" + myEntry.getHandle();
                    ViewHistoryEntryAnchor.setHref(href);
                    ViewHistoryEntryAnchor.setAttribute("style","display: block;");
                //} else {
                //    ViewHistoryEntryAnchor.setHref("");
               //     ViewHistoryEntryAnchor.setAttribute("style","display: none;");
               //}
                
                // The view XML anchor
                // FIXME : create new page.po like history
                QueryParameter qpxml = new QueryParameter();
                qpxml.setXsl("XML");
                String[] dictNames = new String[1];
                dictNames[0] = myEntry.getDictionaryName();
                qpxml.setDictionaryNames(dictNames);
                Vector crit = new Vector();
                String[] idc = new String[4];
                idc[0] = Volume.CDM_contributionId;
                idc[1] = null;
                //if (myEntry.getStatus().equals(VolumeEntry.NOT_FINISHED_STATUS)
                //    && myEntry.getModificationAuthor().equals(this.getUser().getLogin())) {
                //        idc[2] = myEntry.getClassifiedFinishedContributionId(); 
                //} else {
                        idc[2] = myEntry.getContributionId(); 
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
                
                href = "LexalpEditEntryInit.po?"
                    + AdvancedQueryForm.getEncodedUrlForParameter(qpxml); 
                
                viewXmlAnchor.setHref(href);
                
                HTMLElement cloneEntry = (HTMLElement)entryListRow.cloneNode(true);
                
                //      we have to take off the id attribute because we did not take it off the original
                cloneEntry.removeAttribute("id");
                entryTable.appendChild(cloneEntry);
                
                //entryNode.getParentNode().insertBefore(entryNode.cloneNode(true), entryNode);
            }
            
            //
            entryNode.getParentNode().removeChild(entryNode);
            removeEntryListTemplate();
        }
	
    protected void removeEntryListTemplate() {
		Element myElement = content.getElementEntryListRow();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
    }
    
    protected void removeEntryListTable () {
		// PB when I remove the entire table, the following elements disappear from the DOM
		// To fix the pb, always embedd a table in a <div> element
		Element myElement = content.getElementEntryListTable();
		Node myParent = myElement.getParentNode();
		myParent.removeChild(myElement);
    }
    
}

