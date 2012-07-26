/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/ConfirmEntry.xhtml
 */
public class ConfirmEntryXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ConfirmEntryXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ConfirmEntryContent;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Edit;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_EditingResultView;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Message;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Value1;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Value2;

    /**
     * Class attribute constant for element class editEntry
     */
    public static final String CLASS_editEntry = "editEntry";

    /**
     * Class attribute constant for element class editingResultTitle
     */
    public static final String CLASS_editingResultTitle = "editingResultTitle";

    /**
     * Class attribute constant for element class editingResultView
     */
    public static final String CLASS_editingResultView = "editingResultView";

    /**
     * Class attribute constant for element class messageConfirm
     */
    public static final String CLASS_messageConfirm = "messageConfirm";

    /**
     * Element name constant for action
     */
    public static final String NAME_action = "action";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ConfirmEntryXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/ConfirmEntry.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ConfirmEntryXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ConfirmEntryXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ConfirmEntryXHTMLImpl(ConfirmEntryXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6;
        
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
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("editEntry");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("ConfirmEntryContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_ConfirmEntryContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("editingResultTitle");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Editing result");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("messageConfirm");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Message");
        $attr4.appendChild($node5);
        
        $element_Message = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("editingResultView");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("EditingResultView");
        $attr4.appendChild($node5);
        
        $element_EditingResultView = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LaunchAction.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("editingResultTitle");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("get");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Value1");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_Value1 = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Value2");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $element_Value2 = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("edit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("action");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("submit");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Re-Edit");
        $attr6.appendChild($node7);
        
        $element_Edit = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n                    ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("javascript:top.window.close();");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("reset");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Close window");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new ConfirmEntryXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ConfirmEntryContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementConfirmEntryContent() {
        return $element_ConfirmEntryContent;
    }

    /**
     * Get the element with id <CODE>edit</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementEdit() {
        return $element_Edit;
    }

    /**
     * Get the element with id <CODE>EditingResultView</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementEditingResultView() {
        return $element_EditingResultView;
    }

    /**
     * Get the element with id <CODE>Message</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementMessage() {
        return $element_Message;
    }

    /**
     * Get the element with id <CODE>Value1</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValue1() {
        return $element_Value1;
    }

    /**
     * Get the element with id <CODE>Value2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementValue2() {
        return $element_Value2;
    }

    /**
     * Get the element with id <CODE>ConfirmEntryContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagConfirmEntryContent() {
        return $element_ConfirmEntryContent;
    }

    /**
     * Get the element with id <CODE>edit</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEdit() {
        return $element_Edit;
    }

    /**
     * Get the element with id <CODE>EditingResultView</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditingResultView() {
        return $element_EditingResultView;
    }

    /**
     * Get the element with id <CODE>Message</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagMessage() {
        return $element_Message;
    }

    /**
     * Get the element with id <CODE>Value1</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValue1() {
        return $element_Value1;
    }

    /**
     * Get the element with id <CODE>Value2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagValue2() {
        return $element_Value2;
    }

    /**
     * Get the value of text child of element <CODE>ConfirmEntryContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextConfirmEntryContent(String text) {
        doSetText($element_ConfirmEntryContent, text);
    }

    /**
     * Get the value of text child of element <CODE>EditingResultView</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditingResultView(String text) {
        doSetText($element_EditingResultView, text);
    }

    /**
     * Get the value of text child of element <CODE>Message</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextMessage(String text) {
        doSetText($element_Message, text);
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
