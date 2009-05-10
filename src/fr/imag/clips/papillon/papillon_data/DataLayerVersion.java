/* Jibiki project
 * © jibiki developpers, GETA-CLIPS, IMAG.
 *-----------------------------------------------------------------------------
 * $Id$
 *-----------------------------------------------------------------------------
 * $Log$
 * Revision 1.3  2007/04/05 13:56:23  serasset
 * Corrected UserLanguage (slo -> slv)
 *
 * Revision 1.2  2007/04/05 12:55:54  serasset
 * Added a DBLayer Version management with an auto-update of db layer.
 *
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

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.appserver.server.Enhydra;
import com.lutris.dods.builder.generator.query.DataObjectException;
import com.lutris.dods.builder.generator.query.NonUniqueQueryException;
import com.lutris.dods.builder.generator.query.QueryException;
import com.lutris.dods.builder.generator.query.RefAssertionException;
import com.lutris.util.ConfigException;
import fr.imag.clips.papillon.CurrentDBTransaction;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.data.JibikiVersionDO;
import fr.imag.clips.papillon.data.JibikiVersionQuery;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

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
        try {
            String version = Enhydra.getApplication().getConfig().getString("jibiki.dblayer.version");
            return Integer.parseInt(version);
        } catch (ConfigException e) {
            return 0;
        }
    }

    public static void setDBVersion(int v) throws PapillonBusinessException {
        JibikiVersionQuery jvq = new JibikiVersionQuery(CurrentDBTransaction.get());
        jvq.requireUniqueInstance();
        try {
            JibikiVersionDO[] jva = jvq.getDOArray();
            JibikiVersionDO jvo;
            if (jva == null || jva.length == 0) {
                jvo = JibikiVersionDO.createVirgin(CurrentDBTransaction.get());
            } else {
                jvo = jva[0];
            }
            jvo.setNumber(v);
            jvo.save();
        } catch (DataObjectException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        } catch (NonUniqueQueryException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        } catch (SQLException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        } catch (DatabaseManagerException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        } catch (QueryException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        } catch (ObjectIdException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        } catch (RefAssertionException e) {
            PapillonLogger.writeDebugMsg(e.getLocalizedMessage());
        }
    }

    // WARNING: This method should be called AFTER CACHE INITIALISATION.
    public static void upgradeDB() throws PapillonBusinessException {
        int currentDBVersion = getDBVersion();
        int currentApplicationVersion = getApplicationVersion();
        if (currentDBVersion < currentApplicationVersion) {
            PapillonLogger.writeDebugMsg("Upgrading database from version " + currentDBVersion + " to version " + currentApplicationVersion);
            if (currentDBVersion <= 0) {
                // Check if the version column do exist and create it if necessary
                if (!ManageDatabase.getTableNames().contains("jibikiversion")) {
                    ManageDatabase.executeSql(
                            "create table jibikiversion \n" +
                                    "( /* class JibikiVersion*/ \n" +
                                    "    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY , \n" +
                                    "    ObjectVersion INTEGER  NOT NULL , \n" +
                                    "    number INTEGER NOT NULL \n" +
                                    ");\n");
                    PapillonLogger.writeDebugMsg("jibikiversion table was created in the database");
                }

				// check if dom column is present in all volumes
				// delete it
				if (ManageDatabase.getColumnNames("volumes").contains("cdmelements")) {
					ManageDatabase.executeSql(
											  "alter TABLE volumes drop COLUMN cdmelements ;\n");
					PapillonLogger.writeDebugMsg("'cdmelements' column dropped in table volumes");                        
				}
				
				
                Collection vols = VolumesFactory.getVolumes();
                Iterator volsIter = vols.iterator();
                while (volsIter.hasNext()) {
                    Volume vol = (Volume) volsIter.next();
                    PapillonLogger.writeDebugMsg("Upgrading volume " + vol.getName());
                    // check if htmldom column is present in all volumes
                    // delete it if yes
                    if (ManageDatabase.getColumnNames(vol.getDbname()).contains("htmldom")) {
                        ManageDatabase.executeSql(
                                "alter TABLE " + vol.getDbname() + " drop COLUMN htmldom ;\n");
                        PapillonLogger.writeDebugMsg("'htmldom' column dropped in table " + vol.getDbname());
                    }
                    // check if dom column is present in all volumes
                    // delete it
                    if (ManageDatabase.getColumnNames(vol.getDbname()).contains("dom")) {
                        ManageDatabase.executeSql(
                                "alter TABLE " + vol.getDbname() + " drop COLUMN dom ;\n");
                        PapillonLogger.writeDebugMsg("'dom' column dropped in table " + vol.getDbname());                        
                    }
                }
            }

            setDBVersion(currentApplicationVersion);
            PapillonLogger.writeDebugMsg("jibikiversion value incremented.");            
        }
    }
}
