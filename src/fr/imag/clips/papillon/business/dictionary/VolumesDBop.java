/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
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
