

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationRequest;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLElement;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// Standard imports
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.text.DateFormat;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.dictionary.VolumeEntriesFactory;
import fr.imag.clips.papillon.business.dictionary.VolumeEntry;
import fr.imag.clips.papillon.business.user.*;
import fr.imag.clips.papillon.data.VolumeEntryDO;
import fr.imag.clips.papillon.presentation.xhtml.orig.*;

public class Test extends PapillonBasePO {
    protected  int getCurrentSection() {
        return NO_SECTION;
    }
    protected boolean loggedInUserRequired() {
        return false;
    }

    
    protected boolean userMayUseThisPO() {
        return true;
    }
    
    TestZYXHTML content;
    public Node getContent()
    throws HttpPresentationException, IOException {
        
        Node contentNode;
        
        // Création du contenu
        content = (TestZYXHTML)MultilingualXHtmlTemplateFactory.createTemplate("TestZYXHTML", this.getComms(), this.getSessionData());
       
        HttpPresentationRequest req = this.getComms().request;
        addUserListArray();
        addResultSearchArray();
        //contentNode = content.getElementHelpContent();
        
        //On rend le contenu correct
        return content.getElementTestUserList();
    }
	private void addUserListArray() throws PapillonBusinessException {
		
		 User MyUser = UsersFactory.findUserByName("zhang");
		 content.setTextName(MyUser.getName());
		 content.setTextLogin(MyUser.getLogin());
		 content.setTextEmail(MyUser.getEmail());
		 content.setTextGroup(MyUser.getGroups());
		 content.setTextLangue(MyUser.getLang());
		 
	}
	private void addResultSearchArray() throws PapillonBusinessException {
    	ArrayList searchList = new ArrayList();
    	ArrayList condList0 = new ArrayList();  
    	condList0.add("aabits");
    	searchList.add(condList0);
    	ArrayList condList1 = new ArrayList();     	
    	condList1.add("poids");
    	condList1.add("2"); //1:= 2:< 3:>
    	condList1.add("0.7");
    	searchList.add(condList1);
//    	ArrayList condList2 = new ArrayList();   
//    	condList2.add("poids");
//    	condList2.add(2); 
//    	condList2.add(0.9);
//    	searchList.add(condList2);
//    	ArrayList condList3 = new ArrayList();   
//    	condList3.add("poids");
//    	condList3.add(1); 
//    	condList3.add(0.9);
//    	searchList.add(condList3);
//    	ArrayList condList4 = new ArrayList();   
//    	condList4.add("poids");
//    	condList4.add(3); 
//    	condList4.add(0.3);
//    	searchList.add(condList4);
//    	ArrayList condList5 = new ArrayList();   
//    	condList5.add("dico");
//    	condList5.add(1); 
//    	condList5.add("GDEF");
//    	searchList.add(condList5);
//    	ArrayList condList6 = new ArrayList();   
//    	condList6.add("lc");
//    	condList6.add(1); 
//    	condList6.add("fra");
//    	searchList.add(condList6);
    	PapillonLogger.writeDebugMsg("source: aabits, condition: poids > 0.7, rien d'autre...");
		 VolumeEntryDO[] MyResult = VolumeEntriesFactory.findEntry(searchList);
		 
//		 content.setTextNameDico(MyResult.getName());
//		 content.setTextLogin(MyResult.getLogin());
//		 content.setTextEmail(MyResult.getEmail());
//		 content.setTextGroup(MyResult.getGroups());
//		 content.setTextLangue(MyResult.getLang());
		 
	}
	
    
}
