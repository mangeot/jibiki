/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:32  serasset
 * Initial revision
 *
 * Revision 1.11  2004/10/30 10:16:11  mangeot
 * Fixed a bug when creating a new user, need to create the xmlCode anyway
 *
 * Revision 1.10  2004/10/28 10:35:01  mangeot
 * Some changes:
 * the User.java implements an enhydra interface in order to register users into enhydra sessions
 * the AdminUsers.java displays currently logged users
 *
 * Revision 1.9  2004/03/26 07:53:26  mangeot
 * *** empty log message ***
 *
 * Revision 1.8  2004/02/10 05:27:14  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.7.2.2  2004/01/21 07:50:29  mangeot
 * Added confirm javascript for delete button
 *
 * Revision 1.7.2.1  2004/01/08 15:17:20  mangeot
 * Bugs fixed
 *
 * Revision 1.7  2003/08/19 08:06:43  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2003/08/14 08:30:13  mangeot
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
 * Revision 1.5  2003/06/04 16:07:33  serasset
 * You don't have to know the password of the user you want to delete...
 *
 * Revision 1.4  2003/06/04 15:38:30  serasset
 * Mise en place du chinois et de la nouvelle version du login/register
 *
 * Revision 1.3.2.3  2003/08/11 10:24:51  mangeot
 * Debugging ...
 *
 * Revision 1.3.2.2  2003/06/21 17:56:38  mangeot
 * *** empty log message ***
 *
 * Revision 1.3.2.1  2003/05/28 09:17:20  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.3  2002/12/09 08:32:01  mangeot
 * Added a permanent cookie for indentification when reconnection
 *
 * Revision 1.2  2002/11/26 06:38:47  mangeot
 * Work on RegisterUser: fixed bugs and clarified !
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.3  2002/10/25 14:10:32  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.2.2.1  2002/10/09 06:18:06  mangeot
 * password encoding for protection
 *
 * Revision 1.2  2002/09/11 16:28:13  mangeot
 * Added classes to implement dict protocol rfc 2229
 *
 * Revision 1.1  2002/05/22 08:59:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.11  2002/05/10 16:43:18  mangeot
 * Integration of HTML code from remote dictionary servers on the Web
 * iUse of HTMLTidy, conversion problem remaining ...
 *
 * Revision 1.10  2002/05/09 07:43:42  mangeot
 * Work on the data layer.
 * I am now able to send directly sql statements.
 * I use sql statements to create a table for the users
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new user
 * I also added 2 scripts for dump/restore of the database in sql/ directory
 *
 * Revision 1.9  2002/04/18 11:42:34  mangeot
 * Fait l'affichage des donnees XML metadata + stylesheets
 * Ameliore les stylesheets
 * corrige le bug du parsage du FeM
 *
 * Revision 1.8  2002/04/17 20:44:01  mangeot
 * Now I load a XSL stylesheet from an URI instead of a file.
 * I load automatically XSL sheets included in dicts and vols metadata files
 *
 * Revision 1.7  2002/04/17 19:18:22  mangeot
 * I deleted the form AdminXml.po and created another one:
 * AddEntries.po
 * Now you can't add entries without a metadata file associated.
 *
 * Revision 1.6  2002/04/17 17:09:23  mangeot
 * Travail sur les stylesheets
 *
 * Revision 1.5  2002/04/16 10:17:24  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2002/04/16 02:44:03  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2002/04/15 13:16:33  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2002/04/14 09:47:12  mangeot
 * lecture des elements CDM ds les fichiers user-metadata
 * et upload des entrees
 *
 * Revision 1.1  2002/04/01 07:48:10  mangeot
 * Added these files to manage user metadata files
 *
 * Revision 1.2  2002/03/27 09:51:28  mangeot
 * *** empty log message ***
 *
 * Revision 1.1  2002/03/11 11:15:48  mangeot
 * *** empty log message ***
 *
 * Revision 1.6  2001/10/17 13:02:03  serasset
 * Distinction entre Doucmuent (abstrait) et fichier (qui constituent concretement un doucument)
 *
 * Revision 1.5  2001/07/19 17:07:44  salvati
 * Change the driver of database and adding namespace:too small place in db
 *
 * Revision 1.4  2001/07/18 12:35:31  serasset
 * Version demontree pendant les journees papillon 2001. Integration de la partie XML/XSL dans la BD.
 *
 * Revision 1.3  2001/07/12 20:38:45  salvati
 * Added Node2String function and use of it
 *
 * Revision 1.2  2001/07/12 17:58:00  salvati
 * end of debug
 * CV: ----------------------------------------------------------------------
 *
 * Revision 1.1  2001/07/12 17:38:08  salvati
 * Renaming UserFactory in DictionarEntriesFactory
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.user;

import fr.imag.clips.papillon.data.*;

//for URLs
import java.net.*;

import com.lutris.dods.builder.generator.dataobject.GenericDO;
import com.lutris.dods.builder.generator.query.QueryBuilder;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.PapillonLogger;

import com.lutris.appserver.server.*;
import com.lutris.appserver.server.sql.ObjectId;

import java.util.*;

import fr.imag.clips.papillon.business.utility.*;

/**
 * Used to find the instances of xslsheet.
 */
public class UsersFactory{

   public static User findUserByName(String name)
    throws PapillonBusinessException {
        User theUser = null;

        try {
            UserQuery query = new UserQuery();
            //set query
            query.setQueryName(name);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            UserDO theUserDO = query.getNextDO();
            theUser = new User(theUserDO);
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findVolumeByName()", ex);
        }
        return theUser;
    }

    public static User findUserByLogin(String login)
    throws PapillonBusinessException {
        User theUser = null;

        try {
            UserQuery query = new UserQuery();
            //set query
            query.setQueryLogin(login);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            UserDO theUserDO = query.getNextDO();
            theUser = new User(theUserDO);
            return theUser;
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new PapillonBusinessException("Exception in findUserByLogin()", ex);
        }
    }

    public static UserAnswer createUniqueUser(String name,
                                              String login,
                                              String password,
                                              String password2,
                                              String email,
											  String lang)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        User myUser = null;
        String answerMessage = "";

        if (name==null || name.equals("")) {
            answerMessage = "User name empty";
        }
        else if (login==null || login.equals("")) {
            answerMessage = "User login empty";
        }
        else if (password==null || password.equals("") &&
                 password2==null || password2.equals("")) {
            answerMessage = "User password empty";
        }
        else if (!password.equals(password2)) {
            answerMessage = "Different passwords";
        }
        else if (email==null || email.equals("")) {
            answerMessage = "User email empty";
        }
        else {
            //search for an existing user
            User Existe=UsersFactory.findUserByName(name);
            if (!Existe.IsEmpty()) {
                answerMessage = "User " + name + " already in the database";
            }
            else {
                Existe=UsersFactory.findUserByLogin(login);
                if (!Existe.IsEmpty()) {
                    answerMessage = "Login " + login + " already in the database";
                }
                else {//doesn't exist, create:
                    myUser=new User();
                    myUser.setName(name);
                    myUser.setLogin(login);
                    myUser.setPassword(password);
                    myUser.setEmail(email);
                    myUser.setLang(lang);
                    myUser.setXmlCode(myUser.serializeXml());
                    myUser.save();
                    answerMessage =  "User: "+ myUser.getName() + " // login: " + myUser.getLogin() + " added";
                }
            }
        }
        return new UserAnswer(myUser,answerMessage);
    }

    public static UserAnswer changeUserPassword(String login,
                                                String password,
                                                String newPassword,
                                                String newPassword2)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        User myUser = null;
        String answerMessage = "";

        if (login==null || login.equals("")) {
            answerMessage = "User login empty";
        }
        else if (password==null || password.equals("")) {
            answerMessage = "User old password empty";
        }
        else if (newPassword==null || newPassword.equals("")) {
            answerMessage = "User new password empty";
        }
        else if (!newPassword.equals(newPassword2)) {
            answerMessage = "Different new passwords";
        }
        else {
            //search for an existing user
            myUser = UsersFactory.findUserByLogin(login);
            if (myUser.IsEmpty()) {
                answerMessage = "Login " + login + " not in the database";
            }
            else {
                if (myUser.HasCorrectPassword(password)) {
                    if (newPassword.equals(newPassword2)) {
                        myUser.setPassword(newPassword);
                        myUser.save();
                        answerMessage = "Password changed for user: "+ myUser.getName() + " // login: " + myUser.getLogin();
                    }
                    else {
                        answerMessage = "Wrong new password";
                    }

                }
                else {
                    answerMessage = "Wrong old password";
                }
            }
        }
        return new UserAnswer(myUser,answerMessage);
    }

    public static UserAnswer addUserInGroup(User myUser,
                                            String group,
                                            String groupPassword)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        String answerMessage = "";

        if (myUser==null || myUser.IsEmpty()) {
            answerMessage = "Non existing user";
        }
        else if (group==null || group.equals("")) {
            answerMessage = "Group empty";
        }
        else if (groupPassword==null || groupPassword.equals("")) {
            answerMessage = "Group password empty";
        }
        else {
            //search for an existing user
			String refGroupPassword = myUser.getGroupPassword(group);
			if (refGroupPassword!=null && !refGroupPassword.equals("")) {
					if (groupPassword.equals(refGroupPassword)) {
						myUser.addGroup(group);
						myUser.save();
						answerMessage = "User "+ myUser.getName() + " is in group " + group;
					}
					else {
						answerMessage = "Wrong group password";
					}
			}
			else {
				answerMessage = "Group " + group + " does not exist!";
			}
        }
        return new UserAnswer(myUser,answerMessage);
    }

	public static UserAnswer deleteUser(User myUser, String password)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		String answerMessage = "";

		//search for an existing user
		if (myUser == null || myUser.IsEmpty()) {
			answerMessage = "User not in the database";
		}
		else {
			if (myUser.HasCorrectPassword(password)) {
				answerMessage = "User " + myUser.getName() + " deleted";
				myUser.delete();
			}
			else {
				answerMessage = "Wrong user password";
			}
		}
		return new UserAnswer(myUser,answerMessage);
		}
   
//ajouter pour la page profil

 public static UserAnswer ChangeNameAndEmail(User myUser,
                                             String name, String email)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        String answerMessage = "";

        if (email==null || email.equals("")) {
					answerMessage = "Current email empty";
        }
        else if (name==null || name.equals("")) {
					answerMessage = "Current name empty";
        }
        else {
            //search for an existing user
            if (myUser.IsEmpty()) {
                answerMessage = "User not in the database";
            }
            else {
							myUser.setName(name);
							myUser.setEmail(email);
							myUser.save();
							answerMessage = "Email changed for user: "+ myUser.getName() + " // login: " + myUser.getLogin();
						}
        }
        
        return new UserAnswer(myUser,answerMessage);
    }



//fini 
   
    
     
    public static User findUserById(String id) 
        throws PapillonBusinessException {
        User theUser = null;
        UserDO theUserDO = null;
        
        try {
           UserQuery query = new UserQuery();  
             //set query
            query.setQueryOId(new ObjectId(id));
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            theUserDO = query.getNextDO();
        theUser = new User(theUserDO);
        return theUser;
        
        }
        catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in findUserById()", ex);
        }
    }
	
	public static User[] getUsersArray(String sortBy) 
		throws PapillonBusinessException {
		return getUsersArray("","","","",sortBy);
	}
    
    protected static User[] getUsersArray(String name, String login, String password, String email, String sortBy) 
        throws PapillonBusinessException {
        User[] theDictArray = null;
        
        try {
            UserQuery query = new UserQuery();
            
            if ((null != name) && (!name.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("name", name, 
                    QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
            if ((null != login) && (!login.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("login", login, 
                    QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
            if ((null != password) && (!password.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("password", password,
                                                       QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
            if ((null != email) && (!email.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("email", email,
                                                       QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
			if (sortBy!=null && !sortBy.equals("")) {
				if (sortBy.equals("name")) {
					query.addOrderByName(true);
				}
				else if (sortBy.equals("login")) {
					query.addOrderByLogin(true);
				}
				else if (sortBy.equals("email")) {
					query.addOrderByEmail(true);
				}
			}
            UserDO[] DOarray = query.getDOArray();
            theDictArray = new User[ DOarray.length ];
            for ( int i = 0; i < DOarray.length; i++ )
	    	theDictArray[i] = new User(DOarray[i]);

        }catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in getUsersArray()", ex);
        }
         
        return theDictArray;
    }
	
	// for managing user prefs
	
	

}
