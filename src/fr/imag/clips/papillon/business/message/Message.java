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
 * Revision 1.3  2004/01/21 11:47:22  serasset
 * Merged Trunk with PAPILLON_DEBUG_FOR_JDK14
 *
 * Revision 1.2.4.1  2004/01/06 14:55:50  serasset
 * Suppressed late reencoding of large text data incorrectly read by DODS.
 * These text fields are now correctly encoded by the patched enhydra 5.0.
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
 * Revision 1.1.1.1.2.1  2003/05/28 09:17:18  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.6  2002/10/25 14:10:31  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.5.10.1  2002/10/23 09:51:08  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.5  2002/04/26 11:33:36  serasset
 * MailingList managment and interface polished. Insertion of a new feature to display
 * messages to the user from most business objects (PapillonUserLogger class).
 *
 * Revision 1.4  2001/07/11 15:30:25  serasset
 * Suppression des tables author et threads. Utilisation d'une table unique "messages".
 *
 * Revision 1.3  2001/07/09 16:37:29  serasset
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

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

/**
 * Represents a Mailing list message. 
 */
public class Message {
    /**
     * The DO of the message.
     */
    protected MessageDO myDO = null;

    /**
     * The public constructor.
     */
    public Message() throws PapillonBusinessException {
        try {
            this.myDO = MessageDO.createVirgin();  
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error creating empty Message", ex);
        } catch(ObjectIdException ex) {
            throw new PapillonBusinessException("Error creating empty Message", ex);
        }
    }

    /** The protected constructor
     *
     * @param theDisc. The data object of the message.
     */
    protected Message(MessageDO theMessage) 
        throws PapillonBusinessException  {
        this.myDO = theMessage;
    }

    /**
     * Gets the object id for the message
     *
     * @return the object id.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getHandle()
        throws PapillonBusinessException {
        try {
            return this.myDO.getHandle();
        } catch(DatabaseManagerException ex) {
            throw new PapillonBusinessException("Error getting messages's handle", ex);
        }
    }

    /**
     * Gets the subject of the message
     *
     * @return the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getSubject() 
        throws PapillonBusinessException {
        try {
            return myDO.getSubject();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting message's subject", ex);
        }
    }
    
    /**
     * Gets the msgid for the message
     *
     * @return the msgid.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getMsgid()
        throws PapillonBusinessException {
        try {
            return myDO.getMsgid();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting message's Msgid", ex);
        }
    }
    
    /**
     * Gets the body for the message
     *
     * @return the body.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getMsg()
        throws PapillonBusinessException {
        try {
            //byte [] buf = this.myDO.getMsg().getBytes();
            //return new String(buf, "UTF-8");
	    return this.myDO.getMsg();
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting message's body", ex);
        } //catch(java.io.UnsupportedEncodingException ex) {
          //  throw new PapillonBusinessException("Error getting Dictionary XmlCode", ex);
        //}
    }

    /**
     * Gets the date for the message
     *
     * @return the Date.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public java.sql.Date getDate()
        throws PapillonBusinessException {
        try {
            return myDO.getDate();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting message's date", ex);
        }
    }
    
    /**
     * Gets the author of the message
     *
     * @return the Author.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getAuthor()
        throws PapillonBusinessException {
        try {            
            return myDO.getAuthor();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting message's author", ex);
        }
    }

    /**
     * Gets the author address of the message
     *
     * @return the Author.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getAuthorAddress()
        throws PapillonBusinessException {
        try {            
            return myDO.getAuthorAddress();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting message's author", ex);
        }
    }
    
    /**
     * Gets the thread of the message
     *
     * @return the Thread.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public String getThread()
        throws PapillonBusinessException {
        try {            
            return myDO.getThread();   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error getting message's thread", ex);
        }
    }

    // Setting the values
    /**
     * Set the subject of the message
     *
     * @param the subject.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void setSubject(String subject) 
        throws PapillonBusinessException {
        try {
            myDO.setSubject(subject);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting message's subject", ex);
        }
    }
    
    /**
     * Sets the msgid for the message
     *
     * @param the msgid.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void setMsgid(String msgid)
        throws PapillonBusinessException {
        try {
            myDO.setMsgid(msgid);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting message's Msgid", ex);
        }
    }
    
    /**
     * Sets the body for the message
     *
     * @param the body.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void setMsg(String body)
        throws PapillonBusinessException {
        try {
             myDO.setMsg(body);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting message's body", ex);
        }
    }

    /**
     * Gets the date for the message
     *
     * @param the Date.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void setDate(java.sql.Date date)
        throws PapillonBusinessException {
        try {
             myDO.setDate(date);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting message's date", ex);
        }
    }
    
    /**
     * Gets the author for the message
     *
     * @param the author.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void setAuthor(String author)
        throws PapillonBusinessException {
        try {
             myDO.setAuthor(author);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting message's author", ex);
        }
    }
    
     /**
     * Sets the author address for the message
     *
     * @param the author address.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void setAuthorAddress(String address)
        throws PapillonBusinessException {
        try {
             myDO.setAuthorAddress(address);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting message's author", ex);
        }
    }
    
   
   /**
     * Gets the thread for the message
     *
     * @param the thread.
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void setThread(String thread)
        throws PapillonBusinessException {
        try {
             myDO.setThread(thread);   
        } catch(DataObjectException ex) {
            throw new PapillonBusinessException("Error setting message's thread", ex);
        }
    }


    /**
     * Commits all changes to the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   retrieving data (usually due to an underlying data layer
     *   error).
     */
    public void save() 
        throws PapillonBusinessException {
        try {
            this.myDO.commit();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error saving message", ex);
        }
    }
    
    /**
     * Deletes the message from the database.
     *
     * @exception PapillonBusinessException if an error occurs
     *   deleting data (usually due to an underlying data layer
     *   error).
     */
    public void delete() 
        throws PapillonBusinessException {
        try {
            this.myDO.delete();
        } catch(Exception ex) {
            throw new PapillonBusinessException("Error deleting message", ex);
        }
    }
}
