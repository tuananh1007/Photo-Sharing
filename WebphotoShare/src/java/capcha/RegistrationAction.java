/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package capcha;

import bean.entity.TblUser;
import bean.session.TblUserFacadeRemote;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.*;
import com.opensymphony.xwork2.ActionContext;
import java.util.Date;
import javax.naming.InitialContext;
import log.WriteLog;
import utils.SendMailUtils;
import utils.ValidationUtils;

public class RegistrationAction extends ActionSupport {

    private String username;
    private Date birthdays;

    public Date getBirthdays() {
        return birthdays;
    }

    public void setBirthdays(Date birthdays) {
        this.birthdays = birthdays;
    }
    private String email;
    private String gender;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() throws Exception {
        InitialContext ict = new InitialContext();
        TblUserFacadeRemote remote = (TblUserFacadeRemote) ict.lookup("java:global/WebphotoShare/TblUserFacade");
        TblUser user = null;
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
        Boolean isNotResponseCorrect = Boolean.FALSE;
        javax.servlet.http.HttpSession session = request.getSession();
        String parm = request.getParameter("answer");
        String c = (String) session.getAttribute(Capcha.CAPTCHA_KEY);
        try {
            user = (TblUser) remote.find(getUsername());
        } catch (Exception e) {
            WriteLog writelog = new WriteLog();
            writelog.writeLogInfo(e.getMessage());
            e.printStackTrace();
        }
        if (user != null) {
            addActionError("User Name Allready Exist");
            isNotResponseCorrect = true;
        }
        if (!parm.equals(c)) {
            addActionError("Invalid Code! Please try again!");
            isNotResponseCorrect = true;
        }
        if (!ValidationUtils.isValidEmailAddress(getEmail())) {
            isNotResponseCorrect = true;
            addActionError("Invalid email format !");
        }
        if ((getUsername() == null) || (getUsername().length() <= 3)) {
            isNotResponseCorrect = true;
            addActionError("Invalid Username");
        }
//      if((getBirthdays()==null)||getBirthdays().compareTo(new Date())>=0)
//      {
//      isNotResponseCorrect=true;
//      addActionError("Datetime must be less than now");
//      }
        if (isNotResponseCorrect) {
            return ERROR;
        } else {
            user = new TblUser();
            Date birth = getBirthdays();
            user.setBirthday(getBirthdays());
            user.setDateRegistration(new Date());
            user.setEmail(getEmail());
            if (getGender().equalsIgnoreCase("male")) {
                user.setGender(true);
            } else {
                user.setGender(false);
            }
            user.setUserID(getUsername());
            user.setIsApproved(false);
            user.setUserAvatar("images/no.jpg");
            remote.create(user);
            //send mail to User.
            try {
                String smtpServer = "smtp.gmail.com";
                String to = getEmail();
                String from = "photosharepro@gmail.com";
                String subject = "Hello from PhotoShare Website";
                String body = "Thanks for you registered to PhotoShare Website."
                        + " Please wait admin approve your account"
                        + " password will be send to your email if your account is approved.";
                String password = "projectsem4";
                SendMailUtils.send(smtpServer, to, from, password, subject, body);
            } catch (Exception ex) {
                WriteLog writelog = new WriteLog();
                writelog.writeLogInfo(ex.getMessage());
                System.out.println("Usage: " + ex.getMessage());
            }
            addActionMessage("Thank you, registration account success, please check mail.");
            return SUCCESS;
        }
    }
}
