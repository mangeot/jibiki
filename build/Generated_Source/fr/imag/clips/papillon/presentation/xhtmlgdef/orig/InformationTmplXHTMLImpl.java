/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlgdef.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlgdef/orig/InformationTmpl.xhtml
 */
public class InformationTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements InformationTmplXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.InformationTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_InfoContent;

    /**
     * Element name constant for Credits
     */
    public static final String NAME_Credits = "Credits";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = InformationTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlgdef/orig/InformationTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public InformationTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public InformationTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public InformationTmplXHTMLImpl(InformationTmplXHTMLImpl src) {
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
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
        org.enhydra.apache.xerces.dom.DocumentTypeImpl docType = (org.enhydra.apache.xerces.dom.DocumentTypeImpl)fDOMFactory.createDocumentType("html", "-//W3C//DTD XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", null);
        org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl document = (org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl)fDOMFactory.createDocument("http://www.w3.org/1999/xhtml", "html", docType);
        $elem1 = document.getDocumentElement();
        document.createElementNS("http://www.w3.org/1999/xhtml", "html");
        
        $attr1 = document.createAttributeNS("", "lang");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("fr");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("fr");
        $attr1.appendChild($node2);
        
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
        
        $node4 = document.createTextNode("Header");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $node3 = document.createComment(" When translating this document, make sure the anchor names remain the same as they are refered from outside of this document ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("InfoContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_InfoContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Grand dictionnaire estonien-fran");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("ccedil");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00e7");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode("ais");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createEntityReference("nbsp");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00a0");
        $node5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\t\t");
        $elem3.appendChild($node4);
        
        buildSubDocument_0(document, $elem3);
        $node4 = document.createTextNode("\n\n\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("8. Cr\u00e9dits");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Credits");
        $attr5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Plate-forme informatique");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(": ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Mathieu MANGEOT-NAGATA");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" & ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Gilles S\u00c9RASSET");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(": main developpers.");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Donn\u00e9es lexicographiques");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(": ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Association franco-estonienne de lexicographie");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" & ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Institut de la langue estonienne");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(".");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5;
        Element $elem0, $elem1, $elem2, $elem3, $elem4;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "style");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("text-align:justify");
        $attr0.appendChild($node1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        buildSubDocument_0_0(document, $elem0);
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("1. Objectif");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Anchor-49575");
        $attr2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("L\u2019objectif de ce projet est la r\u00e9alisation d\u2019un dictionnaire estonien-fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais d\u2019environ 80");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("000 entr\u00e9es, par une \u00e9quipe bilingue de linguistes et traducteurs professionnels.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("R\u00e9alis\u00e9 au format XML, ce dictionnaire est disponible en ligne gratuitement au fur et \u00e0 mesure de son \u00e9laboration. La version d\u00e9finitive sera \u00e9galement publi\u00e9e sur papier et sur CD-ROM.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("2. N\u00e9cessit\u00e9 d\u2019un nouveau dictionnaire");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Anchor-47857");
        $attr2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        buildSubDocument_0_1(document, $elem0);
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        buildSubDocument_0_2(document, $elem0);
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("3. Publics cibles");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Anchor-11481");
        $attr2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Le grand dictionnaire estonien-fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais est destin\u00e9 ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" r\u00e9pondre en priorit\u00e9 aux besoins des publics suivants");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(":");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("3.1.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode(" ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Apprenants de fran");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("ccedil");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00e7");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode("ais en Estonie");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("La n\u00e9cessit\u00e9 d\u2019un grand dictionnaire bilingue se fait sentir tout particuli");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("rement au niveau du lyc\u00e9e (3 derni");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("res classes de l\u2019enseignement secondaire) et dans l\u2019enseignement sup\u00e9rieur, o");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ugrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00f9");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" l\u2019absence d\u2019outil ad\u00e9quat complique singuli");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("rement la pratique du th");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("me fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais et de la r\u00e9daction.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Le dictionnaire r\u00e9pondrait \u00e9galement aux besoins des apprenants adultes participant aux cours de l\u2019Alliance fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("aise d\u2019Estonie et du Centre culturel fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais, notamment les fonctionnaires estoniens qui b\u00e9n\u00e9ficient du programme d\u2019apprentissage du fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais mis en place par l\u2019Ambassade de France.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createEntityReference("Agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00c0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" l\u2019issue des cours, l\u2019existence d\u2019un dictionnaire estonien-fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais moderne et suffisamment complet est une condition indispensable ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" l\u2019utilisation effective du fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais par les fonctionnaires et responsables estoniens dans leur communication \u00e9crite avec leurs partenaires francophones.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("3.2.");
        $elem2.appendChild($node3);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Apprenants d\u2019estonien francophones");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        buildSubDocument_0_3(document, $elem0);
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("3.3.");
        $elem2.appendChild($node3);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Traducteurs d\u2019estonien");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("En l\u2019absence de dictionnaire de d\u00e9finitions estonien comparable au Petit Robert, l\u2019existence d\u2019un grand dictionnaire bilingue estonien-fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais refl\u00e9tant l\u2019\u00e9tat actuel de la langue estonienne constituera un outil de travail indispensable pour les traducteurs francophones, notamment au sein des institutions europ\u00e9ennes.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("4. Aspects linguistiques");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Anchor-35882");
        $attr2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("4.1. Nomenclature");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Le grand dictionnaire estonien-fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais comprendra environ 80");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("000 entr\u00e9es, refl\u00e9tant aussi largement que possible le lexique estonien contemporain, dans tous ses emplois concernant le grand public");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(": litt\u00e9rature ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" partir de 1925 (date de la standardisation de la langue), presse, vulgarisation scientifique et technique, langue parl\u00e9e. Il fournira pour ces mots estoniens les \u00e9quivalents en fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais standard, en s\u2019attachant ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" distinguer avec pr\u00e9cision leurs nuances de sens et leurs contextes d\u2019emploi.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("4.2. Une \u00e9quipe bilingue");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Le dictionnaire est r\u00e9alis\u00e9 sous la responsabilit\u00e9 d\u2019Antoine Chalvin (directeur scientifique), Madis J\u00fcrviste, Indrek Koff et Jean Pascal Ollivry, par une \u00e9quipe comprenant des Estoniens poss\u00e9dant une connaissance approfondie et active du fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais et des Fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais poss\u00e9dant une connaissance approfondie et active de l\u2019estonien. Outre les quatre responsables, les autres membres de l'\u00e9quipe de r\u00e9daction sont actuellement Marri Amon, Jean-Pierre Minaudier, Heete Sahkai et Eva Toulouze.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("La pr\u00e9sence dans l\u2019\u00e9quipe de locuteurs des deux langues, condition indispensable pour la fiabilit\u00e9 d\u2019un tel dictionnaire, semble aujourd\u2019hui aller de soi dans tout projet lexicographique bilingue s\u00e9rieux. Elle constitue n\u00e9anmoins une innovation radicale en Estonie, o");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ugrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00f9");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" les dictionnaires bilingues, y compris les plus r\u00e9cents, sont toujours r\u00e9dig\u00e9s par des Estoniens (souvent m");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ecirc");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00ea");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("me par un seul auteur).");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("5. Aspects informatiques");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Anchor-14210");
        $attr2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("5.1. Base de donn\u00e9es");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Le dictionnaire est r\u00e9alis\u00e9 sous la forme d\u2019une base de donn\u00e9es XML comprenant deux sous-ensembles");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(":");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("1) la base principale (dite \"");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("volume estonien");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("\"), contenant les articles du futur dictionnaire");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(";");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("2)");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("une base distincte (dite \"");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("volume fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("\"), contenant tous les mots fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais cit\u00e9s comme \u00e9quivalents dans le volume estonien, ainsi que leurs informations annexes (genre des noms, type de conjugaison des verbes, auxiliaire utilis\u00e9 ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" la conjugaison active, h aspir\u00e9, prononciation en cas d\u2019irr\u00e9gularit\u00e9).");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Les \u00e9quivalents fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais et leurs informations annexes sont stock\u00e9s une fois pour toutes dans le volume fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais. Leur insertion dans les articles du dictionnaire se fait au moyen de liens plac\u00e9s dans le volume estonien. Cette technique permet de ne saisir qu\u2019une seule fois les informations concernant les mots fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais, afin de minimiser les risques d\u2019erreur et de faciliter les corrections.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("5.2. Interface de saisie et de consultation");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Afin de rem\u00e9dier ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" la dispersion g\u00e9ographique et ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" la mobilit\u00e9 des r\u00e9dacteurs, la saisie des articles se fait sur Internet, au moyen d\u2019une interface qui permet la conversion au format XML des donn\u00e9es saisies dans un formulaire, en garantissant le respect de la structure d\u2019article (\u00e9diteur XML en ligne, fonctionnant au moyen d\u2019un serveur web d\u2019objets dynamiques java (Enhydra)).");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Une autre interface permet aux r\u00e9dacteurs de consulter la base de donn\u00e9es lexicographique en cours d\u2019\u00e9laboration.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Cette plateforme est une version modifi\u00e9e de la plateforme ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "href");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("http://jibiki.univ-savoie.fr/jibiki/");
        $attr2.appendChild($node3);
        
        $node3 = document.createTextNode("jibiki");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode(", d\u00e9velopp\u00e9e par Mathieu Mangeot, Gilles S\u00e9rasset et David Th\u00e9venin.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("6. Aspects institutionnels");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Anchor-23240");
        $attr2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("La r\u00e9alisation du projet est assur\u00e9e par l\u2019Association franco-estonienne de lexicographie, avec le soutien de l\u2019Agence intergouvernementale de la francophonie, de la Fondation Robert Schuman, de l\u2019Ambassade de France en Estonie et du Centre culturel et de coop\u00e9ration fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais de Tallinn, et en partenariat avec les institutions suivantes");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(":");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "i");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("-");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode("pour la France");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode(":");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("l\u2019Institut national des langues et civilisations orientales (INALCO), \n\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("http://www.inalco.fr/pub/enseignements/langues/eco/estonien/");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("section d\u2019\u00e9tudes estoniennes");
        $elem4.appendChild($node5);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $node4 = document.createTextNode(";");
        $elem3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "i");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("- pour l\u2019Estonie");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode(":");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem0.appendChild($elem1);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("le Centre d\u2019\u00e9tudes francophones Robert Schuman de l\u2019");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("http://www.ut.ee/");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Universit\u00e9 de Tartu");
        $elem3.appendChild($node4);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode(";");
        $elem2.appendChild($node3);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("l\u2019");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("http://www.eki.ee/");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("Institut de la langue estonienne");
        $elem3.appendChild($node4);
        
        $node3 = document.createTextNode(" (Tallinn)");
        $elem2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node3 = document.createTextNode(";");
        $elem2.appendChild($node3);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("7. D\u00e9bouch\u00e9s concrets");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Anchor-3800");
        $attr2.appendChild($node3);
        
        $node3 = document.createEntityReference("nbsp");
        $elem2.appendChild($node3);
        
        $node4 = document.createTextNode("\u00a0");
        $node3.appendChild($node4);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("- ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Dictionnaire en ligne.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode(" Le grand dictionnaire estonien-fran\u00e7ais est mis gratuitement \u00e0 la disposition du public sur le site Internet ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("www.estfra.ee");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode(", et ce d\u00e8s les premi\u00e8res \u00e9tapes de la r\u00e9alisation. Une fois achev\u00e9, il sera \u00e9galement int\u00e9gr\u00e9 au portail de ressources sur la langue estonienne ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("www.keelevara.ee");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode(".");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("- ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Publication d\u2019un dictionnaire papier.");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode(" Le grand dictionnaire estonien-fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais sera publi\u00e9 sous la forme d\u2019un volume reli\u00e9 et cartonn\u00e9 par la maison d\u2019\u00e9dition estonienne Eesti Keele Sihtasutus (\"");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("Fondation de la langue estonienne");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("\"), sp\u00e9cialis\u00e9e dans les dictionnaires.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("- ");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem1.appendChild($elem2);
        
        $node3 = document.createTextNode("Publication d\u2019un CD-ROM");
        $elem2.appendChild($node3);
        
        $node2 = document.createTextNode(". La structure XML de la version \u00e9lectronique du dictionnaire rendra relativement ais\u00e9e la r\u00e9alisation d\u2019un CD-ROM. Nous sommes ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" la recherche d\u2019un \u00e9diteur multim\u00e9dia susceptible d\u2019");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ecirc");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00ea");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("tre int\u00e9ress\u00e9 par le projet. La t");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("acirc");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e2");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("che est cependant compliqu\u00e9e par le fait que l\u2019\u00e9dition multim\u00e9dia est un secteur encore presque inexistant en Estonie. Dans l\u2019hypoth");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("se o");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ugrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00f9");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" aucune entreprise sp\u00e9cialis\u00e9e ne verrait le jour en Estonie avant l\u2019ach");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("vement du dictionnaire, nous pourrions envisager de r\u00e9aliser ce CD-ROM par nos propres moyens, sous r\u00e9serve de trouver un partenaire pour prendre en charge la commercialisation.");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_0(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3;
        Element $elem0, $elem1;
        Attr $attr0, $attr1;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        parentNode.appendChild($elem0);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Anchor-49575");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("1. Objectif");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Anchor-47857");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("2.");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("N\u00e9cessit\u00e9 d\u2019un nouveau dictionnaire");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Anchor-11481");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("3. Publics cibles");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Anchor-35882");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("4.");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("Aspects linguistiques");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Anchor-14210");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("5.");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("Aspects informatiques");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Anchor-23240");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("6.");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("Aspects institutionnels");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Anchor-3800");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("7. D\u00e9bouch\u00e9s concrets");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem0.appendChild($elem1);
        
        $node1 = document.createTextNode("\n\t\t\t");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "href");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("#Credits");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("8. Cr\u00e9dits");
        $elem1.appendChild($node2);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_1(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3;
        Element $elem0, $elem1;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        parentNode.appendChild($elem0);
        
        $node1 = document.createTextNode("L\u2019adh\u00e9sion de l\u2019Estonie ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" l\u2019Union europ\u00e9enne et le d\u00e9veloppement de l\u2019enseignement du fran");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("ccedil");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e7");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode("ais dans ce pays font appara\u00eetre comme une urgente n\u00e9cessit\u00e9 la publication d\u2019un nouveau dictionnaire estonien-fran");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("ccedil");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e7");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode("ais. Il n\u2019existe en effet aucun grand dictionnaire estonien-fran");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("ccedil");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e7");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode("ais r\u00e9pondant aux exigence de la lexicographie moderne et refl\u00e9tant l\u2019\u00e9tat actuel de la langue estonienne. Le seul dictionnaire d\u2019une taille comparable (K.");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("nbsp");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00a0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode("Kann et N.");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("nbsp");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00a0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode("Kaplinski, ");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "i");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Eesti-prantsuse s");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("otilde");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00f5");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("naramat");
        $elem1.appendChild($node2);
        
        $node1 = document.createTextNode(", Tallinn");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("nbsp");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00a0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(": Valgus, 1979) est entach\u00e9 de graves d\u00e9fauts, auxquels il ne semble pas possible de rem\u00e9dier par une simple mise ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" jour");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("nbsp");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00a0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(":");
        $elem0.appendChild($node1);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_2(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3;
        Element $elem0, $elem1;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        parentNode.appendChild($elem0);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Publi\u00e9 en 1979, il ne refl");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("te plus l\u2019\u00e9tat actuel de la langue estonienne, dont le lexique a \u00e9t\u00e9 consid\u00e9rablement");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("modifi\u00e9 et enrichi par les bouleversements politiques et \u00e9conomiques des ann\u00e9es 1990, ainsi que par les pr\u00e9paratifs en vue de l\u2019adh\u00e9sion ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" l\u2019Union europ\u00e9enne");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(";");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("R\u00e9dig\u00e9 ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" une \u00e9poque o");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ugrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00f9");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" les auteurs avaient, par la force des circonstances, perdu le contact avec la langue fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("aise vivante, il contient de nombreuses erreurs dans les traductions fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("aises");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("(fautes d\u2019orthographe, mots archa");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("iuml");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00ef");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ques ou inexistants, erreurs de traduction) ;");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Les contextes d\u2019emploi des \u00e9quivalents fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais ne sont pas distingu\u00e9s avec suffisamment de pr\u00e9cision, ce qui rend ce dictionnaire tr");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("s difficile ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" utiliser par des Estoniens ayant besoin d\u2019\u00e9crire un texte en fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(";");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Le dictionnaire ne contient que tr");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("s peu d\u2019indications sur la rection des mots fran");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("ais et estoniens");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(";");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Il contient un nombre tr");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("s insuffisant de locutions et d\u2019expressions idiomatiques");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(";");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Les mots sont pr\u00e9sent\u00e9s selon une disposition graphique peu claire (regroupement des mots compos\u00e9s dans l\u2019article consacr\u00e9 ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" leur premier constituant), ce qui rend la consultation fastidieuse");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("nbsp");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00a0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(";");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("Con");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("u exclusivement pour le public estonien, il ne r\u00e9pond pas de fa");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("ccedil");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e7");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("on satisfaisante aux besoin des francophones apprenant l\u2019estonien comme langue \u00e9trang");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("re, public de plus en plus nombreux et qui devrait encore cro");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("icirc");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00ee");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("tre dans les ann\u00e9es ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" venir, apr");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("egrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e8");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode("s l\u2019adh\u00e9sion de l\u2019Estonie ");
        $elem1.appendChild($node2);
        
        $node2 = document.createEntityReference("agrave");
        $elem1.appendChild($node2);
        
        $node3 = document.createTextNode("\u00e0");
        $node2.appendChild($node3);
        
        $node2 = document.createTextNode(" l\u2019Union europ\u00e9enne.");
        $elem1.appendChild($node2);
        
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_3(org.w3c.dom.Document document,
                                      org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2;
        Element $elem0;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        parentNode.appendChild($elem0);
        
        $node1 = document.createTextNode("Ce public, d\u00e9j");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" plus nombreux qu\u2019on ne croit, est appel\u00e9 ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" se d\u00e9velopper dans les ann\u00e9es ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" venir, compte tenu de l\u2019adh\u00e9sion de l\u2019Estonie ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" l\u2019Union europ\u00e9enne et du d\u00e9veloppement des relations avec les pays francophones. D\u2019ores et d\u00e9j");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(", l\u2019estonien est enseign\u00e9 en France ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" l\u2019Institut national des langues et civilisations orientales (une quinzaine d\u2019\u00e9tudiants chaque ann\u00e9e), ainsi qu\u2019");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" Bruxelles au sein des institutions europ\u00e9ennes. Des francophones participent \u00e9galement aux cours organis\u00e9s en Estonie par l\u2019Universit\u00e9 de Tartu et l\u2019Universit\u00e9 p\u00e9dagogique de Tallinn. Le dictionnaire pourrait \u00e9galement ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("ecirc");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00ea");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode("tre utile au Canada, o");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("ugrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00f9");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" vit une importante communaut\u00e9 estonienne et o");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("ugrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00f9");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" existent de nombreux cours d\u2019estonien ");
        $elem0.appendChild($node1);
        
        $node1 = document.createEntityReference("agrave");
        $elem0.appendChild($node1);
        
        $node2 = document.createTextNode("\u00e0");
        $node1.appendChild($node2);
        
        $node1 = document.createTextNode(" diff\u00e9rents niveaux.");
        $elem0.appendChild($node1);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new InformationTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>InfoContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementInfoContent() {
        return $element_InfoContent;
    }

    /**
     * Get the element with id <CODE>InfoContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagInfoContent() {
        return $element_InfoContent;
    }

    /**
     * Get the value of text child of element <CODE>InfoContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextInfoContent(String text) {
        doSetText($element_InfoContent, text);
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
