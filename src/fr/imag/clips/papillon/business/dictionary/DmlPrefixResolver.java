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
 * Revision 1.1  2005/06/22 16:05:49  mangeot
 * *** empty log message ***
 *
 *
 *---------------------------------------------------------
 */

package fr.imag.clips.papillon.business.dictionary;

import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.w3c.dom.Node;

public class DmlPrefixResolver implements PrefixResolver  {
	
	//FIXME: le préfixe de DML est d. Il faudrait choisir un préfixe plus élaboré genre
	// papaillon_dml pour éviter les conflits avec des préfixes définis
	// dans d'autres dictionnaires
	
	public final static String DML_PREFIX = "d";
	public final static String DML_URI = "http://www-clips.imag.fr/geta/services/dml";
    public final static String XLINK_URI = "http://www.w3.org/1999/xlink";

	
	protected static PrefixResolver defaultPrefixResolver = null;	
	
	public DmlPrefixResolver(Node rootElement) {
		defaultPrefixResolver = new PrefixResolverDefault(rootElement);
	}
	
	public java.lang.String getNamespaceForPrefix(java.lang.String prefix) {
		if (prefix.equals(DML_PREFIX)) {
			return DML_URI;
		}
		else 
			return defaultPrefixResolver.getNamespaceForPrefix(prefix);
	}
	
	public java.lang.String getNamespaceForPrefix(java.lang.String prefix, Node context) {
		if (prefix.equals(DML_PREFIX)) {
			return DML_URI;
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
