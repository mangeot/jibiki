
/*-----------------------------------------------------------------------------
 * Enhydra Java	Application	Server
 * Copyright 1997-2000 Lutris Technologies,	Inc.
 * All rights reserved.
 *
 * Redistribution and use in source	and	binary forms, with or without
 * modification, are permitted provided	that the following conditions
 * are met:
 * 1. Redistributions of source	code must retain the above copyright
 *	  notice, this list	of conditions and the following	disclaimer.
 * 2. Redistributions in binary	form must reproduce	the	above copyright
 *	  notice, this list	of conditions and the following	disclaimer in
 *	  the documentation	and/or other materials provided	with the distribution.
 * 3. All advertising materials	mentioning features	or use of this software
 *	  must display the following acknowledgement:
 *		This product includes Enhydra software developed by	Lutris
 *		Technologies, Inc. and its contributors.
 * 4. Neither the name of Lutris Technologies nor the names	of its contributors
 *	  may be used to endorse or	promote	products derived from this software
 *	  without specific prior written permission.
 *
 * THIS	SOFTWARE IS PROVIDED BY	LUTRIS TECHNOLOGIES AND	CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL LUTRIS TECHNOLOGIES OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,	SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;	OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED	AND ON ANY THEORY OF LIABILITY,	WHETHER	IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR	OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF	THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *-----------------------------------------------------------------------------
 * fr.imag.clips.papillon.data/DictionaryQuery.java
 *-----------------------------------------------------------------------------
 */

package	fr.imag.clips.papillon.data;

import org.enhydra.dods.DODS;
import com.lutris.dods.builder.generator.query.*;
import com.lutris.appserver.server.sql.*;
//import org.enhydra.dods.cache.LRUCache;
import org.enhydra.dods.cache.DataStructCache;
import org.enhydra.dods.cache.QueryCache;
import org.enhydra.dods.cache.QueryCacheItem;
import org.enhydra.dods.cache.QueryResult;
import org.enhydra.dods.cache.DataStructShell;
import org.enhydra.dods.cache.DOShell;
import org.enhydra.dods.cache.Condition;
import org.enhydra.dods.statistics.Statistics;
import org.enhydra.dods.cache.CacheConstants;
import org.enhydra.dods.statistics.*;
import com.lutris.logging.LogChannel;
import com.lutris.logging.Logger;
import com.lutris.appserver.server.sql.CachedDBTransaction;

//import org.enhydra.dods.util.LRUMap;
import java.sql.*;
import java.util.*;
import java.math.*;
import java.util.Date;	// when	I say Date,	I don't	mean java.sql.Date

// WebDocWf	extension for DODS row instance	based security
// The following line has been added
import org.webdocwf.dods.access.*;
// end of WebDocWf extension for DODS row instance based security

/**
 * DictionaryQuery	is used	to query the dictionaries table in the database.<BR>
 * It returns objects of type DictionaryDO.
 * <P>
 * General usage:
 * <P>
 *	   In DODS:
 *		  Create a Data	Object named "Dog",
 *		  and create an	Attribute named	"Name",
 *		  and set that Attribute to	"Can be	queried."
 *		  DODS will	then generate the method DogQuery.setQueryName().
 * <P>
 *	   In your Business	Layer, prepare the query:<BR>
 * <P><PRE>
 *			   DogQuery	dq = new DogQuery();
 *			   dq.setQueryName("Rex")
 *			   if (	Rex	is a reserved name )
 *				   dq.requireUniqueInstance();
 * </PRE>
 *	   Then, get the query results one of two ways:
 * <P>
 *		   #1:<PRE>
 *			   String names	= "";
 *			   DogDO[] dogs	= dq.getDOArray();
 *			   for ( int i = 0;	i < dogs.length;	i++	) {
 *				   names +=	dogs[i].getName() +	" ";
 *			   }
 * </PRE>
 *		or #2:<PRE>
 *			   String names	= "";
 *			   DogDO dog;
 *			   while ( null	!= ( dog = dq.getNextDO() )	) {
 *				   names +=	dog.getName() +	" ";
 *			   }
 * </PRE>
 * <P>
 *	   Note:   If <CODE>requireUniqueInstance()</CODE> was called,
 *			   then	<CODE>getDOArray()</CODE> or <CODE>getNextDO()</CODE>
 *			   will	throw an exception if more than	one	"Rex" was found.
 * <P>
 *	   Note:   Results of the query	will come from the Data	Object cache if:
 *			   -  The cache	is available.
 *			   -  Matches were found in	the	cache.
 *			   -  No other tables (Data	Objects	of other types)	were involved
 *				  in the query.
 *				  This can happen if you extend	the	<CODE>DogQuery</CODE> class
 *				  and you make calls to	the	<CODE>QueryBuilder</CODE> object
 *				  to add SQL involving other tables.
 *			   If any of these conditions is not true,
 *			   then	any	results	from the query will	come from the database.
 * <P>
 *	   To reuse	the	query object, call:
 * <P><PRE>
 *			   dq.reset();
 * </PRE>
 * @author NN
 * @version	$Revision: 1.23 $
 */
public class DictionaryQuery implements Query {

	private	QueryBuilder builder;

	/**
	 * logical name	of the database	for	which DictionaryQuery object has been created
	 */
	private	String logicalDatabase;

	private	ResultSet resultSet	= null;
	private	boolean	uniqueInstance	= false;
	private	boolean	loadData	= false;
	private	DictionaryDO[]	DOs	= null;
	private	int	arrayIndex = -1;
	private	boolean	needToRun =	true;
// 12.04.2004 tj
//	private	LRUMap cacheHits	= null;
  private	Vector cacheHits	= null;
	private	boolean	isQueryByOId = false;
	private	boolean	hasNonOidCond	= false;
	private	boolean	hitDb =	false;
	private	boolean	userHitDb =	false;
	private	int	maxDBrows =	0;
	private boolean orderRelevant = true; // true if order of query results is relavant, otherwise false
	private	QueryCacheItem queryItem = null;
	private	String currentHandle = null;
	private HashMap refs = new HashMap();
        private int iCurrentFetchSize = -1;
        private int iCurrentQueryTimeout = 0;
        DBTransaction transaction = null;

	/**
	 * Public constructor.
         *

     * @deprecated Use DictionaryQuery(DBTransaction) instead.
	 */
	public DictionaryQuery() {

		builder	= new QueryBuilder(	"dictionaries", DictionaryDO.columnsNameString );

		String dbName =	DictionaryDO.get_logicalDBName();
		try	{
			String vendor =	DODS.getDatabaseManager().logicalDatabaseType(dbName);
			if (vendor != null)	{
				builder.setDatabaseVendor(vendor);
				logicalDatabase	= dbName;
			} else {
				builder.setDatabaseVendor();
				logicalDatabase	=  DODS.getDatabaseManager().getDefaultDB();
			}
		} catch	(Exception e) {
			builder.setDatabaseVendor();
			logicalDatabase	=  DODS.getDatabaseManager().getDefaultDB();
		}
		builder.setUserStringAppendWildcard( false );
		builder.setUserStringTrim( false );
		reset();
	}

	/**
	 * Public constructor.
         *
	 * @param dbTrans current database transaction
	 */
	public DictionaryQuery(DBTransaction dbTrans) {

		builder	= new QueryBuilder(	"dictionaries", DictionaryDO.columnsNameString );

		String dbName = null;
		if(dbTrans!=null)
		    dbName = dbTrans.getDatabaseName();
		else
		    dbName = DictionaryDO.get_logicalDBName();
		try	{
		    transaction = dbTrans;
			String vendor =	DODS.getDatabaseManager().logicalDatabaseType(dbName);
			if (vendor != null)	{
				builder.setDatabaseVendor(vendor);
				logicalDatabase	= dbName;
			} else {
				builder.setDatabaseVendor();
				logicalDatabase	=  DODS.getDatabaseManager().getDefaultDB();
			}
		} catch	(Exception e) {
			builder.setDatabaseVendor();
			logicalDatabase	=  DODS.getDatabaseManager().getDefaultDB();
		}
		builder.setUserStringAppendWildcard( false );
		builder.setUserStringTrim( false );
		reset();
	}



	/**
	 * Return logical name of the database that	DictionaryQuery object	uses
	 *
	 * @return param logical database name
	 *
	 */
	public String getLogicalDatabase() {
		return logicalDatabase;
	}

	/**
	 * Change logical database to another logical database (which name is dbName)
	 *
	 * @param dbName the logical name of the database
	 * @exception SQLException
	 * @exception DatabaseManagerException
	 */
	public void	setLogicalDatabase(String dbName) throws SQLException, DatabaseManagerException	{
		String vendor =	DODS.getDatabaseManager().logicalDatabaseType(dbName);
		if (vendor != null)	{
			builder.setDatabaseVendor(vendor);
			logicalDatabase	= dbName;
		} else {
			builder.setDatabaseVendor();
			logicalDatabase	=  DODS.getDatabaseManager().getDefaultDB();
		}
		reset();
	}



	//	WebDocWf extension for unique query	results	without	SQL	DISTINCT
	//	The	following lines	has	been added:
	private	boolean	unique = false;

	/**
	 * Set the unique flag of the query
	 *
	 * @param newUnique	The	unique flag	for	the	query
	 *
	 * WebDocWf	extension
	 *
	 */
	public void	setUnique(boolean newUnique) { unique =	newUnique; }

	/**
	 * Get the unique flag of the query
	 *
	 * @return The unique flag of the query
	 *
	 * WebDocWf	extension
	 *
	 */
	public boolean getUnique() { return	unique;	}

	//	WebDocWf extension for skipping	the	n first	rows of	the	result
	//	The	following lines	has	been added:
	private	int	readSkip = 0;

	/**
	 * Set the readSkip	number of the query
	 *
	 * @param newReadSkip The number of	results	to skip.
	 *
	 * WebDocWf	extension
	 *
	 */
	public void	setReadSkip(int	newReadSkip) {
	  readSkip = newReadSkip;
	}

	/**
	 * Get the readSkip	number of the query
	 *
	 * @return The number of rows which	are	skipped
	 *
	 * WebDocWf	extension
	 *
	 */
	public int getReadSkip() { return readSkip;	}

	// WebDocWf	extension for select rowcount limit
	// The following lines has been	added:
	private	int	databaseLimit =	0;

	/**
	 * Set the database	limit of the query
	 *
	 * @param newLimit The limit for the query
	 *
	 * WebDocWf	extension
	 *
	 */
	public void	setDatabaseLimit(int newLimit) {
	  databaseLimit	= newLimit;
	}

	/**
	 * Get the database	limit of the query
	 *
	 * @return The database	limit of the query
	 *
	 * WebDocWf	extension
	 *
	 */
	public int getDatabaseLimit() {	return databaseLimit; }

	private	boolean	databaseLimitExceeded =	false;

	/**
	 * Get the database	limit exceeded flag	of the query.
	 *
	 * @return The database	limit exceeded flag	of the query
	 *	 True if there would have been more	rows than the limit, otherwise false.
	 *
	 * WebDocWf	extension
	 */
	public boolean getDatabaseLimitExceeded() {	return databaseLimitExceeded; }
	// end of WebDocWf extension for select	rowcount limit

	/**
	 * Set that	all	queries	go to database,	not	to cache.
	 */
	public void	hitDatabase() {	userHitDb =	true; }

	// WebDocWf	extension for extended wildcard	support
	// The following rows have been	added:

	/**
	 * Set user	string wildcard.
	 *
	 * @param newUserStringWildcard	New	user string	wildcard.
	 *
	 * WebDocWf	extension
	 */
	public void	setUserStringWildcard(String newUserStringWildcard)	{
		builder.setUserStringWildcard( newUserStringWildcard );
	}

	/**
	 * Set user	string single wildcard.
	 *
	 * @param newUserStringSingleWildcard New user string single wildcard.
	 *
	 * WebDocWf	extension
	 */
	public void	setUserStringSingleWildcard(String newUserStringSingleWildcard)	{
		builder.setUserStringSingleWildcard( newUserStringSingleWildcard );
	}

	/**
	 * Set user	string single wildcard escape.
	 *
	 * @param newUserStringSingleWildcardEscape	New	user string	single wildcard	escape.
	 *
	 * WebDocWf	extension
	 */
	public void	setUserStringSingleWildcardEscape(String newUserStringSingleWildcardEscape)	{
		builder.setUserStringSingleWildcardEscape( newUserStringSingleWildcardEscape );
	}

	/**
	 * Set user	string wildcard	escape.
	 *
	 * @param newUserStringWildcardEscape New user string wildcard escape.
	 *
	 * WebDocWf	extension
	 */
	public void	setUserStringWildcardEscape(String newUserStringWildcardEscape)	{
		builder.setUserStringWildcardEscape( newUserStringWildcardEscape );
	}

	/**
	 * Set user	string append wildcard.
	 *
	 * @param userStringAppendWildcard New user	string append wildcard.
	 *
	 * WebDocWf	extension
	 */
	public void	setUserStringAppendWildcard(boolean	userStringAppendWildcard ) {
		builder.setUserStringAppendWildcard( userStringAppendWildcard );
	}

	 /**
	 * Set user	string trim.
	 *
	 * @param userStringTrim New user string trim.
	 *
	 * WebDocWf	extension
	 */
	public void	setUserStringTrim(boolean userStringTrim ) {
		builder.setUserStringTrim( userStringTrim );
	}

	/**
	 * Get user	string wildcard.
	 *
	 * @return User	string wildcard.
	 *
	 * WebDocWf	extension
	 */
	public String getUserStringWildcard() {
		return builder.getUserStringWildcard();
	}

	/**
	 * Get user	string single wildcard.
	 *
	 * @return User	string single wildcard.
	 *
	 * WebDocWf	extension
	 */
	public String getUserStringSingleWildcard()	{
		return builder.getUserStringSingleWildcard();
	}

	/**
	 * Get user	string single wildcard escape.
	 *
	 * @return User	string single wildcard escape.
	 *
	 * WebDocWf	extension
	 */
	public String getUserStringSingleWildcardEscape() {
		return builder.getUserStringSingleWildcardEscape();
	}

	/**
	 * Get user	string wildcard	escape.
	 *
	 * @return User	string wildcard	escape.
	 *
	 * WebDocWf	extension
	 */
	public String getUserStringWildcardEscape()	{
		return builder.getUserStringWildcardEscape();
	}

	/**
	 * Get user	string append wildcard.
	 *
	 * @return User	string append wildcard.
	 *
	 * WebDocWf	extension
	 */
	public boolean getUserStringAppendWildcard() {
		return builder.getUserStringAppendWildcard();
	}

	/**
	 * Get user	string trim.
	 *
	 * @return User	string trim.
	 *
	 * WebDocWf	extension
	 */
	public boolean getUserStringTrim() {
		return builder.getUserStringTrim();
	}
	// end of WebDocWf extension for extended wildcard support

	/**
	 * Perform the query on	the	database, and prepare the array of	returned
	 * DO	objects.
	 *
	 * @param DOs Vector of result oids which will be switched with the whole DOs
	 * (from the database).
	 * @exception DataObjectException If a database	access error occurs.
	 * @exception NonUniqueQueryException If too many rows were	found.
	 */
	private	void getQueryByOIds(Vector DOs)
	throws DataObjectException {
		if (DOs.size() == 0)
			return;
		DictionaryDO DO = null;
		DOShell	shell =	null;
		DictionaryQuery tmpQuery = null;
		Date startQueryTime	= new Date();
		long queryTime = 0;
		for	(int i=0; i<DOs.size(); i++)	{
			shell =	(DOShell)DOs.elementAt(i);
			tmpQuery = new DictionaryQuery(transaction);
			try {
			 tmpQuery.setQueryHandle( shell.handle );
             tmpQuery.requireUniqueInstance();

             DO = tmpQuery.getNextDO();
             if ( null == DO )
                    throw new DataObjectException("DictionaryDO DO not found for id=" + shell.handle );
            } catch ( Exception e ) {
               throw new DataObjectException( "Duplicate ObjectId" );
            }
            shell.dataObject = DO;
		}
		Date stopQueryTime = new Date();
		queryTime =	stopQueryTime.getTime()	- startQueryTime.getTime();
		DictionaryDO.statistics.updateQueryByOIdAverageTime((new Long(queryTime)).intValue(),DOs.size());
	}



	/**
	 * Perform the query on	the	database, and prepare the
	 * array of	returned DO	objects.
	 *
	 * @exception DataObjectException If a database	access error occurs.
	 * @exception NonUniqueQueryException If too many rows were	found.
	 */
	private	void runQuery()
	throws DataObjectException,	NonUniqueQueryException	{
	    needToRun =	false;
	    arrayIndex = -1;
	    DBQuery	dbQuery	= null;
	    Date startQueryTime	= new Date();
	    long queryTime = 0;
	    boolean	readDOs	= false;
	    boolean canUseQueryCache = true;
	    CacheStatistics stat = null;
	    boolean resultsFromQCache = false;
	    QueryCacheItem queryCachedItem = null;

	    if(builder.isUnionTableJoin())throw new DataObjectException( "Could not use �UNION [ALL]� statement in query witch retrieve data object." );

	    if ((transaction!=null) &&
		(transaction instanceof com.lutris.appserver.server.sql.CachedDBTransaction)) {
		if(((com.lutris.appserver.server.sql.CachedDBTransaction)transaction).getAutoWrite()) try {
		    transaction.write();
		} catch (SQLException sqle) {
		    sqle.printStackTrace();
		    throw new DataObjectException("Couldn't write transaction: "+sqle);
		}
		((com.lutris.appserver.server.sql.CachedDBTransaction)transaction).dontAggregateDOModifications();
	    }

		try	{
			QueryResult	results	= null;
			DOShell	shell =	null;
			if (isQueryByOId &&	!hasNonOidCond) {	// query by	OId
				builder.setCurrentFetchSize(1);
				results	= new QueryResult();
				if (currentHandle != null) {
        		 	if(transaction!=null && _tr_(transaction).getTransactionCache()!=null && !loadData) {
        			     DictionaryDO DO= (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(currentHandle);
        			     if(DO!=null){
        			        shell = new DOShell(DO);
        					results.DOs.add(shell);
        					resultsFromQCache = true;
        				 }
// tj 12.04.2004 put under comment next 2 lines
//        				 else
//        				    resultsFromQCache = false;
        			}
        			if(!resultsFromQCache) {  //	DO isn't found in the transaction cache
        			    DictionaryDataStruct DS = (DictionaryDataStruct)DictionaryDO.cache.getDataStructByHandle(currentHandle);
        			    if (DS != null && !(DS.isEmpty && loadData))	{ // DO	is found in	the	cache
        				  DictionaryDO DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
        				  shell =	new	DOShell(DO);
        				  results.DOs.add(shell);
        				  resultsFromQCache = true;
        				 }
// tj 12.04.2004 put under comment next 4 lines
//        				 else{ //	DO isn't found in the cache
//        				  	 if (DictionaryDO.cache.isFull())
//        						 resultsFromQCache =	false;
//        				 }
        			}
				}//currentHandle != null
			}
			else { //	other queries
                if (	DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)
                                          &&(!hitDb) && (maxDBrows == 0) && (databaseLimit == 0)
                                          && (readSkip == 0) && !builder.isMultiTableJoin() ) {
                      resultsFromQCache = true;
                }
                else {
                 if (DictionaryDO.cache.getLevelOfCaching()	== CacheConstants.QUERY_CACHING) {
                    if (builder.isMultiTableJoin()) { // statistics about multi join query
                      stat = null;
       				        stat = DictionaryDO.statistics.getCacheStatistics(CacheConstants.MULTI_JOIN_QUERY_CACHE);
       				        if (stat!= null){
       				          stat.incrementCacheAccessNum(1);
       				        }
       				      }
       				      else {
	                    if (hitDb) { // statistics about complex query
	       				        stat = null;
	       				        stat = DictionaryDO.statistics.getCacheStatistics(CacheConstants.COMPLEX_QUERY_CACHE);
	       				        if (stat!= null){
	       				         stat.incrementCacheAccessNum(1);
	       				        }
	       				      }else{ // statistics about simple query
	       				        stat = null;
	       				        stat = DictionaryDO.statistics.getCacheStatistics(CacheConstants.SIMPLE_QUERY_CACHE);
	       				        if (stat!= null){
	       				          stat.incrementCacheAccessNum(1);
	       				        }
	       			       }
	       			     }
                 }
                 if(transaction != null)
                    canUseQueryCache = !transaction.preventCacheQueries();
       			  if ((DictionaryDO.cache.getLevelOfCaching()	== CacheConstants.QUERY_CACHING) && canUseQueryCache) {
       					String queryID = builder.getSQLwithParms(); //unique representation of	query
       					int resNum = 0;
       					int evaluateNo = 0;
           			if (builder.isMultiTableJoin()) {
           			  queryCachedItem = ((QueryCache)DictionaryDO.cache).getMultiJoinQueryCacheItem(logicalDatabase, queryID);
           			}
           			else{
           			   if (hitDb)
           			      queryCachedItem = ((QueryCache)DictionaryDO.cache).getComplexQueryCacheItem(logicalDatabase, queryID);
           			   else
           			      queryCachedItem = ((QueryCache)DictionaryDO.cache).getSimpleQueryCacheItem(logicalDatabase, queryID);
           			}
           				queryItem.setQueryId(queryID);  // queryItem defined as private template attribute
           		  if (queryCachedItem == null) { // query	doesn't	exist
// tj 03.09.2004        					   if ((!builder.isMultiTableJoin()) || DictionaryDO.isAllReadOnly())
        					   if (builder.isMultiTableJoin()){
        					     ((QueryCache)DictionaryDO.cache).addMultiJoinQuery(queryItem); // register multi join query
        					   }
        					   else {
        			   		   if (hitDb)
        					         ((QueryCache)DictionaryDO.cache).addComplexQuery(queryItem); // register complex query
        					      else
        						      ((QueryCache)DictionaryDO.cache).addSimpleQuery(queryItem); //	register simple	query
           			   	}
           				}
           				else{ //	query found
           				   if ( !(isOrderRelevant() && queryCachedItem.isModifiedQuery()) ) {
    				           if (builder.isMultiTableJoin()){ // statistics about multi join cache
    				             stat = null;
           				       stat = DictionaryDO.statistics.getCacheStatistics(CacheConstants.MULTI_JOIN_QUERY_CACHE);
           				       if (stat!= null){
           				           stat.incrementCacheHitsNum(1);
           				       }
    				           }
    				           else {
    				            if (hitDb) { // statistics about complex cache
        					         stat = null;
           				         stat = DictionaryDO.statistics.getCacheStatistics(CacheConstants.COMPLEX_QUERY_CACHE);
           				         if (stat!= null){
           				             stat.incrementCacheHitsNum(1);
           				         }
        				   	    }else{ // statistics about simple cache
        					         stat = null;
           				         stat = DictionaryDO.statistics.getCacheStatistics(CacheConstants.SIMPLE_QUERY_CACHE);
           				         if (stat!= null){
           				            stat.incrementCacheHitsNum(1);
           				         }
        				         }
        				       }

                              int limitOfRes;
                              if (databaseLimit == 0)
                                 limitOfRes = 0;
                              else
                                 limitOfRes = readSkip+databaseLimit+1;
                              if (! unique) {
                                 if (builder.isMultiTableJoin()) {
                                   results = ((QueryCache)DictionaryDO.cache).getMultiJoinQueryResults(logicalDatabase, queryID, limitOfRes, maxDBrows);
                                 }
                                 else {
	                                 if (hitDb)
	                                   results = ((QueryCache)DictionaryDO.cache).getComplexQueryResults(logicalDatabase, queryID, limitOfRes, maxDBrows);
	                                 else
	                                   results = ((QueryCache)DictionaryDO.cache).getSimpleQueryResults(logicalDatabase, queryID, limitOfRes, maxDBrows);
	                               }
                              }else{ // (! unique)
                                 if (builder.isMultiTableJoin()) {
                                   results = ((QueryCache)DictionaryDO.cache).getMultiJoinQueryResults(logicalDatabase, queryID, limitOfRes, maxDBrows, true);
                                 }
                                 else {
	                                 if (hitDb)
	                                    results = ((QueryCache)DictionaryDO.cache).getComplexQueryResults(logicalDatabase, queryID, limitOfRes, maxDBrows, true);
	                                 else
	                                    results = ((QueryCache)DictionaryDO.cache).getSimpleQueryResults(logicalDatabase, queryID, limitOfRes, maxDBrows, true);
	                               }
                              } // (! unique)
                              if (results != null) {
                                 resNum = results.DOs.size();
// tj 01.02.2004 remove skipped
                              	 if (readSkip > 0) {
                                     if (results.DOs.size() > readSkip) {
                                        for (int i = 0; i < readSkip; i++) {
                                           results.DOs.remove(0);
                                        }
                                      }
                                      else {
                                         results.DOs.clear();
                                      }
                                 }

 //sinisa 06.08.2003.
                                 results = getCachedResults(results);
                                 if (databaseLimit != 0) { // databaseLimitExceeded begin
                                     if (resNum == readSkip+databaseLimit+1) {
                                         resNum--;
                                         databaseLimitExceeded = true;
                                         results.DOs.remove(databaseLimit);
                                     }else{
                                         if ( (resNum == readSkip+databaseLimit) && (!queryCachedItem.isCompleteResult()) )
                                              databaseLimitExceeded = true;
                                     }
                                 }  // databaseLimitExceeded end
                                 if ( (databaseLimit!=0 &&(resNum == (readSkip+databaseLimit))) || (maxDBrows!=0 && (resNum + results.skippedUnique) == maxDBrows) || (queryCachedItem.isCompleteResult()) ) {
     				                      int lazyTime = DictionaryDO.statistics.getQueryByOIdAverageTime()*results.lazy.size();
                 		         		 if (lazyTime <= queryCachedItem.getTime()) {
                 				              resultsFromQCache = true;
                 					           getQueryByOIds(results.lazy);  // gets cached query results from database
                                     }else
                                        databaseLimitExceeded = false;
                 			         }else
                                     databaseLimitExceeded = false;

												//remove skiped
                              } // (results != null)

                        } // !(isOrderRelevant() && queryCachedItem.isModifiedQuery())
                    } // query found
                  } // if QUERY_CACHING
                } // full caching
            } // other queries
            if (( userHitDb) || (!resultsFromQCache)) { // go to	database

				        dbQuery	= DictionaryDO.createQuery(transaction);

			   if(uniqueInstance)
			     builder.setCurrentFetchSize(1);

		   	results	= new QueryResult();
			   	int	resultCount=0;
				   boolean	bHasMoreResults	= false;
          if (( (DictionaryDO.getConfigurationAdministration().getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect())  && !loadData) {
		         builder.resetSelectedFields();
        		   builder.setSelectClause("dictionaries."+DictionaryDO.get_OIdColumnName()+", dictionaries."+DictionaryDO.get_versionColumnName());
		       }
		       else
		        builder.setSelectClause(DictionaryDO.columnsNameString);
				   dbQuery.query( this	);	  // invokes executeQuery


				   if (! unique) {
    	   			while (	(bHasMoreResults = resultSet.next()) &&	(databaseLimit==0 || (results.DOs.size()<databaseLimit)) )	{
    					   DictionaryDO newDO;
    					   DictionaryDataStruct newDS;

                    if (( (DictionaryDO.getConfigurationAdministration().getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect())  && !loadData) {
   						   newDO =	DictionaryDO.ceInternal ( new ObjectId(resultSet.getBigDecimal(CoreDO.get_OIdColumnName())) , refs, transaction);
                                                   newDO.set_Version(resultSet.getInt(DictionaryDO.get_versionColumnName()));
   						} else
   						    newDO =	DictionaryDO.ceInternal ( resultSet , refs, transaction);
       					    if(transaction==null) {
                             if(newDO!=null && newDO.isTransactionCheck()) {
                                DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created : Database: "+newDO.get_OriginDatabase()+" DictionaryDO class, oid: "+newDO.get_Handle()+", version: "+newDO.get_Version()+" \n");
                                (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

                             }
                          }
    
                        if (queryItem != null) {
                            queryItem.add((DictionaryDataStruct)newDO.originalData_get());
                        }
                        if (( (DictionaryDO.getConfigurationAdministration().getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect())  && !loadData)
                         {}
                        else
                           newDS =DictionaryDO.addToCache((DictionaryDataStruct)newDO.originalData_get());
    
        					    if (resultCount	>= readSkip)	{
                                    shell =	new	DOShell(newDO);
                                    results.DOs.add(shell);
    							}
    						    resultCount++;
    
    				} // while
 			    } // (!unique)

                else { // (! unique)
 			        HashSet	hsResult = new HashSet(readSkip+databaseLimit);
				    while((bHasMoreResults = resultSet.next()) && (databaseLimit==0 || (results.DOs.size()<databaseLimit)) ) {
 				        DictionaryDO newDO;
 				        DictionaryDataStruct newDS;

                    if (( (DictionaryDO.getConfigurationAdministration().getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect())  && !loadData) {
   						   newDO =	DictionaryDO.ceInternal ( new ObjectId(resultSet.getBigDecimal(CoreDO.get_OIdColumnName())) , refs, transaction);
                                                   newDO.set_Version(resultSet.getInt(DictionaryDO.get_versionColumnName()));
   						} else
    					      newDO =	DictionaryDO.ceInternal ( resultSet , refs , transaction);
							if(transaction==null) {
                                if(newDO!=null && newDO.isTransactionCheck()) {
                                   DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created : Database: "+newDO.get_OriginDatabase()+" DictionaryDO class, oid: "+newDO.get_Handle()+", version: "+newDO.get_Version()+" \n");
                                   (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

                                }
                              }

                        if (queryItem != null) {
                            queryItem.add((DictionaryDataStruct)newDO.originalData_get());
                        }
                        if (( (DictionaryDO.getConfigurationAdministration().getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect())  && !loadData)
                         {
                        } else
                           newDS = DictionaryDO.addToCache((DictionaryDataStruct)newDO.originalData_get());

								if (!hsResult.contains(newDO.get_Handle())) {
									hsResult.add(newDO.get_Handle());
    								if (resultCount	>= readSkip)	{

                                        shell =	new	DOShell(newDO);
                                        results.DOs.add(shell);
                                    }
    								resultCount++;
    							}

 				    } // while
 			    } // else (! unique)

				if ((results.DOs.size()==databaseLimit)&& bHasMoreResults) {
					resultSet.close();
					databaseLimitExceeded =	true;
				}
        if (maxDBrows > 0) {
					if (!bHasMoreResults) {
					  if ((databaseLimit > 0) && databaseLimit < maxDBrows )
					      queryItem.setCompleteResult(true);
          }
        }
				else {
				  if (!bHasMoreResults)
				      queryItem.setCompleteResult(true);
				}
				Date stopQueryTime = new Date();
				queryTime =	stopQueryTime.getTime()	- startQueryTime.getTime();
 			    if (queryItem != null) {
				    queryItem.setTime((new Long(queryTime)).intValue());
     				    if (queryCachedItem != null) {
     				      if ( queryItem.isCompleteResult() || (queryCachedItem.isModifiedQuery() && isOrderRelevant()) || (queryCachedItem.getResultNum() < queryItem.getResultNum()) ) {
// tj 03.09.2004                    if ((!builder.isMultiTableJoin()) || DictionaryDO.isAllReadOnly() )
                    if (builder.isMultiTableJoin()){
                      ((QueryCache)DictionaryDO.cache).addMultiJoinQuery(queryItem);
                    }
                    else {
	   				            if (hitDb) {
	   				              ((QueryCache)DictionaryDO.cache).addComplexQuery(queryItem);
	   				            }
	   				            else {
	   				              ((QueryCache)DictionaryDO.cache).addSimpleQuery(queryItem);
   				              }
                   	} // else from if (builder.isMultiTableJoin())
                  }
           			  else {
           			    if ( (queryCachedItem.getResultNum() < (readSkip + databaseLimit) ) && (queryCachedItem.getResultNum() < maxDBrows) ) {
     				          queryCachedItem.setCompleteResult(true);
 				            }
     				      }
     				      if ( (queryItem.getResultNum() < (readSkip + databaseLimit) ) && (queryItem.getResultNum() < maxDBrows) )
     				            queryItem.setCompleteResult(true);
     				    } // (queryCachedItem != null)
     			} // (queryItem != null)
				    int maxExecuteTime = DictionaryDO.cache.getTableConfiguration().getMaxExecuteTime();
				    if (maxExecuteTime > 0 && queryTime > maxExecuteTime)
				        DODS.getLogChannel().write(Logger.WARNING, "sql = " + builder.getSQLwithParms()+" execute time = "+queryTime + "max table execute time = "+maxExecuteTime);
       	    }
       	    else { //	( userHitDb) || (!resultsFromQCache)
			    if (	DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)
			                     && (!hitDb) && (maxDBrows == 0) && (databaseLimit == 0)
                              && (readSkip == 0) && !builder.isMultiTableJoin()) {
                 results = new QueryResult();
  			      if (readSkip<cacheHits.size()) {
// 12.04.2004 tj					      Vector vect	= new Vector(cacheHits.values());
   					    results.DOs = new Vector();
   					    DictionaryDO DO = null;
   					    DictionaryDataStruct DS = null;
						String cachePrefix = getLogicalDatabase()+".";
            int i = 0;
            int resNumber = 0;
            Vector uniqueResults = new Vector();
						while (i < cacheHits.size() ) { //  && ((databaseLimit==0) || (results.DOs.size()<=databaseLimit))
                                               //	 && ((maxDBrows==0) || (i < maxDBrows))
						    boolean findInTransactionCache = false;
						    DS = (DictionaryDataStruct)cacheHits.get(i);
						    if(transaction!=null && _tr_(transaction).getTransactionCache()!=null && !loadData) {
                                                       DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                               if(DO != null)
                                findInTransactionCache = true;
                            }
                            if(!findInTransactionCache){
                                DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
   					        }
   					        
                             if (unique) {
                                if (!uniqueResults.contains(cachePrefix+DS.get_Handle())) {
                                  uniqueResults.add(cachePrefix+DS.get_Handle());
                                  //if (resNumber	>= readSkip ){
                                  results.DOs.add(DO);
                                  //}
                                  resNumber++;
                                }
                             }
                             else {
                                //if (resNumber	>= readSkip ){
                                results.DOs.add(DO);
                                //}
                                resNumber++;
                             }

   					    i++;
   					    }
						readDOs	= true;
					}

 /*         if ((databaseLimit != 0) && (results.DOs.size() == databaseLimit+1)) {
            databaseLimitExceeded = true;
            results.DOs.remove(databaseLimit);
          }
*/
				}  //if full

   	        } //	( userHitDb) || (!resultsFromQCache)
// end of WebDocWf extension
			if (results != null) {  // tj 01.02.2004
			if ( results.DOs.size()	> 1 && uniqueInstance )
				throw new NonUniqueQueryException("Too many	rows returned from database" );
			DOs	= new DictionaryDO	[ results.DOs.size() ];
			DictionaryDataStruct orig;
			if (readDOs) {
				for	( int i	= 0; i <	results.DOs.size();	i++	) {
					DOs[i] = (DictionaryDO)results.DOs.elementAt(i);
   		        }
   		    }
			else {
			    for	( int i	= 0; i <	results.DOs.size();	i++	) {
				    DOs[i] = (DictionaryDO)((DOShell)results.DOs.elementAt(i)).dataObject;
                }
            }
			arrayIndex = 0;
			}
			else {
				DOs	= new DictionaryDO	[0];
			}
			if (isQueryByOId &&	!hasNonOidCond) {
			   DictionaryDO.statistics.incrementQueryByOIdNum();
			   DictionaryDO.statistics.updateQueryByOIdAverageTime((new Long(queryTime)).intValue(),1);
			}
			else {
			   DictionaryDO.statistics.incrementQueryNum();
				DictionaryDO.statistics.updateQueryAverageTime((new Long(queryTime)).intValue());
			}
		} catch	( SQLException se )	{
			if (null ==	se.getSQLState() ) {
				throw new DataObjectException("Unknown SQLException", se );
			}
			if ( se.getSQLState().startsWith("02") && se.getErrorCode()	== 100 ) {
				throw new DataObjectException("Update or delete	DO is out of synch", se	);
			} else if (		se.getSQLState().equals("S1000") &&		se.getErrorCode() == -268) {
				throw new DataObjectException("Integrity constraint	violation",	se );
			} else {
				throw new DataObjectException( "Data Object	Error",	se );
			}
		} catch	( ObjectIdException	oe ) {
			throw new DataObjectException( "Object ID Error", oe );
		} catch	( DatabaseManagerException de )	{
			throw new DataObjectException( "Database connection	Error",	de );
		}
		finally {
                        if ( null != dbQuery )dbQuery.release();
		}
	}

	/**
	 * Limit the number	of rows	(DOs) returned.
	 * NOTE: When setting a	limit on rows returned by a	query,
	 * you usually want	to use a call to an	addOrderBy method
	 * to cause	the	most interesting rows to be	returned first.

	 * However,	the	DO cache does not yet support the Order	By operation.
	 * Using the addOrderBy	method forces the query	to hit the database.
	 * So, setMaxRows also forces the query	to hit the database.

	 *
	 * @param maxRows Max number of	rows (DOs) returned.
	 *
	 * @exception DataObjectException If a database	access error occurs.
	 * @exception NonUniqueQueryException If too many rows were	found.
	 */
	public void	setMaxRows(	int	maxRows	)
	throws DataObjectException,	NonUniqueQueryException	{

    maxDBrows = maxRows;
		builder.setMaxRows(	maxRows	);
	}

	/**
	 * Return limit of rows	(DOs) returned.
	 * @return Max number of	rows (DOs) returned.
	 *
	 */
	public int	getMaxRows() {
    return maxDBrows;
	}
	/**
	 * Returns attribute orderRelevant.
	 *
	 * @return true if order of query results is relavant, otherwise false.
	 */
	public boolean	isOrderRelevant() {
    return orderRelevant;
	}

	/**
	 * Sets attribute orderRelevant.
	 *
	 * @param newOrderRelevant new value of attribute orderRelavant.
	 */
	public void setOrderRelevant(boolean newOrderRelevant) {
    orderRelevant = newOrderRelevant;
	}


	/**
	 * Return QueryResult with read DOs or DataStructs from caches.
	 *
	 * @param result QueryResult object with result oids.
	 * @return QueryResult object with filled DOs or DataStructs that are found
	 * in the cache.
	 *
	 * @exception DataObjectException If a database	access error occurs.
	 */
	public QueryResult getCachedResults(QueryResult result) throws DataObjectException	{
	    Vector tempVec = result.DOs;
	    if (tempVec == null)
	        return null;
	    result.DOs = new Vector();
	    result.lazy = new Vector();
	    DOShell shell = null;
	    DictionaryDO cacheDO = null;
	    DictionaryDataStruct cacheDS = null;
	    String handle = "";
	    String cachePrefix=getLogicalDatabase()+".";

        for(int i=0; i < tempVec.size(); i++) {

            if(tempVec.get(i)!=null) {
                cacheDO = null;
                cacheDS = null;
                handle=(String)tempVec.get(i);
                shell = new DOShell(handle);
                if(transaction!=null && _tr_(transaction).getTransactionCache()!=null && !loadData) {
                    try {
                        cacheDO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+handle);
                    } catch (Exception e) {
                    }
                }
                if (cacheDO == null){
                    cacheDS = (DictionaryDataStruct)DictionaryDO.cache.getDataStructByHandle(cachePrefix+handle);
                    if(cacheDS!=null) {
                        try {
                            cacheDO = (DictionaryDO)DictionaryDO.ceInternal(cacheDS.get_OId(), transaction);
       		        } catch (Exception e) {
                    }
                }
               }
                if (cacheDO == null){
                    result.lazy.add(shell);
                }
                else {
                    shell.dataObject = cacheDO;
                }
                result.DOs.add(shell);
          }
        } //for
		return result;
	}



	/**
	 * Return array	of DOs constructed from	ResultSet returned by query.
	 *
	 * @return Array of	DOs	constructed	from ResultSet returned	by query.
	 *
	 * @exception DataObjectException If a database	access error occurs.
	 * @exception NonUniqueQueryException If too many rows were	found.
	 */
	public DictionaryDO[] getDOArray()
	throws DataObjectException,	NonUniqueQueryException	{
		if ( needToRun )
			runQuery();
		return DOs;
	}

	/**
	 * Return successive DOs from array	built from ResultSet returned by query.
	 *
	 * @return DOs from	array built	from ResultSet returned	by query.
	 *
	 * @exception DataObjectException If a database	access error occurs.
	 * @exception NonUniqueQueryException If too many rows were	found.
	 */
	public DictionaryDO getNextDO()
	throws DataObjectException,	NonUniqueQueryException	{
		if ( needToRun )
			runQuery();
		if ( null == DOs ) {
			/* This	should never happen.
			 * runQuery() should either	throw an exception
			 * or create an	array of DOs, possibly of zero length.
			 */
			return null;
		}
		if ( arrayIndex	< DOs.length	)
			return DOs[	arrayIndex++ ];
		return null;
	}


	/**
	 * Set the OID to query.
	 * WARNING!	 This method assumes that table	<CODE>dictionaries</CODE>
	 * has a column	named <CODE>"oid"</CODE>.
	 * This	method is called from the DO classes to	retrieve an	object by id.
	 *
	 * @param oid The object id	to query.
	 */
	public void	setQueryOId(ObjectId oid) {
		// Remove from cacheHits any DO	that does not meet this
		// setQuery	requirement.
		String handle =	getLogicalDatabase()+ "." +oid.toString();
		if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
// 12.04.2004 tj new
      DictionaryDataStruct DS = null;
      for ( int i = 0; i < cacheHits.size(); i++ ) {
	      DS = (DictionaryDataStruct)cacheHits.elementAt( i );
	      String cacheHandle = null;
	      try{
	        cacheHandle = DS.get_CacheHandle();
	      }
	      catch (Exception e){}
	      if (cacheHandle != null) {
  	      if ( ! cacheHandle.equals( handle ) )
  		      cacheHits.removeElementAt( i-- );
  		  }
      } // for
    } // full
			if (isQueryByOId) {	// query by	OId	already	has	been invoked

			  hasNonOidCond = true; // this is not simple query by oid: has at least two conditions for oids


			} else { // (isQueryByOid)
				currentHandle =	 handle;
		}
				isQueryByOId = true;
		try {
			Condition cond = new Condition(DictionaryDataStruct.COLUMN_OID,handle,"=");
			queryItem.addCond(cond);
		}
		catch (Exception e){
			DODS.getLogChannel().write(Logger.DEBUG," DictionaryQuery class\n :"+" condition are not added");
		}
		// Also	prepare	the	SQL	needed to query	the	database
		// in case there is	no cache, or the query involves	other tables.
		builder.addWhere( DictionaryDO.PrimaryKey,	oid.toBigDecimal(),	QueryBuilder.EQUAL );
	}

	/**
	 * Set the object handle to	query.
	 * This	is a variant of	setQueryOId().
	 *
	 * @param handle The string	version	of the id to query.
	 * @exception ObjectIdException
	 */
	public void	setQueryHandle(String handle)
	throws ObjectIdException {
		ObjectId oid = new ObjectId( handle	);
		setQueryOId( oid );
	}


	/**
	 * Set "unique instance" assertion bit.
	 * The first call to the next()	method will	throw an exception
	 * if more than	one	object was found.
	 */
	public void	requireUniqueInstance()	{
		uniqueInstance = true;
	}

	/**
	 * Set loadData parameter. if parameter is set to true, Query select t.* is performed.
	 * @param newValue boolean (true/false)
	 */
	public void	setLoadData(boolean newValue)	{
		loadData = newValue;
	}

	/**
	 * Return true if Query is prepared for select t1.* statement. Otherwise return false.
	 * @return boolean (true/false)
	 */
	public boolean	getLoadData()	{
		if(loadData)
		   return true;
		else
		   return ((DictionaryDO.getConfigurationAdministration().getTableConfiguration().isLazyLoading()) || isCaching());
	}

	/**
	 * Reset the query parameters.
	 */
	public void	reset()	{
      if(DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
      if(DictionaryDO.cache.getTableConfiguration().getFullCacheCountLimit() > 0){
		     if(DictionaryDO.cache.getCacheAdministration(CacheConstants.DATA_CACHE).getCacheSize() > DictionaryDO.cache.getTableConfiguration().getFullCacheCountLimit())
		         DictionaryDO.isFullCacheNeeded = false;
	   }
	  }
		if(DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {

		  Map m = null;
		  synchronized (DictionaryDO.cache) {
			  m = DictionaryDO.cache.getCacheContent();
			  if(m!=null)
		         cacheHits =	new Vector(m.values());
		     else
		         cacheHits = new Vector();
		  }
		}
		DOs	= null;
		uniqueInstance	= false;
		needToRun		= true;
		isQueryByOId = false;
		hasNonOidCond	= false;
		loadData=false;
		builder.reset();
		if (DictionaryDO.cache.getLevelOfCaching()	== CacheConstants.QUERY_CACHING) {
			queryItem =	((QueryCache)DictionaryDO.cache).newQueryCacheItemInstance(logicalDatabase);
		}
	}

	/**
	 * Return the appropriate QueryBuilder flag	for	selecting
	 * exact matches (SQL '=') or inexact matches (SQL 'matches').
	 *
	 * @param exact Flag that indicates whether	it is exact match (SQL '=') or
	 * inexact matches (SQL 'matches').
	 * @return boolean True	if it is exact match, otherwise	false.
	 *
	 */
	private	boolean	exactFlag( boolean exact ) {
		return exact ? QueryBuilder.EXACT_MATCH	: QueryBuilder.NOT_EXACT;
	}

	//
	// Implementation of Query interface
	//

	/**
	 * Method to query objects from	the	database.
	 * The following call in runQuery()
	 *			dbQuery.query( this	);
	 * causes the dbQuery object to	invoke
	 *		executeQuery()
	 *
	 * @param conn Handle to database connection.
	 *
	 * @return ResultSet with the results of the query.
	 *
	 * @exception java.sql.SQLException	If a database access error occurs.
	 */
	public ResultSet executeQuery(DBConnection conn)
	throws SQLException		{
		builder.setCurrentFetchSize(iCurrentFetchSize);
		builder.setCurrentQueryTimeout(iCurrentQueryTimeout);
		resultSet =	builder.executeQuery( conn );
		return resultSet;
	}

	/**
	 * WARNING!	 This method is	disabled.
	 * It's	implementation is forced by	the	Query interface.
	 * This	method is disabled for 2 reasons:
	 * 1)  the getDOArray()	and	getNextDO()	methods	are	better
	 *	   because they	return DOs instead of JDBC objects.
	 * 2)  the ceInternal()	method throws an exception
	 *	   that	we cannot reasonably handle	here,
	 *	   and that	we cannot throw	from here.
	 *
	 * @param rs JDBC result set from which	the	next object
	 *	 will be instantiated.
	 * @return Next result.
	 *
	 * @exception java.sql.SQLException
	 *	 If	a database access error	occurs.
	 * @exception com.lutris.appserver.server.sql.ObjectIdException
	 *	 If	an invalid object id was queried from the database.
	 */
	public Object next(ResultSet rs)
	throws SQLException, ObjectIdException {
		// TODO: It	would be nice to throw an unchecked	exception here
		// (an exception that extends RuntimeException)
		// that	would be guaranteed	to appear during application testing.
		throw new ObjectIdException("next()	should not be used.	 Use getNextDO() instead." );
		//return null;
	}


	// WebDocWf	extension for extended wildcard	support
	// The following lines have	been added:
	/**
	 * Convert a String	with user wildcards	into a string with DB wildcards
	 *
	 * @param userSearchValue The string with user wildcards
	 *
	 * @return The string with DB wildcards
	 *
	 * WebDocWf	extension
	 *
	 */
	public String convertUserSearchValue( String userSearchValue ) {
		return builder.convertUserSearchValue( userSearchValue );
	}

	/**
	 * Check whether a string contains DB wildcards
	 *
	 * @param dbSearchValue	The	string with	possible DB	wildcards
	 *
	 * @return Whether a string	contains DB	wildcards
	 *
	 * WebDocWf	extension
	 *
	 */
	public boolean containsWildcards( String dbSearchValue ) {
		return builder.containsWildcards( dbSearchValue	);
	}
	// end of WebDocWf extension for extended wildcard support

	// WebDocWf	extension for query	row	counter
	// The following lines have	been added:
	/**
	 * Get the rowcount	of the query
	 * If possible,	do it without reading all rows
	 *
	 * @return The row count
	 * @exception NonUniqueQueryException
	 * @exception DataObjectException
	 * @exception SQLException
	 * @exception DatabaseManagerException
	 *
	 * WebDocWf	extension
	 *
	 */
	public int getCount()
	throws NonUniqueQueryException,	DataObjectException, SQLException, DatabaseManagerException		{
		int	rowCount=0;
		if (needToRun && databaseLimit==0) {
			rowCount = selectCount();
		} else {
			if (needToRun) runQuery();
				rowCount = DOs.length;
		}
		return rowCount;
	}

    /**
     * Set reference objects.
     * @param queryRefs Reference objects.
     */
    protected void setRefs(HashMap queryRefs) {
        refs = queryRefs;
    }

    /**
     * set the current cursor type - overrides default value from dbVendorConf file.
     * @param resultSetType a result set type; one of ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE.
     * @param resultSetConcurrency a concurrency type; one of ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE.
     * @return the current queryTimeout;
     */
    public void set_CursorType(int resultSetType, int resultSetConcurrency) {
         builder.setCursorType(resultSetType,resultSetConcurrency);
     }

    /**
     * Set fetch size for this query
     * @param iCurrentFetchSizeIn Query fetch size.
     */
    public void set_FetchSize (int iCurrentFetchSizeIn) {
         iCurrentFetchSize = iCurrentFetchSizeIn;
     }

   /**
    * reads the current fetchsize for this query
    * @return the current fetchsize; if -1 the no fetchsize is defined, defaultFetchSize will be use if defined
    */
   public int get_FetchSize() {
       return (iCurrentFetchSize < 0)? builder.getDefaultFetchSize() : iCurrentFetchSize;
   }

   /**
    * Reads the current queryTimeout for this query.
    * @return the current queryTimeout;
    */
   public int get_QueryTimeout() {
       return iCurrentQueryTimeout;
   }

   /**
    * Sets the current queryTimeout for this query.
    * @param iQueryTimeoutIn current queryTimeout.
    */
   public void set_QueryTimeout(int iQueryTimeoutIn) {
       iCurrentQueryTimeout =  (iCurrentQueryTimeout < 0)? builder.getDefaultQueryTimeout() : iCurrentQueryTimeout;
   }


	/**
	 * Get the rowcount	of the query by	using count(*) in the DB
	 *
	 * @return The row count.
	 * @exception SQLException
	 * @exception DatabaseManagerException
	 *
	 * WebDocWf	extension
	 *
	 */
	public int selectCount()
	throws SQLException, DatabaseManagerException {
		int	rowCount=0;
		String tempClause =	builder.getSelectClause();
		builder.setSelectClause(" count(*) as \"counter\" ");
		DBQuery	dbQuery;

			dbQuery	= DictionaryDO.createQuery(transaction);
		dbQuery.query(this);
		resultSet.next();
		rowCount=resultSet.getInt("counter");
		resultSet.close();
      if (transaction == null)
		    dbQuery.release();
		builder.close();
		resultSet =	null;
		builder.setSelectClause(tempClause);
		return rowCount;
	}
	// end of WebDocWf extension for query row counter

	/**
	 * Return true if some caching for this table is enabled.
	 * @return (true/false)
	 */

   private boolean isCaching() {
      double cachePercentage = DictionaryDO.cache.getCachePercentage();
      double usedPercentage = 0;
      if(cachePercentage == -1)
         return false;
      else if(cachePercentage == 0)
         return true;
      else {
       try {
          usedPercentage = DictionaryDO.getConfigurationAdministration().getStatistics().getCacheStatistics(CacheConstants.DATA_CACHE).getUsedPercents();
        } catch (Exception ex) {
               return false;
        }
         if(usedPercentage > DictionaryDO.cache.getCachePercentage()*100)
            return true;
         else
            return false;
      }
   }

   private static CachedDBTransaction _tr_(DBTransaction dbt) {
      return (CachedDBTransaction)dbt;
   }



    private String fixCaseSensitiveCondition(String cmp_op){
        if(DictionaryDO.getConfigurationAdministration().getTableConfiguration().isCaseSensitive()){
			if( cmp_op.equals(builder.CASE_INSENSITIVE_CONTAINS) ){
				return builder.CASE_SENSITIVE_CONTAINS;
			}else if( cmp_op.equals( builder.CASE_INSENSITIVE_STARTS_WITH ) ){
				return builder.CASE_SENSITIVE_STARTS_WITH;
			}else if( cmp_op.equals(builder.CASE_INSENSITIVE_ENDS_WITH) ){
				return builder.CASE_SENSITIVE_ENDS_WITH;
			}else if( cmp_op.equals(builder.CASE_INSENSITIVE_EQUAL) ){
				return builder.EQUAL;
			}else if( cmp_op.equals(builder.CASE_INSENSITIVE_MATCH) ){
				return builder.CASE_SENSITIVE_MATCH;
			}else if( cmp_op.equals(builder.USER_CASE_INSENSITIVE_MATCH) ){
				return builder.USER_CASE_SENSITIVE_MATCH;
			}
        }
        return cmp_op;
    }




    /**
     * Set the fullName to query, with a QueryBuilder comparison operator.
     *
     * @param x The fullName of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryFullName(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_FULLNAME,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getFullName();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.FullName, x, cmp_op );
    }

    /**
     * Set the fullName to query, with a QueryBuilder comparison operator.
     *
     * @param x The fullName of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryFullName(String x)
    throws DataObjectException, QueryException {
         setQueryFullName(x, QueryBuilder.EQUAL);
    }

    /**
     * Add fullName to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByFullName(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("fullName", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add fullName to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByFullName() {
        hitDb = true;
        builder.addOrderByColumn("fullName","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the fullName to query with a user wildcard string
     *
     * @param x The fullName of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchFullName( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchFullName( y );
    }



    /**
     * Set the fullName to query with a DB wildcard string
     *
     * @param x The fullName of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchFullName(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.FullName, x );
            hitDb = true;
        } else
            setQueryFullName( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the name to query, with a QueryBuilder comparison operator.
     *
     * @param x The name of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryName(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_NAME,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getName();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.Name, x, cmp_op );
    }

    /**
     * Set the name to query, with a QueryBuilder comparison operator.
     *
     * @param x The name of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryName(String x)
    throws DataObjectException, QueryException {
         setQueryName(x, QueryBuilder.EQUAL);
    }

    /**
     * Add name to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByName(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("name", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add name to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByName() {
        hitDb = true;
        builder.addOrderByColumn("name","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the name to query with a user wildcard string
     *
     * @param x The name of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchName( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchName( y );
    }



    /**
     * Set the name to query with a DB wildcard string
     *
     * @param x The name of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchName(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.Name, x );
            hitDb = true;
        } else
            setQueryName( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the category to query, with a QueryBuilder comparison operator.
     *
     * @param x The category of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryCategory(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_CATEGORY,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getCategory();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.Category, x, cmp_op );
    }

    /**
     * Set the category to query, with a QueryBuilder comparison operator.
     *
     * @param x The category of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryCategory(String x)
    throws DataObjectException, QueryException {
         setQueryCategory(x, QueryBuilder.EQUAL);
    }

    /**
     * Add category to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByCategory(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("category", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add category to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByCategory() {
        hitDb = true;
        builder.addOrderByColumn("category","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the category to query with a user wildcard string
     *
     * @param x The category of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchCategory( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchCategory( y );
    }



    /**
     * Set the category to query with a DB wildcard string
     *
     * @param x The category of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchCategory(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.Category, x );
            hitDb = true;
        } else
            setQueryCategory( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the type to query, with a QueryBuilder comparison operator.
     *
     * @param x The type of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryType(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_TYPE,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getType();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.Type, x, cmp_op );
    }

    /**
     * Set the type to query, with a QueryBuilder comparison operator.
     *
     * @param x The type of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryType(String x)
    throws DataObjectException, QueryException {
         setQueryType(x, QueryBuilder.EQUAL);
    }

    /**
     * Add type to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByType(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("type", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add type to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByType() {
        hitDb = true;
        builder.addOrderByColumn("type","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the type to query with a user wildcard string
     *
     * @param x The type of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchType( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchType( y );
    }



    /**
     * Set the type to query with a DB wildcard string
     *
     * @param x The type of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchType(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.Type, x );
            hitDb = true;
        } else
            setQueryType( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the domain to query, with a QueryBuilder comparison operator.
     *
     * @param x The domain of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryDomain(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_DOMAIN,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getDomain();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.Domain, x, cmp_op );
    }

    /**
     * Set the domain to query, with a QueryBuilder comparison operator.
     *
     * @param x The domain of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryDomain(String x)
    throws DataObjectException, QueryException {
         setQueryDomain(x, QueryBuilder.EQUAL);
    }

    /**
     * Add domain to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByDomain(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("domain", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add domain to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByDomain() {
        hitDb = true;
        builder.addOrderByColumn("domain","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the domain to query with a user wildcard string
     *
     * @param x The domain of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchDomain( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchDomain( y );
    }



    /**
     * Set the domain to query with a DB wildcard string
     *
     * @param x The domain of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchDomain(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.Domain, x );
            hitDb = true;
        } else
            setQueryDomain( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the legal to query, with a QueryBuilder comparison operator.
     *
     * @param x The legal of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryLegal(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_LEGAL,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getLegal();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.Legal, x, cmp_op );
    }

    /**
     * Set the legal to query, with a QueryBuilder comparison operator.
     *
     * @param x The legal of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryLegal(String x)
    throws DataObjectException, QueryException {
         setQueryLegal(x, QueryBuilder.EQUAL);
    }

    /**
     * Add legal to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByLegal(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("legal", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add legal to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByLegal() {
        hitDb = true;
        builder.addOrderByColumn("legal","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the legal to query with a user wildcard string
     *
     * @param x The legal of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchLegal( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchLegal( y );
    }



    /**
     * Set the legal to query with a DB wildcard string
     *
     * @param x The legal of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchLegal(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.Legal, x );
            hitDb = true;
        } else
            setQueryLegal( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the sourceLanguages to query, with a QueryBuilder comparison operator.
     *
     * @param x The sourceLanguages of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQuerySourceLanguages(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_SOURCELANGUAGES,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getSourceLanguages();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.SourceLanguages, x, cmp_op );
    }

    /**
     * Set the sourceLanguages to query, with a QueryBuilder comparison operator.
     *
     * @param x The sourceLanguages of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQuerySourceLanguages(String x)
    throws DataObjectException, QueryException {
         setQuerySourceLanguages(x, QueryBuilder.EQUAL);
    }

    /**
     * Add sourceLanguages to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderBySourceLanguages(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("sourceLanguages", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add sourceLanguages to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderBySourceLanguages() {
        hitDb = true;
        builder.addOrderByColumn("sourceLanguages","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the sourceLanguages to query with a user wildcard string
     *
     * @param x The sourceLanguages of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchSourceLanguages( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchSourceLanguages( y );
    }



    /**
     * Set the sourceLanguages to query with a DB wildcard string
     *
     * @param x The sourceLanguages of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchSourceLanguages(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.SourceLanguages, x );
            hitDb = true;
        } else
            setQuerySourceLanguages( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the targetLanguages to query, with a QueryBuilder comparison operator.
     *
     * @param x The targetLanguages of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryTargetLanguages(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_TARGETLANGUAGES,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getTargetLanguages();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.TargetLanguages, x, cmp_op );
    }

    /**
     * Set the targetLanguages to query, with a QueryBuilder comparison operator.
     *
     * @param x The targetLanguages of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryTargetLanguages(String x)
    throws DataObjectException, QueryException {
         setQueryTargetLanguages(x, QueryBuilder.EQUAL);
    }

    /**
     * Add targetLanguages to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByTargetLanguages(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("targetLanguages", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add targetLanguages to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByTargetLanguages() {
        hitDb = true;
        builder.addOrderByColumn("targetLanguages","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the targetLanguages to query with a user wildcard string
     *
     * @param x The targetLanguages of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchTargetLanguages( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchTargetLanguages( y );
    }



    /**
     * Set the targetLanguages to query with a DB wildcard string
     *
     * @param x The targetLanguages of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchTargetLanguages(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.TargetLanguages, x );
            hitDb = true;
        } else
            setQueryTargetLanguages( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Set the xmlCode to query, with a QueryBuilder comparison operator.
     *
     * @param x The xmlCode of the dictionaries to query.
     * @param cmp_op QueryBuilder comparison operator to use.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */

    
    public void setQueryXmlCode(String x, String cmp_op )
    throws DataObjectException, QueryException {
    
    String cachePrefix = getLogicalDatabase()+".";

        hasNonOidCond = true;
        cmp_op = fixCaseSensitiveCondition(cmp_op);
        Condition cond = null;
      cond = new Condition(DictionaryDataStruct.COLUMN_XMLCODE,x,cmp_op);
        queryItem.addCond(cond);
        // WebDocWf extension for extended wildcard support
        // The following lines have been added:
        if (cmp_op.equals(QueryBuilder.CASE_INSENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_SENSITIVE_MATCH) || cmp_op.equals(QueryBuilder.USER_CASE_INSENSITIVE_MATCH)) {
            hitDb = true;
        } else {
            // end of WebDocWf extension for extended wildcard support
            
            if (DictionaryDO.cache.isFull() && (DictionaryDO.isFullCacheNeeded)) {
                // Remove from cacheHits any DOs that do not meet this
                // setQuery requirement.
                DictionaryDO DO = null;
                DictionaryDataStruct DS = null;
// 12.04.2004 tj
//                for ( Iterator iter = (new HashSet(cacheHits.values())).iterator(); iter.hasNext();) 
                for ( int i = 0; i < cacheHits.size(); i++ ) {
                      try {
                        boolean findInTransactionCache = false;
//                        DS = (DictionaryDataStruct)iter.next();
                        DS = (DictionaryDataStruct)cacheHits.elementAt( i );
                        if(transaction!=null && _tr_(transaction).getTransactionCache()!=null) {
                            DO = (DictionaryDO)_tr_(transaction).getTransactionCache().getDOByHandle(cachePrefix+DS.get_Handle());
                            if(DO != null)
                                findInTransactionCache = true;
                        }
                        if(!findInTransactionCache){
                            DO = (DictionaryDO)DictionaryDO.ceInternal(DS.get_OId(), transaction);
                        }
                      }catch (Exception ex) {
                      System.out.println("Error in query member stuff");
                    }            
                    String m = DO.getXmlCode();
                    if(!QueryBuilder.compare( m, x, cmp_op )) {
                        try {
                            String cacheHandle = DO.get_CacheHandle();
//                            cacheHits.remove(cacheHandle);
                            cacheHits.removeElementAt( i-- );
                        } catch (DatabaseManagerException e) {
                            throw new DataObjectException("Error in loading data object's handle.");
                        }
                    }
                } // for
            }
        }
        // Also prepares the SQL needed to query the database
        // in case there is no cache, or the query involves other tables.
        // WebDocWf patch for correct queries in fully cached objects
        // The following line has been put under comments:
        // if ( partOrLru || hitDb )
        // end of WebDocWf patch for correct queries in fully cached objects
        builder.addWhere( DictionaryDO.XmlCode, x, cmp_op );
    }

    /**
     * Set the xmlCode to query, with a QueryBuilder comparison operator.
     *
     * @param x The xmlCode of the dictionaries to query.
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If comparison operator is inappropriate
     * (e.g. CASE_SENSITIVE_CONTAINS on an integer field).
     */
    public void setQueryXmlCode(String x)
    throws DataObjectException, QueryException {
         setQueryXmlCode(x, QueryBuilder.EQUAL);
    }

    /**
     * Add xmlCode to the ORDER BY clause.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     *
     * @param direction_flag  True for ascending order, false for descending
     */
    public void addOrderByXmlCode(boolean direction_flag) {
        hitDb = true;
        builder.addOrderByColumn("xmlCode", (direction_flag) ? "ASC" : "DESC");
    }


    /**
     * Add xmlCode to the ORDER BY clause.  This convenience
     * method assumes ascending order.
     * NOTE: The DO cache does not yet support the Order By operation.
     * Using the addOrderBy method forces the query to hit the database.
     */
    public void addOrderByXmlCode() {
        hitDb = true;
        builder.addOrderByColumn("xmlCode","ASC");
    }



    // WebDocWf extension for extended wildcard support
    // The following lines have been added:

    /**
     * Set the xmlCode to query with a user wildcard string
     *
     * @param x The xmlCode of the dictionaries to query with user wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setUserMatchXmlCode( String x )
    throws DataObjectException, QueryException {
        String y = convertUserSearchValue( x );
        setDBMatchXmlCode( y );
    }



    /**
     * Set the xmlCode to query with a DB wildcard string
     *
     * @param x The xmlCode of the dictionaries to query with DB wildcards
     *
     * @exception DataObjectException If a database access error occurs.
     * @exception QueryException If a query error occurs.
     *
     * @deprecated Use comparison operators instead
     *
     * WebDocWf extension
     *
     */
    public void setDBMatchXmlCode(String x )
    throws DataObjectException, QueryException {
        if (containsWildcards(x) || builder.getUserStringAppendWildcard()) {
            builder.addMatchClause( DictionaryDO.XmlCode, x );
            hitDb = true;
        } else
            setQueryXmlCode( x, QueryBuilder.EQUAL );
    }


    // end of WebDocWf extension for extended wildcard support

    /**
     * Returns the <code>QueryBuilder</code> that this <code>DictionaryQuery</code>
     * uses to construct and execute database queries.
     * <code>DictionaryQuery.setQueryXXX</code> methods use 
     * the <code>QueryBuilder</code> to
     * append SQL expressions to the <code>"WHERE"</code> clause to be executed.
     * The <code>QueryBuilder.addEndClause method.</code> can be used to
     * append freeform SQL expressions to the <code>WHERE</code> clause,
     * e.g. "ORDER BY name".
     *
     * <b>Notes regarding cache-enabled DO classes:</b>
     * DO classes can be cache-enabled.  
     * If when using a <code>DictionaryQuery</code>, the application developer
     * <b>does not call</b> <code>getQueryBuilder</code>,
     * then <code>DictionaryQuery.setQueryXXX</code> methods 
     * simply prune the DO cache and return the remaining results.
     * However, a <code>QueryBuilder</code> builds
     * <CODE>SELECT</CODE> statements for execution by the actual database,
     * and never searches the built-in cache for the DO.
     * So, if the DO class is cache-enabled, and <code>getQueryBuilder</code>
     * is called, this <CODE>DictionaryQuery</CODE> object ignores the cache 
     * and hits the actual database.
     * 
     * @return QueryBuilder that is used to construct and execute database queries.   
     */
    public QueryBuilder getQueryBuilder() {
         hitDb = true;
        return builder;
    }

    /**
     * Insert an <CODE>OR</CODE> between <CODE>WHERE</CODE> clauses.
     * Example:  find all the persons named Bob or Robert:
     * <CODE>
     *    PersonQuery pq = new PersonQuery();
     *    pq.setQueryFirstName( "Bob" );
     *    pq.or();
     *    pq.setQueryFirstName( "Robert" );
     * </CODE>
     * 
     * Note:  Calls to <CODE>setQueryXxx</CODE> methods
     * are implicitly <CODE>AND</CODE>ed together,
     * so the following example will always return nothing:
     * <CODE>
     *    PersonQuery pq = new PersonQuery();
     *    pq.setQueryFirstName( "Bob" );
     *    // AND automatically inserted here.
     *    pq.setQueryFirstName( "Robert" );
     * </CODE>

     * 
     * NOTE: The DO cache does not yet support the OR operator.
     * Using the or() method forces the query to hit the database.

     * 
     * @see com.lutris.dods.builder.generator.query.QueryBuilder QueryBuilder to construct more elaborate queries.
     * author Jay Gunter
     */
    public void or() {
        hitDb = true;
        builder.addWhereOr();
    }

    /**
     * Place an open parenthesis in the <CODE>WHERE</CODE> clause.
     * Example usage:  find all the Bobs and Roberts who are 5 or 50 years old:
     * <CODE>
     *    PersonQuery pq = new PersonQuery();
     *    pq.openParen();
     *       pq.setQueryFirstName( "Bob" );
     *       pq.or();
     *       pq.setQueryFirstName( "Robert" );
     *    pq.closeParen();
     *    // AND automatically inserted here.
     *    pq.openParen();
     *       pq.setQueryAge( 5 );
     *       pq.or();
     *       pq.setQueryAge( 50 );
     *    pq.closeParen();
     * </CODE>
    
     * 
     * NOTE: The DO cache does not yet support the Open Paren operator.
     * Using the openParen() method forces the query to hit the database.
    
     * 
     * @see com.lutris.dods.builder.generator.query.QueryBuilder QueryBuilder to construct more elaborate queries.
     * author Jay Gunter
     */
    public void openParen() {
        hitDb = true;
        builder.addWhereOpenParen();
    }

    /**
     * Place a closing parenthesis in the <CODE>WHERE</CODE> clause.
    
     * 
     * NOTE: The DO cache does not yet support the Close Paren operator.
     * Using the closeParen() method forces the query to hit the database.
    
     * 
     * @see DictionaryQuery#openParen openParen
     * author Jay Gunter
     */
    public void closeParen() {
        hitDb = true;
        builder.addWhereCloseParen();
    }
}
