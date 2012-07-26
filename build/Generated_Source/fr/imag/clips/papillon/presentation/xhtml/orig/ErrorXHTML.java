/*
 ************************************
 * XMLC GENERATED CODE, DO NOT EDIT *
 ************************************
 */
package fr.imag.clips.papillon.presentation.xhtml.orig;


/**
 * XMLC Document class, generated from
 * /Users/yingzhang/Projet/LINKS_1_0/src/fr/imag/clips/papillon/resources/xhtml/orig/Error.xhtml
 */
public interface ErrorXHTML extends org.enhydra.xml.xmlc.XMLObject, org.enhydra.xml.xmlc.html.HTMLObject {
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
     * Get the element with id <CODE>Content</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLDivElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLDivElement getElementContent();

    /**
     * Get the element with id <CODE>ErrorMessage</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementErrorMessage();

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLScriptElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLScriptElement getElementScript();

    /**
     * Get the element with id <CODE>StackTrace</CODE>.
     * @see org.enhydra.xml.xhtml.dom.XHTMLSpanElement
     */
    public org.enhydra.xml.xhtml.dom.XHTMLSpanElement getElementStackTrace();

    /**
     * Get the element with id <CODE>Content</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagContent();

    /**
     * Get the element with id <CODE>ErrorMessage</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagErrorMessage();

    /**
     * Get the element with id <CODE>Script</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagScript();

    /**
     * Get the element with id <CODE>StackTrace</CODE>.
     * @see org.w3c.dom.Element
     */
    public org.w3c.dom.Element getTagStackTrace();

    /**
     * Get the value of text child of element <CODE>Content</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextContent(String text);

    /**
     * Get the value of text child of element <CODE>ErrorMessage</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextErrorMessage(String text);

    /**
     * Get the value of text child of element <CODE>Script</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextScript(String text);

    /**
     * Get the value of text child of element <CODE>StackTrace</CODE>.
     * @see org.w3c.dom.Text
     */
    public void setTextStackTrace(String text);

}
