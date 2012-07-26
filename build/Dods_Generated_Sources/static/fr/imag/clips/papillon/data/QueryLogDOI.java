
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
 *      This product includes Enhydra software developed by Lutris
 *      Technologies, Inc. and its contributors.
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
 *-----------------------------------------------------------------------------
 * fr.imag.clips.papillon.data/QueryLogDOI.java
 *-----------------------------------------------------------------------------
 */

package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.*;

/**
 * Interface implemented by QueryLogDO
 * Interface could also be implemented by a (hand-written) Business Layer class
 * which uses QueryLogDO
 *
 * @version $Revision: 1.6 $
 * @author  NN
 * @since   DODS Project
 */
public interface QueryLogDOI {

    ////////////////////////// data member Date

    /**
     * Get date of the querylogs
     *
     * @return date of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public java.sql.Date getDate () 
    throws DataObjectException;
    

    /**
     * Set date of the querylogs
     *
     * @param date of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDate ( java.sql.Date date )
    throws DataObjectException;

    ////////////////////////// data member Login

    /**
     * Get login of the querylogs
     *
     * @return login of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getLogin () 
    throws DataObjectException;
    

    /**
     * Set login of the querylogs
     *
     * @param login of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLogin ( String login )
    throws DataObjectException;

    ////////////////////////// data member FormName

    /**
     * Get formName of the querylogs
     *
     * @return formName of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getFormName () 
    throws DataObjectException;
    

    /**
     * Set formName of the querylogs
     *
     * @param formName of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setFormName ( String formName )
    throws DataObjectException;

    ////////////////////////// data member PrefLang

    /**
     * Get prefLang of the querylogs
     *
     * @return prefLang of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getPrefLang () 
    throws DataObjectException;
    

    /**
     * Set prefLang of the querylogs
     *
     * @param prefLang of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setPrefLang ( String prefLang )
    throws DataObjectException;

    ////////////////////////// data member Query

    /**
     * Get query of the querylogs
     *
     * @return query of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getQuery () 
    throws DataObjectException;
    

    /**
     * Set query of the querylogs
     *
     * @param query of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setQuery ( String query )
    throws DataObjectException;

    ////////////////////////// data member Results

    /**
     * Get results of the querylogs
     *
     * @return results of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getResults () 
    throws DataObjectException;
    

    /**
     * Set results of the querylogs
     *
     * @param results of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setResults ( String results )
    throws DataObjectException;

    ////////////////////////// data member SrcLang

    /**
     * Get srcLang of the querylogs
     *
     * @return srcLang of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getSrcLang () 
    throws DataObjectException;
    

    /**
     * Set srcLang of the querylogs
     *
     * @param srcLang of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setSrcLang ( String srcLang )
    throws DataObjectException;

    ////////////////////////// data member TrgLangs

    /**
     * Get trgLangs of the querylogs
     *
     * @return trgLangs of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getTrgLangs () 
    throws DataObjectException;
    

    /**
     * Set trgLangs of the querylogs
     *
     * @param trgLangs of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setTrgLangs ( String trgLangs )
    throws DataObjectException;

    ////////////////////////// data member Dicts

    /**
     * Get dicts of the querylogs
     *
     * @return dicts of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getDicts () 
    throws DataObjectException;
    

    /**
     * Set dicts of the querylogs
     *
     * @param dicts of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDicts ( String dicts )
    throws DataObjectException;

    ////////////////////////// data member Strategy

    /**
     * Get strategy of the querylogs
     *
     * @return strategy of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getStrategy () 
    throws DataObjectException;
    

    /**
     * Set strategy of the querylogs
     *
     * @param strategy of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setStrategy ( String strategy )
    throws DataObjectException;

    ////////////////////////// data member QueryString

    /**
     * Get queryString of the querylogs
     *
     * @return queryString of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getQueryString () 
    throws DataObjectException;
    

    /**
     * Set queryString of the querylogs
     *
     * @param queryString of the querylogs
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setQueryString ( String queryString )
    throws DataObjectException;

    /**
     * Inserts/Updates the DO into its table.
     *
     * @exception java.sql.SQLException if any SQL errors occur.
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException if a Transaction can not be created.
     * @exception DataObjectException
     * @exception RefAssertionException thrown by okTo method.
     * @exception DBRowUpdateException
     * @exception QueryException
     */
    public void save() 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException;
    
    /**
     * Inserts/Updates the DO into its table.
     * The transaction is likely provided by the save() method of another DO
     * which references this DO.
     * 
     * @param dbt The transaction object to use for this operation.
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException if a Transaction can not be created.
     * @exception com.lutris.appserver.server.sql.DBRowUpdateException if a version error occurs.
     * @exception RefAssertionException thrown by okTo method.
     * @exception java.sql.SQLException if any SQL errors occur.
     * @exception DataObjectException
     * @exception QueryException
     */
    public void save(DBTransaction dbt)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException;
    
    /**
     * Inserts/Updates the DO into its table.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException if a Transaction can not be created.
     * @exception RefAssertionException thrown by okTo method.
     * @exception java.sql.SQLException if any SQL errors occur.
     * @exception DataObjectException
     * @exception DBRowUpdateException 
     * @exception QueryException 
     * @deprecated Use save() instead.
     */
    public void commit() 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException;
    
    /**
     * Inserts/Updates the DO into its table.
     * The transaction is likely provided by the commit() method of another DO
     * which references this DO.
     * 
     * @param dbt The transaction object to use for this operation.
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException if a Transaction can not be created.
     * @exception com.lutris.appserver.server.sql.DBRowUpdateException if a version error occurs.
     * @exception RefAssertionException thrown by okTo method.
     * @exception java.sql.SQLException if any SQL errors occur.
     * @exception DataObjectException
     * @exception QueryException 
     * @deprecated Use save() instead.
     */
    public void commit(DBTransaction dbt)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException;
    
    /**
     * Deletes the DO from its table.
     *
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException if a Transaction can not be created.
     * @exception RefAssertionException thrown by okTo method.
     * @exception java.sql.SQLException if any SQL errors occur.
     * @exception DataObjectException
     * @exception DBRowUpdateException 
     * @exception QueryException 
     */
    public void delete() 
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException;
    
    /**
     * Deletes the DO from its table.
     * The transaction is likely provided by the delete() method of another DO
     * which references this DO.
     *
     * @param dbt The transaction object to use for this operation.
     * @exception com.lutris.appserver.server.sql.DatabaseManagerException if a Transaction can not be created.
     * @exception com.lutris.appserver.server.sql.DBRowUpdateException if a version error occurs.
     * @exception RefAssertionException thrown by okTo method.
     * @exception java.sql.SQLException if any SQL errors occur.
     * @exception DataObjectException 
     * @exception QueryException
     */
    public void delete(DBTransaction dbt)
    throws SQLException, DatabaseManagerException, DataObjectException, RefAssertionException, DBRowUpdateException, QueryException;

}
