//
//  GenerateInterface.java
//  PapillonStable
//
//  Created by Mathieu Mangeot on Thu Sep 16 2004.
//  Copyright (c) 2004 __MyCompanyName__. All rights reserved.
//
package fr.imag.clips.papillon.business.edition;

import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

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


public class GenerateTemplate {
	
	protected final static String DefaultEncoding = "UTF-8";
	
	
	protected final static String xmlHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
		"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:d=\"http://www-clips.imag.fr/geta/services/dml\">\n" +
		"<head>\n" +
		"	<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
		"	<title>Interface Template</title>\n" +
		"</head>\n" +
		"<body>\n" +
		"<form  action=\"EditEntry.po\" id=\"default\" name=\"default\" xml:lang=\"en\" lang=\"en\" d:lang=\"eng\">\n" +
		"<h1 align=\"center\">Edition interface</h1>\n" +
		"<input name=\"VolumeName\" type=\"hidden\" value=\"\" />\n" +
		"<input name=\"EntryHandle\" type=\"hidden\" value=\"\" />\n" +
		"<input name=\"AddCall\" type=\"hidden\" value=\"\" />\n" +
		"<input name=\"DelCall\" type=\"hidden\" value=\"\" />\n" +
		"<input name=\"ChooseCall\" type=\"hidden\" value=\"\" />\n";
	
	protected final static String xmlFooter = "<br /><br />\n" +
		"<input name=\"Update\" type=\"Submit\" value=\"Update\" />\n" +
		"<input name=\"Save\" type=\"Submit\" value=\"Save\" />\n" + 
		"<label for=\"SaveComment\">Comment:</label> <input name=\"SaveComment\" type=\"text\" />\n" +
		"</form>\n" +
		"</body>\n" +
		"</html>\n";
	
	protected final static int DEFAULT_ELEMENT = 0;
	protected final static int LIST_ELEMENT = 1;
	protected final static int CHOICE_ELEMENT = 2;
	
	protected static String HistoryTag = "";
	
	// public methods
	public static void generateInterfaceTemplate(Volume myVolume)  
		throws PapillonBusinessException {
			
			BufferedWriter bufferInterface;
			
			try {
				myVolume.loadCDMElements();
				HistoryTag = myVolume.CDM_history;
				ByteArrayOutputStream interfaceOS = new ByteArrayOutputStream();
				OutputStreamWriter interfaceWriter =
					new OutputStreamWriter(interfaceOS, DefaultEncoding);
				// throws UnsupportedEncodingException
				bufferInterface = new BufferedWriter(interfaceWriter);
				PapillonLogger.writeDebugMsg("Generating interface template from XML schema");
				produceInterfaceTemplate(bufferInterface, myVolume.getXmlSchema(), myVolume.CDM_entry, myVolume.getName());
				bufferInterface.close();
				interfaceOS.flush();
				String itfString = interfaceOS.toString(DefaultEncoding);
				myVolume.setXmuVisualisation(itfString);
				myVolume.save();
				//	PapillonLogger.writeDebugMsg("interface template generated: ");
				//	System.out.println(itfString);
			} catch (java.io.IOException ex) {
				throw new PapillonBusinessException ("IOException in generateInterfaceTemplate ", ex);
			} 
		}
	
	// protected methods
	protected static void produceInterfaceTemplate(BufferedWriter interfaceBuffer, 
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
				PapillonLogger.writeDebugMsg("produceInterfaceTemplate: Schema parsed ===============================");
			} catch (Exception ex) {
				throw new PapillonBusinessException("Exception in XmlSchemaFactory.produceInterfaceTemplate with " +  schemaString, ex);
			}
			produceInterfaceTemplate(interfaceBuffer, schemaGrammar, rootElement, volumeName);
		}
	
	protected static void produceInterfaceTemplate(BufferedWriter interfaceBuffer, 
												   SchemaGrammar schemaGrammar, String rootElement, String volumeName)  
		throws PapillonBusinessException {
			
			XSElementDeclaration myDeclaration = null;
			XSNamedMap listComponent;
			XSObject object;
			
			try {
				interfaceBuffer.write(xmlHeader);
				myDeclaration = schemaGrammar.getGlobalElementDecl(rootElement);
				if (myDeclaration !=null) {
					parseElementDeclaration(interfaceBuffer, volumeName, myDeclaration);
				}
				/*				listComponent =
					schemaGrammar.getComponents(XSConstants.ELEMENT_DECLARATION);
				boolean found = false;
				int i=0;
				while (i < listComponent.getMapLength() && !found) {
					object = (XSObject) listComponent.getItem(i);
					if ((object != null) && (object instanceof XSElementDeclaration)) {
						myDeclaration = (XSElementDeclaration) object;
						if (myDeclaration.getName().equals(rootElement)) {
							parseElementDeclaration(interfaceBuffer, volumeName, myDeclaration);
							found = true;
						}
					}
					i++;
				} */
				interfaceBuffer.write(xmlFooter);
			} catch (Exception ex) {
				throw new PapillonBusinessException("Exception in GenerateTemplate.produceInterfaceTemplate with " +  volumeName, ex);
			}
		}
	
	protected static void parseElementDeclaration(BufferedWriter interfaceBuffer,
												  String volumeName, XSElementDeclaration declaration) {
		parseElementDeclaration(interfaceBuffer, volumeName, declaration, DEFAULT_ELEMENT);
	}
	
	
	protected static void parseElementDeclaration(BufferedWriter interfaceBuffer,
												  String volumeName, XSElementDeclaration declaration, int elementType) {
		
		XSObject object;
		XSTypeDefinition baseType;
		XSComplexTypeDefinition complexType;
		
		XSAttributeDeclaration attributePSVI;
		XSParticle particle = null;
		XSTerm term = null;
		XSModelGroup modelGroup = null;
		
		try {
			String elementName = declaration.getName();
			// discard history and modifications tags
			if (!elementName.equals(HistoryTag)) {		
				interfaceBuffer.write("<" + UIGenerator.ITF_ELT_NAME + " " + UIGenerator.ITF_ATTR_NAME  + "=\"" + elementName + "\">" + "\n");			
				
				if (elementType==GenerateTemplate.LIST_ELEMENT) {
					interfaceBuffer.write("<input name=\"" + UIGenerator.SELECT_ATTR_NAME + "\" type=\"checkbox\" value=\"" + elementName + "\" />\n");
				}
				else if (elementType==GenerateTemplate.CHOICE_ELEMENT) {
					interfaceBuffer.write("<label for=\"" + elementName + "\">"+ elementName + ":</label>\n");
					interfaceBuffer.write("<input name=\"" + UIGenerator.CHOOSE_ATTR_NAME + "\" type=\"checkbox\" value=\"" + elementName + "\" />\n");
					interfaceBuffer.write("<br />\n");
					interfaceBuffer.write("<span title=\"" + elementName + "\" class=\"" + UIGenerator.ITF_HIDDEN_STYLE + "\">\n");
				}
				baseType = declaration.getTypeDefinition ();
				String typeName = declaration.getName() + "Type";
				if (baseType.getName()!=null) {
					typeName =  baseType.getName();
				}
				
				PapillonLogger.writeDebugMsg("Element: " + elementName);
				PapillonLogger.writeDebugMsg("Type Name: " + typeName);
				
				if (baseType instanceof XSSimpleTypeDefinition) {
					parseSimpleTypeDeclaration (interfaceBuffer,(XSSimpleTypeDefinition) baseType,elementName);
				}
				else if (baseType instanceof XSComplexTypeDefinition) {
					interfaceBuffer.write("  <blockquote>\n");	
					PapillonLogger.writeDebugMsg("Complex type definition");
					complexType = (XSComplexTypeDefinition) baseType; 
					
					/* Attributes */
					XSObjectList listObject = complexType.getAttributeUses ();
					if (listObject != null) {
						for (int i = 0; i < listObject.getLength (); i++) {
							object = listObject.getItem (i);
							if ((object != null) && (object instanceof XSAttributeUse)) {
								attributePSVI = ((XSAttributeUse) object).getAttrDeclaration ();
								String attrName = attributePSVI.getName();
								// avoid special attributes
								if (!attrName.equals("id")) {
									parseSimpleTypeDeclaration (interfaceBuffer,attributePSVI.getTypeDefinition(),attrName);
								}
							}
						}
					}
					
					switch (complexType.getContentType ()) {
						case XSComplexTypeDefinition.CONTENTTYPE_SIMPLE:
							PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_SIMPLE" );
							/* SimpleContent */
							XSSimpleTypeDefinition simpleTypeDefinition = complexType.getSimpleType ();
							if (simpleTypeDefinition != null) {
								PapillonLogger.writeDebugMsg ("PB in constructComplexType: a simpleTypeDefinition not managed: " + simpleTypeDefinition);
							}
								break;
							
						case XSComplexTypeDefinition.CONTENTTYPE_MIXED:
							PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_MIXED" );
							particle = complexType.getParticle ();
							/* Case where there are not element. In this case I simmulate the mixed contentType
							as a string */
							if (particle == null) {
							}
								else {
									particle = complexType.getParticle ();
									if (particle != null) {
										if (!(particle instanceof XSParticleDecl)) {
											PapillonLogger.writeDebugMsg ("-------- PB in constructComplexType: particle have a bad type.");
										}
										else {
											//					attribute = constructAttributeFromParticle ((XSParticleDecl) particle);
										}
									}
								}
								break;
							
						case XSComplexTypeDefinition.CONTENTTYPE_ELEMENT:
							//	PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_ELEMENT" );
							/* Complex type definied with a {choice, sequence or all) elements */
							particle = complexType.getParticle ();
							if (particle != null) {
								term = particle.getTerm();
								if (term instanceof XSModelGroup) {
									// PapillonLogger.writeDebugMsg ("XSModelGroup ");
									modelGroup = (XSModelGroup) term;
									if (modelGroup.getCompositor()==XSModelGroup.COMPOSITOR_SEQUENCE) {
										//	PapillonLogger.writeDebugMsg ("Compositor sequence");
										XSObjectList myList = modelGroup.getParticles();
										for (int j=0;j<myList.getLength();j++) {
											XSParticle tempParticle = (XSParticle)myList.getItem(j);
											term = tempParticle.getTerm();
											int newTypeElement = DEFAULT_ELEMENT;
											if (tempParticle.getIsMaxOccursUnbounded()) {
												// list	
												interfaceBuffer.write("  List of " +  term.getName() + "s:\n");
												interfaceBuffer.write("  <input name=\"" + elementName + "\" onclick=\"this.form.AddCall.value='" + ((XSElementDeclaration) term).getName() + UIGenerator.PARAMETERS_SEPARATOR + "\" type=\"submit\" value=\"+\" />\n");
												interfaceBuffer.write("  <input name=\"" + elementName + "\" onclick=\"this.form.DelCall.value='" + ((XSElementDeclaration) term).getName() + UIGenerator.PARAMETERS_SEPARATOR + "\" type=\"submit\" value=\"-\" />\n");
												interfaceBuffer.write("  <br />\n");
												PapillonLogger.writeDebugMsg(" list element: " + ((XSElementDeclaration) term).getName());
												newTypeElement = LIST_ELEMENT;
											}
											if (term instanceof XSElementDeclaration) {
												parseElementDeclaration(interfaceBuffer, volumeName, 
																		(XSElementDeclaration) term, newTypeElement);
											}	
										}																					
									}
									else if (modelGroup.getCompositor()==XSModelGroup.COMPOSITOR_CHOICE) {
										PapillonLogger.writeDebugMsg ("Compositor choice");
										// choice
										interfaceBuffer.write("  <span title=\"" +  
											UIGenerator.CHOICE_NODE_NAME + UIGenerator.PARAMETERS_SEPARATOR + elementName
											+ "\">\n");
										interfaceBuffer.write("  Choice for " +  elementName + ":\n");
										interfaceBuffer.write("  <input name=\"" + elementName + "\" onclick=\"this.form.ChooseCall.value='" + elementName + UIGenerator.PARAMETERS_SEPARATOR + "\" type=\"submit\" value=\"||\" />\n");
										interfaceBuffer.write("  <br />\n</span>\n");
										XSObjectList myList = modelGroup.getParticles();
										for (int j=0;j<myList.getLength();j++) {
											XSParticle tempParticle = (XSParticle)myList.getItem(j);
											term = tempParticle.getTerm();
											if (term instanceof XSElementDeclaration) {
												PapillonLogger.writeDebugMsg(" choice element: " + ((XSElementDeclaration) term).getName());
												parseElementDeclaration(interfaceBuffer, volumeName, 
																		(XSElementDeclaration) term, CHOICE_ELEMENT);
											}	
										}
									}
								}
								if (!(particle instanceof XSParticleDecl)) {
									PapillonLogger.writeDebugMsg ("-------- PB in constructComplexType: particle have a bad type.");
								}
								else {
									//		attribute = constructAttributeFromParticle ((XSParticleDecl) particle);
									//		if (attribute != null)
									//			concept.addAttributeRelationID (attribute.getID (), currentContainer.version.getID ());
								}
							}
								break;
							
						case XSComplexTypeDefinition.CONTENTTYPE_EMPTY:
							PapillonLogger.writeDebugMsg ("************************CONTENTTYPE_EMPTY" );
							/* Complex type definied only with attibutes */
							break;
		}
					interfaceBuffer.write("  </blockquote>\n");	
	}
				if (elementType==GenerateTemplate.CHOICE_ELEMENT) {
					interfaceBuffer.write("</span>\n");
				}
				interfaceBuffer.write("</" + UIGenerator.ITF_ELT_NAME + ">\n");	
		}
		}
		catch (java.io.IOException IOEx) {
			IOEx.printStackTrace();
		}		
	}
	
	protected static void parseSimpleTypeDeclaration (BufferedWriter interfaceBuffer, 
													  XSSimpleTypeDefinition simpleTypeDefinition, String elementName) 
		throws java.io.IOException {
			String typeName = simpleTypeDefinition.getName();
			PapillonLogger.writeDebugMsg("Simple type definition: " + elementName + " type: " + typeName);
			interfaceBuffer.write("  <label for=\"" + elementName + "\" >" + elementName + ":</label>\n");	
			// we do not manage all the different types, we can only use a checkbox, a text box and a select
			// for a closed list, we use a select with a list of options
			if (simpleTypeDefinition.getIsDefinedFacet(XSSimpleTypeDefinition.FACET_ENUMERATION)) {
				interfaceBuffer.write("    <select name=\"" + elementName + "\" >" + "\n");			
				StringList stringList = simpleTypeDefinition.getLexicalEnumerations ();
				for (int i=0; i < stringList.getLength (); i++) {
					interfaceBuffer.write("      <option value=\"" + stringList.item(i) + "\">" + stringList.item(i) + "</option>\n");			
				}
				interfaceBuffer.write("    </select>" + "\n");	
				interfaceBuffer.write("<br />\n");					
			}
			// for a boolean, we use a checkbox.
			else if (typeName!= null && typeName.equals("boolean")) {
				interfaceBuffer.write("    <input name=\"" + UIGenerator.BOOLEAN_ATTR_NAME + "\" type=\"checkbox\" value=\"" + elementName + "\" />\n");			
				interfaceBuffer.write("<br />\n");					
			}
			else if (typeName!= null && typeName.equals("integer")) {
				interfaceBuffer.write("    <input name=\"" + elementName + "\" type=\"text\" onkeyup=\"this.value=this.value.replace(/\\D/,'')\" onchange=\"this.value=this.value.replace(/\\D/g,'')\" value=\"\" />\n");			
				interfaceBuffer.write("<br />\n");			
			}
			// for all the other cases, we use a text box.
			else {
				//	if (typeName!= null && typeName.equals("string")) {
				interfaceBuffer.write("    <input name=\"" + elementName + "\" type=\"text\" value=\"\" />" + "\n");			
				interfaceBuffer.write("<br />\n");			
				}
			}
	
		}
