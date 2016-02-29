

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="/WebphotoShare/style.css" rel="stylesheet" type="text/css" />
        <LINK REL="SHORTCUT ICON" HREF="/WebphotoShare/images/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management System</title>
    </head>
<body>
	         <div class="home">
			 <!--header//////////////////////////////////////////////////////////////////////////////////////-->
                         <jsp:include page="adminHeader.jsp" flush="true"/>
                         <c:if test="${sessionScope['admin']!=null}">
                         <jsp:include page="userManagement_body.jsp" flush=""/>
                         </c:if>
                         <c:if test="${sessionScope['admin']==null}">
                             <jsp:include page="login_body.jsp"/>
                         </c:if>
                         <jsp:include page="adminFooter.jsp" flush="true"/>
                 </div>
    </body>
</html>
