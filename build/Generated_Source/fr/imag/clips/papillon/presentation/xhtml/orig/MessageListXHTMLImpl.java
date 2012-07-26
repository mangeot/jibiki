/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/MessageList.xhtml
 */
public class MessageListXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements MessageListXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Author;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_AuthorContains;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_AuthorInput;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ButtonNext;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ButtonPrevious;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_CurrentLimit;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_CurrentOffset;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Date;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Discussion;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_MessageContains;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_MessageRange;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SortByAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SortByDate;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SortBySubject;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Subject;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SubjectAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_SubjectContains;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ThreadAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Threads;

    /**
     * Class attribute constant for element class cellRow
     */
    public static final String CLASS_cellRow = "cellRow";

    /**
     * Class attribute constant for element class headerRow
     */
    public static final String CLASS_headerRow = "headerRow";

    /**
     * Element name constant for authorcontains
     */
    public static final String NAME_authorcontains = "authorcontains";

    /**
     * Element name constant for limit
     */
    public static final String NAME_limit = "limit";

    /**
     * Element name constant for messagecontains
     */
    public static final String NAME_messagecontains = "messagecontains";

    /**
     * Element name constant for next
     */
    public static final String NAME_next = "next";

    /**
     * Element name constant for offset
     */
    public static final String NAME_offset = "offset";

    /**
     * Element name constant for previous
     */
    public static final String NAME_previous = "previous";

    /**
     * Element name constant for sort
     */
    public static final String NAME_sort = "sort";

    /**
     * Element name constant for subjectcontains
     */
    public static final String NAME_subjectcontains = "subjectcontains";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = MessageListXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/MessageList.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public MessageListXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public MessageListXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public MessageListXHTMLImpl(MessageListXHTMLImpl src) {
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
        
        $attr1 = document.createAttributeNS("", "lang");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("en-US");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("en-US");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("http://www.w3.org/1999/xhtml");
        $attr1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "head");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Papillon's mailing list");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Discussion");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_Discussion = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("MailingList.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("post");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("CurrentLimit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("limit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_CurrentLimit = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("CurrentOffset");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("offset");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_CurrentOffset = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "border");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("1");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("bordercolor:white; bgcolor:#eeeecc");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "summary");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Search form");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("100%");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "colspan");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("3");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Find messages where...");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("bgcolor:#4682b4; font-color:#ffffff");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Sender contains:");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("bgcolor:#4682b4; font-color:#ffffff");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Subject contains:");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("bgcolor:#4682b4; font-color:#ffffff");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Message contains:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("AuthorContains");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("authorcontains");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "size");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("23");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("text");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $element_AuthorContains = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("SubjectContains");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("subjectcontains");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "size");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("23");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("text");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $element_SubjectContains = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("MessageContains");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("messagecontains");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "size");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("23");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("text");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $element_MessageContains = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Sort by:");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("\n");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("sort");
        $attr9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SortByDate");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("date");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("date");
        $attr10.appendChild($node11);
        
        $element_SortByDate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("date");
        $elem10.appendChild($node11);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SortByAuthor");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("author");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("author");
        $attr10.appendChild($node11);
        
        $element_SortByAuthor = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("sender");
        $elem10.appendChild($node11);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SortBySubject");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("subject");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("subject");
        $attr10.appendChild($node11);
        
        $element_SortBySubject = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("subject");
        $elem10.appendChild($node11);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "colspan");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("2");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("submit");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Go");
        $attr9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "summary");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("100%");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "align");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("left");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\nClic on the ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "alt");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("@");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "height");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("15");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "src");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("media/arobas.png");
        $attr9.appendChild($node10);
        
        $node9 = document.createTextNode(" button to see the sender's address.\n");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "align");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("right");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "alt");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("previous messages");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("ButtonPrevious");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("previous");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "src");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("media/previous.gif");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "style");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("height:15; valign:middle");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("image");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("previous");
        $attr9.appendChild($node10);
        
        $element_ButtonPrevious = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("messageRange");
        $attr9.appendChild($node10);
        
        $element_MessageRange = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("0-0");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "alt");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("next messages");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("ButtonNext");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("next");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "src");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("media/next.gif");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "style");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("height:15; valign:middle");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("image");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("next");
        $attr9.appendChild($node10);
        
        $element_ButtonNext = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n      ");
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
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("bordercolor:white");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("messages");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("headerRow");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("height:35");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Date");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "colspan");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("2");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Sender");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Suject");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Answers");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cellRow");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("TemplateRow");
        $attr5.appendChild($node6);
        
        $element_TemplateRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Date");
        $attr7.appendChild($node8);
        
        $element_Date = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("date");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Author");
        $attr7.appendChild($node8);
        
        $element_Author = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Author");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "action");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "method");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("post");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("AuthorInput");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "onclick");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("alert( this.name + '@' + this.value);return false;");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "src");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("media/arobas.png");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("image");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $element_AuthorInput = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SubjectAnchor");
        $attr7.appendChild($node8);
        
        $element_SubjectAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Subject");
        $attr8.appendChild($node9);
        
        $element_Subject = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Subject");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ThreadAnchor");
        $attr7.appendChild($node8);
        
        $element_ThreadAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Threads");
        $attr8.appendChild($node9);
        
        $element_Threads = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("0");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n\n    ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new MessageListXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>Author</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementAuthor() {
        return $element_Author;
    }

    /**
     * Get the element with id <CODE>AuthorContains</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAuthorContains() {
        return $element_AuthorContains;
    }

    /**
     * Get the element with id <CODE>AuthorInput</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAuthorInput() {
        return $element_AuthorInput;
    }

    /**
     * Get the element with id <CODE>ButtonNext</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementButtonNext() {
        return $element_ButtonNext;
    }

    /**
     * Get the element with id <CODE>ButtonPrevious</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementButtonPrevious() {
        return $element_ButtonPrevious;
    }

    /**
     * Get the element with id <CODE>CurrentLimit</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementCurrentLimit() {
        return $element_CurrentLimit;
    }

    /**
     * Get the element with id <CODE>CurrentOffset</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementCurrentOffset() {
        return $element_CurrentOffset;
    }

    /**
     * Get the element with id <CODE>Date</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDate() {
        return $element_Date;
    }

    /**
     * Get the element with id <CODE>Discussion</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementDiscussion() {
        return $element_Discussion;
    }

    /**
     * Get the element with id <CODE>MessageContains</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementMessageContains() {
        return $element_MessageContains;
    }

    /**
     * Get the element with id <CODE>messageRange</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementMessageRange() {
        return $element_MessageRange;
    }

    /**
     * Get the element with id <CODE>SortByAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementSortByAuthor() {
        return $element_SortByAuthor;
    }

    /**
     * Get the element with id <CODE>SortByDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementSortByDate() {
        return $element_SortByDate;
    }

    /**
     * Get the element with id <CODE>SortBySubject</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementSortBySubject() {
        return $element_SortBySubject;
    }

    /**
     * Get the element with id <CODE>Subject</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSubject() {
        return $element_Subject;
    }

    /**
     * Get the element with id <CODE>SubjectAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSubjectAnchor() {
        return $element_SubjectAnchor;
    }

    /**
     * Get the element with id <CODE>SubjectContains</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSubjectContains() {
        return $element_SubjectContains;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>ThreadAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementThreadAnchor() {
        return $element_ThreadAnchor;
    }

    /**
     * Get the element with id <CODE>Threads</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementThreads() {
        return $element_Threads;
    }

    /**
     * Get the element with id <CODE>Author</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthor() {
        return $element_Author;
    }

    /**
     * Get the element with id <CODE>AuthorContains</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthorContains() {
        return $element_AuthorContains;
    }

    /**
     * Get the element with id <CODE>AuthorInput</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthorInput() {
        return $element_AuthorInput;
    }

    /**
     * Get the element with id <CODE>ButtonNext</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagButtonNext() {
        return $element_ButtonNext;
    }

    /**
     * Get the element with id <CODE>ButtonPrevious</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagButtonPrevious() {
        return $element_ButtonPrevious;
    }

    /**
     * Get the element with id <CODE>CurrentLimit</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCurrentLimit() {
        return $element_CurrentLimit;
    }

    /**
     * Get the element with id <CODE>CurrentOffset</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCurrentOffset() {
        return $element_CurrentOffset;
    }

    /**
     * Get the element with id <CODE>Date</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDate() {
        return $element_Date;
    }

    /**
     * Get the element with id <CODE>Discussion</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDiscussion() {
        return $element_Discussion;
    }

    /**
     * Get the element with id <CODE>MessageContains</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMessageContains() {
        return $element_MessageContains;
    }

    /**
     * Get the element with id <CODE>messageRange</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMessageRange() {
        return $element_MessageRange;
    }

    /**
     * Get the element with id <CODE>SortByAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSortByAuthor() {
        return $element_SortByAuthor;
    }

    /**
     * Get the element with id <CODE>SortByDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSortByDate() {
        return $element_SortByDate;
    }

    /**
     * Get the element with id <CODE>SortBySubject</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSortBySubject() {
        return $element_SortBySubject;
    }

    /**
     * Get the element with id <CODE>Subject</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSubject() {
        return $element_Subject;
    }

    /**
     * Get the element with id <CODE>SubjectAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSubjectAnchor() {
        return $element_SubjectAnchor;
    }

    /**
     * Get the element with id <CODE>SubjectContains</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSubjectContains() {
        return $element_SubjectContains;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>ThreadAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagThreadAnchor() {
        return $element_ThreadAnchor;
    }

    /**
     * Get the element with id <CODE>Threads</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagThreads() {
        return $element_Threads;
    }

    /**
     * Get the value of text child of element <CODE>Author</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAuthor(String text) {
        doSetText($element_Author, text);
    }

    /**
     * Get the value of text child of element <CODE>Date</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDate(String text) {
        doSetText($element_Date, text);
    }

    /**
     * Get the value of text child of element <CODE>Discussion</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDiscussion(String text) {
        doSetText($element_Discussion, text);
    }

    /**
     * Get the value of text child of element <CODE>messageRange</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMessageRange(String text) {
        doSetText($element_MessageRange, text);
    }

    /**
     * Get the value of text child of element <CODE>SortByAuthor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSortByAuthor(String text) {
        doSetText($element_SortByAuthor, text);
    }

    /**
     * Get the value of text child of element <CODE>SortByDate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSortByDate(String text) {
        doSetText($element_SortByDate, text);
    }

    /**
     * Get the value of text child of element <CODE>SortBySubject</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSortBySubject(String text) {
        doSetText($element_SortBySubject, text);
    }

    /**
     * Get the value of text child of element <CODE>Subject</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSubject(String text) {
        doSetText($element_Subject, text);
    }

    /**
     * Get the value of text child of element <CODE>SubjectAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSubjectAnchor(String text) {
        doSetText($element_SubjectAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ThreadAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextThreadAnchor(String text) {
        doSetText($element_ThreadAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Threads</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextThreads(String text) {
        doSetText($element_Threads, text);
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
