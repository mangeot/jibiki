/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/WelcomeTmpl.xhtml
 */
public class WelcomeTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements WelcomeTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_BestContributor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_BestReviewer;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ContributorsTable;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Finished;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GDEFFinishedEntryCount;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GDEFReviewedEntryCount;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GDEFValidatedEntryCount;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_LatestNewsContainer;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LoggedName;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_LoggedTemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LoggedUsers;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Login;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_MaxContributions;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_MaxRevisions;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Name;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Reviewed;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_TotalFinished;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_TotalReviewed;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_TotalValidated;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Validated;

    /**
     * Class attribute constant for element class hidden
     */
    public static final String CLASS_hidden = "hidden";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = WelcomeTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/WelcomeTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public WelcomeTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public WelcomeTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public WelcomeTmplXHTMLImpl(WelcomeTmplXHTMLImpl src) {
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
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Bienvenue sur le GDEF");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Utilisateurs connect\u00e9s");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LoggedUsers");
        $attr4.appendChild($node5);
        
        $element_LoggedUsers = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("0");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" user(s) currently logged:\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Logged users");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Name");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LoggedTemplateRow");
        $attr5.appendChild($node6);
        
        $element_LoggedTemplateRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("LoggedName");
        $attr8.appendChild($node9);
        
        $element_LoggedName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("name");
        $elem8.appendChild($node9);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Derni\u00e8re nouvelle du GDEF");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LatestNewsContainer");
        $attr4.appendChild($node5);
        
        $element_LatestNewsContainer = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Nombre d'articles en cours");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Le dictionnaire contient actuellement ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("GDEFValidatedEntryCount");
        $attr5.appendChild($node6);
        
        $element_GDEFValidatedEntryCount = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("XXX");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" articles valid\u00e9s \nainsi que ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("GDEFReviewedEntryCount");
        $attr5.appendChild($node6);
        
        $element_GDEFReviewedEntryCount = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("XXX");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" articles r\u00e9vis\u00e9s en attente de validation\nainsi que ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("GDEFFinishedEntryCount");
        $attr5.appendChild($node6);
        
        $element_GDEFFinishedEntryCount = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("XXX");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" articles finis en attente de r\u00e9vision.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Tableau r\u00e9sum\u00e9 des contributions");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hidden");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ContributorsTable");
        $attr4.appendChild($node5);
        
        $element_ContributorsTable = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("The most active contributor is ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("BestContributor");
        $attr7.appendChild($node8);
        
        $element_BestContributor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("John Doe");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode(" with ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("MaxContributions");
        $attr6.appendChild($node7);
        
        $element_MaxContributions = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node7 = document.createTextNode("X");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" contributions.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("The most active reviewer is ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("BestReviewer");
        $attr7.appendChild($node8);
        
        $element_BestReviewer = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("John Doe");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode(" with ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("MaxRevisions");
        $attr6.appendChild($node7);
        
        $element_MaxRevisions = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node7 = document.createTextNode("X");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" revisions.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ContributorsBoard");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Name");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Login");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Finished");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Reviewed");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Validated");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "colspan");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("2");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Total:");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("TotalFinished");
        $attr9.appendChild($node10);
        
        $element_TotalFinished = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("finished");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("TotalReviewed");
        $attr9.appendChild($node10);
        
        $element_TotalReviewed = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("reviewed");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("TotalValidated");
        $attr9.appendChild($node10);
        
        $element_TotalValidated = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("validated");
        $elem9.appendChild($node10);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("TemplateRow");
        $attr7.appendChild($node8);
        
        $element_TemplateRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("Name");
        $attr10.appendChild($node11);
        
        $element_Name = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("name");
        $elem10.appendChild($node11);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Login");
        $attr9.appendChild($node10);
        
        $element_Login = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("login");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Finished");
        $attr9.appendChild($node10);
        
        $element_Finished = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("finished");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Reviewed");
        $attr9.appendChild($node10);
        
        $element_Reviewed = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("reviewed");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Validated");
        $attr9.appendChild($node10);
        
        $element_Validated = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("validated");
        $elem9.appendChild($node10);
        
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
        return new WelcomeTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>BestContributor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementBestContributor() {
        return $element_BestContributor;
    }

    /**
     * Get the element with id <CODE>BestReviewer</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementBestReviewer() {
        return $element_BestReviewer;
    }

    /**
     * Get the element with id <CODE>ContributorsTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementContributorsTable() {
        return $element_ContributorsTable;
    }

    /**
     * Get the element with id <CODE>Finished</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFinished() {
        return $element_Finished;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>GDEFFinishedEntryCount</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGDEFFinishedEntryCount() {
        return $element_GDEFFinishedEntryCount;
    }

    /**
     * Get the element with id <CODE>GDEFReviewedEntryCount</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGDEFReviewedEntryCount() {
        return $element_GDEFReviewedEntryCount;
    }

    /**
     * Get the element with id <CODE>GDEFValidatedEntryCount</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGDEFValidatedEntryCount() {
        return $element_GDEFValidatedEntryCount;
    }

    /**
     * Get the element with id <CODE>LatestNewsContainer</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementLatestNewsContainer() {
        return $element_LatestNewsContainer;
    }

    /**
     * Get the element with id <CODE>LoggedName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLoggedName() {
        return $element_LoggedName;
    }

    /**
     * Get the element with id <CODE>LoggedTemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementLoggedTemplateRow() {
        return $element_LoggedTemplateRow;
    }

    /**
     * Get the element with id <CODE>LoggedUsers</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLoggedUsers() {
        return $element_LoggedUsers;
    }

    /**
     * Get the element with id <CODE>Login</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLogin() {
        return $element_Login;
    }

    /**
     * Get the element with id <CODE>MaxContributions</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementMaxContributions() {
        return $element_MaxContributions;
    }

    /**
     * Get the element with id <CODE>MaxRevisions</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementMaxRevisions() {
        return $element_MaxRevisions;
    }

    /**
     * Get the element with id <CODE>Name</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementName() {
        return $element_Name;
    }

    /**
     * Get the element with id <CODE>Reviewed</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementReviewed() {
        return $element_Reviewed;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>TotalFinished</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementTotalFinished() {
        return $element_TotalFinished;
    }

    /**
     * Get the element with id <CODE>TotalReviewed</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementTotalReviewed() {
        return $element_TotalReviewed;
    }

    /**
     * Get the element with id <CODE>TotalValidated</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementTotalValidated() {
        return $element_TotalValidated;
    }

    /**
     * Get the element with id <CODE>Validated</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementValidated() {
        return $element_Validated;
    }

    /**
     * Get the element with id <CODE>BestContributor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagBestContributor() {
        return $element_BestContributor;
    }

    /**
     * Get the element with id <CODE>BestReviewer</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagBestReviewer() {
        return $element_BestReviewer;
    }

    /**
     * Get the element with id <CODE>ContributorsTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContributorsTable() {
        return $element_ContributorsTable;
    }

    /**
     * Get the element with id <CODE>Finished</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFinished() {
        return $element_Finished;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>GDEFFinishedEntryCount</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGDEFFinishedEntryCount() {
        return $element_GDEFFinishedEntryCount;
    }

    /**
     * Get the element with id <CODE>GDEFReviewedEntryCount</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGDEFReviewedEntryCount() {
        return $element_GDEFReviewedEntryCount;
    }

    /**
     * Get the element with id <CODE>GDEFValidatedEntryCount</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGDEFValidatedEntryCount() {
        return $element_GDEFValidatedEntryCount;
    }

    /**
     * Get the element with id <CODE>LatestNewsContainer</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLatestNewsContainer() {
        return $element_LatestNewsContainer;
    }

    /**
     * Get the element with id <CODE>LoggedName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLoggedName() {
        return $element_LoggedName;
    }

    /**
     * Get the element with id <CODE>LoggedTemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLoggedTemplateRow() {
        return $element_LoggedTemplateRow;
    }

    /**
     * Get the element with id <CODE>LoggedUsers</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLoggedUsers() {
        return $element_LoggedUsers;
    }

    /**
     * Get the element with id <CODE>Login</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLogin() {
        return $element_Login;
    }

    /**
     * Get the element with id <CODE>MaxContributions</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMaxContributions() {
        return $element_MaxContributions;
    }

    /**
     * Get the element with id <CODE>MaxRevisions</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMaxRevisions() {
        return $element_MaxRevisions;
    }

    /**
     * Get the element with id <CODE>Name</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagName() {
        return $element_Name;
    }

    /**
     * Get the element with id <CODE>Reviewed</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviewed() {
        return $element_Reviewed;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>TotalFinished</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTotalFinished() {
        return $element_TotalFinished;
    }

    /**
     * Get the element with id <CODE>TotalReviewed</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTotalReviewed() {
        return $element_TotalReviewed;
    }

    /**
     * Get the element with id <CODE>TotalValidated</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTotalValidated() {
        return $element_TotalValidated;
    }

    /**
     * Get the element with id <CODE>Validated</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValidated() {
        return $element_Validated;
    }

    /**
     * Get the value of text child of element <CODE>BestContributor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextBestContributor(String text) {
        doSetText($element_BestContributor, text);
    }

    /**
     * Get the value of text child of element <CODE>BestReviewer</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextBestReviewer(String text) {
        doSetText($element_BestReviewer, text);
    }

    /**
     * Get the value of text child of element <CODE>ContributorsTable</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextContributorsTable(String text) {
        doSetText($element_ContributorsTable, text);
    }

    /**
     * Get the value of text child of element <CODE>Finished</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFinished(String text) {
        doSetText($element_Finished, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>GDEFFinishedEntryCount</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGDEFFinishedEntryCount(String text) {
        doSetText($element_GDEFFinishedEntryCount, text);
    }

    /**
     * Get the value of text child of element <CODE>GDEFReviewedEntryCount</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGDEFReviewedEntryCount(String text) {
        doSetText($element_GDEFReviewedEntryCount, text);
    }

    /**
     * Get the value of text child of element <CODE>GDEFValidatedEntryCount</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGDEFValidatedEntryCount(String text) {
        doSetText($element_GDEFValidatedEntryCount, text);
    }

    /**
     * Get the value of text child of element <CODE>LatestNewsContainer</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLatestNewsContainer(String text) {
        doSetText($element_LatestNewsContainer, text);
    }

    /**
     * Get the value of text child of element <CODE>LoggedName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLoggedName(String text) {
        doSetText($element_LoggedName, text);
    }

    /**
     * Get the value of text child of element <CODE>LoggedUsers</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLoggedUsers(String text) {
        doSetText($element_LoggedUsers, text);
    }

    /**
     * Get the value of text child of element <CODE>Login</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLogin(String text) {
        doSetText($element_Login, text);
    }

    /**
     * Get the value of text child of element <CODE>MaxContributions</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMaxContributions(String text) {
        doSetText($element_MaxContributions, text);
    }

    /**
     * Get the value of text child of element <CODE>MaxRevisions</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMaxRevisions(String text) {
        doSetText($element_MaxRevisions, text);
    }

    /**
     * Get the value of text child of element <CODE>Name</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextName(String text) {
        doSetText($element_Name, text);
    }

    /**
     * Get the value of text child of element <CODE>Reviewed</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviewed(String text) {
        doSetText($element_Reviewed, text);
    }

    /**
     * Get the value of text child of element <CODE>TotalFinished</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTotalFinished(String text) {
        doSetText($element_TotalFinished, text);
    }

    /**
     * Get the value of text child of element <CODE>TotalReviewed</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTotalReviewed(String text) {
        doSetText($element_TotalReviewed, text);
    }

    /**
     * Get the value of text child of element <CODE>TotalValidated</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTotalValidated(String text) {
        doSetText($element_TotalValidated, text);
    }

    /**
     * Get the value of text child of element <CODE>Validated</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextValidated(String text) {
        doSetText($element_Validated, text);
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
