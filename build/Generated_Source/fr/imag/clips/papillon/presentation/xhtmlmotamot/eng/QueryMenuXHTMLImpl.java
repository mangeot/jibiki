/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlmotamot.eng;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlmotamot/eng/QueryMenu.xhtml
 */
public class QueryMenuXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements QueryMenuXHTML, fr.imag.clips.papillon.presentation.xhtmlmotamot.orig.QueryMenuXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_ConsultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Facet;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Operator;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_QMAllTargetsOption;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_QMTargets;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryMenu;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_SourceLang;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SourceOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_TargetTmpl;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ValueField;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_VolumesDiv;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_VolumesInput;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_VolumesLang;

    /**
     * Class attribute constant for element class accesskey
     */
    public static final String CLASS_accesskey = "accesskey";

    /**
     * Class attribute constant for element class menuBlock
     */
    public static final String CLASS_menuBlock = "menuBlock";

    /**
     * Class attribute constant for element class menuColumnSize
     */
    public static final String CLASS_menuColumnSize = "menuColumnSize";

    /**
     * Class attribute constant for element class menuGo
     */
    public static final String CLASS_menuGo = "menuGo";

    /**
     * Class attribute constant for element class menuTitle
     */
    public static final String CLASS_menuTitle = "menuTitle";

    /**
     * Class attribute constant for element class menuVariableName
     */
    public static final String CLASS_menuVariableName = "menuVariableName";

    /**
     * Class attribute constant for element class menuVariableValue
     */
    public static final String CLASS_menuVariableValue = "menuVariableValue";

    /**
     * Class attribute constant for element class menuVariableValueWidth
     */
    public static final String CLASS_menuVariableValueWidth = "menuVariableValueWidth";

    /**
     * Element name constant for NB_RESULT_PER_PAGE
     */
    public static final String NAME_NB_RESULT_PER_PAGE = "NB_RESULT_PER_PAGE";

    /**
     * Element name constant for OFFSET
     */
    public static final String NAME_OFFSET = "OFFSET";

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
     * Element name constant for action
     */
    public static final String NAME_action = "action";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = QueryMenuXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlmotamot/eng/QueryMenu.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public QueryMenuXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public QueryMenuXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public QueryMenuXHTMLImpl(QueryMenuXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9, $node10, $node11;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9, $elem10;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9, $attr10;
        
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
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("menuBlock");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("QueryMenu");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_QueryMenu = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("menuTitle");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("javascript:void(0)");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Lookup a word in online dictionaries");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Lookup:");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Motamot.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ConsultForm");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("get");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "onsubmit");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("filterVolumes();");
        $attr4.appendChild($node5);
        
        $element_ConsultForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("menuColumnSize");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("menuVariableName");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "accesskey");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("t");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("ValueField");
        $attr9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "class");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("accesskey");
        $attr10.appendChild($node11);
        
        $node11 = document.createTextNode("T");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("erm:");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("menuVariableValue");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Facet");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("FACET.0");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("hidden");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("cdm-headword");
        $attr9.appendChild($node10);
        
        $element_Facet = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Operator");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("OPERATOR.0");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("hidden");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("0");
        $attr9.appendChild($node10);
        
        $element_Operator = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "class");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("menuVariableValueWidth");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("ValueField");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("FACETVALUE.0");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("text");
        $attr9.appendChild($node10);
        
        $element_ValueField = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                    ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("menuColumnSize");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("menuVariableName");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "accesskey");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("s");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("SourceLang");
        $attr9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "class");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("accesskey");
        $attr10.appendChild($node11);
        
        $node11 = document.createTextNode("S");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("ource:");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("menuVariableValue");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "class");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("menuVariableValueWidth");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("SourceLang");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("SOURCE.0");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "onchange");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("updateQMTargets()");
        $attr9.appendChild($node10);
        
        $element_SourceLang = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem9;$elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SourceOptionTemplate");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("NONE");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("NONE");
        $attr10.appendChild($node11);
        
        $element_SourceOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("NONE");
        $elem10.appendChild($node11);
        
        $node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                    ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("menuColumnSize");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("menuVariableName");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "accesskey");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("a");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("QMTargets");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("T");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "class");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("accesskey");
        $attr10.appendChild($node11);
        
        $node11 = document.createTextNode("a");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("rget:");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                         ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("menuVariableValue");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n\t\t\t\t\t\t    ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("TARGETS");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("hidden");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("axi");
        $attr9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "class");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("menuVariableValueWidth");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("QMTargets");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("TARGETS");
        $attr9.appendChild($node10);
        
        $element_QMTargets = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem9;$elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("QMAllTargetsOption");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("All languages");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("*ALL*");
        $attr10.appendChild($node11);
        
        $element_QMAllTargetsOption = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("All");
        $elem10.appendChild($node11);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("TargetTmpl");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("NONE");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("NONE");
        $attr10.appendChild($node11);
        
        $element_TargetTmpl = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("NONE");
        $elem10.appendChild($node11);
        
        $node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                    ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n \t\t\t\t\t");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("VolumesDiv");
        $attr7.appendChild($node8);
        
        $element_VolumesDiv = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem7;$node8 = document.createTextNode("\n\t\t\t\t\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VolumesLang");
        $attr8.appendChild($node9);
        
        $element_VolumesLang = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem8;$node9 = document.createTextNode("\n\t\t\t\t\t\t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VolumesInput");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VOLUMES");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("hidden");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("*ALL*");
        $attr9.appendChild($node10);
        
        $element_VolumesInput = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n\t\t\t\t\t\t");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t\t\t\t");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                   ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("XSL");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Default");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("NB_RESULT_PER_PAGE");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("OFFSET");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("action");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lookup");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("menuGo");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("submit");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Go");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AdvancedSearch.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "title");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Advanced Lookup of a Word");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Advanced Lookup");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ViewDictionaries.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "title");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Dictionary List");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Dictionary List");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new QueryMenuXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ConsultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementConsultForm() {
        return $element_ConsultForm;
    }

    /**
     * Get the element with id <CODE>Facet</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementFacet() {
        return $element_Facet;
    }

    /**
     * Get the element with id <CODE>Operator</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementOperator() {
        return $element_Operator;
    }

    /**
     * Get the element with id <CODE>QMAllTargetsOption</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementQMAllTargetsOption() {
        return $element_QMAllTargetsOption;
    }

    /**
     * Get the element with id <CODE>QMTargets</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementQMTargets() {
        return $element_QMTargets;
    }

    /**
     * Get the element with id <CODE>QueryMenu</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryMenu() {
        return $element_QueryMenu;
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
     * Get the element with id <CODE>TargetTmpl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementTargetTmpl() {
        return $element_TargetTmpl;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>VolumesDiv</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementVolumesDiv() {
        return $element_VolumesDiv;
    }

    /**
     * Get the element with id <CODE>VolumesInput</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVolumesInput() {
        return $element_VolumesInput;
    }

    /**
     * Get the element with id <CODE>VolumesLang</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementVolumesLang() {
        return $element_VolumesLang;
    }

    /**
     * Get the element with id <CODE>ConsultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagConsultForm() {
        return $element_ConsultForm;
    }

    /**
     * Get the element with id <CODE>Facet</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFacet() {
        return $element_Facet;
    }

    /**
     * Get the element with id <CODE>Operator</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOperator() {
        return $element_Operator;
    }

    /**
     * Get the element with id <CODE>QMAllTargetsOption</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQMAllTargetsOption() {
        return $element_QMAllTargetsOption;
    }

    /**
     * Get the element with id <CODE>QMTargets</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQMTargets() {
        return $element_QMTargets;
    }

    /**
     * Get the element with id <CODE>QueryMenu</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryMenu() {
        return $element_QueryMenu;
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
     * Get the element with id <CODE>TargetTmpl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargetTmpl() {
        return $element_TargetTmpl;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>VolumesDiv</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumesDiv() {
        return $element_VolumesDiv;
    }

    /**
     * Get the element with id <CODE>VolumesInput</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumesInput() {
        return $element_VolumesInput;
    }

    /**
     * Get the element with id <CODE>VolumesLang</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumesLang() {
        return $element_VolumesLang;
    }

    /**
     * Get the value of text child of element <CODE>QMAllTargetsOption</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQMAllTargetsOption(String text) {
        doSetText($element_QMAllTargetsOption, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryMenu</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryMenu(String text) {
        doSetText($element_QueryMenu, text);
    }

    /**
     * Get the value of text child of element <CODE>SourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSourceOptionTemplate(String text) {
        doSetText($element_SourceOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>TargetTmpl</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargetTmpl(String text) {
        doSetText($element_TargetTmpl, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumesDiv</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumesDiv(String text) {
        doSetText($element_VolumesDiv, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumesLang</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumesLang(String text) {
        doSetText($element_VolumesLang, text);
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
