//
//  Request.java
//  xcode_Papillon5.1.lexalp
//
//  Created by Francis Brunet-Manquat on 9/11/05.
//  Copyright 2005 __MyCompanyName__. All rights reserved.
//


package fr.imag.clips.papillon.business.dictionary;

import com.lutris.dods.builder.generator.query.QueryBuilder;
import com.lutris.dods.builder.generator.query.RDBColumn;
import com.lutris.dods.builder.generator.query.RDBTable;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.CurrentRequestContext;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.data.VolumeEntryDO;
import fr.imag.clips.papillon.data.VolumeEntryQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;


/**
        * A Request is a business object passed when querying dictionaries.
     */
    public class QueryRequest {
        
        //
        protected ArrayList volumes;
        protected ArrayList criteriaTree;   // AND(OR) tree or OR(AND) tree
        protected boolean isAndTree = true; // AND(OR) tree -> default
        protected String offset; 
        protected String limit; 
        protected String xsl;
        protected ArrayList targets = new ArrayList();
        
        //
        private final boolean DEBUG = false;
        
        //
        public QueryRequest(Volume volume) {
            criteriaTree = new ArrayList();
            volumes = new ArrayList();
            volumes.add(volume);
            limit = "0";
            offset = "0";
        }
        
        //
        public QueryRequest(Collection volumesCollection) {
            criteriaTree = new ArrayList();
            volumes = new ArrayList(volumesCollection);
        }
        
        //
        public Collection getVolumes() {
            return volumes;
        }
        
        //
        public ArrayList getCriteriaTree() {
            return criteriaTree;
        }
        
        //
        public void addCriteria(QueryCriteria criteria) {
            
            // Add to criteriaTree
            ArrayList orNode = new ArrayList();
            orNode.add(criteria);
            criteriaTree.add(orNode);
        }
        
        //
        public void addOrCriteriaList(ArrayList criteriaList) {
            
            // Add to criteriaTree
            ArrayList orNode = new ArrayList();
            for (int i = 0; i < criteriaList.size(); i++) {
                orNode.add((QueryCriteria)criteriaList.get(i));
            }
            criteriaTree.add(orNode);
        }

        //
        public void addAndCriteriaList(ArrayList criteriaList) {
            isAndTree = false;  // OR(AND)
            
            // Add to criteriaTree
            ArrayList andNode = new ArrayList();
            for (int i = 0; i < criteriaList.size(); i++) {
                andNode.add((QueryCriteria)criteriaList.get(i));
            }
            criteriaTree.add(andNode);
        }

        public void setOrTree() {
            isAndTree = false;  // OR(AND)
        }
        
        public String getOffset() {
            return offset;
        }
        
        public void setOffset(String newOffset) {
            offset = newOffset;
        }
        
        public String getLimit() {
            return limit;
        }
        
        public void setLimit(String newLimit) {
            limit = newLimit;
        }
        
        public String getXsl() {
            return xsl;
        }
        
        public void setXsl(String newXsl) {
            xsl = newXsl;
        }
        
        public Collection getTargets() {
            return targets;
        }
        
        public void setTargets(Collection targetsCollection) {
            targets = new ArrayList(targetsCollection);
        }


        public boolean isEmpty() {
            return (criteriaTree.size() == 0);
        }

        //=========================== Briques de base ===========================
        
        // find(QueryBuilder query, String volumeDbName)
        // - add to query new criteria
        // - find in volumeDbName
        /* For example :
        select * from idxlexalpfra where 
          (
           idxlexalpfra.entryId IN (  
                                      select idxlexalpfra.entryId from  idxlexalpfra 
                                      WHERE  idxlexalpfra.key = 'cdm-headword' 
                                      AND  idxlexalpfra.value like 'VA' 
                                      )   
           AND 
                (
                    idxlexalpfra.entryId IN (  
                                       select idxlexalpfra.entryId from  idxlexalpfra 
                                       WHERE  idxlexalpfra.key = 'cdm-contribution-status' 
                                       AND  idxlexalpfra.value = 'finished' 
                                       )
            
                 OR 
                    idxlexalpfra.entryId IN (  
                                       select idxlexalpfra.entryId from  idxlexalpfra 
                                       WHERE  idxlexalpfra.key = 'cdm-contribution-status' 
                                       AND  idxlexalpfra.value = 'not finished' 
                                       )
            )))
        */
		/*
		 
		 select distinct idxlexalpfra.entryId FROM idxlexalpfra WHERE 
		 (	
			(
				(
					idxlexalpfra.key = 'cdm-headword' 
					AND  idxlexalpfra.value like 'VA'
				)
			)   
			AND 
			(
				(
					idxlexalpfra.key = 'cdm-contribution-status' 
					AND  idxlexalpfra.value = 'finished' 
				)
				OR 
				(  
					idxlexalpfra.key = 'cdm-contribution-status' 
					AND  idxlexalpfra.value = 'not finished' 
				)
			)
		)
		 */
        private void find(QueryBuilder query, RDBTable table) throws PapillonBusinessException {
            try {               
                if (isAndTree) {    // AND(OR)
                    Iterator iterAnd = criteriaTree.iterator();
                    while (iterAnd.hasNext()) {
                        ArrayList orNode = (ArrayList)iterAnd.next();
                        query.addWhereOpenParen();
                        Iterator iterOr = orNode.iterator();
                        while (iterOr.hasNext()) {
							query.addWhereOpenParen();
                            QueryCriteria criteria = (QueryCriteria)iterOr.next();
                            for (int i = 0; i < criteria.size(); i++) {      
                                RDBColumn columnRDB = new RDBColumn( table, criteria.getColumn(i), false );
                                query.addWhere(columnRDB, criteria.getValue(i), criteria.getStrategie(i));
								PapillonLogger.writeDebugMsg("value: " + criteria.getValue(i) + " Strategy: " + criteria.getStrategie(i));
                            }
							query.addWhereCloseParen();
                            if ( iterOr.hasNext() ) { query.addWhereOr(); }
                        }
                        query.addWhereCloseParen();
                    }
                } else {    // OR(AND)
                    Iterator iterOr = criteriaTree.iterator();
                    while (iterOr.hasNext()) {
                        ArrayList andNode = (ArrayList)iterOr.next();
                        query.addWhereOpenParen();
                        Iterator iterAnd = andNode.iterator();
                        while (iterAnd.hasNext()) {
                            QueryCriteria criteria = (QueryCriteria)iterAnd.next();
                            for (int i = 0; i < criteria.size(); i++) {      
                                RDBColumn columnRDB = new RDBColumn( table, criteria.getColumn(i), false );
                                query.addWhere(columnRDB, criteria.getValue(i), criteria.getStrategie(i));
                            }
                        }
                        query.addWhereCloseParen();
                        query.addWhereOr();
                    }                    
                }
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in find() ", ex);
            }
        }
        
        // find(QueryBuilder query, String volumeDbName, String volumeIndexDbName) 
        // - add to query new criteria
        // - find in volumeDbName and its index
        /* For example :
         select *
         from  lexalpfra 
         WHERE  lexalpfra.ObjectId IN (select idxlexalpfra.entryId from idxlexalpfra where ...)
         */
        private void findLexie(QueryBuilder query, String volumeDbName, String volumeIndexDbName)  throws PapillonBusinessException {
            try {
 				mergeCriteriaSubtrees();
               RDBTable table = new RDBTable(volumeDbName);
                if ( (criteriaTree.size() != 0) && (volumeIndexDbName != null) ) {
                    // Search in index table
                    RDBTable tableIndex = new RDBTable(volumeIndexDbName);
                    RDBColumn entryIdRDB = new RDBColumn( tableIndex, "entryId", false );
                    RDBColumn[] tableIndexRDBList = new RDBColumn[1];
                    tableIndexRDBList[0] = entryIdRDB;
                    RDBColumn objectIdRDB = new RDBColumn( table, "ObjectId", false );
					//query.distinct();
						if (isAndTree) {    // AND(OR)
							Iterator iterAnd = criteriaTree.iterator();
							while (iterAnd.hasNext()) {
								QueryBuilder querySearch = new QueryBuilder(tableIndexRDBList);
								ArrayList orNode = (ArrayList)iterAnd.next();
								Iterator iterOr = orNode.iterator();
								while (iterOr.hasNext()) {
									QueryCriteria criteria = (QueryCriteria)iterOr.next();
									if (criteria.getFullClause() != null && criteria.getFullClause() != "") {
										querySearch.addWhereOpenParen();
										//PapillonLogger.writeDebugMsg("isAndTree criteria: " + criteria.getFullClause());
										querySearch.addWhere(criteria.getFullClause());
										querySearch.addWhereCloseParen();
										if ( iterOr.hasNext() ) { querySearch.addWhereOr(); }
									}
								}
								query.addWhereIn(objectIdRDB, querySearch);
							}
						} else {    // OR(AND)
							Iterator iterOr = criteriaTree.iterator();
							while (iterOr.hasNext()) {
								QueryBuilder querySearch = new QueryBuilder(tableIndexRDBList);
								ArrayList andNode = (ArrayList)iterOr.next();
								Iterator iterAnd = andNode.iterator();
								while (iterAnd.hasNext()) {
									QueryCriteria criteria = (QueryCriteria)iterAnd.next();
									if (criteria.getFullClause() != null && criteria.getFullClause() != "") {
										querySearch.addWhereOpenParen();
										//PapillonLogger.writeDebugMsg("isOrTree criteria: " + criteria.getFullClause());
										querySearch.addWhere(criteria.getFullClause());
										querySearch.addWhereCloseParen();
									}
								}
								querySearch.addWhereOr();
								query.addWhereIn(objectIdRDB, querySearch);
							}                    
						}
					}                    
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexie() ", ex);
            }
        }
        

		
		
/*        
        //
        private void findAxieFromLexie(QueryBuilder query, String volumeDbName, VolumeEntry ve) throws PapillonBusinessException {
            try {
                // QueryResult ... Volume Entry ????
                // recup entryId dans index
                // recup value de cdm-entry-id dans index
                // recup entryId dans indexAxie avec value de cdm-entry-id
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findAxieFromLexie() ", ex);
            }
        }
        
        //
        private void findLexieFromAxie(QueryBuilder query, String volumeDbName, VolumeEntry ve) throws PapillonBusinessException {
            try {
                
                //
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieFromAxie() ", ex);
            }
        }
        
*/        
            
        //=========================== Public Methods ===========================
        
         
        /**
         * Find lexies
         * @param user      add contraints to find lexies FIXME: not use actually 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
        public ArrayList findLexie(User user)  throws PapillonBusinessException {
            try {
                ArrayList result = new ArrayList();
				filterVolumes();
                for (Iterator iter = volumes.iterator(); iter.hasNext();) {
                    Volume volume = (Volume)iter.next();

                    //
                    VolumeEntryQuery veQuery = new VolumeEntryQuery(volume.getDbname(), CurrentDBTransaction.get());
					findLexie(veQuery.getQueryBuilder(), volume.getDbname(), volume.getIndexDbname());

                    // limit/offset and sort
                    if ((limit != null) && (offset != null) && ((!limit.equals("0")) || (!offset.equals("0")))) {
                        veQuery.getQueryBuilder().addEndClause(" LIMIT " + limit + " OFFSET " + offset);
                    }
                    veQuery.getQueryBuilder().addOrderByColumn("multilingual_sort('" + volume.getSourceLanguage() + "',headword)","");

                    // Debug
                    if (DEBUG) veQuery.getQueryBuilder().debug();

                    //
                    VolumeEntryDO[] DOarray = veQuery.getDOArray();
                    if (null != DOarray) {
						VolumeEntriesFactory.cutEntryCache();
                        for (int j=0; j < DOarray.length; j++) {
                            VolumeEntry tempEntry = new VolumeEntry(DictionariesFactory.getDictionaryByName(volume.getDictname()), volume, DOarray[j]);
							// Add the volume entry in the request context.
                            CurrentRequestContext.get().set(tempEntry.getEntryId(), tempEntry);
							EntryCache.putEntryInCache(tempEntry);
							QueryResult queryResult = new QueryResult(QueryResult.UNIQUE_RESULT, tempEntry);
                            result.add(queryResult);
                        }
                    }
                }
                return result;

            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexie() ", ex);
            }
        }
                
        /**
         * Find lexies and their translations
         * @param user      add contraints to find lexies FIXME: not use actually 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
        public Collection findLexieAndTranslation(User user)  throws PapillonBusinessException {
            try {
                Collection lexies = findLexie(user);
                // If no target languages, do not merge axies.
                return DictionariesFactory.expandResults(lexies, this.getTargets(), user, this.getTargets().size() > 0);
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieAndTranslation() ", ex);
            }
        }

		/**
         * Find lexies and their translations
         * @param user      add contraints to find lexies FIXME: not use actually 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
        public Collection findPreviousLexieAndTranslation(String volumeName, String headword, User user)  throws PapillonBusinessException {
            try {
				//PapillonLogger.writeDebugMsg("findPreviousLexieAndTranslation of " + headword + " in " + volumeName);
				ArrayList lexies = new ArrayList();
				VolumeEntry tempEntry = VolumeEntriesFactory.findPreviousEntryByHeadword(volumeName, headword);
				if (null != tempEntry) {
					VolumeEntriesFactory.cutEntryCache();
					// Add the volume entry in the request context.
					CurrentRequestContext.get().set(tempEntry.getEntryId(), tempEntry);
					EntryCache.putEntryInCache(tempEntry);
					QueryResult queryResult = new QueryResult(QueryResult.UNIQUE_RESULT, tempEntry);
					lexies.add(queryResult);
				}
				
                // If no target languages, do not merge axies.
                return DictionariesFactory.expandResults((Collection)lexies, this.getTargets(), user, this.getTargets().size() > 0);
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieAndTranslation() ", ex);
            }
        }

		/**
         * Find lexies and their translations
         * @param user      add contraints to find lexies FIXME: not use actually 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
        public Collection findNextLexieAndTranslation(String volumeName, String headword, User user)  throws PapillonBusinessException {
            try {
				//PapillonLogger.writeDebugMsg("findPreviousLexieAndTranslation of " + headword + " in " + volumeName);
				ArrayList lexies = new ArrayList();
				VolumeEntry tempEntry = VolumeEntriesFactory.findNextEntryByHeadword(volumeName, headword);
				if (null != tempEntry) {
					VolumeEntriesFactory.cutEntryCache();
					// Add the volume entry in the request context.
					CurrentRequestContext.get().set(tempEntry.getEntryId(), tempEntry);
					EntryCache.putEntryInCache(tempEntry);
					QueryResult queryResult = new QueryResult(QueryResult.UNIQUE_RESULT, tempEntry);
					lexies.add(queryResult);
				}
                // If no target languages, do not merge axies.
                return DictionariesFactory.expandResults((Collection)lexies, this.getTargets(), user, this.getTargets().size() > 0);
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieAndTranslation() ", ex);
            }
        }
		
        
        /**
         * Find all lexies in one volume
         * @param volumeName
         * @param user      add contraints to find lexies FIXME: not use currently 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
        // FIXME: create QueryRequestFactory !
        static public ArrayList findAllLexies(Volume volume, User user)  throws PapillonBusinessException {
            try {
                ArrayList result = new ArrayList();
                
                QueryRequest query = new QueryRequest(volume);
                //query.setTargets(targets);
                //query.setOffset(offset);
                
                //
                result = query.findLexie(user); 
                
                return result;
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieHistory() ", ex);
            }
        }
        
        
        /**
            * Find lexie history
         * @param handle
         * @param volume
         * @param user      add contraints to find lexies FIXME: not use currently 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
        // FIXME: create QueryRequestFactory !
        static public ArrayList findLexieHistory(String handle, Volume volume, User user)  throws PapillonBusinessException {
            try {
                ArrayList result = new ArrayList();
                
                QueryRequest query = new QueryRequest(volume);
                //query.setTargets(targets);
                //query.setOffset(offset);
                
                //
                QueryCriteria criteria = new QueryCriteria();
                criteria.add("entryid", QueryCriteria.EQUAL, handle);
                query.addCriteria(criteria);
                
                result = query.findLexie(user); 
                /*
                if (result.size() == 1) {
                    QueryResult qr = (QueryResult) result.get(0);
                    Collection classifiedFinishedContributionIdCollection = qr.getSourceEntry().getClassifiedFinishedContributionIdCollection();

                    //
                    while ( classifiedFinishedContributionIdCollection.size() != 0 ) {
                                             
                        //
                        for (Iterator iter = classifiedFinishedContributionIdCollection.iterator(); iter.hasNext();) {
                            String newEntryId = qr.getSourceEntry().getClassifiedFinishedContributionId();
                            
                        QueryRequest newQuery = new QueryRequest(volume);
                                                
                        QueryCriteria newCriteria = new QueryCriteria();
                        newCriteria.add("key", QueryCriteria.EQUAL, Volume.CDM_contributionId);  
                        newCriteria.add("value", QueryCriteria.EQUAL, newEntryId);
                        newQuery.addCriteria(newCriteria);
                        
                        result.addAll(newQuery.findLexie(user));
                        qr = (QueryResult) result.get(result.size()-1);
                    }
                } else {
                    throw new PapillonBusinessException("Exception in findLexieHistory() : none or several entries find");
                }
                */
                
                return result;
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieHistory() ", ex);
            }
        }
		
		public void filterVolumes() throws PapillonBusinessException {
			if (volumes.size()>1) {
			int i=0;
			while (i<volumes.size()) {
				boolean keepVolume = true;
				Volume volume = (Volume)volumes.get(i);
				Hashtable CDMelements = volume.getCdmElements();
				if (this.isAndTree) {
					Iterator iterAnd = criteriaTree.iterator();
					while (iterAnd.hasNext() && keepVolume) {
                        ArrayList orNode = (ArrayList)iterAnd.next();
						keepVolume	= keepVolume && filterOrCriteriaSubtree(CDMelements, orNode);
					}
				}
				else {
					keepVolume = false;
					Iterator iterOr = criteriaTree.iterator();
					while (iterOr.hasNext() && !keepVolume) {
                        ArrayList AndNode = (ArrayList)iterOr.next();
						if (filterOrCriteriaSubtree(CDMelements, AndNode)) {
							keepVolume = true;
						}
					}
			
				}
				//PapillonLogger.writeDebugMsg("filterVolume: " + volume.getName() + " kv: " + keepVolume);
				if (!keepVolume) {
					volumes.remove(i);
				}
				else {
					i++;
				}
			}
			}
		}
		
		protected boolean filterAndCriteriaSubtree(Hashtable CDMelements, ArrayList subtree) {
			boolean keepVolume = true;
			if (subtree.size() >0) {
				Iterator citer = subtree.iterator();
				while ( citer.hasNext() && keepVolume) {
					QueryCriteria criteria = (QueryCriteria)citer.next();
					if (criteria.getLang() != null) {
						Hashtable langElements = (Hashtable) CDMelements.get(criteria.getLang());
						if (langElements != null) {
							Vector element = (Vector) langElements.get(criteria.getKey());
							keepVolume = (element != null);	
						}
						else {
							keepVolume = false;
						}
					}
				}
			}	
			return keepVolume;
		}
		
		protected boolean filterOrCriteriaSubtree(Hashtable CDMelements, ArrayList subtree) {
			boolean keepVolume = false;
			if (subtree.size() >0) {
					Iterator citer = subtree.iterator();
					while ( citer.hasNext() && !keepVolume) {
						QueryCriteria criteria = (QueryCriteria)citer.next();
						//PapillonLogger.writeDebugMsg("filterOrCriteria: " + criteria.getKey() + " langue : " + criteria.getLang());
						if (criteria.getLang() != null) {
							Hashtable langElements = (Hashtable) CDMelements.get(criteria.getLang());
							if (langElements != null) {
								Vector element = (Vector) langElements.get(criteria.getKey());
								if (element != null) {
									keepVolume = true;
								}	
							}
						}
						else if (criteria.getLang() == null) {
							keepVolume = true;
						}
					}
				}
				//PapillonLogger.writeDebugMsg("filterOrCriteriaTree: " + keepVolume);
				return keepVolume;
			}  

		// following BUG311
		private void mergeCriteriaSubtrees()  throws PapillonBusinessException {
            try {
                if ( (criteriaTree.size() != 0)) {
					mergeSameCriteria();
					if (isAndTree) {    // AND(OR)
						int i=0;
						int treeSize = criteriaTree.size();
						while (i<treeSize) {
							ArrayList orNode = (ArrayList)criteriaTree.get(i);
							if (orNode.size()==1) {
								QueryCriteria criteria = (QueryCriteria)orNode.get(0);
								treeSize -= mergeSubCriterias(criteriaTree, "AND", orNode,criteria);
							}
							i++;
						}
					} else {    // OR(AND)
						int i=0;
						int treeSize = criteriaTree.size();
						while (i<treeSize) {
							ArrayList andNode = (ArrayList)criteriaTree.get(i);
							if (andNode.size()==1) {
								QueryCriteria criteria = (QueryCriteria)andNode.get(0);
								treeSize -= mergeSubCriterias(criteriaTree, "OR", andNode,criteria);
							}
							i++;
						}                    
					}
				}                    
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in mergeCriteriaSubtrees() ", ex);
            }
        }
		
		// following BUG311		
		private void mergeSameCriteria()  throws PapillonBusinessException {
            try {
                if ( (criteriaTree.size() != 0)) {
					if (isAndTree) {    // AND(OR)
						//PapillonLogger.writeDebugMsg("isAndTree : AND(OR)");
						Iterator iterAnd = criteriaTree.iterator();
						while (iterAnd.hasNext()) {
							ArrayList orNode = (ArrayList)iterAnd.next();
							int i = 0;
							int nodeSize = orNode.size();
							while (i<nodeSize-1) {
								QueryCriteria criteria = (QueryCriteria)orNode.get(i);
								nodeSize -= mergeCriterias(orNode,"OR", criteria);
								i++;
							}
						}
					} else {    // OR(AND)
						Iterator iterOr = criteriaTree.iterator();
						while (iterOr.hasNext()) {
							ArrayList andNode = (ArrayList)iterOr.next();
							int i = 0; 
							int nodeSize = andNode.size();
							while (i<nodeSize-1) {
								QueryCriteria criteria = (QueryCriteria)andNode.get(i);
								nodeSize -= mergeCriterias(andNode,"AND", criteria);
								i++;
							}
						}                    
					}
				}                    
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in mergeSameCriteria() ", ex);
            }
        }
		
		// following BUG311
		private static int mergeCriterias(ArrayList node, String type, QueryCriteria firstCriteria)
			throws PapillonBusinessException {
			int res = 0;
			try {
			int i=node.indexOf(firstCriteria)+1;
			int nodeSize = node.size();
			while (i<nodeSize) {
				QueryCriteria criteria = (QueryCriteria) node.get(i);
				if (criteria.getKey() != null && firstCriteria.getKey() != null
					&& criteria.getKey().equals(firstCriteria.getKey())
					&& ((criteria.getLang()==null && firstCriteria.getLang() ==null)				
						|| ( criteria.getLang() != null && firstCriteria.getLang() != null
							&& criteria.getLang().equals(firstCriteria.getLang()))
						)) {
					firstCriteria.appendClause(" "+type+" " + criteria.getClause());
					node.remove(i);
					nodeSize--;
					res++;
				}	
				i++;
			}
			} catch(Exception ex) {
				throw new PapillonBusinessException("Exception in mergeCriterias() ", ex);
			}
			return res;
		}
				
		// following BUG311
		private static int mergeSubCriterias(ArrayList node, String type, ArrayList subNode, QueryCriteria firstCriteria)
			throws PapillonBusinessException {
				int res = 0;
				try {
					//PapillonLogger.writeDebugMsg("mergeSubCriterias " + type);
			int i=node.indexOf(subNode)+1;
			int nodeSize = node.size();
			while (i<nodeSize) {
				subNode = (ArrayList) node.get(i);
				if (subNode.size()==1) {
					QueryCriteria criteria = (QueryCriteria)subNode.get(0);
					if (criteria.getKey() != null && firstCriteria.getKey() != null
						&& criteria.getKey().equals(firstCriteria.getKey())
						&& ((criteria.getLang()==null && firstCriteria.getLang() ==null)				
							|| ( criteria.getLang() != null && firstCriteria.getLang() != null
								&& criteria.getLang().equals(firstCriteria.getLang()))
						)) {
						firstCriteria.appendClause(" "+type+" " + criteria.getClause());
						node.remove(i);
						res++;
						nodeSize--;
					}	
				}
				i++;
			}
		} catch(Exception ex) {
			throw new PapillonBusinessException("Exception in mergeSubCriterias() ", ex);
		}
				return res;
		}
    }
    
