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
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.9  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.8  2004/09/21 14:35:42  mangeot
 * Adding resetCache
 *
 * Revision 1.7  2004/09/18 17:26:20  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2004/03/11 13:39:06  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2004/02/10 05:27:15  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.4.2.6  2004/02/09 05:45:18  mangeot
 * *** empty log message ***
 *
 * Revision 1.4.2.5  2004/02/08 03:46:25  mangeot
 * bug fixes, cleaning code
 *
 * Revision 1.4.2.4  2004/02/02 07:53:53  mangeot
 * Bug fixes in encoding and UserInterface
 *
 * Revision 1.4.2.3  2004/01/22 08:48:49  mangeot
 * Bug fix uploading XNF interface
 *
 * Revision 1.4.2.2  2004/01/20 09:17:26  mangeot
 * Bug fix in getXmlcodeWithDefaultEncoding
 *
 * Revision 1.4.2.1  2004/01/20 09:08:00  mangeot
 * Lots of changes for version 2 of UIGenerator: interface description files are loaded
 * into the database.
 *
 * Revision 1.4  2003/09/02 13:09:19  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/08/21 10:47:06  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/08/14 08:30:16  mangeot
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
 * Revision 1.1.1.1.2.6  2003/08/11 10:24:51  mangeot
 * Debugging ...
 *
 * Revision 1.1.1.1.2.5  2003/07/31 10:51:31  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.4  2003/07/01 07:14:54  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.3  2003/06/21 17:56:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.1.1.2.2  2003/05/28 09:17:21  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1.2.1  2003/02/18 06:07:44  mangeot
 * Information added
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.16  2002/10/25 14:10:34  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.15.2.2  2002/10/10 07:15:50  mangeot
 * put the new funciton countEntries in Volume.java
 *
 * Revision 1.15.2.1  2002/10/10 06:46:52  mangeot
 * Corrected a bug pb between lang and DocLang in consultInformations
 * Created a new sql function to count the number of entries for the volumes
 * added in Adminvolumes.java and dictd.show server
 *
 * Revision 1.15  2002/09/16 13:34:22  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.14.2.1  2002/08/02 08:25:10  mangeot
 * Replaced PAGENAME variable by this.getUrl() method
 *
 * Revision 1.14  2002/07/26 10:00:22  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.13.6.1  2002/07/12 13:50:43  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.13  2002/05/23 16:14:41  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.12  2002/05/22 08:56:18  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.11  2002/05/10 16:43:19  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.10  2002/05/09 08:20:04  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.8  2002/05/09 06:00:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.7  2002/04/18 11:42:35  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.6  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.5  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/04/16 04:57:23  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/04/16 02:44:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/04/14 09:48:31  mangeot
 * *** empty log message ***
 *
 *-----------------------------------------------
 * Papillon Admin page.
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


//pour les dictionary
import fr.imag.clips.papillon.business.dictionary.*;

// import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.edition.GenerateTemplate;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.xmlschema.UserInterface;
import fr.imag.clips.papillon.business.xmlschema.XmlSchemaFactory;

import fr.imag.clips.papillon.presentation.html.orig.*;


public class AdminVolumes extends BasePO {

    protected final static String SEE_METADATA_PARAMETER="SeeMetadata";
    protected final static String SEE_SCHEMA_PARAMETER="SeeSchema";
    protected final static String SEE_TEMPLATE_PARAMETER="SeeTemplate";
    protected final static String SEE_XMU_EDIT_PARAMETER="SeeXmuEdit";
    protected final static String SEE_XMU_VIEW_PARAMETER="SeeXmuView";
    protected final static String SEE_XNF_CONCEPT_PARAMETER="SeeXnfConcept";
    protected final static String SEE_XNF_INTERFACE_PARAMETER="SeeXnfInterface";
    protected final static String GENERATE_XNF_PARAMETER="GenerateXnf";
    protected final static String GENERATE_XMU_PARAMETER="GenerateXmu";
    protected final static String REMOVE_METADATA_PARAMETER="RemoveMetadata";
    protected final static String REMOVE_ALL_PARAMETER="RemoveAll";
    protected final static String FLUSH_PARAMETER="Flush";
		
		protected final static String Object_Metadata="Metadata";
		protected final static String Object_Schema="Schema";
		protected final static String Object_Template="Template";
		protected final static String Object_XmuEdit="XmuEdit";
		protected final static String Object_XmuView="XmuView";
		protected final static String Object_XnfConcept="XnfConcept";
		protected final static String Object_XnfInterface="XnfInterface";

    
    protected final static String URL_PARAMETER="url";
    protected final static String DICTIONARY_PARAMETER="DICTIONARY";

    protected final static String ADD_PARAMETER="Add";
    protected final static String ADD_ENTRIES_PARAMETER="AddEntries";

    
    protected static AdminVolumesHTML content;


    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean adminUserRequired() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }

    public Node getContent()
        throws javax.xml.parsers.ParserConfigurationException,
                    HttpPresentationException,
		   IOException, org.xml.sax.SAXException,
                   javax.xml.transform.TransformerException
    {
        
        // Création du contenu
        content = (AdminVolumesHTML)MultilingualHtmlTemplateFactory.createTemplate("AdminVolumesHTML", this.getComms(), this.getSessionData());
		  
        HttpPresentationRequest req = this.getComms().request;
				String dictName = myGetParameter(content.NAME_Dictionary);
				String volName = myGetParameter(content.NAME_Volume);
        // If the page is called with parameters, take the requested action
        if (req.getParameterNames().hasMoreElements()) {
            //TEMPORAIRE :avec l URL
            //AJOUT DE DICO
            String userMessage = null;
						String urlString = myGetParameter(content.NAME_URL);
            if (null != urlString &&
								null != myGetParameter(content.NAME_Dictionary)) {
								URL myURL = new URL(urlString);
                PapillonLogger.writeDebugMsg(req.getParameter(myURL.toString()));
								Dictionary dict = DictionariesFactory.findDictionaryByName(dictName);
                Volume myVolume = VolumesFactory.parseVolumeMetadata(dict, myURL,req.getParameter(content.NAME_AddEntries));
                if (null != myVolume && !myVolume.IsEmpty()) {
                        userMessage = "adding "+ myVolume.getName() + " volume" + " // " + myVolume.getDictname() + " // "  + myVolume.getDbname() + " // " + myVolume.getSourceLanguage() + " // " + myVolume.getTargetLanguages() + " // " + myVolume.getVolumeRef();
						UserInterface.resetCache();
						fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
                    }
                else {
                    userMessage = "Ignoring volume";
                    }
                }
             else if (null != myGetParameter(content.NAME_Volume) &&
									null != myGetParameter(content.NAME_URLObject) &&
									null != myGetParameter(content.NAME_Object)) {
									String object = myGetParameter(content.NAME_Object);
									String url = myGetParameter(content.NAME_URLObject);
									userMessage = this.uploadObject(volName, object, url);
            } 
             else if (null != myGetParameter(REMOVE_METADATA_PARAMETER)) {
                String handle = myGetParameter(REMOVE_METADATA_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                volume.delete();
                userMessage = "Volume " + volume.getName() + " metadata  erased...";	
            } 
             else if (null != myGetParameter(REMOVE_ALL_PARAMETER)) {
                String handle = myGetParameter(REMOVE_ALL_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                if (null != volume && !volume.IsEmpty()) {
                    volume.deleteAll();
                    userMessage = "Volume " + volume.getName() + " entries and metadata  erased...";                    
                }
            }
            else if (null != myGetParameter(SEE_METADATA_PARAMETER)) {
                String handle = myGetParameter(SEE_METADATA_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(volume.getXmlCode());
            }
            else if (null != myGetParameter(SEE_SCHEMA_PARAMETER)) {
                String handle = myGetParameter(SEE_SCHEMA_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(volume.getXmlSchema());
            }
            else if (null != myGetParameter(SEE_TEMPLATE_PARAMETER)) {
                String handle = myGetParameter(SEE_TEMPLATE_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(volume.getTemplateEntry());
            }
            else if (null != myGetParameter(SEE_XMU_EDIT_PARAMETER)) {
                String handle = myGetParameter(SEE_XMU_EDIT_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(volume.getXmuEdition());
            }
            else if (null != myGetParameter(SEE_XMU_VIEW_PARAMETER)) {
                String handle = myGetParameter(SEE_XMU_VIEW_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(volume.getXmuVisualisation());
            }
            else if (null != myGetParameter(GENERATE_XMU_PARAMETER)) {
                String handle = myGetParameter(GENERATE_XMU_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                // generating an XNF interface description
				GenerateTemplate.generateInterfaceTemplate(volume);
            }
            else if (null != myGetParameter(SEE_XNF_CONCEPT_PARAMETER)) {
                String handle = myGetParameter(SEE_XNF_CONCEPT_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(volume.getXnfConcept());
            }
            else if (null != myGetParameter(SEE_XNF_INTERFACE_PARAMETER)) {
                String handle = myGetParameter(SEE_XNF_INTERFACE_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                //adding an XML file
                addXml(volume.getXnfInterface());
            }
            else if (null != myGetParameter(GENERATE_XNF_PARAMETER)) {
                String handle = myGetParameter(GENERATE_XNF_PARAMETER);
                Volume volume = VolumesFactory.findVolumeByID(handle);
                // generating an XNF interface description
				XmlSchemaFactory.generateXnf(volume);
				volume.save();
            }
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
        }
        
        //adding the consult form
        addConsultForm(dictName, volName);
        
        //adding the content of the volumes table
        addVolumesArray();
        
        
        //On rend le contenu correct
        return content.getElementFormulaire();
    }
    
    protected void addVolumesArray() 
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
        HTMLAnchorElement theSeeXmuEditAnchor = content.getElementSeeXmuEditAnchor();
        HTMLAnchorElement theSeeXmuViewAnchor = content.getElementSeeXmuViewAnchor();
        HTMLAnchorElement theSeeXnfConceptAnchor = content.getElementSeeXnfConceptAnchor();
        HTMLAnchorElement theSeeXnfInterfaceAnchor = content.getElementSeeXnfInterfaceAnchor();
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
        theSeeXmuEditAnchor.removeAttribute("id");
        content.getElementSeeXmuEdit().removeAttribute("id");
        theSeeXmuViewAnchor.removeAttribute("id");
        content.getElementSeeXmuView().removeAttribute("id");
				theSeeXnfConceptAnchor.removeAttribute("id");
        content.getElementSeeXnfConcept().removeAttribute("id");
        theSeeXnfInterfaceAnchor.removeAttribute("id");
        content.getElementSeeXnfInterface().removeAttribute("id");

        theRemoveMetadataAnchor.removeAttribute("id");
        theRemoveAllAnchor.removeAttribute("id");
				
				theSeeSchema.removeAttribute("id");
        content.getElementSeeTemplate().removeAttribute("id");
        content.getElementSeeXmuEdit().removeAttribute("id");
        content.getElementSeeXmuView().removeAttribute("id");
        content.getElementSeeXnfConcept().removeAttribute("id");


        //adding the volumes description
	for ( int i = 0; i < VolumesTable.length; i++ ) {
        content.setTextDictname(VolumesTable[i].getDictname());
        content.setTextName(VolumesTable[i].getName());
        content.setTextDbname(VolumesTable[i].getDbname());
        content.setTextSource(VolumesTable[i].getSourceLanguage());
				String entries = VolumesFactory.countEntries(VolumesTable[i]);
        content.setTextEntries(entries);
            
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
				
				object = VolumesTable[i].getXmuEdition();
				content.setTextSeeXmuEdit("");
				if (object !=null && !object.equals("")) {
					content.setTextSeeXmuEdit("See");
					theSeeXmuEditAnchor.setHref(this.getUrl() + "?" + SEE_XMU_EDIT_PARAMETER + "=" + handle);
				}
				
				object = VolumesTable[i].getXmuVisualisation();
				content.setTextSeeXmuView("");
				if (object !=null && !object.equals("")) {
					content.setTextSeeXmuView("See");
					theSeeXmuViewAnchor.setHref(this.getUrl() + "?" + SEE_XMU_VIEW_PARAMETER + "=" + handle);
				}
				else if (schema !=null && !schema.equals("")) {
					content.setTextSeeXmuView("Generate");
					theSeeXmuViewAnchor.setHref(this.getUrl() + "?" + GENERATE_XMU_PARAMETER + "=" + handle);
				}
				
				object = VolumesTable[i].getXnfConcept();
				content.setTextSeeXnfConcept("");
				if (object !=null && !object.equals("")) {
					content.setTextSeeXnfConcept("See");
					theSeeXnfConceptAnchor.setHref(this.getUrl() + "?" + SEE_XNF_CONCEPT_PARAMETER + "=" + handle);
				}
				else if (schema !=null && !schema.equals("")) {
					content.setTextSeeXnfConcept("Generate");
					theSeeXnfConceptAnchor.setHref(this.getUrl() + "?" + GENERATE_XNF_PARAMETER + "=" + handle);
				}
				
				object = VolumesTable[i].getXnfInterface();
				content.setTextSeeXnfInterface("");
				if (object !=null && !object.equals("")) {
					content.setTextSeeXnfInterface("See");
					theSeeXnfInterfaceAnchor.setHref(this.getUrl() + "?" + SEE_XNF_INTERFACE_PARAMETER + "=" + handle);
				}
				else if (schema !=null && !schema.equals("")) {
					content.setTextSeeXnfInterface("Generate");
					theSeeXnfInterfaceAnchor.setHref(this.getUrl() + "?" + GENERATE_XNF_PARAMETER + "=" + handle);
				}
				
        theRemoveMetadataAnchor.setHref(this.getUrl() + "?" + REMOVE_METADATA_PARAMETER + "=" + handle);
        theRemoveAllAnchor.setHref(this.getUrl() + "?" + REMOVE_ALL_PARAMETER + "=" + handle);
            
        theRowParent.appendChild(theRow.cloneNode(true));
				
				
        }
        
        theRowParent.removeChild(theRow);
    }
    
    protected void addXml(String xmlString) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException {
            
        Node xmlNode = XslTransformation.applyXslSheetForXml(xmlString);    
            
        //where we must insert the xml
        HTMLElement theXml = content.getElementXml();

        Node theXmlParent = theXml.getParentNode();

        theXmlParent.appendChild(content.importNode(xmlNode,true));
        theXmlParent.removeChild(theXml);
    }
    
     protected void addConsultForm(String selectedDict, String selectedVolume) 
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
				
				         // Adding the appropriate source languages to the source list
        HTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
        Node volumeSelect = volumeOptionTemplate.getParentNode();
        volumeOptionTemplate.removeAttribute("id");
        // We assume that the option element has only one text child 
        // (it should be this way if the HTML is valid...)
        Text volumeTextTemplate = (Text)volumeOptionTemplate.getFirstChild(); 
                
        Volume[] AllVolumes = VolumesFactory.getVolumesArray();
                
        for (int i = 0; i < AllVolumes.length; i++) {
            String volumeName = AllVolumes[i].getName();
            volumeOptionTemplate.setValue(volumeName);
            volumeOptionTemplate.setLabel(volumeName);
            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux 
            // specs W3C.
            volumeTextTemplate.setData(volumeName);
            volumeOptionTemplate.setSelected(volumeName.equals(selectedVolume));
            volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
        }
        volumeSelect.removeChild(volumeOptionTemplate);
    }

	protected String uploadObject(String volName, String object, String url) throws PapillonBusinessException {
		PapillonLogger.writeDebugMsg("uploadObject volName: " + volName);
		Volume myVolume = VolumesFactory.findVolumeByName(volName);
		String result = "Nothing uploaded";
		if (myVolume!=null && !myVolume.IsEmpty()) {
			if (object !=null && !object.equals("")) {
				String objectResult = Utility.NodeToString(Utility.buildDOMTreeFromUrl(url));
				result= object + " reloaded";
				if (object.equals(Object_Schema)) {
					myVolume.setXmlSchema(objectResult);
				}
				else if (object.equals(Object_Template)) {
					myVolume.setTemplateEntry(objectResult);
				}
				else if (object.equals(Object_XmuEdit)) {
					myVolume.setXmuEdition(objectResult);
				}
				else if (object.equals(Object_XmuView)) {
					myVolume.setXmuVisualisation(objectResult);
				}
				else if (object.equals(Object_XnfConcept)) {
					myVolume.setXnfConcept(objectResult);
				}
				else if (object.equals(Object_XnfInterface)) {
					myVolume.setXnfInterface(objectResult);
				}
				else {
						result = "Nothing uploaded";
				}
				UserInterface.resetCache();
				fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
				myVolume.save();
			}
		}
		return result;
	}
    
}
