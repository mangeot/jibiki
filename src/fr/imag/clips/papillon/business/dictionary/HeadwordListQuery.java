package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import java.util.Collection;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.appserver.server.Enhydra;

/**
 * 
 */
public class HeadwordListQuery {

       public static Collection getHeadwordListForLanguage(String sourceLanguage, String prefix, int limit) throws SQLException {

        // FIXME: This gives all headword, even the one that have been deleted...
        // It will be the case as long as the index references all entries...
        DBConnection myDBConnection = null;
        ResultSet myResultSet = null;
        TreeSet myTreeSet = new TreeSet();

        try {

            myDBConnection = Enhydra.getDatabaseManager().allocateConnection();

            Collection volumes = VolumesFactory.getVolumesArray(null, sourceLanguage, null);

            for (Iterator iter = volumes.iterator(); iter.hasNext();) {
                Volume volume = (Volume)iter.next();
                String sqlQuery = "SELECT DISTINCT value FROM " + volume.getIndexDbname() +
                        " WHERE key='" + Volume.CDM_headword +
                        "' AND value ilike '"+ prefix + "%' " +
                        "LIMIT "+ limit + ";";

                // System.out.println(sqlQuery);
                
                myResultSet = myDBConnection.executeQuery(sqlQuery);
                while(myResultSet.next()){
                    myTreeSet.add(myResultSet.getString(1));
                }
                myResultSet.close();
            }

        }  catch(PapillonBusinessException e) {
            PapillonLogger.writeDebugMsg("Exception in HeadwordListQuery : " + e.toString());

        }  catch(SQLException se) {
            se.printStackTrace();
            //very important to throw out bad connections
            if(myDBConnection.handleException(se)) myDBConnection=null;

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(myDBConnection!=null) {
                myDBConnection.reset();
                myDBConnection.release();
            }
        }

        //
        return myTreeSet;
    }
}
