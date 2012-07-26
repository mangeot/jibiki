
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
 * fr.imag.clips.papillon.data/VolumeDOI.java
 *-----------------------------------------------------------------------------
 */

package fr.imag.clips.papillon.data;

import java.io.*;
import java.sql.*;
import java.math.*;
import com.lutris.appserver.server.sql.*;
import com.lutris.dods.builder.generator.query.*;

/**
 * Interface implemented by VolumeDO
 * Interface could also be implemented by a (hand-written) Business Layer class
 * which uses VolumeDO
 *
 * @version $Revision: 1.6 $
 * @author  NN
 * @since   DODS Project
 */
public interface VolumeDOI {

    ////////////////////////// data member Name

    /**
     * Get name of the volumes
     *
     * @return name of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getName () 
    throws DataObjectException;
    

    /**
     * Set name of the volumes
     *
     * @param name of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setName ( String name )
    throws DataObjectException;

    ////////////////////////// data member Dictname

    /**
     * Get dictname of the volumes
     *
     * @return dictname of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getDictname () 
    throws DataObjectException;
    

    /**
     * Set dictname of the volumes
     *
     * @param dictname of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDictname ( String dictname )
    throws DataObjectException;

    ////////////////////////// data member Dbname

    /**
     * Get dbname of the volumes
     *
     * @return dbname of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getDbname () 
    throws DataObjectException;
    

    /**
     * Set dbname of the volumes
     *
     * @param dbname of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setDbname ( String dbname )
    throws DataObjectException;

    ////////////////////////// data member Location

    /**
     * Get location of the volumes
     *
     * @return location of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getLocation () 
    throws DataObjectException;
    

    /**
     * Set location of the volumes
     *
     * @param location of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setLocation ( String location )
    throws DataObjectException;

    ////////////////////////// data member SourceLanguage

    /**
     * Get sourceLanguage of the volumes
     *
     * @return sourceLanguage of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getSourceLanguage () 
    throws DataObjectException;
    

    /**
     * Set sourceLanguage of the volumes
     *
     * @param sourceLanguage of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setSourceLanguage ( String sourceLanguage )
    throws DataObjectException;

    ////////////////////////// data member TargetLanguages

    /**
     * Get targetLanguages of the volumes
     *
     * @return targetLanguages of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getTargetLanguages () 
    throws DataObjectException;
    

    /**
     * Set targetLanguages of the volumes
     *
     * @param targetLanguages of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setTargetLanguages ( String targetLanguages )
    throws DataObjectException;

    ////////////////////////// data member VolumeRef

    /**
     * Get volumeRef of the volumes
     *
     * @return volumeRef of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getVolumeRef () 
    throws DataObjectException;
    

    /**
     * Set volumeRef of the volumes
     *
     * @param volumeRef of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setVolumeRef ( String volumeRef )
    throws DataObjectException;

    ////////////////////////// data member XmlCode

    /**
     * Get xmlCode of the volumes
     *
     * @return xmlCode of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getXmlCode () 
    throws DataObjectException;
    

    /**
     * Set xmlCode of the volumes
     *
     * @param xmlCode of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setXmlCode ( String xmlCode )
    throws DataObjectException;

    ////////////////////////// data member XmlSchema

    /**
     * Get xmlSchema of the volumes
     *
     * @return xmlSchema of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getXmlSchema () 
    throws DataObjectException;
    

    /**
     * Set xmlSchema of the volumes
     *
     * @param xmlSchema of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setXmlSchema ( String xmlSchema )
    throws DataObjectException;

    ////////////////////////// data member TemplateItf

    /**
     * Get templateItf of the volumes
     *
     * @return templateItf of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getTemplateItf () 
    throws DataObjectException;
    

    /**
     * Set templateItf of the volumes
     *
     * @param templateItf of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setTemplateItf ( String templateItf )
    throws DataObjectException;

    ////////////////////////// data member TemplateEntry

    /**
     * Get templateEntry of the volumes
     *
     * @return templateEntry of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getTemplateEntry () 
    throws DataObjectException;
    

    /**
     * Set templateEntry of the volumes
     *
     * @param templateEntry of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setTemplateEntry ( String templateEntry )
    throws DataObjectException;

    ////////////////////////// data member Reverse

    /**
     * Get reverse of the volumes
     *
     * @return reverse of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public String getReverse () 
    throws DataObjectException;
    

    /**
     * Set reverse of the volumes
     *
     * @param reverse of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setReverse ( String reverse )
    throws DataObjectException;

    ////////////////////////// data member Entries

    /**
     * Get entries of the volumes
     *
     * @return entries of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public int getEntries () 
    throws DataObjectException;
    

    /**
     * Set entries of the volumes
     *
     * @param entries of the volumes
     *
     * @exception DataObjectException
     *   If the object is not found in the database.
     */
    public void setEntries ( int entries )
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
