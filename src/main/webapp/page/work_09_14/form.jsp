<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-14
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="../common_tag.jsp"%>
<html>
<head>
    <title>表单界面</title>
    <script>
        function validateForm(){
            var name=document.forms["myForm"]["name"].value;
            if (name==null || name==""){
                alert("姓必须填写");
                return false;
            }
            var email = document.forms["myForm"]["email"].value;
            var emailreg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
            if (email==null || email ==""){
                alert("请输入邮箱!");
                return false;
            }else if(!emailreg.test(email)){
                alert("请输入正确的邮箱!");
                return false;
            }
            var phone = document.forms["myForm"]["phone"].value;
            var phonereg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0-9]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-4]{1})|(18[5-9]{1}))+\d{8})$/;
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
            var birthday = document.forms["myForm"]["birthday"].value;
            if(birthday == null || birthday == ""){
                alert("请输入生日");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
    <div style="margin-left: 40%">
        <form name="myForm" action="transmit.jsp" method="post" style="margin-top: 5%" onsubmit="return validateForm()">
            姓名:<input style="margin-top: 2%" type="text" name="name"/><br>
            性别:男<input style="margin-top: 2%" type="radio" name="sex" value="男" checked="checked"/>
            女<input style="margin-top: 2%" type="radio" name="sex" value="女"/><br>
            邮箱:<input style="margin-top: 2%" type="text" name="email"/><br>
            电话:<input style="margin-top: 2%" type="text" name="phone"/><br>
            出生年月:<input style="margin-top: 2%" type="date" name="birthday"/><br>
            <input style="margin-left: 5%;margin-top: 2%" type="submit" value="提交">
            <input style="margin-left: 5%;margin-top: 2%" type="reset" value="重置">
            <% request.setCharacterEncoding("utf-8");%>
        </form>
    </div>
</body>
</html>

