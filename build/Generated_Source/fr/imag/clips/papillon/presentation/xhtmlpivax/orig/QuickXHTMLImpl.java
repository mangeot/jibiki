/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlpivax.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlpivax/orig/Quick.xhtml
 */
public class QuickXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements QuickXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLButtonElement $element_AddItemButton;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_AddNewTermForm;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_Caption;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_ColAdd;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_ColDel;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_ColRaise;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Content;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Document;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Form;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Inbox;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LammaParam;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Outbox;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Page;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Password;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Project;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Result;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Scoremax;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Scoremin;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_SegmentID;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Source;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_SourceInformation;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_SourceResult;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_TableButton;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Target;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_TargetInformation;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Timeout;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_User;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Volume;

    /**
     * Class attribute constant for element class addNewTermForm
     */
    public static final String CLASS_addNewTermForm = "addNewTermForm";

    /**
     * Class attribute constant for element class caption
     */
    public static final String CLASS_caption = "caption";

    /**
     * Class attribute constant for element class colAdd
     */
    public static final String CLASS_colAdd = "colAdd";

    /**
     * Class attribute constant for element class colDel
     */
    public static final String CLASS_colDel = "colDel";

    /**
     * Class attribute constant for element class colRaise
     */
    public static final String CLASS_colRaise = "colRaise";

    /**
     * Class attribute constant for element class sourceInformation
     */
    public static final String CLASS_sourceInformation = "sourceInformation";

    /**
     * Class attribute constant for element class sourceResult
     */
    public static final String CLASS_sourceResult = "sourceResult";

    /**
     * Class attribute constant for element class tableButton
     */
    public static final String CLASS_tableButton = "tableButton";

    /**
     * Class attribute constant for element class targetInformation
     */
    public static final String CLASS_targetInformation = "targetInformation";

    /**
     * Class attribute constant for element class w4
     */
    public static final String CLASS_w4 = "w4";

    /**
     * Class attribute constant for element class w5
     */
    public static final String CLASS_w5 = "w5";

    /**
     * Class attribute constant for element class wpb
     */
    public static final String CLASS_wpb = "wpb";

    /**
     * Element name constant for addItem
     */
    public static final String NAME_addItem = "addItem";

    /**
     * Element name constant for content
     */
    public static final String NAME_content = "content";

    /**
     * Element name constant for document
     */
    public static final String NAME_document = "document";

    /**
     * Element name constant for inbox
     */
    public static final String NAME_inbox = "inbox";

    /**
     * Element name constant for lammaParam
     */
    public static final String NAME_lammaParam = "lammaParam";

    /**
     * Element name constant for outbox
     */
    public static final String NAME_outbox = "outbox";

    /**
     * Element name constant for page
     */
    public static final String NAME_page = "page";

    /**
     * Element name constant for password
     */
    public static final String NAME_password = "password";

    /**
     * Element name constant for project
     */
    public static final String NAME_project = "project";

    /**
     * Element name constant for scoremax
     */
    public static final String NAME_scoremax = "scoremax";

    /**
     * Element name constant for scoremin
     */
    public static final String NAME_scoremin = "scoremin";

    /**
     * Element name constant for search
     */
    public static final String NAME_search = "search";

    /**
     * Element name constant for segmentID
     */
    public static final String NAME_segmentID = "segmentID";

    /**
     * Element name constant for source
     */
    public static final String NAME_source = "source";

    /**
     * Element name constant for target
     */
    public static final String NAME_target = "target";

    /**
     * Element name constant for timeout
     */
    public static final String NAME_timeout = "timeout";

    /**
     * Element name constant for user
     */
    public static final String NAME_user = "user";

    /**
     * Element name constant for volume
     */
    public static final String NAME_volume = "volume";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = QuickXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlpivax/orig/Quick.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public QuickXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public QuickXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public QuickXHTMLImpl(QuickXHTMLImpl src) {
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
        
        $node4 = document.createTextNode("PIVAX infinitive loop search interface");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "link");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("css/pivax.css");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "rel");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("stylesheet");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "link");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("css/google.css");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "rel");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("stylesheet");
        $attr3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("form");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_Form = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("PIVAX infinitive loop search interface");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Send to PIVAX ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "i");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("(Quick.po)");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" with following parameters by ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("PROGRAM");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(". It\n                sends back a HTML file with result in a pure HTML format in a ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("gradually");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n                process, finished by the EOF character.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Your program saves this HTML file in your application site and load immediatly it\n                when you need");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" The important parameter is: ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode(" required: source=[3_letters], target=[3_letters], lemma=[true/false],\n                    content=[segment content], volume=[volume name, if you know :), if not PIVAX\n                    will search all volumes with the giving source language] ");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode(" optional: timeout=xxxx(ms), scoremin=aaaa, scoremax=bbbb ");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode(" specified and send by SECTra_w (or other ?): segmentId=abcd, project=EOLSS,\n                    page=num ");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Quick.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("post");
        $attr4.appendChild($node5);
        
        $node5 = document.createComment(" Select Volume ");
        $elem4.appendChild($node5);
        
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
        $node6 = document.createTextNode("autoMatch");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Source language: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("source");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("source");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("eng");
        $attr8.appendChild($node9);
        
        $element_Source = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Target language: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("target");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("target");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("fra");
        $attr8.appendChild($node9);
        
        $element_Target = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Do lemma ? ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("lammaParam");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("lammaParam");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("checkbox");
        $attr8.appendChild($node9);
        
        $element_LammaParam = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("3");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Segment: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("content");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("content");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("80");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("stavudine heavy water Arizona trout arsenic alarm system");
        $attr8.appendChild($node9);
        
        $element_Content = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode(" Volume name: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("volume");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("volume");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PIVAX_IATE_eng");
        $attr8.appendChild($node9);
        
        $element_Volume = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n                    \t\tUser: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("user");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("user");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("nguyenht");
        $attr8.appendChild($node9);
        
        $element_User = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                    \t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n                    \t\tPassword: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("password");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("password");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("password");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("khunglong");
        $attr8.appendChild($node9);
        
        $element_Password = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                    \t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n                    \t\tScore min: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("scoremin");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("scoremin");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("1");
        $attr8.appendChild($node9);
        
        $element_Scoremin = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                    \t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n                    \t\tScore max: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("scoremax");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("scoremax");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("5");
        $attr8.appendChild($node9);
        
        $element_Scoremax = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                    \t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n                    \t\ttime out: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("timeout");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("timeout");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("1000");
        $attr8.appendChild($node9);
        
        $element_Timeout = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                    \t");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode(" Project name: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("project");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("project");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EOLSS");
        $attr8.appendChild($node9);
        
        $element_Project = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode(" Document name: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("document");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("document");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("D2");
        $attr8.appendChild($node9);
        
        $element_Document = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode(" Segment ID: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("segmentID");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("segmentID");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("21212");
        $attr8.appendChild($node9);
        
        $element_SegmentID = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode(" page: ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("page");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("page");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("5");
        $attr8.appendChild($node9);
        
        $element_Page = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode(" Inbox (*): ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("inbox");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("inbox");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("/workspace/jibiki/pivax/data/Pivax_Purgatory/SECTRA_w/");
        $attr8.appendChild($node9);
        
        $element_Inbox = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode(" Outbox (*): ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("outbox");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("outbox");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("/tmp/eolss_d2/");
        $attr8.appendChild($node9);
        
        $element_Outbox = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n                            ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("search");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("search");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                        ");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("result");
        $attr3.appendChild($node4);
        
        $element_Result = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("caption");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("caption");
        $attr5.appendChild($node6);
        
        $element_Caption = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Source");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Targets");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("sourceResult");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("sourceResult");
        $attr5.appendChild($node6);
        
        $element_SourceResult = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("sourceInformation");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("sourceInformation");
        $attr6.appendChild($node7);
        
        $element_SourceInformation = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $node7 = document.createComment("table id=\"tableInformation\" class=\"tableInformation\">\n                            <tr id=\"rowInformation\" class=\"rowInformation\">\n                                <td id=\"colInformation\" class=\"colInformation\">\n                                    <table id=\"tableItem\" class=\"tableItem\">\n                                        <tr id=\"captionItem\" class=\"captionItem\">\n                                            <th>Name</th>\n                                            <th>Value</th>\n                                        </tr>\n                                        <tr id=\"contentItem\" class=\"contentItem\">\n                                            <td id=\"contentItemName\" class=\"contentItemName\">headword</td>\n                                            <td id=\"contentItemValue\" class=\"contentItemValue\">abc</td>\n                                        </tr>\n                                    </table>\n                                </td>\n                                <td id=\"colButton\" class=\"colButton\">\n                                    <table id=\"tableButton\" class=\"tableButton\">\n                                        <tr>\n                                            <td id=\"colDel\" class=\"colDel\">\n                                                <button class=\"w5\" title=\"Delete\"/>\n                                            </td>\n                                            <td id=\"colRaise\" class=\"colRaise\">\n                                                <button class=\"w4\" title=\"Vote\"/>\n                                            </td>\n                                            <td id=\"colAdd\" class=\"colAdd\">\n                                                <button class=\"wpb\" title=\"Add\"/>\n                                            </td>\n                                        </tr>\n                                    </table>\n                                </td>\n                            </tr>\n                        </table");
        $elem6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("targetInformation");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("targetInformation");
        $attr6.appendChild($node7);
        
        $element_TargetInformation = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$node7 = document.createTextNode(" ");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("addNewTermForm");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("addNewTermForm");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $element_AddNewTermForm = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "colspan");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("2");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("addItem");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode(" ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "button");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("wpb");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("addItemButton");
        $attr7.appendChild($node8);
        
        $element_AddItemButton = (org.enhydra.xml.xhtml.dom.XHTMLButtonElement)$elem7;$node4 = document.createTextNode("\n            \n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("tableButton");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("tableButton");
        $attr4.appendChild($node5);
        
        $element_TableButton = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("colDel");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("colDel");
        $attr6.appendChild($node7);
        
        $element_ColDel = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$node7 = document.createTextNode("\n                                                ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "button");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("w5");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "title");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Delete");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                                            ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("colRaise");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("colRaise");
        $attr6.appendChild($node7);
        
        $element_ColRaise = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$node7 = document.createTextNode("\n                                                ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "button");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("w4");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "title");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Vote");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                                            ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("colAdd");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("colAdd");
        $attr6.appendChild($node7);
        
        $element_ColAdd = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$node7 = document.createTextNode("\n                                                ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "button");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("wpb");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "title");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Add");
        $attr7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                                            ");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new QuickXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>addItemButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLButtonElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLButtonElement getElementAddItemButton() {
        return $element_AddItemButton;
    }

    /**
     * Get the element with id <CODE>addNewTermForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementAddNewTermForm() {
        return $element_AddNewTermForm;
    }

    /**
     * Get the element with id <CODE>caption</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementCaption() {
        return $element_Caption;
    }

    /**
     * Get the element with id <CODE>colAdd</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementColAdd() {
        return $element_ColAdd;
    }

    /**
     * Get the element with id <CODE>colDel</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementColDel() {
        return $element_ColDel;
    }

    /**
     * Get the element with id <CODE>colRaise</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementColRaise() {
        return $element_ColRaise;
    }

    /**
     * Get the element with id <CODE>content</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementContent() {
        return $element_Content;
    }

    /**
     * Get the element with id <CODE>document</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementDocument() {
        return $element_Document;
    }

    /**
     * Get the element with id <CODE>form</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementForm() {
        return $element_Form;
    }

    /**
     * Get the element with id <CODE>inbox</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementInbox() {
        return $element_Inbox;
    }

    /**
     * Get the element with id <CODE>lammaParam</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLammaParam() {
        return $element_LammaParam;
    }

    /**
     * Get the element with id <CODE>outbox</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementOutbox() {
        return $element_Outbox;
    }

    /**
     * Get the element with id <CODE>page</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementPage() {
        return $element_Page;
    }

    /**
     * Get the element with id <CODE>password</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementPassword() {
        return $element_Password;
    }

    /**
     * Get the element with id <CODE>project</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementProject() {
        return $element_Project;
    }

    /**
     * Get the element with id <CODE>result</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementResult() {
        return $element_Result;
    }

    /**
     * Get the element with id <CODE>scoremax</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementScoremax() {
        return $element_Scoremax;
    }

    /**
     * Get the element with id <CODE>scoremin</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementScoremin() {
        return $element_Scoremin;
    }

    /**
     * Get the element with id <CODE>segmentID</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSegmentID() {
        return $element_SegmentID;
    }

    /**
     * Get the element with id <CODE>source</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSource() {
        return $element_Source;
    }

    /**
     * Get the element with id <CODE>sourceInformation</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementSourceInformation() {
        return $element_SourceInformation;
    }

    /**
     * Get the element with id <CODE>sourceResult</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementSourceResult() {
        return $element_SourceResult;
    }

    /**
     * Get the element with id <CODE>tableButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementTableButton() {
        return $element_TableButton;
    }

    /**
     * Get the element with id <CODE>target</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementTarget() {
        return $element_Target;
    }

    /**
     * Get the element with id <CODE>targetInformation</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementTargetInformation() {
        return $element_TargetInformation;
    }

    /**
     * Get the element with id <CODE>timeout</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementTimeout() {
        return $element_Timeout;
    }

    /**
     * Get the element with id <CODE>user</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementUser() {
        return $element_User;
    }

    /**
     * Get the element with id <CODE>volume</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVolume() {
        return $element_Volume;
    }

    /**
     * Get the element with id <CODE>addItemButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAddItemButton() {
        return $element_AddItemButton;
    }

    /**
     * Get the element with id <CODE>addNewTermForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAddNewTermForm() {
        return $element_AddNewTermForm;
    }

    /**
     * Get the element with id <CODE>caption</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCaption() {
        return $element_Caption;
    }

    /**
     * Get the element with id <CODE>colAdd</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagColAdd() {
        return $element_ColAdd;
    }

    /**
     * Get the element with id <CODE>colDel</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagColDel() {
        return $element_ColDel;
    }

    /**
     * Get the element with id <CODE>colRaise</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagColRaise() {
        return $element_ColRaise;
    }

    /**
     * Get the element with id <CODE>content</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContent() {
        return $element_Content;
    }

    /**
     * Get the element with id <CODE>document</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocument() {
        return $element_Document;
    }

    /**
     * Get the element with id <CODE>form</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagForm() {
        return $element_Form;
    }

    /**
     * Get the element with id <CODE>inbox</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagInbox() {
        return $element_Inbox;
    }

    /**
     * Get the element with id <CODE>lammaParam</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLammaParam() {
        return $element_LammaParam;
    }

    /**
     * Get the element with id <CODE>outbox</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOutbox() {
        return $element_Outbox;
    }

    /**
     * Get the element with id <CODE>page</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPage() {
        return $element_Page;
    }

    /**
     * Get the element with id <CODE>password</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPassword() {
        return $element_Password;
    }

    /**
     * Get the element with id <CODE>project</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagProject() {
        return $element_Project;
    }

    /**
     * Get the element with id <CODE>result</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResult() {
        return $element_Result;
    }

    /**
     * Get the element with id <CODE>scoremax</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScoremax() {
        return $element_Scoremax;
    }

    /**
     * Get the element with id <CODE>scoremin</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScoremin() {
        return $element_Scoremin;
    }

    /**
     * Get the element with id <CODE>segmentID</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSegmentID() {
        return $element_SegmentID;
    }

    /**
     * Get the element with id <CODE>source</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSource() {
        return $element_Source;
    }

    /**
     * Get the element with id <CODE>sourceInformation</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSourceInformation() {
        return $element_SourceInformation;
    }

    /**
     * Get the element with id <CODE>sourceResult</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSourceResult() {
        return $element_SourceResult;
    }

    /**
     * Get the element with id <CODE>tableButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTableButton() {
        return $element_TableButton;
    }

    /**
     * Get the element with id <CODE>target</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTarget() {
        return $element_Target;
    }

    /**
     * Get the element with id <CODE>targetInformation</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargetInformation() {
        return $element_TargetInformation;
    }

    /**
     * Get the element with id <CODE>timeout</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTimeout() {
        return $element_Timeout;
    }

    /**
     * Get the element with id <CODE>user</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUser() {
        return $element_User;
    }

    /**
     * Get the element with id <CODE>volume</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolume() {
        return $element_Volume;
    }

    /**
     * Get the value of text child of element <CODE>addItemButton</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAddItemButton(String text) {
        doSetText($element_AddItemButton, text);
    }

    /**
     * Get the value of text child of element <CODE>colAdd</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextColAdd(String text) {
        doSetText($element_ColAdd, text);
    }

    /**
     * Get the value of text child of element <CODE>colDel</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextColDel(String text) {
        doSetText($element_ColDel, text);
    }

    /**
     * Get the value of text child of element <CODE>colRaise</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextColRaise(String text) {
        doSetText($element_ColRaise, text);
    }

    /**
     * Get the value of text child of element <CODE>form</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextForm(String text) {
        doSetText($element_Form, text);
    }

    /**
     * Get the value of text child of element <CODE>result</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextResult(String text) {
        doSetText($element_Result, text);
    }

    /**
     * Get the value of text child of element <CODE>sourceInformation</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSourceInformation(String text) {
        doSetText($element_SourceInformation, text);
    }

    /**
     * Get the value of text child of element <CODE>targetInformation</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargetInformation(String text) {
        doSetText($element_TargetInformation, text);
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
