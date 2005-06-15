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
 * Revision 1.10  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.9  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.8.4.5  2005/06/13 10:22:01  mangeot
 * Bug fixed, added Referrer hidden param in generator
 *
 * Revision 1.8.4.4  2005/06/01 14:17:54  mangeot
 * Bug fix in itf generator & added variant in CDM lookup1
 *
 * Revision 1.8.4.3  2005/05/27 15:11:42  mangeot
 * bug fix in URL formation
 *
 * Revision 1.8.4.2  2005/05/27 11:53:34  mangeot
 * *** empty log message ***
 *
 * Revision 1.8.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.8  2005/04/22 14:13:40  mangeot
 * URL encoding bug fix
 *
 * Revision 1.7  2005/04/20 10:51:14  mangeot
 * Correction de AddDirectTranslations
 *
 * Revision 1.6  2005/04/14 13:08:25  mangeot
 * Deleted all references to findContributionByEntryHandle
 *
 * Revision 1.5  2005/04/14 09:21:04  mangeot
 * Changed redirections after marked finish and save a contribution
 *
 * Revision 1.4  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.3.2.4  2005/04/08 08:23:04  mangeot
 * Added referrer when redirection is on
 *
 * Revision 1.3.2.3  2005/02/25 10:22:08  mangeot
 * Bug fixes and added the use of referrer when exiting from Reviewcontributions.po
 *
 * Revision 1.3.2.2  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.3.2.1  2005/01/27 23:55:13  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2005/01/14 21:49:59  mangeot
 * Modified the editor: when the user adds an item, it is added before the last selected sibling or at the end if nothing is selected.
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.3  2004/10/28 10:43:36  mangeot
 * Fixed some bugs
 * Implemented the xsd:choice feature
 *
 * Revision 1.2  2004/09/20 15:12:36  mangeot
 * Bug corrections for the new UIGenerator
 * plus now able to deal with booleans
 *
 * Revision 1.1  2004/09/18 17:27:15  mangeot
 * It is a new version of the editor
 *
 *-----------------------------------------------
 * Papillon Login page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

import java.util.ArrayList;

// internal imports
import fr.imag.clips.papillon.business.dictionary.ContributionsFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.edition.UIGenerator;
import fr.imag.clips.papillon.business.edition.UITemplates;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.Utility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EditEntry extends PapillonBasePO {
    
    public static String EntryHandle_PARAMETER = "EntryHandle";
    public static String Headword_PARAMETER = "Headword";
    public static String VolumeName_PARAMETER = "VolumeName";  
    public static String Redirection_PARAMETER = "Redirection";  
	public static String Referrer_PARAMETER = "Referrer";
	public static String HomographId_PARAMETER = "HomographId";
    public static String AddCall_PARAMETER = "AddCall";
    public static String DelCall_PARAMETER = "DelCall";
    public static String ChooseCall_PARAMETER = "ChooseCall";
	
    protected static String Choose_PARAMETER = UIGenerator.CHOOSE_ATTR_NAME;  
    protected static String Select_PARAMETER = UIGenerator.SELECT_ATTR_NAME;  
    protected static String Boolean_PARAMETER = UIGenerator.BOOLEAN_ATTR_NAME;  
    protected static String Update_PARAMETER = "Update";  
    protected static String Save_PARAMETER = "Save";  
    protected static String SaveComment_PARAMETER = "SaveComment";  
	
	protected final static String AdminContributionsURL = "AdminContributions.po";
	protected final static String ChooseEntryURL = "ChooseEntry.po";
	protected final static String EditEntryInitURL = "EditEntryInit.po";
	protected final static String ReviewContributionsURL = "ReviewContributions.po";
    protected final static String ContributionsLookupParameter = "LOOKUP";
    protected final static String ContributionsHeadwordParameter = "HEADWORD";
    protected final static String ContributionsVolumeParameter = "VOLUME";

	
    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean userMayUseThisPO() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public org.w3c.dom.Node getContent() 
		throws java.io.UnsupportedEncodingException, 
			HttpPresentationException {

        // Management of the parameters
	    String submitAdd = myGetParameter(AddCall_PARAMETER);
	    String submitDelete = myGetParameter(DelCall_PARAMETER);
	    String submitChoose = myGetParameter(ChooseCall_PARAMETER);
	    String select = myGetParameter(Select_PARAMETER);
	    String choose = myGetParameter(Choose_PARAMETER);
	    String volumeName = myGetParameter(VolumeName_PARAMETER);
		String entryHandle = myGetParameter(EntryHandle_PARAMETER);
	    String submitUpdate = myGetParameter(Update_PARAMETER);
	    String submitSave = myGetParameter(Save_PARAMETER);
	    String saveComment = myGetParameter(SaveComment_PARAMETER);
	    String referrer = myGetParameter(Referrer_PARAMETER);
	    String homographId = myGetParameter(HomographId_PARAMETER);
				
		// Recuperation of parameters
		if (referrer== null || referrer.equals("")) {
			referrer = this.getReferrer();
		}
				
		// buidling the queryString
		String queryString = this.getUrl() + "?" 
					+ VolumeName_PARAMETER + "=" + myUrlEncode(volumeName)
					+ "&" + EntryHandle_PARAMETER + "=" + myUrlEncode(entryHandle);
		
		String selectParams = serializeParameterForUrl(Select_PARAMETER,myGetParameterValues(Select_PARAMETER));
		if (selectParams != null && !selectParams.equals("")) {
			queryString += "&" + selectParams;
		}
		if (submitAdd!=null && !submitAdd.equals("")) {
			queryString += "&" + AddCall_PARAMETER + "=" + myUrlEncode(submitAdd);
		}
		if (submitDelete!=null && !submitDelete.equals("")) {
			queryString += "&"  + DelCall_PARAMETER + "=" + myUrlEncode(submitDelete);
		}
		if (submitChoose!=null && !submitChoose.equals("")) {
			queryString += ChooseCall_PARAMETER + "=" + myUrlEncode(submitChoose)
			+ "&" + Choose_PARAMETER + "=" + myUrlEncode(choose);
		}
		if (submitUpdate!=null && !submitUpdate.equals("")) {
			queryString += "&" + Update_PARAMETER + "=" + myUrlEncode(submitUpdate);
		}
		if (submitSave!=null && !submitSave.equals("")) {
			queryString += "&" + Save_PARAMETER + "=" + myUrlEncode(submitSave)
			+ "&" + SaveComment_PARAMETER + "=" + myUrlEncode(saveComment);
		}
		if (referrer!=null && !referrer.equals("")) {
			queryString +=  "&" + Referrer_PARAMETER + "=" + myUrlEncode(referrer);
		}
		
		ArrayList languages = this.getSessionData().getUserAcceptLanguages();

		Element myEntry = null;
		VolumeEntry myVolumeEntry = null;
		if (volumeName!=null && !volumeName.equals("")
			&& entryHandle!=null &&!entryHandle.equals("")) {
			myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName,entryHandle);
			myEntry = myVolumeEntry.getDom().getDocumentElement();
		}
		// TODO answer if no arguments
		else {
			throw new ClientPageRedirectException(EditEntryInitURL);
		}
		Element myTemplateEntry = UITemplates.getTemplateEntry(volumeName);
		
		
		// updateElement
		if (myVolumeEntry!=null) {
			updateEntry(myVolumeEntry, myEntry, this.getComms().request.getParameterNames());
			String homographWord = VolumeEntriesFactory.setGDEFFrenchTranslations(myVolumeEntry, homographId);
			myVolumeEntry.save();
			if (homographWord !=null && !homographWord.equals("")) {
				homographWord = myUrlEncode(homographWord);
				String queryStringCopy = queryString
				+ "&" + HomographId_PARAMETER + "=";
				queryStringCopy = queryStringCopy.replaceAll("&",ChooseEntry.Ampersand);
				queryStringCopy = queryStringCopy.replaceAll("=",ChooseEntry.Equal);
				
				String otherVolume = VolumesFactory.getSymetricVolumeName(volumeName);
				
				String newUrl = ChooseEntryURL 
					+ "?" + ChooseEntry.ChooseEntry_PARAMETER + "=" + homographWord
					+ "&" + ChooseEntry.Volume_PARAMETER + "=" + otherVolume
					+ "&" + ChooseEntry.QueryString_PARAMETER + "=" + queryStringCopy;

				throw new ClientPageRedirectException(newUrl);
			}
		}

		// addElement
		if (submitAdd!=null && !submitAdd.equals("")) {
			String redirected = myGetParameter(Redirection_PARAMETER);
			// The redirection is used in order to open the generated web page 
			// with the added block at the top of the window
			// It is essential when lots of blocks are already created
			
			if (redirected == null || redirected.equals("")) {
				myVolumeEntry.save();
				String newUrl = queryString 
					+ "&" + Redirection_PARAMETER + "=" + "on"	
					+ "#" + UIGenerator.NEW_BLOCK_ANCHOR;			
				throw new ClientPageRedirectException(newUrl);
			}
			int plus =  submitAdd.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
			if (plus > 0) {
				String elementName = submitAdd.substring(0,plus);
				String parentElement = submitAdd.substring(plus+1);
				String[] siblingElements = myGetParameterValues(Select_PARAMETER);
				UIGenerator.addElement(elementName,parentElement,myEntry, myTemplateEntry, siblingElements);
			}
		}
		// deleteElements MUST be after updateElement because it modifies the element ids.
		else if (submitDelete!=null && !submitDelete.equals("")
					&& select != null && !select.equals("")) {
			String redirected = myGetParameter(Redirection_PARAMETER);
			// The redirection is used in order to open the generated web page 
			// with the deleted block parent at the top of the window
			// It is essential when lots of blocks are already created
			if (redirected == null || redirected.equals("")) {
				myVolumeEntry.save();
				String newUrl = queryString 
					+ "&" + Redirection_PARAMETER + "=" + "on"	
					+ "#" + UIGenerator.NEW_BLOCK_ANCHOR;				
				throw new ClientPageRedirectException(newUrl);
			}
			int plus =  submitDelete.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
			if (plus > 0) {
				String elementName = submitDelete.substring(0,plus);
				String parentElement = submitDelete.substring(plus+1);
				String[] selectedElements = myGetParameterValues(Select_PARAMETER);
				UIGenerator.deleteElements(elementName,selectedElements,myEntry);
			}
		}
		else if (submitChoose!=null && !submitChoose.equals("")
					&& choose != null && !choose.equals("")) {
			int plus =  submitChoose.indexOf(UIGenerator.PARAMETERS_SEPARATOR);
			if (plus > 0) {
				String elementId = submitChoose.substring(0,plus);
				String parentId = submitChoose.substring(plus+1);
				UIGenerator.chooseElement(choose,parentId,myEntry, myTemplateEntry);
			}
		}
		
	// saveModifiedEntry
		if (submitSave!=null && !submitSave.equals("")) {
			saveEntry(myVolumeEntry, this.getUser().getLogin(),saveComment, referrer);
		}

			// fill template
		Element myInterface = UITemplates.getInterface(volumeName, UITemplates.DEFAULT_FORM,languages); 
		Element myItfTemplate = null;	
		
		if (myInterface!=null) {
			myInterface = (Element) myInterface.cloneNode(true);
			myItfTemplate = (Element) myInterface.cloneNode(true);	
		}
		
	// add volume name & entry handle in the form	
		UIGenerator.setValueInput(myInterface, VolumeName_PARAMETER, volumeName);
		UIGenerator.setValueInput(myInterface, EntryHandle_PARAMETER, entryHandle);
		UIGenerator.setValueInput(myInterface, Referrer_PARAMETER, referrer);
		
				
	// fillInterfaceTemplate
		UIGenerator.fillInterfaceTemplate(myEntry,myInterface, myItfTemplate);

	//	System.out.println(Utility.NodeToString(myEntry));
	//	System.out.println(Utility.NodeToString(myInterface));
	// save at the end because fillTemplate modifies the entry DOM
	// when there is a block anchor
		myVolumeEntry.save();
		
		return myInterface;
	}
	
	protected void updateBooleanElements(String[] elements, Element myEntry) {
	// FIXME: a problem here: the element ids change when one element is deleted.
	// the second element of the same type will not be deleted
		for (int i=0; i<elements.length;i++) {
			String elt = elements[i];
			if (elt != null) {
				UIGenerator.updateElement(elt, "true", myEntry);
			}
		}
	}

	
	protected void updateEntry(VolumeEntry myVolumeEntry, Element entryElt, java.util.Enumeration parameterNames)
		throws java.io.UnsupportedEncodingException,
				com.lutris.appserver.server.httpPresentation.HttpPresentationException {
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			if (parameterName.indexOf(UIGenerator.ID_SEPARATOR)>0) {
				UIGenerator.updateElement(parameterName,myGetParameter(parameterName),entryElt);
			}
		}
		updateBooleanElements(myGetParameterValues(Boolean_PARAMETER),entryElt);
	}
			
	protected void saveEntry(VolumeEntry myVolumeEntry, String author, String saveComment, String referrer) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		if (myVolumeEntry!=null) {
			myVolumeEntry.setModification(author,saveComment);
			myVolumeEntry.save();
		}
		if (referrer.indexOf(ReviewContributionsURL)>0) {
			throw new ClientPageRedirectException(ReviewContributionsURL+ "?" + ContributionsVolumeParameter + "=" + myVolumeEntry.getVolumeName()
			+ "&" + ContributionsHeadwordParameter + "=" + myUrlEncode(myVolumeEntry.getHeadword())
			+ "&" + ContributionsLookupParameter + "=on");
		}
		else {
			throw new ClientPageRedirectException(AdminContributionsURL + "?" + ContributionsVolumeParameter + "=" + myVolumeEntry.getVolumeName()
			+ "&" + ContributionsHeadwordParameter + "=" + myUrlEncode(myVolumeEntry.getHeadword())
			+ "&" + ContributionsLookupParameter + "=on");
		}
	}
       
}
