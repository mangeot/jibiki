
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
 * fr.imag.clips.papillon.data/QueryLogDataStruct.java
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
public class QueryLogDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        QueryLogDataStruct ret =
            new QueryLogDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }
    
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
    
    private String login = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_LOGIN = 1;
    

    /**
     * Sets Login column.
     * @param _login new column value.
     */
    public void setLogin(String _login) {
        if (readOnly)
            throw new Error("This should never happen! setLogin on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(login, _login);
        login = _login;
//        return bDiff;
    }

    /**
     * Return value of Login column.
     * @return value of Login column.
     */
    public String getLogin() {
        return login;
    }
    
    private String formName = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_FORMNAME = 2;
    

    /**
     * Sets FormName column.
     * @param _formName new column value.
     */
    public void setFormName(String _formName) {
        if (readOnly)
            throw new Error("This should never happen! setFormName on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(formName, _formName);
        formName = _formName;
//        return bDiff;
    }

    /**
     * Return value of FormName column.
     * @return value of FormName column.
     */
    public String getFormName() {
        return formName;
    }
    
    private String prefLang = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_PREFLANG = 3;
    

    /**
     * Sets PrefLang column.
     * @param _prefLang new column value.
     */
    public void setPrefLang(String _prefLang) {
        if (readOnly)
            throw new Error("This should never happen! setPrefLang on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(prefLang, _prefLang);
        prefLang = _prefLang;
//        return bDiff;
    }

    /**
     * Return value of PrefLang column.
     * @return value of PrefLang column.
     */
    public String getPrefLang() {
        return prefLang;
    }
    
    private String query = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_QUERY = 4;
    

    /**
     * Sets Query column.
     * @param _query new column value.
     */
    public void setQuery(String _query) {
        if (readOnly)
            throw new Error("This should never happen! setQuery on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(query, _query);
        query = _query;
//        return bDiff;
    }

    /**
     * Return value of Query column.
     * @return value of Query column.
     */
    public String getQuery() {
        return query;
    }
    
    private String results = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_RESULTS = 5;
    

    /**
     * Sets Results column.
     * @param _results new column value.
     */
    public void setResults(String _results) {
        if (readOnly)
            throw new Error("This should never happen! setResults on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(results, _results);
        results = _results;
//        return bDiff;
    }

    /**
     * Return value of Results column.
     * @return value of Results column.
     */
    public String getResults() {
        return results;
    }
    
    private String srcLang = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SRCLANG = 6;
    

    /**
     * Sets SrcLang column.
     * @param _srcLang new column value.
     */
    public void setSrcLang(String _srcLang) {
        if (readOnly)
            throw new Error("This should never happen! setSrcLang on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(srcLang, _srcLang);
        srcLang = _srcLang;
//        return bDiff;
    }

    /**
     * Return value of SrcLang column.
     * @return value of SrcLang column.
     */
    public String getSrcLang() {
        return srcLang;
    }
    
    private String trgLangs = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_TRGLANGS = 7;
    

    /**
     * Sets TrgLangs column.
     * @param _trgLangs new column value.
     */
    public void setTrgLangs(String _trgLangs) {
        if (readOnly)
            throw new Error("This should never happen! setTrgLangs on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(trgLangs, _trgLangs);
        trgLangs = _trgLangs;
//        return bDiff;
    }

    /**
     * Return value of TrgLangs column.
     * @return value of TrgLangs column.
     */
    public String getTrgLangs() {
        return trgLangs;
    }
    
    private String dicts = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DICTS = 8;
    

    /**
     * Sets Dicts column.
     * @param _dicts new column value.
     */
    public void setDicts(String _dicts) {
        if (readOnly)
            throw new Error("This should never happen! setDicts on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(dicts, _dicts);
        dicts = _dicts;
//        return bDiff;
    }

    /**
     * Return value of Dicts column.
     * @return value of Dicts column.
     */
    public String getDicts() {
        return dicts;
    }
    
    private String strategy = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_STRATEGY = 9;
    

    /**
     * Sets Strategy column.
     * @param _strategy new column value.
     */
    public void setStrategy(String _strategy) {
        if (readOnly)
            throw new Error("This should never happen! setStrategy on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(strategy, _strategy);
        strategy = _strategy;
//        return bDiff;
    }

    /**
     * Return value of Strategy column.
     * @return value of Strategy column.
     */
    public String getStrategy() {
        return strategy;
    }
    
    private String queryString = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_QUERYSTRING = 10;
    

    /**
     * Sets QueryString column.
     * @param _queryString new column value.
     */
    public void setQueryString(String _queryString) {
        if (readOnly)
            throw new Error("This should never happen! setQueryString on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(queryString, _queryString);
        queryString = _queryString;
//        return bDiff;
    }

    /**
     * Return value of QueryString column.
     * @return value of QueryString column.
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * Used for query caching.
     */
    static public final int COLUMN_OID = 11;

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

              case COLUMN_LOGIN:
                   return QueryBuilder.compare(getLogin(),cond.getValue(),cond.getOperator());

              case COLUMN_FORMNAME:
                   return QueryBuilder.compare(getFormName(),cond.getValue(),cond.getOperator());

              case COLUMN_PREFLANG:
                   return QueryBuilder.compare(getPrefLang(),cond.getValue(),cond.getOperator());

              case COLUMN_QUERY:
                   return QueryBuilder.compare(getQuery(),cond.getValue(),cond.getOperator());

              case COLUMN_RESULTS:
                   return QueryBuilder.compare(getResults(),cond.getValue(),cond.getOperator());

              case COLUMN_SRCLANG:
                   return QueryBuilder.compare(getSrcLang(),cond.getValue(),cond.getOperator());

              case COLUMN_TRGLANGS:
                   return QueryBuilder.compare(getTrgLangs(),cond.getValue(),cond.getOperator());

              case COLUMN_DICTS:
                   return QueryBuilder.compare(getDicts(),cond.getValue(),cond.getOperator());

              case COLUMN_STRATEGY:
                   return QueryBuilder.compare(getStrategy(),cond.getValue(),cond.getOperator());

              case COLUMN_QUERYSTRING:
                   return QueryBuilder.compare(getQueryString(),cond.getValue(),cond.getOperator());


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
    public QueryLogDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        QueryLogDataStruct ret = new QueryLogDataStruct ();
        if (!isEmpty) {
            ret.date = GenericDO.copyDate(date);
            ret.login = GenericDO.copyString(login);
            ret.formName = GenericDO.copyString(formName);
            ret.prefLang = GenericDO.copyString(prefLang);
            ret.query = GenericDO.copyString(query);
            ret.results = GenericDO.copyString(results);
            ret.srcLang = GenericDO.copyString(srcLang);
            ret.trgLangs = GenericDO.copyString(trgLangs);
            ret.dicts = GenericDO.copyString(dicts);
            ret.strategy = GenericDO.copyString(strategy);
            ret.queryString = GenericDO.copyString(queryString);

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
