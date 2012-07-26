/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/AdminTmpl.xhtml
 */
public class AdminTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdminTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_AdminMessage;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_All;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_EditData;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HomeContent;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ModifiedStatus;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_NormalizeHeadword;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ReConstructionIndex;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Standardization;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    /**
     * Element name constant for AdminMessage
     */
    public static final String NAME_AdminMessage = "AdminMessage";

    /**
     * Element name constant for AdminMessageSubmit
     */
    public static final String NAME_AdminMessageSubmit = "AdminMessageSubmit";

    /**
     * Element name constant for EditData
     */
    public static final String NAME_EditData = "EditData";

    /**
     * Element name constant for Flush
     */
    public static final String NAME_Flush = "Flush";

    /**
     * Element name constant for Folder
     */
    public static final String NAME_Folder = "Folder";

    /**
     * Element name constant for ModifiedStatus
     */
    public static final String NAME_ModifiedStatus = "ModifiedStatus";

    /**
     * Element name constant for NormalizeHeadword
     */
    public static final String NAME_NormalizeHeadword = "NormalizeHeadword";

    /**
     * Element name constant for ReConstructionIndex
     */
    public static final String NAME_ReConstructionIndex = "ReConstructionIndex";

    /**
     * Element name constant for Reload
     */
    public static final String NAME_Reload = "Reload";

    /**
     * Element name constant for ResetInterfaceDescriptionCache
     */
    public static final String NAME_ResetInterfaceDescriptionCache = "ResetInterfaceDescriptionCache";

    /**
     * Element name constant for ResetLanguagesCache
     */
    public static final String NAME_ResetLanguagesCache = "ResetLanguagesCache";

    /**
     * Element name constant for ResetNewsCache
     */
    public static final String NAME_ResetNewsCache = "ResetNewsCache";

    /**
     * Element name constant for ResetXslSheetTransformersCache
     */
    public static final String NAME_ResetXslSheetTransformersCache = "ResetXslSheetTransformersCache";

    /**
     * Element name constant for SetEditData
     */
    public static final String NAME_SetEditData = "SetEditData";

    /**
     * Element name constant for Standardization
     */
    public static final String NAME_Standardization = "Standardization";

    /**
     * Element name constant for Update
     */
    public static final String NAME_Update = "Update";

    /**
     * Element name constant for VOLUME
     */
    public static final String NAME_VOLUME = "VOLUME";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = AdminTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/AdminTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdminTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdminTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdminTmplXHTMLImpl(AdminTmplXHTMLImpl src) {
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
        $node4 = document.createTextNode("HomeContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_HomeContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Managing Caches and Archives");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n \n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" Begining administration form ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Admin.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("get");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Administative Message");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "for");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("AdminMessage");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Text: ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("AdminMessage");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("AdminMessage");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text");
        $attr6.appendChild($node7);
        
        $element_AdminMessage = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem5.appendChild($elem6);
        
        $node6 = document.createTextNode("\n(will be displayed by all http responses)");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem5.appendChild($elem6);
        
        $node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("AdminMessageSubmit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Set");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Papillon mailing list archive");
        $elem5.appendChild($node6);
        
        buildSubDocument_0(document, $elem4);
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Edition Interface Description Cache");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ResetInterfaceDescriptionCache");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Reset");
        $attr8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("XslSheet transformers Cache");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ResetXslSheetTransformersCache");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Reset");
        $attr8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Languages Cache");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ResetLanguagesCache");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Reset");
        $attr8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem4.appendChild($elem5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("News Cache");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ResetNewsCache");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Reset");
        $attr8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem4.appendChild($elem5);
        
        $node5 = document.createComment("h3 style=\"text-align:center\">HTML DOM Caches</h3>\n<table width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" summary=\"Formulaire\">\n  <tr>\n    <td><b>&nbsp;Action:</b></td> \n    <td><label for=\"HTMLDomCaches\">Cache activated:</label>\n\t<input id=\"HTMLDomCaches\" name=\"HTMLDomCaches\" type=\"checkbox\" value=\"HTMLDomCaches\"/>\n\t\t&nbsp;&nbsp;\n\t\t<input name=\"SetHTMLDomCaches\" type=\"submit\" value=\"Validate\"/>\n\t</td> \n  </tr>\n</table>\n<hr/");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("text-align:center");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Data edition");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "for");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EditData");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Edition activated:");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EditData");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EditData");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("checkbox");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EditData");
        $attr8.appendChild($node9);
        
        $element_EditData = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("SetEditData");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Validate");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem4.appendChild($elem5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("text-align:center");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Index");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Volumes:");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUME");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("all");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("all");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("*all*");
        $attr9.appendChild($node10);
        
        $element_All = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("all");
        $elem9.appendChild($node10);
        
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
        
        $node8 = document.createTextNode("\n\t\t ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReConstructionIndex");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReConstructionIndex");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReConstruction");
        $attr8.appendChild($node9);
        
        $element_ReConstructionIndex = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("text-align:center");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Status");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ModifiedStatus");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ModifiedStatus");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ModifiedStatus");
        $attr8.appendChild($node9);
        
        $element_ModifiedStatus = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("text-align:center");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Standardization");
        $elem5.appendChild($node6);
        
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Standardization");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Standardization");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Standardization");
        $attr8.appendChild($node9);
        
        $element_Standardization = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode("Action:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NormalizeHeadword");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NormalizeHeadword");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NormalizeHeadword");
        $attr8.appendChild($node9);
        
        $element_NormalizeHeadword = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5;
        Element $elem0, $elem1, $elem2, $elem3;
        Attr $attr0, $attr1, $attr2, $attr3;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "border");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("0");
        $attr0.appendChild($node1);
        
        $attr0 = document.createAttributeNS("", "cellpadding");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("0");
        $attr0.appendChild($node1);
        
        $attr0 = document.createAttributeNS("", "cellspacing");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("0");
        $attr0.appendChild($node1);
        
        $attr0 = document.createAttributeNS("", "summary");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("Formulaire");
        $attr0.appendChild($node1);
        
        $attr0 = document.createAttributeNS("", "width");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("600");
        $attr0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Folder:");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Folder");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "size");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("64");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("");
        $attr3.appendChild($node4);
        
        $node1 = document.createComment("  <TR>\n    <TD WIDTH=\"25%\"><B>Database URL&nbsp;:<br/>(not available)</B></TD> \n    <TD WIDTH=\"75\"><INPUT NAME=\"DbUrl\" TYPE=\"text\" SIZE=\"64\" VALUE=\"\"></TD> \n  </TR>");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem2.appendChild($elem3);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $node4 = document.createTextNode("Action:");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("\n\t");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Flush");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("submit");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Flush");
        $attr3.appendChild($node4);
        
        $node3 = document.createTextNode("\n\t");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode("\n\t");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Update");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("submit");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Update");
        $attr3.appendChild($node4);
        
        $node3 = document.createTextNode("\n\t");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode("\n     \t");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Reload");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("submit");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Flush & Reload");
        $attr3.appendChild($node4);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new AdminTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>AdminMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAdminMessage() {
        return $element_AdminMessage;
    }

    /**
     * Get the element with id <CODE>all</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementAll() {
        return $element_All;
    }

    /**
     * Get the element with id <CODE>EditData</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementEditData() {
        return $element_EditData;
    }

    /**
     * Get the element with id <CODE>HomeContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementHomeContent() {
        return $element_HomeContent;
    }

    /**
     * Get the element with id <CODE>ModifiedStatus</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementModifiedStatus() {
        return $element_ModifiedStatus;
    }

    /**
     * Get the element with id <CODE>NormalizeHeadword</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementNormalizeHeadword() {
        return $element_NormalizeHeadword;
    }

    /**
     * Get the element with id <CODE>ReConstructionIndex</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementReConstructionIndex() {
        return $element_ReConstructionIndex;
    }

    /**
     * Get the element with id <CODE>Standardization</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementStandardization() {
        return $element_Standardization;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>AdminMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAdminMessage() {
        return $element_AdminMessage;
    }

    /**
     * Get the element with id <CODE>all</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAll() {
        return $element_All;
    }

    /**
     * Get the element with id <CODE>EditData</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditData() {
        return $element_EditData;
    }

    /**
     * Get the element with id <CODE>HomeContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHomeContent() {
        return $element_HomeContent;
    }

    /**
     * Get the element with id <CODE>ModifiedStatus</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagModifiedStatus() {
        return $element_ModifiedStatus;
    }

    /**
     * Get the element with id <CODE>NormalizeHeadword</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNormalizeHeadword() {
        return $element_NormalizeHeadword;
    }

    /**
     * Get the element with id <CODE>ReConstructionIndex</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReConstructionIndex() {
        return $element_ReConstructionIndex;
    }

    /**
     * Get the element with id <CODE>Standardization</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStandardization() {
        return $element_Standardization;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>all</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAll(String text) {
        doSetText($element_All, text);
    }

    /**
     * Get the value of text child of element <CODE>HomeContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHomeContent(String text) {
        doSetText($element_HomeContent, text);
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
