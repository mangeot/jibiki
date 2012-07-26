
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
 * fr.imag.clips.papillon.data/PapillonAxiDataStruct.java
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
public class PapillonAxiDataStruct extends CoreDataStruct implements Cloneable, Serializable {

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
        PapillonAxiDataStruct ret =
            new PapillonAxiDataStruct();
        ret.set_OId(get_OId());
        ret.set_Version((incrementVersion?1:0)+get_Version());
        ret.set_Database(get_Database());
        return ret;
    }

    /**
 * the external id
 */
    private String id = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_ID = 0;
    

    /**
     * Sets Id column.
     * @param _id new column value.
     */
    public void setId(String _id) {
        if (readOnly)
            throw new Error("This should never happen! setId on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(id, _id);
        id = _id;
//        return bDiff;
    }

    /**
     * Return value of Id column.
     * @return value of Id column.
     */
    public String getId() {
        return id;
    }

    /**
 * the semantic category
 */
    private String semanticCat = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SEMANTICCAT = 1;
    

    /**
     * Sets SemanticCat column.
     * @param _semanticCat new column value.
     */
    public void setSemanticCat(String _semanticCat) {
        if (readOnly)
            throw new Error("This should never happen! setSemanticCat on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(semanticCat, _semanticCat);
        semanticCat = _semanticCat;
//        return bDiff;
    }

    /**
     * Return value of SemanticCat column.
     * @return value of SemanticCat column.
     */
    public String getSemanticCat() {
        return semanticCat;
    }

    /**
 * the entry as a dom document node
 */
    private byte[] dom = {0};

    /**
     * Used for query caching.
     */
    static public final int COLUMN_DOM = 2;
    

    /**
     * Sets Dom column.
     * @param _dom new column value.
     */
    public void setDom(byte[] _dom) {
        if (readOnly)
            throw new Error("This should never happen! setDom on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_bytes(dom, _dom);
        dom = _dom;
//        return bDiff;
    }

    /**
     * Return value of Dom column.
     * @return value of Dom column.
     */
    public byte[] getDom() {
        return dom;
    }

    /**
 * the entry formatted in html as a dom document node
 */
    private byte[] htmldom = {0};

    /**
     * Used for query caching.
     */
    static public final int COLUMN_HTMLDOM = 3;
    

    /**
     * Sets Htmldom column.
     * @param _htmldom new column value.
     */
    public void setHtmldom(byte[] _htmldom) {
        if (readOnly)
            throw new Error("This should never happen! setHtmldom on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_bytes(htmldom, _htmldom);
        htmldom = _htmldom;
//        return bDiff;
    }

    /**
     * Return value of Htmldom column.
     * @return value of Htmldom column.
     */
    public byte[] getHtmldom() {
        return htmldom;
    }

    /**
 * The XML code of the axi.
 */
    private String xmlCode = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_XMLCODE = 4;
    

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
 * the lexies in a hashtable with the ISO 639-2 lang 3 letter code as access key
 */
    private byte[] lexies = {0};

    /**
     * Used for query caching.
     */
    static public final int COLUMN_LEXIES = 5;
    

    /**
     * Sets Lexies column.
     * @param _lexies new column value.
     */
    public void setLexies(byte[] _lexies) {
        if (readOnly)
            throw new Error("This should never happen! setLexies on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_bytes(lexies, _lexies);
        lexies = _lexies;
//        return bDiff;
    }

    /**
     * Return value of Lexies column.
     * @return value of Lexies column.
     */
    public byte[] getLexies() {
        return lexies;
    }

    /**
 * The synonym axies
 */
    private String synonyms = null;

    /**
     * Used for query caching.
     */
    static public final int COLUMN_SYNONYMS = 6;
    

    /**
     * Sets Synonyms column.
     * @param _synonyms new column value.
     */
    public void setSynonyms(String _synonyms) {
        if (readOnly)
            throw new Error("This should never happen! setSynonyms on "
			    + this +" is being called although readOnly is true");
//        boolean bDiff = GenericDO.isNewDataDifferent_String(synonyms, _synonyms);
        synonyms = _synonyms;
//        return bDiff;
    }

    /**
     * Return value of Synonyms column.
     * @return value of Synonyms column.
     */
    public String getSynonyms() {
        return synonyms;
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
              case COLUMN_ID:
                   return QueryBuilder.compare(getId(),cond.getValue(),cond.getOperator());

              case COLUMN_SEMANTICCAT:
                   return QueryBuilder.compare(getSemanticCat(),cond.getValue(),cond.getOperator());

              case COLUMN_DOM:
                   return QueryBuilder.compare(getDom(),cond.getValue(),cond.getOperator());

              case COLUMN_HTMLDOM:
                   return QueryBuilder.compare(getHtmldom(),cond.getValue(),cond.getOperator());

              case COLUMN_XMLCODE:
                   return QueryBuilder.compare(getXmlCode(),cond.getValue(),cond.getOperator());

              case COLUMN_LEXIES:
                   return QueryBuilder.compare(getLexies(),cond.getValue(),cond.getOperator());

              case COLUMN_SYNONYMS:
                   return QueryBuilder.compare(getSynonyms(),cond.getValue(),cond.getOperator());


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
    public PapillonAxiDataStruct duplicate() 
    throws DatabaseManagerException, ObjectIdException {
        PapillonAxiDataStruct ret = new PapillonAxiDataStruct ();
        if (!isEmpty) {
            ret.id = GenericDO.copyString(id);
            ret.semanticCat = GenericDO.copyString(semanticCat);
            ret.dom = GenericDO.copyByteArray(dom);
            ret.htmldom = GenericDO.copyByteArray(htmldom);
            ret.xmlCode = GenericDO.copyString(xmlCode);
            ret.lexies = GenericDO.copyByteArray(lexies);
            ret.synonyms = GenericDO.copyString(synonyms);

        }
        ret.set_OId(get_OId());
        ret.set_Version(get_Version());
        ret.databaseName=get_Database();
        ret.isEmpty = isEmpty;
        return ret;
    }
}
