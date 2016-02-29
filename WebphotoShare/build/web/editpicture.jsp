

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@taglib  prefix="s" uri="/struts-tags" %>
<head>
<LINK REL="SHORTCUT ICON" HREF="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome to Photo Share</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<link href="fancybox/jquery.fancybox-1.3.1.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="fancybox/jquery.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox-1.3.1.js"></script>
<script type="text/javascript" src="fancybox/jquery.easing-1.3.pack.js"></script>
<script language="javascript" type="text/javascript">
$(function(){
				$('.a-img').fancybox({
				'width'				: '75%',
				'height'			: '75%',
				'autoScale'			: false,
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'type'				: 'image'
				}
				);
			});
</script>
</head>
<body>
	         <div class="home">
<jsp:include page="homeHeader.jsp" flush="true"/>
<p class="p-tis-topvote" id="photo-tis" align="center"><a href="homepage.jsp"><span class="h1">P</span>hotoshare  </a>>> <a href="#">Edit Photos</a></p>
<%
TblImage img=null;
if(session.getAttribute("username")==null){
    out.println("<br><font color='red'><h4 align='center'>Please Login To Visite Your Personal Page</h4></font><br>");
    %>
    <jsp:include page="login_body.jsp" flush="false"/>
    <%
    }
String eid="";
if(session.getAttribute("eid")!=null) eid=session.getAttribute("eid").toString();
if(request.getParameter("eid")!=null){
    eid=request.getParameter("eid");
    session.setAttribute("eid",eid );
    InitialContext ict=new InitialContext();
    TblImageFacadeRemote iremote=(TblImageFacadeRemote)ict.lookup("java:global/WebphotoShare/TblImageFacade");
    img=iremote.find(new Integer(eid));
    %>
    <div class="Photo-detail-div-photo2">
        <div class="Photo-detail-h-div-img2"><img src="uploadImages/<%= img.getImageLocation().substring(img.getImageLocation().lastIndexOf("\\")+1) %>" width="600" height="400"/></div>
    </div
<%
}
%>
<div align="center">
<font color='red'><s:actionerror  /></font>
<s:fielderror />
<s:form action="doEdit" name="upload" method="POST" enctype="multipart/form-data">
<tr>
    <td colspan="2"><h2 align="center">Upload new Image File</h2></td>
</tr>
<s:file name="upload" label="Browse new file to upload" tooltip="Browse new file to upload" required="true" size="55"/>
<s:textfield name="fileCaption" label="New caption" required="true" maxLength="50" tooltip="Enter File Name" size="55"/>
<s:submit />
</s:form>
</div>
<jsp:include page="homefooter.jsp" flush="true"/>
			</div><!--end-->
</body>
</html>