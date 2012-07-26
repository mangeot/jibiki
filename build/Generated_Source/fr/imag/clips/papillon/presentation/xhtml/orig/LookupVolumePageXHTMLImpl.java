/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/LookupVolumePage.xhtml
 */
public class LookupVolumePageXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements LookupVolumePageXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_BrowseVolumeTable;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Central;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Copyright;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Entete;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_HEADWORD;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LIMIT;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Leftmenu;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Lift;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Milieu;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ProjectDescription;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_STATUS;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_VOLUME;

    private org.enhydra.xml.xhtml.dom.XHTMLLabelElement $element_VolumeLabel;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    /**
     * Class attribute constant for element class accesskey
     */
    public static final String CLASS_accesskey = "accesskey";

    /**
     * Class attribute constant for element class gray
     */
    public static final String CLASS_gray = "gray";

    /**
     * Element name constant for HEADWORD
     */
    public static final String NAME_HEADWORD = "HEADWORD";

    /**
     * Element name constant for LIMIT
     */
    public static final String NAME_LIMIT = "LIMIT";

    /**
     * Element name constant for STATUS
     */
    public static final String NAME_STATUS = "STATUS";

    /**
     * Element name constant for VOLUME
     */
    public static final String NAME_VOLUME = "VOLUME";

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
    public static final Class XMLC_GENERATED_CLASS = LookupVolumePageXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/LookupVolumePage.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public LookupVolumePageXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public LookupVolumePageXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public LookupVolumePageXHTMLImpl(LookupVolumePageXHTMLImpl src) {
        setDocument((Document)src.getDocument().cloneNode(true), src.getMIMEType(), src.getEncoding());
        syncAccessMethods();
    }

    /**
     * Create document as a DOM and initialize accessor method fields.
     */
    public void buildDocument() {
        org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl document = buildSubDocument();
        setDocument(document,"application/xhtml+xml", "UTF-8");
        
    }

    /**
     * Create a subtree of the document.
     */
    private org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl buildSubDocument() {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9, $node10, $node11, $node12;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9, $elem10, $elem11;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9, $attr10, $attr11;
        
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
        $node4 = document.createTextNode("content-type");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Mathieu MANGEOT");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("author");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Projet Papillon");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("keywords");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Projet Papillon");
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
        
        $node4 = document.createTextNode("Projet Papillon");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "link");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("css/papillon-home.css");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "rel");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("stylesheet");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/css");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "link");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("css/lookupVolume.css");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "rel");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("stylesheet");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/css");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "src");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("javascript/LookupVolume.js");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("entete");
        $attr3.appendChild($node4);
        
        $element_Entete = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n  \t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Le projet Papillon");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n  ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("milieu");
        $attr3.appendChild($node4);
        
        $element_Milieu = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n   ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("leftmenu");
        $attr4.appendChild($node5);
        
        $element_Leftmenu = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n    ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("BrowseVolumeTable");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Volume tri\u00e9 par odre alphab\u00e9tique");
        $attr5.appendChild($node6);
        
        $element_BrowseVolumeTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("LIMIT");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("LIMIT");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("hidden");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("30");
        $attr9.appendChild($node10);
        
        $element_LIMIT = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("STATUS");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("STATUS");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("hidden");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("validated");
        $attr9.appendChild($node10);
        
        $element_STATUS = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n\t\t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "accesskey");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("v");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VOLUME");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VolumeLabel");
        $attr9.appendChild($node10);
        
        $element_VolumeLabel = (org.enhydra.xml.xhtml.dom.XHTMLLabelElement)$elem9;$elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "class");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("accesskey");
        $attr10.appendChild($node11);
        
        $node11 = document.createTextNode("V");
        $elem10.appendChild($node11);
        
        $node10 = document.createTextNode("olume:\n    \t\t");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("VOLUME");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "name");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("VOLUME");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "title");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("s\u00e9lectionner le volume [v]");
        $attr10.appendChild($node11);
        
        $element_VOLUME = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem10;$elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("VolumeOptionTemplate");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "label");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("tmpl");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "value");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("tmpl");
        $attr11.appendChild($node12);
        
        $element_VolumeOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem11;$node12 = document.createTextNode("tmpl");
        $elem11.appendChild($node12);
        
        $node10 = document.createTextNode("\n\t\t\t");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem9.appendChild($elem10);
        
        $node10 = document.createTextNode("\n\t\t\t");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "accesskey");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("r");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("HEADWORD");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("HEADWORD");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "title");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Rechercher dans la base Papillon [r]");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("text");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $element_HEADWORD = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "onclick");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("makeFirstRequests()");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("button");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Recherche");
        $attr9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem8.appendChild($elem9);
        
        $node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "accesskey");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("p");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "onclick");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("increaseTable('up')");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "title");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Articles pr\u00e9c\u00e9dents dans l'ordre alphab\u00e9tique [p]");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("button");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("\u2191");
        $attr9.appendChild($node10);
        
        $node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "accesskey");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("s");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "onclick");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("increaseTable('down')");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "title");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Articles suivants dans l'ordre alphab\u00e9tique [s]");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("button");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("\u2193");
        $attr9.appendChild($node10);
        
        $node9 = document.createTextNode("\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n    \t\t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("lift");
        $attr9.appendChild($node10);
        
        $element_Lift = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem9;$node9 = document.createTextNode("\n \t\t\t");
        $elem8.appendChild($node9);
        
        $node5 = document.createTextNode("\n  ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n  ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("central");
        $attr4.appendChild($node5);
        
        $element_Central = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n       ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ProjectDescription");
        $attr5.appendChild($node6);
        
        $element_ProjectDescription = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("fr");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("fr");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Le projet ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("gray");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Papillon");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ja");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ja");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("gray");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\u30d1\u30d4\u30e8\u30f3");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\u8f9e\u66f8");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("en");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("en");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("The ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("gray");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Papillon");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode(" project");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("zh-Hans");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("zh-Hans");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("gray");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\u5f69 \u8776");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode(" \u8bcd \u5178");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("de");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("de");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Das ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("gray");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Papillon");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("-Projekt");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n      ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n    ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n  ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("copyright");
        $attr3.appendChild($node4);
        
        $element_Copyright = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\u00a9 2001-2007 ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("mailto:Mathieu.MangeotATimag.fr?subject=GDEFServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Mathieu Mangeot");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" \n  & ");
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
        return new LookupVolumePageXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>BrowseVolumeTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementBrowseVolumeTable() {
        return $element_BrowseVolumeTable;
    }

    /**
     * Get the element with id <CODE>central</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementCentral() {
        return $element_Central;
    }

    /**
     * Get the element with id <CODE>copyright</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementCopyright() {
        return $element_Copyright;
    }

    /**
     * Get the element with id <CODE>entete</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementEntete() {
        return $element_Entete;
    }

    /**
     * Get the element with id <CODE>HEADWORD</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementHEADWORD() {
        return $element_HEADWORD;
    }

    /**
     * Get the element with id <CODE>LIMIT</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLIMIT() {
        return $element_LIMIT;
    }

    /**
     * Get the element with id <CODE>leftmenu</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementLeftmenu() {
        return $element_Leftmenu;
    }

    /**
     * Get the element with id <CODE>lift</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementLift() {
        return $element_Lift;
    }

    /**
     * Get the element with id <CODE>milieu</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementMilieu() {
        return $element_Milieu;
    }

    /**
     * Get the element with id <CODE>ProjectDescription</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementProjectDescription() {
        return $element_ProjectDescription;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSTATUS() {
        return $element_STATUS;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeLabel</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLLabelElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLLabelElement getElementVolumeLabel() {
        return $element_VolumeLabel;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>BrowseVolumeTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagBrowseVolumeTable() {
        return $element_BrowseVolumeTable;
    }

    /**
     * Get the element with id <CODE>central</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCentral() {
        return $element_Central;
    }

    /**
     * Get the element with id <CODE>copyright</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCopyright() {
        return $element_Copyright;
    }

    /**
     * Get the element with id <CODE>entete</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntete() {
        return $element_Entete;
    }

    /**
     * Get the element with id <CODE>HEADWORD</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHEADWORD() {
        return $element_HEADWORD;
    }

    /**
     * Get the element with id <CODE>LIMIT</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLIMIT() {
        return $element_LIMIT;
    }

    /**
     * Get the element with id <CODE>leftmenu</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLeftmenu() {
        return $element_Leftmenu;
    }

    /**
     * Get the element with id <CODE>lift</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLift() {
        return $element_Lift;
    }

    /**
     * Get the element with id <CODE>milieu</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMilieu() {
        return $element_Milieu;
    }

    /**
     * Get the element with id <CODE>ProjectDescription</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagProjectDescription() {
        return $element_ProjectDescription;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSTATUS() {
        return $element_STATUS;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeLabel</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeLabel() {
        return $element_VolumeLabel;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>central</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCentral(String text) {
        doSetText($element_Central, text);
    }

    /**
     * Get the value of text child of element <CODE>copyright</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCopyright(String text) {
        doSetText($element_Copyright, text);
    }

    /**
     * Get the value of text child of element <CODE>entete</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntete(String text) {
        doSetText($element_Entete, text);
    }

    /**
     * Get the value of text child of element <CODE>leftmenu</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLeftmenu(String text) {
        doSetText($element_Leftmenu, text);
    }

    /**
     * Get the value of text child of element <CODE>lift</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLift(String text) {
        doSetText($element_Lift, text);
    }

    /**
     * Get the value of text child of element <CODE>milieu</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMilieu(String text) {
        doSetText($element_Milieu, text);
    }

    /**
     * Get the value of text child of element <CODE>ProjectDescription</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextProjectDescription(String text) {
        doSetText($element_ProjectDescription, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeLabel</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeLabel(String text) {
        doSetText($element_VolumeLabel, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeOptionTemplate(String text) {
        doSetText($element_VolumeOptionTemplate, text);
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
