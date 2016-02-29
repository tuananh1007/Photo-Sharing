/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capcha;



import bean.entity.TblUser;
import bean.session.TblUserFacadeRemote;
import java.io.File;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import log.WriteLog;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import utils.File_Utils;
public class EditProfile extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware{
    protected Map session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private File upload;//The actual file
    private String uploadContentType; //The content type of the file
    private String uploadFileName; //The uploaded file name
    private String fullname;//The caption of the file entered by user
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String execute() throws Exception {
    try {
    String fullFileName = ServletActionContext.getServletContext().getRealPath("/")+"uploadImages\\"+File_Utils.genFileName(uploadFileName);
    System.out.println("Type:"+uploadContentType);
    System.out.println("Location:"+fullFileName);
    if((!"image/jpeg".equalsIgnoreCase(uploadContentType))&&(!("image/gif".equalsIgnoreCase(uploadContentType)))&&(!("image/bmp".equalsIgnoreCase(uploadContentType)))&&(!("image/png".equalsIgnoreCase(uploadContentType)))&&(!("image/ico".equalsIgnoreCase(uploadContentType)))){
    addActionError("File format invalid !");
    return ERROR;
    }
    //create and add iamge
    InitialContext ict=new InitialContext();
    TblUserFacadeRemote uremote=(TblUserFacadeRemote)ict.lookup("java:global/WebphotoShare/TblUserFacade");
    TblUser user=uremote.find(session.get("username").toString());
    if("images/no.jpg".equalsIgnoreCase(user.getUserAvatar())||user.getUserAvatar()==null){
    user.setUserAvatar(fullFileName);
    }
    else{
    //if exist avatar, del old image avatar
    File delfile=new File(user.getUserAvatar());
    delfile.delete();
    user.setUserAvatar(fullFileName);
    }
    if((getFullname()!=null)&&(getFullname().length()>0))
    user.setUserFullName(getFullname());
    if(getBirthday()!=null) user.setBirthday(getBirthday());
    uremote.edit(user);
    //finish EditImage image
    File theFile = new File(fullFileName);
    FileUtils.copyFile(upload, theFile);
    } catch (Exception e) {
    WriteLog writelog=new WriteLog();
    writelog.writeLogInfo(e.getMessage());
    addActionError(e.getMessage());
    return ERROR;
    }
    addActionMessage("Edit Profile Successfully!");
    return SUCCESS;
    }
  public File getUpload() {
    return upload;
  }
  public void setUpload(File upload) {
    this.upload = upload;
  }
  public String getUploadContentType() {
    return uploadContentType;
  }
  public void setUploadContentType(String uploadContentType) {
    this.uploadContentType = uploadContentType;
  }
  public String getUploadFileName() {
    return uploadFileName;
  }
  public void setUploadFileName(String uploadFileName) {
    this.uploadFileName = uploadFileName;
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