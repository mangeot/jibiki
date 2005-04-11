/*-----------------------------------------------------------------------------
*-----------------------------------------------------------------------------
*/

package fr.imag.clips.papillon.papillon_data;

import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import java.sql.*;

import com.lutris.appserver.server.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.DataObjectException; 

import org.enhydra.dods.DODS;

/* For debug messages */
//import fr.imag.clips.papillon.business.PapillonLogger;


/**
 *
 * @version $Revision$
 * @author  mangeot
 * @since   main
 */
public class ManageDatabase implements Query {


    protected static String createTableSql = "CREATE TABLE ";
    protected static String createIndexSql = "CREATE INDEX ";
    protected static String truncateTableSql = "TRUNCATE TABLE ";
    protected static String dropTableSql = "DROP TABLE ";
    protected static String dropIndexSql = "DROP INDEX ";

    
    protected String currentSQL = "";
    protected DBTransaction transaction;
    /**
        * Public constructor
     */
    public ManageDatabase(DBTransaction trans, String sql) {
        this.transaction = trans;
        this.currentSQL = sql;
    }
    
    /**
        * WARNING!	 This method is	disabled.
     * The reason is that this special set of Queries do not return any result.
     * Moreover, it is also disabled in Quries implementations.
	 */
	public Object next(ResultSet rs) throws SQLException, ObjectIdException {
        // TODO: It	would be nice to throw an unchecked	exception here
        // (an exception that extends RuntimeException)
        // that	would be guaranteed	to appear during application testing.
        throw new ObjectIdException("next()	should not be used.	 Use getNextDO() instead." );
        //return null;
    }
    
    /*<table id="fr.imag.clips.papillon.data.VolumeEntry" dbTableName="volume">
        <column id="headword" isIndex="true" usedForQuery="true">
        <javadoc>
        </javadoc>
        <type canBeNull="true" dbType="LONGVARCHAR" javaType="String"/>
        </column>
        <column id="id" usedForQuery="true">
        <javadoc>
        </javadoc>
        <type canBeNull="true" dbType="VARCHAR" javaType="String" size="255"/>
        </column>
        <column id="pos" usedForQuery="true">
        <javadoc>
        </javadoc>
        <type canBeNull="true" dbType="VARCHAR" javaType="String" size="255"/>
        </column>
        <column id="pronunciation" isIndex="true" usedForQuery="true">
        <javadoc>
        </javadoc>
        <type canBeNull="true" dbType="VARCHAR" javaType="String" size="255"/>
        </column>
        <column id="translation" isIndex="true" usedForQuery="true">
        <javadoc>
        </javadoc>
        <type canBeNull="true" dbType="LONGVARCHAR" javaType="String"/>
        </column>
        <column id="key1" usedForQuery="true">
        <javadoc>
        </javadoc>
        <type canBeNull="true" dbType="VARCHAR" javaType="String" size="255"/>
        </column>
        <column id="key2" usedForQuery="true">
        <javadoc>
         </javadoc>
        <type canBeNull="true" dbType="VARCHAR" javaType="String" size="255"/>
        </column>
        <column id="xmlCode" usedForQuery="true">
        <javadoc>
         </javadoc>
        <type dbType="LONGVARCHAR" javaType="String"/>
        </column>
        </table>*/ 
    
    
    protected static String createVolumeTableParamsSql = " (" +
        "headword TEXT DEFAULT '\'''\''    ," +
		"dom BYTEA NOT NULL   ," +
		"htmldom BYTEA NOT NULL   ," +
        "xmlCode TEXT DEFAULT '\'''\'' NOT NULL   ," +
        
        "ObjectId DECIMAL(19,0) NOT NULL PRIMARY KEY," +
        "ObjectVersion INTEGER NOT NULL)";
    
    protected static String createIndexTableParamsSql = " (" +
		"key VARCHAR(255) DEFAULT '\'''\''    ," +
		"lang VARCHAR(3) DEFAULT '\'''\''    ," +
		"value VARCHAR(255) DEFAULT '\'''\''    ," +
        "entryid VARCHAR(255) DEFAULT '\'''\''    ," +
        
        "ObjectId DECIMAL(19,0) NOT NULL PRIMARY KEY," +
        "ObjectVersion INTEGER NOT NULL)";
    
    
    public static void createVolumeTable(String table) throws  PapillonBusinessException {
            executeSql(createTableSql + table + createVolumeTableParamsSql);
        }
    
    public static void createIndexTable(String indexTable) throws  PapillonBusinessException {
            executeSql(createTableSql + indexTable + createIndexTableParamsSql);
        }
    
    public static void createIndexForTable(String table, String name, String field1, String field2, String field3) throws  PapillonBusinessException {
            String query = createIndexSql + table + "_" + name  + "_idx" + " ON " + table + " ( " + field1 + "," + field2 + "," + field3 + " )";
            executeSql(query);
        }
    
    public static void createIndexForTable(String table, String name) throws PapillonBusinessException {
            String query = createIndexSql + table + "_" + name  + "_idx" + " ON " + table + " ( " + name + " )";
            executeSql(query);
        }
    
    public static void dropIndexForTable(String table, String name) throws  PapillonBusinessException {
            String query = dropIndexSql + table + "_" + name + "_idx";
            executeSql(query);
        }
    
    public static void truncateTable(String table) throws  PapillonBusinessException {
            executeSql(truncateTableSql + table);
            //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Table: " + table + " truncated");
        }
    
    public static void dropTable(String table) throws  PapillonBusinessException {
        executeSql(dropTableSql + table);
        //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Table: " + table + " dropped");
        
    }
    
    protected static void executeSql (String sql) throws PapillonBusinessException {
        DBTransaction transaction = CurrentDBTransaction.get();
        ManageDatabase req = new ManageDatabase(transaction, sql);
        //Flush the current transaction (?)
        // Is this really usefull ?
        if ((transaction!=null) &&
            (transaction instanceof com.lutris.appserver.server.sql.CachedDBTransaction)) {
            if(((com.lutris.appserver.server.sql.CachedDBTransaction)transaction).getAutoWrite()) try {
                transaction.write();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                throw new PapillonBusinessException("Couldn't write transaction: "+sqle);
            }
        }
        // Create the DB Query Object
        DBQuery	dbQuery = null;
        try {
            if (transaction == null) {
                dbQuery	= DODS.getDatabaseManager().createQuery();
            } else {
                dbQuery	= transaction.createQuery();
            }

            dbQuery.query( req	);	  // invokes executeQuery
        } catch ( DatabaseManagerException e ) { 
            String err = "ERROR SpecialDatabaseRequest: Could not create a DBQuery.  ";
            throw new PapillonBusinessException( err, e );
        } catch ( SQLException e ) { 
            String err = "ERROR SpecialDatabaseRequest: Exception while running the query: " + sql;
            throw new PapillonBusinessException( err, e );
        } finally {
            if ( null != dbQuery ) dbQuery.release();
		}
    }
    
    
    public ResultSet executeQuery(DBConnection conn) throws SQLException {
        conn.execute(currentSQL);
        return null;
    }

    
//    
//    protected static void executeSql (String sql)
//        throws java.sql.SQLException {
//            DBConnection myDbConnection = null;
//            try {
//                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();
//                
//                myDbConnection.execute(sql);
//                
//            }  catch(SQLException se) {
//                se.printStackTrace();
//                //very important to throw out bad connections
//                
//                if(myDbConnection.handleException(se)) myDbConnection=null;
//            } catch(Exception e) {
//                e.printStackTrace();
//            } finally {
//                if(myDbConnection!=null) {
//                    myDbConnection.reset();
//                    myDbConnection.release();
//                }
//            }
//        }
//    
//    protected static void executeSqlQuery (String sql)
//        throws java.sql.SQLException {
//            DBConnection myDbConnection = null;
//            ResultSet myResultSet = null;
//            try {
//                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();
//                
//                myResultSet = myDbConnection.executeQuery(sql);
//                
//                if(myResultSet != null) {
//                    myResultSet.close();
//                }
//            }  catch(SQLException se) {
//                se.printStackTrace();
//                //very important to throw out bad connections
//                
//                if(myDbConnection.handleException(se)) myDbConnection=null;
//            } catch(Exception e) {
//                e.printStackTrace();
//            } finally {
//                if(myDbConnection!=null) {
//                    myDbConnection.reset();
//                    myDbConnection.release();
//                }
//            }
//        }
}
