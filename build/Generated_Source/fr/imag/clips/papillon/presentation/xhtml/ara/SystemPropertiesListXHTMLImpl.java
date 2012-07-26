/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.ara;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/ara/SystemPropertiesList.xhtml
 */
public class SystemPropertiesListXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements SystemPropertiesListXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.SystemPropertiesListXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_ActiveSessionCount;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_MaxSessionCount;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_MaxSessionCountDate;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_PropertiesList;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Property;

    private org.enhydra.xml.xhtml.dom.XHTMLTableRowElement $element_TemplateRow;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Value;

    /**
     * Class attribute constant for element class cellRow
     */
    public static final String CLASS_cellRow = "cellRow";

    /**
     * Class attribute constant for element class headerRow
     */
    public static final String CLASS_headerRow = "headerRow";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = SystemPropertiesListXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/ara/SystemPropertiesList.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public SystemPropertiesListXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public SystemPropertiesListXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public SystemPropertiesListXHTMLImpl(SystemPropertiesListXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7;
        
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
        
        $node4 = document.createTextNode("Papillon's Environment");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("PropertiesList");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_PropertiesList = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Propri\u00e9t\u00e9s syst\u00e8me et session");
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
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Session Properties");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("headerRow");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Propri\u00e9t\u00e9s session");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Valeur");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cellRow");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Nombre de sessions actives");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("ActiveSessionCount");
        $attr7.appendChild($node8);
        
        $element_ActiveSessionCount = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode(" Valeur ");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cellRow");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Nombre max de sessions");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("MaxSessionCount");
        $attr7.appendChild($node8);
        
        $element_MaxSessionCount = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode(" Valeur ");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cellRow");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Date du max");
        $elem6.appendChild($node7);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("MaxSessionCountDate");
        $attr7.appendChild($node8);
        
        $element_MaxSessionCountDate = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode(" Valeur ");
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
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("System Properties");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("100%");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("headerRow");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Propri\u00e9t\u00e9s syst\u00e8me");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Valeur");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("cellRow");
        $attr5.appendChild($node6);
        
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
        $node8 = document.createTextNode("Property");
        $attr7.appendChild($node8);
        
        $element_Property = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode(" Propri\u00e9t\u00e9 ");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Value");
        $attr7.appendChild($node8);
        
        $element_Value = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode(" Valeur ");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new SystemPropertiesListXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ActiveSessionCount</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementActiveSessionCount() {
        return $element_ActiveSessionCount;
    }

    /**
     * Get the element with id <CODE>MaxSessionCount</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementMaxSessionCount() {
        return $element_MaxSessionCount;
    }

    /**
     * Get the element with id <CODE>MaxSessionCountDate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementMaxSessionCountDate() {
        return $element_MaxSessionCountDate;
    }

    /**
     * Get the element with id <CODE>PropertiesList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementPropertiesList() {
        return $element_PropertiesList;
    }

    /**
     * Get the element with id <CODE>Property</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementProperty() {
        return $element_Property;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTableRowElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTableRowElement getElementTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>Value</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementValue() {
        return $element_Value;
    }

    /**
     * Get the element with id <CODE>ActiveSessionCount</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagActiveSessionCount() {
        return $element_ActiveSessionCount;
    }

    /**
     * Get the element with id <CODE>MaxSessionCount</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMaxSessionCount() {
        return $element_MaxSessionCount;
    }

    /**
     * Get the element with id <CODE>MaxSessionCountDate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMaxSessionCountDate() {
        return $element_MaxSessionCountDate;
    }

    /**
     * Get the element with id <CODE>PropertiesList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagPropertiesList() {
        return $element_PropertiesList;
    }

    /**
     * Get the element with id <CODE>Property</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagProperty() {
        return $element_Property;
    }

    /**
     * Get the element with id <CODE>TemplateRow</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagTemplateRow() {
        return $element_TemplateRow;
    }

    /**
     * Get the element with id <CODE>Value</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValue() {
        return $element_Value;
    }

    /**
     * Get the value of text child of element <CODE>ActiveSessionCount</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextActiveSessionCount(String text) {
        doSetText($element_ActiveSessionCount, text);
    }

    /**
     * Get the value of text child of element <CODE>MaxSessionCount</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMaxSessionCount(String text) {
        doSetText($element_MaxSessionCount, text);
    }

    /**
     * Get the value of text child of element <CODE>MaxSessionCountDate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMaxSessionCountDate(String text) {
        doSetText($element_MaxSessionCountDate, text);
    }

    /**
     * Get the value of text child of element <CODE>PropertiesList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextPropertiesList(String text) {
        doSetText($element_PropertiesList, text);
    }

    /**
     * Get the value of text child of element <CODE>Property</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextProperty(String text) {
        doSetText($element_Property, text);
    }

    /**
     * Get the value of text child of element <CODE>Value</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextValue(String text) {
        doSetText($element_Value, text);
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
