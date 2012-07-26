/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlpivax.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlpivax/orig/SavingQueryForm.xhtml
 */
public class SavingQueryFormXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements SavingQueryFormXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_SavingQuery;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_SavingQueryLink;

    /**
     * Class attribute constant for element class menuTitle
     */
    public static final String CLASS_menuTitle = "menuTitle";

    /**
     * Element name constant for SavingQueryLink
     */
    public static final String NAME_SavingQueryLink = "SavingQueryLink";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = SavingQueryFormXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlpivax/orig/SavingQueryForm.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public SavingQueryFormXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public SavingQueryFormXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public SavingQueryFormXHTMLImpl(SavingQueryFormXHTMLImpl src) {
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
        
        $node4 = document.createTextNode("Saving Query");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("SavingQuery");
        $attr3.appendChild($node4);
        
        $element_SavingQuery = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n        ");
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
        
        $attr6 = document.createAttributeNS("", "align");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("left");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n              ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "lang");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("en");
        $attr7.appendChild($node8);
        
        $attr7 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("en");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("\n                ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("menuTitle");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                  ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "title");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Shotcut(s):");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Shotcut(s):");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                ");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n                ");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "href");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("javascript:void(0)");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("SavingQueryLink");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("SavingQueryLink");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "style");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("font-weight:normal;");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "title");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_SavingQueryLink = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem8;$node9 = document.createTextNode("shotcut1");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n              ");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n            ");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new SavingQueryFormXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>SavingQuery</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementSavingQuery() {
        return $element_SavingQuery;
    }

    /**
     * Get the element with id <CODE>SavingQueryLink</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementSavingQueryLink() {
        return $element_SavingQueryLink;
    }

    /**
     * Get the element with id <CODE>SavingQuery</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSavingQuery() {
        return $element_SavingQuery;
    }

    /**
     * Get the element with id <CODE>SavingQueryLink</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSavingQueryLink() {
        return $element_SavingQueryLink;
    }

    /**
     * Get the value of text child of element <CODE>SavingQuery</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSavingQuery(String text) {
        doSetText($element_SavingQuery, text);
    }

    /**
     * Get the value of text child of element <CODE>SavingQueryLink</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSavingQueryLink(String text) {
        doSetText($element_SavingQueryLink, text);
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
