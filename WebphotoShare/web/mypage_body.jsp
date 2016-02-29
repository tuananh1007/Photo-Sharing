

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*,log.WriteLog" %>
<html>
<%
if(session.getAttribute("username")==null)
    {
    out.println("<br><font color='red'><h4 align='center'>Please Login To Visite Your Personal Page</h4></font><br>");
    %>
    <jsp:include page="login_body.jsp" flush="false"/>
    <%
    }
else
    {
String username=session.getAttribute("username").toString();
int pages=1;
int totalpage=1;
int total=0;
int totaluploaded=0;
int[] range=new int[2];
if(request.getParameter("pages")!=null)
    try{
    pages=Integer.parseInt(request.getParameter("pages"));
    }catch(Exception e)
        {
    WriteLog writelog=new WriteLog();
    writelog.writeLogInfo(e.getMessage());
    writelog.writeLogInfo("IP accessing:"+request.getRemoteAddr()+" URL:"+request.getRequestURI());
    }
InitialContext ict=new InitialContext();
TblImageFacadeRemote iremote=(TblImageFacadeRemote)ict.lookup("java:global/WebphotoShare/TblImageFacade");
//String user=session.getAttribute("username").toString();
//List<TblImage> ilist=(List<TblImage>)iremote.findImageByUserID(user);
total=iremote.countByUsername(username);
totaluploaded=total;
totalpage=(total/7)+1;
range[0]=(pages-1)*7;
range[1]=pages*7;
if(range[1]>total)
    range[1]=total;
List<TblImage> ilist=(List<TblImage>)iremote.findByUserID_Pagination(username, range);
%>
<body>
			 <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
			 	<div class="primary">
                        <div class="primary-2">
                        		<div class="photo-primary-2-left">
                                            <p class="p-tis-topvote" id="photo-tis"><a href="homepage.jsp"><span class="h1">P</span>hotoshare  </a>>> <a href="#">Photos</a></p>
                                            <div class='clear'></div>
                                                        <%
                                                        if((ilist==null)||(ilist.size()==0)) {
                                                            out.println("<h3 class='h'>You have No Image...</h3>");
                                                            %>
                                                         <div align="center"><jsp:include page="uploadfile.jsp" flush="true"/></div>
                                                            <%
                                                            }
                                                        else{
                                                            out.println("Total Images Uploaded:<font color='red'>"+totaluploaded+ " </font>images, remain <font color='red'>"+(35-totaluploaded)+ " </font>number of <a href='FQAs.jsp'>images for upload!</a><div class='clear'></div>");
                                                            for(TblImage image:ilist)
                                                            {
                                                        %>
                                                            <div class="photo-div-photo2">
                                                                <div class="photo-h-div-img2"><a href="detailsImage.jsp?iid=<%= image.getImageID() %>" class="a-img"><img src="uploadImages/<%= image.getImageLocation().substring(image.getImageLocation().lastIndexOf("\\")+1) %>" width="106" height="100"/></a></div>
                                                                <p class="photo-p-namephoto2"><%= StringUtils.getSubTilte(image.getImageName(),11) %> Downloads: <font color="red"><%= image.getDownloadCount() %> times</font> </p>
                                                            <div class="vote"> <img src="images/sao.png" width="15" height="15"/><img src="images/sao.png"  width="15" height="15"/><img src="images/sao.png"  width="15" height="15"/><img src="images/sao2.png"  width="15" height="15"/><img src="images/sao2.png"  width="15" height="15"/></div>
                                                            </div>
                                                            <%}
                                                           if((total<35)){
                                                            %>
                                                            <div class='clear'></div>
                                                            <div align="center"><jsp:include page="uploadfile.jsp" flush="true"/></div>
                                                            <%
                                                            }
                                                            else
                                                                out.println("<font color='red'>Normal account limit upload 35 pictures, to has no limit please become professional member with 500$</font>");
                                                              }
                                                            %>
                                                          
                                                            
                                </div>
                                <div class='clear'></div>
                                <div class="photo-page">
                                    <a href="#"> < </a>
                                    <%for(int i=0;i<totalpage;i++){%>
                                    <a href="mypage.jsp?pages=<%= i+1%>"><%= i+1%></a>
                                    <%}%>
                                    <a href="#">></a>
                                </div>
                                 <div class="clear"></div>
                            	</div><!--end primary-2-left-->
                        </div><!--end primary-2-->
                        <div class="clear"></div>
</body>
                                       <%}%>
</html>
