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
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.12  2004/10/28 10:44:12  mangeot
 * Added the possibility to sort by columns
 *
 * Revision 1.11  2004/10/16 09:47:47  mangeot
 * New mechanism for reviewing the contributions:
 * Step 1 revision, the status of the contrib is modified
 * Step 2 validation, the status of the contrib is modified
 * Step 3 integration into the database, the contrib is deleted and the entry inserted into the corresponding volume
 *
 * Revision 1.10  2004/09/18 17:26:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2004/03/11 16:12:23  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2004/03/11 15:13:32  mangeot
 * Finalisation de la revision des contributions
 *
 * Revision 1.7  2004/03/08 04:20:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2004/02/16 08:08:11  mangeot
 * bugs fix for reviewContributions
 *
 * Revision 1.5  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.4.2.1  2004/01/08 09:43:21  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.4  2003/08/25 07:35:23  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/08/21 04:47:56  mangeot
 * Cleaning the new menu
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
 * Revision 1.1.2.8  2003/08/14 04:15:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.7  2003/08/09 07:21:07  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.1.2.6  2003/08/07 06:29:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.5  2003/08/05 05:18:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.4  2003/06/23 05:28:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.3  2003/06/21 17:56:40  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.2  2003/05/29 03:50:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.1  2003/05/28 09:18:50  mangeot
 * *** empty log message ***
 *
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


public class ReviewContributions extends BasePO {

	
    protected final static int MaxDisplayedEntries= 5;

	protected final static int STEP_DEFAULT = 1;
	protected final static int STEP_LOOKUP = 2;
	protected final static int STEP_VIEW = 3;
	protected final static int STEP_REMOVE = 4;
	protected final static int STEP_REVISE = 5;
	protected final static int STEP_VALIDATE = 6;

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
    
    protected static ReviewContributionsTmplHTML content;

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
        content = (ReviewContributionsTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("ReviewContributionsTmplHTML", this.getComms(), this.getSessionData());

        HttpPresentationRequest req = this.getComms().request;
        
           // decoding the CGI arguments
		String volume = myGetParameter(content.NAME_VOLUME);
		String author = myGetParameter(content.NAME_AUTHOR);
		String contribid = myGetParameter(CONTRIBID_PARAMETER);
		String xslid = myGetParameter(XSLID_PARAMETER);
		String headword = myGetParameter(content.NAME_HEADWORD);
		String partialMatch = myGetParameter(content.NAME_PartialMatch);
		String sortBy = myGetParameter(SORTBY_PARAMETER);
		String queryString = "";
		int strategy = IQuery.STRATEGY_EXACT;
		if (null != partialMatch && !partialMatch.equals("")) {
			strategy = IQuery.STRATEGY_SUBSTRING;
			queryString += "&" + content.NAME_PartialMatch + "=" + partialMatch;
		}
		if (volume!=null &&!volume.equals("")) {
			this.setPreference(content.NAME_VOLUME,volume);
		}
		else {
			volume = this.getPreference(content.NAME_VOLUME);
		}
		if (volume !=null && !volume.equals("")) {
			queryString += "&" + content.NAME_VOLUME + "=" + volume;
		}
		if (author !=null && !author.equals("")) {
			queryString += "&" + content.NAME_AUTHOR + "=" + author;
		}
		if (headword !=null && !headword.equals("")) {
			queryString += "&" + content.NAME_HEADWORD + "=" + headword;
		}

		int step = STEP_DEFAULT;

		if (null != myGetParameter(content.NAME_Lookup)) {
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
				addContributions(volume, author, headword, strategy, sortBy, queryString);
				break;
			case STEP_LOOKUP:
				addContributions(volume, author, headword, strategy, sortBy, queryString);
				break;
			case STEP_VIEW:
				addContribution(contribid, xslid, queryString);
				break;
			case STEP_REMOVE:
				contribid = myGetParameter(CONTRIBID_PARAMETER);
				if (contribid !=null && !contribid.equals("")) {
					Contribution myContrib = ContributionsFactory.findContributionByHandle(contribid);
					if (null != myContrib && !myContrib.IsEmpty()) {
						userMessage = "Contribution " +  myContrib.getHandle() + " / " +
						myContrib.getHeadword() + " removed...";
						volume = myContrib.getVolumeName();
						myContrib.delete();
					}
				}
				addContributions(volume, author, headword, strategy, sortBy, queryString);
				break;
			case STEP_REVISE:
				contribid = myGetParameter(CONTRIBID_PARAMETER);
				if (contribid !=null && !contribid.equals("") && this.getUser().IsSpecialist()) {
					Contribution myContrib = ContributionsFactory.findContributionByHandle(contribid);
					if (null != myContrib && !myContrib.IsEmpty()
					&& null != myContrib.getStatus() && myContrib.getStatus().equals(Contribution.FINISHED_STATUS)) {
						VolumeEntry myEntry = VolumeEntriesFactory.findEntryByHandle(myContrib.getVolumeName(),myContrib.getEntryHandle());
						//Adding modifications in the XML code
						IAnswerFactory.setModification(myEntry,this.getUser().getLogin(),Contribution.REVISED_STATUS);
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
				addContributions(volume, author, headword, strategy, sortBy, queryString);
				break;
			case STEP_VALIDATE:
				if (contribid !=null && !contribid.equals("") && this.getUser().IsValidator()) {
					Contribution myContrib = ContributionsFactory.findContributionByHandle(contribid);
					if (null != myContrib && !myContrib.IsEmpty() &&
						null != myContrib.getStatus() && myContrib.getStatus().equals(Contribution.REVISED_STATUS)) {
						VolumeEntry myEntry = VolumeEntriesFactory.findEntryByHandle(myContrib.getVolumeName(),myContrib.getEntryHandle());
						//Adding modifications in the XML code
						IAnswerFactory.setModification(myEntry,this.getUser().getLogin(),Contribution.VALIDATED_STATUS);
						if (!myContrib.IsNewEntry()) {
							VolumeEntry origEntry = VolumeEntriesFactory.findEntryByHandle(myContrib.getVolumeName(),myContrib.getOriginalHandle());
							origEntry.replaceData(myEntry);
							origEntry.save();
							myEntry.delete();
						}
						else {
							myEntry.save();
						}
						userMessage = "Contribution " +  myContrib.getHandle() + " / " +
						myContrib.getHeadword() + " integrated in the dictionary...";
						volume = myContrib.getVolumeName();
						myContrib.delete();
					}
				}
				addContributions(volume, author, headword, strategy, sortBy, queryString);
				break;
			default:
				break;
			}	
			
            if (null != userMessage && !userMessage.equals("")){
                this.getSessionData().writeUserMessage(userMessage);
                PapillonLogger.writeDebugMsg(userMessage);
            }
           
        addConsultForm(volume);

        
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

    protected void addContributions(String volume, String author, String headword, int strategy, String sortBy, String queryString)
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
			Collection EntryCollection = ContributionsFactory.getContributions(volume, author, strategy, Headwords, sortBy);
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
						IAnswer myAnswer = DictionariesFactory.findAnswerByHandle(myContrib.getVolumeName(),myContrib.getEntryHandle());
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
                        XslSheet xmlSheet = XslSheetFactory.findXslSheetByName("XML");
                        String xslid = "";
                        if (null != xmlSheet && !xmlSheet.IsEmpty()) {
                            xslid = xmlSheet.getHandle();
                        } 					
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
							&& (this.getUser().IsInNormalGroups(myContrib.getGroupsArray())
							|| this.getUser().IsValidator())) {
							editContribAnchor.setHref(EditURL + "?"
                                                  + EditVolumeParameter + "="
                                                  + myContrib.getVolumeName() + "&"
                                                  + EditHandleParameter + "="
                                                  + myContrib.getEntryHandle());
						}
						else {
							content.setTextEditMessage("");
						}
						
						// remove contrib
						if (this.getUser().getLogin().equals(myContrib.getAuthor())
							|| this.getUser().IsInNormalGroups(myContrib.getGroupsArray())
							|| this.getUser().IsValidator()) {
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
								&& this.getUser().IsSpecialist() 
								&& this.getUser().IsInNormalGroups(myContrib.getGroupsArray())) {
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
								&& this.getUser().IsValidator()) {
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
