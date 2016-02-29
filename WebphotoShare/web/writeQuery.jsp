

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String status="";
String enable="";
if(session.getAttribute("username")==null)
{
       status="You must login befor send your ideas.";
       enable="disabled='true'";
}
%>
<p class="p-tis-topvote" id="FQAs-send-tis"><span class="h1">S</span>end new Query for site administrator!</p>
<c:if test="${requestScope['status']!=null}">
    <br>
    <p class="p-tis-topvote" align="center"><font color="red">${requestScope['status']}</font></p>
</c:if>
<div class="FQAs-send">
    <form action="query" method="post" name="frm"/>
   <div class="div-mail-content"><p>Your Question:</p> <textarea id="fqas-send-content" name="content" <%= enable %>><%= status %></textarea> </div>
   <div class="div-link-fqa"><input type="submit" <%= enable %> id="send" value="Send"/><input type="reset" id="reset" value="Reset"/></div>
    </form>
</div>
<div class="clear"></div>
