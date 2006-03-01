/*
 *  papillon
 * 
 * (c) Francis Brunet-Manquat - GETA CLIPS IMAG
 * Projet Papillon
 */

package fr.imag.clips.papillon.business.transformation;

import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.Dictionary;
import fr.imag.clips.papillon.business.dictionary.Volume;

import fr.imag.clips.papillon.business.PapillonBusinessException;

public class ResultPostProcessorFactory {
    
     // returns the postProcessor for the appropriate volume or dictionary. 
    public static  ResultPostProcessor getPostProcessor(VolumeEntry volumeEntry)
    throws PapillonBusinessException {
        
        Volume volume = volumeEntry.getVolume();
        Dictionary dictionary = volumeEntry.getDictionary();
        
        String postProcessorClassName = null;
        postProcessorClassName = volume.getPostProcessorClassName();
        
        if (postProcessorClassName == null) {
            postProcessorClassName = dictionary.getPostProcessorClassName();
        }
        
        // If not, use the generic PostProcessor
        if (postProcessorClassName == null) {
            postProcessorClassName = "fr.imag.clips.papillon.business.transformation.PostProcessor";
        }
        
        // Instanciate the postProcessor
        ResultPostProcessor postProcessor = null;
        try {
            postProcessor = (ResultPostProcessor) Class.forName(postProcessorClassName).newInstance();
        } catch (java.lang.ClassNotFoundException e) {
            throw new PapillonBusinessException("Could not initialize postProcessor. [class: " + postProcessorClassName + "]", e);
        } catch (java.lang.InstantiationException e) {
            throw new PapillonBusinessException("Could not initialize postProcessor. [class: " + postProcessorClassName + "]", e);
        } catch (java.lang.IllegalAccessException e) {
            throw new PapillonBusinessException("Could not initialize postProcessor. [class: " + postProcessorClassName + "]", e);
        }
        
        return postProcessor;
    }
    
}
