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
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.2  2003/08/14 08:30:17  mangeot
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 *
 * for their work on the editor.
 * Important CVS commit
 * Attention, if you checkout this version, you must empty and
 * relaod all your database because the database schema has been modified a lot.
 * The entries must be relaoded, the users also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:22  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:16  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.5  2002/07/26 10:00:23  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.4.2.1  2002/07/12 13:50:44  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.4  2002/06/10 13:26:04  mangeot
 * Continued the localization, added the lang string into the session data
 *
 * Revision 1.3  2002/05/23 16:14:42  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.2  2002/01/25 17:26:38  serasset
 * *** empty log message ***
 *
 * Revision 1.1  2002/01/22 07:56:46  mangeot
 * *** empty log message ***
 *
 *-----------------------------------------------
 * Papillon Home page.
 */

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

public class Contacts extends BasePO {


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

        // Création du contenu
        ContactsContentHTML content =
            (ContactsContentHTML)MultilingualHtmlTemplateFactory.createTemplate("ContactsContentHTML", this.getComms(), this.getSessionData());
        contentNode = content.getElementContactsContent();

        //On rend le contenu correct
        return contentNode;
    }

}
