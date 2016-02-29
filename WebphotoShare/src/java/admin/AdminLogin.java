/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package admin;

import bean.session.TblAdminFacadeRemote;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import utils.PasswordUtils;



public class AdminLogin extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware{
    	private static final long serialVersionUID = 1L;

	protected Map session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

private String aname;
private String apass;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApass() {
        return apass;
    }

    public void setApass(String apass) {
        this.apass = apass;
    }

    public AdminLogin() {
    }

    @Override
    public String execute() throws Exception {
        boolean isvalid=true;
        if((aname.length()<1)||aname==null)
        {
        addActionError( "Admin name must be greater than 6 characters");
        isvalid=false;
        }
        if((apass.length()<1)||apass==null)
        {
        addActionError( "Admin password must be greater than 6 characters");
        isvalid=false;
        }
        InitialContext ict=new InitialContext();
        TblAdminFacadeRemote aremote=(TblAdminFacadeRemote)ict.lookup("java:global/WebphotoShare/TblAdminFacade");
        int rs=aremote.adminLogin(getAname().trim(), PasswordUtils.hashPassword(getApass().trim()));
        if(rs==0)
        {
        isvalid=false;
        addActionError("Login Failed");
        }
        if(isvalid)
        {
            session.put("admin", getAname());
            return SUCCESS;
        }
        else
            return ERROR;
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