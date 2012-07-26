/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmllexalp.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmllexalp/orig/HTMLPalette.xhtml
 */
public class HTMLPaletteXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements HTMLPaletteXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.HTMLPaletteXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLImageElement $element_HTMLImageElementTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HTMLPalette;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_HTMLSpanElementTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_SpanWithATextChild;

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = HTMLPaletteXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmllexalp/orig/HTMLPalette.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public HTMLPaletteXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public HTMLPaletteXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public HTMLPaletteXHTMLImpl(HTMLPaletteXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5;
        Element $elem0, $elem1, $elem2, $elem3, $elem4;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4;
        
        org.enhydra.apache.xerces.dom.DocumentTypeImpl docType = (org.enhydra.apache.xerces.dom.DocumentTypeImpl)fDOMFactory.createDocumentType("html", "-//W3C//DTD XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", null);
        org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl document = (org.enhydra.xml.xhtml.dom.xerces.XHTMLDocumentImpl)fDOMFactory.createDocument("http://www.w3.org/1999/xhtml", "html", docType);
        $elem1 = document.getDocumentElement();
        document.createElementNS("http://www.w3.org/1999/xhtml", "html");
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "head");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("HTML Palette");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $node3 = document.createComment(" This HTML document does not have to be localized ! ");
        $elem2.appendChild($node3);
        
        $node3 = document.createComment(" This Special HTML File is used as a general palette for HTML components ");
        $elem2.appendChild($node3);
        
        $node3 = document.createComment(" Each HTML element is usable by any enhydra presentation object after a duplicate and import inside");
        $elem2.appendChild($node3);
        
        $node3 = document.createComment(" a po document. This is used in order to avoid the HTMLElement Implementation to be hard encoded into the ");
        $elem2.appendChild($node3);
        
        $node3 = document.createComment(" source of the papillon project. This implementation being specified by XMLC itself. ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("HTMLPalette");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_HTMLPalette = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" An image object ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "alt");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("HTMLImageElementTemplate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("HTMLImageElementTemplate");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "src");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_HTMLImageElementTemplate = (org.enhydra.xml.xhtml.dom.XHTMLImageElement)$elem4;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" An Span Element ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("HTMLSpanElementTemplate");
        $attr4.appendChild($node5);
        
        $element_HTMLSpanElementTemplate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" A simple text element in a span ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("SpanWithATextChild");
        $attr4.appendChild($node5);
        
        $element_SpanWithATextChild = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("Text");
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
        return new HTMLPaletteXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>HTMLImageElementTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLImageElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLImageElement getElementHTMLImageElementTemplate() {
        return $element_HTMLImageElementTemplate;
    }

    /**
     * Get the element with id <CODE>HTMLPalette</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementHTMLPalette() {
        return $element_HTMLPalette;
    }

    /**
     * Get the element with id <CODE>HTMLSpanElementTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementHTMLSpanElementTemplate() {
        return $element_HTMLSpanElementTemplate;
    }

    /**
     * Get the element with id <CODE>SpanWithATextChild</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementSpanWithATextChild() {
        return $element_SpanWithATextChild;
    }

    /**
     * Get the element with id <CODE>HTMLImageElementTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHTMLImageElementTemplate() {
        return $element_HTMLImageElementTemplate;
    }

    /**
     * Get the element with id <CODE>HTMLPalette</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHTMLPalette() {
        return $element_HTMLPalette;
    }

    /**
     * Get the element with id <CODE>HTMLSpanElementTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHTMLSpanElementTemplate() {
        return $element_HTMLSpanElementTemplate;
    }

    /**
     * Get the element with id <CODE>SpanWithATextChild</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSpanWithATextChild() {
        return $element_SpanWithATextChild;
    }

    /**
     * Get the value of text child of element <CODE>HTMLPalette</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHTMLPalette(String text) {
        doSetText($element_HTMLPalette, text);
    }

    /**
     * Get the value of text child of element <CODE>HTMLSpanElementTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHTMLSpanElementTemplate(String text) {
        doSetText($element_HTMLSpanElementTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>SpanWithATextChild</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextSpanWithATextChild(String text) {
        doSetText($element_SpanWithATextChild, text);
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
