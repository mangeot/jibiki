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
 * Revision 1.2  2003/08/14 08:30:13  mangeot
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:19  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.7  2002/06/03 10:08:02  serasset
 * Managing pages when viewing messages in the mailing list.
 *
 * Revision 1.6  2002/05/13 12:46:14  serasset
 * The mailing list presents only 20 mail headers in one page.
 *
 * Revision 1.5  2001/07/12 16:36:46  serasset
 * Ajout des fonctionalites de recherche dans la mailing list.
 *
 * Revision 1.4  2001/07/11 15:08:11  serasset
 * Ajout des tris par date, auteur, sujet dans la liste des messages.
 *
 * Revision 1.3  2001/07/09 16:37:30  serasset
 * Liens entre l'application enhydra et la base de donnees PostgreSQL.
 * Suppression du dossier data de la hierarchie CVS
 * Premiere version de la mailing list.
 *
 * Revision 1.2  2001/07/04 12:50:43  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.message;

import fr.imag.clips.papillon.business.PapillonBusinessException;

import fr.imag.clips.papillon.data.MessageDO;
import fr.imag.clips.papillon.data.MessageQuery;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.sql.ObjectId;
import com.lutris.appserver.server.sql.DBConnection;
import com.lutris.dods.builder.generator.query.QueryBuilder;
import com.lutris.appserver.server.Enhydra;
import com.lutris.appserver.server.sql.DBQuery;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.appserver.server.sql.DatabaseManagerException;

import java.sql.ResultSet;
/**
 * Used to find the instances of message.
 */
public class MessageFactory {
    public final static String SORT_BY_DATE = "date";
    public final static String SORT_BY_AUTHOR = "author";
    public final static String SORT_BY_SUBJECT = "subject";
    
    /** 
     * The getMessagesArray method performs a database query to
     * return an array of <CODE>Messages</CODE> objects
     * representing all the rows in the <CODE>message</CODE> table. 
     *
     * @return
     *     array of discs. 
     * @exception PapillonBusinessException
     *   If there is a problem retrieving disc information.
     */
    public static Message[] getMessagesArray(String authorcontains, 
                                             String subjectcontains, 
                                             String messagecontains, 
                                             String thread, 
                                             String sort,
                                             int offset,
                                             int limit) 
        throws PapillonBusinessException {
        Message[] theMessageArray = null;
        
        try {
            MessageQuery query = new MessageQuery();
            
            if ((null != thread) && ("" != thread.trim())) {
                query.setQueryThread(thread);
            } else {
                if ((null != authorcontains) && (!authorcontains.trim().equals(""))) {
                    query.getQueryBuilder().addWhereOpenParen();
                    query.getQueryBuilder().addWhereClause("author", authorcontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                    query.getQueryBuilder().addWhereOr();
                    query.getQueryBuilder().addWhereClause("authoraddress", authorcontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                    query.getQueryBuilder().addWhereCloseParen();
                }
                if ((null != subjectcontains) && (!subjectcontains.trim().equals(""))) {
                    query.getQueryBuilder().addWhereClause("subject", subjectcontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                }
                if ((null != messagecontains) && (!messagecontains.trim().equals(""))) {
                    query.getQueryBuilder().addWhereClause("msg", messagecontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                }
            }
            
            // Order 
            if ((null != sort) && (sort.equals(SORT_BY_DATE))) {
                query.addOrderByDate(false);  // Or true for ascending ?
            } else if ((null != sort) && (sort.equals(SORT_BY_AUTHOR))) {
                query.addOrderByAuthor();  // ascending, what about descending ?
            } else if ((null != sort) && (sort.equals(SORT_BY_SUBJECT))) {
                query.addOrderByThread();  // ascending, what about descending ?
            } else {
                query.addOrderByDate(false);  // Or true for ascending ?
            }
        
            QueryBuilder qb = query.getQueryBuilder();
            qb.addEndClause(" LIMIT " + limit + " OFFSET " + offset);
            
            //query.getQueryBuilder().debug();
            MessageDO[] DOarray = query.getDOArray();
            theMessageArray = new Message[ DOarray.length ];
            for ( int i = 0; i < DOarray.length; i++ )
	    	theMessageArray[i] = new Message(DOarray[i]);
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in getMessagesArray()", ex);
        }
        
        return theMessageArray;
    }
    
    
    /** 
     * The getMessagesCount method performs a database query to
     * return the number of <CODE>Messages</CODE> objects
     * representing all the rows matching criteria in the <CODE>message</CODE> table. 
     *
     * @return
     *     number of messages. 
     * @exception PapillonBusinessException
     *   If there is a problem retrieving information.
     */
    public static int getMessagesCount(String authorcontains, 
                                  String subjectcontains, 
                                  String messagecontains, 
                                  String thread, 
                                  String sort) 
        throws PapillonBusinessException {
        int nbmsg = 0;
        
        DBConnection c = null;
        try {
            // Preparing the Query :

            QueryBuilder qb = new QueryBuilder("messages", "count(objectid)");
            qb.setDatabaseVendor( "PostgreSQL" );
            qb.setStringMatchDetails( "LIKE", "%" );
//            qb.reset();
            
            if ((null != thread) && ("" != thread.trim())) {
                qb.addWhere( MessageDO.Thread, thread, QueryBuilder.EQUAL );
            } else {
                if ((null != authorcontains) && (!authorcontains.trim().equals(""))) {
                    
                    qb.addWhereOpenParen();
                    qb.addWhereClause("author", authorcontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                    qb.addWhereOr();
                    qb.addWhereClause("authoraddress", authorcontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                    qb.addWhereCloseParen();
                }
                if ((null != subjectcontains) && (!subjectcontains.trim().equals(""))) {
                    qb.addWhereClause("subject", subjectcontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                }
                if ((null != messagecontains) && (!messagecontains.trim().equals(""))) {
                    qb.addWhereClause("msg", messagecontains, 
                        QueryBuilder.CASE_INSENSITIVE_CONTAINS);
                }
            }
                        
            //qb.debug();
            
            c = Enhydra.getDatabaseManager().allocateConnection();
            ResultSet rs = qb.executeQuery(c);
            if (rs.next()) {
                nbmsg = rs.getInt("count");
            }
            c.reset();
        } catch (Exception e) {
            throw new PapillonBusinessException( "Database connection Error", e );
        } finally {
            if ( null != c )
                c.release();
        }

        return nbmsg;
    }


    /** 
     * The findMessageByID method performs a database query to
     * return a <CODE>Message</CODE> object
     * representing the row in the <CODE>message</CODE> table
     * that matches the object id. 
     *
     * @param id, the object id of the message table.
     * @return
     *    the message. null if there isn't a message associated
     *    to the id
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static Message findMessageByID(String id) 
        throws PapillonBusinessException {
        Message theMessage = null;
        
        try {
            MessageQuery query = new MessageQuery();
            //set query
            query.setQueryOId(new ObjectId(id));
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            MessageDO theMessageDO = query.getNextDO();
            theMessage = new Message(theMessageDO);
            return theMessage;
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findMessageByID()", ex);
        }
    }
    
    /** 
     * The numberOfMessageWithThread method performs a database query to
     * return a <CODE>int</CODE>
     * representing the number of <CODE>message</CODE>
     * that matches the thread. 
     *
     * @param thread, the thread.
     * @return
     *    the number of messages
     * @exception PapillonBusinessException
     *    if there is a problem retrieving message.
     */
    public static int numberOfMessagesWithThread(String thread) 
        throws PapillonBusinessException {
        int result = 0;
        try {
            QueryBuilder qb;
            DBConnection conn = Enhydra.getDatabaseManager().allocateConnection();
            qb = new QueryBuilder( "messages", "count(Date)" );
            qb.addWhereClause( "Thread", thread, QueryBuilder.CASE_INSENSITIVE_EQUAL);
            //qb.debug();
            java.sql.ResultSet rs = qb.executeQuery(conn);
            if (rs.next()) result= rs.getInt(1);
            conn.release();
            return result;
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findMessageByID()", ex);
        }
    }

     
}

