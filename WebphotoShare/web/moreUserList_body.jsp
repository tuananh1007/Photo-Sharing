

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*,log.WriteLog" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />

</head>
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
WriteLog writelog=new WriteLog();
writelog.writeLogInfo(e.getMessage());
writelog.writeLogInfo("IP accessing:"+request.getRemoteAddr()+" URL:"+request.getRequestURI());
}
InitialContext ict=new InitialContext();
TblUserFacadeRemote uremote=(TblUserFacadeRemote)ict.lookup("java:global/WebphotoShare/TblUserFacade");

total=uremote.countValidatedUser();
totalpage=(total/7)+1;
range[0]=7*(pages-1);
range[1]=7*(pages);//9;
if(range[1]>total)range[1]=total;
List<TblUser> luser=(List<TblUser>)uremote.listNewUserPaging(range);
%>
<body>
			 <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
			 	<div class="primary">
                        <div class="primary-2">
                        		<div class="photo-primary-2-left">
                                            <p class="p-tis-topvote" id="photo-tis"><a href="homepage.jsp"><span class="h1">P</span>hotoshare  </a>>> <a href="#">Website Members</a></p>
                                                        <%
                                                        if((luser==null)||(luser.size()==0)) out.println("<h3 class='h'>Not found any User...</h3>");
                                                        else
                                                            {
                                                            out.println("<p class='p-tis-topvote' id='photo-tis' style='margin-top:20px; font-family:System; font-size:12px; color:#999999;'>Website has total: <font color='red'>"+total+ " </font> active User.</p>");
                                                            for(TblUser user:luser)
                                                            {
                                                                String avatar="";
                                                                if(!"images/no.jpg".equalsIgnoreCase(user.getUserAvatar())){
                                                                    try{
                                                                avatar="uploadImages/"+ user.getUserAvatar().substring(user.getUserAvatar().lastIndexOf("\\")+1);
                                                                }catch(Exception e )
                                                                        {
                                                                avatar="images/no.jpg";
                                                                }
                                                                }
                                                                else
                                                                    avatar="images/no.jpg";
                                                             %>
                                                            <div class="photo-div-photo2">
                                                                <div class="photo-h-div-img2"><a href="profile.jsp?iid=<%= user.getUserID() %>" class="a-img"><img src="<%= avatar %>" width="106" height="100"/></a></div>
                                                                <p class="photo-p-namephoto2"><font color="red"><%= StringUtils.getSubTilte(user.getUserID(),10)%></font><br></p>
                                                                <p align="center">Registered at: <%= user.getDateRegistration() %></p>
                                                            </div>
                                                            <%}
                                                              }%>
                                                    <div class="clear"></div>
                                </div>
                                <div class="clear"></div>
                                <div class="photo-page">
                                    <a href="#"> < </a>
                                    <%
                                    for(int i=0;i<totalpage;i++)
                                        {
                                    %>
                                    <a href="moreUserList.jsp?pages=<%= i+1%>"><%= i+1%></a>
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
