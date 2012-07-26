/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/EditAxieTmpl.xhtml
 */
public class EditAxieTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements EditAxieTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_ConfirmAxiesButton;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_EditAxieContent;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_EntryDiv;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryIdList1;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryIdList2;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryListRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_EntryListTable;

    private org.enhydra.xml.xhtml.dom.XHTMLTfootElement $element_EntryListTableFoot;

    private org.enhydra.xml.xhtml.dom.XHTMLTheadElement $element_EntryListTableHead;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Formula1;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Formula2;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_FormulaRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_HeadwordList1;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_HeadwordList2;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_HeadwordLookupRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_HeadwordLookupTable;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LinkAxiesButton;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_LinkTable;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_LookupForm;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_PosList1;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_PosList2;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeEntryAnchor1;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeEntryAnchor2;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_SelectEntry1;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_SelectEntry2;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_SemanticCat;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_SemanticCatDiv;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_SubmitRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserName;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_VolumeHidden1;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_VolumeHidden2;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate1;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate2;

    /**
     * Element name constant for Confirm
     */
    public static final String NAME_Confirm = "Confirm";

    /**
     * Element name constant for HEADWORD1
     */
    public static final String NAME_HEADWORD1 = "HEADWORD1";

    /**
     * Element name constant for HEADWORD2
     */
    public static final String NAME_HEADWORD2 = "HEADWORD2";

    /**
     * Element name constant for Link
     */
    public static final String NAME_Link = "Link";

    /**
     * Element name constant for Lookup
     */
    public static final String NAME_Lookup = "Lookup";

    /**
     * Element name constant for PartialMatch1
     */
    public static final String NAME_PartialMatch1 = "PartialMatch1";

    /**
     * Element name constant for PartialMatch2
     */
    public static final String NAME_PartialMatch2 = "PartialMatch2";

    /**
     * Element name constant for SelectEntry1
     */
    public static final String NAME_SelectEntry1 = "SelectEntry1";

    /**
     * Element name constant for SelectEntry2
     */
    public static final String NAME_SelectEntry2 = "SelectEntry2";

    /**
     * Element name constant for SemanticCat
     */
    public static final String NAME_SemanticCat = "SemanticCat";

    /**
     * Element name constant for VOLUME1
     */
    public static final String NAME_VOLUME1 = "VOLUME1";

    /**
     * Element name constant for VOLUME2
     */
    public static final String NAME_VOLUME2 = "VOLUME2";

    /**
     * Element name constant for VOLUMEHIDDEN1
     */
    public static final String NAME_VOLUMEHIDDEN1 = "VOLUMEHIDDEN1";

    /**
     * Element name constant for VOLUMEHIDDEN2
     */
    public static final String NAME_VOLUMEHIDDEN2 = "VOLUMEHIDDEN2";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = EditAxieTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/EditAxieTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public EditAxieTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public EditAxieTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public EditAxieTmplXHTMLImpl(EditAxieTmplXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9, $node10, $node11, $node12;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9, $elem10, $elem11;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9, $attr10, $attr11;
        
        org.enhydra.apache.xerces.dom.DocumentTypeImpl docType = (org.enhydra.apache.xerces.dom.DocumentTypeImpl)fDOMFactory.createDocumentType("html", "-//W3C//DTD XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", null);
        org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl document = (org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl)fDOMFactory.createDocument("http://www.w3.org/1999/xhtml", "html", docType);
        $elem1 = document.getDocumentElement();
        document.createElementNS("http://www.w3.org/1999/xhtml", "html");
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "head");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Consultation of Papillon Lexical Database");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("EditAxieContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_EditAxieContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UserName");
        $attr5.appendChild($node6);
        
        $element_UserName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("Name");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" Edit Axie Interface");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("EditAxie.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LookupForm");
        $attr4.appendChild($node5);
        
        $element_LookupForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("SemanticCatDiv");
        $attr5.appendChild($node6);
        
        $element_SemanticCatDiv = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\nSelect the Semantic Category of the Axie:\n");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("SemanticCat");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("SemanticCat");
        $attr6.appendChild($node7);
        
        $element_SemanticCat = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("entity");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("entity");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("entity");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("process");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("process");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("process");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("result");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("result");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("result");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("state");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("state");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("state");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("gloss");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("gloss");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("gloss");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("idiom");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("idiom");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("idiom");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("citation");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("citation");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("citation");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "label");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("proverb");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "value");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("proverb");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("proverb");
        $elem7.appendChild($node8);
        
        $node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "border");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("1");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "frame");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hsides");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("EntryListTable");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "summary");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Entries");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("100%");
        $attr6.appendChild($node7);
        
        $element_EntryListTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("EntryListTableHead");
        $attr7.appendChild($node8);
        
        $element_EntryListTableHead = (org.enhydra.xml.xhtml.dom.XHTMLTheadElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Sel");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Headword");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Entry ID");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("PoS");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Sel");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Headword");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Entry ID");
        $elem9.appendChild($node10);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("PoS");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("EntryListTableFoot");
        $attr7.appendChild($node8);
        
        $element_EntryListTableFoot = (org.enhydra.xml.xhtml.dom.XHTMLTfootElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "colspan");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("8");
        $attr9.appendChild($node10);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem9.appendChild($elem10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EntryListRow");
        $attr8.appendChild($node9);
        
        $element_EntryListRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SelectEntry1");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "name");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SelectEntry1");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "type");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("radio");
        $attr10.appendChild($node11);
        
        $element_SelectEntry1 = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem10;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("HeadwordList1");
        $attr10.appendChild($node11);
        
        $element_HeadwordList1 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("Headword");
        $elem10.appendChild($node11);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "href");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SeeEntryAnchor1");
        $attr10.appendChild($node11);
        
        $element_SeeEntryAnchor1 = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem10;$elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("EntryIdList1");
        $attr11.appendChild($node12);
        
        $element_EntryIdList1 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem11;$node12 = document.createTextNode("EntryId");
        $elem11.appendChild($node12);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("PosList1");
        $attr10.appendChild($node11);
        
        $element_PosList1 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("pos");
        $elem10.appendChild($node11);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SelectEntry2");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "name");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SelectEntry2");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "type");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("radio");
        $attr10.appendChild($node11);
        
        $element_SelectEntry2 = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem10;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("HeadwordList2");
        $attr10.appendChild($node11);
        
        $element_HeadwordList2 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("Headword");
        $elem10.appendChild($node11);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "href");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("SeeEntryAnchor2");
        $attr10.appendChild($node11);
        
        $element_SeeEntryAnchor2 = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem10;$elem11 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem10.appendChild($elem11);
        
        $attr11 = document.createAttributeNS("", "id");
        $elem11.setAttributeNode($attr11);
        $node12 = document.createTextNode("EntryIdList2");
        $attr11.appendChild($node12);
        
        $element_EntryIdList2 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem11;$node12 = document.createTextNode("EntryId");
        $elem11.appendChild($node12);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("PosList2");
        $attr10.appendChild($node11);
        
        $element_PosList2 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("pos");
        $elem10.appendChild($node11);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("FormulaRow");
        $attr8.appendChild($node9);
        
        $element_FormulaRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "colspan");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("4");
        $attr9.appendChild($node10);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("Formula1");
        $attr10.appendChild($node11);
        
        $element_Formula1 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("Formula1");
        $elem10.appendChild($node11);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "colspan");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("4");
        $attr9.appendChild($node10);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $node10 = document.createEntityReference("nbsp");
        $elem9.appendChild($node10);
        
        $node11 = document.createTextNode("\u00a0");
        $node10.appendChild($node11);
        
        $elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("Formula2");
        $attr10.appendChild($node11);
        
        $element_Formula2 = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("Formula2");
        $elem10.appendChild($node11);
        
        $node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LinkTable");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LinkTable");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $element_LinkTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("SubmitRow");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "valign");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("top");
        $attr6.appendChild($node7);
        
        $element_SubmitRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("LinkAxiesButton");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Link");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Link");
        $attr8.appendChild($node9);
        
        $element_LinkAxiesButton = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ConfirmAxiesButton");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Confirm");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Confirm");
        $attr8.appendChild($node9);
        
        $element_ConfirmAxiesButton = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VolumeHidden1");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUMEHIDDEN1");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_VolumeHidden1 = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VolumeHidden2");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUMEHIDDEN2");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_VolumeHidden2 = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("HeadwordLookupTable");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("HeadwordLookupTable");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $element_HeadwordLookupTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "colspan");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("2");
        $attr8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("HeadwordLookupRow");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "valign");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("top");
        $attr6.appendChild($node7);
        
        $element_HeadwordLookupRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Headword1:");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode(" \n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("HEADWORD1");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("15");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PartialMatch1");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("checkbox");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PartialMatch");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("Partial match");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Volume1:");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("           \n\t ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUME1");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VolumeOptionTemplate1");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $element_VolumeOptionTemplate1 = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("NONE");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Headword2: ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode(" \n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("HEADWORD2");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("15");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PartialMatch2");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("checkbox");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PartialMatch");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("Partial match");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Volume2:");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("           \n\t ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUME2");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VolumeOptionTemplate2");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NONE");
        $attr9.appendChild($node10);
        
        $element_VolumeOptionTemplate2 = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("NONE");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Lookup");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Lookup");
        $attr8.appendChild($node9);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("EntryDiv");
        $attr4.appendChild($node5);
        
        $element_EntryDiv = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new EditAxieTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ConfirmAxiesButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementConfirmAxiesButton() {
        return $element_ConfirmAxiesButton;
    }

    /**
     * Get the element with id <CODE>EditAxieContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementEditAxieContent() {
        return $element_EditAxieContent;
    }

    /**
     * Get the element with id <CODE>EntryDiv</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementEntryDiv() {
        return $element_EntryDiv;
    }

    /**
     * Get the element with id <CODE>EntryIdList1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryIdList1() {
        return $element_EntryIdList1;
    }

    /**
     * Get the element with id <CODE>EntryIdList2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryIdList2() {
        return $element_EntryIdList2;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>EntryListTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementEntryListTable() {
        return $element_EntryListTable;
    }

    /**
     * Get the element with id <CODE>EntryListTableFoot</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTfootElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTfootElement getElementEntryListTableFoot() {
        return $element_EntryListTableFoot;
    }

    /**
     * Get the element with id <CODE>EntryListTableHead</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTheadElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTheadElement getElementEntryListTableHead() {
        return $element_EntryListTableHead;
    }

    /**
     * Get the element with id <CODE>Formula1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFormula1() {
        return $element_Formula1;
    }

    /**
     * Get the element with id <CODE>Formula2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFormula2() {
        return $element_Formula2;
    }

    /**
     * Get the element with id <CODE>FormulaRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementFormulaRow() {
        return $element_FormulaRow;
    }

    /**
     * Get the element with id <CODE>HeadwordList1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementHeadwordList1() {
        return $element_HeadwordList1;
    }

    /**
     * Get the element with id <CODE>HeadwordList2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementHeadwordList2() {
        return $element_HeadwordList2;
    }

    /**
     * Get the element with id <CODE>HeadwordLookupRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementHeadwordLookupRow() {
        return $element_HeadwordLookupRow;
    }

    /**
     * Get the element with id <CODE>HeadwordLookupTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementHeadwordLookupTable() {
        return $element_HeadwordLookupTable;
    }

    /**
     * Get the element with id <CODE>LinkAxiesButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLinkAxiesButton() {
        return $element_LinkAxiesButton;
    }

    /**
     * Get the element with id <CODE>LinkTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementLinkTable() {
        return $element_LinkTable;
    }

    /**
     * Get the element with id <CODE>LookupForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementLookupForm() {
        return $element_LookupForm;
    }

    /**
     * Get the element with id <CODE>PosList1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementPosList1() {
        return $element_PosList1;
    }

    /**
     * Get the element with id <CODE>PosList2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementPosList2() {
        return $element_PosList2;
    }

    /**
     * Get the element with id <CODE>SeeEntryAnchor1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeEntryAnchor1() {
        return $element_SeeEntryAnchor1;
    }

    /**
     * Get the element with id <CODE>SeeEntryAnchor2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeEntryAnchor2() {
        return $element_SeeEntryAnchor2;
    }

    /**
     * Get the element with id <CODE>SelectEntry1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSelectEntry1() {
        return $element_SelectEntry1;
    }

    /**
     * Get the element with id <CODE>SelectEntry2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSelectEntry2() {
        return $element_SelectEntry2;
    }

    /**
     * Get the element with id <CODE>SemanticCat</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementSemanticCat() {
        return $element_SemanticCat;
    }

    /**
     * Get the element with id <CODE>SemanticCatDiv</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementSemanticCatDiv() {
        return $element_SemanticCatDiv;
    }

    /**
     * Get the element with id <CODE>SubmitRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementSubmitRow() {
        return $element_SubmitRow;
    }

    /**
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementUserName() {
        return $element_UserName;
    }

    /**
     * Get the element with id <CODE>VolumeHidden1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVolumeHidden1() {
        return $element_VolumeHidden1;
    }

    /**
     * Get the element with id <CODE>VolumeHidden2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVolumeHidden2() {
        return $element_VolumeHidden2;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate1() {
        return $element_VolumeOptionTemplate1;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate2() {
        return $element_VolumeOptionTemplate2;
    }

    /**
     * Get the element with id <CODE>ConfirmAxiesButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagConfirmAxiesButton() {
        return $element_ConfirmAxiesButton;
    }

    /**
     * Get the element with id <CODE>EditAxieContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditAxieContent() {
        return $element_EditAxieContent;
    }

    /**
     * Get the element with id <CODE>EntryDiv</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryDiv() {
        return $element_EntryDiv;
    }

    /**
     * Get the element with id <CODE>EntryIdList1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryIdList1() {
        return $element_EntryIdList1;
    }

    /**
     * Get the element with id <CODE>EntryIdList2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryIdList2() {
        return $element_EntryIdList2;
    }

    /**
     * Get the element with id <CODE>EntryListRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListRow() {
        return $element_EntryListRow;
    }

    /**
     * Get the element with id <CODE>EntryListTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListTable() {
        return $element_EntryListTable;
    }

    /**
     * Get the element with id <CODE>EntryListTableFoot</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListTableFoot() {
        return $element_EntryListTableFoot;
    }

    /**
     * Get the element with id <CODE>EntryListTableHead</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListTableHead() {
        return $element_EntryListTableHead;
    }

    /**
     * Get the element with id <CODE>Formula1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormula1() {
        return $element_Formula1;
    }

    /**
     * Get the element with id <CODE>Formula2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormula2() {
        return $element_Formula2;
    }

    /**
     * Get the element with id <CODE>FormulaRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaRow() {
        return $element_FormulaRow;
    }

    /**
     * Get the element with id <CODE>HeadwordList1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordList1() {
        return $element_HeadwordList1;
    }

    /**
     * Get the element with id <CODE>HeadwordList2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordList2() {
        return $element_HeadwordList2;
    }

    /**
     * Get the element with id <CODE>HeadwordLookupRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordLookupRow() {
        return $element_HeadwordLookupRow;
    }

    /**
     * Get the element with id <CODE>HeadwordLookupTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordLookupTable() {
        return $element_HeadwordLookupTable;
    }

    /**
     * Get the element with id <CODE>LinkAxiesButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLinkAxiesButton() {
        return $element_LinkAxiesButton;
    }

    /**
     * Get the element with id <CODE>LinkTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLinkTable() {
        return $element_LinkTable;
    }

    /**
     * Get the element with id <CODE>LookupForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLookupForm() {
        return $element_LookupForm;
    }

    /**
     * Get the element with id <CODE>PosList1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPosList1() {
        return $element_PosList1;
    }

    /**
     * Get the element with id <CODE>PosList2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPosList2() {
        return $element_PosList2;
    }

    /**
     * Get the element with id <CODE>SeeEntryAnchor1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeEntryAnchor1() {
        return $element_SeeEntryAnchor1;
    }

    /**
     * Get the element with id <CODE>SeeEntryAnchor2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeEntryAnchor2() {
        return $element_SeeEntryAnchor2;
    }

    /**
     * Get the element with id <CODE>SelectEntry1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSelectEntry1() {
        return $element_SelectEntry1;
    }

    /**
     * Get the element with id <CODE>SelectEntry2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSelectEntry2() {
        return $element_SelectEntry2;
    }

    /**
     * Get the element with id <CODE>SemanticCat</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSemanticCat() {
        return $element_SemanticCat;
    }

    /**
     * Get the element with id <CODE>SemanticCatDiv</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSemanticCatDiv() {
        return $element_SemanticCatDiv;
    }

    /**
     * Get the element with id <CODE>SubmitRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSubmitRow() {
        return $element_SubmitRow;
    }

    /**
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUserName() {
        return $element_UserName;
    }

    /**
     * Get the element with id <CODE>VolumeHidden1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeHidden1() {
        return $element_VolumeHidden1;
    }

    /**
     * Get the element with id <CODE>VolumeHidden2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeHidden2() {
        return $element_VolumeHidden2;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate1() {
        return $element_VolumeOptionTemplate1;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate2() {
        return $element_VolumeOptionTemplate2;
    }

    /**
     * Get the value of text child of element <CODE>EditAxieContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditAxieContent(String text) {
        doSetText($element_EditAxieContent, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryDiv</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryDiv(String text) {
        doSetText($element_EntryDiv, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryIdList1</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryIdList1(String text) {
        doSetText($element_EntryIdList1, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryIdList2</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryIdList2(String text) {
        doSetText($element_EntryIdList2, text);
    }

    /**
     * Get the value of text child of element <CODE>Formula1</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormula1(String text) {
        doSetText($element_Formula1, text);
    }

    /**
     * Get the value of text child of element <CODE>Formula2</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormula2(String text) {
        doSetText($element_Formula2, text);
    }

    /**
     * Get the value of text child of element <CODE>HeadwordList1</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeadwordList1(String text) {
        doSetText($element_HeadwordList1, text);
    }

    /**
     * Get the value of text child of element <CODE>HeadwordList2</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeadwordList2(String text) {
        doSetText($element_HeadwordList2, text);
    }

    /**
     * Get the value of text child of element <CODE>PosList1</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPosList1(String text) {
        doSetText($element_PosList1, text);
    }

    /**
     * Get the value of text child of element <CODE>PosList2</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPosList2(String text) {
        doSetText($element_PosList2, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeEntryAnchor1</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeEntryAnchor1(String text) {
        doSetText($element_SeeEntryAnchor1, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeEntryAnchor2</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeEntryAnchor2(String text) {
        doSetText($element_SeeEntryAnchor2, text);
    }

    /**
     * Get the value of text child of element <CODE>SemanticCatDiv</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSemanticCatDiv(String text) {
        doSetText($element_SemanticCatDiv, text);
    }

    /**
     * Get the value of text child of element <CODE>UserName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserName(String text) {
        doSetText($element_UserName, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeOptionTemplate1</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeOptionTemplate1(String text) {
        doSetText($element_VolumeOptionTemplate1, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeOptionTemplate2</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeOptionTemplate2(String text) {
        doSetText($element_VolumeOptionTemplate2, text);
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
