/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmldilaf.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmldilaf/orig/HomeContent.xhtml
 */
public class HomeContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements HomeContentXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.HomeContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HomeContent;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ProjectDescription;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    /**
     * Class attribute constant for element class deu
     */
    public static final String CLASS_deu = "deu";

    /**
     * Class attribute constant for element class eng
     */
    public static final String CLASS_eng = "eng";

    /**
     * Class attribute constant for element class fra
     */
    public static final String CLASS_fra = "fra";

    /**
     * Class attribute constant for element class gray
     */
    public static final String CLASS_gray = "gray";

    /**
     * Class attribute constant for element class jpn
     */
    public static final String CLASS_jpn = "jpn";

    /**
     * Class attribute constant for element class standard
     */
    public static final String CLASS_standard = "standard";

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Class attribute constant for element class zho
     */
    public static final String CLASS_zho = "zho";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = HomeContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmldilaf/orig/HomeContent.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public HomeContentXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public HomeContentXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public HomeContentXHTMLImpl(HomeContentXHTMLImpl src) {
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
        
        $node3 = document.createComment(" Be careful, in order to display the languages in a random order, there must be as many h1 than p ");
        $elem2.appendChild($node3);
        
        $node3 = document.createComment(" and in the same language order ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("HomeContent");
        $attr3.appendChild($node4);
        
        $element_HomeContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" in this div, there must be only p and h1 tags ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ProjectDescription");
        $attr4.appendChild($node5);
        
        $element_ProjectDescription = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("fr");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("fr");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Le projet ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Papillon");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ja");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ja");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\u30d1\u30d4\u30e8\u30f3");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\u8f9e\u66f8");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("en");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("en");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("The ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Papillon");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" project");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("zh-Hans");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("zh-Hans");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\u5f69 \u8776");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" \u8bcd \u5178");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("de");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("de");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Das ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Papillon");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("-Projekt");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("fra");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("fr");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("fr");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Ce projet a pour but de cr\u00e9er une base lexicale\n            multilingue comprenant entre autres l\u2019allemand, l\u2019anglais, le fran\u00e7ais, le japonais, le\n            malais, le lao, le tha\u00ef, le vietnamien et le chinois. L\u2019acc\u00e8s est gratuit pourvu que\n            l\u2019usage ne soit pas commercial (licence de logiciel libre). Notre projet, initi\u00e9 par des\n            chercheurs en linguistique informatique, se veut utile et ouvert \u00e0 la collaboration de\n            toutes les personnes ayant un int\u00e9r\u00eat pour ces langues.");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("jpn");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ja");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ja");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\u3053\u306e\u30d7\u30ed\u30b8\u30a7\u30af\u30c8\u306f\u3001\u7279\u306b\u82f1\u8a9e\u3001\u30bf\u30a4\u8a9e\u3001\u4e2d\u56fd\u8a9e\u3001\u30c9\u30a4\u30c4\u8a9e\u3001\u65e5\u672c\u8a9e\u3001\n            \u30d5\u30e9\u30f3\u30b9\u8a9e\u3001\u30de\u30ec\u30a4\u8a9e\u3001\u30e9\u30aa\u30b9\u8a9e\u53ca\u3073\u30d9\u30c8\u30ca\u30e0\u8a9e\u3068\u3044\u3063\u305f\u591a\u8a00\u8a9e\u306e\u8a9e\u5f59\u30c7\u30fc\u30bf\u30d9\u30fc\u30b9\u306e\u4f5c\u6210\u3092\u76ee\u6307\u3057\u307e\u3059\u3002 \u5546\u696d\u76ee\u7684\u3067\u306f\u306a\u304f\u30aa\u30fc\u30d7\u30f3\u30bd\u30fc\u30b9\u3067\u8ab0\u3067\u3082\u7121\u6599\u3067\u5229\u7528\u3067\u304d\u307e\u3059\u3002\n            \u4f55\u4eba\u304b\u306e\u6a5f\u68b0\u8a00\u8a9e\u5b66\u8005\u306b\u3088\u3063\u3066\u59cb\u3081\u3089\u308c\u305f\u79c1\u305f\u3061\u306e\u30d7\u30ed\u30b8\u30a7\u30af\u30c8\u306f\u3053\u308c\u3089\u306e\u8a00\u8a9e\u306b \u8208\u5473\u3092\u6301\u3063\u3066\u3044\u308b\u3059\u3079\u3066\u306e\u4eba\u3005\u306b\u3068\u3063\u3066\u6709\u52b9\u304b\u3064\u958b\u304b\u308c\u308b\u4e8b\u3092\u76ee\u6307\u3057\u3066\u3044\u307e\u3059\u3002");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("eng");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("en");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("en");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("This project aims at creating a multilingual\n            lexical database covering among others English, French, German, Japanese, Lao, Tha\u00ef and\n            Chinese. The access will be free of charge for non commercial use (Open Source license).\n            Our project, initiated by some computational linguists, aims at being useful and open to\n            all those who are interested in these languages.");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("zho");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("zh-Hans");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("zh-Hans");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\u672c\u9879\u76ee\u662f\u4e3a\u4e86\u521b\u5efa\u4e00\u4e2a\u5305\u62ec\u82f1\u8bed\u3001\u6cd5\u8bed\u3001\u65e5\u8bed\u3001\u9a6c\u6765\u8bed\u3001\u8001\u631d\u8bed\u3001\u6cf0\u8bed\u3001\n            \u8d8a\u5357\u8bed\u548c\u4e2d\u6587\u7684\u591a\u56fd\u6587\u5b57\u5e73\u53f0\uff0c\u53ef\u4ee5\u514d\u8d39\u8fdb\u5165\uff0c\u6ca1\u6709\u4efb\u4f55\u5546\u4e1a\u76ee\u7684\u3002\u6211\u4eec\u7684\u5e73\u53f0\u53ef\u4e3a\u6240\u6709\u5bf9\u6cd5\u8bed\u3001\u65e5\u8bed\u3001\u9a6c\u6765\u8bed\u3001\u8001\u631d\u8bed\u3001\u6cf0\u8bed\u3001 \u8d8a\u5357\u8bed\u548c\u4e2d\u6587\u611f\u5174\u8da3\u7684\u4eba\u4eec\u63d0\u4f9b\u5e2e\u52a9\u3002");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("display:none;");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("deu");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("de");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("de");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Dieses Projekt hat die Erstellung einer\n            mehrsprachigen W\u00f6rterbuch-Datenbank zum Ziel, welche unter anderem die Sprachen\n            Chinesisch, Deutsch, Englisch, Franz\u00f6sisch, Japanisch, Lao und Thai abdeckt. Der Zugang\n            wird f\u00fcr den nicht kommerziellen Gebrauch kostenlos gew\u00e4hrt (Open Source Licenz). Unser\n            Projekt, wurde von einigen Computer-Lingusiten initiert und hat zum Ziel, f\u00fcr alle, die\n            an diesen Sprachen Interesse haben, n\u00fctzlich und offen zu sein.");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("fr");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("fr");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Le projet ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("DiLAF");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n\t\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Le but de ce super projet, coordonn\u00e9e par la grande quelqu'un ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-size:20pt;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Chantal Enguehard");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(", \n\t  consiste \u00e0 convertir des dictionnaires \u00e9ditoriaux bilingues langue africaine-fran\u00e7ais en dictionnaires \u00e9lectroniques au format \nXML \u00e0 des fins d'affichage sur la Toile et de p\u00e9rennisation de ressources linguistiques pour le Traitement Automatique des \nLangues Naturelles");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\nCe projet vise avant tout \u00e0 favoriser la diversit\u00e9 linguistique des aires linguistiques partenaires sur la toile en am\u00e9liorant \nl'acc\u00e8s aux dictionnaires existants pour toutes les personnes \u00e9crivant en langue nationale. Il s'inscrit directement dans les \nplans d\u00e9cennaux des pays des partenaires en mati\u00e8re d'\u00e9ducation en am\u00e9liorant l'acc\u00e8s \u00e0 des ouvrages de r\u00e9f\u00e9rence en \nlangues nationales. Il met en oeuvre les technologies de l'information et de la communication.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Les partenaires de ce projet peuvent \u00eatre pr\u00e9sent\u00e9s en deux groupes");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "ol");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("les informaticiens sp\u00e9cialistes en Traitement Automatique des Langues. Ils sont membres des pays du Nord et du Sud.");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("les linguistes ayant pour langues maternelles les langues africaines des dictionnaires bilingues.");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\nLes informaticiens auront pour t\u00e2che de r\u00e9diger des tutoriels portant sur le standard Unicode, le format XML, les programmes \nXSLT et les expressions r\u00e9guli\u00e8res. Ils assureront le transfert de connaissances sur ces sujets pendant des ateliers portant \ndirectement sur les dictionnaires \u00e0 traiter. Ils participeront \u00e0 l'\u00e9criture des programmes XSLT et \u00e0 la mise en oeuvre de la \nnavigation sur le site mis en ligne. ");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\nLes linguistes seront charg\u00e9s de la conversion des dictionnaires au standard Unicode et de la pose des balises.");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode(" \nInformaticiens et linguistes travailleront en collaboration \u00e9troite pour la d\u00e9finition des balises XML. Ils seront appuy\u00e9s par un \nexpert du standard international Lexical Markup Framework (LMF) de balisage de dictionnaires multilingues ISO/TC 37/SC 4 \nN130. ");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\nDes articles de recherche seront \u00e9crits en commun. ");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\nTous les partenaires de ce projet connaissent d\u00e9j\u00e0 bien les probl\u00e9matiques en jeu. Ils ont une solide exp\u00e9rience en ce qui \nconcerne la lexicographie, tant dans le domaine linguistique qu'informatique. ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n       ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryResult");
        $attr4.appendChild($node5);
        
        $element_QueryResult = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("title");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("R\u00e9sultat de recherche");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryFuzzyResult");
        $attr4.appendChild($node5);
        
        $element_QueryFuzzyResult = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("title");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("R\u00e9sultat de recherche approch\u00e9e");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryFuzzyResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryFuzzyResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node5 = document.createTextNode("\n      ");
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
        return new HomeContentXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>HomeContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementHomeContent() {
        return $element_HomeContent;
    }

    /**
     * Get the element with id <CODE>ProjectDescription</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementProjectDescription() {
        return $element_ProjectDescription;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResult</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryFuzzyResult() {
        return $element_QueryFuzzyResult;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryFuzzyResultForm() {
        return $element_QueryFuzzyResultForm;
    }

    /**
     * Get the element with id <CODE>QueryResult</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryResult() {
        return $element_QueryResult;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the element with id <CODE>HomeContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHomeContent() {
        return $element_HomeContent;
    }

    /**
     * Get the element with id <CODE>ProjectDescription</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagProjectDescription() {
        return $element_ProjectDescription;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResult</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryFuzzyResult() {
        return $element_QueryFuzzyResult;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryFuzzyResultForm() {
        return $element_QueryFuzzyResultForm;
    }

    /**
     * Get the element with id <CODE>QueryResult</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryResult() {
        return $element_QueryResult;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the value of text child of element <CODE>HomeContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHomeContent(String text) {
        doSetText($element_HomeContent, text);
    }

    /**
     * Get the value of text child of element <CODE>ProjectDescription</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextProjectDescription(String text) {
        doSetText($element_ProjectDescription, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryFuzzyResult</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryFuzzyResult(String text) {
        doSetText($element_QueryFuzzyResult, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryFuzzyResultForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryFuzzyResultForm(String text) {
        doSetText($element_QueryFuzzyResultForm, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryResult</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryResult(String text) {
        doSetText($element_QueryResult, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryResultForm(String text) {
        doSetText($element_QueryResultForm, text);
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
