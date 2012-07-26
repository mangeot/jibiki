
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
 * fr.imag.clips.papillon.data/ContributionLogDataStruct.java
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
public class ContributionLogDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        ContributionLogDataStruct ret =
            new ContributionLogDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }

    /**
 * the login of the author of the contribution
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
 * the groups allowed to view the contribution
 */
    private String groups = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_GROUPS = 1;
    

    /**
     * Sets Groups column.
     * @param _groups new column value.
     */
    public void setGroups(String _groups) {
        if (readOnly)
            throw new Error("This should never happen! setGroups on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(groups, _groups);
        groups = _groups;
//        return bDiff;
    }

    /**
     * Return value of Groups column.
     * @return value of Groups column.
     */
    public String getGroups() {
        return groups;
    }

    /**
 * the volume where the contribution has to be inserted
 */
    private String volume = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_VOLUME = 2;
    

    /**
     * Sets Volume column.
     * @param _volume new column value.
     */
    public void setVolume(String _volume) {
        if (readOnly)
            throw new Error("This should never happen! setVolume on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(volume, _volume);
        volume = _volume;
//        return bDiff;
    }

    /**
     * Return value of Volume column.
     * @return value of Volume column.
     */
    public String getVolume() {
        return volume;
    }

    /**
 * the source language of the contribution
 * values taken from dml:lang type (mainly ISO 639-2/T)
 * (eng, fra, jpn, etc.)
 */
    private String sourceLanguage = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SOURCELANGUAGE = 3;
    

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
 * the headword
 */
    private String headword = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_HEADWORD = 4;
    

    /**
     * Sets Headword column.
     * @param _headword new column value.
     */
    public void setHeadword(String _headword) {
        if (readOnly)
            throw new Error("This should never happen! setHeadword on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(headword, _headword);
        headword = _headword;
//        return bDiff;
    }

    /**
     * Return value of Headword column.
     * @return value of Headword column.
     */
    public String getHeadword() {
        return headword;
    }

    /**
 * the contribution id corresponding to the contribution
 */
    private String contributionId = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_CONTRIBUTIONID = 5;
    

    /**
     * Sets ContributionId column.
     * @param _contributionId new column value.
     */
    public void setContributionId(String _contributionId) {
        if (readOnly)
            throw new Error("This should never happen! setContributionId on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(contributionId, _contributionId);
        contributionId = _contributionId;
//        return bDiff;
    }

    /**
     * Return value of ContributionId column.
     * @return value of ContributionId column.
     */
    public String getContributionId() {
        return contributionId;
    }

    /**
 * the entry id corresponding to the contribution
 */
    private String entryId = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_ENTRYID = 6;
    

    /**
     * Sets EntryId column.
     * @param _entryId new column value.
     */
    public void setEntryId(String _entryId) {
        if (readOnly)
            throw new Error("This should never happen! setEntryId on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(entryId, _entryId);
        entryId = _entryId;
//        return bDiff;
    }

    /**
     * Return value of EntryId column.
     * @return value of EntryId column.
     */
    public String getEntryId() {
        return entryId;
    }

    /**
 * the date of the action on the contribution
 */
    private java.sql.Timestamp date = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DATE = 7;
    

    /**
     * Sets Date column.
     * @param _date new column value.
     */
    public void setDate(java.sql.Timestamp _date) {
        if (readOnly)
            throw new Error("This should never happen! setDate on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_java_sql_Timestamp(date, _date);
        date = _date;
//        return bDiff;
    }

    /**
     * Return value of Date column.
     * @return value of Date column.
     */
    public java.sql.Timestamp getDate() {
        return date;
    }

    /**
 * the status of the contribution
 */
    private String status = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_STATUS = 8;
    

    /**
     * Sets Status column.
     * @param _status new column value.
     */
    public void setStatus(String _status) {
        if (readOnly)
            throw new Error("This should never happen! setStatus on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(status, _status);
        status = _status;
//        return bDiff;
    }

    /**
     * Return value of Status column.
     * @return value of Status column.
     */
    public String getStatus() {
        return status;
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
              case COLUMN_AUTHOR:
                   return QueryBuilder.compare(getAuthor(),cond.getValue(),cond.getOperator());

              case COLUMN_GROUPS:
                   return QueryBuilder.compare(getGroups(),cond.getValue(),cond.getOperator());

              case COLUMN_VOLUME:
                   return QueryBuilder.compare(getVolume(),cond.getValue(),cond.getOperator());

              case COLUMN_SOURCELANGUAGE:
                   return QueryBuilder.compare(getSourceLanguage(),cond.getValue(),cond.getOperator());

              case COLUMN_HEADWORD:
                   return QueryBuilder.compare(getHeadword(),cond.getValue(),cond.getOperator());

              case COLUMN_CONTRIBUTIONID:
                   return QueryBuilder.compare(getContributionId(),cond.getValue(),cond.getOperator());

              case COLUMN_ENTRYID:
                   return QueryBuilder.compare(getEntryId(),cond.getValue(),cond.getOperator());

              case COLUMN_DATE:
                   return QueryBuilder.compare(getDate(),cond.getValue(),cond.getOperator());

              case COLUMN_STATUS:
                   return QueryBuilder.compare(getStatus(),cond.getValue(),cond.getOperator());


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
    public ContributionLogDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        ContributionLogDataStruct ret = new ContributionLogDataStruct ();
        if (!isEmpty) {
            ret.author = GenericDO.copyString(author);
            ret.groups = GenericDO.copyString(groups);
            ret.volume = GenericDO.copyString(volume);
            ret.sourceLanguage = GenericDO.copyString(sourceLanguage);
            ret.headword = GenericDO.copyString(headword);
            ret.contributionId = GenericDO.copyString(contributionId);
            ret.entryId = GenericDO.copyString(entryId);
            ret.date = GenericDO.copyTimestamp(date);
            ret.status = GenericDO.copyString(status);

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
