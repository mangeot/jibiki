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
 * Revision 1.1  2004/12/06 16:38:32  serasset
 * Initial revision
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
 

public class UserAnswer {


    /**
         */
    protected User myUser = null;
    protected String myAnswer = "";

        /**
            * The public constructor.
         */
    public UserAnswer(User aUser, String anAnswer) {
        myUser = aUser;
        myAnswer = anAnswer;
    }

    public String getMessage() {
        return myAnswer;
    }
    public User getUser() {
        return myUser;
    }
    public boolean IsEmpty() {
        return (myUser == null || myUser.IsEmpty());
    }
}