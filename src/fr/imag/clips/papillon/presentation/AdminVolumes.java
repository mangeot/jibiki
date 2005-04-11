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
 * Revision 1.4  2005/04/11 08:01:02  fbrunet
 * Passage en xhtml des ressources Papillon.
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


//pour les dictionary
import fr.imag.clips.papillon.business.dictionary.*;

// import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.edition.GenerateTemplate;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.transformation.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;


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

    
    protected static AdminVolumesXHTML content;


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
        content = (AdminVolumesXHTML)MultilingualXHtmlTemplateFactory.createTemplate("AdminVolumesXHTML", this.getComms(), this.getSessionData());
		  
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
				fr.imag.clips.papillon.business.edition.UITemplates.resetCache();
				myVolume.save();
			}
		}
		return result;
	}
    
}
