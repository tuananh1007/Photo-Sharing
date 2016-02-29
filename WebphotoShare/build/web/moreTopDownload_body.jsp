

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
TblImageFacadeRemote iremote=(TblImageFacadeRemote)ict.lookup("java:global/WebphotoShare/TblImageFacade");
total=iremote.count();
totalpage=(total/7)+1;
range[0]=7*(pages-1);
range[1]=7*(pages);//9;
if(range[1]>total)range[1]=total;
List<TblImage> ilist=iremote.topDownloadPaging(range);
%>
<body>
			 <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
			 	<div class="primary">
                        <div class="primary-2">
                        		<div class="photo-primary-2-left">
                                            <p class="p-tis-topvote" id="photo-tis"><a href="homepage.jsp"><span class="h1">P</span>hotoshare  </a>>> <a href="#">Top Images downloads</a></p>
                                                        <%
                                                        if((ilist==null)||(ilist.size()==0)) out.println("<h3 class='h'>Not found any Image...</h3>");
                                                        else
                                                            {
                                                                int i=0;
                                                            out.println("<p class='p-tis-topvote' id='photo-tis' style='margin-top:20px; font-family:System; font-size:12px; color:#999999;'>Found total:<font color='red'>"+total+ " </font>images</p>");
                                                            for(TblImage image:ilist)
                                                            {
                                                             %>
                                                            <div class="photo-div-photo2">
                                                                <div class="photo-h-div-img2"><a href="detailsImage.jsp?iid=<%= image.getImageID() %>" class="a-img"><img src="uploadImages/<%= image.getImageLocation().substring(image.getImageLocation().lastIndexOf("\\")+1) %>" width="106" height="100"/></a></div>
                                                                <p class="photo-p-namephoto2"><font color="red"><%= StringUtils.getSubTilte(image.getImageName(),10)%></font><br>Upload by<br> <font color="green"><%= image.getUserID().getUserID()%></font><br> Downloads: <font color="red"><%= image.getDownloadCount() %> times</font></p>
                                                            <div class="vote"> <img src="images/sao.png" width="15" height="15"/><img src="images/sao.png"  width="15" height="15"/><img src="images/sao.png"  width="15" height="15"/><img src="images/sao2.png"  width="15" height="15"/><img src="images/sao2.png"  width="15" height="15"/></div>
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
                                    <a href="moreTopDownload.jsp?pages=<%= i+1%>"><%= i+1%></a>
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
