
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<LINK REL="SHORTCUT ICON" HREF="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Photo Share</title>
<link href="style.css" rel="stylesheet" type="text/css" />

</head>
<body>
	         <div class="home">
<jsp:include page="homeHeader.jsp" flush="true"/>
<jsp:include page="registration_body.jsp" flush="true"/>
<jsp:include page="homefooter.jsp" flush="true"/>
			</div><!--end-->
</body>
</html>