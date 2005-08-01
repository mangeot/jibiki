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
 * Revision 1.15  2005/08/01 08:34:03  mangeot
 * Added method getCompleteHeadword for VolumeEntry that concatenates the homograph number and the particule to the headword
 *
 * Revision 1.14  2005/07/16 16:25:26  mangeot
 * Adapted the linker to the GDEF project + bug fixes
 *
 * Revision 1.13  2005/07/16 13:44:13  mangeot
 * bug fix
 *
 * Revision 1.12  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.11  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.10.4.4  2005/06/10 14:11:55  mangeot
 * *** empty log message ***
 *
 * Revision 1.10.4.3  2005/06/10 14:00:40  mangeot
 * Changed Edit to Copy and Edit when a copy of the original entry is done before editing
 *
 * Revision 1.10.4.2  2005/04/29 17:30:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.10.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.10  2005/04/26 10:11:32  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2005/04/20 10:51:14  mangeot
 * Correction de AddDirectTranslations
 *
 * Revision 1.8  2005/04/19 15:47:06  mangeot
 * Fixed a pb with the id
 *
 * Revision 1.7  2005/04/14 13:08:25  mangeot
 * Deleted all references to findContributionByEntryHandle
 *
 * Revision 1.6  2005/04/14 09:02:40  mangeot
 * Bug fix for headword lookup, wrong source language
 *
 * Revision 1.5  2005/04/13 15:47:41  mangeot
 * *** empty log message ***
 *
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
 * Added persistent preferences for the user. They are saved in the database and retrieved
 * when the user reconnects. The user is registered in the enhydra session.
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



public class EditEntryInit extends PapillonBasePO {

    protected final static String HANDLE_PARAMETER = "handle";

    protected final static String ContributionsURL = "AdminContributions.po";
    protected final static String ContributionsVolumeParameter = "VOLUME";

    protected final static String ConsultExpertURL = "ConsultExpert.po";
    protected final static String ConsultExpertVolumeParameter = "VOLUME";
    protected final static String ConsultExpertHandleParameter = "handle";
    protected final static String ConsultExpertFormatterParameter = "xslid";
    protected final static String EditEntryURL = "EditEntry.po";

    protected final static int STEP_INIT = 1;
    protected final static int STEP_LOOKUP_EDIT = 2;
    protected final static int STEP_CREATE = 3;
    protected final static int STEP_EDIT = 4;

    protected EditEntryInitXHTML content;

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
				
	    switch (step) {
		case STEP_LOOKUP_EDIT:
		    volume = myGetParameter(content.NAME_VOLUME);
			displayLookupResults(volume, headword, strategy, this.getUserPreferredLanguage());
		    break;
		case STEP_CREATE:
			myEntry = VolumeEntriesFactory.createEmptyEntry(volume);
			myEntry.setCreationDate();
			myEntry.setHeadword(headword);
			myEntry.setAuthor(myUser.getLogin());
			myEntry.setGroups(myUser.getGroupsArray());
			myEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
			myEntry.save();
			String headwordParam = myUrlEncode(headword);
		    throw new ClientPageRedirectException(EditEntryURL + "?" + EditEntry.VolumeName_PARAMETER + "=" + volume + 
			"&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
		case STEP_EDIT:
			myEntry = VolumeEntriesFactory.findEntryByHandle(volume, entryHandle);
			if (myEntry.getAuthor().equals(this.getUser().getLogin()) &&
				!myEntry.getStatus().equals(VolumeEntry.VALIDATED_STATUS) &&
				!myEntry.getStatus().equals(VolumeEntry.DELETED_STATUS)) {
				throw new ClientPageRedirectException(EditEntryURL + "?" + EditEntry.VolumeName_PARAMETER + "=" + myEntry.getVolumeName() + 
				"&" + EditEntry.EntryHandle_PARAMETER + "=" + myEntry.getHandle());
			}
			else {
				VolumeEntry newEntry = VolumeEntriesFactory.newEntryFromExisting(myEntry);
				newEntry.setAuthor(myUser.getLogin());
				newEntry.setGroups(myUser.getGroupsArray());
				newEntry.setContributionId();
				newEntry.setOriginalContributionId(myEntry.getContributionId());
				newEntry.setStatus(VolumeEntry.NOT_FINISHED_STATUS);
				newEntry.save();
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

			//Headword[0] = key
			//Headword[1] = lang
			//Headword[2] = value
			//Headword[3] = strategy
		String[] Headword = new String[4];
		Headword[0] = Volume.CDM_headword;
		Headword[1] = null;
		Headword[2] = headword;
		Headword[3] = IQuery.QueryBuilderStrategy[strategy+1];
		Vector myVector = new Vector();
		myVector.add(Headword);

	    Collection EntryCollection = DictionariesFactory.getVolumeEntriesCollection(volumeName, this.getUser(), myVector);


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
	    HTMLElement headwordElement = content.getElementHeadwordList();
	    HTMLElement posElement = content.getElementPosList();
	    HTMLElement authorElement = content.getElementEntryAuthorList();
	    HTMLAnchorElement editAnchor = content.getElementEditEntryAnchor();
	    HTMLAnchorElement viewXmlAnchor = content.getElementViewXmlEntryAnchor();
	    HTMLElement editElement = content.getElementEditMessage();
	    HTMLElement copyElement = content.getElementCopyMessage();

		// Recuperating the elements for the formula
		HTMLTableRowElement formulaRow = content.getElementFormulaRow();
		HTMLElement formulaElement = content.getElementFormula();
		

	    //      we don't take off the id attribute because we will take the element off later...
     //      entryListRow.removeAttribute("id");
		entryIdAnchor.removeAttribute("id");
	    headwordElement.removeAttribute("id");
	    posElement.removeAttribute("id");
	    editAnchor.removeAttribute("id");
	    viewXmlAnchor.removeAttribute("id");
		formulaElement.removeAttribute("id");
		editElement.removeAttribute("id");
		copyElement.removeAttribute("id");
		authorElement.removeAttribute("id");


	    // On récupère le noeud contenant la table...
	    Node entryTable = entryListRow.getParentNode();
	    if (null != EntryCollection) {
			for(Iterator entriesIterator = EntryCollection.iterator(); entriesIterator.hasNext();) {
		    VolumeEntry myEntry = (VolumeEntry)entriesIterator.next();

		    // The headword
		    content.setTextHeadwordList(myEntry.getCompleteHeadword());

			// The entry id
		    String href = ConsultExpertURL + "?"
			+ ConsultExpert.VOLUME_PARAMETER + "="
			+ myEntry.getVolumeName() + "&"
			+ ConsultExpert.HANDLE_PARAMETER + "="
			+ myEntry.getHandle();
			
		    entryIdAnchor.setHref(href);


			// the entry id
			content.setTextEntryIdList(myEntry.getId());
			
		    // The pos
			content.setTextPosList(myEntry.getPos());

		    // The author
			content.setTextEntryAuthorList(myEntry.getAuthor());
			
		    // The status
			content.setTextEntryStatusList(myEntry.getStatus());

		    // The edit anchor
		   href = this.getUrl() + "?"
			+ content.NAME_VOLUME + "="
			+ myEntry.getVolumeName() + "&"
			+ HANDLE_PARAMETER + "="
			+ myEntry.getHandle();
			
			// the Edit button
			if (myEntry.getAuthor().equals(this.getUser().getLogin())
				&& !myEntry.getStatus().equals(VolumeEntry.VALIDATED_STATUS)) {
				editAnchor.setHref(href);
				editElement.setAttribute("class","");
				copyElement.setAttribute("class","hidden");
			}
			else if (myEntry.getStatus().equals(VolumeEntry.VALIDATED_STATUS)) {
				editAnchor.setHref(href);
				copyElement.setAttribute("class","");
				editElement.setAttribute("class","hidden");
			}
			else {
				editAnchor.setHref("");
				copyElement.setAttribute("class","hidden");
				editElement.setAttribute("class","hidden");
			}

		    // The view XML anchor
		    href = ConsultExpertURL + "?"
				+ ConsultExpert.VOLUME_PARAMETER + "="
				+ myEntry.getVolumeName() + "&"
				+ ConsultExpert.HANDLE_PARAMETER + "="
				+ myEntry.getHandle() + "&"
			+ ConsultExpert.FORMATTER_PARAMETER + "="
			+ fr.imag.clips.papillon.business.transformation.XslTransformation.XML_FORMATTER; 
			
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

