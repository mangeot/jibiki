/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.fra;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/fra/AdminDictionaries.xhtml
 */
public class AdminDictionariesXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdminDictionariesXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.AdminDictionariesXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Category;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Domain;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Legal;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Name;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RemoveAllAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RemoveAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Sources;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Targets;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Type;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Url;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Xml;

    /**
     * Class attribute constant for element class note
     */
    public static final String CLASS_note = "note";

    /**
     * Element name constant for Add
     */
    public static final String NAME_Add = "Add";

    /**
     * Element name constant for AddVolumes
     */
    public static final String NAME_AddVolumes = "AddVolumes";

    /**
     * Element name constant for AddVolumesAndEntries
     */
    public static final String NAME_AddVolumesAndEntries = "AddVolumesAndEntries";

    /**
     * Element name constant for LogContributions
     */
    public static final String NAME_LogContributions = "LogContributions";

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
    public static final Class XMLC_GENERATED_CLASS = AdminDictionariesXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/fra/AdminDictionaries.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdminDictionariesXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdminDictionariesXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdminDictionariesXHTMLImpl(AdminDictionariesXHTMLImpl src) {
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
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n    ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Gestion des dictionnaires XML");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text/javascript");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n    ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment("\n            function updateField(idField, idFieldValue) {\n              if (idField != '') {\n                theIdField = document.getElementById(idField);\n                theIdField.value = idFieldValue;\n              }\n            }\n          \n            function openUploader(parentId) {\n              // Get the id of the elements to be modified\n              var targetUrl='UploadFile.po';\n              window.open(targetUrl, parentId,'height=200,width=300,resizable');\n            }\n          \n          // ");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" formulaire de voir mot");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AdminDictionaries.po");
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
        $node6 = document.createTextNode("Formulaire");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("3");
        $attr7.appendChild($node8);
        
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
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
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
        $node9 = document.createTextNode("charger");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode(" \n\tou bien ");
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
        $node9 = document.createTextNode("64");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_Url = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("note");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("NB: Le fichier des m\u00e9tadonn\u00e9es du dictionnaire doit \u00eatre \u00eatre conforme \u00e0 l'\u00e9l\u00e9ment <dictionary-metadata>  du sch\u00e9ma DML. On trouvera la derni\u00e8re version du sch\u00e9ma \u00e0 l'adresse: ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "href");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("http://www-clips.imag.fr/geta/services/dml/dml.xsd");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("www-clips.imag.fr/geta/services/dml/dml.xsd");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode(".");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Charger aussi les volumes des m\u00e9tadonn\u00e9es:");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("    \n    ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("AddVolumes");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("checkbox");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Load volumes");
        $attr9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Charger aussi les volumes des m\u00e9tadonn\u00e9es and Entries:");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("     \n    ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("AddVolumesAndEntries");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("checkbox");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Charger les volumes et les entr\u00e9es");
        $attr9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Log les contributions: ");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("\n    ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("LogContributions");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("checkbox");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("LogContributions");
        $attr9.appendChild($node10);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("3");
        $attr7.appendChild($node8);
        
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
        
        $node4 = document.createTextNode("\n\nDictionnaires actuellement dans la base:\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Existing Dictionaries");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("nom");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("cat\u00e9gorie");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("type");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("sources");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("cibles");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("domaine");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("mentions l\u00e9gales");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Metadonn\u00e9es");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("|");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Metadonn\u00e9es");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Tout");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("TemplateRow");
        $attr5.appendChild($node6);
        
        $element_TemplateRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Name");
        $attr8.appendChild($node9);
        
        $element_Name = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Nom");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Category");
        $attr7.appendChild($node8);
        
        $element_Category = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Cat");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Type");
        $attr7.appendChild($node8);
        
        $element_Type = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Type");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Sources");
        $attr7.appendChild($node8);
        
        $element_Sources = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Srce");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Targets");
        $attr7.appendChild($node8);
        
        $element_Targets = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Cible");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Domain");
        $attr7.appendChild($node8);
        
        $element_Domain = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("domaine");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Legal");
        $attr7.appendChild($node8);
        
        $element_Legal = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("mentions l\u00e9gales");
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
        $node8 = document.createTextNode("SeeAnchor");
        $attr7.appendChild($node8);
        
        $element_SeeAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Voir");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("|");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
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
        $node8 = document.createTextNode("RemoveAnchor");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "onclick");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("return confirm('Etes-vous s\u00fbr de vouloir supprimer les m\u00e9tadonn\u00e9es?')");
        $attr7.appendChild($node8);
        
        $element_RemoveAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("rm");
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
        $node8 = document.createTextNode("RemoveAllAnchor");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "onclick");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("return confirm('Etes-vous s\u00fbr de vouloir supprimer les m\u00e9tadonn\u00e9es et les entr\u00e9es?')");
        $attr7.appendChild($node8);
        
        $element_RemoveAllAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("rm");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode(" \n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Xml");
        $attr5.appendChild($node6);
        
        $element_Xml = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n");
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
        return new AdminDictionariesXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>Category</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCategory() {
        return $element_Category;
    }

    /**
     * Get the element with id <CODE>Domain</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDomain() {
        return $element_Domain;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Legal</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLegal() {
        return $element_Legal;
    }

    /**
     * Get the element with id <CODE>Name</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementName() {
        return $element_Name;
    }

    /**
     * Get the element with id <CODE>RemoveAllAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementRemoveAllAnchor() {
        return $element_RemoveAllAnchor;
    }

    /**
     * Get the element with id <CODE>RemoveAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementRemoveAnchor() {
        return $element_RemoveAnchor;
    }

    /**
     * Get the element with id <CODE>SeeAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeAnchor() {
        return $element_SeeAnchor;
    }

    /**
     * Get the element with id <CODE>Sources</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSources() {
        return $element_Sources;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>Type</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementType() {
        return $element_Type;
    }

    /**
     * Get the element with id <CODE>url</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementUrl() {
        return $element_Url;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementXml() {
        return $element_Xml;
    }

    /**
     * Get the element with id <CODE>Category</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCategory() {
        return $element_Category;
    }

    /**
     * Get the element with id <CODE>Domain</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDomain() {
        return $element_Domain;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Legal</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLegal() {
        return $element_Legal;
    }

    /**
     * Get the element with id <CODE>Name</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagName() {
        return $element_Name;
    }

    /**
     * Get the element with id <CODE>RemoveAllAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveAllAnchor() {
        return $element_RemoveAllAnchor;
    }

    /**
     * Get the element with id <CODE>RemoveAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveAnchor() {
        return $element_RemoveAnchor;
    }

    /**
     * Get the element with id <CODE>SeeAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeAnchor() {
        return $element_SeeAnchor;
    }

    /**
     * Get the element with id <CODE>Sources</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSources() {
        return $element_Sources;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>Type</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagType() {
        return $element_Type;
    }

    /**
     * Get the element with id <CODE>url</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUrl() {
        return $element_Url;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXml() {
        return $element_Xml;
    }

    /**
     * Get the value of text child of element <CODE>Category</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCategory(String text) {
        doSetText($element_Category, text);
    }

    /**
     * Get the value of text child of element <CODE>Domain</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDomain(String text) {
        doSetText($element_Domain, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>Legal</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLegal(String text) {
        doSetText($element_Legal, text);
    }

    /**
     * Get the value of text child of element <CODE>Name</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextName(String text) {
        doSetText($element_Name, text);
    }

    /**
     * Get the value of text child of element <CODE>RemoveAllAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRemoveAllAnchor(String text) {
        doSetText($element_RemoveAllAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>RemoveAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRemoveAnchor(String text) {
        doSetText($element_RemoveAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeAnchor(String text) {
        doSetText($element_SeeAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Sources</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSources(String text) {
        doSetText($element_Sources, text);
    }

    /**
     * Get the value of text child of element <CODE>Targets</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargets(String text) {
        doSetText($element_Targets, text);
    }

    /**
     * Get the value of text child of element <CODE>Type</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextType(String text) {
        doSetText($element_Type, text);
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
