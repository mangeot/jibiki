
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
 * fr.imag.clips.papillon.data/IndexDOI.java
 *-----------------------------------------------------------------------------
 */

package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.*;

/**
 * Interface implemented by IndexDO
 * Interface could also be implemented by a (hand-written) Business Layer class
 * which uses IndexDO
 *
 * @version $Revision: 2 $
 * @author  NN
 * @since   DODS Project
 */
public interface IndexDOI {

    ////////////////////////// data member Key

    /**
     * Get key of the index
     *
     * @return key of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getKey () 
    throws DataObjectException;
    

    /**
     * Set key of the index
     *
     * @param key of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setKey ( String key )
    throws DataObjectException;

    ////////////////////////// data member Lang

    /**
     * Get lang of the index
     *
     * @return lang of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getLang () 
    throws DataObjectException;
    

    /**
     * Set lang of the index
     *
     * @param lang of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLang ( String lang )
    throws DataObjectException;

    ////////////////////////// data member Value

    /**
     * Get value of the index
     *
     * @return value of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getValue () 
    throws DataObjectException;
    

    /**
     * Set value of the index
     *
     * @param value of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setValue ( String value )
    throws DataObjectException;

    ////////////////////////// data member Msort

    /**
     * Get msort of the index
     *
     * @return msort of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getMsort () 
    throws DataObjectException;
    

    /**
     * Set msort of the index
     *
     * @param msort of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setMsort ( String msort )
    throws DataObjectException;

    ////////////////////////// data member EntryId

    /**
     * Get entryId of the index
     *
     * @return entryId of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public int getEntryId () 
    throws DataObjectException;
    

    /**
     * Set entryId of the index
     *
     * @param entryId of the index
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setEntryId ( int entryId )
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
