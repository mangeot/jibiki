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
 * Revision 1.1  2004/12/06 16:38:42  serasset
 * Initial revision
 *
 * Revision 1.8  2004/10/28 10:56:21  mangeot
 * Added the list of connected users on AdminUsers.java,
 * Added the possibility to sort in columns for some pages
 * Added persistent preferences for the user. They are saved in the database and retrived when the user reconnects. The user is registered in the enhydra session.
 *
 * Revision 1.7  2003/10/19 13:25:20  mangeot
 * Do not display null user messages any more
 *
 * Revision 1.6  2003/10/03 05:34:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.5  2003/08/23 03:58:05  mangeot
 * *** empty log message ***
 *
 * Revision 1.4  2003/08/20 08:15:39  mangeot
 * *** empty log message ***
 *
 * Revision 1.3  2003/08/14 08:30:18  mangeot
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
 * Revision 1.2.2.3  2003/05/28 09:17:23  mangeot
 * Changement du copyright sur les fichiers
 *
 * Revision 1.2.2.2  2003/03/19 10:03:10  mangeot
 * *** empty log message ***
 *
 * Revision 1.2.2.1  2003/03/18 06:04:12  mangeot
 * *** empty log message ***
 *
 * Revision 1.2  2003/01/10 08:11:57  mangeot
 * Problem with labels and UTF-8 fixed for internet explorer and icab
 * Problem with language identification fixed eg: en-US
 *
 * Revision 1.1.1.1  2002/10/28 16:49:17  serasset
 * Creation of the papillon CVS repository for enhydra 5.0
 *
 * Revision 1.7  2002/09/16 13:34:24  mangeot
 * Merged DEV and DEPLOY versions + added Olivier Tache code
 *
 * Revision 1.6.2.1  2002/08/08 09:11:58  mangeot
 * New Home page with simplified interface a lot of work
 * + localization in german
 *
 * Revision 1.6  2002/07/26 10:00:29  serasset
 * Merging deplyement branch "PAPILLON_1_2_DEPLOY" with the main branch.
 *
 * Revision 1.5.2.1  2002/07/12 13:50:49  serasset
 * A new architecture for HTML template localization has been integrated.
 *
 * Revision 1.5  2002/06/10 13:26:09  mangeot
 * Continued the localization, added the lang string into the session data
 *
 * Revision 1.4  2002/05/22 08:56:19  mangeot
 * MML added user login and register:
 * LoginUser.po RegisterUser.po AdminUsers.po
 *
 * Revision 1.3  2002/04/26 11:33:36  serasset
 * MailingList managment and interface polished. Insertion of a new feature to display
 * messages to the user from most business objects (PapillonUserLogger class).
 *
 * Revision 1.2  2001/07/04 12:50:50  serasset
 * Creation du dossier CVS pour Papillon, Mise a jour de fichiers pour inclusion du log
 * et de l'Id, suppression du dossier enh-deme introduit par erreur.
 *
 *-----------------------------------------------
 * 
 */


package fr.imag.clips.papillon.presentation;

import fr.imag.clips.papillon.business.user.User;
import java.util.ArrayList;
import java.util.Hashtable;

// for user interface
import fr.imag.clips.papillon.business.xmlschema.UserInterface;

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
	protected UserInterface editLexieUserInterface = null;
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
    
    public UserInterface getEditLexieUserInterface() {
        return this.editLexieUserInterface;
    }
    
    public void setEditLexieUserInterface(UserInterface newUserInterface) {
			this.editLexieUserInterface = newUserInterface;
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
