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
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.3  2003/09/03 10:08:30  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:16  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.3  2002/10/25 14:10:30  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.2.2.1  2002/10/01 05:49:16  mangeot
 * Corrected a few bugs for AdminInformations.java
 *
 * Revision 1.2  2002/08/16 11:46:08  tache
 * Improved errors handle. Now all kind of exceptions thrown during the
 * import are caught.
 *
 * Revision 1.1  2002/08/01 12:39:59  tache
 * Cleaned up a lot of code in import classes. Moved HTML parsing methods from
 * ImportHTMLFile to new class HTMLParser to reuse them in ImportArchive.
 * Moved XMLTitleParser to fr.imag.clips.papillon.presentation.
 *
 * Revision 1.4  2001/11/16 13:56:50  serasset
 * Correction d'un probleme d'encodage de chaine dans la consultation d'un fichier d'information.
 *
 * Revision 1.3  2001/10/30 15:23:00  serasset
 * Images and other format are now supported as media files (i.e. files that are locally saved in a special directory).
 *
 * Revision 1.2  2001/10/29 13:32:17  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 * Revision 1.1  2001/10/17 12:59:56  serasset
 * L'ajout de document d'information se fait via une action specifique par type de fichier.
 * Distinction entre Document (abstrait) et Fichier (qui composent concretement un document).
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;

import java.io.InputStream;
import java.io.InputStreamReader;

import fr.imag.clips.papillon.business.PapillonImportException;
import fr.imag.clips.papillon.business.PapillonLogger;

import org.apache.regexp.RE;
import org.apache.regexp.ReaderCharacterIterator;
import org.w3c.dom.Document;
import org.w3c.tidy.Configuration;
import org.w3c.tidy.Tidy;


public class HTMLParser {

    public final static String FILE_VIEWER_URL="ConsultInformations.po?fileid="; 


    // Constructor...
    public HTMLParser() {
	// Nada...
    }
    

    /**
     * Parses an HTML File in an InputStream to a DOM Document
     *
     * @param is the InputStream to parse
     * @param encoding the encoding type to use for the parsing
     * @return the resulting document
     */
    public static Document parseHTML(InputStream is, int encoding)  throws java.io.IOException, PapillonImportException {
        
        Tidy myTidy=new Tidy();
        myTidy.setCharEncoding(encoding);

        myTidy.setMakeClean(true);
        myTidy.setXHTML(true);
        myTidy.setXmlOut(true);
        myTidy.setUpperCaseTags(true);
        myTidy.setTidyMark(false);
        myTidy.setQuiet(true);
        myTidy.setQuoteAmpersand(false);
        myTidy.setQuoteMarks(true);        
        myTidy.setSmartIndent(true);
        myTidy.setIndentContent(true);
        Document myDoc=myTidy.parseDOM(is,null);
        if (myTidy.getParseErrors()>0) {
	    throw new PapillonImportException("there are errors in an HTML file. Correct them before sending the document to the server.");
	}
        return myDoc;

    }
    
    

    /**
     * Tries to guess the encoding of an InputStream
     *
     * @param is the InputStream
     * @return an integer representing the encoding type
     */
    public static int guessEncoding(InputStream is) {
        // returns the encoding of the HTML document
        // Pretend the stream is iso latin 1...
        int res = Configuration.UTF8;
        try {
            InputStreamReader ir = new InputStreamReader(is, "ISO-8859-1");
    
            // First, search for a encoding declaration. If present, it should be something like:
            // <META content="text/html; charset=UTF-8" http-equiv="Content-Type"> 
            // WARNING, will will only search for \"text/html; charset=...\"
            RE r = new RE("content=\"text/html;[:space:]*charset=([^\"]*)\"");
            ReaderCharacterIterator sci = new ReaderCharacterIterator(ir);
            
            boolean matched = r.match(sci, 0);
            if (matched) {
                String enc = r.getParen(1);
                if (enc.equalsIgnoreCase("UTF-8")) {
                    res = Configuration.UTF8;
                } else if (enc.equalsIgnoreCase("ISO-8859-1")) {
                    res = Configuration.LATIN1;
                } else {
                    PapillonLogger.writeDebugMsg("Unrecognized encoding: " + enc);
                }
            }
        } catch (java.io.UnsupportedEncodingException e) {
            PapillonLogger.writeDebugMsg("unsupported encoding.");
        } catch (org.apache.regexp.RESyntaxException e) {
            PapillonLogger.writeDebugMsg("WARN : Expression Syntax Error !!!");	   
        } catch (java.io.IOException e) {
	    PapillonLogger.writeDebugMsg("Error closing InputStreamReader.");
	}
        return res;
    }

}



