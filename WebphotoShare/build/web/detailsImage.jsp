

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*,log.WriteLog" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Photo Share Pro</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <script type="text/javascript">
        function DeleteYesOrNo() {

            var isDelete = confirm("Are you sure to delete ?");

            if (isDelete) {
                return true;
            } else {
                return false;
            }

        }
        function copyToClipboard(text)
        {
            if (window.clipboardData) // IE
            {
                window.clipboardData.setData("Text", text);
                alert("copy success!");
            }
            else
            {
                unsafeWindow.netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                const clipboardHelper = Components.classes["@mozilla.org/widget/clipboardhelper;1"].getService(Components.interfaces.nsIClipboardHelper);
                clipboardHelper.copyString(text);
                alert("copy success!");
            }
        }

    </script>
    <%
        InitialContext ict = new InitialContext();
        TblImageFacadeRemote iremote = (TblImageFacadeRemote) ict.lookup("java:global/WebphotoShare/TblImageFacade");
        TblCommentFacadeRemote cremote = (TblCommentFacadeRemote) ict.lookup("java:global/WebphotoShare/TblCommentFacade");
        if ((request.getParameter("did") != null) && (session.getAttribute("username") != null)) {
            //TblComment cm=cremote.find(new Integer(request.getParameter("did")));
            //cremote.remove(cm);
            cremote.delCommentByID(Integer.parseInt(request.getParameter("did")));
        }
        if ((request.getParameter("diid") != null) && (session.getAttribute("username") != null)) {
            //TblComment cm=cremote.find(new Integer(request.getParameter("did")));
            //cremote.remove(cm);
            iremote.delImage(Integer.parseInt(request.getParameter("diid")));
    %>
    <jsp:forward page="mypage.jsp"/>
    <%
        }
        //get all comment of picture and share picture
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("iid"));
        } catch (Exception e) {
            WriteLog writelog = new WriteLog();
            writelog.writeLogInfo(e.getMessage());
            writelog.writeLogInfo("IP accessing:" + request.getRemoteAddr() + " URL:" + request.getRequestURI());
    %>
    <jsp:forward page="error.jsp"/>
    <%
        }
        String commentenable = "";
        if (session.getAttribute("username") == null) {
            commentenable = " please login to post your comment.";
        }
        session.setAttribute("imageid", id);
        TblImage image = (TblImage) iremote.find(new Integer(id));
        image.setViewCount(image.getViewCount() + 1);
        iremote.edit(image);
        List<TblComment> clist = (List<TblComment>) cremote.findByImageID(id);
        String url = request.getRequestURL().toString();
        url = url.substring(0, url.lastIndexOf("/") + 1) + "uploadImages/";
        url += image.getImageLocation().substring(image.getImageLocation().lastIndexOf("\\") + 1);
    %>
    <body>
        <div class="home">
            <!--header//////////////////////////////////////////////////////////////////////////////////////-->
            <jsp:include page="homeHeader.jsp" flush="true"/><!--end header-->
            <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
            <div class="primary">
                <div class="primary-2">

                    <div class="Photo-primary-2-left">
                        <p class="p-tis-topvote" id="FQAs-tis"><a href="homepage.jsp"><span class="h1">P</span>hotoshare  </a> >><a href="#">Detail of image <span class="name-photo">"<%= image.getImageName()%>"</span></a></p>
                        <div class="Photo-detail-div-photo2">
                            <div class="Photo-detail-h-div-img2"><img src="uploadImages/<%= image.getImageLocation().substring(image.getImageLocation().lastIndexOf("\\") + 1)%>" width="600" height="400"/></div>
                            <p class="name-photo"><%= image.getImageName()%> Downloads: <%= image.getDownloadCount()%> times, Views <%= image.getViewCount()%> times  <a href="downloadImage.jsp?id=<%= id%>"><img src="images/download.jpg" width="20" height="20"/></a>
                                    <%
                                        if (session.getAttribute("username") != null) {
                                            if ((image.getUserID().getUserID().equalsIgnoreCase(session.getAttribute("username").toString())) || (image.getUserID().getUserID().equalsIgnoreCase(session.getAttribute("username").toString()))) {
                                                out.println("<a href='detailsImage.jsp?diid=" + image.getImageID() + "&iid=" + id + "'><img src='images/delete.jpg' width='20' height='20'/ onclick='return DeleteYesOrNo();'></a>");
                                                out.println("<a href='editpicture.jsp?eid=" + image.getImageID() + "'><img src='images/edit.jpg' width='20' height='20'/></a>");
                                            }
                                        }
                                    %>
                            </p>
                            <p class="name-photo">URL for embed:  <%= url%><input type="button" value="copy" onclick="copyToClipboard(<%= "'" + url + "'"%>);" /></p>
                            <div class="clear"></div>
                        </div>

                        <p class="p-tis-topvote" id="comment-send-tis"><span class="h1">C</span>omments:<%= clist.size() + commentenable%> </p>

                        <%
                            for (TblComment comment : clist) {
                        %>
                        <div class="comment-div-photo">
                            <div class="comment-h-div-img2"><img src="images/comment.jpg" width="50" height="50"/></div>
                            <p >"<%= comment.getCommentTitle()%>" by: <font color="red"><%= comment.getUserID().getUserID()%></font> at <%= comment.getCommentTimeCreate()%> </p>
                            <p ><%= comment.getCommentContent()%></p>
                            <div class="clear"></div>
                            <%
                                if (session.getAttribute("username") != null) {
                                    if ((comment.getUserID().getUserID().equalsIgnoreCase(session.getAttribute("username").toString())) || (image.getUserID().getUserID().equalsIgnoreCase(session.getAttribute("username").toString()))) {
                                        out.println("<p class='comment-p-name' align='right'><a href='detailsImage.jsp?did=" + comment.getCommentID() + "&iid=" + id + "'><img src='images/delete.jpg' width='20' height='20' onclick='return DeleteYesOrNo();'/></a></p>");
                                    }
                                }
                            %>
                            <div class="clear"></div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <div class="clear"></div>
                    <%
                        if (session.getAttribute("username") != null) {
                    %>
                    <jsp:include page="writecomment_s2.jsp" flush="true"/>
                    <%
                        }
                    %>
                    <div class="clear"></div>
                </div><!--end primary-2-left-->
            </div><!--end primary-2-->
            <div class="clear"></div>
        </div><!--end primary-->
        <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
        <jsp:include page="homefooter.jsp" flush="true"/>

        <!--end-->
    </body>
</html>

