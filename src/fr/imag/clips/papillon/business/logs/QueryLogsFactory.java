/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.1  2003/02/03 05:44:30  mangeot
 * *** empty log message ***
 *
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.logs;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.papillon_data.*;


//import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;

/* for the config file */
import com.lutris.util.Config;
import com.lutris.appserver.server.Enhydra;
import com.lutris.util.ConfigException;



import java.util.*;

// For URLs
import java.net.*;

import fr.imag.clips.papillon.business.utility.*;

/**
* Used to find the instances of xslsheet.
 */
public class QueryLogsFactory {

   
    public static QueryLog newQueryLog(String login, 
					 String formName,
					 String prefLang,
					 String query,
					 String[][] results,
					 String srcLang,
					 String[] trgLangs,
					 String[] dicts,
					 String strategy,
					 String queryString)
        throws fr.imag.clips.papillon.business.PapillonBusinessException, java.io.IOException {

                    QueryLog myQueryLog=new QueryLog();
                    myQueryLog.setDate(new java.util.Date());
                    myQueryLog.setLogin(login);
                    myQueryLog.setFormName(formName);
                    myQueryLog.setPrefLang(prefLang);
                    myQueryLog.setQuery(query);
                    myQueryLog.setResults(buildResultsString(results));
                    myQueryLog.setSrcLang(srcLang);
                    myQueryLog.setTrgLangs(buildCommaSeparatedString(trgLangs));
                    myQueryLog.setDicts(buildCommaSeparatedString(dicts));
                    myQueryLog.setStrategy(strategy);
                    myQueryLog.setQueryString(queryString);
             
		    return myQueryLog;
        }

    protected static String buildResultsString(String[][] resTable) {
	String results = "";
	if (resTable != null) {
	    int i=0;
	    while (i<resTable.length && (resTable[i][0] != null)) {
		results += "%%"+ resTable[i][0] + "::" + resTable[i][1];
		i++;
	    }
	}
	return results;
    }

    protected static String buildCommaSeparatedString(String[] resTable) {
	String results = "";
	if (resTable != null && resTable.length>0) {
	    results = resTable[0];
	    for (int i=1; i< resTable.length;i++) {
		results += ", " + resTable[i];
	    }
	}
	return results;
    }

    public static boolean StoreQueryLogs() throws PapillonBusinessException{
	boolean result = false;
	try {
            result =  Enhydra.getApplication().getConfig().getBoolean(QueryLog.STORE_STRING);
        } catch (ConfigException e) {
            throw new PapillonBusinessException("Home found no store boolean. Check the application config file.", e);
	}
	return result;
    }


    public static int countEntries() throws PapillonBusinessException {
        int entries = -1;
	QueryLog dummyLog = new QueryLog();
        String dbname = dummyLog.getTableName();
        if (null != dbname && !dbname.equals("")) {
            try {
                entries = ManageDatabase.countRows(dbname);
            }
            catch (java.sql.SQLException ex) {
                throw new fr.imag.clips.papillon.business.PapillonBusinessException("Error in QueryLogsFactory.countEntries: ",ex);
            }
        }
        return entries;
    }
    
}
