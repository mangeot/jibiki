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
 * Revision 1.4  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.3  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.2.2.3  2005/03/30 11:17:07  mangeot
 * Modified table contributions: replaced originalhandle by originalid
 * Corrected a few bugs when validating an already existing entry
 *
 * Revision 1.2.2.2  2005/03/29 15:27:09  mangeot
 * Bug fix when trying to create a contribution from an existing entry
 *
 * Revision 1.2.2.1  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.3  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.2  2004/09/18 18:26:30  mangeot
 * Bug corrected
 *
 * Revision 1.1  2004/09/18 17:27:15  mangeot
 * It is a new version of the editor
 *
 */

package fr.imag.clips.papillon.presentation;


//General java imports
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

// DOM imports
import org.w3c.dom.html.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;


// HTML source import
import fr.imag.clips.papillon.presentation.xhtml.orig.*;

//local imports
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;



public class EditEntryInit extends BasePO {

    protected final static String HANDLE_PARAMETER = "handle";

    protected final static String ContributionsURL = "AdminContributions.po";
    protected final static String ContributionsVolumeParameter = "VOLUME";

    protected final static String ConsultExpertURL = "ConsultExpert.po";
    protected final static String ConsultExpertVolumeParameter = "VOLUME";
    protected final static String ConsultExpertHandleParameter = "handle";
    protected final static String ConsultExpertXslidParameter = "xslid";
    protected final static String EditEntryURL = "EditEntry.po";

    protected final static int STEP_INIT = 1;
    protected final static int STEP_LOOKUP_EDIT = 2;
    protected final static int STEP_CREATE = 3;
    protected final static int STEP_EDIT = 4;

    protected EditEntryInitXHTML content;

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
	java.io.UnsupportedEncodingException,
	java.io.IOException,
	fr.imag.clips.papillon.business.PapillonBusinessException {

	    // Content creation
	    content = (EditEntryInitXHTML)MultilingualXHtmlTemplateFactory.createTemplate("EditEntryInitXHTML", this.getComms(), this.getSessionData());

	    // On regarde d'abord les parametres qui nous sont demandes.
		String submitLookupEdit = myGetParameter(content.NAME_LookupEdit);
		String submitCreate = myGetParameter(content.NAME_CreateAnyway);		
		String volume = myGetParameter(content.NAME_VOLUME);
		String headword = myGetParameter(content.NAME_Headword);
		String partialMatch = myGetParameter(content.NAME_PartialMatch);
		String entryHandle = myGetParameter(HANDLE_PARAMETER);
		
		if (volume!=null &&!volume.equals("")) {
			this.setPreference(content.NAME_VOLUME,volume);
		}
		else {
			volume = this.getPreference(content.NAME_VOLUME);
		}

		int strategy = IQuery.STRATEGY_EXACT;
		if (null != partialMatch && !partialMatch.equals("")) {
			strategy = IQuery.STRATEGY_SUBSTRING;
		}

		int step = STEP_INIT;
		if (submitLookupEdit!=null &&!submitLookupEdit.equals("")
			&& volume!=null && !volume.equals("")
			&& headword!=null && !headword.equals("")) {
			step = STEP_LOOKUP_EDIT;
		}
		else if (submitCreate!=null && !submitCreate.equals("")
			&& volume!=null && !volume.equals("") 
			&& headword!=null && !headword.equals("")) {
			step = STEP_CREATE;
		}
		else if (volume!=null && !volume.equals("") 
			&& entryHandle!=null && !entryHandle.equals("")) {
			step = STEP_EDIT;
		}
	    User myUser = getUser();
	    if (null != myUser) {
			content.setTextUserName(myUser.getName());
	    }
		VolumeEntry myEntry = null;
		Contribution myContrib = null;
				
	    switch (step) {
		case STEP_LOOKUP_EDIT:
		    volume = myGetParameter(content.NAME_VOLUME);
			displayLookupResults(volume, headword, strategy, this.getUserPreferredLanguage());
		    break;
		case STEP_CREATE:
			myEntry = VolumeEntriesFactory.createEmptyEntry(volume);
			myEntry.setHeadword(headword);
			myEntry.setId();
			myEntry.save();
			myContrib = ContributionsFactory.createContributionFromVolumeEntry(myEntry, myUser, null);
			myContrib.save();
			String headwordParam = myUrlEncode(headword);
		    throw new ClientPageRedirectException(EditEntryURL + "?" + EditEntry.VolumeName_PARAMETER + "=" + volume + 
			"&" + EditEntry.Headword_PARAMETER + "=" + headwordParam + 
			"&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
		case STEP_EDIT:
			myEntry = VolumeEntriesFactory.findEntryByHandle(volume, entryHandle);
			// if myAnswer is contribution
			myContrib = ContributionsFactory.findContributionByEntryHandle(entryHandle);
			boolean isMyContrib =  (myContrib !=null && !myContrib.IsEmpty() && myContrib.getAuthor().equals(this.getUser().getLogin()));
			
			// if there is an existing contribution and it is myUser's one
			if (isMyContrib) {
		    throw new ClientPageRedirectException(EditEntryURL + "?" + EditEntry.VolumeName_PARAMETER + "=" + myEntry.getVolumeName() + 
			"&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
			}
						
			// if it is a modification of an existing entry and myUser has no previous contributions on it
			else {
				VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
				newEntry.save();
				myContrib = ContributionsFactory.createContributionFromVolumeEntry(newEntry, myUser, myEntry.getId());
				myContrib.save();
				throw new ClientPageRedirectException(EditEntryURL + "?" + EditEntry.VolumeName_PARAMETER + "=" + newEntry.getVolumeName() + 
				"&" + EditEntry.EntryHandle_PARAMETER + "=" + newEntry.getHandle());
			}
		default:
		    removeEntryListTable();
		    break;
	    }
		displayLookupInterface(volume, headword);
	    return content.getElementEditEntryInitContent();
	}

    protected void displayLookupInterface(String volume, String headword)
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

    protected void displayLookupResults (String volumeName, String headword, int strategy, String lang)
	throws PapillonBusinessException,
	java.io.UnsupportedEncodingException,
	HttpPresentationException {

	    String[] Headwords = {headword};

	    Collection EntryCollection = DictionariesFactory.getVolumeEntriesCollection(volumeName, this.getUser(), Headwords, strategy);


	    if (EntryCollection != null && EntryCollection.size()>0) {
		    addEntriesTable(EntryCollection);
		}
	    else {
			this.getSessionData().writeUserMessage("Sorry, entry not found! Please check the volume.");
			removeEntryListTable();
		}
	}

    protected void addEntriesTable (Collection EntryCollection) throws
	fr.imag.clips.papillon.business.PapillonBusinessException {

	    // On récupère les éléments du layout
	    HTMLTableRowElement entryListRow = content.getElementEntryListRow();
		HTMLAnchorElement entryIdAnchor = content.getElementViewEntryAnchor();
		HTMLAnchorElement contribAnchor = content.getElementContribAnchor();
	    HTMLElement headwordElement = content.getElementHeadwordList();
	    HTMLElement posElement = content.getElementPosList();
	    HTMLAnchorElement editAnchor = content.getElementEditEntryAnchor();
	    HTMLAnchorElement viewXmlAnchor = content.getElementViewXmlEntryAnchor();

		// Recuperating the elements for the formula
		HTMLTableRowElement formulaRow = content.getElementFormulaRow();
		HTMLElement formulaElement = content.getElementFormula();
		

	    //      we don't take off the id attribute because we will take the element off later...
     //      entryListRow.removeAttribute("id");
		entryIdAnchor.removeAttribute("id");
		contribAnchor.removeAttribute("id");
	    headwordElement.removeAttribute("id");
	    posElement.removeAttribute("id");
	    editAnchor.removeAttribute("id");
	    viewXmlAnchor.removeAttribute("id");
		formulaElement.removeAttribute("id");


	    // On récupère le noeud contenant la table...
	    Node entryTable = entryListRow.getParentNode();
	    if (null != EntryCollection) {
			for(Iterator entriesIterator = EntryCollection.iterator(); entriesIterator.hasNext();) {
		    VolumeEntry myEntry = (VolumeEntry)entriesIterator.next();

		    // The headword
		    content.setTextHeadwordList(myEntry.getHeadword());

			// The entry id
		    String href = ConsultExpertURL + "?"
			+ ConsultExpertVolumeParameter + "="
			+ myEntry.getVolumeName() + "&"
			+ ConsultExpertHandleParameter + "="
			+ myEntry.getHandle();
			
		    entryIdAnchor.setHref(href);

			content.setTextEntryIdList(myEntry.getId());
			
			// The Contribution text and anchor
			Contribution myContrib = ContributionsFactory.findContributionByEntryHandle(myEntry.getHandle());
			boolean IsContrib = (myContrib != null && !myContrib.IsEmpty());
			if (IsContrib) {
					content.setTextContribution(new Boolean(IsContrib).toString() + " " + myContrib.getAuthor() + " " + myContrib.getCreationDate().toString());			
			} 
			else {
					content.setTextContribution(new Boolean(IsContrib).toString());
			}
				String contribHref = ContributionsURL + "?"
						+ ContributionsVolumeParameter + "="
						+ myEntry.getVolumeName();
					contribAnchor.setHref(contribHref);
					

		    // The pos
			content.setTextPosList(myEntry.getPos());

		    // The edit anchor
		   href = this.getUrl() + "?"
			+ content.NAME_VOLUME + "="
			+ myEntry.getVolumeName() + "&"
			+ HANDLE_PARAMETER + "="
			+ myEntry.getHandle();
		    editAnchor.setHref(href);

		    // The view XML anchor
			XslSheet xmlSheet = XslSheetFactory.findXslSheetByName("XML");
			String xslid = "";
			if (null != xmlSheet && !xmlSheet.IsEmpty()) {
				xslid = xmlSheet.getHandle();
			} 
		    href = ConsultExpertURL + "?"
			+ ConsultExpertVolumeParameter + "="
			+ myEntry.getVolumeName() + "&"
			+ ConsultExpertHandleParameter + "="
			+ myEntry.getHandle() + "&"
			+ ConsultExpertXslidParameter + "="
			+ xslid; 
			
			viewXmlAnchor.setHref(href);

			// The formula
			content.setTextFormula(myEntry.getDefinition());


			HTMLElement cloneEntry = (HTMLElement)entryListRow.cloneNode(true);
			HTMLElement cloneFormula = (HTMLElement)formulaRow.cloneNode(true);

		    //      we have to take off the id attribute because we did not take it off the original
			cloneEntry.removeAttribute("id");
			cloneFormula.removeAttribute("id");
			entryTable.appendChild(cloneEntry);
			entryTable.appendChild(cloneFormula);
		}
		removeEntryListTemplate();
	    }
	}
	
    protected void removeEntryListTemplate() {
		Element myElement = content.getElementEntryListRow();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
		 myElement = content.getElementFormulaRow();
		 myParent = myElement.getParentNode();
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

