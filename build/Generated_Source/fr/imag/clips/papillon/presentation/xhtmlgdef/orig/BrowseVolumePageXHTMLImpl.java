/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmlgdef.orig;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmlgdef/orig/BrowseVolumePage.xhtml
 */
public class BrowseVolumePageXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements BrowseVolumePageXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.BrowseVolumePageXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_Elevator;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_HEADWORD;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_LIMIT;

    private org.enhydra.xml.xhtml.dom.XHTMLInputElement $element_STATUS;

    private org.enhydra.xml.xhtml.dom.XHTMLSelectElement $element_VOLUME;

    private org.enhydra.xml.xhtml.dom.XHTMLLabelElement $element_VolumeLabel;

    private org.enhydra.xml.xhtml.dom.XHTMLOptionElement $element_VolumeOptionTemplate;

    /**
     * Class attribute constant for element class copyright
     */
    public static final String CLASS_copyright = "copyright";

    /**
     * Class attribute constant for element class elevator
     */
    public static final String CLASS_elevator = "elevator";

    /**
     * Class attribute constant for element class main
     */
    public static final String CLASS_main = "main";

    /**
     * Element name constant for HEADWORD
     */
    public static final String NAME_HEADWORD = "HEADWORD";

    /**
     * Element name constant for LIMIT
     */
    public static final String NAME_LIMIT = "LIMIT";

    /**
     * Element name constant for STATUS
     */
    public static final String NAME_STATUS = "STATUS";

    /**
     * Element name constant for VOLUME
     */
    public static final String NAME_VOLUME = "VOLUME";

    /**
     * Element name constant for author
     */
    public static final String NAME_author = "author";

    /**
     * Element name constant for description
     */
    public static final String NAME_description = "description";

    /**
     * Element name constant for generator
     */
    public static final String NAME_generator = "generator";

    /**
     * Element name constant for keywords
     */
    public static final String NAME_keywords = "keywords";

    /**
     * Element name constant for robots
     */
    public static final String NAME_robots = "robots";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = BrowseVolumePageXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmlgdef/orig/BrowseVolumePage.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public BrowseVolumePageXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public BrowseVolumePageXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public BrowseVolumePageXHTMLImpl(BrowseVolumePageXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6, $node7, $node8, $node9, $node10, $node11;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5, $elem6, $elem7, $elem8, $elem9, $elem10;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5, $attr6, $attr7, $attr8, $attr9, $attr10;
        
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
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "link");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "href");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("css/gdef-home.css");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "rel");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("StyleSheet");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/css");
        $attr3.appendChild($node4);
        
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
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Mathieu MANGEOT & Gilles S\u00e9rasset");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("author");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Grand Dictionnaire Estonien Fran\u00e7ais");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("keywords");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Le projet GDEF a pour but de cr\u00e9er un dictionnaire bilingue estonien-fran\u00e7ais");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("description");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("Enhydra");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("generator");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "meta");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "content");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("index, follow");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "name");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("robots");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("GDEF: Grand Dictionnaire Estonien Fran\u00e7ais");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "style");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/css");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode(" \n\t");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("\n\t\ttable {\n\t\ttext-align: center;\n\t\tmargin-left: auto;\n\t\tmargin-right: auto;\n\t}\n\t\n\t.interface {\n\t\ttext-align: center;\n\t}\n\t\n\t.elevator {\n\t\twidth: 180px;\n\t\theight: 500px;\n\t\toverflow: scroll;\n\t\ttext-align: left;\n\t}\n\t// ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "script");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "type");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("text/javascript");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $node4 = document.createComment("\n\n\tvar url = 'BrowseVolume.po?';\n\n\t/*** HTTP request ***/\n\n  var http_request = false;\n  \n  function makeRequests(element) {\n  \n  \tvar elev = element.ownerDocument.getElementById('elevator');\n  \twhile (elev.firstChild) {\n  \t\telev.removeChild(elev.firstChild);\n  \t}\n  \t\n  \tvar parameters = 'VOLUME=' + element.ownerDocument.getElementById('VOLUME').value;\n  \tparameters += '&HEADWORD=' + element.ownerDocument.getElementById('HEADWORD').value\n  \tparameters += '&STATUS=' + element.ownerDocument.getElementById('STATUS').value\n  \tif (element.ownerDocument.getElementById('LIMIT')) {\n  \t\tparameters += '&LIMIT=' + element.ownerDocument.getElementById('LIMIT').value\n  \t}\n  \tmakeRequest(\"updown\",parameters);\n  }\n  \n  function increaseTable(direction, table) {\n\tvar node = table;\n  \tif (direction==\"up\") {\n\t\tnode = node.firstChild;\n  \t\twhile (node.nodeName !='A') {\n  \t\t\tnode = node.nextSibling;\n  \t\t}\n  \t}\n  \telse {\n\t\tnode = node.lastChild;\n  \t\twhile (node.nodeName !='A') {\n  \t\t\tnode = node.previousSibling;\n  \t\t}\n  \t}\n  \tvar headword = node.firstChild.nodeValue;\n\n  \tvar parameters = \"VOLUME=\" + table.ownerDocument.getElementById('VOLUME').value;\n  \tparameters += \"&HEADWORD=\" + headword;\n  \tparameters += '&STATUS=' + table.ownerDocument.getElementById('STATUS').value;\n  \tif (table.ownerDocument.getElementById('LIMIT')) {\n  \t\tparameters += '&LIMIT=' + table.ownerDocument.getElementById('LIMIT').value\n  \t}\n  \tmakeRequest(direction,parameters);\n  }\n\n  function makeRequest(direction,parameters) {\n  \n  \tparameters+= \"&DIRECTION=\" + direction;\n  \n  \n\t\t\n  \ttry {\n   \t\tnetscape.security.PrivilegeManager.enablePrivilege(\"UniversalBrowserRead\");\n   \t} catch (e) {\n    \t/*alert(\"Permission UniversalBrowserRead denied.\"); */\n   \t}\n\n    http_request = false;\n    \n    /*@cc_on\n         @if (@_jscript_version >= 5)\n          try {\n              http_request = new ActiveXObject(\"Msxml2.XMLHTTP\");\n              } catch (e) {\n              try {\n                  http_request = new ActiveXObject(\"Microsoft.XMLHTTP\");\n                  } catch (E) {\n                  http_request = false;\n                  }\n              } \n         @else\n          http_request = false;\n         @end @*/\n\n    \n    http_request = new XMLHttpRequest();\n    if (http_request.overrideMimeType) {\n      http_request.overrideMimeType('text/xml');\n    }\n    http_request.setRequestHeader(\"Content-Type\", \"text/xml;charset=utf-8\")\n    if (!http_request) {\n      alert('Cannot create XMLHTTP instance');\n      return false;\n    }\n   // it seems to be impossible to pass parameters to the function called by onreadystatechange\n    if (direction== 'up') {\n     http_request.onreadystatechange = getUpContent;\n    }\n    else {\n     http_request.onreadystatechange = getDownContent;\n    }\n    http_request.open('GET', url + parameters, true);\n    http_request.send(null);\n  }\n\n  function getUpContent() {\n    if (http_request.readyState == 4) {\n      if (http_request.status == 200) {\n\n        var string = http_request.responseText;\n      \taddElements(document.getElementById('elevator'),string,'up');\n\n      } else {\n        alert('There was a problem with the request.');\n      }\n    }\n   }\n    \n  function getDownContent() {\n    if (http_request.readyState == 4) {\n      if (http_request.status == 200) {\n\n        var string = http_request.responseText;\n      \taddElements(document.getElementById('elevator'),string,'down');\n\n      } else {\n        alert('There was a problem with the request.');\n      }\n    }\n  }\n  \n  \t/*** Array ***/\n  \t\n\t\tfunction addArrayUp(element, array) {\n\t\t\n\t\t\tvar theDocument = element.ownerDocument;\n\t\t\tfor (var i=0; i<array.length; i++) {\n\t\t\t\tvar couple = array[i];\n\t\t\t\t\n\t\t\t\tvar coupleArray = couple.split('#,#');\n\t\t\t\n\t\t\t\tvar br = theDocument.createElement('br');\n\t\t\t\tvar a = theDocument.createElement('a');\n\t\t\t\t\n\t\t\t\tvar page = 'ConsultExpert.po?LOOKUP=LOOKUP&VOLUME=' + theDocument.getElementById('VOLUME').value + '&handle=' + coupleArray[1];\n\t\t\t\t\n\t\t\t\ta.setAttribute('href',page);\n\t\t\t\ta.setAttribute('target','_blank');\n\t\t\t\tvar text = theDocument.createTextNode(coupleArray[0]);\n\t\t\t\ta.appendChild(text);\n\t\t\t\telement.insertBefore(br,element.firstChild);\n\t\t\t\telement.insertBefore(a,element.firstChild);\n\t\t\t}\n\t\t}\n\t\t\n\t\tfunction addArrayDown(element, array) {\n\t\t\n\t\t\tvar theDocument = element.ownerDocument;\n\t\t\tfor (var i=0; i< array.length; i++) {\n\t\t\t\tvar couple = array[i];\n\t\t\t\t\n\t\t\t\tvar coupleArray = couple.split('#,#');\n\t\t\t\n\t\t\t\tvar br = theDocument.createElement('br');\n\t\t\t\tvar a = theDocument.createElement('a');\n\t\t\t\t\n\t\t\t\tvar page = 'ConsultExpert.po?LOOKUP=LOOKUP&VOLUME=' + theDocument.getElementById('VOLUME').value+ '&handle=' + coupleArray[1];\n\t\t\t\t\n\t\t\t\ta.setAttribute('href',page);\n\t\t\t\ta.setAttribute('target','_blank');\n\t\t\t\tvar text = theDocument.createTextNode(coupleArray[0]);\n\t\t\t\ta.appendChild(text);\n\t\t\t\telement.appendChild(a);\n\t\t\t\telement.appendChild(br);\n\t\t\t}\n\t\t}\n\t\t\n\t\tfunction addElements(parent, elementsString, direction) {\n\t\t\t\t\t\n\t\t\tvar rootbegin = \"<entries>\";\n\t\t\tvar rootend = \"<\\/entries>\";\n\t\t\t\n\t\t\tvar first = elementsString.indexOf(rootbegin);\n\t\t\tvar end = elementsString.indexOf(rootend);\n\t\t\t\n\t\t\tvar first = first + rootbegin.length;\n\t\t\telementsString = elementsString.substring(first, end-1);\n\t\t\t\n\t\t\tvar theArray = new Array();\n\t\t\ttheArray = elementsString.split('#;#');\n\t\t\t\n\t\t\tif (direction=='up' || direction == 'updown') {\n\t\t\t\taddArrayUp(parent,theArray);\n\t\t\t}\n\t\t\telse {\n\t\t\t\taddArrayDown(parent,theArray);\n\t\t\t}\n\t\t\t\n\t\t\t//var newNode = theDocument.importNode(element, true);\n\t\t\t//alert(newNode.nodeName);\n\n\t\t\t//for (var i=0; i< elements.length; i++) {\n\t\t\t\t//alert(elements[i]);\n\t\t\t\t//var newNode = theDocument.importNode(elements[i]);\n\t\t\t\t//alert(newNode);\n\t\t\t\t//parent.appendChild(newNode);\n\t\t\t//}\n\t\t}\n\n\t\t// ");
        $elem3.appendChild($node4);
        
        $node4 = document.createTextNode("\n\t");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("main");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\n    ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "table");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "summary");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Dictionary sorted in alphabetical order");
        $attr4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "thead");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("LIMIT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("LIMIT");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("30");
        $attr8.appendChild($node9);
        
        $element_LIMIT = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STATUS");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("STATUS");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("hidden");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_STATUS = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "label");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "for");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VOLUME");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("VolumeLabel");
        $attr8.appendChild($node9);
        
        $element_VolumeLabel = (org.enhydra.xml.xhtml.dom.XHTMLLabelElement)$elem8;$node9 = document.createTextNode("Volume:\n    \t\t");
        $elem8.appendChild($node9);
        
        $elem9 = document.createElementNS("http://www.w3.org/1999/xhtml", "select");
        $elem8.appendChild($elem9);
        
        $attr9 = document.createAttributeNS("", "id");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VOLUME");
        $attr9.appendChild($node10);
        
        $attr9 = document.createAttributeNS("", "name");
        $elem9.setAttributeNode($attr9);
        $node10 = document.createTextNode("VOLUME");
        $attr9.appendChild($node10);
        
        $element_VOLUME = (org.enhydra.xml.xhtml.dom.XHTMLSelectElement)$elem9;$elem10 = document.createElementNS("http://www.w3.org/1999/xhtml", "option");
        $elem9.appendChild($elem10);
        
        $attr10 = document.createAttributeNS("", "id");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("VolumeOptionTemplate");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "label");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("tmpl");
        $attr10.appendChild($node11);
        
        $attr10 = document.createAttributeNS("", "value");
        $elem10.setAttributeNode($attr10);
        $node11 = document.createTextNode("tmpl");
        $attr10.appendChild($node11);
        
        $element_VolumeOptionTemplate = (org.enhydra.xml.xhtml.dom.XHTMLOptionElement)$elem10;$node11 = document.createTextNode("tmpl");
        $elem10.appendChild($node11);
        
        $node9 = document.createTextNode("\n\t\t\t");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n\t\t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
        $node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("HEADWORD");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "name");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("HEADWORD");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("text");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("");
        $attr8.appendChild($node9);
        
        $element_HEADWORD = (org.enhydra.xml.xhtml.dom.XHTMLInputElement)$elem8;$node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "onclick");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("makeRequests(this)");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("button");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("OK");
        $attr8.appendChild($node9);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem7.appendChild($elem8);
        
        $node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "onclick");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("increaseTable('up',document.getElementById('elevator'))");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("button");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("-");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tfoot");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "th");
        $elem6.appendChild($elem7);
        
        $node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "input");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "onclick");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("increaseTable('down',document.getElementById('elevator'))");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "type");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("button");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "value");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("+");
        $attr8.appendChild($node9);
        
        $node8 = document.createTextNode("\n    \t\t");
        $elem7.appendChild($node8);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "tbody");
        $elem4.appendChild($elem5);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "tr");
        $elem5.appendChild($elem6);
        
        $elem7 = document.createElementNS("http://www.w3.org/1999/xhtml", "td");
        $elem6.appendChild($elem7);
        
        $elem8 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem7.appendChild($elem8);
        
        $attr8 = document.createAttributeNS("", "class");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("elevator");
        $attr8.appendChild($node9);
        
        $attr8 = document.createAttributeNS("", "id");
        $elem8.setAttributeNode($attr8);
        $node9 = document.createTextNode("elevator");
        $attr8.appendChild($node9);
        
        $element_Elevator = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem8;$node9 = document.createTextNode("\n  \t\t");
        $elem8.appendChild($node9);
        
        $node8 = document.createTextNode("\n \t\t\t");
        $elem7.appendChild($node8);
        
        $node4 = document.createTextNode("\n ");
        $elem3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "class");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("copyright");
        $attr3.appendChild($node4);
        
        $node4 = document.createTextNode("\u00a9 2001-2005 ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("mailto:Mathieu.MangeotATimag.fr?subject=GDEFServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Mathieu Mangeot");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(" & ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "href");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("mailto:gilles.serassetATimag.fr?subject=PapillonServer&body=replace\u00a0AT\u00a0by\u00a0@\u00a0in\u00a0the\u00a0email\u00a0address");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Gilles S\u00e9rasset");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode(", GETA-CLIPS. All rights reserved.");
        $elem3.appendChild($node4);
        
        return document;
    }

    /**
     * Clone the document.
     */
    public Node cloneNode(boolean deep) {
        cloneDeepCheck(deep);
        return new BrowseVolumePageXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>elevator</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementElevator() {
        return $element_Elevator;
    }

    /**
     * Get the element with id <CODE>HEADWORD</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementHEADWORD() {
        return $element_HEADWORD;
    }

    /**
     * Get the element with id <CODE>LIMIT</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementLIMIT() {
        return $element_LIMIT;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLInputElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLInputElement getElementSTATUS() {
        return $element_STATUS;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSelectElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSelectElement getElementVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeLabel</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLLabelElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLLabelElement getElementVolumeLabel() {
        return $element_VolumeLabel;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLOptionElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLOptionElement getElementVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the element with id <CODE>elevator</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagElevator() {
        return $element_Elevator;
    }

    /**
     * Get the element with id <CODE>HEADWORD</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagHEADWORD() {
        return $element_HEADWORD;
    }

    /**
     * Get the element with id <CODE>LIMIT</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagLIMIT() {
        return $element_LIMIT;
    }

    /**
     * Get the element with id <CODE>STATUS</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagSTATUS() {
        return $element_STATUS;
    }

    /**
     * Get the element with id <CODE>VOLUME</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVOLUME() {
        return $element_VOLUME;
    }

    /**
     * Get the element with id <CODE>VolumeLabel</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeLabel() {
        return $element_VolumeLabel;
    }

    /**
     * Get the element with id <CODE>VolumeOptionTemplate</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagVolumeOptionTemplate() {
        return $element_VolumeOptionTemplate;
    }

    /**
     * Get the value of text child of element <CODE>elevator</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextElevator(String text) {
        doSetText($element_Elevator, text);
    }

    /**
     * Get the value of text child of element <CODE>VolumeLabel</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextVolumeLabel(String text) {
        doSetText($element_VolumeLabel, text);
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
