/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlpivax.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlpivax/orig/OMNIA.xhtml
 */
public class OMNIAXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements OMNIAXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Formulaire;

    private org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement $element_Input;

    private org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement $element_Output;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Volume;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_Xplain;

    /**
     * Element name constant for chercher
     */
    public static final String NAME_chercher = "chercher";

    /**
     * Element name constant for input
     */
    public static final String NAME_input = "input";

    /**
     * Element name constant for output
     */
    public static final String NAME_output = "output";

    /**
     * Element name constant for volume
     */
    public static final String NAME_volume = "volume";

    /**
     * Element name constant for xplain
     */
    public static final String NAME_xplain = "xplain";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = OMNIAXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlpivax/orig/OMNIA.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public OMNIAXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public OMNIAXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public OMNIAXHTMLImpl(OMNIAXHTMLImpl src) {
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
        
        $node4 = document.createTextNode("Projet OMNIA");
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
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_Formulaire = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h4");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("G\u00e9n\u00e9ration des r\u00e8gles des syst\u00e8mes-Q des entr\u00e9es dans le volume UW");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n            Interface pour consulter et g\u00e9n\u00e9rer les r\u00e8gles des syst\u00e8mes-Q pour annoter le texte\n            Param:\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("input=[liste des lemmes]");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("xplain=[true/false] (pour r\u00e9cup\u00e9rer seulement les r\u00e8gles sous la forme textuelle");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n            ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "form");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "action");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("OMNIA.po");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "method");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("post");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "id");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("volume");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "name");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("volume");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "type");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("hidden");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "value");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("Pivax_unl-upp");
        $attr6.appendChild($node7);
        
        $element_Volume = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem6;$node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "border");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("0");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "cellpadding");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("10");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "cellspacing");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("0");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "summary");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("autoMatch");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("600");
        $attr6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("Liste des lemmes:");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem8.appendChild($elem9);
        
        $node10 = document.createTextNode("R\u00e8gles g\u00e9n\u00e9r\u00e9es:");
        $elem9.appendChild($node10);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "textarea");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "cols");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("80");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("input");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("input");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "rows");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("30");
        $attr9.appendChild($node10);
        
        $element_Input = (org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement)$elem9;$node10 = document.createTextNode("a\ta\tN\nparaglide \tparaglide\tN\nfly\tfly\tV\nabove\tabove\tPRE\nfield\tfield\tN\nresemblant\tresemblant\tV\nto\tto\tV\na\ta\tN\ncardiogram\tcardiogram\tN\nduring\tduring\tA\na\ta\tN\ncharity\tcharity\tN\nday\tday\tN\nfor\tfor\tN\nchild\tchild\tN\nwith\twith\tPRE\nheart problem\t$MOTCP(heart,#sp,problem)\tUNK\nat\tat\tPRE\nvertical\tvertical\tA\nvertical fin\t$MOTCP(vertical,#sp,fin)\tN\nair-condition\t$MOTCP(air,-,condition)\tV\nair-ship\t$MOTCP(air,-,ship)\tV\n                        \n                        ");
        $elem9.appendChild($node10);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "textarea");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "cols");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("80");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("output");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("output");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "rows");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("30");
        $attr9.appendChild($node10);
        
        $element_Output = (org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement)$elem9;$node10 = document.createTextNode("output");
        $elem9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "colspan");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("2");
        $attr8.appendChild($node9);
        
        $node9 = document.createTextNode("\n                          R\u00e9cup\u00e9rer seulement la sortie:");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("xplain");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("xplain");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("checkbox");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("true");
        $attr9.appendChild($node10);
        
        $element_Xplain = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem9;$node9 = document.createTextNode("\n                            ");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("chercher");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "type");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("submit");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "value");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("chercher");
        $attr9.appendChild($node10);
        
        $node9 = document.createTextNode("\n                        ");
        $elem8.appendChild($node9);
        
        $node6 = document.createTextNode("\n                ");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n        ");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new OMNIAXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>input</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement getElementInput() {
        return $element_Input;
    }

    /**
     * Get the element with id <CODE>output</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLTextAreaElement getElementOutput() {
        return $element_Output;
    }

    /**
     * Get the element with id <CODE>volume</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementVolume() {
        return $element_Volume;
    }

    /**
     * Get the element with id <CODE>xplain</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementXplain() {
        return $element_Xplain;
    }

    /**
     * Get the element with id <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagFormulaire() {
        return $element_Formulaire;
    }

    /**
     * Get the element with id <CODE>input</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagInput() {
        return $element_Input;
    }

    /**
     * Get the element with id <CODE>output</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagOutput() {
        return $element_Output;
    }

    /**
     * Get the element with id <CODE>volume</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolume() {
        return $element_Volume;
    }

    /**
     * Get the element with id <CODE>xplain</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXplain() {
        return $element_Xplain;
    }

    /**
     * Get the value of text child of element <CODE>Formulaire</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextFormulaire(String text) {
        doSetText($element_Formulaire, text);
    }

    /**
     * Get the value of text child of element <CODE>input</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextInput(String text) {
        doSetText($element_Input, text);
    }

    /**
     * Get the value of text child of element <CODE>output</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextOutput(String text) {
        doSetText($element_Output, text);
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
