/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlgdef.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlgdef/orig/ChangeAuthorTmpl.xhtml
 */
public class ChangeAuthorTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ChangeAuthorTmplXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.ChangeAuthorTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_AUTHOR;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_AuthorList;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ChangeAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_ContribList;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ContributionsCount;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_CreationDateList;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryIdList;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryListRow;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_HeadwordList;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_InputCreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_InputReviewDate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LOOKUP;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_NewAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_REVIEWER;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ReviewDateList;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ReviewerList;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_STATUS;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search1;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search1text;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Search2;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Search2text;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Status;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy1;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Strategy2;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_StrategyAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_StrategyCreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_StrategyReviewDate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserName;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_VOLUME;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    /**
     * Element name constant for AUTHOR
     */
    public static final String NAME_AUTHOR = "AUTHOR";

    /**
     * Element name constant for ChangeAuthor
     */
    public static final String NAME_ChangeAuthor = "ChangeAuthor";

    /**
     * Element name constant for CreationDate
     */
    public static final String NAME_CreationDate = "CreationDate";

    /**
     * Element name constant for LOOKUP
     */
    public static final String NAME_LOOKUP = "LOOKUP";

    /**
     * Element name constant for NewAuthor
     */
    public static final String NAME_NewAuthor = "NewAuthor";

    /**
     * Element name constant for REVIEWER
     */
    public static final String NAME_REVIEWER = "REVIEWER";

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
     * Element name constant for StrategyAuthor
     */
    public static final String NAME_StrategyAuthor = "StrategyAuthor";

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
    public static final Class XMLC_GENERATED_CLASS = ChangeAuthorTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlgdef/orig/ChangeAuthorTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ChangeAuthorTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ChangeAuthorTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ChangeAuthorTmplXHTMLImpl(ChangeAuthorTmplXHTMLImpl src) {
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
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UserName");
        $attr5.appendChild($node6);
        
        $element_UserName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("Name");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("'s Change Author Interface");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" formulaire de voir mot");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ChangeAuthor.po");
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
        $node6 = document.createTextNode("100%");
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
        
        $node9 = document.createTextNode("Status:");
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
        
        $node8 = document.createTextNode("\n     ");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "for");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AUTHOR");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Author ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("StrategyAuthor");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("StrategyAuthor");
        $attr8.appendChild($node9);
        
        $element_StrategyAuthor = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("is");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("0");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("is");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("begins with");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("1");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("begins with");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n\t\t\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AUTHOR");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AUTHOR");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("12");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $element_AUTHOR = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t\t\t");
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
        $node9 = document.createTextNode("REVIEWER");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("Reviewer:");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("REVIEWER");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("REVIEWER");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("12");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $element_REVIEWER = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t\t\t");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("bgcolor:#4682b4;");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n              Creation date (aaaa/mm/dd) is\n              ");
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
        
        $node8 = document.createTextNode("\n              Review date (aaaa/mm/dd) is\n              ");
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
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Change author of the ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ContributionsCount");
        $attr6.appendChild($node7);
        
        $element_ContributionsCount = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node7 = document.createTextNode("0");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" contributions");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "frame");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("hsides");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ContribList");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("entries");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $element_ContribList = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Headword");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Entry Id");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Author");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Creation");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Reviewer");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Revision");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Status");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("EntryListRow");
        $attr6.appendChild($node7);
        
        $element_EntryListRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("HeadwordList");
        $attr8.appendChild($node9);
        
        $element_HeadwordList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Contrib");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EntryIdList");
        $attr8.appendChild($node9);
        
        $element_EntryIdList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("EntryId");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AuthorList");
        $attr8.appendChild($node9);
        
        $element_AuthorList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Author");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("CreationDateList");
        $attr8.appendChild($node9);
        
        $element_CreationDateList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("CreationDate");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewerList");
        $attr8.appendChild($node9);
        
        $element_ReviewerList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Reviewer");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewDateList");
        $attr8.appendChild($node9);
        
        $element_ReviewDateList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("ReviewDate");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Status");
        $attr8.appendChild($node9);
        
        $element_Status = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Status");
        $elem8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("New author: ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("NewAuthor");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "name");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("NewAuthor");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "type");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $element_NewAuthor = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem7;$node6 = document.createTextNode(" ");
        $elem5.appendChild($node6);
        
        $node6 = document.createEntityReference("nbsp");
        $elem5.appendChild($node6);
        
        $node7 = document.createTextNode("\u00a0");
        $node6.appendChild($node7);
        
        $node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ChangeAuthor");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ChangeAuthor");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Change Author");
        $attr6.appendChild($node7);
        
        $element_ChangeAuthor = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node4 = document.createTextNode("\n\n");
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
        $node4 = document.createTextNode("frequence");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-frequence");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("frequence");
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
        $node4 = document.createTextNode("exact match");
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
        $node4 = document.createTextNode("prefix");
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
        $node4 = document.createTextNode("suffix");
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
        $node4 = document.createTextNode("substring");
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
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem1.appendChild($elem2);
        
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
        
        $node2 = document.createTextNode("\n                and\n\t\t\t");
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
        $node4 = document.createTextNode("frequence");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("gdef-est-frequence");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("frequence");
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
        $node4 = document.createTextNode("exact match");
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
        $node4 = document.createTextNode("prefix");
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
        $node4 = document.createTextNode("suffix");
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
        $node4 = document.createTextNode("substring");
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
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem1.appendChild($elem2);
        
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
        $node3 = document.createTextNode("Count");
        $attr2.appendChild($node3);
        
        $element_LOOKUP = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n            ");
        $elem1.appendChild($node2);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ChangeAuthorTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>AUTHOR</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementAUTHOR() {
        return $element_AUTHOR;
    }

    /**
     * Get the element with id <CODE>AuthorList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementAuthorList() {
        return $element_AuthorList;
    }

    /**
     * Get the element with id <CODE>ChangeAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementChangeAuthor() {
        return $element_ChangeAuthor;
    }

    /**
     * Get the element with id <CODE>ContribList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementContribList() {
        return $element_ContribList;
    }

    /**
     * Get the element with id <CODE>ContributionsCount</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementContributionsCount() {
        return $element_ContributionsCount;
    }

    /**
     * Get the element with id <CODE>CreationDateList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCreationDateList() {
        return $element_CreationDateList;
    }

    /**
     * Get the element with id <CODE>EntryIdList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryIdList() {
        return $element_EntryIdList;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>HeadwordList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementHeadwordList() {
        return $element_HeadwordList;
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
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>NewAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementNewAuthor() {
        return $element_NewAuthor;
    }

    /**
     * Get the element with id <CODE>REVIEWER</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementREVIEWER() {
        return $element_REVIEWER;
    }

    /**
     * Get the element with id <CODE>ReviewDateList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementReviewDateList() {
        return $element_ReviewDateList;
    }

    /**
     * Get the element with id <CODE>ReviewerList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementReviewerList() {
        return $element_ReviewerList;
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
     * Get the element with id <CODE>StrategyAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementStrategyAuthor() {
        return $element_StrategyAuthor;
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
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>AUTHOR</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAUTHOR() {
        return $element_AUTHOR;
    }

    /**
     * Get the element with id <CODE>AuthorList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthorList() {
        return $element_AuthorList;
    }

    /**
     * Get the element with id <CODE>ChangeAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagChangeAuthor() {
        return $element_ChangeAuthor;
    }

    /**
     * Get the element with id <CODE>ContribList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContribList() {
        return $element_ContribList;
    }

    /**
     * Get the element with id <CODE>ContributionsCount</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContributionsCount() {
        return $element_ContributionsCount;
    }

    /**
     * Get the element with id <CODE>CreationDateList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreationDateList() {
        return $element_CreationDateList;
    }

    /**
     * Get the element with id <CODE>EntryIdList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryIdList() {
        return $element_EntryIdList;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>HeadwordList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordList() {
        return $element_HeadwordList;
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
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>NewAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNewAuthor() {
        return $element_NewAuthor;
    }

    /**
     * Get the element with id <CODE>REVIEWER</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagREVIEWER() {
        return $element_REVIEWER;
    }

    /**
     * Get the element with id <CODE>ReviewDateList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviewDateList() {
        return $element_ReviewDateList;
    }

    /**
     * Get the element with id <CODE>ReviewerList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviewerList() {
        return $element_ReviewerList;
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
     * Get the element with id <CODE>StrategyAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStrategyAuthor() {
        return $element_StrategyAuthor;
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
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>AuthorList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAuthorList(String text) {
        doSetText($element_AuthorList, text);
    }

    /**
     * Get the value of text child of element <CODE>ContributionsCount</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextContributionsCount(String text) {
        doSetText($element_ContributionsCount, text);
    }

    /**
     * Get the value of text child of element <CODE>CreationDateList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCreationDateList(String text) {
        doSetText($element_CreationDateList, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryIdList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryIdList(String text) {
        doSetText($element_EntryIdList, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>HeadwordList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeadwordList(String text) {
        doSetText($element_HeadwordList, text);
    }

    /**
     * Get the value of text child of element <CODE>ReviewDateList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviewDateList(String text) {
        doSetText($element_ReviewDateList, text);
    }

    /**
     * Get the value of text child of element <CODE>ReviewerList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviewerList(String text) {
        doSetText($element_ReviewerList, text);
    }

    /**
     * Get the value of text child of element <CODE>Status</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextStatus(String text) {
        doSetText($element_Status, text);
    }

    /**
     * Get the value of text child of element <CODE>UserName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserName(String text) {
        doSetText($element_UserName, text);
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
