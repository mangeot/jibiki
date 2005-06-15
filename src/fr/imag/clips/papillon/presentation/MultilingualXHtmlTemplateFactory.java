/*
 * papillon
 *
 * MultilingualXHtmlTemplateFactory.java
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.3  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.2  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.1.6.1  2005/05/27 11:53:34  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2004/12/24 08:57:44  serasset
 * Premiere version de l'interface avec fond papillon et transparence.
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *-----------------------------------------------
 * Multilingual XHTML Template Factory.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import java.util.ArrayList;

import fr.imag.clips.papillon.business.locales.LanguageFactory;

import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

public class MultilingualXHtmlTemplateFactory {
    private final static String PACKAGE = "fr.imag.clips.papillon.presentation.xhtml";
    private final static String ORIG_PACKAGE = PACKAGE + "orig.";

    private final static String DEFAULT_LANGUAGE = "eng";
    
    /**
     * Return an HTML Template object that is a localized instance of the
     * requested class. The language of the returned object depends on
     * the HTTPRequest (which contains the user's preferred languages).
     *
     * @return The localized HTML Template Object
     * @deprecated Use createTemplate with package specifier.
     */
    public static java.lang.Object createTemplate(String xhtmlClass,
                                                  HttpPresentationComms comms,
                                                  PapillonSessionData sessiondata)
        throws HttpPresentationException
    {
        return createTemplate(PACKAGE,xhtmlClass,comms,sessiondata);
    }
    
    /**
        * Return an HTML Template object that is an localized instance of the
     * requested class. The language of the returned object depends on
     * the HTTPRequest (which contains the user's preferred languages).
     *
     * @return The localized HTML Template Object
     */
    public static java.lang.Object createTemplate(String xhtmlPackage,
                                                  String xhtmlClass,
                                                  HttpPresentationComms comms,
                                                  PapillonSessionData sessiondata)
        throws HttpPresentationException
    {
        
        ArrayList languages = sessiondata.getUserAcceptLanguages();
        
        int i = 0;
        java.lang.Object template = null;
        
        while (i != languages.size() &&
               (template = getTemplateForLanguage(xhtmlPackage, xhtmlClass, (String)languages.get(i), comms)) == null) {
            i++;
        }
        if (i == languages.size()) {
            try {
                template = comms.xmlcFactory.create(Class.forName(xhtmlPackage + ".orig." + xhtmlClass));
            } catch (java.lang.ClassNotFoundException e) {
                throw new HttpPresentationException("ERREUR:", e);
            }
        }
        
        return template;
        
    }
    
    public static java.lang.Object getTemplateForLanguage(String xhtmlPackage, String htmlClass, String lang, HttpPresentationComms comms) {
        String className = xhtmlPackage + "." + lang + "." + htmlClass;
        java.lang.Object template = null;
		
        try {
            template = comms.xmlcFactory.create(Class.forName(className));
        } catch (java.lang.ClassNotFoundException e) {
        }
        return template;
    }

    public static ArrayList getAcceptLanguages (HttpPresentationRequest req)  {
        ArrayList defaultAccept = new ArrayList();
        defaultAccept.add(new String(DEFAULT_LANGUAGE));

        ArrayList res = null;

        try {
            String languages = null;
            languages = req.getHeader("Accept-Language");
            res = LanguageFactory.decodeAcceptLanguages(languages);
        } catch (com.lutris.appserver.server.httpPresentation.HttpPresentationException e) {
            res = defaultAccept;
        }
        return (null == res || 0 == res.size()) ? defaultAccept : res;
    }
    
}
