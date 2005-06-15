/*
 * papillon 
 *
 * Enhydra super-servlet
 * 
 * © Mathieu Mangeot & Gilles Sérasset - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.2  2005/06/15 16:48:28  mangeot
 * Merge between the ContribsInXml branch and the main trunk. It compiles but bugs remain..
 *
 * Revision 1.1.2.4  2005/05/20 16:54:53  mangeot
 * Added ExportVolume functionnality
 *
 * Revision 1.1.2.3  2005/05/20 15:56:47  mangeot
 * *** empty log message ***
 *
 * Revision 1.1.2.2  2005/05/20 14:43:48  mangeot
 * Repair mismatch in branch tag
 *
 * Revision 1.1.2.1  2005/05/20 10:31:46  mangeot
 * Added 2 new classes 1 contributors board and one for exporting a volume
 *
 *
 *-----------------------------------------------
 * Papillon Export Volume page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;
import com.lutris.appserver.server.session.Session;


// manipulations HTML
import org.enhydra.xml.xhtml.dom.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import fr.imag.clips.papillon.business.message.MessageDBLoader;
import fr.imag.clips.papillon.presentation.PapillonSessionData;


// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.io.*;

import fr.imag.clips.papillon.presentation.xhtml.orig.ExportVolumeTmplXHTML;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.IQuery;
import fr.imag.clips.papillon.business.dictionary.Volume;


public class ExportVolume extends PapillonBasePO {

	protected final static String ALL="*ALL*";
	protected final static String SORTBY_PARAMETER="SortBy";
    protected final static String BASE_DIR_CONFIG = "Papillon.Informations.baseDir";
    protected final static String MEDIA_DIR_CONFIG = "Papillon.Informations.mediaDir";
	protected final static String EXPORT_VOLUME_DIR="export";
    
    protected static ExportVolumeTmplXHTML content;

    protected boolean loggedInUserRequired() {
        return true;
    }

    protected boolean userMayUseThisPO() {
        try {
            return this.getUser().isValidator();
        } catch (fr.imag.clips.papillon.business.PapillonBusinessException ex) {
            this.getSessionData().writeUserMessage("Error getting the authorisation to use this PO.");
        }
        return false;
    }
	
    protected  int getCurrentSection() {
        return NO_SECTION;
    }



    public Node getContent()
        throws javax.xml.parsers.ParserConfigurationException,
			HttpPresentationException,
		    IOException, org.xml.sax.SAXException,
			javax.xml.transform.TransformerException,
			fr.imag.clips.papillon.presentation.PapillonPresentationException {
        
        // Création du contenu
        content = (ExportVolumeTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("ExportVolumeTmplXHTML", this.getComms(), this.getSessionData());
	  
        HttpPresentationRequest req = this.getComms().request;

		String export = myGetParameter(content.NAME_EXPORT);
		String volume = myGetParameter(content.NAME_VOLUME);
		String author = myGetParameter(content.NAME_AUTHOR);
		String status = myGetParameter(content.NAME_STATUS);
		String sortBy = myGetParameter(SORTBY_PARAMETER);

        // If the page is called with parameters, take the requested action
		if (export != null && volume != null) {
		
			if (status != null && status.equals(ALL)) {
				status = null;
			}

		
			java.util.Vector myKeys = new java.util.Vector();
			java.util.Vector myClauses = new java.util.Vector();
			if (author != null && !author.equals("")) {
				String[] myKey = new String[4];
				myKey[0] = Volume.CDM_contributionAuthor;
				myKey[1] = Volume.DEFAULT_LANG;
				myKey[2] = author;
				myKey[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
				myKeys.add(myKey);
			}
			if (status != null && !status.equals("")) {
				String[] myKey = new String[4];
				myKey[0] = Volume.CDM_contributionStatus;
				myKey[1] = Volume.DEFAULT_LANG;
				myKey[2] = status;
				myKey[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];
				myKeys.add(myKey);
			}
		
			java.io.File fileDir = new java.io.File(getExportAbsoluteDir());
			fileDir.mkdirs();
			
			String filename = createFileName(volume);
			java.io.File exportFile = new java.io.File(fileDir.getCanonicalPath() + File.separator + filename);
			exportFile.createNewFile();
		
			FileOutputStream fileOutStream = new FileOutputStream(exportFile.getCanonicalFile());
			
			java.util.zip.GZIPOutputStream myGZipOutStream = new java.util.zip.GZIPOutputStream(fileOutStream);
		
			fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory.exportVolume(volume, myKeys, myClauses, myGZipOutStream);
		
			PapillonLogger.writeDebugMsg("Compressing volume");
			myGZipOutStream.close();
		
			String userMessage = "Volume " + volume + " exported";
			
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
			throw new ClientPageRedirectException(getExportRelativeDir() + filename); 			
		}
        
		addConsultForm(volume);
		
        //On rend le contenu correct
        return content.getElementFormulaire();
    }
	
	protected void addConsultForm(String selectedVolume) 
        throws fr.imag.clips.papillon.business.PapillonBusinessException, 
                HttpPresentationException {
           // Adding the appropriate source languages to the source list
        XHTMLOptionElement volumeOptionTemplate = content.getElementVolumeOptionTemplate();
        Node volumeSelect = volumeOptionTemplate.getParentNode();
        volumeOptionTemplate.removeAttribute("id");
        // We assume that the option element has only one text child 
        // (it should be this way if the HTML is valid...)
        Text volumeTextTemplate = (Text)volumeOptionTemplate.getFirstChild(); 
                
		fr.imag.clips.papillon.business.dictionary.Volume[] AllVolumes = fr.imag.clips.papillon.business.dictionary.VolumesFactory.getVolumesArray();
                
        for (int i = 0; i < AllVolumes.length; i++) {
            String volumeName = AllVolumes[i].getName();
            volumeOptionTemplate.setValue(volumeName);
            volumeOptionTemplate.setLabel(volumeName);
            // Je dois ici mettre un text dans l'OPTION, car les browser PC ne sont pas conformes aux 
            // specs W3C.
            volumeTextTemplate.setData(volumeName);
            volumeOptionTemplate.setSelected(volumeName.equals(selectedVolume));
            volumeSelect.appendChild(volumeOptionTemplate.cloneNode(true));
        }
        volumeSelect.removeChild(volumeOptionTemplate);
    }
	
	       
	protected String getExportAbsoluteDir() throws PapillonPresentationException {            
		String baseDir = "";
		String mediaDir = "";
		try {
			baseDir = com.lutris.appserver.server.Enhydra.getApplication().getConfig().getString(BASE_DIR_CONFIG);
			mediaDir = com.lutris.appserver.server.Enhydra.getApplication().getConfig().getString(MEDIA_DIR_CONFIG);
			if (! baseDir.endsWith(File.separator)) {
				baseDir = baseDir + File.separator;
			}
			if (! mediaDir.endsWith(File.separator)) {
				mediaDir = mediaDir + File.separator;
			}
		}
		catch (com.lutris.util.ConfigException ex) {
			throw new PapillonPresentationException("Error in Papillon Configuration File: ", ex);
		}
		baseDir = baseDir + mediaDir + EXPORT_VOLUME_DIR + File.separator;
		return baseDir;
	}

	protected String getExportRelativeDir() throws PapillonPresentationException {            
		String mediaDir = "";
		try {
			mediaDir = com.lutris.appserver.server.Enhydra.getApplication().getConfig().getString(MEDIA_DIR_CONFIG);
			if (! mediaDir.endsWith(File.separator)) {
				mediaDir = mediaDir + File.separator;
			}
		}
		catch (com.lutris.util.ConfigException ex) {
			throw new PapillonPresentationException("Error in Papillon Configuration File: ", ex);
		}
		mediaDir = mediaDir + EXPORT_VOLUME_DIR + File.separator;
		return mediaDir;
	}

	       
	protected String createFileName(String volume) {
		String timestamp = "" + new java.util.Date().getTime();
		String fileName = volume + "-" + timestamp + ".xml.gz";
		return fileName;
	}
					      


}
