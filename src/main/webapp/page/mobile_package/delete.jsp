<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-18
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common_tag.jsp"%>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<html>
<head>
    <title>查询显示</title>
    <script>
        $(function(){
            $("#but1").click(function(){
                var id = $("#ID").val();
                $.ajax({
                    type:"post",
                    url:"<%=basePath%>/serlvet/customerselect.htm",
                    data: {"id":id},
                    dataType:"json",
                    success:function(data){
                        $("#update").css("display","block");
                        for(var i = 0;i<data.length;i++){
                            var customer = data[i];
                            $("#name").val(customer.name);
                            if(customer.sex == "男"){
                                $("#sex").attr("checked","checked");
                                $("#sex").prop("checked");
                            }else{
                                $("#sex1").attr("checked","checked");
                                $("#sex1").prop("checked");
                            }
                            $("#idCard").val(customer.idCard);
                            $("#phoneCode").val(customer.phoneCode);
                            $("#address").val(customer.address);
                            $("#balance").val(customer.balance);
                            $("#idUpdate").val(customer.id);
                        }
                    },error:function(error){
                        alert("com.aaa");
                    }
                })
            });
        });
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
<div style="margin-top: 3%;width: 100%;height: 10%;text-align: center">
    <p>请输入需要查询的用户Id</p>
    ID:<input type="text" id="ID"/>
    <button id="but1">查询</button>
</div>
<div style="margin-left: 41%;display: none" id="update">
    <form name="myForm" action="<%=basePath%>/serlvet/customerdelete.htm" method="post" style="margin-top: 5%" onsubmit="return validateForm()">
        姓名:<input style="margin-top: 2%" readonly type="text" id="name" name="name"/><br>
        性别:男<input style="margin-top: 2%" disabled type="radio" id="sex" name="sex" value="男"/>
        女<input style="margin-top: 2%" disabled type="radio" id="sex1" name="sex" value="女"/><br>
        身份证号:<input style="margin-top: 2%" readonly type="text" id="idCard" name="idCard"/><br>
        电话:<input style="margin-top: 2%" readonly type="text" id="phoneCode" name="phoneCode"/><br>
        地址:<input style="margin-top: 2%" readonly type="text" id="address" name="address"/><br>
        余额:<input style="margin-top: 2%" readonly type="text" id="balance" name="balance" value="0"/><br>
        <input id="idUpdate" name="id" type="text" hidden="hidden"/>
        <input style="margin-left: 5%;margin-top: 2%" type="submit" value="删除"/>
        <% request.setCharacterEncoding("utf-8");%>
    </form>
</div>
</body>
</html>