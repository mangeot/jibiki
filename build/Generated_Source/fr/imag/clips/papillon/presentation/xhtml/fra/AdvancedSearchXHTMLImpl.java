/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.fra;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/fra/AdvancedSearch.xhtml
 */
public class AdvancedSearchXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements AdvancedSearchXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.AdvancedSearchXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_AdvancedSearchPage;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ResultList;

    /**
     * Class attribute constant for element class QueryForm
     */
    public static final String CLASS_QueryForm = "QueryForm";

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = AdvancedSearchXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/fra/AdvancedSearch.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public AdvancedSearchXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public AdvancedSearchXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public AdvancedSearchXHTMLImpl(AdvancedSearchXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
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
        
        $node4 = document.createTextNode("Menu");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("AdvancedSearchPage");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_AdvancedSearchPage = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("title");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Interface de recherche avanc\u00e9e");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryForm");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryForm");
        $attr4.appendChild($node5);
        
        $element_QueryForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ResultList");
        $attr4.appendChild($node5);
        
        $element_ResultList = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n            ");
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
        return new AdvancedSearchXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>AdvancedSearchPage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementAdvancedSearchPage() {
        return $element_AdvancedSearchPage;
    }

    /**
     * Get the element with id <CODE>QueryForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryForm() {
        return $element_QueryForm;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the element with id <CODE>ResultList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementResultList() {
        return $element_ResultList;
    }

    /**
     * Get the element with id <CODE>AdvancedSearchPage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAdvancedSearchPage() {
        return $element_AdvancedSearchPage;
    }

    /**
     * Get the element with id <CODE>QueryForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryForm() {
        return $element_QueryForm;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the element with id <CODE>ResultList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResultList() {
        return $element_ResultList;
    }

    /**
     * Get the value of text child of element <CODE>AdvancedSearchPage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAdvancedSearchPage(String text) {
        doSetText($element_AdvancedSearchPage, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryForm(String text) {
        doSetText($element_QueryForm, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryResultForm(String text) {
        doSetText($element_QueryResultForm, text);
    }

    /**
     * Get the value of text child of element <CODE>ResultList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextResultList(String text) {
        doSetText($element_ResultList, text);
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
