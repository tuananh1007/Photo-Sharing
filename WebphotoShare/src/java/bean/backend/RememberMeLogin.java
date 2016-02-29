/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean.backend;

import bean.session.TblUserFacadeRemote;
import static com.opensymphony.xwork2.Action.*;
import utils.*;
import javax.naming.NamingException;
import javax.servlet.http.*;
import javax.faces.context.*;
import javax.naming.InitialContext;

public final class RememberMeLogin {

    boolean remember;
    String username;
    String password;
    String remember1 = "hi";
    String error = "";

    public RememberMeLogin() {
        checkCookie();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
//    if(remember == false){
//      username = "";
//      return username;
//    }
//    else
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
//    if(remember == false){
//      password = "";
//      return password;
//    }
//    else
        return password;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public boolean getRemember() {
        return remember;
    }

    public String CheckLogin() throws NamingException {
//        HttpServletRequest request = null;
        InitialContext ict = new InitialContext();
        TblUserFacadeRemote remote = (TblUserFacadeRemote) ict.lookup("java:global/WebphotoShare/TblUserFacade");
        String s = PasswordUtils.hashPassword(getPassword().trim());
//        String user = request.getParameter("loginname");
//        String pass = request.getParameter("password");
//        setUsername(user);
//        setPassword(pass);
//        String user = getUsername();
//        String pass = getPassword();
        if (remote.login(getUsername().trim(), s) != 0) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("username", getUsername().trim());
            // Save the userid and password in a cookie
            Cookie btuser = new Cookie("btuser", username);
            Cookie btpasswd = new Cookie("btpasswd", password);
            if (remember == false) {
                remember1 = "false";
            } else {
                remember1 = "true";
            }
            Cookie btremember = new Cookie("btremember", remember1);
            btuser.setMaxAge(3600);
            btpasswd.setMaxAge(3600);

            ((HttpServletResponse) facesContext.getExternalContext().getResponse()).
                    addCookie(btuser);
            ((HttpServletResponse) facesContext.getExternalContext().getResponse()).
                    addCookie(btpasswd);
            ((HttpServletResponse) facesContext.getExternalContext().getResponse()).
                    addCookie(btremember);
            return "success";
        } else {
            error = "Login failed, Check User name and password";
            return "failure";
        }
    }

    public void checkCookie() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String cookieName = null;
        Cookie cookie[] = ((HttpServletRequest) facesContext.getExternalContext().
                getRequest())
                .getCookies();
        if (cookie != null && cookie.length > 0) {
            for (Cookie cookie1 : cookie) {
                cookieName = cookie1.getName();
                switch (cookieName) {
                    case "btuser":
                        username = cookie1.getValue();
                        break;
                    case "btpasswd":
                        password = cookie1.getValue();
                        break;
                    case "btremember":
                        remember1 = cookie1.getValue();
                        switch (remember1) {
                            case "false":
                                remember = false;
                                break;
                            case "true":
                                remember = true;
                                break;
                        }
                        break;
                }
            }
        } else {
            System.out.println("Cannot find any cookie");
        }
    }
}
