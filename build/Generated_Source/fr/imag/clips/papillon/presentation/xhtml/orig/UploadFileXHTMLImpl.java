/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/UploadFile.xhtml
 */
public class UploadFileXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements UploadFileXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_File;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_FileName;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_Form;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ResultUrl;

    private org.enhydra.xml.xhtml.dom.XHTMLScriptElement $element_Script;

    /**
     * Class attribute constant for element class copyright
     */
    public static final String CLASS_copyright = "copyright";

    /**
     * Element name constant for author
     */
    public static final String NAME_author = "author";

    /**
     * Element name constant for description
     */
    public static final String NAME_description = "description";

    /**
     * Element name constant for file
     */
    public static final String NAME_file = "file";

    /**
     * Element name constant for fileName
     */
    public static final String NAME_fileName = "fileName";

    /**
     * Element name constant for generator
     */
    public static final String NAME_generator = "generator";

    /**
     * Element name constant for keywords
     */
    public static final String NAME_keywords = "keywords";

    /**
     * Element name constant for resultUrl
     */
    public static final String NAME_resultUrl = "resultUrl";

    /**
     * Element name constant for robots
     */
    public static final String NAME_robots = "robots";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = UploadFileXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/UploadFile.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public UploadFileXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public UploadFileXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public UploadFileXHTMLImpl(UploadFileXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7;
        
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
        $node4 = document.createTextNode("css/papillon-home.css");
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
        $node4 = document.createTextNode("dictionnaire, multilingue, projet papillon, base lexicale, fran\u00e7ais, japonais, multilingual dictionary, papillon project, lexical database, French, English, Japanese, \u96fb\u5b50\u8f9e\u66f8,\u30aa\u30f3\u30e9\u30a4\u30f3\u8f9e\u66f8,\u96fb\u5b50\u8f9e\u5178,\u30aa\u30f3\u30e9\u30a4\u30f3\u8f9e\u5178,\u4ecf\u548c\u8f9e\u5178,\u548c\u4ecf\u8f9e\u5178,\u30d5\u30e9\u30f3\u30b9\u8a9e\u8f9e\u5178,\u4ecf\u8a9e\u8f9e\u5178");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("keywords");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Le projet Papillon a pour but de cr\u00e9er une base lexicale multilingue comprenant entre autres l'anglais, le fran\u00e7ais, le japonais, le malais, le lao, le tha\u00ef, le vietnamien et le chinois. L'acc\u00e8s est libre et gratuit. Notre projet se veut utile et ouvert \u00e0 la collaboration de toutes les personnes ayant un int\u00e9r\u00eat pour ces langues \u30d1\u30d4\u30ed\u30f3\u30d7\u30ed\u30b8\u30a7\u30af\u30c8\u306f\u3001\u7279\u306b\u82f1\u8a9e\u3001\u30d5\u30e9\u30f3\u30b9\u8a9e\u3001\u65e5\u672c\u8a9e\u3001\u30e9\u30aa\u30b9\u8a9e\u3001\u30de\u30ec\u30a4\u8a9e\u3001\u30bf\u30a4\u8a9e\u3001\u4e2d\u56fd\u8a9e\u53ca\u3073\u30d9\u30c8\u30ca\u30e0\u8a9e\u3068\u3044\u3063\u305f\u591a\u8a00\u8a9e\u306e\u8a9e\u5f59\u30c7\u30fc\u30bf\u30d9\u30fc\u30b9\u306e\u4f5c\u6210\u3092\u76ee\u6307\u3057\u307e\u3059\u3002\u5546\u696d\u76ee\u7684\u3067\u306f\u306a\u304f\u30aa\u30fc\u30d7\u30f3\u30bd\u30fc\u30b9\u3067\u8ab0\u3067\u3082\u7121\u6599\u3067\u5229\u7528\u3067\u304d\u307e\u3059\u3002\u4f55\u4eba\u304b\u306e\u6a5f\u68b0\u8a00\u8a9e\u5b66\u8005\u306b\u3088\u3063\u3066\u59cb\u3081\u3089\u308c\u305f\u79c1\u305f\u3061\u306e\u30d7\u30ed\u30b8\u30a7\u30af\u30c8\u306f\u3053\u308c\u3089\u306e\u8a00\u8a9e\u306b\u8208\u5473\u3092\u6301\u3063\u3066\u3044\u308b\u3059\u3079\u3066\u306e\u4eba\u3005\u306b\u3068\u3063\u3066\u6709\u52b9\u304b\u3064\u958b\u304b\u308c\u308b\u4e8b\u3092\u76ee\u6307\u3057\u3066\u3044\u307e\u3059\u3002 Papillon project aims at creating a multilingual lexical database covering among others English, French, Japanese, Lao, Tha\u00ef and Chinese. The access will be free. Our project aims at being useful and open to all those who are interested in these languages.");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("description");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Dynamically generated by Enhydra from Hand crafted XHTML documents.");
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
        
        $node4 = document.createTextNode("Dictionnaire multilingue Papillon Multilingual Dictionary \u30d1\u30d4\u30e8\u30f3\u591a\u8a00\u8a9e\u96fb\u5b50\u8f9e\u5178");
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
        
        $element_Script = (org.enhydra.xml.xhtml.dom.XHTMLScriptElement)$elem3;$node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("\n        function init() {\n\t\t\tvar resultUrlValue = document.getElementById(\"resultUrl\").value;\n\t\t\tif (resultUrlValue != '') {\n\t\t\t\tupdateParent();\n\t\t\t}\n        }\n        //");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "style");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/css");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("\n\th1 {\n\t\ttext-align: center;\n\t}\n\t");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "onload");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("javascript:init();");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("File upload");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("\n      function updateParent() {\n\t    var resultUrlValue = document.getElementById(\"resultUrl\").value;\n        opener.updateURL(window.name,resultUrlValue);\n\t    var fileNameValue = document.getElementById(\"fileName\").value;\n        opener.updateFileName(fileNameValue);\n        window.close();\n      }\n\t\t//");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "action");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("UploadFile.po");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "enctype");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("multipart/form-data");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("form");
        $attr3.appendChild($node4);
        
        $element_Form = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem3;$elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("File: ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("file");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("file");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "onchange");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("this.form.submit()");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("file");
        $attr7.appendChild($node8);
        
        $element_File = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem5.appendChild($elem6);
        
        $node6 = document.createTextNode("\n\tIt can also be gzipped or zipped.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("fileName");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("fileName");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("hidden");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $element_FileName = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode("\n\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("resultUrl");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("resultUrl");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("hidden");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $element_ResultUrl = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode("\n\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Upload");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode(" ");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(" ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("updateParent()");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("button");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Close window");
        $attr6.appendChild($node7);
        
        $node5 = document.createTextNode("\n\t");
        $elem4.appendChild($node5);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("copyright");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\u00a9 2001-2006 ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("mailto:Mathieu.MangeotATimag.fr?subject=PapillonServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Mathieu Mangeot");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" & ");
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
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new UploadFileXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>file</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementFile() {
        return $element_File;
    }

    /**
     * Get the element with id <CODE>fileName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementFileName() {
        return $element_FileName;
    }

    /**
     * Get the element with id <CODE>form</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementForm() {
        return $element_Form;
    }

    /**
     * Get the element with id <CODE>resultUrl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementResultUrl() {
        return $element_ResultUrl;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLScriptElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLScriptElement getElementScript() {
        return $element_Script;
    }

    /**
     * Get the element with id <CODE>file</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFile() {
        return $element_File;
    }

    /**
     * Get the element with id <CODE>fileName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFileName() {
        return $element_FileName;
    }

    /**
     * Get the element with id <CODE>form</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagForm() {
        return $element_Form;
    }

    /**
     * Get the element with id <CODE>resultUrl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResultUrl() {
        return $element_ResultUrl;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScript() {
        return $element_Script;
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
