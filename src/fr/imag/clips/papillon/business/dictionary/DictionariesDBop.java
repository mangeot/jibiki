/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.2  2003/09/03 10:08:29  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.1.1.1  2002/10/28 16:49:12  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.4  2002/04/16 10:17:23  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/04/16 02:44:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/04/01 07:46:32  mangeot
 * Added a table for volumes metadata descriptions
 *
 * Revision 1.1  2002/03/11 11:15:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.2  2001/07/12 17:58:00  salvati
 * end of debug
 * CV: ----------------------------------------------------------------------
 *
 * Revision 1.1  2001/07/12 17:18:11  salvati
 * Converting from XslDbop
 *
 *
 *-----------------------------------------------
 * 
 */
 
package fr.imag.clips.papillon.business.dictionary;
import fr.imag.clips.papillon.business.PapillonLogger;

/**
for inserting, deleting Dictionaries

*/

public class DictionariesDBop{
	
	
	
	public static Dictionary addDictionary(String name,
                                                String fullname,
                                                String category,
                                                String type,
                                                String domain,
                                                String legal,
                                                String sources,
                                                String targets,
                                                String xmlCode)
		throws fr.imag.clips.papillon.business.PapillonBusinessException
	{
        Dictionary myDictionary = null;
	if ((name!=null) && (fullname!=null) && (category!=null) && (type!=null) && (sources!=null) && (xmlCode!=null)) 
		{
		//search for an existing dictionary
		Dictionary Existe=DictionariesFactory.findDictionaryByName(name);
		if (Existe.IsEmpty()) {//does'nt exist, create :
                    myDictionary=new Dictionary();
                    myDictionary.setName(name);
                    myDictionary.setFullName(fullname);
                    myDictionary.setCategory(category);
                    myDictionary.setType(type);
                    myDictionary.setDomain(domain);
                    myDictionary.setLegal(legal);
                    myDictionary.setSourceLanguages(sources);
                    myDictionary.setTargetLanguages(targets);
                    myDictionary.setXmlCode(xmlCode);
                    myDictionary.save();						
			}
                else {
                    PapillonLogger.writeDebugMsg("Dico deja existant dans la base");
			}
		}	
            return myDictionary;
	}
	
	
        /* GS: This should be done directly with a truncate SQL statement ! */
	public static void EmptyDatabase()
		throws fr.imag.clips.papillon.business.PapillonBusinessException
	{
	Dictionary[]	TheDictionaries= DictionariesFactory.getDictionariesArray();
	for ( int i = 0; i < TheDictionaries.length; i++ )
	{
		TheDictionaries[i].delete();
	}
	}
}
