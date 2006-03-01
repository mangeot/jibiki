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
 * Revision 1.12  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 * Revision 1.11  2006/02/26 14:04:56  mangeot
 * Corrected a bug: the content was a static variable, thus there were problems when two users wanted to aces the same page at the same time
 *
 * Revision 1.10  2005/12/01 15:34:28  mangeot
 * MM: I solved the problem of already created tables by creating an sql query for retrieving the table names. If the name already exists, VolumeEntriesFactory.createVolumeTables do not create the tables.
 * It allows the administrator to delete and reload only the metadata files without dropping the whole data.
 * The method is ManageDatabase.getTableNames() and it returns a vector with all the table names created by the database user (usually "papillon").
 *
 * Revision 1.9  2005/11/22 13:21:02  mangeot
 * I moved the VolumeEntriesFactory.createVolumeTables out of the database transactions in AdminDictionaries.java and Adminvolumes.java because otherwise, it is not possible to reload metadata when the data tables already exist (in this case, the transaction does not commit).
 *
 * Revision 1.8  2005/11/14 21:46:26  mangeot
 * *** empty log message ***
 *
 * Revision 1.7.4.2  2005/12/08 13:03:37  fbrunet
 * Add transformation interface to volume administration
 *
 * Revision 1.7.4.1  2005/12/02 10:04:09  fbrunet
 * Add Pre/Post edition processing
 * Add index reconstruction
 * Add new query request
 * Add fuzzy search
 * Add new contribution administration
 * Add xsl transformation volume
 *
 * Revision 1.7  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.6  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.5.4.7  2005/06/09 11:28:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.5.4.6  2005/06/09 11:07:45  mangeot
 * Deleted the countEntriesCache. entries counts are not cached any more.
 * Fixed a few bugs.
 *
 * Revision 1.5.4.5  2005/06/02 09:13:50  mangeot
 * *** empty log message ***
 *
 * Revision 1.5.4.4  2005/06/01 15:20:33  mangeot
 * Added a boolean for contributionslog
 *
 * Revision 1.5.4.3  2005/06/01 08:38:43  mangeot
 * Multi bug correction + added the possibility of disabling data edition
 * via the Admin.po page
 *
 * Revision 1.5.4.2  2005/05/19 17:02:22  mangeot
 * Importing entries without the contribution element
 *
 * Revision 1.5.4.1  2005/04/29 14:50:25  mangeot
 * New version with contribution infos embedded in the XML of the entries
 *
 * Revision 1.5  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.4  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
 *
 * Revision 1.3.2.2  2005/03/31 09:10:31  mangeot
 * (re) added the code for loading the volume metadata only
 *
 * Revision 1.3.2.1  2005/01/28 19:45:55  mangeot
 * First version that runs basically.
 * Should compile after an ant clean.
 * XPath loading and virtual volumes for terminological lexicons are OK.
 * Bugs remain, needs more testings like the editor for example.
 *
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *-----------------------------------------------
 * Papillon Admin Volumes page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import fr.imag.clips.papillon.business.message.MessageDBLoader;

//import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;

// For URLs
import java.net.URL;


import fr.imag.clips.papillon.CurrentDBTransaction;
import com.lutris.appserver.server.sql.DBTransaction;

//pour les dictionary
import fr.imag.clips.papillon.business.dictionary.*;

// import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.edition.GenerateTemplate;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;


public class AdminVolumes extends PapillonBasePO {

    protected final static String SEE_METADATA_PARAMETER="SeeMetadata";
    protected final static String SEE_SCHEMA_PARAMETER="SeeSchema";
    protected final static String SEE_TEMPLATE_PARAMETER="SeeTemplate";
    protected final static String SEE_INTERFACE_PARAMETER="SeeInterface";
    protected final static String GENERATE_INTERFACE_PARAMETER="GenerateItf";
    protected final static String REMOVE_METADATA_PARAMETER="RemoveMetadata";
    protected final static String REMOVE_ALL_PARAMETER="RemoveAll";
    protected final static String FLUSH_PARAMETER="Flush";
		
	protected final static String Object_Metadata="Metadata";
	protected final static String Object_Schema="Schema";
	protected final static String Object_Template="Template";
	protected final static String Object_Interface="Interface";
        
    protected final static String URL_PARAMETER="url";
    protected final static String DICTIONARY_PARAMETER="DICTIONARY";

    protected final static String ADD_PARAMETER="Add";
    protected final static String ADD_ENTRIES_PARAMETER="AddEntries";

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean userMayUseThisPO() {
        try {
            return this.getUser().isAdmin();
        } catch (PapillonBusinessException ex) {
            this.getSessionData().writeUserMessage("Error getting the authorisation to use this PO.");
        }
        return false;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws javax.xml.parsers.ParserConfigurationException,
			HttpPresentationException,
		    IOException, org.xml.sax.SAXException,
			javax.xml.transform.TransformerException,
			java.sql.SQLException
    {
        
        // Création du contenu
        AdminVolumesXHTML content = (AdminVolumesXHTML)MultilingualXHtmlTemplateFactory.createTemplate("AdminVolumesXHTML", this.getComms(), this.getSessionData());
		  
        HttpPresentationRequest req = this.getComms().request;
				String dictName = myGetParameter(AdminVolumesXHTML.NAME_Dictionary);
				String volName = myGetParameter(AdminVolumesXHTML.NAME_Volume);
                String volNameTransformation = myGetParameter(AdminVolumesXHTML.NAME_VolumeTransformation);
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            //TEMPORAIRE :avec l URL
            //AJOUT DE DICO
            String userMessage = null;
            String urlString = myGetParameter(AdminVolumesXHTML.NAME_URL);
            if (null != urlString &&
				null != myGetParameter(AdminVolumesXHTML.NAME_Dictionary)) {
                    userMessage = handleVolumeAddition(req);
                }
             else if (null != myGetParameter(AdminVolumesXHTML.NAME_Volume) &&
					null != myGetParameter(AdminVolumesXHTML.NAME_URLObject) &&
					null != myGetParameter(AdminVolumesXHTML.NAME_Object)) {
					String object = myGetParameter(AdminVolumesXHTML.NAME_Object);
					String url = myGetParameter(AdminVolumesXHTML.NAME_URLObject);
					userMessage = this.uploadObject(volName, object, url);
            
            } else if (null != myGetParameter(content.NAME_VolumeTransformation) &&
                       null != myGetParameter(content.NAME_URLObjectTransformation)) {
                String url = myGetParameter(content.NAME_URLObjectTransformation);
                userMessage = this.launchTranformation(volNameTransformation, url);
            
            } else if (null != myGetParameter(REMOVE_METADATA_PARAMETER)) {
                String handle = myGetParameter(REMOVE_METADATA_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                volume.delete();
                userMessage = "Volume " + volume.getName() + " metadata  erased...";	
            } else if (null != myGetParameter(REMOVE_ALL_PARAMETER)) {
                String handle = myGetParameter(REMOVE_ALL_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                if (null != volume && !volume.isEmpty()) {
                    volume.deleteAll();
                    userMessage = "Volume " + volume.getName() + " entries and metadata  erased...";                    
                }
            }
            else if (null != myGetParameter(SEE_METADATA_PARAMETER)) {
                String handle = myGetParameter(SEE_METADATA_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(content, volume.getXmlCode());
            }
            else if (null != myGetParameter(SEE_SCHEMA_PARAMETER)) {
                String handle = myGetParameter(SEE_SCHEMA_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(content, volume.getXmlSchema());
            } else if (null != myGetParameter(SEE_TEMPLATE_PARAMETER)) {
                String handle = myGetParameter(SEE_TEMPLATE_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(content, volume.getTemplateEntry());
            } else if (null != myGetParameter(SEE_INTERFACE_PARAMETER)) {
                String handle = myGetParameter(SEE_INTERFACE_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(content, volume.getTemplateInterface());
            } else if (null != myGetParameter(GENERATE_INTERFACE_PARAMETER)) {
                String handle = myGetParameter(GENERATE_INTERFACE_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                // generating an XNF interface description
				GenerateTemplate.generateInterfaceTemplate(volume);
            }
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
        }
        
        //adding the consult form
        addConsultForm(content, dictName, volName, volNameTransformation);
        
        //adding the content of the volumes table
        addVolumesArray(content);
        
        //On rend le contenu correct
        return content.getElementFormulaire();
    }
    
	protected String handleVolumeAddition(HttpPresentationRequest req) throws PapillonBusinessException, HttpPresentationException, java.net.MalformedURLException {
        String userMessage;
        String urlString = req.getParameter(AdminVolumesXHTML.NAME_URL);
        URL myURL = new URL(urlString);
        PapillonLogger.writeDebugMsg(myURL.toString());
		String logContribsString = req.getParameter(AdminVolumesXHTML.NAME_LogContributions);
		boolean logContribs = (logContribsString!=null && !logContribsString.equals(""));
		String parseEntriesString = req.getParameter(AdminVolumesXHTML.NAME_AddVolumesAndEntries);
		boolean parseEntries = (parseEntriesString!=null && !parseEntriesString.equals(""));
        
        // Create and Register the transaction
        CurrentDBTransaction.registerNewDBTransaction();
		Volume myVolume = null;
        try {
			Dictionary dict = DictionariesFactory.findDictionaryByName(req.getParameter(AdminVolumesXHTML.NAME_Dictionary));
			myVolume = VolumesFactory.parseVolumeMetadata(dict, myURL, parseEntries, logContribs);

            if (null != myVolume && !myVolume.isEmpty()) {
				userMessage = "adding " + myVolume.getName() + " volume" + " // " + myVolume.getDictname() + " // "  + myVolume.getDbname() + " // " + myVolume.getSourceLanguage() + " // " + myVolume.getTargetLanguages() + " // " + myVolume.getVolumeRef();
				myVolume.save();
				fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
            } else {
                userMessage = "Ignoring volume";
            }
            // everything was correct, commit the transaction...
            ((DBTransaction) CurrentDBTransaction.get()).commit();
        } catch (Exception e) {
            userMessage = "Problems while adding the specified volume.\n";
            userMessage = userMessage + e.getMessage();
            userMessage = userMessage + "\nAll changes to the database have been rolled back.";
			e.printStackTrace();
            try {
                ((DBTransaction) CurrentDBTransaction.get()).rollback();
            } catch (java.sql.SQLException sqle) {
                PapillonLogger.writeDebugMsg("AdminVolumes: SQLException while rolling back failed transaction.");
				sqle.printStackTrace();
            }
        } finally {
            CurrentDBTransaction.releaseCurrentDBTransaction();
        }
		return userMessage;
    }

	
    protected void addVolumesArray(AdminVolumesXHTML content) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            
        Volume[] VolumesTable=VolumesFactory.getVolumesArray();
        //where we must insert the form
        HTMLTableRowElement theRow = content.getElementTemplateRow();
        HTMLElement theDictname = content.getElementDictname();
        HTMLElement theName = content.getElementName();
        HTMLElement theDbname = content.getElementDbname();
        HTMLElement theSource = content.getElementSource();
        HTMLElement theEntries = content.getElementEntries();
        HTMLAnchorElement theSeeMetadataAnchor = content.getElementSeeMetadataAnchor();
        HTMLAnchorElement theSeeSchemaAnchor = content.getElementSeeSchemaAnchor();
		HTMLElement theSeeSchema = content.getElementSeeSchema();
		HTMLAnchorElement theSeeTemplateAnchor = content.getElementSeeTemplateAnchor();
        HTMLAnchorElement theSeeInterfaceAnchor = content.getElementSeeInterfaceAnchor();
        HTMLAnchorElement theRemoveMetadataAnchor = content.getElementRemoveMetadataAnchor();
        HTMLAnchorElement theRemoveAllAnchor = content.getElementRemoveAllAnchor();

        Node theRowParent = theRow.getParentNode();
				
				theRow.removeAttribute("id");
        theDictname.removeAttribute("id");
        theName.removeAttribute("id");
        theDbname.removeAttribute("id");
        theSource.removeAttribute("id");
        theEntries.removeAttribute("id");
        theSeeMetadataAnchor.removeAttribute("id");
				
        theSeeSchemaAnchor.removeAttribute("id");
        content.getElementSeeSchema().removeAttribute("id");
        
		theSeeTemplateAnchor.removeAttribute("id");
        content.getElementSeeTemplate().removeAttribute("id");
       
		 theSeeInterfaceAnchor.removeAttribute("id");
        content.getElementSeeInterface().removeAttribute("id");

        theRemoveMetadataAnchor.removeAttribute("id");
        theRemoveAllAnchor.removeAttribute("id");

        //adding the volumes description
	for ( int i = 0; i < VolumesTable.length; i++ ) {
        content.setTextDictname(VolumesTable[i].getDictname());
        content.setTextName(VolumesTable[i].getName());
        content.setTextDbname(VolumesTable[i].getDbname());
        content.setTextSource(VolumesTable[i].getSourceLanguage());
        content.setTextEntries("" + VolumesTable[i].getCount());
            
				String handle =  VolumesTable[i].getHandle();
        theSeeMetadataAnchor.setHref(this.getUrl() + "?" + SEE_METADATA_PARAMETER + "=" + handle);
				
				String schema = VolumesTable[i].getXmlSchema();
				content.setTextSeeSchema("");
				if (schema !=null && !schema.equals("")) {
					content.setTextSeeSchema("See");
					theSeeSchemaAnchor.setHref(this.getUrl() + "?" + SEE_SCHEMA_PARAMETER + "=" + handle);
				}

				String object = VolumesTable[i].getTemplateEntry();
				content.setTextSeeTemplate("");
				if (object !=null && !object.equals("")) {
					content.setTextSeeTemplate("See");
					theSeeTemplateAnchor.setHref(this.getUrl() + "?" + SEE_TEMPLATE_PARAMETER + "=" + handle);
				}
				
				object = VolumesTable[i].getTemplateInterface();
				content.setTextSeeInterface("");
				if (object !=null && !object.equals("")) {
					content.setTextSeeInterface("See");
					theSeeInterfaceAnchor.setHref(this.getUrl() + "?" + SEE_INTERFACE_PARAMETER + "=" + handle);
				}
				else if (schema !=null && !schema.equals("")) {
					content.setTextSeeInterface("Generate");
					theSeeInterfaceAnchor.setHref(this.getUrl() + "?" + GENERATE_INTERFACE_PARAMETER + "=" + handle);
				}
								
        theRemoveMetadataAnchor.setHref(this.getUrl() + "?" + REMOVE_METADATA_PARAMETER + "=" + handle);
        theRemoveAllAnchor.setHref(this.getUrl() + "?" + REMOVE_ALL_PARAMETER + "=" + handle);
            
        theRowParent.appendChild(theRow.cloneNode(true));
				
				
        }
        
        theRowParent.removeChild(theRow);
    }
    
    protected void addXml(AdminVolumesXHTML content, String xmlString) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            
        Node xmlNode = XslTransformation.applyXslSheetForXml(xmlString);    
            
        //where we must insert the xml
        HTMLElement theXml = content.getElementXml();

        Node theXmlParent = theXml.getParentNode();

        theXmlParent.appendChild(content.importNode(xmlNode,true));
        theXmlParent.removeChild(theXml);
    }
    
     protected void addConsultForm(AdminVolumesXHTML content, String selectedDict, String selectedVolume, String selectedVolumeTransformation) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException, 
                HttpPresentationException {
           // Adding the appropriate source languages to the source list
        HTMLOptionElement dictionaryOptionTemplate = content.getElementDictionaryOptionTemplate();
        Node dictionarySelect = dictionaryOptionTemplate.getParentNode();
        dictionaryOptionTemplate.removeAttribute("id");
        // We assume that the option element has only one text child 
        // (it should be this way if the HTML is valid...)
        Text dictionaryTextTemplate = (Text)dictionaryOptionTemplate.getFirstChild(); 
                
                
        Dictionary[] AllDictionaries = DictionariesFactory.getDictionariesArray();
                
        for (int i = 0; i < AllDictionaries.length; i++) {   
	    String dictName = AllDictionaries[i].getName();
            dictionaryOptionTemplate.setValue(dictName);
            dictionaryOptionTemplate.setLabel(dictName);
            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux 
            // specs W3C.
            dictionaryTextTemplate.setData(dictName);
			dictionaryOptionTemplate.setSelected(dictName.equals(selectedDict));

            dictionarySelect.appendChild(dictionaryOptionTemplate.cloneNode(true));            
        }
        dictionarySelect.removeChild(dictionaryOptionTemplate);
				
        // Adding the appropriate source languages to the source lists
        HTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
        HTMLOptionElement volumeOptionTemplateTransformation = content.getElementVolumeOptionTemplateTransformation();
        Node volumeSelect = volumeOptionTemplate.getParentNode();
        Node volumeSelectTransformation = volumeOptionTemplateTransformation.getParentNode();
        volumeOptionTemplate.removeAttribute("id");
        volumeOptionTemplateTransformation.removeAttribute("id");
        // We assume that the option element has only one text child 
        // (it should be this way if the HTML is valid...)
        Text volumeTextTemplate = (Text)volumeOptionTemplate.getFirstChild();
        Text volumeTextTemplateTransformation = (Text)volumeOptionTemplateTransformation.getFirstChild();
                
        Volume[] AllVolumes = VolumesFactory.getVolumesArray();
                
        for (int i = 0; i < AllVolumes.length; i++) {
            String volumeName = AllVolumes[i].getName();
            
            //
            volumeOptionTemplate.setValue(volumeName);
            volumeOptionTemplate.setLabel(volumeName);
            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux 
            // specs W3C.
            volumeTextTemplate.setData(volumeName);
            volumeOptionTemplate.setSelected(volumeName.equals(selectedVolume));
            volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
            
            //
            volumeOptionTemplateTransformation.setValue(volumeName);
            volumeOptionTemplateTransformation.setLabel(volumeName);
            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux 
            // specs W3C.
            volumeTextTemplateTransformation.setData(volumeName);
            if ( (selectedVolumeTransformation != null) && (!selectedVolumeTransformation.equals("")) ) {
                volumeOptionTemplateTransformation.setSelected(volumeName.equals(selectedVolumeTransformation));
            }
            volumeSelectTransformation.appendChild(volumeOptionTemplateTransformation.cloneNode(true));
        }
        volumeSelect.removeChild(volumeOptionTemplate);
        volumeSelectTransformation.removeChild(volumeOptionTemplateTransformation);
    }

	protected String uploadObject(String volName, String object, String url) throws PapillonBusinessException {
		PapillonLogger.writeDebugMsg("uploadObject volName: " + volName);
		Volume myVolume = VolumesFactory.findVolumeByName(volName);
		String result = "Nothing uploaded";
		if (myVolume!=null && !myVolume.isEmpty()) {
			if (object !=null && !object.equals("")) {
				String objectResult = Utility.NodeToString(Utility.buildDOMTreeFromUrl(url));
				result= object + " reloaded";
				if (object.equals(Object_Schema)) {
					myVolume.setXmlSchema(objectResult);
				}
				else if (object.equals(Object_Metadata)) {
					myVolume.setXmlCode(objectResult);
					myVolume.setCdmElements();
				}
				else if (object.equals(Object_Template)) {
					objectResult = VolumesFactory.updateTemplateEntry(objectResult, myVolume.getCdmElements());
					PapillonLogger.writeDebugMsg("uploadObject objectResult: " + objectResult);
					myVolume.setTemplateEntry(objectResult);
					myVolume.setCdmElements();
				}
				else if (object.equals(Object_Interface)) {
					myVolume.setTemplateInterface(objectResult);
                }
				else {
						result = "Nothing uploaded";
				}
				fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
				myVolume.save();
			}
		}
		return result;
	}
    
    //
    protected String launchTranformation(String volName, String url) throws PapillonBusinessException {
		String result = "Nothing uploaded";
        String objectResult = Utility.NodeToString(Utility.buildDOMTreeFromUrl(url));
        
        //
        if ( (volName != null) && volName.equals("All") ) {
            
            //
            Volume[] AllVolumes = VolumesFactory.getVolumesArray();
            for (int i = 0; i < AllVolumes.length; i++) {
                PapillonLogger.writeDebugMsg("Transformation " + AllVolumes[i].getName() + " volume");
                AllVolumes[i].launchTransformation(objectResult, this.getUser());
            }
            result = "Transform all volumes";
        
        } else {
            //
            Volume myVolume = VolumesFactory.findVolumeByName(volName);
            
            //
            if (myVolume!=null && !myVolume.isEmpty()) {
                PapillonLogger.writeDebugMsg("Transformation " + myVolume.getName() + " volume");
                myVolume.launchTransformation(objectResult, this.getUser());
                result = "Transform " + myVolume.getName() + " volume";
            } else {
                result = "Empty volume";
            }        
        }
        //
		return result;
	}
    
}
