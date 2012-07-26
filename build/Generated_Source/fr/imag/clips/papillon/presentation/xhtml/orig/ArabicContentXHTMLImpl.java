/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/ArabicContent.xhtml
 */
public class ArabicContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ArabicContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HomeContent;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ProjectDescription;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    /**
     * Class attribute constant for element class ar
     */
    public static final String CLASS_ar = "ar";

    /**
     * Class attribute constant for element class gray
     */
    public static final String CLASS_gray = "gray";

    /**
     * Class attribute constant for element class standard
     */
    public static final String CLASS_standard = "standard";

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ArabicContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/ArabicContent.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ArabicContentXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ArabicContentXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ArabicContentXHTMLImpl(ArabicContentXHTMLImpl src) {
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
        
        $node4 = document.createTextNode("Papillon");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $node3 = document.createComment(" Be careful, in order to display the languages in a random order, there must be as many h1 than p ");
        $elem2.appendChild($node3);
        
        $node3 = document.createComment(" and in the same language order ");
        $elem2.appendChild($node3);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "dir");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("rtl");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("HomeContent");
        $attr3.appendChild($node4);
        
        $element_HomeContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment(" in this div, there must be only p and h1 tags ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("ProjectDescription");
        $attr4.appendChild($node5);
        
        $element_ProjectDescription = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ar");
        $attr5.appendChild($node6);
        
        $attr5 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ar");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\u0627\u0644\u0645\u0634\u0631\u0648\u0639 ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("gray");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\u0645\u0635\u0637\u0644\u062d");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("standard");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("\n          ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "span");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "class");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ar");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ar");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ar");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n          \u0645\u0634\u0631\u0648\u0639 \u0645\u0635\u0637\u0644\u062d \u0647\u0648 \u062c\u0632\u0621 \u0645\u0646 \u0645\u0634\u0631\u0648\u0639 \u0623\u0634\u0645\u0644 \u0648 \u0647\u0648 \u0645\u0634\u0631\u0648\u0639 \u0641\u0631\u0627\u0634\u0629\u060c \u064a\u0647\u062f\u0641 \u0645\u0634\u0631\u0648\u0639 \u0645\u0635\u0637\u0644\u062d \u0625\u0644\u0649 \u062c\u0645\u0639 \u0645\u0627\u0647\u0648 \u0645\u062a\u0627\u062d \u0644\u062f\u0649 \u0627\u0644\u062f\u0648\u0644 \u0627\u0644\u0639\u0631\u0628\u064a\u0629 \u0648 \u0627\u0644\u0645\u0624\u0633\u0633\u0627\u062a \u0627\u0644\u0639\u0627\u0626\u062f\u0629 \u0625\u0644\u064a\u0647\u0627 \u0628\u0627\u0644\u0646\u0638\u0631 \u0645\u0646 \u0642\u0648\u0627\u0639\u062f \u0628\u064a\u0627\u0646\u0627\u062a \u0645\u0635\u0637\u0644\u062d\u064a\u0629 \u0641\u064a \u0645\u062e\u062a\u0644\u0641 \u0627\u0644\u0645\u062c\u0644\u0627\u062a \u0648 \u0630\u0644\u0643 \u0628\u0647\u062f\u0641 \u0625\u0646\u0634\u0627\u0621 \u0646\u0648\u0627\u0629 \u0644\u0628\u0646\u0643 \u0645\u0635\u0637\u0644\u062d\u064a \u0645\u0641\u062a\u0648\u062d \u0627\u0644\u0645\u0635\u062f\u0631 \u0648 \u0645\u062a\u0627\u062d \u0644\u0643\u0644 \u0627\u0644\u0645\u062e\u062a\u0635\u064a\u0646 \u0641\u064a \u0645\u062c\u0627\u0644 \u0627\u0644\u0645\u0635\u0637\u0644\u062d\u064a\u0629 \u0648 \u0627\u0644\u062a\u0631\u062c\u0645\u0629\n          ");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\u0631\u0627\u0628\u0637 \u0630\u064a \u0635\u0644\u0629 : ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://javalig.imag.fr/jdmar/jdm-accueil.php");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "title");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("\u0631\u0627\u0628\u0637 \u0630\u064a \u0635\u0644\u0629");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\u0644\u0639\u0628\u0629 \u0627\u0644\u0643\u0644\u0645\u0627\u062a \u0627\u0644\u0639\u0631\u0628\u064a\u0629");
        $elem6.appendChild($node7);
        
        $node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n       ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryResult");
        $attr4.appendChild($node5);
        
        $element_QueryResult = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("title");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Search result");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node5 = document.createTextNode("\n      ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n      ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "id");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("QueryFuzzyResult");
        $attr4.appendChild($node5);
        
        $element_QueryFuzzyResult = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem4;$node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "class");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("title");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Fuzzy search result");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryFuzzyResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryFuzzyResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node5 = document.createTextNode("\n      ");
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
        return new ArabicContentXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>HomeContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementHomeContent() {
        return $element_HomeContent;
    }

    /**
     * Get the element with id <CODE>ProjectDescription</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementProjectDescription() {
        return $element_ProjectDescription;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResult</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryFuzzyResult() {
        return $element_QueryFuzzyResult;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryFuzzyResultForm() {
        return $element_QueryFuzzyResultForm;
    }

    /**
     * Get the element with id <CODE>QueryResult</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryResult() {
        return $element_QueryResult;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the element with id <CODE>HomeContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHomeContent() {
        return $element_HomeContent;
    }

    /**
     * Get the element with id <CODE>ProjectDescription</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagProjectDescription() {
        return $element_ProjectDescription;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResult</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryFuzzyResult() {
        return $element_QueryFuzzyResult;
    }

    /**
     * Get the element with id <CODE>QueryFuzzyResultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryFuzzyResultForm() {
        return $element_QueryFuzzyResultForm;
    }

    /**
     * Get the element with id <CODE>QueryResult</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryResult() {
        return $element_QueryResult;
    }

    /**
     * Get the element with id <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagQueryResultForm() {
        return $element_QueryResultForm;
    }

    /**
     * Get the value of text child of element <CODE>HomeContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextHomeContent(String text) {
        doSetText($element_HomeContent, text);
    }

    /**
     * Get the value of text child of element <CODE>ProjectDescription</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextProjectDescription(String text) {
        doSetText($element_ProjectDescription, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryFuzzyResult</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryFuzzyResult(String text) {
        doSetText($element_QueryFuzzyResult, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryFuzzyResultForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryFuzzyResultForm(String text) {
        doSetText($element_QueryFuzzyResultForm, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryResult</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryResult(String text) {
        doSetText($element_QueryResult, text);
    }

    /**
     * Get the value of text child of element <CODE>QueryResultForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextQueryResultForm(String text) {
        doSetText($element_QueryResultForm, text);
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
