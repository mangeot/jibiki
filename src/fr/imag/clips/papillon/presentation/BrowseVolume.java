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
 *  Revision 1.9  2007/01/05 13:57:26  serasset
 *  multiple code cleanup.
 *  separation of XMLServices from the Utility class
 *  added an xml parser pool to allow reuse of parser in a multithreaded context
 *  added a new field in the db to identify the db layer version
 *  added a new system property to know which db version is known by the current app
 *
 *  Revision 1.8  2006/08/10 22:17:13  fbrunet
 *  - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 *  - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 *  - Bug correction : +/- in advanced search
 *
 *  Revision 1.7  2006/07/15 08:55:14  mangeot
 *  The BrowseVolumePage opens an HTML form that is used to lookup a volume in alphabetical order.
 *  The BrowseVolume is the server side of the AJAX script for retrieving the entries in alphabetical order
 *
 *  Revision 1.6  2006/02/27 00:04:01  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.5  2006/02/26 22:05:02  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.4  2006/02/26 20:24:30  mangeot
 *  *** empty log message ***
 *
 *  Revision 1.3  2006/02/26 19:58:18  mangeot
 *  *** empty log message ***
 *
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
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.Index;
import fr.imag.clips.papillon.business.dictionary.IndexFactory;

import fr.imag.clips.papillon.business.xml.XMLServices;

/**
*  Description of the Class
 *
 * @author     mangeot
 * @created    February 24, 2006
 */
public class BrowseVolume extends AbstractPO {
    
	protected static final String ALL_STATUS = "*ALL*";
	
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

			
			String volumeName = myGetParameter("VOLUME");
			String headword = myGetParameter("HEADWORD");
			String status = myGetParameter("STATUS");
			if (status==null || status.equals("")) {
				status="validated";
			}
			//MM: I commented this for efficiency
			// If we want to check if there is a danger to show unfinished entries
			//  the following lines have to be uncommented
			/*
			else if (status != "validated") {
				fr.imag.clips.papillon.business.user.User myUser = this.getUser();
				if (myUser ==null || !myUser.isSpecialist()) {
					status="validated";
				}
			}*/
			String limitString = myGetParameter("LIMIT");
			
			int limit = 40;
			
			if (limitString!=null && !limitString.equals("")) {
				limit =Integer.parseInt(limitString);
			}
			
			String direction = myGetParameter("DIRECTION");
			String direction2 = "";
			
			String strategy = "";
			String strategy2 = "";
			
			if (direction != null && direction.equals("up")) {
				direction = IndexFactory.ORDER_DESCENDING;
				strategy =  QueryBuilder.LESS_THAN;
			}
			else if  (direction != null && direction.equals("down")) {
				direction = "";
				strategy = QueryBuilder.GREATER_THAN;
			}
			else if  (direction != null && direction.equals("updown")) {
				limit = limit /2;
				direction = "";
				strategy = QueryBuilder.GREATER_THAN_OR_EQUAL;
				direction2 = IndexFactory.ORDER_DESCENDING;
				strategy2 =  QueryBuilder.LESS_THAN;
			}
			else {
				direction = "";
				strategy = QueryBuilder.EQUAL;
			}

			String allArray = "";
			java.util.Vector resultsVector = null;
			if (headword != null && !headword.equals("") &&
				volumeName != null && !volumeName.equals("")) {
				Volume myVolume = VolumesFactory.getVolumeByName(volumeName);
				if (myVolume != null && !myVolume.isEmpty()) {
					java.util.Vector myKeys = new java.util.Vector();
					String[] Headword = new String[4];
					String[] Status = new String[4];
					Headword[0] = Volume.CDM_headword;
					Headword[1] = myVolume.getSourceLanguage();
					Headword[2] = headword;
					Headword[3] = strategy;
					myKeys.add(Headword);
					if (status!=null && !status.equals(ALL_STATUS)) {
						Status[0] = Volume.CDM_contributionStatus;
						Status[1] = Volume.DEFAULT_LANG;
						Status[2] = status;
						Status[3] = QueryBuilder.EQUAL;
						myKeys.add(Status);
						resultsVector = VolumeEntriesFactory.getVolumeNameEntriesVector(myVolume.getName(),
																						myKeys,
																						null,
																						null,
																						direction, 
																						0,
																						limit);
						for (int i=0; i<resultsVector.size(); i++) {
							VolumeEntry myEntry = (VolumeEntry) resultsVector.elementAt(i);
							allArray += myEntry.getHeadword() + "#,#" + myEntry.getHandle() + "#;#" ;
						}
					}
					else {
						resultsVector = IndexFactory.getIndexEntriesVector(myVolume.getIndexDbname(),
																		   myKeys,
																		   direction,
																		   limit);
						for (int i=0; i<resultsVector.size(); i++) {
							Index myEntry = (Index) resultsVector.elementAt(i);
							allArray += myEntry.getValue() + "#,#" + myEntry.getEntryId() + "#;#" ;
						}
					}
					if (direction2 != "" && strategy2 != "") {
						myKeys.clear();
						Headword[3] = strategy2;
						myKeys.add(Headword);
						String allArray2 = "";
						if (status!=null && !status.equals(ALL_STATUS)) {
							myKeys.add(Status);
							resultsVector = VolumeEntriesFactory.getVolumeNameEntriesVector(myVolume.getName(),
																							myKeys,
																							null,
																							null,
																							direction2, 
																							0,
																							limit);
							for (int i=0; i< resultsVector.size(); i++) {
								VolumeEntry myEntry = (VolumeEntry) resultsVector.elementAt(i);
								allArray2 += myEntry.getHeadword() + "#,#" + myEntry.getHandle() + "#;#";
							}
						}
						else {
							resultsVector = IndexFactory.getIndexEntriesVector(myVolume.getIndexDbname(),
																			   myKeys,
																			   direction2,
																			   limit);
							for (int i=resultsVector.size()-1; i>=0; i--) {
								Index myEntry = (Index) resultsVector.elementAt(i);
								allArray2 += myEntry.getValue() + "#,#" + myEntry.getEntryId() + "#;#";
							}
						}
						allArray = allArray2 + allArray;
					}
				}
			}
			
			org.w3c.dom.Document myDoc = XMLServices.buildDOMTree("<?xml version='1.0' encoding='UTF-8' ?><entries>" + allArray + "</entries>");
			
            return (org.w3c.dom.Node) myDoc;
        }
    
}
