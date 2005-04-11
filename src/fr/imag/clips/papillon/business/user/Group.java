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
 * Revision 1.3  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.2.2.1  2005/03/29 09:41:33  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:31  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.2  2004/02/10 05:27:13  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.1.2.2  2004/01/09 05:18:57  mangeot
 * Bugs fixes !
 *
 * Revision 1.1.2.1  2004/01/08 15:18:35  mangeot
 * New object from database, do not forget to run the sql script create_tables.sql
 * To manage groups
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.user;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.CurrentDBTransaction;

/* for password encryption */
import java.io.*;
import java.security.*;
import java.util.*;
import java.lang.*;



/* for the ADMIN password in config file */
import com.lutris.util.Config;
import com.lutris.appserver.server.Enhydra;
import com.lutris.util.ConfigException;

import com.lutris.appserver.server.sql.DatabaseManagerException;
import com.lutris.appserver.server.sql.ObjectIdException;
import com.lutris.dods.builder.generator.query.DataObjectException;

public class Group {
	
    public final static String ADMIN_GROUP = "admin";
    public final static String SPECIALIST_GROUP = "specialist";
    protected final static String PASSWORD_STRING = "Papillon.Groups.Groups.Password";
    protected final static String PASSWORD_ENCODING = "US-ASCII";
    protected final static String USERS_SEPARATOR_STRING = "#";
    protected final static int PASSWORD_DIGEST_LENGTH = 30;
	
	
    /**
		* The DO of the Volume.
	 */
	protected GroupDO myDO = null;
	
	/**
		* The public constructor.
	 */
	public Group() throws PapillonBusinessException {
		try {
			this.myDO = GroupDO.createVirgin(CurrentDBTransaction.get());
		} catch(DatabaseManagerException ex) {
			throw new PapillonBusinessException("Error creating empty group", ex);
		} catch(ObjectIdException ex) {
			throw new PapillonBusinessException("Error creating empty group", ex);
		}
	}
	
	/** The protected constructor
		*
		* @param theDisc. The data object of the Volume.
		*/
	protected Group(GroupDO theGroup)
		throws PapillonBusinessException  {
			this.myDO = theGroup;
		}
	
	public boolean IsEmpty() {
		return (this.myDO==null) ;
	}
	
	
	/**
		* Gets the object id for the Volume
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
				throw new PapillonBusinessException("Error getting group's handle", ex);
			}
		}
	
	/**
		* Gets the name of the Volume
	 *
	 * @return the name.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String getName()
		throws PapillonBusinessException {
			try {
				return myDO.getName();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting Volume's name", ex);
			}
		}
	public void setName(String name)
		throws PapillonBusinessException {
			try {
				myDO.setName(name);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting Volume's name", ex);
			}
		}
	
	/**
		* Gets the password of the group
	 *
	 * @return the password.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public byte[] getPassword()
		throws PapillonBusinessException {
			try {
				return myDO.getPassword();
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting groups's password", ex);
			}
		}
	public void setPassword(String password)
		throws PapillonBusinessException {
			try {
				byte[] myDigest = makeDigest(this.getName(), password);
				myDO.setPassword(myDigest);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting group's password", ex);
			}
		}
	
	
	/**
		* Gets the users of the group
	 *
	 * @return the groups.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String[] getUsersArray()
		throws PapillonBusinessException {
			String[] Users = null;
			String users = getUsers();
			if (null != users && !users.equals("")){
				Users = users.split(USERS_SEPARATOR_STRING);
			}
			return Users;
		}
	
	public String getUsers()
		throws PapillonBusinessException {
			try {
				return myDO.getUsers();
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting group's users", ex);
			}
		}
	protected void setUsers(String users)
		throws PapillonBusinessException {
			try {
                myDO.setUsers(users);
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting group's users", ex);
			}
		}
	public void setUsersArray(String[] Users)
		throws PapillonBusinessException {
			String users = null;
			if (null != users && Users.length >0) {
				for (int i=0; i< Users.length; i++) {
					users += USERS_SEPARATOR_STRING + Users[i];
				}
			}
			users.trim();
			setUsers(users);
		}
	protected void addNewUser(String user)
		throws PapillonBusinessException {
			String users = getUsers();
			users += USERS_SEPARATOR_STRING + user;
			users.trim();
			setUsers(users);
		}
	
	public void addUser(String user)
		throws PapillonBusinessException {
			if (!IsInGroup(user)) {
				addNewUser(user);
			}
		}
				
				public void removeUser(String user)
		throws PapillonBusinessException {
			if (IsInGroup(user)) {
				String[] users = getAdminsArray();
				String newUsers = "";
				for (int i=0;i< users.length;i++) {
					String tempUser = users[i];
					if (!tempUser.equals(user)) {
						newUsers += USERS_SEPARATOR_STRING + tempUser;
					}
				}
				setUsers(newUsers);
			}
		}
	
	
	
	public boolean IsInGroup(String user)
		throws PapillonBusinessException {
            String[] Users = getUsersArray();
            boolean is = false;
            if (null != Users && Users.length > 0) {
				int i =0;
                while (!is && i<Users.length) {
                    is = user.equals(Users[i]);
					i++;
                }
            }
            return is;
        }
	
	/**
		* Gets the admins of the group
	 *
	 * @return the groups.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String[] getAdminsArray()
		throws PapillonBusinessException {
			String[] Users = null;
			String users = getAdmins();
			if (null != users && !users.equals("")){
				// delete the first separator in order to avoid an empty user
				if (users.indexOf(USERS_SEPARATOR_STRING) ==0) {
					users = users.substring(USERS_SEPARATOR_STRING.length());
				}
				Users = users.split(USERS_SEPARATOR_STRING);
			}
			return Users;
		}
	
	protected String getAdmins()
		throws PapillonBusinessException {
			try {
				return myDO.getAdmins();
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting group's admins", ex);
			}
		}
	protected void setAdmins(String users)
		throws PapillonBusinessException {
			try {
                myDO.setAdmins(users);
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting group's admins", ex);
			}
		}
	public void setAdminsArray(String[] Users)
		throws PapillonBusinessException {
			String users = null;
			if (null != users && Users.length >0) {
				for (int i=0; i< Users.length; i++) {
					users += USERS_SEPARATOR_STRING + Users[i];
				}
			}
			users.trim();
			setAdmins(users);
		}
	
	protected void addNewAdmin(String user)
		throws PapillonBusinessException {
			String users = getAdmins();
			users += USERS_SEPARATOR_STRING + user;
			users.trim();
			setAdmins(users);
		}
	
	public void addAdmin(String user)
		throws PapillonBusinessException {
			if (!IsAdmin(user)) {
				addNewAdmin(user);
			}
		}
	
				public void removeAdmin(String user)
		throws PapillonBusinessException {
			if (IsAdmin(user)) {
				String[] users = getAdminsArray();
				String newUsers = "";
				for (int i=0;i< users.length;i++) {
					String tempUser = users[i];
					if (!tempUser.equals(user)) {
						newUsers += USERS_SEPARATOR_STRING + tempUser;
					}
				}
				setAdmins(newUsers);
			}
		}
	
	public boolean IsAdmin(String user)
		throws PapillonBusinessException {
            String[] Users = getAdminsArray();
            boolean is = false;
            if (null != Users && Users.length > 0) {
				int i =0;
                while (!is && i<Users.length) {
                    is = user.equals(Users[i]);
					i++;
                }
            }
            return is;
        }
	
	protected void removeUsers() throws PapillonBusinessException {
		User [] usersTable = UsersFactory.getUsersArrayForGroup(this.getName());
		if (usersTable!=null) {
			for (int i=0;i<usersTable.length;i++) {
				usersTable[i].removeGroup(this.getName());
				usersTable[i].save();				
			}
			this.setUsers("");
		}
	}

				
	/**
		* save the object in the database
	 */
	
	public void save()
		throws PapillonBusinessException {
			try {
				this.myDO.commit();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error saving group", ex);
			}
		}
	
	/**
		* Deletes the Volume from the database.
	 *
	 * @exception PapillonBusinessException if an error occurs
	 *   deleting data (usually due to an underlying data layer
						*   error).
	 */
	public void delete()
		throws PapillonBusinessException {
			try {
				removeUsers();
				this.myDO.delete();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error deleting Volume", ex);
			}
		}
	
	
	/**	Uses the given digestalgorithm to compute a 20 byte array of the
		*	group name and password.
		*/
	protected static byte[] makeDigest(String group, String password)
		throws PapillonBusinessException {
			byte[] digestbytes = new byte[PASSWORD_DIGEST_LENGTH];
			if (group == null || group.equals("")) {
				throw new PapillonBusinessException("Error in makeDigestString: group string empty");
			}
			try {
				MessageDigest messagedigest = MessageDigest.getInstance("SHA");
				messagedigest.update(group.getBytes());
				messagedigest.update(password.getBytes());
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				messagedigest.update(baos.toByteArray());
				digestbytes = messagedigest.digest();
			} catch(NoSuchAlgorithmException nsae) {
				throw new PapillonBusinessException("Error in makeDigest: NoSuchAlgorithmException: ", nsae);
			}
			return digestbytes;
		}
	
	
	
	
	public boolean HasCorrectPassword(String password)
		throws PapillonBusinessException{
            boolean answer = false;
            String name = this.getName();
            try {
                if (null != name && !name.equals("")) {
                    byte[] givenPassword = makeDigest(name,password);
                    String givenPasswordString = new String(givenPassword, PASSWORD_ENCODING);
                    String origPasswordString = new String(this.getPassword(), PASSWORD_ENCODING); 
                    answer = origPasswordString.equals(givenPasswordString);
                    answer = true;
                }
            }
            catch(UnsupportedEncodingException uee){
                throw new PapillonBusinessException("Error in makeDigestString: UnsupportedEncodingException: " + PASSWORD_ENCODING, uee);
            }
            return answer;   
        } 
	
}