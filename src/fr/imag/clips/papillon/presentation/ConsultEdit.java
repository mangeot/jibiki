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
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.12  2004/09/18 17:26:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.11  2004/03/23 01:38:09  mangeot
 * *** empty log message ***
 *
 * Revision 1.10  2004/02/16 08:52:45  mangeot
 * expiration de session
 *
 * Revision 1.9  2004/02/12 15:55:49  mangeot
 * Added functionnalities for the GDEF
 *
 * Revision 1.8  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.7.2.6  2004/02/02 07:53:53  mangeot
 * Bug fixes in encoding and UserInterface
 *
 * Revision 1.7.2.5  2004/01/22 08:31:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.2.4  2004/01/13 05:10:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.2.3  2004/01/13 02:14:05  mangeot
 * Bug fixes :-(
 *
 * Revision 1.7.2.2  2004/01/08 15:17:21  mangeot
 * Bugs fixed
 *
 * Revision 1.7.2.1  2004/01/08 09:43:20  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.7  2003/11/25 07:01:37  mangeot
 * Bug Fix when reediting an existing contribution
 *
 * Revision 1.6  2003/08/23 03:58:05  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2003/08/21 09:12:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/08/20 08:15:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/08/19 06:21:56  mangeot
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
 * Revision 1.1.2.17  2003/08/14 04:15:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.16  2003/08/11 10:24:51  mangeot
 * Debugging ...
 *
 * Revision 1.1.2.15  2003/08/09 07:21:06  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.1.2.14  2003/08/07 06:29:52  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.13  2003/07/31 06:25:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.12  2003/06/30 14:22:01  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.11  2003/06/30 13:25:27  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.10  2003/06/27 05:28:42  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.9  2003/06/21 17:56:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.8  2003/05/28 09:17:21  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.2.7  2003/05/27 05:47:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.6  2003/05/26 14:58:34  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.5  2003/05/26 11:47:00  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.4  2003/05/24 01:01:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.3  2003/05/23 16:25:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.2  2003/05/23 13:37:29  mangeot
 * I added getHeadwordText instead of getHeadword
 *
 * Revision 1.1.2.1  2003/05/23 13:03:27  mangeot
 * *** empty log message ***
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
import fr.imag.clips.papillon.presentation.html.orig.*;

//local imports
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.xmlschema.UserInterface;
import fr.imag.clips.papillon.business.xmlschema.XmlSchemaFactory;

import fr.imag.clips.papillon.business.utility.Utility;


public class ConsultEdit extends BasePO {

    protected final static String HANDLE_PARAMETER = "handle";
    protected final static String SELECT_PARAMETER = "select";
    protected final static String INIT_TYPE_PARAMETER = "InitType";
    protected final static String SEP = UserInterface.PARAMETER_SEPARATOR;

    protected final static String ContributionsURL = "AdminContributions.po";
    protected final static String ContributionsVolumeParameter = "VOLUME";


    protected final static int STEP_INIT = 1;
    protected final static int STEP_LOOKUP_VIEW = 2;
    protected final static int STEP_LOOKUP_EDIT = 3;
    protected final static int STEP_CREATE = 4;
    protected final static int STEP_VIEW = 5;
    protected final static int STEP_EDIT = 6;
    protected final static int STEP_UPDATE = 7;
    protected final static int STEP_DELETE = 8;
    protected final static int STEP_ADD = 9;
    protected final static int STEP_SAVE = 10;

		protected final static String initView = "view";
		protected final static String initEdit = "edit";
		protected final static String initCreate = "create";

    protected ConsultEditTmplHTML content;

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
	    content = (ConsultEditTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("ConsultEditTmplHTML", this.getComms(), this.getSessionData());

	    // On regarde d'abord les parametres qui nous sont demandes.
	    UserInterface myUserInterface = this.getSessionData().getEditLexieUserInterface();
			String submitLookupEdit = myGetParameter(content.NAME_LookupEdit);
			String submitLookupView = myGetParameter(content.NAME_LookupView);
	    String submitCreate = myGetParameter(content.NAME_Create);
			String submitView = myGetParameter(content.NAME_View);
			String submitEdit = myGetParameter(content.NAME_Edit);
			String submitUpdate = myGetParameter(content.NAME_Update);
	    String submitDelete = myGetParameter(UserInterface.DelCall_PARAMETER);
	    String submitAdd = myGetParameter(UserInterface.AddCall_PARAMETER);
	    String submitSave = myGetParameter(content.NAME_Save);
		
	    int step = STEP_INIT;
			boolean hiddenParameters = false;
	    String stepString = myGetParameter(content.NAME_STEP);
	    if (stepString != null && !stepString.equals("")) {
				step = Integer.parseInt(stepString);
	    }
			else if (submitLookupView != null && !submitLookupView.equals("")) {
				step = STEP_LOOKUP_VIEW;
			}
			else if (submitLookupEdit != null && !submitLookupEdit.equals("")) {
				step = STEP_LOOKUP_EDIT;
			}
			else if (submitCreate != null && !submitCreate.equals("")) {
		  step = STEP_CREATE;
	    }
			else if (submitView != null && !submitView.equals("") && myUserInterface!=null) {
				step = STEP_VIEW;
				hiddenParameters = true;
			}
			else if (submitEdit != null && !submitEdit.equals("") && myUserInterface!=null) {
				step = STEP_EDIT;
				hiddenParameters = true;
			}
			else if (submitUpdate != null && !submitUpdate.equals("") && myUserInterface!=null) {
				step = STEP_UPDATE;
				hiddenParameters = true;
			}
			else if (submitDelete != null && !submitDelete.equals("") && myUserInterface!=null) {
				step = STEP_DELETE;
				hiddenParameters = true;
	    }
	    else if (submitAdd != null && !submitAdd.equals("") && myUserInterface!=null) {
				step = STEP_ADD;
				hiddenParameters = true;
	    }
	    else if (submitSave != null && !submitSave.equals("") && myUserInterface!=null) {
				step = STEP_SAVE;
				hiddenParameters = true;
	    }
			else {
				step = STEP_UPDATE;
				hiddenParameters = true;			
			}

			String volume = "";
			String entryHandle = "";
	    String headword = "";
	    UserInterface newUserInterface = null;
			String partialMatch = "";
			int strategy = IQuery.STRATEGY_EXACT;

	    User myUser = getUser();
	    if (null != myUser) {
				content.setTextUserName(myUser.getName());
	    }


			// get and reput the hidden parameters
	    // if the entry is already existing
			if (hiddenParameters) {
				volume = myGetParameter(content.NAME_VOLUMEHIDDEN);
				entryHandle = myGetParameter(content.NAME_HANDLEHIDDEN);
			}
			// else if lookup
			else {
				volume = myGetParameter(content.NAME_VOLUME);
				entryHandle = myGetParameter(HANDLE_PARAMETER);
			}
			addVolumeEntryHandleTypeParameters(volume,entryHandle);
				
	    // Actions depending on CGI input parameters
			PapillonLogger.writeDebugMsg("Step : " + step);

	    switch (step) {
		case STEP_INIT:
			String initType = myGetParameter(INIT_TYPE_PARAMETER);
			PapillonLogger.writeDebugMsg("initType: " + initType);
			if (null == initType || initType.equals(""))	{
				initType = initView;
			}
				if (initType.equals(initView)) {
					removeCreateButton();
					removeLookupEditButton();
					addStepParameter(STEP_LOOKUP_VIEW);
				}
				else if (initType.equals(initEdit)) {
					removeCreateButton();
					removeLookupViewButton();
					addStepParameter(STEP_LOOKUP_EDIT);
				}
				else if (initType.equals(initCreate)) {
					removeHeadwordInput();
					removeLookupEditButton();
					removeLookupViewButton();
					addStepParameter(STEP_CREATE);
				}
				removeEntryListTable();
		    removeLexieInterface();
		    break;
		case STEP_LOOKUP_VIEW:
		    volume = myGetParameter(content.NAME_VOLUME);
		    headword = myGetParameter(content.NAME_HEADWORD);
				partialMatch = myGetParameter(content.NAME_PartialMatch);

		    if (null != partialMatch && !partialMatch.equals("")) {
					strategy = IQuery.STRATEGY_SUBSTRING;
				}
				displayLookupResults(volume, headword, strategy, STEP_VIEW, this.getUserPreferredLanguage());
		    break;
		case STEP_LOOKUP_EDIT:
		    volume = myGetParameter(content.NAME_VOLUME);
		    headword = myGetParameter(content.NAME_HEADWORD);
				partialMatch = myGetParameter(content.NAME_PartialMatch);

		    if (null != partialMatch && !partialMatch.equals("")) {
					strategy = IQuery.STRATEGY_SUBSTRING;
				}
				displayLookupResults(volume, headword, strategy, STEP_EDIT, this.getUserPreferredLanguage());
		    break;
		case STEP_CREATE:
		    volume = myGetParameter(content.NAME_VOLUME);
		    headword = myGetParameter(content.NAME_HEADWORD);
		    IAnswer myAnswer = VolumeEntriesFactory.createEmptyEntry(volume);
		    createEntryInterface(myAnswer, UserInterface.ENHYDRA_SITE_EDITION_TYPE, this.getUserPreferredLanguage());
		    newUserInterface = this.getSessionData().getEditLexieUserInterface();
		    displayEntry(newUserInterface);
				removeViewLexieInterface();
				removeViewLexieButton();
		    removeEntryListTable();
		    break;
		case STEP_VIEW:
			createEntryInterface(volume, entryHandle,
			UserInterface.ENHYDRA_SITE_VISUALISATION_TYPE, this.getUserPreferredLanguage());
			newUserInterface = this.getSessionData().getEditLexieUserInterface();
			displayEntry(newUserInterface);
			removeEditLexieInterface();
			removeEntryListTable();
			break;
		case STEP_EDIT:
			createEntryInterface(volume, entryHandle,
			UserInterface.ENHYDRA_SITE_EDITION_TYPE, this.getUserPreferredLanguage());
			newUserInterface = this.getSessionData().getEditLexieUserInterface();
			displayEntry(newUserInterface);
			removeEntryListTable();
			removeViewLexieInterface();
			break;
		case STEP_UPDATE:
			if (myUserInterface!=null) {
				updateEntry(myUserInterface, this.getComms().request.getParameterNames());
				displayEntry(myUserInterface);
				removeEntryListTable();
				removeViewLexieInterface();
			}
			else {
				displaySessionTimeout();
			}
			break;
		case STEP_DELETE:
			if (myUserInterface!=null) {
				updateEntry(myUserInterface, this.getComms().request.getParameterNames());
		    deleteInstances(myUserInterface, myGetParameterValues(SELECT_PARAMETER));
		    displayEntry(myUserInterface);
		    removeEntryListTable();
				removeViewLexieInterface();
			}
			else {
				displaySessionTimeout();
			}
			break;
		case STEP_ADD:
			if (myUserInterface!=null) {
				updateEntry(myUserInterface, this.getComms().request.getParameterNames());

				String dynamicParentId = "";
		    String parentID = "";
		    PapillonLogger.writeDebugMsg("AddCall " + submitAdd);
				addInstance(myUserInterface, submitAdd);
		    displayEntry(myUserInterface);
		    removeEntryListTable();
				removeViewLexieInterface();
			}
			else {
				displaySessionTimeout();
			}
			break;
		case STEP_SAVE:
			if (myUserInterface!=null) {
			String saveComment = myGetParameter(content.NAME_SaveComment);
		    updateEntry(myUserInterface, this.getComms().request.getParameterNames());
		    saveEntry(myUserInterface,myUser,saveComment);
		    String volumeName = myUserInterface.getVolumeName();
		    throw new ClientPageRedirectException(ContributionsURL + "?" + ContributionsVolumeParameter + "=" + volumeName);
			}
			else {
				displaySessionTimeout();
			}
			break;	
		default:
		    removeEntryListTable();
				removeViewLexieInterface();
		    break;
	    }
			displayLookupInterface();
	    return content;
	}

    protected void displayLookupInterface()
	throws fr.imag.clips.papillon.business.PapillonBusinessException,
	HttpPresentationException,
	java.io.UnsupportedEncodingException {

	    // Adding the appropriate source languages to the source list
	    HTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
	    Node volumeSelect = volumeOptionTemplate.getParentNode();
	    volumeOptionTemplate.removeAttribute("id");
	    // We assume that the option element has only one text child
     // (it should be this way if the HTML is valid...)
	    Text volumeTextTemplate = (Text)volumeOptionTemplate.getFirstChild();


	    Volume[] AllVolumes = VolumesFactory.getVolumesArray();

	    String volume = myGetParameter(content.NAME_VOLUME);

	    for (int i = 0; i < AllVolumes.length; i++) {
		Volume myVolume = AllVolumes[i];
		String schema = myVolume.getXmlSchema();
		// FIXME: trick to avoid displaying Papillon axies...
		if (schema != null && !schema.equals("") && !myVolume.getName().equals(PapillonPivotFactory.VOLUMENAME)) {
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

    protected void displayLookupResults (String volumeName, String headword, int strategy, int step, String lang)
	throws PapillonBusinessException,
	java.io.UnsupportedEncodingException,
	HttpPresentationException {

	    String[] Headwords = {headword};

	    Collection EntryCollection = DictionariesFactory.getVolumeEntriesCollection(volumeName, this.getUser(), Headwords, strategy);


	    if (EntryCollection != null && EntryCollection.size()>0) {
		if (EntryCollection.size()>1) {
		    addEntriesTable(EntryCollection, step);
		    removeLexieInterface();
		}
		// There is only one entry, we go directly to STEP
		else {
		    IAnswer myAnswer = (IAnswer) EntryCollection.iterator().next();
			if (step == STEP_EDIT) {
				createEntryInterface(myAnswer, UserInterface.ENHYDRA_SITE_EDITION_TYPE, lang);
				removeViewLexieInterface();
			}
			else {
				createEntryInterface(myAnswer, UserInterface.ENHYDRA_SITE_VISUALISATION_TYPE, lang);
				removeEditLexieInterface();
		}
			addVolumeEntryHandleTypeParameters(volumeName,myAnswer.getHandle());
		    UserInterface newUserInterface = this.getSessionData().getEditLexieUserInterface();
		    displayEntry(newUserInterface);
		    removeEntryListTable();
		}
	    }
	    else {
		this.getSessionData().writeUserMessage("Sorry, entry not found! Please check the volume.");
		removeEntryListTable();
		removeLexieInterface();
	    }
	}

    protected void createEntryInterface(String volumeName, String handle, String interfaceType, String lang) throws
	fr.imag.clips.papillon.business.PapillonBusinessException {
		IAnswer myAnswer = DictionariesFactory.findAnswerByHandle(volumeName, handle);
		createEntryInterface(myAnswer, interfaceType, lang);
	}

    protected void createEntryInterface(IAnswer myAnswer, String interfaceType, String lang) throws
	fr.imag.clips.papillon.business.PapillonBusinessException
	{
		// creating and saving the UserInterface
		//PapillonLogger.writeDebugMsg("createUI: " + myAnswer.getVolume() + lang + interfaceType);
		UserInterface myUserInterface = new UserInterface(myAnswer.getVolume(), interfaceType, lang);
		myUserInterface.InitData(myAnswer);
		this.getSessionData().setEditLexieUserInterface(myUserInterface);
	}


				protected void displayEntry(UserInterface myUserInterface) throws
	fr.imag.clips.papillon.business.PapillonBusinessException {

	    // recuperating and displaying the content
	    Element contentElement = myUserInterface.getDocumentElement();
	    HTMLElement UIGenerator = (HTMLElement) content.getElementUIGenerator();
	    UIGenerator.appendChild(content.importNode(contentElement, true));

	}

    protected void updateEntry(UserInterface myUserInterface, java.util.Enumeration parameterNames)			throws java.io.UnsupportedEncodingException,
	com.lutris.appserver.server.httpPresentation.HttpPresentationException
	{
		while (parameterNames.hasMoreElements())
		{
			String parameterName = (String) parameterNames.nextElement();
			String IDs [] = idDecode(parameterName);
			if (IDs != null)
			{
				if (myUserInterface.IsInstance(IDs[0]))
				{
					myUserInterface.updateInstance(IDs[0], IDs[1], myGetParameter(parameterName));
				}
			}
		}
		VolumeEntriesFactory.setGDEFFrenchTranslations(myUserInterface.getAnswer(),myUserInterface.getEntryDocument());
	}

	protected void deleteInstances(UserInterface myUserInterface, String[] codeInstanceIDs)
	throws PapillonBusinessException
	{
		for (int i=0; i<codeInstanceIDs.length;i++)
		{
			String IDs [] = idDecode(codeInstanceIDs[i]);
			if (IDs != null)
			{
				myUserInterface.deleteInstance(IDs[0], IDs[1]);
			}
		}
	}

    protected void addInstance(UserInterface myUserInterface, String codesID)
	throws PapillonBusinessException
	{
		String IDs [] = idDecode(codesID);
		if (IDs != null)
		{
			String IDs2 [] = idDecode(IDs[0]);
			if (IDs2 != null)
				myUserInterface.addChildInstance(IDs2[1], IDs[1], IDs2[0]);
		}
	}

    protected void saveEntry(UserInterface myUserInterface, User myUser, String saveComment) throws
	fr.imag.clips.papillon.business.PapillonBusinessException, java.io.IOException {
	    myUserInterface.saveData(myUser, saveComment);
	    this.getSessionData().setEditLexieUserInterface(null);
	}


    protected void addEntriesTable (Collection EntryCollection, int step) throws
	fr.imag.clips.papillon.business.PapillonBusinessException {

	    // On récupère les éléments du layout
	    HTMLTableRowElement entryListRow = content.getElementEntryListRow();
		HTMLAnchorElement entryAnchor = content.getElementSeeEntryAnchor();
		HTMLAnchorElement contribAnchor = content.getElementContribAnchor();
	    HTMLElement headwordElement = content.getElementHeadwordList();
	    HTMLElement posElement = content.getElementPosList();
	    HTMLAnchorElement editAnchor = content.getElementEditEntryAnchor();

		// Recuperating the elements for the formula
		HTMLTableRowElement formulaRow = content.getElementFormulaRow();
		HTMLElement formulaElement = content.getElementFormula();
		

	    //      we don't take off the id attribute because we will take the element off later...
     //      entryListRow.removeAttribute("id");
		entryAnchor.removeAttribute("id");
		contribAnchor.removeAttribute("id");
	    headwordElement.removeAttribute("id");
	    posElement.removeAttribute("id");
	    editAnchor.removeAttribute("id");
		formulaElement.removeAttribute("id");


	    // On récupère le noeud contenant la table...
	    Node entryTable = entryListRow.getParentNode();
	    if (null != EntryCollection) {
			for(Iterator entriesIterator = EntryCollection.iterator(); entriesIterator.hasNext();) {
		    String href;
		    VolumeEntry myEntry = (VolumeEntry)entriesIterator.next();

		    // The headword
		    content.setTextHeadwordList(myEntry.getHeadwords());

		    // The entryHandle anchor
		    href = this.getUrl() + "?"
			+ content.NAME_VOLUME + "="
			+ myEntry.getVolumeName() + "&"
			+ HANDLE_PARAMETER + "="
			+ myEntry.getHandle() + "&"
			+ content.NAME_STEP + "=";
		    entryAnchor.setHref(href + STEP_VIEW);

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

		    // The edit
				if (step == STEP_EDIT) {
					removeViewAnchor();
				}
				else {
					removeEditAnchor();
				}
		    editAnchor.setHref(href + step);

			// The formula
			content.setTextFormula(IAnswerFactory.getDefinitionString(myEntry));


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
	
		protected void displaySessionTimeout () {
				removeEntryListTable();
				removeLexieInterface();
				Element myElement = content.getElementSessionTimeout();
				myElement.removeAttribute("class");
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

    protected void removeLookupInterface () {
			Element myElement = content.getElementHeadwordLookupRow();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
			myElement = content.getElementVolumeLookupRow();
			myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
			myElement = content.getElementButtonsLookupRow();
			myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeLookupForm () {
		Element myElement = content.getElementLookupForm();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
    }

    protected void removeEditLexieInterface () {
			Element myElement = content.getElementEditLexieRow();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeViewLexieInterface () {
		Element myElement = content.getElementViewLexieRow();
		Node myParent = myElement.getParentNode();
		if (myParent != null)
			myParent.removeChild(myElement);
    }

    protected void removeViewLexieButton () {
			Element myElement = content.getElementViewLexieButton();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeCreateButton () {
			Element myElement = content.getElementCreateButton();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeLookupViewButton () {
			Element myElement = content.getElementLookupViewButton();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeLookupEditButton () {
			Element myElement = content.getElementLookupEditButton();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeHeadwordInput () {
			Element myElement = content.getElementHeadwordLookupRow();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeEditAnchor () {
			Element myElement = content.getElementEditAnchor();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

    protected void removeViewAnchor () {
			Element myElement = content.getElementViewAnchor();
			Node myParent = myElement.getParentNode();
			if (myParent != null)
				myParent.removeChild(myElement);
    }

		protected void removeLexieInterface() {
			removeEditLexieInterface();
			removeViewLexieInterface();
		}

		protected void addVolumeEntryHandleTypeParameters(String volumeName, String entryHandle) {
			HTMLInputElement volumeInput = (HTMLInputElement) content.getElementVolumeHidden();
			volumeInput.setValue(volumeName);
			HTMLInputElement entryHandleInput = (HTMLInputElement) content.getElementHandleHidden();
			entryHandleInput.setValue(entryHandle);
		}

		protected void addStepParameter(int step) {
			HTMLInputElement stepInput = (HTMLInputElement) content.getElementStepHidden();
			stepInput.setValue(Integer.toString(step));
		}

    protected void removeEntryListTable () {
		// PB when I remove the entire table, the following elements disappear from the DOM
		// To fix the pb, always embedd a table in a <div> element
		Element myElement = content.getElementEntryListTable();
		Node myParent = myElement.getParentNode();
		myParent.removeChild(myElement);
		}
		
	// David Thevenin ADD
	protected String [] idDecode (String id)
	{
		String IDs [] = new String [2];
		
		int index = id.lastIndexOf(SEP);
		if (index == -1) return null;
		IDs[0] = id.substring(0, index);
		IDs[1] = id.substring(index + SEP.length());
		return IDs;
	}	
}

