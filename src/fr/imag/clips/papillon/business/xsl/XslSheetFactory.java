/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.7  2005/07/16 12:33:23  mangeot
 * dictionaryname and volumename of xslsheets are now not null
 *
 * Revision 1.6  2005/07/14 13:48:53  serasset
 * Added columns dictionaryname and volumename to the xslsheets.
 * Modified the XslSheet and XslSheetFactory accordingly.
 * Modified AdminXsl interface accordingly.
 * Modified DictionariesFactory and VolumesFactory to allow several xsl-sheets and to
 * correctly provide dictionaryName/volumeName to XslSheetFactory.
 * Cleanup of several errors in papillon_static doml file.
 *
 * Revision 1.5  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.4  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.3.4.1  2005/06/01 08:38:43  mangeot
 * Multi bug correction + added the possibility of disabling data edition
 * via the Admin.po page
 *
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.3  2005/03/29 09:41:33  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2.2.2  2005/03/16 13:24:31  serasset
 * Modified all boolean fields in table to CHAR(1) in order to be more db independant.
 * Suppressed ant.jar from class path, informationfiles (which rely on it) should be corrected.
 * The version of Xerces is now displayed on application init.
 *
 * Revision 1.2.2.1  2005/01/27 15:56:21  mangeot
 * Able to load a volume with XPointers, cannot lookup the result yet.
 * Does not compile but commit for backup
 *
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
import fr.imag.clips.papillon.CurrentDBTransaction;

import fr.imag.clips.papillon.business.utility.*;

import fr.imag.clips.papillon.data.XslSheetDO;
import fr.imag.clips.papillon.data.XslSheetQuery;

import com.lutris.appserver.server.sql.ObjectId;

//for URLs
import java.net.URL;

import java.util.Vector;

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
     *     array of xslSheets. 
     * @exception PapillonBusinessException
     *   If there is a problem retrieving disc information.
     */
    public static XslSheet[] getXslSheetsArray() 
        throws PapillonBusinessException {
        XslSheet[] theXslArray = null;
        
        try {
            XslSheetQuery query = new XslSheetQuery(CurrentDBTransaction.get());
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
    
    /** 
    * The getXslSheetArray method performs a database query to
    * return an array of XslSheets for the given dictionary
    * @param dictionaryName
    * @return
    *     array of xslSheets for the given dictionary + global xslSheets. 
    * @exception PapillonBusinessException
    *   If there is a problem retrieving disc information.
    */
    public static XslSheet[] getApplicableXslSheets(String dictionaryName) 
    throws PapillonBusinessException {
        Vector xslSheets = new Vector();

        try {
            XslSheetQuery query = new XslSheetQuery(CurrentDBTransaction.get());
            query.setQueryDictionaryName(dictionaryName);
            query.addOrderByName(true);
            XslSheetDO[] DOarray = query.getDOArray();
            for ( int i = 0; i < DOarray.length; i++ )
                xslSheets.add(new XslSheet(DOarray[i]));
            
            query.reset();
            query.setQueryDictionaryName(null);
            query.addOrderByName(true);
            DOarray = query.getDOArray();
            for ( int i = 0; i < DOarray.length; i++ )
                xslSheets.add(new XslSheet(DOarray[i]));
            
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getXslSheetsArray()", ex);
        }
        
        return (XslSheet []) xslSheets.toArray((XslSheet []) null);
    }
    
    /** 
    * The getXslSheetArray method performs a database query to
    * return an array of XslSheets for the given dictionary
    * @param dictionaryName
    * @param volumeName
    * @return
    *     array of xslSheets for the given dictionary + global xslSheets. 
    * @exception PapillonBusinessException
    *   If there is a problem retrieving disc information.
    */
    public static XslSheet[] getApplicableXslSheets(String dictionaryName, String volumeName) 
    throws PapillonBusinessException {
        Vector xslSheets = new Vector();
        
        try {
            XslSheetQuery query = new XslSheetQuery(CurrentDBTransaction.get());
            query.setQueryDictionaryName(dictionaryName);
            query.setQueryVolumeName(volumeName);
            query.addOrderByName(true);
            XslSheetDO[] DOarray = query.getDOArray();
            for ( int i = 0; i < DOarray.length; i++ )
                xslSheets.add(new XslSheet(DOarray[i]));
            
            query.reset();
            query.setQueryDictionaryName(null);
            query.addOrderByName(true);
            DOarray = query.getDOArray();
            for ( int i = 0; i < DOarray.length; i++ )
                xslSheets.add(new XslSheet(DOarray[i]));
            
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getXslSheetsArray()", ex);
        }
        
        return (XslSheet []) xslSheets.toArray((XslSheet []) null);
    }
    
    public XslSheet getDefaultXslSheet(String dictionaryName, String volumeName) throws PapillonBusinessException {
        XslSheet theXsl = null;
        
        try {
            XslSheetQuery query = new XslSheetQuery(CurrentDBTransaction.get());
            //set query
            query.setQueryDictionaryName(dictionaryName);
            query.setQueryVolumeName(volumeName);
            query.setQueryDefaultxsl("Y");
            
            // Throw an exception if more than one query is found
            query.requireUniqueInstance();
            XslSheetDO theXslSheetDO = query.getNextDO();
            
            if (null == theXslSheetDO) {
                query.reset();
                query.setQueryDictionaryName(dictionaryName);
                query.setQueryDefaultxsl("Y");
                query.requireUniqueInstance();
                theXslSheetDO = query.getNextDO();
                if (null == theXslSheetDO) {
                    query.reset();
                    query.setQueryDefaultxsl("Y");
                    query.requireUniqueInstance();
                    theXslSheetDO = query.getNextDO();
                }
            }
            theXsl = new XslSheet(theXslSheetDO);
            if (null == theXsl) {
                // Here we should generate an exception or display an HTML message
                fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Exception in findDefaultxslsheet(): no default existing XSL sheet");
            }
            return theXsl;
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getDefaultXslSheet()", ex);
        }
        
        
    }
    
    public static String parseXslSheet(URL fileURL) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
        String result = null;
        
            try {
                Document docXml = Utility.buildDOMTree(fileURL);                
               if (null != docXml) 
                result=Utility.NodeToString(docXml);
              //  PapillonLogger.writeDebugMsg("The XSL sheet:");
              //  PapillonLogger.writeDebugMsg(result);
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
            XslSheetQuery query = new XslSheetQuery(CurrentDBTransaction.get());
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
            XslSheetQuery query = new XslSheetQuery(CurrentDBTransaction.get());
            //set query
            query.setQueryDictionaryName("");
            query.setQueryVolumeName("");
            query.setQueryDefaultxsl("Y");
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
            XslSheetQuery query = new XslSheetQuery(CurrentDBTransaction.get());
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
	
	public static void AddXslSheet(String name, String dictionaryName, String volumeName, String description,String code,boolean defaultXsl)
    throws fr.imag.clips.papillon.business.PapillonBusinessException{
        if ((name!=null) && (code!=null)) {
            //search for an existing
            XslSheetFactory XslFactory=new XslSheetFactory();
            XslSheet Existe=XslFactory.findXslSheetByName(name);
            if (Existe.isEmpty()) {
                XslSheet mySheet=new XslSheet();
                mySheet.setName(name);
				if (dictionaryName == null) {
					dictionaryName = "";
				}
                mySheet.setDictionaryName(dictionaryName);
				if (volumeName == null) {
					volumeName = "";
				}
                mySheet.setVolumeName(volumeName);
                mySheet.setDescription(description);
                mySheet.setCode(code);
                mySheet.setDefaultxsl(defaultXsl);
                mySheet.save();
                PapillonLogger.writeDebugMsg("XslSheet: " + mySheet.getName() + " is stored in the database");
            }
            else {
                PapillonLogger.writeDebugMsg("Existing XslSheet in the database");
                PapillonLogger.writeDebugMsg("Name: "+Existe.getName());
                PapillonLogger.writeDebugMsg("Description: "+Existe.getDescription());
            }
        }
        else {
            PapillonLogger.writeDebugMsg("XslSheet ignored");
        }
    }


    public static void AddAndReplaceXslSheet(String name, String dictionaryName, String volumeName, String description,String code,boolean defaultXsl)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        if ((name!=null) && (code!=null)) {
            //search for an existing
            XslSheetFactory XslFactory=new XslSheetFactory();
            XslSheet Existe=XslFactory.findXslSheetByName(name);
            if (!Existe.isEmpty()) {
                Existe.delete();
				fr.imag.clips.papillon.business.transformation.XslTransformation.resetCache();
			}
			XslSheet mySheet=new XslSheet();
			mySheet.setName(name);
			if (dictionaryName == null) {
				dictionaryName = "";
			}
            mySheet.setDictionaryName(dictionaryName);
			if (volumeName == null) {
				volumeName = "";
			}
            mySheet.setVolumeName(volumeName);
			mySheet.setDescription(description);
			mySheet.setCode(code);
			mySheet.setDefaultxsl(defaultXsl);
			mySheet.save();
            PapillonLogger.writeDebugMsg("XslSheet: " + name + " is stored in the database");
        }
        else {
            PapillonLogger.writeDebugMsg("XslSheet ignored");
        }        
    }

    public static void emptyDatabase()
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        XslSheet[]	TheXslSheets= XslSheetFactory.getXslSheetsArray();
        for ( int i = 0; i < TheXslSheets.length; i++ ) {
            TheXslSheets[i].delete();
        }
    }
	
}

