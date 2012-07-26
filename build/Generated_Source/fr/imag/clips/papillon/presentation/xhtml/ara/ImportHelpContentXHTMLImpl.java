/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.ara;

import org.w3c.dom.*;

/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/ara/ImportHelpContent.xhtml
 */
public class ImportHelpContentXHTMLImpl extends org.enhydra.xml.xmlc.html.HTMLObjectImpl implements ImportHelpContentXHTML, fr.imag.clips.papillon.presentation.xhtml.orig.ImportHelpContentXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    private org.enhydra.xml.xhtml.dom.XHTMLDivElement $element_ImportHelpContent;

    /**
     * Field that is used to identify this as the XMLC generated class
     * in an inheritance chain. Contains a reference to the class object.
     */
    public static final Class XMLC_GENERATED_CLASS = ImportHelpContentXHTMLImpl.class;

    /**
     * Field containing CLASSPATH relative name of the source file
     * that this class can be regenerated from.
     */
    public static final String XMLC_SOURCE_FILE = "fr/imag/clips/papillon/presentation/xhtml/ara/ImportHelpContent.xhtml";

    /**
     * XMLC DOM factory associated with this class.
     */
    private static final org.enhydra.xml.xmlc.dom.XMLCDomFactory fDOMFactory = org.enhydra.xml.xmlc.dom.XMLCDomFactoryCache.getFactory(org.enhydra.xml.xhtml.XHTMLDomFactory.class);

    /**
     * Default constructor.
     */
    public ImportHelpContentXHTMLImpl() {
        buildDocument();
    }

    /**
     * Constructor with optional building of the DOM.
     */
    public ImportHelpContentXHTMLImpl(boolean buildDOM) {
        if (buildDOM) {
            buildDocument();
        }
    }

    /**
     * Copy constructor.
     */
    public ImportHelpContentXHTMLImpl(ImportHelpContentXHTMLImpl src) {
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
        Node $node0, $node1, $node2, $node3, $node4, $node5, $node6;
        Element $elem0, $elem1, $elem2, $elem3, $elem4, $elem5;
        Attr $attr0, $attr1, $attr2, $attr3, $attr4, $attr5;
        
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
        $node4 = document.createTextNode("ImportHelpContent");
        $attr3.appendChild($node4);
        
        $attr3 = document.createAttributeNS("", "lang");
        $elem3.setAttributeNode($attr3);
        $node4 = document.createTextNode("fr");
        $attr3.appendChild($node4);
        
        $element_ImportHelpContent = (org.enhydra.xml.xhtml.dom.XHTMLDivElement)$elem3;$node4 = document.createTextNode("\n\n  ");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h1");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "style");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("text-align:center");
        $attr4.appendChild($node5);
        
        $node5 = document.createTextNode("Aide pour l'ajout de documents d'information");
        $elem4.appendChild($node5);
        
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
        $node6 = document.createTextNode("AdminInformations.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Retour");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" \u00e0 la page d'aministration des documents d'information\n");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Il est possible d'ajouter sur le serveur Papillon des documents monolingues ou multilingues de n'importe quel type.\nLes fichiers de type archive (TAR ou ZIP) peuvent \u00eatre multilingues, tandis que les fichiers simples (HTML, PDF, RTF, GIF, etc.)\nsont obligatoirement monolingues.");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\nUn fichier compr\u00e9ss\u00e9 avec Gzip est d'abord d\u00e9compact\u00e9; le fichier ainsi obtenu n'est pas ajout\u00e9\n directement, mais trait\u00e9 exactement comme si il avait \u00e9t\u00e9 envoy\u00e9 sous forme non compr\u00e9ss\u00e9e.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("1. Ajout d'archives (.tar, .zip, .tar.gz)");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("1.1. Processus");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("L'archive est d\u00e9compact\u00e9e et son contenu est analys\u00e9, puis ajout\u00e9. Il peut s'agir d'un unique r\u00e9pertoire archiv\u00e9, auquel cas\n le terme \"racine\" d\u00e9signe le contenu de ce r\u00e9pertoire. Il est possible de placer \u00e0 la racine de l'archive un fichier au format XML\n nomm\u00e9 ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("info_doc.xml");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" qui remplace la saisie des informations du formulaire d'ajout de documents.\nCe fichier de decription info_doc.xml de l'archive pr\u00e9cise");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("nbsp");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00a0");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode(":");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("la section dans laquelle vous souhaitez placer le document,");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("le nom du ou des auteurs du document,");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("le titre du document dans chacune des langues disponibles,");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("la date de cr\u00e9ation du document (optionnel),");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("des r\u00e9f\u00e9frences si c'est une publication (optionnel).");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Si des informations ont \u00e9t\u00e9 entr\u00e9es dans le formulaire, elles sont ignor\u00e9es et remplac\u00e9es par celles contenues dans info_doc.xml.");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\nLe format du fichier info_doc.xml est d\u00e9fini par le Sch\u00e9ma XML ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("XMLSchema.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("info_doc.xsd");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("ATTENTION: les documents HTML ne doivent pas contenir d'entit\u00e9 caract");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("egrave");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00e8");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode("re hexadecimale comme &#x8A93; car le parseur Tidy semble ne pas les reconna");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("icirc");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00ee");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode("tre.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h3");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("1.2. Diff\u00e9rents types d'archives");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("There are three types of archives, wich are treated differently:");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("La distinction est faite entre trois types d'archives qui sont trait\u00e9es diff\u00e9remment");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("nbsp");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00a0");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode(":");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "ul");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("une archive multilingue HTML est constitu\u00e9e d'un mini-site HTML dans plusieurs langues.");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("une archive multilingue non HTML contient plusieurs versions d'un document simple non HTML (par exemple un document PDF ou RTF) dans diff\u00e9rentes langues.");
        $elem5.appendChild($node6);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "li");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("une archive monolingue dont le contenu est libre.");
        $elem5.appendChild($node6);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Pour les deux types de documents multilingues, l'archive doit comporter \u00e0 sa racine le fichier info_doc.xml puis, pour chaque langue, un r\u00e9pertoire portant\nle code ");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("agrave");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00e0");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode(" trois lettres ISO 639-2/T de cette langue. Les langues actuellement accept\u00e9es sont");
        $elem4.appendChild($node5);
        
        $node5 = document.createEntityReference("nbsp");
        $elem4.appendChild($node5);
        
        $node6 = document.createTextNode("\u00a0");
        $node5.appendChild($node6);
        
        $node5 = document.createTextNode(":");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\ndeu (allemand), eng (anglais), esp (espagnol), fra (fran\u00e7ais), hun (hongrois), ita (italien), jpn (japonais), lao (lao), msa (malais), tha (tha\u00ef),\n vie (vietnamien), etc.");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem4.appendChild($elem5);
        
        $node5 = document.createTextNode("\nAucun autre fichier, \u00e0 l'exception du fichier info_doc.xml,et aucun autre r\u00e9pertoire ne doivent \u00eatre p\u00e9sents \u00e0 la racine de l'archive,\nsinon le document est consid\u00e9r\u00e9e comme monolingue.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h4");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("1 Multilingual HTML archives");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h4");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("1 Archives multilingues HTML");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Chaque r\u00e9pertoire portant le nom d'une langue doit au moins contenir un fichier index nomm\u00e9 index.htm(l)\nou default.htm(l), qui sera le point d'entr\u00e9e dans le document pour cette langue. Si le fichier info_doc.xml est absent, vous pouvez remplir le champ ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Auteur");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" du formulaire; les titres du document dans\nles diff\u00e9rentes langues sont r\u00e9cup\u00e9r\u00e9s dans la balise <title> des fichiers index.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\nExemple");
        $elem3.appendChild($node4);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $node4 = document.createTextNode(":");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "alt");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Multilingual HTML archive");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "src");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("media/html_archive.jpg");
        $attr4.appendChild($node5);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h4");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("2 Archives multilingues non HTML");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Chaque r\u00e9pertoire portant le nom d'une langue doit contenir exactement un fichier, la version du document\n dans cette langue. La pr\u00e9sence du fichier info_doc.xml est obligatoire.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\nExemple");
        $elem3.appendChild($node4);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $node4 = document.createTextNode(":");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "alt");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Multilingual non-HTML archive");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "src");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("media/media_archive.jpg");
        $attr4.appendChild($node5);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h4");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("3 Archives monolingues");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("S'il s'agit d'un ensemble de pages HTML, un fichier index doit \u00eatre plac\u00e9 \u00e0 la racine de l'archive.\n Si le fichier info_doc.xml est absent, vous devez obligatoirement remplir le champ ");
        $elem4.appendChild($node5);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "b");
        $elem4.appendChild($elem5);
        
        $node6 = document.createTextNode("Titre");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" du \n formulaire et indiquer la langue du document.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\nExemple");
        $elem3.appendChild($node4);
        
        $node4 = document.createEntityReference("nbsp");
        $elem3.appendChild($node4);
        
        $node5 = document.createTextNode("\u00a0");
        $node4.appendChild($node5);
        
        $node4 = document.createTextNode(":");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
        $elem3.appendChild($elem4);
        
        $attr4 = document.createAttributeNS("", "alt");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("Monolingual archive");
        $attr4.appendChild($node5);
        
        $attr4 = document.createAttributeNS("", "src");
        $elem4.setAttributeNode($attr4);
        $node5 = document.createTextNode("media/mono_archive.jpg");
        $attr4.appendChild($node5);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "br");
        $elem3.appendChild($elem4);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "h2");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("2. Ajout de fichiers non archiv\u00e9s");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $node5 = document.createTextNode("Vous devez donner le titre du document et indiquer sa langue dans le formulaire.");
        $elem4.appendChild($node5);
        
        $node4 = document.createTextNode("\n");
        $elem3.appendChild($node4);
        
        $elem4 = document.createElementNS("http://www.w3.org/1999/xhtml", "p");
        $elem3.appendChild($elem4);
        
        $elem5 = document.createElementNS("http://www.w3.org/1999/xhtml", "a");
        $elem4.appendChild($elem5);
        
        $attr5 = document.createAttributeNS("", "href");
        $elem5.setAttributeNode($attr5);
        $node6 = document.createTextNode("AdminInformations.po");
        $attr5.appendChild($node6);
        
        $node6 = document.createTextNode("Retour");
        $elem5.appendChild($node6);
        
        $node5 = document.createTextNode(" \u00e0 la page d'aministration des documents d'information.");
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
        return new ImportHelpContentXHTMLImpl(this);
    }

    /**
     * Get the XMLC DOM factory associated with the class.
     */
    protected final org.enhydra.xml.xmlc.dom.XMLCDomFactory getDomFactory() {
        return fDOMFactory;
    }

    /**
     * Get the element with id <CODE>ImportHelpContent</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementImportHelpContent() {
        return $element_ImportHelpContent;
    }

    /**
     * Get the element with id <CODE>ImportHelpContent</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagImportHelpContent() {
        return $element_ImportHelpContent;
    }

    /**
     * Get the value of text child of element <CODE>ImportHelpContent</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextImportHelpContent(String text) {
        doSetText($element_ImportHelpContent, text);
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
