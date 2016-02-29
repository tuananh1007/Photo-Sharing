

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*,log.WriteLog" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/favicon.ico"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Ask and Answer center</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <%
        int[] range = new int[2];
        int total = 0;
        int pages = 1;
        int totalpage = 1;
        if (request.getParameter("pages") != null)
            try {
                pages = Integer.parseInt(request.getParameter("pages").toString());
            } catch (Exception e) {
                WriteLog writelog = new WriteLog();
                writelog.writeLogInfo(e.getMessage());
                writelog.writeLogInfo("IP accessing:" + request.getRemoteAddr() + " URL:" + request.getRequestURI());
    %>
    <jsp:forward page="error.jsp" />
    <%
            }
        InitialContext ict = new InitialContext();
        TblFAQFacadeRemote fremote = (TblFAQFacadeRemote) ict.lookup("java:global/WebphotoShare/TblFAQFacade");

        total = fremote.count();
        totalpage = (total / 6) + 1;
        range[0] = 6 * (pages - 1);
        range[1] = 6 * (pages);//9;
        if (range[1] > total) {
            range[1] = total;
        }

        List<TblFAQ> flist = fremote.findRange(range);
    %>
    <body>
        <div class="home">
            <!--header//////////////////////////////////////////////////////////////////////////////////////-->
            <jsp:include page="homeHeader.jsp" flush="true"/>
            <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
            <div class="primary">
                <div class="primary-2">
                    <div class="FQAs-primary-2-left">
                        <p class="p-tis-topvote" id="FQAs-tis"><a href="homepage.jsp"><span class="h1">P</span>hotoshare  </a>>> <a href="#">FQAs</a></p>
                        <div class="clear"></div>
                        <%
                            for (int i = 0; i <= flist.size() / 2 - 1; i++) {
                        %>
                        <div class="FQAs-div-photo2">

                            <div class="FQAs-h-div-img2"><img src="images/ask.jpg" width="50" height="50"/></div>
                            <p class="FQAs-p-name"> <a href="FQAsDetails.jsp?fid=<%= flist.get(2 * i).getFaqid()%>"><%= flist.get(2 * i).getFAQQuestion()%></a></p>
                        </div>
                        <div class="FQAs-div-photo2">

                            <div class="FQAs-h-div-img2"><img src="images/ask.jpg" width="50" height="50"/></div>
                            <p class="FQAs-p-name"><a href="FQAsDetails.jsp?fid=<%= flist.get(2 * i + 1).getFaqid()%>"><%= flist.get(2 * i + 1).getFAQQuestion()%></a></p>

                        </div>
                        <%
                            }
                            if ((flist.size() % 2) != 0) {
                        %>
                        <div class="FQAs-div-photo2">
                            <div class="FQAs-h-div-img2"><img src="images/ask.jpg" width="50" height="50"/></div>
                            <p class="FQAs-p-name"> <a href="FQAsDetails.jsp?fid=<%= flist.get(flist.size() - 1).getFaqid()%>"><%= flist.get(flist.size() - 1).getFAQQuestion()%></a></p>
                        </div>
                        <%}%>
                    </div>
                    <div class="clear"></div>
                    <div class="photo-page">
                        <a href="#"> < </a>
                        <%
                            for (int i = 0; i < totalpage; i++) {
                        %>
                        <a href="FQAs.jsp?pages=<%= i + 1%>"><%= i + 1%></a>
                        <%
                            }
                        %>
                        <a href="#">></a>
                    </div>
                    <%--<c:if test="${sessionScope['username']!=null}">--%>
                        <jsp:include page="writequery_s2.jsp" flush="true"/>
                    <%--</c:if>--%>

                </div><!--end primary-2-left-->
            </div><!--end primary-2-->
            <div class="clear"></div>
        </div><!--end primary-->
        <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
        <jsp:include page="homefooter.jsp" flush="true"/>
    </body>
</html>
