/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.16  2004/09/18 17:27:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.15  2004/03/11 15:13:32  mangeot
 * Finalisation de la revision des contributions
 *
 * Revision 1.14  2004/02/13 00:56:38  mangeot
 * Bug fixes
 *
 * Revision 1.13  2004/02/12 15:55:48  mangeot
 * Added functionnalities for the GDEF
 *
 * Revision 1.12  2004/02/12 14:45:02  mangeot
 * Added history directly in the entries
 *
 * Revision 1.11  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.business.dictionary;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.xmlschema.XmlSchemaFactory;

import java.util.Date;
import java.util.Vector;

/**
 * Insert the type's description here.
 * Creation date: (10.08.01 20:55:06)
 * @author: Administrator
 */
 
public class IAnswerFactory {
	
	public static String checkAndSetNewId(IAnswer myAnswer) throws PapillonBusinessException {
		String newId = myAnswer.getId();
		if (newId==null || newId.equals("")) {
			newId = checkAndSetNewId(myAnswer, Utility.buildDOMTree(myAnswer.getXmlCode()), myAnswer.getHeadword());
		}
		return newId;
	}

	public static String checkAndSetNewId(IAnswer myAnswer, String headword) throws PapillonBusinessException {
		String newId = myAnswer.getId();
		if (newId==null || newId.equals("")) {
			newId = checkAndSetNewId(myAnswer, Utility.buildDOMTree(myAnswer.getXmlCode()), headword);
	}
		return newId;
	}

	public static String checkAndSetNewId(IAnswer myAnswer, Element myDOMEntry, String headword) throws PapillonBusinessException {
		String newId = myAnswer.getId();
		if (newId==null || newId.equals("")) {
			newId = checkAndSetNewId(myAnswer, myDOMEntry.getOwnerDocument(), headword);
		}
		return newId;
	}
		
		
	public static String checkAndSetNewId(IAnswer myAnswer, Document myDocument, String headword) throws PapillonBusinessException {
		String newId = myAnswer.getId();
		if (newId==null || newId.equals("")) {
			Volume myVolume = myAnswer.getVolume();
			myVolume.loadCDMElements();
			checkAndSetNewId(myAnswer, myVolume, myDocument, headword);
			newId = myAnswer.getId();
		}
		return newId;
	}
		
	public static String checkAndSetNewId(IAnswer myAnswer, Volume myVolume, Document myDocument, String headword) throws PapillonBusinessException {
		NodeList myNodeList = myDocument.getElementsByTagName(myVolume.CDM_entryId);

		String newId = myAnswer.getId();
		if (newId==null || newId.equals("")) {
			newId = myAnswer.createNewId(headword);
		try {
		PapillonLogger.writeDebugMsg("New Entry Id: " + newId);
		
		if ((myNodeList != null) && (myNodeList.getLength()>0)) {
			Element myElt = (Element) myNodeList.item(0);
			if (myVolume.CDM_entryId_attribute !=null && !myVolume.CDM_entryId_attribute.equals("")) {
				if (myVolume.CDM_entryId_attribute_ns != null &&
				!myVolume.CDM_entryId_attribute_ns.equals("")) {
					myElt.setAttributeNS(myVolume.CDM_entryId_attribute_ns, myVolume.CDM_entryId_attribute, newId);
				}
				else {
					myElt.setAttribute(myVolume.CDM_entryId_attribute, newId);
				}
			}
			else {
				Utility.setText(myElt,newId);
			}
			myAnswer.setXmlCode(Utility.NodeToString(myDocument));
		}

		}
		catch(Exception ex) {
            throw new PapillonBusinessException("Error setting new ID for IAnswer", ex);
        }
		myAnswer.setId(newId);
		}
		return newId;
	}

	public static String getDefinitionString(IAnswer myAnswer) throws PapillonBusinessException {

		String xmlcode = myAnswer.getXmlCode();
		String tagname = "semantic-formula";
		String definition = "    ";

		Volume myVolume = myAnswer.getVolume();
		myVolume.loadCDMElements();
		if (myVolume.CDM_definition != null && !myVolume.CDM_definition.equals("")) {
			tagname=myVolume.CDM_definition;
		}
		
		Document myDocument =Utility.buildDOMTree(xmlcode);
		NodeList myNodeList = myDocument.getElementsByTagName(tagname);

		if ((myNodeList != null) && (myNodeList.getLength()>0)) {
			Element myElt = (Element) myNodeList.item(0);
			definition = Utility.getNormalizedStringValue(myElt);
		}
		return definition;
	}
	
	public static void setModification(IAnswer myAnswer, String author, String comment) throws PapillonBusinessException {
		Document myDOC = Utility.buildDOMTree(myAnswer.getXmlCode());
		setModification(myAnswer,myDOC,author,comment);
		myAnswer.setXmlCode(Utility.NodeToString(myDOC));
		myAnswer.save();
	}


	public static void setModification(IAnswer myAnswer, Document myDocument, String author, String comment) throws PapillonBusinessException {
		Volume myVolume = myAnswer.getVolume();
		myVolume.loadCDMElements();
		if (myVolume.CDM_entry != null && !myVolume.CDM_entry.equals("")) {
		
			NodeList myNodeList = myDocument.getElementsByTagName(myVolume.CDM_entry);

			if ((myNodeList != null) && (myNodeList.getLength()>0)) {
				Element myEntry = (Element) myNodeList.item(0);
				myNodeList = myEntry.getElementsByTagName(myVolume.CDM_history);
				Element myHistory = null;
				if ((myNodeList != null) && (myNodeList.getLength()>0)) {
					myHistory = (Element) myNodeList.item(0);
				}
				else {
					myHistory = myDocument.createElement(myVolume.CDM_history);
					myEntry.appendChild(myHistory);
				}
				NodeList modifsList = myHistory.getElementsByTagName(myVolume.CDM_modification);
				Element myModification = null;
				if ((modifsList != null) && (modifsList.getLength()>0)) {
					myModification = (Element) modifsList.item(0);
				}
				else {
					myModification = myDocument.createElement(myVolume.CDM_modification);
					myHistory.appendChild(myModification);
				}
				Element newModification = (Element) myModification.cloneNode(true);
				myNodeList = newModification.getElementsByTagName(myVolume.CDM_modificationAuthor);
				Element myAuthor = null;
				Element myDate = null;
				Element myComment = null;
				if ((myNodeList != null) && (myNodeList.getLength()>0)) {
					myAuthor = (Element) myNodeList.item(0);
				}
				else {
					myAuthor = myDocument.createElement(myVolume.CDM_modificationAuthor);
					newModification.appendChild(myAuthor);
				}
				String existingAuthor = Utility.getText(myAuthor);
				myNodeList = newModification.getElementsByTagName(myVolume.CDM_modificationDate);
				if ((myNodeList != null) && (myNodeList.getLength()>0)) {
					myDate = (Element) myNodeList.item(0);
				}
				else {
					myDate = myDocument.createElement(myVolume.CDM_modificationDate);
					newModification.appendChild(myDate);
				}
				myNodeList = newModification.getElementsByTagName(myVolume.CDM_modificationComment);
				if ((myNodeList != null) && (myNodeList.getLength()>0)) {
					myComment = (Element) myNodeList.item(0);
				}
				else {
					myComment = myDocument.createElement(myVolume.CDM_modificationComment);
					newModification.appendChild(myComment);
				}
				Utility.setText(myAuthor,author);
				Utility.setText(myDate,new Date().toString());
				Utility.setText(myComment,comment);
				if (modifsList.getLength()==1 && existingAuthor.equals("")) {
					myHistory.removeChild(myModification);
				}	
				myHistory.appendChild(newModification);
			}
		}
	}
	
	protected static int deleteVector(Vector TheAnswers)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		for ( int i = 0; i < TheAnswers.size(); i++ ) {
			((IAnswer)TheAnswers.elementAt(i)).delete();
		}
		return TheAnswers.size();
	}
	
}
