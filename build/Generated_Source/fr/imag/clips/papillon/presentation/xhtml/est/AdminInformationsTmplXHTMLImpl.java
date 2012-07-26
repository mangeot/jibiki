/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.est;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/est/AdminInformationsTmpl.xhtml
 */
public class AdminInformationsTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdminInformationsTmplXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.AdminInformationsTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Author;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_DocumentAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DocumentAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DocumentDate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DocumentReference;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DocumentTitle;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_LanguageTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_NBSpace;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_OptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RemoveAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ReplaceButton;

    private org.enhydra.xml.xhtml.dom.XHTMLScriptElement $element_Script;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Title;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Url;

    /**
     * Element name constant for Add
     */
    public static final String NAME_Add = "Add";

    /**
     * Element name constant for Reference
     */
    public static final String NAME_Reference = "Reference";

    /**
     * Element name constant for Replace
     */
    public static final String NAME_Replace = "Replace";

    /**
     * Element name constant for ReplaceButton
     */
    public static final String NAME_ReplaceButton = "ReplaceButton";

    /**
     * Element name constant for author
     */
    public static final String NAME_author = "author";

    /**
     * Element name constant for date
     */
    public static final String NAME_date = "date";

    /**
     * Element name constant for language
     */
    public static final String NAME_language = "language";

    /**
     * Element name constant for section
     */
    public static final String NAME_section = "section";

    /**
     * Element name constant for title
     */
    public static final String NAME_title = "title";

    /**
     * Element name constant for upload
     */
    public static final String NAME_upload = "upload";

    /**
     * Element name constant for url
     */
    public static final String NAME_url = "url";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = AdminInformationsTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/est/AdminInformationsTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdminInformationsTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdminInformationsTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdminInformationsTmplXHTMLImpl(AdminInformationsTmplXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9, $node10;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9;
        
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
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Administration des documents d'information");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text/javascript");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n    ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment("\n            function updateURL (theID, theURL) {\n\t\t\t\tdocument.getElementById(theID).value = theURL;\n\t\t\t}\n            function updateFileName (theFileName) {\n\t\t\t\tif (theFileName.lastIndexOf('.')>0) {\n\t\t\t\t\ttheFileName = theFileName.substring(0,theFileName.lastIndexOf('.'));\n\t\t\t\t}\n\t\t\t\tdocument.getElementById('title').value = theFileName;\n\t\t\t}\n          \n            function openUploader(parentId) {\n              // Get the id of the elements to be modified\n              var targetUrl='UploadSimpleFile.po';\n              window.open(targetUrl, parentId,'height=200,width=300,resizable');\n            }\n          \n          // ");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $node5 = document.createEntityReference("nbsp");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00a0");
        $node5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ImportHelp.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Aide");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("form enctype=\"multipart/form-data\" action=\"AdminInformations.po\" method=\"post\" accept-charset=\"UTF-8\"");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AdminInformations.po");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellspacing");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("5");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("File attributes");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Fichier ou URL");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("upload");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "onclick");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("javascript:openUploader('url')");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("button");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("upload");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode(" or ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("url");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("url");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("60");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_Url = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n        ");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Auteur");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("author");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("author");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("30");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_Author = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Section");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $node7 = document.createComment(" Warning, make sure the option element contains a Text and only a Text (no other child) ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("section");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("OptionTemplate");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $element_OptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("NONE");
        $elem9.appendChild($node10);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Titre");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("* ");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("title");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("title");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("30");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_Title = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Langue");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("* ");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("language");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Choisissez...");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Choisissez...");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("LanguageTemplate");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $element_LanguageTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("NONE");
        $elem9.appendChild($node10);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Date de cr\u00e9ation (jj/mm/aaaa)");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("date");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("15");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("R\u00e9f\u00e9rence");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Reference");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("30");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("* : n\u00e9cessaire uniquement pour les documents monolingues sans le fichier de description d'archive ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("info_doc.xml");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellspacing");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("5");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Form options and action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Add");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ajouter");
        $attr8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("    \n    ");
        $elem7.appendChild($node8);
        
        $node5 = document.createComment(" <INPUT NAME=\"Remove\" TYPE=\"submit\" VALUE=\"Remove\"> ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment(" <FORM ACTION=\"AdminInformations.po\" METHOD=\"GET\">\n\tFlush all Files in the database: <INPUT NAME=\"Flush\" TYPE=\"submit\" VALUE=\"Flush\">\n</FORM> \n<HR> ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Documents stock\u00e9s dans la base de donn\u00e9es");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(":");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Replace");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Existing Documents");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Titre");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Auteur");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Date");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("R\u00e9f\u00e9rence");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("TemplateRow");
        $attr6.appendChild($node7);
        
        $element_TemplateRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("see");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DocumentAnchor");
        $attr8.appendChild($node9);
        
        $element_DocumentAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("DocumentTitle");
        $attr9.appendChild($node10);
        
        $element_DocumentTitle = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("TITLE");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NBSpace");
        $attr8.appendChild($node9);
        
        $element_NBSpace = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DocumentAuthor");
        $attr8.appendChild($node9);
        
        $element_DocumentAuthor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("AUTHOR");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DocumentDate");
        $attr8.appendChild($node9);
        
        $element_DocumentDate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("DATE");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DocumentReference");
        $attr8.appendChild($node9);
        
        $element_DocumentReference = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("REFERENCE");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReplaceButton");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReplaceButton");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Remplacer");
        $attr8.appendChild($node9);
        
        $element_ReplaceButton = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("RemoveAnchor");
        $attr8.appendChild($node9);
        
        $element_RemoveAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Supprimer");
        $elem8.appendChild($node9);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new AdminInformationsTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>author</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAuthor() {
        return $element_Author;
    }

    /**
     * Get the element with id <CODE>DocumentAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementDocumentAnchor() {
        return $element_DocumentAnchor;
    }

    /**
     * Get the element with id <CODE>DocumentAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDocumentAuthor() {
        return $element_DocumentAuthor;
    }

    /**
     * Get the element with id <CODE>DocumentDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDocumentDate() {
        return $element_DocumentDate;
    }

    /**
     * Get the element with id <CODE>DocumentReference</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDocumentReference() {
        return $element_DocumentReference;
    }

    /**
     * Get the element with id <CODE>DocumentTitle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDocumentTitle() {
        return $element_DocumentTitle;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>LanguageTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementLanguageTemplate() {
        return $element_LanguageTemplate;
    }

    /**
     * Get the element with id <CODE>NBSpace</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementNBSpace() {
        return $element_NBSpace;
    }

    /**
     * Get the element with id <CODE>OptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementOptionTemplate() {
        return $element_OptionTemplate;
    }

    /**
     * Get the element with id <CODE>RemoveAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementRemoveAnchor() {
        return $element_RemoveAnchor;
    }

    /**
     * Get the element with id <CODE>ReplaceButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementReplaceButton() {
        return $element_ReplaceButton;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLScriptElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLScriptElement getElementScript() {
        return $element_Script;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>title</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementTitle() {
        return $element_Title;
    }

    /**
     * Get the element with id <CODE>url</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementUrl() {
        return $element_Url;
    }

    /**
     * Get the element with id <CODE>author</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthor() {
        return $element_Author;
    }

    /**
     * Get the element with id <CODE>DocumentAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentAnchor() {
        return $element_DocumentAnchor;
    }

    /**
     * Get the element with id <CODE>DocumentAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentAuthor() {
        return $element_DocumentAuthor;
    }

    /**
     * Get the element with id <CODE>DocumentDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentDate() {
        return $element_DocumentDate;
    }

    /**
     * Get the element with id <CODE>DocumentReference</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentReference() {
        return $element_DocumentReference;
    }

    /**
     * Get the element with id <CODE>DocumentTitle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentTitle() {
        return $element_DocumentTitle;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>LanguageTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLanguageTemplate() {
        return $element_LanguageTemplate;
    }

    /**
     * Get the element with id <CODE>NBSpace</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNBSpace() {
        return $element_NBSpace;
    }

    /**
     * Get the element with id <CODE>OptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOptionTemplate() {
        return $element_OptionTemplate;
    }

    /**
     * Get the element with id <CODE>RemoveAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveAnchor() {
        return $element_RemoveAnchor;
    }

    /**
     * Get the element with id <CODE>ReplaceButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReplaceButton() {
        return $element_ReplaceButton;
    }

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScript() {
        return $element_Script;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>title</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTitle() {
        return $element_Title;
    }

    /**
     * Get the element with id <CODE>url</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUrl() {
        return $element_Url;
    }

    /**
     * Get the value of text child of element <CODE>DocumentAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentAnchor(String text) {
        doSetText($element_DocumentAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>DocumentAuthor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentAuthor(String text) {
        doSetText($element_DocumentAuthor, text);
    }

    /**
     * Get the value of text child of element <CODE>DocumentDate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentDate(String text) {
        doSetText($element_DocumentDate, text);
    }

    /**
     * Get the value of text child of element <CODE>DocumentReference</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentReference(String text) {
        doSetText($element_DocumentReference, text);
    }

    /**
     * Get the value of text child of element <CODE>DocumentTitle</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentTitle(String text) {
        doSetText($element_DocumentTitle, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>LanguageTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLanguageTemplate(String text) {
        doSetText($element_LanguageTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>NBSpace</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNBSpace(String text) {
        doSetText($element_NBSpace, text);
    }

    /**
     * Get the value of text child of element <CODE>OptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextOptionTemplate(String text) {
        doSetText($element_OptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>RemoveAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRemoveAnchor(String text) {
        doSetText($element_RemoveAnchor, text);
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
