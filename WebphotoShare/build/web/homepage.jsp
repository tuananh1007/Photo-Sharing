<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <LINK REL="SHORTCUT ICON" HREF="images/favicon.ico"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Welcome to Photo Share</title>
        <link href="style.css" rel="stylesheet" type="text/css" />

    </head>
    <%
        System.out.println("IP accessing:" + request.getRemoteAddr());
        //users
        InitialContext ict = new InitialContext();
        TblUserFacadeRemote uremote = (TblUserFacadeRemote) ict.lookup("java:global/WebphotoShare/TblUserFacade");
        InitialContext ict1 = new InitialContext();
        //images
        TblImageFacadeRemote iremote = (TblImageFacadeRemote) ict1.lookup("java:global/WebphotoShare/TblImageFacade");
        int[] range = new int[2];
        range[0] = 0;
        range[1] = 3;
        List<TblImage> ilist = (List<TblImage>) iremote.topNewPaging(range);
        List<TblImage> allImage = (List<TblImage>) iremote.findAll();
        List<TblUser> luser = uremote.listNewUser();
        int total = uremote.countValidatedUser();
        //fqas
        TblFAQFacadeRemote fremote = (TblFAQFacadeRemote) ict.lookup("java:global/WebphotoShare/TblFAQFacade");
        List<TblFAQ> flist = fremote.findAll();
        //top download
        List<TblImage> tilist = (List<TblImage>) iremote.topDownload();
    %>
    <body>
        <div class="home">
            <!--header//////////////////////////////////////////////////////////////////////////////////////-->
            <jsp:include page="homeHeader.jsp" flush="true"/>
            <!--end header-->
            <!--Primary//////////////////////////////////////////////////////////////////////////////////////-->
            <div class="primary">
                <div class="primary-1">
                    <div class="primary-1-left">
                        <jsp:include page="/slide/demo.html" flush="true" />
                        <%--<jsp:include page="slideshow1.jsp" flush="true"/>--%>
                    </div><!--end primary-1-left-->

                    <div class="primary-1-right">
                        <p class="p-tis-newphoto"><span class="h1">N</span>ewphoto</p>
                        <div class="p-tis-content-newphoto">
                            <%
                                for (int i = 0; i < ilist.size(); i++) {
                                    if (i < 3) {
                            %>
                            <div class="div-photo">
                                <div class="h-div-img"><a href="detailsImage.jsp?iid=<%= ilist.get(i).getImageID()%>" class="a-img"><img src="uploadImages/<%= ilist.get(i).getImageLocation().substring(ilist.get(i).getImageLocation().lastIndexOf("\\") + 1)%>" width="100" height="96"/></a></div>
                                <p class="p-namephoto"><%= StringUtils.getSubTilte(ilist.get(i).getImageName(), 10)%> Upload by <font color="red"> <%= ilist.get(i).getUserID().getUserID()%></font></p>
                            </div>
                            <%
                                    }
                                }%>
                        </div>
                        <div class="div-link" id="link-newphoto"><a href="moreTopNew.jsp"></a></div>
                    </div><!--end primary-1-right-->
                    <div class="clear"></div>
                </div><!--end primary-1-->


                <div class="primary-2">

                    <div class="primary-2-left">
                        <p class="p-tis-topvote"><span class="h1">A</span>ll Images</p>

                        <div class="primary-2-left-content">

                            <%
                                for (int i = 0; i < allImage.size(); i++) {
                            %>
                            <div class="div-photo2">
                                <div class="h-div-img2"><a href="detailsImage.jsp?iid=<%= allImage.get(i).getImageID()%>" class="a-img"><img src="uploadImages/<%= allImage.get(i).getImageLocation().substring(allImage.get(i).getImageLocation().lastIndexOf("\\") + 1)%>" width="180" height="174"/></a></div>
                                <p class="p-namephoto2"><%= StringUtils.getSubTilte(allImage.get(i).getImageName(), 10)%> Upload by <font color="red"> <%= allImage.get(i).getUserID().getUserID()%></font></p>
                                <!--<div class="vote"> <img src="images/sao.png" width="15" height="15"/><img src="images/sao.png"  width="15" height="15"/><img src="images/sao.png"  width="15" height="15"/><img src="images/sao2.png"  width="15" height="15"/><img src="images/sao2.png"  width="15" height="15"/></div>-->
                            </div>
                            <%
                                }
                            %>
                        </div>

                    </div><!--end primary-2-left-->
                    <div class="primary-2-right">
                        <div class="primary-2-right-1">
                            <p class="p-tis-newphoto"><span class="h1">N</span>ew user</p>
                            <div class="p-tis-content-newphoto">
                                <%
                                    for (int i = 0; i < luser.size(); i++) {
                                        if (i < 3) {
                                            String avatar = "";
                                            if (!"images/no.jpg".equalsIgnoreCase(luser.get(i).getUserAvatar())) {
                                                avatar = "uploadImages/" + luser.get(i).getUserAvatar().substring(luser.get(i).getUserAvatar().lastIndexOf("\\") + 1);
                                            } else {
                                                avatar = "images/no.jpg";
                                            }
                                %>
                                <div class="div-photo">
                                    <div class="h-div-img"><a href="profile.jsp?iid=<%= luser.get(i).getUserID() %>" ><img src="<%= avatar%>" width="69" height="65"/></a></div>
                                    <p class="p-namephoto"><font color="green"><%= StringUtils.getSubTilte(luser.get(i).getUserID(), 13)%> <%= DateUtils.daydiff(luser.get(i).getDateRegistration())%> days a go</font></p>
                                </div>
                                <%
                                        }
                                    }
                                %>
                                <div class="all-uer" style="top:20px; position:relative; width:200px; height:30px;"> Total active user: <font color="red"> <%= total%></font></div>
                            </div>
                            <div class="div-link" id="link-newphoto"><a href="moreUserList.jsp"></a></div>
                        </div>
                        <br/>
                        <div class="primary-2-right-1">
                            <p class="p-tis-newphoto"><span class="h1">T</span>op download</p>
                            <div class="p-tis-content-newphoto">
                                <%
                                    for (int i = 0; i < tilist.size(); i++) {
                                        if (i < 3) {
                                %>
                                <div class="div-photo">
                                    <div class="h-div-img"><a href="detailsImage.jsp?iid=<%= tilist.get(i).getImageID()%>" class="a-img"><img src="uploadImages/<%= tilist.get(i).getImageLocation().substring(tilist.get(i).getImageLocation().lastIndexOf("\\") + 1)%>" width="69" height="65"/></a></div>
                                    <p class="p-namephoto"><%= StringUtils.getSubTilte(tilist.get(i).getImageName(), 10)%> <font color="red"><%= tilist.get(i).getDownloadCount()%></font> downloads</p>
                                </div>
                                <%
                                        }
                                    }
                                %>
                            </div>
                            <div class="div-link" id="link-newphoto"><a href="moreTopDownload.jsp"></a></div>
                        </div>
                        <br/>
                        <div class="primary-2-right-1">
                            <p class="p-tis-newphoto"><span class="h1">F</span>QAs</p>
                            <div class="p-tis-content-newphoto">
                                <%
                                    for (int i = 0; i < flist.size(); i++) {
                                        if (i < 4) {
                                %>
                                <div class="div-photo-fqa">
                                    <div class="h-div-img-fqa"><img src="images/ask.jpg" width="30" height="30"/></div>
                                    <p class="p-namephoto-fqa"><a href="FQAsDetails.jsp?fid=<%= flist.get(i).getFaqid()%>"><%= StringUtils.getSubTilte(flist.get(i).getFAQQuestion(), 40)%></a> </p>
                                </div>
                                <%
                                        }
                                    }
                                %>
                            </div>
                            <div class="div-link" id="link-newphoto"><a href="FQAs.jsp"></a></div>
                        </div>
                    </div><!--end primary-2-right-->

                </div><!--end primary-2-->
                <div class="clear"></div>
            </div><!--end primary-->
            <!--Primary//////////////////////fotter////////////////////////////////////////////////-->
            <jsp:include page="homefooter.jsp" flush="true"/>
            <!--end footer-->
        </div><!--end-->
    </body>
</html>
