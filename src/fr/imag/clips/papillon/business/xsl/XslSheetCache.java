/*
 *  Jibiki
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Francis Brunet-Manquat, Mathieu Mangeot & Gilles Serasset - GETA CLIPS IMAG
 * Projet Jibiki 
 -----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2006/08/10 22:17:13  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 *
 */


package fr.imag.clips.papillon.business.xsl;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import java.util.Hashtable;
import java.util.Collection;


public class XslSheetCache {

    
    // Xsl sheets caches
    private static Hashtable xslSheetCache;
    private static Hashtable xslSheetCacheByHandle;   
    
    
    /** 
    * Initialize xsl sheet cache
    *
    * @exception PapillonBusinessException
    * 
    */
    public static void xslSheetCacheInit() 
        throws PapillonBusinessException {
            
            try {
                
                //
                xslSheetCache = new Hashtable();
                xslSheetCacheByHandle = new Hashtable();
                               
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in xslSheetCacheinit()", ex);
            }
        }
    
    
    /** 
        * Put xsl sheet in cache with Key composed of dictionary name, volume name and xsl name
        *
        * @param dictionary name
        * @param volume name
        * @param xsl name
        * @param xsl sheet
        *
        * @exception PapillonBusinessException
        * 
        */
    public static void putXslSheetInCache(String dictionaryName, String volumeName, String xslName, XslSheet xsl) 
        throws PapillonBusinessException {
            
            try {
                
                // Key is composed of dictionary name, volume name and xsl name
                String key = dictionaryName + "/" + volumeName + "/" + xslName;
                xslSheetCache.put(key, xsl);
                
                // Key is equal to 'handle' (database object id)
                if (!xslSheetCacheByHandle.containsKey(xsl.getHandle())) {
                    xslSheetCacheByHandle.put(xsl.getHandle(), xsl);
                }
                
                //
                PapillonLogger.writeDebugMsg("XslSheet " + key +" load");
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in putXslSheetInCache()", ex);
            }
        }
    
    
    /** 
        * Get xsl sheets in cache
        *
        * @return collection of XslSheet
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Collection getXslSheetsInCache() 
        throws PapillonBusinessException {
            
            try {
                
                //
                return xslSheetCacheByHandle.values();
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getXslSheetCache()", ex);
            }
        }

    
    /** 
        * Get xsl sheet
        *
        * @return xsl sheet
        *
        * @exception PapillonBusinessException
        * 
        */
    public static XslSheet getXslSheetInCache(String dictionaryName, String volumeName, String xslName) 
        throws PapillonBusinessException {
            
            try {
                
                //
                String key = dictionaryName + "/" + volumeName + "/" + xslName;
                
                //
                return (XslSheet)xslSheetCache.get(key);
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getXslSheet()", ex);
            }
        }
    
    
    /** 
        * Get xsl sheet by 'handle' (database object id)
        *
        * @return xsl sheet
        *
        * @exception PapillonBusinessException
        * 
        */
    public static XslSheet getXslSheetInCacheByHandle(String handle) 
        throws PapillonBusinessException {
            
            try {
                
                //
                return (XslSheet)xslSheetCacheByHandle.get(handle);
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getXslSheetInCacheByHandle()", ex);
            }
        }
    
}