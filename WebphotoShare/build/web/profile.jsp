

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<link href="style.css" rel="stylesheet" type="text/css" />
<html>
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <div class="home">
        <jsp:include page="homeHeader.jsp"/>
<%
String iid=request.getParameter("iid");
if(iid!=null){
InitialContext ict=new InitialContext();
TblUserFacadeRemote uremote=(TblUserFacadeRemote)ict.lookup("java:global/WebphotoShare/TblUserFacade");
TblUser user=uremote.find(iid);
String avatar="";
if(!"images/no.jpg".equalsIgnoreCase(user.getUserAvatar())){
avatar="uploadImages/"+ user.getUserAvatar().substring(user.getUserAvatar().lastIndexOf("\\")+1);
}
else
    avatar="images/no.jpg";
%>
<h2 align="center" class="h1">User Profile</h2>
<div align="center"><img align="middle" src="<%= avatar %>" width="100" height="150"/></div>
<p align="center">Avatar</p>
<br/>
<p align="center">User Name:<%= user.getUserID() %></p>
<p align="center">Full Name:<%= user.getUserFullName() %></p>
<p align="center">Date Registered:<%= user.getDateRegistration() %></p>
<p align="center">Birth day:<%= user.getBirthday() %></p>
<%
}
%>
        <jsp:include page="homefooter.jsp"/>
        </div>
    </body>
</html>
