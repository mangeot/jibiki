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
 * Revision 1.2  2006/02/26 14:04:56  mangeot
 * Corrected a bug: the content was a static variable, thus there were problems when two users wanted to aces the same page at the same time
 *
 * Revision 1.1  2005/08/05 18:47:02  mangeot
 * *** empty log message ***
 *
 * Revision 1.9  2005/08/02 08:27:16  mangeot
 * Now, the display of an entry with EditEntryInit is done in the page itself.
 *
 * Revision 1.8  2005/07/30 13:52:13  mangeot
 * Commit due to some conflicts between directories. Beware !
 *
 * Revision 1.7  2005/07/28 16:40:33  mangeot
 * *** empty log message ***
 *
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

import fr.imag.clips.papillon.presentation.xhtml.orig.ProcessVolumeTmplXHTML;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.utility.Utility;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.IQuery;
import fr.imag.clips.papillon.business.dictionary.Volume;
import fr.imag.clips.papillon.business.dictionary.VolumesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;


public class ProcessVolume extends PapillonBasePO {
	
	protected final static String ALL="*ALL*";
	protected final static String DEFAULT="*default*";
	protected final static String SORTBY_PARAMETER="SortBy";
	protected final static String AnyContains_PARAMETER="AnyContains";
	    
    protected ProcessVolumeTmplXHTML content;

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
        content = (ProcessVolumeTmplXHTML)MultilingualXHtmlTemplateFactory.createTemplate("ProcessVolumeTmplXHTML", this.getComms(), this.getSessionData());
	  
        HttpPresentationRequest req = this.getComms().request;

		String convert = myGetParameter(content.NAME_CONVERT);
		String volume = myGetParameter(content.NAME_VOLUME);
		String stylesheetHandle = myGetParameter(content.NAME_STYLESHEET);

        // If the page is called with parameters, take the requested action
		if (convert != null && volume != null) {
					
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
			convertVolume(volume, myKeys, myClauses, stylesheetHandle);
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

		XHTMLOptionElement xslOptionTemplate = content.getElementXslOptionTemplate();
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
        xslSelect.removeChild(xslOptionTemplate);
				
	}
	
	
	protected void convertVolume (String volume, java.util.Vector myKeys, java.util.Vector myClauses, String stylesheetHandle) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		PapillonLogger.writeDebugMsg("Converting volume");

		fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory.convertVolume(volume, myKeys, myClauses, stylesheetHandle);
		
		String userMessage = "Volume " + volume + " converted";
		
		if (userMessage != null) {
			this.getSessionData().writeUserMessage(userMessage);
			PapillonLogger.writeDebugMsg(userMessage);
		}
	}
}
