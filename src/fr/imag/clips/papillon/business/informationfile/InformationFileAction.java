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
 * Revision 1.3  2003/09/03 10:15:45  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.2  2003/08/14 08:30:12  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:17  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.6  2002/08/01 12:40:00  tache
 * Cleaned up a lot of code in import classes. Moved HTML parsing methods from
 * ImportHTMLFile to new class HTMLParser to reuse them in ImportArchive.
 * Moved XMLTitleParser to fr.imag.clips.papillon.presentation.
 *
 * Revision 1.5  2002/07/26 16:51:11  tache
 * The document repository now manages multilingual documents.
 *
 * Revision 1.4  2001/10/30 15:23:01  serasset
 * Images and other format are now supported as media files (i.e. files that are locally saved in a special directory).
 *
 * Revision 1.3  2001/10/29 13:32:18  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 * Revision 1.2  2001/10/17 12:59:56  serasset
 * L'ajout de document d'information se fait via une action specifique par type de fichier.
 * Distinction entre Document (abstrait) et Fichier (qui composent concretement un document).
 *
 * Revision 1.1  2001/09/07 06:53:45  serasset
 * File addition is now done with a set of Handler classes that are invoked depending on
 * the application configuration file.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonImportException;

public abstract class InformationFileAction {

    public static String handlerName = null;

    /**
     * perform the file addition.
     */
    public abstract void addFile( de.opus5.servlet.UploadedFile file,
                                  InformationDocument doc,
                                  RelativeURLMapper env,
				  String lang)
                
            throws PapillonBusinessException, PapillonImportException,
		   javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException;
            
    public abstract void addFile( java.io.File file,
                                  InformationDocument doc,
                                  RelativeURLMapper env,
				  String lang)
                
            throws PapillonBusinessException, PapillonImportException,
		   javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException;
            
    /**
     * Return the url where the given file will be found after an import...
     */
    public abstract String getNameOnServer(String filename, String oid); 
    

    /**
     * Return the name of the handler
     */
    public String getHandlerName() {
	return handlerName;
    }

}
