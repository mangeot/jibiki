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
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.3  2003/09/03 10:15:45  mangeot
 * reorganizing imports and using eclipse
 *
 * Revision 1.2  2003/08/14 08:30:12  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:17  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:14  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.1  2001/10/29 13:32:18  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.informationfile;
import java.util.Hashtable;

// Enhydra SuperServlet imports

public class RelativeURLMapper {
    protected Hashtable myTable = null;
    
    /**
     * The public constructor.
     */
    public RelativeURLMapper() {
            this.myTable = new Hashtable();  
    }

    /**
     * Gets the file id for the relative URL
     *
     * @return the file id.
     */
	  
    public String getFileIDForURL(String url) {
        return (String)this.myTable.get(url);
    }

    /**
     * Sets the file id for the relative URL
     *
     */
	  
    public void setFileIDForURL(String url, String fileId) {
        try {
            this.myTable.put(url, fileId);
        } catch (NullPointerException e) {
            // nothing.
        }
    }


}
