/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmllexalp.fra;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmllexalp/fra/HomeContent.xhtml
 */
public class HomeContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements HomeContentXHTML, fr.imag.clips.papillon.presentation.xhtmllexalp.orig.HomeContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_HomeContent;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ProjectDescription;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryFuzzyResultForm;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResult;

    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_QueryResultForm;

    /**
     * Class attribute constant for element class title
     */
    public static final String CLASS_title = "title";

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = HomeContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtmllexalp/fra/HomeContent.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public HomeContentXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public HomeContentXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public HomeContentXHTMLImpl(HomeContentXHTMLImpl src) {
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
        $node4 = document.createTextNode("text/html; charset=utf-8");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "http-equiv");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("content-type");
        $attr3.appendChild($node4);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "title");
        $elem2.appendChild($elem3);
        
        $node4 = document.createTextNode("LexALP");
        $elem3.appendChild($node4);
        
        $elem2 = document.createElementNS("http://www.w3.org/1999/xhtml", "body");
        $elem1.appendChild($elem2);
        
        $elem3 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem2.appendChild($elem3);
        
        $attr3 = document.createAttributeNS("", "id");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("HomeContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_HomeContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n      ");
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
        
        $node6 = document.createTextNode("Bienvenue dans la banque de termes LexALP");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Cette banque de termes contient la terminologie sp\u00e9cialis\u00e9e des domaines de ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("l'am\u00e9nagement \n        du territoire");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" et du ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("d\u00e9veloppement durable");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(".");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Cette terminologie est disponible en ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("allemand, fran\u00e7ais, italien et slov\u00e8ne");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" \n        (mais pas en anglais, m\u00eame si une interface en anglais est disponible).");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Nous avons choisi peu de concepts, mais nous essayons de les d\u00e9crire de mani\u00e8re exhaustive pour \n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("tous les syst\u00e8mes l\u00e9gaux de l'arc alpin");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(", aussi vous trouverez habituellement de nombreuses\n        informations sur une page si vous n'affinez pas votre recherche.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Vous remarquerez les ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("drapeaux");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" sur la droite de chaque terme (ex: \n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "alt");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("ac-logo");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "src");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("media/lexalp/AC.gif");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "width");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("20");
        $attr6.appendChild($node7);
        
        $node6 = document.createTextNode(" pour la Convention Alpine): ils indiquent\n        \u00e0 quel syst\u00e8me l\u00e9gal appartient le terme affich\u00e9. Parfois, un m\u00eame terme est utilis\u00e9 dans les textes\n        de la Convention Alpine, de l'Union europ\u00e9enne, dans les textes internationaux ou nationaux. Dans ce cas, \n        un m\u00eame terme peut appara\u00eetre jusqu'\u00e0 trois ou quatre fois, avec pour seule variation leurs drapeaux et\n        des descriptions peu diff\u00e9rentes. Nous vous rappelons que, m\u00eame si elle fait partie des textes internationaux, \n        nous avons choisis de d\u00e9crire le syst\u00e8me l\u00e9gal de la Convention Alpine de mani\u00e8re s\u00e9par\u00e9e afin de \n        satisfaire aux objectifs du projet.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Les termes portant le label ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("\"harmonis\u00e9\"");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" viennent toujours par quatre. Ce sont les quatre termes, un par langue, \n        qui sont \u00e9quivalents au sein de la Convention Alpine. Le but principal du projet est d'identifier les plus utiles\n        de ces quartets d'\u00e9quivalents.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("La banque de termes LexALP sert \u00e0 la fois \u00e0 ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("l'\u00e9laboration");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" et \u00e0 ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("la diffusion");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode("\n         des termes. Cela vous offre un acc\u00e8s en temps r\u00e9el \u00e0 la terminologie de la Convention Alpine, mais n 'oubliez \n         pas\u00a0: c'est un travail en cours\u00a0!");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Si vous ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("ne trouvez pas");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" une expression particuli\u00e8re, essayez de la chercher dans le \n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://217.199.4.152:8080/htdocs2/lexalp/corp_lexalp/search_corp.php");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "title");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("corpus LexALP");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n\t\tcorpus");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" o\u00f9 vous pourrez \n        vraisemblablement trouver une traduction dans un texte parall\u00e8le.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Vous remarquerez que chaque terme est class\u00e9 par ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "strong");
        $elem5.appendChild($elem6);
        
        $node7 = document.createTextNode("domaines");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(". L'ensemble de la terminologie est \n        class\u00e9e selon une structure sp\u00e9cifique inspir\u00e9e par l'article 9 du Protocole\n        ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("http://www.convenzionedellealpi.org/archive/protocols/Protokoll_f_Raumplanung.pdf");
        $attr6.appendChild($node7);
        
        $attr6 = document.createAttributeNS("", "onclick");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("window.open(this.href,'_blank');return false;");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("\n            \"Am\u00e9nagement du territoire et d\u00e9veloppement durable\"");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(" de la Convention Alpine.\n        Dans l'interface de recherche avanc\u00e9e, vous pouvez sp\u00e9cifier le domaine (ainsi que de nombreux autres\n            crit\u00e8res, comme la langue, le syst\u00e8me \n        l\u00e9gal, etc.) pour restreindre votre recherche.");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Pour de plus amples informations, consultez notre ");
        $elem5.appendChild($node6);
        
        $elem6 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem5.appendChild($elem6);
        
        $attr6 = document.createAttributeNS("", "href");
        $elem6.setAttributeNode($attr6);
        $node7 = document.createTextNode("");
        $attr6.appendChild($node7);
        
        $node7 = document.createTextNode("guide technique de l'utilisateur");
        $elem6.appendChild($node7);
        
        $node6 = document.createTextNode(".");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n       ");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("        \n       ");
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
        
        $node6 = document.createTextNode("R\u00e9sultat de la recherche");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n        ");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n      ");
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
        
        $node6 = document.createTextNode("R\u00e9sultat de la recherche floue");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode("\n        ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "div");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "id");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("QueryFuzzyResultForm");
        $attr5.appendChild($node6);
        
        $element_QueryFuzzyResultForm = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem5;$node6 = document.createTextNode("\n        ");
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
        return new HomeContentXHTMLImpl(this);
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
