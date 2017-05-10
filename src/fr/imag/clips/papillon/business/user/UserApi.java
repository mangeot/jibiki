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
import fr.imag.clips.papillon.business.PapillonLogger;
import fr.imag.clips.papillon.business.xml.XMLServices;


public class UserApi {

    protected static String JSON_CONTENTTYPE = "text/json";
    protected static String XML_CONTENTTYPE = "text/xml";

    protected static final String USERLIST_XMLSTRING_HEADER = "<?xml version='1.0' encoding='UTF-8'?><d:user-list "
    + "xmlns:d='http://www-clips.imag.fr/geta/services/dml'>";
    protected static final String USERLIST_XMLSTRING_FOOTER = "</d:user-list>";
    protected static final String USER_XMLSTRING_HEADER = "<?xml version='1.0' encoding='UTF-8'?><d:user xmlns:d='http://www-clips.imag.fr/geta/services/dml'>";
    protected static final String sortByDefault = "login";

	
    public static java.util.Vector getUserList(User theUser)
        throws PapillonBusinessException {
        java.util.Vector responseVector = new java.util.Vector(3);
        int status = HttpPresentationResponse.SC_OK;
        org.w3c.dom.Document content = null;
        String errorMsg = "";
        
        
        if (theUser != null && theUser.isAdmin()) {
            content = getUsersListForAdmin();
        }
        else {
            content = getUsersListForPublic();
        }
        
        responseVector.addElement(content);
        responseVector.addElement(new Integer(status));
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
    
    public static java.util.Vector getUser(String login, User theUser)
        throws PapillonBusinessException {

        java.util.Vector responseVector = new java.util.Vector(3);
        int status = HttpPresentationResponse.SC_OK;
        org.w3c.dom.Document content = null;
        String errorMsg = "";

        
        if (theUser != null && (theUser.isAdmin() || theUser.getLogin().equals(login))) {
            content = getUserForAdmin(login);
        }
        else {
            content = getUserForPublic(login);
        }
        if (content == null) {
            errorMsg = "Error: user: " + login + " does not exist!";
            status = HttpPresentationResponse.SC_NOT_FOUND;
            content = XMLServices.buildDOMTree("<?xml version='1.0'?><html><h1>Error : " + status + "</h1><p>" + errorMsg + "</p></html>");
        }
        responseVector.addElement(content);
        responseVector.addElement(new Integer(status));
        responseVector.addElement(errorMsg);
        return responseVector;
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
    
    public static java.util.Vector postUser(String authlogin, String authpassword, String login, String userString, String contentType, User theUser)
    throws PapillonBusinessException, org.json.JSONException {
        PapillonLogger.writeDebugMsg("POST user 10 login"+ login);
        
        java.util.Vector responseVector = new java.util.Vector(3);
        int status = HttpPresentationResponse.SC_OK;
        org.w3c.dom.Document content = null;
        String errorMsg = "";
                
        if (authlogin != null && authlogin != "" && authpassword != null && authpassword != "") {
            User aUser = UsersFactory.findUserByLogin(login);
            if (aUser != null && !aUser.isEmpty()) {
                errorMsg = "Error: conflict, user " + login + " already exists!";
                status = 409;
                content = XMLServices.buildDOMTree("<?xml version='1.0'?><html><h1>Error : " + status + " Conflict</h1><p>" + errorMsg + "</p></html>");
            }
            else {
                if (contentType.equals(JSON_CONTENTTYPE)) {
                    org.json.JSONObject obj = new org.json.JSONObject(userString);
                    String userName = obj.getJSONObject("user").getString("name");
                    String email = obj.getJSONObject("user").getString("email");
                    PapillonLogger.writeDebugMsg("POST user login: " + authlogin + " password: " + authpassword + " name: " + userName + " email: " +email);
                   /* String email = obj.getJSONObject("pageInfo").getString("pageName");
                    
                    JSONArray arr = obj.getJSONArray("posts");
                    for (int i = 0; i < arr.length(); i++)
                    {
                        String post_id = arr.getJSONObject(i).getString("post_id");
                        ......
                    }*/

                }
            }
        }
        responseVector.addElement(content);
        responseVector.addElement(new Integer(status));
        responseVector.addElement(errorMsg);
        return responseVector;
    }

}
