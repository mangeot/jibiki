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
 * Revision 1.7  2004/10/28 10:38:11  mangeot
 * Fixed some bugs that affected the dictd server
 * Modified some methods in order to display a text entry in the dictd server
 *
 * Revision 1.6  2004/02/10 05:27:13  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.5.2.3  2004/02/08 03:46:24  mangeot
 * bug fixes, cleaning code
 *
 * Revision 1.5.2.2  2004/02/02 07:53:52  mangeot
 * Bug fixes in encoding and UserInterface
 *
 * Revision 1.5.2.1  2004/01/20 09:07:59  mangeot
 * Lots of changes for version 2 of UIGenerator: interface description files are loaded
 * into the database.
 *
 * Revision 1.5  2003/08/14 08:30:11  mangeot
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
 * Revision 1.4  2003/03/26 04:20:50  mangeot
 * Added order in informationdocument and xslsheet queries
 *
 * Revision 1.3.2.7  2003/08/11 07:47:48  mangeot
 * bug correction while loading dicitonry entries
 *
 * Revision 1.3.2.6  2003/07/31 10:51:30  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.5  2003/07/01 07:14:54  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.4  2003/06/21 17:56:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.3  2003/05/21 10:15:08  mangeot
 * Travail sur l'interface d'edition
 *
 * Revision 1.3.2.2  2003/02/18 06:07:44  mangeot
 * Information added
 *
 * Revision 1.3.2.1  2003/02/18 03:27:53  mangeot
 * Development for the editing interface
 *
 * Revision 1.3  2003/02/06 09:35:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/01/28 08:23:01  mangeot
 * Bug fixed in ConsultExpert.java must be correcting also on Home.java
 * and added xmlSchema to volumes
 *
 * Revision 1.1.1.1  2002/10/28 16:49:13  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.15  2002/09/17 17:13:21  mangeot
 * Bouh, lots of improvements, version DEPLOY1_4 is almost ready !
 *
 * Revision 1.14  2002/09/16 13:34:21  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.13  2002/09/11 16:28:13  mangeot
 * Added classes to implement dict protocol rfc 2229
 *
 * Revision 1.12  2002/08/10 00:04:53  mangeot
 * Implemented the user contributions
 * added a new table for handling contributions
 * need to reload the sql script create_tables
 *
 * Revision 1.11.8.1  2002/08/09 09:15:13  mangeot
 * Improvements for the simple consultation
 * adding text for help,
 * correcting consultation bugs
 *
 * Revision 1.11  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.10  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.9  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.8  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.7  2002/04/17 19:18:22  mangeot
 * I deleted the form AdminXml.po and created another one:
 * AddEntries.po
 * Now you can't add entries without a metadata file associated.
 *
 * Revision 1.6  2002/04/17 17:09:23  mangeot
 * Travail sur les stylesheets
 *
 * Revision 1.5  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/04/16 02:44:03  mangeot
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
 * Revision 1.2  2002/03/27 09:51:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/03/11 11:15:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/10/17 13:02:03  serasset
 * Distinction entre Doucmuent (abstrait) et fichier (qui constituent concretement un doucument)
 *
 * Revision 1.5  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.4  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.3  2001/07/12 20:38:45  salvati
 * Added Node2String function and use of it
 *
 * Revision 1.2  2001/07/12 17:58:00  salvati
 * end of debug
 * CV: ----------------------------------------------------------------------
 *
 * Revision 1.1  2001/07/12 17:38:08  salvati
 * Renaming VolumeFactory in DictionarEntriesFactory
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.data.*;

//for URLs
import java.net.URL;
import java.net.MalformedURLException;


//pour parser le document avec le DOM
import org.w3c.dom.*;

import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;

import java.util.*;

import fr.imag.clips.papillon.business.utility.Utility;

/**
 * Used to find the instances of xslsheet.
 */
public class VolumesFactory {


        protected final static String DML_URI = "http://www-clips.imag.fr/geta/services/dml";
        protected final static String XLINK_URI = "http://www.w3.org/1999/xlink";

        protected final static String VOLUME_TAG = "volume-metadata";
        protected final static String XSLSHEET_TAG = "xsl-stylesheet";
        protected final static String XMLSCHEMA_TAG = "xmlschema-ref";
        protected final static String XMU_EDITION_TAG = "xmu-edition-ref";
        protected final static String XMU_VISUALISATION_TAG = "xmu-visualisation-ref";
        protected final static String XNF_CONCEPT_TAG = "xnf-concept-ref";
        protected final static String XNF_INTERFACE_TAG = "xnf-interface-ref";
        protected final static String TEMPLATE_ENTRY_TAG = "template-entry-ref";
        protected final static String HREF_ATTRIBUTE="href";
        protected final static String LOCATION_ATTRIBUTE="location";

		protected final static Hashtable countEntriesCache = new Hashtable(); 

    
	 public static Volume newVolume(String dictname, Element volume, URL fileURL)
            throws fr.imag.clips.papillon.business.PapillonBusinessException, java.io.IOException {
            // in this method, I ma merging, VolumesDBop and VolumesFactory methods,
            // not good, need to clarify it ! 
            // Cette méthode dépend du schéma des volumes.
            String name = volume.getAttribute("name");
            String dbname = volume.getAttribute("dbname");
            String location = volume.getAttribute(LOCATION_ATTRIBUTE);
            String source = volume.getAttribute("source-language");
            String targets = volume.getAttribute("target-languages");

            if (null == dbname || dbname.equals("")) {
                dbname = name;
            }
            
          NodeList refNodes = volume.getElementsByTagName("volume-ref");
            String href = "";
            if (null != refNodes && refNodes.getLength()>0) {
                Element tempElt = (Element)refNodes.item(0); 
                href = tempElt.getAttributeNS(XLINK_URI, "href");
                    }
                else {
                 PapillonLogger.writeDebugMsg("No volume-ref");   
                 } 

            String schema = getXmlCode(volume,XMLSCHEMA_TAG, fileURL);
            String xmuEdition = getXmlCode(volume,XMU_EDITION_TAG, fileURL);
            String xmuVisualisation = getXmlCode(volume,XMU_VISUALISATION_TAG, fileURL);
            String xnfConcept = getXmlCode(volume,XNF_CONCEPT_TAG, fileURL);
            String xnfInterface = getXmlCode(volume,XNF_INTERFACE_TAG, fileURL);
            String templateEntry = getXmlCode(volume,TEMPLATE_ENTRY_TAG, fileURL);
						
            String xmlCode=Utility.NodeToString(volume);
            return createUniqueVolume(name, dictname, dbname, location, source, targets, href, xmlCode, schema, xmuEdition, xmuVisualisation, xnfConcept, xnfInterface, templateEntry);
            } 
            
        public static Volume findVolumeByName(String name) 
        throws PapillonBusinessException {
        Volume theVolume = null;

            if (null != name && !name.equals("")) {        
        try {
            VolumeQuery query = new VolumeQuery();
            //set query
            query.setQueryName(name,QueryBuilder.CASE_INSENSITIVE_EQUAL);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            VolumeDO theVolumeDO = query.getNextDO();
            theVolume = new Volume(theVolumeDO);
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findVolumeByName()", ex);
        }
            }
            return theVolume;
    }
    
        public static Volume findVolumeByDbname(String name) 
        throws PapillonBusinessException {
        Volume theVolume = null;
        if (null != name && !name.equals("")) {
        try {
            VolumeQuery query = new VolumeQuery();
            //set query
            query.setQueryDbname(name,QueryBuilder.CASE_INSENSITIVE_EQUAL);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            VolumeDO theVolumeDO = query.getNextDO();
            theVolume = new Volume(theVolumeDO);
        }
        catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findVolumeByDbame()", ex);
        }
        }
        return theVolume;
    }
    
    	public static Volume createUniqueVolume(String name,
                                                String dictname,
                                             String dbname,
                                             String location,
                                               String source,
                                               String targets,
                                               String href,
																						 String xmlCode,
																						 String xmlSchema,
																						 String xmuEdition,
																						 String xmuVisualisation,
																						 String xnfConcept,
																						 String xnfInterface,
						String template)
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Volume myVolume = null;
	if ((name!=null) && (dictname!=null) && (dbname!=null)
            && (source!=null) && (href!=null) && (xmlCode!=null)) 
		{
		//search for an existing dictionary
		Volume Existe=VolumesFactory.findVolumeByName(name);
		if (Existe.IsEmpty())
			{//does'nt exist, create :
					myVolume=new Volume();
                                        myVolume.setName(name);
                                        myVolume.setDictname(dictname);
                                        myVolume.setDbname(dbname);
                                        myVolume.setLocation(location);
                                        myVolume.setSourceLanguage(source);
                                        myVolume.setTargetLanguages(targets);
                                        myVolume.setVolumeRef(href);
                                        myVolume.setXmlCode(xmlCode);
                                        myVolume.setXmlSchema(xmlSchema);
                                        myVolume.setXmuEdition(xmuEdition);
                                        myVolume.setXmuVisualisation(xmuVisualisation);
                                        myVolume.setXnfConcept(xnfConcept);
                                        myVolume.setXnfInterface(xnfInterface);
                                        myVolume.setTemplateEntry(template);
			}else
			{PapillonLogger.writeDebugMsg("Volume already in the Database");
			}
		}
                return myVolume;	
	}
        
        public static Volume parseVolumeMetadata (Dictionary dict, URL fileURL, String parseEntries) 
            throws fr.imag.clips.papillon.business.PapillonBusinessException {
        
            Volume resVolume = null;
        
            try {
                Document docXml = Utility.buildDOMTree(fileURL);
                PapillonLogger.writeDebugMsg("The xml code:");
                PapillonLogger.writeDebugMsg(Utility.NodeToString(docXml));
                
		//on recupere le dictionnaire
		Element volume;		
  		volume=(Element)docXml.getElementsByTagName(VOLUME_TAG).item(0);
  		
		// ajout du dico ds la table.
                resVolume = VolumesFactory.newVolume(dict.getName(), volume, fileURL);
                if (null != resVolume) {
                    resVolume.save();
                    
                     Element stylesheet =(Element)docXml.getElementsByTagName(XSLSHEET_TAG).item(0);

                   if (null != stylesheet) {
                        String ref = stylesheet.getAttributeNS(XLINK_URI,HREF_ATTRIBUTE);
                        URL resultURL = new URL(fileURL,ref);
                        String xslString = fr.imag.clips.papillon.business.xsl.XslSheetFactory.parseXslSheet(resultURL);
                        fr.imag.clips.papillon.business.xsl.XslSheetDBop.AddXslSheet(resVolume.getName(),null,xslString,false);
                        }
                    
                    if (null != parseEntries && resVolume.getLocation().equals(Volume.LOCAL_LOCATION)) {
                        VolumeEntriesFactory.createVolumeTables(resVolume);
                        URL resultURL = new URL(fileURL,resVolume.getVolumeRef());
												VolumeEntriesFactory.parseVolume(dict, resVolume, resultURL.toString());
                    }
                }
                }
               catch(Exception ex) {
                    throw new PapillonBusinessException("Exception in parseVolumeMetadata()", ex);
                }
                return resVolume;
            }
    
    public static Volume findVolumeByID(String id) 
        throws PapillonBusinessException {
        Volume theVolume = null;
        VolumeDO theVolumeDO = null;
        
        try {
           VolumeQuery query = new VolumeQuery();  
             //set query
            query.setQueryOId(new ObjectId(id));
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            theVolumeDO = query.getNextDO();
        theVolume = new Volume(theVolumeDO);
        return theVolume;
        
        }
        catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findVolumeByID()", ex);
        }
    }

	 public static Volume[] getVolumesArray()
		 throws PapillonBusinessException {
			 return getVolumesArray(null, null, null);
		 }

	 public static Volume[] getVolumesArray(String dictName)
		 throws PapillonBusinessException {
			 return getVolumesArray(dictName, null, null);
		 }

	 
    public static Volume[] getVolumesArray(String dictname, String source, String target) 
        throws PapillonBusinessException {
        Volume[] theDictArray = null;
        
        try {
            VolumeQuery query = new VolumeQuery();            
            if ((null != dictname) && (!dictname.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("dictname", dictname, 
                    QueryBuilder.EQUAL);
            }
            if ((null != source) && (!source.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("sourceLanguage", source, 
                    QueryBuilder.EQUAL);
            }
            if ((null != target) && (!dictname.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("targetLanguages", target, 
                    QueryBuilder.CASE_SENSITIVE_CONTAINS);
            }
            query.addOrderByName(true);  
            VolumeDO[] DOarray = query.getDOArray();
            theDictArray = new Volume[ DOarray.length ];
            for ( int i = 0; i < DOarray.length; i++ )
	    	theDictArray[i] = new Volume(DOarray[i]);

        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getVolumesArray()", ex);
        }
         
        return theDictArray;
    }

	 public static String countEntries(Volume myVolume)
		 throws fr.imag.clips.papillon.business.PapillonBusinessException {
			 String result = "-1";
			 if (countEntriesCache.containsKey(myVolume.getName())) {
				 result = (String) countEntriesCache.get(myVolume.getName());
			 }
			 else {
				 result = String.valueOf(myVolume.countEntries());
				 countEntriesCache.put(myVolume.getName(),result);
			 }
			 return result;
		 }


	 public static int intCountEntries(Volume myVolume)
		 throws fr.imag.clips.papillon.business.PapillonBusinessException {
			 return Integer.parseInt(countEntries(myVolume));
		 }

	 public static void setCountEntries(Volume myVolume)
		 throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			 setCountEntries(myVolume.getName(),String.valueOf(myVolume.countEntries()));
		 }

	 public static void resetCountEntries(String myVolumeName)
		 throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			 setCountEntries(myVolumeName,"0");
		 }

	 protected static void setCountEntries(String myVolumeName, String entries)
		 throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			 countEntriesCache.put(myVolumeName,entries);
		 }

	 public static void deleteCountEntries(String myVolumeName)
		 throws fr.imag.clips.papillon.business.PapillonBusinessException  {
			 countEntriesCache.remove(myVolumeName);
		 }

	 public static void resetCountEntriesCache()
		 throws fr.imag.clips.papillon.business.PapillonBusinessException {
		 Volume[] Volumes = getVolumesArray();
		 for (int i=0;i<Volumes.length;i++) {
			 setCountEntries(Volumes[i]);
		 }
	 }
	 
	 protected static String getXmlCode(Element myDOMElement, String tag, URL fileURL) throws PapillonBusinessException {
		String res = "";
		String href ="";
		try {
		NodeList refNodes = myDOMElement.getElementsByTagName(tag);
		if (null != refNodes && refNodes.getLength()>0) {
			Element tempElt = (Element)refNodes.item(0);
			href = tempElt.getAttributeNS(XLINK_URI, "href");
			if (href!=null && !href.equals("")) {
				URL resultURL = new URL(fileURL,href);
				PapillonLogger.writeDebugMsg("getXmlCode with URL: " + resultURL.toString());
				res = Utility.NodeToString(Utility.buildDOMTree(resultURL));
			}
		}
		else {
				PapillonLogger.writeDebugMsg("No " + tag);
		}
		}
		catch (MalformedURLException ex) {
			throw new PapillonBusinessException("Error in getXmlCode with the href " + href,ex);
		}
		return res;
	 }

}

