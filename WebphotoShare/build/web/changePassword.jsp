

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<link href="style.css" rel="stylesheet" type="text/css" />
<html>
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
<link href="<s:url value="style.css"/>" rel="stylesheet"
type="text/css"/>
<%--<s:head theme="ajax" />--%>
    <body>
        <div class="home">
        <jsp:include page="homeHeader.jsp"/>

<h2 align="center" class="h1">Change your Password</h2>
<div align="center">
<s:form action="changePassword" name="frm" method="POST" >
<table border="0" align="center">
<tr>
    <td><s:password label="Old Password" name="oldpassword" tooltip="Type Old Password"/></td>
</tr>
<tr>
    <td><s:password label="New Password" name="newpassword" tooltip="Type new Password"/></td>
</tr>
<tr>
    <td><s:password label="Retype New Password" name="renewpassword" tooltip="Retype new Password"/></td>
</tr>
<tr>
    <td colspan="2" align="center"><s:submit value="Change Password"/></td>
</tr>
</table>
    <s:actionerror/>
    <s:actionmessage/>
</s:form>
</div>
        <jsp:include page="homefooter.jsp"/>
        </div>
    </body>
</html>
