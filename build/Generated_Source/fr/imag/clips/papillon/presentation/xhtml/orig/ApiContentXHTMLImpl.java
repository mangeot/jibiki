/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/ApiContent.xhtml
 */
public class ApiContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ApiContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ApiContent;

    /**
     * Class attribute constant for element class api
     */
    public static final String CLASS_api = "api";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ApiContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/ApiContent.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ApiContentXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ApiContentXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ApiContentXHTMLImpl(ApiContentXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4;
        Element $elem0, $elem1, $elem2, $elem3;
        Attr $attr0, $attr1, $attr2, $attr3;
        
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
        
        $node4 = document.createTextNode("Papillon");
        $elem3.appendChild($node4);
        
        buildSubDocument_0(document, $elem1);
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        parentNode.appendChild($elem0);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "id");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("ApiContent");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "lang");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("en");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("en");
        $attr1.appendChild($node2);
        
        $element_ApiContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem1;$node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "style");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("text-align:center");
        $attr2.appendChild($node3);
        
        $node3 = document.createTextNode("jibiki REST Application Programming Interface");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Summary");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("List of available dictionaries");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "class");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("api");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("URL");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("api/");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("api/");
        $elem6.appendChild($node7);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Method");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("GET");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Returns");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("200 OK & XML (list of dictionaries metadata)");
        $elem5.appendChild($node6);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Description of a dictionary");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "class");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("api");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("URL");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("api/[dictionary]/");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Method");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("GET");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "rowspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Returns");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("200 OK & XML (dictionary metadata)");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("404 Not Found");
        $elem5.appendChild($node6);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Description of a volume");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "class");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("api");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("URL");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("api/[dictionary]/[lang]/");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Method");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("GET");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "rowspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Returns");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("200 OK & XML (volume metadata)");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("404 Not Found");
        $elem5.appendChild($node6);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Requesting an entry");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "class");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("api");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("URL");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("api/[dictionary]/[lang]/[contributionId]");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Method");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("GET");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "rowspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Returns");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("200 OK & XML (entry)");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("404 Not Found");
        $elem5.appendChild($node6);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Example of query: ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("api/FeM/fra/fra.abandonner.8814938.c");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("api/FeM/fra/fra.abandonner.8814938.c");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Answer:");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "pre");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<volume name=\"FeM_fra\" source-language=\"fra\" target-languages=\"eng msa\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\" http://www-clips.imag.fr/geta/services/dml/fem.xsd\">\n<d:contribution \n\td:contribid=\"fra.abandonner.8814938.c\" \n\td:originalcontribid=\"\" \n\txmlns:d=\"http://www-clips.imag.fr/geta/services/dml\" \n\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n\txsi:schemaLocation=\"http://www-clips.imag.fr/geta/services/dml  \n\thttp://www-clips.imag.fr/geta/services/dml/dml.xsd\">\n\t<d:metadata>\n\t\t<d:author>automatic</d:author><\n\t\t<d:creation-date>2009/05/07 13:59:57</d:creation-date>\n\t...\t\n\t<d:data>\n\t\t<entry id=\"fra.abandonner.8814938.e\">\n\t\t\t<headword>abandonner</headword><hom/>\n\t\t\t<prnc>aban-done-</prnc>\n\t\t\t<aux/>\n\t\t\t<body>\n\t\t\t\t<sense-list>\n\t\t\t\t\t<sense>\n\t\t\t\t\t<pos-list>v.tr.</pos-list>\n\t\t\t\t\t...\n\t</d:data>\n</d:contribution>\n</volume>\n");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Modifying an entry");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        buildSubDocument_0_0(document, $elem1);
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Note: the user has to be logged and in the specialist group.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Creating an entry");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "class");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("api");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("URL");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("api/[dictionary]/[lang]/[contributionId]");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Method");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("POST");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "rowspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Querystring");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("login=");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("login");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("password=");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("password");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "rowspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Returns");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("201 Created & XML (entry)");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("401 Unauthorized");
        $elem5.appendChild($node6);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Note: the user has to be logged and in the validator group.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Deleting an entry");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "class");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("api");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("URL");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("api/[dictionary]/[lang]/[contributionId]");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Method");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("DELETE");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "rowspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Querystring");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("login=");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("login");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("password=");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("password");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "rowspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("3");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Returns");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("204 No Content & XML (entry)");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("401 Unauthorized");
        $elem5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "colspan");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("404 Not Found");
        $elem5.appendChild($node6);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Note: the user has to be logged and in the admin group.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Querying entries");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        buildSubDocument_0_1(document, $elem1);
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("The searches with the [key] part give the value of the key for the corresponding entries.\nFor example, searching an entry with ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "i");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("api/*/eng/cdm-headword/trial/cdm-pos");
        $elem3.appendChild($node4);
        
        $node3 = document.createTextNode(" will give a list of \nparts-of-speech for the \"trial\" entry.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("It is possible to query all the dictionaries by putting a ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("*");
        $elem3.appendChild($node4);
        
        $node3 = document.createTextNode(" instead of the name of the dictionary.\nIt is also possible to do the same for the [lang] and [key] part of the URL.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("The ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("handle");
        $elem3.appendChild($node4);
        
        $node3 = document.createTextNode(" criteria is special as it does not give a list of entry handles but the full entry XML\n content.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Example of query: ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("api/FeM/fra/cdm-headword/abandonner");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("api/FeM/fra/cdm-headword/abandonner");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Answer:");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "pre");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<entry-list xmlns=\"http://www-clips.imag.fr/geta/services/dml\">\n\t<entry dictionary=\"FeM\" lang=\"fra\">\n\t\t<criteria value='cdm-headword'>abandonner</criteria>\n\t\t<handle>8814938</handle>\n\t</entry>\n</entry-list>\n");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Example of query: ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("api/FeM/fra/cdm-headword/abandonner/cdm-pos");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("api/FeM/fra/cdm-headword/abandonner/cdm-pos");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Answer:");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "pre");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<entry-list xmlns=\"http://www-clips.imag.fr/geta/services/dml\">\n\t<entry dictionary=\"FeM\" lang=\"fra\">\n\t\t<criteria value='cdm-headword'>abandonner</criteria>\n\t\t<handle>8814938</handle>\n\t\t<key value='cdm-pos'>v.t.</key>\n\t</entry>\n</entry-list>\n");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Example of query: ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("api/FeM/fra/handle/8814938");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("api/FeM/fra/handle/8814938");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Answer:");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "pre");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<volume name=\"FeM_fra\" source-language=\"fra\" target-languages=\"eng msa\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\" http://www-clips.imag.fr/geta/services/dml/fem.xsd\">\n<d:contribution \n\td:contribid=\"fra.abandonner.8814938.c\" \n\td:originalcontribid=\"\" \n\txmlns:d=\"http://www-clips.imag.fr/geta/services/dml\" \n\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n\txsi:schemaLocation=\"http://www-clips.imag.fr/geta/services/dml  \n\thttp://www-clips.imag.fr/geta/services/dml/dml.xsd\">\n\t<d:metadata>\n\t\t<d:author>automatic</d:author><\n\t\t<d:creation-date>2009/05/07 13:59:57</d:creation-date>\n\t...\t\n\t<d:data>\n\t\t<entry id=\"fra.abandonner.8814938.e\">\n\t\t\t<headword>abandonner</headword><hom/>\n\t\t\t<prnc>aban-done-</prnc>\n\t\t\t<aux/>\n\t\t\t<body>\n\t\t\t\t<sense-list>\n\t\t\t\t\t<sense>\n\t\t\t\t\t<pos-list>v.tr.</pos-list>\n\t\t\t\t\t...\n\t</d:data>\n</d:contribution>\n</volume>\n");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Criteria and key are one of the following:");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        buildSubDocument_0_2(document, $elem1);
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Note: the criteria and key depend on the resource. A criteria or a key might not be available for one specific resource.\nOther criteria and keys not in the list may exist only for one specific resource.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("cdm stands for Common dictionary Markup");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Strategy is one of the following:");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        buildSubDocument_0_3(document, $elem1);
        $node2 = document.createTextNode("\n\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("All the answers are in XML and encoded in UTF-8.");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "em");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("lang");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" is the ISO 639-2/T 3 letter code of the language (eg: 'eng' for English,'esp' for Spanish,'fra' for French, etc.)");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("All parameters are case sensitive (dictionary, contributionId, string, etc.)");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n \n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Misc");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("If you need more help, send an email to\n");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("mailto:mathieu.mangeotATimag.fr?subject=jibikiServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Mathieu Mangeot-Nagata");
        $elem3.appendChild($node4);
        
        $node3 = document.createTextNode(".");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode("\n");
        $elem1.appendChild($node2);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_0(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4;
        Element $elem0, $elem1, $elem2, $elem3;
        Attr $attr0, $attr1, $attr2, $attr3;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "class");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("api");
        $attr0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("URL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("api/[dictionary]/[lang]/[contributionId]");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Method");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("PUT");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "rowspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Querystring");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("login=");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("login");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("password=");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("password");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "rowspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("3");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Returns");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("201 Created & XML (entry)");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("401 Unauthorized");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("404 Not Found");
        $elem3.appendChild($node4);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_1(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4;
        Element $elem0, $elem1, $elem2, $elem3;
        Attr $attr0, $attr1, $attr2, $attr3;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "class");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("api");
        $attr0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("URL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("api/[dictionary]/[lang]/[criteria]/[string]");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("URL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("api/[dictionary]/[lang]/[criteria]/[string]/[key]");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Method");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("GET");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "rowspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("3");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Querystring");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("strategy=");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("strategy");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("count=");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("count");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("startIndex=");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("startIndex");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "rowspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Returns");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("200 OK & XML (entry)");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("404 Not Found");
        $elem3.appendChild($node4);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_2(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4;
        Element $elem0, $elem1, $elem2, $elem3;
        Attr $attr0;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "class");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("api");
        $attr0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("handle");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("unique entry handle specific to the server database");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("previous");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("previous entry before the headword");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("next");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("previous entry after the headword");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-entry-id");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry id");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-headword");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry headword");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-headword-variant");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry headword variant");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-reading");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry headword reading (ex: japanese kana)");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-writing");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry headword transcription (ex: pinyin for Chinese)");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-pronunciation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry headword pronunciation (Usually in IPA but it depends on the resource)");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-pos");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry part-of-speech (can be \"n\", \"noun\", etc. It depends on the resource)");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-translation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry headword translation in another language");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-example");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry examples");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-idiom");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("entry idioms");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-contribution-id");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("contribution id");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-contribution-author");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("contribution author");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-contribution-creation-date");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("contribution creation date");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-contribution-finition-date");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("contribution finition date");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("cdm-contribution-status");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("contribution status");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("pivax");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("UNL translations of a word via axemes and axies");
        $elem3.appendChild($node4);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_3(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4;
        Element $elem0, $elem1, $elem2, $elem3;
        Attr $attr0;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "class");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("api");
        $attr0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("EQUAL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("CASE_SENSITIVE_STARTS_WITH");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("CASE_SENSITIVE_ENDS_WITH");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("sequential search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("CASE_SENSITIVE_CONTAINS");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("sequential search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("CASE_INSENSITIVE_EQUAL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("CASE_INSENSITIVE_STARTS_WITH");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("CASE_INSENSITIVE_ENDS_WITH");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("sequential search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("CASE_INSENSITIVE_CONTAINS");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("sequential search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("NOT_EQUAL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("GREATER_THAN");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("GREATER_THAN_OR_EQUAL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("LESS_THAN");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("LESS_THAN_OR_EQUAL");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("indexed search");
        $elem3.appendChild($node4);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ApiContentXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ApiContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementApiContent() {
        return $element_ApiContent;
    }

    /**
     * Get the element with id <CODE>ApiContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagApiContent() {
        return $element_ApiContent;
    }

    /**
     * Get the value of text child of element <CODE>ApiContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextApiContent(String text) {
        doSetText($element_ApiContent, text);
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
