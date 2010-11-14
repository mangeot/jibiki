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
 * Revision 1.12  2007/04/05 12:55:54  serasset
 * Added a DBLayer Version management with an auto-update of db layer.
 *
 * Revision 1.11  2007/01/16 13:28:31  serasset
 * Added cache reinitialization when a metadata is modified.
 *
 * Revision 1.10  2007/01/05 13:57:25  serasset
 * multiple code cleanup.
 * separation of XMLServices from the Utility class
 * added an xml parser pool to allow reuse of parser in a multithreaded context
 * added a new field in the db to identify the db layer version
 * added a new system property to know which db version is known by the current app
 *
 * Revision 1.9  2006/08/10 22:17:12  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 * Revision 1.8  2006/08/10 19:03:15  mangeot
 * default charsetCVS: ----------------------------------------------------------------------
 *
 * Revision 1.7  2006/08/10 18:44:49  mangeot
 * Added local default file encoding log
 *
 * Revision 1.6  2005/07/28 13:06:47  mangeot
 * - Added the possibility to export in PDF format. The conversion into PDF is don
 * e via the fop package that has to be installed (see ToolsForPapillon)
 *
 * Revision 1.5  2005/06/16 10:42:15  mangeot
 * Added and modified files for the GDEF project
 *
 * Revision 1.4  2005/05/24 12:51:21  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.1  2005/03/16 13:24:31  serasset
 * Modified all boolean fields in table to CHAR(1) in order to be more db independant.
 * Suppressed ant.jar from class path, informationfiles (which rely on it) should be corrected.
 * The version of Xerces is now displayed on application init.
 *
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
import com.lutris.logging.Logger;

import fr.imag.clips.papillon.business.dictionary.DictionariesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.AvailableLanguages;
import fr.imag.clips.papillon.business.xsl.XslSheetFactory;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

/* For JDictd */
import fr.imag.clips.papillon.dict.server.JDictd;

/*for tests*/
import fr.imag.clips.papillon.business.xml.XMLParsersPool;
import fr.imag.clips.papillon.papillon_data.DataLayerVersion;


/**
 * The application object.
 *
 * Application-wide data would go here.
 */
public class Papillon extends StandardApplication {
	
    protected static final String PRIORITY_PACKAGE_CONFIG = "Papillon.Presentation.PriorityPackage";
    protected static final String LAYOUT_CONFIG = "Papillon.LayoutClassName";
    protected static final String COOKIE_CONFIG = "Papillon.LoginCookieName";

    protected String presentationPriorityPackage = null;
    protected String layoutClassName = "fr.imag.clips.papillon.presentation.PapillonLayout";
    protected String loginCookieName = "PapillonLoginCookie";
	protected String applicationPrefix = "/";
	static {
                System.setProperty("javax.xml.parsers.DocumentBuilderFactory", 
				"org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
        }
    /*
     *  A few methods you might want to add to.
     *  See StandardApplication for more details.
     */
    public void startup(Config appConfig) throws ApplicationException {
        super.startup(appConfig);
        //  Here is where you would read application-specific settings from
        //  your config file.
        
        // Look at the Xerces version that is currently loaded and display it...
        PapillonLogger.writeInfoMsg(org.apache.xerces.impl.Version.getVersion());
		
		// Look at the local file encoding
        PapillonLogger.writeInfoMsg("Local system file encoding: "+System.getProperty ("file.encoding"));
		// Available only in java 1.5
		//java.nio.charset.Charset defaultCharset = java.nio.charset.Charset.defaultCharset();
		java.io.InputStreamReader myInputStreamReader = new java.io.InputStreamReader(System.in);
        PapillonLogger.writeInfoMsg("Local system default charset: "+myInputStreamReader.getEncoding());
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

        // Initialize the XMLParsersPool
        try {
            XMLParsersPool.initializeXMLParsersPool();
        } catch (PapillonBusinessException e) {
            throw new ApplicationException("Problem when initializing the XML parsers pool. Quitting.", e);
        }

        // Get current Layout Setting.
        String priorityPackage = null; 
        try {
            priorityPackage =  Enhydra.getApplication().getConfig().getString(PRIORITY_PACKAGE_CONFIG);
            presentationPriorityPackage = priorityPackage;
        } catch (ConfigException e) {
            // nothing... failing to default...
        }

        // Get current Layout Setting.
        String configLayoutClassName = null; 
        try {
            configLayoutClassName =  Enhydra.getApplication().getConfig().getString(LAYOUT_CONFIG);
            layoutClassName = configLayoutClassName;
        } catch (ConfigException e) {
            // nothing... failing to default...
        }
        
        // Get Login Cookie Name.
        String configLoginCookieName = null; 
        try {
            configLoginCookieName =  Enhydra.getApplication().getConfig().getString(COOKIE_CONFIG);
            loginCookieName = configLoginCookieName;
        } catch (ConfigException e) {
            // nothing... failing to default...
        }
		
		try {
			applicationPrefix = Enhydra.getApplication().getConfig().getString("Application.Prefix");
		}
		catch (com.lutris.util.ConfigException ce) {
				PapillonLogger.writeDebugMsg("no Application.Prefix var in the config file!");
		}
		
		try {
			Papillon.initializeAllCaches();
        } catch (PapillonBusinessException e) {
            ;
        }
		
        // Upgrade the DB layer to a correct version
        // Problem is: the cache initialization has to be done in order to get all available volumes
        // hence, layer modifications should not break the cache mecanism...
        PapillonLogger.writeInfoMsg("Database uses Data Layer Version n°: " + DataLayerVersion.getDBVersion());
        try {
            DataLayerVersion.upgradeDB();
        } catch (PapillonBusinessException e) {
            throw new ApplicationException("Could not upgrade DB Layer.", e);
        }
		
		try {
			Papillon.initializeAllCaches();
        } catch (PapillonBusinessException e) {
            throw new ApplicationException("Initialize caches error", e);
        }
		try {
			XslSheetFactory.initializeXslSheetCache();
        } catch (PapillonBusinessException e) {
            throw new ApplicationException("Initialize caches error", e);
        }
    }

    public synchronized static void initializeAllCaches() throws PapillonBusinessException {
        // Initialize dictionarie cache

        DictionariesFactory.initializeDictionaryCache();

        // Initialize volume cache
        VolumesFactory.initializeVolumeCache();

        // Initialize volume cache
        VolumeEntriesFactory.initializeEntryCache();

		// Initialize transformer factory
        // FIXME : For Xalan 2_7_0
        XslSheetFactory.initializeTransformerFactory();

        // Initialize xsl sheet cache
        XslSheetFactory.initializeXslSheetCache();

        // Initialize jibiki xsl sheets
        XslSheetFactory.initializeJibikiXslSheet();

        AvailableLanguages.resetCache();
    }

    public String getPriorityPackage() {
        return presentationPriorityPackage;
    }
    
    public String getLayoutClassName() {
        return layoutClassName;
    }
    
    public String getLoginCookieName() {
        return loginCookieName;
    }
	
	public String getUrl() {
		return defaultUrl;
	}
    
	public String getApplicationPrefix() {
		return applicationPrefix;
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
