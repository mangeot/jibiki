/* Jibiki project
 * © jibiki developpers, GETA-CLIPS, IMAG.
 *-----------------------------------------------------------------------------
 * $Id$
 *-----------------------------------------------------------------------------
 * $Log$
 * Revision 1.3.2.3  2008/01/09 19:29:59  serasset
 * Updated layer version transition to allow the creation of correctly structured new dictionaries databases.
 *
 * Revision 1.3.2.2  2007/11/21 18:25:46  serasset
 * Created new code to reinex the volumes. This will allow for further speed improvements.
 * New DB layer version that creates a view containing current available headwords.
 * New DB layer also introduce new indexes in the db to drastically accelerate headword queries.
 * New page to browse the entries of a dictionary (an index) that uses this new layer.
 *
 * Revision 1.3.2.1  2007/11/15 13:07:49  serasset
 * Re-implemented reindexing feature to allow later optimization
 * Updated database layer version to 2: add new views for headword listing, add indexes and analyze idx tables
 * BUG165: Autocomplete now uses headword list view and does not return obsolete headwords
 *
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

            if (currentDBVersion <= 1) addHeadwordViewsAndIndex();

            setDBVersion(currentApplicationVersion);
            PapillonLogger.writeDebugMsg("jibikiversion value incremented.");
        }
    }

    public static void addHeadwordViewsAndIndex() throws PapillonBusinessException {
        Collection vols = VolumesFactory.getVolumes();
        Iterator volsIter = vols.iterator();
        // Create headword view for all volumes, except axi.
        while (volsIter.hasNext()) {
            Volume vol = (Volume) volsIter.next();
            if (!vol.getSourceLanguage().equals("axi")) {
                if (!ManageDatabase.getViewNames().contains(vol.getHeadwordViewName())) {
                    // CREATE VIEW hw_lexalpfra
                    // AS SELECT DISTINCT i.value FROM idxlexalpfra AS i
                    //     INNER JOIN idxlexalpfra AS status ON status.entryid=i.entryid
                    //   WHERE status.key='cdm-contribution-status' AND (status.value='finished' OR status.value='modified') AND i.key='cdm-headword';

                    ManageDatabase.createHeadwordView(vol.getHeadwordViewName(), vol.getIndexDbname());
                    PapillonLogger.writeDebugMsg("Created headword view for volume " + vol.getName());

                }
            }
        }
        volsIter = vols.iterator();
        // Create indexes on value and msort.
        while (volsIter.hasNext()) {
            Volume vol = (Volume) volsIter.next();
            String idxval = vol.getIndexDbname() + "_value_idx";
            String idxmsort = vol.getIndexDbname() + "_msort_idx";
            if (!ManageDatabase.getIndexes(vol.getIndexDbname()).contains(idxval)) {
                ManageDatabase.executeSql(
                        "CREATE INDEX " + idxval + " ON " + vol.getIndexDbname() + " (value);\n");
                PapillonLogger.writeDebugMsg("Created index on value for volume " + vol.getName());

            }
            if (!ManageDatabase.getIndexes(vol.getIndexDbname()).contains(idxmsort)) {
                ManageDatabase.executeSql(
                        "CREATE INDEX " + idxmsort + " ON " + vol.getIndexDbname() + " (msort);\n");
                PapillonLogger.writeDebugMsg("Created index on msort for volume " + vol.getName());

            }
            ManageDatabase.executeSql(
                    "ANALYZE " + vol.getIndexDbname() + ";\n");
            PapillonLogger.writeDebugMsg("Analyzing index for volume " + vol.getName());
        }
    }
}
