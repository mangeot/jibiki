/*
 *  papillon
 *
 * (c) Francis Brunet-Manquat - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------
 * $Id: LexALPPostUpdateProcessor.java 712 2007-10-29 15:11:03Z serasset $
 *------------------------
 * $Log$
 * Revision 1.2.4.1  2007/10/29 15:11:03  serasset
 * NEW: lexalp css now defines different forms for HARMONISED/REJECTED entries
 * NEW: added new db url/user/password configuration keys in papillon.properties file
 * BUG158: headwords are now harmonised at edition and search time, added a "normalise headword" admin action
 *
 * Revision 1.2  2006/06/01 22:05:05  fbrunet
 * New interface, quick search, new contribution management (the first edition not create new contribution. New contribution is created after add, remove element, update, save, etc. in the interface window)
 *
 * Revision 1.1  2006/05/05 02:08:23  fbrunet
 * bug correction : url utf8 transfert (in createEntryInit)
 *
 *
 *
 *------------------------
 */

package fr.imag.clips.papillon.business.motamot;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.xml.XMLServices;

import fr.imag.clips.papillon.business.transformation.ResultPostUpdateProcessor;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

public class MotamotPostUpdateProcessor implements ResultPostUpdateProcessor {
    
	protected static String AXI_LANG = "axi";
	protected static String ENTRY_TAG = "m:entry";
	protected static String ID_TAG = "id";
	protected static String IDMAX_TAG = "idmax";
	protected static String SENSE_TAG = "m:sense";
	protected static String SID_PREFIX = "s";
	protected static String TRANSLATIONS_TAG = "m:translations";
	protected static String TRANSLATION_TAG = "m:translation";
	protected static String REFLEXIES_TAG = "m:reflexies";
	protected static String REFLEXIE_TAG = "m:reflexie";
	protected static String REFAXIE_TAG = "m:refaxie";
	protected static String IDREFENTRY_TAG = "idrefentry";
	protected static String IDREFLEXIE_TAG = "idreflexie";
	protected static String IDREFAXIE_TAG = "idrefaxie";
	protected static String LANG_TAG = "lang";
    
    public void transformation(VolumeEntry volumeEntry, User user) throws PapillonBusinessException {
        try {
			if (volumeEntry != null && !volumeEntry.getSourceLanguage().equals(AXI_LANG)) {
                Document dom = volumeEntry.getDom();
                
                // mise à jour de la numérotation des sens
                NodeList entryList = dom.getElementsByTagName(ENTRY_TAG);
				if ((null != entryList) && (entryList.getLength() > 0)) {
					Element entry = (Element) entryList.item(0);
					Node idmaxNode = entry.getAttributes().getNamedItem(IDMAX_TAG);
					int idmax = 0;
					if (idmaxNode!=null) {
						idmax = Integer.parseInt(idmaxNode.getNodeValue());
					}
					int idmaxOrig = idmax;
					NodeList senseList = dom.getElementsByTagName(SENSE_TAG);
					if ((null != senseList) && (senseList.getLength() > 0)) {
						for (int i=0; i < senseList.getLength(); i++) {
							Element sense = (Element)senseList.item(i);
							Node senseIdAttribute = sense.getAttributes().getNamedItem(ID_TAG);
							String senseId = null;
							if (senseIdAttribute != null) {
								senseId = senseIdAttribute.getNodeValue();
							}
							if (senseId==null || senseId.equals("")) {
								idmax++;
								senseId = SID_PREFIX+idmax;
								sense.setAttribute(ID_TAG,senseId);
							}
							
							updateOrCreateAxies(volumeEntry, sense, senseId, user);
						}
					}
					if (idmax > idmaxOrig) {
						entry.setAttribute(IDMAX_TAG,""+idmax);
					}
                }
				
                // test si besoin de creation ou mise à jour d'axie
								
                volumeEntry.save();
            }    
            
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in MotamotPostProcessor.transformation()", ex);
        }	
    }
		
	protected static void updateOrCreateAxies(VolumeEntry theEntry, Node sense, String senseId, User user) 
	throws PapillonBusinessException {
		String axieVolume = theEntry.getAxieVolume().getName();

		NodeList translationsList = sense.getChildNodes();
		if ((null != translationsList) && (translationsList.getLength() > 0)) {
			for (int j=0; j < translationsList.getLength(); j++) {
				Node translations = translationsList.item(j);
				if (translations.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && translations.getNodeName().equals(TRANSLATIONS_TAG)) {
		NodeList translationList = translations.getChildNodes();
		if ((null != translationList) && (translationList.getLength() > 0)) {
			for (int i=0; i < translationList.getLength(); i++) {
				Node translation = translationList.item(i);
				if (translation.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && translation.getNodeName().equals(TRANSLATION_TAG)) {
				Node idreflexieAttribute =  ((Element)translation).getAttributes().getNamedItem(IDREFLEXIE_TAG);
				String idreflexie = null;
				if (idreflexieAttribute != null) {
					idreflexie = idreflexieAttribute.getNodeValue();
				}
				if (idreflexie!=null && !idreflexie.equals("")) {
					Node idrefentryAttribute = translation.getAttributes().getNamedItem(IDREFENTRY_TAG);
					String idrefentry = null;
					if (idrefentryAttribute != null) {
						idrefentry =  idrefentryAttribute.getNodeValue();
						if (idrefentry!=null && !idrefentry.equals("")) {
							Node langAttribute = translation.getAttributes().getNamedItem(LANG_TAG);
							String targetLang = null;
							if (langAttribute != null) {
								targetLang = langAttribute.getNodeValue();
								if (targetLang!=null && !targetLang.equals("")) {
									String idrefaxie = null;
									Node idrefaxieAttribute = translation.getAttributes().getNamedItem(IDREFAXIE_TAG);
									if (idrefaxieAttribute != null) {
										idrefaxie = idrefaxieAttribute.getNodeValue();
									}
									if (idrefaxie!=null && !idrefaxie.equals("")) {
										PapillonLogger.writeDebugMsg("updateAxie: " + idrefaxie + " with: " + idreflexie + " lang:" + targetLang);
									}
									else {
										String refaxie = createAxie (axieVolume, theEntry.getSourceLanguage(), theEntry.getEntryId(), senseId, targetLang, idrefentry, idreflexie, user);
										addRefaxie(sense,refaxie);
									}
									translations.removeChild(translation);
								}
							}
						}
					}
				}
			}
		}
	}
}
			}
		}
	}

	
	protected static String createAxie (String axieVolume, String lang1, String refEntry1, String refLexie1, String lang2, String refEntry2, String refLexie2, User user)
		throws PapillonBusinessException {

			PapillonLogger.writeDebugMsg("createAxie: lang1: " + lang1 + " e1: " + refEntry1 + "." + refLexie1 + " ; lang2: " + lang2 + " e2: " + refEntry2 + "." + refLexie2);

			VolumeEntry myAxie = VolumeEntriesFactory.createEmptyEntry(axieVolume);
		myAxie.setCreationDate();
		myAxie.setAuthor(user.getLogin());
		myAxie.setGroups(user.getGroupsArray());
		myAxie.setStatus(VolumeEntry.FINISHED_STATUS);
		myAxie.setHeadword(createAxieHeadword(lang1,refEntry1,lang2,refEntry2));
			
		org.w3c.dom.Document theDom = myAxie.getDom();
		Element reflexies = (Element)theDom.getElementsByTagName(REFLEXIES_TAG).item(0);
		Element reflexie = theDom.createElement(REFLEXIE_TAG);
		reflexie.setAttribute(IDREFENTRY_TAG, refEntry1);
		reflexie.setAttribute(IDREFLEXIE_TAG, refLexie1);
		reflexie.setAttribute(LANG_TAG, lang1);
		reflexies.appendChild(reflexie.cloneNode(true));
		reflexie.setAttribute(IDREFENTRY_TAG, refEntry2);
		reflexie.setAttribute(IDREFLEXIE_TAG, refLexie2);
		reflexie.setAttribute(LANG_TAG, lang2);
		reflexies.appendChild(reflexie);
			
			// FIXME: if I don't recompute the DOM, it does not take into account some parts like the reflexies
		myAxie.setDom(XMLServices.buildDOMTree(XMLServices.xmlCode(theDom)));

		myAxie.save();
		return myAxie.getEntryId();
	}

	protected static String createAxieHeadword(String lang1,String refEntry1,String lang2,String refEntry2) {
		if (lang1.compareTo(lang2)>0) {
			String tmp = refEntry1;
			refEntry1 = refEntry2;
			refEntry2 = tmp;
		}
		return "["+transformEntryId(refEntry1) + "," + transformEntryId(refEntry2) +"]";
	}
    
	protected static String transformEntryId(String id) {
		int first = id.indexOf('.');
		int next =id.indexOf('.',first+1);
		if (first >=0 && next > first) {
			id = id.substring(0,next);
			id = id.replace('.',':');
		}
		return id;
	}
	
	protected static void addRefaxie(Node sense, String idrefaxie) {
		Element refaxie = sense.getOwnerDocument().createElement(REFAXIE_TAG);
		refaxie.setAttribute(IDREFAXIE_TAG, idrefaxie);

		NodeList childsList = sense.getChildNodes();
		if ((null != childsList) && (childsList.getLength() > 0)) {
			int i=0;
			while (refaxie !=null && i< childsList.getLength()) {
				Node child = childsList.item(i);
				if (child.getNodeType()==org.w3c.dom.Node.ELEMENT_NODE && child.getNodeName().equals(TRANSLATIONS_TAG)) {
					sense.insertBefore(refaxie,child);
					refaxie = null;
				}
				i++;
			}
		}
		if (refaxie != null) {
			sense.appendChild(refaxie);
		}
	}
	
	
	protected static void updateAxie(String axieVolume, String refaxie, String lang, String refEntry, String refLexie) 
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		PapillonLogger.writeDebugMsg("updateAxie: axi: " + refaxie + " lang: " + lang + " e1: " + refEntry + "." + refLexie);
		VolumeEntry myAxie = VolumeEntriesFactory.findEntryByEntryId(axieVolume,refaxie);
		org.w3c.dom.Document theDom = myAxie.getDom();
		Element reflexies = (Element)theDom.getElementsByTagName(REFLEXIES_TAG).item(0);
		Element reflexie = theDom.createElement(REFLEXIE_TAG);
		reflexie.setAttribute(IDREFENTRY_TAG, refEntry);
		reflexie.setAttribute(IDREFLEXIE_TAG, refLexie);
		reflexie.setAttribute(LANG_TAG, lang);
		reflexies.appendChild(reflexie);
		
		// FIXME: if I don't recompute the DOM, it does not take into account some parts like the reflexies
		myAxie.setDom(XMLServices.buildDOMTree(XMLServices.xmlCode(theDom)));
		
		myAxie.save();
	}


}













