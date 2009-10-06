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

import fr.imag.clips.papillon.presentation.xhtml.orig.*;
import fr.imag.clips.papillon.presentation.*;

import fr.imag.clips.papillon.business.PapillonLogger;

import java.io.*;
    
/**
 * Class to handle exceptions not caught anywhere else in the framework of
 * our application
 *
 * @author
 * @version
 */
public class ErrorHandler extends  fr.imag.clips.papillon.presentation.XmlBasePO {
 
	private org.w3c.dom.Document content;

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
			content = (org.w3c.dom.Document) MultilingualXHtmlTemplateFactory.createTemplate("ErrorXHTML",
																						 this.getComms(), this.getSessionData());
        String prefix = this.getAbsoluteUrl();
		prefix = prefix.substring(0,prefix.lastIndexOf('/') + 1);
			
        if(null != this.getComms().exception) {
			if (this.getComms().exception instanceof com.lutris.appserver.server.httpPresentation.FilePresentationException) {
				HttpPresentationRequest theRequest = this.getComms().request;
				String theURI = theRequest.getPresentationURI();
				if (theURI.indexOf(prefix)==0) {
					theURI = theURI.substring(prefix.length());
				}
				String[] restStrings = theURI.split("/");
				String message = "REST API URI : [" + prefix + "] " + theRequest.getPresentationURI() + ";";
				message += "REST API COMMAND : " + theRequest.getMethod() + ";";
				PapillonLogger.writeDebugMsg("REST API COMMAND : " + theRequest.getMethod());
				if (restStrings.length>=0) {
					message += "REST API DICT : " + restStrings[0]+ ";";
				}
				if (restStrings.length>=1) {
					message += "REST API LANG : " + restStrings[1]+ ";";
				}
				if (restStrings.length>=2) {
					message += "REST API HW : " + restStrings[2]+ ";";
					//String url = prefix+"Entries.po?DICTIONARY=" + restStrings[0] + "&LANG=" + restStrings[1] + "&ID=" + restStrings[2];
					//throw new ClientPageRedirectException(url);
					//message += " URL : " + url + ";";
					if (theRequest.getMethod().equals("GET")) {
						content = Entries.getEntry(restStrings[0], restStrings[1], restStrings[2]);
					}
					if (theRequest.getMethod().equals("PUT")) {
						//content = Entries.putEntry(restStrings[0], restStrings[1], restStrings[2]);
					}
					if (theRequest.getMethod().equals("POST")) {
						//content = Entries.putEntry(restStrings[0], restStrings[1], restStrings[2]);
					}
					if (theRequest.getMethod().equals("DELETE")) {
						//content = Entries.putEntry(restStrings[0], restStrings[1], restStrings[2]);
					}
				}
				//content.setTextErrorMessage(message);
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
				((ErrorXHTML)content).setTextStackTrace(stringWriter.toString());
				((ErrorXHTML)content).setTextErrorMessage(this.getComms().exception.getMessage());
			}
        }
		return content;
    }
}
