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
import fr.imag.clips.papillon.business.transformation.XslTransformation;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.utility.Utility;


public class EditAxie extends BasePO {

    protected final static String ContributionsURL = "AdminContributions.po";
    protected final static String ContributionsVolumeParameter = "VOLUME";
	protected final static String PAPILLON_DICT = "Papillon";
	protected final static String VOLUME_PARAMETER = "VOLUME";
	protected final static String ENTRYID_PARAMETER = "ENTRYID";
	protected final static String STEP_PARAMETER = "STEP";
				


    protected final static int STEP_INIT = 1;
    protected final static int STEP_LOOKUP = 2;
    protected final static int STEP_LINK = 3;
    protected final static int STEP_VIEW = 4;
    protected final static int STEP_CONFIRM = 9;

    protected EditAxieTmplXHTML content;

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
	java.io.UnsupportedEncodingException,
	java.io.IOException,
	fr.imag.clips.papillon.business.PapillonBusinessException {

	    // Content creation
	    content = (EditAxieTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("EditAxieTmplXHTML", this.getComms(), this.getSessionData());

	    // On regarde d'abord les parametres qui nous sont demandes.
		String submitLookup = myGetParameter(content.NAME_Lookup);
		String submitLink = myGetParameter(content.NAME_Link);
		String submitConfirm = myGetParameter(content.NAME_Confirm);

		int step = STEP_INIT;
		String stepString = myGetParameter(STEP_PARAMETER);
		if (stepString != null && !stepString.equals("")) {
			step = Integer.parseInt(stepString);
		}
		

		if (submitLookup != null && !submitLookup.equals("")) {
			step = STEP_LOOKUP;
		}
		if (submitLink != null && !submitLink.equals("")) {
			step = STEP_LINK;
		}
		if (submitConfirm != null && !submitConfirm.equals("")) {
			step = STEP_CONFIRM;
		}
		
	    String login = null;
		String semanticCat =  "";
		String volume1 =  "";
		String volume2 =  "";
		String handle1 = "";
		String handle2 = "";
		

		User myUser = this.getUser();

	    // Actions depending on CGI input parameters

	    switch (step) {
		case STEP_INIT:
		    removeEntryListInterface();
		    break;
		case STEP_LOOKUP:
			volume1 = myGetParameter(content.NAME_VOLUME1);
			volume2 = myGetParameter(content.NAME_VOLUME2);
			String headword1 = myGetParameter(content.NAME_HEADWORD1);
			String headword2 = myGetParameter(content.NAME_HEADWORD2);
			String partialMatch1 = myGetParameter(content.NAME_PartialMatch1);
			String partialMatch2 = myGetParameter(content.NAME_PartialMatch2);

			int strategy1 = IQuery.STRATEGY_EXACT;
			if (null != partialMatch1 && !partialMatch1.equals("")) {
				strategy1 = IQuery.STRATEGY_SUBSTRING;
			}
			int strategy2 = IQuery.STRATEGY_EXACT;
			if (null != partialMatch2 && !partialMatch2.equals("")) {
				strategy2 = IQuery.STRATEGY_SUBSTRING;
			}
				addHiddenVolumes(volume1, volume2);
				displayLookupResults(myUser, volume1, headword1, strategy1, volume2, headword2,strategy2);
			removeConfirmAxiesButton();
		    break;
		case STEP_VIEW:
			volume1 = myGetParameter(VOLUME_PARAMETER);
			handle1 = myGetParameter(ENTRYID_PARAMETER);
			addFullEntry(volume1, handle1);
			removeEntryListTable();
			removeEntryListInterface();

			break;
		case STEP_LINK:
			semanticCat = myGetParameter(content.NAME_SemanticCat);

			volume1 = myGetParameter(content.NAME_VOLUMEHIDDEN1);
			volume2 = myGetParameter(content.NAME_VOLUMEHIDDEN2);

			handle1 = myGetParameter(content.NAME_SelectEntry1);
			handle2 = myGetParameter(content.NAME_SelectEntry2);
			selectSemanticCat(semanticCat);
			addHiddenVolumes(volume1, volume2);
			displayLinkResults(volume1, handle1, volume2, handle2);
			removeLinkAxiesButton();
			
			break;
		case STEP_CONFIRM:
			semanticCat = myGetParameter(content.NAME_SemanticCat);

			volume1 = myGetParameter(content.NAME_VOLUMEHIDDEN1);
			volume2 = myGetParameter(content.NAME_VOLUMEHIDDEN2);

			handle1 = myGetParameter(content.NAME_SelectEntry1);
			handle2 = myGetParameter(content.NAME_SelectEntry2);

			IAnswer myAnswer1 = DictionariesFactory.findAnswerByHandle(volume1, handle1);
			IAnswer myAnswer2 = DictionariesFactory.findAnswerByHandle(volume2, handle2);
			
			
			// looking for existing axies linking these lexies EXPERIMENTAL
			Collection axies = PapillonPivotFactory.findAxiesByLexie(myAnswer1, myUser);
			boolean axieFound = false;
			String entryLang = "";
			String entryId = "";
			
			if (axies ==null || axies.size()==0) {
				axies = PapillonPivotFactory.findAxiesByLexie(myAnswer2, myUser);
				if (axies ==null || axies.size()==0) {
				// No axies were found, we create an axie from scratch	
				}
				else {
					axieFound=true;
					entryLang = myAnswer1.getSourceLanguage();
					entryId = myAnswer1.getId();
				}
			}
			else {
					axieFound=true;
					entryLang = myAnswer2.getSourceLanguage();
					entryId = myAnswer2.getId();
			}
			Contribution myContrib = null;
				if (axieFound) {
					boolean myPreviousContrib = false;
					Axie myAxie = (Axie) ContributionsFactory.myFirstContribution(axies,myUser);
					if (myAxie!=null && !myAxie.IsEmpty()) {
						myPreviousContrib = true;
					}
					else {
						myAxie = (Axie) ContributionsFactory.myFirstGroupContribution(axies,myUser);
						if (myAxie==null || myAxie.IsEmpty()) {
							myAxie= (Axie) axies.iterator().next();
						}
					}
					PapillonPivotFactory.addLanguageLink(myAxie,entryLang,entryId);
					
					// if the existing axie was not my contrib, I have to create a new axie and a new contrib 
					if (!myPreviousContrib) {
						myAxie=PapillonPivotFactory.newAxieFromExisting(myAxie);
						myContrib = ContributionsFactory.createContributionFromAxie(myAxie, myUser);
						myAxie.save();
						myContrib.save();
					}
					else {
						myAxie.save();
					}
				}
			 else {
				Axie myAxie = PapillonPivotFactory.createAxieFromLink(semanticCat, myAnswer1, myAnswer2);
				ContributionsFactory.createContributionFromAxie(myAxie, myUser);
			 }
			

			throw new ClientPageRedirectException(ContributionsURL + "?" + ContributionsVolumeParameter + "=" + PapillonPivotFactory.VOLUMENAME);
		default:
		    removeEntryListInterface();
		    break;
	    }
			displayLookupInterface(volume1, volume2);
	    return content;
	}

    protected void displayLookupInterface(String volume1, String volume2)
		throws fr.imag.clips.papillon.business.PapillonBusinessException,
		HttpPresentationException,
		java.io.UnsupportedEncodingException {
			addVolumeSelectValues(content.getElementVolumeOptionTemplate1(), volume1);
			addVolumeSelectValues(content.getElementVolumeOptionTemplate2(), volume2);
		}

    protected void addVolumeSelectValues(HTMLOptionElement volumeOptionTemplate, String selectedVolume)
	throws fr.imag.clips.papillon.business.PapillonBusinessException,
	HttpPresentationException,
	java.io.UnsupportedEncodingException {

		// Adding the appropriate source languages to the source list
	    Node volumeSelect = volumeOptionTemplate.getParentNode();
	    volumeOptionTemplate.removeAttribute("id");
	    // We assume that the option element has only one text child
     // (it should be this way if the HTML is valid...)
	    Text volumeTextTemplate = (Text)volumeOptionTemplate.getFirstChild();


	    Volume[] AllVolumes = VolumesFactory.getVolumesArray(PAPILLON_DICT);

	    for (int i = 0; i < AllVolumes.length; i++) {
		Volume myVolume = AllVolumes[i];
		String schema = myVolume.getXmlSchema();
		// FIXME: trick to avoid displaying Papillon axies...
		if (schema != null && !schema.equals("") && !myVolume.getName().equals("Papillon_axi")) {
		    volumeOptionTemplate.setValue(myVolume.getName());
		    volumeOptionTemplate.setLabel(myVolume.getName());
		    // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux
      // specs W3C.
		    volumeOptionTemplate.setSelected(myVolume.getName().equals(selectedVolume));
		    volumeTextTemplate.setData(myVolume.getName());
		    volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
		}
	    }
	    volumeSelect.removeChild(volumeOptionTemplate);
	}

    protected void displayLookupResults (User myUser,
										 String volumeName1, String headword1, int strategy1,
										 String volumeName2, String headword2, int strategy2)
		throws PapillonBusinessException,
		java.io.UnsupportedEncodingException,
		HttpPresentationException {

			String[] Headwords1 = {headword1};
			String[] Headwords2 = {headword2};

			Collection EntryVector1 = DictionariesFactory.getVolumeEntriesCollection(volumeName1, myUser, Headwords1, strategy1);
			Collection EntryVector2 = DictionariesFactory.getVolumeEntriesCollection(volumeName2, myUser, Headwords2, strategy2);

			addEntriesTable(EntryVector1, EntryVector2, false);
		}

    protected void displayLinkResults (String volumeName1, String handle1,
										 String volumeName2, String handle2)
		throws PapillonBusinessException,
		java.io.UnsupportedEncodingException,
		HttpPresentationException {
			Collection EntryVector1 = new Vector();
			Collection EntryVector2 = new Vector();
			
			IAnswer myAnswer1 = (IAnswer)DictionariesFactory.findAnswerByHandle(volumeName1, handle1);
			if (myAnswer1 != null && !myAnswer1.IsEmpty()) {
				EntryVector1.add(myAnswer1);
			}
			IAnswer myAnswer2 = (IAnswer)DictionariesFactory.findAnswerByHandle(volumeName2, handle2);
			if (myAnswer2 != null && !myAnswer2.IsEmpty()) {
				EntryVector2.add(myAnswer2);
			}
			addEntriesTable(EntryVector1, EntryVector2, true);
		}

	protected void selectSemanticCat(String semCat) throws
		fr.imag.clips.papillon.business.PapillonBusinessException  {
			HTMLCollection myCollection = content.getElementSemanticCat().getOptions();
			int i=0;
			while (i< myCollection.getLength()) {
				HTMLOptionElement myOptionElement = (HTMLOptionElement) myCollection.item(i);
				if (myOptionElement.getValue().equals(semCat)) {
					myOptionElement.setSelected(true);
					i = myCollection.getLength();
				}
				else {
					i++;
				}
			}
	}

    protected void addEntriesTable (Collection EntryVector1, Collection EntryVector2, boolean checked) throws
	fr.imag.clips.papillon.business.PapillonBusinessException {

	    // Recuperating the elements for the entry
		HTMLTableRowElement entryListRow = content.getElementEntryListRow();

		HTMLInputElement radioEntryElement1 = content.getElementSelectEntry1();
		HTMLInputElement radioEntryElement2 = content.getElementSelectEntry2();
		HTMLElement headwordElement1 = content.getElementHeadwordList1();
		HTMLElement headwordElement2 = content.getElementHeadwordList2();
		HTMLAnchorElement entryAnchor1 = content.getElementSeeEntryAnchor1();
		HTMLAnchorElement entryAnchor2 = content.getElementSeeEntryAnchor2();
		HTMLElement posElement1 = content.getElementPosList1();
		HTMLElement posElement2 = content.getElementPosList2();

		// Recuperating the elements for the formula
		HTMLTableRowElement formulaRow = content.getElementFormulaRow();
		HTMLElement formulaElement1 = content.getElementFormula1();
		HTMLElement formulaElement2 = content.getElementFormula2();


	    //      we don't take off the id attribute because we will take the element off later...
     //      entryListRow.removeAttribute("id");
		radioEntryElement1.removeAttribute("id");
		radioEntryElement2.removeAttribute("id");
		headwordElement1.removeAttribute("id");
		headwordElement2.removeAttribute("id");
		entryAnchor1.removeAttribute("id");
		entryAnchor2.removeAttribute("id");
		posElement1.removeAttribute("id");
		posElement2.removeAttribute("id");
		formulaElement1.removeAttribute("id");
		formulaElement2.removeAttribute("id");

	    // On récupère le noeud contenant la table...
	    Node entryTable = entryListRow.getParentNode();

		int shortSize = 0;
		boolean longVector1 = true;
	    if (null != EntryVector1) {
			if (null != EntryVector2) {
				if (EntryVector1.size() > EntryVector2.size()){
					shortSize = EntryVector2.size();
					longVector1 = true;
				}
				else {
					shortSize = EntryVector1.size();
					longVector1 = false;
				}
			}
			else {
				shortSize = 0;
				longVector1 = true;
			}
		}
		else {
			shortSize = 0;
			longVector1 = false;			
		}
		// both vectors have entries
		Iterator Vector1 = EntryVector1.iterator();
		Iterator Vector2 = EntryVector2.iterator();
		for(int i = 0; i < shortSize; i++) {
			String href;
			IAnswer myEntry1 = (IAnswer)Vector1.next();
			IAnswer myEntry2 = (IAnswer)Vector2.next();

			// The radio entry input
			radioEntryElement1.setValue(myEntry1.getHandle());
			radioEntryElement1.setChecked(checked);
			radioEntryElement2.setValue(myEntry2.getHandle());
			radioEntryElement2.setChecked(checked);
			
		    // The headword
			content.setTextHeadwordList1(myEntry1.getHeadwords());
			content.setTextHeadwordList2(myEntry2.getHeadwords());

			// The entryId1 anchor
			href = this.getUrl() + "?"
				+ VOLUME_PARAMETER + "="
				+ myEntry1.getVolumeName() + "&"
				+ ENTRYID_PARAMETER + "="
				+ myEntry1.getHandle() + "&"
				+ STEP_PARAMETER + "=";
			entryAnchor1.setHref(href + STEP_VIEW);

			// The entryId2 anchor
					href = this.getUrl() + "?"
				+ VOLUME_PARAMETER + "="
				+ myEntry2.getVolumeName() + "&"
				+ ENTRYID_PARAMETER + "="
				+ myEntry2.getHandle() + "&"
				+ STEP_PARAMETER + "=";
			entryAnchor2.setHref(href + STEP_VIEW);

			// The id
			content.setTextEntryIdList1(myEntry1.getId());
			content.setTextEntryIdList2(myEntry2.getId());

			// The pos1			
			if (myEntry1.getType() == IAnswer.LocalEntry) {
				String pos = ((VolumeEntry)myEntry1).getPoss();
				if (pos != null)
					content.setTextPosList1(pos);
			}	

			// The pos2
			if (myEntry2.getType() == IAnswer.LocalEntry) {
				String pos = ((VolumeEntry)myEntry2).getPoss();
				if (pos != null)
					content.setTextPosList2(pos);
			}

			// The formula
			content.setTextFormula1(IAnswerFactory.getDefinitionString(myEntry1));
			content.setTextFormula2(IAnswerFactory.getDefinitionString(myEntry2));
			


			HTMLElement cloneEntry = (HTMLElement)entryListRow.cloneNode(true);
			HTMLElement cloneFormula = (HTMLElement)formulaRow.cloneNode(true);
		    //      we have to take off the id attribute because we did not take it off the original
			cloneEntry.removeAttribute("id");
			cloneFormula.removeAttribute("id");
			entryTable.appendChild(cloneEntry);
			entryTable.appendChild(cloneFormula);
		}
		
		// Vector 1 still has entries
		if (longVector1) {
			Element selectEntry2 = content.getElementSelectEntry2();
			Node select2Parent = selectEntry2.getParentNode();
			if (select2Parent != null)
				select2Parent.removeChild(selectEntry2);
		for (int i=shortSize;i<EntryVector1.size();i++) {
			String href;
			IAnswer myEntry1 = (IAnswer)Vector1.next();

			// The radio entry input
			radioEntryElement1.setValue(myEntry1.getHandle());
			radioEntryElement1.setChecked(checked);


			// The headword
			content.setTextHeadwordList1(myEntry1.getHeadwords());
			content.setTextHeadwordList2("");

			// The entryId1 anchor
			href = this.getUrl() + "?"
				+ VOLUME_PARAMETER + "="
				+ myEntry1.getVolumeName() + "&"
				+ ENTRYID_PARAMETER + "="
				+ myEntry1.getHandle() + "&"
				+ STEP_PARAMETER + "=";
			entryAnchor1.setHref(href + STEP_VIEW);

			// The pos1
			content.setTextEntryIdList1(myEntry1.getId());

			if (myEntry1.getType() == IAnswer.LocalEntry) {
				String pos = ((VolumeEntry)myEntry1).getPoss();
				if (pos != null)
					content.setTextPosList1(pos);
			}
			content.setTextPosList2("");
			content.setTextEntryIdList2("");

			// The formula
			content.setTextFormula1(IAnswerFactory.getDefinitionString(myEntry1));
			content.setTextFormula2("");			



			HTMLElement cloneEntry = (HTMLElement)entryListRow.cloneNode(true);
			HTMLElement cloneFormula = (HTMLElement)formulaRow.cloneNode(true);
			//      we have to take off the id attribute because we did not take it off the original
			cloneEntry.removeAttribute("id");
			cloneFormula.removeAttribute("id");
			entryTable.appendChild(cloneEntry);
			entryTable.appendChild(cloneFormula);
		}
		}
		 
		// Vector 2 still has entries
	else if (EntryVector2 != null) {
		Element selectEntry1 = content.getElementSelectEntry1();
		Node select1Parent = selectEntry1.getParentNode();
		if (select1Parent != null)
			select1Parent.removeChild(selectEntry1);
		for (int i=shortSize;i<EntryVector2.size();i++) {
				String href;
				IAnswer myEntry2 = (IAnswer)Vector2.next();

				// The radio entry input
				radioEntryElement2.setValue(myEntry2.getHandle());
				radioEntryElement2.setChecked(checked);

				// The headword
				content.setTextHeadwordList2(myEntry2.getHeadwords());
				content.setTextHeadwordList1("");

				// The entryId2 anchor
				href = this.getUrl() + "?"
					+ VOLUME_PARAMETER + "="
					+ myEntry2.getVolumeName() + "&"
					+ ENTRYID_PARAMETER + "="
					+ myEntry2.getHandle() + "&"
					+ STEP_PARAMETER + "=";
				entryAnchor2.setHref(href + STEP_VIEW);

				content.setTextEntryIdList2(myEntry2.getId());

				// The pos2
				if (myEntry2.getType() == IAnswer.LocalEntry) {
					String pos = ((VolumeEntry)myEntry2).getPoss();
					if (pos != null)
						content.setTextPosList2(pos);
				}
				content.setTextPosList1("");
				content.setTextEntryIdList1("");

				// The formula
				content.setTextFormula2(IAnswerFactory.getDefinitionString(myEntry2));
				content.setTextFormula1("");




				HTMLElement cloneEntry = (HTMLElement)entryListRow.cloneNode(true);
				HTMLElement cloneFormula = (HTMLElement)formulaRow.cloneNode(true);
				//      we have to take off the id attribute because we did not take it off the original
				cloneEntry.removeAttribute("id");
				cloneFormula.removeAttribute("id");
				entryTable.appendChild(cloneEntry);
				entryTable.appendChild(cloneFormula);
		}
	}
				removeEntryListTemplate();
	}

 protected void addFullEntry(String volumeName, String entryId) throws
		fr.imag.clips.papillon.business.PapillonBusinessException {
			IAnswer myAnswer = DictionariesFactory.findAnswerByHandle(volumeName, entryId);
			Node myNode = XslTransformation.applyXslSheets(myAnswer);
			//for the lexie content
			HTMLElement entryDiv= (HTMLElement) content.getElementEntryDiv();
			entryDiv.removeAttribute("id");

			entryDiv.appendChild(content.importNode(myNode, true));
		}

	protected void addHiddenVolumes(String volumeName1, String volumeName2){
		HTMLInputElement volumeInput1 = (HTMLInputElement) content.getElementVolumeHidden1();
		volumeInput1.setValue(volumeName1);
		HTMLInputElement volumeInput2 = (HTMLInputElement) content.getElementVolumeHidden2();
		volumeInput2.setValue(volumeName2);		
	}
	
    protected void removeEntryListTemplate() {
		Element myElement = content.getElementEntryListRow();
		Element mySecondElement = content.getElementFormulaRow();
		Node myParent = myElement.getParentNode();
		if (myParent != null);
		myParent.removeChild(myElement);
		Node mySecondParent = mySecondElement.getParentNode();
		if (mySecondParent != null);
		mySecondParent.removeChild(mySecondElement);
    }

    protected void removeLookupInterface () {
		Element myElement = content.getElementHeadwordLookupRow();
		Node myParent = myElement.getParentNode();
		if (myParent != null);
			myParent.removeChild(myElement);
    }

    protected void removeLookupForm() {
		Element myElement = content.getElementLookupForm();
		Node myParent = myElement.getParentNode();
		if (myParent != null);
			myParent.removeChild(myElement);
    }

	protected void removeLinkAxiesButton() {
		Element myElement = content.getElementLinkAxiesButton();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
    }
	
	protected void removeConfirmAxiesButton() {
		Element myElement = content.getElementConfirmAxiesButton();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
    }
	
	protected void removeSemanticCatDiv() {
		Element myElement = content.getElementSemanticCatDiv();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
    }

    protected void removeEntryListTable() {
		// PB when I remove the entire table, the following elements dissapear from the DOM
		// I have to embedd the table element into a div one.
		Element myElement = content.getElementEntryListTable();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
    }

	protected void removeEntryListInterface() {
		removeEntryListTable();
		removeLinkAxiesButton();
		removeConfirmAxiesButton();
		removeSemanticCatDiv();
	}
}

