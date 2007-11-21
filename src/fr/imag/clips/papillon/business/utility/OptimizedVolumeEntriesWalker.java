package fr.imag.clips.papillon.business.utility;

import com.lutris.appserver.server.Enhydra;
import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.appserver.server.sql.DBTransaction;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.ParseVolume;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.xml.XMLServices;
import org.w3c.dom.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OptimizedVolumeEntriesWalker {

    static long fetchcumul = 0;
    static long parsecumul = 0;
    static long writecumul = 0;

    public static void rebuildIndexes(Volume volume) throws PapillonBusinessException {
        DBConnection myDbConnection = null;
        String sql = "SELECT xmlcode, objectid FROM " + volume.getDbname() + " ORDER BY objectid";

        PapillonLogger.writeDebugMsg("Re-indexing volume " + volume.getDbname() + " which contains " + volume.getCount() + " entries.");

        int offset = 0;
        int resultCount = 100;
        ArrayList indexes = new ArrayList(4000);
        
        while (resultCount == 100) {
            resultCount = 0;

            long start = System.currentTimeMillis();
            try {
                String actualSql = sql + " OFFSET " + offset + " LIMIT 100";
                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();
                ResultSet myResultSet = myDbConnection.executeQuery(actualSql);


                if (myResultSet != null) {
                    while (myResultSet.next()) {
                        String xmlCode = myResultSet.getString("xmlcode");
                        Document xmlDoc = XMLServices.buildDOMTree(xmlCode);
                        String handle = myResultSet.getString("objectid");

                        indexes.addAll(ParseVolume.parseEntry(volume, xmlDoc, handle));
                        resultCount++;
                    }
                    myResultSet.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
                //very important to throw out bad connections

                if (myDbConnection.handleException(se)) myDbConnection = null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (myDbConnection != null) {
                    try {
                        myDbConnection.reset();
                        myDbConnection.release();
                    } catch (SQLException se) {
                        se.printStackTrace();
                        //very important to throw out bad connections
                        if (myDbConnection.handleException(se)) myDbConnection = null;
                    }
                }
            }
            long mid = System.currentTimeMillis();

            try {
                CurrentDBTransaction.registerNewDBTransaction();
                ParseVolume.saveIndexes(indexes, volume.getIndexDbname());
                CurrentDBTransaction.get().commit();
            } catch (SQLException se) {
                String userMessage = "Problems when re-index entries.";
                PapillonLogger.writeDebugMsg(userMessage);
                se.printStackTrace();
                try {
                    DBTransaction dbt = ((DBTransaction) CurrentDBTransaction.get());
                    if (null != dbt) dbt.rollback();
                } catch (java.sql.SQLException sqle) {
                    PapillonLogger.writeDebugMsg(
                            "reConstructionIndex: SQLException while rolling back failed transaction.");
                    sqle.printStackTrace();
                }
            } finally {
                CurrentDBTransaction.releaseCurrentDBTransaction();
            }

            long end = System.currentTimeMillis();
            
            PapillonLogger.writeDebugMsg("Re indexed entries " + offset + " to " + (offset + resultCount) + " | read: " + (mid-start) + ", write: " + (end-mid) );
            offset += resultCount;
            indexes.clear();
        }

    }


/*    private void walk(QueryBuilder builder, DBTransaction transaction)
        throws DataObjectException, NonUniqueQueryException {
    arrayIndex = -1;
    DBQuery dbQuery = null;
    Date startQueryTime = new Date();
    long queryTime = 0;
    boolean readDOs = false;
    CacheStatistics stat = null;

    if (builder.isUnionTableJoin())
        throw new DataObjectException("Could not use “UNION [ALL]“ statement in query witch retrieve data object.");

    if ((transaction != null) &&
            (transaction instanceof com.lutris.appserver.server.sql.CachedDBTransaction)) {
        if (((com.lutris.appserver.server.sql.CachedDBTransaction) transaction).getAutoWrite()) try {
            transaction.write();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new DataObjectException("Couldn't write transaction: " + sqle);
        }
        ((com.lutris.appserver.server.sql.CachedDBTransaction) transaction).dontAggregateDOModifications();
    }

    try {
        QueryResult results = null;
        DOShell shell = null;


        dbQuery = VolumeEntryDO.createQuery(transaction);

        results = new QueryResult();
        int resultCount = 0;
        boolean bHasMoreResults = false;

        builder.setSelectClause(VolumeEntryDO.getColumnsNameString(dbtablename));

        dbQuery.query(this);      // invokes executeQuery


        if (!unique) {
            while ((bHasMoreResults = resultSet.next()) && (databaseLimit == 0 || (results.DOs.size() < databaseLimit))) {
                VolumeEntryDO newDO;
                VolumeEntryDataStruct newDS;

                if (((VolumeEntryDO.getConfigurationAdministration(this.dbtablename).getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect()) && !loadData) {
                    newDO = VolumeEntryDO.ceInternal(this.dbtablename, new ObjectId(resultSet.getBigDecimal(CoreDO.get_OIdColumnName())), refs, transaction);
                    newDO.set_Version(resultSet.getInt(VolumeEntryDO.get_versionColumnName()));
                } else
                    newDO = VolumeEntryDO.ceInternal(this.dbtablename, resultSet, refs, transaction);
                if (transaction == null) {
                    if (newDO != null && newDO.isTransactionCheck()) {
                        DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created : Database: " + newDO.get_OriginDatabase() + " VolumeEntryDO class, oid: " + newDO.get_Handle() + ", version: " + newDO.get_Version() + " \n");
                        (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

                    }
                }

                if (queryItem != null) {
                    queryItem.add((VolumeEntryDataStruct) newDO.originalData_get());
                }
                if (((VolumeEntryDO.getConfigurationAdministration(this.dbtablename).getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect()) && !loadData) {
                } else
                    newDS = VolumeEntryDO.addToCache(this.dbtablename, (VolumeEntryDataStruct) newDO.originalData_get());

                if (resultCount >= readSkip) {
                    shell = new DOShell(newDO);
                    results.DOs.add(shell);
                }
                resultCount++;

            } // while
        } // (!unique)

        else { // (! unique)
            HashSet hsResult = new HashSet(readSkip + databaseLimit);
            while ((bHasMoreResults = resultSet.next()) && (databaseLimit == 0 || (results.DOs.size() < databaseLimit))) {
                VolumeEntryDO newDO;
                VolumeEntryDataStruct newDS;

                if (((VolumeEntryDO.getConfigurationAdministration(this.dbtablename).getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect()) && !loadData) {
                    newDO = VolumeEntryDO.ceInternal(this.dbtablename, new ObjectId(resultSet.getBigDecimal(CoreDO.get_OIdColumnName())), refs, transaction);
                    newDO.set_Version(resultSet.getInt(VolumeEntryDO.get_versionColumnName()));
                } else
                    newDO = VolumeEntryDO.ceInternal(this.dbtablename, resultSet, refs, transaction);
                if (transaction == null) {
                    if (newDO != null && newDO.isTransactionCheck()) {
                        DODS.getLogChannel().write(Logger.WARNING, "DO without transaction context is created : Database: " + newDO.get_OriginDatabase() + " VolumeEntryDO class, oid: " + newDO.get_Handle() + ", version: " + newDO.get_Version() + " \n");
                        (new Throwable()).printStackTrace(DODS.getLogChannel().getLogWriter(Logger.WARNING));

                    }
                }

                if (queryItem != null) {
                    queryItem.add((VolumeEntryDataStruct) newDO.originalData_get());
                }
                if (((VolumeEntryDO.getConfigurationAdministration(this.dbtablename).getTableConfiguration().isLazyLoading()) || isCaching()) && (!builder.getPreventPrimaryKeySelect()) && !loadData) {
                } else
                    newDS = VolumeEntryDO.addToCache(this.dbtablename, (VolumeEntryDataStruct) newDO.originalData_get());

                if (!hsResult.contains(newDO.get_Handle())) {
                    hsResult.add(newDO.get_Handle());
                    if (resultCount >= readSkip) {

                        shell = new DOShell(newDO);
                        results.DOs.add(shell);
                    }
                    resultCount++;
                }

            } // while
        } // else (! unique)

        if ((results.DOs.size() == databaseLimit) && bHasMoreResults) {
            resultSet.close();
            databaseLimitExceeded = true;
        }
        if (maxDBrows > 0) {
            if (!bHasMoreResults) {
                if ((databaseLimit > 0) && databaseLimit < maxDBrows)
                    queryItem.setCompleteResult(true);
            }
        } else {
            if (!bHasMoreResults)
                queryItem.setCompleteResult(true);
        }
        Date stopQueryTime = new Date();
        queryTime = stopQueryTime.getTime() - startQueryTime.getTime();
        if (queryItem != null) {
            queryItem.setTime((new Long(queryTime)).intValue());
            if (queryCachedItem != null) {
                if (queryItem.isCompleteResult() || (queryCachedItem.isModifiedQuery() && isOrderRelevant()) || (queryCachedItem.getResultNum() < queryItem.getResultNum())) {
// tj 03.09.2004                    if ((!builder.isMultiTableJoin()) || VolumeEntryDO.isAllReadOnly() )
                    if (builder.isMultiTableJoin()) {
                        ((QueryCache) VolumeEntryDO.getCache(this.dbtablename)).addMultiJoinQuery(queryItem);
                    } else {
                        if (hitDb) {
                            ((QueryCache) VolumeEntryDO.getCache(this.dbtablename)).addComplexQuery(queryItem);
                        } else {
                            ((QueryCache) VolumeEntryDO.getCache(this.dbtablename)).addSimpleQuery(queryItem);
                        }
                    } // else from if (builder.isMultiTableJoin())
                } else {
                    if ((queryCachedItem.getResultNum() < (readSkip + databaseLimit)) && (queryCachedItem.getResultNum() < maxDBrows)) {
                        queryCachedItem.setCompleteResult(true);
                    }
                }
                if ((queryItem.getResultNum() < (readSkip + databaseLimit)) && (queryItem.getResultNum() < maxDBrows))
                    queryItem.setCompleteResult(true);
            } // (queryCachedItem != null)
        } // (queryItem != null)
        int maxExecuteTime = VolumeEntryDO.getCache(this.dbtablename).getTableConfiguration().getMaxExecuteTime();
        if (maxExecuteTime > 0 && queryTime > maxExecuteTime)
            DODS.getLogChannel().write(Logger.WARNING, "sql = " + builder.getSQLwithParms() + " execute time = " + queryTime + "max table execute time = " + maxExecuteTime);


        if (results != null) {  // tj 01.02.2004
            if (results.DOs.size() > 1 && uniqueInstance)
                throw new NonUniqueQueryException("Too many	rows returned from database");
            DOs = new VolumeEntryDO[results.DOs.size()];
            VolumeEntryDataStruct orig;
            if (readDOs) {
                for (int i = 0; i < results.DOs.size(); i++) {
                    DOs[i] = (VolumeEntryDO) results.DOs.elementAt(i);
                }
            } else {
                for (int i = 0; i < results.DOs.size(); i++) {
                    DOs[i] = (VolumeEntryDO) ((DOShell) results.DOs.elementAt(i)).dataObject;
                }
            }
            arrayIndex = 0;
        } else {
            DOs = new VolumeEntryDO[0];
        }
        if (isQueryByOId && !hasNonOidCond) {
            VolumeEntryDO.get_statistics(this.dbtablename).incrementQueryByOIdNum();
            VolumeEntryDO.get_statistics(this.dbtablename).updateQueryByOIdAverageTime((new Long(queryTime)).intValue(), 1);
        } else {
            VolumeEntryDO.get_statistics(this.dbtablename).incrementQueryNum();
            VolumeEntryDO.get_statistics(this.dbtablename).updateQueryAverageTime((new Long(queryTime)).intValue());
        }
    } catch (SQLException se) {
        if (null == se.getSQLState()) {
            throw new DataObjectException("Unknown SQLException", se);
        }
        if (se.getSQLState().startsWith("02") && se.getErrorCode() == 100) {
            throw new DataObjectException("Update or delete	DO is out of synch", se);
        } else if (se.getSQLState().equals("S1000") && se.getErrorCode() == -268) {
            throw new DataObjectException("Integrity constraint	violation", se);
        } else {
            throw new DataObjectException("Data Object	Error", se);
        }
    } catch (ObjectIdException oe) {
        throw new DataObjectException("Object ID Error", oe);
    } catch (DatabaseManagerException de) {
        throw new DataObjectException("Database connection	Error", de);
    }
    finally {
        if (null != dbQuery) dbQuery.release();
    }
}

*/

}
