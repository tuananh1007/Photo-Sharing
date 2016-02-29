<%--
    Document   : writeComment
    Created on : 05-10-2010, 22:20:45
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="../style.css" rel="stylesheet" type="text/css" />
   <div class="clear"></div>
<%
String question=request.getParameter("question");
String answer=request.getParameter("answer");
if((question!=null)||(answer!=null)){
    if((question.length()<10)||(answer.length()<10)){
    out.println("<h2 align='center'><font color='red'>Enter Data atless 10 characters</font></h2>");
    }
    else{
    InitialContext ict=new InitialContext();
    TblFAQFacadeRemote fremote=(TblFAQFacadeRemote)ict.lookup("java:global/WebphotoShare/TblFAQFacade!bean.session.TblFAQFacadeRemote");
    TblFAQ fqa=new TblFAQ();
    fqa.setFAQQuestion(question);
    fqa.setFAQAnswer(answer);
    fremote.create(fqa);
    out.println("<h2 align='center'><font color='blue'>Add answer and question success !</font></h2>");
    }
}
%>
   <div class="clear"></div>
   <p class="p-tis-topvote" id="FQAs-send-tis" align="center"><span class="h1">A</span>dd new FQAs!</p>
<div class="FQAs-send">
    <form action="" method="post" name="frm"/>
    <div class="div-mail-fqas"><p> Question:</p> <input type="text" name="question" id="fqas-mail" /></div>
   <div class="clear"></div>
   <div class="div-mail-content"><p>Answer:</p> <textarea id="fqas-send-content" name="answer" ></textarea> </div>
   <div class="div-link-fqa"><input type="submit" id="send" value="Send"/><input type="reset" id="reset" value="Reset"/></div>
    </form>
</div>
<div class="clear"></div>
