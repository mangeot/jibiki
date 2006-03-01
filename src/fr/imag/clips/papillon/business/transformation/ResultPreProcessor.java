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


/** Interface PreProcessor.
* PreProcessor Modifies the volume entry before the entry editing
*
*/
public interface ResultPreProcessor {
        
    /** 
    transform the volume entry in pre-preocessing.
    */
    public abstract void transformation(VolumeEntry ve, User user) throws PapillonBusinessException;
    
    
}