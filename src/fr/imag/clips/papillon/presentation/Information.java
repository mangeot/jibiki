/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
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
 * Revision 1.1  2003/08/21 09:12:02  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/08/14 08:30:18  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:23  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.6  2002/07/26 10:00:27  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.5.6.1  2002/07/12 13:50:47  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.5  2002/05/23 16:14:42  mangeot
 * Adding admin group for presentation pages
 *
 * Revision 1.4  2001/07/31 08:36:38  serasset
 * enommage des fichiers HTML pour eviter un eventuel ecrasement par xmlc.
 *
 * Revision 1.3  2001/07/05 15:53:09  salvati
 * integration d un mot et changement de HTMLElement en Node
 *
 * Revision 1.2  2001/07/04 12:50:50  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 */

package fr.imag.clips.papillon.presentation;

// Enhydra SuperServlet imports
import com.lutris.appserver.server.httpPresentation.HttpPresentation;
import com.lutris.appserver.server.httpPresentation.HttpPresentationComms;
import com.lutris.appserver.server.httpPresentation.HttpPresentationException;
import com.lutris.appserver.server.httpPresentation.HttpPresentationOutputStream;
import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

// w3c imports
import org.w3c.dom.html.HTMLElement;
import org.w3c.dom.Node;
// Standard imports
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;

import fr.imag.clips.papillon.presentation.html.orig.*;

import fr.imag.clips.papillon.presentation.MultilingualHtmlTemplateFactory;

public class Information extends BasePO {

    public Node getContent()
        throws HttpPresentationException, IOException {

	InformationTmplHTML content;

	// Création du contenu
	//content = (InfosTmplHTML)this.getComms().xmlcFactory.create(InfosTmplHTML.class);
        content = (InformationTmplHTML)MultilingualHtmlTemplateFactory.createTemplate("InformationTmplHTML", this.getComms(), this.getSessionData());
      
        return content.getElementInfoContent();
        }

    protected boolean loggedInUserRequired() {
        return false;
    }

    protected boolean adminUserRequired() {
        return false;
    }
    
    protected  int getCurrentSection() {
        return INFORMATIONS_SECTION;
    }


}
