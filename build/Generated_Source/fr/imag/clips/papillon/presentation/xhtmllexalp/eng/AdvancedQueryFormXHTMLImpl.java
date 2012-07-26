/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmllexalp.eng;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmllexalp/eng/AdvancedQueryForm.xhtml
 */
public class AdvancedQueryFormXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdvancedQueryFormXHTML, fr.imag.clips.papillon.presentation.xhtmllexalp.orig.AdvancedQueryFormXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Action;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_AdvancedSearchForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_CriteriaZone;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Criterion;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Dictionaries;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_DictionarySelection;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_DictionaryTmpl;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Facet;

    private org.enhydra.xml.xhtml.dom.XHTMLImageElement $element_Minus;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_MyFinishedContributions;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_MyNotFinishedContributions;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_NumberOfCriteria;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_NumberOfResultPerPage;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Offset;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Operator;

    private org.enhydra.xml.xhtml.dom.XHTMLImageElement $element_Plus;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QuickLink;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_RowShowHideTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_SearchForm;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_SourceLang;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SourceOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_TableShowHideElement;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_TargetLanguagesSelection;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_TargetTmpl;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Targets;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Tmp;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ValueField;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeTmpl;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Volumes;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Xsl;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_XslTmpl;

    /**
     * Class attribute constant for element class quick_link
     */
    public static final String CLASS_quick_link = "quick_link";

    /**
     * Class attribute constant for element class quick_search
     */
    public static final String CLASS_quick_search = "quick_search";

    /**
     * Element name constant for ACTION
     */
    public static final String NAME_ACTION = "ACTION";

    /**
     * Element name constant for CRITERIA_NB
     */
    public static final String NAME_CRITERIA_NB = "CRITERIA_NB";

    /**
     * Element name constant for DICTIONARIES
     */
    public static final String NAME_DICTIONARIES = "DICTIONARIES";

    /**
     * Element name constant for FACET
     */
    public static final String NAME_FACET = "FACET";

    /**
     * Element name constant for FACETVALUE
     */
    public static final String NAME_FACETVALUE = "FACETVALUE";

    /**
     * Element name constant for NB_RESULT_PER_PAGE
     */
    public static final String NAME_NB_RESULT_PER_PAGE = "NB_RESULT_PER_PAGE";

    /**
     * Element name constant for OFFSET
     */
    public static final String NAME_OFFSET = "OFFSET";

    /**
     * Element name constant for OPERATOR
     */
    public static final String NAME_OPERATOR = "OPERATOR";

    /**
     * Element name constant for SOURCE
     */
    public static final String NAME_SOURCE = "SOURCE";

    /**
     * Element name constant for TARGETS
     */
    public static final String NAME_TARGETS = "TARGETS";

    /**
     * Element name constant for VOLUMES
     */
    public static final String NAME_VOLUMES = "VOLUMES";

    /**
     * Element name constant for XSL
     */
    public static final String NAME_XSL = "XSL";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = AdvancedQueryFormXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmllexalp/eng/AdvancedQueryForm.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdvancedQueryFormXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdvancedQueryFormXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdvancedQueryFormXHTMLImpl(AdvancedQueryFormXHTMLImpl src) {
        setDocument((Document)src.getDocument().cloneNode(true), src.getMIMEType(), src.getEncoding());
        syncAccessMethods();
    }

    /**
     * Create document as a DOM and initialize accessor method fields.
     */
    public void buildDocument() {
        org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl document = buildSubDocument();
        setDocument(document,"application/xhtml+xml", "utf-8");
        
    }

    /**
     * Create a subtree of the document.
     */
    private org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl buildSubDocument() {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7;
        
        org.enhydra.apache.xerces.dom.DocumentTypeImpl docType = (org.enhydra.apache.xerces.dom.DocumentTypeImpl)fDOMFactory.createDocumentType("html", "-//W3C//DTD XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", null);
        org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl document = (org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl)fDOMFactory.createDocument("http://www.w3.org/1999/xhtml", "html", docType);
        $elem1 = document.getDocumentElement();
        document.createElementNS("http://www.w3.org/1999/xhtml", "html");
        
        $attr1 = document.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("http://www.w3.org/1999/xhtml");
        $attr1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "head");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/html; charset=UTF-8");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "http-equiv");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Content-Type");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Menu");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n    \n        //\n        function addOrRemoveCriterion(caller, action) {\n            document.getElementById('Action').value = action + caller;\n            document.getElementById(\"SearchForm\").submit();\n        }\n\n    ");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n                     ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("AdvancedSearchForm");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_AdvancedSearchForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SearchForm");
        $attr4.appendChild($node5);
        
        $element_SearchForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem4;buildSubDocument_0(document, $elem4);
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:block; padding: 5px;");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Display ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("NumberOfResultPerPage");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("NB_RESULT_PER_PAGE");
        $attr6.appendChild($node7);
        
        $element_NumberOfResultPerPage = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("10");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("5");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("10");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("10");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("10");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("20");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("20");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("20");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("50");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("50");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("50");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("100");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("100");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("100");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("all");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("0");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("all");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("results per page using form:");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Xsl");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("XSL");
        $attr6.appendChild($node7);
        
        $element_Xsl = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Default");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Default");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("XslTmpl");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Default");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $element_XslTmpl = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem7;$node8 = document.createTextNode("Default");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Offset");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("OFFSET");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $element_Offset = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Action");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ACTION");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_Action = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Go");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "style");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("display:block; padding:5px;");
        $attr0.appendChild($node1);
        
        $node1 = document.createTextNode("\n          ");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "border");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("0");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "cellpadding");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("0");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "cellspacing");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("0");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "summary");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("Search Form");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "width");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("100%");
        $attr1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "valign");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("top");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("\n                ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("DictionarySelection");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("padding:5px; display: none;");
        $attr4.appendChild($node5);
        
        $element_DictionarySelection = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Find entries in: ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment(" MULTIPLE VALUES: TARGETS, DICTIONARIES ");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Dictionaries");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "multiple");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("multiple");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("DICTIONARIES");
        $attr5.appendChild($node6);
        
        $element_Dictionaries = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("dictionaryTmpl");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "label");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("All dictionaries");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("*All*");
        $attr6.appendChild($node7);
        
        $element_DictionaryTmpl = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem6;$node7 = document.createTextNode("All dictionaries");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n \t\t\t\t  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Volumes");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "multiple");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("multiple");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("VOLUMES");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $element_Volumes = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("volumeTmpl");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "label");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("All volumes");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("*All*");
        $attr6.appendChild($node7);
        
        $element_VolumeTmpl = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem6;$node7 = document.createTextNode("All volumes");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n               ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("\n                ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("CriteriaZone");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode(" padding:5px;");
        $attr4.appendChild($node5);
        
        $element_CriteriaZone = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n                ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment(" HIDDEN ELEMENTS  ");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n                    ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("tableShowHideElement");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display: none;");
        $attr5.appendChild($node6);
        
        $element_TableShowHideElement = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("rowShowHideTemplate");
        $attr6.appendChild($node7);
        
        $element_RowShowHideTemplate = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("cdm-headword");
        $elem7.appendChild($node8);
        
        $node5 = document.createTextNode("\n                    ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("tmp");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display: none;");
        $attr5.appendChild($node6);
        
        $element_Tmp = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createComment(" ");
        $elem5.appendChild($node6);
        
        $node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NumberOfCriteria");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("CRITERIA_NB");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("hidden");
        $attr5.appendChild($node6);
        
        $element_NumberOfCriteria = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("criterion");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:block; margin-left: 0px;");
        $attr5.appendChild($node6);
        
        $element_Criterion = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("-");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("minus");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("addOrRemoveCriterion(this.id, '-');");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/minus.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("15");
        $attr6.appendChild($node7);
        
        $element_Minus = (org.enhydra.xml.xhtml.dom.XHTMLImageElement)$elem6;$node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("+");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("plus");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("addOrRemoveCriterion(this.id, '+');");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/plus.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("15");
        $attr6.appendChild($node7);
        
        $element_Plus = (org.enhydra.xml.xhtml.dom.XHTMLImageElement)$elem6;$node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Facet");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("FACET");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onchange");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hideOrNotSourceLang(value, name); getSelector(value, name);");
        $attr6.appendChild($node7);
        
        $element_Facet = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Term");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-headword");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Term");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Definition");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-definition");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Definition");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Translation");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-translation");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Translation");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Grammar");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-pos");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Grammar");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Context");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-context");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Context");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Example");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-example");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Example");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Note");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-note");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Note");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Source");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lexalp-source");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Source");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Legal system");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lexalp-legal-system");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Legal system");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Domain number");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lexalp-domain");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Domain number");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Geographical usage");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lexalp-usage");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Geographical usage");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Axie");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("axi-reflexie");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Axie");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Modified by");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-modification-author");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Modified by");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Created by");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-contribution-author");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Created by");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Date");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-modification-date");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Date");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Harmonising status");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lexalp-harmonising-status");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Harmonising status");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Process status");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lexalp-process-status");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Process status");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Entry status");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-contribution-status");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Progress");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Entry Id");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-entry-id");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Entry Id");
        $elem7.appendChild($node8);
        
        $node7 = document.createComment("<option value=\"cdm-contribution-id\" label=\"Entry Id\">Contribution Id</option>");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Operator");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("OPERATOR");
        $attr6.appendChild($node7);
        
        $element_Operator = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("contains");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("4");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("contains");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("is");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("is");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("starts with");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("6");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("starts with");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ends with");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("ends with");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("greater than");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("10");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("greater than");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lower than");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("11");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("lower than");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ValueField");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "maxlength");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("128");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("FACETVALUE");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "size");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("20");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text");
        $attr7.appendChild($node8);
        
        $element_ValueField = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("   \n                    ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("visibility: visible;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $node7 = document.createComment("\n                        <label id=\"SourceLangLabel\" for=\"SourceLang\" accesskey=\"i\" >\n                        <span class=\"accesskey\">I</span>n:</label>\n                        ");
        $elem6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("padding-left: 1em;");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("source language:");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SourceLang");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SOURCE");
        $attr7.appendChild($node8);
        
        $element_SourceLang = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("All");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("All");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("all languages");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("SourceOptionTemplate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $element_SourceOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem8;$node9 = document.createTextNode("NONE");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n                  ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n                ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("\n                ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("quick_search");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("TargetLanguagesSelection");
        $attr4.appendChild($node5);
        
        $element_TargetLanguagesSelection = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Show target languages :");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n                  ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Targets");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "multiple");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("multiple");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("TARGETS");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("width: 120px;");
        $attr5.appendChild($node6);
        
        $element_Targets = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("TargetTmpl");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "label");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("All languages");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("*All*");
        $attr6.appendChild($node7);
        
        $element_TargetTmpl = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem6;$node7 = document.createTextNode("All languages");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n                ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("\n                    ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("quick_search");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QuickLink");
        $attr4.appendChild($node5);
        
        $element_QuickLink = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n                        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Quick search :");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n                        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("quick_link");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("MyFinishedContributions");
        $attr5.appendChild($node6);
        
        $element_MyFinishedContributions = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("My finished contributions");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n                        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("quick_link");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("MyNotFinishedContributions");
        $attr5.appendChild($node6);
        
        $element_MyNotFinishedContributions = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("My unfinished contributions");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n                    ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n                ");
        $elem3.appendChild($node4);
        
        $node1 = document.createTextNode("\n          ");
        $elem0.appendChild($node1);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new AdvancedQueryFormXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>Action</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAction() {
        return $element_Action;
    }

    /**
     * Get the element with id <CODE>AdvancedSearchForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementAdvancedSearchForm() {
        return $element_AdvancedSearchForm;
    }

    /**
     * Get the element with id <CODE>CriteriaZone</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementCriteriaZone() {
        return $element_CriteriaZone;
    }

    /**
     * Get the element with id <CODE>criterion</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementCriterion() {
        return $element_Criterion;
    }

    /**
     * Get the element with id <CODE>Dictionaries</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementDictionaries() {
        return $element_Dictionaries;
    }

    /**
     * Get the element with id <CODE>DictionarySelection</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementDictionarySelection() {
        return $element_DictionarySelection;
    }

    /**
     * Get the element with id <CODE>dictionaryTmpl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementDictionaryTmpl() {
        return $element_DictionaryTmpl;
    }

    /**
     * Get the element with id <CODE>Facet</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementFacet() {
        return $element_Facet;
    }

    /**
     * Get the element with id <CODE>minus</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLImageElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLImageElement getElementMinus() {
        return $element_Minus;
    }

    /**
     * Get the element with id <CODE>MyFinishedContributions</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementMyFinishedContributions() {
        return $element_MyFinishedContributions;
    }

    /**
     * Get the element with id <CODE>MyNotFinishedContributions</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementMyNotFinishedContributions() {
        return $element_MyNotFinishedContributions;
    }

    /**
     * Get the element with id <CODE>NumberOfCriteria</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementNumberOfCriteria() {
        return $element_NumberOfCriteria;
    }

    /**
     * Get the element with id <CODE>NumberOfResultPerPage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementNumberOfResultPerPage() {
        return $element_NumberOfResultPerPage;
    }

    /**
     * Get the element with id <CODE>Offset</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementOffset() {
        return $element_Offset;
    }

    /**
     * Get the element with id <CODE>Operator</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementOperator() {
        return $element_Operator;
    }

    /**
     * Get the element with id <CODE>plus</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLImageElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLImageElement getElementPlus() {
        return $element_Plus;
    }

    /**
     * Get the element with id <CODE>QuickLink</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQuickLink() {
        return $element_QuickLink;
    }

    /**
     * Get the element with id <CODE>rowShowHideTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementRowShowHideTemplate() {
        return $element_RowShowHideTemplate;
    }

    /**
     * Get the element with id <CODE>SearchForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementSearchForm() {
        return $element_SearchForm;
    }

    /**
     * Get the element with id <CODE>SourceLang</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSourceLang() {
        return $element_SourceLang;
    }

    /**
     * Get the element with id <CODE>SourceOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementSourceOptionTemplate() {
        return $element_SourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>tableShowHideElement</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementTableShowHideElement() {
        return $element_TableShowHideElement;
    }

    /**
     * Get the element with id <CODE>TargetLanguagesSelection</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementTargetLanguagesSelection() {
        return $element_TargetLanguagesSelection;
    }

    /**
     * Get the element with id <CODE>TargetTmpl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementTargetTmpl() {
        return $element_TargetTmpl;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>tmp</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementTmp() {
        return $element_Tmp;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>volumeTmpl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeTmpl() {
        return $element_VolumeTmpl;
    }

    /**
     * Get the element with id <CODE>Volumes</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementVolumes() {
        return $element_Volumes;
    }

    /**
     * Get the element with id <CODE>Xsl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementXsl() {
        return $element_Xsl;
    }

    /**
     * Get the element with id <CODE>XslTmpl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementXslTmpl() {
        return $element_XslTmpl;
    }

    /**
     * Get the element with id <CODE>Action</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAction() {
        return $element_Action;
    }

    /**
     * Get the element with id <CODE>AdvancedSearchForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAdvancedSearchForm() {
        return $element_AdvancedSearchForm;
    }

    /**
     * Get the element with id <CODE>CriteriaZone</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCriteriaZone() {
        return $element_CriteriaZone;
    }

    /**
     * Get the element with id <CODE>criterion</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCriterion() {
        return $element_Criterion;
    }

    /**
     * Get the element with id <CODE>Dictionaries</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionaries() {
        return $element_Dictionaries;
    }

    /**
     * Get the element with id <CODE>DictionarySelection</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionarySelection() {
        return $element_DictionarySelection;
    }

    /**
     * Get the element with id <CODE>dictionaryTmpl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionaryTmpl() {
        return $element_DictionaryTmpl;
    }

    /**
     * Get the element with id <CODE>Facet</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFacet() {
        return $element_Facet;
    }

    /**
     * Get the element with id <CODE>minus</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMinus() {
        return $element_Minus;
    }

    /**
     * Get the element with id <CODE>MyFinishedContributions</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMyFinishedContributions() {
        return $element_MyFinishedContributions;
    }

    /**
     * Get the element with id <CODE>MyNotFinishedContributions</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMyNotFinishedContributions() {
        return $element_MyNotFinishedContributions;
    }

    /**
     * Get the element with id <CODE>NumberOfCriteria</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNumberOfCriteria() {
        return $element_NumberOfCriteria;
    }

    /**
     * Get the element with id <CODE>NumberOfResultPerPage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNumberOfResultPerPage() {
        return $element_NumberOfResultPerPage;
    }

    /**
     * Get the element with id <CODE>Offset</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOffset() {
        return $element_Offset;
    }

    /**
     * Get the element with id <CODE>Operator</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOperator() {
        return $element_Operator;
    }

    /**
     * Get the element with id <CODE>plus</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPlus() {
        return $element_Plus;
    }

    /**
     * Get the element with id <CODE>QuickLink</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQuickLink() {
        return $element_QuickLink;
    }

    /**
     * Get the element with id <CODE>rowShowHideTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRowShowHideTemplate() {
        return $element_RowShowHideTemplate;
    }

    /**
     * Get the element with id <CODE>SearchForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearchForm() {
        return $element_SearchForm;
    }

    /**
     * Get the element with id <CODE>SourceLang</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSourceLang() {
        return $element_SourceLang;
    }

    /**
     * Get the element with id <CODE>SourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSourceOptionTemplate() {
        return $element_SourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>tableShowHideElement</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTableShowHideElement() {
        return $element_TableShowHideElement;
    }

    /**
     * Get the element with id <CODE>TargetLanguagesSelection</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargetLanguagesSelection() {
        return $element_TargetLanguagesSelection;
    }

    /**
     * Get the element with id <CODE>TargetTmpl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargetTmpl() {
        return $element_TargetTmpl;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>tmp</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTmp() {
        return $element_Tmp;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>volumeTmpl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeTmpl() {
        return $element_VolumeTmpl;
    }

    /**
     * Get the element with id <CODE>Volumes</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumes() {
        return $element_Volumes;
    }

    /**
     * Get the element with id <CODE>Xsl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXsl() {
        return $element_Xsl;
    }

    /**
     * Get the element with id <CODE>XslTmpl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXslTmpl() {
        return $element_XslTmpl;
    }

    /**
     * Get the value of text child of element <CODE>AdvancedSearchForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAdvancedSearchForm(String text) {
        doSetText($element_AdvancedSearchForm, text);
    }

    /**
     * Get the value of text child of element <CODE>CriteriaZone</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCriteriaZone(String text) {
        doSetText($element_CriteriaZone, text);
    }

    /**
     * Get the value of text child of element <CODE>criterion</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCriterion(String text) {
        doSetText($element_Criterion, text);
    }

    /**
     * Get the value of text child of element <CODE>DictionarySelection</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictionarySelection(String text) {
        doSetText($element_DictionarySelection, text);
    }

    /**
     * Get the value of text child of element <CODE>dictionaryTmpl</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictionaryTmpl(String text) {
        doSetText($element_DictionaryTmpl, text);
    }

    /**
     * Get the value of text child of element <CODE>MyFinishedContributions</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMyFinishedContributions(String text) {
        doSetText($element_MyFinishedContributions, text);
    }

    /**
     * Get the value of text child of element <CODE>MyNotFinishedContributions</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMyNotFinishedContributions(String text) {
        doSetText($element_MyNotFinishedContributions, text);
    }

    /**
     * Get the value of text child of element <CODE>QuickLink</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQuickLink(String text) {
        doSetText($element_QuickLink, text);
    }

    /**
     * Get the value of text child of element <CODE>SourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSourceOptionTemplate(String text) {
        doSetText($element_SourceOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>TargetLanguagesSelection</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargetLanguagesSelection(String text) {
        doSetText($element_TargetLanguagesSelection, text);
    }

    /**
     * Get the value of text child of element <CODE>TargetTmpl</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargetTmpl(String text) {
        doSetText($element_TargetTmpl, text);
    }

    /**
     * Get the value of text child of element <CODE>tmp</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTmp(String text) {
        doSetText($element_Tmp, text);
    }

    /**
     * Get the value of text child of element <CODE>volumeTmpl</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeTmpl(String text) {
        doSetText($element_VolumeTmpl, text);
    }

    /**
     * Get the value of text child of element <CODE>XslTmpl</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextXslTmpl(String text) {
        doSetText($element_XslTmpl, text);
    }

    /**
     * Called to set access method fields from the DOM.
     * Missing Ids have fields set to null.
     */
    protected void syncWithDocument(Node node) {
        if (node.getNodeType() != Node.DOCUMENT_NODE) {
            throw new org.enhydra.xml.xmlc.XMLCRuntimeException("Node must be a document node");
        }
        Document doc = (Document) node;
        try {
            java.lang.reflect.Field[] fs = this.getClass().getDeclaredFields();
            int substStart = "$element_".length();
            for (int i = 0; i < fs.length; i++) {
                java.lang.reflect.Field f = fs[i];
                if (!f.getName().startsWith("$element_")) continue;
                String id = f.getName().substring(substStart);
                Node idNode = doc.getElementById(id);
                if (idNode == null) {
                    id = id.substring(0, 1).toLowerCase() + id.substring(1);
                    idNode = doc.getElementById(id);
                }
                if (idNode != null) f.set(this, idNode);
            }
        } catch (Exception e) {
            throw new org.enhydra.xml.xmlc.XMLCRuntimeException("Error reflecting on element access fields", e);
        }
    }

}
