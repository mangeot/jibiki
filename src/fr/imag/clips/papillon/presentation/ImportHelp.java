
package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
//import org.enhydra.xml.xmlc.XMLObject;
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.Node;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
//import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;

import fr.imag.clips.papillon.presentation.html.orig.*;

public class ImportHelp extends BasePO {


    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean adminUserRequired() {
        return false;
    }
    
    protected  int getCurrentSection() {
        return NO_SECTION;
    }
    

    public Node getContent()
    throws HttpPresentationException, IOException {

        Node contentNode;

        ImportHelpContentHTML content = (ImportHelpContentHTML)MultilingualHtmlTemplateFactory.createTemplate("ImportHelpContentHTML", this.getComms(), this.getSessionData());
        contentNode = content.getElementImportHelpContent();
        
        //On rend le contenu correct
        return contentNode;
    }
    
}
