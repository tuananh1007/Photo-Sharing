/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package capcha;

import bean.entity.TblImage;
import bean.session.TblImageFacadeRemote;
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
public class EditImage extends ActionSupport implements
		SessionAware, ServletRequestAware, ServletResponseAware{
    protected Map session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private File upload;//The actual file
    private String uploadContentType; //The content type of the file
    private String uploadFileName; //The uploaded file name
    private String fileCaption;//The caption of the file entered by user
    @Override
    public String execute() throws Exception {
    try {
    String fullFileName = ServletActionContext.getServletContext().getRealPath("/")+"uploadImages\\"+File_Utils.genFileName(uploadFileName);
    System.out.println("Type:"+uploadContentType);
    System.out.println("Location:"+fullFileName);
    System.out.println("Naem:"+getFileCaption());
    if((!"image/jpeg".equalsIgnoreCase(uploadContentType))&&(!("image/gif".equalsIgnoreCase(uploadContentType)))&&(!("image/bmp".equalsIgnoreCase(uploadContentType)))&&(!("image/png".equalsIgnoreCase(uploadContentType)))&&(!("image/ico".equalsIgnoreCase(uploadContentType))))
    {
    addActionError("File format invalid !");
    return ERROR;
    }
    //create and add iamge
    int iid=Integer.parseInt(session.get("eid").toString());
    InitialContext ict=new InitialContext();
    TblImageFacadeRemote iremote=(TblImageFacadeRemote)ict.lookup("java:global/WebphotoShare/TblImageFacade");
    TblImage img=iremote.find(new Integer(iid));
    //delete old file
    try{
    File file=new File(img.getImageLocation());
    file.delete();
    }catch(Exception e)
    {
    System.out.println("Delete file error when edit image!");
    WriteLog writelog=new WriteLog();
    writelog.writeLogInfo(e.getMessage());
    }
    img.setImageLocation(fullFileName);
    img.setImageName(fileCaption);
    img.setTimeUpload(new Date());
    iremote.edit(img);
    //save file
    File theFile = new File(fullFileName);
    FileUtils.copyFile(upload, theFile);
    } catch (Exception e) {

    addActionError(e.getMessage());
    WriteLog writelog=new WriteLog();
    writelog.writeLogInfo(e.getMessage());
    return ERROR;

    }
    return SUCCESS;

    }
  public String getFileCaption() {
    return fileCaption;
  }
  public void setFileCaption(String fileCaption) {
    this.fileCaption = fileCaption;
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