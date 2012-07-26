
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
 * fr.imag.clips.papillon.data/VolumeDataStruct.java
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
public class VolumeDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        VolumeDataStruct ret =
            new VolumeDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }

    /**
 * Name of the volume
 */
    private String name = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_NAME = 0;
    

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
 * Name of the dictionary that contains this volume
 */
    private String dictname = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DICTNAME = 1;
    

    /**
     * Sets Dictname column.
     * @param _dictname new column value.
     */
    public void setDictname(String _dictname) {
        if (readOnly)
            throw new Error("This should never happen! setDictname on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(dictname, _dictname);
        dictname = _dictname;
//        return bDiff;
    }

    /**
     * Return value of Dictname column.
     * @return value of Dictname column.
     */
    public String getDictname() {
        return dictname;
    }

    /**
 * Name of the database table where the volume entries are stored
 */
    private String dbname = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DBNAME = 2;
    

    /**
     * Sets Dbname column.
     * @param _dbname new column value.
     */
    public void setDbname(String _dbname) {
        if (readOnly)
            throw new Error("This should never happen! setDbname on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(dbname, _dbname);
        dbname = _dbname;
//        return bDiff;
    }

    /**
     * Return value of Dbname column.
     * @return value of Dbname column.
     */
    public String getDbname() {
        return dbname;
    }

    /**
 * Indicates if the volume is stored locally or remotely
 */
    private String location = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_LOCATION = 3;
    

    /**
     * Sets Location column.
     * @param _location new column value.
     */
    public void setLocation(String _location) {
        if (readOnly)
            throw new Error("This should never happen! setLocation on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(location, _location);
        location = _location;
//        return bDiff;
    }

    /**
     * Return value of Location column.
     * @return value of Location column.
     */
    public String getLocation() {
        return location;
    }

    /**
 * source language of the volume
 * values taken from dml:lang type
 * (eng, fra, jpn, etc.)  (mainly ISO 639-2/T)
 */
    private String sourceLanguage = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SOURCELANGUAGE = 4;
    

    /**
     * Sets SourceLanguage column.
     * @param _sourceLanguage new column value.
     */
    public void setSourceLanguage(String _sourceLanguage) {
        if (readOnly)
            throw new Error("This should never happen! setSourceLanguage on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(sourceLanguage, _sourceLanguage);
        sourceLanguage = _sourceLanguage;
//        return bDiff;
    }

    /**
     * Return value of SourceLanguage column.
     * @return value of SourceLanguage column.
     */
    public String getSourceLanguage() {
        return sourceLanguage;
    }

    /**
 * target languages of the volume
 * values taken from dml:lang type
 * (eng, fra, jpn, etc.)  (mainly ISO 639-2/T)
 */
    private String targetLanguages = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_TARGETLANGUAGES = 5;
    

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
 * Href of the volume file where are stored the entries
 */
    private String volumeRef = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_VOLUMEREF = 6;
    

    /**
     * Sets VolumeRef column.
     * @param _volumeRef new column value.
     */
    public void setVolumeRef(String _volumeRef) {
        if (readOnly)
            throw new Error("This should never happen! setVolumeRef on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(volumeRef, _volumeRef);
        volumeRef = _volumeRef;
//        return bDiff;
    }

    /**
     * Return value of VolumeRef column.
     * @return value of VolumeRef column.
     */
    public String getVolumeRef() {
        return volumeRef;
    }

    /**
 * The XML code of the volume metadata.
 */
    private String xmlCode = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_XMLCODE = 7;
    

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
 * The XML code of the XML schema representing the microstructure of the volume
*/
    private String xmlSchema = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_XMLSCHEMA = 8;
    

    /**
     * Sets XmlSchema column.
     * @param _xmlSchema new column value.
     */
    public void setXmlSchema(String _xmlSchema) {
        if (readOnly)
            throw new Error("This should never happen! setXmlSchema on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(xmlSchema, _xmlSchema);
        xmlSchema = _xmlSchema;
//        return bDiff;
    }

    /**
     * Return value of XmlSchema column.
     * @return value of XmlSchema column.
     */
    public String getXmlSchema() {
        return xmlSchema;
    }

    /**
 * The XML code of the interface template used in the online Edition interface module
*/
    private String templateItf = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_TEMPLATEITF = 9;
    

    /**
     * Sets TemplateItf column.
     * @param _templateItf new column value.
     */
    public void setTemplateItf(String _templateItf) {
        if (readOnly)
            throw new Error("This should never happen! setTemplateItf on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(templateItf, _templateItf);
        templateItf = _templateItf;
//        return bDiff;
    }

    /**
     * Return value of TemplateItf column.
     * @return value of TemplateItf column.
     */
    public String getTemplateItf() {
        return templateItf;
    }

    /**
* The XML code of an empty entry used as a template
*/
    private String templateEntry = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_TEMPLATEENTRY = 10;
    

    /**
     * Sets TemplateEntry column.
     * @param _templateEntry new column value.
     */
    public void setTemplateEntry(String _templateEntry) {
        if (readOnly)
            throw new Error("This should never happen! setTemplateEntry on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(templateEntry, _templateEntry);
        templateEntry = _templateEntry;
//        return bDiff;
    }

    /**
     * Return value of TemplateEntry column.
     * @return value of TemplateEntry column.
     */
    public String getTemplateEntry() {
        return templateEntry;
    }

    /**
* indicates if the volume can be reversed for lookup ie: target words searched as source words.
*/
    private String reverse = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_REVERSE = 11;
    

    /**
     * Sets Reverse column.
     * @param _reverse new column value.
     */
    public void setReverse(String _reverse) {
        if (readOnly)
            throw new Error("This should never happen! setReverse on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(reverse, _reverse);
        reverse = _reverse;
//        return bDiff;
    }

    /**
     * Return value of Reverse column.
     * @return value of Reverse column.
     */
    public String getReverse() {
        return reverse;
    }

    /**
 * Numer of entries in the volume
 */
    private int entries = 1;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_ENTRIES = 12;
    

    /**
     * Sets Entries column.
     * @param _entries new column value.
     */
    public void setEntries(int _entries) {
        if (readOnly)
            throw new Error("This should never happen! setEntries on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_int(entries, _entries);
        entries = _entries;
//        return bDiff;
    }

    /**
     * Return value of Entries column.
     * @return value of Entries column.
     */
    public int getEntries() {
        return entries;
    }

    /**
     * Used for query caching.
     */
    static public final int COLUMN_OID = 13;

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
              case COLUMN_NAME:
                   return QueryBuilder.compare(getName(),cond.getValue(),cond.getOperator());

              case COLUMN_DICTNAME:
                   return QueryBuilder.compare(getDictname(),cond.getValue(),cond.getOperator());

              case COLUMN_DBNAME:
                   return QueryBuilder.compare(getDbname(),cond.getValue(),cond.getOperator());

              case COLUMN_LOCATION:
                   return QueryBuilder.compare(getLocation(),cond.getValue(),cond.getOperator());

              case COLUMN_SOURCELANGUAGE:
                   return QueryBuilder.compare(getSourceLanguage(),cond.getValue(),cond.getOperator());

              case COLUMN_TARGETLANGUAGES:
                   return QueryBuilder.compare(getTargetLanguages(),cond.getValue(),cond.getOperator());

              case COLUMN_VOLUMEREF:
                   return QueryBuilder.compare(getVolumeRef(),cond.getValue(),cond.getOperator());

              case COLUMN_XMLCODE:
                   return QueryBuilder.compare(getXmlCode(),cond.getValue(),cond.getOperator());

              case COLUMN_XMLSCHEMA:
                   return QueryBuilder.compare(getXmlSchema(),cond.getValue(),cond.getOperator());

              case COLUMN_TEMPLATEITF:
                   return QueryBuilder.compare(getTemplateItf(),cond.getValue(),cond.getOperator());

              case COLUMN_TEMPLATEENTRY:
                   return QueryBuilder.compare(getTemplateEntry(),cond.getValue(),cond.getOperator());

              case COLUMN_REVERSE:
                   return QueryBuilder.compare(getReverse(),cond.getValue(),cond.getOperator());

              case COLUMN_ENTRIES:
                   return QueryBuilder.compare(getEntries(),cond.getValue(),cond.getOperator());


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
    public VolumeDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        VolumeDataStruct ret = new VolumeDataStruct ();
        if (!isEmpty) {
            ret.name = GenericDO.copyString(name);
            ret.dictname = GenericDO.copyString(dictname);
            ret.dbname = GenericDO.copyString(dbname);
            ret.location = GenericDO.copyString(location);
            ret.sourceLanguage = GenericDO.copyString(sourceLanguage);
            ret.targetLanguages = GenericDO.copyString(targetLanguages);
            ret.volumeRef = GenericDO.copyString(volumeRef);
            ret.xmlCode = GenericDO.copyString(xmlCode);
            ret.xmlSchema = GenericDO.copyString(xmlSchema);
            ret.templateItf = GenericDO.copyString(templateItf);
            ret.templateEntry = GenericDO.copyString(templateEntry);
            ret.reverse = GenericDO.copyString(reverse);
            ret.entries = entries;

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
