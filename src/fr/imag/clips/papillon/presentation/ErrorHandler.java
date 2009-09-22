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
//import org.enhydra.xml.xhtml.dom.*;

import fr.imag.clips.papillon.presentation.xhtml.orig.*;

import java.io.*;
    
/**
 * Class to handle exceptions not caught anywhere else in the framework of
 * our application
 *
 * @author
 * @version
 */
public class ErrorHandler extends PapillonBasePO {
 
	private ErrorXHTML content;

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
     * Gets the currentSection attribute of the Home object
     *
     * @return The currentSection value
     */
    protected int getCurrentSection() {
        return NO_SECTION;
    }

	/**
     * This implements the run method in HttpPresentation.
     *
     * @param HttpPresentationComms
     * @exception HttpPresentationException
     */
    public org.w3c.dom.Node getContent()
        throws HttpPresentationException {
        	
			
			////// Create Home page
			content = (ErrorXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ErrorXHTML",
																						 this.getComms(), this.getSessionData());
		//        ErrorHTML errorPage = new ErrorHTML();
        
        if(null != this.getComms().exception) {
            StringWriter stringWriter = new StringWriter();
            this.getComms().exception.printStackTrace(new PrintWriter(stringWriter));
            LogChannel logChannel = Enhydra.getLogChannel();
            int level = logChannel.getLevel("DEBUG");
            
            logChannel.write(level, "jibiki.presentation.ErrorHandler stack trace = ");
            logChannel.write(level, stringWriter.toString());
            logChannel.write(level, "jibiki.presentation.ErrorHandler caught an exception - " 
                             + this.getComms().exception.toString(), this.getComms().exception);
            content.setTextStackTrace(stringWriter.toString());
            content.setTextErrorMessage(this.getComms().exception.getMessage());
        }
        
			return content.getElementContent();
    }
}
