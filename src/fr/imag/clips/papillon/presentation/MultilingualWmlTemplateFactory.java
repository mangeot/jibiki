/*
 * papillon
 *
 * MultilingualWmlTemplateFactory.java
 *
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.3  2003/09/03 10:15:45  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.2  2003/08/14 08:30:18  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.1.2.2  2003/06/27 05:28:42  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.1  2003/05/28 09:17:23  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1  2002/12/06 05:12:45  mangeot
 * Essai de pages WAP/WML
 *
 *
 *-----------------------------------------------
 * Multilingual WML Template Factory.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import java.util.ArrayList;

import fr.imag.clips.papillon.business.locales.LanguageFactory;

import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

public class MultilingualWmlTemplateFactory {
    private final static String PACKAGE = "fr.imag.clips.papillon.presentation.wml.";
    private final static String ORIG_PACKAGE = PACKAGE + "orig.";

    private final static String DEFAULT_LANGUAGE = "eng";
    
    /**
     * Return an HTML Template object that is an localized instance of the
     * requested class. The language of the returned object depends on
     * the HTTPRequest (which contains the user's preferred languages).
     *
     * @return The localized HTML Template Object
     */
    public static java.lang.Object createTemplate(String wmlClass,
                                                  HttpPresentationComms comms,
                                                  PapillonSessionData sessiondata)
        throws HttpPresentationException
    {
        ArrayList languages = sessiondata.getUserAcceptLanguages();

        int i = 0;
        int languagesSize = 0;
        java.lang.Object template = null;

        if (languages != null) {
            languagesSize = languages.size();
        }
        while (i != languagesSize &&
               (template = getTemplateForLanguage(wmlClass, (String)languages.get(i), comms)) == null) {
            i++;
        }
        if (i == languagesSize) {
            try {
                template = comms.xmlcFactory.create(Class.forName(ORIG_PACKAGE + wmlClass));
            } catch (java.lang.ClassNotFoundException e) {
                throw new HttpPresentationException("ERREUR:", e);
            }
        }
        return template;

    }

    public static java.lang.Object getTemplateForLanguage(String wmlClass, String lang, HttpPresentationComms comms) {
        String className = PACKAGE + lang + "." + wmlClass;
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
