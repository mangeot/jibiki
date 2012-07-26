/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlgdef.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlgdef/orig/HomeContent.xhtml
 */
public class HomeContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements HomeContentXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.HomeContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GDEFReviewedEntryCountEst;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GDEFReviewedEntryCountFra;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GDEFValidatedEntryCountEst;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GDEFValidatedEntryCountFra;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HomeContent;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ProjectDescription;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    /**
     * Class attribute constant for element class est
     */
    public static final String CLASS_est = "est";

    /**
     * Class attribute constant for element class fra
     */
    public static final String CLASS_fra = "fra";

    /**
     * Class attribute constant for element class gray
     */
    public static final String CLASS_gray = "gray";

    /**
     * Class attribute constant for element class standard
     */
    public static final String CLASS_standard = "standard";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = HomeContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlgdef/orig/HomeContent.xhtml";

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
        
        $node4 = document.createTextNode("Projet GDEF");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
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
        
        $node4 = document.createTextNode("\n      ");
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
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("fr");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Grand dictionnaire estonien-fran\u00e7ais ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("(GDEF)");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n\t\t");
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
        
        $node7 = document.createTextNode("L\u2019objectif de ce projet est de r\u00e9aliser un grand dictionnaire\nestonien-fran\u00e7ais de plus de 80");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("000 articles. La r\u00e9daction de ce dictionnaire\nest assur\u00e9e par l\u2019Association franco-estonienne de lexicographie sous la\ndirection scientifique d\u2019Antoine Chalvin, avec la coop\u00e9ration de l\u2019Institut de la langue estonienne (EKI) et le\nsoutien de l\u2019Organisation internationale de la francophonie (OIF), du minist\u00e8re estonien de l\u2019\u00c9ducation et de la Recherche, de la Fondation Robert Schuman,\nde l\u2019Ambassade de France en Estonie et du Centre culturel et de coop\u00e9ration fran\u00e7ais de Tallinn. \n");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem6.appendChild($elem7);
        
        $node7 = document.createTextNode("Le dictionnaire contient actuellement ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("GDEFValidatedEntryCountFra");
        $attr7.appendChild($node8);
        
        $element_GDEFValidatedEntryCountFra = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("XXX");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode(" articles valid\u00e9s \nainsi que ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("GDEFReviewedEntryCountFra");
        $attr7.appendChild($node8);
        
        $element_GDEFReviewedEntryCountFra = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("XXX");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode(" articles r\u00e9vis\u00e9s en attente de validation.");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("et");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("et");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Suur eesti-prantsuse s\u00f5naraamat ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("(GDEF)");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n\t\t");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("est");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("et");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("et");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Projekti eesm\u00e4rgiks on koostada \u00fcle \n\t\t80");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("000 m\u00e4rks\u00f5na sisaldav\neesti-prantsuse s\u00f5naraamat. S\u00f5naraamatut koostab Antoine Chalvin\u2019 peatoimetamisel \nEesti-Prantsuse Leksikograafia\u00fching koost\u00f6\u00f6s Eesti Keele Instituudiga. Projekti toetavad Rahvusvaheline Frankofooniaorganisatsioon (OIF), Eesti Vabariigi Haridus- ja Teadusministeerium, Robert Schumani Fond, Prantsuse Suursaatkond \nEestis ning Prantsuse Kultuuri- ja  Koost\u00f6\u00f6keskus Tallinnas.\n");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem6.appendChild($elem7);
        
        $node7 = document.createTextNode("S\u00f5naraamat sisaldab praegu ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("GDEFValidatedEntryCountEst");
        $attr7.appendChild($node8);
        
        $element_GDEFValidatedEntryCountEst = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("XXX");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode(" kinnitatud artiklit ja\n ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("GDEFReviewedEntryCountEst");
        $attr7.appendChild($node8);
        
        $element_GDEFReviewedEntryCountEst = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("XXX");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode(" toimetatud, ent veel kinnitamata artiklit.");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t\u3000\u3000\u3000");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align: center;");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n\t\t\t\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.francophonie.org/");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Logo OIF");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/logo_OIF_petit.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("170");
        $attr6.appendChild($node7);
        
        $node5 = document.createTextNode("\u00a0\u00a0\u00a0\n\t\t\t\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.hm.ee/");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Logo Haridusministeerium");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/logoHM_petit.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("210");
        $attr6.appendChild($node7);
        
        $node5 = document.createTextNode("\u00a0\u00a0\n\t\t\t\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.ccf.ee/");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Logo CCCF");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/CCCF_Logo.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("200");
        $attr6.appendChild($node7);
        
        $node5 = document.createTextNode("\u00a0\u00a0\u00a0\n\t\t\t\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.ambafrance-ee.org/");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Logo Ambassade");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/logoAmbass_petit.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("120");
        $attr6.appendChild($node7);
        
        $node5 = document.createTextNode("\u00a0\u00a0 \n\t\t\t\t");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.robert-schuman.org/");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Logo AIF");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/logoSchumanpetit.jpg");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("150");
        $attr6.appendChild($node7);
        
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
        
        $node5 = document.createComment("h1 class=\"title\">Search result</h1");
        $elem4.appendChild($node5);
        
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
        
        $node5 = document.createComment("h1 class=\"title\">Fuzzy search result</h1");
        $elem4.appendChild($node5);
        
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
     * Get the element with id <CODE>GDEFReviewedEntryCountEst</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGDEFReviewedEntryCountEst() {
        return $element_GDEFReviewedEntryCountEst;
    }

    /**
     * Get the element with id <CODE>GDEFReviewedEntryCountFra</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGDEFReviewedEntryCountFra() {
        return $element_GDEFReviewedEntryCountFra;
    }

    /**
     * Get the element with id <CODE>GDEFValidatedEntryCountEst</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGDEFValidatedEntryCountEst() {
        return $element_GDEFValidatedEntryCountEst;
    }

    /**
     * Get the element with id <CODE>GDEFValidatedEntryCountFra</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGDEFValidatedEntryCountFra() {
        return $element_GDEFValidatedEntryCountFra;
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
     * Get the element with id <CODE>GDEFReviewedEntryCountEst</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGDEFReviewedEntryCountEst() {
        return $element_GDEFReviewedEntryCountEst;
    }

    /**
     * Get the element with id <CODE>GDEFReviewedEntryCountFra</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGDEFReviewedEntryCountFra() {
        return $element_GDEFReviewedEntryCountFra;
    }

    /**
     * Get the element with id <CODE>GDEFValidatedEntryCountEst</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGDEFValidatedEntryCountEst() {
        return $element_GDEFValidatedEntryCountEst;
    }

    /**
     * Get the element with id <CODE>GDEFValidatedEntryCountFra</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGDEFValidatedEntryCountFra() {
        return $element_GDEFValidatedEntryCountFra;
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
     * Get the value of text child of element <CODE>GDEFReviewedEntryCountEst</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGDEFReviewedEntryCountEst(String text) {
        doSetText($element_GDEFReviewedEntryCountEst, text);
    }

    /**
     * Get the value of text child of element <CODE>GDEFReviewedEntryCountFra</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGDEFReviewedEntryCountFra(String text) {
        doSetText($element_GDEFReviewedEntryCountFra, text);
    }

    /**
     * Get the value of text child of element <CODE>GDEFValidatedEntryCountEst</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGDEFValidatedEntryCountEst(String text) {
        doSetText($element_GDEFValidatedEntryCountEst, text);
    }

    /**
     * Get the value of text child of element <CODE>GDEFValidatedEntryCountFra</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGDEFValidatedEntryCountFra(String text) {
        doSetText($element_GDEFValidatedEntryCountFra, text);
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
