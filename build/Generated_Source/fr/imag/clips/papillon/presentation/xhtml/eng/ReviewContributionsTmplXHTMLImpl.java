/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.eng;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/eng/ReviewContributionsTmpl.xhtml
 */
public class ReviewContributionsTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ReviewContributionsTmplXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.ReviewContributionsTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_AUTHOR;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Author;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_AuthorHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_ContribList;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_Contributions;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ContributionsCount;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_CreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_CreationdateHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_EditContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EditMessage;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_EntryCell;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryListRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryRow;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_HeadwordHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_InputCreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_InputReviewDate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_IntegrateContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LOOKUP;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_NextEntriesAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_PreviousEntriesAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_REVIEWER;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RemoveContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_RemoveMessage;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ReviewDate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ReviewdateHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Reviewer;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ReviewerHeaderAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ReviseContribAnchor;

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

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ValidateContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ViewContribText;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewXmlAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_VolumeName;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    /**
     * Class attribute constant for element class copyentry
     */
    public static final String CLASS_copyentry = "copyentry";

    /**
     * Class attribute constant for element class hidden
     */
    public static final String CLASS_hidden = "hidden";

    /**
     * Element name constant for AUTHOR
     */
    public static final String NAME_AUTHOR = "AUTHOR";

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
    public static final Class XMLC_GENERATED_CLASS = ReviewContributionsTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/eng/ReviewContributionsTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ReviewContributionsTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ReviewContributionsTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ReviewContributionsTmplXHTMLImpl(ReviewContributionsTmplXHTMLImpl src) {
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
        
        $node5 = document.createTextNode("'s Contributions Review Interface");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" formulaire de voir mot");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        buildSubDocument_0(document, $elem3);
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("View the ");
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
        
        $element_ContribList = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Volume");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewContributions.po?SortBy=AUTHOR_SORT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AuthorHeaderAnchor");
        $attr8.appendChild($node9);
        
        $element_AuthorHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Author");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewContributions.po?SortBy=HEADWORD_SORT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("HeadwordHeaderAnchor");
        $attr8.appendChild($node9);
        
        $element_HeadwordHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("View");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewContributions.po?SortBy=CREATION_DATE_SORT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("CreationdateHeaderAnchor");
        $attr8.appendChild($node9);
        
        $element_CreationdateHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Creation");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewContributions.po?SortBy=STATUS_SORT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("StatusHeaderAnchor");
        $attr8.appendChild($node9);
        
        $element_StatusHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Status");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("XML");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Edit");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Remove");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewContributions.po?SortBy=REVIEWER_SORT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewerHeaderAnchor");
        $attr8.appendChild($node9);
        
        $element_ReviewerHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Reviewer");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewContributions.po?SortBy=REVIEW_DATE_SORT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewdateHeaderAnchor");
        $attr8.appendChild($node9);
        
        $element_ReviewdateHeaderAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Review");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Action");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "align");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("center");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("11");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PreviousEntriesAnchor");
        $attr8.appendChild($node9);
        
        $element_PreviousEntriesAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("<< Get previous entries <<");
        $elem8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "align");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("center");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("11");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NextEntriesAnchor");
        $attr8.appendChild($node9);
        
        $element_NextEntriesAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode(">> Get next entries >>");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "align");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("left");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("11");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Note: Contributions with ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "class");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("copyentry");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("this style");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode(" are copies of existing entries");
        $elem8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem4.appendChild($elem5);
        
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
        $node9 = document.createTextNode("VolumeName");
        $attr8.appendChild($node9);
        
        $element_VolumeName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Volume");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Author");
        $attr8.appendChild($node9);
        
        $element_Author = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Author");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ViewContribAnchor");
        $attr8.appendChild($node9);
        
        $element_ViewContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("ViewContribText");
        $attr9.appendChild($node10);
        
        $element_ViewContribText = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("Contrib");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("CreationDate");
        $attr8.appendChild($node9);
        
        $element_CreationDate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("date");
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
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ViewXmlAnchor");
        $attr8.appendChild($node9);
        
        $element_ViewXmlAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("View");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EditContribAnchor");
        $attr8.appendChild($node9);
        
        $element_EditContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("EditMessage");
        $attr9.appendChild($node10);
        
        $element_EditMessage = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("Edit");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("RemoveContribAnchor");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "onclick");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("return confirm('Are you sure you want to remove the contribution?')");
        $attr8.appendChild($node9);
        
        $element_RemoveContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("RemoveMessage");
        $attr9.appendChild($node10);
        
        $element_RemoveMessage = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("Remove");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Reviewer");
        $attr8.appendChild($node9);
        
        $element_Reviewer = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Reviewer");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviewDate");
        $attr8.appendChild($node9);
        
        $element_ReviewDate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("ReviewDate");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ReviseContribAnchor");
        $attr8.appendChild($node9);
        
        $element_ReviseContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Review");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ValidateContribAnchor");
        $attr8.appendChild($node9);
        
        $element_ValidateContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Validate");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("IntegrateContribAnchor");
        $attr8.appendChild($node9);
        
        $element_IntegrateContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("Integrate");
        $elem8.appendChild($node9);
        
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
        
        $element_EntryCell = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem6;$node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "action");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("ReviewContributions.po");
        $attr0.appendChild($node1);
        
        $attr0 = document.createAttributeNS("", "method");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("get");
        $attr0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "border");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("0");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "cellpadding");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("10");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "cellspacing");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("0");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "summary");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("Formulaire");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "width");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("600");
        $attr1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "for");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("VOLUME");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Volume:");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("VOLUME");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("VOLUME");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "onchange");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("document.MainForm.submit()");
        $attr4.appendChild($node5);
        
        $element_VOLUME = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("VolumeOptionTemplate");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NONE");
        $attr5.appendChild($node6);
        
        $element_VolumeOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem5;$node6 = document.createTextNode("NONE");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "for");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("STATUS");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Status:");
        $elem4.appendChild($node5);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("STATUS");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("STATUS");
        $attr4.appendChild($node5);
        
        $element_STATUS = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("tous");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("*ALL*");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("all");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("not finished");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("not finished");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("not finished");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("finished");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("finished");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("finished");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("revised");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("revised");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("revised");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n     ");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "for");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AUTHOR");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Author:");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AUTHOR");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("AUTHOR");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("12");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text");
        $attr4.appendChild($node5);
        
        $element_AUTHOR = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n\t\t\t");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "for");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("REVIEWER");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Reviewer:");
        $elem4.appendChild($node5);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n\t\t\t\t");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("REVIEWER");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("REVIEWER");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("12");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text");
        $attr4.appendChild($node5);
        
        $element_REVIEWER = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n\t\t\t");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "style");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("bgcolor:#4682b4;");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n              Creation date (aaaa/mm/dd) is\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("StrategyCreationDate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("StrategyCreationDate");
        $attr4.appendChild($node5);
        
        $element_StrategyCreationDate = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u2264");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("14");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u2264");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("<");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("13");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode(">");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("=");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("=");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u2265");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("12");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u2265");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode(">");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("11");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode(">");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("InputCreationDate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("CreationDate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("10");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_InputCreationDate = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("\n             ");
        $elem3.appendChild($node4);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\t\t\t");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "style");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("bgcolor:#4682b4;");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n              Review date (aaaa/mm/dd) is\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("StrategyReviewDate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("StrategyReviewDate");
        $attr4.appendChild($node5);
        
        $element_StrategyReviewDate = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u2264");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("14");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u2264");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("<");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("13");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode(">");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("=");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("=");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u2265");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("12");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u2265");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "label");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode(">");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("11");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode(">");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n              ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("InputReviewDate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ReviewDate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("10");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_InputReviewDate = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        buildSubDocument_0_0(document, $elem1);
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0_0(org.w3c.dom.Document document,
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
        
        $node2 = document.createTextNode("\n               ");
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
        
        $element_Search1text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n\t\t\t   is \n              ");
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
        
        $node4 = document.createTextNode("exact match");
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
        
        $node4 = document.createTextNode("prefix");
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
        
        $node4 = document.createTextNode("suffix");
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
        
        $node4 = document.createTextNode("substring");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("case insensitive");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("4");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("case insensitive");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("insensitive prefix");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("5");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("insensitive prefix");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("insensitive suffix");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("6");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("insensitive suffix");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("insensitive substring");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("7");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("insensitive substring");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n\t\t\t  of\n             ");
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
        $node4 = document.createTextNode("pronunciation");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-pronunciation");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("pronunciation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("reading");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-reading");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("reading");
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
        
        $node4 = document.createTextNode("examples");
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
        
        $node2 = document.createTextNode("\n            ");
        $elem1.appendChild($node2);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem0.appendChild($elem1);
        
        $node2 = document.createTextNode("\n              and\n\t\t\t");
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
        
        $element_Search2text = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n\t\t\t  is\n              ");
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
        
        $node4 = document.createTextNode("exact match");
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
        
        $node4 = document.createTextNode("prefix");
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
        
        $node4 = document.createTextNode("suffix");
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
        
        $node4 = document.createTextNode("substring");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("case insensitive");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("4");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("case insensitive");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("insensitive prefix");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("5");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("insensitive prefix");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("insensitive suffix");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("6");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("insensitive suffix");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("insensitive substring");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("7");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("insensitive substring");
        $elem3.appendChild($node4);
        
        $node2 = document.createTextNode("\n\t\t\t  of\n              ");
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
        $node4 = document.createTextNode("pronunciation");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-pronunciation");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("pronunciation");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "label");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("reading");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "value");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("cdm-reading");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("reading");
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
        
        $node4 = document.createTextNode("examples");
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
        $node3 = document.createTextNode("Lookup");
        $attr2.appendChild($node3);
        
        $element_LOOKUP = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem2;$node2 = document.createTextNode("\n\t\t\t\t");
        $elem1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem1.appendChild($elem2);
        
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
        $node3 = document.createTextNode("Reset");
        $attr2.appendChild($node3);
        
        $node2 = document.createTextNode("\n            ");
        $elem1.appendChild($node2);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ReviewContributionsTmplXHTMLImpl(this);
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
     * Get the element with id <CODE>Author</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementAuthor() {
        return $element_Author;
    }

    /**
     * Get the element with id <CODE>AuthorHeaderAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementAuthorHeaderAnchor() {
        return $element_AuthorHeaderAnchor;
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
     * Get the element with id <CODE>EditContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementEditContribAnchor() {
        return $element_EditContribAnchor;
    }

    /**
     * Get the element with id <CODE>EditMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEditMessage() {
        return $element_EditMessage;
    }

    /**
     * Get the element with id <CODE>EntryCell</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementEntryCell() {
        return $element_EntryCell;
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
     * Get the element with id <CODE>IntegrateContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementIntegrateContribAnchor() {
        return $element_IntegrateContribAnchor;
    }

    /**
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>NextEntriesAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementNextEntriesAnchor() {
        return $element_NextEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementPreviousEntriesAnchor() {
        return $element_PreviousEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>REVIEWER</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementREVIEWER() {
        return $element_REVIEWER;
    }

    /**
     * Get the element with id <CODE>RemoveContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementRemoveContribAnchor() {
        return $element_RemoveContribAnchor;
    }

    /**
     * Get the element with id <CODE>RemoveMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementRemoveMessage() {
        return $element_RemoveMessage;
    }

    /**
     * Get the element with id <CODE>ReviewDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementReviewDate() {
        return $element_ReviewDate;
    }

    /**
     * Get the element with id <CODE>ReviewdateHeaderAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementReviewdateHeaderAnchor() {
        return $element_ReviewdateHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>Reviewer</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementReviewer() {
        return $element_Reviewer;
    }

    /**
     * Get the element with id <CODE>ReviewerHeaderAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementReviewerHeaderAnchor() {
        return $element_ReviewerHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>ReviseContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementReviseContribAnchor() {
        return $element_ReviseContribAnchor;
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
     * Get the element with id <CODE>ValidateContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementValidateContribAnchor() {
        return $element_ValidateContribAnchor;
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
     * Get the element with id <CODE>VolumeName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementVolumeName() {
        return $element_VolumeName;
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
     * Get the element with id <CODE>Author</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthor() {
        return $element_Author;
    }

    /**
     * Get the element with id <CODE>AuthorHeaderAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAuthorHeaderAnchor() {
        return $element_AuthorHeaderAnchor;
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
     * Get the element with id <CODE>EditContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditContribAnchor() {
        return $element_EditContribAnchor;
    }

    /**
     * Get the element with id <CODE>EditMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditMessage() {
        return $element_EditMessage;
    }

    /**
     * Get the element with id <CODE>EntryCell</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryCell() {
        return $element_EntryCell;
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
     * Get the element with id <CODE>IntegrateContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagIntegrateContribAnchor() {
        return $element_IntegrateContribAnchor;
    }

    /**
     * Get the element with id <CODE>LOOKUP</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLOOKUP() {
        return $element_LOOKUP;
    }

    /**
     * Get the element with id <CODE>NextEntriesAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNextEntriesAnchor() {
        return $element_NextEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPreviousEntriesAnchor() {
        return $element_PreviousEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>REVIEWER</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagREVIEWER() {
        return $element_REVIEWER;
    }

    /**
     * Get the element with id <CODE>RemoveContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveContribAnchor() {
        return $element_RemoveContribAnchor;
    }

    /**
     * Get the element with id <CODE>RemoveMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRemoveMessage() {
        return $element_RemoveMessage;
    }

    /**
     * Get the element with id <CODE>ReviewDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviewDate() {
        return $element_ReviewDate;
    }

    /**
     * Get the element with id <CODE>ReviewdateHeaderAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviewdateHeaderAnchor() {
        return $element_ReviewdateHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>Reviewer</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviewer() {
        return $element_Reviewer;
    }

    /**
     * Get the element with id <CODE>ReviewerHeaderAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviewerHeaderAnchor() {
        return $element_ReviewerHeaderAnchor;
    }

    /**
     * Get the element with id <CODE>ReviseContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReviseContribAnchor() {
        return $element_ReviseContribAnchor;
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
     * Get the element with id <CODE>ValidateContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValidateContribAnchor() {
        return $element_ValidateContribAnchor;
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
     * Get the element with id <CODE>VolumeName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeName() {
        return $element_VolumeName;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>Author</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAuthor(String text) {
        doSetText($element_Author, text);
    }

    /**
     * Get the value of text child of element <CODE>AuthorHeaderAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAuthorHeaderAnchor(String text) {
        doSetText($element_AuthorHeaderAnchor, text);
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
     * Get the value of text child of element <CODE>EditContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditContribAnchor(String text) {
        doSetText($element_EditContribAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EditMessage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditMessage(String text) {
        doSetText($element_EditMessage, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryCell</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryCell(String text) {
        doSetText($element_EntryCell, text);
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
     * Get the value of text child of element <CODE>IntegrateContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextIntegrateContribAnchor(String text) {
        doSetText($element_IntegrateContribAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>NextEntriesAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNextEntriesAnchor(String text) {
        doSetText($element_NextEntriesAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPreviousEntriesAnchor(String text) {
        doSetText($element_PreviousEntriesAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>RemoveContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRemoveContribAnchor(String text) {
        doSetText($element_RemoveContribAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>RemoveMessage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRemoveMessage(String text) {
        doSetText($element_RemoveMessage, text);
    }

    /**
     * Get the value of text child of element <CODE>ReviewDate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviewDate(String text) {
        doSetText($element_ReviewDate, text);
    }

    /**
     * Get the value of text child of element <CODE>ReviewdateHeaderAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviewdateHeaderAnchor(String text) {
        doSetText($element_ReviewdateHeaderAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Reviewer</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviewer(String text) {
        doSetText($element_Reviewer, text);
    }

    /**
     * Get the value of text child of element <CODE>ReviewerHeaderAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviewerHeaderAnchor(String text) {
        doSetText($element_ReviewerHeaderAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ReviseContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReviseContribAnchor(String text) {
        doSetText($element_ReviseContribAnchor, text);
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
     * Get the value of text child of element <CODE>ValidateContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextValidateContribAnchor(String text) {
        doSetText($element_ValidateContribAnchor, text);
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
     * Get the value of text child of element <CODE>VolumeName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeName(String text) {
        doSetText($element_VolumeName, text);
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
