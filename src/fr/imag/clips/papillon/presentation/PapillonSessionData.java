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
 * Revision 1.3  2005/01/15 12:51:24  mangeot
 * Deleting old cvs comments + bug fixes with xhtml and enhydra5.1
 *
 * Revision 1.2  2004/12/24 14:31:28  mangeot
 * I merged the latest developments of Papillon5.0 with this version 5.1.
 * Have to be tested more ...
 *
 * Revision 1.1.1.1  2004/12/06 16:38:42  serasset
 * Papillon for enhydra 5.1. This version compiles and starts with enhydra 5.1.
 * There are still bugs in the code.
 *
 *
 *-----------------------------------------------
 * 
 */


package fr.imag.clips.papillon.presentation;

import fr.imag.clips.papillon.business.user.User;
import java.util.ArrayList;
import java.util.Hashtable;

import fr.imag.clips.papillon.business.PapillonBusinessException;


/**
 * Object that will be held in session data.  This should
 * be the only object held there.  Methods should be called
 * on this object to set and get data.
 */
public class PapillonSessionData {
    protected final int INITIAL_MESSAGE_SIZE = 256;
    
    /**
     * Hash key to save session data for the DiscRack app in the Session
     */
    public static final String SESSION_KEY = "PapillonSessionData";
    
    protected User myUser = null;
    protected StringBuffer userMessage = null;
    protected ArrayList acceptLanguages = new ArrayList();
    protected boolean ClientWithLabelDisplayProblems = false;
	protected Hashtable PreferencesTable = null;
    
    public PapillonSessionData(User myUser, ArrayList userAcceptLanguage, String requestHeader)
		throws PapillonBusinessException{
			setUser(myUser);
			setUserAcceptLanguages(userAcceptLanguage);
			if (myUser != null && !myUser.IsEmpty()) {
				setUserPreferredLanguage(myUser.getLang());
			}
			setClientWithLabelDisplayProblems(requestHeader);
			this.userMessage = new StringBuffer(INITIAL_MESSAGE_SIZE);
    }

    /**
        * Language selection support
     *
     * @param lang the language name (3 characters String).
     */
    public void setUserPreferredLanguage(String lang) {
			this.acceptLanguages.set(0, lang);
    }

    public ArrayList getUserAcceptLanguages() {
        return this.acceptLanguages;
    }
    
    public String getUserPreferredLanguage() {
        return (String)this.acceptLanguages.get(0);
    }

    protected void setUserAcceptLanguages(ArrayList accept) {
        this.acceptLanguages = accept;
    }

    public boolean getClientWithLabelDisplayProblems() {
        return this.ClientWithLabelDisplayProblems;
    }

    protected void setClientWithLabelDisplayProblems(String requestHeader) {
        this.ClientWithLabelDisplayProblems = (requestHeader.indexOf("MSIE") > 0
                                                || requestHeader.indexOf("iCab") > 0);
    }	
    /**
        * Sets the person object
     *
     * @param thePerson the person object
     */
    protected void setUser(User theUser) {
        this.myUser = theUser;
    }

    /**
     * Gets the person object
     *
     * @return person
     */
    public User getUser() {
        return this.myUser;
    }    
    
    /**
     * Method to remove the current user from the session
     */
    public void removeUser() {
        this.myUser = null;
    }
    
    public String getUserMessage() {
        return this.userMessage.toString();
    }
    
    /**
     * Appends the given String to the Message that will be provided to the user
     * after the completion of the action.
     */
    public void writeUserMessage(String msg) {
        if  (null != msg && !msg.equals("")) {
            this.userMessage.append(msg);
            if (null != msg && !msg.endsWith("\n")) {
                this.userMessage.append('\n');
            }
        }
    }
    
    public void flushUserMessage() {
        this.userMessage.setLength(0);
    } 

// management of the preferences
    public String getPreference(String url, String name) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
        String pref = "";
		if (this.PreferencesTable ==null) {
			if (this.myUser!=null) {
				this.PreferencesTable = this.myUser.getPreferences();
			}
			else {
				this.PreferencesTable = new Hashtable();
			}
		}
		if (this.PreferencesTable !=null) {
			pref = (String) this.PreferencesTable.get(url + User.KEY_SEP + name);
		}
		
		return pref;
    } 

	
    public void setPreference(String url, String name, String value) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
			setPreference(url, name, value, true);
	} 

    public void setPreference(String url, String name, String value, boolean persistent) 
		throws fr.imag.clips.papillon.business.PapillonBusinessException {
		if (value !=null) {
			if (this.PreferencesTable ==null) {
				if (this.myUser!=null && persistent) {
					this.PreferencesTable = this.myUser.getPreferences();
				}
				else {
					this.PreferencesTable = new Hashtable();
				}
			}
			if (this.PreferencesTable !=null) {
				String pref = (String) this.PreferencesTable.get(url + User.KEY_SEP + name);
				if (value !=null && !value.equals(pref)) {
					this.PreferencesTable.put(url + User.KEY_SEP + name, value);
					if (myUser!=null && persistent) {
						this.myUser.setPreference(url, name, value);
					}
				}
			}
		}	
	}
}
