
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
 * fr.imag.clips.papillon.data/MessageDOI.java
 *-----------------------------------------------------------------------------
 */

package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.*;

/**
 * Interface implemented by MessageDO
 * Interface could also be implemented by a (hand-written) Business Layer class
 * which uses MessageDO
 *
 * @version $Revision: 1.6 $
 * @author  NN
 * @since   DODS Project
 */
public interface MessageDOI {

    ////////////////////////// data member Date

    /**
     * Get date of the messages
     *
     * @return date of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public java.sql.Date getDate () 
    throws DataObjectException;
    

    /**
     * Set date of the messages
     *
     * @param date of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDate ( java.sql.Date date )
    throws DataObjectException;

    ////////////////////////// data member Msg

    /**
     * Get msg of the messages
     *
     * @return msg of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getMsg () 
    throws DataObjectException;
    

    /**
     * Set msg of the messages
     *
     * @param msg of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setMsg ( String msg )
    throws DataObjectException;

    ////////////////////////// data member Msgid

    /**
     * Get msgid of the messages
     *
     * @return msgid of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getMsgid () 
    throws DataObjectException;
    

    /**
     * Set msgid of the messages
     *
     * @param msgid of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setMsgid ( String msgid )
    throws DataObjectException;

    ////////////////////////// data member Subject

    /**
     * Get subject of the messages
     *
     * @return subject of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getSubject () 
    throws DataObjectException;
    

    /**
     * Set subject of the messages
     *
     * @param subject of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setSubject ( String subject )
    throws DataObjectException;

    ////////////////////////// data member Author

    /**
     * Get author of the messages
     *
     * @return author of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getAuthor () 
    throws DataObjectException;
    

    /**
     * Set author of the messages
     *
     * @param author of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setAuthor ( String author )
    throws DataObjectException;

    ////////////////////////// data member AuthorAddress

    /**
     * Get authorAddress of the messages
     *
     * @return authorAddress of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getAuthorAddress () 
    throws DataObjectException;
    

    /**
     * Set authorAddress of the messages
     *
     * @param authorAddress of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setAuthorAddress ( String authorAddress )
    throws DataObjectException;

    ////////////////////////// data member Thread

    /**
     * Get thread of the messages
     *
     * @return thread of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getThread () 
    throws DataObjectException;
    

    /**
     * Set thread of the messages
     *
     * @param thread of the messages
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setThread ( String thread )
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
