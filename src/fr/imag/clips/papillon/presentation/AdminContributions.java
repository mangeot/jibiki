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
 * Revision 1.4  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *
 *-----------------------------------------------
 * Papillon AdminContributions page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import fr.imag.clips.papillon.business.message.MessageDBLoader;

// Standard imports
import java.io.IOException;
import java.util.Vector;
import java.text.DateFormat;
import java.io.*;


//pour le dictionary
import fr.imag.clips.papillon.business.dictionary.*;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.user.*;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.xsl.*;


import fr.imag.clips.papillon.presentation.xhtml.orig.*;

// Imported JAVA API for XML Parsing classes
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

// Imported TraX classes
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;


public class AdminContributions extends BasePO {
	
    protected final static int MaxDisplayedEntries= 5;
	
	
	protected final static String EditURL="EditEntry.po";
	protected final static String EditVolumeParameter=EditEntry.VolumeName_PARAMETER;
	protected final static String EditHandleParameter=EditEntry.EntryHandle_PARAMETER;
	
	protected final static String REMOVE_CONTRIB_PARAMETER="RemoveContrib";
	protected final static String MARK_FINISHED_PARAMETER="MarkFinished";
	protected final static String ENTRYID="entryid";
    protected final static String XSLID="xslid";
    protected final static String SORTBY_PARAMETER="SortBy";
    
    protected static AdminContributionsTmplXHTML content;
	
    protected boolean loggedInUserRequired() {
        return true;
    }
	
    protected boolean adminUserRequired() {
        return false;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }
    
    public Node getContent() 
        throws HttpPresentationException,
        IOException,
        TransformerConfigurationException,
        org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException,
        java.io.IOException,
        javax.xml.transform.TransformerException,
        ClassNotFoundException,
        PapillonBusinessException {
        
        // Création du contenu
        content = (AdminContributionsTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("AdminContributionsTmplXHTML", this.getComms(), this.getSessionData());
		
        HttpPresentationRequest req = this.getComms().request;
        
		//TEMPORAIRE :avec l URL
		//AJOUT D ENTREE DE DICO
		
		String URL = req.getParameter(content.NAME_URL);
		String volumeString = req.getParameter(content.NAME_VOLUME);
		String entryid = req.getParameter(ENTRYID);
		String xslid = req.getParameter(XSLID);
		String sortBy = req.getParameter(SORTBY_PARAMETER);
		
		if (volumeString!=null &&!volumeString.equals("")) {
			this.setPreference(content.NAME_VOLUME,volumeString);
		}
		else {
			volumeString = this.getPreference(content.NAME_VOLUME);
		}

		String queryString = "";
		if (volumeString!=null && !volumeString.equals("")) {
			queryString += "&" + content.NAME_VOLUME + "=" + volumeString;
		}
		
		String userMessage = null;
		if (null != req.getParameter(content.NAME_ADD) &&
			null != URL) {
			Contribution[] Contribs = null;
			//         Contribution[] Contribs = ContributionsFactory.parseCreateContributionsURL(getUser().getLogin(),
			//                                                                                     volumeString, URL);
			if (null != Contribs && Contribs.length>0) {
				for (int i=0;i<Contribs.length;i++) {
					Contribution myContrib = Contribs[i];
					if (null != myContrib && !myContrib.IsEmpty()) {
						myContrib.save();
						userMessage = "Contribution from " + myContrib.getAuthor() +
							" on volume " + volumeString +
							" with headword " + myContrib.getHeadword() + " downloaded...";
					}
				}
			}
		}
		else if (null != req.getParameter(content.NAME_EMPTY)) {
			ContributionsFactory.removeContributions(this.getUser().getLogin(), volumeString);
			userMessage = "Volume " + volumeString + " contributions removed...";
		}
		else if (null != req.getParameter(REMOVE_CONTRIB_PARAMETER)) {
			Contribution myContrib = ContributionsFactory.findContributionByHandle(entryid);
			if (null != myContrib && !myContrib.IsEmpty()) {
				volumeString = myContrib.getVolumeName();
				// we delete the entry related to the contrib
				IAnswer myAnswer = DictionariesFactory.findAnswerByHandle(myContrib.getVolumeName(),myContrib.getEntryHandle());
				if (myAnswer != null && 
					!myAnswer.IsEmpty() && 
					myAnswer.getType()==IAnswer.LocalEntry && 
					myAnswer.getVolumeName().equals(PapillonPivotFactory.VOLUMENAME)) {
					PapillonPivotFactory.deleteLinksInAxies(myAnswer,this.getUser());
				}
				myAnswer.delete();
				myContrib.delete();
				entryid=null;
				userMessage = "Contribution " +  myContrib.getHandle() + " / " +
					myContrib.getHeadword() + " removed...";
			}
		}
		else if (null != req.getParameter(MARK_FINISHED_PARAMETER)) {
				if (entryid !=null && !entryid.equals("")) {
					Contribution myContrib = ContributionsFactory.findContributionByHandle(entryid);
					if (null != myContrib && !myContrib.IsEmpty()
					&& null != myContrib.getStatus() && myContrib.getStatus().equals(Contribution.NOT_FINISHED_STATUS)) {
						VolumeEntry myEntry = VolumeEntriesFactory.findEntryByHandle(myContrib.getVolumeName(),myContrib.getEntryHandle());
						//Adding modifications in the XML code
						IAnswerFactory.setModification(myEntry,this.getUser().getLogin(),Contribution.FINISHED_STATUS);
						myEntry.save();
						myContrib.setStatus(Contribution.FINISHED_STATUS);
						myContrib.save();
						userMessage = "Contribution " +  myContrib.getHandle() + " / " +
						myContrib.getHeadword() + " finished";
						volumeString = myContrib.getVolumeName();
					}
				}
		}
		if (null != userMessage && !userMessage.equals("")){
			this.getSessionData().writeUserMessage(userMessage);
			PapillonLogger.writeDebugMsg(userMessage);
		}
		
        addConsultForm(volumeString);
		
        addContributions(entryid, volumeString, this.getUser(), xslid, sortBy, queryString);
        
        removeTemplateRows();
        
        //On rend le contenu correct
        return content.getElementFormulaire();
    }
	protected void addConsultForm(String volume) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException, 
		HttpPresentationException,
        java.io.UnsupportedEncodingException {
			
			// Adding the user name
			User user = getUser();
			
			if (null != user && !user.IsEmpty()) {
				content.setTextUserName(user.getName());
			}
			
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
				String schema = myVolume.getXmlSchema();
				if (schema != null && !schema.equals("")) {
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
	
    protected void addContributions(String entryid, String volumeString, User myUser, String xslid, String sortBy, String queryString)
        throws PapillonBusinessException,
        ClassNotFoundException,
        HttpPresentationException,
        IOException,
        TransformerConfigurationException,
        org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException,
        javax.xml.transform.TransformerException {
			
            Vector ContribVector = new Vector();
            if (null != entryid && !entryid.equals("")) {
                ContribVector.add(ContributionsFactory.findContributionByHandle(entryid));
            }
            else {
                ContribVector = ContributionsFactory.getContributions(volumeString, myUser, sortBy);
            }
            // If there are too much entries ie > MaxDisplayedEntries,
            // we display a table of entries instead of the entries
            if (null != ContribVector) {
                addEntryTable(ContribVector, queryString);
                if (ContribVector.size() < MaxDisplayedEntries) {
                    for(int i = 0; i < ContribVector.size(); i++) {
                        Contribution myContrib = (Contribution)ContribVector.get(i);
						IAnswer myAnswer = DictionariesFactory.findAnswerByHandle(myContrib.getVolumeName(),myContrib.getEntryHandle());
						if (myAnswer!=null && !myAnswer.IsEmpty()) {
							addElement(XslTransformation.applyXslSheets(myAnswer, xslid));
						}
					}
				}
			}
		}
    
	
    protected void addEntryTable (Vector ContribVector, String queryString)
        throws PapillonBusinessException,
        java.io.UnsupportedEncodingException {
			
            // On récupère les éléments du layout
			// the headers
			HTMLAnchorElement headwordHeader = content.getElementHeadwordHeaderAnchor();
			headwordHeader.setHref(headwordHeader.getHref()+queryString);
			HTMLAnchorElement creationdateHeader = content.getElementCreationdateHeaderAnchor();
			creationdateHeader.setHref(creationdateHeader.getHref()+queryString);
			HTMLAnchorElement statusHeader = content.getElementStatusHeaderAnchor();
			statusHeader.setHref(statusHeader.getHref()+queryString);
			HTMLAnchorElement newentryHeader = content.getElementNewentryHeaderAnchor();
			newentryHeader.setHref(newentryHeader.getHref()+queryString);


            HTMLTableRowElement entryListRow = content.getElementEntryListRow();
			
			// View Contrib
            HTMLAnchorElement viewContribAnchor = content.getElementViewContribAnchor();
            viewContribAnchor.removeAttribute("id");
            content.getElementViewContribText().removeAttribute("id");
			
			// EntryId
			content.getElementEntryId().removeAttribute("id");
												
			// Creation date
			content.getElementCreationDate().removeAttribute("id");
												
			// IsNewEntry
			content.getElementIsNewEntry().removeAttribute("id");

			// Status
			content.getElementStatus().removeAttribute("id");
			
			//Mark finished
            HTMLAnchorElement markFinishedAnchor = content.getElementMarkFinishedAnchor();
            markFinishedAnchor.removeAttribute("id");
			
			//View XML
            HTMLAnchorElement viewXmlAnchor = content.getElementViewXmlAnchor();
            viewXmlAnchor.removeAttribute("id");
			
			// Edit contrib
            HTMLAnchorElement editContribAnchor = content.getElementEditContribAnchor();
            editContribAnchor.removeAttribute("id");
			
			// remove contrib
            HTMLAnchorElement removeContribAnchor = content.getElementRemoveContribAnchor();
            removeContribAnchor.removeAttribute("id");
			
			
            // On récupère le noeud contenant la table...
            Node entryTable = entryListRow.getParentNode();
            if (null != ContribVector && ContribVector.size()>0) {
				content.setTextContributionsCount("" + ContribVector.size());
                for(int i = 0; i < ContribVector.size(); i++) {
					Contribution myContrib = (Contribution) ContribVector.elementAt(i);
					
					// view contrib
					if (myContrib!=null && !myContrib.IsEmpty()) {

					// FIXME: hack for the GDEF estonian volume
						String headword = myContrib.getHeadword();
						if (myContrib.getVolumeName().equals("GDEF_est")) {
							VolumeEntry myEntry = VolumeEntriesFactory.findEntryByHandle(myContrib.getVolumeName(),myContrib.getEntryHandle());
							if (myEntry!=null && !myEntry.IsEmpty()) {
								String particule = myEntry.getParticule();
								if(particule!=null && !particule.equals("")) {
									headword = particule + " " + headword;
								}
							}
						}


						content.setTextViewContribText(headword);
						viewContribAnchor.setHref(this.getUrl() + "?"
												  + ENTRYID + "="
												  + myContrib.getHandle()
												  + queryString);
						// entry id
						content.setTextEntryId(myContrib.getEntryId());
						
						// creation date
						content.setTextCreationDate(myContrib.getCreationDate().toString());
						
						// IsNewEntry
						content.setTextIsNewEntry(new Boolean(myContrib.IsNewEntry()).toString());
						
						// Status
						content.setTextStatus(myContrib.getStatus());
						
						// mark finished
						markFinishedAnchor.setHref(this.getUrl() + "?"
											  + MARK_FINISHED_PARAMETER + "=on&"
											  + ENTRYID + "="
											  + myContrib.getHandle()
											  + queryString);

						// view XML
						XslSheet xmlSheet = XslSheetFactory.findXslSheetByName("XML");
						String xslid = "";
						if (null != xmlSheet && !xmlSheet.IsEmpty()) {
							xslid = xmlSheet.getHandle();
						} 
						
						viewXmlAnchor.setHref(this.getUrl() + "?"
											  + ENTRYID + "="
											  + myContrib.getHandle() + "&"
											  + XSLID + "="
											  + xslid
											  + queryString);
						
						// edit contrib
                        //FIXME: encore un hack de plus pour les axies.
						//For the moment, we cannot reedit axies
						if (myContrib.getVolumeName().equals(PapillonPivotFactory.VOLUMENAME)) {
							content.setTextEditContrib("");
							
						}
						else {
							editContribAnchor.setHref(EditURL + "?"
													  + EditVolumeParameter + "="
													  + myContrib.getVolumeName() + "&"
													  + EditHandleParameter + "="
													  + myContrib.getEntryHandle());
						}
						
						// remove contrib
                        removeContribAnchor.setHref(this.getUrl() + "?"
													+ REMOVE_CONTRIB_PARAMETER + "=on&"
													+ ENTRYID + "="
													+ myContrib.getHandle()
													+ queryString);                        
                        
                        HTMLElement clone = (HTMLElement)entryListRow.cloneNode(true);
                        //      we have to take off the id attribute because we did not take it off the original
                        clone.removeAttribute("id");
                        entryTable.appendChild(clone);
                    }
					else {
						PapillonLogger.writeDebugMsg("contrib empty ");
					}
				}
			}
        }
	
    protected void addElement (Element element)
        throws HttpPresentationException,
        PapillonBusinessException,
        java.io.IOException {
			
            //for the entry content
            HTMLTableRowElement originalEntryRow = content.getElementEntryRow();
            Node entryTable=originalEntryRow.getParentNode();
            //for the entry content
            HTMLTableRowElement entryRow = (HTMLTableRowElement)originalEntryRow.cloneNode(true);
			
            //for the lexie content
            HTMLTableCellElement entryCell= (HTMLTableCellElement)entryRow.getFirstChild();
			
            entryRow.removeAttribute("id");
            entryCell.removeAttribute("id");
			
            entryCell.appendChild(content.importNode(element, true));
            entryTable.appendChild(entryRow);
            // Don't remove the original node in order to add more entries ...
            //entryTable.removeChild(entryRow);
        }
	
    
    
    
    protected void removeTemplateRows() {
        // EntryListRow
        Element entryListRow = content.getElementEntryListRow();
        Node entryListRowParent = entryListRow.getParentNode();
        entryListRowParent.removeChild(entryListRow);
		
        // EntryRow
        Element entryRow = content.getElementEntryRow();
        Node entryRowParent = entryRow.getParentNode();
        entryRowParent.removeChild(entryRow);
    }    
    
}
