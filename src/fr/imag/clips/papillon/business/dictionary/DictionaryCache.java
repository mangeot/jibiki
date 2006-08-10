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
 * Revision 1.1  2006/08/10 22:17:12  fbrunet
 * - Add caches to manage Dictionaries, Volumes and Xsl sheets (improve efficiency)
 * - Add export contibutions to pdf file base on exportVolume class and, Saxon8b & FOP transformations (modify papillon.properties to specify XML to FO xsl)
 * - Bug correction : +/- in advanced search
 *
 *
 */


package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import java.util.Hashtable;
import java.util.Collection;


public class DictionaryCache {
    
    
    // Dictionary cache
    private static Hashtable dictionaryCache;
    private static Hashtable dictionaryCacheByHandle; 
    
    /** 
    * Initialize dictionary cache
    *
    * @exception PapillonBusinessException
    * 
    */
    public static void dictionaryCacheInit() 
        throws PapillonBusinessException {
            
            try {
                
                //
                dictionaryCache = new Hashtable();
                dictionaryCacheByHandle = new Hashtable();
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in dictionaryCacheInit()", ex);
            }
        }
    
    
    /** 
        * Put dictionary in cache with dictionary name key
        *
        * @param dictionary name
        * @param xsl sheet
        *
        * @exception PapillonBusinessException
        * 
        */
    public static void putDictionaryInCache(String dictionaryName, Dictionary dict) 
        throws PapillonBusinessException {
            
            try {
                
                //
                PapillonLogger.writeDebugMsg("Dictionary " + dictionaryName +" load");
                dictionaryCache.put(dictionaryName, dict);
                
                // Key is equal to 'handle' (database object id)
                dictionaryCacheByHandle.put(dict.getHandle(), dict);

            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in putDictionaryInCache()", ex);
            }
        }
    
    
    /** 
        * Get dictionaries in cache
        *
        * @return collection of Dictionaries
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Collection getDictionariesInCache() 
        throws PapillonBusinessException {
            
            try {
                
                //
                return dictionaryCacheByHandle.values();
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getDictionariesInCache()", ex);
            }
        }
    
    
    /** 
        * Get dictionary
        *
        * @return Dictionary
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Dictionary getDictionaryInCache(String key) 
        throws PapillonBusinessException {
            
            try {
                
                //
                return (Dictionary)dictionaryCache.get(key);
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getDictionaryInCache()", ex);
            }
        }

    
    /** 
        * Get dictionary by 'handle' (database object id)
        *
        * @return Dictionary
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Dictionary getDictionaryInCacheByHandle(String handle) 
        throws PapillonBusinessException {
            
            try {
                
                //
                return (Dictionary)dictionaryCacheByHandle.get(handle);
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getDictionaryInCacheByHandle()", ex);
            }
        }
}
