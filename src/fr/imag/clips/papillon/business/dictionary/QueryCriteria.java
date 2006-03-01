//
//  QueryCriteria.java
//  xcode_Papillon5.1.lexalp
//
//  Created by Francis Brunet-Manquat on 10/11/05.
//  Copyright 2005 __MyCompanyName__. All rights reserved.
//

package fr.imag.clips.papillon.business.dictionary;

/* standards imports */
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Integer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* dods import */
import com.lutris.dods.builder.generator.query.QueryBuilder;

public class QueryCriteria {

    private ArrayList criteriaList;
    
    public static final String EQUAL = "0";
    public static final String NOT_EQUAL = "1";
    public static final String CASE_INSENSITIVE_EQUAL = "2";
    public static final String CASE_INSENSITIVE_NOT_EQUAL = "3";
    public static final String CASE_INSENSITIVE_CONTAINS = "4";
    public static final String CASE_INSENSITIVE_ENDS_WITH = "5";
    public static final String CASE_INSENSITIVE_STARTS_WITH = "6";
    public static final String CASE_SENSITIVE_CONTAINS = "7";
    public static final String CASE_SENSITIVE_ENDS_WITH = "8";
    public static final String CASE_SENSITIVE_STARTS_WITH = "9";
    public static final String GREATER_THAN = "10";
    public static final String LESS_THAN = "11";
    
    public QueryCriteria() {
        criteriaList = new ArrayList();
    }
    
    // find words in string value to add into query : column=word[0] AND column=word[1] AND ...
    public void addAdvancedValue(String column, String strategie, String value) {
        
        // find words in string value
        Pattern pat = Pattern.compile("^[ ]*([^ ]+)(.*)$");
        Matcher mat = pat.matcher(value);
        boolean isFind = mat.find();
        //System.out.println("addAdvancedValue: $" + value + "$");
        
        while (isFind) {
            
            // add word in criteria
            add(column, strategie, mat.group(1));
            
            //
            if ( (mat.group(2) != null) || (!mat.group(2).equals("")) ) {
                value = mat.group(2);
                mat = pat.matcher(value);
                isFind = mat.find();
            } else {
                isFind = false;
            }
        }
    }
    
    //
    public void add(String column, String strategie, String value) {
        
        //
        Pattern pat = Pattern.compile("^[ ]*([^ ]+([ ]+[^ ]+)*)[ ]*$");
        Matcher mat = pat.matcher(value);
        if (mat.find()) value = mat.group(1);
        //System.out.println("add: $" + value + "$");
        
        //
        String[] criteria = new String[3];
        criteria[0] = column;
        if ( strategie.equals(QueryCriteria.EQUAL) ) {
            criteria[1] = QueryBuilder.EQUAL;
            criteria[2] = value; 
            
        } else if ( strategie.equals(QueryCriteria.NOT_EQUAL) ) {
            criteria[1] = QueryBuilder.NOT_EQUAL;
            criteria[2] = value; 
            
        } else if ( strategie.equals(QueryCriteria.CASE_INSENSITIVE_EQUAL) ) {
            criteria[1] = "ilike";
            criteria[2] = value; 
            
        } else if ( strategie.equals(QueryCriteria.CASE_INSENSITIVE_NOT_EQUAL) ) {
            criteria[1] = "not ilike";
            criteria[2] = value; 
            
        } else if ( strategie.equals(QueryCriteria.CASE_INSENSITIVE_CONTAINS) ) {
            criteria[1] = "ilike";
            criteria[2] = "%" + value + "%"; 
        
        } else if ( strategie.equals(QueryCriteria.CASE_INSENSITIVE_ENDS_WITH) ) {
            criteria[1] = "ilike";
            criteria[2] = "%" + value; 
        
        }  else if ( strategie.equals(QueryCriteria.CASE_INSENSITIVE_STARTS_WITH) ) {
            criteria[1] = "ilike";
            criteria[2] = value + "%"; 
            
        }  else if ( strategie.equals(QueryCriteria.CASE_SENSITIVE_CONTAINS) ) {
            criteria[1] = "like";
            criteria[2] = "%" + value + "%"; 
            
        } else if ( strategie.equals(QueryCriteria.CASE_SENSITIVE_ENDS_WITH) ) {
            criteria[1] = "like";
            criteria[2] = "%" + value; 
            
        }  else if ( strategie.equals(QueryCriteria.CASE_SENSITIVE_STARTS_WITH) ) {
            criteria[1] = "like";
            criteria[2] = value + "%"; 
        
        }  else if ( strategie.equals(QueryCriteria.GREATER_THAN) ) {
            criteria[1] = ">";
            criteria[2] = value; 
            
        }  else if ( strategie.equals(QueryCriteria.LESS_THAN) ) {
            criteria[1] = "<";
            criteria[2] = value; 
                    
        } else {
            // defaut
            criteria[1] = strategie;
            criteria[2] = value;
        }
        
        criteriaList.add(criteria);
    }
    
    //
    public int size() {
        return criteriaList.size();
    }
    
    // 
    public String getColumn(int i) {
        return ((String[])criteriaList.get(i))[0];
    }
    
    // 
    public String getStrategie(int i) {
        return ((String[])criteriaList.get(i))[1];
    }
    
    // 
    public String getValue(int i) {
        return ((String[])criteriaList.get(i))[2];
    }
}
