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

package fr.imag.clips.papillon.presentation;

import com.lutris.logging.*;
import com.lutris.appserver.server.httpPresentation.*;
import com.lutris.appserver.server.*;

import com.lutris.appserver.server.Enhydra;
import fr.imag.clips.papillon.Papillon;

import fr.imag.clips.papillon.business.xml.XMLServices;
import fr.imag.clips.papillon.business.PapillonLogger;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

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
	private ErrorXHTML XHTMLcontent;
    private static final String API_COMMAND = "api";
    private static final String APIUSERS_COMMAND = "apiusers";
	
	protected static String ERROR_PAGE = "<?xml version='1.0'?><html></html>";
	
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
		
		// special code for handling the root query (/api/)
		// because it is not handled by the api/ErrorHandler.po
        String command = "";
        int status = HttpPresentationResponse.SC_OK;
		
        String prefix = this.getAbsoluteUrl();
		prefix = prefix.substring(0,prefix.lastIndexOf('/') + 1);
        String apiPrefix = prefix + API_COMMAND + "/";
        String apiUsersPrefix = prefix + APIUSERS_COMMAND + "/";
		HttpPresentationRequest theRequest = this.getComms().request;
		HttpPresentationResponse theResponse = this.getComms().response;
		String theURI = theRequest.getPresentationURI();
        if (theURI.indexOf(apiPrefix)==0) {
            theURI = theURI.substring(apiPrefix.length());
            command = API_COMMAND;
        }
        if (theURI.indexOf(apiUsersPrefix)==0) {
            theURI = theURI.substring(apiUsersPrefix.length());
            command = APIUSERS_COMMAND;
        }
		if ((theURI == null || theURI.equals(""))
		   && (null != this.getComms().exception) 
		   && (this.getComms().exception instanceof com.lutris.appserver.server.httpPresentation.FilePresentationException)) {
            if (command.equals(API_COMMAND)) {
                PapillonLogger.writeDebugMsg("REST API COMMAND: " + theRequest.getMethod() + " DICTLIST");
                if (theRequest.getMethod().equals("GET")) {
                    java.util.Vector responseVector = fr.imag.clips.papillon.business.dictionary.MetadataApi.getDictionaryList(this.getUser());
                    content = (org.w3c.dom.Document) responseVector.elementAt(0);
                    status = ((Integer)responseVector.elementAt(1)).intValue();
                    theResponse.setStatus(status, (String) responseVector.elementAt(2));
                }
                else if (theRequest.getMethod().equals("PUT")) {
                    HttpPresentationInputStream inputStream = theRequest.getInputStream();
                    String dict = convertStreamToString(inputStream);
                    PapillonLogger.writeDebugMsg("Error: put dictlist: not implemented");
                    theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
                }
                else if (theRequest.getMethod().equals("POST")) {
                    HttpPresentationInputStream inputStream = theRequest.getInputStream();
                    String dict = convertStreamToString(inputStream);
                    PapillonLogger.writeDebugMsg("Error: post dictlist: not implemented");
                    theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
                }
                else if (theRequest.getMethod().equals("DELETE")) {
                    PapillonLogger.writeDebugMsg("Error: delete dictlist: not implemented");
                    theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
                }
            }
                else if (command.equals(APIUSERS_COMMAND)) {
                PapillonLogger.writeDebugMsg("REST APIUSERS COMMAND: " + theRequest.getMethod() + " USERSLIST;");
                if (theRequest.getMethod().equals("GET")) {
                    java.util.Vector responseVector = fr.imag.clips.papillon.business.user.UserApi.getUserList(this.getUser());
                    content = (org.w3c.dom.Document) responseVector.elementAt(0);
                    status = ((Integer)responseVector.elementAt(1)).intValue();
                    theResponse.setStatus(status, (String) responseVector.elementAt(2));
                }
                else if (theRequest.getMethod().equals("PUT")) {
                    HttpPresentationInputStream inputStream = theRequest.getInputStream();
                    String parcel = convertStreamToString(inputStream);
                    PapillonLogger.writeDebugMsg("Error: put users list: not implemented");
                    theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
                }
                else if (theRequest.getMethod().equals("POST")) {
                    HttpPresentationInputStream inputStream = theRequest.getInputStream();
                    String parcel = convertStreamToString(inputStream);
                    PapillonLogger.writeDebugMsg("Error: post users list: not implemented");
                    theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
                    
                }
                else if (theRequest.getMethod().equals("DELETE")) {
                    PapillonLogger.writeDebugMsg("Error: delete users list: not implemented");
                    theResponse.setStatus(HttpPresentationResponse.SC_NOT_IMPLEMENTED);
                }
                
                }
			}
			else {
				////// Create Home page
				XHTMLcontent = (ErrorXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ErrorXHTML",
																					   this.getComms(), this.getSessionData());
				//        ErrorHTML errorPage = new ErrorHTML();
				
				if(null != this.getComms() && null != this.getComms().exception) {
					StringWriter stringWriter = new StringWriter();
					this.getComms().exception.printStackTrace(new PrintWriter(stringWriter));
					LogChannel logChannel = Enhydra.getLogChannel();
					int level = logChannel.getLevel("DEBUG");
					
					logChannel.write(level, "jibiki.presentation.ErrorHandler stack trace = ");
					logChannel.write(level, stringWriter.toString());
					logChannel.write(level, "jibiki.presentation.ErrorHandler caught an exception - " 
									 + this.getComms().exception.toString(), this.getComms().exception);
					XHTMLcontent.setTextStackTrace(stringWriter.toString());
					if (this.getComms().exception.getMessage() != null) {
						XHTMLcontent.setTextErrorMessage(this.getComms().exception.getMessage());
					}
					else {
						XHTMLcontent.setTextErrorMessage(this.getComms().exception.toString());
					}
					
				}
				else {
					XHTMLcontent.setTextErrorMessage("Comms or comms.exception is null");
				}
				content = (org.w3c.dom.Document) XHTMLcontent;
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
