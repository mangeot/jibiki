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
 * Revision 1.6  2005/07/28 15:34:34  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2005/07/28 14:59:07  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2005/07/28 13:06:47  mangeot
 * - Added the possibility to export in PDF format. The conversion into PDF is don
 * e via the fop package that has to be installed (see ToolsForPapillon)
 *
 * Revision 1.3  2005/07/21 15:09:20  mangeot
 * Bug fixes and corrections mainly for the GDEF project
 *
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
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;


public class ExportVolume extends PapillonBasePO {
	
	protected final static String ALL="*ALL*";
	protected final static String DEFAULT="*default*";
	protected final static String SORTBY_PARAMETER="SortBy";
	protected final static String AnyContains_PARAMETER="AnyContains";
    protected final static String BASE_DIR_CONFIG = "Papillon.Informations.baseDir";
    protected final static String RELATIVE_DIR_CONFIG = "Papillon.Informations.relativeDir";
    protected final static String MEDIA_DIR_CONFIG = "Papillon.Informations.mediaDir";
	protected final static String EXPORT_VOLUME_DIR="export";
	
	protected static final String XMLFormat = Integer.toString(fr.imag.clips.papillon.business.transformation.ResultFormatterFactory.XML_DIALECT);
	protected static final String XHTMLFormat = Integer.toString(fr.imag.clips.papillon.business.transformation.ResultFormatterFactory.XHTML_DIALECT);
	protected static final String TEXTFormat = Integer.toString(fr.imag.clips.papillon.business.transformation.ResultFormatterFactory.PLAINTEXT_DIALECT);
	protected static final String PDFFormat = Integer.toString(fr.imag.clips.papillon.business.transformation.ResultFormatterFactory.PDF_DIALECT);
    
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
		String sortBy = myGetParameter(SORTBY_PARAMETER);
		String outputFormat = myGetParameter(content.NAME_FORMAT);

        // If the page is called with parameters, take the requested action
		if (export != null && volume != null) {
					
			// search1
			String search1 = myGetParameter(content.NAME_search1);
			String search1text = myGetParameter(content.NAME_search1text);
			
			// search2
			String search2 = myGetParameter(content.NAME_search2);
			String search2text = myGetParameter(content.NAME_search2text);
			
			String anyContains = null;
			
			
			if (null != search1 && null != search1text && !search1text.equals("")) {
				if (search1.equals(AnyContains_PARAMETER)) {
					anyContains = search1text;
				}
			}
			
			if (null != search2 && null != search2text && !search2text.equals("")) {
				if (search2.equals(AnyContains_PARAMETER)) {
					anyContains = search2text;
				}
			}
			
			// strategy1
			String strategyString1 = myGetParameter(content.NAME_Strategy1);
			int strategy1 = IQuery.STRATEGY_NONE;
			if (null != strategyString1 && !strategyString1.equals("")) {
				strategy1 = Integer.parseInt(strategyString1);
			}
			
			String strategyString2 = myGetParameter(content.NAME_Strategy2);
			int strategy2 = IQuery.STRATEGY_NONE;
						
			// status
			String status = myGetParameter(content.NAME_STATUS);
			if (status != null && status.equals(ALL)) {
				status = null;
			}
			
			java.util.Vector myKeys = new java.util.Vector();
			java.util.Vector myClauses = new java.util.Vector();
			Volume myVolume = VolumesFactory.findVolumeByName(volume);
			String source = "eng";
			if (myVolume !=null && !myVolume.isEmpty()) {
				source = myVolume.getSourceLanguage();
			}
			if (search1 !=null && !search1.equals("")  &&
				search1text != null && !search1text.equals("")) {
				if (strategy1 == IQuery.STRATEGY_GREATER_THAN ||
					strategy1 == IQuery.STRATEGY_GREATER_THAN_OR_EQUAL ||
					strategy1 == IQuery.STRATEGY_LESS_THAN ||
					strategy1 == IQuery.STRATEGY_LESS_THAN_OR_EQUAL) {
					String clause = "key='" + search1 + "'";
					clause += " and " + source + "_sort(value)" + IQuery.QueryBuilderStrategy[strategy1+1] + " " + source + "_sort('" + search1text +"') "; 
					myClauses.add(clause);
				}
				else {
					String[] key1 = new String[4];
					key1[0] = search1;
					key1[2] = search1text;
					key1[3] = IQuery.QueryBuilderStrategy[strategy1+1];
					myKeys.add(key1);
				}
			}
			if (search2 !=null && !search2.equals("") &&
				search2text != null && !search2text.equals("")) {
				if (strategy2 == IQuery.STRATEGY_GREATER_THAN ||
					strategy2 == IQuery.STRATEGY_GREATER_THAN_OR_EQUAL ||
					strategy2 == IQuery.STRATEGY_LESS_THAN ||
					strategy2 == IQuery.STRATEGY_LESS_THAN_OR_EQUAL) {
					String clause = "key='" + search2 + "'";
					clause += " and " + source + "_sort(value)" + IQuery.QueryBuilderStrategy[strategy2+1] + " " + source + "_sort('" + search2text +"') "; 
					myClauses.add(clause);
				}
				else {
					String[] key2 = new String[4];
					key2[0] = search2;
					key2[2] = search2text;
					key2[3] = IQuery.QueryBuilderStrategy[strategy2+1];
					myKeys.add(key2);
				}
			}
			if (status !=null && !status.equals("")) {
				String[] key2 = new String[4];
				key2[0] = Volume.CDM_contributionStatus;
				key2[1] = Volume.DEFAULT_LANG;
				key2[2] = status;
				key2[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_EXACT+1];			
				myKeys.add(key2);
			}
			else {
				String[] key2 = new String[4];
				key2[0] = Volume.CDM_contributionStatus;
				key2[1] = Volume.DEFAULT_LANG;
				key2[2] = VolumeEntry.VALIDATED_STATUS;
				key2[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_NOT_EQUAL+1];			
				myKeys.add(key2);			
				String[] key3 = new String[4];
				key3[0] = Volume.CDM_contributionStatus;
				key3[1] = Volume.DEFAULT_LANG;
				key3[2] = VolumeEntry.DELETED_STATUS;
				key3[3] = IQuery.QueryBuilderStrategy[IQuery.STRATEGY_NOT_EQUAL+1];			
				myKeys.add(key3);			
			}
		
			java.io.File fileDir = new java.io.File(getExportAbsoluteDir());
			fileDir.mkdirs();
			
			String filename = createFileName(volume, this.getUser().getLogin(), outputFormat);
			java.io.File exportFile = new java.io.File(fileDir.getCanonicalPath() + File.separator + filename);
			exportFile.createNewFile();
		
			FileOutputStream fileOutStream = new FileOutputStream(exportFile.getCanonicalFile());
			
			java.util.zip.GZIPOutputStream myGZipOutStream = new java.util.zip.GZIPOutputStream(fileOutStream);
			
			fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory.exportVolume(volume, myKeys, myClauses, outputFormat, myGZipOutStream);
			
			PapillonLogger.writeDebugMsg("Compressing volume");
			myGZipOutStream.close();
			
			String userMessage = "Volume " + volume + " exported";
			
			if (userMessage != null) {
				this.getSessionData().writeUserMessage(userMessage);
				PapillonLogger.writeDebugMsg(userMessage);
			}
			System.out.println("ClientPageRedirectException: " + getExportRelativeDir() + filename);
			
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

       /* XHTMLOptionElement xslOptionTemplate = content.getElementXslOptionTemplate();
        Node xslSelect = xslOptionTemplate.getParentNode();
        xslOptionTemplate.removeAttribute("id");
        Text xslTextTemplate = (Text)xslOptionTemplate.getFirstChild(); 
		
		fr.imag.clips.papillon.business.xsl.XslSheet[] AllXsls = fr.imag.clips.papillon.business.xsl.XslSheetFactory.getXslSheetsArray();
		
        for (int i = 0; i < AllXsls.length; i++) {
            String xslName = AllXsls[i].getName();
            String xslDescription = AllXsls[i].getDescription();
			if (xslDescription != null && !xslDescription.equals("")) {
				xslDescription = " (" + xslDescription + ")";
			}
			else {
				xslDescription = "";
			}
			xslName += xslDescription;
            xslOptionTemplate.setValue(AllXsls[i].getHandle());
            xslOptionTemplate.setLabel(xslName);
            xslTextTemplate.setData(xslName);
            xslSelect.appendChild(xslOptionTemplate.cloneNode(true));
        }
        xslSelect.removeChild(xslOptionTemplate); */
				
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
		String baseDir = "";
		String mediaDir = "";
		try {
			baseDir = com.lutris.appserver.server.Enhydra.getApplication().getConfig().getString(RELATIVE_DIR_CONFIG);
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

	       
	protected String createFileName(String volume, String login, String format) {
		String timestamp = "" + new java.util.Date().getTime();
		String extension = "";
		if (format !=null && format.equals(XHTMLFormat)) {
			extension = ".html";
		}
		else if (format !=null && format.equals(TEXTFormat)) {
			extension = ".txt";
		}
		else if (format !=null && format.equals(PDFFormat)) {
			extension = ".pdf";
		}
		else {
			extension = ".xml";
		}
		
		String fileName = volume + "-" + login + "-" + timestamp + extension + ".gz";
		return fileName;
	}
					      


}
