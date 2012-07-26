/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlpivax.eng;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlpivax/eng/Layout.xhtml
 */
public class LayoutXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements LayoutXHTML, fr.imag.clips.papillon.presentation.xhtmlpivax.orig.LayoutXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_HeaderPlace;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_HomeLink;

    private org.enhydra.xml.xhtml.dom.XHTMLImageElement $element_Logo;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_MainColumn;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_MenuBlockPlaceHolder;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_MenuColumn;

    private org.enhydra.xml.xhtml.dom.XHTMLHeadingElement $element_ProjectTitle;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_QuicklistLink;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_QuicklistNumber;

    private org.enhydra.xml.xhtml.dom.XHTMLScriptElement $element_Script;

    /**
     * Class attribute constant for element class copyright
     */
    public static final String CLASS_copyright = "copyright";

    /**
     * Class attribute constant for element class eolssLogos
     */
    public static final String CLASS_eolssLogos = "eolssLogos";

    /**
     * Class attribute constant for element class jibikiLogos
     */
    public static final String CLASS_jibikiLogos = "jibikiLogos";

    /**
     * Class attribute constant for element class mainColumn
     */
    public static final String CLASS_mainColumn = "mainColumn";

    /**
     * Class attribute constant for element class menuColumn
     */
    public static final String CLASS_menuColumn = "menuColumn";

    /**
     * Class attribute constant for element class quickLinks
     */
    public static final String CLASS_quickLinks = "quickLinks";

    /**
     * Class attribute constant for element class titlePane
     */
    public static final String CLASS_titlePane = "titlePane";

    /**
     * Class attribute constant for element class undlLogos
     */
    public static final String CLASS_undlLogos = "undlLogos";

    /**
     * Element name constant for author
     */
    public static final String NAME_author = "author";

    /**
     * Element name constant for description
     */
    public static final String NAME_description = "description";

    /**
     * Element name constant for generator
     */
    public static final String NAME_generator = "generator";

    /**
     * Element name constant for keywords
     */
    public static final String NAME_keywords = "keywords";

    /**
     * Element name constant for robots
     */
    public static final String NAME_robots = "robots";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = LayoutXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlpivax/eng/Layout.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public LayoutXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public LayoutXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public LayoutXHTMLImpl(LayoutXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6;
        
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
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "link");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("css/pivax.css");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "rel");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("StyleSheet");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/css");
        $attr3.appendChild($node4);
        
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
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Hong-Thai NGUYEN");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("author");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("UNL-NL Dictionary U++C");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("keywords");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Dictionary for UNL to/from Natural Language in MT systems");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("description");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Enhydra");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("generator");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("index, follow");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("robots");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("PIVAX - Lexical database for pivot languages");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Script");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "src");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("javascript/pivax.js");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $element_Script = (org.enhydra.xml.xhtml.dom.XHTMLScriptElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("\n        //\n\n        //");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("      \n    ");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "onload");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("javascript:init();");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("titlePane");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("projectTitle");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "lang");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("fr");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("fr");
        $attr4.appendChild($node5);
        
        $element_ProjectTitle = (org.enhydra.xml.xhtml.dom.XHTMLHeadingElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://localhost:8999/");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("homeLink");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("PIVAX Home Page");
        $attr5.appendChild($node6);
        
        $element_HomeLink = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("PIVAX");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("logo");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/pivax/logo4.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("150px");
        $attr6.appendChild($node7);
        
        $element_Logo = (org.enhydra.xml.xhtml.dom.XHTMLImageElement)$elem6;$node5 = document.createTextNode(" UW - UNL Dictionary\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("quickLinks");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("HeaderPlace");
        $attr4.appendChild($node5);
        
        $element_HeaderPlace = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Home.po?action=quicklist");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("quicklistLink");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Quick list");
        $attr5.appendChild($node6);
        
        $element_QuicklistLink = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("Quick list");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" (");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("quicklistNumber");
        $attr5.appendChild($node6);
        
        $element_QuicklistNumber = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("0");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(")\u00a0| ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Contacts.po");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Contacts");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Contacts");
        $elem5.appendChild($node6);
        
        $node5 = document.createComment("|\u00a0<a href=\"Search.po\">Search</a");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\u00a0|\u00a0");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("SiteMap.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Site Map");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("menuColumn");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("MenuColumn");
        $attr3.appendChild($node4);
        
        $element_MenuColumn = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("menuBlockPlaceHolder");
        $attr4.appendChild($node5);
        
        $element_MenuBlockPlaceHolder = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("jibikiLogos");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.papillon-dictionary.org/Home.po");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Jibiki platform");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Jibiki");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/logo-jibiki.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("150px");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("undlLogos");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.undl.org/");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UNDL Home Page");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("UNDL");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/pivax/undl_logo.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("150px");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      \n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("eolssLogos");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.eolss.net/");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EOLSS Home Page");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("UNDL");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/pivax/eolss_logo.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("150px");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      \n      ");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("div class=\"omniaLogos\">\n        <a href=\"http://www.ellemme.org/\" title=\"OMNIA Project Home Page\">\n        <img src=\"media/pivax/logo_omnia.tiff\" alt=\"OMNIA\" width=\"150px\"/>\n        </a>\n        </div>\n        <div class=\"xeroxLogos\">\n        <a href=\"http://www.xrce.xerox.com/\" title=\"Xerox Research Center Europe\">\n        <img src=\"media/pivax/logo_pages_Xerox.gif\" alt=\"LIRIS\" width=\"150px\"/>\n        </a>\n        </div>\n        <div class=\"lirisLogos\">\n        <a href=\"http://liris.cnrs.fr/\" title=\"\u00c9cole Centrale de Lyon\">\n        <img src=\"media/pivax/logo_liris.png\" alt=\"LIRIS\" width=\"150px\"/>\n        </a>\n        </div>\n        <div class=\"ligLogos\">\n        <a href=\"http://www-clips.imag.fr/getalp//\" title=\"Universit\u00e9 Joseph-Fourier - LIG\">\n        <img src=\"media/pivax/UJF-LIG-complet.tiff\" alt=\"GETALP-LIG,UJF\" width=\"150px\"/>\n        </a>\n        </div");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("  \n    ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("mainColumn");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("MainColumn");
        $attr3.appendChild($node4);
        
        $element_MainColumn = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node3 = document.createComment("div id=\"NewsColumn\" class=\"newsColumn\" /");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("copyright");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n      Jibiki Plateform: \u00a9 2001-2007, GETALP-LIG. All rights reserved.");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n      Data: \u00a9 2007- PIVAX.");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new LayoutXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>HeaderPlace</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementHeaderPlace() {
        return $element_HeaderPlace;
    }

    /**
     * Get the element with id <CODE>homeLink</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementHomeLink() {
        return $element_HomeLink;
    }

    /**
     * Get the element with id <CODE>logo</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLImageElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLImageElement getElementLogo() {
        return $element_Logo;
    }

    /**
     * Get the element with id <CODE>MainColumn</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementMainColumn() {
        return $element_MainColumn;
    }

    /**
     * Get the element with id <CODE>menuBlockPlaceHolder</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementMenuBlockPlaceHolder() {
        return $element_MenuBlockPlaceHolder;
    }

    /**
     * Get the element with id <CODE>MenuColumn</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementMenuColumn() {
        return $element_MenuColumn;
    }

    /**
     * Get the element with id <CODE>projectTitle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLHeadingElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLHeadingElement getElementProjectTitle() {
        return $element_ProjectTitle;
    }

    /**
     * Get the element with id <CODE>quicklistLink</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementQuicklistLink() {
        return $element_QuicklistLink;
    }

    /**
     * Get the element with id <CODE>quicklistNumber</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementQuicklistNumber() {
        return $element_QuicklistNumber;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLScriptElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLScriptElement getElementScript() {
        return $element_Script;
    }

    /**
     * Get the element with id <CODE>HeaderPlace</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeaderPlace() {
        return $element_HeaderPlace;
    }

    /**
     * Get the element with id <CODE>homeLink</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHomeLink() {
        return $element_HomeLink;
    }

    /**
     * Get the element with id <CODE>logo</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLogo() {
        return $element_Logo;
    }

    /**
     * Get the element with id <CODE>MainColumn</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMainColumn() {
        return $element_MainColumn;
    }

    /**
     * Get the element with id <CODE>menuBlockPlaceHolder</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMenuBlockPlaceHolder() {
        return $element_MenuBlockPlaceHolder;
    }

    /**
     * Get the element with id <CODE>MenuColumn</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMenuColumn() {
        return $element_MenuColumn;
    }

    /**
     * Get the element with id <CODE>projectTitle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagProjectTitle() {
        return $element_ProjectTitle;
    }

    /**
     * Get the element with id <CODE>quicklistLink</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQuicklistLink() {
        return $element_QuicklistLink;
    }

    /**
     * Get the element with id <CODE>quicklistNumber</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQuicklistNumber() {
        return $element_QuicklistNumber;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScript() {
        return $element_Script;
    }

    /**
     * Get the value of text child of element <CODE>HeaderPlace</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeaderPlace(String text) {
        doSetText($element_HeaderPlace, text);
    }

    /**
     * Get the value of text child of element <CODE>homeLink</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHomeLink(String text) {
        doSetText($element_HomeLink, text);
    }

    /**
     * Get the value of text child of element <CODE>MainColumn</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMainColumn(String text) {
        doSetText($element_MainColumn, text);
    }

    /**
     * Get the value of text child of element <CODE>menuBlockPlaceHolder</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMenuBlockPlaceHolder(String text) {
        doSetText($element_MenuBlockPlaceHolder, text);
    }

    /**
     * Get the value of text child of element <CODE>MenuColumn</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMenuColumn(String text) {
        doSetText($element_MenuColumn, text);
    }

    /**
     * Get the value of text child of element <CODE>projectTitle</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextProjectTitle(String text) {
        doSetText($element_ProjectTitle, text);
    }

    /**
     * Get the value of text child of element <CODE>quicklistLink</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQuicklistLink(String text) {
        doSetText($element_QuicklistLink, text);
    }

    /**
     * Get the value of text child of element <CODE>quicklistNumber</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQuicklistNumber(String text) {
        doSetText($element_QuicklistNumber, text);
    }

    /**
     * Get the value of text child of element <CODE>Script</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextScript(String text) {
        doSetText($element_Script, text);
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
