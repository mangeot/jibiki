/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:38  serasset
 * Initial revision
 *
 * Revision 1.6  2004/02/10 05:27:14  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.5.2.1  2004/02/02 07:53:53  mangeot
 * Bug fixes in encoding and UserInterface
 *
 * Revision 1.5  2003/08/14 08:30:14  mangeot
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
 * Revision 1.4  2003/03/27 06:54:56  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/03/26 04:20:50  mangeot
 * Added order in informationdocument and xslsheet queries
 *
 * Revision 1.2.2.1  2003/02/18 03:27:53  mangeot
 * Development for the editing interface
 *
 * Revision 1.2  2003/02/06 09:35:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.7  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.6  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.5  2002/04/17 17:09:24  mangeot
 * Travail sur les stylesheets
 *
 * Revision 1.4  2002/03/20 09:36:21  mangeot
 * Now the consultation is done in a separate db table for each volume
 * A big pb remaining: the data directory has to be remodified by hands...
 *
 * Revision 1.3  2001/07/24 13:15:32  salvati
 * Adding the defaultxsl field in the database, adding the choice of
 * the default stylesheet when adding stylesheets.
 *
 * Revision 1.2  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.1  2001/07/12 16:55:52  salvati
 * Adding find by name.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.xsl;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.business.utility.*;

import fr.imag.clips.papillon.data.XslSheetDO;
import fr.imag.clips.papillon.data.XslSheetQuery;

import com.lutris.appserver.server.sql.ObjectId;

//for URLs
import java.net.URL;

//pour les nouvelles entrees
import org.w3c.dom.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * Used to find the instances of xslsheet.
 */
public class XslSheetFactory {
    
    /** 
     * The getXslSheetArray method performs a database query to
     * return an array of XslSheets
     * @return
     *     array of discs. 
     * @exception PapillonBusinessException
     *   If there is a problem retrieving disc information.
     */
    public static XslSheet[] getXslSheetsArray() 
        throws PapillonBusinessException {
        XslSheet[] theXslArray = null;
        
        try {
            XslSheetQuery query = new XslSheetQuery();
	    query.addOrderByName(true);
            XslSheetDO[] DOarray = query.getDOArray();
            theXslArray = new XslSheet[ DOarray.length ];
            for ( int i = 0; i < DOarray.length; i++ )
	    	theXslArray[i] = new XslSheet(DOarray[i]);

        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getXslSheetsArray()", ex);
        }
         
        return theXslArray;
    }
    
    
    public static String parseXslSheet(URL fileURL) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        String result = null;
        
            try {
                Document docXml = Utility.buildDOMTree(fileURL);                
               if (null != docXml) 
                result=Utility.NodeToString(docXml);
                PapillonLogger.writeDebugMsg("The XSL sheet:");
                PapillonLogger.writeDebugMsg(result);
               }
               catch(Exception ex) {
                    throw new PapillonBusinessException("Exception in parseXslSheet()", ex);
                }
                return result;
            }

    /** 
     * The findMessageByID method performs a database query to
     * return a <CODE>Message</CODE> object
     * representing the row in the <CODE>message</CODE> table
     * that matches the object id. 
     *
     * @param id, the object id of the message table.
     * @return
     *    the message. null if there isn't a message associated
     *    to the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static XslSheet findXslSheetByID(String id) 
        throws PapillonBusinessException {
        XslSheet theXsl = null;
        
        try {
            XslSheetQuery query = new XslSheetQuery();
            //set query
            query.setQueryOId(new ObjectId(id));
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            XslSheetDO theXslSheetDO = query.getNextDO();
            theXsl = new XslSheet(theXslSheetDO);
            return theXsl;
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findXslSheetByID()", ex);
        }
    }
    
    
    public static XslSheet findDefaultXslSheet()
        throws PapillonBusinessException {
        XslSheet theXsl = null;
        
        try {
            XslSheetQuery query = new XslSheetQuery();
            //set query
            query.setQueryDefaultxsl(true);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            XslSheetDO theXslSheetDO = query.getNextDO();
            theXsl = new XslSheet(theXslSheetDO);
            if (null == theXsl) {
            // Here we should generate an exception or display an HTML message
              fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Exception in findDefaultxslsheet(): no default existing XSL sheet");
              }
            return theXsl;
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findDefaultxslsheet()", ex);
        }
    }
    
    public static XslSheet findXslSheetByName(String Name) 
        throws PapillonBusinessException {
        XslSheet theXsl = null;
        
        try {
            XslSheetQuery query = new XslSheetQuery();
            //set query
            query.setQueryName(Name);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            XslSheetDO theXslSheetDO = query.getNextDO();			
            theXsl = new XslSheet(theXslSheetDO);
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findXslSheetByID()", ex);
        }
        return theXsl;
    }
}

