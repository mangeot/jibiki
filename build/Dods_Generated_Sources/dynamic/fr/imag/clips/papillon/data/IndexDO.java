
/*-----------------------------------------------------------------------------
 * Enhydra Java Application Server
 * Copyright 1997-2000 Lutris Technologies, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes Enhydra software developed by Lutris
 *    Technologies, Inc. and its contributors.
 * 4. Neither the name of Lutris Technologies nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY LUTRIS TECHNOLOGIES AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL LUTRIS TECHNOLOGIES OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * contains WebDocWf extensions
 *
 *-----------------------------------------------------------------------------
 * fr.imag.clips.papillon.data/IndexDO.java
 *-----------------------------------------------------------------------------
 */


package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import java.util.Hashtable;
import java.util.Collection;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.Vector;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.reflect.Method;

import com.lutris.logging.LogChannel;
import com.lutris.logging.Logger;
import org.enhydra.dods.DODS;
import com.lutris.util.Config;
import com.lutris.util.ConfigException;
import com.lutris.appserver.server.sql.*;
import com.lutris.appserver.server.sql.standard.*;
import com.lutris.dods.builder.generator.dataobject.*;
import com.lutris.dods.builder.generator.query.*;
import org.enhydra.dods.cache.Condition;
import org.enhydra.dods.cache.DataStructCache;
import org.enhydra.dods.cache.QueryCache;
import org.enhydra.dods.cache.QueryCacheImpl;
import org.enhydra.dods.cache.QueryResult;
import org.enhydra.dods.cache.ConfigurationAdministration;
import org.enhydra.dods.statistics.Statistics;
import com.lutris.classloader.MultiClassLoader;
import org.enhydra.xml.XMLConfig;
import org.enhydra.dods.Common;
import org.enhydra.dods.cache.CacheConstants;
import org.enhydra.dods.exceptions.AssertionDataObjectException;
import org.enhydra.dods.exceptions.CacheObjectException;



// WebDocWf extension for DODS row instance security and genric store
import org.webdocwf.dods.access.*;
// end of WebDocWf extension for DODS row instance security and generic store

/**
 * Data core class, used to set and retrieve the IndexDO information.
 *
 * @version $Revision: 662 $
 * @author  NN
 * @since   DODS Project
 */
 public class IndexDO extends com.lutris.dods.builder.generator.dataobject.GenericDO implements IndexDOI, java.io.Serializable {
    /**
     * Static final data members name the table and columns for this DO.
     * By using these members with an instance of the QueryBuilder class,
     * an application can perform straight SQL queries while retaining
     * compile-time checking of table and column usage.
     *
     * Example:  List the Cities containing Persons named Bob:
     *
     *    Using straight SQL with QueryBuilder:
     *      Pro: code runs faster because you create fewer objects
     *      Con: code is less clear
     *
     *         Vector fields = new Vector();
     *         fields.addElement( AddressDO.City );
     *         QueryBuilder qb = new QueryBuilder( fields );
     *         qb.addWhere( PersonDO.FirstName, "Bob" );
     *         qb.addWhere( PersonDO.PrimaryKey, AddressDO.Person );
     *         RDBRow row;
     *         while ( null != ( row = qb.getNextRow() ) ) {
     *             String city = row.get( AddressDO.City ).getString();
     *         }
     *
     *    Using Query/DO classes:
     *      Pro: code is (often) clearer
     *      Con: code runs slower because you create more objects
     *
     *         PersonQuery pq = new PersonQuery();
     *         pq.setQueryFirstName( "Bob" );
     *         PersonDO[] bobs = pq.getDOArray();
     *         for ( int i = 0; i < bobs.length; i++ ) {
     *             AddressQuery aq = new AddressQuery();
     *             aq.setQueryPerson( bobs[i] );
     *             AddressDO addr = aq.getNextDO();
     *             String city = addr.getCity();
     *         }
     */
	 
	 // GS: added the dbtablename + made table a non static attribute (will be initialized at construction time)
     protected String dbtablename;

    /**
     * List of reference objects
     */
    private HashMap refs = null;


    /**
    * null : use old style init query
    * true : use columns names with table prefix
    * false: use columns names withouth table prefix
    */
    private static Boolean useOrderedWithTable = null ;


    /**
    * String with column names
    */
	// static String columnsNameString = null;
    public  String getColumnsNameString() {
        return getColumnsNameString(this.dbtablename);
    }
    
    /**
    * Is DO first node in DELETE CASCADE sekvence
    */
    private boolean isRootDeleteNode = true;


    /**
     * Name of the logical database for which DO object was created
     */
    protected String originDatabase = null;


    /**
     * Return the name of the logical database for which DO object was created.
     *
     * @deprecated Use get_OriginDatabase()
     * @return origin logical database name.
     *
     */
    public String getOriginDatabase() {
        return get_OriginDatabase();
    }

    /**
     * Return the name of the logical database for which DO object was created.
     *
     * @return origin logical database name.
     *
     */
    public String get_OriginDatabase() {
        return get_DataStruct().get_Database();
    }

	// GS: we now return the value of dbtablename (value initialized at construction time)
    /**
     * Return the value of dbtablename as the name of the table in the database
     * which contains IndexDO objects.
     * This method overrides CoreDO.getTableName()
     * and is used by CoreDO.executeUpdate() during error handling.
     *
     * @return The database table name.
     *
     * @see com.lutris.appserver.server.sql.CoreDO CoreDO
     * author Jay Gunter
     */
    public String getTableName() {
        return this.dbtablename;
	    //return "index";
    }

    /**
     * final RDBColumn PrimaryKey for use with QueryBuilder.
     * See example above.
     */
	 // GS: The PrimaryKey is not static anymore. It will be set at construction time;
     public static RDBColumn getPrimaryKey(String tablename) {
         RDBTable  table = new RDBTable(tablename);
         return new RDBColumn( table,
                               getPrimaryKeyName() );

     }
    /* RDBColumns for IndexDO attributes are defined below. */


    /* Using a DO (and its Query class) to access a VIEW instead of a TABLE:
     *
     * A DO (and its Query class) can be used to access a VIEW
     * instead of a TABLE.  The Data Object is created as usual in DODS,
     * but the "create table" SQL command for that DO is not used.
     * Instead, you substitute a "create view" command to create a
     * virtual table in the database; this is often done to provide
     * convenient access to a collection of tables joined together.
     *
     * A VIEW usually does not return "oid" and "version" columns;
     * often (but now always) a VIEW is defined to return the "oid" column
     * for one of the tables joined together in the definition of the VIEW.
     *
     * If notUsingOId is true, IndexDO.createExisting(ResultSet)
     * will NOT invoke the GenericDO(ResultSet) constructor
     * so to avoid attempting to extract the "oid" and "version" columns
     * from the ResultSet.
     */
    static protected final boolean notUsingOId = false;


    /**
     * A DO class contains a reference to a DataStruct class.
     * This reference can be null (when the data for the DO
     * has not yet been retrieved from the database),
     * allowing a DO object to be a lightweight placeholder
     * until its data is needed.
     */
    private IndexDataStruct data = null;

    /**
     * A DO class contains a reference to a DBTransaction class.
     * This reference can be null (when the DO is created without
     * transaction).
     */
    private DBTransaction transaction = null;

    /**
     * Return transaction which DO belongs.
     *
     * @return DBTransaction or null if not specified.
     *
     */
    public DBTransaction get_transaction() {
        return transaction;
    }

    /**
     * Set Transaction to current DO.
     *
     * @param trans The transaction.
     * @return true if the operation was successfully performed, otherwise false.
     */
    protected boolean setTransaction(DBTransaction trans) {
        boolean isOK=false;
        if (get_transaction() == null) {
            transaction = trans;
            isOK=true;
        } else {
        if(get_transaction().equals(trans))
            isOK=true;
        }
        return isOK;
    }


    /**
     * Return information whether the data for this object has been marked read-only.
     *
     * @return True if the data for this object has been marked read-only.
     *
     */
    public boolean isReadOnly() {
      return getConfigurationAdministration().getTableConfiguration().isReadOnly();
     }

    /**
     * Sets DO's data.
     * @param data Data object.
     * @deprecated Use set_Data()
     */
     public void setData (Object data) {
        set_Data(data);
     }

    /**
     * Sets DO's data.
     * @param data Data object.
     */
     public void set_Data (Object data) {
        this.data = (IndexDataStruct)data;
     }

    /**
     * Sets original DO's data.
     * @param data Data object.
     */
     public void originalData_set (Object data) {
        originalData = (IndexDataStruct)data;
     }

    /**
     * Returns DO's data.
     * @return DO's data.
     * @deprecated Use get_Data()
     */
     public Object getData () {
        return get_Data();
     }

    /**
     * Returns DO's data.
     * @return DO's data.
     */
     public Object get_Data () {
        return (null != data)? data : originalData;
     }

    /**
     * Returns dataStruct.
     * @return Data Struct object.
     * @deprecated Use get_DataStruct()
     */
    public IndexDataStruct getDataStruct () {
        return get_DataStruct();
    }

    /**
     * Returns dataStruct.
     * @return Data Struct object.
     */
    public IndexDataStruct get_DataStruct () {
        return (IndexDataStruct) get_Data();
    }

    /**
     * Returns original DO's data.
     * @return Original DO's data.
     */
     public Object originalData_get () {
        return originalData;
     }

     public void checkDup () throws DatabaseManagerException, com.lutris.appserver.server.sql.ObjectIdException {
         if (isDeletedFromDatabase)
             throw new DatabaseManagerException("Object "+get_Handle()+" is deleted");
         if (null == data) {
             data = ((IndexDataStruct)originalData).duplicate();
         data.readOnly = false;
         }
     }

	
    /**
     * Protected constructor. Only derived classes should call it.
     *
     * @param is_view Is this view or not.
     *
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     */
	 // GS: Constructors now have a tablename additional mandatory operator.
    protected IndexDO ( String tablename, boolean is_view )
    throws ObjectIdException, DatabaseManagerException {
        super( is_view );
        this.dbtablename = tablename;

        if(isTransactionCheck()) {
            DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created :"+(is_view?"":" Database: "+get_OriginDatabase()+" IndexDO class, oid: "+get_Handle()+", version: "+get_Version())+" \n");
            (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

        }
    }
    /**
     * Protected constructor. Only derived classes should call it.
     *
     * @param is_view Is this view or not.
     * @param dbTrans Database transaction.
     *
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     */
 	 // GS: Constructors now have a tablename additional mandatory operator.
    protected IndexDO ( String tablename, boolean is_view, DBTransaction dbTrans )
    throws ObjectIdException, DatabaseManagerException {
        super( is_view );
        this.dbtablename = tablename;

        setTransaction(dbTrans);
        if(dbTrans!=null) {
           originDatabase = dbTrans.getDatabaseName();
        }
        if(originDatabase==null)
           originDatabase = get_logicalDBName();
        get_DataStruct().set_Database(originDatabase);
        addToTransactionCache();

    }


    /**
     * Protected constructor.  Only derived classes should call it.
     *
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     */
 	 // GS: Constructors now have a tablename additional mandatory operator.
    protected IndexDO ( String tablename )
    throws ObjectIdException, DatabaseManagerException {
        super( notUsingOId );
        this.dbtablename = tablename;

        originDatabase = get_logicalDBName();
        get_DataStruct().set_Database(originDatabase);
        if(isTransactionCheck()) {
            DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created : Database: "+get_OriginDatabase()+" IndexDO class, oid: "+get_Handle()+", version: "+get_Version()+" \n");
            (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

        }
        if (autoSaveAllowed&&isAutoSaveCreateVirgin()&&null != transaction) {
            try {
                save(transaction,false);
            } catch (Exception ex) {
                        DODS.getLogChannel().write(Logger.DEBUG,"Faild to AutoSave virgin DO: "+get_OriginDatabase()+" IndexDO class\n");
            }
        }
    }

    /**
     * Protected constructor.  Only derived classes should call it.
     * @param dbTrans The current database transaction.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     */
 	 // GS: Constructors now have a tablename additional mandatory operator.
    protected IndexDO ( String tablename, DBTransaction dbTrans )
    throws ObjectIdException, DatabaseManagerException {
        super( notUsingOId );
        this.dbtablename = tablename;

        setTransaction(dbTrans);
        if(dbTrans!=null) {
           originDatabase = dbTrans.getDatabaseName();
        }
        if(originDatabase==null)
           originDatabase = get_logicalDBName();
        get_DataStruct().set_Database(originDatabase);

        addToTransactionCache();
        if (autoSaveAllowed&&isAutoSaveCreateVirgin()&&null != transaction) {
            try {
                save(transaction,false);
            } catch (Exception ex) {
                        DODS.getLogChannel().write(Logger.DEBUG,"Faild to AutoSave virgin DO: "+get_OriginDatabase()+" IndexDO class\n");
            }
        }
    }



    /**
     * isLoaded()
     * Returns information whether object's data is loaded from database.
     * @return true if the data for this object has been retrieved
     * from the database.
     */
    public boolean isLoaded() {
        return (null != originalData)&&(!get_DataStruct().isEmpty);
    }


    /**
     * Load the fields for the DO from the database.
     *
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    public void loadData()
    throws SQLException, ObjectIdException, DataObjectException {
        if (null == originalData&&!get_DataStruct().isEmpty) {
            originalData = new IndexDataStruct ();
        }

        ObjectId id = get_OId();
        if ( null == id )
            return;
        if ( ! isPersistent() )   // DO from createVirgin
            return;
        // DO from createExisting.  Complain if no record in database.
        IndexQuery query;

               query = new IndexQuery (dbtablename, get_transaction());

//        if(get_refs()!=null)
//        {
        query.setRefs(get_refs());
//        }
        query.setQueryOId( id );
        query.requireUniqueInstance();
        IndexDO obj;
        try {
           query.setLoadData(true);
           obj = query.getNextDO();
            if ( null == obj )
                throw new DataObjectException("IndexDO DO not found for id=" + id );
            makeIdentical(obj);
            set_Version(    obj.get_Version() );
            get_DataStruct().isEmpty = false;
        } catch ( NonUniqueQueryException e ) {
            throw new ObjectIdException( "Duplicate ObjectId" );
        }

    }

    /**
     * Load the actual DO data if necessary.
     * Called by get/set methods.
     *
     * @exception DataObjectException If a data access error occurs.
     */
    protected void checkLoad()
    throws DataObjectException {
        if (null == originalData||get_DataStruct().isEmpty) {
            try {
                loadData();
            } catch ( Exception e ) {
                throw new DataObjectException("Unable to load data for IndexDO id=" + get_OId() +
                                              ", error = ", e);
            }
    }
    }


    /**
     * Protected constructor used by createExisting(ObjectId) above.
     *
     * @param id The ObjectId for the object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   Should never see this exception since GenericDO.ctor(ObjectId)
     *   never accesses the database.
     */
    protected IndexDO(String tablename, ObjectId id )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        super( id );
        this.dbtablename = tablename;
        originDatabase = get_logicalDBName();
        get_DataStruct().set_Database(originDatabase);
        if(isTransactionCheck()) {
            DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created : Database: "+get_OriginDatabase()+" IndexDO class, oid: "+get_Handle()+", version: "+get_Version()+" \n");
           (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

        }

    }

    /**
     * Protected constructor used by createExisting(ObjectId, DBTransaction) above.
     *
     * @param id The ObjectId for the object.
     * @param dbTrans The current database transaction
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   Should never see this exception since GenericDO.ctor(ObjectId)
     *   never accesses the database.
     */
    protected IndexDO(String tablename, ObjectId id , DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        super( id );
        this.dbtablename = tablename;
        setTransaction(dbTrans);
        if(dbTrans!=null) {
           originDatabase = dbTrans.getDatabaseName();
        }
        if(originDatabase==null)
           originDatabase = get_logicalDBName();
        get_DataStruct().set_Database(originDatabase);
        addToTransactionCache();
    }




    /**
     * Represents table and cache (if there is caching) statistics.
     */
    // protected static Statistics statistics;

    /**
     * Get table statistics.
     *
     * @return Table statistics.
     */
    public static Statistics get_statistics(String tablename) {
        return getCache(tablename).getStatistics();
    }

    /**
     * Refresh table statistics.
     */
    public static void refreshStatistics(String tablename) {
       getCache(tablename).refreshStatistics();
    }


    /**
     * Get all used logical databases.
     *
     * @deprecated Use get_UsedLogicalDatabases()
     * @return Array that contains names of all used logical databases.
     *
     */
    public static String[] getUsedLogicalDatabases() {
        return get_UsedLogicalDatabases();
    }

    /**
     * Get all used logical databases.
     *
     * @return Array that contains names of all used logical databases.
     *
     */
    public static String[] get_UsedLogicalDatabases() {
        String[] str = { get_logicalDBName() };
        return str;
    }

    //GS: We have as many caches as we have accessed tables
    //protected static DataStructCache cache; // cache for IndexDO
	protected static java.util.Hashtable cachesTable = new Hashtable();
    protected static DataStructCache getCache(String tablename) {
		DataStructCache resultCache = (DataStructCache) cachesTable.get(tablename);
		if (resultCache==null) {
			resultCache = initCache(tablename);
		}
		return resultCache;
	}
    protected DataStructCache getCache() {
		DataStructCache resultCache = (DataStructCache) cachesTable.get(dbtablename);
		if (resultCache==null) {
			resultCache = initCache(this.dbtablename);
		}
		return resultCache;
	}
    protected static void setCache(String tablename, DataStructCache newCache) {
		if (newCache!=null) {
            // GS: Maybe we should test if the cache exists and sync it...
			cachesTable.put(tablename, newCache);
		}
	}


    protected static boolean isFullCacheNeeded = false; // it depends of CacheFullCacheCountLimit parameter and number of data in database.
    


    /**
     * Read cache configuration from application configuration file:
     * cache size for fr.imag.clips.papillon.data.index table or default cache size.
     * @param database DO's database.
     * @exception CacheObjectException
     */
    public static void readCacheConfiguration(String tablename, String database) throws CacheObjectException {
        if (getConfigurationAdministration(tablename).isDisabled()) {
            throw new CacheObjectException("Caching is disabled");
        }
        Config tableConfig = null;
        Config cacheConfig = null;
        try {
            tableConfig = (Config)DODS.getDatabaseManager().getConfig().getSection("DB."+database+".index");
        } catch (Exception ex) {
                    DODS.getLogChannel().write(Logger.DEBUG," IndexDO class\n :"+" Using default configuration for 'index' table");
        }
        try {
            cacheConfig = (Config)DODS.getDatabaseManager().getConfig().getSection("DB."+database+".index.cache");
        } catch ( Exception e ) {
            DODS.getLogChannel().write(Logger.DEBUG," IndexDO class\n :"+" Using default cache configuration for 'index' table");
        }
        
        getCache(tablename).readConfiguration(tableConfig,cacheConfig, database);
    }


    /**
     * Get name of the table that is cached.
     *
     * @return Name of the table that is cached.
     */
    public static String getCacheDodsTableName() {
        return "index";
    }


    /**
     * Returns index table cache.
     *
     * @return index table cache.
     */
    public ConfigurationAdministration getConfigurationAdministration() {
        return getCache();
    }
    public static ConfigurationAdministration getConfigurationAdministration(String tablename) {
        return getCache(tablename);
    }

    /**
     * Queries all rows in table, and for each row
     * creates a DO instance in the cache.
     * For these DOs, data.readOnly = true,
     * which causes set methods to throw an exception.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    public static void refreshCache(String tablename)
    throws java.sql.SQLException, DatabaseManagerException, ObjectIdException, DataObjectException {
       getConfigurationAdministration(tablename).getCacheAdministration(CacheConstants.DATA_CACHE).refresh();
       DataStructCache cache = getCache(tablename);
       String querySnt = cache.getInitialQueryCache();
       int maxSize = cache.getCacheAdministration(CacheConstants.DATA_CACHE).getMaxCacheSize();
        	 if (maxSize != 0) {
	        cache.checkFull();
           if(cache.isFull()) {
           if(cache.getTableConfiguration().getFullCacheCountLimit() == 0) {
               isFullCacheNeeded=false;
           } else if(cache.getTableConfiguration().getFullCacheCountLimit() > 0) {
            int numOfRows = 0;
  	            IndexQuery query;

	                DBTransaction tmpTransaction = DODS.getDatabaseManager().createTransaction(get_logicalDBName());
	                query = new IndexQuery (tablename, tmpTransaction);
	                try {
	                    numOfRows = query.getCount();
	                    tmpTransaction.release();
	                } catch ( NonUniqueQueryException ex ) {
	                    // Since we do not call query.requireUniqueInstance()
	                    // this should never happen.
	                    throw new ObjectIdException( "Duplicate ObjectId" );
	                }
	

               if (numOfRows < cache.getTableConfiguration().getFullCacheCountLimit())
                  isFullCacheNeeded = true;
               else
                  isFullCacheNeeded = false;      
               
           } else 
               isFullCacheNeeded=true;  
	        }
	        if (querySnt != null) {
	            IndexQuery query;

	                DBTransaction tmpTransaction = DODS.getDatabaseManager().createTransaction(get_logicalDBName());
	                query = new IndexQuery (tablename, tmpTransaction);
	                query.hitDatabase();
// tj 02.04.2004	                maxSize = cache.getCacheAdministration(CacheConstants.DATA_CACHE).getMaxCacheSize();
                	int initMaxSize = 0;
                	if(cache.getInitialDSCacheSize()> 0){
                        initMaxSize=cache.getInitialDSCacheSize();
                	}
                	if((initMaxSize > 0) && ((initMaxSize < maxSize)||(maxSize < 0))) {
                	   isFullCacheNeeded = false;   
                  maxSize=initMaxSize;
               }
	                if (maxSize > 0)
	                    try {
	                        query.setMaxRows(maxSize);
	                    }
	                    catch (NonUniqueQueryException nuEx){
	                        System.err.println ("NonUniqueQueryException in refreshCache() method : too many rows were      found.");
	                    }
	                if (!querySnt.equals("*")) {
	                    QueryBuilder builder = query.getQueryBuilder();
	                    builder.addWhere(querySnt);
	                }
	                IndexDO obj;
	                try {
	                	if (cache.getInitialCacheFetchSize()>0){
	                        query.set_FetchSize(cache.getInitialCacheFetchSize());
	                	}
	                	query.set_CursorType(cache.getTableConfiguration().getInitCachesResultSetType(),cache.getTableConfiguration().getInitCachesResultSetConcurrency());                     	                            
	                    query.setLoadData(true);
	                    query.getNextDO();
	                    tmpTransaction.release();
	                } catch ( NonUniqueQueryException ex ) {
	                    // Since we do not call query.requireUniqueInstance()
	                    // this should never happen.
	                    throw new ObjectIdException( "Duplicate ObjectId" );
	                }
	
	        }
	     }
	     cache.refreshStatistics();
    }

    private static boolean isDisabledCaching = false;

    /**
     * Disable caching.
     * @exception java.sql.SQLException
     * @exception DatabaseManagerException
     * @exception ObjectIdException
     * @exception DataObjectException
     */
    public void disableCaching()
    throws java.sql.SQLException, DatabaseManagerException, ObjectIdException, DataObjectException {
        isDisabledCaching = true;
        getConfigurationAdministration().getCacheAdministration(CacheConstants.DATA_CACHE).disable();
    }

    /**
     * Enable caching.
     * @exception java.sql.SQLException
     * @exception DatabaseManagerException
     * @exception ObjectIdException
     * @exception DataObjectException
     */
    public void enableCaching()
    throws java.sql.SQLException, DatabaseManagerException, ObjectIdException, DataObjectException {
        if (isDisabledCaching){
            getConfigurationAdministration().getCacheAdministration(CacheConstants.DATA_CACHE).enable();
            DataStructCache cache = getCache();
            int maxSize = cache.getCacheAdministration(CacheConstants.DATA_CACHE).getMaxCacheSize();
            if (maxSize != 0){
           if(cache.isFull()) {
           if(cache.getTableConfiguration().getFullCacheCountLimit() == 0) {
               isFullCacheNeeded=false;
           } else if(cache.getTableConfiguration().getFullCacheCountLimit() > 0) {
            int numOfRows = 0;
  	            IndexQuery query;

	                DBTransaction tmpTransaction = DODS.getDatabaseManager().createTransaction(get_logicalDBName());
	                query = new IndexQuery (dbtablename, tmpTransaction);
	                try {
	                    numOfRows = query.getCount();
	                    tmpTransaction.release();
	                } catch ( NonUniqueQueryException ex ) {
	                    // Since we do not call query.requireUniqueInstance()
	                    // this should never happen.
	                    throw new ObjectIdException( "Duplicate ObjectId" );
	                }
	

               if (numOfRows < cache.getTableConfiguration().getFullCacheCountLimit())
                  isFullCacheNeeded = true;
               else
                  isFullCacheNeeded = false;      
               
           } else 
               isFullCacheNeeded=true;  
	        }
            
            String querySnt = cache.getInitialQueryCache();
            if (querySnt != null) {
	                IndexQuery query;
	    
	                    DBTransaction tmpTransaction = DODS.getDatabaseManager().createTransaction(get_logicalDBName());
	                    query = new IndexQuery (dbtablename, tmpTransaction);
	                    query.hitDatabase();
                           	int initMaxSize = 0;
                         	if(cache.getInitialDSCacheSize()> 0){
        	                 	initMaxSize=cache.getInitialDSCacheSize();
                	         }
                	         if((initMaxSize > 0) && ((initMaxSize < maxSize)||(maxSize < 0))){
                	            isFullCacheNeeded = false;
                           maxSize=initMaxSize;
                        }

     	                 if (maxSize > 0)
	                     try {
	                        query.setMaxRows(maxSize);
	                     }
	                     catch (NonUniqueQueryException nuEx){
	                        System.out.println ("NonUniqueQueryException in enableCache() method : too many rows were found.");
	                     }

	                    if (!querySnt.equals("*")) {
	                        QueryBuilder builder = query.getQueryBuilder();
	                        builder.addWhere(querySnt);
	                    }
	                    IndexDO obj;
	                    try {
	                       	if (cache.getInitialCacheFetchSize()>0){
                                query.set_FetchSize(cache.getInitialCacheFetchSize());
                        	}
                        	query.set_CursorType(cache.getTableConfiguration().getInitCachesResultSetType(),cache.getTableConfiguration().getInitCachesResultSetConcurrency());                     	                            
	                        query.setLoadData(true);
	                        query.getNextDO();
	                        tmpTransaction.release();
	                    } catch ( NonUniqueQueryException ex ) {
	                        // Since we do not call query.requireUniqueInstance()
	                        // this should never happen.
	                        throw new ObjectIdException( "Duplicate ObjectId" );
	                    }
	    
	            }
	         }
        }
    }
    private static CachedDBTransaction _tr_(DBTransaction dbt) {
        return (CachedDBTransaction)dbt;
    }

    /**
     * Add DO to cache.
     * If DO already exists in cache, just the data member is replaced,
     * so that application references to the DO remain valid.
     * If there  is no caching newDO object is returned.
     *
     * @param newDO Data object that will be added to cache.
     * @return Data object added to cache.
     */
    private IndexDO addToTransactionCache( IndexDO newDO ) {
        IndexDO ret = null;
        if(get_transaction()!=null && _tr_(get_transaction()).getTransactionCache()!=null) {
            ret = (IndexDO)_tr_(get_transaction()).getTransactionCache().addDO(newDO);
        }
        if (ret == null)
            return newDO;
        return ret;
    }

    /**
     * Add DataStruct object to cache.
     * If there is no caching newDO object is returned.
     *
     * @param newDS DataStruct object that will be added to cache.
     * @return DataStruct object added to cache.
     */
    public static synchronized IndexDataStruct addToCache( String tablename, IndexDataStruct newDS ) {
        IndexDataStruct ret = (IndexDataStruct)getCache(tablename).addDataStruct(newDS);
        if (ret == null)
            return newDS;
        return ret;
    }

    /**
     * Add DataStruct object to cache.
     * If there is no caching newDO object is returned.
     *
     * @param newDS DataStruct object that will be added to cache.
     * @return DataStruct object added to cache.
     */
    public synchronized IndexDataStruct addToCache( IndexDataStruct newDS ) {
        IndexDataStruct ret = (IndexDataStruct)getCache().addDataStruct(newDS);
        if (ret == null)
            return newDS;
        return ret;
    }

    /**
     * Add DO's original data object to cache.
     */
    public void addToCache() {
        addToCache((IndexDataStruct)this.originalData_get());
    }

    /**
     * Add DO to cache.
     * If DO already exists in cache, just the data member is replaced,
     * so that application references to the DO remain valid.
     * This method overides method addToCache of the class CoreDO.
     */
    private void addToTransactionCache() {
        addToTransactionCache(this);
    }


     /**
     * UpdateCache for given DataStruct object.
     *
     * @param updDS DataStruct object
     * @return Updated or inserted DataStruct object.
     */
    public synchronized IndexDataStruct updateCache( IndexDataStruct updDS) {
        IndexDataStruct ret = (IndexDataStruct)getCache().updateDataStruct(updDS);
        if (ret == null)
            return updDS;
        return ret;
    }

    /**
     * Update Cache.
     */
    public void updateCache() {
        updateCache((IndexDataStruct)this.originalData_get());
    }

    /**
     * Delete DataStruct object from cache
     *
     * @param data DataStruct object for deleting
     *
     * @return Deleted DataStruct object
     */
    public static synchronized IndexDataStruct deleteFromCache(String tablename, IndexDataStruct data ) {
        getCache(tablename).deleteDataStruct(data);
        return data;
    }


    /**
     * Remove DataStruct object from cache.
     *
     * @param dbName Logical name of the database from which
     * IndexDataStruct object will be removed.
     * @param handle Handle of DataStruct object which will be re moved.
     */
    public static synchronized void removeFromCache(String tablename, String dbName, String handle) {
        String cacheHandle = dbName+"."+handle;
        getCache(tablename).removeDataStruct( cacheHandle );
    }

    /**
     * Delete object from cache
     */
    public void deleteFromCache() {
        deleteFromCache(this.dbtablename, (IndexDataStruct)this.originalData_get());
    }


    /**
     * Remove DataStruct from cache.
     *
     * @param data DataStruct object which will be removed.
     *
     * @return Removed DataStruct object or null if DataStruct object doesn't
     * exist in the cache.
     */
    public static synchronized IndexDataStruct removeFromCache( String tablename, IndexDataStruct data ) {
        return (IndexDataStruct)getCache(tablename).removeDataStruct(data);
    }

    /**
     * Remove DataStruct from cache.
     */
    public void evict() {
        if (!isPersistent())
            removeFromCache(this.dbtablename, (IndexDataStruct)this.originalData_get());
    }

    /**
     * Remove DataStruct objects from cache.
     *
     * @param DSs Array of DataStruct objects which will be removed from cache.
     */
    public static void evict(String tablename, IndexDataStruct[] DSs) {
        for (int i=0; i<DSs.length; i++)
            removeFromCache(tablename, (IndexDataStruct) DSs[i]);
    }

    /**
     * Remove DataStruct objects from cache.
     *
     * @param dbName Logical name of the database from which
     * IndexDataStruct object will be removed.
     * @param handles array of DataStruct object handles that will be removed
     * from cache.
     */
    public static void evict(String tablename, String dbName, String[] handles) {
        if (handles!=null) {
            for (int i=0; i<handles.length; i++)
                removeFromCache(tablename, dbName, handles[i]);
        }
    }

    /**
     * The cache is used automatically by the class.
     * Callers of the create() methods do not know whether
     * the returned DO instance is shared or not.
     * This prevents the existence of multiple instances in memory
     * of the same database object.
     * The cache is instantiated when the first DO instance is created.
     */

    static {
            String dbName = get_logicalDBName();
        	useOrderedWithTable = null;
        	try {
                String orderedResultSetStr = ((StandardLogicalDatabase)DODS.getDatabaseManager()
                        	                  .findLogicalDatabase(dbName)).getDriverProperty(Common.VENDOR_ORDERED_RESULT_SET);
                if (orderedResultSetStr!=null){
                	if (orderedResultSetStr.equalsIgnoreCase("oldStyle")){
                	}else if (orderedResultSetStr.equalsIgnoreCase("withPrefix")){
                        useOrderedWithTable = new Boolean(true);
                	}else if (orderedResultSetStr.equalsIgnoreCase("noPrefix")){
                        useOrderedWithTable = new Boolean(false);
                	}else{
                        DODS.getLogChannel().write(Logger.DEBUG,"IndexDO : Invalid value for OrderedResultSet parameter. Using default. ");
                	}
                }
        	} catch (DatabaseManagerException e){
                DODS.getLogChannel().write(Logger.DEBUG,"IndexDO : Unable to read configuration for OrderedResultSet. Using default. ");
        	}
    }
    /**
     * Class that contains unchanging (static) data from the database
     * will have a cache of DOs representing the entire contents of the table.
     */
    // GS: this is not a static initialization anymore: static {
    protected static DataStructCache initCache(String tablename) {
 	   DataStructCache cache = null;
       try {
        	String dbName = get_logicalDBName();

            XMLConfig dodsConf = Common.getDodsConf();
            String cacheClassPath = null;
            String cacheClassName = null;
              
        	String queryCacheImplClass = 
                ((StandardLogicalDatabase)DODS.getDatabaseManager().findLogicalDatabase(dbName)).getDatabaseConfiguration().getQueryCacheImplClass();              
            try {
            	if (queryCacheImplClass==null){
                	cacheClassPath = dodsConf.getText("CacheJar");
                	cacheClassName = dodsConf.getText("CacheClassName");
                	if (cacheClassPath != null && cacheClassName != null) {
                        MultiClassLoader loader = new MultiClassLoader(null);
                        loader.setClassPath(cacheClassPath);
                        Class cacheClass = loader.loadClass(cacheClassName);
						cache = (DataStructCache)cacheClass.newInstance();
						cache = cache.newInstance();
                	} else  {
						cache = new QueryCacheImpl();
                	}
            	}else{
                	Class cacheClass = Class.forName(queryCacheImplClass);
					cache = (DataStructCache)cacheClass.newInstance();
					cache = cache.newInstance();
            	}
            } catch ( Exception e ) {}
                        
           if (cache == null) {
                cache = new QueryCacheImpl();
            }
            
            setCache(tablename, cache);

            readCacheConfiguration(tablename, get_logicalDBName());
            get_statistics(tablename); // set statistics
            refreshCache(tablename);
        } catch ( Exception e ) {
            // cannot throw from static block
        }
		return cache;
    }

    /**
     * This method is invoked whenever object needs to be loaded from database.
     *
     * @exception DataObjectException If a data access error occurs.
     */
    public void refresh() throws DataObjectException {
        try {
            loadData();
        } catch ( Exception e ) {
            throw new DataObjectException("Unable to load data for IndexDO id=" + get_OId() +
                                          ", error = ", e);
        }
    }

    /**
     * This method is invoked whenever objects needs to be loaded from database.
     *
     * @param DOs Array of DOs which will be red from database.
     *
     * @exception DataObjectException If a data access error occurs.
     */
    public static void refresh(IndexDO[] DOs) throws DataObjectException {
        for (int i=0; i<DOs.length; i++)
            DOs[i].refresh();
    }


    /**
     * Refresh cache by removing from the cache results of the query
     * querySnt
     *
     * @param querySnt query used in this
     * @exception QueryException If a data access error occurs.
     */
         public void refresh(String querySnt)  throws QueryException {
                 try {
                   QueryBuilder qb = new QueryBuilder();
                   qb.select(this.getPrimaryKey(this.dbtablename));
                   qb.addWhere(querySnt);
         BigDecimal objId;
         String handle;
         String database = get_logicalDBName();
                   RDBRow row;
                   try {
                           while ( null != ( row = qb.getNextRow() ) ) {
                                objId = row.get( this.getPrimaryKey(this.dbtablename) ).getBigDecimal();
                                   handle = objId.toString();
                       removeFromCache(this.dbtablename, database, handle);
                           }
                   }catch ( Exception e ) {
                           throw new QueryException(" Query Exception occured," );
                   }
         }catch (Exception ex){
                 System.out.println("Error in refresh(String) of DO object.");
            }
         }


    /**
     * createVirgin(String tablename)
     * Creates a DO that has no ObjectId or data.
     * Such a DO is used to insert a new database entry
     * after its data has been set.
     * @param tablename The name of the table in which the DO is to be created
     *
     * @return Created data object.
     *
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     *

     * @deprecated Use createVirgin(String, DBTransaction) instead.

     */
    public static IndexDO createVirgin(String tablename)
    throws DatabaseManagerException, ObjectIdException {
        return new IndexDO (tablename);
    }

    /**
     * createVirgin(String , DBTransaction)
     * @param tablename The name of the table in which the DO is to be created
     * @param dbTrans The current database transaction
     * @return Created data object.
     *
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static IndexDO createVirgin(String tablename, DBTransaction dbTrans)
    throws DatabaseManagerException, ObjectIdException {
        return new IndexDO (tablename, dbTrans);
    }

    /**
     * createExisting( String, BigDecimal )
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the passed BigDecimal value as the primary key.
     *
     * Creates a DO that represents an existing entry in the database.
     * Such a DO is used to examine and possibly update such an entry.
     * createExisting() is called only from the code that retrieves
     * an ObjectId from a ResultSet (database query result).
     * createExisting() is protected because no other DO or BO should ever
     * need to call it.
     * FIX unfortunately the createExisting(BigDecimal) form *does* need
     * to be public because it is called by the public ctors of other DOs.
     * For example:
     * AaaDO contains a ref to a BbbDO,
     * so there is a method AaaDO.setBbb(BbbDO).
     * In the ctor AaaDO(ResultSet), we have the call
     * setBbb( BbbDO.createExisting( rs.getBigDecimal( "bbb")));
     * Since AaaDO is not in the same package as BbbDO,
     * BbbDO.createExisting(BigDecimal) must be public, not protected.
     * Java needs the C++ 'friend' idea.
     *
     * @param tablename, the table in which the objectis to be queried.
     * @param bd The BigDecimal representation of the ObjectId for the object.
     *
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.

     * @deprecated Use createExistring(String, BigDecimal, DBTransaction) instead.

     */
    public static IndexDO createExisting(String tablename, BigDecimal bd)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        return publicCreateExisting(tablename, null, bd, null, null);
    }

    /**
     * Method ceInternal is public, only to allow generated classes
     * to instantiate one another. Public modifier doesn't mean user
     * application could use it - it mustn't.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param bd The BigDecimal representation of the ObjectId for the object.
     * @return instance of IndexDO or null
     *
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     * @exception ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static IndexDO ceInternal(String tablename, BigDecimal bd)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if (null == bd)
            return null;
        return ceInternal(tablename, new ObjectId(bd));
    }


    /**
     * createExisting( String, BigDecimal, DBTransaction )
     *
     * @param tablename, the table in which the objectis to be queried.
     * @param bd The BigDecimal representation of the ObjectId for the object.
     * @param dbTrans The current database transaction.
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    public static IndexDO createExisting(String tablename, BigDecimal bd, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        return publicCreateExisting(tablename, null, bd, null, dbTrans);
    }

    /**
     * Method ceInternal is public, only to allow generated classes
     * to instantiate one another. Public modifier doesn't mean user
     * application could use it - it mustn't.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param bd The BigDecimal representation of the ObjectId for the object.
     * @param dbTrans The current database transaction.
     * @return instance of IndexDO or null
     *
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     * @exception ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static IndexDO ceInternal(String tablename, BigDecimal bd, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if (null == bd)
            return null;
        return ceInternal(tablename, new ObjectId(bd), dbTrans);
    }

    /**
     * createExisting(String, BigDecimal, HashMap, DBTransaction )
     *
     * @param tablename, the table in which the objectis to be queried.
     * @param bd The BigDecimal representation of the ObjectId for the object.
     * @param queryRefs HashMap Created referenced DO's (key datamaseName.Oid)
     * @param dbTrans The current database transaction.
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    public static IndexDO createExisting(String tablename, BigDecimal bd, HashMap queryRefs, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        return publicCreateExisting(tablename, null, bd, queryRefs, dbTrans);
    }

    /**
     * Method ceInternal is public, only to allow generated classes
     * to instantiate one another. Public modifier doesn't mean user
     * application could use it - it mustn't.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param bd The BigDecimal representation of the ObjectId for the object.
     * @param queryRefs HashMap Created referenced DO's (key datamaseName.Oid)
     * @param dbTrans The current database transaction.
     * @return instance of IndexDO or null
     *
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     * @exception ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static IndexDO ceInternal(String tablename, BigDecimal bd, HashMap queryRefs, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if (null == bd)
            return null;
        return ceInternal(tablename, new ObjectId(bd), queryRefs, dbTrans);
    }


    /**
     * createExisting(String, String )
     *
     * The createExisting method is used to create a <CODE>IndexDO</CODE>
     * from a string handle.
     *
     * @param tablename, the table in which the objectis to be queried.
     * @param handle String representation of the ObjectId for the object.
     *
     * @return Created IndexDO object.

     * @deprecated Use createExisting(String, String, DBTransaction) instead.

     */
    public static IndexDO createExisting(String tablename, String handle) {
        IndexDO ret = null;
        try {
            BigDecimal bd = new BigDecimal(handle);
            ret = publicCreateExisting(tablename, null, bd, null, null);
        } catch (Exception e) {
            DODS.getLogChannel().write(Logger.DEBUG," IndexDO class\n : Create existing failed");
        }
        return ret;
    }

    /**
     * Method ceInternal is public, only to allow generated classes
     * to instantiate one another. Public modifier doesn't mean user
     * application could use it - it mustn't.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param handle String representation of the ObjectId for the object.
     * @return instance of IndexDO or null
     */
    public static IndexDO ceInternal(String tablename, String handle) {
        IndexDO ret = null;
        try {
            BigDecimal bd = new BigDecimal(handle);
            ret = ceInternal(tablename, bd);
        } catch (Exception e) {
            DODS.getLogChannel().write(Logger.DEBUG," IndexDO class\n : Create existing failed");
        }
        return ret;
    }


    /**
     * createExisting(String, String, DBTransaction )
     *
     * The createExisting method is used to create a <CODE>IndexDO</CODE>
     * from a string handle.
     *
     * @param tablename, the table in which the objectis to be queried.
     * @param handle String representation of the ObjectId for the object.
     * @param dbTrans The current database transaction.
     * @return Created IndexDO object.
     */
    public static IndexDO createExisting(String tablename, String handle, DBTransaction dbTrans) {
        IndexDO ret = null;
        try {
            BigDecimal bd = new BigDecimal(handle);
            ret = publicCreateExisting(tablename, null, bd, null, dbTrans);
        } catch (Exception e) {
            DODS.getLogChannel().write(Logger.DEBUG," IndexDO class\n : Create existing failed");
        }
        return ret;
    }

    /**
     * Method ceInternal is public, only to allow generated classes
     * to instantiate one another. Public modifier doesn't mean user
     * application could use it - it mustn't.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param handle String representation of the ObjectId for the object.
     * @param dbTrans The current database transaction.
     * @return instance of IndexDO or null
     */
    public static IndexDO ceInternal(String tablename, String handle, DBTransaction dbTrans) {
        IndexDO ret = null;
        try {
            BigDecimal bd = new BigDecimal(handle);
            ret = ceInternal(tablename, bd, dbTrans);
        } catch (Exception e) {
            DODS.getLogChannel().write(Logger.DEBUG," IndexDO class\n : Create existing failed");
        }
        return ret;
    }



    /**
     * createExisting( ObjectId , DBTransaction)
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the passed ObjectID value as the primary key.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param id The ObjectId for the object.
     * @param dbTrans The current database transaction.
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected static IndexDO ceInternal(String tablename, ObjectId id, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if (null == id)
            return null;
        return ceInternal(tablename, id, null, dbTrans);
    }

    /**
     * ceInternal( ObjectId , HashMap queryRefs, DBTransaction)
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the passed ObjectID value as the primary key.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param id The ObjectId for the object.
     * @param queryRefs HashMap of available references.
     * @param dbTrans The current database transaction.
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected static IndexDO ceInternal(String tablename, ObjectId id, HashMap queryRefs, DBTransaction dbTrans )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        
        boolean isNewDO = true;
        
        if (null == id)
            return null;
        String cacheHandle = get_logicalDBName()+"."+id.toString();
        IndexDO ret = null;
        IndexDataStruct data = null;
        if (null == queryRefs) {
            queryRefs = new HashMap();
        }
        if (null!= dbTrans && null!= _tr_(dbTrans).getTransactionCache()) {
            ret = (IndexDO)_tr_(dbTrans).getTransactionCache().getDOByHandle(cacheHandle);
            isNewDO=false;
        } else if (queryRefs.containsKey(cacheHandle)) {
            ret = (IndexDO)queryRefs.get(cacheHandle);
            isNewDO=false;
        }
        if (ret==null) {
            ret = (IndexDO)createDO (tablename, id, dbTrans);
        }
        if (ret.get_DataStruct().isEmpty) {
            data = findCachedObjectByHandle(tablename, cacheHandle);
            if (data != null)
               ret.originalData_set(data);
        }
        ret.setPersistent(true);  // mark DO as persistent (preexisting)

        if (queryRefs!=null) {
            ret.set_refs(queryRefs);
            ret.addRefs(cacheHandle, ret);
        }
        if (!getCache(tablename).getTableConfiguration().isLazyLoading() ) { // If not lazy-loading, fetch DO data now.
           if(ret.get_DataStruct().isEmpty)
            ret.loadData();
        } else {
            get_statistics(tablename).incrementLazyLoadingNum();
        }
        // unset the GenericDO.dirty flag.
        if(isNewDO)
         ret.markClean();

        return ret;
    }


    /**
     * ceInternal(String, ObjectId )
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the passed ObjectID value as the primary key.
     * @param tablename the name of the table.
     * @param id The ObjectId for the object.
     *
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.

     * @deprecated Use ceInternal(String, ObjectId, DBTransaction) instead.

     */
    protected static IndexDO ceInternal(String tablename, ObjectId id )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == id )
            return null;
        return ceInternal(tablename, id, null);
    }

    /**
     * ceInternal( ResultSet )
     *
     * Factory method used to create an instance of this class to
     * represent a Data Object already existing in the database.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param rs The ResultSet returned by the Query class for
     * an existing Data Object stored in the database.
     *
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.

     * @deprecated Use ceInternal(ResultSet, DBTransaction) instead.

     */
    protected static IndexDO ceInternal(String tablename, ResultSet rs )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == rs )
            return null;
        IndexDO ret = null;
        if ( notUsingOId ) {
            ret = new IndexDO (tablename);
            ret.initFromResultSet( rs );
        } else {
            ret = new IndexDO (tablename, rs );
        }
        return ret;
    }


    /**
     * ceInternal( ResultSet, DBTransaction )
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param rs The ResultSet returned by the Query class for
     * an existing Data Object stored in the database.
     * @param dbTrans The current database transaction
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected static IndexDO ceInternal(String tablename, ResultSet rs , DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == rs )
            return null;
        IndexDO ret = null;
        if ( notUsingOId ) {
            ret = new IndexDO (tablename, dbTrans);
            ret.initFromResultSet( rs );
        } else {
            ret = new IndexDO ( tablename, rs, dbTrans );
        }
        return ret;
    }


    /**
     * ceInternal( ResultSet , HashMap)
     *
     * Factory method used to create an instance of this class to
     * represent a Data Object already existing in the database.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param rs The ResultSet returned by the Query class for
     * an existing Data Object stored in the database.
     * @param queryRefs list of created refernce objects.
     *
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.

     * @deprecated Use ceInternal(ResultSet, HashMap, DBTransaction) instead.

     */
    protected static IndexDO ceInternal(String tablename, ResultSet rs , HashMap queryRefs)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == rs )
            return null;
        IndexDO ret = null;
        if ( notUsingOId ) {
            ret = new IndexDO (tablename);
            ret.set_refs(queryRefs);
            ret.initFromResultSet( rs );
        } else {
            ret = new IndexDO ( tablename, rs, queryRefs );
        }
        return ret;
    }


    /**
     * ceInternal( ResultSet , HashMap, DBTransaction)
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param rs The ResultSet returned by the Query class for
     * an existing Data Object stored in the database.
     * @param queryRefs list of created refernce objects.
     * @param dbTrans The current database transaction
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected static IndexDO ceInternal(String tablename, ResultSet rs , HashMap queryRefs, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == rs )
            return null;
        IndexDO ret = null;
        if ( notUsingOId ) {
            ret = new IndexDO (tablename, dbTrans);
            ret.set_refs(queryRefs);
            ret.initFromResultSet( rs );
        } else {
            if(queryRefs==null)
                queryRefs = new HashMap();
            BigDecimal tmpOid = rs.getBigDecimal(get_OIdColumnName());
            String cacheHandle = get_logicalDBName()+"."+tmpOid;
            if(queryRefs.containsKey(cacheHandle)) {
                ret = (IndexDO)queryRefs.get(cacheHandle);
                if (!ret.isLoaded()) {
                    ret.set_refs(queryRefs);
                    ret.initFromResultSet(rs);
                }
                return ret;
            }
            if (useOrderedWithTable != null){
            	ret = new IndexDO (tablename, new ObjectId(tmpOid),dbTrans);
            	ret.set_refs(queryRefs);
            	ret.initFromResultSet(rs);
            	//if(dbTrans!=null) dbTrans.lockDO(this);
            }else{
                ret = new IndexDO ( tablename, rs, queryRefs, dbTrans );
            }
        }
        return ret;
    }


    /**
     * ceInternal( RDBRow )
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the IndexDO.PrimaryKey value
     * in the passed RDBRow.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param row A row returned by QueryBuilder.getNextRow().
     *
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the RDBRow does not contain a IndexDO.PrimaryKey.
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.

     * @deprecated Use ceInternal(RDBRow, DBTransaction) instead.

     */
    protected static IndexDO ceInternal(String tablename, RDBRow row )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == row )
            return null;
        RDBColumnValue pk = null;
        try {
            pk = row.get( IndexDO.getPrimaryKey(tablename) );
            return ceInternal( tablename, pk );
        } catch ( Exception e ) {
            throw new DataObjectException("Cannot create IndexDO, row does not " +
                                          "contain IndexDO primary key." );
        }
    }


    /**
     * ceInternal( RDBRow , DBTransaction)
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the IndexDO.PrimaryKey value
     * in the passed RDBRow.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param row A row returned by QueryBuilder.getNextRow().
     * @param dbTrans The current database transaction.
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the RDBRow does not contain a IndexDO.PrimaryKey.
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected static IndexDO ceInternal(String tablename, RDBRow row, DBTransaction dbTrans )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == row )
            return null;
        RDBColumnValue pk = null;
        try {
            pk = row.get( IndexDO.getPrimaryKey(tablename) );
            return ceInternal( tablename, pk, dbTrans );
        } catch ( Exception e ) {
            throw new DataObjectException("Cannot create IndexDO, row does not " +
                                          "contain IndexDO primary key." );
        }
    }


    /**
     * ceInternal( RDBColumnValue )
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the passed IndexDO.PrimaryKey.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param pk a PrimaryKey column value from a row that was returned by
     * QueryBuilder.getNextRow().
     *
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the RDBColumnValue does not contain a IndexDO.PrimaryKey.
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.

     * @deprecated Use ceInternal(RDBColumnValue, DBTransaction) instead.

     */
    protected static IndexDO ceInternal(String tablename, RDBColumnValue pk )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == pk )
            return null;
        if ( ! pk.equals( IndexDO.getPrimaryKey(tablename) ) )
            throw new DataObjectException("Cannot create IndexDO, " +
                                          "RDBColumnValue is not IndexDO.PrimaryKey." );
        BigDecimal bd = null;
        try {
            bd = pk.getBigDecimal();
        } catch ( Exception e ) {
            throw new DataObjectException("Cannot create IndexDO, bad primary key." );
        }
        if ( null == bd )
            return null;
        return ceInternal( tablename, bd );
    }



    /**
     * ceInternal( RDBColumnValue, DBTransaction )
     *
     * Factory method creates a IndexDO object by searching for it
     * in the database using the passed IndexDO.PrimaryKey.
     *
     * @param tablename The name of the table in which the object is to be created.
     * @param pk a PrimaryKey column value from a row that was returned by
     * QueryBuilder.getNextRow().
     * @param dbTrans The current database transaction.
     * @return Created IndexDO object.
     *
     * @exception DataObjectException
     *   If the RDBColumnValue does not contain a IndexDO.PrimaryKey.
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected static IndexDO ceInternal(String tablename, RDBColumnValue pk, DBTransaction dbTrans )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if ( null == pk )
            return null;
        if ( ! pk.equals( IndexDO.getPrimaryKey(tablename) ) )
            throw new DataObjectException("Cannot create IndexDO, " +
                                          "RDBColumnValue is not IndexDO.PrimaryKey." );
        BigDecimal bd = null;
        try {
            bd = pk.getBigDecimal();
        } catch ( Exception e ) {
            throw new DataObjectException("Cannot create IndexDO, bad primary key." );
        }
        if ( null == bd )
            return null;
        return ceInternal( tablename, bd , dbTrans);
    }


    /**
     * Creates a DO that has no ObjectId
     * but has a copy of an existing DO's data.
     * Such a DO is used to insert a new database entry
     * that is largely similar to an existing entry.
     *
     * @param tablename Name of the table in which the DO is to be created.
     * @param data The data struct to copy values from.
     *
     * @return Created IndexDO object.
     *
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.

     * @deprecated Use createCopy(String, IndexDataStruct, DBTransaction) instead.

     */
    public static IndexDO createCopy(String tablename,  IndexDataStruct data )
    throws DatabaseManagerException, ObjectIdException {
        IndexDO ret = new IndexDO (tablename, true);
        ret.originalData_set(data);
        return ret;
    }

    /**
     * Creates a DO that has no ObjectId
     * but has a copy of an existing DO's data.
     * Such a DO is used to insert a new database entry
     * that is largely similar to an existing entry.
     *
     * @param tablename Name of the table in which the DO is to be created.
     * @param data The data struct to copy values from.
     * @param dbTrans The current database transaction
     * @return Created IndexDO object.
     *
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static IndexDO createCopy( String tablename, IndexDataStruct data, DBTransaction dbTrans )
    throws DatabaseManagerException, ObjectIdException {
        IndexDO ret = new IndexDO (tablename, true, dbTrans);
        ret.originalData_set(data);
        ret.markClean();
        return ret;
    }



    /**
     * Creates a DO that has no ObjectId
     * but has a copy of an existing DO's data.
     * Such a DO is used to insert a new database entry
     * that is largely similar to an existing entry.
     *
     * @param orig The original DO to copy.
     *
     * @return Created IndexDO object.
     *
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static IndexDO createCopy( IndexDO orig )
    throws DatabaseManagerException, ObjectIdException {
        if (null == orig)
            return null;
        IndexDO ret = new IndexDO (orig.dbtablename, true);
        if (null != orig.originalData_get()) {
            ret.originalData_set(orig.originalData_get());
            ret.markClean();
            ret.transaction = orig.transaction;
            ret.setPersistent(orig.isPersistent());
        }
        return ret;
    }

   /**
     *
     * @param orig The original DO to copy.
     * @param dbTrans The current database transaction
     * @return Created IndexDO object.
     *
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static IndexDO createCopy( IndexDO orig, DBTransaction dbTrans )
    throws DatabaseManagerException, ObjectIdException {
        if (null == orig)
            return null;
        IndexDO ret = new IndexDO (orig.dbtablename, true, dbTrans);
        if (null != orig.originalData_get()) {
            ret.originalData_set(orig.originalData_get());
            ret.markClean();
            ret.setPersistent(orig.isPersistent());
        }
        return ret;

    }


    /**
     * Causes the DO to refresh itself from the database
     * the next time a set or get method is called.
     */
    public void reload() {
        originalData = data = null;
    }

    /**
     * The methods <CODE>
     *     getHandle
     *     hasMatchingHandle

     *     findCachedObjectByHandle

     * </CODE> are used by Presentation Objects that need to populate
     * HTML select lists with Data Objects as options.
     * The <CODE>getHandle()</CODE> method is used
     * to set the value for each option,
     * and the <CODE>hasMatchingHandle()<CODE>

     * methods are used to lookup the Data Object when the selection has
     * been made.
     *
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     *
     * @return id of this DO as a string
     *   If an object's id can't be allocated for this object.
     * @deprecated Use get_Handle() instead.
     */
    public String  getHandle()
    throws DatabaseManagerException {
        return get_Handle();
    }


    /**
     * The methods <CODE>
     *     get_Handle
     *     hasMatchingHandle

     *     findCachedObjectByHandle

     * </CODE> are used by Presentation Objects that need to populate
     * HTML select lists with Data Objects as options.
     * The <CODE>get_Handle()</CODE> method is used
     * to set the value for each option,
     * and the <CODE>hasMatchingHandle()<CODE>

     * methods are used to lookup the Data Object when the selection has
     * been made.
     *
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     *
     * @return id of this DO as a string
     *   If an object's id can't be allocated for this object.
     */
    public String  get_Handle()
    throws DatabaseManagerException {
        /*
        String ret = null;
        if ( null == get_OId() )
               throw new DatabaseManagerException( "ID not set " );
        ret = get_OId().toString();
        return ret;
        */
        if (null == __the_handle)
            throw new DatabaseManagerException( "ID not set " );
        return __the_handle;
    }

    /**
     * Returns cache handle.
     *
     * @return cache handle.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public String  get_CacheHandle()
    throws DatabaseManagerException {
        String ret = get_OriginDatabase() + "." + get_Handle();
        return ret;
    }

    /**
     * Created DO with specified OID.
     *
     * @param tablename, DO's table.
     * @param oid DO's oid.
     * @return copy of DO (with the same id).
     *
     * @exception SQLException
     * @exception ObjectIdException
     * @exception DataObjectException
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.

     * @deprecated Use createDO(String, ObjectId, DBTransaction) instead.

     */
    public static GenericDO createDO(String tablename, ObjectId oid) throws java.sql.SQLException, com.lutris.appserver.server.sql.ObjectIdException, com.lutris.dods.builder.generator.query.DataObjectException, com.lutris.appserver.server.sql.DatabaseManagerException{
        return new IndexDO(tablename, oid);
    }


    /**
     * Created DO with specified OID.
     *
     * @param tablename, DO's table.
     * @param oid DO's oid.
     * @param dbTrans The current database transaction.
     * @return copy of DO (with the same id).
     *
     * @exception SQLException
     * @exception ObjectIdException
     * @exception DataObjectException
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public static GenericDO createDO(String tablename, ObjectId oid, DBTransaction dbTrans) throws java.sql.SQLException, com.lutris.appserver.server.sql.ObjectIdException, com.lutris.dods.builder.generator.query.DataObjectException, com.lutris.appserver.server.sql.DatabaseManagerException{
        return new IndexDO(tablename, oid, dbTrans);
    }


   /**
     * Compare string version of the id of this DO and handle.
     *
     * @param handle
     *   <CODE>String</CODE> version of DO id.
     *
     * @return boolean
     *   True if the string version of the id of this DO matches passed handle.
     *
     * @see IndexDO#get_Handle() get_Handle
     */
    public boolean hasMatchingHandle( String handle ) {
        boolean ret = false;
        if (null == __the_handle) {
           return false;
        } else {
           //String thisHnadle = get_OId().toString();
           ret = __the_handle.equals( handle );
        }
        return ret;
    }


   /**
     * Get data object with key cacheHandle from the cache.
     *
     * @param cacheHandle
     *   <CODE>String</CODE> version of concatenation of:
     * name of the data object's database, followed by '.', followed by
     * data object's id.
     *
     * @return <CODE>IndexDO</CODE>
     *   Object if one is found in cache, otherwise null.
     *
     * @see IndexDO#get_Handle() get_Handle
     */
    public IndexDO findTransactionCachedObjectByHandle( String cacheHandle ){
        if ( null == cacheHandle )
            return null;
        if(get_transaction()!=null && _tr_(get_transaction()).getTransactionCache()!= null)
            return (IndexDO)_tr_(get_transaction()).getTransactionCache().getDOByHandle( cacheHandle );
        else
            return null;
    }

     /**
     * Get DataStruct object with key cacheHandle from the cache.
     *
     * @param tablename
     * @param cacheHandle
     *   <CODE>String</CODE> version of concatenation of:
     * name of the data object's database, followed by '.', followed by
     * data object's id.
     *
     * @return <CODE>IndexDataStruct</CODE>
     *   Object if one is found in cache, otherwise null.
     *
     * @see IndexDO#get_Handle() get_Handle
     */
    public static IndexDataStruct findCachedObjectByHandle( String tablename, String cacheHandle ){
        if ( null == cacheHandle )
            return null;
        return ( IndexDataStruct ) getCache(tablename).getDataStructByHandle( cacheHandle );
    }



    /**
     * Assigns the DataStruct of an existing DO to this DO.
     * Does not duplicate data. Just assigns the reference.
     *
     * @param orig The original DO.
     *
     */
    protected void makeIdentical( IndexDO orig ) {
        super.makeIdentical(orig);
        originalData = orig.originalData;
        data = orig.data;
    }

    /**
     * Return Data object's version.
     * @return Data object's version.
     */
    public int getVersion() {
        return get_Version();
    }

    /**
     * get_Version makes the protected method public in CoreDO.
     *
     * @return Data object's version.
     */
    public int get_Version() {
        return (null != data)?data.get_Version():super.get_Version();
    }

    /**
     * getNewVersion overloaded
     *
     * @return Data object's version.
     * @deprecated get_NewVersion()
     */
    public int getNewVersion() {
        if (null != data)
            return data.get_Version();
        else
            return super.get_Version();
    }

    /**
     * get_NewVersion overloaded
     *
     * @return Data object's version.
     */
    public int get_NewVersion() {
        if (null != data)
            return data.get_Version();
        else
            return super.get_Version();
    }

    /**
     * setVersion overloaded.
     * @param _ver DO's version.
     */
    public void setVersion(int _ver) {
         set_Version(_ver);
    }

    /**
     * set_Version overloaded.
     *
     * @param _ver DO's version.
     */
    public void set_Version(int _ver) {
        if(_ver < get_Version()) {
            new Throwable("WOW, ("+get_OId()+") oldVer:"+get_Version()+", new one is "+_ver).printStackTrace();
        } else if (null != data)
            data.set_Version(_ver);
        else
            super.set_Version(_ver);
    }

    /**
     * setNewVersion overloaded.
     *
     * @param _ver New DO's version.
     * @deprecated Use set_NewVersion
     */
    public void setNewVersion(int _ver){
        set_NewVersion(_ver);
    }

    /**
     * set_NewVersion overloaded.
     *
     * @param _ver Ignored.
     */
    public void set_NewVersion(int _ver){
        try {
            doTouch();
        } catch (Exception e) {
                DODS.getLogChannel().write(Logger.DEBUG," IndexDO class\n :"+" can't set new version ");
        }
    }

    // WebDocWf extension for writeable fully cached objects
    /**
     * Mark the object as read-only.
     *
     * WebDocWf extension
     *
     */
    public void makeReadOnly() {
        if (null != data) {
          try{
            checkDup();
          }catch(Exception ex) {
            DODS.getLogChannel().write(Logger.DEBUG, " MakeReadOnly failed: Database: "+get_OriginDatabase()+" IndexDO class, oid: "+get_OId()+", version: "+get_Version()+" \n");
            (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));
          }
        }
         data.readOnly = true;
    }

    /**
     * Mark the object as read-write.
     *
     * WebDocWf extension
     */
    public void makeReadWrite() {
        if (null != data) {
          try{
            checkDup();
          }catch(Exception ex) {
            DODS.getLogChannel().write(Logger.DEBUG, " MakeReadWrite failed: Database: "+get_OriginDatabase()+" IndexDO class, oid: "+get_OId()+", version: "+get_Version()+" \n");
            (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

          }
        }
         data.readOnly = false;
    }
    // end of WebDocWf extension for writeable fully cached objects

    // WebDocWf extension for writeable fully cached objects

    /**
     * Set reference objects.
     *
     * @param queryRefs Reference objects.
     */
    private void set_refs(HashMap queryRefs) {
        refs = queryRefs;
    }
    /**
     * Return Object with the handle key from reference objects HashMap.
     *
     * @param key DO's handle.
     * @return Object with the handle key from reference objects HashMap.
     */
    private Object getRefs(String key) {
        if(get_transaction()!=null && _tr_(get_transaction()).getTransactionCache()!= null) {
            return _tr_(get_transaction()).getTransactionCache().getDOByHandle(key);
        } else if (null == refs) {
            refs = new HashMap();
            return null;
        } else {
            return refs.get(key);
        }
    }
    /**
     * Add Object newRefs with the handle key to
     * reference objects HashMap.
     *
     * @param key DO's handle.
     * @param newRefs Object to be added.
     */
    private void addRefs(String key, Object newRefs) {
        if (null == refs) {
            refs = new HashMap();
        }
        refs.put(key, newRefs);
    }

    /**
     * Get reference objects.
     * @return HashMap with reference objects.
     */
    private HashMap get_refs() {
        return refs;
    }

    /**
     * Returns this object's identifier.
     * @return this object's identifier.
     */
    public ObjectId getOId() {
        return get_OId();
    }

    /**
     * Returns this object's identifier.
     * @return this object's identifier.
     */
    public ObjectId get_OId() {
        return get_DataStruct().get_OId();
    }

    /**
     * Sets this object's identifier.
     * @deprecated Use set_OId()
     * @param _oId this object's identifier.
     */
    protected void setOId(ObjectId _oId) {
        set_OId(_oId);
    }

    private String __the_handle;

    /**
     * Sets this object's identifier.
     * @param _oId this object's identifier.
     */
    protected void set_OId(ObjectId _oId) {
        if (get_DataStruct() == null)
            originalData = new IndexDataStruct();
             get_DataStruct().set_OId(_oId);
        __the_handle = _oId.toString();
    }

    /**
     * Creates a clone of the object, but ensures that
     * a new and unique object id is created for the object
     * and that the version number is set to zero.
     *
     * @return Cloned object.
     * @exception DatabaseManagerException if an error occurs while
     * allocation a new object id from the default logical database.
     * @exception ObjectIdException if a new object id could not be
     * allocated.
     */
    public synchronized Object cloneUnique()
        throws DatabaseManagerException, ObjectIdException {

        IndexDO _clone = new IndexDO (dbtablename, get_transaction());

        try {
            checkLoad();
            IndexDataStruct toClone = (null != get_Data())
                     ?(IndexDataStruct)get_Data()
                     :(IndexDataStruct)originalData_get();
            if (null != toClone) {
                _clone.set_Data(toClone.duplicate());
                ((IndexDataStruct)_clone.get_Data()).set_OId(((IndexDataStruct)_clone.originalData_get()).get_OId());
                ((IndexDataStruct)_clone.get_Data()).set_Version(0);
                changedFlags_set(true);
            }
        } catch (Exception e) {
            DODS.getLogChannel().write(Logger.DEBUG," cloneUnique failed: Database: "+get_OriginDatabase()+" IndexDO class, oid: "+get_Handle()+", version: "+get_Version()+" \n");
           (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

        }
        return _clone;
    }

    protected boolean deleted;

    /**
     * Returns the value of delete tag.
     * @return true if DO has been deleted, but not commited yet
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of delete tag.
     * @param flag true if DO has been deleted, but not commited yet.
     */
    public void setDeleted(boolean flag) {
        deleted = flag;
    }


    /**
     * If transaction succeeded marks this object as clean.
     * @param success true if the transaction succeeded
     *   and this object was successfully inserted into the database.
     */
    public void finalizeInsert(boolean success) {
        // on rollback reject inserted (createdVirgin) DO
        if (!success && !isPersistent())
            setDeleted(true);
        super.finalizeInsert(success);
        if (success)
            syncStructs(true);
    }

    /**
     * If transaction succeeded marks this object as clean.
     * @param success true if the transaction succeeded
     *   and this object was successfully updated in the database.
     */
    public void finalizeUpdate(boolean success) {
        super.finalizeUpdate(success);
        if (success)
            syncStructs(true);
    }

    /**
     * Currently does nothing.
     *
     * @param success true if the transaction succeeded
     *   and this object was successfully deleted from the
     *   database.
     */
    public void finalizeDelete(boolean success) {
        super.finalizeDelete(success);
        if (success) {
            deleteFromCache();
        }
    }

    /**
     * Method SyncStructs(boolean _updateCache).
     *
     * @param _updateCache boolean value.
     */
    private synchronized void syncStructs(boolean _updateCache) {
        if (null != data)
            originalData = data;
        data = null;
        changedFlags_set(false);
        ((IndexDataStruct)originalData).readOnly = true;
        if (_updateCache)
            updateCache();
    }

    /**
     * Returns information whether the DO is created virgin and hasn't been
     * commited yet.
     * @return true for DO that's created virgin and hasn't been commited yet.
     */
    public boolean isVirgin() {
        return !isPersistent();
    }

    /**
     * Make DO's data from cache visible.
     */
    public void makeVisible () {
        try {
            ((QueryCache)getCache()).makeVisible(get_CacheHandle());
        } catch (DatabaseManagerException dme) {
            System.err.println("makeVisible for "+super.toString()+"failed");
        }
    }

    /**
     * Make DO's  data from cache Invisible.
     */
    public void makeInvisible () {
        try {
            ((QueryCache)getCache()).makeInvisible(get_CacheHandle());
        } catch (DatabaseManagerException dme) {
            System.err.println("makeInvisible for "+super.toString()+"failed");
        }
    }

    /**
     * Inserts this object into the database.
     *
     * @param conn the database connection.
     * @exception java.sql.SQLException if a database access error occurs.
     * @exception DBRowUpdateException If a version error occurs.
     */
    public synchronized void executeInsert(DBConnection conn)
    throws SQLException, DBRowUpdateException {
        if (dirty) {
            super.executeInsert(conn);
            changedFlags_set(false);
        }
    }


    /**
     * Returns value for AutoSave.
     * @return true if AutoSave is on, otherwise false.
     */
    protected boolean isAutoSave()
    {
      boolean flag = false;
      try {
        flag = ((StandardLogicalDatabase)(DODS.getDatabaseManager().findLogicalDatabase(get_OriginDatabase()))).getDatabaseConfiguration().getAutoSave();
      } catch (Exception ex) {}
      return flag;
    }

    /**
     * Returns value for AutoSaveCreateVirgin.
     * @return true if AutoSaveCreateVirgin is on, otherwise false.
     */
    protected boolean isAutoSaveCreateVirgin()
    {
      boolean flag = false;
      try {
        flag = ((StandardLogicalDatabase)(DODS.getDatabaseManager().findLogicalDatabase(get_OriginDatabase()))).getDatabaseConfiguration().getAutoSaveCreateVirgin();
      } catch (Exception ex) {}
      return flag;
    }

    /**
     * Returns value for TransactionCheck.
     * @return true if TransactionCheck is on, otherwise false.
     */
    protected boolean isTransactionCheck()
    {
      boolean flag = false;
      try {
        flag = ((StandardLogicalDatabase)(DODS.getDatabaseManager().findLogicalDatabase(get_OriginDatabase()))).getDatabaseConfiguration().getTransactionCheck();
      } catch (Exception ex) {}
      return flag;
    }

    /**
     * Returns value for TransactionCaches.
     * @return true if TransactionCaches are on, otherwise false.
     */
    protected boolean isTransactionCaches()
    {
      boolean flag = false;
      try {
        flag = ((StandardLogicalDatabase)(DODS.getDatabaseManager().findLogicalDatabase(get_OriginDatabase()))).getDatabaseConfiguration().getTransactionCaches();
      } catch (Exception ex) {}
      return flag;
    }

    /**
     * Returns value for DeleteCheckVersion.
     * @return true if DeleteCheckVersion is on, otherwise false.
     */
    protected boolean isDeleteCheckVersion()
    {
      boolean flag = false;
      try {
        flag = ((StandardLogicalDatabase)(DODS.getDatabaseManager().findLogicalDatabase(this.get_OriginDatabase()))).getDatabaseConfiguration().getDeleteCheckVersion();
      } catch (Exception ex) {}
      return flag;
    }


    /**
     * Returns value for AllReadOnly.
     * @return true if AllReadOnly is on, otherwise false.
     */
    protected static boolean isAllReadOnly()
    {
      boolean flag = false;
      try {
        flag = ((StandardLogicalDatabase)(DODS.getDatabaseManager().findLogicalDatabase(get_logicalDBName()))).getDatabaseConfiguration().isAllReadOnly();
      } catch (Exception ex) {}
      return flag;
    }



     /**
     * Undo action.
     *
     * @exception DataObjectException
     */
    public void undo()throws com.lutris.dods.builder.generator.query.DataObjectException
    {
      try{
        if(null != transaction){
                if((data!=null) || (data==null && isDeleted())){
                        int tempVersion=get_Version();
                                if(isDeleted() && !isDeletedFromDatabase){
                                                unDelete(transaction);
                                }else if (isDeleted() && isDeletedFromDatabase){
                                        data =((IndexDataStruct)originalData).duplicate();
                                        set_Version(tempVersion);
                                        persistent=false;
                                        deleted=false;
                                        isDeletedFromDatabase=false;
                                        if (isAutoSave()) {
                            save(transaction,false);
                        }
                                }else{
                                        data =((IndexDataStruct)originalData).duplicate();
                                        set_Version(tempVersion);
                                        if ( isAutoSave()) {
                            save(transaction,false);
                        }
                                }
                }
        }else{
                        throw new DataObjectException("Error during Undo operation");
                }
      }catch(Exception ex){
                throw new DataObjectException("Error during Undo operation");
      }

    }

    /**
     * dumpData action.
     *
     * @param incrementVersion Increment version.
     */
    public void dumpData(boolean incrementVersion) {
        data = null;
        ObjectId _oid = get_OId();
        int _version = (incrementVersion?1:0)+ get_Version();
        originalData_set(new IndexDataStruct());
        set_OId(_oid);
        set_Version(_version);
    }
    /**
     * publicCreateExisting action.
     *
     * @param _tablename Table name.
     * @param _dbName Database name.
     * @param _oid DO's oid.
     * @param _refs Reference objects.
     * @param dbt Current transaction.
     * @return Created DO or null if doesn't exist.
     *
     * @exception SQLException
     * @exception ObjectIdException
     * @exception DataObjectException
     * @exception DatabaseManagerException
     */
    private static IndexDO publicCreateExisting(String _tablename, String _dbName, BigDecimal _oid, HashMap _refs, DBTransaction dbt)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        if (null == _oid)
            return null;
        if (null == _dbName)
            _dbName = get_logicalDBName();
        IndexQuery qry = new IndexQuery(_tablename, dbt);
        qry.setLogicalDatabase(_dbName);
        if (null != _refs) {
            qry.setRefs(_refs);
        }
        qry.setQueryOId(new ObjectId(_oid));
        qry.requireUniqueInstance();
        try {
            return qry.getNextDO();
        } catch (com.lutris.dods.builder.generator.query.NonUniqueQueryException nuqe) {
            throw new DataObjectException("Query didn't give unique result.");
        }
    }


    ////////////////////////// data member Key

    /**
     * static final RDBColumn Key for use with QueryBuilder.
     * See RDBColumn PrimaryKey at the top of this file for usage example.
     */
    //static public final RDBColumn Key = new RDBColumn( table, "key", false);
    public static RDBColumn getKeyColumn(String dbtable) {
         RDBTable  table = new RDBTable(dbtable);
		 return new RDBColumn( table, "key", false );
	 }

    private boolean changedKey = false;

    /**
     * Use for query caching.
     */
    static public final int COLUMN_KEY = 0;
    static public final int key_MaxLength = 255;

    /**
     * Get key of the index.
     *
     * @return key of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getKey ()
    throws DataObjectException {
        checkLoad();
        
        return get_DataStruct().getKey();
    }


    /**
     * Get original key of the index.
     *
     * @return key of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String originalData_getKey ()
    throws DataObjectException {
        checkLoad();
        return ((IndexDataStruct)originalData_get()).getKey();
    }



    /**
     * Set key of the index.
     *
     * @param key of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setKey ( String key )
    throws DataObjectException {
        _setKey ( key );
    }
    
    /**
     * _setKey is a protected method that is called by
     * setKey if key is not part of
     * a multicolumn foreign key.
     *
     * @param key of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    protected void _setKey ( String key )
    throws DataObjectException {
        checkLoad();
        
        try {
            checkDup();
        } catch (Exception e) {
            throw new DataObjectException ("Coudn't duplicate DataStruct:", e);
        }
        if (data.isEmpty)
            data.isEmpty = false;
        data.setKey(markNewValue(get_DataStruct().getKey(),  key, 0, key_MaxLength, true));
        changedKey |= colChanged;
        if (changedKey) {
            if (autoSaveAllowed&&isAutoSave()&&null != transaction) {
                try {
                    save(transaction,false);
                } catch (Exception ex) {
                    throw new DataObjectException("Error during transaction's writting data into database",ex);
                }
            }
        }
    }




    ////////////////////////// data member Lang

    /**
     * static final RDBColumn Lang for use with QueryBuilder.
     * See RDBColumn PrimaryKey at the top of this file for usage example.
     */
    //static public final RDBColumn Lang = new RDBColumn( table, "lang", false);
    public static RDBColumn getLangColumn(String dbtable) {
         RDBTable  table = new RDBTable(dbtable);
		 return new RDBColumn( table, "lang", false );
	 }

    private boolean changedLang = false;

    /**
     * Use for query caching.
     */
    static public final int COLUMN_LANG = 1;
    static public final int lang_MaxLength = 3;

    /**
     * Get lang of the index.
     *
     * @return lang of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getLang ()
    throws DataObjectException {
        checkLoad();
        
        return get_DataStruct().getLang();
    }


    /**
     * Get original lang of the index.
     *
     * @return lang of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String originalData_getLang ()
    throws DataObjectException {
        checkLoad();
        return ((IndexDataStruct)originalData_get()).getLang();
    }



    /**
     * Set lang of the index.
     *
     * @param lang of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLang ( String lang )
    throws DataObjectException {
        _setLang ( lang );
    }
    
    /**
     * _setLang is a protected method that is called by
     * setLang if lang is not part of
     * a multicolumn foreign key.
     *
     * @param lang of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    protected void _setLang ( String lang )
    throws DataObjectException {
        checkLoad();
        
        try {
            checkDup();
        } catch (Exception e) {
            throw new DataObjectException ("Coudn't duplicate DataStruct:", e);
        }
        if (data.isEmpty)
            data.isEmpty = false;
        data.setLang(markNewValue(get_DataStruct().getLang(),  lang, 0, lang_MaxLength, true));
        changedLang |= colChanged;
        if (changedLang) {
            if (autoSaveAllowed&&isAutoSave()&&null != transaction) {
                try {
                    save(transaction,false);
                } catch (Exception ex) {
                    throw new DataObjectException("Error during transaction's writting data into database",ex);
                }
            }
        }
    }




    ////////////////////////// data member Value

    /**
     * static final RDBColumn Value for use with QueryBuilder.
     * See RDBColumn PrimaryKey at the top of this file for usage example.
     */
    //static public final RDBColumn Value = new RDBColumn( table, "value", false);
    public static RDBColumn getValueColumn(String dbtable) {
         RDBTable  table = new RDBTable(dbtable);
		 return new RDBColumn( table, "value", false );
	 }

    private boolean changedValue = false;

    /**
     * Use for query caching.
     */
    static public final int COLUMN_VALUE = 2;
    static public final int value_MaxLength = 255;

    /**
     * Get value of the index.
     *
     * @return value of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getValue ()
    throws DataObjectException {
        checkLoad();
        
        return get_DataStruct().getValue();
    }


    /**
     * Get original value of the index.
     *
     * @return value of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String originalData_getValue ()
    throws DataObjectException {
        checkLoad();
        return ((IndexDataStruct)originalData_get()).getValue();
    }



    /**
     * Set value of the index.
     *
     * @param value of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setValue ( String value )
    throws DataObjectException {
        _setValue ( value );
    }
    
    /**
     * _setValue is a protected method that is called by
     * setValue if value is not part of
     * a multicolumn foreign key.
     *
     * @param value of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    protected void _setValue ( String value )
    throws DataObjectException {
        checkLoad();
        
        try {
            checkDup();
        } catch (Exception e) {
            throw new DataObjectException ("Coudn't duplicate DataStruct:", e);
        }
        if (data.isEmpty)
            data.isEmpty = false;
        data.setValue(markNewValue(get_DataStruct().getValue(),  value, 0, value_MaxLength, true));
        changedValue |= colChanged;
        if (changedValue) {
            if (autoSaveAllowed&&isAutoSave()&&null != transaction) {
                try {
                    save(transaction,false);
                } catch (Exception ex) {
                    throw new DataObjectException("Error during transaction's writting data into database",ex);
                }
            }
        }
    }




    ////////////////////////// data member Msort

    /**
     * static final RDBColumn Msort for use with QueryBuilder.
     * See RDBColumn PrimaryKey at the top of this file for usage example.
     */
    //static public final RDBColumn Msort = new RDBColumn( table, "msort", false);
    public static RDBColumn getMsortColumn(String dbtable) {
         RDBTable  table = new RDBTable(dbtable);
		 return new RDBColumn( table, "msort", false );
	 }

    private boolean changedMsort = false;

    /**
     * Use for query caching.
     */
    static public final int COLUMN_MSORT = 3;
    static public final int msort_MaxLength = 255;

    /**
     * Get msort of the index.
     *
     * @return msort of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getMsort ()
    throws DataObjectException {
        checkLoad();
        
        return get_DataStruct().getMsort();
    }


    /**
     * Get original msort of the index.
     *
     * @return msort of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String originalData_getMsort ()
    throws DataObjectException {
        checkLoad();
        return ((IndexDataStruct)originalData_get()).getMsort();
    }



    /**
     * Set msort of the index.
     *
     * @param msort of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setMsort ( String msort )
    throws DataObjectException {
        _setMsort ( msort );
    }
    
    /**
     * _setMsort is a protected method that is called by
     * setMsort if msort is not part of
     * a multicolumn foreign key.
     *
     * @param msort of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    protected void _setMsort ( String msort )
    throws DataObjectException {
        checkLoad();
        
        try {
            checkDup();
        } catch (Exception e) {
            throw new DataObjectException ("Coudn't duplicate DataStruct:", e);
        }
        if (data.isEmpty)
            data.isEmpty = false;
        data.setMsort(markNewValue(get_DataStruct().getMsort(),  msort, 0, msort_MaxLength, true));
        changedMsort |= colChanged;
        if (changedMsort) {
            if (autoSaveAllowed&&isAutoSave()&&null != transaction) {
                try {
                    save(transaction,false);
                } catch (Exception ex) {
                    throw new DataObjectException("Error during transaction's writting data into database",ex);
                }
            }
        }
    }




    ////////////////////////// data member EntryId

    /**
     * static final RDBColumn EntryId for use with QueryBuilder.
     * See RDBColumn PrimaryKey at the top of this file for usage example.
     */
    //static public final RDBColumn EntryId = new RDBColumn( table, "entryId", true);
    public static RDBColumn getEntryIdColumn(String dbtable) {
         RDBTable  table = new RDBTable(dbtable);
		 return new RDBColumn( table, "entryId", false );
	 }

    private boolean changedEntryId = false;

    /**
     * Use for query caching.
     */
    static public final int COLUMN_ENTRYID = 4;
    

    /**
     * Get entryId of the index.
     *
     * @return entryId of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public int getEntryId ()
    throws DataObjectException {
        checkLoad();
        
        return get_DataStruct().getEntryId();
    }


    /**
     * Get original entryId of the index.
     *
     * @return entryId of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public int originalData_getEntryId ()
    throws DataObjectException {
        checkLoad();
        return ((IndexDataStruct)originalData_get()).getEntryId();
    }



    /**
     * Set entryId of the index.
     *
     * @param entryId of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setEntryId ( int entryId )
    throws DataObjectException {
        _setEntryId ( entryId );
    }
    
    /**
     * _setEntryId is a protected method that is called by
     * setEntryId if entryId is not part of
     * a multicolumn foreign key.
     *
     * @param entryId of the index.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    protected void _setEntryId ( int entryId )
    throws DataObjectException {
        checkLoad();
        
        try {
            checkDup();
        } catch (Exception e) {
            throw new DataObjectException ("Coudn't duplicate DataStruct:", e);
        }
        if (data.isEmpty)
            data.isEmpty = false;
        data.setEntryId(markNewValue(get_DataStruct().getEntryId(),  entryId));
        changedEntryId |= colChanged;
        if (changedEntryId) {
            if (autoSaveAllowed&&isAutoSave()&&null != transaction) {
                try {
                    save(transaction,false);
                } catch (Exception ex) {
                    throw new DataObjectException("Error during transaction's writting data into database",ex);
                }
            }
        }
    }



    /**
     * Compares whether this DO satisfies condition cond.
     *
     * @param cond condition.
     * 
     * @return true if DO satisfies condition cond, otherwise false.
     */
    public boolean compareCond(Condition cond) {
        try {
            switch(cond.getColumnIndex()) {
        case COLUMN_KEY:
                    
                     return QueryBuilder.compare(getKey(),cond.getValue(),cond.getOperator());
        case COLUMN_LANG:
                    
                     return QueryBuilder.compare(getLang(),cond.getValue(),cond.getOperator());
        case COLUMN_VALUE:
                    
                     return QueryBuilder.compare(getValue(),cond.getValue(),cond.getOperator());
        case COLUMN_MSORT:
                    
                     return QueryBuilder.compare(getMsort(),cond.getValue(),cond.getOperator());
        case COLUMN_ENTRYID:
                    
                     return QueryBuilder.compare(getEntryId(),cond.getValue(),cond.getOperator());
            }
        } catch (Exception e) {
        }
        return false;
    }

    static {
    }

    /**
     * logicalDbName is logical database name
     * set by setLogicalDBName()
     * and retrieved by get_logicalDBName().
     */
    static private String logicalDbName = null;

    /**
     * setLogicalDBName sets the logical database name that will be used
     * to create DBTransaction and DBQuery objects used by
     * IndexDO and the corresponding Query class.
     * 
     * @param logicalDbNameInConfFile The logical database specified in the
     * application's .conf file.
     *
     * @deprecated It is dangeruous to use this method in multiuser environment because, 
     * this setings are applied to all users (sets logical database to all users)
     */
    static public synchronized void setLogicalDBName( String logicalDbNameInConfFile ) {
        if ( null != logicalDbNameInConfFile && 0    != logicalDbNameInConfFile.length() )
            logicalDbName = logicalDbNameInConfFile;
        else 
            logicalDbName = DODS.getDatabaseManager().getDefaultDB();
    }
    
    /**
     * get_logicalDBName retrieves the logical database name 
     * set by setLogicalDBName().
     *
     * @return the logical database name that was set by method setLogicalDBName()
     *
     */
    static public synchronized String get_logicalDBName() {
        if (logicalDbName == null)
            logicalDbName = DODS.getDatabaseManager().getDefaultDB();                    
        return logicalDbName;
    }

    /**
     * createTransaction() creates a new DBTransaction.
     * This method uses the logical database name set by method setLogicalDBName().
     *
     * If setLogicalDBName() was used to set the logical database name
     * to something other than the value of DatabaseManager.DefaultDatabase
     * in the application's .conf file, then any DBTransaction passed to 
     * save(DBTransaction) or delete(DBTransaction) should be created using 
     * IndexDO.createTransaction().
     *
     * The IndexDO save() and delete() methods use this method.
     *
     * @return A DBTransaction object to use with the IndexDO class.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    static public DBTransaction createTransaction() 
    throws DatabaseManagerException, SQLException {
        DBTransaction ret;
        try {
            ret = DODS.getDatabaseManager().createTransaction(get_logicalDBName());
            ret.setDatabaseName(get_logicalDBName());
            return ret;
        } catch ( DatabaseManagerException e ) { 
            String err = "";
            if ( null != get_logicalDBName() )
                err = "ERROR: Could not create a DBTransaction.  " +
                      "IndexDO.logicalDbName='" + get_logicalDBName() + "'.  "+
                      "The application .conf file must list this name in " +
                      "DatabaseManager.Databases[], and there must be " +
                      "DatabaseManager.DB." + get_logicalDBName() + " settings.";
            throw new DatabaseManagerException( err, e );
        }
    }
    

    /**
     * createQuery() creates a new DBQuery.
     * This method uses the logical database name set by method setLogicalDBName().
     *
     * If setLogicalDBName() was used to set the logical database name
     * to something other than the value of DatabaseManager.DefaultDatabase
     * in the application's .conf file, then any DBQuery object used to 
     * access the 'index' table should be created using 
     * IndexDO.createQuery().
     *
     * The Query class corresponding to IndexDO uses this method.
     *
     * @return A DBQuery object to use in accessing the 'index' table.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.

     * @deprecated Use createQuery(DBTransaction) instead.          
     */
    static public DBQuery createQuery() 
    throws DatabaseManagerException, SQLException {
        try {
	 	return DODS.getDatabaseManager().createQuery(get_logicalDBName());
        } catch ( DatabaseManagerException e ) { 
            String err = "";
            if ( null != get_logicalDBName() )
                err = "ERROR: Could not create a DBQuery.  " +
                      "IndexDO.logicalDBName='" + get_logicalDBName() + "'.  "+
                      "The application .conf file must list this name in " +
                      "DatabaseManager.Databases[], and there must be " +
                      "DatabaseManager.DB." + get_logicalDBName() + " settings.";
            throw new DatabaseManagerException( err, e );
        }
    }


    /**
     * createQuery() creates a new DBQuery.
     * This method uses the logical database name set by method setLogicalDBName().
     *
     * If setLogicalDBName() was used to set the logical database name
     * to something other than the value of DatabaseManager.DefaultDatabase
     * in the application's .conf file, then any DBQuery object used to 
     * access the 'index' table should be created using 
     * IndexDO.createQuery().
     *
     * The Query class corresponding to IndexDO uses this method.
     *
     * @param trans DBTransaction
     * @return A DBQuery object to use in accessing the 'index' table.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    static public DBQuery createQuery(DBTransaction trans) 
    throws DatabaseManagerException, SQLException {

        try {
	 	return (null==trans)?createQuery():trans.createQuery();
        } catch ( DatabaseManagerException e ) { 
            String err = "";
            if ( null != get_logicalDBName() )
                err = "ERROR: Could not create a DBQuery.  " +
                      "IndexDO.logicalDBName='" + get_logicalDBName() + "'.  "+
                      "The application .conf file must list this name in " +
                      "DatabaseManager.Databases[], and there must be " +
                      "DatabaseManager.DB." + get_logicalDBName() + " settings.";
            throw new DatabaseManagerException( err, e );
        }
    }


    /**
     * Protected constructor.
     *
     * @param rs Result set from which to obtain product data.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected IndexDO(String tablename, ResultSet rs)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        super(rs);
		this.dbtablename = tablename;
        initFromResultSet( rs );
        originDatabase = get_logicalDBName();
        get_DataStruct().set_Database(originDatabase);
        set_OId(new ObjectId(rs.getBigDecimal(get_OIdColumnName())));
    	if ( versioning )
       	    set_Version(rs.getInt(get_versionColumnName()));
        if(isTransactionCheck()) {
            DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created : Database: "+get_OriginDatabase()+" IndexDO class, oid: "+get_Handle()+", version: "+get_Version()+" \n");
            (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));
            
        }    
    }

    /**
     * Protected constructor.
     *
     * @param rs Result set from which to obtain product data.
     * @param queryRefs Reference objects.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected IndexDO(String tablename, ResultSet rs, HashMap queryRefs)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        this(tablename, rs,queryRefs,null);
    }

    /**
     * Protected constructor.
     *
     * @param rs Result set from which to obtain product data.
     * @param queryRefs Reference objects.
     * @param dbTrans DBTransaction object.
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected IndexDO(String tablename, ResultSet rs, HashMap queryRefs, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        super(rs);
		this.dbtablename = tablename;
        set_refs(queryRefs);
	setTransaction(dbTrans);
        initFromResultSet( rs );
        if(dbTrans!=null)
            originDatabase = dbTrans.getDatabaseName();
        if(originDatabase==null)    
           originDatabase = get_logicalDBName();
        get_DataStruct().set_Database(originDatabase);
        addToTransactionCache();
        if(dbTrans!=null)
            dbTrans.lockDO(this);
    }    

    /**
     * Protected constructor.
     *
     * @param rs Result set from which to obtain product data.
     * @param dbTrans The current database transaction
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    protected IndexDO(String tablename, ResultSet rs, DBTransaction dbTrans)
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        this(tablename, rs, null, dbTrans);
    }
    
    



    /**
     * while in initFromResultSet, auto save can't be allowed
     */
    private boolean autoSaveAllowed = true;

    /**
     * initFromResultSet initializes the data members of index.
     * This code was separated from the ResultSet constructor
     * so that createExisting(ResultSet) could handle VIEWs.
     *
     * @param rs ResultSet from which data members are initialized.
     * @exception DataObjectException
     *   If the object is not found in the database.
     * @exception com.lutris.appserver.server.sql.ObjectIdException
     *   If an object's id can't be allocated for this object.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    private void initFromResultSet( ResultSet rs )
    throws SQLException, ObjectIdException, DataObjectException, DatabaseManagerException {
        autoSaveAllowed = false;
        // Constructing a DO from a ResultSet means we definitely need the 
        // DataStruct ready for the setXxx methods invoked below.
        if (null == get_DataStruct())
            originalData = new IndexDataStruct ();
	get_DataStruct().isEmpty = false; 
        // writeMemberStuff uses the ResultSetExtraction.template
        // to build up the value for this tag:
        // the value is a series of calls to the DO set methods.
        
        if ( versioning )set_Version(rs.getInt(get_versionColumnName()));
         setKey( rs.getString( "key"  ) );
         setLang( rs.getString( "lang"  ) );
         setValue( rs.getString( "value"  ) );
         setMsort( rs.getString( "msort"  ) );
         setEntryId( rs.getInt( "entryId"  ) );

        get_DataStruct().isEmpty = false;
        setPersistent(true);
        markClean();
        syncStructs(false);
//        refs = null;
        autoSaveAllowed = true;
    }

    	public static String getColumnsNameString(String dbtblname){
        String columnsNameString = null;
        
    	if(useOrderedWithTable==null){
    		columnsNameString=dbtblname+".*";
    	}else{
			columnsNameString = "";
   		String tableName;
			if (useOrderedWithTable.booleanValue()){
				tableName="@T@_"+dbtblname+"_@@.";
			}else{
				tableName="@F@_"+dbtblname+"_@@.";
			}
			String oidStr = IndexDO.get_OIdColumnName();
			String verStr = IndexDO.get_versionColumnName();
			columnsNameString = tableName+oidStr+", " ;
			if ( versioning ) {
				columnsNameString +=tableName+verStr+", ";
			}

			columnsNameString += tableName + "key, ";

			columnsNameString += tableName + "lang, ";

			columnsNameString += tableName + "value, ";

			columnsNameString += tableName + "msort, ";

			columnsNameString += tableName + "entryId, ";

			if ( versioning ) {
				columnsNameString += tableName + verStr ;
			}else{
				columnsNameString = columnsNameString.substring(0,columnsNameString.length()-2);
			}
		}
        return columnsNameString;
	}


    private int[] param = null;
    private boolean isDeletedFromDatabase = false;
    /**
     * Prepares the statement used to insert this object
     * into the database.
     *
     * @param conn The database connection.
     *
     * @return The insert statement.
     *
     * @exception java.sql.SQLException if an error occurs.
     */
    public PreparedStatement getInsertStatement(DBConnection conn)
    throws SQLException {
        ObjectId oid;
    
	if (isDeletedFromDatabase) 
            throw new SQLException("Object "+get_OId()+" is already deleted");

        PreparedStatement stmt = conn.prepareStatement(  
            "insert into " + this.dbtablename + " ( key, lang, value, msort, entryId, " + get_OIdColumnName() + ", " + get_versionColumnName() + " )" +
            "values ( ?, ?, ?, ?, ?, ?, ? )" 
        );

        param = new int[1]; param[0] = 1;
        // writeMemberStuff uses the JDBCsetCalls.template
        // to build up the value for this tag:
        // the value is a series of calls to setPrepStmtParam_TYPE methods.
        // Those methods are defined in GenericDO.
        try {
            setPrepStmtParam_String ( stmt, param, getKey());
            setPrepStmtParam_String ( stmt, param, getLang());
            setPrepStmtParam_String ( stmt, param, getValue());
            setPrepStmtParam_String ( stmt, param, getMsort());
            setPrepStmtParam_int ( stmt, param, getEntryId());

            /* The ObjecId/Version columns form the primary key.  */
            setPrepStmtParam_BigDecimal( stmt, param, get_OId().toBigDecimal() );
            setPrepStmtParam_int( stmt, param, get_NewVersion() );

        } catch ( Exception e ) {
            throw new SQLException( "Data Object error: " + e.getMessage() );
        }
        get_statistics(this.dbtablename).incrementInsertNum();
        return stmt;
    }


    /**
     *
     */
    private boolean _lockDO = false;

    /**
     * Specifies whether to lock this DO (row) in database just before commit.
     * Locking is attempted via "dummy" update:
     * "update set version=OLD_ONE where OID=X and version=OLD_ONE".
     * @param value true for locking, false otherwise
     */
    public void doCheck(boolean value) {
        _lockDO = value;
    }

    /**
     * Locks this DO in database by performing
     * "update set version=OLD_ONE where OID=X and version=OLD_ONE".
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     */
    public void doLock() throws SQLException {
        if (null!=transaction) {
            incrementVersionToo = false;
            boolean _ol = _lockDO;
            _lockDO = true;
            transaction.lockDO(this);
            _lockDO = _ol;
        }
    }

    private boolean incrementVersionToo = true;
    /**
     * Locks this DO in database by performing
     * "update set version=INCREMENTED where OID=X and version=OLD_ONE".
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     * @exception SQLException
     *   If the database rejects the SQL generated to retrieve data
     *   for this object, or if the table contains a bad foreign key, etc.
     * @exception ObjectIdException
     * @exception DataObjectException
     */
    public void doTouch() 
    throws SQLException, DatabaseManagerException, 
    com.lutris.appserver.server.sql.ObjectIdException, DataObjectException {
        if (null!=transaction) {
	    checkLoad();
	    checkDup();
  	    markNewValue();
            incrementVersionToo = true;
            boolean _ol = _lockDO;
            _lockDO = true;
            transaction.lockDO(this);
            _lockDO = _ol;
        }
    }

    /**
     * Prepares and executes the statement used to lock this object
     * in the database.
     *
     * @param conn The database connection
     *
     * @exception java.sql.SQLException if an error occurs.
     */
    public void executeLockingStatement(DBConnection conn) throws SQLException {
        if (!_lockDO)
            return;
        StringBuffer updateStmt = new StringBuffer();
        PreparedStatement stmt = null;
        if (isDeletedFromDatabase)
            throw new SQLException(this.dbtablename + " ("
					+get_OId()+") is already deleted, "
					+"cannot lock it.");

        param = new int[1]; param[0] = 1;
        try {
            updateStmt.append("Update " + this.dbtablename + " set ");
            updateStmt.append(get_versionColumnName()).append(" = ? ");
            updateStmt.append(" where " + get_OIdColumnName() + " = ? and " + get_versionColumnName() + " = ?");

            stmt = conn.prepareStatement(updateStmt.toString());
            setPrepStmtParam_int(stmt, param, get_Version()+(incrementVersionToo?1:0));
            setPrepStmtParam_BigDecimal( stmt, param, get_OId().toBigDecimal() );
            setPrepStmtParam_int(stmt, param, get_Version());
            if (null != stmt) {
	        conn.executeUpdate(stmt, "execute update");
                if (incrementVersionToo) {
                    set_Version(get_Version()+1);
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new SQLException( "Data Object error: " + e.getMessage() );
        }
    }


    /**
     * Prepares the statement used to update this object
     * in the database.
     *
     * @param conn The database connection
     *
     * @return The update statement.
     *
     * @exception java.sql.SQLException if an error occurs.
     */
    public PreparedStatement getUpdateStatement(DBConnection conn)
    throws SQLException {
        StringBuffer updateStmt = new StringBuffer();
        PreparedStatement stmt;

	     if (isDeletedFromDatabase)
            throw new SQLException("Object "+get_OId()+" is already deleted");

        data.set_Version(get_Version()+1);
        param = new int[1]; param[0] = 1;
        try {
            updateStmt.append("Update " + this.dbtablename + " set ");
            updateStmt.append(get_versionColumnName()).append(" = ? ");

            if (changedKey)
                updateStmt.append(", Key = ? ");
            if (changedLang)
                updateStmt.append(", Lang = ? ");
            if (changedValue)
                updateStmt.append(", Value = ? ");
            if (changedMsort)
                updateStmt.append(", Msort = ? ");
            if (changedEntryId)
                updateStmt.append(", EntryId = ? ");
            updateStmt.append(" where " + get_OIdColumnName() + " = ? and " + get_versionColumnName() + " = ?");

            stmt = conn.prepareStatement(updateStmt.toString());
            setPrepStmtParam_int(stmt, param, get_Version());

            if (changedKey) {
                setPrepStmtParam_String( stmt, param, getKey());
                changedKey = false;
            }
            if (changedLang) {
                setPrepStmtParam_String( stmt, param, getLang());
                changedLang = false;
            }
            if (changedValue) {
                setPrepStmtParam_String( stmt, param, getValue());
                changedValue = false;
            }
            if (changedMsort) {
                setPrepStmtParam_String( stmt, param, getMsort());
                changedMsort = false;
            }
            if (changedEntryId) {
                setPrepStmtParam_int( stmt, param, getEntryId());
                changedEntryId = false;
            }
            setPrepStmtParam_BigDecimal( stmt, param, get_OId().toBigDecimal() );
            setPrepStmtParam_int(stmt, param, get_Version() - 1);
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new SQLException( "Data Object error: " + e.getMessage() );
        }
        get_statistics(this.dbtablename).incrementUpdateNum();
        return stmt;
    }

    /**
     * Prepares the statement used to delete this object
     * from the database.
     *
     * @param conn The database connection
     *
     * @return The delete statement.
     *
     * @exception java.sql.SQLException if an error occurs.
     */
    public PreparedStatement getDeleteStatement(DBConnection conn)
    throws SQLException {
        String sql="";
        if(isDeleteCheckVersion())
            sql =
            "delete from " + this.dbtablename + " \n" +
            "where " + get_OIdColumnName() + " = ? and " + get_versionColumnName() + " = ?";
        else    
            sql =
            "delete from " + this.dbtablename + "\n" +
            "where " + get_OIdColumnName() + " = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setBigDecimal(1, get_OId().toBigDecimal());
        if(isDeleteCheckVersion()) {
            stmt.setInt(2, get_Version());
        }
        get_statistics(this.dbtablename).incrementDeleteNum();
        isDeletedFromDatabase = true;
        return stmt;
    }
    


    /*
     * toString - for debugging
     *
     * @return String for debugging.
     *
     */
    public String toString(){
        return toString( 1 );
    }

    public String toString( int indentCount ){
        String indent = "";
        for ( int i = 0; i < indentCount; i++ ) {
            indent += ". ";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(indent + "IndexDO:");

        ObjectId oid = get_OId();
        String id = "virgin";
        if ( null != oid )
            id = oid.toString();
        sb.append(" OID=" + id + ",VERSION=" + get_Version());
        if (isLoaded()) {    
                sb.append("\n" + indent + "key=" + get_DataStruct().getKey());
    
                sb.append("\n" + indent + "lang=" + get_DataStruct().getLang());
    
                sb.append("\n" + indent + "value=" + get_DataStruct().getValue());
    
                sb.append("\n" + indent + "msort=" + get_DataStruct().getMsort());
    
                sb.append("\n" + indent + "entryId=" + get_DataStruct().getEntryId());
;
            sb.append("\n" + indent + "SUPER=" + super.toString( indentCount ));
        }
        return sb.toString(); 
    }

    /**
     * A stub method for implementing pre-commit assertions 
     * for this IndexDO.
     * Implement this stub to throw an RefAssertionException for cases
     * where this object is not valid for writing to the database.
     * @exception RefAssertionException
     */
    protected void okToCommit() 
    throws RefAssertionException { 
    }

    /**
     * A stub method for implementing pre-delete assertions 
     * for this IndexDO.
     * Implement this stub to throw an RefAssertionException for cases
     * where this object is not valid for deletion from the database.
     * @exception RefAssertionException
     */
    protected void okToDelete() throws RefAssertionException {  }

    /**
     * Inserts/Updates the DO into its table.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     *
     * @deprecated Use save() instead.
     */
    public void commit() 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        commit(null);
    }

    /**
     * Inserts/Updates the DO into its table.
     * The transaction is likely provided by the commit() method of another DO
     * which references this DO.
     * 
     * @param dbt The transaction object used for this operation.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     *
     * @deprecated Use save() instead.
     */
    public void commit(DBTransaction dbt)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        if (getCache().getTableConfiguration().isReadOnly())
            throw new AssertionDataObjectException("IndexDO's cache is read-only. Therefore, DML opertions are not allowed.");
        // WebDocWf extension for generic store
        try { 
            DBTransaction dbtlocal = dbt;
            boolean needToCommit = false;
            if (dbtlocal == null) {
               if( get_transaction()==null) {
                  dbtlocal = DODS.getDatabaseManager().createTransaction(get_OriginDatabase());
                  dbtlocal.setDatabaseName(get_OriginDatabase());
                  needToCommit = true;
               }else 
                  dbtlocal=transaction;
            } else {
                if(get_transaction()!=null) {
                   if(!get_transaction().equals(dbt))
                         throw new DatabaseManagerException("DO doesn't belong this transaction.");
                }
            }
            modifyDO( dbtlocal, false );
            if (needToCommit) {
                dbtlocal.commit();
                dbtlocal.release();
            }
        } catch (DataObjectException e) {
            modifyDO( dbt, false ); 
        } 
        // end of WebDocWf extension for generic store
    }

    /**
     * Inserts/Updates the DO into its table.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     * 
     * WebDocWf extension
     */
    public void save() 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        save(get_transaction(),true);
    }

    /**
     * Inserts/Updates the DO into its table.
     *
     * @param references True if references should be saved with this DO.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     * 
     * WebDocWf extension
     */
    public void save(boolean references) 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        save(get_transaction(),references);
    }

    /**
     * Inserts/Updates the DO into its table.
     * The transaction is likely provided by the commit() method of another DO
     * which references this DO.
     * 
     * @param dbt The transaction object used for this operation.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     * 
     * WebDocWf extension
     */
    public void save(DBTransaction dbt)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        save(dbt, true);
    }

    /**
     * Inserts/Updates the DO into its table.
     * The transaction is likely provided by the commit() method of another DO
     * which references this DO.
     * 
     * @param dbt The transaction object used for this operation.
     * @param references True if references of this DO should be saved.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     * 
     * WebDocWf extension
     */
    public void save(DBTransaction dbt, boolean references)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        if (getCache().getTableConfiguration().isReadOnly()) {
            throw new AssertionDataObjectException("IndexDO's cache is read-only. Therefore, DML opertions are not allowed.");
        }    
        // before: modifyDO( dbt, false );
        // The following line has been inserted:
        try {  
            // WebDocWf extension for generic store
            // The following line has been inserted:
            DBTransaction dbtlocal = dbt;
            boolean needToCommit = false;

            if (dbtlocal == null) {
              if( get_transaction()==null) {
                dbtlocal = DODS.getDatabaseManager().createTransaction(get_OriginDatabase());
                dbtlocal.setDatabaseName(get_OriginDatabase());
                needToCommit = true;
              }
             else 
                dbtlocal=transaction;
            } else {
                if(get_transaction()!=null) {
                    if(!get_transaction().equals(dbt))
                          throw new DatabaseManagerException("DO doesn't belong this transaction.");
                }
            }

            // The following line has been changed:
            modifyDO( dbtlocal, false, references );
            if (needToCommit) {
                dbtlocal.commit();
                dbtlocal.release();
            }
        } catch (DataObjectException e) {
            modifyDO( dbt, false );
        }  
        // end of WebDocWf extension for generic store
    }

    /**
     * Deletes the DO from its table.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     */
    public void delete() 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        delete(get_transaction(), true);
    }


	/**
	 * Deletes the DO from its table.
	 *
     * @param dbt The transaction object used for this operation.
	 *
	 * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
	 * @exception RefAssertionException Thrown by okTo method.
	 * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
	 */
	public void delete(DBTransaction dbt) 
	throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
		delete(dbt,true);
	}


    /**
     * UnDeletes the DO and inserts to the table.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     */
    public void unDelete() 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        unDelete(get_transaction());
    }
    
    /**
     * Deletes the DO from its table.
     * The transaction is likely provided by the delete() method of another DO
     * which references this DO. 
     * NOTE : This method is only for DODS internal usage.
     * @param dbt The transaction object used for this operation.
     * @param rootDO Is DO root in DELETE CASCADE sekvence
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     */
    public void delete(DBTransaction dbt, boolean rootDO)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        isRootDeleteNode = rootDO ;
        if (getCache().getTableConfiguration().isReadOnly())
            throw new AssertionDataObjectException("IndexDO's cache is read-only. Therefore, DML opertions are not allowed.");
        // WebDocWf extension for generic store
        // The following lines have been inserted:
        try {       
            DBTransaction dbtlocal = dbt;
            boolean needToCommit = false;
            if (dbtlocal == null) {
              if(get_transaction()==null) {
                dbtlocal = DODS.getDatabaseManager().createTransaction(get_OriginDatabase());
                dbtlocal.setDatabaseName(get_OriginDatabase());
                needToCommit = true;
              }
              else
                dbtlocal=transaction;  
            } else {
                if(get_transaction()!=null) {
                    if(!get_transaction().equals(dbtlocal))
                        throw new DatabaseManagerException("DO doesn't belong this transaction.");
                }
            }
            // The following line has been changed:
            modifyDO( dbtlocal, true );
            // end of WebDocWf extension for generic store
            if (needToCommit) {
                dbtlocal.commit();
                dbtlocal.release();
            }
        } catch (DataObjectException e) {
            modifyDO( dbt, true );
        } 
    }

    /**
     * UnDeletes the DO and inserts to the table.
     *
     * @param dbt The transaction object used for this operation.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     */
    public void unDelete(DBTransaction dbt)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
     
     if (getCache().getTableConfiguration().isReadOnly())
            throw new AssertionDataObjectException("IndexDO's cache is read-only. Therefore, DML opertions are not allowed.");
        // WebDocWf extension for generic store
        // The following lines have been inserted:
        try {
            DBTransaction dbtlocal = dbt;
            boolean needToCommit = false;
            if (dbtlocal == null) {
              if(get_transaction()==null) {
                dbtlocal = DODS.getDatabaseManager().createTransaction(get_OriginDatabase());
                dbtlocal.setDatabaseName(get_OriginDatabase());
                needToCommit = true;
              }
              else
                dbtlocal=transaction;  
            } else {
           if(get_transaction()!=null) {
                if(!get_transaction().equals(dbtlocal))
                    throw new DatabaseManagerException("DO didn't belong this transaction.");
           }
          }
          setDeleted(false);
	 isDeletedFromDatabase = false;
          persistent=false;
          modifyDO( dbtlocal, false );
          if (needToCommit) {
                dbtlocal.commit();
                dbtlocal.release();
          }
          isDeletedFromDatabase = false;
        } catch (DataObjectException e) { 
            persistent=true;
            setDeleted(true);
        } 
    }

    
    /**
     * Modifies the DO within its table.
     * Performs recursive commit/delete on referenced DOs;
     * all operations occur within a single transaction
     * to allow rollback in the event of error.
     * Only the creator of the transaction releases it.
     *
     * @param dbt The transaction object used for this operation.
     * @param delete True if doing a delete, otherwise false (for insert/update).
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     * 
     * WebDocWf extension
     */
    protected void modifyDO( DBTransaction dbt, boolean delete)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        modifyDO( dbt, delete, true);
    }

    /**
     * Modifies the DO within its table.
     * Performs recursive commit/delete on referenced DOs;
     * all operations occur within a single transaction
     * to allow rollback in the event of error.
     * Only the creator of the transaction releases it.
     *
     * @param dbt The transaction object used for this operation.
     * @param delete True if doing a delete, otherwise false (for insert/update).
     * @param references True if references should be saved
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException If a Transaction can not be created.
     * @exception RefAssertionException Thrown by okTo method.
     * @exception java.sql.SQLException If any SQL errors occur.
     * @exception DataObjectException 
     * @exception DBRowUpdateException
     * @exception QueryException
     * 
     * WebDocWf extension
     */
    protected void modifyDO( DBTransaction dbt, boolean delete, boolean references )
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException {
        if ( delete ) 
            okToDelete();
        else
            okToCommit();

        boolean ownTransaction = false;
        try {
            if ( null == dbt ) {
                if( null==get_transaction()) { 
                    DatabaseManager dbm = DODS.getDatabaseManager();
                    dbt = dbm.createTransaction(get_OriginDatabase());      // create a transaction
                    dbt.setDatabaseName(get_OriginDatabase());
                    ownTransaction = true;
                } else {       
                    dbt=transaction;
                }
            } else {

                if(get_transaction()!=null) {
                    if(!get_transaction().equals(dbt))
                        throw new DatabaseManagerException("DO doesn't belong this transaction.");
                }
            }
            // end of WebDocWf fix for circular references
            if ( null == dbt )
                throw new DatabaseManagerException("DatabaseManager.createTransaction returned null." );
            if ( delete ) {
               _tr_(dbt).addDeletedDO(this);

                // The following line keeps the compiler happy 
                // when the CASCADING_DELETES tag is empty.
                if ( false )
                    throw new QueryException("XXX");
            } else {
                // WebDocWf extension for save without references
                // The following line has been inserted
                if (references) {
                    // end of WebDocWf extension for save without references
                    // commit referenced DOs.
 
                    // WebDocWf extension for save without references
                    // The following line has been inserted
                }
                // end of WebDocWf extension for save without references
            }
            if ( false ) {
                // This throw is here to keep the compiler happy
                // in the case of a DO that does not refer to other DOs.
                // In that case, the above delete/commit code blocks will be empty
                // and throw nothing.
                throw new DataObjectException( "foo" );   
            }
            if ( delete ) {
              dbt.delete( this );
              setDeleted(true);
              if (isRootDeleteNode) {
                   _tr_(dbt).resetDeletedDOs();
              }
            } else {
                if ( isLoaded() || isAutoSaveCreateVirgin())
                    dbt.insert( this );   // dbt.insert() handles insertions and updates
            }
            if (ownTransaction) {
                dbt.commit(); // commit the transaction
            }
        } catch (SQLException sqle) {
            StringBuffer message = new StringBuffer("Failed to insert/update DO: ");
            message.append(sqle.getMessage());
            // rollback, if necessary
            if (ownTransaction) {
                try {
                    dbt.rollback();
                } catch (SQLException sqle2) {
                    message.insert(0,"\n");
                    message.insert(0,sqle2.getMessage());
                    message.insert(0,"Rollback failed: ");
                }
            }
            throw new SQLException(message.toString());
        } finally {
            // release the transaction, if any
            if (ownTransaction) {
                dbt.release();
            }
        }
    }

    private void changedFlags_set(boolean value) {
        changedKey = value;
        changedLang = value;
        changedValue = value;
        changedMsort = value;
        changedEntryId = value;
    }
}
