
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
 * fr.imag.clips.papillon.data/UserDOI.java
 *-----------------------------------------------------------------------------
 */

package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.*;

/**
 * Interface implemented by UserDO
 * Interface could also be implemented by a (hand-written) Business Layer class
 * which uses UserDO
 *
 * @version $Revision: 1.6 $
 * @author  NN
 * @since   DODS Project
 */
public interface UserDOI {

    ////////////////////////// data member Name

    /**
     * Get name of the users
     *
     * @return name of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getName () 
    throws DataObjectException;
    

    /**
     * Set name of the users
     *
     * @param name of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setName ( String name )
    throws DataObjectException;

    ////////////////////////// data member Login

    /**
     * Get login of the users
     *
     * @return login of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getLogin () 
    throws DataObjectException;
    

    /**
     * Set login of the users
     *
     * @param login of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLogin ( String login )
    throws DataObjectException;

    ////////////////////////// data member Password

    /**
     * Get password of the users
     *
     * @return password of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public byte[] getPassword () 
    throws DataObjectException;
    

    /**
     * Set password of the users
     *
     * @param password of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setPassword ( byte[] password )
    throws DataObjectException;

    ////////////////////////// data member Email

    /**
     * Get email of the users
     *
     * @return email of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getEmail () 
    throws DataObjectException;
    

    /**
     * Set email of the users
     *
     * @param email of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setEmail ( String email )
    throws DataObjectException;

    ////////////////////////// data member Lang

    /**
     * Get lang of the users
     *
     * @return lang of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getLang () 
    throws DataObjectException;
    

    /**
     * Set lang of the users
     *
     * @param lang of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLang ( String lang )
    throws DataObjectException;

    ////////////////////////// data member Groups

    /**
     * Get groups of the users
     *
     * @return groups of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getGroups () 
    throws DataObjectException;
    

    /**
     * Set groups of the users
     *
     * @param groups of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setGroups ( String groups )
    throws DataObjectException;

    ////////////////////////// data member Credits

    /**
     * Get credits of the users
     *
     * @return credits of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public int getCredits () 
    throws DataObjectException;
    

    /**
     * Set credits of the users
     *
     * @param credits of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setCredits ( int credits )
    throws DataObjectException;

    ////////////////////////// data member XmlCode

    /**
     * Get xmlCode of the users
     *
     * @return xmlCode of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getXmlCode () 
    throws DataObjectException;
    

    /**
     * Set xmlCode of the users
     *
     * @param xmlCode of the users
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setXmlCode ( String xmlCode )
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
