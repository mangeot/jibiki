
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
 * fr.imag.clips.papillon.data/DictionaryDataStruct.java
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
public class DictionaryDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        DictionaryDataStruct ret =
            new DictionaryDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }

    /**
 * Full Name of the dictionary
 */
    private String fullName = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_FULLNAME = 0;
    

    /**
     * Sets FullName column.
     * @param _fullName new column value.
     */
    public void setFullName(String _fullName) {
        if (readOnly)
            throw new Error("This should never happen! setFullName on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(fullName, _fullName);
        fullName = _fullName;
//        return bDiff;
    }

    /**
     * Return value of FullName column.
     * @return value of FullName column.
     */
    public String getFullName() {
        return fullName;
    }

    /**
 * name of the dictionary (nickname)
 */
    private String name = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_NAME = 1;
    

    /**
     * Sets Name column.
     * @param _name new column value.
     */
    public void setName(String _name) {
        if (readOnly)
            throw new Error("This should never happen! setName on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(name, _name);
        name = _name;
//        return bDiff;
    }

    /**
     * Return value of Name column.
     * @return value of Name column.
     */
    public String getName() {
        return name;
    }

    /**
 * category of the dictionary
 * values taken from dml:categoryType type
 * (monolingual, bilingual, multilingual)
 */
    private String category = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_CATEGORY = 2;
    

    /**
     * Sets Category column.
     * @param _category new column value.
     */
    public void setCategory(String _category) {
        if (readOnly)
            throw new Error("This should never happen! setCategory on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(category, _category);
        category = _category;
//        return bDiff;
    }

    /**
     * Return value of Category column.
     * @return value of Category column.
     */
    public String getCategory() {
        return category;
    }

    /**
 * type of the dictionary
 * values taken from dml:dictType type
 * (monodirectional, bidirectional, pivot, mixed)
 */
    private String type = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_TYPE = 3;
    

    /**
     * Sets Type column.
     * @param _type new column value.
     */
    public void setType(String _type) {
        if (readOnly)
            throw new Error("This should never happen! setType on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(type, _type);
        type = _type;
//        return bDiff;
    }

    /**
     * Return value of Type column.
     * @return value of Type column.
     */
    public String getType() {
        return type;
    }

    /**
 * domain of the dictionary
 * (general, medecine, etc.)
 */
    private String domain = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DOMAIN = 4;
    

    /**
     * Sets Domain column.
     * @param _domain new column value.
     */
    public void setDomain(String _domain) {
        if (readOnly)
            throw new Error("This should never happen! setDomain on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(domain, _domain);
        domain = _domain;
//        return bDiff;
    }

    /**
     * Return value of Domain column.
     * @return value of Domain column.
     */
    public String getDomain() {
        return domain;
    }

    /**
 * legal rights associated with the dictionary
 */
    private String legal = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_LEGAL = 5;
    

    /**
     * Sets Legal column.
     * @param _legal new column value.
     */
    public void setLegal(String _legal) {
        if (readOnly)
            throw new Error("This should never happen! setLegal on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(legal, _legal);
        legal = _legal;
//        return bDiff;
    }

    /**
     * Return value of Legal column.
     * @return value of Legal column.
     */
    public String getLegal() {
        return legal;
    }

    /**
 * source languages of the dictionary
 * values taken from dml:lang type
 * (eng, fra, jpn, etc.)
 */
    private String sourceLanguages = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SOURCELANGUAGES = 6;
    

    /**
     * Sets SourceLanguages column.
     * @param _sourceLanguages new column value.
     */
    public void setSourceLanguages(String _sourceLanguages) {
        if (readOnly)
            throw new Error("This should never happen! setSourceLanguages on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(sourceLanguages, _sourceLanguages);
        sourceLanguages = _sourceLanguages;
//        return bDiff;
    }

    /**
     * Return value of SourceLanguages column.
     * @return value of SourceLanguages column.
     */
    public String getSourceLanguages() {
        return sourceLanguages;
    }

    /**
 * target languages of the dictionary
 * values taken from dml:lang type
 * (eng, fra, jpn, etc.)
 */
    private String targetLanguages = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_TARGETLANGUAGES = 7;
    

    /**
     * Sets TargetLanguages column.
     * @param _targetLanguages new column value.
     */
    public void setTargetLanguages(String _targetLanguages) {
        if (readOnly)
            throw new Error("This should never happen! setTargetLanguages on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(targetLanguages, _targetLanguages);
        targetLanguages = _targetLanguages;
//        return bDiff;
    }

    /**
     * Return value of TargetLanguages column.
     * @return value of TargetLanguages column.
     */
    public String getTargetLanguages() {
        return targetLanguages;
    }

    /**
 * The XML code of the dictionary entry.
 */
    private String xmlCode = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_XMLCODE = 8;
    

    /**
     * Sets XmlCode column.
     * @param _xmlCode new column value.
     */
    public void setXmlCode(String _xmlCode) {
        if (readOnly)
            throw new Error("This should never happen! setXmlCode on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(xmlCode, _xmlCode);
        xmlCode = _xmlCode;
//        return bDiff;
    }

    /**
     * Return value of XmlCode column.
     * @return value of XmlCode column.
     */
    public String getXmlCode() {
        return xmlCode;
    }

    /**
     * Used for query caching.
     */
    static public final int COLUMN_OID = 9;

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
              case COLUMN_FULLNAME:
                   return QueryBuilder.compare(getFullName(),cond.getValue(),cond.getOperator());

              case COLUMN_NAME:
                   return QueryBuilder.compare(getName(),cond.getValue(),cond.getOperator());

              case COLUMN_CATEGORY:
                   return QueryBuilder.compare(getCategory(),cond.getValue(),cond.getOperator());

              case COLUMN_TYPE:
                   return QueryBuilder.compare(getType(),cond.getValue(),cond.getOperator());

              case COLUMN_DOMAIN:
                   return QueryBuilder.compare(getDomain(),cond.getValue(),cond.getOperator());

              case COLUMN_LEGAL:
                   return QueryBuilder.compare(getLegal(),cond.getValue(),cond.getOperator());

              case COLUMN_SOURCELANGUAGES:
                   return QueryBuilder.compare(getSourceLanguages(),cond.getValue(),cond.getOperator());

              case COLUMN_TARGETLANGUAGES:
                   return QueryBuilder.compare(getTargetLanguages(),cond.getValue(),cond.getOperator());

              case COLUMN_XMLCODE:
                   return QueryBuilder.compare(getXmlCode(),cond.getValue(),cond.getOperator());


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
    public DictionaryDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        DictionaryDataStruct ret = new DictionaryDataStruct ();
        if (!isEmpty) {
            ret.fullName = GenericDO.copyString(fullName);
            ret.name = GenericDO.copyString(name);
            ret.category = GenericDO.copyString(category);
            ret.type = GenericDO.copyString(type);
            ret.domain = GenericDO.copyString(domain);
            ret.legal = GenericDO.copyString(legal);
            ret.sourceLanguages = GenericDO.copyString(sourceLanguages);
            ret.targetLanguages = GenericDO.copyString(targetLanguages);
            ret.xmlCode = GenericDO.copyString(xmlCode);

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
