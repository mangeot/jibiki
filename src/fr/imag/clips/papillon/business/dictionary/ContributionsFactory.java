/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.7  2004/10/28 10:38:11  mangeot
 * Fixed some bugs that affected the dictd server
 * Modified some methods in order to display a text entry in the dictd server
 *
 * Revision 1.6  2004/03/08 04:27:34  mangeot
 *  co
 *
 * Revision 1.5  2004/02/16 08:08:11  mangeot
 * bugs fix for reviewContributions
 *
 * Revision 1.4  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.3.2.5  2004/02/08 03:46:24  mangeot
 * bug fixes, cleaning code
 *
 * Revision 1.3.2.4  2004/01/13 05:10:19  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.3  2004/01/09 08:32:23  mangeot
 * Hacked my code because of the same encoding problem. Have to be deleted when fixed with Gilles patchFi
 *
 * Revision 1.3.2.2  2004/01/09 05:18:56  mangeot
 * Bugs fixes !
 *
 * Revision 1.3.2.1  2004/01/08 09:43:18  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.3  2003/08/14 08:30:10  mangeot
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
 * Revision 1.2.2.11  2003/08/14 04:15:51  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.10  2003/08/11 10:24:50  mangeot
 * Debugging ...
 *
 * Revision 1.2.2.9  2003/08/09 07:21:04  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.2.2.8  2003/08/07 06:29:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.7  2003/07/04 15:18:55  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.6  2003/05/29 03:50:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.5  2003/05/28 09:17:15  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.2.2.4  2003/05/23 11:07:37  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.3  2003/05/21 10:15:08  mangeot
 * Travail sur l'interface d'edition
 *
 * Revision 1.2.2.2  2003/03/25 08:59:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.1  2003/03/24 09:29:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/11/22 13:04:10  mangeot
 * Nouvelle version Papillon enhydra 5.0
 *
 * Revision 1.1.1.1  2002/10/28 16:49:12  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.3  2002/10/25 14:10:29  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.2.2.2  2002/10/24 06:58:49  mangeot
 * Corrected an important bug in AdminContributions.java
 * Better to reinstall !
 *
 * Revision 1.2.2.1  2002/10/09 03:13:16  mangeot
 * bug corrected in contributions
 *
 * Revision 1.2  2002/09/17 17:13:20  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.1  2002/08/10 12:11:07  mangeot
 * Added contribution files
 *
 * Revision 1.3  2002/08/10 11:32:09  mangeot
 * Added pages to edit monolingual entries
 * it is very beta version
 *
 * Revision 1.2  2002/08/10 09:18:58  mangeot
 * Added funcitonalities to the AdminContributions page
 *
 * Revision 1.1  2002/08/10 00:07:43  mangeot
 * Added files for contributions
 *
 * Revision 1.11  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.10  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.9  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.8  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.7  2002/04/17 19:18:22  mangeot
 * I deleted the form AdminXml.po and created another one:
 * AddEntries.po
 * Now you can't add entries without a metadata file associated.
 *
 * Revision 1.6  2002/04/17 17:09:23  mangeot
 * Travail sur les stylesheets
 *
 * Revision 1.5  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/04/16 02:44:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/04/14 09:47:12  mangeot
 * lecture des elements CDM ds les fichiers volume-metadata
 * et upload des entrees
 *
 * Revision 1.1  2002/04/01 07:48:10  mangeot
 * Added these files to manage volume metadata files
 *
 * Revision 1.2  2002/03/27 09:51:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/03/11 11:15:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/10/17 13:02:03  serasset
 * Distinction entre Doucmuent (abstrait) et fichier (qui constituent concretement un doucument)
 *
 * Revision 1.5  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.4  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.3  2001/07/12 20:38:45  salvati
 * Added Node2String function and use of it
 *
 * Revision 1.2  2001/07/12 17:58:00  salvati
 * end of debug
 * CV: ----------------------------------------------------------------------
 *
 * Revision 1.1  2001/07/12 17:38:08  salvati
 * Renaming ContributionFactory in DictionarEntriesFactory
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;

//for URLs
import java.net.*;


//pour parser le document avec le DOM
import org.w3c.dom.*;

import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;

import java.util.*;
import java.io.*;

import fr.imag.clips.papillon.business.utility.*;

/**
* Used to find the instances of xslsheet.
 */
public class ContributionsFactory {

    protected final static String DML_URI = "http://www-clips.imag.fr/geta/services/dml";

    public static Contribution newContribution(String volumeName, String author, String groups, String headword, String entryId, String entryHandle, String status, boolean newEntry, String originalHandle)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            //
            Contribution newContrib=new Contribution();
            // external id
            newContrib.setAuthor(author);
            // external id
            newContrib.setGroups(groups);
            // external id
            newContrib.setVolumeName(volumeName);
            // external id
            newContrib.setHeadword(headword);
            // external id
            newContrib.setEntryId(entryId);
            //xml code
            newContrib.setEntryHandle(entryHandle);
            //xml code
            newContrib.setStatus(status);
            //xml code
            newContrib.setCreationDate(new Date());
            //xml code
            newContrib.setNewEntry(newEntry);
						if (!newEntry) {
						newContrib.setOriginalHandle(originalHandle);
						}
            return newContrib;
        }

    public static Contribution findContributionByHandle(String handle)
        throws PapillonBusinessException {
            Contribution theContribution = null;
            ContributionDO theContributionDO = null;

						int intId = 0;
						try {
							intId = Integer.parseInt(handle);
						}
						catch(NumberFormatException ex) {
							return theContribution;
            }
						
            try {
                ContributionQuery query = new ContributionQuery();
                //set query
                query.setQueryOId(new ObjectId(intId));
                // Throw an exception if more than one message is found
                query.requireUniqueInstance();
                theContributionDO = query.getNextDO();
				if (theContributionDO != null) {
					theContribution = new Contribution(theContributionDO);
				}
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findContributionByHandle()", ex);
            }
            return theContribution;
        }

    public static Contribution findContributionByEntryHandle(String handle)
        throws PapillonBusinessException {
            Contribution theContribution = null;
            ContributionDO theContributionDO = null;
						
            try {
                ContributionQuery query = new ContributionQuery();
                //set query
                query.setQueryEntryHandle(handle);
                // Throw an exception if more than one message is found
             //   query.requireUniqueInstance();
                theContributionDO = query.getNextDO();
							if (theContributionDO != null) {
								theContribution = new Contribution(theContributionDO);
							}
            }
            catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findContributionByHandle()", ex);
            }
            return theContribution;
        }

    protected static Vector getContributionsForDeletion(String author, String volume)
        throws PapillonBusinessException {
            Vector theContribVector = new Vector();
            try {
                ContributionQuery query = new ContributionQuery();
				if (author !=null && !author.equals("")) {
					query.getQueryBuilder().addWhereClause("author", author,
                                                       QueryBuilder.EQUAL);
				}
				if (volume !=null && !volume.equals("")) {
					query.getQueryBuilder().addWhereClause("volume", volume,
                                                       QueryBuilder.EQUAL);
				}
                ContributionDO[] DOarray = query.getDOArray();
                for ( int i = 0; i < DOarray.length; i++ ) {
                    theContribVector.add(new Contribution(DOarray[i]));
                }
            }catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getContributionsForDeletion()", ex);
            }
            return theContribVector;
        }
				
			public static Collection checkContributions(User user, Hashtable entriesTable) throws PapillonBusinessException {
				for (Enumeration handles = entriesTable.keys(); handles.hasMoreElements();) {					
					String handle = (String) handles.nextElement();
					Contribution myContrib = findContributionByEntryHandle(handle);
					// There is an existing contribution
					if (myContrib != null && !myContrib.IsEmpty()) {
					// the author is not the current user
						if (user==null || user.IsEmpty()) {
								entriesTable.remove(handle);
						}
						else if (user !=null && !user.IsEmpty() && !myContrib.getAuthor().equals(user.getLogin())) {
						// the current user is not in the same groups as the author
							if (!user.IsInGroups(myContrib.getGroupsArray())) {
								entriesTable.remove(handle);
							}
						}
					}
				}
				return entriesTable.values();
			}

			public static IAnswer myFirstContribution(Collection entriesCollection, User user) throws PapillonBusinessException {
					IAnswer myAnswer = null;
					Iterator entriesIterator = entriesCollection.iterator();
					while (myAnswer == null && entriesIterator.hasNext()) {					
					IAnswer tempAnswer = (IAnswer) entriesIterator.next();
					Contribution myContrib = findContributionByEntryHandle(tempAnswer.getHandle());
					// There is an existing contribution
					if (myContrib != null && !myContrib.IsEmpty()) {
					// the author is the current user
						if (myContrib.getAuthor().equals(user.getLogin())) {
						myAnswer = tempAnswer;
						}
					}
				}
				return myAnswer;
			}

			public static IAnswer myFirstGroupContribution(Collection entriesCollection, User user) throws PapillonBusinessException {
					IAnswer myAnswer = null;
					Iterator entriesIterator = entriesCollection.iterator();
					while (myAnswer == null && entriesIterator.hasNext()) {					
					IAnswer tempAnswer = (IAnswer) entriesIterator.next();
					Contribution myContrib = findContributionByEntryHandle(tempAnswer.getHandle());
					// There is an existing contribution
					if (myContrib != null && !myContrib.IsEmpty()) {
					// the author is the user groups
						if (user.IsInGroups(myContrib.getGroupsArray())) {
							myAnswer = tempAnswer;
						}
					}
				}
				return myAnswer;
			}
			
			
			public static Vector getContributions(String volumeName, User myUser, String sortBy)
		throws PapillonBusinessException {
            Vector theContribs = new Vector();
						String author = myUser.getLogin();
            try {
				// consultation of a local volume
				ContributionQuery query = new ContributionQuery();

				query.getQueryBuilder().addWhereClause("volume", volumeName,
										   QueryBuilder.EQUAL);
				if (author != null && !author.equals("")) {
					query.getQueryBuilder().addWhereClause("author", author,
											QueryBuilder.EQUAL);
				}
					if (sortBy!=null && !sortBy.equals("")) {
						if (sortBy.equals("volume")) {
							query.addOrderByVolume(true);
						}
						else if (sortBy.equals("author")) {
							query.addOrderByAuthor(true);
						}
						else if (sortBy.equals("creationdate")) {
							query.addOrderByCreationDate(true);
						}
						else if (sortBy.equals("status")) {
							query.addOrderByStatus(true);
						}
						else if (sortBy.equals("newentry")) {
							query.addOrderByNewEntry(true);
						}
						else if (sortBy.equals("reviewer")) {
							query.addOrderByReviewer(true);
						}
						else if (sortBy.equals("reviewdate")) {
							query.addOrderByReviewDate(true);
						}
					}
				query.addOrderByHeadword(true);
				ContributionDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						theContribs.add(new Contribution(DOarray[j]));
					}
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getContributions()", ex);
			}
			return theContribs;
		}

	public static Vector getContributions(String volumeName, String author, int strategy, String[] Headwords, String sortBy)
		throws PapillonBusinessException {
            Vector theContribs = new Vector();
            try {
				// consultation of a local volume
				ContributionQuery query = new ContributionQuery();

				query.getQueryBuilder().addWhereClause("volume", volumeName,
										   QueryBuilder.EQUAL);
				if (author != null && !author.equals("")) {
					query.getQueryBuilder().addWhereClause("author", author,
											QueryBuilder.EQUAL);
				}
				if (Headwords != null && Headwords.length>0) {
				for (int i=0;i<Headwords.length;i++) {
					String headword = Headwords[i];
				if (headword != null && !headword.equals("")) {
					// Different strategies
					String CIE = QueryBuilder.CASE_INSENSITIVE_EQUAL;
					String CIC = QueryBuilder.CASE_INSENSITIVE_CONTAINS;
					String cmp_op = CIE;

					if (strategy == IQuery.STRATEGY_EXACT) {
						cmp_op = CIE;
					}
					else if (strategy == IQuery.STRATEGY_PREFIX) {
						cmp_op = CIC;
					}
					else if (strategy == IQuery.STRATEGY_SUFFIX) {
						cmp_op = CIC;
					}
					else if (strategy == IQuery.STRATEGY_SUBSTRING) {
						cmp_op = CIC;
					}
					else {
						cmp_op = CIC;
					}
					query.getQueryBuilder().addWhereClause("headword", headword,cmp_op);
					if (sortBy!=null && !sortBy.equals("")) {
						if (sortBy.equals("volume")) {
							query.addOrderByVolume(true);
						}
						else if (sortBy.equals("author")) {
							query.addOrderByAuthor(true);
						}
						else if (sortBy.equals("creationdate")) {
							query.addOrderByCreationDate(true);
						}
						else if (sortBy.equals("status")) {
							query.addOrderByStatus(true);
						}
						else if (sortBy.equals("newentry")) {
							query.addOrderByNewEntry(true);
						}
						else if (sortBy.equals("reviewer")) {
							query.addOrderByReviewer(true);
						}
						else if (sortBy.equals("reviewdate")) {
							query.addOrderByReviewDate(true);
						}
					}
				query.addOrderByHeadword(true);
				ContributionDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						theContribs.add(new Contribution(DOarray[j]));
					}
				}
			}
			}
			}
			else {
					if (sortBy!=null && !sortBy.equals("")) {
						if (sortBy.equals("volume")) {
							query.addOrderByVolume(true);
						}
						else if (sortBy.equals("author")) {
							query.addOrderByAuthor(true);
						}
						else if (sortBy.equals("creationdate")) {
							query.addOrderByCreationDate(true);
						}
						else if (sortBy.equals("status")) {
							query.addOrderByStatus(true);
						}
						else if (sortBy.equals("newentry")) {
							query.addOrderByNewEntry(true);
						}
						else if (sortBy.equals("reviewer")) {
							query.addOrderByReviewer(true);
						}
						else if (sortBy.equals("reviewdate")) {
							query.addOrderByReviewDate(true);
						}
					}
				query.addOrderByHeadword(true);
				ContributionDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						theContribs.add(new Contribution(DOarray[j]));
					}
				}			
			}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getContributions()", ex);
			}
			return theContribs;
        }
				

	public static Vector getContributionsByEntryId(String author, String entryid) throws PapillonBusinessException {
		Vector theContribs = new Vector();
		try {
			// consultation of a local volume
			ContributionQuery query = new ContributionQuery();

			query.getQueryBuilder().addWhereClause("entryid", entryid,
										  QueryBuilder.EQUAL);
			if (author != null && !author.equals("")) {
				query.getQueryBuilder().addWhereClause("author", author,
										   QueryBuilder.EQUAL);
			}
			ContributionDO[] DOarray = query.getDOArray();
			if (null != DOarray) {
				for (int j=0; j < DOarray.length; j++) {
					theContribs.add(new Contribution(DOarray[j]));
				}
			}
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in getContributions()", ex);
		}
		return theContribs;
	}
	
public static void removeContributions(String author, String volume)
throws fr.imag.clips.papillon.business.PapillonBusinessException {
	Vector ContribVector = getContributionsForDeletion(author,volume);
	if (null != ContribVector && ContribVector.size()>0) {
		for (int i=0;i<ContribVector.size();i++) {
			((Contribution)ContribVector.get(i)).delete();
		}
	}
}

public static void removeContributions(Volume volume)
throws fr.imag.clips.papillon.business.PapillonBusinessException {
	Vector ContribVector = getContributionsForDeletion("",volume.getName());
	if (null != ContribVector && ContribVector.size()>0) {
		for (int i=0;i<ContribVector.size();i++) {
			((Contribution)ContribVector.get(i)).delete();
		}
	}
}

public static Contribution createContributionFromAxie (Axie myAxie, User myUser)
throws fr.imag.clips.papillon.business.PapillonBusinessException {
	Contribution myContrib = null;
	PapillonLogger.writeDebugMsg("New contrib author: " + myUser.getLogin() + " volume: " + myAxie.getVolumeName() +
							  " headword: " + myAxie.getHeadword() + " entryid: " + myAxie.getId());
	myContrib = newContribution(myAxie.getVolumeName(), myUser.getLogin(), myUser.getGroups(), myAxie.getHeadword(), myAxie.getId(), myAxie.getHandle(), Contribution.NOT_FINISHED_STATUS, true, null);
	if (null != myContrib && !myContrib.IsEmpty()) {
		myContrib.save();
	}
	return myContrib;
}

public static Contribution createContributionFromVolumeEntry (VolumeEntry myEntry, User myUser, String originalHandle)
throws fr.imag.clips.papillon.business.PapillonBusinessException {
	Contribution myContrib = null;
	boolean newEntry = (originalHandle == null || originalHandle.equals(""));
	PapillonLogger.writeDebugMsg("New contrib author: " + myUser.getLogin() + " volume: " + myEntry.getVolumeName() +
							  " headword: " + myEntry.getHeadword() + " entryid: " + myEntry.getId());
	myContrib = newContribution(myEntry.getVolumeName(), myUser.getLogin(), myUser.getGroups(),  myEntry.getHeadword(), myEntry.getId(), myEntry.getHandle(), Contribution.NOT_FINISHED_STATUS, newEntry, originalHandle);
	if (null != myContrib && !myContrib.IsEmpty()) {
		myContrib.save();
	}
	return myContrib;
}


}

