
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link href="../style.css" rel="stylesheet" type="text/css" />
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
if(request.getParameter("action")!=null)
    {
if("logout".equalsIgnoreCase(request.getParameter("action").toString()))
    session.setAttribute("admin", null);
}
String name="";
if(session.getAttribute("admin")!=null) name=session.getAttribute("admin").toString();
%>
			 	<div class="header">
                	<div class="header-admin">
                            <div class="header2">
                            <div class="div-logo"><a href="../homepage.jsp"></a></div>
                            <div class="div-loginInfo"><p class="welcome-user">Welcome to Photoshare <font color="red"> <%= name%></font></p><c:if test="${sessionScope['admin']!=null}"><a href="adminHome.jsp?action=logout" class="signout" >Sign Out</a></c:if></div>
                        <div class="div-headerbar">
                        	<ul>
                                        <%
                                        if(session.getAttribute("admin")==null)
                                            {
                                        %>
                                        <li><a href="../admin/login.jsp">Sign In</a></li>
                                        <%
                                        }
                                        %>
                                </ul>
                        	</div>
                            <div class="div-search">
                                <form id="frm" name="frm" action="search.jsp" method="post">
                                <input type="text" name="keyword" value="Enter keyword for search..."  onclick="this.value='';" class="txt" maxlength="30"/>
                            <input type="submit" id="sb-search" value="">
                            </form>
                            </div>
                        <div class="clear"></div>
                        <div class="div-nav" align="center">
                        	<ul>
                                    <li><a href="adminHome.jsp">Home</a></li>
                                    <li><a href="../admin/userManagement.jsp">User </a></li>
                                <!--li><a href="#">Feedback</a></li-->
                                <li><a href="adminHome.jsp">Images management</a></li>
                                <li><a href="FQAs.jsp">Add FQAs </a></li>
                                <li><a href="replyFeedback.jsp">Reply Feedback</a></li>
                        	</ul>
                        </div>
                    </div><!--end header2-->
                                </div>
                                </div>