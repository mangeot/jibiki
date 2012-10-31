/*
 -----------------------------
 * $Id: LinkFactory.java 1111 2012-03-26 22:00:04 zhang ying $
 *-----------------------------------------------
 * $Log$
 * 
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.dictionary;

import com.lutris.dods.builder.generator.query.QueryBuilder;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.data.LinkDO;
import fr.imag.clips.papillon.data.LinkQuery;
import fr.imag.clips.papillon.data.VolumeEntryDO;
import fr.imag.clips.papillon.data.VolumeEntryQuery;
import fr.imag.clips.papillon.papillon_data.ManageDatabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
* Used to find the instances of xslsheet.
 */
public class LinkFactory {
	
	public final static String LINK_TABLE_PREFIX = "link";
	
	public final static String OBJECTID_FIELD = "objectid";

	public final static String ENTRYID_FIELD = "entryid";

	public final static String NAME_FIELD = "name";
	public final static String LANG_FIELD = "lang";
	public final static String VOLUME_FIELD = "volumetarget";
	public final static String TYPE_FIELD = "type";
	public final static String WEIGHT_FIELD = "weight";
	public final static String LABEL_FIELD = "label";
	
	public final static String ORDER_ASCENDING = "";
	public final static String ORDER_DESCENDING = "DESC";
	
	protected final static String databaseName = LinkDO.get_logicalDBName(); 
	public static String databaseVendor = null;
	protected static com.lutris.dods.builder.generator.query.RDBColumn[] Columns = new com.lutris.dods.builder.generator.query.RDBColumn[1];

	static {
		try  {
			databaseVendor = org.enhydra.dods.DODS.getDatabaseManager().logicalDatabaseType(databaseName);
		}
		catch (com.lutris.appserver.server.sql.DatabaseManagerException ex) {
			databaseVendor = null;
		}
		catch (java.sql.SQLException ex) {
			databaseVendor = null;
		}
	}
		
	
        
	public static ArrayList getLinkArrayByEntryId(Volume volume, String entryId) throws PapillonBusinessException {
		ArrayList theLink = new ArrayList();
		
		if (entryId != null && !entryId.equals("")) {
			int intId = 0;
			try {
				intId = Integer.parseInt(entryId);
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getLinkVectorByEntryId()", ex);
			}
			
			try {
				LinkQuery query = new LinkQuery(volume.getLinkDbname(), CurrentDBTransaction.get());
				query.setQueryEntryId(intId);
				LinkDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						theLink.add(new Link(DOarray[j]));
					}
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getLinkVectorByEntryId()", ex);
			}
		}
		return theLink;
	}
	
/*////	public static Vector getLinkEntriesVector(String linkTableName, Vector Keys, String order, int limit) throws PapillonBusinessException {
		return getLinkEntriesVector(linkTableName, Keys, order, limit,0);
	}
////*/
	
/*////	public static Vector getLinkEntriesVector(String linkTableName, Vector Keys, String order, int limit, int offset) throws PapillonBusinessException {
        Vector theEntries = new Vector();
		
		if (null != linkTableName) {
			try {
			////	com.lutris.dods.builder.generator.query.RDBColumn keyColumn = LinkDO.getKeyColumn(linkTableName);
				com.lutris.dods.builder.generator.query.RDBColumn langColumn = LinkDO.getLangColumn(linkTableName);
			////	com.lutris.dods.builder.generator.query.RDBColumn valueColumn = LinkDO.getValueColumn(linkTableName);
				LinkQuery query = new LinkQuery(linkTableName, CurrentDBTransaction.get());
				//fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Index request table: " + indexTableName);
	
				if (Keys != null) {
					for (java.util.Enumeration enumKeys = Keys.elements(); enumKeys.hasMoreElements();) {
						String[] key = (String[]) enumKeys.nextElement();
						if (key!=null && key[2] !=null && !key[2].equals("")) {
						////	query.getQueryBuilder().addWhere(keyColumn, key[0], QueryBuilder.EQUAL);
							if (key[1] !=null && !key[1].equals("")) {
								query.getQueryBuilder().addWhere(langColumn, key[1], QueryBuilder.EQUAL);
							}
							if ( key[3] == QueryBuilder.LESS_THAN ||
								 key[3] == QueryBuilder.LESS_THAN_OR_EQUAL ||
								 key[3] == QueryBuilder.GREATER_THAN ||
								 key[3] == QueryBuilder.GREATER_THAN_OR_EQUAL) {
								query.getQueryBuilder().addWhere(MSORT_FIELD + key[3]+ "multilingual_sort('" + key[1] + "','" + key[2] + "')");
							}
							else {
						////		query.getQueryBuilder().addWhere(valueColumn, key[2],  key[3]);
							}
						}
					}
				}				
				query.getQueryBuilder().setMaxRows((0 == limit) ? DictionariesFactory.MaxRetrievedEntries : limit);
				if (offset!=0) {
					query.getQueryBuilder().addEndClause("OFFSET " + offset);
				}
				if (order==null || !order.equals(ORDER_DESCENDING)) {
					order = "";
				}
				query.getQueryBuilder().addOrderByColumn(MSORT_FIELD,order);
				// debug
				//query.getQueryBuilder().debug();
				
				LinkDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						Link tempLink = new Link(DOarray[j]);
						theEntries.add(tempLink);
					}
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in getLinkEntriesVector()", ex);
			}
		}
		return theEntries;
	}
	////*/
	protected static void deleteLinkForEntryId(String linkDbname, String entryId) throws 	PapillonBusinessException {		
		String cmp_op = QueryBuilder.EQUAL;
		
		int intId = 0;
		try {
			intId = Integer.parseInt(entryId);
		}
		catch(Exception ex) {
			throw new PapillonBusinessException("Exception in newLink()", ex);
		}
		
		
		if (entryId != null && !entryId.equals("")) {
			try {
				LinkQuery query = new LinkQuery(linkDbname, CurrentDBTransaction.get());
				query.setQueryEntryId(intId);
				LinkDO[] DOarray = query.getDOArray();
				if (null != DOarray) {
					for (int j=0; j < DOarray.length; j++) {
						Link myLink = new Link(DOarray[j]);
						myLink.delete();
					}
				}
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in deleteLinkForEntryId()", ex);
			}
		}
	}
	
	public static Link newLink(String table, String name, String lang, String handle)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			//
			int intId = 0;
			try {
				intId = Integer.parseInt(handle);
			}
			catch(Exception ex) {
				throw new PapillonBusinessException("Exception in newLink()", ex);
			}
			
			Link newLink = new Link(table);
			//PapillonLogger.writeDebugMsg("value = "+targetId+", lang = "+lang+", handle = "+handle+"weight = "+ weight);
			// lang of the key
			if (lang.length()==3) {
				newLink.setLang(lang);
			}
			else {
				newLink.setLang(Volume.DEFAULT_LANG);
			}
			newLink.setName(name);
			// entry id
			newLink.setEntryId(intId);
					//
			//fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("NEW INDEX : table=" + table + " key=" + key + " lang=" + lang + " value=" + value + " lang=" + handle);
			return newLink;
            
		}

	public static String[] findHeadwordbyEntryId (String entryId, String tableName) {
		String[] headword=null;
		try{
			LinkQuery qr = new LinkQuery(tableName,CurrentDBTransaction.get());
			qr.setQueryEntryId(Integer.parseInt(entryId));
			LinkDO[] theLinkEntry = qr.getDOArray();
			headword = new String[theLinkEntry.length];
			for (int i=0; i<theLinkEntry.length;i++){
				headword[i] = theLinkEntry[i].getTargetId();
				//String[] hw = headword[i].split("\\.");
				//headword[i] = hw[1];
			}
			
		}catch(Exception ex){
			PapillonLogger.writeDebugMsg("findHeadwordbyEntryId error"+ex);
		}
		return headword;
	}
	
    /**
	 * Gets the linked entries of an entry
	 * recursive procedure.
     *
     * @param theEntry the VolumeEntry
     * @param theAxies an ArrayList of axies already linked 
     * @param theLinks the HashMap of linked entries by entryid
     * @param targets Collection of target languages
     * @param direction string representing the direction of the result tree traversal (Link.DIRECTION_UP or Link.DIRECTION_DOWN)
     * @param user the user
     * @return void
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
	 *   error).
     */
	public static void getLinkedEntriesByEntry(VolumeEntry theEntry, ArrayList theAxies, HashMap theLinks, Collection targets, String direction, User user) throws PapillonBusinessException {
		try {
			PapillonLogger.writeDebugMsg("getLinkedEntriesByEntry: start "+ theEntry.getEntryId() + " direction: " + direction);
				LinkQuery qr = new LinkQuery(theEntry.getVolume().getLinkDbname(),CurrentDBTransaction.get());
				qr.setQueryEntryId(Integer.parseInt(theEntry.getHandle()));
//				qr.setQueryLang(lang);
				LinkDO[] DOarray = qr.getDOArray();
				for (int i=0; i<DOarray.length;i++){
					Link tempLink = new Link(DOarray[i]);
					String targetId = tempLink.getTargetId();
					String type = tempLink.getType();
					if (((direction.equals(Link.DIRECTION_UP) && (type == null || !type.equals(Link.FINAL_TYPE)))
						|| (direction.equals(Link.DIRECTION_DOWN) && ((type == null || !type.equals(Link.FINAL_TYPE)) || 
																		(type.equals(Link.FINAL_TYPE) && targets.contains(tempLink.getLang())))))
						&& !theAxies.contains(targetId)) {
						VolumeEntry linkedEntry = (VolumeEntry) theLinks.get(targetId);
						if (linkedEntry == null ||linkedEntry.isEmpty()) {
							Volume myVolume = VolumesFactory.getVolumeByName(tempLink.getVolumeTarget());
							if (myVolume !=null && !myVolume.isEmpty()) {
								PapillonLogger.writeDebugMsg("getLinkedEntriesByEntry: call findEntryByEntryId "+ myVolume.getName() + " " + targetId);
								linkedEntry = VolumeEntriesFactory.findEntryByEntryId(user, myVolume, targetId);
								if (linkedEntry != null && !linkedEntry.isEmpty() &&!theLinks.containsKey(targetId)) {
									theLinks.put(targetId,linkedEntry);
								}
							}
						}
						if (linkedEntry != null && !linkedEntry.isEmpty()) {
							if (type == null || !type.equals(Link.FINAL_TYPE)) {
								String prevDir = direction;
								if (type != null && type.equals(Link.AXIE_TYPE)) {
									theAxies.add(targetId);
									direction = Link.DIRECTION_DOWN;
								}
								PapillonLogger.writeDebugMsg("getLinkedEntriesByEntry: call getLinkedEntriesByEntry "+ linkedEntry.getEntryId()  + " lang: " + tempLink.getLang());
								getLinkedEntriesByEntry(linkedEntry, theAxies, theLinks, targets, direction, user);
								direction = prevDir;
							}
						}
					}
				}
//			}
			
		} catch(Exception ex){
			throw new PapillonBusinessException("Exception in getLinkedEntriesByEntry()", ex);
		}
	}

	public static void getLinkedEntriesByAxie(VolumeEntry theEntry, ArrayList theLinks, HashMap allLinks, User user) throws PapillonBusinessException {
		try {
			// PapillonLogger.writeDebugMsg("getLinkedEntriesByAxie: "+ theEntry.getEntryId());
			LinkQuery qr = new LinkQuery(theEntry.getVolume().getLinkDbname(),CurrentDBTransaction.get());
			qr.setQueryEntryId(Integer.parseInt(theEntry.getHandle()));
			LinkDO[] DOarray = qr.getDOArray();
			for (int i=0; i<DOarray.length;i++){
				Link tempLink = new Link(DOarray[i]);
				String linkType = tempLink.getType();
				String targetId = tempLink.getTargetId();
				if (linkType ==null || !linkType.equals(Link.AXIE_TYPE)) {
					VolumeEntry linkedEntry = (VolumeEntry) allLinks.get(targetId);
					if (linkedEntry==null || linkedEntry.isEmpty()) {
						Volume myVolume = VolumesFactory.getVolumeByName(tempLink.getVolumeTarget());
						if (myVolume !=null && !myVolume.isEmpty()) {
							// PapillonLogger.writeDebugMsg("getLinkedEntriesByAxie: find volume "+ tempLink.getVolumeTarget() + " TargetId: " + tempLink.getTargetId());
							linkedEntry = VolumeEntriesFactory.findEntryByEntryId(user, myVolume, tempLink.getTargetId());
							if (linkedEntry != null && !linkedEntry.isEmpty()) {
								allLinks.put(targetId,linkedEntry);
							}
						}
					}
					else {
						// PapillonLogger.writeDebugMsg("getLinkedEntriesByAxie: linkedEntry already in "+ tempLink.getVolumeTarget() + " TargetId: " + tempLink.getTargetId());
					}
					if (linkedEntry != null && !linkedEntry.isEmpty() && !theLinks.contains(targetId)) {
						theLinks.add(targetId);
						if (linkType == null || !linkType.equals(Link.FINAL_TYPE)) {
							getLinkedEntriesByAxie(linkedEntry, theLinks, allLinks, user);
						}
					}
				}
			}
			
		} catch(Exception ex){
			throw new PapillonBusinessException("Exception in getLinkedEntriesByAxie()", ex);
		}
	}
	
	
	public static HashMap getLinkedAxiesByEntry(VolumeEntry theEntry, HashMap theLinks, User user) throws PapillonBusinessException {
		//PapillonLogger.writeDebugMsg("getLinkedAxiesByEntry: "+ theEntry.getHeadword() + " entryId: " + theEntry.getEntryId());
		HashMap theAxies = new HashMap();
		try{
			LinkQuery qr = new LinkQuery(theEntry.getVolume().getLinkDbname(),CurrentDBTransaction.get());
			qr.setQueryEntryId(Integer.parseInt(theEntry.getHandle()));
			LinkDO[] DOarray = qr.getDOArray();
			for (int i=0; i<DOarray.length;i++){
				Link tempLink = new Link(DOarray[i]);
				String targetId = tempLink.getTargetId();
				if (!theAxies.containsKey(targetId)) {
				VolumeEntry linkedEntry = (VolumeEntry) theLinks.get(targetId);
				if (linkedEntry==null || linkedEntry.isEmpty()) {
					Volume myVolume = VolumesFactory.getVolumeByName(tempLink.getVolumeTarget());
					if (myVolume !=null && !myVolume.isEmpty()) {
						linkedEntry = VolumeEntriesFactory.findEntryByEntryId(user, myVolume, tempLink.getTargetId());
					}
				}
				if (linkedEntry != null && !linkedEntry.isEmpty()) {
					if (tempLink.getType() != null && tempLink.getType().equals(Link.AXIE_TYPE)) {
						//PapillonLogger.writeDebugMsg("getLinkedAxiesByEntry: axie found: "+ linkedEntry.getHeadword() + " entryId: " + linkedEntry.getEntryId());
						theAxies.put(linkedEntry.getEntryId(),linkedEntry);
					}
					else if (tempLink.getType() != null && !tempLink.getType().equals(Link.FINAL_TYPE)) {
						theLinks.put(tempLink.getTargetId(),linkedEntry);
						theAxies.putAll(getLinkedAxiesByEntry(linkedEntry,theLinks,user));
					}
					else {
						theLinks.put(tempLink.getTargetId(),linkedEntry);
					}
				}
				}
			}
			
		} catch(Exception ex){
			throw new PapillonBusinessException("Exception in getLinkedAxiesByEntry()", ex);
		}
		return theAxies;
	}
	
	
//	public static String[] findTranslationIdByEntryId (String[] entryId, String tableName)
//	throws PapillonBusinessException {
//		VolumeEntry theEntry = null;
//		String[] myEntryId = null;
//		try{
//			VolumeEntryQuery query = new VolumeEntryQuery(myVolume.getDbname(), CurrentDBTransaction.get());
//			//set query
//			query.setQueryHeadword(entryName);
//			VolumeEntryDO[] theEntryDO = query.getDOArray();			
//			myEntryId = new String[theEntryDO.length];
//			for(int i=0; i<theEntryDO.length;i++){	
//				String testid = theEntryDO[0].get_Handle();
//				myEntryId[i] = theEntryDO[i].get_Handle();
//			}
//	    }catch(Exception ex) {
//	        throw new PapillonBusinessException("Exception in findEntryIdByEntryName()", ex);
//	    }
//		return myEntryId;
//	}
	
	public static void emptyLink(String table)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			try {
				ManageDatabase.truncateTable(table);
			}
			catch (Exception e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in emptyLink with table: " + table, e);
			}
		}
	
	public static void createLinkTable(Volume volume)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			try {
				ManageDatabase.createLinkTable(volume.getLinkDbname());
				createIndexForTable(volume.getLinkDbname());
			}
			catch (Exception e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in createLinkTable " + volume.getLinkDbname() + " for volume: " + volume.getName(), e);
			}
		}
	
	protected static void createIndexForTable(String table)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			try {
				ManageDatabase.createIndexForTable(table,OBJECTID_FIELD);
				ManageDatabase.createIndexForTable(table,ENTRYID_FIELD);
				ManageDatabase.createIndexForTable(table,NAME_FIELD);
				ManageDatabase.createIndexForTable(table,LANG_FIELD);
				ManageDatabase.createIndexForTable(table,VOLUME_FIELD);
				ManageDatabase.createIndexForTable(table,TYPE_FIELD);
				ManageDatabase.createIndexForTable(table,WEIGHT_FIELD);
				ManageDatabase.createIndexForTable(table,LABEL_FIELD);				
			}
			catch (Exception e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in createLinkForTable: " + table, e);
			}
		}
	
	public static void dropLinkTable(Volume theVolume) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			dropLinkTable(theVolume.getLinkDbname());
		}
	
	public static void dropLinkTable(String table)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			try {
				ManageDatabase.dropTable(table);
			}
			catch (Exception e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in dropLinkTable: " + table, e);
			}
		}
	
	public static void truncateLinkTable(Volume volume) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			truncateLinkTable(volume.getLinkDbname());
		}
	
	public static void truncateLinkTable(String table)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			try {
				ManageDatabase.truncateTable(table);
			}
			catch (Exception e) {
				throw new fr.imag.clips.papillon.business.PapillonBusinessException ("Exception in truncateLinkTable: " + table, e);
			}
		}
	}

