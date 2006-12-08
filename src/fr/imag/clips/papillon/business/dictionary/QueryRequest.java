//
//  Request.java
//  xcode_Papillon5.1.lexalp
//
//  Created by Francis Brunet-Manquat on 9/11/05.
//  Copyright 2005 __MyCompanyName__. All rights reserved.
//


package fr.imag.clips.papillon.business.dictionary;
    
    import fr.imag.clips.papillon.CurrentDBTransaction;
    import fr.imag.clips.papillon.data.*;
    import fr.imag.clips.papillon.business.user.User;
    import fr.imag.clips.papillon.business.dictionary.QueryResult;

    /* standards imports */
    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.Collection;
    import java.util.Vector;

    /* Query builder */
    import com.lutris.dods.builder.generator.query.*;

    /* Execption */
    import fr.imag.clips.papillon.business.PapillonBusinessException;
    import fr.imag.clips.papillon.business.PapillonLogger;
    
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
        protected ArrayList targets;
        
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
        private void find(QueryBuilder query, String volumeDbName) throws PapillonBusinessException {
            try {
                
                //
                if (isAndTree) {    // AND(OR)
                    Iterator iterAnd = criteriaTree.iterator();
                    while (iterAnd.hasNext()) {
                        ArrayList orNode = (ArrayList)iterAnd.next();
                        
                        //
                        query.addWhereOpenParen();
                        
                        //
                        Iterator iterOr = orNode.iterator();
                        while (iterOr.hasNext()) {
                            QueryCriteria criteria = (QueryCriteria)iterOr.next();
                            
                            // 
                            RDBTable table = new RDBTable(volumeDbName);
                            RDBColumn entryIdRDB = new RDBColumn( table, "entryId", false );
                            RDBColumn[] RDBList = new RDBColumn[1];
                            RDBList[0] = entryIdRDB;
                            QueryBuilder queryIn = new QueryBuilder(RDBList);
                            
                            //
                            for (int i = 0; i < criteria.size(); i++) {      
                                //
                                RDBColumn columnRDB = new RDBColumn( table, criteria.getColumn(i), false );
                                queryIn.addWhere(columnRDB, criteria.getValue(i), criteria.getStrategie(i));
                            }
                            
                            //
                            query.addWhereIn(entryIdRDB, queryIn);
                            if ( iterOr.hasNext() ) { query.addWhereOr(); }
                        }
                        
                        //
                        //if (limit != 0) query.addEndClause("LIMIT " + Integer.toString(limit));
                        //query.addEndClause("OFFSET 10");
                        
                        //
                        query.addWhereCloseParen();
                    }
                    
                } else {    // OR(AND)
                    Iterator iterOr = criteriaTree.iterator();
                    while (iterOr.hasNext()) {
                        ArrayList andNode = (ArrayList)iterOr.next();
                        
                        //
                        query.addWhereOpenParen();
                        
                        //
                        Iterator iterAnd = andNode.iterator();
                        while (iterAnd.hasNext()) {
                            QueryCriteria criteria = (QueryCriteria)iterAnd.next();
                            
                            // 
                            RDBTable table = new RDBTable(volumeDbName);
                            RDBColumn entryIdRDB = new RDBColumn( table, "entryId", false );
                            RDBColumn[] RDBList = new RDBColumn[1];
                            RDBList[0] = entryIdRDB;
                            QueryBuilder queryIn = new QueryBuilder(RDBList);
                            
                            //
                            for (int i = 0; i < criteria.size(); i++) {      
                                //
                                RDBColumn columnRDB = new RDBColumn( table, criteria.getColumn(i), false );
                                queryIn.addWhere(columnRDB, criteria.getValue(i), criteria.getStrategie(i));
                            }
                            
                            //
                            query.addWhereIn(entryIdRDB, queryIn);
                        }
                        
                        //
                        //query.addEndClause("LIMIT 10 OFFSET 10");
                        
                        //
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
                //
                RDBTable table = new RDBTable(volumeDbName);
                
                //
                if ( (criteriaTree.size() != 0) && (volumeIndexDbName != null) ) {
                    
                    // Search in index table
                    RDBTable tableIndex = new RDBTable(volumeIndexDbName);
                    RDBColumn entryIdRDB = new RDBColumn( tableIndex, "entryId", false );
                    RDBColumn[] tableIndexRDBList = new RDBColumn[1];
                    tableIndexRDBList[0] = entryIdRDB;
                    QueryBuilder querySearch = new QueryBuilder(tableIndexRDBList);
                    querySearch.distinct();
                    
                    //
                    find(querySearch, volumeIndexDbName);
                    
                    //
                    RDBColumn objectIdRDB = new RDBColumn( table, "ObjectId", false );
                    query.addWhereIn(objectIdRDB, querySearch);
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
                
                //
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
                    
                    // debug
                    //veQuery.getQueryBuilder().debug();
                    
                    //
                    VolumeEntryDO[] DOarray = veQuery.getDOArray();
                    if (null != DOarray) {
                        for (int j=0; j < DOarray.length; j++) {
                            VolumeEntry tempEntry = new VolumeEntry(DictionariesFactory.getDictionaryByName(volume.getDictname()), volume, DOarray[j]);
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
         * Find lexies for edition web page. Find lexies with additional constraints :
         *  - Supress contribution linked to another contribution (by CDM_previousClassifiedFinishedContribution)
         *
         * @param user      add contraints to find lexies FIXME: not use actually 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
/*
        public ArrayList findLexieForEdition(User user)  throws PapillonBusinessException {
            try {
                ArrayList result = new ArrayList();
                
                //
                for (int i=0; i< volumeNames.length; i++) {
                    
                    // init
                    Volume volume = VolumesFactory.getVolumeByName((String)volumeNames[i]);
                    VolumeEntryQuery veQuery = new VolumeEntryQuery(volume.getDbname(), CurrentDBTransaction.get());
                    RDBTable table = new RDBTable(volume.getDbname());
                    RDBColumn objectidRDB = new RDBColumn( table, "objectid", false );
                    RDBTable tableIndex = new RDBTable(volume.getIndexDbname());
                    RDBColumn keyRDB = new RDBColumn( tableIndex, "key", false );
                    RDBColumn valueRDB = new RDBColumn( tableIndex, "value", false );
                    RDBColumn entryidRDB = new RDBColumn( tableIndex, "entryid", false );
                    
                    // Add constraint to veQuery
                    findLexie(veQuery.getQueryBuilder(), volume.getDbname(), volume.getIndexDbname());
                    
                    // Search CDM_previousClassifiedFinishedContribution value 
                    RDBColumn[] valueRDBList = new RDBColumn[1];
                    valueRDBList[0] = valueRDB;
                    QueryBuilder qbValue = new QueryBuilder(valueRDBList);
                    qbValue.addWhere(keyRDB, Volume.CDM_previousClassifiedFinishedContribution, QueryBuilder.EQUAL);
                    
                    // Search CDM_contributionId
                    RDBColumn[] contribRDBList = new RDBColumn[1];
                    contribRDBList[0] = entryidRDB;
                    QueryBuilder qbContrib = new QueryBuilder(contribRDBList);
                    qbContrib.addWhere(keyRDB, Volume.CDM_contributionId, QueryBuilder.EQUAL);
                    qbContrib.addWhereIn(valueRDB, qbValue);
                    
                    // Constrain veQuery with previousClassifiedFinishedContribution Id
                    veQuery.getQueryBuilder().addWhereNotIn(objectidRDB, qbContrib);
                    
                    // sort
                    veQuery.getQueryBuilder().addOrderByColumn("multilingual_sort('" + volume.getSourceLanguage() + "',headword)","");
                    
                    // debug
                    //veQuery.getQueryBuilder().debug();
                    
                    //
                    VolumeEntryDO[] DOarray = veQuery.getDOArray();
                    if (null != DOarray) {
                        for (int j=0; j < DOarray.length; j++) {
                            VolumeEntry tempEntry = new VolumeEntry(DictionariesFactory.getDictionaryByName(volume.getDictname()), volume, DOarray[j]);
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
        
    */
        
        /**
            * Find lexies and their translations
         * @param user      add contraints to find lexies FIXME: not use actually 
         *
         * @return QueryResult arraylist
         * @exception PapillonBusinessException if database error
         */
        public ArrayList findLexieAndTranslation(User user)  throws PapillonBusinessException {
            try {
                ArrayList result = new ArrayList();
                
                //
                for (Iterator iter = volumes.iterator(); iter.hasNext();) {
                    Volume volume = (Volume)iter.next();
                    
                    // Create query
                    VolumeEntryQuery veQuery = new VolumeEntryQuery(volume.getDbname(), CurrentDBTransaction.get());
                    findLexie(veQuery.getQueryBuilder(), volume.getDbname(), volume.getIndexDbname());
                    
                    // limit/offset
                    if ( (limit != null) && (offset != null) 
                         && ((!limit.equals("0")) || (!offset.equals("0")))) {
                        veQuery.getQueryBuilder().addEndClause(" LIMIT " + limit + " OFFSET " + offset);
                    }
                    
                    // Order by
                    veQuery.getQueryBuilder().addOrderByColumn("multilingual_sort('" + volume.getSourceLanguage() + "',headword)","");
                    
                    // debug
                    //veQuery.getQueryBuilder().debug();
                    
                    //
                    VolumeEntryDO[] DOarray = veQuery.getDOArray();
                    if (null != DOarray) {
                        for (int j=0; j < DOarray.length; j++) {
                            
                            //
                            VolumeEntry tempEntry = new VolumeEntry(DictionariesFactory.getDictionaryByName(volume.getDictname()), volume, DOarray[j]);
                            
                            // FIXME : replace expandResult by QueryRequest MethodS !
                            result.addAll(DictionariesFactory.expandResult(tempEntry, targets, user));
                            //QueryResult queryResult = new QueryResult(QueryResult.AXIE_COLLECTION_RESULT, tempEntry, axie, transEntries);
                            //result.add(queryResult);  
                        }
                    } 
                }
                return result;
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieAndTranslation() ", ex);
            }
        }
        
        
        /**
         * Find all lexies in one volume
         * @param volumeName
         * @param user      add contraints to find lexies FIXME: not use actually 
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
         * @param volumeName
         * @param user      add contraints to find lexies FIXME: not use actually 
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
                
                if (result.size() == 1) {
                    QueryResult qr = (QueryResult) result.get(0);
                    
                    //
                    while (     (!qr.getSourceEntry().getClassifiedFinishedContributionId().equals("")) 
                                && (qr.getSourceEntry().getClassifiedFinishedContributionId() != null) ) {
                        String newEntryId = qr.getSourceEntry().getClassifiedFinishedContributionId();
                        //String newEntryId = qr.getSourceEntry().getClassifiedNotFinishedContributionId();
                        
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
                
                
                return result;
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in findLexieHistory() ", ex);
            }
        }
        
    }
    