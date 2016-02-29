/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capcha;

import bean.entity.TblComment;
import bean.entity.TblImage;
import bean.entity.TblUser;
import bean.session.TblCommentFacadeRemote;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;


public class WriteComment extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware{
private int iid;
private String redirectURL;
private String title;
private String content;
protected Map session;
protected HttpServletRequest request;
protected HttpServletResponse response;

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WriteComment() {
    }

    @Override
    public String execute() throws Exception {
        if(getTitle().length()>=200)
        {
        addActionError("Title to loong !");
        return ERROR;
        }
        TblComment comment=new TblComment();
        String user=session.get("username").toString();
        comment.setImageID(new TblImage(new Integer(session.get("imageid").toString())));
        comment.setCommentTitle(title);
        comment.setCommentContent(content);
        comment.setCommentTimeCreate( new Date());
        comment.setUserID(new TblUser(user));
        InitialContext ict=new InitialContext();
        TblCommentFacadeRemote cremote=(TblCommentFacadeRemote)ict.lookup("java:global/WebphotoShare/TblCommentFacade");
        cremote.create(comment);
        this.redirectURL = "faces/detailsImage.jsp";
        this.iid=Integer.parseInt(session.get("imageid").toString());
        addActionMessage("Send Comment Success !");
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