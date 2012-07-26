
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
 * fr.imag.clips.papillon.data/InformationDocumentDataStruct.java
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
public class InformationDocumentDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        InformationDocumentDataStruct ret =
            new InformationDocumentDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }

    /**
 * The author or authors of the document
 */
    private String author = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_AUTHOR = 0;
    

    /**
     * Sets Author column.
     * @param _author new column value.
     */
    public void setAuthor(String _author) {
        if (readOnly)
            throw new Error("This should never happen! setAuthor on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(author, _author);
        author = _author;
//        return bDiff;
    }

    /**
     * Return value of Author column.
     * @return value of Author column.
     */
    public String getAuthor() {
        return author;
    }

    /**
 * login of the owner of the document, who uploaded the document ot the database.
 */
    private String owner = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_OWNER = 1;
    

    /**
     * Sets Owner column.
     * @param _owner new column value.
     */
    public void setOwner(String _owner) {
        if (readOnly)
            throw new Error("This should never happen! setOwner on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(owner, _owner);
        owner = _owner;
//        return bDiff;
    }

    /**
     * Return value of Owner column.
     * @return value of Owner column.
     */
    public String getOwner() {
        return owner;
    }

    /**
 * The reference of the document if it is a publication, pages,number, conference, etc.
 */
    private String reference = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_REFERENCE = 2;
    

    /**
     * Sets Reference column.
     * @param _reference new column value.
     */
    public void setReference(String _reference) {
        if (readOnly)
            throw new Error("This should never happen! setReference on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(reference, _reference);
        reference = _reference;
//        return bDiff;
    }

    /**
     * Return value of Reference column.
     * @return value of Reference column.
     */
    public String getReference() {
        return reference;
    }
    
    private java.sql.Date creationDate = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_CREATIONDATE = 3;
    

    /**
     * Sets CreationDate column.
     * @param _creationDate new column value.
     */
    public void setCreationDate(java.sql.Date _creationDate) {
        if (readOnly)
            throw new Error("This should never happen! setCreationDate on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_java_sql_Date(creationDate, _creationDate);
        creationDate = _creationDate;
//        return bDiff;
    }

    /**
     * Return value of CreationDate column.
     * @return value of CreationDate column.
     */
    public java.sql.Date getCreationDate() {
        return creationDate;
    }

    /**
 * The section in which the document will appear.
 */
    private String section = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SECTION = 4;
    

    /**
     * Sets Section column.
     * @param _section new column value.
     */
    public void setSection(String _section) {
        if (readOnly)
            throw new Error("This should never happen! setSection on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(section, _section);
        section = _section;
//        return bDiff;
    }

    /**
     * Return value of Section column.
     * @return value of Section column.
     */
    public String getSection() {
        return section;
    }

    /**
 * The title of the document
 */
    private String title = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_TITLE = 5;
    

    /**
     * Sets Title column.
     * @param _title new column value.
     */
    public void setTitle(String _title) {
        if (readOnly)
            throw new Error("This should never happen! setTitle on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(title, _title);
        title = _title;
//        return bDiff;
    }

    /**
     * Return value of Title column.
     * @return value of Title column.
     */
    public String getTitle() {
        return title;
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
              case COLUMN_AUTHOR:
                   return QueryBuilder.compare(getAuthor(),cond.getValue(),cond.getOperator());

              case COLUMN_OWNER:
                   return QueryBuilder.compare(getOwner(),cond.getValue(),cond.getOperator());

              case COLUMN_REFERENCE:
                   return QueryBuilder.compare(getReference(),cond.getValue(),cond.getOperator());

              case COLUMN_CREATIONDATE:
                   return QueryBuilder.compare(getCreationDate(),cond.getValue(),cond.getOperator());

              case COLUMN_SECTION:
                   return QueryBuilder.compare(getSection(),cond.getValue(),cond.getOperator());

              case COLUMN_TITLE:
                   return QueryBuilder.compare(getTitle(),cond.getValue(),cond.getOperator());


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
    public InformationDocumentDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        InformationDocumentDataStruct ret = new InformationDocumentDataStruct ();
        if (!isEmpty) {
            ret.author = GenericDO.copyString(author);
            ret.owner = GenericDO.copyString(owner);
            ret.reference = GenericDO.copyString(reference);
            ret.creationDate = GenericDO.copyDate(creationDate);
            ret.section = GenericDO.copyString(section);
            ret.title = GenericDO.copyString(title);

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
