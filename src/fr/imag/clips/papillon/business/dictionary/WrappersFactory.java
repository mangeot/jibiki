/*
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.3  2003/09/03 10:08:29  mangeot
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
 * Revision 1.1.1.1.2.1  2003/06/25 09:54:57  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.4  2002/10/25 14:10:30  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.3.2.1  2002/10/23 09:51:07  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.3  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.2.8.2  2002/08/09 09:15:14  mangeot
 * Improvements for the simple consultation
 * adding text for help,
 * correcting consultation bugs
 *
 * Revision 1.2.8.1  2002/08/02 13:55:48  mangeot
 * Corrected the encoding problem while connection to the XRCE analyzers
 *
 * Revision 1.2  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.1  2002/05/02 07:02:58  mangeot
 * *** empty log message ***
 *
 *-----------------------------------------------
 *
 */

package fr.imag.clips.papillon.business.dictionary;

// General import
import java.util.TreeSet;

import fr.imag.clips.papillon.business.PapillonBusinessException;

/**
* Used to manage wrappers.
 */
public class WrappersFactory {

    // This function is written ad-hoc but has to be generated from an XML file
    // stored in the database...
    public static Wrapper createXRCEAnalyzerWrapper(String lang) {
        String url = "http://www.xrce.xerox.com/cgi-bin/mltt/demos/";
        Wrapper myWrapper = null;
        String CGI;
        if (lang.equals("deu")) CGI = "german.cgi";
        else if (lang.equals("eng")) CGI = "english.cgi";
        else if (lang.equals("esp")) CGI = "spanish.cgi";
        else if (lang.equals("fra")) CGI = "french.cgi";
        else if (lang.equals("ita")) CGI = "italian.cgi";
        else if (lang.equals("hun")) CGI = "hungarian.cgi";
        else CGI = null;

        if (null != CGI) {
            url = url + CGI;
            myWrapper = new Wrapper();
            myWrapper.setName("XRCE_" + lang);
            myWrapper.setURL(url);
            myWrapper.setMethod("POST");
            myWrapper.setParameters("step=2&txt=");
            myWrapper.setStartMatch("<listing><font size=+1>");
            myWrapper.setEndMatch("</font></listing>");
            myWrapper.setEncoding("ISO-8859-1");
        }
        return myWrapper;
    }

    // This function is written ad-hoc but has to be generated from an XML file
    // stored in the database...
    public static Wrapper createLexicoWrapper() {
        Wrapper myWrapper = new Wrapper();
        myWrapper.setName("Lexico_eng");
        myWrapper.setURL("http://www.dictionary.com/search");
        myWrapper.setMethod("GET");
        myWrapper.setParameters("q=");
        myWrapper.setStartMatch("<!-- Content -->");
        myWrapper.setEndMatch("<!-- End content -->");
        myWrapper.setEncoding("ISO-8859-1");
        return myWrapper;
    }

		public static String[] getXRCEAnalyzerAnswers(String response)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        String[] Array = null;
        String[] ArrayResponse = null;
        int offset;
        Array = response.split("\\s");
        TreeSet mySet = new TreeSet();
        String word;
        
        if (null != Array && Array.length > 0) {
            for (int i=0; i< Array.length; i++) {
                word = Array[i];
                if ((offset = word.indexOf("+")) > -1) {
                    if (offset>0) {
                        word = word.substring(0,offset);
                    }
                    else {
                        word = null;
                    }
                }
                if (null != word && !word.equals("")) {
                    mySet.add(word);
                }
            }
        }
        return (String[])mySet.toArray(new String[0]);
    }
}

