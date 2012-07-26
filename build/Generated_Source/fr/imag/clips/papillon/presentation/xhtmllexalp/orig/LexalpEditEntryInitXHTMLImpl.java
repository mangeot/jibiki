/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmllexalp.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmllexalp/orig/LexalpEditEntryInit.xhtml
 */
public class LexalpEditEntryInitXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements LexalpEditEntryInitXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_CreateAnywayButton;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_EditEntryInitContent;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Headword;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserName;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_VOLUME;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    /**
     * Class attribute constant for element class QueryForm
     */
    public static final String CLASS_QueryForm = "QueryForm";

    /**
     * Class attribute constant for element class hidden
     */
    public static final String CLASS_hidden = "hidden";

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Element name constant for Headword
     */
    public static final String NAME_Headword = "Headword";

    /**
     * Element name constant for VOLUME
     */
    public static final String NAME_VOLUME = "VOLUME";

    /**
     * Element name constant for action
     */
    public static final String NAME_action = "action";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = LexalpEditEntryInitXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmllexalp/orig/LexalpEditEntryInit.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public LexalpEditEntryInitXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public LexalpEditEntryInitXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public LexalpEditEntryInitXHTMLImpl(LexalpEditEntryInitXHTMLImpl src) {
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
        
        $node4 = document.createTextNode("Edition of LexALP Term Bank");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("EditEntryInitContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_EditEntryInitContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode(" \n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("title");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UserName");
        $attr5.appendChild($node6);
        
        $element_UserName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("Name");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" edition interface");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text/javascript");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $node5 = document.createComment(" \n                // Open a new interface window to create the new entry \n                function create() {\n                    href = 'LexalpEditEntryInit.po?action=createAnyway&VOLUME=' + document.getElementById('VOLUME').value + '&Headword=' +  document.getElementById('Headword').value;\n                    window.open(href,'EditEntry');\n                }\n            //");
        $elem4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("hidden");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Create ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Headword");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Headword");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("text");
        $attr5.appendChild($node6);
        
        $element_Headword = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode(" in \n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("VOLUME");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("VOLUME");
        $attr5.appendChild($node6);
        
        $element_VOLUME = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem5;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("VolumeOptionTemplate");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "label");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("NONE");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("NONE");
        $attr6.appendChild($node7);
        
        $element_VolumeOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem6;$node7 = document.createTextNode("NONE");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n            ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("CreateAnywayButton");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "name");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("action");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "onclick");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("create()");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "type");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("submit");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "value");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("create anyway");
        $attr5.appendChild($node6);
        
        $element_CreateAnywayButton = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem5;$node5 = document.createTextNode("\n        ");
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
        $node5 = document.createTextNode("QueryResultForm");
        $attr4.appendChild($node5);
        
        $element_QueryResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
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
        return new LexalpEditEntryInitXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>CreateAnywayButton</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementCreateAnywayButton() {
        return $element_CreateAnywayButton;
    }

    /**
     * Get the element with id <CODE>EditEntryInitContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementEditEntryInitContent() {
        return $element_EditEntryInitContent;
    }

    /**
     * Get the element with id <CODE>Headword</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementHeadword() {
        return $element_Headword;
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
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementUserName() {
        return $element_UserName;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>CreateAnywayButton</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCreateAnywayButton() {
        return $element_CreateAnywayButton;
    }

    /**
     * Get the element with id <CODE>EditEntryInitContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEditEntryInitContent() {
        return $element_EditEntryInitContent;
    }

    /**
     * Get the element with id <CODE>Headword</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHeadword() {
        return $element_Headword;
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
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUserName() {
        return $element_UserName;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>EditEntryInitContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextEditEntryInitContent(String text) {
        doSetText($element_EditEntryInitContent, text);
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
     * Get the value of text child of element <CODE>UserName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserName(String text) {
        doSetText($element_UserName, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeOptionTemplate(String text) {
        doSetText($element_VolumeOptionTemplate, text);
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
