//
//  UIGenerator.java
//  PapillonStable
//
//  Created by Mathieu Mangeot on Wed Sep 15 2004.
//  Copyright (c) 2004 __MyCompanyName__. All rights reserved.
//

package fr.imag.clips.papillon.business.edition;

// utils
import java.util.Vector;

// internal imports
import fr.imag.clips.papillon.business.PapillonLogger;

// DOM elements
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class UIGenerator {
	
	
	// constants
	
	public static final String ID_SEPARATOR = ".";
	public static final String PARAMETERS_SEPARATOR = "+";
	public static final String ITF_ELT_NAME = "span";
	public static final String ITF_ATTR_NAME = "class";
	public static final String ITF_HIDDEN_STYLE = "hidden";
	public static final String SELECT_ATTR_NAME = "select";
	public static final String CHOOSE_ATTR_NAME = "choose";
	public static final String BOOLEAN_ATTR_NAME = "boolean";
	
	public static final String CHOICE_NODE_NAME = "xsd:choice";
	
	
	/******************************************************/
	/* Public methods                                     */
	/******************************************************/
	
	public static void fillInterfaceTemplate(Element entryElt, Element rootItfElt,Element itfTemplate) {
		Element correspItf = UIGenerator.findCorrespondingElement(entryElt,rootItfElt, "root.0");
		
		UIGenerator.fillTemplate(entryElt,correspItf, itfTemplate);
	}
	
	public static boolean addElement(String elementName, String parentId, Element entryElt, Element entryTemplate) {
		PapillonLogger.writeDebugMsg("addElement: " + elementName + " parent: " + parentId);	
		boolean found = false;
		
		int indexOfPt = parentId.lastIndexOf(ID_SEPARATOR);
		String parentName = "";
		String parentNb = "";
		
		if (indexOfPt>0) {
			parentName = parentId.substring(0,indexOfPt);
			parentNb = parentId.substring(indexOfPt+1);
			
			Element parentElt = findElementInEntry(parentName, parentNb, entryElt);
			if (parentElt!=null) {
				found = true;
				Element myElement = getTemplateEntryElement(elementName,parentName,entryTemplate);
				insertEntryElement(parentElt,myElement);
			}
		}
		
		return found;
	}
	
	public static boolean chooseElement(String elementId, String parentId, Element entryElt, Element entryTemplate) {
		PapillonLogger.writeDebugMsg("chooseElement: " + elementId + " parent: " + parentId);	
		boolean found = false;
		
		int indexOfPt = parentId.lastIndexOf(ID_SEPARATOR);
		String parentName = "";
		String parentNb = "";
		
		if (indexOfPt>0) {
			parentName = parentId.substring(0,indexOfPt);
			parentNb = parentId.substring(indexOfPt+1);
			Element resultParent = findElementInEntry(parentName, parentNb, entryElt);
			if (resultParent!=null) {
				int indexOfElt = elementId.lastIndexOf(ID_SEPARATOR);
				String elementName = "";
				String elementNb = "";
				if (indexOfElt>0) {
					elementName = elementId.substring(0,indexOfElt);
					elementNb = elementId.substring(indexOfElt+1);
					Element templateElt = getTemplateEntryElement(elementName,parentName,entryTemplate);
					if (templateElt!=null) {
						found = true;
						Node chooseNode = getChildNode(resultParent,CHOICE_NODE_NAME);
						Node resNode = resultParent.getOwnerDocument().importNode(templateElt,true);
						resultParent.replaceChild(resNode,chooseNode);
					}
				}
			}
		}
		return found;
	}
	
	
	// Update an element in the XML entry entryElt with the new value value
	public static boolean updateElement(String elementId, String value, Element entryElt) {
		PapillonLogger.writeDebugMsg("updateElement: " + elementId + " value: " + value);	
		boolean found = false;
		boolean isAttribute =  (elementId.indexOf(ID_SEPARATOR)!= elementId.lastIndexOf(ID_SEPARATOR));
		String attrName = "";
		
		if (isAttribute) {
			attrName = elementId.substring(elementId.lastIndexOf(ID_SEPARATOR)+1);
			elementId = elementId.substring(0,elementId.lastIndexOf(ID_SEPARATOR));
		}
		
		int indexOfPt = elementId.lastIndexOf(ID_SEPARATOR);
		String elementName = "";
		String eltNb = "";
		
		if (indexOfPt>0) {
			elementName = elementId.substring(0,indexOfPt);
			eltNb = elementId.substring(indexOfPt+1);
			
			Element resultElt = findElementInEntry(elementName, eltNb,entryElt);
			if (resultElt!=null) {
				found=true;
				if (isAttribute) {
					resultElt.setAttribute(attrName,value);
				}
				else {
					NodeList childNodes = resultElt.getChildNodes();
					for (int j=0;j<childNodes.getLength();j++) {
						resultElt.removeChild(childNodes.item(j));
					}
					Node textNode = resultElt.getOwnerDocument().createTextNode(value);
					resultElt.appendChild(textNode);
				}
			}
		}		
		return found;
	}
	
	public static void deleteElements(String elementName, String[] elementIds, Element entryElt) {
		//	PapillonLogger.writeDebugMsg("deleteElements: " + elementName);
		NodeList myNodeList = entryElt.getElementsByTagName (elementName);
		Vector removeNodes = new Vector();
		for (int i=0; i<elementIds.length;i++) {
			String elementId = elementIds[i];
			int indexOfPt = elementId.lastIndexOf(ID_SEPARATOR);
			String currentName = "";
			String currentNb = "";
			if (indexOfPt>0) {
				currentName = elementId.substring(0,indexOfPt);
				currentNb = elementId.substring(indexOfPt+1);
			}
			if (currentNb!=null && !currentNb.equals("") && 
				elementName!=null && elementName.equals(currentName)) {
				int itemNb = Integer.parseInt(currentNb);
				Element resultElt = (Element) myNodeList.item(itemNb);
				removeNodes.add(resultElt);
			}
		}
		
		for (int i=0; i<removeNodes.size();i++) {
			Element removeElt = (Element) removeNodes.elementAt(i);
			removeElt.getParentNode().removeChild(removeElt);
		}
	}
	
	public static boolean setValueInput(Element itfElt, String correspName, String value) {
		PapillonLogger.writeDebugMsg("setValueInput: " + correspName);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("input");
		int i=0;
		while (i<myNodeList.getLength () && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String name = currentElt.getAttribute("name");
			if (name !=null && name.equals(correspName)) {
				String type = currentElt.getAttribute("type");
				currentElt.setAttribute("value", value);
				found = true;
			}	
			i++;
		}
		return found;
	}
	
	
	
	/******************************************************/
	/* protected methods								  */
	/******************************************************/
	
	protected static void fillTemplate(Node entryNode, Element itfElt,Element itfTemplate) {
		fillTemplate(entryNode, itfElt, itfTemplate, "");
	}
	
	protected static void fillTemplate(Node entryNode, Element itfElt,Element itfTemplate, String oldId) {
		if (itfElt !=null) {
			String newId = createId(entryNode, oldId);
			String entryNodeName = entryNode.getNodeName();
			PapillonLogger.writeDebugMsg("fillTemplate Node: " + entryNodeName + " ID: " + newId);
			
			setIdCorrespondingSubmitInputs(entryNodeName, itfElt, newId);
			setIdCorrespondingLabel(entryNodeName, itfElt, newId);
			setIdCorrespondingSelectCheckbox(entryNodeName,itfElt, newId);
	
			// special handling of the xsd:choice schema directive
			Node parentNode = entryNode.getParentNode();
			if (parentNode!= null && !parentNode.getNodeName().equals(CHOICE_NODE_NAME)) {
				setClassCorrespondingSpan(entryNodeName,"",itfElt);
			}
			Node choiceChild = getChildNode(entryNode, CHOICE_NODE_NAME);
			if (choiceChild==null) {
				setClassCorrespondingSpan(CHOICE_NODE_NAME + PARAMETERS_SEPARATOR + entryNodeName,ITF_HIDDEN_STYLE, itfElt);
			}
			
			// computing attributes
			NamedNodeMap myNodeMap = entryNode.getAttributes();
			if (myNodeMap!=null) {
				for (int i=0; i< myNodeMap.getLength();i++) {
					Attr myAttribute = (Attr) myNodeMap.item(i);
					fillTemplate(myAttribute, itfElt, itfTemplate, newId);
				}
			}
			
			// computing child elements
			String inputValue = "";
			if (entryNode.hasChildNodes ()) {
				NodeList myNodeList = entryNode.getChildNodes ();
				Node previousNode = null;
				Element correspItf;
				for (int i = 0; i < myNodeList.getLength (); i++) {
					Node nodeItem = myNodeList.item(i);
					switch (nodeItem.getNodeType()) {
						// an attribute note is not a child node
						// so, this case should not be present 
						// attributes are computed later
						case  Node.ATTRIBUTE_NODE:
							fillTemplate(nodeItem, itfElt, itfTemplate, newId);
							break;
							// this case case should not be present.
						case  Node.DOCUMENT_NODE:
							fillTemplate(((Document) nodeItem).getDocumentElement() ,itfElt, itfTemplate, newId);
							break;
						case  Node.ELEMENT_NODE:
							// If the previous node is of the same type, then duplicate the previous corresponding interface node 
							if (previousNode!=null && nodeItem.getNodeName().equals(previousNode.getNodeName())) {
								correspItf = findCorrespondingElement((Element) previousNode,itfElt, newId);
								correspItf = duplicateInterfaceElement((Element) nodeItem,correspItf,itfTemplate, newId);
							}
							else {
								correspItf = findCorrespondingElement((Element) nodeItem,itfElt, newId);
							}
							previousNode = nodeItem;
							fillTemplate(nodeItem,correspItf, itfTemplate, newId);
							break;
						case Node.TEXT_NODE:
							inputValue = nodeItem.getNodeValue();
							// virer tous les blancs de nodevalue
							break;
						default:
							break;
					}
				}
			}
			boolean found = setIdValueCorrespondingTextInput(entryNodeName,itfElt, newId, inputValue);
			if (!found) {
				setIdValueCorrespondingSelect(entryNodeName,itfElt, newId, inputValue);
			}
			if (!found) {
				setIdValueCorrespondingBooleanCheckbox(entryNodeName,itfElt, newId, inputValue);
			}
		}
	}
	
	protected static int getElementNumber(Element entryElt) {
		Document myDoc = entryElt.getOwnerDocument();
		NodeList myNodeList = myDoc.getElementsByTagName (entryElt.getNodeName());
		int idCount=0;
		int i=0;
		boolean found = false;
		while (i<myNodeList.getLength() && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			if (currentElt==entryElt) {
				idCount=i;
				found= true;
			}	
			i++;
		}
		return idCount;
	}
	
	protected static String createId(Node entryNode, String eltId) {
		String idString = ""; 
		switch (entryNode.getNodeType()) {
			// this case case should not be present. It is solved in the next section
			case  Node.ATTRIBUTE_NODE:
				idString = eltId + ID_SEPARATOR + entryNode.getNodeName();
				break;
			case  Node.DOCUMENT_NODE:
				idString = entryNode.getNodeName() + ID_SEPARATOR + getElementNumber(((Document) entryNode).getDocumentElement());
				break;
			case  Node.ELEMENT_NODE:
				idString = entryNode.getNodeName() + ID_SEPARATOR + getElementNumber((Element) entryNode);
				break;
			case Node.TEXT_NODE:
				// this case case should not be present.
				idString = entryNode.getNodeName() + ID_SEPARATOR + "0";
				break;
			default:
				// this case case should not be present.
				idString = entryNode.getNodeName() + ID_SEPARATOR + "0";
				break;
		}
		return idString;
	}
	
	public static Element findCorrespondingElement(Element entryElt, Element itfElt, String newId) {
		return findCorrespondingElement(entryElt, itfElt, newId, false);
	}
	
	protected static Element findCorrespondingElement(Element entryElt, Element itfElt, String newId, boolean template) {
		//	PapillonLogger.writeDebugMsg("findCorrespondingElement " + entryElt.getNodeName() + " id: " + newId + " itfelt: " + itfElt.getNodeName() + " class: " + itfElt.getAttribute("class"));
		int entryElementNumber = getElementNumber(entryElt);
		Element resultElt = null;
		String entryEltName = entryElt.getNodeName();
		NodeList myNodeList = itfElt.getElementsByTagName (ITF_ELT_NAME);
		int i=0;
		int itfElementNumber = 0;
		while (i<myNodeList.getLength () && resultElt==null) {
			Element currentElt = (Element) myNodeList.item(i);
			String myAttr = currentElt.getAttribute(ITF_ATTR_NAME);
			if (myAttr !=null) {
				if (myAttr.equals(entryEltName)) {
					// When the interface element comes from the interface template
					if (template) {
						resultElt = currentElt;
					}
					else if (itfElementNumber==entryElementNumber) {
						resultElt = currentElt;
					}
					else {
						itfElementNumber++;
					}
				}
			}	
			i++;	
		}
		if (resultElt==null && !template) {
			resultElt = itfElt;
		} 
		return resultElt;
	}
	
	protected static boolean setIdCorrespondingLabel(String label, Element itfElt, String newId) {
		//	PapillonLogger.writeDebugMsg("setIdCorrespondingLabel: " + label);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("label");
		int i=0;
		while (i<myNodeList.getLength () && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String name = currentElt.getAttribute("for");
			if (name !=null && name.equals(label)) {
				currentElt.setAttribute("for", newId);
				found = true;
			}	
			i++;	
		}
		return found;
	}
	
	protected static boolean setClassCorrespondingSpan(String spanTitle, String classType, Element itfElt) {
		//	PapillonLogger.writeDebugMsg("setClassCorrespondingSpan: " + spanTitle + " class: " + classType);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("span");
		int i=0;
		while (i<myNodeList.getLength () && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String name = currentElt.getAttribute("title");
			if (name !=null && name.equals(spanTitle)) {
				currentElt.setAttribute("class", classType);
				found = true;
			}	
			i++;	
		}
		return found;
	}
	
	protected static boolean setIdCorrespondingSubmitInputs(String correspName, Element itfElt, String newId) {
		//		PapillonLogger.writeDebugMsg("setIdCorrespondingSubmitInputs: " + correspName);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("input");
		for (int i=0;i<myNodeList.getLength ();i++) {
			Element currentElt = (Element) myNodeList.item(i);
			String name = currentElt.getAttribute("name");
			if (name !=null && name.equals(correspName)) {
				String type = currentElt.getAttribute("type");
				if (type !=null && type.equals("submit")) {
					currentElt.setAttribute("onclick", currentElt.getAttribute("onclick") + newId +"'");
					found = true;
				}
			}	
		}
		return found;
	}
	
	protected static boolean setIdValueCorrespondingTextInput(String correspName, Element itfElt, String newId, String value) {
		//		PapillonLogger.writeDebugMsg("findCorrespondingTextInput: " + correspName);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("input");
		int i=0;
		while (i<myNodeList.getLength() && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String name = currentElt.getAttribute("name");
			if (name !=null && name.equals(correspName)) {
				String type = currentElt.getAttribute("type");
				if (type !=null && (type.equals("text") || type.equals("textarea"))) {
					currentElt.setAttribute("name", newId);
					currentElt.setAttribute("id", newId);
					currentElt.setAttribute("value", value);
					found = true;
				}
			}
			i++;	
		}
		return found;
	}
	
	protected static boolean setIdCorrespondingSelectCheckbox(String correspName, Element itfElt, String newId) {
		//		PapillonLogger.writeDebugMsg("setIdCorrespondingCheckbox: " + correspName);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("input");
		int i=0;
		while (i<myNodeList.getLength () && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String name = currentElt.getAttribute("name");
			String type = currentElt.getAttribute("type");
			if ((name.equals(SELECT_ATTR_NAME) || name.equals(CHOOSE_ATTR_NAME))
				&& type.equals("checkbox")) {
				String value = currentElt.getAttribute("value");
				if (value.equals(correspName)) {
					currentElt.setAttribute("id",newId);
					currentElt.setAttribute("value",newId);
					found = true;
				}
			}	
			i++;	
		}		
		return found;
	}
	
	protected static boolean setIdValueCorrespondingBooleanCheckbox(String correspName, Element itfElt, String newId, String newValue) {
		PapillonLogger.writeDebugMsg("setIdValueCorrespondingBooleanCheckbox: " + correspName + " id: " + newId + " value: " + newValue);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("input");
		int i=0;
		while (i<myNodeList.getLength () && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String name = currentElt.getAttribute("name");
			String type = currentElt.getAttribute("type");
			if (name.equals(BOOLEAN_ATTR_NAME) && type.equals("checkbox")) {
				String value = currentElt.getAttribute("value");
				if (value.equals(correspName)) {
					if (newValue!=null && newValue.equals("true")) {
						currentElt.setAttribute("checked",newValue);
					}
					currentElt.setAttribute("id",newId);
					currentElt.setAttribute("value",newId);
					found = true;
				}
			}	
			i++;	
		}		
		return found;
	}
	
	
	protected static boolean setIdValueCorrespondingSelect(String correspName, Element itfElt, String newId, String value) {
		//	PapillonLogger.writeDebugMsg("setIdValueCorrespondingSelect: " + correspName);
		boolean found = false;
		NodeList myNodeList = itfElt.getElementsByTagName ("select");
		int i=0;
		while (i<myNodeList.getLength () && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String myAttr = currentElt.getAttribute("name");
			if (myAttr !=null) {
				if (myAttr.equals(correspName)) {
					setSelected(currentElt,value);
					currentElt.setAttribute("name",newId);
					currentElt.setAttribute("id",newId);
					found = true;
				}
			}	
			i++;	
		}		
		return found;
	}
	
	protected static boolean setSelected(Element itfElt, String value) {
		//		PapillonLogger.writeDebugMsg("setSelected: " + value);
		NodeList myNodeList = itfElt.getElementsByTagName("option");
		boolean found = false;
		int i=0;
		while (i<myNodeList.getLength () && !found) {
			Element currentElt = (Element) myNodeList.item(i);
			String myAttr = currentElt.getAttribute("value");
			if (myAttr !=null) {
				if (myAttr.equals(value)) {
					currentElt.setAttribute("selected","selected");
					found = true;
				}
			}	
			i++;	
		}		
		return found;
	}
	
	
	protected static Element duplicateInterfaceElement(Element entryElt, Element itfElt, Element itfTemplate,String newId) {
		PapillonLogger.writeDebugMsg("duplicateInterfaceElement: " + entryElt.getNodeName() + " itf: " + itfElt.getNodeName());	
		Vector nodeVector = new Vector();
		boolean template = true;
		Element resElt = (Element) findCorrespondingElement(entryElt,itfTemplate, newId, template);
		if (resElt !=null) {
			
			Document itfDoc = itfElt.getOwnerDocument();
			resElt = (Element) itfDoc.importNode(resElt,true);
			Element parentElement = (Element) itfElt.getParentNode();
			
			NodeList childNodes = parentElement.getChildNodes();
			boolean found = false;
			int i=0;
			while (i<childNodes.getLength () && !found) {
				Node nodeItem = childNodes.item(i);
				if (nodeItem.getNodeType()== Node.ELEMENT_NODE) {
					Element currentElt = (Element) nodeItem;		
					String myAttr = currentElt.getAttribute(ITF_ATTR_NAME);
					if (myAttr !=null) {
						found = (myAttr.equals(entryElt.getNodeName()));				
					}
				}	
				i++;	
			}		
			
			boolean other = false;
			while (i<childNodes.getLength () && !other) {
				Node nodeItem = childNodes.item(i);
				if (nodeItem.getNodeType()== Node.ELEMENT_NODE) {
					Element currentElt = (Element) nodeItem;		
					String myAttr = currentElt.getAttribute(ITF_ATTR_NAME);
					if (myAttr !=null) {
						other = (!myAttr.equals(entryElt.getNodeName()));
					}
					else {
						other=true;
					}
				}	
				i++;	
			}		
			i--;
			if (i<childNodes.getLength ()) {
				parentElement.insertBefore(resElt,childNodes.item(i));
			}
			else {
				parentElement.appendChild(resElt);
			}
		}
		return resElt;
	}
	
	
	protected static Element insertEntryElement(Element parentElement, Element newElement) {
		//		PapillonLogger.writeDebugMsg("insertEntryElement: " + newElement.toString() + " parent: " + parentElement.toString());	
		Vector nodeVector = new Vector();
		
		Element resElt = (Element) parentElement.getOwnerDocument().importNode(newElement,true);
		NodeList childNodes = parentElement.getChildNodes();
		boolean found = false;
		int i=0;
		while (i<childNodes.getLength () && !found) {
			Node nodeItem = childNodes.item(i);
			if (nodeItem.getNodeType()== Node.ELEMENT_NODE) {
				Element currentElt = (Element) nodeItem;	
				found = (currentElt.getNodeName().equals(resElt.getNodeName()));
			}	
			i++;	
		}		
		
		boolean other = false;
		while (i<childNodes.getLength () && !other) {
			Node nodeItem = childNodes.item(i);
			if (nodeItem.getNodeType()== Node.ELEMENT_NODE) {
				Element currentElt = (Element) nodeItem;		
				other = (!currentElt.getNodeName().equals(resElt.getNodeName()));
			}	
			i++;	
		}		
		i--;
		if (i<childNodes.getLength ()) {
			parentElement.insertBefore(resElt,childNodes.item(i));
		}
		else {
			parentElement.appendChild(resElt);
		}
		return resElt;
	}
	
	protected static Element getTemplateEntryElement(String elementName, String parentName, Element entryTemplate) {
		PapillonLogger.writeDebugMsg("getTemplateEntryElement: " + elementName + " parent: " + parentName + " tmpl: " + entryTemplate.toString());
		Element resElt = null;
		NodeList parentNodes = entryTemplate.getElementsByTagName(parentName);
		if (parentNodes.getLength()>0) {
			Element myParent = (Element) parentNodes.item(0);
			NodeList myNodes = myParent.getElementsByTagName(elementName);
			if (myNodes.getLength()>0) {
				resElt = (Element)myNodes.item(0);
			}
		}
		return resElt;
	}
	
	protected static Element findElementInEntry(String eltName, String eltNb, Element entryElt) {
		Element resultElt = null;
		boolean found = false;
		NodeList myNodeList = entryElt.getElementsByTagName (eltName);
		int i=0;
		while (i<myNodeList.getLength() && !found) {
			resultElt = (Element) myNodeList.item(i);
			found = eltNb.equals(i + "");
			i++;
		}
		return resultElt;
	}
	
	protected static Node getChildNode(Node parentNode, String childName) {
		Node resultNode = null;
		boolean found = false;
		NodeList myNodeList = parentNode.getChildNodes ();
		int i=0;
		while (i<myNodeList.getLength() && !found) {
			Node tempNode = myNodeList.item(i);
			if (tempNode.getNodeName().equals(childName)) {
				found = true;
				resultNode= tempNode;
			}
			i++;
		}
		return resultNode;
	}
	
}
