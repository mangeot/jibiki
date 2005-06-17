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
 * Revision 1.4  2005/06/17 16:36:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2005/06/17 15:51:32  mangeot
 * Modified changeAuthor
 *
 * Revision 1.2  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.1.2.1  2005/06/14 11:56:16  mangeot
 * Added a new page ChangeAuthor for changing the author of a set of previously selected contributions
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.enhydra.xml.xhtml.dom.*;
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


public class ChangeAuthor extends PapillonBasePO {

	
    protected final static int MaxDisplayedEntries= 5;

	protected final static int STEP_DEFAULT = 1;
	protected final static int STEP_LOOKUP = 2;
	protected final static int STEP_CHANGE_AUTHOR = 3;

	protected final static String ALL="*ALL*";
	protected final static String EditURL="EditEntry.po";
	protected final static String EditVolumeParameter=EditEntry.VolumeName_PARAMETER;
	protected final static String EditHandleParameter=EditEntry.EntryHandle_PARAMETER;

	protected final static String VIEW_CONTRIB_PARAMETER="ViewContrib";
	protected final static String AnyContains_PARAMETER="AnyContains";
	protected final static String OFFSET_PARAMETER="OFFSET";
	protected final static String REMOVE_CONTRIB_PARAMETER="RemoveContrib";
	protected final static String REVISE_CONTRIB_PARAMETER="ReviseContrib";
	protected final static String VALIDATE_CONTRIB_PARAMETER="ValidateContrib";
	protected final static String CONTRIBID_PARAMETER="ContribId";
    protected final static String XSLID_PARAMETER="xslid";
    protected final static String SORTBY_PARAMETER="SortBy";
	
	protected final static String AND_CONNECTOR = "AND";
    protected final static String OR_CONNECTOR = "OR";

    
    protected static ChangeAuthorTmplXHTML content;

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean userMayUseThisPO() {
        try {
            return this.getUser().isValidator();
        } catch (fr.imag.clips.papillon.business.PapillonBusinessException ex) {
            this.getSessionData().writeUserMessage("Error getting the authorisation to use this PO.");
        }
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
        content = (ChangeAuthorTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("ChangeAuthorTmplXHTML", this.getComms(), this.getSessionData());

   //     HttpPresentationRequest req = this.getComms().request;
        
		// decoding the CGI arguments
		String queryString = "";
		
			String lookup = myGetParameter(content.NAME_LOOKUP);
			String changeAuthor = myGetParameter(content.NAME_ChangeAuthor);
			String volume = myGetParameter(content.NAME_VOLUME);
			String newAuthor = myGetParameter(content.NAME_NewAuthor);
						
			if (volume!=null &&!volume.equals("")) {
				this.setPreference(content.NAME_VOLUME,volume);
			}
			else {
				volume = this.getPreference(content.NAME_VOLUME);
			}
			
			if (volume!=null && !volume.equals("")) {
				queryString += "&" + content.NAME_VOLUME + "=" + volume;
			}
			
			//author
			String author = myGetParameter(content.NAME_AUTHOR);
			if (lookup !=null && !lookup.equals("")) {
				this.setPreference(content.NAME_AUTHOR,author);
			}
			else {
				author = this.getPreference(content.NAME_AUTHOR);
			}
			if (author !=null && !author.equals("")) {
				queryString += "&" + content.NAME_AUTHOR + "=" + author;
			}

			// reviewer
			String reviewer = myGetParameter(content.NAME_REVIEWER);
			if (lookup !=null && !lookup.equals("")) {
				this.setPreference(content.NAME_REVIEWER,reviewer);
			}
			else {
				reviewer =  this.getPreference(content.NAME_REVIEWER);
			}
			if (reviewer !=null && !reviewer.equals("")) {
				queryString += "&" + content.NAME_REVIEWER + "=" + reviewer;
			}

			// CreationDate
			String creationDate = myGetParameter(content.NAME_CreationDate);
			if (lookup !=null && !lookup.equals("")) {
				this.setPreference(content.NAME_CreationDate, creationDate);
			} else {
				creationDate = this.getPreference(content.NAME_CreationDate);
			}
			if (creationDate !=null && !creationDate.equals("")) {
				queryString += "&" + content.NAME_CreationDate + "=" + creationDate;
			}
			String creationDateStrategyString = myGetParameter(content.NAME_StrategyCreationDate);
			if (creationDateStrategyString != null && !creationDateStrategyString.equals("")) {
				this.setPreference(content.NAME_StrategyCreationDate, creationDateStrategyString);
			} else {
				creationDateStrategyString = this.getPreference(content.NAME_StrategyCreationDate);
			}
			int creationDateStrategy = IQuery.STRATEGY_NONE;
			if (null != creationDateStrategyString && !creationDateStrategyString.equals("")) {
				creationDateStrategy = Integer.parseInt(creationDateStrategyString);
			}
			if (creationDateStrategyString !=null && !creationDateStrategyString.equals("")) {
				queryString += "&" + content.NAME_StrategyCreationDate + "=" + creationDateStrategyString;
			}
			
			// ReviewDate
			String reviewDate = myGetParameter(content.NAME_ReviewDate);
			if (lookup !=null && !lookup.equals("")) {
				this.setPreference(content.NAME_ReviewDate, reviewDate);
			} else {
				reviewDate = this.getPreference(content.NAME_ReviewDate);
			}
			if (reviewDate !=null && !reviewDate.equals("")) {
				queryString += "&" + content.NAME_ReviewDate + "=" + reviewDate;
			}
			String reviewDateStrategyString = myGetParameter(content.NAME_StrategyReviewDate);
			if (reviewDateStrategyString != null && !reviewDateStrategyString.equals("")) {
				this.setPreference(content.NAME_StrategyReviewDate, reviewDateStrategyString);
			} else {
				reviewDateStrategyString = this.getPreference(content.NAME_StrategyReviewDate);
			}
			int reviewDateStrategy = IQuery.STRATEGY_NONE;
			if (null != reviewDateStrategyString && !reviewDateStrategyString.equals("")) {
				reviewDateStrategy = Integer.parseInt(reviewDateStrategyString);
			}
			if (reviewDateStrategyString !=null && !reviewDateStrategyString.equals("")) {
				queryString += "&" + content.NAME_StrategyReviewDate + "=" + reviewDateStrategyString;
			}
			
			// search1
			String search1 = myGetParameter(content.NAME_search1);
			if (search1 != null && !search1.equals("")) {
				this.setPreference(content.NAME_search1, search1);
			} else {
				search1 = this.getPreference(content.NAME_search1);
			}
			if (search1 !=null && !search1.equals("")) {
				queryString += "&" + content.NAME_search1 + "=" + search1;
			}
			String search1text = myGetParameter(content.NAME_search1text);
			if (search1text !=null && !search1text.equals("")) {
				queryString += "&" + content.NAME_search1text + "=" + search1text;
			}
			
			// search2
			String search2 = myGetParameter(content.NAME_search2);
			if (search2 != null && !search2.equals("")) {
				this.setPreference(content.NAME_search2, search2);
			} else {
				search2 = this.getPreference(content.NAME_search2);
			}
			if (search2 !=null && !search2.equals("")) {
				queryString += "&" + content.NAME_search2 + "=" + search2;
			}
			String search2text = myGetParameter(content.NAME_search2text);
			if (search2text !=null && !search2text.equals("")) {
				queryString += "&" + content.NAME_search2text + "=" + search2text;
			}
			
			String anyContains = null;
			
			
			if (null != search1 && null != search1text && !search1text.equals("")) {
				if (search1.equals(AnyContains_PARAMETER)) {
					anyContains = search1text;
				}
			}
			
			if (null != search2 && null != search2text && !search2text.equals("")) {
				if (search2.equals(AnyContains_PARAMETER)) {
					anyContains = search2text;
				}
			}
			
			// strategy1
			String strategyString1 = myGetParameter(content.NAME_Strategy1);
			if (strategyString1 != null && !strategyString1.equals("")) {
				this.setPreference(content.NAME_Strategy1, strategyString1);
			} else {
				strategyString1 = this.getPreference(content.NAME_Strategy1);
			}
			int strategy1 = IQuery.STRATEGY_NONE;
			if (null != strategyString1 && !strategyString1.equals("")) {
				strategy1 = Integer.parseInt(strategyString1);
			}
			if (strategyString1 !=null && !strategyString1.equals("")) {
				queryString += "&" + content.NAME_Strategy1 + "=" + strategyString1;
			}
			
			String strategyString2 = myGetParameter(content.NAME_Strategy2);
			if (strategyString2 != null && !strategyString2.equals("")) {
				this.setPreference(content.NAME_Strategy2, strategyString2);
			} else {
				strategyString2 = this.getPreference(content.NAME_Strategy2);
			}
			int strategy2 = IQuery.STRATEGY_NONE;
			if (null != strategyString2 && !strategyString2.equals("")) {
				strategy2 = Integer.parseInt(strategyString2);
			}
			if (strategyString2 !=null && !strategyString2.equals("")) {
				queryString += "&" + content.NAME_Strategy2 + "=" + strategyString2;
			}
						
			int offset = 0;
			String offsetString = myGetParameter(OFFSET_PARAMETER);
			if (offsetString != null && !offsetString.equals("")) {
				offset = Integer.parseInt(offsetString);
			}
			queryString += "&" + OFFSET_PARAMETER + "=" + offset;
			
			// status
			String status = myGetParameter(content.NAME_STATUS);
			if (lookup!=null &&!lookup.equals("")) {
				this.setPreference(content.NAME_STATUS,status);
			}
			else {
				status =  this.getPreference(content.NAME_STATUS);
			}
			if (status !=null && !status.equals("")) {
				queryString += "&" + content.NAME_STATUS + "=" + status;
			}
			if (status != null && status.equals(ALL)) {
				status = null;
			}
			Vector myKeys1 = new Vector();
			Vector clausesVector = new Vector();
			Volume myVolume = VolumesFactory.findVolumeByName(volume);
			String source = "eng";
			if (myVolume !=null && !myVolume.isEmpty()) {
				source = myVolume.getSourceLanguage();
			}
			if (search1 !=null && !search1.equals("")  &&
				search1text != null && !search1text.equals("")) {
				if (strategy1 == IQuery.STRATEGY_GREATER_THAN ||
					strategy1 == IQuery.STRATEGY_GREATER_THAN_OR_EQUAL ||
					strategy1 == IQuery.STRATEGY_LESS_THAN ||
					strategy1 == IQuery.STRATEGY_LESS_THAN_OR_EQUAL) {
					String clause = "key='" + search1 + "'";
					clause += " and " + source + "_sort(value)" + IQuery.QueryBuilderStrategy[strategy1+1] + " " + source + "_sort('" + search1text +"') "; 
					clausesVector.add(clause);
					}
				else {
					String[] key1 = new String[4];
					key1[0] = search1;
					key1[2] = search1text;
					key1[3] = IQuery.QueryBuilderStrategy[strategy1+1];
					myKeys1.add(key1);
				}
			}
			if (search2 !=null && !search2.equals("") &&
				search2text != null && !search2text.equals("")) {
				if (strategy2 == IQuery.STRATEGY_GREATER_THAN ||
					strategy2 == IQuery.STRATEGY_GREATER_THAN_OR_EQUAL ||
					strategy2 == IQuery.STRATEGY_LESS_THAN ||
					strategy2 == IQuery.STRATEGY_LESS_THAN_OR_EQUAL) {
					String clause = "key='" + search2 + "'";
					clause += " and " + source + "_sort(value)" + IQuery.QueryBuilderStrategy[strategy2+1] + " " + source + "_sort('" + search2text +"') "; 
					clausesVector.add(clause);
				}
				else {
					String[] key2 = new String[4];
					key2[0] = search2;
					key2[2] = search2text;
					key2[3] = IQuery.QueryBuilderStrategy[strategy2+1];
					myKeys1.add(key2);
				}
			}
			if (status !=null && !status.equals("")) {
				String[] key2 = new String[4];
				key2[0] = Volume.CDM_contributionStatus;
				key2[1] = Volume.DEFAULT_LANG;
				key2[2] = status;
				key2[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];			
				myKeys1.add(key2);
			}
			else {
				String[] key2 = new String[4];
				key2[0] = Volume.CDM_contributionStatus;
				key2[1] = Volume.DEFAULT_LANG;
				key2[2] = VolumeEntry.VALIDATED_STATUS;
				key2[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_NOT_EQUAL+1];			
				myKeys1.add(key2);			
				String[] key3 = new String[4];
				key3[0] = Volume.CDM_contributionStatus;
				key3[1] = Volume.DEFAULT_LANG;
				key3[2] = VolumeEntry.DELETED_STATUS;
				key3[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_NOT_EQUAL+1];			
				myKeys1.add(key3);			
			}
			if (author !=null && !author.equals("")) {
				String[] authorKey = new String[4];
				authorKey[0] = Volume.CDM_contributionAuthor;
				authorKey[1] = Volume.DEFAULT_LANG;
				authorKey[2] = author;
				authorKey[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];			
				myKeys1.add(authorKey);
			}
			if (reviewer !=null && !reviewer.equals("")) {
				String[] reviewerKey = new String[4];
				reviewerKey[0] = Volume.CDM_contributionReviewer;
				reviewerKey[1] = Volume.DEFAULT_LANG;
				reviewerKey[2] = reviewer;
				reviewerKey[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];			
				myKeys1.add(reviewerKey);
			}
			if (reviewDate !=null && !reviewDate.equals("")) {
				String[] reviewDateKey = new String[4];
				reviewDateKey[0] = Volume.CDM_contributionReviewDate;
				reviewDateKey[1] = Volume.DEFAULT_LANG;
				reviewDateKey[2] = reviewDate;
				reviewDateKey[3] = IQuery.QueryBuilderStrategy[reviewDateStrategy+1];			
				myKeys1.add(reviewDateKey);
			}
			if (creationDate !=null && !creationDate.equals("")) {
				String[] creationDateKey = new String[4];
				creationDateKey[0] = Volume.CDM_contributionCreationDate;
				creationDateKey[1] = Volume.DEFAULT_LANG;
				creationDateKey[2] = creationDate;
				creationDateKey[3] = IQuery.QueryBuilderStrategy[creationDateStrategy+1];			
				myKeys1.add(creationDateKey);
			}
			

		int step = STEP_DEFAULT;
		if (null != lookup) {
			step = STEP_LOOKUP;
		}
		else if (changeAuthor !=null  && newAuthor != null) {
			step = STEP_CHANGE_AUTHOR;
		}

		String userMessage = null;

		switch (step) {
			case STEP_DEFAULT:
				break;
			case STEP_LOOKUP:
				addContributionsCount(myVolume, myKeys1, clausesVector);
				break;
			case STEP_CHANGE_AUTHOR:
				VolumeEntriesFactory.changeAuthor(myVolume, this.getUser(), newAuthor, myKeys1, clausesVector);
				userMessage = "New author " + newAuthor + " for selected contributions";
				break;
			default:
				break;
			}	
			
            if (null != userMessage && !userMessage.equals("")){
                this.getSessionData().writeUserMessage(userMessage);
                PapillonLogger.writeDebugMsg(userMessage);
            }
           
        addConsultForm(volume, status, author, reviewer, 
			creationDate, creationDateStrategyString, 
			reviewDate, reviewDateStrategyString, 
			search1, search1text, strategyString1, 
			search2, search2text, strategyString2);
        
        //On rend le contenu correct
        return content.getElementFormulaire();
    }
        protected void addConsultForm(String volume, String status, String author, String reviewer, 
			String creationDate, String creationDateStrategyString, 
			String reviewDate, String reviewDateStrategyString, 
			String search1, String search1text, String strategyString1, 
			String search2, String search2text, String strategyString2)
			throws fr.imag.clips.papillon.business.PapillonBusinessException, 
                HttpPresentationException,
        java.io.UnsupportedEncodingException {
                    
        // Adding the user name
		User user = getUser();

		if (null != user && !user.isEmpty()) {
			content.setTextUserName(user.getName());
		}
                    
           // Adding the appropriate source languages to the source list
        XHTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
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

		// author
		XHTMLInputElement authorInput = content.getElementAUTHOR();
		authorInput.setValue(author);
		
		// reviewer
		XHTMLInputElement reviewerInput = content.getElementREVIEWER();
		reviewerInput.setValue(reviewer);

		// creationDate
		XHTMLInputElement creationDateInput = content.getElementInputCreationDate();
		creationDateInput.setValue(creationDate);
		this.setSelected(content.getElementStrategyCreationDate(), creationDateStrategyString);

		// reviewDate
		XHTMLInputElement reviewDateInput = content.getElementInputReviewDate();
		reviewDateInput.setValue(reviewDate);
		this.setSelected(content.getElementStrategyReviewDate(), reviewDateStrategyString);
		
		
			// strategy
			if (!this.IsClientWithLabelDisplayProblems()) {
				this.setUnicodeLabels(content.getElementStrategy1());
			}
			this.setSelected(content.getElementStrategy1(), strategyString1);
			
			if (!this.IsClientWithLabelDisplayProblems()) {
				this.setUnicodeLabels(content.getElementStrategy2());
			}
			this.setSelected(content.getElementStrategy2(), strategyString2);
						
			// Search1 field
			if (search1 == null || search1.equals("")) {
				search1 = Volume.CDM_headword;
			}
			if (!this.IsClientWithLabelDisplayProblems()) {
				this.setUnicodeLabels(content.getElementSearch1());
			}
			this.setSelected(content.getElementSearch1(), search1);
			
			XHTMLInputElement search1Input = content.getElementSearch1text();
			search1Input.setValue(search1text);
			
			// Search2 field
			if (search2 == null || search2.equals("")) {
				search2 = Volume.CDM_pos;
			}
			if (!this.IsClientWithLabelDisplayProblems()) {
				this.setUnicodeLabels(content.getElementSearch2());
			}
			this.setSelected(content.getElementSearch2(), search2);
			
			XHTMLInputElement search2Input = content.getElementSearch2text();
			search2Input.setValue(search2text);
			
			// status
			XHTMLSelectElement statusSelect = (XHTMLSelectElement) content.getElementSTATUS();
			this.setSelected(statusSelect,status);

    }
	
    protected void addContributionsCount(Volume myVolume, Vector Keys1, Vector clausesVector)
        throws PapillonBusinessException {
			int count = VolumeEntriesFactory.getDbTableEntriesCount(myVolume, Keys1, clausesVector, null);
				content.setTextContributionsCount("" + count);
		}
        
	}
