/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/DictionaryIndex.xhtml
 */
public class DictionaryIndexXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements DictionaryIndexXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_DictionaryIndexContent;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_HeadwordAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLUListElement $element_HeadwordList;

    private org.enhydra.xml.xhtml.dom.XHTMLLIElement $element_HeadwordListItem;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_HeadwordText;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_IndexKey;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_IndexList;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_KeyTitle;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_KeyToc;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_KeyTocBottom;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_KeyTocTop;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_LanguageDiv;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LanguageName;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_LanguageTitle;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LastTocAnchorText;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SectionAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_TocAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_TocAnchorLast;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_TocAnchorText;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_TocSeparator;

    /**
     * Class attribute constant for element class commaList
     */
    public static final String CLASS_commaList = "commaList";

    /**
     * Class attribute constant for element class indexKey
     */
    public static final String CLASS_indexKey = "indexKey";

    /**
     * Class attribute constant for element class indexList
     */
    public static final String CLASS_indexList = "indexList";

    /**
     * Class attribute constant for element class keyTitle
     */
    public static final String CLASS_keyTitle = "keyTitle";

    /**
     * Class attribute constant for element class keyToc
     */
    public static final String CLASS_keyToc = "keyToc";

    /**
     * Class attribute constant for element class languageIndex
     */
    public static final String CLASS_languageIndex = "languageIndex";

    /**
     * Class attribute constant for element class languageTitle
     */
    public static final String CLASS_languageTitle = "languageTitle";

    /**
     * Element name constant for lg_A
     */
    public static final String NAME_lg_A = "lg_A";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = DictionaryIndexXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/DictionaryIndex.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public DictionaryIndexXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public DictionaryIndexXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public DictionaryIndexXHTMLImpl(DictionaryIndexXHTMLImpl src) {
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
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("DictionaryIndexContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_DictionaryIndexContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("languageIndex");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("languageDiv");
        $attr4.appendChild($node5);
        
        $element_LanguageDiv = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("languageTitle");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("languageTitle");
        $attr5.appendChild($node6);
        
        $element_LanguageTitle = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("languageName");
        $attr6.appendChild($node7);
        
        $element_LanguageName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node7 = document.createTextNode("Language");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("keyTocTop");
        $attr5.appendChild($node6);
        
        $element_KeyTocTop = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createComment(" do not remove this comment ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("keyToc");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("keyToc");
        $attr6.appendChild($node7);
        
        $element_KeyToc = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("#");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("tocAnchor");
        $attr7.appendChild($node8);
        
        $element_TocAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("tocAnchorText");
        $attr8.appendChild($node9);
        
        $element_TocAnchorText = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("A");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("tocSeparator");
        $attr7.appendChild($node8);
        
        $element_TocSeparator = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("\u00a0|\u00a0");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "href");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("#");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("tocAnchorLast");
        $attr7.appendChild($node8);
        
        $element_TocAnchorLast = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("lastTocAnchorText");
        $attr8.appendChild($node9);
        
        $element_LastTocAnchorText = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("*");
        $elem8.appendChild($node9);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("indexList");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("indexList");
        $attr5.appendChild($node6);
        
        $element_IndexList = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("indexKey");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("indexKey");
        $attr6.appendChild($node7);
        
        $element_IndexKey = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem6;$node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("keyTitle");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("sectionAnchor");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("lg_A");
        $attr8.appendChild($node9);
        
        $element_SectionAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("keyTitle");
        $attr9.appendChild($node10);
        
        $element_KeyTitle = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("A");
        $elem9.appendChild($node10);
        
        $node7 = document.createTextNode("\n                    ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("commaList");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("headwordList");
        $attr7.appendChild($node8);
        
        $element_HeadwordList = (org.enhydra.xml.xhtml.dom.XHTMLUListElement)$elem7;$elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("headwordListItem");
        $attr8.appendChild($node9);
        
        $element_HeadwordListItem = (org.enhydra.xml.xhtml.dom.XHTMLLIElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "href");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("headwordAnchor");
        $attr9.appendChild($node10);
        
        $element_HeadwordAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem9;$elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("headwordText");
        $attr10.appendChild($node11);
        
        $element_HeadwordText = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("Abomination");
        $elem10.appendChild($node11);
        
        $node7 = document.createTextNode("\n                ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("keyTocBottom");
        $attr5.appendChild($node6);
        
        $element_KeyTocBottom = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createComment(" do not remove this comment ");
        $elem5.appendChild($node6);
        
        $node6 = document.createTextNode("\n            ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
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
        return new DictionaryIndexXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>DictionaryIndexContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementDictionaryIndexContent() {
        return $element_DictionaryIndexContent;
    }

    /**
     * Get the element with id <CODE>headwordAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementHeadwordAnchor() {
        return $element_HeadwordAnchor;
    }

    /**
     * Get the element with id <CODE>headwordList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLUListElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLUListElement getElementHeadwordList() {
        return $element_HeadwordList;
    }

    /**
     * Get the element with id <CODE>headwordListItem</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLLIElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLLIElement getElementHeadwordListItem() {
        return $element_HeadwordListItem;
    }

    /**
     * Get the element with id <CODE>headwordText</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementHeadwordText() {
        return $element_HeadwordText;
    }

    /**
     * Get the element with id <CODE>indexKey</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementIndexKey() {
        return $element_IndexKey;
    }

    /**
     * Get the element with id <CODE>indexList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementIndexList() {
        return $element_IndexList;
    }

    /**
     * Get the element with id <CODE>keyTitle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementKeyTitle() {
        return $element_KeyTitle;
    }

    /**
     * Get the element with id <CODE>keyToc</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementKeyToc() {
        return $element_KeyToc;
    }

    /**
     * Get the element with id <CODE>keyTocBottom</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementKeyTocBottom() {
        return $element_KeyTocBottom;
    }

    /**
     * Get the element with id <CODE>keyTocTop</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementKeyTocTop() {
        return $element_KeyTocTop;
    }

    /**
     * Get the element with id <CODE>languageDiv</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementLanguageDiv() {
        return $element_LanguageDiv;
    }

    /**
     * Get the element with id <CODE>languageName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLanguageName() {
        return $element_LanguageName;
    }

    /**
     * Get the element with id <CODE>languageTitle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementLanguageTitle() {
        return $element_LanguageTitle;
    }

    /**
     * Get the element with id <CODE>lastTocAnchorText</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLastTocAnchorText() {
        return $element_LastTocAnchorText;
    }

    /**
     * Get the element with id <CODE>sectionAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSectionAnchor() {
        return $element_SectionAnchor;
    }

    /**
     * Get the element with id <CODE>tocAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementTocAnchor() {
        return $element_TocAnchor;
    }

    /**
     * Get the element with id <CODE>tocAnchorLast</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementTocAnchorLast() {
        return $element_TocAnchorLast;
    }

    /**
     * Get the element with id <CODE>tocAnchorText</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementTocAnchorText() {
        return $element_TocAnchorText;
    }

    /**
     * Get the element with id <CODE>tocSeparator</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementTocSeparator() {
        return $element_TocSeparator;
    }

    /**
     * Get the element with id <CODE>DictionaryIndexContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionaryIndexContent() {
        return $element_DictionaryIndexContent;
    }

    /**
     * Get the element with id <CODE>headwordAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordAnchor() {
        return $element_HeadwordAnchor;
    }

    /**
     * Get the element with id <CODE>headwordList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordList() {
        return $element_HeadwordList;
    }

    /**
     * Get the element with id <CODE>headwordListItem</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordListItem() {
        return $element_HeadwordListItem;
    }

    /**
     * Get the element with id <CODE>headwordText</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadwordText() {
        return $element_HeadwordText;
    }

    /**
     * Get the element with id <CODE>indexKey</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagIndexKey() {
        return $element_IndexKey;
    }

    /**
     * Get the element with id <CODE>indexList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagIndexList() {
        return $element_IndexList;
    }

    /**
     * Get the element with id <CODE>keyTitle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagKeyTitle() {
        return $element_KeyTitle;
    }

    /**
     * Get the element with id <CODE>keyToc</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagKeyToc() {
        return $element_KeyToc;
    }

    /**
     * Get the element with id <CODE>keyTocBottom</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagKeyTocBottom() {
        return $element_KeyTocBottom;
    }

    /**
     * Get the element with id <CODE>keyTocTop</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagKeyTocTop() {
        return $element_KeyTocTop;
    }

    /**
     * Get the element with id <CODE>languageDiv</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLanguageDiv() {
        return $element_LanguageDiv;
    }

    /**
     * Get the element with id <CODE>languageName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLanguageName() {
        return $element_LanguageName;
    }

    /**
     * Get the element with id <CODE>languageTitle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLanguageTitle() {
        return $element_LanguageTitle;
    }

    /**
     * Get the element with id <CODE>lastTocAnchorText</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLastTocAnchorText() {
        return $element_LastTocAnchorText;
    }

    /**
     * Get the element with id <CODE>sectionAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSectionAnchor() {
        return $element_SectionAnchor;
    }

    /**
     * Get the element with id <CODE>tocAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTocAnchor() {
        return $element_TocAnchor;
    }

    /**
     * Get the element with id <CODE>tocAnchorLast</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTocAnchorLast() {
        return $element_TocAnchorLast;
    }

    /**
     * Get the element with id <CODE>tocAnchorText</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTocAnchorText() {
        return $element_TocAnchorText;
    }

    /**
     * Get the element with id <CODE>tocSeparator</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTocSeparator() {
        return $element_TocSeparator;
    }

    /**
     * Get the value of text child of element <CODE>DictionaryIndexContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictionaryIndexContent(String text) {
        doSetText($element_DictionaryIndexContent, text);
    }

    /**
     * Get the value of text child of element <CODE>headwordAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeadwordAnchor(String text) {
        doSetText($element_HeadwordAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>headwordListItem</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeadwordListItem(String text) {
        doSetText($element_HeadwordListItem, text);
    }

    /**
     * Get the value of text child of element <CODE>headwordText</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHeadwordText(String text) {
        doSetText($element_HeadwordText, text);
    }

    /**
     * Get the value of text child of element <CODE>indexKey</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextIndexKey(String text) {
        doSetText($element_IndexKey, text);
    }

    /**
     * Get the value of text child of element <CODE>indexList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextIndexList(String text) {
        doSetText($element_IndexList, text);
    }

    /**
     * Get the value of text child of element <CODE>keyTitle</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextKeyTitle(String text) {
        doSetText($element_KeyTitle, text);
    }

    /**
     * Get the value of text child of element <CODE>keyToc</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextKeyToc(String text) {
        doSetText($element_KeyToc, text);
    }

    /**
     * Get the value of text child of element <CODE>keyTocBottom</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextKeyTocBottom(String text) {
        doSetText($element_KeyTocBottom, text);
    }

    /**
     * Get the value of text child of element <CODE>keyTocTop</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextKeyTocTop(String text) {
        doSetText($element_KeyTocTop, text);
    }

    /**
     * Get the value of text child of element <CODE>languageDiv</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLanguageDiv(String text) {
        doSetText($element_LanguageDiv, text);
    }

    /**
     * Get the value of text child of element <CODE>languageName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLanguageName(String text) {
        doSetText($element_LanguageName, text);
    }

    /**
     * Get the value of text child of element <CODE>languageTitle</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLanguageTitle(String text) {
        doSetText($element_LanguageTitle, text);
    }

    /**
     * Get the value of text child of element <CODE>lastTocAnchorText</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLastTocAnchorText(String text) {
        doSetText($element_LastTocAnchorText, text);
    }

    /**
     * Get the value of text child of element <CODE>sectionAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSectionAnchor(String text) {
        doSetText($element_SectionAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>tocAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTocAnchor(String text) {
        doSetText($element_TocAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>tocAnchorLast</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTocAnchorLast(String text) {
        doSetText($element_TocAnchorLast, text);
    }

    /**
     * Get the value of text child of element <CODE>tocAnchorText</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTocAnchorText(String text) {
        doSetText($element_TocAnchorText, text);
    }

    /**
     * Get the value of text child of element <CODE>tocSeparator</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTocSeparator(String text) {
        doSetText($element_TocSeparator, text);
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
