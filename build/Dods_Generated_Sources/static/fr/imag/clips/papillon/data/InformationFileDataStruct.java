
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
 *    This product includes Enhydra software developed by Lutris
 *    Technologies, Inc. and its contributors.
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
 * fr.imag.clips.papillon.data/InformationFileDataStruct.java
 *-----------------------------------------------------------------------------
 */


package fr.imag.clips.papillon.data;

import com.lutris.appserver.server.sql.*;
import java.sql.*;
import java.math.*;
import java.io.Serializable;
import com.lutris.dods.builder.generator.dataobject.*;
import com.lutris.dods.builder.generator.query.*;
import org.enhydra.dods.cache.Condition;


/**
 * Data structure for DO class.
 * A container for data members of a DO class.
 * A DO class contains a reference to a DataStruct class.  This reference
 * can be null (a DO whose data has not yet been retrieved from the database),
 * allowing a DO object to be a lightweight placeholder until its data is needed.
 *
 * @version $Revision: 1.17 $
 * @author  NN
 * @since   DODS Project;
 */
public class InformationFileDataStruct extends CoreDataStruct implements Cloneable, Serializable {

    /**
     * A DO refers to this DataStruct.
     * readOnly is set to true when the DO is stored in its class cache.
     */
    public boolean readOnly = false;

    /**
     * Since originalData is being constructed for every DO, this flag
     * "knows" if DataStruct has any useful content.
     */
    protected boolean isEmpty = true;

    /**
     * String identifying logical database this DataStruct belongs to.
     */
    private String databaseName = null;

    private byte[] copyByteArray( byte[] source ) {
        byte[] dest = new byte[ source.length ];
        System.arraycopy( source, 0, dest, 0, source.length );
        return dest;
    }

    /**
     * Returns DataStruct's version.    
     * @return DataStruct's version.    
     */
    protected int getVersion () {
        return get_Version();
    }

    /**
     * Returns DataStruct's version.    
     * @return DataStruct's version.    
     */
    protected int get_Version () {
        return super.get_Version();
    }

    /**
     * Sets DataStruct's version.
     * @param v new DataStruct's version.
     */
    protected void setVersion (int v) {
        set_Version(v);
    }

    /**
     * Sets DataStruct's version.
     * @param v new DataStruct's version.
     */
    protected void set_Version (int v) {
        super.set_Version(v);
    }

    /**
     * Returns this object's identifier.
     * @return this object's identifier.
     */
    public ObjectId getOId() {
	   return get_OId();
    }

    /**
     * Returns this object's identifier.
     * @return this object's identifier.
     */
    public ObjectId get_OId() {
	return super.get_OId();
    }

    /**
     * @deprecated Use set_OId()
     * @param oId this object's identifier.
     */
    protected void setOId(ObjectId oId) {
    	set_OId(oId);
    }

    /**
     * Sets this object's identifier.
     * @param oId this object's identifier.
     */
    protected void set_OId(ObjectId oId) {
    	super.set_OId(oId);
        __the_handle = oId.toString();
    }
    private String __the_handle;
    

    /**
     * Returns this object's handle (identifier as a string).
     * @return This object's identifier as a string.
     *
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public String  get_Handle()
    throws DatabaseManagerException {
        String ret = null;
        if (null == __the_handle)
               throw new DatabaseManagerException( "ID not set " );
        //ret = get_OId().toString();
        return __the_handle;
    }


    /**
     * Returns this object's cache handle (String in the form:
     * "<database_name>.<indetifier_as_String>").
     *
     * @return cache handle.
     * @exception DatabaseManagerException
     *   If a connection to the database cannot be established, etc.
     */
    public String  get_CacheHandle()throws DatabaseManagerException {
        String ret = get_Database() + "." + get_Handle();
        return ret;
    }



    /**
     * @param dbName - name of the logical database this DataStruct should belong to.
     */
    public void set_Database(String dbName) {
         if (null != databaseName)
             throw new Error("Whatta hack you are doing! Multiple db setting not allowed.");
         databaseName = dbName;
    }


    /**
     * @return name of the logical database this DataStruct belongs to.
     */
    public String get_Database() {
         return databaseName;
    }

    public CoreDataStruct dumpData(boolean incrementVersion) {
        InformationFileDataStruct ret =
            new InformationFileDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }
    
    private String filename = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_FILENAME = 0;
    

    /**
     * Sets Filename column.
     * @param _filename new column value.
     */
    public void setFilename(String _filename) {
        if (readOnly)
            throw new Error("This should never happen! setFilename on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(filename, _filename);
        filename = _filename;
//        return bDiff;
    }

    /**
     * Return value of Filename column.
     * @return value of Filename column.
     */
    public String getFilename() {
        return filename;
    }
    
    private String filetype = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_FILETYPE = 1;
    

    /**
     * Sets Filetype column.
     * @param _filetype new column value.
     */
    public void setFiletype(String _filetype) {
        if (readOnly)
            throw new Error("This should never happen! setFiletype on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(filetype, _filetype);
        filetype = _filetype;
//        return bDiff;
    }

    /**
     * Return value of Filetype column.
     * @return value of Filetype column.
     */
    public String getFiletype() {
        return filetype;
    }

    /**
 * The document this file belongs to.
 */
    private BigDecimal document =  null ;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DOCUMENT = 2;
    

    /**
     * Sets Document column.
     * @param _document new column value.
     */
    public void setDocument(BigDecimal _document) {
        if (readOnly)
            throw new Error("This should never happen! setDocument on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_BigDecimal(document, _document);
        document = _document;
//        return bDiff;
    }

    /**
     * Return value of Document column.
     * @return value of Document column.
     */
    public BigDecimal getDocument() {
        return document;
    }
    
    private String filecode = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_FILECODE = 3;
    

    /**
     * Sets Filecode column.
     * @param _filecode new column value.
     */
    public void setFilecode(String _filecode) {
        if (readOnly)
            throw new Error("This should never happen! setFilecode on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(filecode, _filecode);
        filecode = _filecode;
//        return bDiff;
    }

    /**
     * Return value of Filecode column.
     * @return value of Filecode column.
     */
    public String getFilecode() {
        return filecode;
    }

    /**
 * States if the file is the index of its document
 * Only one file per document should be the index file...
 */
    private String isIndexFile = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_ISINDEXFILE = 4;
    

    /**
     * Sets IsIndexFile column.
     * @param _isIndexFile new column value.
     */
    public void setIsIndexFile(String _isIndexFile) {
        if (readOnly)
            throw new Error("This should never happen! setIsIndexFile on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(isIndexFile, _isIndexFile);
        isIndexFile = _isIndexFile;
//        return bDiff;
    }

    /**
     * Return value of IsIndexFile column.
     * @return value of IsIndexFile column.
     */
    public String getIsIndexFile() {
        return isIndexFile;
    }

    /**
 * The language of the file
 */
    private String language = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_LANGUAGE = 5;
    

    /**
     * Sets Language column.
     * @param _language new column value.
     */
    public void setLanguage(String _language) {
        if (readOnly)
            throw new Error("This should never happen! setLanguage on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(language, _language);
        language = _language;
//        return bDiff;
    }

    /**
     * Return value of Language column.
     * @return value of Language column.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Used for query caching.
     */
    static public final int COLUMN_OID = 6;

    /**
     * Compares whether this DataStruct object satisfies condition cond.
     *
     * @param cond Condition of the query.
     *
     * @return true if this DataStruct object satisfies condition of this query,
     * otherwise false.
     */
    public boolean compareCond(Condition cond) {
        try {
            switch (cond.getColumnIndex()) {
              case COLUMN_FILENAME:
                   return QueryBuilder.compare(getFilename(),cond.getValue(),cond.getOperator());

              case COLUMN_FILETYPE:
                   return QueryBuilder.compare(getFiletype(),cond.getValue(),cond.getOperator());

              case COLUMN_DOCUMENT:
                   return QueryBuilder.compare(getDocument(),cond.getValue(),cond.getOperator());

              case COLUMN_FILECODE:
                   return QueryBuilder.compare(getFilecode(),cond.getValue(),cond.getOperator());

              case COLUMN_ISINDEXFILE:
                   return QueryBuilder.compare(getIsIndexFile(),cond.getValue(),cond.getOperator());

              case COLUMN_LANGUAGE:
                   return QueryBuilder.compare(getLanguage(),cond.getValue(),cond.getOperator());


                case COLUMN_OID:
                    return QueryBuilder.compare(get_CacheHandle(),cond.getValue(),cond.getOperator());
            }
        } catch (Exception e) {
          System.out.println("**************************  compareCond catck blok");
        }
        return false;
    }

    /**
     * Create a copy of the guts of a DO.
     *
     * @return Copied DataStruct object.
     *
     * @exception DatabaseManagerException 
     *       if createExisting() fails for a contained DO
     * @exception ObjectIdException 
     *       if GenericDO has trouble obtaining a valid id.
     */
    public InformationFileDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        InformationFileDataStruct ret = new InformationFileDataStruct ();
        if (!isEmpty) {
            ret.filename = GenericDO.copyString(filename);
            ret.filetype = GenericDO.copyString(filetype);
            ret.document = GenericDO.copyBigDecimal(document);
            ret.filecode = GenericDO.copyString(filecode);
            ret.isIndexFile = GenericDO.copyString(isIndexFile);
            ret.language = GenericDO.copyString(language);

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
