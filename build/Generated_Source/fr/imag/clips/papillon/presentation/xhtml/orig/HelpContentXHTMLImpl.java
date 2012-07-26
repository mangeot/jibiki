/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/HelpContent.xhtml
 */
public class HelpContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements HelpContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HelpContent;

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = HelpContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/HelpContent.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public HelpContentXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public HelpContentXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public HelpContentXHTMLImpl(HelpContentXHTMLImpl src) {
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
        
        $node4 = document.createTextNode("Papillon");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("HelpContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_HelpContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Help");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Lookup");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("In order to lookup a word in the dictionaries available on the Papillon server,\nuse the left lookup menu in the following way:");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Step 1: enter the word you are looking for;");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Step 2: specify the language of the word entered;");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Step 3: choose the target language in order to obtain the translation of the word entered;");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Step 4: push the \"go\" button.");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Please note that some available dictionaries have only very few entries.\nYou will not obtain the translation in the desired language in any case.\nThe current interface has been built mainly for experimental purposes.\n");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Navigation");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("In order to navigate optimally on this site, we will specify here below which software is suitable");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Software that works fine");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Chimera");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Mozilla 1.0");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Netscape navigator 7.0");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("OmniWeb 4.1");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Opera");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Safari");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Software that poses problems");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Amaya:");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" The last version seems to deal with japanese characters but it is not\nthe case for thai characters.");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("iCab:");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" The \"option\" element of the HTML forms is not implemented correctly.\nIt does not know display properly non-latin characters\nin the option fields. Note that this problem should not occur if you choose a language in latin characters as preferred interface language.");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("Internet Explorer:");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" The \"option\" element of the HTML forms is not implemented correctly. It does not display properly non-ascii characters\nin the option fields. Note that this problem should not occur if you choose a language in ascii characters as preferred interface language.");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Online Edition");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Edition of a monolingual entry (Lexie)");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You have to be ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Register.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("registered");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" and ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LoginUser.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("logged");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to edit online entries.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode(" the ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ConsultEdit.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Online Edition Interface");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" is for tests only. In order to implement the editor properly, we developped the most complete interface with all the details. Thus, this first version implements an interface for specialists lexicographers with all the information. Thanks to the editor which is generic and the fact that now the complete interface is ready for use, we will be able to develop more easily simplified versions of that first interface in a degraded mode for non-specialist users.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You can add entries and then look them up through the ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Home.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Consultation interface");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(".\nNevertheless, these contributions may not be kept or integrated into the database yet.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Edition of a translation link (Axie)");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You have to be ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Register.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("registered");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" and ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LoginUser.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("logged");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to edit online links.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode(" the ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("EditAxie.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Online Edition Interface");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" is for tests only. In order to create translation links (axies) between two entries (lexies) of different languages, these two lexies must exist in the Papillon dictionary (and only this dictionary). If the entries do not exist, you must first create them with the previous ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ConsultEdit.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("monolingual entry edition interface");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(". Then, once your two lexies are created, you can create a translation link (an axie) between them.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Nevertheless, these contributions may not be kept or integrated into the database yet.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Offline Edition");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You can write entries locally on your computer and then upload them to the database.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("To write entries, we recommend the tool XML Spy for PC available at ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.xmlspy.com/");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("www.xmlspy.com");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" for a 30 days free evaluation\nversion. XMLSpy is using XML schemata to validate the data. It will downolad\nautomatically our XML schemata to validate your files.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("The Papillon XML schemata and examples are located at: ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www-clips.imag.fr/geta/services/dml");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("www-clips.imag.fr/geta/services/dml/");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(".");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("To check the validity of your entries online, you can use the W3C XML Schema\nvalidator: ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("http://www.w3.org/XML/Schema");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("www.w3.org/XML/Schema");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(".");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Management of the Contributions");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You have to be ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Register.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("registered");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" and ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LoginUser.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("logged");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to manage your contributions online.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You do so by accessing the ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AdminContributions.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Contribution Administration Interface");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(". With this interface, you can see or delete your existing contributions.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Reviewing the Contributions");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You have to be ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("Register.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("registered");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" and ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("LoginUser.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("logged");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to acces the reviewing interface.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You have to be part of the specialist group to validate any contribution ie to integrate it definitely into the database.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("You can review the contributions online by accessing the ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ReviewContributions.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Contribution Reviewing Interface");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(".");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n \n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Misc");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("If you need more help, please read the papillon ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ConsultInformations.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("publications");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(",  or send an email to\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("mailto:mangeotATnii.ac.jp?subject=PapillonServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Mathieu Mangeot-Nagata");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(".");
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
        return new HelpContentXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>HelpContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementHelpContent() {
        return $element_HelpContent;
    }

    /**
     * Get the element with id <CODE>HelpContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHelpContent() {
        return $element_HelpContent;
    }

    /**
     * Get the value of text child of element <CODE>HelpContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHelpContent(String text) {
        doSetText($element_HelpContent, text);
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
