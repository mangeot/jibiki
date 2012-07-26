/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlgdef.eng;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlgdef/eng/Layout.xhtml
 */
public class LayoutXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements LayoutXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.LayoutXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Firefox;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HeaderPlace;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_MainColumn;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_MenuColumn;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_NewsColumn;

    private org.enhydra.xml.xhtml.dom.XHTMLHeadingElement $element_ProjectTitle;

    private org.enhydra.xml.xhtml.dom.XHTMLHRElement $element_RemoveIfNotIE;

    private org.enhydra.xml.xhtml.dom.XHTMLScriptElement $element_Script;

    /**
     * Class attribute constant for element class copyright
     */
    public static final String CLASS_copyright = "copyright";

    /**
     * Class attribute constant for element class headerBlock
     */
    public static final String CLASS_headerBlock = "headerBlock";

    /**
     * Class attribute constant for element class headerMenu
     */
    public static final String CLASS_headerMenu = "headerMenu";

    /**
     * Class attribute constant for element class mainColumn
     */
    public static final String CLASS_mainColumn = "mainColumn";

    /**
     * Class attribute constant for element class menuColumn
     */
    public static final String CLASS_menuColumn = "menuColumn";

    /**
     * Class attribute constant for element class newsColumn
     */
    public static final String CLASS_newsColumn = "newsColumn";

    /**
     * Class attribute constant for element class projectName
     */
    public static final String CLASS_projectName = "projectName";

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
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlgdef/eng/Layout.xhtml";

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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
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
        $node4 = document.createTextNode("css/gdef-home.css");
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
        $node4 = document.createTextNode("Mathieu MANGEOT & Gilles S\u00e9rasset");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("author");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Grand Dictionnaire Estonien Fran\u00e7ais");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("keywords");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Le projet GDEF a pour but de cr\u00e9er un dictionnaire bilingue estonien-fran\u00e7ais");
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
        
        $node4 = document.createTextNode("GDEF: Grand Dictionnaire Estonien Fran\u00e7ais");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "src");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("javascript/jquery-1.1.3.1.js");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createComment(" // ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "src");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("javascript/jquery.dimensions.js");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createComment(" // ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "src");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("javascript/autocomplete.js");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createComment(" // ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "src");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("javascript/functions.js");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createComment(" // ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Script");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $element_Script = (org.enhydra.xml.xhtml.dom.XHTMLScriptElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("\n\nfunction loadFunction () {\n\treturn 0;\n}\n\n//");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "onload");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("javascript:loadFunction();");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "src");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("javascript/AdvancedQueryFormAjax.js");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createComment(" // ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("headerBlock");
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
        $node5 = document.createTextNode("en");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("en");
        $attr4.appendChild($node5);
        
        $element_ProjectTitle = (org.enhydra.xml.xhtml.dom.XHTMLHeadingElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment("img alt=\"The Papillon Project\" src=\"media/header.jpg\" /");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        The ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("projectName");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("GDEF");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" Project\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("headerMenu");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("HeaderPlace");
        $attr4.appendChild($node5);
        
        $element_HeaderPlace = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem2.appendChild($elem3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("RemoveIfNotIE");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "style");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("color:white; height:0");
        $attr3.appendChild($node4);
        
        $element_RemoveIfNotIE = (org.enhydra.xml.xhtml.dom.XHTMLHRElement)$elem3;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("menuColumn");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("MenuColumn");
        $attr3.appendChild($node4);
        
        $element_MenuColumn = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("mainColumn");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("MainColumn");
        $attr3.appendChild($node4);
        
        $element_MainColumn = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("newsColumn");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("NewsColumn");
        $attr3.appendChild($node4);
        
        $element_NewsColumn = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("firefox");
        $attr3.appendChild($node4);
        
        $element_Firefox = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("http://www.mozilla-europe.org/fr/");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "alt");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Firefox 2");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "src");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://sfx-images.mozilla.org/affiliates/Buttons/firefox2/firefox-spread-btn-1b.png");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Firefox 2");
        $attr5.appendChild($node6);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("La banque de termes LexALP est optimis\u00e9e pour le navigateur gratuit\u00a0: ");
        $elem4.appendChild($node5);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("copyright");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Platform: \u00a9 2001-2006 ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("mailto:Mathieu.MangeotATimag.fr?subject=GDEFServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Mathieu Mangeot");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" \n\t& ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("mailto:gilles.serassetATimag.fr?subject=PapillonServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Gilles S\u00e9rasset");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(", GETA-CLIPS. All rights reserved.");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n    Data: \u00a9 2004-2006 Association franco-estonienne de lexicographie et Institut de la langue estonienne. All rights reserved.");
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
     * Get the element with id <CODE>firefox</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFirefox() {
        return $element_Firefox;
    }

    /**
     * Get the element with id <CODE>HeaderPlace</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementHeaderPlace() {
        return $element_HeaderPlace;
    }

    /**
     * Get the element with id <CODE>MainColumn</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementMainColumn() {
        return $element_MainColumn;
    }

    /**
     * Get the element with id <CODE>MenuColumn</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementMenuColumn() {
        return $element_MenuColumn;
    }

    /**
     * Get the element with id <CODE>NewsColumn</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementNewsColumn() {
        return $element_NewsColumn;
    }

    /**
     * Get the element with id <CODE>projectTitle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLHeadingElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLHeadingElement getElementProjectTitle() {
        return $element_ProjectTitle;
    }

    /**
     * Get the element with id <CODE>RemoveIfNotIE</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLHRElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLHRElement getElementRemoveIfNotIE() {
        return $element_RemoveIfNotIE;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLScriptElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLScriptElement getElementScript() {
        return $element_Script;
    }

    /**
     * Get the element with id <CODE>firefox</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFirefox() {
        return $element_Firefox;
    }

    /**
     * Get the element with id <CODE>HeaderPlace</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeaderPlace() {
        return $element_HeaderPlace;
    }

    /**
     * Get the element with id <CODE>MainColumn</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMainColumn() {
        return $element_MainColumn;
    }

    /**
     * Get the element with id <CODE>MenuColumn</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMenuColumn() {
        return $element_MenuColumn;
    }

    /**
     * Get the element with id <CODE>NewsColumn</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNewsColumn() {
        return $element_NewsColumn;
    }

    /**
     * Get the element with id <CODE>projectTitle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagProjectTitle() {
        return $element_ProjectTitle;
    }

    /**
     * Get the element with id <CODE>RemoveIfNotIE</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveIfNotIE() {
        return $element_RemoveIfNotIE;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScript() {
        return $element_Script;
    }

    /**
     * Get the value of text child of element <CODE>firefox</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFirefox(String text) {
        doSetText($element_Firefox, text);
    }

    /**
     * Get the value of text child of element <CODE>HeaderPlace</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeaderPlace(String text) {
        doSetText($element_HeaderPlace, text);
    }

    /**
     * Get the value of text child of element <CODE>MainColumn</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMainColumn(String text) {
        doSetText($element_MainColumn, text);
    }

    /**
     * Get the value of text child of element <CODE>MenuColumn</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMenuColumn(String text) {
        doSetText($element_MenuColumn, text);
    }

    /**
     * Get the value of text child of element <CODE>NewsColumn</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNewsColumn(String text) {
        doSetText($element_NewsColumn, text);
    }

    /**
     * Get the value of text child of element <CODE>projectTitle</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextProjectTitle(String text) {
        doSetText($element_ProjectTitle, text);
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
