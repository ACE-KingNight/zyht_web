<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-15
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ include file="../common_tag.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>用户注册</title>
    <script>
        function validateForm(){
            var name=document.forms["myForm"]["name"].value;
            if (name==null || name==""){
                alert("姓必须填写");
                return false;
            }
            var idCard = document.forms["myForm"]["idCard"].value;
            var emailreg = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
            if (idCard==null || idCard ==""){
                alert("请输入身份证号!");
                return false;
            }else if(!emailreg.test(idCard)){
                alert("请输入正确的身份证号!");
                return false;
            }
            var phone = document.forms["myForm"]["phoneCode"].value;
            var phonereg = /^1(3|4|5|7|8)\d{9}$/;
            if(phone ==null || phone==""){
                alert("请输入手机号!");
                return false;
            }else if(phone.length != 11){
                alert("请输入正确的手机号!");
                return false;
            }else if(!phonereg.test(phone)){
                alert("请输入正确的手机号111!");
                return false;
            }
            var birthday = document.forms["myForm"]["address"].value;
            if(birthday == null || birthday == ""){
                alert("请输入地址!!!");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<div style="margin-left: 40%">
    <form name="myForm" action="<%=basePath%>/action/customer!saveCustomer.do" method="post" style="margin-top: 5%" onsubmit="return validateForm()">
        姓名:<input style="margin-top: 2%" type="text" name="name"/><br>
        性别:男<input style="margin-top: 2%" type="radio" name="sex" value="男" checked="checked"/>
        女<input style="margin-top: 2%" type="radio" name="sex" value="女"/><br>
        身份证号:<input style="margin-top: 2%" type="text" name="idCard"/><br>
        电话:<input style="margin-top: 2%" type="text" name="phoneCode"/><br>
        地址:<input style="margin-top: 2%" type="text" name="address"/><br>
        余额:<input style="margin-top: 2%" type="text" name="balance" value="0"/><br>
        <input style="margin-left: 5%;margin-top: 2%" type="submit" value="提交"/>
        <input style="margin-left: 5%;margin-top: 2%" type="reset" value="重置"/>
        <% request.setCharacterEncoding("utf-8");%>
    </form>
</div>
</body>
</html>
