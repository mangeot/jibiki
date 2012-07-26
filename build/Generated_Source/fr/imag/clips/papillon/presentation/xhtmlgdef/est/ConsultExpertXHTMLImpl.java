/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlgdef.est;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlgdef/est/ConsultExpert.xhtml
 */
public class ConsultExpertXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ConsultExpertXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.ConsultExpertXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_AuthorList;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ConsultContent;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_ConsultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DeleteButton;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_DeleteHref;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DictionaryName;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_EntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLParagraphElement $element_EntryDiv;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryIdList;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryListRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_EntryListTable;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryNumber;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_FoksEntries;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_FoksEntry;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_FoksGrade;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_FoksHref;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_FoksRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_FoksWriting;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Formula;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_FormulaRow;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LOOKUP;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_NextEntriesAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_PosEntry;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_PreviousEntriesAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_RESET;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ResourceName;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_ResourceOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Resources;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ReverseLookupMessage;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_SOURCE;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search1;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search1text;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search2;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search2text;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_SorryMessage;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_SourceOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy1;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy2;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_StylesheetCell;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_StylesheetRow;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_TargetOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Targets;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Vocable;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_VolumeEntries;

    /**
     * Class attribute constant for element class bodylink
     */
    public static final String CLASS_bodylink = "bodylink";

    /**
     * Class attribute constant for element class copyright
     */
    public static final String CLASS_copyright = "copyright";

    /**
     * Class attribute constant for element class hidden
     */
    public static final String CLASS_hidden = "hidden";

    /**
     * Class attribute constant for element class result
     */
    public static final String CLASS_result = "result";

    /**
     * Element name constant for LOOKUP
     */
    public static final String NAME_LOOKUP = "LOOKUP";

    /**
     * Element name constant for RESET
     */
    public static final String NAME_RESET = "RESET";

    /**
     * Element name constant for RESOURCES
     */
    public static final String NAME_RESOURCES = "RESOURCES";

    /**
     * Element name constant for SOURCE
     */
    public static final String NAME_SOURCE = "SOURCE";

    /**
     * Element name constant for Strategy1
     */
    public static final String NAME_Strategy1 = "Strategy1";

    /**
     * Element name constant for Strategy2
     */
    public static final String NAME_Strategy2 = "Strategy2";

    /**
     * Element name constant for TARGETS
     */
    public static final String NAME_TARGETS = "TARGETS";

    /**
     * Element name constant for search1
     */
    public static final String NAME_search1 = "search1";

    /**
     * Element name constant for search1text
     */
    public static final String NAME_search1text = "search1text";

    /**
     * Element name constant for search2
     */
    public static final String NAME_search2 = "search2";

    /**
     * Element name constant for search2text
     */
    public static final String NAME_search2text = "search2text";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ConsultExpertXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlgdef/est/ConsultExpert.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ConsultExpertXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ConsultExpertXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ConsultExpertXHTMLImpl(ConsultExpertXHTMLImpl src) {
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
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Consultation of Papillon Lexical Database");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("ConsultContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("et");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("et");
        $attr3.appendChild($node4);
        
        $element_ConsultContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        buildSubDocument_0(document, $elem3);
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SorryMessage");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("align:center;");
        $attr4.appendChild($node5);
        
        $element_SorryMessage = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("Sellist m\u00e4rks\u00f5na s\u00f5nastikus kahjuks veel ei ole.");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ConsultEdit.po?STEP=1&InitType=create");
        $attr5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\t  ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hidden");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ReverseLookupMessage");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("align: center");
        $attr4.appendChild($node5);
        
        $element_ReverseLookupMessage = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("align: center");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("P\u00e4ringule ei leitud t\u00e4pset vastust. Otsime sarnaseid.");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("      \n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "frame");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hsides");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("EntryListTable");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("border:0; bgcolor:#faecc9");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("entries");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_EntryListTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Leiti ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EntryNumber");
        $attr8.appendChild($node9);
        
        $element_EntryNumber = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("0");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode(" m\u00e4rks\u00f5naartiklit:");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("M\u00e4rks\u00f5na");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("ID");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Autor");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("S\u00f5naliik");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("S\u00f5nastik");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "align");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("center");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PreviousEntriesAnchor");
        $attr8.appendChild($node9);
        
        $element_PreviousEntriesAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("<< Eelmised <<");
        $elem8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "align");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("center");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NextEntriesAnchor");
        $attr8.appendChild($node9);
        
        $element_NextEntriesAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode(">> J\u00e4rgmised >>");
        $elem8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("EntryListRow");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("bgcolor:#eeeecc");
        $attr6.appendChild($node7);
        
        $element_EntryListRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$node7 = document.createComment(" resultItemStart ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("bodylink");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "href");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("EntryAnchor");
        $attr9.appendChild($node10);
        
        $element_EntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem9;$node10 = document.createTextNode("\n                  ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("Vocable");
        $attr10.appendChild($node11);
        
        $element_Vocable = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("Vocable");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("\n                ");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EntryIdList");
        $attr8.appendChild($node9);
        
        $element_EntryIdList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Vocable");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n                ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AuthorList");
        $attr8.appendChild($node9);
        
        $element_AuthorList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Author");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PosEntry");
        $attr8.appendChild($node9);
        
        $element_PosEntry = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("pos");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DictionaryName");
        $attr8.appendChild($node9);
        
        $element_DictionaryName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("S\u00f5nastik");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $node7 = document.createComment(" resultItemEnd ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("FormulaRow");
        $attr6.appendChild($node7);
        
        $element_FormulaRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Formula");
        $attr8.appendChild($node9);
        
        $element_Formula = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Valem");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("1");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellspacing");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("1");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("result");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("FoksEntries");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("align:center;bgcolor:e6e6fa;");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Foks Entries");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("90%");
        $attr5.appendChild($node6);
        
        $element_FoksEntries = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Kirje");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Kirjapilt");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Grade");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Link");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "align");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("right");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "colspan");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("4");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem8.appendChild($elem9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "class");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("copyright");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("\u00a9 2002-2003 ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "href");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("mailto:sbilacATcl.cs.titech.ac.jp?subject=PapillonServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr10.appendChild($node11);
        
        $node11 = document.createTextNode("Slaven Bilac");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode(",  Tokyo Institute of Technology. All rights reserved.");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("FoksRow");
        $attr7.appendChild($node8);
        
        $element_FoksRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "align");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("center");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("nowrap:nowrap");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("FoksEntry");
        $attr9.appendChild($node10);
        
        $element_FoksEntry = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("Kirje");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "align");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("center");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("nowrap:nowrap");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("FoksWriting");
        $attr9.appendChild($node10);
        
        $element_FoksWriting = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("Kirjapilt");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "align");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("center");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("nowrap:nowrap");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("FoksGrade");
        $attr9.appendChild($node10);
        
        $element_FoksGrade = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("Grade");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "align");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("center");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("result");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("nowrap:nowrap");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "href");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("EditLexie.po");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("FoksHref");
        $attr9.appendChild($node10);
        
        $element_FoksHref = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem9;$node10 = document.createTextNode("T\u00f5lge");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n      ");
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
        $node5 = document.createTextNode("VolumeEntries");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("bordercolor:white");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("dicocontent");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_VolumeEntries = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("StylesheetRow");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("bgcolor:#eeeecc");
        $attr5.appendChild($node6);
        
        $element_StylesheetRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("StylesheetCell");
        $attr6.appendChild($node7);
        
        $element_StylesheetCell = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EntryRow");
        $attr5.appendChild($node6);
        
        $element_EntryRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "valign");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("top");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align:right");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n\t\t\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DeleteButton");
        $attr8.appendChild($node9);
        
        $element_DeleteButton = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "href");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("ReviewContributions.po");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("DeleteHref");
        $attr9.appendChild($node10);
        
        $element_DeleteHref = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem9;$node10 = document.createTextNode("Delete");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("resourceName");
        $attr9.appendChild($node10);
        
        $element_ResourceName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("resource");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("EntryDiv");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align:justify");
        $attr7.appendChild($node8);
        
        $element_EntryDiv = (org.enhydra.xml.xhtml.dom.XHTMLParagraphElement)$elem7;$node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align:right");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("#_top");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "alt");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("top");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "height");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("16");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "src");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("media/top.gif");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "width");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("16");
        $attr9.appendChild($node10);
        
        $node9 = document.createTextNode("\n              ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem6.appendChild($elem7);
        
        $node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "action");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("ConsultExpert.po");
        $attr0.appendChild($node1);
        
        $attr0 = document.createAttributeNS("", "id");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("ConsultForm");
        $attr0.appendChild($node1);
        
        $element_ConsultForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem0;$elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "style");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("border:1; bordercolor:white; bgcolor:#eeeecc;");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "summary");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("Search form");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "width");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("100%");
        $attr1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "for");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("SOURCE");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("L\u00e4htekeel:");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SOURCE");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SOURCE");
        $attr4.appendChild($node5);
        
        $element_SOURCE = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("SourceOptionTemplate");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $element_SourceOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem5;$node6 = document.createTextNode("NONE");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "valign");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("middle");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n                ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "for");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Targets");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Sihtkeel:");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n              ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Targets");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "multiple");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("multiple");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("TARGETS");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("3");
        $attr4.appendChild($node5);
        
        $element_Targets = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ANY");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("*ANY*");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("k\u00f5ik");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("TargetOptionTemplate");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $element_TargetOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem5;$node6 = document.createTextNode("NONE");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "valign");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("middle");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n                ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "for");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Resources");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("S\u00f5nastik:");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n              ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Resources");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "multiple");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("multiple");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("RESOURCES");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("3");
        $attr4.appendChild($node5);
        
        $element_Resources = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ANY");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("*ANY*");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("k\u00f5ik");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ResourceOptionTemplate");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $element_ResourceOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem5;$node6 = document.createTextNode("NONE");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "style");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("bgcolor:#4682b4;");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Strategy1");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Strategy1");
        $attr4.appendChild($node5);
        
        $element_Strategy1 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00e4pne otsing");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00e4pne otsing");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("prefiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("1");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("prefiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("sufiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("sufiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("m\u00e4rgijada");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("3");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("m\u00e4rgijada");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("4");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu prefiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("5");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu prefiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu sufiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("6");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu sufiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu m\u00e4rgijada");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("7");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu m\u00e4rgijada");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search1");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search1");
        $attr4.appendChild($node5);
        
        $element_Search1 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("M\u00e4rks\u00f5na");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-headword");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("M\u00e4rks\u00f5na");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("S\u00f5naliik");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-pos");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("S\u00f5naliik");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Valdkond");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-domaine");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Valdkond");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("T\u00f5lkevaste id");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-translation-ref");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("T\u00f5lkevaste id");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("N\u00e4ide");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-example");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("N\u00e4ide");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("N\u00e4ite t\u00f5lge");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-traduction-exemple");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("N\u00e4ite t\u00f5lge");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Fraseologism");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-locution");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Fraseologism");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Fraseologismi t\u00f5lge");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-traduction-locution");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Fraseologismi t\u00f5lge");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Mistahes osa");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AnyContains");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Mistahes osa");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "for");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search1text");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("sisaldab");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search1text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search1text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("15");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_Search1text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("\n              ja\n\t\t\t");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "style");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("bgcolor:#4682b4;");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Strategy2");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Strategy2");
        $attr4.appendChild($node5);
        
        $element_Strategy2 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00e4pne otsing");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00e4pne otsing");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("prefiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("1");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("prefiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("sufiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("sufiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("m\u00e4rgijada");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("3");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("m\u00e4rgijada");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("4");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu prefiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("5");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu prefiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu sufiks");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("6");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu sufiks");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("t\u00f5stutundetu m\u00e4rgijada");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("7");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("t\u00f5stutundetu m\u00e4rgijada");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search2");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search2");
        $attr4.appendChild($node5);
        
        $element_Search2 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("M\u00e4rks\u00f5na");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-headword");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("M\u00e4rks\u00f5na");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("S\u00f5naliik");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-pos");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("S\u00f5naliik");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Valdkond");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-domaine");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Valdkond");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("T\u00f5lkevaste id");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-translation-ref");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("T\u00f5lkevaste id");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("N\u00e4ide");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cdm-example");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("N\u00e4ide");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("N\u00e4ite t\u00f5lge");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-traduction-exemple");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("N\u00e4ite t\u00f5lge");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Fraseologism");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-locution");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Fraseologism");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Fraseologismi t\u00f5lge");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("gdef-est-traduction-locution");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Fraseologismi t\u00f5lge");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Mistahes osa");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AnyContains");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Mistahes osa");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "for");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search2text");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("sisaldab");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search2text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("search2text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("15");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_Search2text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "style");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("bgcolor:#4682b4;");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LOOKUP");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LOOKUP");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("submit");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Otsi");
        $attr4.appendChild($node5);
        
        $element_LOOKUP = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("RESET");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("RESET");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("submit");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Algseis");
        $attr4.appendChild($node5);
        
        $element_RESET = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ConsultExpertXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>AuthorList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementAuthorList() {
        return $element_AuthorList;
    }

    /**
     * Get the element with id <CODE>ConsultContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementConsultContent() {
        return $element_ConsultContent;
    }

    /**
     * Get the element with id <CODE>ConsultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementConsultForm() {
        return $element_ConsultForm;
    }

    /**
     * Get the element with id <CODE>DeleteButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDeleteButton() {
        return $element_DeleteButton;
    }

    /**
     * Get the element with id <CODE>DeleteHref</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementDeleteHref() {
        return $element_DeleteHref;
    }

    /**
     * Get the element with id <CODE>DictionaryName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDictionaryName() {
        return $element_DictionaryName;
    }

    /**
     * Get the element with id <CODE>EntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementEntryAnchor() {
        return $element_EntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryDiv</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLParagraphElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLParagraphElement getElementEntryDiv() {
        return $element_EntryDiv;
    }

    /**
     * Get the element with id <CODE>EntryIdList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryIdList() {
        return $element_EntryIdList;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>EntryListTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementEntryListTable() {
        return $element_EntryListTable;
    }

    /**
     * Get the element with id <CODE>EntryNumber</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryNumber() {
        return $element_EntryNumber;
    }

    /**
     * Get the element with id <CODE>EntryRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryRow() {
        return $element_EntryRow;
    }

    /**
     * Get the element with id <CODE>FoksEntries</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementFoksEntries() {
        return $element_FoksEntries;
    }

    /**
     * Get the element with id <CODE>FoksEntry</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFoksEntry() {
        return $element_FoksEntry;
    }

    /**
     * Get the element with id <CODE>FoksGrade</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFoksGrade() {
        return $element_FoksGrade;
    }

    /**
     * Get the element with id <CODE>FoksHref</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementFoksHref() {
        return $element_FoksHref;
    }

    /**
     * Get the element with id <CODE>FoksRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementFoksRow() {
        return $element_FoksRow;
    }

    /**
     * Get the element with id <CODE>FoksWriting</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFoksWriting() {
        return $element_FoksWriting;
    }

    /**
     * Get the element with id <CODE>Formula</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFormula() {
        return $element_Formula;
    }

    /**
     * Get the element with id <CODE>FormulaRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementFormulaRow() {
        return $element_FormulaRow;
    }

    /**
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>NextEntriesAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementNextEntriesAnchor() {
        return $element_NextEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>PosEntry</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementPosEntry() {
        return $element_PosEntry;
    }

    /**
     * Get the element with id <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementPreviousEntriesAnchor() {
        return $element_PreviousEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>RESET</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementRESET() {
        return $element_RESET;
    }

    /**
     * Get the element with id <CODE>resourceName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementResourceName() {
        return $element_ResourceName;
    }

    /**
     * Get the element with id <CODE>ResourceOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementResourceOptionTemplate() {
        return $element_ResourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Resources</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementResources() {
        return $element_Resources;
    }

    /**
     * Get the element with id <CODE>ReverseLookupMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementReverseLookupMessage() {
        return $element_ReverseLookupMessage;
    }

    /**
     * Get the element with id <CODE>SOURCE</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSOURCE() {
        return $element_SOURCE;
    }

    /**
     * Get the element with id <CODE>search1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSearch1() {
        return $element_Search1;
    }

    /**
     * Get the element with id <CODE>search1text</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSearch1text() {
        return $element_Search1text;
    }

    /**
     * Get the element with id <CODE>search2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSearch2() {
        return $element_Search2;
    }

    /**
     * Get the element with id <CODE>search2text</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSearch2text() {
        return $element_Search2text;
    }

    /**
     * Get the element with id <CODE>SorryMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementSorryMessage() {
        return $element_SorryMessage;
    }

    /**
     * Get the element with id <CODE>SourceOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementSourceOptionTemplate() {
        return $element_SourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Strategy1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementStrategy1() {
        return $element_Strategy1;
    }

    /**
     * Get the element with id <CODE>Strategy2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementStrategy2() {
        return $element_Strategy2;
    }

    /**
     * Get the element with id <CODE>StylesheetCell</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementStylesheetCell() {
        return $element_StylesheetCell;
    }

    /**
     * Get the element with id <CODE>StylesheetRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementStylesheetRow() {
        return $element_StylesheetRow;
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
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>Vocable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementVocable() {
        return $element_Vocable;
    }

    /**
     * Get the element with id <CODE>VolumeEntries</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementVolumeEntries() {
        return $element_VolumeEntries;
    }

    /**
     * Get the element with id <CODE>AuthorList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthorList() {
        return $element_AuthorList;
    }

    /**
     * Get the element with id <CODE>ConsultContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagConsultContent() {
        return $element_ConsultContent;
    }

    /**
     * Get the element with id <CODE>ConsultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagConsultForm() {
        return $element_ConsultForm;
    }

    /**
     * Get the element with id <CODE>DeleteButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDeleteButton() {
        return $element_DeleteButton;
    }

    /**
     * Get the element with id <CODE>DeleteHref</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDeleteHref() {
        return $element_DeleteHref;
    }

    /**
     * Get the element with id <CODE>DictionaryName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionaryName() {
        return $element_DictionaryName;
    }

    /**
     * Get the element with id <CODE>EntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryAnchor() {
        return $element_EntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryDiv</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryDiv() {
        return $element_EntryDiv;
    }

    /**
     * Get the element with id <CODE>EntryIdList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryIdList() {
        return $element_EntryIdList;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>EntryListTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListTable() {
        return $element_EntryListTable;
    }

    /**
     * Get the element with id <CODE>EntryNumber</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryNumber() {
        return $element_EntryNumber;
    }

    /**
     * Get the element with id <CODE>EntryRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryRow() {
        return $element_EntryRow;
    }

    /**
     * Get the element with id <CODE>FoksEntries</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFoksEntries() {
        return $element_FoksEntries;
    }

    /**
     * Get the element with id <CODE>FoksEntry</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFoksEntry() {
        return $element_FoksEntry;
    }

    /**
     * Get the element with id <CODE>FoksGrade</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFoksGrade() {
        return $element_FoksGrade;
    }

    /**
     * Get the element with id <CODE>FoksHref</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFoksHref() {
        return $element_FoksHref;
    }

    /**
     * Get the element with id <CODE>FoksRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFoksRow() {
        return $element_FoksRow;
    }

    /**
     * Get the element with id <CODE>FoksWriting</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFoksWriting() {
        return $element_FoksWriting;
    }

    /**
     * Get the element with id <CODE>Formula</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormula() {
        return $element_Formula;
    }

    /**
     * Get the element with id <CODE>FormulaRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaRow() {
        return $element_FormulaRow;
    }

    /**
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>NextEntriesAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNextEntriesAnchor() {
        return $element_NextEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>PosEntry</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPosEntry() {
        return $element_PosEntry;
    }

    /**
     * Get the element with id <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPreviousEntriesAnchor() {
        return $element_PreviousEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>RESET</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRESET() {
        return $element_RESET;
    }

    /**
     * Get the element with id <CODE>resourceName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResourceName() {
        return $element_ResourceName;
    }

    /**
     * Get the element with id <CODE>ResourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResourceOptionTemplate() {
        return $element_ResourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Resources</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResources() {
        return $element_Resources;
    }

    /**
     * Get the element with id <CODE>ReverseLookupMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReverseLookupMessage() {
        return $element_ReverseLookupMessage;
    }

    /**
     * Get the element with id <CODE>SOURCE</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSOURCE() {
        return $element_SOURCE;
    }

    /**
     * Get the element with id <CODE>search1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch1() {
        return $element_Search1;
    }

    /**
     * Get the element with id <CODE>search1text</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch1text() {
        return $element_Search1text;
    }

    /**
     * Get the element with id <CODE>search2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch2() {
        return $element_Search2;
    }

    /**
     * Get the element with id <CODE>search2text</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch2text() {
        return $element_Search2text;
    }

    /**
     * Get the element with id <CODE>SorryMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSorryMessage() {
        return $element_SorryMessage;
    }

    /**
     * Get the element with id <CODE>SourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSourceOptionTemplate() {
        return $element_SourceOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Strategy1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStrategy1() {
        return $element_Strategy1;
    }

    /**
     * Get the element with id <CODE>Strategy2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStrategy2() {
        return $element_Strategy2;
    }

    /**
     * Get the element with id <CODE>StylesheetCell</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStylesheetCell() {
        return $element_StylesheetCell;
    }

    /**
     * Get the element with id <CODE>StylesheetRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStylesheetRow() {
        return $element_StylesheetRow;
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
     * Get the element with id <CODE>Vocable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVocable() {
        return $element_Vocable;
    }

    /**
     * Get the element with id <CODE>VolumeEntries</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeEntries() {
        return $element_VolumeEntries;
    }

    /**
     * Get the value of text child of element <CODE>AuthorList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAuthorList(String text) {
        doSetText($element_AuthorList, text);
    }

    /**
     * Get the value of text child of element <CODE>ConsultContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextConsultContent(String text) {
        doSetText($element_ConsultContent, text);
    }

    /**
     * Get the value of text child of element <CODE>DeleteButton</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDeleteButton(String text) {
        doSetText($element_DeleteButton, text);
    }

    /**
     * Get the value of text child of element <CODE>DeleteHref</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDeleteHref(String text) {
        doSetText($element_DeleteHref, text);
    }

    /**
     * Get the value of text child of element <CODE>DictionaryName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictionaryName(String text) {
        doSetText($element_DictionaryName, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryAnchor(String text) {
        doSetText($element_EntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryDiv</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryDiv(String text) {
        doSetText($element_EntryDiv, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryIdList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryIdList(String text) {
        doSetText($element_EntryIdList, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryNumber</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryNumber(String text) {
        doSetText($element_EntryNumber, text);
    }

    /**
     * Get the value of text child of element <CODE>FoksEntry</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFoksEntry(String text) {
        doSetText($element_FoksEntry, text);
    }

    /**
     * Get the value of text child of element <CODE>FoksGrade</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFoksGrade(String text) {
        doSetText($element_FoksGrade, text);
    }

    /**
     * Get the value of text child of element <CODE>FoksHref</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFoksHref(String text) {
        doSetText($element_FoksHref, text);
    }

    /**
     * Get the value of text child of element <CODE>FoksWriting</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFoksWriting(String text) {
        doSetText($element_FoksWriting, text);
    }

    /**
     * Get the value of text child of element <CODE>Formula</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormula(String text) {
        doSetText($element_Formula, text);
    }

    /**
     * Get the value of text child of element <CODE>NextEntriesAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNextEntriesAnchor(String text) {
        doSetText($element_NextEntriesAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>PosEntry</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPosEntry(String text) {
        doSetText($element_PosEntry, text);
    }

    /**
     * Get the value of text child of element <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPreviousEntriesAnchor(String text) {
        doSetText($element_PreviousEntriesAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>resourceName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextResourceName(String text) {
        doSetText($element_ResourceName, text);
    }

    /**
     * Get the value of text child of element <CODE>ResourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextResourceOptionTemplate(String text) {
        doSetText($element_ResourceOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>ReverseLookupMessage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReverseLookupMessage(String text) {
        doSetText($element_ReverseLookupMessage, text);
    }

    /**
     * Get the value of text child of element <CODE>SorryMessage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSorryMessage(String text) {
        doSetText($element_SorryMessage, text);
    }

    /**
     * Get the value of text child of element <CODE>SourceOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSourceOptionTemplate(String text) {
        doSetText($element_SourceOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>StylesheetCell</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextStylesheetCell(String text) {
        doSetText($element_StylesheetCell, text);
    }

    /**
     * Get the value of text child of element <CODE>TargetOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargetOptionTemplate(String text) {
        doSetText($element_TargetOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>Vocable</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVocable(String text) {
        doSetText($element_Vocable, text);
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
