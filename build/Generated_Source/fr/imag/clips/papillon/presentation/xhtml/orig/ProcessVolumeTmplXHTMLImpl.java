/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/ProcessVolumeTmpl.xhtml
 */
public class ProcessVolumeTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ProcessVolumeTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_CONVERT;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_STATUS;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_STYLESHEET;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search1;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search1text;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search2;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search2text;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy1;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy2;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_VOLUME;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_XslOptionTemplate;

    /**
     * Element name constant for CONVERT
     */
    public static final String NAME_CONVERT = "CONVERT";

    /**
     * Element name constant for STATUS
     */
    public static final String NAME_STATUS = "STATUS";

    /**
     * Element name constant for STYLESHEET
     */
    public static final String NAME_STYLESHEET = "STYLESHEET";

    /**
     * Element name constant for Strategy1
     */
    public static final String NAME_Strategy1 = "Strategy1";

    /**
     * Element name constant for Strategy2
     */
    public static final String NAME_Strategy2 = "Strategy2";

    /**
     * Element name constant for VOLUME
     */
    public static final String NAME_VOLUME = "VOLUME";

    /**
     * Element name constant for search1
     */
    public static final String NAME_search1 = "search1";

    /**
     * Element name constant for search1text
     */
    public static final String NAME_search1text = "search1text";

    /**
     * Element name constant for search2
     */
    public static final String NAME_search2 = "search2";

    /**
     * Element name constant for search2text
     */
    public static final String NAME_search2text = "search2text";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ProcessVolumeTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/ProcessVolumeTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ProcessVolumeTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ProcessVolumeTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ProcessVolumeTmplXHTMLImpl(ProcessVolumeTmplXHTMLImpl src) {
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
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n   ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Process Volume");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t\n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" formulaire de voir mot");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ProcessVolume.po");
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
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VOLUME");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Volume:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUME");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUME");
        $attr8.appendChild($node9);
        
        $element_VOLUME = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
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
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("STATUS");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Status:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STATUS");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STATUS");
        $attr8.appendChild($node9);
        
        $element_STATUS = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("all");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("*ALL*");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("all");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("not finished");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("not finished");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("not finished");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("finished");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("finished");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("finished");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("revised");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("revised");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("revised");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("validated");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("validated");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("validated");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("replaced");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("replaced");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("replaced");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("deleted");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("deleted");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("deleted");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        buildSubDocument_0(document, $elem5);
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "for");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STYLESHEET");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Stylesheet:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STYLESHEET");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STYLESHEET");
        $attr8.appendChild($node9);
        
        $element_STYLESHEET = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("XslOptionTemplate");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $element_XslOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("NONE");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("CONVERT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("CONVERT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Convert");
        $attr8.appendChild($node9);
        
        $element_CONVERT = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4;
        Element $elem0, $elem1, $elem2, $elem3;
        Attr $attr0, $attr1, $attr2, $attr3;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        parentNode.appendChild($elem0);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "style");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("bgcolor:#4682b4;");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("\n             ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search1");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search1");
        $attr2.appendChild($node3);
        
        $element_Search1 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem2;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("headword");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("headword");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("variant");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword-variant");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("variant");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("part-of-speech");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-pos");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("part-of-speech");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("domain");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-domaine");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("domain");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("translation");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-translation");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("translation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("examples");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-example");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("example");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("eg. translations");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-exemple");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("eg. translation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("idioms");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("idiom");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("idiom translation");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("idiom translation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("author");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-author");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("author");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("reviewer");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-reviewer");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("reviewer");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("creation date");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-creation-date");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("creation date");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("revision date");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-revision-date");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("revision date");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("any part");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("AnyContains");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("any part");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem1.appendChild($elem2);
        
        $node2 = document.createTextNode("\n              ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Strategy1");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Strategy1");
        $attr2.appendChild($node3);
        
        $element_Strategy1 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem2;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("=");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("0");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("=");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("begins with");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("1");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("begins with");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("ends with");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("ends with");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("contains");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("3");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("contains");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("<");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("13");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("<");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("\u2264");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("14");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\u2264");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode(">");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("11");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode(">");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("\u2265");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("12");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\u2265");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n\t\t\t  ");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("\n                ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search1text");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search1text");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "size");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("15");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "type");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("text");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "value");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("");
        $attr2.appendChild($node3);
        
        $element_Search1text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n           ");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("and");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "style");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("bgcolor:#4682b4;");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("\n              ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search2");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search2");
        $attr2.appendChild($node3);
        
        $element_Search2 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem2;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("headword");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("headword");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("variant");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword-variant");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("variant");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("part-of-speech");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-pos");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("part-of-speech");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("le domaine");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-domaine");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("domain");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("translation");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-translation");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("translation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("examples");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-example");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("example");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("eg. translations");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-exemple");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("eg. translation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("idioms");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("idiom");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("idiom translation");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("idiom translation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("author");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-author");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("author");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("reviewer");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-reviewer");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("reviewer");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("creation date");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-creation-date");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("creation date");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("revision date");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-contribution-review-date");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("revision date");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("any part");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("AnyContains");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("any part");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem1.appendChild($elem2);
        
        $node2 = document.createTextNode("\n              ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Strategy2");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Strategy2");
        $attr2.appendChild($node3);
        
        $element_Strategy2 = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem2;$elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("=");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("0");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("=");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("begins with");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("1");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("begins with");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("ends with");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("ends with");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("contains");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("3");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("contains");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("<");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("13");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("<");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("\u2264");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("14");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\u2264");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode(">");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("11");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode(">");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("\u2265");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("12");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\u2265");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n\t\t\t  ");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("\n              ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search2text");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("search2text");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "size");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("15");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "type");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("text");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "value");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("");
        $attr2.appendChild($node3);
        
        $element_Search2text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n            ");
        $elem1.appendChild($node2);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ProcessVolumeTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>CONVERT</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementCONVERT() {
        return $element_CONVERT;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSTATUS() {
        return $element_STATUS;
    }

    /**
     * Get the element with id <CODE>STYLESHEET</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSTYLESHEET() {
        return $element_STYLESHEET;
    }

    /**
     * Get the element with id <CODE>search1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSearch1() {
        return $element_Search1;
    }

    /**
     * Get the element with id <CODE>search1text</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSearch1text() {
        return $element_Search1text;
    }

    /**
     * Get the element with id <CODE>search2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSearch2() {
        return $element_Search2;
    }

    /**
     * Get the element with id <CODE>search2text</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSearch2text() {
        return $element_Search2text;
    }

    /**
     * Get the element with id <CODE>Strategy1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementStrategy1() {
        return $element_Strategy1;
    }

    /**
     * Get the element with id <CODE>Strategy2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementStrategy2() {
        return $element_Strategy2;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>XslOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementXslOptionTemplate() {
        return $element_XslOptionTemplate;
    }

    /**
     * Get the element with id <CODE>CONVERT</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCONVERT() {
        return $element_CONVERT;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSTATUS() {
        return $element_STATUS;
    }

    /**
     * Get the element with id <CODE>STYLESHEET</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSTYLESHEET() {
        return $element_STYLESHEET;
    }

    /**
     * Get the element with id <CODE>search1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch1() {
        return $element_Search1;
    }

    /**
     * Get the element with id <CODE>search1text</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch1text() {
        return $element_Search1text;
    }

    /**
     * Get the element with id <CODE>search2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch2() {
        return $element_Search2;
    }

    /**
     * Get the element with id <CODE>search2text</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSearch2text() {
        return $element_Search2text;
    }

    /**
     * Get the element with id <CODE>Strategy1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStrategy1() {
        return $element_Strategy1;
    }

    /**
     * Get the element with id <CODE>Strategy2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStrategy2() {
        return $element_Strategy2;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>XslOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXslOptionTemplate() {
        return $element_XslOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeOptionTemplate(String text) {
        doSetText($element_VolumeOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>XslOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextXslOptionTemplate(String text) {
        doSetText($element_XslOptionTemplate, text);
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
