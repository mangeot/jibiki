/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.est;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/est/UserProfile.xhtml
 */
public class UserProfileXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements UserProfileXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.UserProfileXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_AGLogin;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_CELogin;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_CPLogin;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_CPPassword;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_Credits;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_DLogin;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_DPassword;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_EmailInput;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_Group;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_GroupList;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_GroupOptionTemplate;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_GroupPassword;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_NameInput;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_NewPassword;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_NewPassword2;

    private org.enhydra.xml.xhtml.dom.XHTMLSpanElement $element_UserName;

    /**
     * Element name constant for AddGroup
     */
    public static final String NAME_AddGroup = "AddGroup";

    /**
     * Element name constant for CPPassword
     */
    public static final String NAME_CPPassword = "CPPassword";

    /**
     * Element name constant for ChangeEmail
     */
    public static final String NAME_ChangeEmail = "ChangeEmail";

    /**
     * Element name constant for ChangePassword
     */
    public static final String NAME_ChangePassword = "ChangePassword";

    /**
     * Element name constant for DPassword
     */
    public static final String NAME_DPassword = "DPassword";

    /**
     * Element name constant for DelGroup
     */
    public static final String NAME_DelGroup = "DelGroup";

    /**
     * Element name constant for Delete
     */
    public static final String NAME_Delete = "Delete";

    /**
     * Element name constant for Email
     */
    public static final String NAME_Email = "Email";

    /**
     * Element name constant for Group
     */
    public static final String NAME_Group = "Group";

    /**
     * Element name constant for GroupPassword
     */
    public static final String NAME_GroupPassword = "GroupPassword";

    /**
     * Element name constant for Name
     */
    public static final String NAME_Name = "Name";

    /**
     * Element name constant for NewPassword
     */
    public static final String NAME_NewPassword = "NewPassword";

    /**
     * Element name constant for NewPassword2
     */
    public static final String NAME_NewPassword2 = "NewPassword2";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = UserProfileXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/est/UserProfile.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public UserProfileXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public UserProfileXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public UserProfileXHTMLImpl(UserProfileXHTMLImpl src) {
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
        $node4 = document.createTextNode("et");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("et");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("UserName");
        $attr5.appendChild($node6);
        
        $element_UserName = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem5;$node6 = document.createTextNode("Kasutajanimi");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" kasutajakonto seadistus");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "border");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("0");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "cellpadding");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("10");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "cellspacing");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("0");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Credits");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "width");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("600");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("Credits:");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "id");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("Credits");
        $attr7.appendChild($node8);
        
        $element_Credits = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem7;$node8 = document.createTextNode("Credits");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        buildSubDocument_0(document, $elem3);
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" change mail addresse ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("UserProfile.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("post");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("10");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellspacing");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ChangeMailAddresse");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Muuda nime ja e-posti aadressi");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Kasutajanimi");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("CELogin");
        $attr8.appendChild($node9);
        
        $element_CELogin = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Kasutajanimi");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("NameInput");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Nimi:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("NameInput");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Name");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("30");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Nimi");
        $attr8.appendChild($node9);
        
        $element_NameInput = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("EmailInput");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("E-post:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("EmailInput");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Email");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("30");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("E-post");
        $attr8.appendChild($node9);
        
        $element_EmailInput = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("ChangeEmail");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Muuda");
        $attr8.appendChild($node9);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" add user in group ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("UserProfile.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("post");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("10");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellspacing");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AddGroup");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Liitu t\u00f6\u00f6r\u00fchmaga / Lahku t\u00f6\u00f6r\u00fchmast");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Kasutajanimi:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AGLogin");
        $attr8.appendChild($node9);
        
        $element_AGLogin = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Kasutajanimi");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("Group");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("T\u00f6\u00f6r\u00fchm:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Group");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Group");
        $attr8.appendChild($node9);
        
        $element_Group = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem8;$elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("GroupOptionTemplate");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "label");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("group name");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("group name");
        $attr9.appendChild($node10);
        
        $element_GroupOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem9;$node10 = document.createTextNode("group name");
        $elem9.appendChild($node10);
        
        $node8 = document.createTextNode("\n\t");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("GroupPassword");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("T\u00f6\u00f6r\u00fchma salas\u00f5na:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("GroupPassword");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("GroupPassword");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("10");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("password");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_GroupPassword = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("AddGroup");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Liitu");
        $attr8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DelGroup");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Lahku");
        $attr8.appendChild($node9);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" delete existing user ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("UserProfile.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("post");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "onsubmit");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("return confirm('Are you sure you want to delete the user?')");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "border");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellpadding");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("10");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "cellspacing");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("0");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "summary");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("DeleteUser");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("", "width");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("600");
        $attr5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $node8 = document.createTextNode("Kustuta kasutajakonto");
        $elem7.appendChild($node8);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("Kasutajanimi:");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DLogin");
        $attr8.appendChild($node9);
        
        $element_DLogin = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem8;$node9 = document.createTextNode("Kasutajanimi");
        $elem8.appendChild($node9);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "for");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("DPassword");
        $attr9.appendChild($node10);
        
        $node10 = document.createTextNode("Salas\u00f5na:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DPassword");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("DPassword");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "size");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("10");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("password");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_DPassword = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $attr7 = document.createAttributeNS("", "colspan");
        $elem7.setAttributeNode($attr7);
        $node8 = document.createTextNode("2");
        $attr7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Delete");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("submit");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("Kustuta");
        $attr8.appendChild($node9);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Create a subtree of the document.
     */
    private void buildSubDocument_0(org.w3c.dom.Document document,
                                    org.w3c.dom.Node parentNode) {
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
        $elem0 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        parentNode.appendChild($elem0);
        
        $attr0 = document.createAttributeNS("", "action");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("UserProfile.po");
        $attr0.appendChild($node1);
        
        $attr0 = document.createAttributeNS("", "method");
        $elem0.setAttributeNode($attr0);
        $node1 = document.createTextNode("post");
        $attr0.appendChild($node1);
        
        $node1 = document.createComment(" change password ");
        $elem0.appendChild($node1);
        
        $elem1 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem0.appendChild($elem1);
        
        $attr1 = document.createAttributeNS("", "border");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("0");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "cellpadding");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("10");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "cellspacing");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("0");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "summary");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("ChangePassword");
        $attr1.appendChild($node2);
        
        $attr1 = document.createAttributeNS("", "width");
        $elem1.setAttributeNode($attr1);
        $node2 = document.createTextNode("600");
        $attr1.appendChild($node2);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("T\u00f6\u00f6r\u00fchmade loetelu");
        $elem4.appendChild($node5);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("T\u00f6\u00f6r\u00fchmad:");
        $elem4.appendChild($node5);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("GroupList");
        $attr4.appendChild($node5);
        
        $element_GroupList = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("T\u00f6\u00f6r\u00fchmad");
        $elem4.appendChild($node5);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Muuda salas\u00f5na");
        $elem4.appendChild($node5);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Kasutajanimi:");
        $elem4.appendChild($node5);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("CPLogin");
        $attr4.appendChild($node5);
        
        $element_CPLogin = (org.enhydra.xml.xhtml.dom.XHTMLSpanElement)$elem4;$node5 = document.createTextNode("Kasutajanimi");
        $elem4.appendChild($node5);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "for");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("CPPassword");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Praegune salas\u00f5na:");
        $elem5.appendChild($node6);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("CPPassword");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("CPPassword");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("10");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("password");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_CPPassword = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "for");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NewPassword");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Uus salas\u00f5na:");
        $elem5.appendChild($node6);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("NewPassword");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("NewPassword");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("10");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("password");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_NewPassword = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "for");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("NewPassword2");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Kinnita uus salas\u00f5na:");
        $elem5.appendChild($node6);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("NewPassword2");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("NewPassword2");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "size");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("10");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("password");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("");
        $attr4.appendChild($node5);
        
        $element_NewPassword2 = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem4;$elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "colspan");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("2");
        $attr3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "name");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ChangePassword");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "type");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("submit");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "value");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Muuda");
        $attr4.appendChild($node5);
        
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new UserProfileXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>AGLogin</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementAGLogin() {
        return $element_AGLogin;
    }

    /**
     * Get the element with id <CODE>CELogin</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCELogin() {
        return $element_CELogin;
    }

    /**
     * Get the element with id <CODE>CPLogin</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCPLogin() {
        return $element_CPLogin;
    }

    /**
     * Get the element with id <CODE>CPPassword</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementCPPassword() {
        return $element_CPPassword;
    }

    /**
     * Get the element with id <CODE>Credits</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementCredits() {
        return $element_Credits;
    }

    /**
     * Get the element with id <CODE>DLogin</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementDLogin() {
        return $element_DLogin;
    }

    /**
     * Get the element with id <CODE>DPassword</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementDPassword() {
        return $element_DPassword;
    }

    /**
     * Get the element with id <CODE>EmailInput</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementEmailInput() {
        return $element_EmailInput;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Group</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementGroup() {
        return $element_Group;
    }

    /**
     * Get the element with id <CODE>GroupList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementGroupList() {
        return $element_GroupList;
    }

    /**
     * Get the element with id <CODE>GroupOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementGroupOptionTemplate() {
        return $element_GroupOptionTemplate;
    }

    /**
     * Get the element with id <CODE>GroupPassword</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementGroupPassword() {
        return $element_GroupPassword;
    }

    /**
     * Get the element with id <CODE>NameInput</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementNameInput() {
        return $element_NameInput;
    }

    /**
     * Get the element with id <CODE>NewPassword</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementNewPassword() {
        return $element_NewPassword;
    }

    /**
     * Get the element with id <CODE>NewPassword2</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementNewPassword2() {
        return $element_NewPassword2;
    }

    /**
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementUserName() {
        return $element_UserName;
    }

    /**
     * Get the element with id <CODE>AGLogin</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagAGLogin() {
        return $element_AGLogin;
    }

    /**
     * Get the element with id <CODE>CELogin</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCELogin() {
        return $element_CELogin;
    }

    /**
     * Get the element with id <CODE>CPLogin</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCPLogin() {
        return $element_CPLogin;
    }

    /**
     * Get the element with id <CODE>CPPassword</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCPPassword() {
        return $element_CPPassword;
    }

    /**
     * Get the element with id <CODE>Credits</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagCredits() {
        return $element_Credits;
    }

    /**
     * Get the element with id <CODE>DLogin</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDLogin() {
        return $element_DLogin;
    }

    /**
     * Get the element with id <CODE>DPassword</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagDPassword() {
        return $element_DPassword;
    }

    /**
     * Get the element with id <CODE>EmailInput</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagEmailInput() {
        return $element_EmailInput;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>Group</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGroup() {
        return $element_Group;
    }

    /**
     * Get the element with id <CODE>GroupList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGroupList() {
        return $element_GroupList;
    }

    /**
     * Get the element with id <CODE>GroupOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGroupOptionTemplate() {
        return $element_GroupOptionTemplate;
    }

    /**
     * Get the element with id <CODE>GroupPassword</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagGroupPassword() {
        return $element_GroupPassword;
    }

    /**
     * Get the element with id <CODE>NameInput</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNameInput() {
        return $element_NameInput;
    }

    /**
     * Get the element with id <CODE>NewPassword</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNewPassword() {
        return $element_NewPassword;
    }

    /**
     * Get the element with id <CODE>NewPassword2</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagNewPassword2() {
        return $element_NewPassword2;
    }

    /**
     * Get the element with id <CODE>UserName</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagUserName() {
        return $element_UserName;
    }

    /**
     * Get the value of text child of element <CODE>AGLogin</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextAGLogin(String text) {
        doSetText($element_AGLogin, text);
    }

    /**
     * Get the value of text child of element <CODE>CELogin</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCELogin(String text) {
        doSetText($element_CELogin, text);
    }

    /**
     * Get the value of text child of element <CODE>CPLogin</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCPLogin(String text) {
        doSetText($element_CPLogin, text);
    }

    /**
     * Get the value of text child of element <CODE>Credits</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextCredits(String text) {
        doSetText($element_Credits, text);
    }

    /**
     * Get the value of text child of element <CODE>DLogin</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextDLogin(String text) {
        doSetText($element_DLogin, text);
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>GroupList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGroupList(String text) {
        doSetText($element_GroupList, text);
    }

    /**
     * Get the value of text child of element <CODE>GroupOptionTemplate</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextGroupOptionTemplate(String text) {
        doSetText($element_GroupOptionTemplate, text);
    }

    /**
     * Get the value of text child of element <CODE>UserName</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextUserName(String text) {
        doSetText($element_UserName, text);
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
