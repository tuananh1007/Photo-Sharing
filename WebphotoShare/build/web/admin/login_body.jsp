

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <script type="text/javascript">
function betterMo() {
document.login.reset();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style>
		.login
		{
		width:400px;
		height:300px;
		position:relative;
		background:url(../images/login.jpg) top left no-repeat;
		margin:auto;
		border:5px solid #CCCCCC;}
		.div-txt1
		{
		width:400px;
		height:30px;
		position:relative;
		top:110px;
		background:none;
		}
		.div-txt2
		{
		width:400px;
		height:30px;
		position:relative;
		top:130px;
		background:none;
		}
		.txt1,.txt2
		{
		width:150px;
		height:20px;
		position:relative;
		margin-left:170px;
		border:none;
		background:none;
		color:#FFFFFF;}
		.check
		{
		width:400px;
		height:30px;
		position:relative;
		top:134px;
		font-family:Arial;
		font-size:14px;
		color:#999999;
		}
		.c-box
		{
		margin-left:140px;
		}
		.div-bt
		{
		width:400px;
		height:33px;
		position:relative;
		top:134px;
		font-family:Arial;
		font-size:14px;
		color:#999999;
		}
		.bt-login
		{
		display:block;
		position:relative;
		width:74px;
		height:33px;
		background:url(../images/bt.png) top left no-repeat;
		text-align:center;
		line-height:33px;
		left:170px;
		float:left;
		font-family:Arial;
		font-size:14px;
		color:#FFFFFF;
		text-decoration:none;
		outline:none;
                border: none;
		}
		.bt-reset
		{
		display:block;
		position:relative;
		width:74px;
		height:33px;
		background:url(../images/bt.png) top left no-repeat;
		text-align:center;
		line-height:33px;
		float:left;
		font-family:Arial;
		font-size:14px;
		color:#FFFFFF;
		left:170px;
		text-decoration:none;
		border: none;
                outline: none;
		}
		#bt-reset:hover,#bt-login:hover
		{
		background:url(images/bt-activate.png) top left no-repeat;
		}
	</style>
<body>
    <s:form id="login" theme="simple" action="alogin">
	<div class="login">
            <div class="div-txt1"><s:textfield name="aname" theme="simple" cssClass="txt1"/></div>
            <div class="div-txt2"><s:password name="apass" cssClass="txt2" theme="simple"/></div>
            <div class="div-bt"><s:submit cssClass="bt-login" theme="simple"/>
            <input type="button" value="Reset" onclick="betterMo()" class="bt-reset"/>
            </div>
    </div>
            <div align="center"><font color="#FF0000"><s:actionerror/></font></div>
    </s:form>
</body>
