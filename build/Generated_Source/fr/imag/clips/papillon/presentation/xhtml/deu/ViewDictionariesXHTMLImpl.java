/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.deu;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/deu/ViewDictionaries.xhtml
 */
public class ViewDictionariesXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ViewDictionariesXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.ViewDictionariesXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Category;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Dictionary;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Domain;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Entries;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Legal;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Name;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SeeAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Sources;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Targets;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Type;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Volume;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Xml;

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ViewDictionariesXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/deu/ViewDictionaries.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ViewDictionariesXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ViewDictionariesXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ViewDictionariesXHTMLImpl(ViewDictionariesXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8;
        
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
        $node4 = document.createTextNode("de");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("title");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("XML-W");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("ouml");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00f6");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode("rterb");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("uuml");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00fc");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode("cher auf dem Server");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "border");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("1");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Existing Dictionaries");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Name");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Kategorie");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Typ");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Ausgangssprachen");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Zielsprachen");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Eintr");
        $elem6.appendChild($node7);
        
        $node7 = document.createEntityReference("auml");
        $elem6.appendChild($node7);
        
        $node8 = document.createTextNode("\u00e4");
        $node7.appendChild($node8);
        
        $node7 = document.createTextNode("ge");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Fachgebiet");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("rechtliche Hinweise");
        $elem6.appendChild($node7);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("TemplateRow");
        $attr5.appendChild($node6);
        
        $element_TemplateRow = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Dictionary");
        $attr7.appendChild($node8);
        
        $element_Dictionary = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("W");
        $elem7.appendChild($node8);
        
        $node8 = document.createEntityReference("ouml");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00f6");
        $node8.appendChild($node9);
        
        $node8 = document.createTextNode("rterbuch");
        $elem7.appendChild($node8);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Volume");
        $attr7.appendChild($node8);
        
        $element_Volume = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Volume");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Name");
        $attr8.appendChild($node9);
        
        $element_Name = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("name");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Category");
        $attr7.appendChild($node8);
        
        $element_Category = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("cat");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Type");
        $attr7.appendChild($node8);
        
        $element_Type = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("type");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Sources");
        $attr7.appendChild($node8);
        
        $element_Sources = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("sources");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Targets");
        $attr7.appendChild($node8);
        
        $element_Targets = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("targets");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "align");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("right");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Entries");
        $attr7.appendChild($node8);
        
        $element_Entries = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Entries");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Domain");
        $attr7.appendChild($node8);
        
        $element_Domain = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("domain");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Legal");
        $attr7.appendChild($node8);
        
        $element_Legal = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("legal");
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
        $node8 = document.createTextNode("SeeAnchor");
        $attr7.appendChild($node8);
        
        $element_SeeAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem7;$node8 = document.createTextNode("sehen");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode(" \n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Xml");
        $attr5.appendChild($node6);
        
        $element_Xml = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n");
        $elem5.appendChild($node6);
        
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
        return new ViewDictionariesXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>Category</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCategory() {
        return $element_Category;
    }

    /**
     * Get the element with id <CODE>Dictionary</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDictionary() {
        return $element_Dictionary;
    }

    /**
     * Get the element with id <CODE>Domain</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDomain() {
        return $element_Domain;
    }

    /**
     * Get the element with id <CODE>Entries</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntries() {
        return $element_Entries;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Legal</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLegal() {
        return $element_Legal;
    }

    /**
     * Get the element with id <CODE>Name</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementName() {
        return $element_Name;
    }

    /**
     * Get the element with id <CODE>SeeAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSeeAnchor() {
        return $element_SeeAnchor;
    }

    /**
     * Get the element with id <CODE>Sources</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSources() {
        return $element_Sources;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>Type</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementType() {
        return $element_Type;
    }

    /**
     * Get the element with id <CODE>Volume</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementVolume() {
        return $element_Volume;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementXml() {
        return $element_Xml;
    }

    /**
     * Get the element with id <CODE>Category</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCategory() {
        return $element_Category;
    }

    /**
     * Get the element with id <CODE>Dictionary</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDictionary() {
        return $element_Dictionary;
    }

    /**
     * Get the element with id <CODE>Domain</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDomain() {
        return $element_Domain;
    }

    /**
     * Get the element with id <CODE>Entries</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntries() {
        return $element_Entries;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Legal</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLegal() {
        return $element_Legal;
    }

    /**
     * Get the element with id <CODE>Name</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagName() {
        return $element_Name;
    }

    /**
     * Get the element with id <CODE>SeeAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSeeAnchor() {
        return $element_SeeAnchor;
    }

    /**
     * Get the element with id <CODE>Sources</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSources() {
        return $element_Sources;
    }

    /**
     * Get the element with id <CODE>Targets</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTargets() {
        return $element_Targets;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>Type</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagType() {
        return $element_Type;
    }

    /**
     * Get the element with id <CODE>Volume</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolume() {
        return $element_Volume;
    }

    /**
     * Get the element with id <CODE>Xml</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXml() {
        return $element_Xml;
    }

    /**
     * Get the value of text child of element <CODE>Category</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCategory(String text) {
        doSetText($element_Category, text);
    }

    /**
     * Get the value of text child of element <CODE>Dictionary</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDictionary(String text) {
        doSetText($element_Dictionary, text);
    }

    /**
     * Get the value of text child of element <CODE>Domain</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDomain(String text) {
        doSetText($element_Domain, text);
    }

    /**
     * Get the value of text child of element <CODE>Entries</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntries(String text) {
        doSetText($element_Entries, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>Legal</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLegal(String text) {
        doSetText($element_Legal, text);
    }

    /**
     * Get the value of text child of element <CODE>Name</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextName(String text) {
        doSetText($element_Name, text);
    }

    /**
     * Get the value of text child of element <CODE>SeeAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSeeAnchor(String text) {
        doSetText($element_SeeAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>Sources</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSources(String text) {
        doSetText($element_Sources, text);
    }

    /**
     * Get the value of text child of element <CODE>Targets</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextTargets(String text) {
        doSetText($element_Targets, text);
    }

    /**
     * Get the value of text child of element <CODE>Type</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextType(String text) {
        doSetText($element_Type, text);
    }

    /**
     * Get the value of text child of element <CODE>Volume</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolume(String text) {
        doSetText($element_Volume, text);
    }

    /**
     * Get the value of text child of element <CODE>Xml</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextXml(String text) {
        doSetText($element_Xml, text);
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
