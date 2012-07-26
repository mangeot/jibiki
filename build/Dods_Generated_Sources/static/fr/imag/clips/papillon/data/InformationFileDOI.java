
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
 * fr.imag.clips.papillon.data/InformationFileDOI.java
 *-----------------------------------------------------------------------------
 */

package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.*;

/**
 * Interface implemented by InformationFileDO
 * Interface could also be implemented by a (hand-written) Business Layer class
 * which uses InformationFileDO
 *
 * @version $Revision: 1.6 $
 * @author  NN
 * @since   DODS Project
 */
public interface InformationFileDOI {

    ////////////////////////// data member Filename

    /**
     * Get filename of the informationfiles
     *
     * @return filename of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getFilename () 
    throws DataObjectException;
    

    /**
     * Set filename of the informationfiles
     *
     * @param filename of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setFilename ( String filename )
    throws DataObjectException;

    ////////////////////////// data member Filetype

    /**
     * Get filetype of the informationfiles
     *
     * @return filetype of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getFiletype () 
    throws DataObjectException;
    

    /**
     * Set filetype of the informationfiles
     *
     * @param filetype of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setFiletype ( String filetype )
    throws DataObjectException;

    ////////////////////////// data member Document

    /**
     * Get document of the informationfiles
     *
     * @return document of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public fr.imag.clips.papillon.data.InformationDocumentDO getDocument () 
    throws DataObjectException;
    

    /**
     * Set document of the informationfiles
     *
     * @param document of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDocument ( fr.imag.clips.papillon.data.InformationDocumentDO document )
    throws DataObjectException;

    ////////////////////////// data member Filecode

    /**
     * Get filecode of the informationfiles
     *
     * @return filecode of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getFilecode () 
    throws DataObjectException;
    

    /**
     * Set filecode of the informationfiles
     *
     * @param filecode of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setFilecode ( String filecode )
    throws DataObjectException;

    ////////////////////////// data member IsIndexFile

    /**
     * Get isIndexFile of the informationfiles
     *
     * @return isIndexFile of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getIsIndexFile () 
    throws DataObjectException;
    

    /**
     * Set isIndexFile of the informationfiles
     *
     * @param isIndexFile of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setIsIndexFile ( String isIndexFile )
    throws DataObjectException;

    ////////////////////////// data member Language

    /**
     * Get language of the informationfiles
     *
     * @return language of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getLanguage () 
    throws DataObjectException;
    

    /**
     * Set language of the informationfiles
     *
     * @param language of the informationfiles
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLanguage ( String language )
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
