/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 * $Log$
 * Revision 1.1  2004/12/06 16:38:31  serasset
 * Initial revision
 *
 * Revision 1.2  2004/02/10 05:27:14  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.1.2.1  2004/01/08 15:18:36  mangeot
 * New object from database, do not forget to run the sql script create_tables.sql
 * To manage groups
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
 * The entries must be relaoded, the groups also
 * Merging between the stable branch and the development branch done by MM
 * and David Thevenin for their work on the editor.
 * It means a lot of improvements for this commit.
 * Furthermore, the internal structure of the database has been modified in order
 * to use index in separate db table when there is a query for an entry.
 *
 * Revision 1.5  2003/06/04 16:07:33  serasset
 * You don't have to know the password of the group you want to delete...
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
 * Work on RegisterGroup: fixed bugs and clarified !
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
 * I use sql statements to create a table for the groups
 * and to truncate or drop these tables.
 * I am now finally able to create dynamically a table for a new group
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
 * lecture des elements CDM ds les fichiers group-metadata
 * et upload des entrees
 *
 * Revision 1.1  2002/04/01 07:48:10  mangeot
 * Added these files to manage group metadata files
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
 * Renaming GroupFactory in DictionarEntriesFactory
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
public class GroupsFactory{

   public static Group findGroupByName(String name)
    throws PapillonBusinessException {
        Group theGroup = null;

        try {
            GroupQuery query = new GroupQuery();
            //set query
            query.setQueryName(name);
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            GroupDO theGroupDO = query.getNextDO();
            theGroup = new Group(theGroupDO);
        }catch(Exception ex) {
            throw new PapillonBusinessException("Exception in findGroupByName()", ex);
        }
        return theGroup;
    }

    public static Group findGroupByHandle(String handle)
    throws PapillonBusinessException {
        Group theGroup = null;

        try {
            GroupQuery query = new GroupQuery();
            //set query
            query.setQueryOId(new ObjectId(handle));
            // Throw an exception if more than one message is found
            query.requireUniqueInstance();
            GroupDO theGroupDO = query.getNextDO();
            theGroup = new Group(theGroupDO);
            return theGroup;
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new PapillonBusinessException("Exception in findGroupByHandle()", ex);
        }
    }

    public static GroupAnswer createUniqueGroup(String name,
                                              String password,
                                              String password2)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Group myGroup = null;
        String answerMessage = "";

        if (name==null || name.equals("")) {
            answerMessage = "Group name empty";
        }
        else if (password==null || password.equals("") &&
                 password2==null || password2.equals("")) {
            answerMessage = "Group password empty";
        }
        else if (!password.equals(password2)) {
            answerMessage = "Different passwords";
        }
        else {
            //search for an existing group
            Group Existe=GroupsFactory.findGroupByName(name);
            if (!Existe.IsEmpty()) {
                answerMessage = "Group " + name + " already in the database";
            }
            else {//doesn't exist, create:
				myGroup=new Group();
				myGroup.setName(name);
				myGroup.setPassword(password);
				myGroup.save();
				answerMessage =  "Group: "+ myGroup.getName() + " added";
            }
        }
        return new GroupAnswer(myGroup,answerMessage);
    }

    public static GroupAnswer changeGroupPassword(String name,
                                                String password,
                                                String newPassword,
                                                String newPassword2)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Group myGroup = null;
        String answerMessage = "";

        if (name==null || name.equals("")) {
            answerMessage = "Group name empty";
        }
        else if (password==null || password.equals("")) {
            answerMessage = "Group old password empty";
        }
        else if (newPassword==null || newPassword.equals("")) {
            answerMessage = "Group new password empty";
        }
        else if (!newPassword.equals(newPassword2)) {
            answerMessage = "Different new passwords";
        }
        else {
            //search for an existing group
            myGroup = GroupsFactory.findGroupByName(name);
            if (myGroup.IsEmpty()) {
                answerMessage = "Group " + name + " not in the database";
            }
            else {
                if (myGroup.HasCorrectPassword(password)) {
                    if (newPassword.equals(newPassword2)) {
                        myGroup.setPassword(newPassword);
                        myGroup.save();
                        answerMessage = "Password changed for group: "+ myGroup.getName();
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
        return new GroupAnswer(myGroup,answerMessage);
    }

	public static GroupAnswer deleteGroup(Group myGroup, String password)
	throws fr.imag.clips.papillon.business.PapillonBusinessException {
		String answerMessage = "";

		//search for an existing group
		if (myGroup.IsEmpty()) {
			answerMessage = "Group not in the database";
		}
		else {
			if (myGroup.HasCorrectPassword(password)) {
				answerMessage = "Group " + myGroup.getName() + " deleted";
				myGroup.delete();
			}
			else {
				answerMessage = "Wrong group password";
			}
		}
		return new GroupAnswer(myGroup,answerMessage);
		}

    public static GroupAnswer deleteGroup	(String name)
    throws fr.imag.clips.papillon.business.PapillonBusinessException {
        Group myGroup = null;
        String answerMessage = "";

        if (name==null || name.equals("")) {
            answerMessage = "Group name empty";
        } else {
            //search for an existing group
            myGroup = GroupsFactory.findGroupByName(name);
            if (null != myGroup && !myGroup.IsEmpty()) {
                myGroup.delete();
                answerMessage = "Group: "+ myGroup.getName() + " deleted";
            }
        }
        return new GroupAnswer(myGroup,answerMessage);
    }
         
    
    public static Group[] getGroupsArray(String name, String password) 
        throws PapillonBusinessException {
        Group[] theDictArray = null;
        
        try {
            GroupQuery query = new GroupQuery();
            
            if ((null != name) && (!name.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("name", name, 
                    QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
            if ((null != password) && (!password.trim().equals(""))) {
                query.getQueryBuilder().addWhereClause("password", password,
                                                       QueryBuilder.CASE_INSENSITIVE_CONTAINS);
            }
           query.addOrderByName(true);
          //         query.addOrderByLogin(true);  
            GroupDO[] DOarray = query.getDOArray();
            theDictArray = new Group[ DOarray.length ];
            for ( int i = 0; i < DOarray.length; i++ )
	    	theDictArray[i] = new Group(DOarray[i]);

        }catch(Exception ex) {
            throw new fr.imag.clips.papillon.business.PapillonBusinessException("Exception in getGroupsArray()", ex);
        }
         
        return theDictArray;
    }

}
