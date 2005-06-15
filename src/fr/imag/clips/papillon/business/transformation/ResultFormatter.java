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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;


/** Interface ResultFormatter.
 * ResultFormatter take QueryResults and return an element that is to be included in the presentation object.
 * The resulting Element may be html, xhtml, wml...
 */
public interface ResultFormatter {
        
    // FIXME: is it dangerous to allow different formatter for different output languages ?
    public abstract void initializeFormatter(Dictionary dict, Volume vol, int dialect, String lang)
    throws PapillonBusinessException;
    
    /** 
        returns the Node representing the result.
    */
    public abstract Node getFormattedResult(QueryResult qr) throws PapillonBusinessException;
    
    
}