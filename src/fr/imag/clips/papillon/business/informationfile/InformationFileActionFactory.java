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
 * Revision 1.4  2002/05/22 08:56:18  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.3  2001/10/30 15:23:01  serasset
 * Images and other format are now supported as media files (i.e. files that are locally saved in a special directory).
 *
 * Revision 1.2  2001/10/29 13:32:18  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
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
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.Enhydra;
import com.lutris.util.KeywordValueException;
import com.lutris.util.KeywordValueTable;


public class InformationFileActionFactory {

    public static String CONTENT_TYPE_ACTION_CONFIG_GROUP = "Papillon.Informations.contentTypeHandler";
    public static String FILE_EXTENSION_ACTION_CONFIG_GROUP = "Papillon.Informations.fileExtensionHandler";
    //    public static String NO_ACTION_CLASS = "fr.imag.clips.papillon.business.informationfile.DoNothing";
    // Here I cheat because I am tired of adding new importMediaFile for each file extension ...
    public static String NO_ACTION_CLASS = "fr.imag.clips.papillon.business.informationfile.ImportMediaFile";

    public static InformationFileAction getAction(de.opus5.servlet.UploadedFile file) throws 
                                PapillonBusinessException {
        String fileName = file.getName();
        String contentType = file.getContentType();
        return getAction(fileName, contentType);
    }
    
    public static InformationFileAction getAction(java.io.File file) throws 
                                PapillonBusinessException {
        
        String fileName = file.getName();
        return getAction(fileName, null);
     }
    
    public static InformationFileAction getAction(String name, String contentType) throws PapillonBusinessException {
            // According to the file type and/or name, determine the actions to perform

        String handler = null;
        PapillonLogger.writeDebugMsg("MIME type:" + contentType);
        PapillonLogger.writeDebugMsg("file name:" + name);

        if (null != contentType) {
            try {
                int i = contentType.indexOf("/");
                String category = contentType.substring(0, i).replace('-', '_');
                String type = contentType.substring(i+1).replace('-', '_');
                try {
                    KeywordValueTable handlers = 
                        Enhydra.getApplication().getConfig().getSection(CONTENT_TYPE_ACTION_CONFIG_GROUP);
                    try {
                        handler = handlers.getString(category + "." + type);
                    } catch (KeywordValueException kve) {
                        PapillonLogger.writeDebugMsg("Unknown MIME type: " + category + "/" + type 
                            + " I will try to use filename..." );
                    }
                } catch (KeywordValueException kve) {
                    PapillonLogger.writeDebugMsg("Unexpected Error: Incorrect configuration file for group: "
                        + CONTENT_TYPE_ACTION_CONFIG_GROUP);
                }
            } catch (IndexOutOfBoundsException e) {
                PapillonLogger.writeDebugMsg("Unexpected Error: malformed content type: " + contentType);
            }
        }
        
        // If the handler is not found yet, try to find it from the filename extensions.
        if (null == handler) {
            if (null != name) {
                try {
                    int i = name.lastIndexOf(".");
                    String ext = name.substring(i+1).toLowerCase();
                    PapillonLogger.writeDebugMsg("File extension:" + ext);
                    try {
                        KeywordValueTable handlers = 
                            Enhydra.getApplication().getConfig().getSection(FILE_EXTENSION_ACTION_CONFIG_GROUP);
                        try {
                            handler = handlers.getString(ext);
                        } catch (KeywordValueException kve) {
                            PapillonLogger.writeDebugMsg("Unknown file extension : \"" + ext + 
                                "\" The file will be ignored");
                        }
                    } catch (KeywordValueException kve) {
                        PapillonLogger.writeDebugMsg("Unexpected Error: Incorrect configuration file for group: "
                            + FILE_EXTENSION_ACTION_CONFIG_GROUP);
                    }
                } catch (IndexOutOfBoundsException e) {
                    PapillonLogger.writeDebugMsg("Unexpected Error: Can't determine file extension for file: " + name);
                }
            }
        }
        
        // If the handler is still not found, use the DoNothing Action.
        if (null == handler) {
            handler = NO_ACTION_CLASS;
        }
        
        // Now, get an instance of the handling class.
        InformationFileAction handlerObject = null;
        
        try {
            handlerObject = (InformationFileAction)Class.forName(handler).newInstance();
        } catch (Exception e) {
            throw new PapillonBusinessException("Information File handler not found", e);
        }
        
        return handlerObject;

    }
}
