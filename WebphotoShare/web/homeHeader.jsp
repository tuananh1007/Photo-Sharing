

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
if(request.getParameter("action")!=null)
    {
if("logout".equalsIgnoreCase(request.getParameter("action").toString()))
    session.setAttribute("username", null);
}
String name="";
if(session.getAttribute("username")!=null) name=session.getAttribute("username").toString();
%>
			 	<div class="header">
                	<div class="header2">
                            <div class="div-logo"><a href="homepage.jsp"></a></div>
                            <div class="div-loginInfo"><p class="welcome-user">Welcome to Photoshare <font color="red"> <%= name%></font></p><c:if test="${sessionScope['username']!=null}"><a href="homepage.jsp?action=logout" class="signout" >Sign Out</a></c:if></div>
                        <div class="div-headerbar">
                        	<ul>
                                        <%
                                        if(session.getAttribute("username")==null){
                                        %>
                        		<li><a href="/WebphotoShare/faces/login.jsp">Sign In</a></li>
                                        <li><a href="/WebphotoShare/registration.jsp">Sign Up</a></li>
                                        <%
                                        }
                                        else{
                                            out.println("<li><a href='/WebphotoShare/myProfile.jsp'>My Profile</a></li>");
                                            out.println("<li><a href='/WebphotoShare/changePassword.jsp'>Change Password</a></li>");
                                            }
                                        %>
                                        <!--li><a href="sitemap.jsp">Site Map</a></li-->
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
                                    <li><a href="homepage.jsp">Home</a></li>
                                    <li><a href="/WebphotoShare/faces/mypage.jsp">My Photos</a></li>
                                <!--li><a href="#">Feedback</a></li-->
                                <li><a href="FQAs.jsp">FQAs</a></li>
                                <li><a href="about.jsp">About Site</a></li>
                                <li><a href="sitemap.jsp">Site map</a></li>
                        	</ul>
                        </div>
                    </div><!--end header2-->
                                </div>