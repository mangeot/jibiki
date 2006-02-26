/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.2  2006/02/26 19:21:38  mangeot
 *  Work on BrowseVolume
 *
 *  Revision 1.1  2006/02/26 14:09:32  mangeot
 *  *** empty log message ***
 *
 *
 *  -----------------------------------------------
 *  beta version
 */
package fr.imag.clips.papillon.presentation;

import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.Index;
import fr.imag.clips.papillon.business.dictionary.IndexFactory;

import fr.imag.clips.papillon.business.utility.Utility;

/**
*  Description of the Class
 *
 * @author     mangeot
 * @created    February 24, 2006
 */
public class BrowseVolume extends AbstractPO {
    
	
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return false;
    }
    
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean userMayUseThisPO() {
        return true;
    }
	
    /**
        *  Returns the complete document.
     *
     * @exception  Exception
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  IOException                Description of the Exception
     */
    public org.w3c.dom.Node getDocument()
        throws HttpPresentationException, java.io.IOException, Exception {
			
			getComms().response.setContentType("text/xml");
			getComms().response.setEncoding("UTF-8");

			
			String headword = myGetParameter("HEADWORD");
			String volumeName = myGetParameter("VOLUME");
			String direction = myGetParameter("DIRECTION");
			
			String strategy = "";
			
			if (direction != null && direction.equals("up")) {
				direction = IndexFactory.ORDER_DESCENDING;
				strategy =  QueryBuilder.LESS_THAN;
			}
			else if  (direction != null && direction.equals("down")) {
				direction = "";
				strategy = QueryBuilder.GREATER_THAN;
			}
			else {
				direction = "";
				strategy = QueryBuilder.EQUAL;
			}
			int limit = 40;

			java.util.Vector resultsVector = null;
			if (headword != null && !headword.equals("") &&
				volumeName != null && !volumeName.equals("")) {
				Volume myVolume = VolumesFactory.findVolumeByName(volumeName);
				if (myVolume != null && !myVolume.isEmpty()) {
					java.util.Vector myKeys = new java.util.Vector();
					String[] Headword = new String[4];
					Headword[0] = Volume.CDM_headword;
					Headword[1] = myVolume.getSourceLanguage();
					Headword[2] = headword;
					Headword[3] = strategy;
					myKeys.add(Headword);
					resultsVector = IndexFactory.getIndexEntriesVector(myVolume.getIndexDbname(),
																	   myKeys,
																	   direction,
																	   limit);
				}
			}
			String allArray = "";
			for (int i=0; i<resultsVector.size(); i++) {
				Index myEntry = (Index) resultsVector.elementAt(i);
				allArray += myEntry.getValue() + "#,#" + myEntry.getEntryId() + "#;#" ;
			}
			
			org.w3c.dom.Document myDoc = Utility.buildDOMTree("<?xml version='1.0' encoding='UTF-8' ?><entries>" + allArray + "</entries>");
			
            return (org.w3c.dom.Node) myDoc;
        }
    
}
