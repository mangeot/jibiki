/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.1.1.1  2004/12/06 16:38:38  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
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

