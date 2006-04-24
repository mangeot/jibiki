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
 * Revision 1.3  2006/04/24 13:43:29  fbrunet
 * Add new class ViewQueryResult : allow to use one class to create result display in advancedSearch and EditEntryInit (like advancedQueryForm)
 * Improve result display : view n results per page
 *
 * Revision 1.2  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.1.4.1  2005/08/31 15:01:39  serasset
 * Applied modifications done on the LEXALP_1_0 branch to updated sources of the
 * trunk to create a new updated LEXALP_1_1 branch.
 *
 * Revision 1.1.2.1  2005/07/22 13:28:32  serasset
 * Modified EditEntryInit for Lexalp. It now serves as a main page for db maintenance.
 * Added a function to get url for QueryParameter.
 * Modified the way xslsheets are handled in order to allow several xslsheet with the same name, different dicts.
 *
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
import java.lang.Integer;
import java.lang.Object;


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
    
    public QueryParameter() {
        criteria = new Vector();
        offset = 0; 
        limit = 0; 
    }
    
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
    
    public String getOffsetString() {
        return Integer.toString(offset);
    }
    
    public void setOffset(int newOffset) {
        offset = newOffset;
    }

    public int getLimit() {
        return limit;
    }
    
    public String getLimitString() {
        return Integer.toString(limit);
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
        
    public QueryParameter duplicate() {
            
        //
        QueryParameter duplicate = new QueryParameter();
        
        // NOT clone() ATTENTION NO DEEP COPY
        // JUST Create the SAME queryParamater. It use to create next and previous query request !
        duplicate.setDictionaryNames(dictionaryNames);
        duplicate.setCriteria(criteria);
        duplicate.setOffset(offset);
        duplicate.setLimit(limit);
        duplicate.setXsl(xsl);
        duplicate.setTargets(targets);
        
        return duplicate;
    }
}
