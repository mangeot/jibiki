/*
 * Enhydra Java Application Server Project
 * 
 * The contents of this file are subject to the Enhydra Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License on
 * the Enhydra web site ( http://www.enhydra.org/ ).
 * 
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See 
 * the License for the specific terms governing rights and limitations
 * under the License.
 * 
 * The Initial Developer of the Enhydra Application Server is Lutris
 * Technologies, Inc. The Enhydra Application Server and portions created
 * by Lutris Technologies, Inc. are Copyright Lutris Technologies, Inc.
 * All Rights Reserved.
 * 
 * Contributor(s):
 * 
 * $Id: ErrorHandler.java,v 1.1 2003/11/25 18:17:31 slobodan Exp $
 */

package fr.imag.clips.papillon.presentation.api;

import com.lutris.logging.*;
import com.lutris.appserver.server.httpPresentation.*;
import com.lutris.appserver.server.*;

import com.lutris.appserver.server.Enhydra;
import fr.imag.clips.papillon.Papillon;

import fr.imag.clips.papillon.business.xml.XMLServices;

import fr.imag.clips.papillon.business.PapillonLogger;

import java.io.*;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;*/

import java.util.Properties;

    
/**
 * Class to handle exceptions not caught anywhere else in the framework of
 * our application
 *
 * @author
 * @version
 */
public class ErrorHandler extends  fr.imag.clips.papillon.presentation.XmlBasePO {
 
	private org.w3c.dom.Document content;
	
	protected static String ERROR_PAGE = "<?xml version='1.0'?><html></html>";
	protected static String LOGIN_PARAMETER = "login";
	protected static String PASSWORD_PARAMETER = "password";
	protected static String STRATEGY_PARAMETER = "strategy";
	protected static String LIMIT_PARAMETER = "count";
	protected static String OFFSET_PARAMETER = "startIndex";
	
	/**
     * Description of the Method
     *
     * @return Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return false;
    }
	
	
    /**
     * Description of the Method
     *
     * @return Description of the Return Value
     */
    protected boolean userMayUseThisPO() {
        return true;
    }
	
	/**
     * This implements the run method in HttpPresentation.
     *
     * @param HttpPresentationComms
     * @exception HttpPresentationException
     */
    public org.w3c.dom.Document getContent()
        throws HttpPresentationException, java.io.IOException, java.lang.Exception {
        	
			
			////// Create Home page
			content = XMLServices.buildDOMTree(ERROR_PAGE);
        String prefix = this.getAbsoluteUrl();
		prefix = prefix.substring(0,prefix.lastIndexOf('/') + 1);
			
        if(null != this.getComms().exception) {
			if (this.getComms().exception instanceof com.lutris.appserver.server.httpPresentation.FilePresentationException) {
				HttpPresentationRequest theRequest = this.getComms().request;
				HttpPresentationResponse theResponse = this.getComms().response;
				String login =  myGetParameter(LOGIN_PARAMETER);
				String password = myGetParameter(PASSWORD_PARAMETER);
				PapillonLogger.writeDebugMsg("REST API URI : [" + prefix + "] " + theRequest.getPresentationURI()+";");
				String theURI = theRequest.getPresentationURI();
				if (theURI.indexOf(prefix)==0) {
					theURI = theURI.substring(prefix.length());
				}
				String[] restStrings = null;
				if (theURI!=null &&!theURI.equals("")) {
					restStrings = theURI.split("/");
				}
				
				String commande = "REST API COMMAND: " + theRequest.getMethod();
				if (restStrings== null || restStrings.length==0) {
					PapillonLogger.writeDebugMsg(commande + " DICTLIST;");
					if (theRequest.getMethod().equals("GET")) {
						content = Metadata.getDictionaryList();
					}
					else if (theRequest.getMethod().equals("PUT")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String dict = convertStreamToString(inputStream);
						System.out.println("Error: put dictlist: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
					}
					else if (theRequest.getMethod().equals("POST")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String dict = convertStreamToString(inputStream);
						System.out.println("Error: post dictlist: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
						
					}
					else if (theRequest.getMethod().equals("DELETE")) {
						System.out.println("Error: delete dictlist: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
					}
				}
				if (restStrings.length==1) {
					if (theRequest.getMethod().equals("GET")) {
						PapillonLogger.writeDebugMsg(commande + " DICTLIST;");
						if (restStrings[0].equals("*")) {
							content = Metadata.getDictionaryList();
						}
						else {
							PapillonLogger.writeDebugMsg(commande + " DICT: " + restStrings[0]+ ";");
							content = Metadata.getDictionaryMetadata(restStrings[0]);
						}
						if (content==null) {
							String errorMsg = "Error: dict: " + restStrings[0] + " does not exist!";
							System.out.println(errorMsg);
							theResponse.setStatus(HttpPresentationResponse.SC_NOT_FOUND,errorMsg);
						}
					}
					else if (theRequest.getMethod().equals("PUT")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String dict = convertStreamToString(inputStream);
						System.out.println("Error: put dict: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
					}
					else if (theRequest.getMethod().equals("POST")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String dict = convertStreamToString(inputStream);
						System.out.println("Error: post dict: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
					}
					else if (theRequest.getMethod().equals("DELETE")) {
						System.out.println("Error: delete dict: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
					}
				}
				if (restStrings.length==2) {
					PapillonLogger.writeDebugMsg(commande + " DICT: " + restStrings[0] + " LANG: " + restStrings[1]+ ";");
					if (theRequest.getMethod().equals("GET")) {
						content = Metadata.getVolumeMetadata(restStrings[0], restStrings[1]);
						if (content==null) {
							String errorMsg = "Error: volume: " + restStrings[0] + " lang: " +  restStrings[1] + " does not exist!";
							System.out.println(errorMsg);
							theResponse.setStatus(HttpPresentationResponse.SC_NOT_FOUND,errorMsg);
						}
					}
					else if (theRequest.getMethod().equals("PUT")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String volume = convertStreamToString(inputStream);
						System.out.println("Error: put volume: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
						theResponse.flush();
					}
					else if (theRequest.getMethod().equals("POST")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String volume = convertStreamToString(inputStream);
						System.out.println("Error: post volume: not implemented");
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);						
					}
					else if (theRequest.getMethod().equals("DELETE")) {
						String errorMsg = "Error: delete volume: not implemented";
						System.out.println(errorMsg);
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED,errorMsg);
					}
				}
				if (restStrings.length==3) {
					PapillonLogger.writeDebugMsg(commande + " DICT: " + restStrings[0] + " LANG: " + restStrings[1]+ " ENTRYID : " + restStrings[2]+ ";");
					if (theRequest.getMethod().equals("GET")) {
						content = Entries.getEntry(restStrings[0], restStrings[1], restStrings[2]);
						if (content==null) {
							String errorMsg = "Error: entryid: " + restStrings[0] + " lang: " +  restStrings[1] + " ID: " + restStrings[2] +" does not exist!";
							System.out.println(errorMsg);
							theResponse.setStatus(HttpPresentationResponse.SC_NOT_FOUND,errorMsg);
						}						
					}
					else if (theRequest.getMethod().equals("PUT")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String entry = convertStreamToString(inputStream);
						System.out.println("put data: "+entry);
						//inputStream.close();
						if (Entries.userCanPutEntry(login,password)) {
							content = Entries.putEntry(restStrings[0], restStrings[1], restStrings[2], entry);
							if (content==null) {
								String errorMsg = "Error: entryid: " + restStrings[0] + " lang: " +  restStrings[1] + " ID: " + restStrings[2] +" does not exist!";
								System.out.println(errorMsg);
								theResponse.setStatus(HttpPresentationResponse.SC_NOT_FOUND,errorMsg);
							}
							else {
								theResponse.setStatus(HttpPresentationResponse.SC_CREATED);
							}
						}
						else {
							String errorMsg = "Error: user: " + login +" not authorized to put entry!";
							System.out.println(errorMsg);
							theResponse.setStatus(HttpPresentationResponse.SC_UNAUTHORIZED,errorMsg);
						}
					}
					else if (theRequest.getMethod().equals("POST")) {
						HttpPresentationInputStream inputStream = theRequest.getInputStream();
						String entry = convertStreamToString(inputStream);
						System.out.println("post data: "+entry);
						if (Entries.userCanPostEntry(login,password)) {
							content = Entries.postEntry(restStrings[0], restStrings[1], restStrings[2], entry);
							if (content==null) {
								String errorMsg = "Error: dict: " + restStrings[0] + " lang: " +  restStrings[1] +" does not exist!";
								System.out.println(errorMsg);
								theResponse.setStatus(HttpPresentationResponse.SC_NOT_FOUND, errorMsg);
							}
							else {
								theResponse.setStatus(HttpPresentationResponse.SC_CREATED);
							}
						}
						else {
							String errorMsg = "Error: user: " + login +" not authorized to put entry!";
							System.out.println(errorMsg);
							theResponse.setStatus(HttpPresentationResponse.SC_UNAUTHORIZED,errorMsg);
						}
					}
					else if (theRequest.getMethod().equals("DELETE")) {
						if (Entries.userCanDeleteEntry(login,password)) {
							content = Entries.deleteEntry(restStrings[0], restStrings[1], restStrings[2]);
							if (content==null) {
								String errorMsg = "Error: entryid: " + restStrings[0] + " lang: " +  restStrings[1] + " ID: " + restStrings[2] +" does not exist!";
								System.out.println(errorMsg);
								theResponse.setStatus(HttpPresentationResponse.SC_NOT_FOUND, errorMsg);
							}
							else {
								theResponse.setStatus(HttpPresentationResponse.SC_NO_CONTENT);
							}							
						}
						else {
							String errorMsg = "Error: user: " + login +" not authorized to put entry!";
							System.out.println(errorMsg);
							theResponse.setStatus(HttpPresentationResponse.SC_UNAUTHORIZED,errorMsg);
						}
					}
				}
				if (restStrings.length==4 || restStrings.length==5) {
					PapillonLogger.writeDebugMsg(commande + " DICT: " + restStrings[0] + " LANG: " + restStrings[1]+ " MODE: " + restStrings[2]+ " STRING: " + restStrings[3]+ ";");
					if (theRequest.getMethod().equals("GET")) {
						String strategy = myGetParameter(STRATEGY_PARAMETER);
						String limit = myGetParameter(LIMIT_PARAMETER);
						String offset = myGetParameter(OFFSET_PARAMETER);
						String key=null;
						if (restStrings.length==5) {
							key = restStrings[4];
						}
						/*
						 //Problem if the inputStream is not closed, the server is waiting in vain 
						if (strategy==null && limit==null && offset == null) {
							HttpPresentationInputStream inputStream = theRequest.getInputStream();
							String[] params = convertStreamToString(inputStream).split("&(amp;)?");
							for (int i=0;i<params.length;i++) {
								String[] param = params[i].split("=");
								if (param[0].equals(STRATEGY_PARAMETER)) {
									strategy = param[1];
								}
								if (param[0].equals(LIMIT_PARAMETER)) {
									limit = param[1];
								}
								if (param[0].equals(OFFSET_PARAMETER)) {
									offset = param[1];
								}
							}
						}						*/
						content = Entries.getEntries(restStrings[0], restStrings[1], restStrings[2], restStrings[3], key, strategy, limit, offset);
						if (content==null) {
							String errorMsg = "Error: search: " + restStrings[0] + " lang: " +  restStrings[1] + " method: " + restStrings[2] +" does not exist!";
							System.out.println(errorMsg);
							theResponse.setStatus(HttpPresentationResponse.SC_NOT_FOUND, errorMsg);
						}
					}
					else {
						theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
						System.out.println("Error: method not implemented");
						System.out.println("search entries: error message! " + restStrings[0] + " "+restStrings[1]);
					}
				}
				if (restStrings.length>5) {
					PapillonLogger.writeDebugMsg(commande + " DICT: " + restStrings[0] + " LANG: " + restStrings[1]+ " MODE: " + restStrings[2]+ " STRING: " + restStrings[3]+ ";");
					theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
					System.out.println("Error: method not implemented");
				}
			}
			else {
				StringWriter stringWriter = new StringWriter();
				this.getComms().exception.printStackTrace(new PrintWriter(stringWriter));
				LogChannel logChannel = Enhydra.getLogChannel();
				int level = logChannel.getLevel("DEBUG");
            
				logChannel.write(level, "jibiki.presentation.ErrorHandler stack trace = ");
				logChannel.write(level, stringWriter.toString());
				logChannel.write(level, "jibiki.presentation.ErrorHandler caught an exception - " 
                             + this.getComms().exception.toString(), this.getComms().exception);
				org.w3c.dom.Node stackNode = content.createTextNode(stringWriter.toString());
				content.getDocumentElement().appendChild(stackNode);
				org.w3c.dom.Node messageNode = content.createTextNode(this.getComms().exception.getMessage());
				content.getDocumentElement().appendChild(messageNode);
			}
        }
		return content;
    }
	
	
	
			
		public static String convertStreamToString(InputStream is) {
			/*
			 * To convert the InputStream to String we use the BufferedReader.readLine()
			 * method. We iterate until the BufferedReader return null which means
			 * there's no more data to read. Each line will appended to a StringBuilder
			 * and returned as String.
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			
			String line = null;
			try {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
			/*
			finally {
				try {
					is.close();
				} catch (IOException e) {
					// HttpPresentationInputStream may not be closed error
					//e.printStackTrace();
				}
			} */
			
			return sb.toString();
		}
}
