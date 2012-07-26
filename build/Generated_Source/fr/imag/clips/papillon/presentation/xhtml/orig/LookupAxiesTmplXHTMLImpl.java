/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/LookupAxiesTmpl.xhtml
 */
public class LookupAxiesTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements LookupAxiesTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_AxieId;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_ContribList;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryListRow;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Lexies;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_SemCat;

    private org.enhydra.xml.xhtml.dom.XHTMLBElement $element_Source;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SourceOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewXmlAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Xml;

    /**
     * Element name constant for ENTRYID
     */
    public static final String NAME_ENTRYID = "ENTRYID";

    /**
     * Element name constant for HEADWORD
     */
    public static final String NAME_HEADWORD = "HEADWORD";

    /**
     * Element name constant for LookupAxie
     */
    public static final String NAME_LookupAxie = "LookupAxie";

    /**
     * Element name constant for LookupLexie
     */
    public static final String NAME_LookupLexie = "LookupLexie";

    /**
     * Element name constant for SOURCE
     */
    public static final String NAME_SOURCE = "SOURCE";

    /**
     * Element name constant for Strategy
     */
    public static final String NAME_Strategy = "Strategy";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = LookupAxiesTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/LookupAxiesTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public LookupAxiesTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public LookupAxiesTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public LookupAxiesTmplXHTMLImpl(LookupAxiesTmplXHTMLImpl src) {
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
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Formulaire");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\t\t\t\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Lookup axies");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" formulaire de voir mot");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t\t\t\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LookupAxies.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("get");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("10");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellspacing");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Form");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t\t\t\t\t\t\t\t\t\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "border");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("0");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "cellpadding");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("0");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "cellspacing");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("5");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "summary");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("form");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem10.appendChild($elem11);
        
        $node12 = document.createTextNode("Looking for an axie by id");
        $elem11.appendChild($node12);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem10.appendChild($elem11);
        
        $node12 = document.createTextNode("or linking a specific lexie headword");
        $elem11.appendChild($node12);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("Source");
        $attr11.appendChild($node12);
        
        $element_Source = (org.enhydra.xml.xhtml.dom.XHTMLBElement)$elem11;$node12 = document.createTextNode("Source Language:");
        $elem11.appendChild($node12);
        
        $node11 = document.createTextNode("             ");
        $elem10.appendChild($node11);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("SOURCE");
        $attr11.appendChild($node12);
        
        $elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "id");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("SourceOptionTemplate");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "label");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("NONE");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "value");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("NONE");
        $attr12.appendChild($node13);
        
        $element_SourceOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem12;$node13 = document.createTextNode("NONE");
        $elem12.appendChild($node13);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem10.appendChild($elem11);
        
        $node11 = document.createTextNode("\n\t\t\t\t\t\t\t\t\t\t\t\t\t");
        $elem10.appendChild($node11);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem10.appendChild($elem11);
        
        $node12 = document.createTextNode("Axie ID:");
        $elem11.appendChild($node12);
        
        $node12 = document.createEntityReference("nbsp");
        $elem11.appendChild($node12);
        
        $node13 = document.createTextNode("\u00a0");
        $node12.appendChild($node13);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("ENTRYID");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "size");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("25");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "type");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("text");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "value");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("");
        $attr11.appendChild($node12);
        
        $node11 = document.createEntityReference("nbsp");
        $elem10.appendChild($node11);
        
        $node12 = document.createTextNode("\u00a0");
        $node11.appendChild($node12);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("LookupAxie");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "type");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("submit");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "value");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("Lookup");
        $attr11.appendChild($node12);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem9.appendChild($elem10);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem10.appendChild($elem11);
        
        $node12 = document.createTextNode("Word:");
        $elem11.appendChild($node12);
        
        $node12 = document.createEntityReference("nbsp");
        $elem11.appendChild($node12);
        
        $node13 = document.createTextNode("\u00a0");
        $node12.appendChild($node13);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("HEADWORD");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "size");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("25");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "type");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("text");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "value");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("");
        $attr11.appendChild($node12);
        
        $node11 = document.createEntityReference("nbsp");
        $elem10.appendChild($node11);
        
        $node12 = document.createTextNode("\u00a0");
        $node11.appendChild($node12);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("LookupLexie");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "type");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("submit");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "value");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("Lookup");
        $attr11.appendChild($node12);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem10.appendChild($elem11);
        
        $node11 = document.createTextNode("\n\t                                                Partial match: ");
        $elem10.appendChild($node11);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "name");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("Strategy");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "type");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("checkbox");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "value");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("on");
        $attr11.appendChild($node12);
        
        $node8 = document.createTextNode("\n\t\t\t\t\t\t\t\t\t\t");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("View the axies");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t\t\t\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "border");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("0");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "frame");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hsides");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ContribList");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("entries");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_ContribList = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Axie ID");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Sem. Cat");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Lexie ids");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("View XML");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EntryListRow");
        $attr5.appendChild($node6);
        
        $element_EntryListRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("AxieId");
        $attr7.appendChild($node8);
        
        $element_AxieId = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("ID");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SemCat");
        $attr7.appendChild($node8);
        
        $element_SemCat = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("SemCat");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Lexies");
        $attr7.appendChild($node8);
        
        $element_Lexies = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Lexies");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ViewXmlAnchor");
        $attr7.appendChild($node8);
        
        $element_ViewXmlAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("XML");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n\t\t\t\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Xml");
        $attr4.appendChild($node5);
        
        $element_Xml = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new LookupAxiesTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>AxieId</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementAxieId() {
        return $element_AxieId;
    }

    /**
     * Get the element with id <CODE>ContribList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementContribList() {
        return $element_ContribList;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Lexies</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLexies() {
        return $element_Lexies;
    }

    /**
     * Get the element with id <CODE>SemCat</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSemCat() {
        return $element_SemCat;
    }

    /**
     * Get the element with id <CODE>Source</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLBElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLBElement getElementSource() {
        return $element_Source;
    }

    /**
     * Get the element with id <CODE>SourceOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementSourceOptionTemplate() {
        return $element_SourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementXml() {
        return $element_Xml;
    }

    /**
     * Get the element with id <CODE>AxieId</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAxieId() {
        return $element_AxieId;
    }

    /**
     * Get the element with id <CODE>ContribList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContribList() {
        return $element_ContribList;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Lexies</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLexies() {
        return $element_Lexies;
    }

    /**
     * Get the element with id <CODE>SemCat</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSemCat() {
        return $element_SemCat;
    }

    /**
     * Get the element with id <CODE>Source</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSource() {
        return $element_Source;
    }

    /**
     * Get the element with id <CODE>SourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSourceOptionTemplate() {
        return $element_SourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXml() {
        return $element_Xml;
    }

    /**
     * Get the value of text child of element <CODE>AxieId</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAxieId(String text) {
        doSetText($element_AxieId, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>Lexies</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLexies(String text) {
        doSetText($element_Lexies, text);
    }

    /**
     * Get the value of text child of element <CODE>SemCat</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSemCat(String text) {
        doSetText($element_SemCat, text);
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
     * Get the value of text child of element <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewXmlAnchor(String text) {
        doSetText($element_ViewXmlAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Xml</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextXml(String text) {
        doSetText($element_Xml, text);
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
