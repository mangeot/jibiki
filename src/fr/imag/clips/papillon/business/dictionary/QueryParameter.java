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
 * Revision 1.1  2005/07/16 12:58:31  serasset
 * Added limit parameter to query functions
 * Added a parameter to Formater initializations
 * Developped a new Advanced search functionality with reusable code for the query form handling...
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.business.dictionary;

/* standards imports */
import java.util.Hashtable;
import java.util.Vector;

/**
* A QueryParameter is a business object passed when querying dictionaries.
*/
public class QueryParameter {
    // Parameters
    protected String [] dictionaryNames;
    protected Vector criteria;
    protected int offset; 
    protected int limit; 
    protected String xsl;
    protected String [] targets;
    
    public String[] getDictionaryNames() {
        return (null == dictionaryNames) ? (dictionaryNames = new String[0]) : dictionaryNames;
    }
    
    public void setDictionaryNames(String [] names) {
        dictionaryNames = names;
    }
    
    public Vector getCriteria() {
        return (null == criteria) ? (criteria = new Vector()) : criteria;
    }
    
    public void setCriteria(Vector newCriteria) {
        criteria = newCriteria;
    }

    public int getOffset() {
        return offset;
    }
    
    public void setOffset(int newOffset) {
        offset = newOffset;
    }

    public int getLimit() {
        return limit;
    }
    
    public void setLimit(int newLimit) {
        limit = newLimit;
    }

    public String getXsl() {
        return xsl;
    }
    
    public void setXsl(String newXsl) {
        xsl = newXsl;
    }

    public String[] getTargets() {
        return (null == targets) ? (targets = new String[0]) : targets;
    }
    
    public void setTargets(String [] newTargets) {
        targets = newTargets;
    }
    
}
