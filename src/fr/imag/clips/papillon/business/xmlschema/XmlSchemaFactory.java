/*
*
*-----------------------
*$Id $
*------------------------
*$Log$
*Revision 1.1  2004/12/06 16:38:32  serasset
*Initial revision
*
*Revision 1.5  2004/03/11 13:39:06  mangeot
**** empty log message ***
*
*Revision 1.4  2004/02/10 05:27:14  mangeot
*The version UIGEN_V2 has been merged with the trunk by MM
*Be careful because the Volumes and contributions database tables have been modified.
*You have to drop and rebuild them unless you modify them by hands.
*
*Revision 1.3.2.2  2004/02/09 05:45:18  mangeot
**** empty log message ***
*
*Revision 1.3.2.1  2004/01/20 09:07:59  mangeot
*Lots of changes for version 2 of UIGenerator: interface description files are loaded
*into the database.
*
*Revision 1.3  2003/09/29 10:54:26  mangeot
**** empty log message ***
*
*Revision 1.2  2003/08/14 08:30:14  mangeot
*Important CVS commit
*Attention, if you checkout this version, you must empty and
*
*for their work on the editor.
*Important CVS commit
*Attention, if you checkout this version, you must empty and
*relaod all your database because the database schema has been modified a lot.
*The entries must be relaoded, the users also
*Merging between the stable branch and the development branch done by MM
*and David Thevenin for their work on the editor.
*It means a lot of improvements for this commit.
*Furthermore, the internal structure of the database has been modified in order
*to use index in separate db table when there is a query for an entry.
*
*Revision 1.1.2.7  2003/08/09 07:21:06  mangeot
*Lots of improvements:
*possible to create a new axie linking two contributions
*possible to delete contributions
*
*Revision 1.1.2.6  2003/03/24 09:29:50  mangeot
**** empty log message ***
*
*Revision 1.1.2.5  2003/03/19 10:03:10  mangeot
**** empty log message ***
*
*Revision 1.1.2.4  2003/03/18 06:04:12  mangeot
**** empty log message ***
*
*Revision 1.1.2.3  2003/03/16 10:30:59  mangeot
**** empty log message ***
*
*Revision 1.1.2.2  2003/03/16 07:31:08  mangeot
**** empty log message ***
*
*Revision 1.1.2.1  2003/02/18 03:27:53  mangeot
*Development for the editing interface
*
*Revision 1.1  2003/02/06 09:36:49  mangeot
**** empty log message ***
*
*
*------------------------
*/

package fr.imag.clips.papillon.business.xmlschema;

//Dom objects
import org.w3c.dom.Document;

// pour les transforamtion
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;
import org.xml.sax.InputSource;

//  Imported JAVA API for XML Parsing classes
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//pour le debugage
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;

// to parse the XML schema
import org.apache.xerces.xni.parser.XMLInputSource;
import org.apache.xerces.impl.xs.*;
import org.apache.xerces.impl.xs.psvi.*;

// io imports
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;

// local imports
import fr.imag.clips.papillon.business.dictionary.Volume;


public class XmlSchemaFactory {

	protected final static String DefaultEncoding = "UTF-8";
	protected final static int startId = 100;

	protected final static String staticInstance = "static";
	protected final static String dynamicInstance = "dynamic";
	protected final static String REGULAR_ID_PREFIX = "S.ri.";
	
	protected final static String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<?xnf version = \"0.1\"?>\n" +
"<!DOCTYPE XNF SYSTEM \"http://www-clips.imag.fr/geta/services/dml/xnf2bis.dtd\">\n" +
"<XNF>\n" +
"  <header>\n" +
"    <documentation>\n" +
"      <exporter>ARTStudio4WEB</exporter>\n" +
"      <exporterVersion>1.7</exporterVersion>\n" +
"      <nameSpace>plasticity.description.instances</nameSpace>\n" +
"    </documentation>\n" +
"    <metamodel name=\"XNF\" version=\"2\"></metamodel>\n" +
"  </header>\n" +
"  <content>\n" +
"    <Description id=\"\">\n" +
"      <descriptionName>test</descriptionName>\n" +
"      <ownedElement> \n" +
"        <Container id=\"S.101\">\n" +
"          <versionName value=\"default\"/>\n" +
"          <predVersionID id=\"S.0\"/>\n" +
"          <subVersionIDs list=\"{S.102}\"/>\n" +
"            <containerElement>\n";

	protected final static String xmlCloseContainer = "     	    </containerElement>\n" + 
"        </Container>\n" +
"\n" +
"        <Container id=\"S.102\">\n" +
"          <versionName value=\"";

	protected final static String xmlOpenContainer = "\"/>\n" +
"          <predVersionID id=\"S.101\"/>\n" +
"          <subVersionIDs list=\"{}\"/>\n" +
"            <containerElement> \n";


	protected final static String xmlFooter = "	   	    </containerElement>\n" + 
"        </Container>\n" +
"      </ownedElement>\n" + 
"    </Description>\n" +
"   </content>\n" +
"</XNF>\n";
		
	public static void generateXnf(Volume myVolume)  
		throws PapillonBusinessException {
		
		BufferedWriter bufferConcept, bufferInterface;

		try {
			myVolume.loadCDMElements();
			ByteArrayOutputStream conceptOS = new ByteArrayOutputStream();
			ByteArrayOutputStream interfaceOS = new ByteArrayOutputStream();
			OutputStreamWriter conceptWriter =
				new OutputStreamWriter(conceptOS, DefaultEncoding);
			OutputStreamWriter interfaceWriter =
				new OutputStreamWriter(interfaceOS, DefaultEncoding);
			// throws UnsupportedEncodingException
			bufferConcept = new BufferedWriter(conceptWriter);
			bufferInterface = new BufferedWriter(interfaceWriter);
			PapillonLogger.writeDebugMsg("Generating XNF files from XML schema");
			produceXnf(bufferConcept, bufferInterface, myVolume.getXmlSchema(), myVolume.CDM_entry, myVolume.getName());
			bufferConcept.close();
			bufferInterface.close();
			conceptOS.flush();
			interfaceOS.flush();
			String conceptString = conceptOS.toString(DefaultEncoding);
			myVolume.setXnfConcept(conceptString);
			myVolume.setXnfInterface(interfaceOS.toString(DefaultEncoding));
			PapillonLogger.writeDebugMsg("XNF concept description and interface descriptions generated " + conceptString);
		} catch (java.io.IOException ex) {
			throw new PapillonBusinessException ("IOException in generateXnf ", ex);
		} 
	}
	
	protected static void produceXnf(BufferedWriter conceptBuffer, 
		BufferedWriter interfaceBuffer, 
		String schemaString, 
		String rootElement, 
		String volumeName) 
		throws PapillonBusinessException {

		XMLInputSource	grammarSource = new XMLInputSource ("", "", "", new StringReader(schemaString), "");

		XMLSchemaLoader loader;
		SchemaGrammar schemaGrammar = null;

		try {
			loader = new XMLSchemaLoader();
			schemaGrammar = (SchemaGrammar) loader.loadGrammar(grammarSource);
			PapillonLogger.writeDebugMsg("produceXnf: Schema parsed ===============================");
		} catch (Exception ex) {
			throw new PapillonBusinessException("Exception in XmlSchemaFactory.produceXnf with " +  schemaString, ex);
		}
			produceXnf(conceptBuffer, interfaceBuffer, schemaGrammar, rootElement, volumeName);
	}

	protected static void produceXnf(BufferedWriter conceptBuffer, BufferedWriter interfaceBuffer, 
		SchemaGrammar schemaGrammar, String rootElement, String volumeName)  
		throws PapillonBusinessException {

		XSElementDeclaration declaration;
		XSNamedMap listComponent;
		XSObject object;

		try {
			conceptBuffer.write(xmlHeader);
			conceptBuffer.write(xmlCloseContainer);
			conceptBuffer.write(volumeName);
			conceptBuffer.write(xmlOpenContainer);

			interfaceBuffer.write(xmlHeader);
			interfaceBuffer.write(xmlCloseContainer);
			interfaceBuffer.write(UserInterface.DEFAULT_LANGUAGE_VERSION_NAME);
			interfaceBuffer.write(xmlOpenContainer);

		/* ELEMENT */
		listComponent =
			schemaGrammar.getComponents(XSConstants.ELEMENT_DECLARATION);
		for (int i = 0; i < listComponent.getMapLength(); i++) {
			object = (XSObject) listComponent.getItem(i);
			if ((object != null) && (object instanceof XSElementDeclaration)) {
				declaration = (XSElementDeclaration) object;
				if (declaration.getName().equals(rootElement)) {
				parseElementDeclaration(conceptBuffer, interfaceBuffer, volumeName, (XSElementDeclaration) declaration, staticInstance, startId, "");
				}
			}
		}
		
		conceptBuffer.write(xmlFooter);
		interfaceBuffer.write(xmlFooter);
		} catch (Exception ex) {
			throw new PapillonBusinessException("Exception in XmlSchemaFactory.produceXnf with " +  volumeName, ex);
		}
	}
		
	protected static int parseElementDeclaration(BufferedWriter conceptBuffer, BufferedWriter interfaceBuffer,
		String volumeName, XSElementDeclaration declaration, String instanceKind, int id, String idReferent) {

		XSObject object;
		XSTypeDefinition baseType;
		XSComplexTypeDefinition complexType;

		XSAttributeDeclaration attributePSVI;
		XSSimpleTypeDefinition simpleTypeDefinition;
		XSParticle particle = null;
		XSTerm term = null;
		XSModelGroup modelGroup = null;
		
	baseType = declaration.getTypeDefinition ();
	String typeName = declaration.getName() + "Type";
	if (baseType.getName()!=null) {
			typeName =  baseType.getName();
	}
	
	String newIdRef = printXnf(conceptBuffer, interfaceBuffer, volumeName, declaration.getName(),typeName,instanceKind,id,idReferent);
	id++;
	PapillonLogger.writeDebugMsg("Element : " + declaration.getName());
	PapillonLogger.writeDebugMsg("Id : " + id  + " IdReferent : " + idReferent + " newIdRef : " + newIdRef);
	PapillonLogger.writeDebugMsg("InstanceKind : " + instanceKind);
	PapillonLogger.writeDebugMsg("Type Name : " + typeName);
	
	if (baseType instanceof XSSimpleTypeDefinition) {
		PapillonLogger.writeDebugMsg("Simple type definition");
	}
	else if (baseType instanceof XSComplexTypeDefinition) {
		PapillonLogger.writeDebugMsg("Complex type definition");
		complexType = (XSComplexTypeDefinition) baseType; 
		switch (complexType.getContentType ())
		{
			case XSComplexTypeDefinition.CONTENTTYPE_SIMPLE:
		//			PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_SIMPLE" );
					/* SimpleContent */
					simpleTypeDefinition = complexType.getSimpleType ();
					if (simpleTypeDefinition != null)
					{
						PapillonLogger.writeDebugMsg ("PB in constructComplexType: a simpleTypeDefinition not managed: " + simpleTypeDefinition);
					}
				break;
				
			case XSComplexTypeDefinition.CONTENTTYPE_MIXED:
		//	PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_MIXED" );
					particle = complexType.getParticle ();
					/* Case where there are not element. In this case I simmulate the mixed contentType
					as a string */
					if (particle == null)
					{
						}
					else
					{
						particle = complexType.getParticle ();
						if (particle != null)
						{
							if (!(particle instanceof XSParticleDecl))
							{
								PapillonLogger.writeDebugMsg ("-------- PB in constructComplexType: particle have a bad type.");
							}
							else
							{
			//					attribute = constructAttributeFromParticle ((XSParticleDecl) particle);
								}
						}
					}
				break;
						
			case XSComplexTypeDefinition.CONTENTTYPE_ELEMENT:
		//	PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_ELEMENT" );
				/* Complex type definied with a {choice, sequence or all) elements */
					particle = complexType.getParticle ();
					if (particle != null)
					{
						term = particle.getTerm();
						if (term instanceof XSModelGroup) {
			//				PapillonLogger.writeDebugMsg ("XSModelGroup ");
							modelGroup = (XSModelGroup) term;
							if (modelGroup.getCompositor()==XSModelGroup.COMPOSITOR_SEQUENCE) {
								PapillonLogger.writeDebugMsg ("Compositor sequence");
								XSObjectList myList = modelGroup.getParticles();
								for (int j=0;j<myList.getLength();j++) {
									XSParticle tempParticle = (XSParticle)myList.getItem(j);
									String newInstanceKind = instanceKind;
									if (newInstanceKind.equals(staticInstance)) {
										if (tempParticle.getIsMaxOccursUnbounded()) {
											newInstanceKind = dynamicInstance;
										}
									}
									term = tempParticle.getTerm();
									if (term instanceof XSElementDeclaration) {
											id = parseElementDeclaration(conceptBuffer, interfaceBuffer, volumeName, 
												(XSElementDeclaration) term, newInstanceKind, id, newIdRef);
									}	
								}																					
							}
						}
						if (!(particle instanceof XSParticleDecl))
						{
							PapillonLogger.writeDebugMsg ("-------- PB in constructComplexType: particle have a bad type.");
						}
						else
						{
					//		attribute = constructAttributeFromParticle ((XSParticleDecl) particle);
					//		if (attribute != null)
					//			concept.addAttributeRelationID (attribute.getID (), currentContainer.version.getID ());
						}
					}
				break;
				
			case XSComplexTypeDefinition.CONTENTTYPE_EMPTY:
		//	PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_EMPTY" );
					/* Complex type definied only with attibutes */
				break;
		}

	}
	return id;
	}
				
	protected static String printXnf (BufferedWriter conceptBuffer, BufferedWriter interfaceBuffer, 
		String volumeName, String element, String type, String kind, int id, String ref) {
		String regularId = "";
	try {
				conceptBuffer.write("\n");
				interfaceBuffer.write("\n");
				writeConstantInstance(interfaceBuffer,element, id);
			if (ref !=null && !ref.equals("")) {
				regularId = REGULAR_ID_PREFIX + id;
				writeRegularInstance(conceptBuffer, element, type, kind, regularId);
				writeMethodCall(conceptBuffer, element, ref, regularId, id);
			}
			else {
			// There is no reference, it means that we are writing the root instance, ie the entry instance
				regularId = UserInterface.INSTANCE_ENTRY_ID;
				writeRegularInstance(conceptBuffer, element, type, kind, UserInterface.INSTANCE_ENTRY_ID);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return regularId;
	}

	protected static void writeRegularInstance(BufferedWriter buffer, String element, String type, String kind, String id) {
//		<!-- mot -->
//		<Instance type="element" id="S.101">
//		  <InstanceKind value="static"/>
//		  <InstanceBuildKind value="regular"/>
//		  <Name value="mot"/>
//		  <ClassNameSpace value=""/>
//		  <ClassName value="motType"/>
//		  <TaskOwnerID value="S.360"/>
//		  <TaskRangeID list="{S.360}"/>
//		</Instance>
	try {
	
//		<!-- mot -->
		buffer.write("            <!-- " + element +  " -->\n");
//		<Instance type="element" id="S.101">
		buffer.write("            <Instance type=\"element\" id=\"" + id +  "\">\n");
//		  <InstanceKind value="static"/>
		buffer.write("              <InstanceKind value=\"" + kind +  "\"/>\n");
//		  <InstanceBuildKind value="regular"/>
		buffer.write("              <InstanceBuildKind value=\"regular\"/>\n");
//		  <Name value="mot"/>
		buffer.write("              <Name value=\"" + element + "\"/>\n");
//		<ClassNameSpace value=""/>
		buffer.write("              <ClassNameSpace value=\"\"/>\n");
//		<ClassName value="motType"/>
		buffer.write("              <ClassName value=\"" + type + "\"/>\n");
//		<TaskOwnerID value="S.360"/>
		buffer.write("              <TaskOwnerID value=\"S.360\"/>\n");
//		<TaskRangeID list="{S.360}"/>
		buffer.write("              <TaskRangeID list=\"{S.360}\"/>\n");
//	  </Instance>
	  buffer.write("            </Instance>\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	} 


	protected static void writeMethodCall(BufferedWriter buffer, String element, String ref, String idString, int id) {
//		<MethodCall type="element" id="S.1011">
//		  <MethodKind value="localCall"/>
//		  <Name value="mot"/>
//		  <InstanceID value="S.100"/>
//		</MethodCall>
//		    
//		<UseMethod type="relation" id="S.51011" access="0" elements="{S.101;S.1011}">
//		  <Name value="constructor"/>
//		</UseMethod>
	try {
//		<MethodCall type="element" id="S.1011">
		buffer.write("            <MethodCall type=\"element\" id=\"S.mc." + id +  "\">\n");
//		  <MethodKind value="localCall"/>
		buffer.write("              <MethodKind value=\"localCall\"/>\n");
//		  <Name value="mot"/>
		buffer.write("              <Name value=\"" + element + "\"/>\n");
//		  <InstanceID value="S.100"/>
		buffer.write("              <InstanceID value=\"" + ref + "\"/>\n");
//		</MethodCall>
		buffer.write("            </MethodCall>\n");	    

//		<UseMethod type="relation" id="S.51011" access="0" elements="{S.101;S.1011}">
		buffer.write("            <UseMethod type=\"relation\" id=\"S.um." + id + "\" access=\"0\" elements=\"{" + idString + ";S.mc." + id + "}\">\n");
//			<Name value="constructor"/>
		buffer.write("              <Name value=\"constructor\"/>\n");	    
//		</UseMethod>
		buffer.write("            </UseMethod>\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	} 


						
	protected static void writeConstantInstance(BufferedWriter buffer, String element, int id) {
//		<!-- mot -->
//		<Instance type="element" id="S.102">
//		  <InstanceKind value="static"/>
//		  <InstanceBuildKind value="constant"/>
//		  <Name value="motInfo"/>
//		  <ClassNameSpace value=""/>
//		  <ClassName value="String"/>
//		  <ConstantValue value="Mot:"/>
//		  <TaskOwnerID value="S.360"/>
//		  <TaskRangeID list="{S.360}"/>
//		</Instance>
	String interfaceName = element.replace('-',' ');
	interfaceName = interfaceName.replace('_',' ');
	if (interfaceName!=null &&!interfaceName.equals("")) {
		interfaceName=interfaceName.substring(0,1).toUpperCase()+interfaceName.substring(1);
	}
	interfaceName+=":";

	try {
//		<!-- mot -->
		buffer.write("            <!-- " + element +  " -->\n");
//		<Instance type="element" id="S.102">
		buffer.write("            <Instance type=\"element\" id=\"S.ci." + id +  "\">\n");
//		  <InstanceKind value="static"/>
		buffer.write("              <InstanceKind value=\"static\"/>\n");
//		  <InstanceBuildKind value="constant"/>
		buffer.write("              <InstanceBuildKind value=\"constant\"/>\n");
//		  <Name value="motInfo"/>
		buffer.write("              <Name value=\"" + element + "Info\"/>\n");
//		  <ClassNameSpace value=""/>
		buffer.write("              <ClassNameSpace value=\"\"/>\n");
//		  <ClassName value="String"/>
		buffer.write("              <ClassName value=\"String\"/>\n");
		
		
//		  <ConstantValue value="Mot:"/>
		buffer.write("              <ConstantValue value=\"" + interfaceName + "\"/>\n");
//		  <TaskOwnerID value="S.360"/>
		buffer.write("              <TaskOwnerID value=\"S.360\"/>\n");
//		  <TaskRangeID list="{S.360}"/>
		buffer.write("              <TaskRangeID list=\"{S.360}\"/>\n");
//		  </Instance>
		buffer.write("            </Instance>\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	} 
					
}
 
		
















