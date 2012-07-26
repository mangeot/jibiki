
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
 * fr.imag.clips.papillon.data/ContributionLogDOI.java
 *-----------------------------------------------------------------------------
 */

package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.*;

/**
 * Interface implemented by ContributionLogDO
 * Interface could also be implemented by a (hand-written) Business Layer class
 * which uses ContributionLogDO
 *
 * @version $Revision: 1.6 $
 * @author  NN
 * @since   DODS Project
 */
public interface ContributionLogDOI {

    ////////////////////////// data member Author

    /**
     * Get author of the contributionlog
     *
     * @return author of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getAuthor () 
    throws DataObjectException;
    

    /**
     * Set author of the contributionlog
     *
     * @param author of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setAuthor ( String author )
    throws DataObjectException;

    ////////////////////////// data member Groups

    /**
     * Get groups of the contributionlog
     *
     * @return groups of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getGroups () 
    throws DataObjectException;
    

    /**
     * Set groups of the contributionlog
     *
     * @param groups of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setGroups ( String groups )
    throws DataObjectException;

    ////////////////////////// data member Volume

    /**
     * Get volume of the contributionlog
     *
     * @return volume of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getVolume () 
    throws DataObjectException;
    

    /**
     * Set volume of the contributionlog
     *
     * @param volume of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setVolume ( String volume )
    throws DataObjectException;

    ////////////////////////// data member SourceLanguage

    /**
     * Get sourceLanguage of the contributionlog
     *
     * @return sourceLanguage of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getSourceLanguage () 
    throws DataObjectException;
    

    /**
     * Set sourceLanguage of the contributionlog
     *
     * @param sourceLanguage of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setSourceLanguage ( String sourceLanguage )
    throws DataObjectException;

    ////////////////////////// data member Headword

    /**
     * Get headword of the contributionlog
     *
     * @return headword of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getHeadword () 
    throws DataObjectException;
    

    /**
     * Set headword of the contributionlog
     *
     * @param headword of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setHeadword ( String headword )
    throws DataObjectException;

    ////////////////////////// data member ContributionId

    /**
     * Get contributionId of the contributionlog
     *
     * @return contributionId of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getContributionId () 
    throws DataObjectException;
    

    /**
     * Set contributionId of the contributionlog
     *
     * @param contributionId of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setContributionId ( String contributionId )
    throws DataObjectException;

    ////////////////////////// data member EntryId

    /**
     * Get entryId of the contributionlog
     *
     * @return entryId of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getEntryId () 
    throws DataObjectException;
    

    /**
     * Set entryId of the contributionlog
     *
     * @param entryId of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setEntryId ( String entryId )
    throws DataObjectException;

    ////////////////////////// data member Date

    /**
     * Get date of the contributionlog
     *
     * @return date of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public java.sql.Timestamp getDate () 
    throws DataObjectException;
    

    /**
     * Set date of the contributionlog
     *
     * @param date of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDate ( java.sql.Timestamp date )
    throws DataObjectException;

    ////////////////////////// data member Status

    /**
     * Get status of the contributionlog
     *
     * @return status of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getStatus () 
    throws DataObjectException;
    

    /**
     * Set status of the contributionlog
     *
     * @param status of the contributionlog
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setStatus ( String status )
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
