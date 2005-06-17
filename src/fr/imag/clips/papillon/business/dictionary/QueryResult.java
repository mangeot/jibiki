/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/06/17 12:38:56  mangeot
 * Changed lexiesCollection into lexiesHashtable in order to implement the getDirectTranslations
 *
 * Revision 1.1  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.business.dictionary;

/* standards imports */
import java.util.Hashtable;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;

/**
 * A QueryResult is a business object return when querying dictionaries.
 * Its form depend on the kind of dictionary that is queried. 
 *    If the dictionary is monolingual, it only contain one entry. 
 *    If the dictionary is bilingual or is a fork dictionary, it only contains one bi/multi lingual entry.
 *    If the dictionary is a pivot dictionary, it contains:
 *       - one entry (the source entry)
 *       - ONE axie (which is connected to the queried entry).
 *       - a collection of all lexies DIRECTLY connected to the axie in requested target languages.
 *    If the result has been obtained by reverse lookup, it states it.
 */
public class QueryResult {
    
    // Kind of result
    public static final int UNKNOWN = 0;
    public static final int UNIQUE_RESULT = 1;
    public static final int REVERSE_UNIQUE_RESULT = 2;
    public static final int AXIE_COLLECTION_RESULT = 3;
	public static final int DIRECT_TRANSLATIONS_RESULT = 4;
    
    protected int resultKind;
	protected VolumeEntry sourceEntry = null;
    protected VolumeEntry resultAxie = null;
    protected Hashtable lexiesHashtable = null;
	
    public QueryResult() {
        this.resultKind = UNKNOWN;
    }

    // new QueryResult initialized from a prototype.
    public QueryResult(QueryResult qr) {
        this.resultKind = qr.getResultKind();
        this.sourceEntry = qr.getSourceEntry();
        this.resultAxie = qr.getResultAxie();
        this.lexiesHashtable = qr.getLexiesHashtable();
    }
    
    
    public QueryResult(int kind, VolumeEntry source) {
        this.resultKind = kind;
        this.sourceEntry = source;
    }
    
    public QueryResult(int kind, VolumeEntry source, VolumeEntry axie) {
        this(kind, source);
        this.resultAxie = axie;
    }
    
    public QueryResult(int kind, VolumeEntry source, VolumeEntry axie, Hashtable lexies) {
        this(kind, source, axie);
        this.lexiesHashtable = lexies;
    }
    
    public void setSourceEntry(VolumeEntry ve) {
        this.sourceEntry = ve;
    }
    
    public VolumeEntry getSourceEntry() {
        return this.sourceEntry;
    }
    
    public void setResultKind(int rk) {
        this.resultKind = rk;
    }
    
    public int getResultKind() {
        return this.resultKind;
    }

    public void setResultAxie(VolumeEntry ax) {
        this.resultAxie = ax;
    }
    
    public VolumeEntry getResultAxie() {
        return this.resultAxie;
    }

    public void setLexiesHashtable(Hashtable lexies) {
        this.lexiesHashtable = lexies;
    }
    
    public Hashtable getLexiesHashtable() {
        return this.lexiesHashtable;
    }
    
    public java.util.Collection getLexiesCollection() {
        return this.lexiesHashtable.values();
    }
    
    
    
}
