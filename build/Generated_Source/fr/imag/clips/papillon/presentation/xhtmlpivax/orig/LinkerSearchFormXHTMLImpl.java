/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlpivax.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlpivax/orig/LinkerSearchForm.xhtml
 */
public class LinkerSearchFormXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements LinkerSearchFormXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_AdvancedSearchForm;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_AllSystemsOption;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_AllTargetsOption;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Axeme;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_AxemeHandle;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_AxieHandle;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Criterion;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Dictionaries;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Facet;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Operator;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_SearchForm;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_System;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SystemOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Systems;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_TargetLang;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_TargetOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Targets;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ValueField;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Volumes;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Xsl;

    /**
     * Class attribute constant for element class accesskey
     */
    public static final String CLASS_accesskey = "accesskey";

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
     * Element name constant for OPERATOR
     */
    public static final String NAME_OPERATOR = "OPERATOR";

    /**
     * Element name constant for SOURCE
     */
    public static final String NAME_SOURCE = "SOURCE";

    /**
     * Element name constant for SYSTEM
     */
    public static final String NAME_SYSTEM = "SYSTEM";

    /**
     * Element name constant for SYSTEMS
     */
    public static final String NAME_SYSTEMS = "SYSTEMS";

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
     * Element name constant for axeme
     */
    public static final String NAME_axeme = "axeme";

    /**
     * Element name constant for axemeHandle
     */
    public static final String NAME_axemeHandle = "axemeHandle";

    /**
     * Element name constant for axieHandle
     */
    public static final String NAME_axieHandle = "axieHandle";

    /**
     * Element name constant for lookup
     */
    public static final String NAME_lookup = "lookup";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = LinkerSearchFormXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlpivax/orig/LinkerSearchForm.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public LinkerSearchFormXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public LinkerSearchFormXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public LinkerSearchFormXHTMLImpl(LinkerSearchFormXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8;
        
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
        
        $element_SearchForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n        Find entries where:");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem5.appendChild($elem6);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node6 = document.createComment(" MULTIPLE VALUES: VOLUMES, TARGETS, ");
        $elem5.appendChild($node6);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node6 = document.createComment("input type=\"hidden\" name=\"idFieldName\" id=\"idFieldName\"/>\n        <input type=\"hidden\" name=\"handleFieldName\" id=\"handleFieldName\"/>\n        <input type=\"hidden\" name=\"volFieldName\" id=\"volFieldName\"/");
        $elem5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          \n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Volumes");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("VOLUMES");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_Volumes = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Targets");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("TARGETS");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_Targets = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Systems");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("SYSTEMS");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_Systems = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("  \n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("axeme");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("axeme");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_Axeme = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("axemeHandle");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("axemeHandle");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_AxemeHandle = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("  \n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("axieHandle");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("axieHandle");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_AxieHandle = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("    \n          \n        ");
        $elem5.appendChild($node6);
        
        $node6 = document.createComment(" multiple selection: dictionaries to search into ");
        $elem5.appendChild($node6);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Dictionaries");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("DICTIONARIES");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $element_Dictionaries = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("criterion");
        $attr6.appendChild($node7);
        
        $element_Criterion = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem6;$node7 = document.createTextNode("\n        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Facet");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("FACET");
        $attr7.appendChild($node8);
        
        $element_Facet = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Headword");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("cdm-headword");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Headword");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Entry Id");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("cdm-entry-id");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Entry Id");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Definition");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("cdm-definition");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Definition");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Context");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("cdm-example");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Context");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Axie");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("axi-reflexie");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Axie");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode(" \n        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Operator");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("OPERATOR");
        $attr7.appendChild($node8);
        
        $element_Operator = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("contains");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("4");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("contains");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("is");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("2");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("is");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("starts with");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("6");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("starts with");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ends with");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("5");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("ends with");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode("\n        ");
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
        $node8 = document.createTextNode("14");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text");
        $attr7.appendChild($node8);
        
        $element_ValueField = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "accesskey");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("i");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "for");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("TargetLang");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("accesskey");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("I");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("n:");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("TargetLang");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SOURCE");
        $attr7.appendChild($node8);
        
        $element_TargetLang = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AllTargetsOption");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ALL");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("*ALL*");
        $attr8.appendChild($node9);
        
        $element_AllTargetsOption = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem8;$node9 = document.createTextNode("All languages");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("TargetOptionTemplate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $element_TargetOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem8;$node9 = document.createTextNode("NONE");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode("\n        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "accesskey");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("s");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "for");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("System");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("accesskey");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("S");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("ystem:");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("System");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SYSTEM");
        $attr7.appendChild($node8);
        
        $element_System = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AllSystemsOption");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ALL");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("*ALL*");
        $attr8.appendChild($node9);
        
        $element_AllSystemsOption = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem8;$node9 = document.createTextNode("All systems");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("SystemOptionTemplate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $element_SystemOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem8;$node9 = document.createTextNode("NONE");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode("  \n        ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Xsl");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("XSL");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Default");
        $attr6.appendChild($node7);
        
        $element_Xsl = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("lookup");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Go");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
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
        return new LinkerSearchFormXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>AdvancedSearchForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementAdvancedSearchForm() {
        return $element_AdvancedSearchForm;
    }

    /**
     * Get the element with id <CODE>AllSystemsOption</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementAllSystemsOption() {
        return $element_AllSystemsOption;
    }

    /**
     * Get the element with id <CODE>AllTargetsOption</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementAllTargetsOption() {
        return $element_AllTargetsOption;
    }

    /**
     * Get the element with id <CODE>axeme</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAxeme() {
        return $element_Axeme;
    }

    /**
     * Get the element with id <CODE>axemeHandle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAxemeHandle() {
        return $element_AxemeHandle;
    }

    /**
     * Get the element with id <CODE>axieHandle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAxieHandle() {
        return $element_AxieHandle;
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
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementDictionaries() {
        return $element_Dictionaries;
    }

    /**
     * Get the element with id <CODE>Facet</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementFacet() {
        return $element_Facet;
    }

    /**
     * Get the element with id <CODE>Operator</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementOperator() {
        return $element_Operator;
    }

    /**
     * Get the element with id <CODE>SearchForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementSearchForm() {
        return $element_SearchForm;
    }

    /**
     * Get the element with id <CODE>System</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSystem() {
        return $element_System;
    }

    /**
     * Get the element with id <CODE>SystemOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementSystemOptionTemplate() {
        return $element_SystemOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Systems</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSystems() {
        return $element_Systems;
    }

    /**
     * Get the element with id <CODE>TargetLang</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementTargetLang() {
        return $element_TargetLang;
    }

    /**
     * Get the element with id <CODE>TargetOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementTargetOptionTemplate() {
        return $element_TargetOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>Volumes</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVolumes() {
        return $element_Volumes;
    }

    /**
     * Get the element with id <CODE>Xsl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementXsl() {
        return $element_Xsl;
    }

    /**
     * Get the element with id <CODE>AdvancedSearchForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAdvancedSearchForm() {
        return $element_AdvancedSearchForm;
    }

    /**
     * Get the element with id <CODE>AllSystemsOption</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAllSystemsOption() {
        return $element_AllSystemsOption;
    }

    /**
     * Get the element with id <CODE>AllTargetsOption</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAllTargetsOption() {
        return $element_AllTargetsOption;
    }

    /**
     * Get the element with id <CODE>axeme</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAxeme() {
        return $element_Axeme;
    }

    /**
     * Get the element with id <CODE>axemeHandle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAxemeHandle() {
        return $element_AxemeHandle;
    }

    /**
     * Get the element with id <CODE>axieHandle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAxieHandle() {
        return $element_AxieHandle;
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
     * Get the element with id <CODE>SearchForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearchForm() {
        return $element_SearchForm;
    }

    /**
     * Get the element with id <CODE>System</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSystem() {
        return $element_System;
    }

    /**
     * Get the element with id <CODE>SystemOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSystemOptionTemplate() {
        return $element_SystemOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Systems</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSystems() {
        return $element_Systems;
    }

    /**
     * Get the element with id <CODE>TargetLang</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargetLang() {
        return $element_TargetLang;
    }

    /**
     * Get the element with id <CODE>TargetOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargetOptionTemplate() {
        return $element_TargetOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValueField() {
        return $element_ValueField;
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
     * Get the value of text child of element <CODE>AdvancedSearchForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAdvancedSearchForm(String text) {
        doSetText($element_AdvancedSearchForm, text);
    }

    /**
     * Get the value of text child of element <CODE>AllSystemsOption</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAllSystemsOption(String text) {
        doSetText($element_AllSystemsOption, text);
    }

    /**
     * Get the value of text child of element <CODE>AllTargetsOption</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAllTargetsOption(String text) {
        doSetText($element_AllTargetsOption, text);
    }

    /**
     * Get the value of text child of element <CODE>criterion</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCriterion(String text) {
        doSetText($element_Criterion, text);
    }

    /**
     * Get the value of text child of element <CODE>SystemOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSystemOptionTemplate(String text) {
        doSetText($element_SystemOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>TargetOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargetOptionTemplate(String text) {
        doSetText($element_TargetOptionTemplate, text);
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
