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
 * Revision 1.2  2003/08/14 08:30:10  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:15  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:12  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.2  2002/05/13 12:46:14  serasset
 * The mailing list presents only 20 mail headers in one page.
 *
 * Revision 1.1  2002/04/26 11:33:36  serasset
 * MailingList managment and interface polished. Insertion of a new feature to display
 * messages to the user from most business objects (PapillonUserLogger class).
 *
 */
package fr.imag.clips.papillon.business;
import fr.imag.clips.papillon.business.PapillonLogger;

public class PapillonUserLogger {
    
    protected final int INITIAL_LOG_SIZE = 1024;

    protected StringBuffer userLog = null;

    public PapillonUserLogger() {
        this.userLog = new StringBuffer(INITIAL_LOG_SIZE);
    }
    
    public String getUserLog() {
        String log = this.userLog.toString();
        this.flushUserLog();
        return log;
    }
    
    /**
     * Appends the given String to the Message that will be provided to the user
     * after the completion of the action.
     */
    public void writeUserLog(String msg) {
        if (null != msg) {
            this.userLog.append(msg);
            if (! msg.endsWith("\n")) {
                this.userLog.append('\n');
            }
            // Log all output to the debug log...
            PapillonLogger.writeDebugMsg(msg);
        }
    }
    
    public void flushUserLog() {
        this.userLog.setLength(0);
    } 
}
