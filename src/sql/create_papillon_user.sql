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
 * Revision 1.4  2002/10/25 14:10:37  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.3.10.1  2002/10/23 09:51:13  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.3  2002/05/09 08:06:57  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the volumes
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new volume
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.1  2001/11/20 15:12:51  serasset
 * Deplacement des fichiers de conf et des script sql dans des dossiers autonomes.
 * Mise en place des configurations pour lancement de l'application via le multiserver.
 * Separation de la partie statique (generee par un make) et de la partie dynamique (creee au cours
 * de l'utilisation de l'application, lors d'un upload par exemple). Maintenant dans 2 dossiers
 * differents. Modification des parametre pour que ces 2 dossiers soient accessibles a l'application.
 *
 * Revision 1.1  2001/07/10 11:53:03  serasset
 * Ajout des scripts SL de maintenance de la base PostgreSGL.
 * 
 * -------------------------------------------------------------
 * This SQL creates the user papillon.
 */

CREATE USER papillon WITH PASSWORD 'dbpap' CREATEDB CREATEUSER;
