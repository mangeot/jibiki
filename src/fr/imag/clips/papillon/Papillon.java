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
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
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
