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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:14  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:12  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.4  2002/10/25 14:10:29  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.3.10.1  2002/10/23 09:51:06  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.3  2002/04/26 11:33:36  serasset
 * MailingList managment and interface polished. Insertion of a new feature to display
 * messages to the user from most business objects (PapillonUserLogger class).
 *
 * Revision 1.2  2001/07/11 09:16:52  serasset
 * Traitement de l'exception resultant d'un message malforme en UTF8.
 *
 * Revision 1.1  2001/07/09 16:37:29  serasset
 * Liens entre l'application enhydra et la base de donnees PostgreSQL.
 * Suppression du dossier data de la hierarchie CVS
 * Premiere version de la mailing list.
 *
 *-----------------------------------------------
 * 
 */


package fr.imag.clips.papillon.business;


import com.lutris.appserver.server.Enhydra;
import com.lutris.logging.*;

public class PapillonLogger {
 
    /**
     * Method to write a debugging message to the debug log
     * channel when the DEBUG flag is turned on
     * 
     * @param msg The message to write to the DEBUG log channel
     */
    public static void writeDebugMsg(String msg) {
        if (null != msg) {
            Enhydra.getLogChannel().write(Logger.DEBUG,msg);
        } else {
            Enhydra.getLogChannel().write(Logger.DEBUG,"null");
        }
    }

}