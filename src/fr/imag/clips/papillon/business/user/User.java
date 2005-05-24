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
 * Revision 1.6  2005/05/24 12:51:22  serasset
 * Updated many aspect of the Papillon project to handle lexalp project.
 * 1. Layout is now parametrable in the application configuration file.
 * 2. Notion of QueryResult has been defined to handle mono/bi and multi lingual dictionary requests
 * 3. Result presentation may be done by way of standard xsl or with any class implementing the appropriate interface.
 * 4. Enhanced dictionary edition management. The template interfaces has to be revised to be compatible.
 * 5. It is now possible to give a name to the cookie key in the app conf file
 * 6. Several bug fixes.
 *
 * Revision 1.5  2005/04/15 11:42:52  mangeot
 * Fixed a bug in isInNormalGroups when groups can be empty
 *
 * Revision 1.4  2005/04/11 12:29:59  mangeot
 * Merge between the XPathAndMultipleKeys branch and the main trunk
 *
 * Revision 1.3.2.2  2005/03/30 11:17:07  mangeot
 * Modified table contributions: replaced originalhandle by originalid
 * Corrected a few bugs when validating an already existing entry
 *
 * Revision 1.3.2.1  2005/03/29 09:41:33  serasset
 * Added transaction support. Use CurrentDBTransaction class to define a transaction
 * context in which all db commands will be executed.
 *
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:32  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
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
			this.myDO = UserDO.createVirgin(CurrentDBTransaction.get());
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
	
	public boolean isEmpty() {
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
			if (!isInGroup(group)) {
				addNewGroup(group);
			}
		}
	
	public void removeGroup(String group)
		throws PapillonBusinessException {
			if (isInGroup(group)) {
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
	
	
	
	public boolean isInGroups(String[] groups) 
		throws PapillonBusinessException {
			boolean answer = false;
			String[] myGroups = this.getGroupsArray();
			if (myGroups != null && myGroups.length>0) {
				if (groups !=null && groups.length>0) {
					int i=0;
					while (!answer && i<groups.length) {
						answer = this.isInGroup(groups[i]);
						i++;
					}
				}
			}
			return answer;
		}
	
	
	public boolean isInNormalGroups(String[] groups) 
		throws PapillonBusinessException {
			boolean answer = false;
			java.util.Vector groupsVector = new java.util.Vector();
			if (groups != null) {
				for (int i=0;i<groups.length;i++) {
					String tmpGroup = groups[i];
					if (!tmpGroup.equals("") &&
						!tmpGroup.equals(ADMIN_GROUP) &&
						!tmpGroup.equals(SPECIALIST_GROUP) &&
						!tmpGroup.equals(VALIDATOR_GROUP)) {
							groupsVector.add(tmpGroup);
					}
				}
			}
			if (groupsVector.size()==0) {
				answer = true;
			}
			else {
				String[] myGroups = this.getGroupsArray();			
				if (myGroups != null && myGroups.length>0) {
					int i=0;
					while (!answer && i<myGroups.length) {
						answer = (groupsVector.contains(myGroups[i]));
						i++;
					}
				}
			}
			return answer;
		}
	
	public boolean isInGroup(String group)
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
	
	public boolean isAdmin()
		throws PapillonBusinessException {
			return isInGroup(ADMIN_GROUP);
		}
	
	public boolean isSpecialist()
		throws PapillonBusinessException {
			return isInGroup(SPECIALIST_GROUP);
		}
	
	public boolean isValidator()
		throws PapillonBusinessException {
			return isInGroup(VALIDATOR_GROUP);
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