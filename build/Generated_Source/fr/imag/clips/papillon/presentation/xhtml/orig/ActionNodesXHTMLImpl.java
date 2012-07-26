/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/ActionNodes.xhtml
 */
public class ActionNodesXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ActionNodesXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ActionsNode;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_DeleteEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_DuplicateEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_EditEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryAuthor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_EntryStatus;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_UndeleteEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewAxieAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewHistoryEntryAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLAnchorElement $element_ViewXmlAnchor;

    /**
     * Class attribute constant for element class action
     */
    public static final String CLASS_action = "action";

    /**
     * Class attribute constant for element class action_list
     */
    public static final String CLASS_action_list = "action_list";

    /**
     * Class attribute constant for element class entry_actions
     */
    public static final String CLASS_entry_actions = "entry_actions";

    /**
     * Class attribute constant for element class jibiki_author
     */
    public static final String CLASS_jibiki_author = "jibiki_author";

    /**
     * Class attribute constant for element class jibiki_byAuthor
     */
    public static final String CLASS_jibiki_byAuthor = "jibiki_byAuthor";

    /**
     * Class attribute constant for element class jibiki_status
     */
    public static final String CLASS_jibiki_status = "jibiki_status";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ActionNodesXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/ActionNodes.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ActionNodesXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ActionNodesXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ActionNodesXHTMLImpl(ActionNodesXHTMLImpl src) {
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
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "head");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/html; charset=utf-8");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "http-equiv");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("content-type");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("Query result");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("action_list");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("ActionsNode");
        $attr3.appendChild($node4);
        
        $element_ActionsNode = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("entry_actions");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("jibiki_status");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EntryStatus");
        $attr5.appendChild($node6);
        
        $element_EntryStatus = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("jibiki_byAuthor");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("by ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("jibiki_author");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("EntryAuthor");
        $attr6.appendChild($node7);
        
        $element_EntryAuthor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EditEntryAnchor");
        $attr5.appendChild($node6);
        
        $element_EditEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("edit");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("DuplicateEntryAnchor");
        $attr5.appendChild($node6);
        
        $element_DuplicateEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("duplicate & edit");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("DeleteEntryAnchor");
        $attr5.appendChild($node6);
        
        $element_DeleteEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("delete");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UndeleteEntryAnchor");
        $attr5.appendChild($node6);
        
        $element_UndeleteEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("undelete & edit");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ViewAxieAnchor");
        $attr5.appendChild($node6);
        
        $element_ViewAxieAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("view axie");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ViewHistoryEntryAnchor");
        $attr5.appendChild($node6);
        
        $element_ViewHistoryEntryAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("view history");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ViewXmlAnchor");
        $attr5.appendChild($node6);
        
        $element_ViewXmlAnchor = (org.enhydra.xml.xhtml.dom.XHTMLAnchorElement)$elem5;$node6 = document.createTextNode("view XML");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n    ");
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
        return new ActionNodesXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ActionsNode</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementActionsNode() {
        return $element_ActionsNode;
    }

    /**
     * Get the element with id <CODE>DeleteEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementDeleteEntryAnchor() {
        return $element_DeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>DuplicateEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementDuplicateEntryAnchor() {
        return $element_DuplicateEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EditEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementEditEntryAnchor() {
        return $element_EditEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryAuthor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryAuthor() {
        return $element_EntryAuthor;
    }

    /**
     * Get the element with id <CODE>EntryStatus</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementEntryStatus() {
        return $element_EntryStatus;
    }

    /**
     * Get the element with id <CODE>UndeleteEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementUndeleteEntryAnchor() {
        return $element_UndeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewAxieAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewAxieAnchor() {
        return $element_ViewAxieAnchor;
    }

    /**
     * Get the element with id <CODE>ViewHistoryEntryAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewHistoryEntryAnchor() {
        return $element_ViewHistoryEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLAnchorElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLAnchorElement getElementViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the element with id <CODE>ActionsNode</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagActionsNode() {
        return $element_ActionsNode;
    }

    /**
     * Get the element with id <CODE>DeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDeleteEntryAnchor() {
        return $element_DeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>DuplicateEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDuplicateEntryAnchor() {
        return $element_DuplicateEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EditEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditEntryAnchor() {
        return $element_EditEntryAnchor;
    }

    /**
     * Get the element with id <CODE>EntryAuthor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryAuthor() {
        return $element_EntryAuthor;
    }

    /**
     * Get the element with id <CODE>EntryStatus</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEntryStatus() {
        return $element_EntryStatus;
    }

    /**
     * Get the element with id <CODE>UndeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUndeleteEntryAnchor() {
        return $element_UndeleteEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewAxieAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewAxieAnchor() {
        return $element_ViewAxieAnchor;
    }

    /**
     * Get the element with id <CODE>ViewHistoryEntryAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewHistoryEntryAnchor() {
        return $element_ViewHistoryEntryAnchor;
    }

    /**
     * Get the element with id <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagViewXmlAnchor() {
        return $element_ViewXmlAnchor;
    }

    /**
     * Get the value of text child of element <CODE>ActionsNode</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextActionsNode(String text) {
        doSetText($element_ActionsNode, text);
    }

    /**
     * Get the value of text child of element <CODE>DeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDeleteEntryAnchor(String text) {
        doSetText($element_DeleteEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>DuplicateEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDuplicateEntryAnchor(String text) {
        doSetText($element_DuplicateEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EditEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditEntryAnchor(String text) {
        doSetText($element_EditEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryAuthor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryAuthor(String text) {
        doSetText($element_EntryAuthor, text);
    }

    /**
     * Get the value of text child of element <CODE>EntryStatus</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEntryStatus(String text) {
        doSetText($element_EntryStatus, text);
    }

    /**
     * Get the value of text child of element <CODE>UndeleteEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUndeleteEntryAnchor(String text) {
        doSetText($element_UndeleteEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewAxieAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewAxieAnchor(String text) {
        doSetText($element_ViewAxieAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewHistoryEntryAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewHistoryEntryAnchor(String text) {
        doSetText($element_ViewHistoryEntryAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>ViewXmlAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextViewXmlAnchor(String text) {
        doSetText($element_ViewXmlAnchor, text);
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
