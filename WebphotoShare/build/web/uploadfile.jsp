<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>File Upload Example</title>
<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<font color='red'><s:actionerror  /></font>
<s:form action="doUpload" name="upload" method="POST" enctype="multipart/form-data">
<tr>
    <td colspan="2"><h2 align="center">Upload new Image File</h2> <p align="center" >(* limit size 20MB/file, format jpg,png,bmp,gif)</p></td>
</tr>
<s:file name="upload" label="File" tooltip="browse file to upload" required="true" size="55"/>
<s:textfield name="fileCaption" label="Caption" required="true" maxLength="50" tooltip="Enter File Name" size="55" />
<s:submit />
</s:form>
</body>
</html>