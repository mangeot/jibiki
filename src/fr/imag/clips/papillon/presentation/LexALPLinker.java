/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.1  2005/07/08 08:22:46  serasset
 *  Reviewed the Abstract/BasePO hierarchy (moved some methods up in the tree).
 *  Added base classes to allow independant browsing window to establish links during edition.
 *
 *  -----------------------------------------------
 *  Class implementing small windows used to link elements.
 */
package fr.imag.clips.papillon.presentation;

import fr.imag.clips.papillon.presentation.xhtmllexalp.orig.*;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import com.lutris.appserver.server.Enhydra;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Comment;

import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLOptionElement;
import org.w3c.dom.html.HTMLSelectElement;

import org.enhydra.xml.xhtml.dom.*;

import org.enhydra.xml.xmlc.*;
//import org.enhydra.xml.xmlc.html.*;
import com.lutris.logging.*;
import com.lutris.util.*;

// For the cookies
//import javax.servlet.http.Cookie;
//import fr.imag.clips.papillon.business.user.UsersFactory;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.text.DateFormat;

//pour le debogage
import fr.imag.clips.papillon.business.utility.*;
import fr.imag.clips.papillon.business.PapillonLogger;

import org.enhydra.xml.io.OutputOptions;
import org.enhydra.xml.io.DOMFormatter;

/**
*  Description of the Class
 *
 * @author     serasset
 * @created    December 8, 2004
 */
public class LexALPLinker extends LinkerBasePO {
    
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return true;
    }
    
    
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean userMayUseThisPO() {
        return true;
    }
    
    public  Node getBrowserForm() throws Exception {
        LinkerBrowserFormXHTML form = (LinkerBrowserFormXHTML) MultilingualXHtmlTemplateFactory.createTemplate(PACKAGE, "LinkerBrowserFormXHTML", this.myComms, this.sessionData);
        
        return (Node) form.getElementLinkerBrowserForm();
    }
    
    public Node getResultList() throws Exception {
        LinkerResultListXHTML results = (LinkerResultListXHTML) MultilingualXHtmlTemplateFactory.createTemplate(PACKAGE, "LinkerResultListXHTML", this.myComms, this.sessionData);
        
        return (Node) results.getElementLinkerResultList();
    }
    
}
