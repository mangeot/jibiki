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
 * Revision 1.3  2003/09/03 10:08:29  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.2  2003/08/14 08:30:11  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.1.1.1.2.2  2003/07/01 07:14:54  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.1  2003/06/21 17:56:37  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.3  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/04/14 09:48:30  mangeot
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

public class VolumesDBop{
	
	
	
	public static Volume addVolume(String name,
                                                String dictname,
                                                String dbname,
                                               String source,
                                               String targets,
                                               String href,
                                                String xmlCode)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Volume myVolume = null;
	if ((name!=null) && (dictname!=null) && (dbname!=null)
            && (source!=null) && (href!=null) && (xmlCode!=null)) 
		{
		//search for an existing dictionary
		Volume Existe=VolumesFactory.findVolumeByName(name);
		if (Existe.IsEmpty())
			{//does'nt exist, create :
					myVolume=new Volume();
                                        myVolume.setName(name);
                                        myVolume.setDictname(dictname);
                                        myVolume.setDbname(dbname);
                                        myVolume.setSourceLanguage(source);
                                        myVolume.setTargetLanguages(targets);
                                        myVolume.setVolumeRef(href);
                                        myVolume.setXmlCode(xmlCode);
					myVolume.save();								
			}else
			{PapillonLogger.writeDebugMsg("Volume deja existant dans la base");
			}
		}
                return myVolume;	
	}
	
	
        /* GS: This should be done directly with a truncate SQL statement ! */
	public static void EmptyDatabase()
		throws fr.imag.clips.papillon.business.PapillonBusinessException
	{
	Volume[]	TheVolumes= VolumesFactory.getVolumesArray();
	for ( int i = 0; i < TheVolumes.length; i++ )
	{
		VolumesFactory.deleteCountEntries(TheVolumes[i].getName());
		TheVolumes[i].delete();
	}
	}
}
