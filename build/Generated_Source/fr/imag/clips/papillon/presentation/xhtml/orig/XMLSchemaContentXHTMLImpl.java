/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/XMLSchemaContent.xhtml
 */
public class XMLSchemaContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements XMLSchemaContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_XMLSchemaContent;

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = XMLSchemaContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/orig/XMLSchemaContent.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public XMLSchemaContentXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public XMLSchemaContentXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public XMLSchemaContentXHTMLImpl(XMLSchemaContentXHTMLImpl src) {
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
        $node4 = document.createTextNode("XMLSchemaContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("en");
        $attr3.appendChild($node4);
        
        $element_XMLSchemaContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n\n   ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("XML Schema for the archive description file");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ImportHelp.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Back");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to Addition Help page");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AdminInformations.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Back");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to Information Documents administration page\n");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Here is the XML Schema that defines the description file format for an archive(info_doc.xml).");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\nDownload the schema:");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("nbsp");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00a0");
        $node5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("xsd/info_doc.xsd");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("info_doc.xsd");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "border");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("1");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("XML schema");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "caption");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("XML Schema info_doc.xsd");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "align");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("left");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "pre");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n  <xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n\n     <xsd:annotation>\n        <xsd:documentation xml:lang=\"en\">\n           Papillon project : schema for info_doc.xml files in non-HTML Tar and Zip archives\n        </xsd:documentation>\t\t\t\t\t\t     \n     </xsd:annotation>\n\n     <xsd:element name=\"document\" type=\"DocumentType\"/>\n\n     <xsd:complexType name=\"DocumentType\">\n        <xsd:sequence>\n           <xsd:element name=\"title\" type=\"TitleType\"/>\n\t   <xsd:element name=\"authors\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"date\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"reference\" type=\"xsd:string\"/>\n        </xsd:sequence>\n        <xsd:attribute name=\"section\" use=\"required\" type=\"SectionType\"/>\n     </xsd:complexType>\n\n     <xsd:complexType name=\"TitleType\">\n        <xsd:all>\n           <xsd:element name=\"deu\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"eng\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n   \t   <xsd:element name=\"esp\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"fra\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"hun\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"ita\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"jpn\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"lao\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"msa\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"tha\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n\t   <xsd:element name=\"vie\" minOccurs=\"0\" maxOccurs=\"1\" type=\"xsd:string\"/>\n        </xsd:all>\n     </xsd:complexType>\n\n\n     <xsd:simpleType name=\"SectionType\">\n        <xsd:restriction base=\"xsd:string\">\n\t   <xsd:enumeration value=\"DEV\"/> \n\t   <xsd:enumeration value=\"DICT\"/> \n\t   <xsd:enumeration value=\"INFO\"/> \n\t   <xsd:enumeration value=\"PAPILLON01\"/> \n\t   <xsd:enumeration value=\"PAPILLON02\"/> \n\t   <xsd:enumeration value=\"PAPILLON03\"/> \n\t   <xsd:enumeration value=\"PUBLIS\"/> \n\t   <xsd:enumeration value=\"PUBLI_PAP\"/> \n\t   <xsd:enumeration value=\"HOWTO\"/> \n\t   <xsd:enumeration value=\"MISC\"/>\n        </xsd:restriction>\n     </xsd:simpleType>\n\n  </xsd:schema>\n");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("The date type should be an xsd:date type ... \nFor the moment, date has the following format in digits: dd/mm/yyyy.\nThe 15");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "sup");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("th");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" of September 2002 is written like this:");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n15/09/2002");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("An example of a valid description file:");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("nbsp");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00a0");
        $node5.appendChild($node6);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "border");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("1");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("example");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "align");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("left");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n");
        $elem6.appendChild($node7);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "pre");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n  <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n  <document section=\"MISC\">\n     <title>\n        <deu>Das Papillon projekt</deu>\n        <eng>The Papillon project</eng>\n        <fra>Le projet Papillon</fra>\n     </title>\n     <authors>Olivier Tache</authors>\n     <date>15/09/2002</date>\n     <reference>Master thesis</reference>\n   </document>\n");
        $elem7.appendChild($node8);
        
        $node7 = document.createTextNode("\n");
        $elem6.appendChild($node7);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("ImportHelp.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Back");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to Addition Help page");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\n");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AdminInformations.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Back");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" to Information Documents administration page\n");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new XMLSchemaContentXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>XMLSchemaContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementXMLSchemaContent() {
        return $element_XMLSchemaContent;
    }

    /**
     * Get the element with id <CODE>XMLSchemaContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagXMLSchemaContent() {
        return $element_XMLSchemaContent;
    }

    /**
     * Get the value of text child of element <CODE>XMLSchemaContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextXMLSchemaContent(String text) {
        doSetText($element_XMLSchemaContent, text);
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
