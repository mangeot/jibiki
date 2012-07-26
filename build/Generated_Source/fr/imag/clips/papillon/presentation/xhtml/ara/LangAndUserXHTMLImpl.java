/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.ara;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/ara/LangAndUser.xhtml
 */
public class LangAndUserXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements LangAndUserXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.LangAndUserXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Lang;

    private org.enhydra.xml.xhtml.dom.XHTMLFormElement $element_LangForm;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LangSelectPlace;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_LanguageAndUser;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LoginAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_LogoutAnchor;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserLogin;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserProfileAnchor;

    /**
     * Class attribute constant for element class menuBlock
     */
    public static final String CLASS_menuBlock = "menuBlock";

    /**
     * Class attribute constant for element class menuTitle
     */
    public static final String CLASS_menuTitle = "menuTitle";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = LangAndUserXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/ara/LangAndUser.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public LangAndUserXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public LangAndUserXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public LangAndUserXHTMLImpl(LangAndUserXHTMLImpl src) {
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
        
        $node4 = document.createTextNode("\u0627\u0644\u062e\u064a\u0627\u0631\u0627\u062a");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("menuBlock");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "dir");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("rtl");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("LanguageAndUser");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("ar");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("ar");
        $attr3.appendChild($node4);
        
        $element_LanguageAndUser = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "class");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("menuTitle");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("javascript:void(0)");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("UserLogin");
        $attr4.appendChild($node5);
        
        $element_UserLogin = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("\u0627\u0633\u0645 \u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("PapillonBasePO.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LangForm");
        $attr4.appendChild($node5);
        
        $element_LangForm = (org.enhydra.xml.xhtml.dom.XHTMLFormElement)$elem4;$elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "accesskey");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("\u0644");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "for");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("lang");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\u0627\u0644\u0644\u063a\u0629");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("LangSelectPlace");
        $attr6.appendChild($node7);
        
        $element_LangSelectPlace = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem6;$node7 = document.createTextNode("\n          ");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("lang");
        $attr7.appendChild($node8);
        
        $element_Lang = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node7 = document.createTextNode("\n        ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "noscript");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem6.appendChild($elem7);
        
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
        
        $node6 = document.createTextNode("\n      ");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LoginAnchor");
        $attr4.appendChild($node5);
        
        $element_LoginAnchor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LoginUser.po");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u062a\u0633\u062c\u064a\u0644 \u0627\u0644\u062f\u062e\u0648\u0644");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u062a\u0633\u062c\u064a\u0644 \u0627\u0644\u062f\u062e\u0648\u0644");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("UserProfileAnchor");
        $attr4.appendChild($node5);
        
        $element_UserProfileAnchor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UserProfile.po");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u0644\u0648\u062d\u0629 \u062a\u062d\u0643\u0645 \u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u0644\u0648\u062d\u0629 \u062a\u062d\u0643\u0645 \u0627\u0644\u0645\u0633\u062a\u062e\u062f\u0645");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("LogoutAnchor");
        $attr4.appendChild($node5);
        
        $element_LogoutAnchor = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LoginUser.po?Logout=yes");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "onclick");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("return confirm('\u00cates-vous s\u00fbr de vouloir vous d\u00e9loguer')");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "title");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("\u062a\u0633\u062c\u064a\u0644 \u0627\u0644\u062e\u0631\u0648\u062c");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u062a\u0633\u062c\u064a\u0644 \u0627\u0644\u062e\u0631\u0648\u062c");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
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
        return new LangAndUserXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>lang</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLang() {
        return $element_Lang;
    }

    /**
     * Get the element with id <CODE>LangForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLFormElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLFormElement getElementLangForm() {
        return $element_LangForm;
    }

    /**
     * Get the element with id <CODE>LangSelectPlace</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLangSelectPlace() {
        return $element_LangSelectPlace;
    }

    /**
     * Get the element with id <CODE>LanguageAndUser</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementLanguageAndUser() {
        return $element_LanguageAndUser;
    }

    /**
     * Get the element with id <CODE>LoginAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLoginAnchor() {
        return $element_LoginAnchor;
    }

    /**
     * Get the element with id <CODE>LogoutAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementLogoutAnchor() {
        return $element_LogoutAnchor;
    }

    /**
     * Get the element with id <CODE>UserLogin</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementUserLogin() {
        return $element_UserLogin;
    }

    /**
     * Get the element with id <CODE>UserProfileAnchor</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementUserProfileAnchor() {
        return $element_UserProfileAnchor;
    }

    /**
     * Get the element with id <CODE>lang</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLang() {
        return $element_Lang;
    }

    /**
     * Get the element with id <CODE>LangForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLangForm() {
        return $element_LangForm;
    }

    /**
     * Get the element with id <CODE>LangSelectPlace</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLangSelectPlace() {
        return $element_LangSelectPlace;
    }

    /**
     * Get the element with id <CODE>LanguageAndUser</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLanguageAndUser() {
        return $element_LanguageAndUser;
    }

    /**
     * Get the element with id <CODE>LoginAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLoginAnchor() {
        return $element_LoginAnchor;
    }

    /**
     * Get the element with id <CODE>LogoutAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLogoutAnchor() {
        return $element_LogoutAnchor;
    }

    /**
     * Get the element with id <CODE>UserLogin</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUserLogin() {
        return $element_UserLogin;
    }

    /**
     * Get the element with id <CODE>UserProfileAnchor</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUserProfileAnchor() {
        return $element_UserProfileAnchor;
    }

    /**
     * Get the value of text child of element <CODE>lang</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLang(String text) {
        doSetText($element_Lang, text);
    }

    /**
     * Get the value of text child of element <CODE>LangSelectPlace</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLangSelectPlace(String text) {
        doSetText($element_LangSelectPlace, text);
    }

    /**
     * Get the value of text child of element <CODE>LanguageAndUser</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLanguageAndUser(String text) {
        doSetText($element_LanguageAndUser, text);
    }

    /**
     * Get the value of text child of element <CODE>LoginAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLoginAnchor(String text) {
        doSetText($element_LoginAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>LogoutAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextLogoutAnchor(String text) {
        doSetText($element_LogoutAnchor, text);
    }

    /**
     * Get the value of text child of element <CODE>UserLogin</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserLogin(String text) {
        doSetText($element_UserLogin, text);
    }

    /**
     * Get the value of text child of element <CODE>UserProfileAnchor</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserProfileAnchor(String text) {
        doSetText($element_UserProfileAnchor, text);
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
