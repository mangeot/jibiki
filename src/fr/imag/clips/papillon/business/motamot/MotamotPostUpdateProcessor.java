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

import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.user.User;

import fr.imag.clips.papillon.business.transformation.ResultPostUpdateProcessor;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

public class MotamotPostUpdateProcessor implements ResultPostUpdateProcessor {
    
    
    public void transformation(VolumeEntry volumeEntry, User user) throws PapillonBusinessException {
        try {
			if (volumeEntry != null && volumeEntry.getDictionary().getName().equals("Motamot")
					&& !volumeEntry.getSourceLanguage().equals("axi")) {
                Document dom = volumeEntry.getDom();
                
                // mise à jour de la numérotation des sens
                NodeList entryList = dom.getElementsByTagName("m:entry");
				if ((null != entryList) && (entryList.getLength() > 0)) {
					Element entry = (Element) entryList.item(0);
					Node idmaxNode = entry.getAttributes().getNamedItem("idmax");
					int idmax = 0;
					if (idmaxNode!=null) {
						idmax = Integer.parseInt(idmaxNode.getNodeValue());
					}
					PapillonLogger.writeDebugMsg("idmax: " + idmax);
					int idmaxOrig = idmax;
					NodeList senseList = dom.getElementsByTagName("m:sense");
					if ((null != senseList) && (senseList.getLength() > 0)) {
						for (int i=0; i < senseList.getLength(); i++) {
							Element sense = (Element)senseList.item(i);
							Node senseIdAttribute = sense.getAttributes().getNamedItem("id");
							String senseId = null;
							if (senseIdAttribute != null) {
								senseId = senseIdAttribute.getNodeValue();
							}
							if (senseId==null || senseId.equals("")) {
								idmax++;
								PapillonLogger.writeDebugMsg("idmax2: " + idmax);
								sense.setAttribute("id","s"+idmax);
							}
						}
					}
					if (idmax > idmaxOrig) {
						entry.setAttribute("idmax",""+idmax);
					}
                }
                volumeEntry.save();
            }    
            
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in MotamotPostProcessor.transformation()", ex);
        }	
        
        
    }


    
}


















