/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capcha;

import bean.entity.TblQuery;
import bean.entity.TblUser;
import bean.session.TblQueryFacadeRemote;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;



public class WriteQuery extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware{
private String content;
protected Map session;
protected HttpServletRequest request;
protected HttpServletResponse response;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WriteQuery() {
    }

    @Override
    public String execute() throws Exception {
            String username=session.get("username").toString();
            if(getContent().length()>=500){
            addActionError("Content Query too length");
            return ERROR;
            }
            InitialContext ict=new InitialContext();
            TblQueryFacadeRemote qremote=(TblQueryFacadeRemote)ict.lookup("java:global/WebphotoShare/TblQueryFacade");
            TblQuery query=new TblQuery();
            query.setUserID(new TblUser(username));
            query.setDateCreate(new Date());
            query.setQueryContent(getContent());
            qremote.create(query);
            addActionMessage("Send Query success !");
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