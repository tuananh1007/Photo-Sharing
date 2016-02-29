/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capcha;

import bean.entity.TblUser;
import bean.session.TblUserFacadeRemote;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import utils.PasswordUtils;



public class ChangePassWord extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware{
protected Map session;
protected HttpServletRequest request;
protected HttpServletResponse response;
private String oldpassword;
private String newpassword;
private String renewpassword;

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getRenewpassword() {
        return renewpassword;
    }

    public void setRenewpassword(String renewpassword) {
        this.renewpassword = renewpassword;
    }

    public ChangePassWord() {
    }

    @Override
    public String execute() throws Exception {
        InitialContext ict=new InitialContext();
        TblUserFacadeRemote uremote=(TblUserFacadeRemote)ict.lookup("java:global/WebphotoShare/TblUserFacade");
        TblUser user=uremote.find(session.get("username").toString());
        if(!user.getPassWord().equalsIgnoreCase(PasswordUtils.hashPassword(getOldpassword().trim()))){
        addActionError("Sorry, Old Password wrong !");
        return ERROR;
        }
        if((getOldpassword()==null)||(getOldpassword().length()==0)){
        addActionError("Enter Old Password");
        return ERROR;
        }
        if((getNewpassword()==null)||(getNewpassword().length()==0)){
        addActionError("Enter New Password");
        return ERROR;
        }
        if((getRenewpassword()==null)||(getRenewpassword().length()==0)){
        addActionError("ReEnter New Password");
        return ERROR;
        }
        if(!getNewpassword().equals(getRenewpassword())){
        addActionError("New Password not match");
        return ERROR;
        }

        user.setPassWord(PasswordUtils.hashPassword(getNewpassword()));
        uremote.edit(user);
        addActionMessage("Change password Successfully !");
        return SUCCESS;
    }
	public Map getSession() {
		return session;
	}

	public void setSession(Map sess) {
		this.session = sess;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest req){
		this.request = req;
	}

	public HttpServletResponse getServletResponse() {
		return response;
	}

	public void setServletResponse(HttpServletResponse resp) {
		this.response = resp;
	}
}