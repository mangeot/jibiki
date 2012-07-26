/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmllexalp.deu;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmllexalp/deu/HomeContent.xhtml
 */
public class HomeContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements HomeContentXHTML, fr.imag.clips.papillon.presentation.xhtmllexalp.orig.HomeContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HomeContent;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ProjectDescription;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = HomeContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmllexalp/deu/HomeContent.xhtml";

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
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6;
        
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
        
        $node4 = document.createTextNode("LexALP");
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
        $node4 = document.createTextNode("de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("de");
        $attr3.appendChild($node4);
        
        $element_HomeContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
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
        
        $node6 = document.createTextNode("Willkommen in der LexALP Terminologiedatenbank");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Diese Terminologiedatenbank enth");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("lt Fachtermini aus den Bereichen ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Raumplanung");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" und ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("nachhaltige Entwicklung");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(".");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Die Terminologie ist in ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Deutsch");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(", ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Franz");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("ouml");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00f6");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("sisch");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(", ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Italienisch");
        $elem6.appendChild($node7);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("\nund ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Slowenisch");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" verf");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00fc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("gbar, die Benutzeroberfl");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("che zus");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("tzlich in Englisch.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Die Anzahl unserer Begriffe ist begrenzt. Wir versuchen jedoch, diese\nBegriffe f");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00fc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("r alle ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Rechtsr");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("auml");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00e4");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("ume\nder Alpen");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" bis ins\nDetail zu beschreiben. Um nicht zu viel Information auf einmal als\nErgebnis zu erhalten, empfehlen wir Ihnen, Ihre Suche\neinzuschr");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("nken. Beachten Sie die ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Fahnen");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" rechts der\nTermini\n(z.b. ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ac-logo");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/lexalp/AC.gif");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("20");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\nf");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00fc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("r die Alpenkonvention): Sie geben das\nRechtssystem an, f");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00fc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("r den der Terminus definiert wurde. In\nvielen F");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("llen wird der gleiche Terminus in der\nAlpenkonvention, auf EU- Ebene sowie auf internationaler und nationaler\nEbene verwendet. In diesen");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(" F");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("llen kann der gleiche\nSuchbegriff mehrmals angezeigt werden ");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ndash");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u2013");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(" mit unterschiedlicher\nFahne und manchmal auch nur mit leicht abweichender Definition. Wir\nm");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ouml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00f6");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("chten Sie darauf hinweisen, dass die Termini der\nAlpenkonvention separat definiert werden, obwohl die Konvention dem\nV");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ouml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00f6");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("lkerrecht zugeordnet werden kann, da nur auf diese Weise die\nProjektanforderungen und ");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ndash");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u2013");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("bed");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00fc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("rfnisse\nerf");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00fc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("llt werden k");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ouml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00f6");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("nnen. Termini mit Status\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createEntityReference("bdquo");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u201e");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("harmonisiert");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("ldquo");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u201c");
        $node7.appendChild($node8);
        
        $node6 = document.createTextNode("\nerscheinen zu viert (jeweils ein\nTerminus pro Sprache). Es handelt sich um Termini, die innerhalb der\nAlpenkonvention gleichwertig verwendet werden. Eines der Hauptziele des\nLexALP-Projekts besteht darin, eine m");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ouml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00f6");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("glichst gro");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("szlig");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00df");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("e\nAnzahl von solchen ");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("Uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00dc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("bersetzungs");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("quivalenten zu\nidentifizieren und festzulegen.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Die LexALP-Terminologiedatenbank dient zum Erfassen und Anzeigen von\nTerminologieeintr");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("gen. Sie liefert Echtzeit-Zugang zur\nTerminologie der Alpenkonvention. Bitte bedenken Sie jedoch, dass das\nProjekt noch in Bearbeitung ist!");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Sollte ein Suchbegriff ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("font-weight: bold;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("nicht\nvorhanden");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" sein, so haben Sie die\nM");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ouml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00f6");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("glichkeit, diesen im ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://217.199.4.152:8080/htdocs2/lexalp/corp_lexalp/search_corp.php");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Korpus");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\nnachzuschlagen.\nEventuell");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(" findet sich in einem Paralleltext eine\nad");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("quate ");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("Uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00dc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("bersetzung.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Sie werden bemerken, dass alle Termini nach Fachgebieten klassifiziert\nsind. Die Struktur ist von Artikel 9 des\nAlpenkonventionsprotokolls");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://www.convenzionedellealpi.org/archive/protocols/Protokoll_f_Raumplanung.pdf");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Raumplanung\nund nachhaltige Entwicklung");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n(verf");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00fc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("gbar auf ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://www.convenzionedellealpi.org/archive/protocols/Protokoll_d_Raumplanung.pdf");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Deutsch");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(",\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://www.convenzionedellealpi.org/archive/protocols/Protokoll_f_Raumplanung.pdf");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Franz");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("ouml");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00f6");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("sisch");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(",\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://www.convenzionedellealpi.org/archive/protocols/Protokoll_i_Raumplanung.pdf");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Italienisch");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(",\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://www.convenzionedellealpi.org/archive/protocols/Protokoll_f_Raumplanung.pdf");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("Slowenisch");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(")\ninspiriert.\n");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("Uuml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00dc");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("ber die ");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("bdquo");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u201e");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("Erweiterte\nBenutzeroberfl");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("che");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ldquo");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u201c");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode(" k");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("ouml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00f6");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("nnen Sie neben\nFachgebieten auch andere Kriterien, wie Sprache, Rechtsraum u.s.w.\nspezifizieren, um Ihre Suche einzuschr");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("auml");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00e4");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("nken.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Klicken Sie ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("hier");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(", um mehr\nInformation zu erhalten.\n");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("           \n       ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryResult");
        $attr4.appendChild($node5);
        
        $element_QueryResult = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("title");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Suchergebnisse");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
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
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("title");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Fuzzy-Suchergebnisse");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryFuzzyResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryFuzzyResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
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
