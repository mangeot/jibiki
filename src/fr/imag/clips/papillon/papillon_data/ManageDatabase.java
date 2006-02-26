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


    protected static final String createTableSql = "CREATE TABLE ";
    protected static final String createIndexSql = "CREATE INDEX ";
    protected static final String truncateTableSql = "TRUNCATE TABLE ";
    protected static final String dropTableSql = "DROP TABLE ";
    protected static final String dropIndexSql = "DROP INDEX ";
	
	protected static final String DatabaseUserString = "DatabaseManager.DB.papillon.Connection.User";
	

    
    protected String currentSQL = "";
    protected DBTransaction transaction;
	protected ResultSet resultSet = null;
	
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
    
    public static void createSortIndexForVolumeTable(String table, String lang) throws PapillonBusinessException {
		String query = createIndexSql + table + "_msort_idx" + " ON " + table + " (multilingual_sort( '" + lang + "',headword ))";
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
    
    public static String multilingual_sort(String lang, String value) throws  PapillonBusinessException {
 		String result = lang + value;
		
		String sql = "SELECT multilingual_sort('"+ lang + "','" + value + "')";
		java.util.Vector myResultVector = getStringResultSet(sql,"multilingual_sort");
		
		if (myResultVector != null && myResultVector.size()>0) {
			result = (String) myResultVector.elementAt(0);
		}
		return result;
    }

	protected static void executeSql (String sql) throws PapillonBusinessException {
		getStringResultSet(sql, null);
	}

	protected static java.util.Vector getStringResultSet (String sql, String columnName) throws PapillonBusinessException {
		java.util.Vector resVector = new java.util.Vector();;
		
		DBTransaction transaction = CurrentDBTransaction.get();
        ManageDatabase req = new ManageDatabase(transaction, sql);
        //Flush the current transaction (?)
        // Is this really usefull ?
        if ((req.transaction!=null) &&
            (req.transaction instanceof com.lutris.appserver.server.sql.CachedDBTransaction)) {
            if(((com.lutris.appserver.server.sql.CachedDBTransaction)req.transaction).getAutoWrite()) try {
                req.transaction.write();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                throw new PapillonBusinessException("Couldn't write transaction: "+sqle);
            }
        }
        // Create the DB Query Object
        DBQuery	dbQuery = null;
        try {
            if (req.transaction == null) {
                dbQuery	= DODS.getDatabaseManager().createQuery();
            } else {
                dbQuery	= req.transaction.createQuery();
            }

            dbQuery.query( req	);	  // invokes executeQuery
			while (req.resultSet.next() && columnName != null) {
				resVector.addElement(req.resultSet.getString(columnName));			
			}
        } catch ( DatabaseManagerException e ) { 
            String err = "ERROR SpecialDatabaseRequest: Could not create a DBQuery.  ";
            throw new PapillonBusinessException( err, e );
        } catch ( SQLException e ) { 
            String err = "ERROR SpecialDatabaseRequest: Exception while running the query: " + req.currentSQL;
            throw new PapillonBusinessException( err, e );
        } finally {
            if ( null != dbQuery ) dbQuery.release();
		}
		return resVector;
    }
    
    public static java.util.Vector getTableNames ()
        throws PapillonBusinessException {
			String sql = "SELECT tablename FROM pg_tables where tableowner='papillon'";
			
			java.util.Vector TableNames = new java.util.Vector();
            DBConnection myDbConnection = null;
            try {
                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();
				String databaseUser = Enhydra.getApplication().getConfig().getString(DatabaseUserString);

				com.lutris.dods.builder.generator.query.QueryBuilder myQueryBuilder = new com.lutris.dods.builder.generator.query.QueryBuilder("pg_tables");
				com.lutris.dods.builder.generator.query.RDBTable pg_tables = new com.lutris.dods.builder.generator.query.RDBTable("pg_tables");
				com.lutris.dods.builder.generator.query.RDBColumn tableOwnerColumn = new com.lutris.dods.builder.generator.query.RDBColumn(pg_tables,"tableowner");
				myQueryBuilder.addWhere(tableOwnerColumn, databaseUser);
				java.sql.ResultSet myResultSet = myQueryBuilder.executeQuery(myDbConnection);
               while (myResultSet.next()) {
				   TableNames.addElement(myResultSet.getString("tablename"));
	//			   fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("getTableNames.table: " + myResultSet.getString("tablename"));
			   }
            }  catch(SQLException se) {
                //very important to throw out bad connections
				System.out.println("SQL exception: ");
				se.printStackTrace();
                if(myDbConnection.handleException(se)) myDbConnection=null;
            } catch(Exception e) {
				String err = "ERROR DatabaseConnexion: Exception while running the query: " + sql;
				System.out.println(err);
				e.printStackTrace();
				//throw new PapillonBusinessException( err, e );
            } finally {
                if(myDbConnection!=null) {
					try {
						myDbConnection.reset();
						myDbConnection.release();
					}
					catch ( SQLException e ) { 
						String err = "ERROR DatabaseConnexion2: Exception while running the query: " + sql;
						System.out.println(err);
						e.printStackTrace();
//						throw new PapillonBusinessException( err, e );
					}
                }
            }
			return TableNames;
        }
	
	
	public ResultSet executeQuery(DBConnection conn) throws SQLException {
		this.resultSet = conn.executeQuery(currentSQL);
        return this.resultSet;
    }

    
/*
    protected static void simpleExecuteSql (String sql)
        throws PapillonBusinessException {
            DBConnection myDbConnection = null;
            try {
                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();
                
                myDbConnection.execute(sql);
                
            }  catch(SQLException se) {
                //very important to throw out bad connections
                
                if(myDbConnection.handleException(se)) myDbConnection=null;
            } catch(Exception e) {
				String err = "ERROR DatabaseConnexion: Exception while running the query: " + sql;
				throw new PapillonBusinessException( err, e );
            } finally {
                if(myDbConnection!=null) {
					try {
						myDbConnection.reset();
						myDbConnection.release();
					}
					catch ( SQLException e ) { 
						String err = "ERROR DatabaseConnexion: Exception while running the query: " + sql;
						throw new PapillonBusinessException( err, e );
					}
                }
            }
        } */
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
