/* 
 * Papillon 2001
 * © Mathieu Mangeot & Gilles Sérasset, GETA CLIPS IMAG
 * -------------------------------------------------------------
 * $Id$
 * -------------------------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:54  serasset
 * Initial revision
 *
 * Revision 1.2  2003/08/14 08:30:22  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:24  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:21  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.6  2002/10/25 14:10:37  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.5.10.1  2002/10/23 09:51:13  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.5  2002/05/09 08:24:18  mangeot
 * Deleted the entries for dynamically created tables
 * This script is no longer useful because now it is directly the user papillon
 * who creates the tables
 *
 * Revision 1.4  2002/04/01 07:46:34  mangeot
 * Added a table for volumes metadata descriptions
 *
 * Revision 1.3  2002/03/25 09:50:41  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/02/14 04:20:57  mangeot
 *
 * Added allow commands for new added tables in papillon.doml
 *
 * Revision 1.1  2001/11/20 15:12:51  serasset
 * Deplacement des fichiers de conf et des script sql dans des dossiers autonomes.
 * Mise en place des configurations pour lancement de l'application via le multiserver.
 * Separation de la partie statique (generee par un make) et de la partie dynamique (creee au cours
 * de l'utilisation de l'application, lors d'un upload par exemple). Maintenant dans 2 dossiers
 * differents. Modification des parametre pour que ces 2 dossiers soient accessibles a l'application.
 *
 * Revision 1.8  2001/10/29 13:34:07  serasset
 * Information section is now managed with Documents containing files. We now allow the addition of tar.gz files
 * containing several html files. images are still not supported.
 *
 * Revision 1.7  2001/09/07 06:58:33  serasset
 * Rights on the GROUPS suppressed as they are used only on bushido.
 *
 * Revision 1.6  2001/08/14 14:05:49  salvati
 * *** empty log message ***
 *
 * Revision 1.5  2001/08/07 13:11:47  salvati
 * Adding ant.jar for untar tools.
 *
 * Revision 1.4  2001/07/11 15:30:25  serasset
 * Suppression des tables author et threads. Utilisation d'une table unique "messages".
 *
 * Revision 1.3  2001/07/11 12:46:05  serasset
 * *** empty log message ***
 *
 * Revision 1.2  2001/07/10 12:19:31  serasset
 * Ajout des droits sur la table objectid.
 *
 * Revision 1.1  2001/07/10 11:53:03  serasset
 * Ajout des scripts SL de maintenance de la base PostgreSGL.
 * 
 * -------------------------------------------------------------
 * This SQL creates the user papillon.
 */

GRANT ALL ON messages TO papillon;
GRANT ALL ON objectid TO papillon;
GRANT ALL ON xslsheets TO papillon;
GRANT ALL ON informationfiles TO papillon;
GRANT ALL ON informationdocument TO papillon;
GRANT ALL ON users TO papillon;
GRANT ALL ON history TO papillon;
GRANT ALL ON dictionaries TO papillon;
GRANT ALL ON volumes TO papillon;

GRANT ALL ON papillonaxi TO papillon;
