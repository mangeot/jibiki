/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 *
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:38  serasset
 * Initial revision
 *
 * Revision 1.4  2004/10/30 10:16:11  mangeot
 * Fixed a bug when creating a new user, need to create the xmlCode anyway
 *
 * Revision 1.3  2004/10/30 08:52:06  mangeot
 * Replace old XSL and reset cache !
 *
 * Revision 1.2  2003/08/14 08:30:14  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/21 10:15:09  mangeot
 * Travail sur l'interface d'edition
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.4  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.3  2001/07/24 13:15:32  salvati
 * Adding the defaultxsl field in the database, adding the choice of
 * the default stylesheet when adding stylesheets.
 *
 * Revision 1.2  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.1  2001/07/12 16:57:50  salvati
 * Procedure to add xslsheet, empty database:used by AdminXsl.java
 *
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.xsl;
import fr.imag.clips.papillon.business.xsl.*;
import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;
import fr.imag.clips.papillon.business.PapillonLogger;

/**
for inserting, deleting XslSheet

 */

public class XslSheetDBop{



    public static void AddXslSheet(String name,String description,String code,boolean defaultXsl)
    throws fr.imag.clips.papillon.business.PapillonBusinessException{
        if ((name!=null) && (code!=null)) {
            //search for an existing
            XslSheetFactory XslFactory=new XslSheetFactory();
            XslSheet Existe=XslFactory.findXslSheetByName(name);
            if (Existe.IsEmpty()) {
                XslSheet mySheet=new XslSheet();
                mySheet.setName(name);
                mySheet.setDescription(description);
                mySheet.setCode(code);
                mySheet.setDefaultxsl(defaultXsl);
                mySheet.save();
                PapillonLogger.writeDebugMsg("XslSheet: " + mySheet.getName() + " is stored in the database");
            }
            else {
                PapillonLogger.writeDebugMsg("Existing XslSheet in the database");
                PapillonLogger.writeDebugMsg("Name: "+Existe.getName());
                PapillonLogger.writeDebugMsg("Description: "+Existe.getDescription());
            }
        }
        else {
            PapillonLogger.writeDebugMsg("XslSheet ignored");
        }
    }


    public static void AddAndReplaceXslSheet(String name,String description,String code,boolean defaultXsl)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        if ((name!=null) && (code!=null)) {
            //search for an existing
            XslSheetFactory XslFactory=new XslSheetFactory();
            XslSheet Existe=XslFactory.findXslSheetByName(name);
            if (!Existe.IsEmpty()) {
                Existe.delete();
				fr.imag.clips.papillon.business.transformation.XslTransformation.resetCache();
			}
			XslSheet mySheet=new XslSheet();
			mySheet.setName(name);
			mySheet.setDescription(description);
			mySheet.setCode(code);
			mySheet.setDefaultxsl(defaultXsl);
			mySheet.save();
            PapillonLogger.writeDebugMsg("XslSheet: " + name + " is stored in the database");
        }
        else {
            PapillonLogger.writeDebugMsg("XslSheet ignored");
        }        
    }

    public static void EmptyDatabase()
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        XslSheet[]	TheXslSheets= XslSheetFactory.getXslSheetsArray();
        for ( int i = 0; i < TheXslSheets.length; i++ ) {
            TheXslSheets[i].delete();
        }
    }
}
