<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page  import="java.io.FileInputStream" %>
<%@ page  import="java.io.BufferedInputStream"  %>
<%@ page  import="java.io.File"  %>
<%@ page import="java.io.IOException" %>
<%@page  import="javax.naming.InitialContext,java.util.List,bean.session.*,bean.entity.*,utils.*,log.WriteLog" %>
<%
//String path=request.getAttribute("id").toString();
int id=Integer.parseInt(request.getParameter("id"));
InitialContext ict=new InitialContext();
TblImageFacadeRemote iremote=(TblImageFacadeRemote)ict.lookup("java:global/WebphotoShare/TblImageFacade");
TblImage image=(TblImage)iremote.find(new Integer(id));
image.setDownloadCount(image.getDownloadCount()+1);
iremote.edit(image);
String path=image.getImageLocation();
String filename=path.substring(path.lastIndexOf("\\"));
BufferedInputStream buf=null;
ServletOutputStream myOut=null;
try{
     myOut=response.getOutputStream();
//Add download counter here
     File f=new File(path);
     URL url=f.toURL();
     InputStream ins=url.openConnection().getInputStream();
     //set response headers
     response.setContentType("application/Octet-Stream");

     response.addHeader(
        "Content-Disposition","attachment; filename="+filename );

     response.setContentLength( (int) f.length());
   //  FileInputStream input = new FileInputStream(myfile);
     buf = new BufferedInputStream(ins);
     int readBytes = 256;

     //read from the file; write to the ServletOutputStream
     while((readBytes = buf.read( )) != -1)
     myOut.write(readBytes);
     myOut.flush();
     myOut.close();
     buf.close( );
} catch (IOException e){
WriteLog writelog=new WriteLog();
writelog.writeLogInfo(e.getMessage());
writelog.writeLogInfo("IP accessing:"+request.getRemoteAddr()+" URL:"+request.getRequestURI());
     } finally {
     //close the input/output streams
     if (myOut != null)
          myOut.close( );
          if (buf != null)
          buf.close( );
     }
%>