/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.slv;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/slv/Consult.xhtml
 */
public class ConsultXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ConsultXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.ConsultXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ConsultContent;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ContribAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Contribution;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DictionaryName;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_EntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLParagraphElement $element_EntryDiv;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryIdList;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryListRow;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_EntryListTable;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryNumber;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_EntryRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Formula;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_FormulaRow;

    private org.enhydra.xml.xhtml.dom.XHTMLParagraphElement $element_FuzzyEntryDiv;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_FuzzyEntryRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_FuzzyResourceName;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_FuzzyTitle;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_NextEntriesAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_PosEntry;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_PreviousEntriesAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ResourceName;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ReverseLookupMessage;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_SorryMessage;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Vocable;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_VolumeEntriesTable;

    private org.enhydra.xml.xhtml.dom.XHTMLTableElement $element_VolumeFuzzyEntriesTable;

    /**
     * Class attribute constant for element class axie
     */
    public static final String CLASS_axie = "axie";

    /**
     * Class attribute constant for element class bodylink
     */
    public static final String CLASS_bodylink = "bodylink";

    /**
     * Class attribute constant for element class hidden
     */
    public static final String CLASS_hidden = "hidden";

    /**
     * Class attribute constant for element class hide
     */
    public static final String CLASS_hide = "hide";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ConsultXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/slv/Consult.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ConsultXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ConsultXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ConsultXHTMLImpl(ConsultXHTMLImpl src) {
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
        
        $attr1 = document.createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("http://www.w3.org/1999/xhtml");
        $attr1.appendChild($node2);
        
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
        $node4 = document.createTextNode("ConsultContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("slv");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("slv");
        $attr3.appendChild($node4);
        
        $element_ConsultContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SorryMessage");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align: center");
        $attr4.appendChild($node5);
        
        $element_SorryMessage = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("D\u00e9sol\u00e9, cet article n'existe pas encore, Vous pouvez contribuer en ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ConsultEdit.po?STEP=1&InitType=create");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("l'ajoutant");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" au dictionnaire !");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Note : vous devez \u00eatre ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("LoginUser.po");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("logu\u00e9");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" pour pouvoir contribuer.");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("      \n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" resultListStart ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hidden");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ReverseLookupMessage");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align: center");
        $attr4.appendChild($node5);
        
        $element_ReverseLookupMessage = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "style");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("text-align: center");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Aucun article trouv\u00e9 en consultation directe. Ces articles ont \u00e9t\u00e9 trouv\u00e9s en consultation renvers\u00e9e. Les traductions peuvent ne pas correspondre.");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("      \n");
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
        $node5 = document.createTextNode("EntryListTable");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("background: #faecc9");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("entries");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_EntryListTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EntryNumber");
        $attr8.appendChild($node9);
        
        $element_EntryNumber = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("0");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode(" articles trouv\u00e9s");
        $elem7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createTextNode(":");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Mot-vedette");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Idf");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Contribution");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Classe gram.");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Dictionnaire");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align:center");
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
        
        $element_PreviousEntriesAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("<< Articles pr\u00e9c\u00e9dents <<");
        $elem8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align:center");
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
        
        $element_NextEntriesAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode(">> Articles suivants >>");
        $elem8.appendChild($node9);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("EntryListRow");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "style");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("background: #eeeecc");
        $attr6.appendChild($node7);
        
        $element_EntryListRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createComment(" resultItemStart ");
        $elem7.appendChild($node8);
        
        $node8 = document.createTextNode("\n    ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("bodylink");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "href");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("EntryAnchor");
        $attr9.appendChild($node10);
        
        $element_EntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem9;$elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("Vocable");
        $attr10.appendChild($node11);
        
        $element_Vocable = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("Vocable");
        $elem10.appendChild($node11);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EntryIdList");
        $attr8.appendChild($node9);
        
        $element_EntryIdList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Id");
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
        $node9 = document.createTextNode("ContribAnchor");
        $attr8.appendChild($node9);
        
        $element_ContribAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Contribution");
        $attr9.appendChild($node10);
        
        $element_Contribution = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("Contribution");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("PosEntry");
        $attr8.appendChild($node9);
        
        $element_PosEntry = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("pos");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DictionaryName");
        $attr8.appendChild($node9);
        
        $element_DictionaryName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("NomDico");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n    ");
        $elem7.appendChild($node8);
        
        $node8 = document.createComment(" resultItemEnd ");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("FormulaRow");
        $attr6.appendChild($node7);
        
        $element_FormulaRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("5");
        $attr7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Formula");
        $attr8.appendChild($node9);
        
        $element_Formula = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Formule");
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
        $node5 = document.createTextNode("VolumeEntriesTable");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("background: #faecc9");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("dicocontent");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_VolumeEntriesTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EntryRow");
        $attr5.appendChild($node6);
        
        $element_EntryRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "valign");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("top");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align: right");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("resourceName");
        $attr9.appendChild($node10);
        
        $element_ResourceName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("resource");
        $elem9.appendChild($node10);
        
        $node7 = document.createTextNode("\n    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("axie");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("EntryDiv");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align: justify");
        $attr7.appendChild($node8);
        
        $element_EntryDiv = (org.enhydra.xml.xhtml.dom.XHTMLParagraphElement)$elem7;$node8 = document.createTextNode(" ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("text-align: right");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hide");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("#_top");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "alt");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("top");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "height");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("16");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "src");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("media/top.gif");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "style");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("border: 0");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "width");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("16");
        $attr9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem6.appendChild($elem7);
        
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
        $node5 = document.createTextNode("FuzzyTitle");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("background: white");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_FuzzyTitle = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Recherche floue");
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
        $node5 = document.createTextNode("VolumeFuzzyEntriesTable");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("background: #faecc9");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("dicocontent");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $element_VolumeFuzzyEntriesTable = (org.enhydra.xml.xhtml.dom.XHTMLTableElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("FuzzyEntryRow");
        $attr5.appendChild($node6);
        
        $element_FuzzyEntryRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "valign");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("top");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("align: right");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("FuzzyResourceName");
        $attr9.appendChild($node10);
        
        $element_FuzzyResourceName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("resource");
        $elem9.appendChild($node10);
        
        $node7 = document.createTextNode("\n    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("axie");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("FuzzyEntryDiv");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("align: justify");
        $attr7.appendChild($node8);
        
        $element_FuzzyEntryDiv = (org.enhydra.xml.xhtml.dom.XHTMLParagraphElement)$elem7;$node8 = document.createTextNode(" ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "style");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("align: right");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("#_top");
        $attr8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "alt");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("top");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "height");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("16");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "src");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("media/top.gif");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "style");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("border: 0");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "width");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("16");
        $attr9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "hr");
        $elem6.appendChild($elem7);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" resultListEnd ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ConsultXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ConsultContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementConsultContent() {
        return $element_ConsultContent;
    }

    /**
     * Get the element with id <CODE>ContribAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementContribAnchor() {
        return $element_ContribAnchor;
    }

    /**
     * Get the element with id <CODE>Contribution</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementContribution() {
        return $element_Contribution;
    }

    /**
     * Get the element with id <CODE>DictionaryName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDictionaryName() {
        return $element_DictionaryName;
    }

    /**
     * Get the element with id <CODE>EntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementEntryAnchor() {
        return $element_EntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryDiv</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLParagraphElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLParagraphElement getElementEntryDiv() {
        return $element_EntryDiv;
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
     * Get the element with id <CODE>EntryListTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementEntryListTable() {
        return $element_EntryListTable;
    }

    /**
     * Get the element with id <CODE>EntryNumber</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryNumber() {
        return $element_EntryNumber;
    }

    /**
     * Get the element with id <CODE>EntryRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementEntryRow() {
        return $element_EntryRow;
    }

    /**
     * Get the element with id <CODE>Formula</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFormula() {
        return $element_Formula;
    }

    /**
     * Get the element with id <CODE>FormulaRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementFormulaRow() {
        return $element_FormulaRow;
    }

    /**
     * Get the element with id <CODE>FuzzyEntryDiv</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLParagraphElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLParagraphElement getElementFuzzyEntryDiv() {
        return $element_FuzzyEntryDiv;
    }

    /**
     * Get the element with id <CODE>FuzzyEntryRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementFuzzyEntryRow() {
        return $element_FuzzyEntryRow;
    }

    /**
     * Get the element with id <CODE>FuzzyResourceName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementFuzzyResourceName() {
        return $element_FuzzyResourceName;
    }

    /**
     * Get the element with id <CODE>FuzzyTitle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementFuzzyTitle() {
        return $element_FuzzyTitle;
    }

    /**
     * Get the element with id <CODE>NextEntriesAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementNextEntriesAnchor() {
        return $element_NextEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>PosEntry</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementPosEntry() {
        return $element_PosEntry;
    }

    /**
     * Get the element with id <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementPreviousEntriesAnchor() {
        return $element_PreviousEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>resourceName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementResourceName() {
        return $element_ResourceName;
    }

    /**
     * Get the element with id <CODE>ReverseLookupMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementReverseLookupMessage() {
        return $element_ReverseLookupMessage;
    }

    /**
     * Get the element with id <CODE>SorryMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementSorryMessage() {
        return $element_SorryMessage;
    }

    /**
     * Get the element with id <CODE>Vocable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementVocable() {
        return $element_Vocable;
    }

    /**
     * Get the element with id <CODE>VolumeEntriesTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementVolumeEntriesTable() {
        return $element_VolumeEntriesTable;
    }

    /**
     * Get the element with id <CODE>VolumeFuzzyEntriesTable</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableElement getElementVolumeFuzzyEntriesTable() {
        return $element_VolumeFuzzyEntriesTable;
    }

    /**
     * Get the element with id <CODE>ConsultContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagConsultContent() {
        return $element_ConsultContent;
    }

    /**
     * Get the element with id <CODE>ContribAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContribAnchor() {
        return $element_ContribAnchor;
    }

    /**
     * Get the element with id <CODE>Contribution</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContribution() {
        return $element_Contribution;
    }

    /**
     * Get the element with id <CODE>DictionaryName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionaryName() {
        return $element_DictionaryName;
    }

    /**
     * Get the element with id <CODE>EntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryAnchor() {
        return $element_EntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryDiv</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryDiv() {
        return $element_EntryDiv;
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
     * Get the element with id <CODE>EntryListTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryListTable() {
        return $element_EntryListTable;
    }

    /**
     * Get the element with id <CODE>EntryNumber</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryNumber() {
        return $element_EntryNumber;
    }

    /**
     * Get the element with id <CODE>EntryRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryRow() {
        return $element_EntryRow;
    }

    /**
     * Get the element with id <CODE>Formula</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormula() {
        return $element_Formula;
    }

    /**
     * Get the element with id <CODE>FormulaRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaRow() {
        return $element_FormulaRow;
    }

    /**
     * Get the element with id <CODE>FuzzyEntryDiv</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFuzzyEntryDiv() {
        return $element_FuzzyEntryDiv;
    }

    /**
     * Get the element with id <CODE>FuzzyEntryRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFuzzyEntryRow() {
        return $element_FuzzyEntryRow;
    }

    /**
     * Get the element with id <CODE>FuzzyResourceName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFuzzyResourceName() {
        return $element_FuzzyResourceName;
    }

    /**
     * Get the element with id <CODE>FuzzyTitle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFuzzyTitle() {
        return $element_FuzzyTitle;
    }

    /**
     * Get the element with id <CODE>NextEntriesAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNextEntriesAnchor() {
        return $element_NextEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>PosEntry</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPosEntry() {
        return $element_PosEntry;
    }

    /**
     * Get the element with id <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPreviousEntriesAnchor() {
        return $element_PreviousEntriesAnchor;
    }

    /**
     * Get the element with id <CODE>resourceName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResourceName() {
        return $element_ResourceName;
    }

    /**
     * Get the element with id <CODE>ReverseLookupMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReverseLookupMessage() {
        return $element_ReverseLookupMessage;
    }

    /**
     * Get the element with id <CODE>SorryMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSorryMessage() {
        return $element_SorryMessage;
    }

    /**
     * Get the element with id <CODE>Vocable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVocable() {
        return $element_Vocable;
    }

    /**
     * Get the element with id <CODE>VolumeEntriesTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeEntriesTable() {
        return $element_VolumeEntriesTable;
    }

    /**
     * Get the element with id <CODE>VolumeFuzzyEntriesTable</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeFuzzyEntriesTable() {
        return $element_VolumeFuzzyEntriesTable;
    }

    /**
     * Get the value of text child of element <CODE>ConsultContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextConsultContent(String text) {
        doSetText($element_ConsultContent, text);
    }

    /**
     * Get the value of text child of element <CODE>ContribAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextContribAnchor(String text) {
        doSetText($element_ContribAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Contribution</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextContribution(String text) {
        doSetText($element_Contribution, text);
    }

    /**
     * Get the value of text child of element <CODE>DictionaryName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictionaryName(String text) {
        doSetText($element_DictionaryName, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryAnchor(String text) {
        doSetText($element_EntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryDiv</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryDiv(String text) {
        doSetText($element_EntryDiv, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryIdList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryIdList(String text) {
        doSetText($element_EntryIdList, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryNumber</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryNumber(String text) {
        doSetText($element_EntryNumber, text);
    }

    /**
     * Get the value of text child of element <CODE>Formula</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormula(String text) {
        doSetText($element_Formula, text);
    }

    /**
     * Get the value of text child of element <CODE>FuzzyEntryDiv</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFuzzyEntryDiv(String text) {
        doSetText($element_FuzzyEntryDiv, text);
    }

    /**
     * Get the value of text child of element <CODE>FuzzyResourceName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFuzzyResourceName(String text) {
        doSetText($element_FuzzyResourceName, text);
    }

    /**
     * Get the value of text child of element <CODE>NextEntriesAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNextEntriesAnchor(String text) {
        doSetText($element_NextEntriesAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>PosEntry</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPosEntry(String text) {
        doSetText($element_PosEntry, text);
    }

    /**
     * Get the value of text child of element <CODE>PreviousEntriesAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPreviousEntriesAnchor(String text) {
        doSetText($element_PreviousEntriesAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>resourceName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextResourceName(String text) {
        doSetText($element_ResourceName, text);
    }

    /**
     * Get the value of text child of element <CODE>ReverseLookupMessage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReverseLookupMessage(String text) {
        doSetText($element_ReverseLookupMessage, text);
    }

    /**
     * Get the value of text child of element <CODE>SorryMessage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSorryMessage(String text) {
        doSetText($element_SorryMessage, text);
    }

    /**
     * Get the value of text child of element <CODE>Vocable</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVocable(String text) {
        doSetText($element_Vocable, text);
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
