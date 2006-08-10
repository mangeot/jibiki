/*
 *  papillon
 *
 *  Enhydra super-servlet
 *
 *  © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 *  Projet Papillon
 *  -----------------------------------------------
 *  $Id$
 *  -----------------------------------------------
 *  $Log$
 *  Revision 1.1  2006/08/10 09:55:21  mangeot
 *  Added a bunzipper for .bz2 compressed files
 *
 *  Revision 1.2  2006/08/07 09:32:21  mangeot
 *  Bug fix: when the method was finished, the file was deleted. I make a copy of the file before exiting.
 *
 *  Revision 1.1  2006/08/03 15:22:47  mangeot
 *  This page is used in order to upload a unique file on the server. The file can be zipped or gzipped. This page must be called via a javascript with window.open.
 *  See the AdminXsl.po for an example.
 *
 *
 *  -----------------------------------------------
 *  Abstract class implementing small windows used to upload documents.
 */
package fr.imag.clips.papillon.presentation;

// Papillon import
import fr.imag.clips.papillon.presentation.xhtml.orig.*;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;

import org.enhydra.xml.xhtml.dom.XHTMLInputElement;
import com.lutris.appserver.server.Enhydra;

//pour le debogage
import fr.imag.clips.papillon.business.PapillonLogger;

/**
*  Description of the Class
 *
 * @author     mangeot
 * @created    August 8, 2006
 *
 * Same as UploadFile but do not unzip if it is a zipped archive. It may be unzipped later. Used by AdminInformations.java
 */
public class UploadSimpleFile extends UploadFile {
	
	protected String getFileUrl(javax.servlet.http.HttpServletRequest mReq)
	throws 	javax.xml.parsers.ParserConfigurationException,
	HttpPresentationException,
	java.io.IOException,
	IllegalArgumentException ,
	com.lutris.mime.MimeException,
	javax.xml.transform.TransformerConfigurationException,
	javax.xml.transform.TransformerException,
	org.xml.sax.SAXException  {
		String theURL = "";
		
		if (mReq.getClass().getName().equals("de.opus5.servlet.MultipartRequest")) {
			
			de.opus5.servlet.UploadedFile theFile = ((de.opus5.servlet.MultipartRequest)mReq).getUploadedFile(UploadFileXHTML.NAME_file);
			if (null != theFile && !theFile.getName().equals("")) {
				String fileName = theFile.getName();
				String contentType = theFile.getContentType();
				String type = "";
				java.io.File newFile = null;
				if (null != contentType) {
					try {
						int i = contentType.indexOf("/");
						String category = contentType.substring(0, i).replace('-', '_');
						type = contentType.substring(i+1).replace('-', '_');
					} catch (IndexOutOfBoundsException e) {
						PapillonLogger.writeDebugMsg("Unexpected Error: malformed content type: " + contentType);
					}
				} 
				if (!type.equals("") && !type.equals("gzip") && !type.equals("x_gzip") && !type.equals("bzip2") && !type.equals("x_bzip2") && !type.equals("zip") && fileName!= null) {
					try {
						int i = fileName.lastIndexOf(".");
						type = fileName.substring(i+1).toLowerCase();
					} catch (IndexOutOfBoundsException e) {
						PapillonLogger.writeDebugMsg("Unexpected Error: Can't determine file extension for file: " + fileName);
					}
				}				
				if (type.equals("gzip") || type.equals("x_gzip") || type.equals("gz")) {
					newFile = ungzipFile(theFile);
				}
				else if (type.equals("bzip") || type.equals("x_bzip") || type.equals("bz2")  || type.equals("bz")) {
					newFile = unbzipFile(theFile);
				}
				// Do not unzip the file. It will be done later
				//else if (type.equals("zip")) {
				//	newFile = unzipFile(theFile);
				//}
				else {
					// The pb was the following: when exiting the method, the file was deleted
					// So I copy it.
					newFile = new java.io.File(theFile.getFile().getCanonicalPath()+".file");
					copyFile(theFile.getFile(), newFile);
					theFile.getFile().deleteOnExit();
				}
				theURL = newFile.toURL().toExternalForm();
			}
			
		}
		return theURL;
	}	
}
