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
 * Revision 1.10  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.9  2004/09/18 17:26:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2004/02/10 05:33:31  mangeot
 * Removed parseCreateContributionsURL, have to rewrite it
 *
 * Revision 1.7  2004/02/10 05:27:14  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.6.2.7  2004/01/13 05:10:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.6  2004/01/13 02:42:12  mangeot
 * *** empty log message ***
 *
 * Revision 1.6.2.5  2004/01/13 02:14:05  mangeot
 * Bug fixes :-(
				*
				* Revision 1.6.2.4  2004/01/09 05:18:57  mangeot
				* Bugs fixes !
				*
				* Revision 1.6.2.3  2004/01/08 15:17:21  mangeot
				* Bugs fixed
				*
				* Revision 1.6.2.2  2004/01/08 09:43:20  mangeot
				* Changed all the mechanism of the management of the contributions
				* Have to be tested
				*
				* Revision 1.6.2.1  2004/01/06 09:07:02  mangeot
				* Added transitivity in Axies. I don't build a new axie if a lexie is already linked to an axie !
				* I corrected some bugs with axies and index
				*
				* Revision 1.6  2003/11/26 06:11:29  mangeot
				* Bug Fix when a new contribution was created from scratch, there was an encoding problem when I tried to build the entry id.
				* The problem comes from the conversion from ISO to UTF-8 that
				* we must do after retrieving an entry from the database.
				* Be careful to use the entry headword or xmlCode only after having saved it once
				* into the database otherwise, there is a double conversion!
				*
				* Revision 1.5  2003/11/25 07:01:37  mangeot
				* Bug Fix when reediting an existing contribution
				*
				* Revision 1.4  2003/08/21 04:47:56  mangeot
				* Cleaning the new menu
				*
				* Revision 1.3  2003/08/20 08:15:38  mangeot
				* *** empty log message ***
				*
				* Revision 1.2  2003/08/14 08:30:16  mangeot
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
				* Revision 1.1.1.1.2.10  2003/08/14 04:15:52  mangeot
				* *** empty log message ***
				*
				* Revision 1.1.1.1.2.9  2003/08/11 10:24:51  mangeot
				* Debugging ...
				*
				* Revision 1.1.1.1.2.8  2003/08/09 07:21:06  mangeot
				* Lots of improvements:
				* possible to create a new axie linking two contributions
				* possible to delete contributions
				*
				* Revision 1.1.1.1.2.7  2003/08/07 06:29:51  mangeot
				* *** empty log message ***
				*
				* Revision 1.1.1.1.2.6  2003/06/21 17:56:38  mangeot
				* *** empty log message ***
				*
				* Revision 1.1.1.1.2.5  2003/05/28 09:17:20  mangeot
				* Changement du copyright sur les fichiers
				*
				* Revision 1.1.1.1.2.4  2003/05/26 12:06:37  mangeot
				* *** empty log message ***
				*
				* Revision 1.1.1.1.2.3  2003/05/26 11:47:00  mangeot
				* *** empty log message ***
				*
				* Revision 1.1.1.1.2.2  2003/05/21 10:15:09  mangeot
				* Travail sur l'interface d'edition
				*
				* Revision 1.1.1.1.2.1  2003/05/14 06:16:27  mangeot
				* *** empty log message ***
				*
				* Revision 1.1.1.1  2002/10/28 16:49:16  serasset
				* Creation of the papillon CVS repository for enhydra 5.0
				*
				* Revision 1.8  2002/10/25 14:10:34  mangeot
				* merge between PAPILLON_1_4 and trunk
				* CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
				*
				* Revision 1.7.2.3  2002/10/24 06:58:50  mangeot
				* Corrected an important bug in AdminContributions.java
				* Better to reinstall !
				*
				* Revision 1.7.2.2  2002/10/23 09:51:12  serasset
				* Clean up of the source tree,
				*     Every source file is now encoded in ISO-Latin-1,
				*     Every html file is still encoded in UTF8.
				*
				* Revision 1.7.2.1  2002/10/09 03:13:16  mangeot
				* bug corrected in contributions
				*
				* Revision 1.7  2002/09/17 17:13:23  mangeot
				* Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
				*
				* Revision 1.6  2002/09/16 13:34:22  mangeot
				* Merged DEV and DEPLOY versions + added Olivier Tache code
				*
				* Revision 1.5  2002/08/15 07:14:37  mangeot
				* Modified start scripts : added a variable for te multiserver conf
				* Corrected URLs in HTML pages
				*
				* Revision 1.4  2002/08/10 12:07:01  mangeot
				* Fixed a problem in compilation priorities
				* no more package contribution
				*
				* Revision 1.3  2002/08/10 11:32:09  mangeot
				* Added pages to edit monolingual entries
				* it is very beta version
				*
				* Revision 1.2  2002/08/10 09:18:58  mangeot
				* Added funcitonalities to the AdminContributions page
				*
				* Revision 1.1  2002/08/10 00:07:43  mangeot
				* Added files for contributions
				*
				* Revision 1.5  2002/07/26 10:00:21  serasset
				* Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
				*
				* Revision 1.4.6.1  2002/07/12 13:50:41  serasset
				* A new architecture for HTML template localization has been integrated.
				*
				* Revision 1.4  2002/05/23 16:14:41  mangeot
				* Adding admin group for presentation pages
				*
				* Revision 1.3  2002/05/22 08:56:18  mangeot
				* MML added user login and register:
				* LoginUser.po RegisterUser.po AdminUsers.po
				*
				* Revision 1.2  2002/05/09 07:43:42  mangeot
				* Work on the data layer.
				* I am now able to send directly sql statements.
				* I use sql statements to create a table for the volumes
				* and to truncate or drop these tables.
				* I am now finally able to create dynamically a table for a new volume
				* I also added 2 scripts for dump/restore of the database in sql/ directory
				*
				* Revision 1.1  2002/05/09 06:00:38  mangeot
				* *** empty log message ***
				*-----------------------------------------------
				* Papillon Admin page.
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


import fr.imag.clips.papillon.presentation.html.orig.*;

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
	
	
	protected final static String EditURL="ConsultEdit.po";
	protected final static String EditVolumeParameter=ConsultEditTmplHTML.NAME_VOLUME;
	protected final static String EditHandleParameter=ConsultEdit.HANDLE_PARAMETER;
	protected final static String EditStepParameter="STEP";
	
	protected final static String REMOVE_CONTRIB_PARAMETER="RemoveContrib";
	protected final static String MARK_FINISHED_PARAMETER="MarkFinished";
	protected final static String ENTRYID="entryid";
    protected final static String XSLID="xslid";
    protected final static String SORTBY_PARAMETER="SortBy";
    
    protected static AdminContributionsTmplHTML content;
	
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
        content = (AdminContributionsTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("AdminContributionsTmplHTML", this.getComms(), this.getSessionData());
		
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
                for(int i = 0; i < ContribVector.size(); i++) {
					Contribution myContrib = (Contribution) ContribVector.elementAt(i);
					
					// view contrib
					if (myContrib!=null && !myContrib.IsEmpty()) {
						content.setTextViewContribText(myContrib.getHeadword());
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
													  + myContrib.getEntryHandle() + "&"
													  + EditStepParameter + "="
													  + ConsultEdit.STEP_EDIT);
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
