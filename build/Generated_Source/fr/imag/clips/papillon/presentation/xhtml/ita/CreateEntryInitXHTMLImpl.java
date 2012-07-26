/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.ita;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/ita/CreateEntryInit.xhtml
 */
public class CreateEntryInitXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements CreateEntryInitXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.CreateEntryInitXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Action;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_CreateAnywayButton;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_CreateAnywayForm;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_CreateButton;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_EditEntryInitContent;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Facet;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_GO;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_HEADWORD_ANYWAY;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_HEADWORD_DISABLED;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_HEADWORD_FINAL;

    private org.enhydra.xml.xhtml.dom.XHTMLScriptElement $element_InitJavascript;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Limit;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_LookupForm;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Offset;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Operator;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryCreateForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ShowCreation;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_SourceLang;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Targets;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserName;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_VOLUME;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_VOLUME_ANYWAY;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_VOLUME_DISABLED;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_VOLUME_FINAL;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ValueField;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Xsl;

    /**
     * Class attribute constant for element class QueryForm
     */
    public static final String CLASS_QueryForm = "QueryForm";

    /**
     * Class attribute constant for element class hidden
     */
    public static final String CLASS_hidden = "hidden";

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Element name constant for GO
     */
    public static final String NAME_GO = "GO";

    /**
     * Element name constant for HEADWORD_ANYWAY
     */
    public static final String NAME_HEADWORD_ANYWAY = "HEADWORD_ANYWAY";

    /**
     * Element name constant for HEADWORD_DISABLED
     */
    public static final String NAME_HEADWORD_DISABLED = "HEADWORD_DISABLED";

    /**
     * Element name constant for NB_RESULT_PER_PAGE
     */
    public static final String NAME_NB_RESULT_PER_PAGE = "NB_RESULT_PER_PAGE";

    /**
     * Element name constant for OFFSET
     */
    public static final String NAME_OFFSET = "OFFSET";

    /**
     * Element name constant for TARGETS
     */
    public static final String NAME_TARGETS = "TARGETS";

    /**
     * Element name constant for VOLUME
     */
    public static final String NAME_VOLUME = "VOLUME";

    /**
     * Element name constant for VOLUME_ANYWAY
     */
    public static final String NAME_VOLUME_ANYWAY = "VOLUME_ANYWAY";

    /**
     * Element name constant for VOLUME_DISABLED
     */
    public static final String NAME_VOLUME_DISABLED = "VOLUME_DISABLED";

    /**
     * Element name constant for XSL
     */
    public static final String NAME_XSL = "XSL";

    /**
     * Element name constant for action
     */
    public static final String NAME_action = "action";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = CreateEntryInitXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/ita/CreateEntryInit.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public CreateEntryInitXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public CreateEntryInitXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public CreateEntryInitXHTMLImpl(CreateEntryInitXHTMLImpl src) {
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
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "head");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/html; charset=utf-8");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "http-equiv");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("content-type");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Edition of Papillon Lexical Database");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("EditEntryInitContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_EditEntryInitContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode(" \n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("title");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("interfaccia di creazione nuove schede di ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UserName");
        $attr5.appendChild($node6);
        
        $element_UserName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("Name");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n         ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("InitJavascript");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text/javascript");
        $attr4.appendChild($node5);
        
        $element_InitJavascript = (org.enhydra.xml.xhtml.dom.XHTMLScriptElement)$elem4;$node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment(" \n                // Open a new interface window to create the new entry \n                function init() {\n                    if (document.getElementById('GO').value == 'go') {\n                        var volumeanyway = document.getElementById('VOLUME_ANYWAY');\n                        var headwordanyway = document.getElementById('HEADWORD_ANYWAY');\n                        var href = 'CreateEntryInit.po?action=createAnyway&volumeanyway=' + encodeURI(volumeanyway.value) + '&headwordanyway=' +  encodeURI(headwordanyway.value);\n                        window.open(href,'EditEntry');\n                    }\n                }\n                \n                 // Open a new interface window to create the new entry \n                function createAnyway() {\n                    var volumeanyway = document.getElementById('VOLUME_ANYWAY');\n                    var headwordanyway = document.getElementById('HEADWORD_ANYWAY');\n                    var href = 'CreateEntryInit.po?action=showAndCreate&volumeanyway=' + encodeURI(volumeanyway.value) + '&headwordanyway=' +  encodeURI(headwordanyway.value);\n                    location.replace(href,'CreateEntry');\n                }\n\n                function create() {\n                    var actionElement = document.getElementById('action');\n                    var formElement = document.getElementById('LookupForm');\n                    actionElement.value='create';\n                    formElement.submit()\n                }\n            //");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center;");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("ATTENZIONE, per creare una nuova scheda attivare la funzione popup del motore di ricerca.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        \n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryCreateForm");
        $attr4.appendChild($node5);
        
        $element_QueryCreateForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        \n         ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hidden");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("VOLUME_ANYWAY");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("VOLUME_ANYWAY");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("hidden");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $element_VOLUME_ANYWAY = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("HEADWORD_ANYWAY");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("HEADWORD_ANYWAY");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("hidden");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $element_HEADWORD_ANYWAY = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("GO");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("GO");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("hidden");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $element_GO = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        \n         ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ShowCreation");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center; width:100%; padding: 10px 0px;");
        $attr4.appendChild($node5);
        
        $element_ShowCreation = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Nouvelle entr\u00e9e \"");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("HEADWORD_FINAL");
        $attr6.appendChild($node7);
        
        $element_HEADWORD_FINAL = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node7 = document.createTextNode("HeadwordFinal");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\" cr\u00e9\u00e9e dans le volume ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("VOLUME_FINAL");
        $attr6.appendChild($node7);
        
        $element_VOLUME_FINAL = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node7 = document.createTextNode("VolumeFinal");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(".");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        \n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryForm");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("CreateAnywayForm");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("text-align:center; width:100%; padding: 10px 0px;");
        $attr5.appendChild($node6);
        
        $element_CreateAnywayForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("La scheda \u00e8 gi\u00e0 presente. Vuoi crearne una nuova comunque?");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem6.appendChild($elem7);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "for");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("VOLUME");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("volume:");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode(" \n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "disabled");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("disabled");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("VOLUME_DISABLED");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("VOLUME_DISABLED");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("width:99px");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_VOLUME_DISABLED = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "for");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ValueField");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("termine:");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode(" \n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "disabled");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("disabled");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("HEADWORD_DISABLED");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("HEADWORD_DISABLED");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("width:30%");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_HEADWORD_DISABLED = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("CreateAnywayButton");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("action");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("createAnyway()");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("crea un'altra scheda");
        $attr6.appendChild($node7);
        
        $element_CreateAnywayButton = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "action");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("CreateEntryInit.po");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LookupForm");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "method");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("get");
        $attr5.appendChild($node6);
        
        $element_LookupForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text-align:center; width:100%; padding: 10px 0px;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "for");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUME");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("volume:");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode("           \n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("VOLUME");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("VOLUME");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("width:100px");
        $attr7.appendChild($node8);
        
        $element_VOLUME = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VolumeOptionTemplate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "label");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NONE");
        $attr8.appendChild($node9);
        
        $element_VolumeOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem8;$node9 = document.createTextNode("NONE");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "for");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ValueField");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("termine:");
        $elem8.appendChild($node9);
        
        $node7 = document.createTextNode(" \n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Facet");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("FACET.0");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("cdm-headword");
        $attr7.appendChild($node8);
        
        $element_Facet = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Operator");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("OPERATOR.0");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $element_Operator = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ValueField");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("FACETVALUE.0");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("width:30%");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $element_ValueField = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SourceLang");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("SOURCE.0");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("All");
        $attr7.appendChild($node8);
        
        $element_SourceLang = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Targets");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("TARGETS");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("*All*");
        $attr7.appendChild($node8);
        
        $element_Targets = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Xsl");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("XSL");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Default");
        $attr7.appendChild($node8);
        
        $element_Xsl = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Limit");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("NB_RESULT_PER_PAGE");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $element_Limit = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Offset");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("OFFSET");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $element_Offset = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("action");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("action");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("hidden");
        $attr7.appendChild($node8);
        
        $element_Action = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("CreateButton");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "onclick");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("create()");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("submit");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("crea");
        $attr7.appendChild($node8);
        
        $element_CreateButton = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node7 = document.createTextNode("\n                ");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n        ");
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
        return new CreateEntryInitXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>action</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAction() {
        return $element_Action;
    }

    /**
     * Get the element with id <CODE>CreateAnywayButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementCreateAnywayButton() {
        return $element_CreateAnywayButton;
    }

    /**
     * Get the element with id <CODE>CreateAnywayForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementCreateAnywayForm() {
        return $element_CreateAnywayForm;
    }

    /**
     * Get the element with id <CODE>CreateButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementCreateButton() {
        return $element_CreateButton;
    }

    /**
     * Get the element with id <CODE>EditEntryInitContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementEditEntryInitContent() {
        return $element_EditEntryInitContent;
    }

    /**
     * Get the element with id <CODE>Facet</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementFacet() {
        return $element_Facet;
    }

    /**
     * Get the element with id <CODE>GO</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementGO() {
        return $element_GO;
    }

    /**
     * Get the element with id <CODE>HEADWORD_ANYWAY</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementHEADWORD_ANYWAY() {
        return $element_HEADWORD_ANYWAY;
    }

    /**
     * Get the element with id <CODE>HEADWORD_DISABLED</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementHEADWORD_DISABLED() {
        return $element_HEADWORD_DISABLED;
    }

    /**
     * Get the element with id <CODE>HEADWORD_FINAL</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementHEADWORD_FINAL() {
        return $element_HEADWORD_FINAL;
    }

    /**
     * Get the element with id <CODE>InitJavascript</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLScriptElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLScriptElement getElementInitJavascript() {
        return $element_InitJavascript;
    }

    /**
     * Get the element with id <CODE>Limit</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLimit() {
        return $element_Limit;
    }

    /**
     * Get the element with id <CODE>LookupForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementLookupForm() {
        return $element_LookupForm;
    }

    /**
     * Get the element with id <CODE>Offset</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementOffset() {
        return $element_Offset;
    }

    /**
     * Get the element with id <CODE>Operator</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementOperator() {
        return $element_Operator;
    }

    /**
     * Get the element with id <CODE>QueryCreateForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryCreateForm() {
        return $element_QueryCreateForm;
    }

    /**
     * Get the element with id <CODE>ShowCreation</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementShowCreation() {
        return $element_ShowCreation;
    }

    /**
     * Get the element with id <CODE>SourceLang</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSourceLang() {
        return $element_SourceLang;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementUserName() {
        return $element_UserName;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VOLUME_ANYWAY</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVOLUME_ANYWAY() {
        return $element_VOLUME_ANYWAY;
    }

    /**
     * Get the element with id <CODE>VOLUME_DISABLED</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVOLUME_DISABLED() {
        return $element_VOLUME_DISABLED;
    }

    /**
     * Get the element with id <CODE>VOLUME_FINAL</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementVOLUME_FINAL() {
        return $element_VOLUME_FINAL;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Xsl</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementXsl() {
        return $element_Xsl;
    }

    /**
     * Get the element with id <CODE>action</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAction() {
        return $element_Action;
    }

    /**
     * Get the element with id <CODE>CreateAnywayButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreateAnywayButton() {
        return $element_CreateAnywayButton;
    }

    /**
     * Get the element with id <CODE>CreateAnywayForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreateAnywayForm() {
        return $element_CreateAnywayForm;
    }

    /**
     * Get the element with id <CODE>CreateButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreateButton() {
        return $element_CreateButton;
    }

    /**
     * Get the element with id <CODE>EditEntryInitContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditEntryInitContent() {
        return $element_EditEntryInitContent;
    }

    /**
     * Get the element with id <CODE>Facet</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFacet() {
        return $element_Facet;
    }

    /**
     * Get the element with id <CODE>GO</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGO() {
        return $element_GO;
    }

    /**
     * Get the element with id <CODE>HEADWORD_ANYWAY</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHEADWORD_ANYWAY() {
        return $element_HEADWORD_ANYWAY;
    }

    /**
     * Get the element with id <CODE>HEADWORD_DISABLED</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHEADWORD_DISABLED() {
        return $element_HEADWORD_DISABLED;
    }

    /**
     * Get the element with id <CODE>HEADWORD_FINAL</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHEADWORD_FINAL() {
        return $element_HEADWORD_FINAL;
    }

    /**
     * Get the element with id <CODE>InitJavascript</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagInitJavascript() {
        return $element_InitJavascript;
    }

    /**
     * Get the element with id <CODE>Limit</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLimit() {
        return $element_Limit;
    }

    /**
     * Get the element with id <CODE>LookupForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLookupForm() {
        return $element_LookupForm;
    }

    /**
     * Get the element with id <CODE>Offset</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOffset() {
        return $element_Offset;
    }

    /**
     * Get the element with id <CODE>Operator</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOperator() {
        return $element_Operator;
    }

    /**
     * Get the element with id <CODE>QueryCreateForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryCreateForm() {
        return $element_QueryCreateForm;
    }

    /**
     * Get the element with id <CODE>ShowCreation</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagShowCreation() {
        return $element_ShowCreation;
    }

    /**
     * Get the element with id <CODE>SourceLang</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSourceLang() {
        return $element_SourceLang;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUserName() {
        return $element_UserName;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VOLUME_ANYWAY</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME_ANYWAY() {
        return $element_VOLUME_ANYWAY;
    }

    /**
     * Get the element with id <CODE>VOLUME_DISABLED</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME_DISABLED() {
        return $element_VOLUME_DISABLED;
    }

    /**
     * Get the element with id <CODE>VOLUME_FINAL</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME_FINAL() {
        return $element_VOLUME_FINAL;
    }

    /**
     * Get the element with id <CODE>ValueField</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValueField() {
        return $element_ValueField;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>Xsl</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXsl() {
        return $element_Xsl;
    }

    /**
     * Get the value of text child of element <CODE>CreateAnywayForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCreateAnywayForm(String text) {
        doSetText($element_CreateAnywayForm, text);
    }

    /**
     * Get the value of text child of element <CODE>EditEntryInitContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditEntryInitContent(String text) {
        doSetText($element_EditEntryInitContent, text);
    }

    /**
     * Get the value of text child of element <CODE>HEADWORD_FINAL</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHEADWORD_FINAL(String text) {
        doSetText($element_HEADWORD_FINAL, text);
    }

    /**
     * Get the value of text child of element <CODE>InitJavascript</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextInitJavascript(String text) {
        doSetText($element_InitJavascript, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryCreateForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryCreateForm(String text) {
        doSetText($element_QueryCreateForm, text);
    }

    /**
     * Get the value of text child of element <CODE>ShowCreation</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextShowCreation(String text) {
        doSetText($element_ShowCreation, text);
    }

    /**
     * Get the value of text child of element <CODE>UserName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserName(String text) {
        doSetText($element_UserName, text);
    }

    /**
     * Get the value of text child of element <CODE>VOLUME_FINAL</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVOLUME_FINAL(String text) {
        doSetText($element_VOLUME_FINAL, text);
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
