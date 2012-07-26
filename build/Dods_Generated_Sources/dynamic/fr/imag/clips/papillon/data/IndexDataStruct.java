
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
 * fr.imag.clips.papillon.data/IndexDataStruct.java
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
 * @version $Revision: 2 $
 * @author  NN
 * @since   DODS Project;
 */
public class IndexDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        IndexDataStruct ret =
            new IndexDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }

    /**
 * the name of the key
 */
    private String key = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_KEY = 0;
    

    /**
     * Sets Key column.
     * @param _key new column value.
     */
    public void setKey(String _key) {
        if (readOnly)
            throw new Error("This should never happen! setKey on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(key, _key);
        key = _key;
//        return bDiff;
    }

    /**
     * Return value of Key column.
     * @return value of Key column.
     */
    public String getKey() {
        return key;
    }

    /**
 * the language of the value of the key
 */
    private String lang = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_LANG = 1;
    

    /**
     * Sets Lang column.
     * @param _lang new column value.
     */
    public void setLang(String _lang) {
        if (readOnly)
            throw new Error("This should never happen! setLang on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(lang, _lang);
        lang = _lang;
//        return bDiff;
    }

    /**
     * Return value of Lang column.
     * @return value of Lang column.
     */
    public String getLang() {
        return lang;
    }

    /**
 * the value of the key
 */
    private String value = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_VALUE = 2;
    

    /**
     * Sets Value column.
     * @param _value new column value.
     */
    public void setValue(String _value) {
        if (readOnly)
            throw new Error("This should never happen! setValue on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(value, _value);
        value = _value;
//        return bDiff;
    }

    /**
     * Return value of Value column.
     * @return value of Value column.
     */
    public String getValue() {
        return value;
    }

    /**
 * plpsql function: multilingual_sort(lang,value)
 */
    private String msort = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_MSORT = 3;
    

    /**
     * Sets Msort column.
     * @param _msort new column value.
     */
    public void setMsort(String _msort) {
        if (readOnly)
            throw new Error("This should never happen! setMsort on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(msort, _msort);
        msort = _msort;
//        return bDiff;
    }

    /**
     * Return value of Msort column.
     * @return value of Msort column.
     */
    public String getMsort() {
        return msort;
    }

    /**
 * the entry id
 */
    private int entryId = 0;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_ENTRYID = 4;
    

    /**
     * Sets EntryId column.
     * @param _entryId new column value.
     */
    public void setEntryId(int _entryId) {
        if (readOnly)
            throw new Error("This should never happen! setEntryId on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_int(entryId, _entryId);
        entryId = _entryId;
//        return bDiff;
    }

    /**
     * Return value of EntryId column.
     * @return value of EntryId column.
     */
    public int getEntryId() {
        return entryId;
    }

    /**
     * Used for query caching.
     */
    static public final int COLUMN_OID = 5;

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
              case COLUMN_KEY:
                   return QueryBuilder.compare(getKey(),cond.getValue(),cond.getOperator());

              case COLUMN_LANG:
                   return QueryBuilder.compare(getLang(),cond.getValue(),cond.getOperator());

              case COLUMN_VALUE:
                   return QueryBuilder.compare(getValue(),cond.getValue(),cond.getOperator());

              case COLUMN_MSORT:
                   return QueryBuilder.compare(getMsort(),cond.getValue(),cond.getOperator());

              case COLUMN_ENTRYID:
                   return QueryBuilder.compare(getEntryId(),cond.getValue(),cond.getOperator());


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
    public IndexDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        IndexDataStruct ret = new IndexDataStruct ();
        if (!isEmpty) {
            ret.key = GenericDO.copyString(key);
            ret.lang = GenericDO.copyString(lang);
            ret.value = GenericDO.copyString(value);
            ret.msort = GenericDO.copyString(msort);
            ret.entryId = entryId;

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
