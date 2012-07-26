/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtmldri.orig;


/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtmldri/orig/LinkerLayout.xhtml
 */
public interface LinkerLayoutXHTML extends fr.imag.clips.papillon.presentation.xhtml.orig.LinkerLayoutXHTML, fr.imag.clips.papillon.presentation.xhtmllexalp.orig.LinkerLayoutXHTML, org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
    /**
     * Class attribute constant for element class simpleBrowser
     */
    public static final String CLASS_simpleBrowser = "simpleBrowser";

    /**
     * Class attribute constant for element class simpleResultList
     */
    public static final String CLASS_simpleResultList = "simpleResultList";

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
     * Get the element with id <CODE>BrowsingForm</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementBrowsingForm();

    /**
     * Get the element with id <CODE>ResultList</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementResultList();

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLScriptElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLScriptElement getElementScript();

    /**
     * Get the element with id <CODE>BrowsingForm</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagBrowsingForm();

    /**
     * Get the element with id <CODE>ResultList</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagResultList();

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScript();

    /**
     * Get the value of text child of element <CODE>BrowsingForm</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextBrowsingForm(String text);

    /**
     * Get the value of text child of element <CODE>ResultList</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextResultList(String text);

    /**
     * Get the value of text child of element <CODE>Script</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextScript(String text);

}
