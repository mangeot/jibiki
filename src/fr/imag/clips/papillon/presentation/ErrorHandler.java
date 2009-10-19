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
		
        String prefix = this.getAbsoluteUrl();
		prefix = prefix.substring(0,prefix.lastIndexOf('/') + 1);
		prefix += "api/";
		HttpPresentationRequest theRequest = this.getComms().request;
		String theURI = theRequest.getPresentationURI();
		if (theURI.indexOf(prefix)==0) {
			theURI = theURI.substring(prefix.length());
		}
		if ((theURI == null || theURI.equals(""))
		   && (null != this.getComms().exception) 
		   && (this.getComms().exception instanceof com.lutris.appserver.server.httpPresentation.FilePresentationException)) {
				PapillonLogger.writeDebugMsg("REST API URI : [" + prefix + "] " + theRequest.getPresentationURI()+";");
				PapillonLogger.writeDebugMsg("REST API COMMAND : " + theRequest.getMethod());
					PapillonLogger.writeDebugMsg("REST API DICTLIST;");
					if (theRequest.getMethod().equals("GET")) {
						content = fr.imag.clips.papillon.presentation.api.Metadata.getDictionaryList();
					}
					else if (theRequest.getMethod().equals("PUT")) {
						System.out.println("put dictlist: error message ");
					}
					else if (theRequest.getMethod().equals("POST")) {
						System.out.println("post dictlist: error message ");
						
					}
					else if (theRequest.getMethod().equals("DELETE")) {
						System.out.println("delete dictlist: error message! ");
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
}
