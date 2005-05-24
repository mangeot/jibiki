/*
 * papillon 
 *
 * Enhydra super-servlet
 * 
 * © Mathieu Mangeot - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.10  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.9  2005/04/15 13:20:08  mangeot
 * Added setIdIfNull
 *
 * Revision 1.8  2005/04/15 11:38:05  mangeot
 * Fixed a bug, not using entryHandle from contributions table any more
 *
 * Revision 1.7  2005/04/14 08:25:12  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.5  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.4.2.5  2005/04/09 14:51:47  mangeot
 * Added more consult options for AdminContributions page
 *
 * Revision 1.4.2.4  2005/03/30 11:17:07  mangeot
 * Modified table contributions: replaced originalhandle by originalid
 * Corrected a few bugs when validating an already existing entry
 *
 * Revision 1.4.2.3  2005/03/16 09:05:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.2.2  2005/02/25 10:22:08  mangeot
 * Bug fixes and added the use of referrer when exiting from Reviewcontributions.po
 *
 * Revision 1.4.2.1  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.4  2005/01/15 20:02:19  mangeot
 * Added new search options for ReviewContributions
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
 *-----------------------------------------------
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
import java.util.*;
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


public class ReviewContributions extends PapillonBasePO {

	
    protected final static int MaxDisplayedEntries= 5;

	protected final static int STEP_DEFAULT = 1;
	protected final static int STEP_LOOKUP = 2;
	protected final static int STEP_VIEW = 3;
	protected final static int STEP_REMOVE = 4;
	protected final static int STEP_REVISE = 5;
	protected final static int STEP_VALIDATE = 6;

	protected final static String ALL="*ALL*";
	protected final static String EditURL="EditEntry.po";
	protected final static String EditVolumeParameter=EditEntry.VolumeName_PARAMETER;
	protected final static String EditHandleParameter=EditEntry.EntryHandle_PARAMETER;

	protected final static String VIEW_CONTRIB_PARAMETER="ViewContrib";
	protected final static String REMOVE_CONTRIB_PARAMETER="RemoveContrib";
	protected final static String REVISE_CONTRIB_PARAMETER="ReviseContrib";
	protected final static String VALIDATE_CONTRIB_PARAMETER="ValidateContrib";
	protected final static String CONTRIBID_PARAMETER="ContribId";
    protected final static String XSLID_PARAMETER="xslid";
    protected final static String SORTBY_PARAMETER="SortBy";
    
    protected static ReviewContributionsTmplXHTML content;

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
        IOException,
        TransformerConfigurationException,
        org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException,
        java.io.IOException,
        javax.xml.transform.TransformerException,
        ClassNotFoundException,
        PapillonBusinessException {
        
        // Création du contenu
        content = (ReviewContributionsTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("ReviewContributionsTmplXHTML", this.getComms(), this.getSessionData());

        HttpPresentationRequest req = this.getComms().request;
        
		// decoding the CGI arguments
		String queryString = "";
		
		// lookup
		String lookup = myGetParameter(content.NAME_LOOKUP);
		// volume
		String volume = myGetParameter(content.NAME_VOLUME);
		if (volume!=null &&!volume.equals("")) {
			this.setPreference(content.NAME_VOLUME,volume);
		}
		else {
			volume = this.getPreference(content.NAME_VOLUME);
		}
		if (volume !=null && !volume.equals("")) {
			queryString += "&" + content.NAME_VOLUME + "=" + volume;
		}
		
		//author
		String author = myGetParameter(content.NAME_AUTHOR);
		if (lookup!=null &&!lookup.equals("")) {
			this.setPreference(content.NAME_AUTHOR,author);
		}
		else {
			author = this.getPreference(content.NAME_AUTHOR);
		}
		if (author !=null && !author.equals("")) {
			queryString += "&" + content.NAME_AUTHOR + "=" + author;
		}

		// headword
		String headword = myGetParameter(content.NAME_HEADWORD);
		if (lookup!=null &&!lookup.equals("")) {
			this.setPreference(content.NAME_HEADWORD,headword);
		}
		else {
			headword = this.getPreference(content.NAME_HEADWORD);
		}
		if (headword !=null && !headword.equals("")) {
			queryString += "&" + content.NAME_HEADWORD + "=" + headword;
		}
		String partialMatch = myGetParameter(content.NAME_PartialMatch);
		if (lookup!=null && !lookup.equals("")) {
			this.setPreference(content.NAME_PartialMatch,partialMatch);
		}
		else {
			partialMatch = this.getPreference(content.NAME_PartialMatch);
		}
		int strategy = IQuery.STRATEGY_EXACT;
		if (null != partialMatch && !partialMatch.equals("")) {
			strategy = IQuery.STRATEGY_SUBSTRING;
			queryString += "&" + content.NAME_PartialMatch + "=" + partialMatch;
		}

		// status
		String status = myGetParameter(content.NAME_STATUS);
		if (lookup!=null &&!lookup.equals("")) {
			this.setPreference(content.NAME_STATUS,status);
		}
		else {
			status =  this.getPreference(content.NAME_STATUS);
		}
		if (status != null && status.equals(ALL)) {
			status = null;
		}
		if (status !=null && !status.equals("")) {
			queryString += "&" + content.NAME_STATUS + "=" + status;
		}

		// revisor
		String revisor = myGetParameter(content.NAME_REVISOR);
		if (lookup!=null &&!lookup.equals("")) {
			this.setPreference(content.NAME_REVISOR,revisor);
		}
		else {
			revisor =  this.getPreference(content.NAME_REVISOR);
		}
		if (revisor !=null && !revisor.equals("")) {
			queryString += "&" + content.NAME_REVISOR + "=" + revisor;
		}

		// hidden arguments
		String contribid = myGetParameter(CONTRIBID_PARAMETER);
		String xslid = myGetParameter(XSLID_PARAMETER);
		String sortBy = myGetParameter(SORTBY_PARAMETER);

		int step = STEP_DEFAULT;
		if (null != lookup || this.getReferrer().indexOf(EditURL)>0) {
			step = STEP_LOOKUP;
		}
		else if (null != contribid && null != myGetParameter(VIEW_CONTRIB_PARAMETER)) {
			step = STEP_VIEW;
		}
		else if (null != contribid && null != myGetParameter(REMOVE_CONTRIB_PARAMETER)) {
			step = STEP_REMOVE;
		}
		else if (null != contribid && null != myGetParameter(REVISE_CONTRIB_PARAMETER)) {
			step = STEP_REVISE;
		}
		else if (null != contribid && null != myGetParameter(VALIDATE_CONTRIB_PARAMETER)) {
			step = STEP_VALIDATE;
		}

		String userMessage = null;

		switch (step) {
			case STEP_DEFAULT:
				//addContributions(volume, author, headword, strategy, sortBy, queryString);
				break;
			case STEP_LOOKUP:
				addContributions(volume, author, headword, strategy, status, revisor, sortBy, queryString);
				break;
			case STEP_VIEW:
				addContribution(contribid, xslid, queryString);
				break;
			case STEP_REMOVE:
				contribid = myGetParameter(CONTRIBID_PARAMETER);
				if (contribid !=null && !contribid.equals("")) {
					Contribution myContrib = ContributionsFactory.findContributionByHandle(contribid);
					if (null != myContrib && !myContrib.isEmpty()) {
						userMessage = "Contribution " +  myContrib.getHandle() + " / " +
						myContrib.getHeadword() + " removed...";
						volume = myContrib.getVolumeName();
						myContrib.delete();
					}
				}
				addContributions(volume, author, headword, strategy, status, revisor, sortBy, queryString);
				break;
			case STEP_REVISE:
				contribid = myGetParameter(CONTRIBID_PARAMETER);
				if (contribid !=null && !contribid.equals("") && this.getUser().isSpecialist()) {
					Contribution myContrib = ContributionsFactory.findContributionByHandle(contribid);
					if (null != myContrib && !myContrib.isEmpty()
					&& null != myContrib.getStatus() && myContrib.getStatus().equals(Contribution.FINISHED_STATUS)) {
						VolumeEntry myEntry = VolumeEntriesFactory.findEntryByEntryId(myContrib.getVolumeName(),myContrib.getEntryId());
						//Adding modifications in the XML code
						myEntry.setModification(this.getUser().getLogin(),Contribution.REVISED_STATUS);
						myEntry.save();
						myContrib.setReviewer(this.getUser().getLogin());
						myContrib.setReviewDate(new Date());
						myContrib.setStatus(Contribution.REVISED_STATUS);
						myContrib.save();
						userMessage = "Contribution " +  myContrib.getHandle() + " / " +
						myContrib.getHeadword() + " revised";
						volume = myContrib.getVolumeName();
					}
				}
				addContributions(volume, author, headword, strategy, status, revisor, sortBy, queryString);
				break;
			case STEP_VALIDATE:
				if (contribid !=null && !contribid.equals("") && this.getUser().isValidator()) {
					Contribution myContrib = ContributionsFactory.findContributionByHandle(contribid);
					if (null != myContrib && !myContrib.isEmpty() &&
						null != myContrib.getStatus() && myContrib.getStatus().equals(Contribution.REVISED_STATUS)) {
						VolumeEntry myEntry = VolumeEntriesFactory.findEntryByEntryId(myContrib.getVolumeName(),myContrib.getEntryId());
						//Adding modifications in the XML code
						myEntry.setModification(this.getUser().getLogin(),Contribution.VALIDATED_STATUS);
						if (!myContrib.IsNewEntry()) {
							VolumeEntry origEntry = VolumeEntriesFactory.findEntryByEntryId(myContrib.getVolumeName(),myContrib.getOriginalId());
							origEntry.replaceData(myEntry);
							origEntry.save();
							myEntry.delete();
							userMessage = "Data of entry " + origEntry.getHeadword() + " / " + origEntry.getId() + " replaced by data of contribution " +  myEntry.getId() +
							" in the dictionary...";
						}
						else {
							myEntry.save();
							userMessage = "Contribution " +  myEntry.getId() + " / " +
							myContrib.getHeadword() + " integrated in the dictionary...";
						}
						volume = myContrib.getVolumeName();
						myContrib.delete();
					}
				}
				addContributions(volume, author, headword, strategy, status, revisor, sortBy, queryString);
				break;
			default:
				break;
			}	
			
            if (null != userMessage && !userMessage.equals("")){
                this.getSessionData().writeUserMessage(userMessage);
                PapillonLogger.writeDebugMsg(userMessage);
            }
           
        addConsultForm(volume, author, headword, partialMatch, status, revisor);

        removeTemplateRows();
        
        //On rend le contenu correct
        return content.getElementFormulaire();
    }
        protected void addConsultForm(String volume, String author, String headword, String strategy, String status, String revisor) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException, 
                HttpPresentationException,
        java.io.UnsupportedEncodingException {
                    
        // Adding the user name
		User user = getUser();

		if (null != user && !user.isEmpty()) {
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

		HTMLInputElement authorInput = content.getElementAUTHOR();
		authorInput.setValue(author);

		HTMLInputElement headwordInput = content.getElementHEADWORD();
		headwordInput.setValue(headword);
		
		if (strategy !=null && !strategy.equals("")) {
			HTMLInputElement strategyInput = content.getElementPartialMatch();
			strategyInput.setChecked(true);		
		}
		
		HTMLSelectElement statusSelect = (HTMLSelectElement) content.getElementSTATUS();
		setSelected(statusSelect,status);
		
		HTMLInputElement revisorInput = content.getElementREVISOR();
		revisorInput.setValue(revisor);
		
    }

    protected void addContribution(String contribid, String xslid, String queryString)
        throws PapillonBusinessException,
        ClassNotFoundException,
        HttpPresentationException,
        IOException,
        TransformerConfigurationException,
        org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException,
        javax.xml.transform.TransformerException {
			Vector EntryVector = new Vector();
			EntryVector.add(ContributionsFactory.findContributionByHandle(contribid));
			addContributions(EntryVector, xslid, queryString);
		}

    protected void addContributions(String volume, String author, String headword, int strategy, String status, String revisor, String sortBy, String queryString)
        throws PapillonBusinessException,
        ClassNotFoundException,
        HttpPresentationException,
        IOException,
        TransformerConfigurationException,
        org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException,
        javax.xml.transform.TransformerException {
				String[] Headwords = null;
				if (headword!=null && !headword.equals("")) {
					Headwords = new String[]{headword};
				}
			Collection EntryCollection = ContributionsFactory.getContributions(volume, author, strategy, Headwords, status, revisor, sortBy);
			addContributions(EntryCollection, null, queryString);
		}

	protected void addContributions(Collection EntryCollection, String xslid, String queryString)
		throws PapillonBusinessException,
		ClassNotFoundException,
		HttpPresentationException,
		IOException,
		TransformerConfigurationException,
		org.xml.sax.SAXException,
		javax.xml.parsers.ParserConfigurationException,
		javax.xml.transform.TransformerException {

		// If there are too much entries ie > MaxDisplayedEntries,
        // we display a table of entries instead of the entries
			if (null != EntryCollection && EntryCollection.size()>0) {
				addEntryTable(EntryCollection, queryString);
				if (EntryCollection.size() < MaxDisplayedEntries) {
					for(Iterator entriesIterator = EntryCollection.iterator(); entriesIterator.hasNext();) {
						Contribution myContrib = (Contribution)entriesIterator.next();
						IAnswer myAnswer = DictionariesFactory.findEntryByEntryId(myContrib.getVolumeName(),myContrib.getEntryId());
						addElement(XslTransformation.applyXslSheets(myAnswer, xslid),myAnswer.getVolumeName(),myAnswer.getHandle());
					}
				}
			}
		}
    

    protected void addEntryTable (Collection EntryCollection, String queryString)
        throws PapillonBusinessException,
        java.io.UnsupportedEncodingException {

            // On rÈcupËre les ÈlÈments du layout
			
			HTMLAnchorElement volumeHeader = content.getElementVolumeHeaderAnchor();
			volumeHeader.setHref(volumeHeader.getHref()+queryString);
			HTMLAnchorElement authorHeader = content.getElementAuthorHeaderAnchor();
			authorHeader.setHref(authorHeader.getHref()+queryString);
			HTMLAnchorElement headwordHeader = content.getElementHeadwordHeaderAnchor();
			headwordHeader.setHref(headwordHeader.getHref()+queryString);
			HTMLAnchorElement creationdateHeader = content.getElementCreationdateHeaderAnchor();
			creationdateHeader.setHref(creationdateHeader.getHref()+queryString);
			HTMLAnchorElement statusHeader = content.getElementStatusHeaderAnchor();
			statusHeader.setHref(statusHeader.getHref()+queryString);
			HTMLAnchorElement reviewerHeader = content.getElementReviewerHeaderAnchor();
			reviewerHeader.setHref(reviewerHeader.getHref()+queryString);
			HTMLAnchorElement reviewdateHeader = content.getElementReviewdateHeaderAnchor();
			reviewdateHeader.setHref(reviewdateHeader.getHref()+queryString);
			
            HTMLTableRowElement entryListRow = content.getElementEntryListRow();
            HTMLElement theDate = content.getElementCreationDate();
            HTMLAnchorElement viewContribAnchor = content.getElementViewContribAnchor();
            HTMLAnchorElement viewXmlAnchor = content.getElementViewXmlAnchor();
            HTMLAnchorElement editContribAnchor = content.getElementEditContribAnchor();
            HTMLAnchorElement removeContribAnchor = content.getElementRemoveContribAnchor();
            HTMLAnchorElement reviseContribAnchor = content.getElementReviseContribAnchor();
            HTMLAnchorElement validateContribAnchor = content.getElementValidateContribAnchor();
            HTMLElement removeMessageElement = content.getElementRemoveMessage();

            theDate.removeAttribute("id");
            viewContribAnchor.removeAttribute("id");
            viewXmlAnchor.removeAttribute("id");
            editContribAnchor.removeAttribute("id");
            removeContribAnchor.removeAttribute("id");
            reviseContribAnchor.removeAttribute("id");
            validateContribAnchor.removeAttribute("id");
            removeMessageElement.removeAttribute("id");
			
						
			String removeMessage = Utility.getText(removeMessageElement);

            // On rÈcupËre le noeud contenant la table...
            Node entryTable = entryListRow.getParentNode();
            if (null != EntryCollection && EntryCollection.size()>0) {
				PapillonLogger.writeDebugMsg("addEntryTable " + EntryCollection.size());
				content.setTextContributionsCount("" + EntryCollection.size());
				for(Iterator entriesIterator = EntryCollection.iterator(); entriesIterator.hasNext();) {
                    Contribution myContrib = (Contribution) entriesIterator.next();
					if (myContrib !=null && !myContrib.isEmpty()) {
					VolumeEntry myEntry = VolumeEntriesFactory.findEntryByEntryId(myContrib.getVolumeName(),myContrib.getEntryId());
					XslSheet xmlSheet = XslSheetFactory.findXslSheetByName("XML");
                        String xslid = "";
                        if (null != xmlSheet && !xmlSheet.isEmpty()) {
                            xslid = xmlSheet.getHandle();
                        } 					
					// FIXME: hack for the GDEF estonian volume
						String headword = myContrib.getHeadword();
						if (myContrib.getVolumeName().equals("GDEF_est")) {
							if (myEntry!=null && !myEntry.isEmpty()) {
								String particule = myEntry.getParticule();
								if(particule!=null && !particule.equals("")) {
									headword = particule + " " + headword;
								}
							}
						}
                        content.setTextViewContribText(headword);
                        viewContribAnchor.setHref(this.getUrl() + "?"
												  + VIEW_CONTRIB_PARAMETER + "=on&"
                                                  + CONTRIBID_PARAMETER + "="
                                                  + myContrib.getHandle()
												  + queryString);

                        viewXmlAnchor.setHref(this.getUrl() + "?"
											  + VIEW_CONTRIB_PARAMETER + "=on&"
                                              + CONTRIBID_PARAMETER + "="
                                              + myContrib.getHandle() + "&"
                                              + XSLID_PARAMETER + "="
                                              + xslid
											  + queryString);

                        content.setTextVolumeName(myContrib.getVolumeName());
                        content.setTextAuthor(myContrib.getAuthor());
                        content.setTextCreationDate(myContrib.getCreationDate().toString());
                        content.setTextStatus(myContrib.getStatus());
												
						// edit contrib
						// FIXME hack because we cannot reedit yet axies ...
						if (!myContrib.getVolumeName().equals(PapillonPivotFactory.VOLUMENAME)
							&& myEntry!=null && !myEntry.isEmpty()
							&& (this.getUser().isInNormalGroups(myContrib.getGroupsArray())
							|| this.getUser().isValidator())) {
							editContribAnchor.setHref(EditURL + "?"
                                                  + EditVolumeParameter + "="
                                                  + myContrib.getVolumeName() + "&"
                                                  + EditHandleParameter + "="
                                                  + myEntry.getHandle());
						}
						else {
							content.setTextEditMessage("");
						}
						
						// remove contrib
						if (this.getUser().getLogin().equals(myContrib.getAuthor())
							|| this.getUser().isInNormalGroups(myContrib.getGroupsArray())
							|| this.getUser().isValidator()) {
							removeContribAnchor.setHref(this.getUrl() + "?"
								   + REMOVE_CONTRIB_PARAMETER + "=on&"
								   + CONTRIBID_PARAMETER + "="
								   + myContrib.getHandle()
								   + queryString);
							content.setTextRemoveMessage(removeMessage);
						}
						else {
							content.setTextRemoveMessage("");
						}

						// revisions on the contrib
						if (myContrib.getReviewer()!=null && myContrib.getReviewDate()!=null) {
							content.setTextReviewer(myContrib.getReviewer());
							content.setTextReviewDate(myContrib.getReviewDate().toString());
						}
						else {
							content.setTextReviewer("");
							content.setTextReviewDate("");
						}
						// action on contrib
						if (myContrib.getStatus()!=null) {
							if (myContrib.getStatus().equals(Contribution.FINISHED_STATUS)
								&& this.getUser().isSpecialist() 
								&& this.getUser().isInNormalGroups(myContrib.getGroupsArray())) {
								reviseContribAnchor.setHref(this.getUrl() + "?"
									 + REVISE_CONTRIB_PARAMETER + "=on&"
									 + CONTRIBID_PARAMETER + "="
									 + myContrib.getHandle()
								     + queryString);
								reviseContribAnchor.setAttribute("class","");	 
							}
							else {
								reviseContribAnchor.setAttribute("class","hidden");	 
							}
							if (myContrib.getStatus().equals(Contribution.REVISED_STATUS)
								&& this.getUser().isValidator()) {
								validateContribAnchor.setHref(this.getUrl() + "?"
									 + VALIDATE_CONTRIB_PARAMETER + "=on&"
									 + CONTRIBID_PARAMETER + "="
									 + myContrib.getHandle()
								     + queryString);
								validateContribAnchor.removeAttribute("class");	 
							}
							else {
								validateContribAnchor.setAttribute("class","hidden");	 
							}
						}
                        
                        HTMLElement clone = (HTMLElement)entryListRow.cloneNode(true);
                        //      we have to take off the id attribute because we did not take it off the original
                        clone.removeAttribute("id");
                        entryTable.appendChild(clone);
                    }
					}
                }
            }

    protected void addElement (Element element, String table, String handle)
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
