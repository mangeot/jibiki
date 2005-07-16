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

package fr.imag.clips.papillon.presentation;

/* standards imports */
import java.util.HashSet;
// Standard imports
import java.util.Vector;
import java.util.Arrays;
import java.util.Iterator;

import java.util.Date;
import java.text.DateFormat;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Enhydra imports
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import javax.servlet.http.HttpServletRequest;
import org.enhydra.xml.xhtml.dom.*;

// Imported DOM classes
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

// Papillon imports
import fr.imag.clips.papillon.presentation.xhtml.orig.AdvancedQueryFormXHTML;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.IQuery;
import fr.imag.clips.papillon.business.dictionary.QueryParameter;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.locales.Languages;
import fr.imag.clips.papillon.business.xsl.XslSheet;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;


/**
* A QueryParameter is a business object passed when querying dictionaries.
 */
public class AdvancedQueryForm {
    
    protected Node queryForm;
        
    protected static final String actionPatternString = "^(\\+|\\-)([^\\.]+)\\.(\\d+)$";
    protected static Pattern actionPattern = Pattern.compile(actionPatternString);
    protected static Matcher actionMatcher = actionPattern.matcher("");
    
    QueryParameter qparams;
    String action;
    
    public String[] getRequestedDictionaries(HttpServletRequest req) 
        throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        String[] d = AbstractPO.myGetParameterValues(req, AdvancedQueryFormXHTML.NAME_DICTIONARIES);
        if (null == d) {
            Dictionary[] knownDictionaries = DictionariesFactory.getDictionariesArray();
            d = new String[knownDictionaries.length];
            for (int i = 0; i < knownDictionaries.length; i++) {
                d[i] = knownDictionaries[i].getName();
            }
        }
        return d;
    }
    
    public String getRequestedXsl(HttpServletRequest req) 
        throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        return AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_XSL);
    }

    public int getRequestedNumberOfResultsPerPage(HttpServletRequest req) 
        throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        String nbr = AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_NB_RESULT_PER_PAGE);
        return (null == nbr || nbr.equals("")) ? 0 : Integer.valueOf(nbr).intValue();
    }

    public int getRequestedOffset(HttpServletRequest req) 
        throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        String ofs = AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_OFFSET);
        return (null == ofs || ofs.equals("")) ? 0 : Integer.valueOf(ofs).intValue();
    }
    
    public String[] getRequestedTargetLanguages(HttpServletRequest req) 
        throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        String[] t = AbstractPO.myGetParameterValues(req, AdvancedQueryFormXHTML.NAME_TARGETS);
        if (null == t) {
            t = new String[0];
        }
        return t;
    }
    
    public Vector getRequestedCriteria(HttpServletRequest req) 
        throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        String nbc = AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_CRITERIA_NB);
        int nbCriteria = (null == nbc || nbc.equals("")) ? 1 : Integer.valueOf(nbc).intValue();
        
        Vector criteria = new Vector();
        for(int i=0; i < nbCriteria; i++) {
            String[] key = new String[4];
            key[0] = AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_FACET + "." + Integer.toString(i));
            key[1] = AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_SOURCE + "." + Integer.toString(i));
            String facetValue = AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_FACETVALUE + "." + Integer.toString(i));
            key[2] = (null == facetValue) ? "" : facetValue;
            String comparator = AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_OPERATOR + "." + Integer.toString(i));
            int comparisonOperator = (comparator != null) ? Integer.valueOf(comparator).intValue() : 0;
            key[3] = IQuery.QueryBuilderStrategy[comparisonOperator];
            
            // Add the criterion to the set
            if (null != key[0]) criteria.add(key);
        }
        return criteria;
    }
    
    public String getRequestedAction(HttpServletRequest req) 
        throws java.io.UnsupportedEncodingException,
        com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        return AbstractPO.myGetParameter(req, AdvancedQueryFormXHTML.NAME_ACTION);
    }
    
    public AdvancedQueryForm(HttpPresentationComms comms, PapillonSessionData sessionData) throws PapillonPresentationException {
        try {
                      
            // Get all the parameters
            qparams = new QueryParameter();
            qparams.setDictionaryNames(getRequestedDictionaries(comms.request.getHttpServletRequest()));
            qparams.setCriteria(getRequestedCriteria(comms.request.getHttpServletRequest()));
            qparams.setLimit(getRequestedNumberOfResultsPerPage(comms.request.getHttpServletRequest()));
            qparams.setOffset(getRequestedOffset(comms.request.getHttpServletRequest()));
            qparams.setXsl(getRequestedXsl(comms.request.getHttpServletRequest()));
            qparams.setTargets(getRequestedTargetLanguages(comms.request.getHttpServletRequest()));
            
            // Did the user ask the addition or removal of a node ? 
            action = getRequestedAction(comms.request.getHttpServletRequest());
            if (actionOnFormRequested()) {
                // Perform the action
                actionMatcher.reset(action);
                if (actionMatcher.find()) {
                    String action = actionMatcher.group(1);
                    String tag = actionMatcher.group(2);
                    int num = Integer.valueOf(actionMatcher.group(3)).intValue();
                    if (action.equals("-")) {
                        qparams.getCriteria().remove(num);
                    } else {
                        String[] key = new String[4];
                        key[0] = Volume.CDM_headword;
                        key[1] = null;
                        key[2] = "";
                        key[3] = IQuery.QueryBuilderStrategy[0];
                        qparams.getCriteria().add(key);
                    }
                } 
            }
            
            // Apply those parameters to the form
            buildFormFromParameters(comms, sessionData, qparams);
            
        } catch (Exception e) {
            throw new PapillonPresentationException("Exception in queryForm", e);
        }
        
    }
    
    /** Called during form initialization.
        If a user wants to modify the parameters and rebuild the form accordingly,
        he will have to call this method again.
        */
    public void buildFormFromParameters(HttpPresentationComms comms, PapillonSessionData sessionData, QueryParameter qp) 
        throws com.lutris.appserver.server.httpPresentation.HttpPresentationException
    {
        // Create the advanced query form and fill it with current requested values
        AdvancedQueryFormXHTML queryDoc = (AdvancedQueryFormXHTML) 
        MultilingualXHtmlTemplateFactory.createTemplate("AdvancedQueryFormXHTML", comms, sessionData);
        
        // Populate form with all known dictionaries
        XHTMLOptionElement dictOption = queryDoc.getElementDictionaryTmpl();
        dictOption.removeAttribute("id");
        Dictionary[] knownDictionaries = DictionariesFactory.getDictionariesArray();
        for (int i = 0; i < knownDictionaries.length; i++) {
            String dicName = knownDictionaries[i].getName();
            dictOption.setValue(dicName);
            dictOption.setLabel(dicName);
            Text txt = (Text) dictOption.getFirstChild();
            txt.setData(dicName);
            dictOption.getParentNode().appendChild(dictOption.cloneNode(true));
        }
        dictOption.getParentNode().removeChild(dictOption);
        
        // Populate form with all know target languages
        XHTMLOptionElement targetOption = queryDoc.getElementTargetTmpl();
        targetOption.removeAttribute("id");
        String[] targetLanguageNames = getAllTargetLanguages();
        for (int i = 0; i < targetLanguageNames.length; i++) {
            String lg = targetLanguageNames[i];
            targetOption.setValue(lg);
            targetOption.setLabel(Languages.localizeLabel(sessionData.getUserPreferredLanguage(),lg));
            Text txt = (Text) targetOption.getFirstChild();
            txt.setData(Languages.localizeName(sessionData.getUserPreferredLanguage(),lg));
            targetOption.getParentNode().appendChild(targetOption.cloneNode(true));
        }
        targetOption.getParentNode().removeChild(targetOption);
        
        // Populate form with available xsls
        // FIXME: this should be replaced by a generic set of formatter options
        XslSheet[] xslsheetsArray = XslSheetFactory.getXslSheetsArray();
        XHTMLOptionElement xslOption = queryDoc.getElementXslTmpl();
        for (int i = 0; i < xslsheetsArray.length; i++) {
            String xsn = xslsheetsArray[i].getName();
            xslOption.setValue(xsn);
            xslOption.setLabel(xsn);
            Text txt = (Text) xslOption.getFirstChild();
            txt.setData(xsn);
            xslOption.getParentNode().appendChild(xslOption.cloneNode(true));
        }
        xslOption.getParentNode().removeChild(xslOption);
        
        // put parameters back into form
        queryDoc.getElementOffset().setValue(Integer.toString(qp.getOffset()));
        
        AbstractPO.setSelected(queryDoc.getElementNumberOfResultPerPage(),Integer.toString(qp.getLimit()));
        
        String[] dics = qp.getDictionaryNames();
        for (int i=0; i < dics.length; i++) {
            AbstractPO.setSelected(queryDoc.getElementDictionaries(),dics[i]);
        }
        
        String[] targets = qp.getTargets();
        for (int i=0; i < targets.length; i++) {
            AbstractPO.setSelected(queryDoc.getElementTargets(),targets[i]);
        }
        
        AbstractPO.setSelected(queryDoc.getElementXsl(),qp.getXsl());

        // Then the criteria...
        XHTMLInputElement nbcrit = queryDoc.getElementNumberOfCriteria();
        Element criterion = queryDoc.getElementCriterion();
        XHTMLImageElement minus = queryDoc.getElementMinus();
        XHTMLImageElement plus = queryDoc.getElementPlus();
        XHTMLSelectElement facet = queryDoc.getElementFacet();
        XHTMLSelectElement oper = queryDoc.getElementOperator();
        XHTMLInputElement valuefield = queryDoc.getElementValueField();
        Element sourceLangSelectArea = queryDoc.getElementSourceLanguageSelection();
        XHTMLLabelElement sourceLangLabel = queryDoc.getElementSourceLangLabel();
        XHTMLSelectElement sourceLang = queryDoc.getElementSourceLang();
        XHTMLOptionElement sourceOption = queryDoc.getElementSourceOptionTemplate();

        nbcrit.removeAttribute("id");
        criterion.removeAttribute("id");
        minus.removeAttribute("id");
        plus.removeAttribute("id");
        facet.removeAttribute("id");
        oper.removeAttribute("id");
        valuefield.removeAttribute("id");
        sourceLangSelectArea.removeAttribute("id");
        sourceLangLabel.removeAttribute("id");
        sourceLang.removeAttribute("id");
        sourceOption.removeAttribute("id");
        
        // add all source languages in the lang selector
        String[] sourceLanguageNames = getAllSourceLanguages();
        for (int i = 0; i < sourceLanguageNames.length; i++) {
            String lg = sourceLanguageNames[i];
            sourceOption.setValue(lg);
            sourceOption.setLabel(Languages.localizeLabel(sessionData.getUserPreferredLanguage(),lg));
            Text txt = (Text) sourceOption.getFirstChild();
            txt.setData(Languages.localizeName(sessionData.getUserPreferredLanguage(),lg));
            sourceOption.getParentNode().appendChild(sourceOption.cloneNode(true));
        }
        sourceOption.getParentNode().removeChild(sourceOption);
        
        if (qp.getCriteria().size() == 0) {
            nbcrit.setValue("1");
            AbstractPO.setSelected(facet,Volume.CDM_headword);
            AbstractPO.setSelected(oper,"1");
            facet.setAttribute("name", AdvancedQueryFormXHTML.NAME_FACET + ".0");
            oper.setAttribute("name", AdvancedQueryFormXHTML.NAME_OPERATOR + ".0");
            valuefield.setAttribute("name", AdvancedQueryFormXHTML.NAME_FACETVALUE + ".0");
            sourceLang.setAttribute("name", AdvancedQueryFormXHTML.NAME_SOURCE + ".0");
            minus.getParentNode().removeChild(minus);
            plus.setAttribute("id", "plus.0");
            sourceLang.setAttribute("id", "SourceLang.0");
            sourceLangLabel.setAttribute("for", "SourceLang.0");
        } else {
            nbcrit.setValue(Integer.toString(qp.getCriteria().size()));
            Iterator iter = qp.getCriteria().iterator();
            int i=0;
            while(iter.hasNext()) {
                String[] key = (String[]) iter.next();
                AbstractPO.setSelected(facet,key[0]);
                int operValue = index(IQuery.QueryBuilderStrategy, key[3]);
                AbstractPO.setSelected(oper,Integer.toString(operValue));
                valuefield.setValue(key[2]);
                if (null != key[1] && !key[1].equals(""))
                    AbstractPO.setSelected(sourceLang,key[1]);
                String istr = Integer.toString(i);
                facet.setAttribute("name", AdvancedQueryFormXHTML.NAME_FACET + "." + istr);
                oper.setAttribute("name", AdvancedQueryFormXHTML.NAME_OPERATOR + "." + istr);
                valuefield.setAttribute("name", AdvancedQueryFormXHTML.NAME_FACETVALUE + "." + istr);
                sourceLang.setAttribute("name", AdvancedQueryFormXHTML.NAME_SOURCE + "." + istr);
                minus.setAttribute("id", "minus." + istr);
                plus.setAttribute("id", "plus." + istr);
                sourceLang.setAttribute("id", "SourceLang." + istr);
                sourceLangLabel.setAttribute("for", "SourceLang." + istr);
                
                Node newCriterion = criterion.cloneNode(true);
                                
                
                // Reinit the template node
                minus.removeAttribute("id");
                plus.removeAttribute("id");
                AbstractPO.deselectAll(facet);
                AbstractPO.deselectAll(sourceLang);
                AbstractPO.deselectAll(oper);
                criterion.getParentNode().insertBefore(newCriterion, criterion);
                
                // Remove plus in all but the last element
                if (iter.hasNext()) {
                    Element newPlus = newCriterion.getOwnerDocument().getElementById("plus." + istr);
                    newPlus.getParentNode().removeChild(newPlus);
                } else if (0 == i) {
                    // Remove minus if there is only one element
                    Element newMinus = newCriterion.getOwnerDocument().getElementById("minus." + istr);
                    newMinus.getParentNode().removeChild(newMinus);
                }
                i++;
            }
            criterion.getParentNode().removeChild(criterion);
        }
        
        queryForm = queryDoc.getElementAdvancedSearchForm();
    }
    
    protected String[] getAllTargetLanguages() 
        throws fr.imag.clips.papillon.business.PapillonBusinessException 
    {
        Dictionary[] knownDictionaries = DictionariesFactory.getDictionariesArray();
        HashSet trgtLgSet = new HashSet();
        for (int i = 0; i < knownDictionaries.length; i++) {
            String[] tls = knownDictionaries[i].getTargetLanguagesArray();
            for (int j=0; j < tls.length; j++) {
                if (null != tls[j] && !tls[j].equals("") && !tls[j].equals("axi")) trgtLgSet.add(tls[j]);
            }
        }
        String[] targetLanguageNames = (String[]) trgtLgSet.toArray(new String[trgtLgSet.size()]);
        // FIXME: the sort should apply on localized languages (not on 3 letter codes...)
        Arrays.sort(targetLanguageNames);
        
        return targetLanguageNames;
    }
    
    protected String[] getAllSourceLanguages() 
        throws fr.imag.clips.papillon.business.PapillonBusinessException 
    {
        Dictionary[] knownDictionaries = DictionariesFactory.getDictionariesArray();
        HashSet srcLgSet = new HashSet();
        for (int i = 0; i < knownDictionaries.length; i++) {
            String[] tls = knownDictionaries[i].getSourceLanguagesArray();
            for (int j=0; j < tls.length; j++) {
                if (null != tls[j] && !tls[j].equals("") && !tls[j].equals("axi")) srcLgSet.add(tls[j]);
            }
        }
        
        String[] sourceLanguageNames = (String[]) srcLgSet.toArray(new String[srcLgSet.size()]);
        // FIXME: the sort should apply on localized languages (not on 3 letter codes...)
        Arrays.sort(sourceLanguageNames);
        
        String[] result = new String[srcLgSet.size()+1];
        result[0] = Volume.DEFAULT_LANG;
        System.arraycopy(sourceLanguageNames, 0, result, 1, sourceLanguageNames.length);
        return result;
    }
    
    protected static int index(String[] array, String key) {
        int i = 0;
        while( i < array.length && !array[i].equals(key)) i++;
        return i;
    }
    
    /** 
    *
    */
    public Node getQueryFormNode(String action) {
        // Create the advanced query form and fill it with current requested values
        return queryForm;
    }
    
   
    public QueryParameter getQueryParameter() {
        // Create the advanced query form and fill it with current requested values
        return qparams;
    }
    
    public boolean actionOnFormRequested() {
        return (null != action && !action.equals(""));
    }
}
