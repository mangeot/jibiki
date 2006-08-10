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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Enumeration;

public class VolumeCache {
    
    
    // Volume cache
    private static Hashtable volumeCache;
    private static Hashtable volumeCacheByHandle;
    private static Hashtable volumeCacheByDictionaryName;
    private static Hashtable volumeCacheBySource;
    private static Hashtable volumeCacheByTarget;
    
    /** 
    * Initialize volume cache
    *
    * @exception PapillonBusinessException
    * 
    */
    public static void volumeCacheInit() 
        throws PapillonBusinessException {
            
            try {
                
                //
                volumeCache = new Hashtable();
                volumeCacheByHandle = new Hashtable();
                volumeCacheByDictionaryName = new Hashtable();
                volumeCacheBySource = new Hashtable();
                volumeCacheByTarget = new Hashtable();
                              
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in volumeCacheInit()", ex);
            }
        }
    
    
    /** 
        * Put volume in caches
        *
        * @param volume name
        * @param xsl sheet
        *
        * @exception PapillonBusinessException
        * 
        */
    public static void putVolumeInCache(String volumeName, Volume vol) 
        throws PapillonBusinessException {
            
            try {
                
                // Key is equal to volume name
                volumeCache.put(volumeName, vol);
                
                // Key is equal to 'handle' (database object id)
                volumeCacheByHandle.put(vol.getHandle(), vol);
                
                // Key is equal to dictionary name
                putVolumeInCache(volumeCacheByDictionaryName, vol.getDictname(), vol);
                
                // Key is equal to source
                putVolumeInCache(volumeCacheBySource, vol.getSourceLanguage(), vol);
                
                // Key is equal to target
                Collection targets = vol.getTargetLanguagesArray();
                String targetsList = new String("");
                for (Iterator iter = targets.iterator(); iter.hasNext();) {
                    String target = (String)iter.next();
                    
                    //
                    putVolumeInCache(volumeCacheByTarget, target, vol);
                    targetsList = targetsList + target;
                }
                
                //
                PapillonLogger.writeDebugMsg("Volume " + volumeName + " (" + vol.getHandle() + ") [" + vol.getDictname() + "] " + vol.getSourceLanguage() + " -> " + targetsList + " load");
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in putVolumeInCache()", ex);
            }
        }
    
    
    /** 
        * Put collection of volumes in cache
        *
        * @param Hashtable
        * @param String
        * @param Volume
        *
        * @exception PapillonBusinessException
        * 
        */
    private static void putVolumeInCache(Hashtable hash, String key, Volume volume)
        throws PapillonBusinessException {

        try {
            
            if (hash.containsKey(key)) {
                
                //
                ArrayList collection = (ArrayList)hash.get(key);
                collection.add(volume);
                hash.put(key, collection);
                
            } else {
                
                //
                ArrayList collection = new ArrayList();
                collection.add(volume);
                hash.put(key, collection);
            }
            
        } catch(Exception ex) {
            throw new PapillonBusinessException("Exception in putVolumeInCache()", ex);
        }
        
    }
    
    
    /** 
        * Get volumes in cache
        *
        * @return collection of Volumes
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Collection getVolumesInCache() 
        throws PapillonBusinessException {
            
            try {
                
                //
                Collection collection = volumeCacheByHandle.values();
                
                //
                if (collection == null) {
                    return new ArrayList();
                } else {
                    return collection;
                }
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumesInCache()", ex);
            }
        }
    
    
    /** 
        * Get volume
        *
        * @return Volume
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Volume getVolumeInCache(String key) 
        throws PapillonBusinessException {
            
            try {
                
                //
                return (Volume)volumeCache.get(key);
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumeInCache()", ex);
            }
        }
    
    
    /** 
        * Get volume by 'handle' (database object id)
        *
        * @return Volume
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Volume getVolumeInCacheByHandle(String handle) 
        throws PapillonBusinessException {
            
            try {
                
                //
                return (Volume)volumeCacheByHandle.get(handle);
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumeInCacheByHandle()", ex);
            }
        }
    
    /** 
        * Get volumes by dictionary name
        *
        * @return Collection
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Collection getVolumesInCacheByDictionaryName(String dictionaryName) 
        throws PapillonBusinessException {
            
            try {
                
                //
                ArrayList collection = (ArrayList)volumeCacheByDictionaryName.get(dictionaryName);
                
                //
                if (collection == null) {
                    return new ArrayList();
                } else {
                    return collection;
                }
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumesInCacheByDictionaryName()", ex);
            }
        }
    
    /** 
        * Get volumes by source language
        *
        * @return Collection
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Collection getVolumesInCacheBySourceLanguage(String source) 
        throws PapillonBusinessException {
            
            try {

                //
                ArrayList collection = (ArrayList)volumeCacheBySource.get(source);
                
                //
                if (collection == null) {
                    return new ArrayList();
                } else {
                    return collection;
                }
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumesInCacheBySource()", ex);
            }
        }
    
    /** 
        * Get all source languages
        *
        * @return Collection
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Enumeration getSourceLanguagesInCache() 
        throws PapillonBusinessException {
            
            try {
                
                //
                return volumeCacheBySource.keys();
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getSourceLanguagesInCache()", ex);
            }
        }
    
    
    
    /** 
        * Get volumes by target language
        *
        * @return Enumeration
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Collection getVolumesInCacheByTargetLanguage(String target) 
        throws PapillonBusinessException {
            
            try {
                
                //
                ArrayList collection = (ArrayList)volumeCacheByTarget.get(target);
                
                //
                if (collection == null) {
                    return new ArrayList();
                } else {
                    return collection;
                }
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getVolumesInCacheByTarget()", ex);
            }
        }
    
    
    /** 
        * Get all target languages
        *
        * @return Enumeration
        *
        * @exception PapillonBusinessException
        * 
        */
    public static Enumeration getTargetLanguagesInCache() 
        throws PapillonBusinessException {
            
            try {
                
                //
                return volumeCacheByTarget.keys();
                
            } catch(Exception ex) {
                throw new PapillonBusinessException("Exception in getTargetLanguagesInCache()", ex);
            }
        }
    
}

