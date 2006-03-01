/*
 *  papillon
 * 
 * (c) Francis Brunet-Manquat - GETA CLIPS IMAG
 * Projet Papillon
 */

package fr.imag.clips.papillon.business.transformation;


import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.user.User;

import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.PapillonBusinessException;


/** Interface PostProcessor.
* PostProcessor Modifies the volume entry after the entry editing
*
*/
public interface ResultPostProcessor {
    
    /** 
    transform the volume entry in post-preocessing.
    */
    public abstract void transformation(VolumeEntry ve, User user) throws PapillonBusinessException;
    
    
}