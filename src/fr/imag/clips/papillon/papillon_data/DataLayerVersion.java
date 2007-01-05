/* Jibiki project
 * © jibiki developpers, GETA-CLIPS, IMAG.
 *-----------------------------------------------------------------------------
 * $Id$
 *-----------------------------------------------------------------------------
 * $Log$
 * Revision 1.1  2007/01/05 13:57:26  serasset
 * multiple code cleanup.
 * separation of XMLServices from the Utility class
 * added an xml parser pool to allow reuse of parser in a multithreaded context
 * added a new field in the db to identify the db layer version
 * added a new system property to know which db version is known by the current app
 *
 *-----------------------------------------------------------------------------
*/

package fr.imag.clips.papillon.papillon_data;

import com.lutris.dods.builder.generator.query.DataObjectException;
import com.lutris.dods.builder.generator.query.NonUniqueQueryException;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.data.JibikiVersionDO;
import fr.imag.clips.papillon.data.JibikiVersionQuery;

/**
 * DataLayerVersion: allows version recognition of the data layer of the current db.
 */
public class DataLayerVersion {

    public static int getDBVersion() {
        // Query the jibikiVersion
        JibikiVersionQuery jvq = new JibikiVersionQuery(CurrentDBTransaction.get());
        jvq.requireUniqueInstance();
        try {
            JibikiVersionDO[] jva = jvq.getDOArray();
            return (jva == null || jva.length == 0) ? 0 : jva[0].getNumber();
        } catch (DataObjectException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        } catch (NonUniqueQueryException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        }
        return 0;
    }

        public static int getApplicationVersion() {
        // Retrieve the application version.
        int appver = Integer.parseInt(System.getProperty("jibiki.dblayer.version"));
        return 0;
    }
}
