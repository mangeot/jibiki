/*
 *
 *-----------------------
 *$Id$
 *------------------------
 *$Log$
 *Revision 1.1  2004/12/06 16:38:32  serasset
 *Initial revision
 *
 *Revision 1.17  2004/09/18 17:27:53  mangeot
 **** empty log message ***
 *
 *Revision 1.16  2004/03/23 01:38:08  mangeot
 **** empty log message ***
 *
 *Revision 1.15  2004/02/12 15:55:49  mangeot
 *Added functionnalities for the GDEF
 *
 *Revision 1.14  2004/02/12 14:45:02  mangeot
 *Added history directly in the entries
 *
 *Revision 1.13  2004/02/12 04:12:06  mangeot
 *Bug with the default language solved
 *
 *Revision 1.12  2004/02/10 05:27:14  mangeot
 *The version UIGEN_V2 has been merged with the trunk by MM
 *Be careful because the Volumes and contributions database tables have been modified.
 *You have to drop and rebuild them unless you modify them by hands.
 *
 *
 *------------------------
 */

package fr.imag.clips.papillon.business.xmlschema;

// imports enhydra
import com.lutris.appserver.server.Enhydra;

// imports locaux
import fr.imag.clips.papillon.business.dictionary.*;
import fr.imag.clips.papillon.business.user.User;

//pour le debugage
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

//Dom objects
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import org.apache.xerces.dom implementation
import org.apache.xerces.dom.ElementImpl;
import org.apache.xerces.dom.DocumentImpl;

//imports UIGenerator
import java.util.*;
import concepts.*;
import UIGeneratorEnhydra.UserInterfaceCache;
import plasticity.description.concreteUI.ConcreteUIDescription;
import plasticity.description.concepts.ConceptDescription;
import plasticity.description.instances.InstanceDescription;
import plasticity.description.instances.Instance;
import plasticity.generator.finalUI.*;
import plasticity.generator.finalUI.impl.instance.XMLFactory;
import plasticity.description.concepts.factories.PapillonConceptDescriptionFactory;

// dynamic instanciation
import java.lang.reflect.Method;

/*************************************************
 *   <p>UserInterface.java Class.</p>
 *************************************************
 *   This class discribe ...
 * 
 *   <p> XXX </p>
 *************************************************
 * @version XX
 * @since XX
 * @author thevenin
*/
/*************************************************
 *   <p>UserInterface Class.</p>
 *************************************************
 *   Cette classe permet l'instanciation dynamique
 * des donnees pour la generation des interfaces
 * WEB.
 * 
 * <p>Dans le projet Papillon, les interfaces
 * d'edition et de consultation des donnees papillon
 * sont generee semi-automatiquement en fonction
 * de la plateforme cible, de l'utilisateur et des
 * donnees.</p>
 * <p>Cette classe parcourt des donnees venant du
 * d'un dictionaire Papillon et produit le cache
 * d'instance, qui est une structure de donnee
 * manipulable par le generateur d'interface.</p>
 * <p>Cette structure depend du modele des instance
 * qui aura ete prealablement defini. Le donnees
 * venant ddu dictionnaire doivent etre sous la
 * forme XML.</p>
 *************************************************
 * @version second version
 * @since Papillon server (version ??)
 * @author David Thevenin and Mathieu Mangeot
*/
public class UserInterface
{
	// Public constants
	public final static String ENHYDRA_SITE_EDITION_TYPE = "edition";
	public final static String ENHYDRA_SITE_VISUALISATION_TYPE = "visualisation";
	
	public final static String ENHYDRA_XNF_INTERFACE_TYPE = "interface";
	public final static String ENHYDRA_XNF_CONCEPT_TYPE = "concept";

	public final static String FILE_NAME_SEPARATOR = "-";
	public final static String FILE_EXTENSION_SEPARATOR = ".";

	public final static String INTERACTOR_MODEL_EXTENSION = "xim";
	public final static String INSTANCE_MODEL_EXTENSION = "xnf";
	public final static String CONCRETE_UI_MODEL_EXTENSION = "xmu";
	public final static String CONCEPT_DESCRIPTION_EXTENSION = "xsd";

	public final static String DEFAULT_CONCEPT_VERSION_NAME = "Papillon_eng";
	public final static String DEFAULT_LANGUAGE_VERSION_NAME = "eng";
	public final static String DEFAULT_INTERACTOR_MODEL_NAME = "default";

	public final static String AddCall_PARAMETER = EnhydraSite.AddCall_PARAMETER;
	public final static String DelCall_PARAMETER = EnhydraSite.DelCall_PARAMETER;
	public final static String PARAMETER_SEPARATOR = EnhydraSite.PARAMETER_SEPARATOR;

	// Protected constants INSTANCE_ENTRY_ID
	protected final static String INSTANCE_ENTRY_ID = XMLFactory.MAIN_INSTANCE_ID;

	// protected variables
	protected String volumeVersionID = null;
	protected String genericVolumeVersionID = null;
	protected String defaultVolumeVersionID = null;
	protected String languageVersionID = null;
	protected String defaultLanguageVersionID = null;

	protected ConceptDescription description;
	protected ConcreteUIDescription CUIModel;
	protected InstanceDescription instanceConceptModel, instanceInterfaceModel;
	protected InstanceCache instanceCache;
    protected XMLFactory instanceGenerator;
	protected EnhydraSite theEnhydraWebSite;
	protected Hashtable enhydraSitesCache;
	protected Volume theVolume;
	protected IAnswer theAnswer;
	protected Document entryDocument;
	protected Node templateEntryNode;

	private static int idCounter = 0;

	/**
	 * Constructeur de la classe.
	 * <p>Le constructeur ouvre les decription necessaire a la generation
	 * du coche de instance</p>
	 * 
	 * @param myVolume, le volume de dictionaire Papillon.
	 * @param interfaceType, la version de l'interface qui devra etre generee.
	 * @throws PapillonBusinessException
	 */
	public UserInterface(Volume myVolume, String interfaceType, String lang) throws PapillonBusinessException
	{
		try
		{
			if ((myVolume != null) && (!myVolume.IsEmpty()))
			{
				theVolume = myVolume;
								
				templateEntryNode = this.getEntryNode(VolumeEntriesFactory.createEmptyEntry(theVolume.getName()));

				String siteName = theVolume.getDictname() + FILE_NAME_SEPARATOR + interfaceType;
				CUIModel = UserInterfaceCache.getConcreteUIDescription(siteName);
				// construction of the ConcreteUIDescription model
				if (CUIModel == null)
				{
					CUIModel = new ConcreteUIDescription();
					CUIModel.setName(siteName);
					CUIModel.setExtension(CONCRETE_UI_MODEL_EXTENSION);
				if (interfaceType.equals(ENHYDRA_SITE_EDITION_TYPE)) {
					CUIModel.loadFromString(theVolume.getXmuEdition());
				} 
				else {
					CUIModel.loadFromString(theVolume.getXmuVisualisation());
				} 
					UserInterfaceCache.putConcreteUIDescription(siteName, CUIModel);
				}
				// set up te generic structure version ID
				genericVolumeVersionID = CUIModel.getMainVersionID();
				volumeVersionID = CUIModel.getVersionIDByName(theVolume.getName());
				if (volumeVersionID == null)
				{
					defaultVolumeVersionID = CUIModel.getVersionIDByName(DEFAULT_CONCEPT_VERSION_NAME);
					if (defaultVolumeVersionID == null)
					{
						PapillonLogger.writeDebugMsg("ERROR. VERSION " + theVolume.getName() + " UNKNOWN as well as " + DEFAULT_CONCEPT_VERSION_NAME + " !!!");
						return;
					}
					volumeVersionID = CUIModel.createSubVersion(genericVolumeVersionID, defaultVolumeVersionID + idCounter++, theVolume.getName());
				}

				// construction of the ConceptDescription model (XML schema)
				// For the moment, depends only on the Volume
				description = UserInterfaceCache.getConceptDescription(theVolume.getName());
				if (description == null)
				{
					description = new ConceptDescription();
					UserInterfaceCache.putConceptDescription(theVolume.getName(), description);
				}

				if (!description.containsVersion(volumeVersionID))
				{
					PapillonConceptDescriptionFactory factory = new PapillonConceptDescriptionFactory();
					factory.setConceptDescription(description);
					factory.parseDocumentFromString(volumeVersionID, theVolume.getName(), theVolume.getXmlSchema());
				}

				// construction of the instanceConceptModel model for the Entry structure
				instanceConceptModel = UserInterfaceCache.getInstanceConceptDescription(theVolume.getDictname());
				if (instanceConceptModel == null)
				{
					instanceConceptModel = new InstanceDescription();
					instanceConceptModel.setName (theVolume.getDictname() + FILE_NAME_SEPARATOR + ENHYDRA_XNF_CONCEPT_TYPE);
					instanceConceptModel.setExtension(INSTANCE_MODEL_EXTENSION);
					instanceConceptModel.loadFromString(theVolume.getXnfConcept());
					UserInterfaceCache.putInstanceConceptDescription(theVolume.getDictname(), instanceConceptModel);
				}

				if (!instanceConceptModel.containsVersion(volumeVersionID)) // the current version does not exist, made a version from de default version
				{
					if (!instanceConceptModel.containsVersion(defaultVolumeVersionID))
					{
						System.out.println("ERROR. DEFAULT INTERFACE VERSION ID " + defaultVolumeVersionID + " in XNF UNKNOWN !!!");
						return;
					}
					instanceConceptModel.createSubVersion(instanceConceptModel.getMainVersionID(), volumeVersionID, theVolume.getName());
				}

				// construction of the instanceInterfaceModel model for the Entry structure
				instanceInterfaceModel = UserInterfaceCache.getInstanceInterfaceDescription(theVolume.getDictname());
				if (instanceInterfaceModel == null)
				{
					instanceInterfaceModel = new InstanceDescription();
					instanceInterfaceModel.setName (theVolume.getDictname() + FILE_NAME_SEPARATOR + ENHYDRA_XNF_INTERFACE_TYPE);
					instanceInterfaceModel.setExtension(INSTANCE_MODEL_EXTENSION);
					instanceInterfaceModel.loadFromString(theVolume.getXnfInterface());
					UserInterfaceCache.putInstanceInterfaceDescription(theVolume.getDictname(), instanceInterfaceModel);
				}

        instanceGenerator = new XMLFactory(instanceConceptModel, instanceInterfaceModel);

				// set up te generic language version ID
				languageVersionID = instanceInterfaceModel.getVersionIDByName(lang);
				if (languageVersionID == null)
				{
					defaultLanguageVersionID = instanceInterfaceModel.getVersionIDByName(DEFAULT_LANGUAGE_VERSION_NAME);
					if (defaultLanguageVersionID == null)
					{
						System.out.println("ERROR. VERSION " + lang + " UNKNOWN as well as " + DEFAULT_LANGUAGE_VERSION_NAME + " !!!");
						return;
					}
//					languageVersionID = instanceInterfaceModel.createSubVersion(instanceInterfaceModel.getMainVersionID(), defaultLanguageVersionID + idCounter++, lang);
					languageVersionID = defaultLanguageVersionID;
				}

//				if (!instanceInterfaceModel.containsVersion(languageVersionID)) // the current version does not exist, made a version from de default version
//				{
//					if (!instanceInterfaceModel.containsVersion(defaultLanguageVersionID))
//					{
//						System.out.println("ERROR. DEFAULT LANGUAGE VERSION ID " + defaultLanguageVersionID + " in XNF UNKNOWN !!!");
//						return;
//					}
//					instanceInterfaceModel.createSubVersion(instanceInterfaceModel.getMainVersionID(), languageVersionID, lang);
//				}
				
				if (!instanceInterfaceModel.containsVersion(languageVersionID))
				{
						System.out.println("ERROR.  LANGUAGE VERSION ID " + languageVersionID + " in XNF UNKNOWN !!!");
						return;
				}
				
				PapillonLogger.writeDebugMsg("VolumeName: " + theVolume.getName() + " lang: " + lang + " volume ID: " + volumeVersionID + " interface ID: " + languageVersionID);

				// construction of the EnhydraSite
				String interfaceName = theVolume.getDictname() + volumeVersionID + languageVersionID + interfaceType;
				theEnhydraWebSite = UserInterfaceCache.getEnhydraSite(interfaceName);
				if (theEnhydraWebSite == null)
				{
					plasticity.generator.finalUI.UserInterfaceGenerator.setCUIModel(CUIModel);
					plasticity.generator.finalUI.UserInterfaceGenerator.setConceptDescription(description);
					plasticity.generator.finalUI.UserInterfaceGenerator.setInstanceConceptDescription(instanceConceptModel);
					plasticity.generator.finalUI.UserInterfaceGenerator.setInstanceInterfaceDescription(instanceInterfaceModel);

					theEnhydraWebSite = UserInterfaceGenerator.generateEnhydra(volumeVersionID, languageVersionID);
					if (theEnhydraWebSite != null)
						UserInterfaceCache.putEnhydraSite(interfaceName, theEnhydraWebSite);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new PapillonBusinessException("Error in UIGenerator");
		}
	}


	/**
		* Save data when we use the site for the first time.
	 * The function try to initilize all possible data used.
	 * Because some data can be know only at runtime, it is
	 * necessary to use the "updateData" function for update
	 * dynamnic data (instance of concept)
	 *
	 * @return boolean if it works
	 * @since 1.7
	 */
public boolean InitData(IAnswer myAnswer) throws PapillonBusinessException
	{
		this.theAnswer = myAnswer;
		this.entryDocument = getEntryDocument(myAnswer);
    Hashtable parameters = new Hashtable ();
    parameters.put(INSTANCE_ENTRY_ID, entryDocument.getDocumentElement());
    instanceCache = instanceGenerator.buildCache (volumeVersionID, languageVersionID, entryDocument, parameters);
    if (instanceCache != null) return true;
      else return false;
	}

	/**
		* Save data when the object is edited
	 *
	 * @return boolean if it works
	 * @since 1.7
	 */
	public boolean saveData(User myUser, String saveComment) throws PapillonBusinessException, java.io.IOException
	{
		Document entryDOM = this.getEntryDocument();
		VolumeEntry myEntry = VolumeEntriesFactory.findEntryByHandle(theAnswer.getVolumeName(),theAnswer.getHandle());

		//Adding modifications in the XML code
		IAnswerFactory.setModification(theAnswer,entryDOM,myUser.getLogin(),saveComment);
		Contribution myContrib = null;
		boolean IsNewEntry = (myEntry == null || myEntry.IsEmpty());
		// If the entry has been created from scratch
		if (IsNewEntry) {
			myEntry = (VolumeEntry) theAnswer;
			myEntry.extractDataFromDOM(entryDOM);
			myContrib = ContributionsFactory.createContributionFromVolumeEntry(myEntry, myUser, null);
		}
		else {
			myContrib = ContributionsFactory.findContributionByEntryHandle(theAnswer.getHandle());
	// code modified in order to let reviewers editing contributions from other people
	//		boolean isMyContrib =  (myContrib !=null && !myContrib.IsEmpty() && myContrib.getAuthor().equals(myUser.getLogin()));
			
			// if there is an existing contribution and it is myUser's one
	//		if (isMyContrib) {
			  myEntry = (VolumeEntry) theAnswer;
				myEntry.extractDataFromDOM(entryDOM);
				myContrib.setHeadword(myEntry.getHeadword());
	//		}
			
			// if it is a modification of an existing entry and myUser has no previous contributions on it
/*			else {
				myEntry = VolumeEntriesFactory.newEntryFromExisting((VolumeEntry)theAnswer);
				myEntry.extractDataFromDOM(entryDOM);
				myContrib = ContributionsFactory.createContributionFromVolumeEntry(myEntry, myUser, theAnswer.getHandle());
			} */
		}		
		myEntry.save();
		myContrib.save();
		
		return true;
	}

	public org.w3c.dom.Element getDocumentElement()
	{
		Document myDocument = theEnhydraWebSite.getDOMPageBody(0, instanceCache);
		return myDocument.getDocumentElement();
	}

	public boolean IsInstance(String instanceID)
	{
		return instanceCache.exist(instanceID);
	}

	public boolean updateInstance(String instanceID, String contextID, String value) throws fr.imag.clips.papillon.business.PapillonBusinessException
	{
		boolean res = instanceGenerator.updateValue(instanceID, contextID, value);
		PapillonLogger.writeDebugMsg("Updated instance: " + instanceCache.getValue(instanceID, contextID));
		return res;
	}
	
	public boolean deleteInstance(String instanceID, String contextID) throws fr.imag.clips.papillon.business.PapillonBusinessException
	{
		PapillonLogger.writeDebugMsg("Delete Instance instanceID: " + instanceID + " contextID: " + contextID);
		return instanceGenerator.deleteInstance(instanceID, contextID);
	}

	public boolean addChildInstance(String parentID, String contextID, String childID) throws PapillonBusinessException
	{
      PapillonLogger.writeDebugMsg("Add ChildInstance parentID: " + parentID + " contextID: " + contextID + " childID : " + childID);
      Node newNode = getTemplateNode(INSTANCE_ENTRY_ID, parentID, childID);
      return instanceGenerator.addChildInstance(parentID, contextID, childID, newNode);
	}

	protected Node getTemplateNode(String rootID, String parentID, String childID) {
		Node currentNode = null;
		Node resultNode = null;
		Instance childInstance = instanceConceptModel.getInstanceByID(childID);
		if (parentID.equals(rootID)) {
			currentNode = this.templateEntryNode;
		}
		else {
			currentNode = getTemplateNode(rootID, instanceCache.getFatherID(parentID), parentID);
		}
		NodeList myNodeList = currentNode.getChildNodes();
		for (int i = 0; i < myNodeList.getLength(); i++) {
			Node myNode = myNodeList.item(i);
			// BEWARE, David's module strings are not regular strings !!!
			// So you have to apply toString() after getName() on an instance
			if (myNode.getNodeName().equals(childInstance.getName().getValue())) {
				resultNode = myNode;
			}
		}
		return resultNode;
	}

	protected Document getEntryDocument(IAnswer myAnswer) throws PapillonBusinessException
	{
		/* Static instances */
		String xmlCode = myAnswer.getXmlCode();
		return Utility.buildDOMTree(xmlCode);
	}

	public Document getEntryDocument() throws PapillonBusinessException {
		return ((Element) instanceCache.getValue(INSTANCE_ENTRY_ID, InstanceCache.TOP_LEVEL_CONTEXT_ID)).getOwnerDocument();
	}
	
	public IAnswer getAnswer() {
		return theAnswer;
	}

	protected Node getEntryNode(IAnswer myAnswer) throws PapillonBusinessException
	{
		return getEntryDocument(myAnswer).getDocumentElement();
	}

	public String getVolumeName() throws PapillonBusinessException
	{
		String answer = "";
		if (theVolume != null)
		{
			answer = theVolume.getName();
		}
		return answer;
	}
	public static void resetCache()
	{
		UserInterfaceCache.reset();
	}
}
