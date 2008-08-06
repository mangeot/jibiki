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
 * Revision 1.6  2007/04/05 12:55:54  serasset
 * Added a DBLayer Version management with an auto-update of db layer.
 *
 * Revision 1.5  2005/06/15 16:48:27  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
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
 * Revision 1.3.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.3  2005/02/25 10:23:07  mangeot
 * Bug fixes
 *
 * Revision 1.2.2.2  2005/02/12 01:06:02  mangeot
 * PapillonLogger and system.out messages are now output in UTF-8.
 * The console encoding have to be in UTF-8 in order to see the non ASCII chars...
 *
 * Revision 1.2.2.1  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *
 *-----------------------------------------------
 * 
 */


package fr.imag.clips.papillon.business;


import com.lutris.appserver.server.Enhydra;
import com.lutris.logging.*;

public class PapillonLogger {
 
    protected static java.io.PrintStream myOutStream = new java.io.PrintStream(System.out, true);
	{
	try {
		myOutStream = new java.io.PrintStream(System.out, true, "UTF-8");
	}
	catch (java.io.UnsupportedEncodingException ex) {
		;
	}
	}
    /**
     * Method to write a debugging message to the debug log
     * channel when the DEBUG flag is turned on
     * 
     * @param msg The message to write to the DEBUG log channel
     */
    public static void writeDebugMsg(String msg) {
        if (null != msg) {
//            Enhydra.getLogChannel().write(Logger.DEBUG,msg);
// MM: FIXME: I changed the log level from Debug to Warning because therre is too much debug output 
// in enhydra5.1. Therefore, it is impossible to find the Papillon logger proper output
//            Enhydra.getLogChannel().write(Logger.WARNING,msg);
// MM: finally, I use System.out because it is not possible to specify the output encoding for 
// the Enhydra LogChannel
// well, I still have problems with the CGI input parameters that do not display well !
			myOutStream.println(fr.imag.clips.papillon.business.utility.Utility.PapillonPrintDateFormat.format(new java.util.Date()) + ":　" + msg);
        } else {
//            Enhydra.getLogChannel().write(Logger.DEBUG,"null");
//            Enhydra.getLogChannel().write(Logger.WARNING,"null");
        }
    }

    public static void writeErrorMsg(String msg) {
        if (null != msg) {
            Enhydra.getLogChannel().write(Logger.ERROR, msg);
        }
    }

    public static void writeInfoMsg(String msg) {
        if (null != msg) {
            Enhydra.getLogChannel().write(Logger.INFO, msg);
        }
    }
//import java.io.UnsupportedEncodingException;


}