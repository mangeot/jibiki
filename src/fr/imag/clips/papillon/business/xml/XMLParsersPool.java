/*
 * Jibiki project
 *
 * © Gilles SŽrasset and Jibiki development team - GETA CLIPS IMAG
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2007/01/05 13:57:26  serasset
 * multiple code cleanup.
 * separation of XMLServices from the Utility class
 * added an xml parser pool to allow reuse of parser in a multithreaded context
 * added a new field in the db to identify the db layer version
 * added a new system property to know which db version is known by the current app
 *
 *
 */
 package fr.imag.clips.papillon.business.xml;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Manage a pool of XML Parsers that may be used concurrently.
 * As an XML parser is not synchronized, we should not allow 2 threads
 * to use a parser together. Moreover, creating a new parser is rather
 * time consuming, hence we manage a pool of parser that should be
 * allocated and released when necessary.
 * 
 */
public class XMLParsersPool {

    protected static LinkedList availableParsers;
    protected static HashSet unavailableParsers;
    protected static final int initialPoolSize = 5;
    protected static final DocumentBuilderFactory myDocumentBuilderFactory;


    static {
        myDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    }

    public static void initializeXMLParsersPool() throws PapillonBusinessException {
        
        if (null == availableParsers) {
            availableParsers = new LinkedList();
            unavailableParsers = new HashSet();
            for (int i = 0; i < initialPoolSize; i++) {
                try {
                    availableParsers.add(createParser());
                } catch (ParserConfigurationException e) {
                    throw new PapillonBusinessException("Error while initializing the XML parsers pool.", e);
                }
            }
        } else PapillonLogger.writeErrorMsg("XML parsers pool has already been initialized !");
    }

    protected static synchronized DocumentBuilder createParser() throws ParserConfigurationException {
        myDocumentBuilderFactory.setNamespaceAware(true);
		return myDocumentBuilderFactory.newDocumentBuilder(); 
    }
    
    public static synchronized DocumentBuilder allocateParser() throws PapillonBusinessException {
        DocumentBuilder parser;
        if (availableParsers.isEmpty()) {
            try {
                parser = createParser();
            } catch (ParserConfigurationException e) {
                throw new PapillonBusinessException("Configuration exception while allocating additional parser in the pool.", e);
            }
        } else {
            parser = (DocumentBuilder) availableParsers.removeFirst();
        }
        unavailableParsers.add(parser);
        return parser;
    }

    public static synchronized void releaseParser(DocumentBuilder parser) {
         if (unavailableParsers.contains(parser)) {
             unavailableParsers.remove(parser);
             availableParsers.addFirst(parser);
         } else {
             PapillonLogger.writeErrorMsg("Releasing a parser that was not allocated !");
         }
    }
}
