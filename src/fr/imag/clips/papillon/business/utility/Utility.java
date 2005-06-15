/*
*
*----------------------------------------
*$Id$
*------------------------------------------
*$Log$
*Revision 1.4  2005/06/15 16:48:28  mangeot
*Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
*
*Revision 1.3.4.4  2005/06/01 08:38:43  mangeot
*Multi bug correction + added the possibility of disabling data edition
*via the Admin.po page
*
*Revision 1.3.4.3  2005/05/19 17:02:22  mangeot
*Importing entries without the contribution element
*
*Revision 1.3.4.2  2005/04/29 17:30:30  mangeot
**** empty log message ***
*
*Revision 1.3.4.1  2005/04/29 14:50:25  mangeot
*New version with contribution infos embedded in the XML of the entries
*
*Revision 1.3  2005/04/11 12:29:59  mangeot
*Merge between the XPathAndMultipleKeys branch and the main trunk
*
*Revision 1.2.2.2  2005/01/27 15:56:21  mangeot
*Able to load a volume with XPointers, cannot lookup the result yet.
*Does not compile but commit for backup
*
*Revision 1.2.2.1  2005/01/25 13:54:54  mangeot
*changed the volume volumeEntry and index objects. Does not compile but need a backup...
*
*Revision 1.2  2004/12/24 14:31:28  mangeot
*I merged the latest developments of Papillon5.0 with this version 5.1.
*Have to be tested more ...
*
*Revision 1.1.1.1  2004/12/06 16:38:32  serasset
*Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
*There are still bugs in the code.
*
*--------------------------------------
*/
package fr.imag.clips.papillon.business.utility;

import java.io.*;

//pour parser le document avec le DOM
import org.w3c.dom.*;

//for URLs
import java.net.URL;


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
import org.apache.xml.serialize.*;
import org.apache.xalan.serialize.*;

//pour utiliser ant: untar
import org.apache.tools.tar.*;


//pour parser les doc html
import org.w3c.tidy.Tidy; 
import org.w3c.tidy.Configuration;

// pour les sax
import org.xml.sax.InputSource;

import fr.imag.clips.papillon.business.PapillonLogger;

public class Utility {


	public static final java.util.Locale PapillonLocale = new java.util.Locale("C");
	public static final java.text.DateFormat PapillonPrintDateFormat = new java.text.SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", PapillonLocale);
	public static final java.text.DateFormat PapillonCDMDateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss", PapillonLocale);
	public static final java.text.DateFormat PapillonShortDateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd", PapillonLocale);

	// constants
	protected static final  String MESSAGE_ENCODING="UTF-8";
	protected static final DocumentBuilderFactory myDocumentBuilderFactory = DocumentBuilderFactory.newInstance();

	// variables
	protected static DocumentBuilder myDocumentBuilder = null;
	protected static SerializerToText mySerializerToText = new SerializerToText();
	// FIXME: there may be an encoding problem because we use the default encoding here instead of UTF-8
	// in order to build the Outputformat("text","UTF-8",true);	
	protected static OutputFormat myOutputFormat = new OutputFormat();
		 
		/**
     * Serialize the DOM element
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
   public static String NodeToString(Element N) {
		 String res = "";
        if (N!=null) {
					try {
						StringWriter myStringWriter = new StringWriter();
						myOutputFormat.setMethod("text");
						myOutputFormat.setIndenting(true);
            XMLSerializer myXMLSerializer = new XMLSerializer(myStringWriter, myOutputFormat);
            myXMLSerializer.serialize(N);
            res= myStringWriter.toString();
					}
					catch (java.io.IOException ioe) {
						PapillonLogger.writeDebugMsg ("NodeToString: java.io.IOException: " + ioe);
					}
        }
				return res;
			}
    
		/**
     * Serialize the DOM node
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public static String NodeToString(Node N) {
			String res = "";
        if (N!=null ) {
					try {
						StringWriter myStringWriter = new StringWriter();
            mySerializerToText.setWriter(myStringWriter);
            mySerializerToText.serialize(N);
            res= myStringWriter.toString();
					}
					catch (java.io.IOException ioe) {
						PapillonLogger.writeDebugMsg ("NodeToString: java.io.IOException: " + ioe);
					}
        }
				return res;
			}

		/**
     * Serialize the DOM Document
     *
     * @return the xml code as a string.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
  public static String NodeToString(Document N) {
		String res = "";
    if (N!= null && N.getDocumentElement()!=null ) {
				try {
						StringWriter myStringWriter = new StringWriter();
						myOutputFormat.setMethod("text");
						myOutputFormat.setIndenting(true);
						XMLSerializer myXMLSerializer = new XMLSerializer(myStringWriter, myOutputFormat);
            myXMLSerializer.serialize(N);
            res= myStringWriter.toString();
				}
				catch (java.io.IOException ioe) {
					PapillonLogger.writeDebugMsg ("NodeToString: java.io.IOException: " + ioe);
				}
			}
		return res;
		}
		
		/**
     * Builds a DOM document from an URL
     *
     * @return the DOM Document
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static org.w3c.dom.Document buildDOMTree(URL theUrl)	{
		return buildDOMTreeFromUrl (theUrl.toString());
	}

		/**
     * Builds a DOM document from an XML String
     *
     * @return the DOM Document
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static org.w3c.dom.Document buildDOMTree (String xmlInputString)	{
		Reader myReader = new StringReader (xmlInputString);
		return buildDOMTree (new InputSource(myReader));
	}

		/**
     * Builds a DOM document from an XML InputSource
     *
     * @return the DOM Document
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static org.w3c.dom.Document buildDOMTree (InputSource mySource)	{
		org.w3c.dom.Document contentDocument = null;

		try {
			if (myDocumentBuilder == null) {
				myDocumentBuilderFactory.setNamespaceAware(true);
				myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
				}			
			// building the source DOM object
			
			contentDocument = myDocumentBuilder.parse (mySource);
		}
		catch (javax.xml.parsers.ParserConfigurationException pce) {
			PapillonLogger.writeDebugMsg ("ParserConfigurationException: " + pce);
		}		
		catch (org.xml.sax.SAXException saxe) {
			PapillonLogger.writeDebugMsg ("org.xml.sax.SAXException: " + saxe);
		}
		catch (java.io.IOException ioe) {
			PapillonLogger.writeDebugMsg ("java.io.IOException: " + ioe);
		}
		if (null == contentDocument ) { 			
			PapillonLogger.writeDebugMsg ("DOCUMENT IS NULL !!!! ");
		}
		return contentDocument;
	}
	
		/**
     * Builds a DOM document from an URL String
     *
     * @return the DOM Document
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
		public static org.w3c.dom.Document buildDOMTreeFromUrl (String url)	{
		org.w3c.dom.Document contentDocument = null;

		try {
			if (myDocumentBuilder == null) {
				myDocumentBuilderFactory.setNamespaceAware(true);
				myDocumentBuilder = myDocumentBuilderFactory.newDocumentBuilder();
				}			
			// building the source DOM object
			
			contentDocument = myDocumentBuilder.parse (url);
		}
		catch (javax.xml.parsers.ParserConfigurationException pce) {
			PapillonLogger.writeDebugMsg ("ParserConfigurationException: " + pce);
		}		
		catch (org.xml.sax.SAXException saxe) {
			PapillonLogger.writeDebugMsg ("org.xml.sax.SAXException: " + saxe);
		}
		catch (java.io.IOException ioe) {
			PapillonLogger.writeDebugMsg ("java.io.IOException: " + ioe);
		}
		return contentDocument;
	}

		/**
     * Gets the String value of the text ChildNodes
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static String getStringValue(Node myNode) {
		String resString = "";
		if (myNode.hasChildNodes ()) {
			NodeList myNodeList = myNode.getChildNodes ();
			for (int i = 0; i < myNodeList.getLength (); i++) {
				Node nodeItem = myNodeList.item(i);
				switch (nodeItem.getNodeType()) {
					case Node.DOCUMENT_NODE:
						resString += getStringValue(((Document)nodeItem).getDocumentElement());
						break;
					case  Node.ELEMENT_NODE:
						String childString = getStringValue(nodeItem);
						resString += childString;
						break;
					case Node.TEXT_NODE:
						resString += nodeItem.getNodeValue ();
						break;
					default:
						break;
				}
			}
		}
		return resString;
	}

		/**
     * Gets the normalized String value of the text ChildNodes
     *
     * @return a normalized String (all spaces equals one space)
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static String getNormalizedStringValue(Node myNode) {
		return normalizeSpaces(getStringValue(myNode));
	}
	
	/**
     * DOM convenience method getTextChild of an element
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */	
		public static String getText(Element myElt) {
		String res = "";
		if (myElt.hasChildNodes()) {
			NodeList childNodes = myElt.getChildNodes();
			for (int i=0; i< childNodes.getLength();i++) {
				res += childNodes.item(i).getNodeValue();
			}
		}
		return res;
	}
	
	/**
     * DOM convenience method setTextChild of an element
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */	
	public static void setText(Element myElt, String myValue) {
		Node myTextNode = myElt.getOwnerDocument().createTextNode(myValue);
		removeChildNodes(myElt);
		myElt.appendChild(myTextNode);
	}

	public static void removeChildNodes(Element myElt) {
		if (myElt.hasChildNodes()) {
			NodeList childNodes = myElt.getChildNodes();
			for (int i=0; i< childNodes.getLength();i++) {
				myElt.removeChild(childNodes.item(i));
			}
		}
	}


	
    public static Node[] addItem(Node newNode,Node[] objList)    
    {
    if ((objList==null)||(objList.length==0))
        {
        objList=new Node[1];
        objList[0]=newNode;
        } else
        {
        Node[] swap=(Node[])objList.clone();
        objList=new Node[objList.length+1];
        //copy old 
        for (int k=0;k<(objList.length-1);k++)                    
            {
                        objList[k]=swap[k];                        
            }
        objList[objList.length-1]=newNode;
        }
    return objList;        
        
    }
    
    
    public static File[] Untar(String file_source,String file_dest) throws  FileNotFoundException,IOException
    {
              
        String srcF = file_source;
        String dir = file_dest;
        TarInputStream tis = null;
        PapillonLogger.writeDebugMsg("Expanding: " + srcF + " into " + dir);
        tis = new TarInputStream(new FileInputStream(srcF));
        TarEntry te = null;
        File[] fileArray=null;
        while ((te = tis.getNextEntry()) != null) {
                
            File f = new File(dir, te.getName());            
            PapillonLogger.writeDebugMsg("expanding " + te.getName() + " to "+ f); 
            File dirF=new File(f.getParent());
            dirF.mkdirs();
            if (te.isDirectory()) {
                f.mkdirs();
            } else {
                byte[] buffer = new byte[1024];
                int length = 0;
                FileOutputStream fos = new FileOutputStream(f);
                while ((length = tis.read(buffer)) >= 0) {
                    fos.write(buffer, 0, length);
                }
                fileArray=addItem(f,fileArray);
                fos.close();
            }
        }
        tis.close();
        
        return fileArray;
    }        
    
/*    
    public static String determineEncoding(ByteArrayInputStream is) throws java.io.IOException 
    {   
        PapillonLogger.writeDebugMsg("searching encoding d");
        Document myDoc=cleanHtmlStream(is);
        //to have something to parse
        NodeList metaList=myDoc.getElementsByTagName("meta");
        PapillonLogger.writeDebugMsg("founded "+metaList.getLength()+" meta");
        String encoding="UTF-8";
        String charsetDef="charset=";
        for (int i=0;i<metaList.getLength();i++)
        {
            NamedNodeMap attrList=metaList.item(i).getAttributes();
            Node httpEquiv=attrList.getNamedItem("http-equiv");
            if (httpEquiv!=null)
            {   
            
                if (httpEquiv.getNodeValue().equals("Content-Type")) 
                { 
                    //on a trouve le noeud ou est defini le charset
                    Node content=attrList.getNamedItem("content");
                    String contentValue=content.getNodeValue();
                    if (contentValue.lastIndexOf(charsetDef)!=(-1))
                    {//il y a la def du charset
                        int begin=contentValue.lastIndexOf(charsetDef)+charsetDef.length();                    
                        int end=contentValue.length();
                        encoding=contentValue.substring(begin,end);
                        PapillonLogger.writeDebugMsg("founded encoding :"+encoding);
                        
                        content.setNodeValue("text/html; charset=utf-8");
                        
                    }
                    
                    
                }
            }
        }        
        
        return encoding;        
    } 
   
    public static Node [] encodingDefList(Document doc) throws java.io.IOException 
    {   
        Node [] result=null;
        PapillonLogger.writeDebugMsg("searching encoding def ");
        //to have something to parse
        NodeList metaList=doc.getElementsByTagName("meta");
        PapillonLogger.writeDebugMsg("founded "+metaList.getLength()+" meta");
        for (int i=0;i<metaList.getLength();i++)
        {
            NamedNodeMap attrList=metaList.item(i).getAttributes();
            Node httpEquiv=attrList.getNamedItem("http-equiv");
            if (httpEquiv!=null)
            {   
                if (httpEquiv.getNodeValue().equals("Content-Type")) 
                { 
                    //on a trouve le noeud ou est defini le charset
                    Node content=attrList.getNamedItem("content");
                    result=addItem(content,result);    
                }
            }
        }        
        
        PapillonLogger.writeDebugMsg("founded "+result.length+" char def");
        
        return result;        
    } 
 
*/    
    public static Document cleanHtmlStream(InputStream is)  throws java.io.IOException  
    {
//Configuration.RAW;
//Configuration.ASCII;
//Configuration.LATIN1;
//Configuration.UTF8;
//Configuration.ISO2022;
//Configuration.MACROMAN;
        


        Tidy myTidy=new Tidy();
//        myTidy.setMakeClean(true);
        myTidy.setXHTML(true);
        myTidy.setXmlOut(true);
        myTidy.setUpperCaseTags(true);
//        myTidy.setCharEncoding(Configuration.UTF8);
        myTidy.setTidyMark(false);
        myTidy.setQuiet(true);
        myTidy.setQuoteAmpersand(false);
        myTidy.setQuoteMarks(true);        
        myTidy.setUpperCaseTags(true);
        myTidy.setSmartIndent(true);
        myTidy.setIndentContent(true);
        Document myDoc=myTidy.parseDOM(is,null);
// PapillonLogger.writeDebugMsg("after TYDY :"+NodeToString(myDoc));                
        
        return myDoc;
    }   


    private static String convertRelativeLink(String relativeLink,String path)
    {//return the path of the relative link with repalcing ../../ by the corresponding path
    //path is the current location where we found the relative link
    
        int nbPath=(relativeLink.lastIndexOf("../")/3)+1;
//        PapillonLogger.writeDebugMsg("nb parent en arriere :"+String.valueOf(nbPath));
        String thePath="";
        String curPath=path;                        
        if (curPath.lastIndexOf("/")==(curPath.length()-1))
        {//fini par un /
//            PapillonLogger.writeDebugMsg("fini par un slash");
            curPath=curPath.substring(0,curPath.lastIndexOf("/"));                            
//            PapillonLogger.writeDebugMsg("sans le slash :"+curPath);
        }

        //curPath est le chemin qui doit remplacer les ../../../ ...
        for (int cont=0;cont<nbPath;cont++)
        {   
//            PapillonLogger.writeDebugMsg("remonte d un cran");
            if (curPath.lastIndexOf("/")!=-1)
            {//ce n est pas le dernier parent
                curPath=curPath.substring(0,curPath.lastIndexOf("/"));                            
            } else
            {//c le dernier 
                curPath="";                            
            }
        }
//        PapillonLogger.writeDebugMsg("on colle :"+curPath);
        String withoutRelative=relativeLink.substring(nbPath*3,relativeLink.length());
        if (!(curPath.equals("")))
        {curPath=curPath+"/";
        }
        return curPath+withoutRelative;
    
    
    }
     
    public static byte[] toUTF8(byte[] b) throws java.io.UnsupportedEncodingException {
        // On cherche l'encodage dans le code HTML...
        String str= new String(b);
        str.toUpperCase();
        
        int index = 0;
        String charset="US-ASCII";
        while((index = str.indexOf("<META", index+1)) != -1) {
            // PLUS TARD: Attention au chevron dans les "" 
            int end=str.indexOf(">", index);
            
            String tag=str.substring(index, end);
            
            if ((tag.indexOf("HTTP-EQUIV") != -1) && (tag.indexOf("CONTENT-TYPE") != -1)) {
                int d=tag.indexOf("CHARSET=");
                int f=tag.indexOf("\"", d);
                charset=tag.substring(d+8, f);
            }
        }
        
        String htmlStr = new String(b, charset);

        return htmlStr.getBytes("UTF-8");
    }
    
    public static ByteArrayInputStream[] convertInternalLinks(String[] fileOldName,String[] fileNewName,
                                                              ByteArrayInputStream[] fileList,String directory)
        throws java.io.FileNotFoundException,java.io.IOException,javax.xml.transform.TransformerException,org.xml.sax.SAXException,
        javax.xml.parsers.ParserConfigurationException
    {
        
        ByteArrayInputStream[] result=null;
        for (int i=0;i<fileOldName.length;i++)
        {//pour chaque fichier
            if (fileOldName[i].toLowerCase().endsWith(".html"))
            {
                Document myDoc=cleanHtmlStream(fileList[i]);
                PapillonLogger.writeDebugMsg("current parsed file :" +fileOldName[i]);
                int pathEnd=fileOldName[i].lastIndexOf("/");    
                String currentPath=null;
                if (pathEnd!=-1) {
                    currentPath=fileOldName[i].substring(0,pathEnd)+"/";
                } else {
                    currentPath="";
                }
                PapillonLogger.writeDebugMsg("current path :"+currentPath+"#");
                
                Node[] links=extractInternalLinks(myDoc);
                
                //parcours des liens du fichier html                               
                for(int j=0;j<links.length;j++)
                {
                                    
                    
                    Node currentLinkNode=links[j];          
                    String oldLinkValue=currentLinkNode.getNodeValue();
                    PapillonLogger.writeDebugMsg("current link :" +oldLinkValue);                    
                    if  (currentLinkNode.getNodeValue().startsWith(".."))
                    {//retablissement du path
                        String theLink=currentLinkNode.getNodeValue();
                        PapillonLogger.writeDebugMsg("lien relatif :"+theLink);
                        theLink=convertRelativeLink(theLink,currentPath);                                                
                        PapillonLogger.writeDebugMsg("nouvelle valeur du lien :"+theLink);
                        currentLinkNode.setNodeValue(theLink);
                    } else
                    {//on colle le path au lien
                    
                    //PapillonLogger.writeDebugMsg("link without path:"+currentLinkNode.getNodeValue());                                               
                        currentLinkNode.setNodeValue(currentPath+currentLinkNode.getNodeValue());
                    //PapillonLogger.writeDebugMsg("link with path:"+currentLinkNode.getNodeValue());
                    
                    }
                    PapillonLogger.writeDebugMsg("end of pretreatment of the link :"+currentLinkNode.getNodeValue());
                    
                    String currentLink=links[j].getNodeValue();
                    
                    //parcours des anciens noms de fichiers
                    boolean founded=false;
                    for(int k=0;k<fileOldName.length;k++)
                    {
                        String currentFileName=fileOldName[k].toLowerCase(); 
                                               
//                        PapillonLogger.writeDebugMsg("current file name search:"+currentFileName);                       
                        if( currentLink.toLowerCase().startsWith(currentFileName))
                        {
                            PapillonLogger.writeDebugMsg("founded "+currentFileName+" in link :"+currentLink);
                            founded=true;
                            int end=currentFileName.length();
                            //retablit la casse
                            String newLink=null;
                            if (currentFileName.endsWith(".html"))
                            {
                                newLink="http://bushido:9000/ConsultInformations.po"+currentLink.substring(end,currentLink.length())+"?see="+fileNewName[k];
                            } else
                            {
                                newLink="upload/"+directory+"/"+fileNewName[k];                              
                            }
                            currentLinkNode.setNodeValue(newLink);
                            PapillonLogger.writeDebugMsg("converted in link :"+currentLinkNode.getNodeValue());
                            break;//on sort si on trouve le bon fichier

                        }
                    
                    }
                    
                    if (!founded)
                    {
                        PapillonLogger.writeDebugMsg("no corresponding file found");                         
                        PapillonLogger.writeDebugMsg("restoring link :"+currentLink);
                        currentLinkNode.setNodeValue(oldLinkValue);
                        PapillonLogger.writeDebugMsg("restored link :"+currentLinkNode.getNodeValue());                                                 
                    }
                    
                }
                
/*                //pour l encodage
                Node [] encodeDef=encodingDefList(myDoc);
                PapillonLogger.writeDebugMsg(encodeDef.length+" encodage a modifiÈ");
                for(int j=0;j<encodeDef.length;j++)
                {   
                    Node curDef=encodeDef[j];                
                    PapillonLogger.writeDebugMsg("encodage prÈcÈdent :"+curDef.getNodeValue());
                    PapillonLogger.writeDebugMsg("encodage modifiÈ");

                    curDef.setNodeValue("text/html; charset=utf-8");
                    PapillonLogger.writeDebugMsg("nouvel encodage :"+curDef.getNodeValue());
                    
                    
                }
            
  */      
                PapillonLogger.writeDebugMsg("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
                PapillonLogger.writeDebugMsg(NodeToString(myDoc));
                PapillonLogger.writeDebugMsg("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");

                //creating the new bytearrayinputstream
                ByteArrayInputStream currentBytes=new ByteArrayInputStream(NodeToString(myDoc).getBytes("UTF-8"));
                
                
                
                //adding the ne bytearrayinputstream    
                result=addItem(currentBytes,result);
            } else
            {//adding non html files
                result=addItem(fileList[i],result);    
            }
        
        
        }
    return result;
    }
    

    private static Node[] extractInternalLinks(Document myDoc)throws java.io.FileNotFoundException
    {PapillonLogger.writeDebugMsg("beginnig of extracting links");
        NodeList markupList=myDoc.getElementsByTagName("*"); 
        Node[] linkList=null;
        for (int i=0;i<markupList.getLength();i++)
        {
            NamedNodeMap attrList=markupList.item(i).getAttributes();
            //search for internal links
            for (int j =0; j<attrList.getLength();j++)
            { 
                if ((attrList.item(j).getNodeName().toLowerCase().equals("href"))||
                    (attrList.item(j).getNodeName().toLowerCase().equals("src")) ||
                    (attrList.item(j).getNodeName().toLowerCase().equals("background")) )
                {
                    
                    linkList=addItem(attrList.item(j),linkList);
                
                   //  PapillonLogger.writeDebugMsg("Founded link :"+attrList.item(j).getNodeValue());                    
                }
            }
        
        }   

     PapillonLogger.writeDebugMsg("ending of extracting links"); 
     return linkList;  
    }
    
    
    public static String[] addItem(String newString,String[] objList)    
    {
    if ((objList==null)||(objList.length==0))
        {
        objList=new String[1];
        objList[0]=newString;
        } else
        {
        String[] swap=(String[])objList.clone();
        objList=new String[objList.length+1];
        //copy old 
        for (int k=0;k<(objList.length-1);k++)                    
            {
                        objList[k]=swap[k];                        
            }
        objList[objList.length-1]=newString;
        }
    return objList;        
        
    }
    
    public static ByteArrayInputStream[] addItem(ByteArrayInputStream newByteArrayInputStream,ByteArrayInputStream[] objList)    
    {
    if ((objList==null)||(objList.length==0))
        {
        objList=new ByteArrayInputStream[1];
        objList[0]=newByteArrayInputStream;
        } else
        {
        ByteArrayInputStream[] swap=(ByteArrayInputStream[])objList.clone();
        objList=new ByteArrayInputStream[objList.length+1];
        //copy old 
        for (int k=0;k<(objList.length-1);k++)                    
            {
                        objList[k]=swap[k];                        
            }
        objList[objList.length-1]=newByteArrayInputStream;
        }
    return objList;        
        
    }
    
    
    public static File[] addItem(File newFile,File[] objList)    
    {
    if ((objList==null)||(objList.length==0))
        {
        objList=new File[1];
        objList[0]=newFile;
        } else
        {
        File[] swap=(File[])objList.clone();
        objList=new File[objList.length+1];
        //copy old 
        for (int k=0;k<(objList.length-1);k++)                    
            {
                        objList[k]=swap[k];                        
            }
        objList[objList.length-1]=newFile;
        }
    return objList;        
        
    }
    
    
    public static String encodeXMLEntities(String theString) {
        if (null != theString && !theString.equals("")) {
            String tmpString = "";
            while (null != theString && theString.indexOf("&") >= 0) {
                tmpString = theString.substring(0,theString.indexOf("&"))
                        + "&amp;";
                theString = theString.substring(theString.indexOf("&") + 1);
            }
            theString = tmpString + theString;

            while (theString.indexOf("'") >= 0 || theString.indexOf("\"") >= 0 
                || theString.indexOf("<") >= 0 ||theString.indexOf(">") >= 0) {
                if (theString.indexOf("'") >= 0) {
                    theString = theString.substring(0,theString.indexOf("'"))
                        + "&apos;" + theString.substring(theString.indexOf("'") + 1);
                }
                if (theString.indexOf("\"") >= 0) {
                    theString = theString.substring(0,theString.indexOf("\""))
                        + "&quot;" + theString.substring(theString.indexOf("\"") + 1);
                }
                if (theString.indexOf("<") >= 0) {
                    theString = theString.substring(0,theString.indexOf("<"))
                        + "&lt;" + theString.substring(theString.indexOf("<") + 1);
                }
                if (theString.indexOf(">") >= 0) {
                    theString = theString.substring(0,theString.indexOf(">"))
                        + "&gt;" + theString.substring(theString.indexOf(">") + 1);
                } 
            }
        }
    return theString;
    }                

		/**
     * Trims the XML header of an XML String
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static String trimXMLHeader(String xmlString) {
		String region = "?>";
		if (xmlString.indexOf(region) > 0) {
			xmlString = xmlString.substring(xmlString.indexOf(region)+region.length());
		}
		return xmlString;
	}
	
		/**
     * converts a String from an encoding to another
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public static String convertFromEncoding(String theString, String encoding)
        throws java.io.UnsupportedEncodingException {
            byte[] pbytes = theString.getBytes();
            return new String(pbytes, encoding);
        }

		/**
     * converts a String for writing an URL
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public static String convertToUrlForEncoding(String str, String encoding) throws java.io.UnsupportedEncodingException {

        return java.net.URLEncoder.encode(str,encoding);
    }

		/**
     * normalize all spaces into only one space character
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static String normalizeSpaces(String myString) {
		StringBuffer myBuffer = new StringBuffer(myString.trim());
		int i=0;
		while (i<myBuffer.length()) {
			if (Character.isWhitespace(myBuffer.charAt(i))) {
				myBuffer.setCharAt(i,' ');
				i++;
				while (i<myBuffer.length() && Character.isWhitespace(myBuffer.charAt(i))) {
					myBuffer.deleteCharAt(i);
				}
			}
			else {
				i++;
			}
		}
		return myBuffer.toString();
	}

		/**
     * Tests if a String is in a String array
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
		public static boolean IsInArray(String myString, String[] myArray) {
			boolean found = false;
			if (myString == null) {
				found = true;
			}
			else if (myArray != null && myArray.length>0) {
				int i=0;
				while (i<myArray.length && !found) {
					found = (myString.equals(myArray[i]));
					i++;
				}
			}
			return found;
		}

		/**
     * Tests if a String array is in another String array
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
		public static boolean IsInArray(String[] myStrings, String[] myArray) {
			boolean found = false;
			if (myStrings != null && myStrings.length>0) {
				int i=0;
				while (i<myStrings.length && !found) {
					found = IsInArray(myStrings[i],myArray);
					i++;
				}
			}
				else {
					found = true;
				}
			return found;
		}

	public static void removeElement(Element elem) {
		if (elem != null) {
			Node myParent = elem.getParentNode();
			if (myParent != null)
				myParent.removeChild(elem);
		}
	}
	
	
	/**
     * getLocalTagName
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static String getLocalTagName(String tagname) {
		if (tagname != null) {
			if (tagname.indexOf(":") >0) {
				tagname = tagname.substring(tagname.indexOf(":")+1);
			}
		}
		return tagname;
	}

	/**
     * getPrefix
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static String getPrefix(String tagname) {
		String prefix = "";
		if (tagname != null) {
			if (tagname.indexOf(":") >0) {
				prefix = tagname.substring(0,tagname.indexOf(":"));
			}
		}
		return prefix;
	}

		/**
     * Tests if a String array is in another String array
     *
     * @return a String
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	
	 
	public static byte[] serializeHashtable(java.util.Hashtable myTable) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		byte[] resultArray = null;
		try {
			ByteArrayOutputStream myByteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myByteArrayOutputStream);
			myObjectOutputStream.writeObject (myTable);
			resultArray = myByteArrayOutputStream.toByteArray();
			myByteArrayOutputStream.flush();
		}
		catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Error in Utility.deSerializeHashtable", ex);
        }
		return resultArray;
	}
	
	/**
     * deSerialize a Hashtable from a byte array
     *
     * @return a hashtable
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static java.util.Hashtable deSerializeHashtable(byte[] myByteArray) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		java.util.Hashtable myRes = null;
		if (myByteArray != null) {
		try {
			ObjectInputStream myOIStream = new ObjectInputStream(new ByteArrayInputStream(myByteArray));
			myRes = (java.util.Hashtable) myOIStream.readObject();
		}
		catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Error in Utility.deSerializeHashtable", ex);
        }
		}
		return myRes;
	}

	/**
     * Serialize a DOM Document into a byte array
     *
     * @return a byte array
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static byte[] serializeDocument(org.w3c.dom.Document myDoc) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		byte[] resultArray = null;
		try {
			ByteArrayOutputStream myByteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myByteArrayOutputStream);
			myObjectOutputStream.writeObject (myDoc);
			resultArray = myByteArrayOutputStream.toByteArray();
			myByteArrayOutputStream.flush();
		}
		catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Error in Utility.deSerializeHashtable", ex);
        }
		return resultArray;
	}
	
	/**
     * deSerialize a DOM Document  from a byte array
     *
     * @return a DOM Document 
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
	public static org.w3c.dom.Document deSerializeDocument(byte[] myByteArray) throws fr.imag.clips.papillon.business.PapillonBusinessException {
		org.w3c.dom.Document myRes = null;
		try {
			ObjectInputStream myOIStream = new ObjectInputStream(new ByteArrayInputStream(myByteArray));
			myRes = (org.w3c.dom.Document) myOIStream.readObject();
		}
		catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Error in Utility.deSerializeHashtable", ex);
        }
		return myRes;
	}

}