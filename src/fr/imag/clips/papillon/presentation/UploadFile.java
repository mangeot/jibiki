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
 * @author     serasset
 * @created    December 8, 2004
 */
public class UploadFile extends AbstractPO {
	
    protected final static String TMP_DIR_CONFIG="Papillon.Informations.tmpDir";

	/**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean loggedInUserRequired() {
        return true;
    }
    
    /**
    *  This method should be implemented in the subclass so that it returns
     *  true if this particular request requires the user to be logged in,
     *  otherwise false.
     *
     * @return    Description of the Return Value
     */
    protected boolean userMayUseThisPO() {
        return true;
    }
	
	
	public org.w3c.dom.Node getDocument() throws javax.xml.parsers.ParserConfigurationException,
	PapillonPresentationException,
	HttpPresentationException,
	java.io.IOException,
	IllegalArgumentException ,
	com.lutris.mime.MimeException,
	javax.xml.transform.TransformerException,
	org.xml.sax.SAXException {
				
		/*********************************/
		// Reading the request
		/*********************************/
		// Avant toute chose, on récupère les paramêtres selon la méthode que le client a utilisé
		// Ce peut-être du GET (c'est standard), du POST en url-encoded (c'est standard aussi dans enhydra)
		// ou bien du POST en multipart (non géré par enhydra, mais par le multipart request).
		HttpPresentationComms comms=this.getComms();
		
		String contentType = comms.request.getContentType();
		if (contentType == null) {
			contentType = "";
		}
		com.lutris.mime.ContentHeader contentHdr = new com.lutris.mime.ContentHeader("Content-Type: " + contentType);
		javax.servlet.http.HttpServletRequest req = null;
		
		if (contentHdr.getValue().toLowerCase().startsWith("multipart/")) {
			// On a affaire à un multipart request, on construit donc la requête appropriée.
			// ATTENTION: Pour simplifier la gestion du fichier chargé plus tard, je choisis le constructeur
			// qui force la sauvegarde des données dans un fichier temporaire.
			PapillonLogger.writeDebugMsg("Multipart request");
			String tmpDir="/tmp/";      // Dangereux ???
			try {
				tmpDir = Enhydra.getApplication().getConfig().getString(TMP_DIR_CONFIG);
				if (! tmpDir.endsWith(java.io.File.separator)) {
					tmpDir = tmpDir + java.io.File.separator;
				}
			} catch (com.lutris.util.KeywordValueException kve) {
				PapillonLogger.writeDebugMsg("Unexpected Error: Incorrect configuration file for group: "
											 + TMP_DIR_CONFIG);
			}
			req = new de.opus5.servlet.MultipartRequest(comms.request.getHttpServletRequest(), 30000000, tmpDir,"jibiki-tmp", true);
		}
		else {
			// PapillonLogger.writeDebugMsg("Normal request");
			req = comms.request.getHttpServletRequest();
		}
		
		/*********************************/
		// Managing the request
		/*********************************/
		String resultUrlValue = getFileUrl(req);
		
		
		/*********************************/
		// Creating the document Layout
		/*********************************/		
		return getForm(resultUrlValue);
		
	}
	
	
	/**
	*  Returns the complete document.
     *
     * @exception  Exception
     * @exception  HttpPresentationException  Description of the Exception
     * @exception  IOException                Description of the Exception
     */
    protected  org.w3c.dom.Node getForm(String resultURLValue)
	throws HttpPresentationException, java.io.IOException {
		
		UploadFileXHTML uploaderLayout;
				
		// Création du document
		uploaderLayout = (UploadFileXHTML) MultilingualXHtmlTemplateFactory.createTemplate("UploadFileXHTML", this.myComms, this.sessionData);
		
		// Add the resultURL as a value of an input
		// adding a script if needed
		XHTMLInputElement urlInputElement = (XHTMLInputElement) uploaderLayout.getElementResultUrl();
		urlInputElement.setValue(resultURLValue);
		
		return (org.w3c.dom.Node) uploaderLayout;
	}
	
	
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
				if (!type.equals("") && !type.equals("gzip") && !type.equals("x_gzip") && !type.equals("zip") && fileName!= null) {
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
				else if (type.equals("zip")) {
					newFile = unzipFile(theFile);
				}
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
	
	protected java.io.File ungzipFile (de.opus5.servlet.UploadedFile file) throws 
		java.io.IOException,
		fr.imag.clips.papillon.business.PapillonBusinessException,
			fr.imag.clips.papillon.business.PapillonImportException{
		// First, computing the output name
		String source = file.getFile().getCanonicalPath();
		String dest = source + ".ungz";		
		java.io.File newFile = null;
		java.io.InputStream is = file.getInputStream();
		
		if (is.available() == 0) {
			dest = "";
            PapillonLogger.writeDebugMsg("ImportGZippedFile: Encountered an empty GZipped file.");
			throw new fr.imag.clips.papillon.business.PapillonImportException("the GZipped file is empty.");
        } 
		else {
            // gunzip the file, then apply the appropriate action, based on gunzipped file type.

            java.io.FileOutputStream out = null;
            java.util.zip.GZIPInputStream zIn = null;
            try {
				newFile = new java.io.File(dest);
                out = new java.io.FileOutputStream(dest);
                zIn = new java.util.zip.GZIPInputStream(is);
                byte[] buffer = new byte[8 * 1024];
                int count = 0;
                do {
                    out.write(buffer, 0, count);
                    count = zIn.read(buffer, 0, buffer.length);
                } while (count != -1);
            } catch (java.io.IOException ioe) {
                String msg = "Problem expanding gzip " + ioe.getMessage();
                PapillonLogger.writeDebugMsg(msg);
                throw new fr.imag.clips.papillon.business.PapillonBusinessException(msg, ioe);
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (java.io.IOException ioex) {}
                }
                if (zIn != null) {
                    try {
                        zIn.close();
                    } catch (java.io.IOException ioex) {}
                }
            }
			file.getFile().deleteOnExit();
		}
		return newFile;
	}
	
	protected java.io.File unzipFile (de.opus5.servlet.UploadedFile file) throws 
		java.io.IOException,
		fr.imag.clips.papillon.business.PapillonBusinessException,
		fr.imag.clips.papillon.business.PapillonImportException{
			// First, computing the output name
			String source = file.getFile().getCanonicalPath();
			String dest = source + ".unzip";	
			java.io.File newFile = null;
			java.io.InputStream is = file.getInputStream();
			
			if (is.available() == 0) {
				dest = "";
				PapillonLogger.writeDebugMsg("ImportZippedFile: Encountered an empty Zipped file.");
				throw new fr.imag.clips.papillon.business.PapillonImportException("the Zipped file is empty.");
			} 
			else {
				// Here, we deal with archives containing one unique file
				// unzip the first file of the archive
				java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(is);
				java.util.zip.ZipEntry ze = zis.getNextEntry();
				if (ze != null &&   !ze.isDirectory()) {
					newFile = new java.io.File(dest);            
					byte[] buffer = new byte[1024];
                    int length = 0;
                    java.io.FileOutputStream fos = new java.io.FileOutputStream(newFile);
                    while ((length = zis.read(buffer)) >= 0) {
                        fos.write(buffer, 0, length);
                    }
                    fos.close();
					zis.close();
				}
				file.getFile().deleteOnExit();
			}
			return newFile;
		}	
	
	   // Copies src file to dst file.
	   // If the dst file does not exist, it is created
    void copyFile(java.io.File src, java.io.File dst) throws java.io.IOException {
        java.io.InputStream in = new java.io.FileInputStream(src);
        java.io.OutputStream out = new java.io.FileOutputStream(dst);
		
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}
