/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.2  2003/08/14 08:30:12  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.1.2.1  2003/05/28 09:17:18  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1  2003/02/03 05:44:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.3  2002/10/25 14:10:29  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.2.10.1  2002/10/23 09:51:06  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.2  2002/04/01 07:46:33  mangeot
 * Added a table for volumes metadata descriptions
 *
 * Revision 1.1  2002/03/11 11:15:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/12/18 13:41:36  serasset
 * *** empty log message ***
 *
 * Revision 1.5  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.4  2001/07/12 20:56:38  salvati
 * ratrapage de la perte du fichier
 *
 * Revision 1.4  2001/07/11 15:30:25  serasset
 * Suppression des tables author et threads. Utilisation d'une table unique "Dictionarys".
 *
 * Revision 1.3  2001/07/09 16:37:29  serasset
 * Liens entre l'application enhydra et la base de donnees PostgreSQL.
 * Suppression du dossier data de la hierarchie CVS
 * Premiere version de la mailing list.
 *
 * Revision 1.2  2001/07/04 12:50:43  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.logs;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

/**
 * Represents a Query Log. 
 */
public class QueryLog {


    public static final int MAX_LOGGED_RESULTS = 10;

    public static final String STORE_STRING = "Papillon.Logging.StoreQueryLogs";

    /**
     * The DO of the QueryLog.
     */
    protected QueryLogDO myDO = null;

    /**
     * The public constructor.
     */
    public QueryLog() throws PapillonBusinessException {
        try {
            this.myDO = QueryLogDO.createVirgin();  
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty QueryLog", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty QueryLog", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the QueryLog.
     */
    protected QueryLog(QueryLogDO theQueryLog) 
        throws PapillonBusinessException  {
        this.myDO = theQueryLog;
    }

    public boolean IsEmpty() {
        return (this.myDO==null) ;
    }


    /**
     * Gets the table name of the QueryLog
     *
     * @return the table name.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    /* FIXME: the method myDO.getTableName is protected, therefore, I can't
       use it. So I hard code the name of the database table ! 
    If one day, we stop to use dods ...*/
    public String getTableName()
        throws PapillonBusinessException {
	/*   try {
	      return this.myDO.getTableName();
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting QueryLogs's table name", ex);
        }*/
            return "querylogs";
    }   


    /**
     * Gets the object id for the QueryLog
     *
     * @return the object id.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getHandle()
        throws PapillonBusinessException {
        try {
            return this.myDO.getHandle();
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting QueryLogs's handle", ex);
        }
    }   

    /**
        * Get Date of the log
     *
     * @return Date of the log
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public java.sql.Date getDate () throws PapillonBusinessException {
        try {
            return this.myDO.getDate();
        } catch(DataObjectException  ex) {
            throw new PapillonBusinessException("Error getting date", ex);
        }
    }



    /**
     * Set date of the log
     *
     * @param date of the log
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDate ( java.sql.Date date ) throws PapillonBusinessException {
        try {
            myDO.setDate(date);
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting date", ex);
        }
    }



   /**
        * Set date
     *
     * @param date (as a java.util.Date) of the InformationDocument
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDate ( java.util.Date date ) throws PapillonBusinessException {
        try {
            myDO.setDate(new java.sql.Date(date.getTime()));
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting InformationDocument's FileType", ex);
        }
    }


    /**
     * Gets the login of the QueryLog
     *
     * @return the login.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getLogin() 
        throws PapillonBusinessException {
        try {
            return myDO.getLogin();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's date", ex);
        }
    }
    
    /**
     * Sets the login of the QueryLog
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	 public void setLogin(String login) 
        throws PapillonBusinessException {
        try {
            myDO.setLogin(login);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's login", ex);
        }
    }


    /**
     * Gets the formName of the QueryLog
     *
     * @return the formName.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getFormName() 
        throws PapillonBusinessException {
        try {
            return myDO.getFormName();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's form name", ex);
        }
    }
    /**
     * Sets the formName of the QueryLog
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setFormName(String formName) 
        throws PapillonBusinessException {
        try {
	    if (formName != null && formName.length()>50) {
		formName = formName.substring(0,49);
	    }
            myDO.setFormName(formName);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's form name", ex);
        }
    }
 


    /**
     * Gets the prefLang of the QueryLog
     *
     * @return the prefferred language.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getPrefLang() 
        throws PapillonBusinessException {
        try {
            return myDO.getPrefLang();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's prefferred language", ex);
        }
    }
    /**
     * Sets the preferred language of the QueryLog
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setPrefLang(String lang) 
        throws PapillonBusinessException {
        try {
	    if (lang != null && lang.length()>3) {
		lang = lang.substring(0,2);
	    }
            myDO.setPrefLang(lang);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's source language", ex);
        }
    }
 


    /**
     * Gets the headword query of the QueryLog
     *
     * @return the headword query.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getQuery() 
        throws PapillonBusinessException {
        try {
            return myDO.getQuery();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's headword query", ex);
        }
    }
    /**
     * Sets the headword query of the QueryLog
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setQuery(String query) 
        throws PapillonBusinessException {
        try {
	    if (query != null && query.length()>255) {
		query = query.substring(0,2);
	    }
            myDO.setQuery(query);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's headword query", ex);
        }
    }
 


    /**
     * Gets the headword results of the QueryLog
     *
     * @return the headword results.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getResults() 
        throws PapillonBusinessException {
        try {
            return myDO.getResults();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's headword results", ex);
        }
    }
    /**
     * Sets the headword results of the QueryLog
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setResults(String results) 
        throws PapillonBusinessException {
        try {
            myDO.setResults(results);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's headword results", ex);
        }
    }
 


    /**
     * Gets the source language of the QueryLog
     *
     * @return the source language of the query
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getSrcLang() 
        throws PapillonBusinessException {
        try {
            return myDO.getSrcLang();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's source language", ex);
        }
    }
    /**
     * Sets the source language of the query user
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setSrcLang(String lang) 
        throws PapillonBusinessException {
        try {
	    if (lang != null && lang.length()>3) {
		lang = lang.substring(0,2);
	    }
            myDO.setSrcLang(lang);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's source language", ex);
        }
    }
 

    /**
     * Gets the target languages of the QueryLog
     *
     * @return the target language of the query
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getTrgLangs() 
        throws PapillonBusinessException {
        try {
            return myDO.getTrgLangs();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's target languages", ex);
        }
    }
    /**
     * Sets the target languages of the query user
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setTrgLangs(String langs) 
        throws PapillonBusinessException {
        try {
	    if (langs != null && langs.length()>512) {
		langs = langs.substring(0,511);
	    }
            myDO.setTrgLangs(langs);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's targets languages", ex);
        }
    }
 

    /**
     * Gets the dictionaries of the QueryLog
     *
     * @return the dictionaries of the query
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getDicts() 
        throws PapillonBusinessException {
        try {
            return myDO.getDicts();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's dictionaries", ex);
        }
    }
    /**
     * Sets the dictionaries of the query user
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setDicts(String dicts) 
        throws PapillonBusinessException {
        try {
	    if (dicts != null && dicts.length()>1024) {
		dicts = dicts.substring(0,1023);
	    }
            myDO.setDicts(dicts);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's dictionaries", ex);
        }
    }
 

    /**
     * Gets the strategy of the QueryLog
     *
     * @return the strategy of the query
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getStrategy() 
        throws PapillonBusinessException {
        try {
            return myDO.getStrategy();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's strategy", ex);
        }
    }
    /**
     * Sets the strategy of the query user
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setStrategy(String strat) 
        throws PapillonBusinessException {
        try {
	    if (strat != null && strat.length()>255) {
		strat = strat.substring(0,254);
	    }
            myDO.setStrategy(strat);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's strategy", ex);
        }
    }
 

    /**
     * Gets the entire query string of the QueryLog
     *
     * @return the query string of the query
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getQueryString() 
        throws PapillonBusinessException {
        try {
            return myDO.getQueryString();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting QueryLog's query string", ex);
        }
    }
    /**
     * Sets the query string of the query user
     *
     * @return void.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    
	 public void setQueryString(String query) 
        throws PapillonBusinessException {
        try {
            myDO.setQueryString(query);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting QueryLog's query string", ex);
        }
    }
 


  

  
   
    public void save() 
        throws PapillonBusinessException {
        try {
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving QueryLog", ex);
        }
    }
    
    /**
     * Deletes the QueryLog from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
     *   error).
     */
    public void delete() 
        throws PapillonBusinessException {
        try {
            this.myDO.delete();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error deleting QueryLog", ex);
        }
    }
}
