/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlpivax.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlpivax/orig/ViewQueryResult.xhtml
 */
public class ViewQueryResultXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ViewQueryResultXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ActionsNode;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ContributionNode;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_DeleteEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_DuplicateEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_EditEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_EntryContent;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_EntryContentTable;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_EntryContentTableColume;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryContentTableRow;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_EntryNode;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryStatus;

    private org.enhydra.xml.xhtml.dom.XHTMLLIElement $element_HintContent;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HintShow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LabelHint;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_LangContent;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_LangContentTable;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_LangContentTableHeading;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_LangName;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_LeftChange;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_LinkContent;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_LinkContentColume;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_LinkContentRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_MainColume;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_MainRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_MainTable;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_MinusWeight;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_NbResults;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_NextAnchorBottom;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_NextAnchorTop;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_PlusWeight;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_PreviousAnchorBottom;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_PreviousAnchorTop;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_QuickListAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_RightChange;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_SystemName;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_SystemTable;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_SystemTableHeading;

    private org.enhydra.xml.xhtml.dom.XHTMLTableCellElement $element_TmpLang;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TmpRow;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_UndeleteEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewHistoryEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewXmlAnchor;

    /**
     * Class attribute constant for element class action
     */
    public static final String CLASS_action = "action";

    /**
     * Class attribute constant for element class action_list
     */
    public static final String CLASS_action_list = "action_list";

    /**
     * Class attribute constant for element class contribution
     */
    public static final String CLASS_contribution = "contribution";

    /**
     * Class attribute constant for element class entry
     */
    public static final String CLASS_entry = "entry";

    /**
     * Class attribute constant for element class entry_actions
     */
    public static final String CLASS_entry_actions = "entry_actions";

    /**
     * Class attribute constant for element class hint
     */
    public static final String CLASS_hint = "hint";

    /**
     * Class attribute constant for element class jibiki_author
     */
    public static final String CLASS_jibiki_author = "jibiki_author";

    /**
     * Class attribute constant for element class jibiki_byAuthor
     */
    public static final String CLASS_jibiki_byAuthor = "jibiki_byAuthor";

    /**
     * Class attribute constant for element class jibiki_status
     */
    public static final String CLASS_jibiki_status = "jibiki_status";

    /**
     * Class attribute constant for element class label_main
     */
    public static final String CLASS_label_main = "label_main";

    /**
     * Class attribute constant for element class systemName
     */
    public static final String CLASS_systemName = "systemName";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ViewQueryResultXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlpivax/orig/ViewQueryResult.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ViewQueryResultXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ViewQueryResultXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ViewQueryResultXHTMLImpl(ViewQueryResultXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9, $node10, $node11, $node12, $node13, $node14, $node15, $node16, $node17, $node18, $node19, $node20, $node21, $node22;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9, $elem10, $elem11, $elem12, $elem13, $elem14, $elem15, $elem16, $elem17, $elem18, $elem19, $elem20, $elem21;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9, $attr10, $attr11, $attr12, $attr13, $attr14, $attr15, $attr16, $attr17, $attr18, $attr19, $attr20, $attr21;
        
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
        
        $node4 = document.createTextNode("Query result");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("QueryResultForm");
        $attr3.appendChild($node4);
        
        $element_QueryResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("NbResults");
        $attr4.appendChild($node5);
        
        $element_NbResults = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("no");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" entry(ies) retrieved.");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text-align: left;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("PreviousAnchorTop");
        $attr7.appendChild($node8);
        
        $element_PreviousAnchorTop = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Previous entries");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text-align: right;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("NextAnchorTop");
        $attr7.appendChild($node8);
        
        $element_NextAnchorTop = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Next entries");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n                ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("contribution");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ContributionNode");
        $attr5.appendChild($node6);
        
        $element_ContributionNode = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("action_list");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ActionsNode");
        $attr6.appendChild($node7);
        
        $element_ActionsNode = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem6;$node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("mainTable");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "width");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("100%");
        $attr7.appendChild($node8);
        
        $element_MainTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("mainRow");
        $attr8.appendChild($node9);
        
        $element_MainRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("mainColume");
        $attr9.appendChild($node10);
        
        $element_MainColume = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem9;$node10 = document.createTextNode("\n                                    ");
        $elem9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("systemTable");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "width");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("100%");
        $attr10.appendChild($node11);
        
        $element_SystemTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem10;$elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "align");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("left");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("systemTableHeading");
        $attr11.appendChild($node12);
        
        $element_SystemTableHeading = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem11;$elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "colspan");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("1");
        $attr12.appendChild($node13);
        
        $node13 = document.createTextNode("\n                                                ");
        $elem12.appendChild($node13);
        
        $elem13 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem12.appendChild($elem13);
        
        $attr13 = document.createAttributeNS("", "class");
        $elem13.setAttributeNode($attr13);
        $node14 = document.createTextNode("systemName");
        $attr13.appendChild($node14);
        
        $attr13 = document.createAttributeNS("", "id");
        $elem13.setAttributeNode($attr13);
        $node14 = document.createTextNode("systemName");
        $attr13.appendChild($node14);
        
        $element_SystemName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem13;$node14 = document.createTextNode("systemName");
        $elem13.appendChild($node14);
        
        $node13 = document.createTextNode("\n                                            ");
        $elem12.appendChild($node13);
        
        $elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "align");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("left");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("tmpRow");
        $attr11.appendChild($node12);
        
        $attr11 = document.createAttributeNS("", "valign");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("top");
        $attr11.appendChild($node12);
        
        $element_TmpRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem11;$elem12 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem11.appendChild($elem12);
        
        $attr12 = document.createAttributeNS("", "align");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("left");
        $attr12.appendChild($node13);
        
        $attr12 = document.createAttributeNS("", "id");
        $elem12.setAttributeNode($attr12);
        $node13 = document.createTextNode("tmpLang");
        $attr12.appendChild($node13);
        
        $element_TmpLang = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem12;$node13 = document.createTextNode("\n                                                ");
        $elem12.appendChild($node13);
        
        $elem13 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem12.appendChild($elem13);
        
        $attr13 = document.createAttributeNS("", "border");
        $elem13.setAttributeNode($attr13);
        $node14 = document.createTextNode("1");
        $attr13.appendChild($node14);
        
        $attr13 = document.createAttributeNS("", "cellpadding");
        $elem13.setAttributeNode($attr13);
        $node14 = document.createTextNode("5");
        $attr13.appendChild($node14);
        
        $attr13 = document.createAttributeNS("", "cellspacing");
        $elem13.setAttributeNode($attr13);
        $node14 = document.createTextNode("0");
        $attr13.appendChild($node14);
        
        $attr13 = document.createAttributeNS("", "id");
        $elem13.setAttributeNode($attr13);
        $node14 = document.createTextNode("langContentTable");
        $attr13.appendChild($node14);
        
        $attr13 = document.createAttributeNS("", "width");
        $elem13.setAttributeNode($attr13);
        $node14 = document.createTextNode("100%");
        $attr13.appendChild($node14);
        
        $element_LangContentTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem13;$elem14 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem13.appendChild($elem14);
        
        $attr14 = document.createAttributeNS("", "id");
        $elem14.setAttributeNode($attr14);
        $node15 = document.createTextNode("langContentTableHeading");
        $attr14.appendChild($node15);
        
        $element_LangContentTableHeading = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem14;$elem15 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem14.appendChild($elem15);
        
        $attr15 = document.createAttributeNS("", "align");
        $elem15.setAttributeNode($attr15);
        $node16 = document.createTextNode("center");
        $attr15.appendChild($node16);
        
        $node16 = document.createTextNode("\n                                                            ");
        $elem15.appendChild($node16);
        
        $elem16 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem15.appendChild($elem16);
        
        $elem17 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem16.appendChild($elem17);
        
        $elem18 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem17.appendChild($elem18);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "href");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("javascript:void(0)");
        $attr19.appendChild($node20);
        
        $attr19 = document.createAttributeNS("", "id");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("leftChange");
        $attr19.appendChild($node20);
        
        $element_LeftChange = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem19;$node20 = document.createTextNode("<");
        $elem19.appendChild($node20);
        
        $elem18 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem17.appendChild($elem18);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "href");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("javascript:void(0)");
        $attr19.appendChild($node20);
        
        $attr19 = document.createAttributeNS("", "id");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("minusWeight");
        $attr19.appendChild($node20);
        
        $element_MinusWeight = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem19;$node20 = document.createTextNode("-");
        $elem19.appendChild($node20);
        
        $elem18 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem17.appendChild($elem18);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "id");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("langName");
        $attr19.appendChild($node20);
        
        $element_LangName = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem19;$node20 = document.createTextNode("lang");
        $elem19.appendChild($node20);
        
        $elem18 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem17.appendChild($elem18);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "href");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("javascript:void(0)");
        $attr19.appendChild($node20);
        
        $attr19 = document.createAttributeNS("", "id");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("plusWeight");
        $attr19.appendChild($node20);
        
        $element_PlusWeight = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem19;$node20 = document.createTextNode("+");
        $elem19.appendChild($node20);
        
        $elem18 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem17.appendChild($elem18);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "href");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("javascript:void(0)");
        $attr19.appendChild($node20);
        
        $attr19 = document.createAttributeNS("", "id");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("rightChange");
        $attr19.appendChild($node20);
        
        $element_RightChange = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem19;$node20 = document.createTextNode(">");
        $elem19.appendChild($node20);
        
        $node16 = document.createTextNode("\n                                                        ");
        $elem15.appendChild($node16);
        
        $elem14 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem13.appendChild($elem14);
        
        $attr14 = document.createAttributeNS("", "id");
        $elem14.setAttributeNode($attr14);
        $node15 = document.createTextNode("langContent");
        $attr14.appendChild($node15);
        
        $element_LangContent = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem14;$elem15 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem14.appendChild($elem15);
        
        $node16 = document.createTextNode("\n                                                            ");
        $elem15.appendChild($node16);
        
        $elem16 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem15.appendChild($elem16);
        
        $attr16 = document.createAttributeNS("", "border");
        $elem16.setAttributeNode($attr16);
        $node17 = document.createTextNode("0");
        $attr16.appendChild($node17);
        
        $attr16 = document.createAttributeNS("", "id");
        $elem16.setAttributeNode($attr16);
        $node17 = document.createTextNode("entryContentTable");
        $attr16.appendChild($node17);
        
        $attr16 = document.createAttributeNS("", "width");
        $elem16.setAttributeNode($attr16);
        $node17 = document.createTextNode("100%");
        $attr16.appendChild($node17);
        
        $element_EntryContentTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem16;$elem17 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem16.appendChild($elem17);
        
        $attr17 = document.createAttributeNS("", "id");
        $elem17.setAttributeNode($attr17);
        $node18 = document.createTextNode("entryContentTableRow");
        $attr17.appendChild($node18);
        
        $element_EntryContentTableRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem17;$elem18 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem17.appendChild($elem18);
        
        $attr18 = document.createAttributeNS("", "id");
        $elem18.setAttributeNode($attr18);
        $node19 = document.createTextNode("entryContentTableColume");
        $attr18.appendChild($node19);
        
        $element_EntryContentTableColume = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem18;$node19 = document.createTextNode("\n                                                                        ");
        $elem18.appendChild($node19);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "class");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("entry");
        $attr19.appendChild($node20);
        
        $attr19 = document.createAttributeNS("", "id");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("EntryNode");
        $attr19.appendChild($node20);
        
        $element_EntryNode = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem19;$node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("entryContent");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "title");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $element_EntryContent = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("content");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                        ");
        $elem19.appendChild($node20);
        
        $node19 = document.createTextNode("\n                                                                        ");
        $elem18.appendChild($node19);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "class");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("hint");
        $attr19.appendChild($node20);
        
        $attr19 = document.createAttributeNS("", "id");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("hintShow");
        $attr19.appendChild($node20);
        
        $element_HintShow = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem19;$node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("label_main");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("labelHint");
        $attr20.appendChild($node21);
        
        $element_LabelHint = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem20;$node21 = document.createTextNode("hint label");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem19.appendChild($elem20);
        
        $elem21 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem20.appendChild($elem21);
        
        $attr21 = document.createAttributeNS("", "id");
        $elem21.setAttributeNode($attr21);
        $node22 = document.createTextNode("hintContent");
        $attr21.appendChild($node22);
        
        $element_HintContent = (org.enhydra.xml.xhtml.dom.XHTMLLIElement)$elem21;$node22 = document.createTextNode("hint Content");
        $elem21.appendChild($node22);
        
        $node20 = document.createTextNode("\n                                                                        ");
        $elem19.appendChild($node20);
        
        $node19 = document.createTextNode("\n                                                                    ");
        $elem18.appendChild($node19);
        
        $node16 = document.createTextNode("\n                                                            ");
        $elem15.appendChild($node16);
        
        $elem16 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem15.appendChild($elem16);
        
        $attr16 = document.createAttributeNS("", "id");
        $elem16.setAttributeNode($attr16);
        $node17 = document.createTextNode("linkContent");
        $attr16.appendChild($node17);
        
        $element_LinkContent = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem16;$elem17 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem16.appendChild($elem17);
        
        $attr17 = document.createAttributeNS("", "id");
        $elem17.setAttributeNode($attr17);
        $node18 = document.createTextNode("linkContentRow");
        $attr17.appendChild($node18);
        
        $attr17 = document.createAttributeNS("", "style");
        $elem17.setAttributeNode($attr17);
        $node18 = document.createTextNode("background-color:grey;font-size:10pt");
        $attr17.appendChild($node18);
        
        $element_LinkContentRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem17;$elem18 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem17.appendChild($elem18);
        
        $attr18 = document.createAttributeNS("", "align");
        $elem18.setAttributeNode($attr18);
        $node19 = document.createTextNode("center");
        $attr18.appendChild($node19);
        
        $attr18 = document.createAttributeNS("", "id");
        $elem18.setAttributeNode($attr18);
        $node19 = document.createTextNode("linkContentColume");
        $attr18.appendChild($node19);
        
        $element_LinkContentColume = (org.enhydra.xml.xhtml.dom.XHTMLTableCellElement)$elem18;$node19 = document.createTextNode("\n                                                                        ");
        $elem18.appendChild($node19);
        
        $elem19 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem18.appendChild($elem19);
        
        $attr19 = document.createAttributeNS("", "class");
        $elem19.setAttributeNode($attr19);
        $node20 = document.createTextNode("entry_actions");
        $attr19.appendChild($node20);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("jibiki_status");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("EntryStatus");
        $attr20.appendChild($node21);
        
        $element_EntryStatus = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem20;$node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("jibiki_byAuthor");
        $attr20.appendChild($node21);
        
        $elem21 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem20.appendChild($elem21);
        
        $attr21 = document.createAttributeNS("", "class");
        $elem21.setAttributeNode($attr21);
        $node22 = document.createTextNode("jibiki_author");
        $attr21.appendChild($node22);
        
        $attr21 = document.createAttributeNS("", "id");
        $elem21.setAttributeNode($attr21);
        $node22 = document.createTextNode("EntryAuthor");
        $attr21.appendChild($node22);
        
        $element_EntryAuthor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem21;$node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("action");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("EditEntryAnchor");
        $attr20.appendChild($node21);
        
        $element_EditEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("edit");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("action");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("DuplicateEntryAnchor");
        $attr20.appendChild($node21);
        
        $element_DuplicateEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("duplicate");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("action");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("DeleteEntryAnchor");
        $attr20.appendChild($node21);
        
        $element_DeleteEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("delete");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("action");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("UndeleteEntryAnchor");
        $attr20.appendChild($node21);
        
        $element_UndeleteEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("undelete");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("action");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("ViewHistoryEntryAnchor");
        $attr20.appendChild($node21);
        
        $element_ViewHistoryEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("history");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("action");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("ViewXmlAnchor");
        $attr20.appendChild($node21);
        
        $element_ViewXmlAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("more");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                            ");
        $elem19.appendChild($node20);
        
        $elem20 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem19.appendChild($elem20);
        
        $attr20 = document.createAttributeNS("", "class");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("action");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "href");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("javascript:void(0)");
        $attr20.appendChild($node21);
        
        $attr20 = document.createAttributeNS("", "id");
        $elem20.setAttributeNode($attr20);
        $node21 = document.createTextNode("QuickListAnchor");
        $attr20.appendChild($node21);
        
        $element_QuickListAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem20;$node21 = document.createTextNode("+");
        $elem20.appendChild($node21);
        
        $node20 = document.createTextNode("\n                                                                        ");
        $elem19.appendChild($node20);
        
        $node19 = document.createTextNode("\n                                                                    ");
        $elem18.appendChild($node19);
        
        $node16 = document.createTextNode("\n                                                        ");
        $elem15.appendChild($node16);
        
        $node13 = document.createTextNode("\n                                            ");
        $elem12.appendChild($node13);
        
        $node10 = document.createTextNode("\n                                    ");
        $elem9.appendChild($node10);
        
        $node10 = document.createComment("hr id=\"separateSystem\"/");
        $elem9.appendChild($node10);
        
        $node10 = document.createTextNode("\n                                ");
        $elem9.appendChild($node10);
        
        $node7 = document.createTextNode("   \n                    ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text-align: left;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("PreviousAnchorBottom");
        $attr7.appendChild($node8);
        
        $element_PreviousAnchorBottom = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Previous entries");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("text-align: right;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n                        ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("NextAnchorBottom");
        $attr7.appendChild($node8);
        
        $element_NextAnchorBottom = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("Next entries");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ViewQueryResultXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ActionsNode</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementActionsNode() {
        return $element_ActionsNode;
    }

    /**
     * Get the element with id <CODE>ContributionNode</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementContributionNode() {
        return $element_ContributionNode;
    }

    /**
     * Get the element with id <CODE>DeleteEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementDeleteEntryAnchor() {
        return $element_DeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>DuplicateEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementDuplicateEntryAnchor() {
        return $element_DuplicateEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EditEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementEditEntryAnchor() {
        return $element_EditEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryAuthor() {
        return $element_EntryAuthor;
    }

    /**
     * Get the element with id <CODE>entryContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementEntryContent() {
        return $element_EntryContent;
    }

    /**
     * Get the element with id <CODE>entryContentTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementEntryContentTable() {
        return $element_EntryContentTable;
    }

    /**
     * Get the element with id <CODE>entryContentTableColume</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementEntryContentTableColume() {
        return $element_EntryContentTableColume;
    }

    /**
     * Get the element with id <CODE>entryContentTableRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryContentTableRow() {
        return $element_EntryContentTableRow;
    }

    /**
     * Get the element with id <CODE>EntryNode</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementEntryNode() {
        return $element_EntryNode;
    }

    /**
     * Get the element with id <CODE>EntryStatus</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryStatus() {
        return $element_EntryStatus;
    }

    /**
     * Get the element with id <CODE>hintContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLLIElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLLIElement getElementHintContent() {
        return $element_HintContent;
    }

    /**
     * Get the element with id <CODE>hintShow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementHintShow() {
        return $element_HintShow;
    }

    /**
     * Get the element with id <CODE>labelHint</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLabelHint() {
        return $element_LabelHint;
    }

    /**
     * Get the element with id <CODE>langContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementLangContent() {
        return $element_LangContent;
    }

    /**
     * Get the element with id <CODE>langContentTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementLangContentTable() {
        return $element_LangContentTable;
    }

    /**
     * Get the element with id <CODE>langContentTableHeading</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementLangContentTableHeading() {
        return $element_LangContentTableHeading;
    }

    /**
     * Get the element with id <CODE>langName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementLangName() {
        return $element_LangName;
    }

    /**
     * Get the element with id <CODE>leftChange</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementLeftChange() {
        return $element_LeftChange;
    }

    /**
     * Get the element with id <CODE>linkContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementLinkContent() {
        return $element_LinkContent;
    }

    /**
     * Get the element with id <CODE>linkContentColume</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementLinkContentColume() {
        return $element_LinkContentColume;
    }

    /**
     * Get the element with id <CODE>linkContentRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementLinkContentRow() {
        return $element_LinkContentRow;
    }

    /**
     * Get the element with id <CODE>mainColume</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementMainColume() {
        return $element_MainColume;
    }

    /**
     * Get the element with id <CODE>mainRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementMainRow() {
        return $element_MainRow;
    }

    /**
     * Get the element with id <CODE>mainTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementMainTable() {
        return $element_MainTable;
    }

    /**
     * Get the element with id <CODE>minusWeight</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementMinusWeight() {
        return $element_MinusWeight;
    }

    /**
     * Get the element with id <CODE>NbResults</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementNbResults() {
        return $element_NbResults;
    }

    /**
     * Get the element with id <CODE>NextAnchorBottom</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementNextAnchorBottom() {
        return $element_NextAnchorBottom;
    }

    /**
     * Get the element with id <CODE>NextAnchorTop</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementNextAnchorTop() {
        return $element_NextAnchorTop;
    }

    /**
     * Get the element with id <CODE>plusWeight</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementPlusWeight() {
        return $element_PlusWeight;
    }

    /**
     * Get the element with id <CODE>PreviousAnchorBottom</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementPreviousAnchorBottom() {
        return $element_PreviousAnchorBottom;
    }

    /**
     * Get the element with id <CODE>PreviousAnchorTop</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementPreviousAnchorTop() {
        return $element_PreviousAnchorTop;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the element with id <CODE>QuickListAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementQuickListAnchor() {
        return $element_QuickListAnchor;
    }

    /**
     * Get the element with id <CODE>rightChange</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementRightChange() {
        return $element_RightChange;
    }

    /**
     * Get the element with id <CODE>systemName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSystemName() {
        return $element_SystemName;
    }

    /**
     * Get the element with id <CODE>systemTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementSystemTable() {
        return $element_SystemTable;
    }

    /**
     * Get the element with id <CODE>systemTableHeading</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementSystemTableHeading() {
        return $element_SystemTableHeading;
    }

    /**
     * Get the element with id <CODE>tmpLang</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableCellElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableCellElement getElementTmpLang() {
        return $element_TmpLang;
    }

    /**
     * Get the element with id <CODE>tmpRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTmpRow() {
        return $element_TmpRow;
    }

    /**
     * Get the element with id <CODE>UndeleteEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementUndeleteEntryAnchor() {
        return $element_UndeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewHistoryEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewHistoryEntryAnchor() {
        return $element_ViewHistoryEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the element with id <CODE>ActionsNode</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagActionsNode() {
        return $element_ActionsNode;
    }

    /**
     * Get the element with id <CODE>ContributionNode</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContributionNode() {
        return $element_ContributionNode;
    }

    /**
     * Get the element with id <CODE>DeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDeleteEntryAnchor() {
        return $element_DeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>DuplicateEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDuplicateEntryAnchor() {
        return $element_DuplicateEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EditEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditEntryAnchor() {
        return $element_EditEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryAuthor() {
        return $element_EntryAuthor;
    }

    /**
     * Get the element with id <CODE>entryContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryContent() {
        return $element_EntryContent;
    }

    /**
     * Get the element with id <CODE>entryContentTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryContentTable() {
        return $element_EntryContentTable;
    }

    /**
     * Get the element with id <CODE>entryContentTableColume</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryContentTableColume() {
        return $element_EntryContentTableColume;
    }

    /**
     * Get the element with id <CODE>entryContentTableRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryContentTableRow() {
        return $element_EntryContentTableRow;
    }

    /**
     * Get the element with id <CODE>EntryNode</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryNode() {
        return $element_EntryNode;
    }

    /**
     * Get the element with id <CODE>EntryStatus</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryStatus() {
        return $element_EntryStatus;
    }

    /**
     * Get the element with id <CODE>hintContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHintContent() {
        return $element_HintContent;
    }

    /**
     * Get the element with id <CODE>hintShow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHintShow() {
        return $element_HintShow;
    }

    /**
     * Get the element with id <CODE>labelHint</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLabelHint() {
        return $element_LabelHint;
    }

    /**
     * Get the element with id <CODE>langContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLangContent() {
        return $element_LangContent;
    }

    /**
     * Get the element with id <CODE>langContentTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLangContentTable() {
        return $element_LangContentTable;
    }

    /**
     * Get the element with id <CODE>langContentTableHeading</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLangContentTableHeading() {
        return $element_LangContentTableHeading;
    }

    /**
     * Get the element with id <CODE>langName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLangName() {
        return $element_LangName;
    }

    /**
     * Get the element with id <CODE>leftChange</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLeftChange() {
        return $element_LeftChange;
    }

    /**
     * Get the element with id <CODE>linkContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLinkContent() {
        return $element_LinkContent;
    }

    /**
     * Get the element with id <CODE>linkContentColume</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLinkContentColume() {
        return $element_LinkContentColume;
    }

    /**
     * Get the element with id <CODE>linkContentRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLinkContentRow() {
        return $element_LinkContentRow;
    }

    /**
     * Get the element with id <CODE>mainColume</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMainColume() {
        return $element_MainColume;
    }

    /**
     * Get the element with id <CODE>mainRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMainRow() {
        return $element_MainRow;
    }

    /**
     * Get the element with id <CODE>mainTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMainTable() {
        return $element_MainTable;
    }

    /**
     * Get the element with id <CODE>minusWeight</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMinusWeight() {
        return $element_MinusWeight;
    }

    /**
     * Get the element with id <CODE>NbResults</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNbResults() {
        return $element_NbResults;
    }

    /**
     * Get the element with id <CODE>NextAnchorBottom</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNextAnchorBottom() {
        return $element_NextAnchorBottom;
    }

    /**
     * Get the element with id <CODE>NextAnchorTop</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNextAnchorTop() {
        return $element_NextAnchorTop;
    }

    /**
     * Get the element with id <CODE>plusWeight</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPlusWeight() {
        return $element_PlusWeight;
    }

    /**
     * Get the element with id <CODE>PreviousAnchorBottom</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPreviousAnchorBottom() {
        return $element_PreviousAnchorBottom;
    }

    /**
     * Get the element with id <CODE>PreviousAnchorTop</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPreviousAnchorTop() {
        return $element_PreviousAnchorTop;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the element with id <CODE>QuickListAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQuickListAnchor() {
        return $element_QuickListAnchor;
    }

    /**
     * Get the element with id <CODE>rightChange</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagRightChange() {
        return $element_RightChange;
    }

    /**
     * Get the element with id <CODE>systemName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSystemName() {
        return $element_SystemName;
    }

    /**
     * Get the element with id <CODE>systemTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSystemTable() {
        return $element_SystemTable;
    }

    /**
     * Get the element with id <CODE>systemTableHeading</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSystemTableHeading() {
        return $element_SystemTableHeading;
    }

    /**
     * Get the element with id <CODE>tmpLang</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTmpLang() {
        return $element_TmpLang;
    }

    /**
     * Get the element with id <CODE>tmpRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTmpRow() {
        return $element_TmpRow;
    }

    /**
     * Get the element with id <CODE>UndeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUndeleteEntryAnchor() {
        return $element_UndeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewHistoryEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewHistoryEntryAnchor() {
        return $element_ViewHistoryEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the value of text child of element <CODE>ActionsNode</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextActionsNode(String text) {
        doSetText($element_ActionsNode, text);
    }

    /**
     * Get the value of text child of element <CODE>ContributionNode</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextContributionNode(String text) {
        doSetText($element_ContributionNode, text);
    }

    /**
     * Get the value of text child of element <CODE>DeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDeleteEntryAnchor(String text) {
        doSetText($element_DeleteEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>DuplicateEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDuplicateEntryAnchor(String text) {
        doSetText($element_DuplicateEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EditEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditEntryAnchor(String text) {
        doSetText($element_EditEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryAuthor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryAuthor(String text) {
        doSetText($element_EntryAuthor, text);
    }

    /**
     * Get the value of text child of element <CODE>entryContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryContent(String text) {
        doSetText($element_EntryContent, text);
    }

    /**
     * Get the value of text child of element <CODE>entryContentTableColume</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryContentTableColume(String text) {
        doSetText($element_EntryContentTableColume, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryNode</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryNode(String text) {
        doSetText($element_EntryNode, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryStatus</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryStatus(String text) {
        doSetText($element_EntryStatus, text);
    }

    /**
     * Get the value of text child of element <CODE>hintContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHintContent(String text) {
        doSetText($element_HintContent, text);
    }

    /**
     * Get the value of text child of element <CODE>hintShow</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHintShow(String text) {
        doSetText($element_HintShow, text);
    }

    /**
     * Get the value of text child of element <CODE>labelHint</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLabelHint(String text) {
        doSetText($element_LabelHint, text);
    }

    /**
     * Get the value of text child of element <CODE>langName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLangName(String text) {
        doSetText($element_LangName, text);
    }

    /**
     * Get the value of text child of element <CODE>leftChange</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLeftChange(String text) {
        doSetText($element_LeftChange, text);
    }

    /**
     * Get the value of text child of element <CODE>linkContentColume</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLinkContentColume(String text) {
        doSetText($element_LinkContentColume, text);
    }

    /**
     * Get the value of text child of element <CODE>mainColume</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMainColume(String text) {
        doSetText($element_MainColume, text);
    }

    /**
     * Get the value of text child of element <CODE>minusWeight</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMinusWeight(String text) {
        doSetText($element_MinusWeight, text);
    }

    /**
     * Get the value of text child of element <CODE>NbResults</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNbResults(String text) {
        doSetText($element_NbResults, text);
    }

    /**
     * Get the value of text child of element <CODE>NextAnchorBottom</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNextAnchorBottom(String text) {
        doSetText($element_NextAnchorBottom, text);
    }

    /**
     * Get the value of text child of element <CODE>NextAnchorTop</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNextAnchorTop(String text) {
        doSetText($element_NextAnchorTop, text);
    }

    /**
     * Get the value of text child of element <CODE>plusWeight</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPlusWeight(String text) {
        doSetText($element_PlusWeight, text);
    }

    /**
     * Get the value of text child of element <CODE>PreviousAnchorBottom</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPreviousAnchorBottom(String text) {
        doSetText($element_PreviousAnchorBottom, text);
    }

    /**
     * Get the value of text child of element <CODE>PreviousAnchorTop</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPreviousAnchorTop(String text) {
        doSetText($element_PreviousAnchorTop, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryResultForm(String text) {
        doSetText($element_QueryResultForm, text);
    }

    /**
     * Get the value of text child of element <CODE>QuickListAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQuickListAnchor(String text) {
        doSetText($element_QuickListAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>rightChange</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextRightChange(String text) {
        doSetText($element_RightChange, text);
    }

    /**
     * Get the value of text child of element <CODE>systemName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSystemName(String text) {
        doSetText($element_SystemName, text);
    }

    /**
     * Get the value of text child of element <CODE>tmpLang</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTmpLang(String text) {
        doSetText($element_TmpLang, text);
    }

    /**
     * Get the value of text child of element <CODE>UndeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUndeleteEntryAnchor(String text) {
        doSetText($element_UndeleteEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewHistoryEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewHistoryEntryAnchor(String text) {
        doSetText($element_ViewHistoryEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewXmlAnchor(String text) {
        doSetText($element_ViewXmlAnchor, text);
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
