/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlgdef.est;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlgdef/est/AdminContributionsTmpl.xhtml
 */
public class AdminContributionsTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdminContributionsTmplXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.AdminContributionsTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_ContribList;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_Contributions;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ContributionsCount;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_CreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_CreationdateHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EditContrib;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_EditContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_EntryCell;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryId;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryListRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryRow;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_HeadwordHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_InputCreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_InputReviewDate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_IsNewEntry;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LOOKUP;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_MarkFinishedAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_NewentryHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_RESET;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RemoveContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_STATUS;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search1;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search1text;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search2;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search2text;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Status;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_StatusHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy1;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy2;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_StrategyCreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_StrategyReviewDate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserName;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_VOLUME;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ViewContribText;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewXmlAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    /**
     * Element name constant for CreationDate
     */
    public static final String NAME_CreationDate = "CreationDate";

    /**
     * Element name constant for LOOKUP
     */
    public static final String NAME_LOOKUP = "LOOKUP";

    /**
     * Element name constant for RESET
     */
    public static final String NAME_RESET = "RESET";

    /**
     * Element name constant for ReviewDate
     */
    public static final String NAME_ReviewDate = "ReviewDate";

    /**
     * Element name constant for STATUS
     */
    public static final String NAME_STATUS = "STATUS";

    /**
     * Element name constant for Strategy1
     */
    public static final String NAME_Strategy1 = "Strategy1";

    /**
     * Element name constant for Strategy2
     */
    public static final String NAME_Strategy2 = "Strategy2";

    /**
     * Element name constant for StrategyCreationDate
     */
    public static final String NAME_StrategyCreationDate = "StrategyCreationDate";

    /**
     * Element name constant for StrategyReviewDate
     */
    public static final String NAME_StrategyReviewDate = "StrategyReviewDate";

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
    public static final Class XMLC_GENERATED_CLASS = AdminContributionsTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlgdef/est/AdminContributionsTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdminContributionsTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdminContributionsTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdminContributionsTmplXHTMLImpl(AdminContributionsTmplXHTMLImpl src) {
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
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9;
        
        org.enhydra.apache.xerces.dom.DocumentTypeImpl docType = (org.enhydra.apache.xerces.dom.DocumentTypeImpl)fDOMFactory.createDocumentType("html", "-//W3C//Dtd XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", null);
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
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Gestion des contributions de ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UserName");
        $attr5.appendChild($node6);
        
        $element_UserName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("Name");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" formulaire de voir mot");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AdminContributions.po");
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
        
        $node10 = document.createTextNode("Volume");
        $elem9.appendChild($node10);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $node10 = document.createTextNode(":");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n            ");
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
        
        $attr8 = document.createAttributeNS("", "onchange");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("document.MainForm.submit()");
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
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "for");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STATUS");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Statut");
        $elem8.appendChild($node9);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createTextNode(":");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
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
        $node10 = document.createTextNode("tous");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("*ALL*");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("tous");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("non finie");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("not finished");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("non finie");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("finie");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("finished");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("finie");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("revisee");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("revised");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("r\u00e9vis\u00e9e");
        $elem9.appendChild($node10);
        
        $node9 = document.createComment("option value=\"validated\" label=\"validees\">valid\u00e9es</option");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n     ");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("bgcolor:#4682b4;");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n              La date de cr\u00e9ation (aaaa/mm/jj) est\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("StrategyCreationDate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("StrategyCreationDate");
        $attr8.appendChild($node9);
        
        $element_StrategyCreationDate = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("\u2264");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("14");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("\u2264");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("<");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("13");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode(">");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("=");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("0");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("=");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("\u2265");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("12");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("\u2265");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode(">");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("11");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode(">");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("InputCreationDate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("CreationDate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("10");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_InputCreationDate = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n             ");
        $elem7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t\t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("bgcolor:#4682b4;");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n              La date de r\u00e9vision (aaaa/mm/jj) est\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("StrategyReviewDate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("StrategyReviewDate");
        $attr8.appendChild($node9);
        
        $element_StrategyReviewDate = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("\u2264");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("14");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("\u2264");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("<");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("13");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode(">");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("=");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("0");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("=");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("\u2265");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("12");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("\u2265");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode(">");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("11");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode(">");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("InputReviewDate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewDate");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("10");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_InputReviewDate = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n            ");
        $elem7.appendChild($node8);
        
        buildSubDocument_0(document, $elem5);
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Voir les ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ContributionsCount");
        $attr5.appendChild($node6);
        
        $element_ContributionsCount = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("0");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" contributions");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "border");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("0");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "frame");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hsides");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ContribList");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("entries");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_ContribList = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("AdminContributions.po?LOOKUP=LOOKUP&SortBy=HEADWORD_SORT");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("HeadwordHeaderAnchor");
        $attr7.appendChild($node8);
        
        $element_HeadwordHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Voir");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Id");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("AdminContributions.po?LOOKUP=LOOKUP&SortBy=CREATION_DATE_SORT");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("CreationdateHeaderAnchor");
        $attr7.appendChild($node8);
        
        $element_CreationdateHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Cr\u00e9ation");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("AdminContributions.po?LOOKUP=LOOKUP&SortBy=ORIGINAL_CONTRIBUTION_ID_SORT");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("NewentryHeaderAnchor");
        $attr7.appendChild($node8);
        
        $element_NewentryHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Nouv.");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("AdminContributions.po?LOOKUP=LOOKUP&SortBy=STATUS_SORT");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("StatusHeaderAnchor");
        $attr7.appendChild($node8);
        
        $element_StatusHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Statut");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Marquer");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Voir");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createEntityReference("nbsp");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00a0");
        $node7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EntryListRow");
        $attr5.appendChild($node6);
        
        $element_EntryListRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ViewContribAnchor");
        $attr7.appendChild($node8);
        
        $element_ViewContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ViewContribText");
        $attr8.appendChild($node9);
        
        $element_ViewContribText = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Contrib");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("EntryId");
        $attr7.appendChild($node8);
        
        $element_EntryId = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("EntryId");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("CreationDate");
        $attr7.appendChild($node8);
        
        $element_CreationDate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("CreationDate");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("IsNewEntry");
        $attr7.appendChild($node8);
        
        $element_IsNewEntry = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("IsNewEntry");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Status");
        $attr7.appendChild($node8);
        
        $element_Status = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Status");
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
        $node8 = document.createTextNode("MarkFinishedAnchor");
        $attr7.appendChild($node8);
        
        $element_MarkFinishedAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Finie");
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
        $node8 = document.createTextNode("ViewXmlAnchor");
        $attr7.appendChild($node8);
        
        $element_ViewXmlAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("XML");
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
        $node8 = document.createTextNode("EditContribAnchor");
        $attr7.appendChild($node8);
        
        $element_EditContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EditContrib");
        $attr8.appendChild($node9);
        
        $element_EditContrib = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("\u00c9diter");
        $elem8.appendChild($node9);
        
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
        $node8 = document.createTextNode("RemoveContribAnchor");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "onclick");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("return confirm('\u00cates-vous s\u00fbr de vouloir supprimer la contribution ?')");
        $attr7.appendChild($node8);
        
        $element_RemoveContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Jeter");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "border");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("0");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "frame");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hsides");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Contributions");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("dicocontent");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_Contributions = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EntryRow");
        $attr5.appendChild($node6);
        
        $element_EntryRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("EntryCell");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "valign");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("top");
        $attr6.appendChild($node7);
        
        $element_EntryCell = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$node4 = document.createTextNode("\n");
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
        
        $node2 = document.createTextNode("\n              ");
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
        
        $element_Search1text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n\t\t\t  est\n\t\t\t\t");
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
        $node4 = document.createTextNode("exactement");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("0");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("exactement");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("prefixe de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("1");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("pr\u00e9fixe de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("suffixe de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("suffixe de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("sous-chaine de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("3");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("sous-cha\u00eene de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("exact hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("4");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("exact hors casse de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("prefix hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("5");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("pr\u00e9fixe hors casse de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("suffixe hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("6");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("suffixe hors casse de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("sous-chaine hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("7");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("sous-cha\u00eene hors casse de");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n              ");
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
        $node4 = document.createTextNode("le mot-vedette");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("le mot-vedette");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("la variante");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword-variant");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("la variante");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("la categorie");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-pos");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("la cat\u00e9gorie");
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
        
        $node4 = document.createTextNode("le domaine");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("la traduction");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-translation");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("la traduction");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("les exemples");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-example");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("les exemples");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("traductions d'expl.");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-exemple");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("les traductions d'expl.");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("les locutions");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("locutions");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("traductions de loc.");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("les traductions de loc.");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("tout l'article");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("AnyContains");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("tout l'article");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n            ");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("\n              et\n\t\t\t");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "style");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("bgcolor:#4682b4;");
        $attr1.appendChild($node2);
        
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
        
        $element_Search2text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n\t\t\t  est\n\t\t\t  ");
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
        $node4 = document.createTextNode("exactement");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("0");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("exactement");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("prefixe de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("1");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("pr\u00e9fixe de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("suffixe de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("suffixe de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("sous-chaine de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("3");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("sous-cha\u00eene de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("exact hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("4");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("exact hors casse de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("prefix hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("5");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("pr\u00e9fixe hors casse de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("suffixe hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("6");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("suffixe hors casse de");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("sous-chaine hors casse de");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("7");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("sous-cha\u00eene hors casse de");
        $elem3.appendChild($node4);
        
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
        $node4 = document.createTextNode("le mot-vedette");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("le mot-vedette");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("la variante");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-headword-variant");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("la variante");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("la categorie");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-pos");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("la cat\u00e9gorie");
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
        
        $node4 = document.createTextNode("le domaine");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("l'id de la traduction");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-translation-ref");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("l'id de la traduction");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("les exemples");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-example");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("les exemples");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("traductions d'expl.");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-exemple");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("les traductions d'expl.");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("les locutions");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("locutions");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("traductions de loc.");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-traduction-locution");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("les traductions de loc.");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("tout l'article");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("AnyContains");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("tout l'article");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n            ");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "style");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("bgcolor:#4682b4;");
        $attr1.appendChild($node2);
        
        $node2 = document.createTextNode("\n\t\t\t\t");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("LOOKUP");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("LOOKUP");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "type");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("submit");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "value");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Chercher");
        $attr2.appendChild($node3);
        
        $element_LOOKUP = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n\t\t\t\t");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem1.appendChild($elem2);
        
        $attr2 = document.createAttributeNS("", "id");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("RESET");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "name");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("RESET");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "type");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("submit");
        $attr2.appendChild($node3);
        
        $attr2 = document.createAttributeNS("", "value");
        $elem2.setAttributeNode($attr2);
        $node3 = document.createTextNode("Initialiser");
        $attr2.appendChild($node3);
        
        $element_RESET = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n            ");
        $elem1.appendChild($node2);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new AdminContributionsTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ContribList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementContribList() {
        return $element_ContribList;
    }

    /**
     * Get the element with id <CODE>Contributions</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementContributions() {
        return $element_Contributions;
    }

    /**
     * Get the element with id <CODE>ContributionsCount</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementContributionsCount() {
        return $element_ContributionsCount;
    }

    /**
     * Get the element with id <CODE>CreationDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCreationDate() {
        return $element_CreationDate;
    }

    /**
     * Get the element with id <CODE>CreationdateHeaderAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementCreationdateHeaderAnchor() {
        return $element_CreationdateHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>EditContrib</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEditContrib() {
        return $element_EditContrib;
    }

    /**
     * Get the element with id <CODE>EditContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementEditContribAnchor() {
        return $element_EditContribAnchor;
    }

    /**
     * Get the element with id <CODE>EntryCell</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementEntryCell() {
        return $element_EntryCell;
    }

    /**
     * Get the element with id <CODE>EntryId</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryId() {
        return $element_EntryId;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>EntryRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryRow() {
        return $element_EntryRow;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>HeadwordHeaderAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementHeadwordHeaderAnchor() {
        return $element_HeadwordHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>InputCreationDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementInputCreationDate() {
        return $element_InputCreationDate;
    }

    /**
     * Get the element with id <CODE>InputReviewDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementInputReviewDate() {
        return $element_InputReviewDate;
    }

    /**
     * Get the element with id <CODE>IsNewEntry</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementIsNewEntry() {
        return $element_IsNewEntry;
    }

    /**
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>MarkFinishedAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementMarkFinishedAnchor() {
        return $element_MarkFinishedAnchor;
    }

    /**
     * Get the element with id <CODE>NewentryHeaderAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementNewentryHeaderAnchor() {
        return $element_NewentryHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>RESET</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementRESET() {
        return $element_RESET;
    }

    /**
     * Get the element with id <CODE>RemoveContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementRemoveContribAnchor() {
        return $element_RemoveContribAnchor;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSTATUS() {
        return $element_STATUS;
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
     * Get the element with id <CODE>Status</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementStatus() {
        return $element_Status;
    }

    /**
     * Get the element with id <CODE>StatusHeaderAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementStatusHeaderAnchor() {
        return $element_StatusHeaderAnchor;
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
     * Get the element with id <CODE>StrategyCreationDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementStrategyCreationDate() {
        return $element_StrategyCreationDate;
    }

    /**
     * Get the element with id <CODE>StrategyReviewDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementStrategyReviewDate() {
        return $element_StrategyReviewDate;
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
     * Get the element with id <CODE>ViewContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewContribAnchor() {
        return $element_ViewContribAnchor;
    }

    /**
     * Get the element with id <CODE>ViewContribText</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementViewContribText() {
        return $element_ViewContribText;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>ContribList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContribList() {
        return $element_ContribList;
    }

    /**
     * Get the element with id <CODE>Contributions</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContributions() {
        return $element_Contributions;
    }

    /**
     * Get the element with id <CODE>ContributionsCount</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContributionsCount() {
        return $element_ContributionsCount;
    }

    /**
     * Get the element with id <CODE>CreationDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreationDate() {
        return $element_CreationDate;
    }

    /**
     * Get the element with id <CODE>CreationdateHeaderAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreationdateHeaderAnchor() {
        return $element_CreationdateHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>EditContrib</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditContrib() {
        return $element_EditContrib;
    }

    /**
     * Get the element with id <CODE>EditContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditContribAnchor() {
        return $element_EditContribAnchor;
    }

    /**
     * Get the element with id <CODE>EntryCell</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryCell() {
        return $element_EntryCell;
    }

    /**
     * Get the element with id <CODE>EntryId</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryId() {
        return $element_EntryId;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>EntryRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryRow() {
        return $element_EntryRow;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>HeadwordHeaderAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordHeaderAnchor() {
        return $element_HeadwordHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>InputCreationDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagInputCreationDate() {
        return $element_InputCreationDate;
    }

    /**
     * Get the element with id <CODE>InputReviewDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagInputReviewDate() {
        return $element_InputReviewDate;
    }

    /**
     * Get the element with id <CODE>IsNewEntry</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagIsNewEntry() {
        return $element_IsNewEntry;
    }

    /**
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>MarkFinishedAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMarkFinishedAnchor() {
        return $element_MarkFinishedAnchor;
    }

    /**
     * Get the element with id <CODE>NewentryHeaderAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNewentryHeaderAnchor() {
        return $element_NewentryHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>RESET</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRESET() {
        return $element_RESET;
    }

    /**
     * Get the element with id <CODE>RemoveContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveContribAnchor() {
        return $element_RemoveContribAnchor;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSTATUS() {
        return $element_STATUS;
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
     * Get the element with id <CODE>Status</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStatus() {
        return $element_Status;
    }

    /**
     * Get the element with id <CODE>StatusHeaderAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStatusHeaderAnchor() {
        return $element_StatusHeaderAnchor;
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
     * Get the element with id <CODE>StrategyCreationDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStrategyCreationDate() {
        return $element_StrategyCreationDate;
    }

    /**
     * Get the element with id <CODE>StrategyReviewDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStrategyReviewDate() {
        return $element_StrategyReviewDate;
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
     * Get the element with id <CODE>ViewContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewContribAnchor() {
        return $element_ViewContribAnchor;
    }

    /**
     * Get the element with id <CODE>ViewContribText</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewContribText() {
        return $element_ViewContribText;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>ContributionsCount</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextContributionsCount(String text) {
        doSetText($element_ContributionsCount, text);
    }

    /**
     * Get the value of text child of element <CODE>CreationDate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCreationDate(String text) {
        doSetText($element_CreationDate, text);
    }

    /**
     * Get the value of text child of element <CODE>CreationdateHeaderAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCreationdateHeaderAnchor(String text) {
        doSetText($element_CreationdateHeaderAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EditContrib</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditContrib(String text) {
        doSetText($element_EditContrib, text);
    }

    /**
     * Get the value of text child of element <CODE>EditContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditContribAnchor(String text) {
        doSetText($element_EditContribAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryCell</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryCell(String text) {
        doSetText($element_EntryCell, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryId</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryId(String text) {
        doSetText($element_EntryId, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>HeadwordHeaderAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeadwordHeaderAnchor(String text) {
        doSetText($element_HeadwordHeaderAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>IsNewEntry</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextIsNewEntry(String text) {
        doSetText($element_IsNewEntry, text);
    }

    /**
     * Get the value of text child of element <CODE>MarkFinishedAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMarkFinishedAnchor(String text) {
        doSetText($element_MarkFinishedAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>NewentryHeaderAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNewentryHeaderAnchor(String text) {
        doSetText($element_NewentryHeaderAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>RemoveContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRemoveContribAnchor(String text) {
        doSetText($element_RemoveContribAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Status</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextStatus(String text) {
        doSetText($element_Status, text);
    }

    /**
     * Get the value of text child of element <CODE>StatusHeaderAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextStatusHeaderAnchor(String text) {
        doSetText($element_StatusHeaderAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>UserName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserName(String text) {
        doSetText($element_UserName, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewContribAnchor(String text) {
        doSetText($element_ViewContribAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewContribText</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewContribText(String text) {
        doSetText($element_ViewContribText, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewXmlAnchor(String text) {
        doSetText($element_ViewXmlAnchor, text);
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
