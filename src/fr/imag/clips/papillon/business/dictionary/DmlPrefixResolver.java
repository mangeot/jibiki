/*
 *  DmlPrefixResolver.java
 *  papillon
 *
 *  Created by Mathieu Mangeot on 22/06/05.
 *  Copyright (c) 2005 GETA_CLIPS_IMAG. All rights reserved.
 *
 *---------------------------------------------------------
 * $Id$
 *---------------------------------------------------------
 * $Log$
 * Revision 1.2  2005/07/05 09:21:59  serasset
 * Template interface generator now correctly generates attribute names (with an @).
 * Target languages are now correctly handled when querying a pivot multilingual dictionary.
 *
 * Revision 1.1  2005/06/22 16:05:49  mangeot
 * *** empty log message ***
 *
 *
 *---------------------------------------------------------
 */

package fr.imag.clips.papillon.business.dictionary;

import fr.imag.clips.papillon.business.dictionary.VolumesFactory;

import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.w3c.dom.Node;

public class DmlPrefixResolver implements PrefixResolver  {
	
	//FIXME: le préfixe de DML est d. Il faudrait choisir un préfixe plus élaboré genre
	// papaillon_dml pour éviter les conflits avec des préfixes définis
	// dans d'autres dictionnaires
	
	
	protected static PrefixResolver defaultPrefixResolver = null;
	
	public DmlPrefixResolver(Node rootElement) {
		defaultPrefixResolver = new PrefixResolverDefault(rootElement);
	}
	
	public java.lang.String getNamespaceForPrefix(java.lang.String prefix) {
		if (prefix.equals(VolumesFactory.DEFAULT_DML_PREFIX)) {
			return VolumesFactory.DML_URI;
		}
		else 
			return defaultPrefixResolver.getNamespaceForPrefix(prefix);
	}
	
	public java.lang.String getNamespaceForPrefix(java.lang.String prefix, Node context) {
		if (prefix.equals(VolumesFactory.DEFAULT_DML_PREFIX)) {
			return VolumesFactory.DML_URI;
		}
		else 
			return defaultPrefixResolver.getNamespaceForPrefix(prefix, context);
	}
	
	public java.lang.String getBaseIdentifier() {
		return defaultPrefixResolver.getBaseIdentifier();
	}
	
	public boolean handlesNullPrefixes() {
		return defaultPrefixResolver.handlesNullPrefixes();
	}
	
}
