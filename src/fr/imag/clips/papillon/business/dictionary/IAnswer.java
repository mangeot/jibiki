/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.1.1.1.2.3  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.1.1.1.2.2  2005/01/27 19:29:21  mangeot
 * Implemented the HtmlDom cache, it increases speed drastically.
 * Still does not compile after an ant clean
 *
 * Revision 1.1.1.1.2.1  2005/01/25 13:54:54  mangeot
 * changed the volume volumeEntry and index objects. Does not compile but need a backup...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.7  2004/10/28 10:38:11  mangeot
 * Fixed some bugs that affected the dictd server
 * Modified some methods in order to display a text entry in the dictd server
 *
 * Revision 1.6  2004/02/10 05:27:12  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.business.dictionary;

/**
 * Insert the type's description here.
 * Creation date: (10.08.01 20:55:06)
 * @author: Administrator
 */
public interface IAnswer {
/**
 * Insert the method's description here.
 * Creation date: (10.08.01 20:55:40)
 * @return org.dict.IDatabase
 */
    public static final int Error = -1;
    public static final int Default = 1;
    public static final int LocalEntry = 1;
    public static final int RemoteEntry = 2;
    public static final int Contribution = 3;
    public static final int LocalAxie = 4;

    int getType();

    boolean IsEmpty();
    
    Dictionary getDictionary() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getDictionaryName() throws fr.imag.clips.papillon.business.PapillonBusinessException;
    
    String getDictionaryFullName() throws fr.imag.clips.papillon.business.PapillonBusinessException;
    
    String getVolumeName() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    Volume getVolume() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getSourceLanguage() throws fr.imag.clips.papillon.business.PapillonBusinessException;
		    
    String getXmlCode() throws fr.imag.clips.papillon.business.PapillonBusinessException;
    
    void setXmlCode(String code) throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getId() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    void setId() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getHeadword() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getHandle() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    org.w3c.dom.Document getDom() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    void setDom(org.w3c.dom.Document myDoc) throws fr.imag.clips.papillon.business.PapillonBusinessException;

    org.w3c.dom.Document getHtmlDom() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    void setHtmlDom(org.w3c.dom.Document myDoc) throws fr.imag.clips.papillon.business.PapillonBusinessException;
		
    void delete() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    boolean save() throws fr.imag.clips.papillon.business.PapillonBusinessException;

}
