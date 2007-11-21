package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.utility.StringNormalizer;

import java.util.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.Collator;

import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.appserver.server.Enhydra;

/**
 *
 */
public class HeadwordListQuery {

    public static Collection getHeadwordListForLanguage(String sourceLanguage, String prefix, int limit) throws SQLException {

        DBConnection myDBConnection = null;
        ResultSet myResultSet = null;
        TreeSet myTreeSet = new TreeSet(Collator.getInstance(new Locale(sourceLanguage)));

        try {

            myDBConnection = Enhydra.getDatabaseManager().allocateConnection();

            Collection volumes = VolumesFactory.getVolumesArray(null, sourceLanguage, null);

            for (Iterator iter = volumes.iterator(); iter.hasNext();) {
                Volume volume = (Volume) iter.next();
                String sqlQuery = "SELECT value FROM " + volume.getHeadwordViewName() +
                        " WHERE value ilike '" + escapeForSql(prefix) + "%' " +
                        "LIMIT " + limit + ";";

                // System.out.println(sqlQuery);

                myResultSet = myDBConnection.executeQuery(sqlQuery);
                while (myResultSet.next()) {
                    myTreeSet.add(myResultSet.getString(1));
                }
                myResultSet.close();
            }

        } catch (PapillonBusinessException e) {
            PapillonLogger.writeDebugMsg("Exception in HeadwordListQuery : " + e.toString());

        } catch (SQLException se) {
            se.printStackTrace();
            //very important to throw out bad connections
            if (myDBConnection.handleException(se)) myDBConnection = null;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (myDBConnection != null) {
                myDBConnection.reset();
                myDBConnection.release();
            }
        }

        //
        return myTreeSet;
    }

    public static String escapeForSql(String str) {
        return str == null ? null : StringNormalizer.normalize(str).replaceAll("'", "''");
    }

    public static Collection getHeadwordListForVolumeIgnoringAccents(Volume volume, String prefix, int limit) throws SQLException, PapillonBusinessException {
        DBConnection myDBConnection = null;
        ResultSet myResultSet = null;

        TreeSet resList = new TreeSet(Collator.getInstance(new Locale(volume.getSourceLanguage())));

        try {

            myDBConnection = Enhydra.getDatabaseManager().allocateConnection();

            String sqlQuery = "SELECT DISTINCT value FROM " + volume.getHeadwordViewName();
            if (null != prefix)
                sqlQuery += " WHERE msort like multilingual_sort('" + volume.getSourceLanguage() + "','" + prefix + "') || '%' ";
            if (0 != limit) sqlQuery += " LIMIT " + limit + ";";

            // System.out.println(sqlQuery);

            myResultSet = myDBConnection.executeQuery(sqlQuery);
            while (myResultSet.next()) {
                resList.add(myResultSet.getString(1));
            }
            myResultSet.close();


        } catch (PapillonBusinessException e) {
            PapillonLogger.writeDebugMsg("Exception in HeadwordListQuery : " + e.toString());

        } catch (SQLException se) {
            se.printStackTrace();
            //very important to throw out bad connections
            if (myDBConnection.handleException(se)) myDBConnection = null;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (myDBConnection != null) {
                myDBConnection.reset();
                myDBConnection.release();
            }
        }
        return resList;
    }

    public static Collection getHeadwordListForLanguageIgnoringAccents(String sourceLanguage, String prefix, int limit) throws SQLException, PapillonBusinessException {

        Collection volumes = VolumesFactory.getVolumesArray(null, sourceLanguage, null);
        TreeSet resList = new TreeSet(Collator.getInstance(new Locale(sourceLanguage)));

        for (Iterator iter = volumes.iterator(); iter.hasNext();) {
            Volume volume = (Volume) iter.next();
            resList.addAll(getHeadwordListForVolumeIgnoringAccents(volume, prefix, limit));
        }
        return resList;
    }
}
