/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.1  2005/07/16 16:42:05  mangeot
 *  iLinker adapted from LexAlpLinker developed by GS
 *
 *
 *  -----------------------------------------------
 *  Class implementing small windows used to link elements.
 */
package fr.imag.clips.papillon.presentation;

import fr.imag.clips.papillon.presentation.xhtmlgdef.orig.LinkerSearchFormXHTML;
import fr.imag.clips.papillon.presentation.xhtmlgdef.orig.LinkerResultListXHTML;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import com.lutris.appserver.server.Enhydra;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Comment;
import org.w3c.dom.Text;

import org.enhydra.xml.xhtml.dom.*;

import org.enhydra.xml.xmlc.*;
//import org.enhydra.xml.xmlc.html.*;
import com.lutris.logging.*;
import com.lutris.util.*;

// For the cookies
//import javax.servlet.http.Cookie;
//import fr.imag.clips.papillon.business.user.UsersFactory;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import java.text.DateFormat;

//pour le debogage
import fr.imag.clips.papillon.business.utility.*;
import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonLogger;

import org.enhydra.xml.io.OutputOptions;
import org.enhydra.xml.io.DOMFormatter;

/**
*  Description of the Class
 *
 * @author     serasset
 * @created    July 6, 2005
 */
public class GDEFLinker extends LinkerBasePO {
        
    // Search form Parameters
    public class SearchFormParameters {
        public boolean isInitialized = false;
        
        public String [] volumes;
        public String [] dictionaries;
        public String facetValue;
        public String sourceLang;
        public String facet;
        public String comparator;
        public String xsl;
        public int comparisonOperator;
        public String [] targets;
        
        // Parameter initialization does not depend on the exact shape of the search form.
        public void initializeSearchParameters(AbstractPO po) 
        throws java.io.UnsupportedEncodingException, 
            com.lutris.appserver.server.httpPresentation.HttpPresentationException
        {
            if (! isInitialized) {
                // Get parameters
                volumes = po.myGetParameterValues(LinkerSearchFormXHTML.NAME_VOLUMES);
                targets = po.myGetParameterValues(LinkerSearchFormXHTML.NAME_TARGETS);
                dictionaries = po.myGetParameterValues(LinkerSearchFormXHTML.NAME_DICTIONARIES);

                facetValue = po.myGetParameter(LinkerSearchFormXHTML.NAME_FACETVALUE);
                facetValue = (null == facetValue) ? "" : facetValue;
                sourceLang = po.myGetParameter(LinkerSearchFormXHTML.NAME_SOURCE);
                facet = po.myGetParameter(LinkerSearchFormXHTML.NAME_FACET);
                comparator = po.myGetParameter(LinkerSearchFormXHTML.NAME_OPERATOR);
                comparisonOperator = (comparator != null) ? Integer.valueOf(comparator).intValue() : 0;
                
                xsl = po.myGetParameter(LinkerSearchFormXHTML.NAME_XSL);
                
                isInitialized = true;
            }
        }
        
    }

    SearchFormParameters parameters = new SearchFormParameters();

    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return true;
    }
    
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean userMayUseThisPO() {
        return true;
    }

    public  Node getBrowserForm() throws Exception {
        LinkerSearchFormXHTML searchForm = (LinkerSearchFormXHTML) 
            MultilingualXHtmlTemplateFactory.createTemplate("fr.imag.clips.papillon.presentation.xhtmlgdef", "LinkerSearchFormXHTML", this.myComms, this.sessionData);

        String idFieldName = myGetParameter(LinkerSearchFormXHTML.NAME_idFieldName);
        String langFieldName = myGetParameter(LinkerSearchFormXHTML.NAME_langFieldName);
        searchForm.getElementIdFieldName().setValue(idFieldName);
        searchForm.getElementLangFieldName().setValue(langFieldName);

        // Parameter initialization is generic
        parameters.initializeSearchParameters(this);
                        
        // update searchForm with requested parameters
        searchForm.getElementValueField().setValue(parameters.facetValue);
        searchForm.getElementXsl().setValue(parameters.xsl);

        XHTMLInputElement volTemplate = searchForm.getElementVolumes();
        volTemplate.removeAttribute("id");
        Node volParent = volTemplate.getParentNode();
        for (int i=0; i < parameters.volumes.length; i++) {
            volTemplate.setValue(parameters.volumes[i]);
            volParent.insertBefore(volTemplate.cloneNode(true), volTemplate);
        }
        volParent.removeChild(volTemplate);
        
        XHTMLInputElement dictTemplate = searchForm.getElementDictionaries();
        dictTemplate.removeAttribute("id");
        Node dictParent = dictTemplate.getParentNode();
        for (int i=0; i < parameters.dictionaries.length; i++) {
            dictTemplate.setValue(parameters.dictionaries[i]);
            dictParent.insertBefore(dictTemplate.cloneNode(true), dictTemplate);
        }
        dictParent.removeChild(dictTemplate);
        
        // Targets should be absent in the linker searchForm (monolingual search only...)
        Element targets = searchForm.getElementTargets();
        targets.getParentNode().removeChild(targets);
        
        setSelected(searchForm.getElementFacet(), parameters.facet);
        setSelected(searchForm.getElementOperator(), Integer.toString(parameters.comparisonOperator));

        return (Node) searchForm.getElementAdvancedSearchForm();
    }
    
    public Node getResultList() throws Exception {
        LinkerResultListXHTML resultsListTmpl = (LinkerResultListXHTML) MultilingualXHtmlTemplateFactory.createTemplate("fr.imag.clips.papillon.presentation.xhtmlgdef", "LinkerResultListXHTML", this.myComms, this.sessionData);

        parameters.initializeSearchParameters(this);

        Vector keys = new Vector();
        String[] key = new String[4];
        key[0] = parameters.facet;
        key[1] = parameters.sourceLang; /// mmm sourceLang determines in which dictionary to look for. should be null here ?
        key[2] = parameters.facetValue;
        key[3] = IQuery.QueryBuilderStrategy[parameters.comparisonOperator];
        keys.add(key);
        
		String[] key2 = new String[4];
		key2[0] = Volume.CDM_contributionStatus;
		key2[1] = Volume.DEFAULT_LANG;
		key2[2] = VolumeEntry.VALIDATED_STATUS;
		key2[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];			
		keys.add(key2);			
        
        
        Collection results = new Vector();
        for (int i=0; i < parameters.volumes.length; i++) {
            String volName = parameters.volumes[i];
            if (volName != null && volName != "") {
                Volume vol = VolumesFactory.findVolumeByName(volName);
                if (vol.getSourceLanguage().equals(parameters.sourceLang)) {
                    Dictionary dict = DictionariesFactory.findDictionaryByName(vol.getDictname());
                    results.addAll(VolumeEntriesFactory.getVolumeEntriesVector(dict,vol,keys,null,null,0, 0));
                }
            }
        }
        // Get the list of volumes in which to perform the request (filter the list by source language)
        // Perform the request.
        // display a list view of the result set.
        XHTMLElement noResultsMessage = resultsListTmpl.getElementNoResultsMessage();
        XHTMLElement resultLine = resultsListTmpl.getElementResults();
        XHTMLElement entryNode = resultsListTmpl.getElementEntry();
        XHTMLAnchorElement action = resultsListTmpl.getElementAction();

        noResultsMessage.removeAttribute("id");
        resultLine.removeAttribute("id");
        entryNode.removeAttribute("id");
        action.removeAttribute("id");
        

        if (results.size() != 0) 
            noResultsMessage.getParentNode().removeChild(noResultsMessage);
        
        Iterator iter = results.iterator();
        while(iter.hasNext()) {
            VolumeEntry ve = (VolumeEntry) iter.next();
            QueryResult qr = new QueryResult(QueryResult.UNIQUE_RESULT, ve);
            ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, null, ResultFormatterFactory.XHTML_DIALECT, null);
            removeChildren(entryNode);
            Node entryDOM = (Node)rf.getFormattedResult(qr);
            //Utility.writeNodeToSystemOut(entryDOM);
            entryNode.appendChild(resultsListTmpl.importNode(entryDOM, true));
            action.setAttribute("onClick", "updateParent('" + ve.getEntryId() + "', '" + ve.getSourceLanguage() + "')");
            resultLine.getParentNode().insertBefore(resultLine.cloneNode(true), resultLine);
        }
        
        resultLine.getParentNode().removeChild(resultLine);
        
        return (Node) resultsListTmpl.getElementLinkerResultList();
    }
    
    // FIXME: to me added in a utility class. This is done in many places.
    public static void removeChildren(Node n) {
        while(n.hasChildNodes()) 
            n.removeChild(n.getFirstChild());
    }
    
}
