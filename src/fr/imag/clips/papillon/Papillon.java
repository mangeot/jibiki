/*
 * papillon 
 *
 * Enhydra super-servlet
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
 * Revision 1.8  2003/10/03 16:02:39  serasset
 * Suppression du traitement specifique du volume Foks.
 *
 * Revision 1.7  2003/09/29 10:54:26  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2003/09/23 15:52:53  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2003/09/22 10:17:36  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/09/03 10:08:30  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.3  2003/08/14 08:30:09  mangeot
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
 * Revision 1.2.2.3  2003/06/28 09:28:08  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.2  2003/05/28 09:17:14  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.2.2.1  2003/02/18 03:27:53  mangeot
 * Development for the editing interface
 *
 * Revision 1.2  2003/01/31 10:00:44  mangeot
 * Added Query Logs into the database
 * and 2 booleans in Papillon.conf to control
 * 1- the logs
 * 2- the dictd listening serverCVS: 
 *
 * Revision 1.1.1.1  2002/10/28 16:49:12  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/09/11 17:35:08  mangeot
 * Added config from config file for dictd server
 *
 * Revision 1.4  2002/09/11 16:28:13  mangeot
 * Added classes to implement dict protocol rfc 2229
 *
 * Revision 1.3  2001/09/07 06:57:26  serasset
 * *** empty log message ***
 *
 * Revision 1.2  2001/07/04 12:50:42  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * Papillon enhydra application.
 */

package fr.imag.clips.papillon;

import com.lutris.appserver.server.*;
import com.lutris.appserver.server.httpPresentation.*;
import com.lutris.util.*;

/* For JDictd */
import fr.imag.clips.papillon.dict.server.JDictd;

/*for tests*/
import fr.imag.clips.papillon.business.PapillonLogger;
//import fr.imag.clips.papillon.business.dictionary.ParseVolume;
import fr.imag.clips.papillon.business.locales.*;

/**
 * The application object.
 *
 * Application-wide data would go here.
 */
public class Papillon extends StandardApplication {

    /*
     *  A few methods you might want to add to.
     *  See StandardApplication for more details.
     */
    public void startup(Config appConfig) throws ApplicationException {
        super.startup(appConfig);
        //  Here is where you would read application-specific settings from
        //  your config file.

		//tests
	//	ParseVolume.parseVolume("essai.xml");
			
        //  Dictd specific settings.
	boolean listen = false; 
	try {
	    listen =  Enhydra.getApplication().getConfig().getBoolean(JDictd.LISTEN_STRING);
	} catch (ConfigException e) {
            throw new ApplicationException("Dictd parameters not found. Check the application config file.", e);
        }
	if (listen) {

	    int port = 2628;
	    int timeout = 50000;
	    try {
		port =  Enhydra.getApplication().getConfig().getInt(JDictd.PORT_STRING);
		timeout =  Enhydra.getApplication().getConfig().getInt(JDictd.TIMEOUT_STRING);
	    }
	    catch (ConfigException e) {
		throw new ApplicationException("Dictd parameters not found. Check the application config file.", e);
	    }
	    // Here is where I startup JDictd server
	    JDictd.listen(port,Enhydra.getApplication(),timeout);
	}
    }
        
    public boolean requestPreprocessor(HttpPresentationComms comms)
                   throws Exception {
        return super.requestPreprocessor(comms);
    }

    /**
     * This is an optional function, used only by the Multiserver's graphical
     * administration. This bit of HTML appears in the status page for this
     * application. You could add extra status info, for example
     * a list of currently logged in users.
     *
     * @return HTML that is displayed in the status page of the Multiserver.
     */
    public String toHtml() {
        return "Application <I>Papillon</I>, GETA-CLIPS IMAG";
    }
}
