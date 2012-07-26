/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.slv;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/slv/ConsultInformationsTmpl.xhtml
 */
public class ConsultInformationsTmplXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ConsultInformationsTmplXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.ConsultInformationsTmplXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_ConsultInformationsForm;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_CreationDate;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_DocumentAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DocumentAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_DocumentRowTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DocumentTitle;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_InformationsFileListPlace;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_NBSpace;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Reference;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_SectionHeader;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_SectionRowTemplate;

    /**
     * Class attribute constant for element class cellRow
     */
    public static final String CLASS_cellRow = "cellRow";

    /**
     * Class attribute constant for element class headerRow
     */
    public static final String CLASS_headerRow = "headerRow";

    /**
     * Element name constant for AuthorContains
     */
    public static final String NAME_AuthorContains = "AuthorContains";

    /**
     * Element name constant for RefContains
     */
    public static final String NAME_RefContains = "RefContains";

    /**
     * Element name constant for TitleContains
     */
    public static final String NAME_TitleContains = "TitleContains";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ConsultInformationsTmplXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/slv/ConsultInformationsTmpl.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ConsultInformationsTmplXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ConsultInformationsTmplXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ConsultInformationsTmplXHTMLImpl(ConsultInformationsTmplXHTMLImpl src) {
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
        
        $node3 = document.createComment(" <div id=\"InformationsFilePlace\">\n\n</div> ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("InformationsFileListPlace");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("slv");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("slv");
        $attr3.appendChild($node4);
        
        $element_InformationsFileListPlace = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Consulter la documentation");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Les membres du projet peuvent ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AdminInformations.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("ajouter des documents");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" \u00e0 ces sections.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ConsultInformations.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ConsultInformationsForm");
        $attr4.appendChild($node5);
        
        $element_ConsultInformationsForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Documents form");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Auteur(s)");
        $elem7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createTextNode(":\n     ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AuthorContains");
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
        
        $node7 = document.createComment(" TD bgcolor=\"#4682b4\"><font  color=\"#ffffff\">Date:</font><INPUT NAME=\"DateContains\" TYPE=\"text\" SIZE=\"15\" VALUE=\"\"></TD ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Titre");
        $elem7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createTextNode(":\n     ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("TitleContains");
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
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("R\u00e9f\u00e9rence");
        $elem7.appendChild($node8);
        
        $node8 = document.createEntityReference("nbsp");
        $elem7.appendChild($node8);
        
        $node9 = document.createTextNode("\u00a0");
        $node8.appendChild($node9);
        
        $node8 = document.createTextNode(":\n     ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("RefContains");
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
        
        $node7 = document.createComment(" The any  contains is not yet implemented because we need to query informationFile instead of informationDocument ");
        $elem6.appendChild($node7);
        
        $node7 = document.createComment("TD bgcolor=\"#4682b4\"><font  color=\"#ffffff\">Any part:</font><INPUT NAME=\"AnyContains\" TYPE=\"text\" SIZE=\"14\" VALUE=\"\"></TD");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("3");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Go");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Documents index");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("100%");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("SectionRowTemplate");
        $attr6.appendChild($node7);
        
        $element_SectionRowTemplate = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "class");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("headerRow");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("3");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("SectionHeader");
        $attr8.appendChild($node9);
        
        $element_SectionHeader = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("SECTION");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("cellRow");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("documentRowTemplate");
        $attr6.appendChild($node7);
        
        $element_DocumentRowTemplate = (org.enhydra.xml.xhtml.dom.XHTMLTableRowElement)$elem6;$elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("DocumentAuthor");
        $attr9.appendChild($node10);
        
        $element_DocumentAuthor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("AUTEUR");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n    (");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("CreationDate");
        $attr9.appendChild($node10);
        
        $element_CreationDate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem9;$node10 = document.createTextNode("DATE");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode(")");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n    ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "i");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "href");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("see");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("DocumentAnchor");
        $attr9.appendChild($node10);
        
        $element_DocumentAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem9;$elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("DocumentTitle");
        $attr10.appendChild($node11);
        
        $element_DocumentTitle = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem10;$node11 = document.createTextNode("TITRE");
        $elem10.appendChild($node11);
        
        $node8 = document.createTextNode("\n    ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Reference");
        $attr8.appendChild($node9);
        
        $element_Reference = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("R\u00e9f\u00e9rence");
        $elem8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NBSpace");
        $attr8.appendChild($node9);
        
        $element_NBSpace = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node9 = document.createEntityReference("nbsp");
        $elem8.appendChild($node9);
        
        $node10 = document.createTextNode("\u00a0");
        $node9.appendChild($node10);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ConsultInformationsTmplXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ConsultInformationsForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementConsultInformationsForm() {
        return $element_ConsultInformationsForm;
    }

    /**
     * Get the element with id <CODE>CreationDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCreationDate() {
        return $element_CreationDate;
    }

    /**
     * Get the element with id <CODE>DocumentAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementDocumentAnchor() {
        return $element_DocumentAnchor;
    }

    /**
     * Get the element with id <CODE>DocumentAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDocumentAuthor() {
        return $element_DocumentAuthor;
    }

    /**
     * Get the element with id <CODE>documentRowTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementDocumentRowTemplate() {
        return $element_DocumentRowTemplate;
    }

    /**
     * Get the element with id <CODE>DocumentTitle</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDocumentTitle() {
        return $element_DocumentTitle;
    }

    /**
     * Get the element with id <CODE>InformationsFileListPlace</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementInformationsFileListPlace() {
        return $element_InformationsFileListPlace;
    }

    /**
     * Get the element with id <CODE>NBSpace</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementNBSpace() {
        return $element_NBSpace;
    }

    /**
     * Get the element with id <CODE>Reference</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementReference() {
        return $element_Reference;
    }

    /**
     * Get the element with id <CODE>SectionHeader</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSectionHeader() {
        return $element_SectionHeader;
    }

    /**
     * Get the element with id <CODE>SectionRowTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementSectionRowTemplate() {
        return $element_SectionRowTemplate;
    }

    /**
     * Get the element with id <CODE>ConsultInformationsForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagConsultInformationsForm() {
        return $element_ConsultInformationsForm;
    }

    /**
     * Get the element with id <CODE>CreationDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreationDate() {
        return $element_CreationDate;
    }

    /**
     * Get the element with id <CODE>DocumentAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentAnchor() {
        return $element_DocumentAnchor;
    }

    /**
     * Get the element with id <CODE>DocumentAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentAuthor() {
        return $element_DocumentAuthor;
    }

    /**
     * Get the element with id <CODE>documentRowTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentRowTemplate() {
        return $element_DocumentRowTemplate;
    }

    /**
     * Get the element with id <CODE>DocumentTitle</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDocumentTitle() {
        return $element_DocumentTitle;
    }

    /**
     * Get the element with id <CODE>InformationsFileListPlace</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagInformationsFileListPlace() {
        return $element_InformationsFileListPlace;
    }

    /**
     * Get the element with id <CODE>NBSpace</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNBSpace() {
        return $element_NBSpace;
    }

    /**
     * Get the element with id <CODE>Reference</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagReference() {
        return $element_Reference;
    }

    /**
     * Get the element with id <CODE>SectionHeader</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSectionHeader() {
        return $element_SectionHeader;
    }

    /**
     * Get the element with id <CODE>SectionRowTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSectionRowTemplate() {
        return $element_SectionRowTemplate;
    }

    /**
     * Get the value of text child of element <CODE>CreationDate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCreationDate(String text) {
        doSetText($element_CreationDate, text);
    }

    /**
     * Get the value of text child of element <CODE>DocumentAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentAnchor(String text) {
        doSetText($element_DocumentAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>DocumentAuthor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentAuthor(String text) {
        doSetText($element_DocumentAuthor, text);
    }

    /**
     * Get the value of text child of element <CODE>DocumentTitle</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDocumentTitle(String text) {
        doSetText($element_DocumentTitle, text);
    }

    /**
     * Get the value of text child of element <CODE>InformationsFileListPlace</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextInformationsFileListPlace(String text) {
        doSetText($element_InformationsFileListPlace, text);
    }

    /**
     * Get the value of text child of element <CODE>NBSpace</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextNBSpace(String text) {
        doSetText($element_NBSpace, text);
    }

    /**
     * Get the value of text child of element <CODE>Reference</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextReference(String text) {
        doSetText($element_Reference, text);
    }

    /**
     * Get the value of text child of element <CODE>SectionHeader</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSectionHeader(String text) {
        doSetText($element_SectionHeader, text);
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
