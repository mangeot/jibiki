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


public class GroupApi {

    
    protected static final String GROUPLIST_XMLSTRING_HEADER = "<?xml version='1.0' encoding='UTF-8'?><d:group-list xmlns:d='http://www-clips.imag.fr/geta/services/dml'>\n";
    protected static final String GROUPLIST_XMLSTRING_FOOTER = "</d:group-list>";
    
    protected static final String GROUP_XMLSTRING_HEADER = "<?xml version='1.0' encoding='UTF-8'?><d:group xmlns:d='http://www-clips.imag.fr/geta/services/dml'>\n";

    public static java.util.Vector getGroupsList(User theUser)
    throws PapillonBusinessException {
        java.util.Vector responseVector = new java.util.Vector(3);
        Integer status = new Integer(HttpPresentationResponse.SC_OK);
        org.w3c.dom.Document content = null;
        String errorMsg = "";

        
        String answer = GROUPLIST_XMLSTRING_HEADER;
        Group[] groupsArray = GroupsFactory.getAllGroupsArray();
        
        for (int i = 0; i < groupsArray.length; i++) {
            Group  aGroup = groupsArray[i];
            
            answer += "<d:group><name>" + aGroup.getName() + "</name></d:group>\n";
        }
        answer += GROUPLIST_XMLSTRING_FOOTER;
        content = XMLServices.buildDOMTree(answer);
        
        responseVector.addElement(content);
        responseVector.addElement(status);
        responseVector.addElement(errorMsg);
        return responseVector;
    }
    
    public static java.util.Vector getGroup(String name, User theUser)
    throws PapillonBusinessException {
        
        java.util.Vector responseVector = new java.util.Vector(3);
        Integer status = new Integer(HttpPresentationResponse.SC_OK);
        org.w3c.dom.Document content = null;
        String errorMsg = "";

        Group aGroup = GroupsFactory.findGroupByName(name);
        
        if (aGroup != null && !aGroup.isEmpty()) {
            String answer = GROUP_XMLSTRING_HEADER + "<name>" + aGroup.getName() + "</name>";
            if (theUser != null && (theUser.isAdmin() || aGroup.isAdmin(theUser.getLogin()))) {
                String[] usersArray = aGroup.getUsersArray();
                answer += "<members>";
                for (int i = 0; i < usersArray.length; i++) {
                    String  userLogin = usersArray[i];
                    answer += "<user-ref>" + userLogin + "</user-ref>\n";
                }
                answer += "</members>\n";
                answer += "<admins>";
                String[] adminsArray = aGroup.getAdminsArray();
                for (int i = 0; i < adminsArray.length; i++) {
                    String  adminLogin = adminsArray[i];
                    answer += "<user-ref>" + adminLogin + "</user-ref>\n";
                }
                answer += "</admins>";
            }
            answer += "</d:group>";
            content = XMLServices.buildDOMTree(answer);
        }
        responseVector.addElement(content);
        responseVector.addElement(status);
        responseVector.addElement(errorMsg);
        return responseVector;
    }
}
