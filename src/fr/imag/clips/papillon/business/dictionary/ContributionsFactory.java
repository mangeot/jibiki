/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.6  2005/04/14 13:08:25  mangeot
 * Deleted all references to findContributionByEntryHandle
 *
 * Revision 1.5  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.4.2.3  2005/04/01 15:16:05  mangeot
 * Added validated contributions count on GDEF homepage
 *
 * Revision 1.4.2.2  2005/03/30 11:17:07  mangeot
 * Modified table contributions: replaced originalhandle by originalid
 * Corrected a few bugs when validating an already existing entry
 *
 * Revision 1.4.2.1  2005/03/29 09:41:32  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.4  2005/01/15 20:02:19  mangeot
 * Added new search options for ReviewContributions
 *
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.CurrentDBTransaction;

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

    public static Contribution newContribution(String volumeName, String srclang, String author, String groups, String headword, String entryId, String entryHandle, String status, boolean newEntry, String originalId)
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            //
            Contribution newContrib=new Contribution();
            // external id
            newContrib.setAuthor(author);
            // source language of the contrib
            newContrib.setSourceLanguage(srclang);
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
						newContrib.setOriginalId(originalId);
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
                ContributionQuery query = new ContributionQuery(CurrentDBTransaction.get());
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

    protected static Vector getContributionsForDeletion(String author, String volume)
        throws PapillonBusinessException {
            Vector theContribVector = new Vector();
            try {
                ContributionQuery query = new ContributionQuery(CurrentDBTransaction.get());
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
				
		public static Collection checkContributions(User user, Vector entriesTable) throws PapillonBusinessException {
				for (int i=0; i< entriesTable.size();i++) {					
					IAnswer myAnswer = (IAnswer) entriesTable.elementAt(i);
					Contribution myContrib = findContributionByEntryId(myAnswer.getId());
					// There is an existing contribution
					if (myContrib != null && !myContrib.IsEmpty()) {
					// the author is not the current user
						if (user==null || user.IsEmpty()) {
								entriesTable.remove(myAnswer);
								i--;
						}
						else if (!myContrib.getAuthor().equals(user.getLogin())) {
						// the current user is not in the same groups as the author
							if (!user.IsInNormalGroups(myContrib.getGroupsArray())) {
								entriesTable.remove(myAnswer);
								i--;
							}
						}
					}
				}
				return (Collection) entriesTable;
			}

			public static IAnswer myFirstContribution(Collection entriesCollection, User user) throws PapillonBusinessException {
					IAnswer myAnswer = null;
					Iterator entriesIterator = entriesCollection.iterator();
					while (myAnswer == null && entriesIterator.hasNext()) {					
					IAnswer tempAnswer = (IAnswer) entriesIterator.next();
					Contribution myContrib = findContributionByEntryId(tempAnswer.getId());
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
					Contribution myContrib = findContributionByEntryId(tempAnswer.getId());
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
				ContributionQuery query = new ContributionQuery(CurrentDBTransaction.get());

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
				// query.addOrderByHeadword(true);
				query.getQueryBuilder().addOrderByColumn("multilingual_sort(sourcelanguage,headword)","");
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

	public static Vector getContributions(String volumeName, String author, int strategy, String[] Headwords, String status, String revisor, String sortBy)
		throws PapillonBusinessException {
            Vector theContribs = new Vector();
            try {
				// consultation of a local volume
				ContributionQuery query = new ContributionQuery(CurrentDBTransaction.get());

				query.getQueryBuilder().addWhereClause("volume", volumeName,
										   QueryBuilder.EQUAL);
				if (author != null && !author.equals("")) {
					query.getQueryBuilder().addWhereClause("author", author,QueryBuilder.EQUAL);
				}
				if (revisor != null && !revisor.equals("")) {
					query.getQueryBuilder().addWhereClause("reviewer", revisor,QueryBuilder.EQUAL);
				}
				if (status != null && !status.equals("")) {
					query.getQueryBuilder().addWhereClause("status", status,QueryBuilder.EQUAL);
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
//				query.addOrderByHeadword(true);
				query.getQueryBuilder().addOrderByColumn("multilingual_sort(sourcelanguage,headword)","");
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
//				query.addOrderByHeadword(true);
				query.getQueryBuilder().addOrderByColumn("multilingual_sort(sourcelanguage,headword)","");
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
				
	// convenience method, must be changed for the new verison of the contribs
    public static Contribution findContributionByEntryId(String id)
        throws PapillonBusinessException {
			Vector myVector = getContributionsByEntryId(null, id);
			Contribution myContrib = null;
			if (myVector != null && myVector.size()>0) {
				myContrib = (Contribution) myVector.elementAt(0);
			}
            return myContrib;
        }


	public static Vector getContributionsByEntryId(String author, String entryid) throws PapillonBusinessException {
		Vector theContribs = new Vector();
		try {
			// consultation of a local volume
			ContributionQuery query = new ContributionQuery(CurrentDBTransaction.get());

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
	myContrib = newContribution(myAxie.getVolumeName(), myAxie.getSourceLanguage(), myUser.getLogin(), myUser.getGroups(), myAxie.getHeadword(), myAxie.getId(), myAxie.getHandle(), Contribution.NOT_FINISHED_STATUS, true, null);
	if (null != myContrib && !myContrib.IsEmpty()) {
		myContrib.save();
	}
	return myContrib;
}

public static Contribution createContributionFromVolumeEntry (VolumeEntry myEntry, User myUser, String originalId)
throws fr.imag.clips.papillon.business.PapillonBusinessException {
	Contribution myContrib = null;
	boolean newEntry = (originalId == null || originalId.equals(""));
	PapillonLogger.writeDebugMsg("New contrib author: " + myUser.getLogin() + " volume: " + myEntry.getVolumeName() +
							  " headword: " + myEntry.getHeadword() + " entryid: " + myEntry.getId() + " originalId: " + originalId);
	myContrib = newContribution(myEntry.getVolumeName(), myEntry.getSourceLanguage(), myUser.getLogin(), myUser.getGroups(),  myEntry.getHeadword(), myEntry.getId(), myEntry.getHandle(), Contribution.NOT_FINISHED_STATUS, newEntry, originalId);
	if (null != myContrib && !myContrib.IsEmpty()) {
		myContrib.save();
	}
	return myContrib;
}

	public static int getCount(Volume myVolume) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
			int count = -1;
			try {
                VolumeEntryQuery volumeQuery = new VolumeEntryQuery(myVolume.getDbname(), CurrentDBTransaction.get());
				count = volumeQuery.getCount();
				ContributionQuery contribsQuery = new ContributionQuery(CurrentDBTransaction.get());
				contribsQuery.getQueryBuilder().addWhereClause("volume", myVolume.getName(),
										   QueryBuilder.EQUAL);
				count -= contribsQuery.getCount();
			}
			catch (com.lutris.appserver.server.sql.DatabaseManagerException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			catch (java.sql.SQLException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			catch (com.lutris.dods.builder.generator.query.DataObjectException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			catch (com.lutris.dods.builder.generator.query.NonUniqueQueryException e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in getCount with volume: " + myVolume.getName(), e);
			}			
			return count;
		}
	

}

