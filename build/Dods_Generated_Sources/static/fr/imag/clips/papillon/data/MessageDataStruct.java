
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
 * fr.imag.clips.papillon.data/MessageDataStruct.java
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
public class MessageDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        MessageDataStruct ret =
            new MessageDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }

    /**
 * The date of post of the message.
 */
    private java.sql.Date date = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DATE = 0;
    

    /**
     * Sets Date column.
     * @param _date new column value.
     */
    public void setDate(java.sql.Date _date) {
        if (readOnly)
            throw new Error("This should never happen! setDate on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_java_sql_Date(date, _date);
        date = _date;
//        return bDiff;
    }

    /**
     * Return value of Date column.
     * @return value of Date column.
     */
    public java.sql.Date getDate() {
        return date;
    }
    
    private String msg = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_MSG = 1;
    

    /**
     * Sets Msg column.
     * @param _msg new column value.
     */
    public void setMsg(String _msg) {
        if (readOnly)
            throw new Error("This should never happen! setMsg on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(msg, _msg);
        msg = _msg;
//        return bDiff;
    }

    /**
     * Return value of Msg column.
     * @return value of Msg column.
     */
    public String getMsg() {
        return msg;
    }
    
    private String msgid = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_MSGID = 2;
    

    /**
     * Sets Msgid column.
     * @param _msgid new column value.
     */
    public void setMsgid(String _msgid) {
        if (readOnly)
            throw new Error("This should never happen! setMsgid on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(msgid, _msgid);
        msgid = _msgid;
//        return bDiff;
    }

    /**
     * Return value of Msgid column.
     * @return value of Msgid column.
     */
    public String getMsgid() {
        return msgid;
    }
    
    private String subject = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SUBJECT = 3;
    

    /**
     * Sets Subject column.
     * @param _subject new column value.
     */
    public void setSubject(String _subject) {
        if (readOnly)
            throw new Error("This should never happen! setSubject on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(subject, _subject);
        subject = _subject;
//        return bDiff;
    }

    /**
     * Return value of Subject column.
     * @return value of Subject column.
     */
    public String getSubject() {
        return subject;
    }
    
    private String author = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_AUTHOR = 4;
    

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
    
    private String authorAddress = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_AUTHORADDRESS = 5;
    

    /**
     * Sets AuthorAddress column.
     * @param _authorAddress new column value.
     */
    public void setAuthorAddress(String _authorAddress) {
        if (readOnly)
            throw new Error("This should never happen! setAuthorAddress on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(authorAddress, _authorAddress);
        authorAddress = _authorAddress;
//        return bDiff;
    }

    /**
     * Return value of AuthorAddress column.
     * @return value of AuthorAddress column.
     */
    public String getAuthorAddress() {
        return authorAddress;
    }
    
    private String thread = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_THREAD = 6;
    

    /**
     * Sets Thread column.
     * @param _thread new column value.
     */
    public void setThread(String _thread) {
        if (readOnly)
            throw new Error("This should never happen! setThread on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(thread, _thread);
        thread = _thread;
//        return bDiff;
    }

    /**
     * Return value of Thread column.
     * @return value of Thread column.
     */
    public String getThread() {
        return thread;
    }

    /**
     * Used for query caching.
     */
    static public final int COLUMN_OID = 7;

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
              case COLUMN_DATE:
                   return QueryBuilder.compare(getDate(),cond.getValue(),cond.getOperator());

              case COLUMN_MSG:
                   return QueryBuilder.compare(getMsg(),cond.getValue(),cond.getOperator());

              case COLUMN_MSGID:
                   return QueryBuilder.compare(getMsgid(),cond.getValue(),cond.getOperator());

              case COLUMN_SUBJECT:
                   return QueryBuilder.compare(getSubject(),cond.getValue(),cond.getOperator());

              case COLUMN_AUTHOR:
                   return QueryBuilder.compare(getAuthor(),cond.getValue(),cond.getOperator());

              case COLUMN_AUTHORADDRESS:
                   return QueryBuilder.compare(getAuthorAddress(),cond.getValue(),cond.getOperator());

              case COLUMN_THREAD:
                   return QueryBuilder.compare(getThread(),cond.getValue(),cond.getOperator());


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
    public MessageDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        MessageDataStruct ret = new MessageDataStruct ();
        if (!isEmpty) {
            ret.date = GenericDO.copyDate(date);
            ret.msg = GenericDO.copyString(msg);
            ret.msgid = GenericDO.copyString(msgid);
            ret.subject = GenericDO.copyString(subject);
            ret.author = GenericDO.copyString(author);
            ret.authorAddress = GenericDO.copyString(authorAddress);
            ret.thread = GenericDO.copyString(thread);

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
