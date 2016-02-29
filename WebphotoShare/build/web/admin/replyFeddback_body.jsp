

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*,java.util.Date" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
int[] range=new int[2];
int total=0;
int pages=1;
int totalpage=1;
if(request.getParameter("pages")!=null)
try{
pages=Integer.parseInt(request.getParameter("pages").toString());
}catch(Exception e)
{
%>
<jsp:forward page="error.jsp" />
<%
}

String enable="";
String qcontent="";
if(session.getAttribute("admin")==null)
{
       enable="disabled='true'";
}
InitialContext ict=new InitialContext();
TblQueryFacadeRemote fremote=(TblQueryFacadeRemote)ict.lookup("java:global/WebphotoShare/TblQueryFacade");
total=fremote.countQueryUnAnswer();
totalpage=(total/6)+1;
range[0]=6*(pages-1);
range[1]=6*(pages);//9;
if(range[1]>total)range[1]=total;

List<TblQuery> qlist=(List<TblQuery>)fremote.getQueryUnAnswer(range);
if(request.getParameter("qid")!=null){
       TblQuery query=fremote.find(new Integer(request.getParameter("qid")));
       qcontent=query.getQueryContent();
       if((request.getParameter("content")!=null)){
           StringBuilder builder=new StringBuilder();
           builder.append("Asked:");
           builder.append(query.getQueryContent());
           builder.append("\r\nAnswer:");
           builder.append(request.getParameter("content"));
       SendMailUtils.send("smtp.gmail.com",query.getUserID().getEmail(), "photosharepro@gmail.com", "projectsem4", "Reply query from PhotoShare Pro", new String(builder));
       query.setDateAnswer(new Date());
       query.setQueryAnswer(request.getParameter("content"));
       fremote.edit(query);
       }
}
%>
 	<div class="primary">
                        <div class="primary-2">
                        		<div class="FQAs-primary-2-left">
                                            <p class="p-tis-topvote" id="FQAs-tis"><a href="adminHome.jsp"><span class="h1">P</span>hotoshare Admin  </a>>> <a href="#">Reply Query</a></p>
                                            <div class="photo-page" align="center">
                                <a href="#"> < </a>
                                    <%
                                    for(int i=0;i<totalpage;i++)
                                        {
                                    %>
                                    <a href="replyFeedback.jsp?pages=<%= i+1%>"><%= i+1%></a>
                                        <%
                                        }
                                    %>
                                    <a href="#">></a>
                                </div>
                                            <div class="clear"></div>
                                                                    <%
                                                                    for(int i=0;i<=qlist.size()/2-1;i++)
                                                                        {
                                                                    %>
                                            <div class="FQAs-div-photo2">

                                        	<div class="FQAs-h-div-img2"><img src="../images/ask.jpg" width="35" height="35"/></div>
                                                <p class="FQAs-p-name"> <a href="replyFeedback.jsp?pages=<%= pages %>&qid=<%= qlist.get(2*i).getQueryID() %>"><%= StringUtils.getSubTilte(qlist.get(2*i).getQueryContent(),35) %></a></p>
                                        </div>
                                        <div class="FQAs-div-photo2">

                                            <div class="FQAs-h-div-img2"><img src="../images/ask.jpg" width="35" height="35"/></div>
                                            <p class="FQAs-p-name"><a href="replyFeedback.jsp?pages=<%= pages %>&qid=<%= qlist.get(2*i+1).getQueryID() %>"><%= StringUtils.getSubTilte(qlist.get(2*i+1).getQueryContent(),35) %></a></p>

                                        </div>
                                            <div class="clear"></div>
                                        <%
                                        }
                                        if((qlist.size()%2)!=0)
                                            {
                                        %>
                                        <div class="FQAs-div-photo2">
                                       	<div class="FQAs-h-div-img2"><img src="../images/ask.jpg" width="35" height="35"/></div>
                                                <p class="FQAs-p-name"> <a href="replyFeedback.jsp?pages=<%= pages %>&qid=<%= qlist.get(qlist.size()-1).getQueryID() %>"><%= StringUtils.getSubTilte(qlist.get(qlist.size()-1).getQueryContent(),35) %></a></p>
                                        </div>
                                        <%}%>

                                         <div class="clear"></div>
                                <div class="photo-page" >
                                <a href="#"> < </a>
                                    <%
                                    for(int i=0;i<totalpage;i++)
                                        {
                                    %>
                                    <a href="replyFeedback.jsp?pages=<%= i+1%>"><%= i+1%></a>
                                        <%
                                        }
                                    %>
                                    <a href="#">></a>
                                </div>
                                        </div>
</div>
                                 <div class="clear"></div>
<div class="FQAs-send">
    <form action="" method="post" name="frm"/>
    <p class="FQAs-detail-p-content"><h4 class="h1">Query Content:</h4><%= qcontent %></p>
   <div class="clear"></div>
   <div class="div-mail-content"><h4 class="h1">Content Reply:</h4> <textarea id="fqas-send-content" name="content" <%= enable %>></textarea> </div>
   <div class="div-link-fqa"><input type="submit" <%= enable %> id="send" value="Send"/><input type="reset" id="reset" value="Reset"/></div>
    </form>
</div>
<div class="clear"></div>
