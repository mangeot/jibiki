/*
 *  papillon
 *
 *  Enhydra super-servlet presentation object
 * 
 * © Mathieu Mangeot - GETA CLIPS IMAG
 * Projet Papillon
 *-----------------------------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.2  2004/02/10 05:27:13  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.1.2.1  2004/01/08 15:18:36  mangeot
 * New object from database, do not forget to run the sql script create_tables.sql
 * To manage groups
 *
 * Revision 1.1  2002/11/26 06:38:47  mangeot
 * Work on RegisterUser: fixed bugs and clarified !
 *
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.user;

/* FIXME: this class is a convenient class. It is used only to return a user and
a message to the RegisterUser.java class. If the createNewUser does not work,
a message explains it.

We should find a generic system for all the answers and multilingual !
*/
 

public class GroupAnswer {


    /**
         */
    protected Group myGroup = null;
    protected String myAnswer = "";

        /**
            * The public constructor.
         */
    public GroupAnswer(Group aGroup, String anAnswer) {
        myGroup = aGroup;
        myAnswer = anAnswer;
    }

    public String getMessage() {
        return myAnswer;
    }
    public Group getGroup() {
        return myGroup;
    }
    public boolean IsEmpty() {
        return (myGroup == null || myGroup.IsEmpty());
    }
}