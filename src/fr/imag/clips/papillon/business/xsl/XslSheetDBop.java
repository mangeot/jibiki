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
 * Revision 1.1.1.1  2004/12/06 16:38:38  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
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
