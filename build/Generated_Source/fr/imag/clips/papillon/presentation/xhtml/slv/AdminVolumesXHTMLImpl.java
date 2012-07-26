/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.slv;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/slv/AdminVolumes.xhtml
 */
public class AdminVolumesXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdminVolumesXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.AdminVolumesXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Dbname;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_DictionaryOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Dictname;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Entries;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Name;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RemoveAllAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RemoveMetadataAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_SeeInterface;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeInterfaceAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeMetadataAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_SeeSchema;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeSchemaAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_SeeTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeTemplateAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Source;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_URL;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_URLObject;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_URLObjectTransformation;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplateTransformation;

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
     * Element name constant for AddVolumesAndEntries
     */
    public static final String NAME_AddVolumesAndEntries = "AddVolumesAndEntries";

    /**
     * Element name constant for Dictionary
     */
    public static final String NAME_Dictionary = "Dictionary";

    /**
     * Element name constant for LogContributions
     */
    public static final String NAME_LogContributions = "LogContributions";

    /**
     * Element name constant for Object
     */
    public static final String NAME_Object = "Object";

    /**
     * Element name constant for Transformation
     */
    public static final String NAME_Transformation = "Transformation";

    /**
     * Element name constant for URL
     */
    public static final String NAME_URL = "URL";

    /**
     * Element name constant for URLObject
     */
    public static final String NAME_URLObject = "URLObject";

    /**
     * Element name constant for URLObjectTransformation
     */
    public static final String NAME_URLObjectTransformation = "URLObjectTransformation";

    /**
     * Element name constant for Volume
     */
    public static final String NAME_Volume = "Volume";

    /**
     * Element name constant for VolumeTransformation
     */
    public static final String NAME_VolumeTransformation = "VolumeTransformation";

    /**
     * Element name constant for upload
     */
    public static final String NAME_upload = "upload";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = AdminVolumesXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/slv/AdminVolumes.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdminVolumesXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdminVolumesXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdminVolumesXHTMLImpl(AdminVolumesXHTMLImpl src) {
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
        $node4 = document.createTextNode("slv");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Gestion des Volumes XML");
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
        
        $node5 = document.createComment("\n            function updateField(idField, idFieldValue) {\n              if (idField != '') {\n                theIdField = document.getElementById(idField);\n                theIdField.value = idFieldValue;\n              }\n            }\n          \n            function openUploader(parentId) {\n              // Get the id of the elements to be modified\n              var targetUrl='UploadFile.po';\n              window.open(targetUrl, parentId,'height=200,width=300,resizable');\n            }\n          \n          // ");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AdminVolumes.po");
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
        $node6 = document.createTextNode("Upload Metadata");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $node7 = document.createComment(" Warning, make sure the option element contains a Text and only a Text (no other child) ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Dictionary:\n\t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Dictionary");
        $attr9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("DictionaryOptionTemplate");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("NONE");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("NONE");
        $attr10.appendChild($node11);
        
        $element_DictionaryOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("NONE");
        $elem10.appendChild($node11);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Fichier ou URL:");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
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
        $node9 = document.createTextNode("javascript:openUploader('URL')");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("button");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("charger");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode(" ou bien\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("URL");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("URL");
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
        
        $element_URL = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Charger aussi les entr\u00e9es: ");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("   \n    ");
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
        $node8 = document.createTextNode("2");
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
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("note");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("NB: Le fichier des m\u00e9tadonn\u00e9es du dictionnaire doit \u00eatre \u00eatre conforme \u00e0 l'\u00e9l\u00e9ment <dictionary-metadata>  du sch\u00e9ma DML. On trouvera la derni\u00e8re version du sch\u00e9ma \u00e0 l'adresse: ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://www-clips.imag.fr/geta/services/dml/dml.xsd");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("www-clips.imag.fr/geta/services/dml/dml.xsd");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(".");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AdminVolumes.po");
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
        $node6 = document.createTextNode("Upload XML File");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Glosar:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Volume");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VolumeOptionTemplate");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $element_VolumeOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("NONE");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Object:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Object");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Metadata File");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Metadata");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Fichier des m\u00e9tadonn\u00e9es");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("XML Schema");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Schema");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Sch\u00e9ma XML");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Template Entry");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Template");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Patron d'entr\u00e9e");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Interface");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Interface");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Fichier d'interface");
        $elem9.appendChild($node10);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "valign");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("top");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Fichier ou URL:");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
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
        $node9 = document.createTextNode("upload");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "onclick");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("javascript:openUploader('URLObject')");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("button");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("charger");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode(" ou bien\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("URLObject");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("URLObject");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("80");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_URLObject = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n");
        $elem7.appendChild($node8);
        
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
        $node9 = document.createTextNode("charger");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AdminVolumes.po");
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
        $node6 = document.createTextNode("Upload XML File");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Glosar:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n        ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VolumeTransformation");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("All");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("All");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Tous les volumes");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VolumeOptionTemplateTransformation");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $element_VolumeOptionTemplateTransformation = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("NONE");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n    ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "valign");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("top");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Fichier ou URL:");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("3");
        $attr7.appendChild($node8);
        
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
        $node9 = document.createTextNode("javascript:openUploader('URLObjectTransformation')");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("button");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("charger");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode(" ou bien \n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("URLObjectTransformation");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("URLObjectTransformation");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("80");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_URLObjectTransformation = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Transformation");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Lancer transformation");
        $attr6.appendChild($node7);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\nVolumes actuellement dans la base:\n");
        $elem3.appendChild($node4);
        
        buildSubDocument_0(document, $elem3);
        $node4 = document.createTextNode("\n");
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
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "summary");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("Existing Volumes");
        $attr0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Dict");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Glosar");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Table");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Srce");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Vnosi");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Sch\u00e9ma");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Patron");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Interface");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode("|");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Metadonn\u00e9es");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Tout");
        $elem2.appendChild($node3);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "id");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("TemplateRow");
        $attr1.appendChild($node2);
        
        $element_TemplateRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem1;$elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Dictname");
        $attr3.appendChild($node4);
        
        $element_Dictname = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem3;$node4 = document.createTextNode("dict");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("SeeMetadataAnchor");
        $attr3.appendChild($node4);
        
        $element_SeeMetadataAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem3;$elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Name");
        $attr5.appendChild($node6);
        
        $element_Name = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("Ime");
        $elem5.appendChild($node6);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Dbname");
        $attr3.appendChild($node4);
        
        $element_Dbname = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem3;$node4 = document.createTextNode("table");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Source");
        $attr3.appendChild($node4);
        
        $element_Source = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem3;$node4 = document.createTextNode("izvirni jezik");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "align");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("right");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Entries");
        $attr3.appendChild($node4);
        
        $element_Entries = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem3;$node4 = document.createTextNode("vnosi");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "align");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("center");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("SeeSchemaAnchor");
        $attr3.appendChild($node4);
        
        $element_SeeSchemaAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem3;$elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SeeSchema");
        $attr4.appendChild($node5);
        
        $element_SeeSchema = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("Prika\u017ei");
        $elem4.appendChild($node5);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "align");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("center");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("SeeTemplateAnchor");
        $attr3.appendChild($node4);
        
        $element_SeeTemplateAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem3;$elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SeeTemplate");
        $attr4.appendChild($node5);
        
        $element_SeeTemplate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("Prika\u017ei");
        $elem4.appendChild($node5);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "align");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("center");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("SeeInterfaceAnchor");
        $attr3.appendChild($node4);
        
        $element_SeeInterfaceAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem3;$elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SeeInterface");
        $attr4.appendChild($node5);
        
        $element_SeeInterface = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("Prika\u017ei");
        $elem4.appendChild($node5);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode("|");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "align");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("center");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("RemoveMetadataAnchor");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "onclick");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("return confirm('Etes-vous sur de vouloir supprimer les  metadonn\u00e9es?')");
        $attr3.appendChild($node4);
        
        $element_RemoveMetadataAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem3;$node4 = document.createTextNode("rm");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "align");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("center");
        $attr2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("RemoveAllAnchor");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "onclick");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("return confirm('Etes-vous sur de vouloir supprimer les  metadonn\u00e9es et les entr\u00e9es?')");
        $attr3.appendChild($node4);
        
        $element_RemoveAllAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem3;$node4 = document.createTextNode("rm");
        $elem3.appendChild($node4);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new AdminVolumesXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>Dbname</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDbname() {
        return $element_Dbname;
    }

    /**
     * Get the element with id <CODE>DictionaryOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementDictionaryOptionTemplate() {
        return $element_DictionaryOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Dictname</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDictname() {
        return $element_Dictname;
    }

    /**
     * Get the element with id <CODE>Entries</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntries() {
        return $element_Entries;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
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
     * Get the element with id <CODE>RemoveMetadataAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementRemoveMetadataAnchor() {
        return $element_RemoveMetadataAnchor;
    }

    /**
     * Get the element with id <CODE>SeeInterface</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSeeInterface() {
        return $element_SeeInterface;
    }

    /**
     * Get the element with id <CODE>SeeInterfaceAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeInterfaceAnchor() {
        return $element_SeeInterfaceAnchor;
    }

    /**
     * Get the element with id <CODE>SeeMetadataAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeMetadataAnchor() {
        return $element_SeeMetadataAnchor;
    }

    /**
     * Get the element with id <CODE>SeeSchema</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSeeSchema() {
        return $element_SeeSchema;
    }

    /**
     * Get the element with id <CODE>SeeSchemaAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeSchemaAnchor() {
        return $element_SeeSchemaAnchor;
    }

    /**
     * Get the element with id <CODE>SeeTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSeeTemplate() {
        return $element_SeeTemplate;
    }

    /**
     * Get the element with id <CODE>SeeTemplateAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeTemplateAnchor() {
        return $element_SeeTemplateAnchor;
    }

    /**
     * Get the element with id <CODE>Source</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSource() {
        return $element_Source;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>URL</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementURL() {
        return $element_URL;
    }

    /**
     * Get the element with id <CODE>URLObject</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementURLObject() {
        return $element_URLObject;
    }

    /**
     * Get the element with id <CODE>URLObjectTransformation</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementURLObjectTransformation() {
        return $element_URLObjectTransformation;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplateTransformation</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplateTransformation() {
        return $element_VolumeOptionTemplateTransformation;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementXml() {
        return $element_Xml;
    }

    /**
     * Get the element with id <CODE>Dbname</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDbname() {
        return $element_Dbname;
    }

    /**
     * Get the element with id <CODE>DictionaryOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionaryOptionTemplate() {
        return $element_DictionaryOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Dictname</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictname() {
        return $element_Dictname;
    }

    /**
     * Get the element with id <CODE>Entries</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntries() {
        return $element_Entries;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
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
     * Get the element with id <CODE>RemoveMetadataAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveMetadataAnchor() {
        return $element_RemoveMetadataAnchor;
    }

    /**
     * Get the element with id <CODE>SeeInterface</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeInterface() {
        return $element_SeeInterface;
    }

    /**
     * Get the element with id <CODE>SeeInterfaceAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeInterfaceAnchor() {
        return $element_SeeInterfaceAnchor;
    }

    /**
     * Get the element with id <CODE>SeeMetadataAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeMetadataAnchor() {
        return $element_SeeMetadataAnchor;
    }

    /**
     * Get the element with id <CODE>SeeSchema</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeSchema() {
        return $element_SeeSchema;
    }

    /**
     * Get the element with id <CODE>SeeSchemaAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeSchemaAnchor() {
        return $element_SeeSchemaAnchor;
    }

    /**
     * Get the element with id <CODE>SeeTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeTemplate() {
        return $element_SeeTemplate;
    }

    /**
     * Get the element with id <CODE>SeeTemplateAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeTemplateAnchor() {
        return $element_SeeTemplateAnchor;
    }

    /**
     * Get the element with id <CODE>Source</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSource() {
        return $element_Source;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>URL</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagURL() {
        return $element_URL;
    }

    /**
     * Get the element with id <CODE>URLObject</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagURLObject() {
        return $element_URLObject;
    }

    /**
     * Get the element with id <CODE>URLObjectTransformation</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagURLObjectTransformation() {
        return $element_URLObjectTransformation;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplateTransformation</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplateTransformation() {
        return $element_VolumeOptionTemplateTransformation;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXml() {
        return $element_Xml;
    }

    /**
     * Get the value of text child of element <CODE>Dbname</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDbname(String text) {
        doSetText($element_Dbname, text);
    }

    /**
     * Get the value of text child of element <CODE>DictionaryOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictionaryOptionTemplate(String text) {
        doSetText($element_DictionaryOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>Dictname</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictname(String text) {
        doSetText($element_Dictname, text);
    }

    /**
     * Get the value of text child of element <CODE>Entries</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntries(String text) {
        doSetText($element_Entries, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
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
     * Get the value of text child of element <CODE>RemoveMetadataAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRemoveMetadataAnchor(String text) {
        doSetText($element_RemoveMetadataAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeInterface</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeInterface(String text) {
        doSetText($element_SeeInterface, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeInterfaceAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeInterfaceAnchor(String text) {
        doSetText($element_SeeInterfaceAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeMetadataAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeMetadataAnchor(String text) {
        doSetText($element_SeeMetadataAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeSchema</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeSchema(String text) {
        doSetText($element_SeeSchema, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeSchemaAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeSchemaAnchor(String text) {
        doSetText($element_SeeSchemaAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeTemplate(String text) {
        doSetText($element_SeeTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeTemplateAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeTemplateAnchor(String text) {
        doSetText($element_SeeTemplateAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Source</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSource(String text) {
        doSetText($element_Source, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeOptionTemplate(String text) {
        doSetText($element_VolumeOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeOptionTemplateTransformation</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeOptionTemplateTransformation(String text) {
        doSetText($element_VolumeOptionTemplateTransformation, text);
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
