/*-----------------------------------------------------------------------------
*-----------------------------------------------------------------------------
*/

package fr.imag.clips.papillon.papillon_data;

import java.sql.*;

import com.lutris.appserver.server.*;
import com.lutris.appserver.server.sql.*;

/* For debug messages */
//import fr.imag.clips.papillon.business.PapillonLogger;


/**
 *
 * @version $Revision$
 * @author  mangeot
 * @since   main
 */
public class ManageDatabase {


    protected static String createTableSql = "CREATE TABLE ";
    protected static String createIndexSql = "CREATE INDEX ";
    protected static String truncateTableSql = "TRUNCATE TABLE ";
    protected static String dropTableSql = "DROP TABLE ";
    protected static String dropIndexSql = "DROP INDEX ";
    protected static String startCountRowsSql = "SELECT COUNT(";
    protected static String endCountRowsSql = ") AS cnt FROM ";
    protected static String countSql = "cnt";

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
        "id VARCHAR(255) DEFAULT '\'''\''    ," +
        "pos VARCHAR(255) DEFAULT '\'''\''    ," +
        "pronunciation VARCHAR(255) DEFAULT '\'''\''    ," +
        "reading VARCHAR(255) DEFAULT '\'''\''    ," +
        "translation TEXT DEFAULT '\'''\''    ," +
        "key1 VARCHAR(255) DEFAULT '\'''\''     ," +
        "key2 VARCHAR(255) DEFAULT '\'''\''    ," +
        "xmlCode TEXT DEFAULT '\'''\'' NOT NULL   ," +

        "ObjectId DECIMAL(19,0) NOT NULL PRIMARY KEY," +
        "ObjectVersion INTEGER NOT NULL)";

    protected static String createIndexTableParamsSql = " (" +
		"key VARCHAR(255) DEFAULT ''    ," +
        "entryid VARCHAR(255) DEFAULT '\'''\''    ," +

        "ObjectId DECIMAL(19,0) NOT NULL PRIMARY KEY," +
        "ObjectVersion INTEGER NOT NULL)";


		public static void createVolumeTable(String table)
			throws java.sql.SQLException {
				executeSql(createTableSql + table + createVolumeTableParamsSql);
			}

		public static void createIndexTable(String indexTable)
			throws java.sql.SQLException {
				executeSql(createTableSql + indexTable + createIndexTableParamsSql);
			}

		public static void createIndexForTable(String table, String field)
			throws java.sql.SQLException {
				String query = createIndexSql + "Idx_" + table + "_" + field + " ON " + table + " ( " + field + " )";
				executeSql(query);
			}

		public static void dropIndexForTable(String table, String field)
			throws java.sql.SQLException {
				String query = dropIndexSql + "Idx_" + table + "_" + field;
				executeSql(query);
			}

		public static int countRows(String table)
        throws java.sql.SQLException {
           return countRow("*",table);
        }

    public static int countRow(String row, String table)
        throws java.sql.SQLException {
            int res = executeSqlCountRows(row, table);
            //        fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Table: " + table + " has " + res + " rows");
            return res;
        }

    public static void truncateTable(String table)
        throws java.sql.SQLException {
            executeSql(truncateTableSql + table);
            //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Table: " + table + " truncated");
        }

    public static void dropTable(String table)
        throws java.sql.SQLException {
            executeSql(dropTableSql + table);
            //fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Table: " + table + " dropped");

        }

    protected static void executeSql (String sql)
        throws java.sql.SQLException {
            DBConnection myDbConnection = null;
            try {
                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();

                myDbConnection.execute(sql);

            }  catch(SQLException se) {
                se.printStackTrace();
                //very important to throw out bad connections

                if(myDbConnection.handleException(se)) myDbConnection=null;
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if(myDbConnection!=null) {
                    myDbConnection.reset();
                    myDbConnection.release();
                }
            }
        }

    protected static int executeSqlCountRows (String row, String table)
        throws java.sql.SQLException {
            DBConnection myDbConnection = null;
            ResultSet myResultSet = null;
            int theCount = -1;
            String sqlQuery = startCountRowsSql + row + endCountRowsSql + table;
            try {
                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();

                myResultSet = myDbConnection.executeQuery(sqlQuery);

                if (myResultSet.next()) {
                    theCount = myResultSet.getInt(countSql);
                    myResultSet.close();
                }
            }  catch(SQLException se) {
                se.printStackTrace();
                //very important to throw out bad connections

                if(myDbConnection.handleException(se)) myDbConnection=null;
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if(myDbConnection!=null) {
                    myDbConnection.reset();
                    myDbConnection.release();
                }
            }
            return theCount;
        }

    protected static void executeSqlQuery (String sql)
        throws java.sql.SQLException {
            DBConnection myDbConnection = null;
            ResultSet myResultSet = null;
            try {
                myDbConnection = Enhydra.getDatabaseManager().allocateConnection();

                myResultSet = myDbConnection.executeQuery(sql);

                if(myResultSet != null) {
                    myResultSet.close();
                }
            }  catch(SQLException se) {
                se.printStackTrace();
                //very important to throw out bad connections

                if(myDbConnection.handleException(se)) myDbConnection=null;
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                if(myDbConnection!=null) {
                    myDbConnection.reset();
                    myDbConnection.release();
                }
            }
        }
}
