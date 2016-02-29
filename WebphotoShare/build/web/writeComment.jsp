
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
<p class="p-tis-topvote" id="FQAs-send-tis"><span class="h1">S</span>end new Comment!</p>

<div class="FQAs-send">
    <form action="comment" method="post" name="frm"/>
    <div class="div-mail-fqas"><p> Subject:</p> <input type="text" name="title" id="fqas-mail" <%= enable %> value="<%= status %>"/></div>
   <div class="clear"></div>
   <div class="div-mail-content"><p>Content:</p> <textarea id="fqas-send-content" name="content"  <%= enable %>></textarea> </div>
   <div class="div-link-fqa"><input type="submit" <%= enable %> id="send" value="Send"/><input type="reset" id="reset" value="Reset"/></div>
    </form>
</div>
<div class="clear"></div>
