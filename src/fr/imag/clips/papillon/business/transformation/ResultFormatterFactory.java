/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * (c) Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------
 *$Id$
 *------------------------
 *$Log$
 *Revision 1.2  2005/06/15 20:40:04  serasset
 *bugfix: transformer -> transformation in default transformer class name.
 *
 *Revision 1.1  2005/05/24 12:51:21  serasset
 *Updated many aspect of the Papillon project to handle lexalp project.
 *1. Layout is now parametrable in the application configuration file.
 *2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 *3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 *4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 *5. It is now possible to give a name to the cookie key in the app conf file
 *6. Several bug fixes.
 *
 *------------------------
 */

package fr.imag.clips.papillon.business.transformation;

import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.QueryResult;

import fr.imag.clips.papillon.business.PapillonBusinessException;

public class ResultFormatterFactory {
    
    public static final int XHTML_DIALECT = 1;
    public static final int HTML_DIALECT = 2;
    public static final int WML_DIALECT = 3;
    public static final int XML_DIALECT = 4;
    public static final int PLAINTEXT_DIALECT = 5;

    
    public static ResultFormatter getFormatter(QueryResult qr, int dialect, String lang)
        throws PapillonBusinessException 
    {
        // returns the formatter for the appropriate volume or dictionary.
        return getFormatter(qr.getSourceEntry().getDictionary(), qr.getSourceEntry().getVolume(), dialect, lang);
    }
    
    public static ResultFormatter getFormatter(Dictionary dict, Volume vol, int dialect, String lang) 
        throws PapillonBusinessException 
    {
        // returns the formatter for the appropriate volume or dictionary.
        // FIXME: Maybe the dialect and/or lang could be use to select a formatter class name.
        // Check if a special transformer is implemented for this Volume/dictionary
        String formatterClassName = null;
        formatterClassName = vol.getFormatterClassName();
        if (formatterClassName == null) {
            formatterClassName = dict.getFormatterClassName();
        }
        
        // If not, use the generic XslTransformer
        if (formatterClassName == null) {
            formatterClassName = "fr.imag.clips.papillon.business.transformation.XslTransformation";
        }
        
        // Instanciate the formatter
        ResultFormatter formatter = null;
        try {
            formatter = (ResultFormatter) Class.forName(formatterClassName).newInstance();
            formatter.initializeFormatter(dict, vol, dialect, lang);
        } catch (java.lang.ClassNotFoundException e) {
            throw new PapillonBusinessException("Could not initialize formatter. [class: " + formatterClassName + "]", e);
        } catch (java.lang.InstantiationException e) {
            throw new PapillonBusinessException("Could not initialize formatter. [class: " + formatterClassName + "]", e);
        } catch (java.lang.IllegalAccessException e) {
            throw new PapillonBusinessException("Could not initialize formatter. [class: " + formatterClassName + "]", e);
        }
        
        return formatter;
    }
    
    
    public static ResultFormatter getFormatter(String formatterName) {
        // returns the formatter named formatterName (should be a valid formatterName as returned by getAvailableFormatters).
        return null;
    }
    
    // Returns a list of available Formatter Names
    public static String[] getAvailableFormatters(Volume vol, int dialect, String lang) {
        return null;
    }
    
}