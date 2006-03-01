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
 * Revision 1.2  2006/03/01 15:41:13  mangeot
 * bug fixes
 *
 * Revision 1.1  2006/03/01 15:12:31  mangeot
 * Merge between maintrunk and LEXALP_1_1 branch
 *
 *
 *-----------------------------------------------
 * Papillon Login page.
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.ClientPageRedirectException;

//import org.enhydra.xml.xmlc.XMLObject;
import org.enhydra.xml.xhtml.dom.*;
import org.w3c.dom.*;

// internal imports
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.transformation.ResultFormatter;
import fr.imag.clips.papillon.business.transformation.ResultFormatterFactory;
import fr.imag.clips.papillon.business.dictionary.QueryResult;
import fr.imag.clips.papillon.business.user.User;
import fr.imag.clips.papillon.presentation.xhtml.orig.*;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;



public class ConfirmEntry extends EditingBasePO {
    
    public static String EntryHandle_PARAMETER = EditEntry.EntryHandle_PARAMETER;
    public static String VolumeName_PARAMETER = EditEntry.VolumeName_PARAMETER;  
	public static String Referrer_PARAMETER = EditEntry.Referrer_PARAMETER; 
	public static String EditingErrorURL = EditEntry.EditingErrorURL; 
	
    protected boolean loggedInUserRequired() {
        return true;
    }
	
    protected boolean userMayUseThisPO() {
        return true;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }
	
    public org.w3c.dom.Node getContent() 
		throws java.io.UnsupportedEncodingException, 
		HttpPresentationException {
			
			// Management of the parameters
			String volumeName = myGetParameter(VolumeName_PARAMETER);
			String entryHandle = myGetParameter(EntryHandle_PARAMETER);
			String referrer = myGetParameter(Referrer_PARAMETER);
			
			// Manage VolumeEntry
			VolumeEntry myVolumeEntry = null;
			if (volumeName!=null && !volumeName.equals("")
				&& entryHandle!=null && !entryHandle.equals("")) {
                
				// VolumeEntry
				myVolumeEntry = VolumeEntriesFactory.findEntryByHandle(volumeName, entryHandle);
                
				// Verification 
				if ( !(myVolumeEntry.getStatus().equals(VolumeEntry.FINISHED_STATUS) 
					   && myVolumeEntry.getModificationAuthor().equals(this.getUser().getLogin())) ) {
					
					// Error page
					throw new ClientPageRedirectException(EditingErrorURL);
				}
			}
			
			//
			ConfirmEntryXHTML content = (ConfirmEntryXHTML) MultilingualXHtmlTemplateFactory.createTemplate("ConfirmEntryXHTML", this.myComms, this.sessionData);
			
			//
			QueryResult qr = new QueryResult(1, myVolumeEntry);
			ResultFormatter rf = ResultFormatterFactory.getFormatter(qr, null, ResultFormatterFactory.XHTML_DIALECT,null);
			Element resultElement = (Element)rf.getFormattedResult(qr, this.getUser());
			
			//
			XHTMLTableCellElement editingResultViewElement = content.getElementEditingResultView();
			editingResultViewElement.appendChild(content.importNode(resultElement, true));
			
			//
			return content.getElementConfirmEntryContent();
		}
}