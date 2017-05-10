/*
-----------------------------
 * $Id$
 *-----------------------------------------------
 *
 *-----------------------------------------------
 * 
 */

package fr.imag.clips.papillon.business.user;

import com.lutris.appserver.server.httpPresentation.HttpPresentationResponse;

import fr.imag.clips.papillon.business.PapillonBusinessException;
import fr.imag.clips.papillon.business.xml.XMLServices;


public class UserApi {

    protected static final String USERLIST_XMLSTRING_HEADER = "<?xml version='1.0' encoding='UTF-8'?><d:user-list "
    + "xmlns:d='http://www-clips.imag.fr/geta/services/dml'>";
    protected static final String USERLIST_XMLSTRING_FOOTER = "</d:user-list>";
    protected static final String USER_XMLSTRING_HEADER = "<?xml version='1.0' encoding='UTF-8'?><d:user xmlns:d='http://www-clips.imag.fr/geta/services/dml'>";
    protected static final String sortByDefault = "login";

	
    public static java.util.Vector getUserList(User theUser)
        throws PapillonBusinessException {
        java.util.Vector responseVector = new java.util.Vector(3);
        Integer status = new Integer(HttpPresentationResponse.SC_OK);
        org.w3c.dom.Document content = null;
        String errorMsg = "";
        
        
        if (theUser != null && theUser.isAdmin()) {
            content = getUsersListForAdmin();
        }
        else {
            content = getUsersListForPublic();
        }
        
        responseVector.addElement(content);
        responseVector.addElement(status);
        responseVector.addElement(errorMsg);
        
        return responseVector;
    }
    
    private static org.w3c.dom.Document getUsersListForPublic()
        throws PapillonBusinessException {
        
        String resultString = USERLIST_XMLSTRING_HEADER;
        
        User[] usersArray = UsersFactory.getUsersArray(sortByDefault);
        
        for (int i = 0; i < usersArray.length; i++) {
            User  aUser = usersArray[i];
            
            resultString += "<d:user><name>" + aUser.getName() + "</name><login>" + aUser.getLogin() + "</login></d:user>";
        }
        resultString += USERLIST_XMLSTRING_FOOTER;
        org.w3c.dom.Document resultDoc = XMLServices.buildDOMTree(resultString);
        return resultDoc;
    }
    
    private static org.w3c.dom.Document getUsersListForAdmin() throws PapillonBusinessException {

        org.w3c.dom.Document resultDoc = XMLServices.buildDOMTree(USERLIST_XMLSTRING_HEADER+USERLIST_XMLSTRING_FOOTER);
        
        User[] usersArray = UsersFactory.getUsersArray(sortByDefault);
        
        for (int i = 0; i < usersArray.length; i++) {
            User  aUser = usersArray[i];
            
            org.w3c.dom.Document aUserDom = XMLServices.buildDOMTree(aUser.getXmlCode());
            org.w3c.dom.Node aUserImported = resultDoc.importNode(aUserDom.getDocumentElement(), true);
            resultDoc.getDocumentElement().appendChild(aUserImported);
        }
        return resultDoc;
    }
    
    public static org.w3c.dom.Document getUser(String login, User theUser)
        throws PapillonBusinessException {

        org.w3c.dom.Document resultDoc = null;
        
        if (theUser != null && (theUser.isAdmin() || theUser.getLogin().equals(login))) {
            resultDoc = getUserForAdmin(login);
        }
        else {
            resultDoc = getUserForPublic(login);
        }
        return resultDoc;
    }
    
    
    private static org.w3c.dom.Document getUserForPublic(String login) throws PapillonBusinessException {

        
        User aUser = UsersFactory.findUserByLogin(login);
        org.w3c.dom.Document resultDoc = null;
        
        if (aUser != null && !aUser.isEmpty()) {
            String resultString = USER_XMLSTRING_HEADER + "<name>" + aUser.getName() + "</name><login>" + aUser.getLogin() + "</login></d:user>";
            resultDoc = XMLServices.buildDOMTree(resultString);
        }
        return resultDoc;
    }
    
    private static org.w3c.dom.Document getUserForAdmin(String login)
        throws PapillonBusinessException {
        org.w3c.dom.Document resultDoc = null;
        
        User aUser = UsersFactory.findUserByLogin(login);
        
        if (aUser != null && !aUser.isEmpty()) {
            resultDoc = XMLServices.buildDOMTree(aUser.getXmlCode());
        }
        return resultDoc;
    }

}
