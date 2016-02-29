

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="/WebphotoShare/style.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript">
            function DeleteYesOrNo() {

                var isDelete = confirm("Are you sure to delete ?");

                if (isDelete) {
                    return true;
                } else {
                    return false;
                }

            }
        </script>
    </head>
    <%
        int[] range = new int[2];
        int total = 0;
        int pages = 1;
        int totalpage = 1;
        if (request.getParameter("pages") != null) {
            pages = Integer.parseInt(request.getParameter("pages").toString());
        }
        InitialContext ict = new InitialContext();
        TblUserFacadeRemote uremote = (TblUserFacadeRemote) ict.lookup("java:global/WebphotoShare/TblUserFacade");
        if (request.getParameter("did") != null) {
            TblUser usertoDel = uremote.find(request.getParameter("did"));
            SendMailUtils.send("smtp.gmail.com", usertoDel.getEmail(), "photosharepro@gmail.com", "projectsem4", "PhotoSharePro", "Your Account Register in PhotosharePro.com Denied !");
            uremote.delUser(request.getParameter("did"));
        }
        total = uremote.count() - uremote.countValidatedUser();
        totalpage = (total / 7) + 1;
        range[0] = 7 * (pages - 1);
        range[1] = 7 * (pages);//9;
        if (range[1] > total) {
            range[1] = total;
        }
        List<TblUser> luser = (List<TblUser>) uremote.listUserNotApproved(range);
    //approve User
        String[] select = request.getParameterValues("ckb");
        if (select != null) {
            for (String s : select) {
                TblUser us = new TblUser();
                us = uremote.find(s);
                us.setIsApproved(true);
                String pass = PasswordUtils.getPassword(8);
                us.setPassWord(PasswordUtils.hashPassword(pass));
                //send mail
                try {
                    String smtpServer = "smtp.gmail.com";
                    String to = us.getEmail();
                    String from = "photosharepro@gmail.com";
                    String subject = "Password from WebPhotoShare";
                    String body = "Your Account approved. "
                            + "Your pass word is :" + pass
                            + " please login http://products.no-ip.org:8080/WebphotoShare/faces/login.jsp with your user name:" + us.getUserID() + " and password:" + pass;
                    String password = "projectsem4";
                    SendMailUtils.send(smtpServer, to, from, password, subject, body);
                } catch (Exception ex) {
                    System.out.println("Usage: " + ex.getMessage());
                }
                //
                uremote.edit(us);
            }
        }
    %>
    <body>
        <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
        <div class="primary">
            <div class="primary-2">
                <div class="photo-primary-2-left">
                    <p class="p-tis-topvote" id="photo-tis"><a href="adminHome.jsp"><span class="h1">A</span>dmin Panel  </a>>> <a href="userManagement.jsp">User Management</a></p>
                    <div class="clear"></div>
                    <div class="photo-page">
                        <a href="#"> < </a>
                        <%
                            for (int i = 0; i < totalpage; i++) {
                        %>
                        <a href="userManagement.jsp?pages=<%= i + 1%>"><%= i + 1%></a>
                        <%
                            }
                        %>
                        <a href="#">></a>
                    </div>
                    <form action="" method="post">
                        <%
                            if ((luser == null) || (luser.size() == 0))
                                out.println("<h3 class='h'>Not found any User...</h3>");
                            else {
                                int i = 0;
                                out.println("<p class='p-tis-topvote' id='photo-tis' style='margin-top:20px; font-family:System; font-size:12px; color:#999999;'>Website has total: <font color='red'>" + total + " </font> User waiting for approve.</p>");
                                for (TblUser user : luser) {
                        %>
                        <div class="comment-div-photo">
                            <div class="comment-h-div-img2"><img src="../<%= user.getUserAvatar()%>" width="50" height="50"/></div>
                            <p class="comment-p-name">"<%= user.getUserID()%>" Birthday: <font color="red"><%= user.getDateRegistration()%></font> </p>
                            <p class="comment-p-name"><font color="blue">Registered at: </font><%= user.getBirthday()%> with email: <%= user.getEmail()%><font color="red"> (this email userd:<%= uremote.countAccountByEmail(user.getEmail())%> times)</font></p>
                            <div class="clear"></div>
                            <div class="clear"></div><hr/>
                            <p>Approve them:    <input type="checkbox" name="ckb" value="<%= user.getUserID()%>"/> </p>
                            <p>Delete Account:<a href="userManagement.jsp?did=<%= user.getUserID()%>"><img src='../images/delete.jpg' width='20' height='20' onclick="return DeleteYesOrNo();"/></a></p>
                        </div>
                        <%}
                                                                }%>
                        <div class="clear"></div>
                </div>
                <div class="clear"></div>
                <input type="submit" value="Save"/>
                </form>
                <div class="photo-page">
                    <a href="#"> < </a>
                    <%
                        for (int i = 0; i < totalpage; i++) {
                    %>
                    <a href="userManagement.jsp?pages=<%= i + 1%>"><%= i + 1%></a>
                    <%
                        }
                    %>
                    <a href="#">></a>
                </div>
                <div class="clear"></div>
            </div><!--end primary-2-left-->
        </div><!--end primary-2-->
        <div class="clear"></div>
    </body>
</html>
