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
 * Revision 1.3  2003/09/03 10:08:29  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.2  2003/08/14 08:30:11  mangeot
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
 * Revision 1.1.1.1.2.2  2003/08/09 07:21:05  mangeot
 * Lots of improvements:
 * possible to create a new axie linking two contributions
 * possible to delete contributions
 *
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:16  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.6  2002/10/25 14:10:30  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.5.2.1  2002/10/23 09:51:07  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.5  2002/09/17 17:13:21  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.4  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.3.8.2  2002/08/09 09:15:13  mangeot
 * Improvements for the simple consultation
 * adding text for help,
 * correcting consultation bugs
 *
 * Revision 1.3.8.1  2002/08/02 13:55:48  mangeot
 * Corrected the encoding problem while connection to the XRCE analyzers
 *
 * Revision 1.3  2002/05/22 12:43:12  mangeot
 * bugs correction ...
 *
 * Revision 1.2  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.1  2002/05/02 07:02:58  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/04/14 09:47:12  mangeot
 * lecture des elements CDM ds les fichiers volume-metadata
 * et upload des entrees
 *
 * Revision 1.1  2002/04/01 07:48:10  mangeot
 * Added these files to manage volume metadata files
 *
 * Revision 1.1  2002/03/11 11:15:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/12/18 13:41:36  serasset
 * *** empty log message ***
 *
 * Revision 1.5  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.4  2001/07/12 20:56:38  salvati
 * ratrapage de la perte du fichier
 *
 * Revision 1.4  2001/07/11 15:30:25  serasset
 * Suppression des tables author et threads. Utilisation d'une table unique "Volumes".
 *
 * Revision 1.3  2001/07/09 16:37:29  serasset
 * Liens entre l'application enhydra et la base de donnees PostgreSQL.
 * Suppression du dossier data de la hierarchie CVS
 * Premiere version de la mailing list.
 *
 * Revision 1.2  2001/07/04 12:50:43  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.dictionary;


// For the HashMap & TreeSet
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.utility.Utility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.tidy.Configuration;
import org.w3c.tidy.Tidy;



/**
 * Represents a Volume. 
 */
public class Wrapper {

    protected String name = "";
    protected String url = "";
    protected String parameters = "";
    protected String method = "GET";
    protected String encoding = "UTF-8";
    protected String preStartMatch = "";
    protected String startMatch = "";
    protected String endMatch = "";
            
    
    // constructor
   public Wrapper() {
   }

   public void setURL(String newURL) {
       url = newURL;
   }

   public void setName(String newName) {
       name = newName;
   }

   public void setEncoding(String newEncoding) {
       encoding = newEncoding;
   }

   public void setParameters(String params) {
        parameters = params;
    }

   public void setMethod(String newMethod) {
       method = newMethod;
   }

   public void setPreStartMatch(String match) {
       preStartMatch = match;
   }

   public void setStartMatch(String match) {
       startMatch = match;
   }

   public void setEndMatch(String match) {
       endMatch = match;
   }
   public String getEncoding() {
       return encoding;
   }
   public String getName() {
       return name;
   }
   
   public Element getResultElement (String[] Headwords)
       throws PapillonBusinessException, java.io.IOException {
           String resString = "<div>" + getResultString(Headwords) + "</div>";
           Tidy tidyParser = new Tidy();
           tidyParser.setQuiet(true);
           tidyParser.setShowWarnings(false);
           tidyParser.setOnlyErrors(true);
           //   tidyParser.setErrout(new NullPrintWriter());
           // tidyParser.setErrout(null);
           tidyParser.setXmlOut(true);
           // tidyParser.setXHTML(true);
           tidyParser.setCharEncoding(Configuration.UTF8);
           // tidyParser.setXmlTags(true);
           Document docDOM = tidyParser.parseDOM(new ByteArrayInputStream(resString.getBytes()), null);
           // It is dangerous but this config of tidy produces an html document
           Element elt = docDOM.getDocumentElement();
           elt = (Element)elt.getElementsByTagName("body").item(0).getFirstChild();
           return elt;
       }


   /* FIXME: this method has two big problems:
       1) It exists because I don't know how to insert the result of tidy directly into another DOM document for display
       2) I have to cut the XML header "by hands" and it is not nice ! */
   public String getResultXmlCode (String[] Headwords)
       throws PapillonBusinessException, java.io.IOException {
           Element myElement = getResultElement(Headwords);
           String xmlCode =  Utility.NodeToString(myElement);
		   xmlCode = Utility.trimXMLHeader(xmlCode);
           return xmlCode;
       }

   
   public String getResultString (String[] Headwords) throws PapillonBusinessException {
     return getResultString(concatenateHeadwords(Headwords));
   }

   protected String concatenateHeadwords(String[] Headwords) {
       String headwords = null;
       if (null != Headwords && Headwords.length > 0) {
           headwords = Headwords[0];
           int length = Headwords.length;
           if (length > 1) {
               for (int i=1;i<length;i++) {
                   headwords = headwords + "+" + Headwords[i];
               }
           }
       }
       return headwords;
   }
   
       public String getResultString (String headwords) throws PapillonBusinessException {
           String resultString = null;

       try {
           headwords=Utility.convertToUrlForEncoding(headwords,encoding);
           if (method.equalsIgnoreCase("GET")) {
               url = url + "?" + parameters + headwords;
           }
           URL myURL = null;
           myURL = new URL(url);

           HttpURLConnection myConnection = (HttpURLConnection)myURL.openConnection();
           myConnection.setRequestMethod(method);
           fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Connected to: " + url);

           if (method.equalsIgnoreCase("POST")) {
               myConnection.setDoOutput(true);

               OutputStream myOutputStream = myConnection.getOutputStream();
               myOutputStream.write((parameters+headwords).getBytes());
               fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Parameters: " + parameters+headwords);

               myOutputStream.flush();
               myOutputStream.close();
           }

           InputStream myInputStream = myConnection.getInputStream();
           ByteArrayOutputStream bytearrayout = new ByteArrayOutputStream();
           byte data1[] = new byte[1];

           int length;
           while(true) {
               length = myInputStream.read(data1);
               if (length < 0) break;
               bytearrayout.write(data1);
           }
           resultString = bytearrayout.toString();
           bytearrayout.close();
           myInputStream.close();
           myConnection.disconnect();

           resultString = extractResponse(resultString);
           resultString = Utility.convertFromEncoding(resultString,this.encoding);
       }
       catch (Exception e) {
           throw new PapillonBusinessException("Error in Wrapper.getResult() :", e);
       }

       return resultString;
    }
   
   protected String extractResponse(String response) {
       int offset = 0;
       if (null != preStartMatch && !preStartMatch.equals("")) {
           if ((offset=response.indexOf(preStartMatch))> 0) {
               response = response.substring(offset + preStartMatch.length());
           }
       }
       if (null != startMatch && !startMatch.equals("")) {
           if ((offset=response.indexOf(startMatch))> 0) {
               response = response.substring(offset + startMatch.length());
           }
       }
       if (null != endMatch && !endMatch.equals("")) {
           if ((offset=response.indexOf(endMatch))> 0) {
               response = response.substring(0, offset);
           }
       }
       return response;
   }

 }
