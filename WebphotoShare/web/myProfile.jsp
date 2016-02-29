
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<link href="style.css" rel="stylesheet" type="text/css" />
<html>
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit  Profile</title>
        <sx:head parseContent="true"/>
    </head>
    <link href="<s:url value="style.css"/>" rel="stylesheet"
          type="text/css"/>
    <%--<s:head theme="ajax" />--%>
    <body>
        <div class="home">
            <jsp:include page="homeHeader.jsp"/>
            <%
                TblUser user = null;
                String iid = session.getAttribute("username").toString().trim();
                //String iid="a";
                InitialContext ict = new InitialContext();
                TblUserFacadeRemote uremote = (TblUserFacadeRemote) ict.lookup("java:global/WebphotoShare/TblUserFacade");
                user = uremote.find(iid);
                String avatar = "";
                if (!"images/no.jpg".equalsIgnoreCase(user.getUserAvatar())) {
//                    avatar = "uploadImages/" + user.getUserAvatar().substring(user.getUserAvatar().lastIndexOf("\\") + 1);
                    avatar = user.getUserAvatar().substring(user.getUserAvatar().lastIndexOf("\\") + 1);
                } else {
                    avatar = "images/no.jpg";
                }
            %>
            <h2 align="center" class="h1"><%= user.getUserID()%>'s Profile</h2>
            <div align="center">
                <table border="0" align="center">
                    <div align="center">
                        <img align="middle" src="uploadImages/<%= avatar%>" width="180" height="180"/></div>
                    <tr>
                        <td>User Name:</td><td><font color="red"><%= user.getUserID()%></font></td>
                    </tr>
                    <tr>
                        <td>Full Name:</td><td><%= user.getUserFullName()%></td>
                    </tr>
                    <tr>
                        <td>Date Registered:</td><td><%= user.getDateRegistration()%></td>
                    </tr>
                    <tr>
                        <td>Birth day:</td><td><%= user.getBirthday()%></td>
                    </tr>
                    <tr>
                        <td>Accessing with IP:</td><td><font color="red"><%= request.getRemoteAddr()%></font></td>
                    </tr>
                </table>
            </div>
            <h2 align="center" class="h1">Edit Profile</h2>
            <div align="center">
                <s:form action="doEditProfile" name="upload" method="POST" enctype="multipart/form-data">
                    <table border="0" align="center">
                        <div align="center"><img align="middle" src="uploadImages/<%= user.getUserAvatar().substring(user.getUserAvatar().lastIndexOf("\\") + 1)%>" width="180" height="180"/></div>
                        <tr>
                            <td>User Name:</td><td><font color="red"><%= user.getUserID()%></font></td>
                        </tr>
                        <tr>
                            <td>Date Registered:</td><td><%= user.getDateRegistration()%></td>
                        </tr>
                        <tr>
                            <td><s:file name="upload" tooltip="browse file to upload" required="true" size="20" label="Select Other Avatar"/></td>
                        </tr>
                        <tr>
                            <td><s:textfield name="fullname" tooltip="Enter FullName" size="20" label="Enter your FullName"/></td>
                        </tr>
                        <tr>
                            <td><sx:datetimepicker name="birthday" label="Birthday"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><s:submit value="Change Profile"/></td>
                        </tr>
                    </table>
                    <s:actionmessage/>
                </s:form>
            </div>
            <jsp:include page="homefooter.jsp"/>
        </div>
    </body>
</html>
