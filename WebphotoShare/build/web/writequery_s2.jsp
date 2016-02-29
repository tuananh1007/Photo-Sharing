

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<s:head theme="ajax" />--%>
    </head>
    <body>
        <s:form action="dowritequery">
        <s:textarea name="content" label="Edit your question here" cssStyle="background-color:#FCFCFC; border: 1px solid #A0A0A0; min-height:300px; max-height:100px;max-height:100px;overflow: scroll;" cols="50" rows="15" />
        <s:submit value="Post comment"/>
        <s:actionmessage/>
        <s:actionerror/>
        </s:form>
    </body>
</html>
