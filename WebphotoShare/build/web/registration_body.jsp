<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <%@taglib uri="/struts-tags" prefix="s" %>
        <%@taglib prefix="sx" uri="/struts-dojo-tags" %>
        <title>Registration User</title>
        <sx:head parseContent="true"/>
        <style>
            .register
            {
                width:600px;
                height:400px;
                position:relative;
                background:url(images/UploadAnh_dangky.png) top left no-repeat;
                margin:auto;
                border:5px #CCCCCC solid;}
            .dong1, .dong2, .dong3 ,.dong4, .dong5
            {
                width:600px;
                height:30px;
                position:relative;
                top:108px;
            }
            .dong2, .dong3 ,.dong4, .dong5
            {
                margin-top:24px;
            }
            #id, #birthday, #mail, #gender, #capchar, #capchar2
            {
                float:left;
                left:90px;
                position:relative;
                background:none;
                border:none;
                color:#FFFFFF;
                font-weight:bold;
            }
            #doCaptcha_birthday{
                margin-left:275px;
            }
            #gender
            {
                margin-left:210px;
            }
            #capchar2
            {
                margin-left:150px;
            }
            #bt-login
            {
                display:block;
                position:relative;
                width:74px;
                height:33px;
                background:url(images/bt.png) top left no-repeat;
                text-align:center;
                line-height:33px;
                left:230px;
                float:left;
                font-family:Arial;
                font-size:14px;
                color:#FFFFFF;
                text-decoration:none;
                outline:none;
                border: none;
            }
            #bt-reset
            {
                display:block;
                position:relative;
                width:74px;
                height:33px;
                background:url(images/bt.png) top left no-repeat;
                text-align:center;
                line-height:33px;
                float:left;
                font-family:Arial;
                font-size:14px;
                color:#FFFFFF;
                left:230px;
                text-decoration:none;
                outline:none;
                border: none;
            }
            #bt-reset:hover,#bt-login:hover,#bt-refresh:hover
            {
                background:url(images/bt-activate.png) top left no-repeat;
            }
            .dong5
            {
                font-family:Tahoma;
                font-size:14px;
                color:#666666;
                padding-left:20px;
                padding-right:20px;
                font-weight:bold;}
            #capchar
            {
                width:100px;
                height:30px;
            }
            #bt-refresh
            {
                display:block;
                position:relative;
                width:74px;
                height:40px;
                background:url(images/bt.png) top left no-repeat;
                text-align:center;
                line-height:33px;
                float:left;
                left:100px;
                top:-7px;
                font-family:Arial;
                font-size:14px;
                color:#FFFFFF;
                text-decoration:none;
                outline:none;
            }
            .errorMessage {
                color: red;
                font-size: 0.8em;
            }
            .label {
                color:#000000;
            }
        </style>
        <link href="<s:url value="style.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript">
            function betterMo() {
                document.frm.reset();
            }
        </script>
    </head>



    <body>
        <s:form action="doCaptcha" name="frm" method="post" theme="simple">
            <div class="register">

                <div class="dong1"><s:textfield name="username" id="id" theme="simple"/> <sx:datetimepicker name="birthday" /></div>
                <div class="dong2"><s:textfield name="email" theme="simple" id="mail"/> <s:select name="gender" list="{'Male','F.Male'}" id="gender"/></div>
                <div class="dong3"><img src="Captcha.jpg" id="capchar"/> <a href="/WebphotoShare/registration.jsp" id="bt-refresh">Refresh</a> <s:textfield name="answer" theme="simple" id="capchar2" tooltip="Enter Capchar from image"/></div>
                <div class="dong4"><s:submit theme="simple" id="bt-login"/><button type="reset" value="reset" name="reset" id="bt-reset" onclick="betterMo();">Reset</button></div>
                <div class="dong5"><span class="name-photo">(*)</span> Password will be send to your email after admin approve your account!</div>
            </div>
            <div align="center"><font color="#FF0000"><s:actionerror/><s:actionmessage/></font></div>
                </s:form>
    </body>

</html>
