/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/AdvancedSearchFormTest.xhtml
 */
public class AdvancedSearchFormTestXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdvancedSearchFormTestXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Action;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_AdvancedSearchFormTest;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_CriteriaZone;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Criterion;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Facet;

    private org.enhydra.xml.xhtml.dom.XHTMLImageElement $element_Minus;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_NumberOfResultPerPage;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Offset;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Operator;

    private org.enhydra.xml.xhtml.dom.XHTMLImageElement $element_Plus;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_SearchFormTest;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Source;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_SourceLang;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SourceOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ValueField;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ValueWord;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_WordSearch;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Xsl;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_XslTmpl;

    /**
     * Class attribute constant for element class menuVariableValueWidth
     */
    public static final String CLASS_menuVariableValueWidth = "menuVariableValueWidth";

    /**
     * Element name constant for ACTION
     */
    public static final String NAME_ACTION = "ACTION";

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
     * Element name constant for VALUEWORD
     */
    public static final String NAME_VALUEWORD = "VALUEWORD";

    /**
     * Element name constant for XSL
     */
    public static final String NAME_XSL = "XSL";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = AdvancedSearchFormTestXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/AdvancedSearchFormTest.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdvancedSearchFormTestXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdvancedSearchFormTestXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdvancedSearchFormTestXHTMLImpl(AdvancedSearchFormTestXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9, $node10, $node11, $node12, $node13;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9, $elem10, $elem11, $elem12;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9, $attr10, $attr11, $attr12;
        
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
        $node4 = document.createTextNode("AdvancedSearchFormTest");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_AdvancedSearchFormTest = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SearchFormTest");
        $attr4.appendChild($node5);
        
        $element_SearchFormTest = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:block; padding:5px;");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "border");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("0");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "cellpadding");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("0");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "cellspacing");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("0");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "summary");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Search Form");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("100%");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "valign");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("top");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("WordSearch");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "style");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("padding:5px; ");
        $attr9.appendChild($node10);
        
        $element_WordSearch = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem9;$node10 = document.createTextNode("\n                  ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem9.appendChild($elem10);
        
        $node11 = document.createTextNode("Word :");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("\n                  ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem9.appendChild($elem10);
        
        $node10 = document.createTextNode("\n\t\t\t\t\t");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("ValueWord");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "maxlength");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("128");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "name");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("VALUEWORD");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "size");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("14");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "type");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("text");
        $attr10.appendChild($node11);
        
        $element_ValueWord = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem10;$node10 = document.createTextNode("\n                ");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n              \t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Source");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "style");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("padding:5px; ");
        $attr9.appendChild($node10);
        
        $element_Source = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem9;$node10 = document.createTextNode("\n                  ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem9.appendChild($elem10);
        
        $node11 = document.createTextNode("Langue Source :");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("\n                  ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem9.appendChild($elem10);
        
        $node10 = document.createTextNode("\n\t\t\t\t\t");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "class");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("menuVariableValueWidth");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SourceLang");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "name");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SOURCE.0");
        $attr10.appendChild($node11);
        
        $element_SourceLang = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem10;$elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("SourceOptionTemplate");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "label");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("NONE");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "value");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("NONE");
        $attr11.appendChild($node12);
        
        $element_SourceOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem11;$node12 = document.createTextNode("NONE");
        $elem11.appendChild($node12);
        
        $node10 = document.createTextNode("\n                ");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("CriteriaZone");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "style");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode(" padding:5px;");
        $attr9.appendChild($node10);
        
        $element_CriteriaZone = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem9;$node10 = document.createTextNode("\n                  ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem9.appendChild($elem10);
        
        $node11 = document.createTextNode("Liens des entr\u00e9es");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("\n                  ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("criterion");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "style");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("display:block; margin-left: 10px;");
        $attr10.appendChild($node11);
        
        $element_Criterion = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem10;$node11 = document.createTextNode("\n                    ");
        $elem10.appendChild($node11);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "alt");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("-");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("minus");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "onclick");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("addOrRemoveCriterion(this.id, '-');");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "src");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("media/minus.jpg");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "width");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("15");
        $attr11.appendChild($node12);
        
        $element_Minus = (org.enhydra.xml.xhtml.dom.XHTMLImageElement)$elem11;$node11 = document.createTextNode("\n                    ");
        $elem10.appendChild($node11);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "alt");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("+");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("plus");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "onclick");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("addOrRemoveCriterion(this.id, '+');");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "src");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("media/plus.jpg");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "width");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("15");
        $attr11.appendChild($node12);
        
        $element_Plus = (org.enhydra.xml.xhtml.dom.XHTMLImageElement)$elem11;$node11 = document.createTextNode("\n                    ");
        $elem10.appendChild($node11);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("Facet");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("FACET");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "onchange");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("hideOrNotSourceLang(value, name);");
        $attr11.appendChild($node12);
        
        $element_Facet = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem11;$elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "label");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("Poids");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "value");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("weight");
        $attr12.appendChild($node13);
        
        $node13 = document.createTextNode("Poids");
        $elem12.appendChild($node13);
        
        $elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "label");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("Dictionnaire");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "value");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("dictionnary");
        $attr12.appendChild($node13);
        
        $node13 = document.createTextNode("Dictionnaire");
        $elem12.appendChild($node13);
        
        $elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "label");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("Langue Cible");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "value");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("target");
        $attr12.appendChild($node13);
        
        $node13 = document.createTextNode("Langue Cible");
        $elem12.appendChild($node13);
        
        $node11 = document.createTextNode("\n                    ");
        $elem10.appendChild($node11);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("Operator");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("OPERATOR");
        $attr11.appendChild($node12);
        
        $element_Operator = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem11;$elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "label");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("est");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "value");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("0");
        $attr12.appendChild($node13);
        
        $node13 = document.createTextNode("est");
        $elem12.appendChild($node13);
        
        $elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "label");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("plus grand que");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "value");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("1");
        $attr12.appendChild($node13);
        
        $node13 = document.createTextNode("plus grand que");
        $elem12.appendChild($node13);
        
        $elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "label");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("plus petit que");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "value");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("2");
        $attr12.appendChild($node13);
        
        $node13 = document.createTextNode("plus petit que");
        $elem12.appendChild($node13);
        
        $node11 = document.createTextNode("\n                    ");
        $elem10.appendChild($node11);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("ValueField");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "maxlength");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("128");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("FACETVALUE");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "size");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("14");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "type");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("text");
        $attr11.appendChild($node12);
        
        $element_ValueField = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem11;$node11 = document.createTextNode("\n                  ");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("\n                ");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
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
        
        $node7 = document.createTextNode("Affiche ");
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
        
        $node7 = document.createComment("option label=\"all\" value=\"0\">tous les</option");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("r\u00e9sultats par page avec la forme ");
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
        $node8 = document.createTextNode("par d\u00e9faut");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("par d\u00e9faut");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("XslTmpl");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("par d\u00e9faut");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $element_XslTmpl = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem7;$node8 = document.createTextNode("d\u00e9faut");
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
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new AdvancedSearchFormTestXHTMLImpl(this);
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
     * Get the element with id <CODE>AdvancedSearchFormTest</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementAdvancedSearchFormTest() {
        return $element_AdvancedSearchFormTest;
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
     * Get the element with id <CODE>SearchFormTest</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementSearchFormTest() {
        return $element_SearchFormTest;
    }

    /**
     * Get the element with id <CODE>Source</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementSource() {
        return $element_Source;
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
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>ValueWord</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValueWord() {
        return $element_ValueWord;
    }

    /**
     * Get the element with id <CODE>WordSearch</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementWordSearch() {
        return $element_WordSearch;
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
     * Get the element with id <CODE>AdvancedSearchFormTest</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAdvancedSearchFormTest() {
        return $element_AdvancedSearchFormTest;
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
     * Get the element with id <CODE>SearchFormTest</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearchFormTest() {
        return $element_SearchFormTest;
    }

    /**
     * Get the element with id <CODE>Source</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSource() {
        return $element_Source;
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
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>ValueWord</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValueWord() {
        return $element_ValueWord;
    }

    /**
     * Get the element with id <CODE>WordSearch</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagWordSearch() {
        return $element_WordSearch;
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
     * Get the value of text child of element <CODE>AdvancedSearchFormTest</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAdvancedSearchFormTest(String text) {
        doSetText($element_AdvancedSearchFormTest, text);
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
     * Get the value of text child of element <CODE>Source</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSource(String text) {
        doSetText($element_Source, text);
    }

    /**
     * Get the value of text child of element <CODE>SourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSourceOptionTemplate(String text) {
        doSetText($element_SourceOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>WordSearch</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextWordSearch(String text) {
        doSetText($element_WordSearch, text);
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
