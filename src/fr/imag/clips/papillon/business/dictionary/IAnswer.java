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
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
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

    String createNewId() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String createNewId(String headword) throws fr.imag.clips.papillon.business.PapillonBusinessException;

    void setId(String newId) throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getHeadword() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getHeadwords() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    String getHandle() throws fr.imag.clips.papillon.business.PapillonBusinessException;
		
    void delete() throws fr.imag.clips.papillon.business.PapillonBusinessException;

    void save() throws fr.imag.clips.papillon.business.PapillonBusinessException;

}
