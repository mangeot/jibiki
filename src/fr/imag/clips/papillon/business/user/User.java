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
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:32  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 * Revision 1.8  2004/10/30 10:26:06  mangeot
 * Fixed bug at init
 *
 * Revision 1.7  2004/10/28 10:35:01  mangeot
 * Some changes:
 * the User.java implements an enhydra interface in order to register users into enhydra sessions
 * the AdminUsers.java displays currently logged users
 *
 * Revision 1.6  2004/03/26 07:53:26  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2004/02/10 05:27:14  mangeot
 * The version UIGEN_V2 has been merged with the trunk by MM
 * Be careful because the Volumes and contributions database tables have been modified.
 * You have to drop and rebuild them unless you modify them by hands.
 *
 * Revision 1.4.2.4  2004/01/21 07:50:29  mangeot
 * Added confirm javascript for delete button
 *
 * Revision 1.4.2.3  2004/01/09 05:18:57  mangeot
 * Bugs fixes !
 *
 * Revision 1.4.2.2  2004/01/08 15:17:20  mangeot
 * Bugs fixed
 *
 * Revision 1.4.2.1  2004/01/08 09:43:19  mangeot
 * Changed all the mechanism of the management of the contributions
 * Have to be tested
 *
 * Revision 1.4  2003/08/14 08:30:13  mangeot
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
 * Revision 1.3  2003/06/04 15:38:30  serasset
 * Mise en place du chinois et de la nouvelle version du login/register
 *
 * Revision 1.2.2.2  2003/07/31 04:30:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.1  2003/05/28 09:17:20  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.2  2002/11/26 06:38:47  mangeot
 * Work on RegisterUser: fixed bugs and clarified !
 *
 * Revision 1.1.1.1  2002/10/28 16:49:15  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.2  2002/10/25 14:10:32  mangeot
 * merge between PAPILLON_1_4 and trunk
 * CVg: 	papillon-enh-src/docs/Bugs-papillon.rtf
 *
 * Revision 1.1.10.3  2002/10/23 09:51:10  serasset
 * Clean up of the source tree,
 *     Every source file is now encoded in ISO-Latin-1,
 *     Every html file is still encoded in UTF8.
 *
 * Revision 1.1.10.2  2002/10/09 10:32:04  mangeot
 * Modified the database
 *
 * Revision 1.1.10.1  2002/10/09 06:18:06  mangeot
 * password encoding for protection
 *
 * Revision 1.1  2002/05/22 08:59:49  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2001/07/04 12:50:43  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.user;

import fr.imag.clips.papillon.data.*;
import fr.imag.clips.papillon.business.PapillonBusinessException;

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

/* for XML management */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.imag.clips.papillon.business.utility.Utility;


public class User implements com.lutris.appserver.server.user.User {
	
    public final static String ADMIN_GROUP = "admin";
    public final static String SPECIALIST_GROUP = "specialist";
    public final static String VALIDATOR_GROUP = "validator";
    public final static String KEY_SEP = "?";
    public final static String GROUPS_SEPARATOR_STRING = "#";

    protected final static String PASSWORD_STRING = "Papillon.Users.Groups.Password";
    protected final static String PASSWORD_ENCODING = "US-ASCII";
    protected final static String PASSWORD_DIGEST = "SHA";
    protected final static int PASSWORD_DIGEST_LENGTH = 30;
	
	protected final static String USER_TAG = "user";
	protected final static String PREFERENCES_TAG = "preferences";
	protected final static String PREFERENCE_TAG = "preference";
	protected final static String URL_ATTR = "href";
	protected final static String NAME_ATTR = "name";
	protected final static String VALUE_ATTR = "value";
	
	
	
    /**
		* The DO of the Volume.
	 */
	protected UserDO myDO = null;
	
	/**
		* The public constructor.
	 */
	public User() throws PapillonBusinessException {
		try {
			this.myDO = UserDO.createVirgin();
		} catch(DatabaseManagerException ex) {
			throw new PapillonBusinessException("Error creating empty user", ex);
		} catch(ObjectIdException ex) {
			throw new PapillonBusinessException("Error creating empty user", ex);
		}
		/* FIXME: I changed the papillon.doml with canBeNull = yes for groups
		but the existing databases have to be changed... */
		this.setGroups("");
	}
	
	/** The protected constructor
		*
		* @param theDisc. The data object of the Volume.
		*/
	protected User(UserDO theUser)
		throws PapillonBusinessException  {
			this.myDO = theUser;
		}
	
	public boolean IsEmpty() {
		return (this.myDO==null) ;
	}
	
	// access methods
	
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
				throw new PapillonBusinessException("Error getting user's handle", ex);
			}
		}
	
	/**
		* Gets the name of the Volume
	 *
	 * @return the name.
	 * @exception odes not throw any exception for compatability with the interface.
	 */
	public String getName() {
		String result = null;
		try {
			result = myDO.getName();
		}  catch(DataObjectException ex) {
				fr.imag.clips.papillon.business.PapillonLogger.writeDebugMsg("Error getting user's name: " + ex.toString());
			}
		return result;
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
		* Gets the dictname of the Volume
	 *
	 * @return the dictname.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String getLogin()
		throws PapillonBusinessException {
			try {
				return myDO.getLogin();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting user's login", ex);
			}
		}
	public void setLogin(String login)
		throws PapillonBusinessException {
			try {
				myDO.setLogin(login);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting user's login", ex);
			}
		}
	
	
	/**
		* Gets the password of the user
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
				throw new PapillonBusinessException("Error getting users's password", ex);
			}
		}
	public void setPassword(String password)
		throws PapillonBusinessException {
			try {
				byte[] myDigest = makeDigest(this.getLogin(), password);
				myDO.setPassword(myDigest);
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting user's password", ex);
			}
		}
	
	/**
		* Gets the email of the user
	 *
	 * @return the email.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String getEmail()
		throws PapillonBusinessException {
			try {
				return myDO.getEmail();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting user's email", ex);
			}
		}
	public void setEmail(String email)
		throws PapillonBusinessException {
			try {
				myDO.setEmail(email);
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting user's email", ex);
			}
		}
	
	/**
		* Gets the preferred language of the user
	 *
	 * @return the preferred language.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String getLang()
		throws PapillonBusinessException {
			try {
				return myDO.getLang();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting user's lang", ex);
			}
		}
	public void setLang(String lang)
		throws PapillonBusinessException {
			try {
				if (lang != null && lang.length() > 3) {
					lang = lang.substring(0,2);
				}
				myDO.setLang(lang);
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting user's lang", ex);
			}
		}
	
	/**
		* Gets the groups of the user
	 *
	 * @return the groups.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
	public String[] getGroupsArray()
		throws PapillonBusinessException {
			String[] Groups = null;
			String groups = getGroups();
			if (null != groups && !groups.equals("")){
			// delete the first separator in order to avoid an empty group
				if (groups.indexOf(GROUPS_SEPARATOR_STRING) ==0) {
					groups = groups.substring(GROUPS_SEPARATOR_STRING.length());
				}
				Groups = groups.split(GROUPS_SEPARATOR_STRING);
			}
			return Groups;
		}
	
	public String getGroups()
		throws PapillonBusinessException {
			try {
				return myDO.getGroups();
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting user's groups", ex);
			}
		}
	protected void setGroups(String groups)
		throws PapillonBusinessException {
			try {
                myDO.setGroups(groups);
				
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting user's groups", ex);
			}
		}
	public void setGroupsArray(String[] Groups)
		throws PapillonBusinessException {
			String groups = null;
			if (null != groups && Groups.length >0) {
				for (int i=0; i< Groups.length; i++) {
					groups = groups + GROUPS_SEPARATOR_STRING + Groups[i];
				}
			}
			groups.trim();
			setGroups(groups);
		}
	
	/**
		* Gets the xmlcode of the user
	 *
	 * @return the xmlcode as a string.
	 * @exception PapillonBusinessException if an error occurs
	 *   retrieving data (usually due to an underlying data layer
						  *   error).
	 */
    public String getXmlCode()
        throws PapillonBusinessException {
			try {
				return this.myDO.getXmlCode();
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error getting User's xmlcode", ex);
			} 
		}
	public void setXmlCode(String code)
        throws PapillonBusinessException {
			try {
		  		myDO.setXmlCode(code);   
			} catch(DataObjectException ex) {
				throw new PapillonBusinessException("Error setting User's xmlcode", ex);
			}
		}
	
	// group convenience methods
	protected void addNewGroup(String group)
		throws PapillonBusinessException {
			String groups = getGroups();
			groups = groups + GROUPS_SEPARATOR_STRING + group;
			groups.trim();
			setGroups(groups);
		}
	
	public void addGroup(String group)
		throws PapillonBusinessException {
			if (!IsInGroup(group)) {
				addNewGroup(group);
			}
		}
	
	public void removeGroup(String group)
		throws PapillonBusinessException {
			if (IsInGroup(group)) {
				String[] groups = getGroupsArray();
				String newGroups = "";
				for (int i=0;i< groups.length;i++) {
					String tempGroup = groups[i];
					if (!tempGroup.equals(group)) {
						newGroups += GROUPS_SEPARATOR_STRING + tempGroup;
					}
				}
				setGroups(newGroups);
			}
		}
	
	
	
	public boolean IsInGroups(String[] groups) 
		throws PapillonBusinessException {
			boolean answer = false;
			String[] myGroups = this.getGroupsArray();
			if (myGroups != null && myGroups.length>0) {
				if (groups !=null && groups.length>0) {
					int i=0;
					while (!answer && i<groups.length) {
						answer = this.IsInGroup(groups[i]);
						i++;
					}
				}
			}
			return answer;
		}
	
	
	public boolean IsInNormalGroups(String[] groups) 
		throws PapillonBusinessException {
			boolean answer = false;
			String[] myGroups = this.getGroupsArray();			
			if (myGroups != null && myGroups.length>0
				&& groups !=null && groups.length>0) {
				int i=0;
				while (!answer && i<myGroups.length) {
					String myGroup = myGroups[i];
					if (!myGroup.equals(ADMIN_GROUP) &&
						!myGroup.equals(SPECIALIST_GROUP) &&
						!myGroup.equals(VALIDATOR_GROUP)) {
						int j=0;
						while (!answer && j<groups.length) {
							answer = myGroup.equals(groups[j]);
							j++;
						}
					}
					i++;
				}
			}
			return answer;
		}
	
	public boolean IsInGroup(String group)
		throws PapillonBusinessException {
            String[] Groups = getGroupsArray();
            boolean is = false;
            if (null != Groups && Groups.length > 0) {
 				int i =0;
                while (!is && i<Groups.length) {
                    is = group.equals(Groups[i]);
					i++;
                }
            }
            return is;
        }
	
	public boolean IsAdmin()
		throws PapillonBusinessException {
			return IsInGroup(ADMIN_GROUP);
		}
	
	public boolean IsSpecialist()
		throws PapillonBusinessException {
			return IsInGroup(SPECIALIST_GROUP);
		}
	
	public boolean IsValidator()
		throws PapillonBusinessException {
			return IsInGroup(VALIDATOR_GROUP);
		}
	
	public String getGroupPassword(String group)
		throws PapillonBusinessException {
            String password = null;
			try {
				password =  Enhydra.getApplication().getConfig().getString(PASSWORD_STRING + "." + group);
			}
            catch (ConfigException e) {
				//     throw new PapillonBusinessException("Password not found. Check the application config file.", e);
            }
            return password;
        }
	
	/**
		* save the object in the database
	 */
	
	public void save()
		throws PapillonBusinessException {
			try {
				this.myDO.commit();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error saving user", ex);
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
				this.myDO.delete();
			} catch(Exception ex) {
				throw new PapillonBusinessException("Error deleting Volume", ex);
			}
		}
	
	
	/**	Uses the given digest algorithm to compute a 20 byte array of the
		*	user name and password.
		*/
	protected static byte[] makeDigest(String user, String password)
		throws PapillonBusinessException {
			byte[] digestbytes = new byte[PASSWORD_DIGEST_LENGTH];
			if (user == null || user.equals("")) {
				throw new PapillonBusinessException("Error in makeDigestString: user login empty");
			}
			try {
				MessageDigest messagedigest = MessageDigest.getInstance(PASSWORD_DIGEST);
				messagedigest.update(user.getBytes());
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
		throws PapillonBusinessException {
            boolean answer = false;
            String login = this.getLogin();
            try {
                if (null != login && !login.equals("")) {
                    byte[] givenPassword = makeDigest(login,password);
                    String givenPasswordString = new String(givenPassword, PASSWORD_ENCODING);
                    String origPasswordString = new String(this.getPassword(), PASSWORD_ENCODING); 
                    answer = origPasswordString.equals(givenPasswordString);
                }
            }
            catch(UnsupportedEncodingException uee){
                throw new PapillonBusinessException("Error in makeDigestString: UnsupportedEncodingException: " + PASSWORD_ENCODING, uee);
            }
            return answer;   
        } 
		
	// xmlcode management methods
	
	protected String serializeXml() 
		throws PapillonBusinessException {
			String xmlCode = "<?xml version='1.0' encoding='UTF-8' standalone='yes'?>\n" +
"<" + USER_TAG +
"   xmlns='http://www-clips.imag.fr/geta/services/dml'\n" +
"   xmlns:xlink='http://www.w3.org/1999/xlink'\n" +
"   xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'\n" +
"   xsi:schemaLocation='http://www-clips.imag.fr/geta/services/dml\n" +
"   http://www-clips.imag.fr/geta/services/dml/dml.xsd'\n";
			if (getName()!=null) {
				xmlCode += "name='" + getName() + "'\n";
			}
			if (getLang()!=null) {
				xmlCode += "lang='" + getLang() + "'\n";
			}

	//end of the attributes
			xmlCode += ">\n";
			
	// login
			if (getLogin()!=null) {
				xmlCode += "<login>" + getLogin() + "</login>\n";
			}
 
	// password
			if (getPassword()!=null) {
				xmlCode += "<password encoding='" + PASSWORD_ENCODING + "' ";
				xmlCode += "digest-length='" + PASSWORD_DIGEST_LENGTH + "' ";
				xmlCode += "digest='" + PASSWORD_DIGEST + "' ";
				xmlCode += ">" + getPassword() + "</password>\n";
			}
 
	// email
			if (getEmail()!=null) {
				xmlCode += "<email>" + getEmail() + "</email>\n";
			}

	// groups
			xmlCode += "<groups>\n";
			String[] groupsArray = getGroupsArray();
			if (groupsArray!=null) {
				for (int i=0;i<groupsArray.length;i++) {
					xmlCode += "<group-ref name='" + groupsArray[i] + "' />\n";
				}
			}
			xmlCode += "</groups>\n";
			
	// preferences
			xmlCode += "<" + PREFERENCES_TAG + "/>\n";
			
	// end of user
			xmlCode += "</" + USER_TAG + ">\n";
			
			this.setXmlCode(xmlCode);
			this.save();
			return xmlCode;
		}
		
		// preference management methods	
		public Hashtable getPreferences() 
			throws fr.imag.clips.papillon.business.PapillonBusinessException {
			Hashtable PrefsTable = new Hashtable();
		
			String xmlCode = getXmlCode();
			if (xmlCode==null || xmlCode.equals("")) {
				xmlCode = serializeXml();
			}
			if (xmlCode!=null && !xmlCode.equals("")) {
				Document myDocDOM = Utility.buildDOMTree(xmlCode);
				NodeList myNodeList = myDocDOM.getElementsByTagName(PREFERENCE_TAG);
				for (int i=0;i<myNodeList.getLength ();i++) {
					Element currentElt = (Element) myNodeList.item(i);
					String tmpUrl = currentElt.getAttribute(URL_ATTR);
					String tmpName = currentElt.getAttribute(NAME_ATTR);
					String tmpPref = currentElt.getAttribute(VALUE_ATTR);
					if (tmpUrl != null && tmpName != null && tmpPref != null) {
						PrefsTable.put(tmpUrl + KEY_SEP + tmpName, tmpPref);
					}
				}
			}
			
			return PrefsTable;
		}
	
		public boolean setPreference(String url, String name, String value) 
			throws fr.imag.clips.papillon.business.PapillonBusinessException {
			boolean found = false;
		
			String xmlCode = getXmlCode();
			if (xmlCode==null || xmlCode.equals("")) {
				xmlCode = serializeXml();
			}
			if (xmlCode!=null && !xmlCode.equals("")) {
				Document myDocDOM = Utility.buildDOMTree(xmlCode);
				NodeList myNodeList = myDocDOM.getElementsByTagName(PREFERENCE_TAG);
				int i=0;
				while (i<myNodeList.getLength () && !found) {
					Element currentElt = (Element) myNodeList.item(i);
					String tmpUrl = currentElt.getAttribute(URL_ATTR);
					String tmpName = currentElt.getAttribute(NAME_ATTR);
					if (tmpUrl != null && tmpUrl.equals(url)
					&& tmpName != null && tmpName.equals(name)) {
						currentElt.setAttribute(VALUE_ATTR,value);
						found=true;
					}
					i++;
				}
				if (!found) {
					NodeList parentNodeList = myDocDOM.getElementsByTagName(PREFERENCES_TAG);
					if (parentNodeList!=null && parentNodeList.getLength ()>0) {
						Element parentElt = (Element) parentNodeList.item(0);
						Element newPref = myDocDOM.createElement(PREFERENCE_TAG);
						newPref.setAttribute(URL_ATTR,url);
						newPref.setAttribute(NAME_ATTR,name);
						newPref.setAttribute(VALUE_ATTR,value);
						parentElt.appendChild(newPref);
						found = true;
					}
				}
				this.setXmlCode(Utility.NodeToString(myDocDOM)); 
				this.save();
			}
			return found;
		}
	
}