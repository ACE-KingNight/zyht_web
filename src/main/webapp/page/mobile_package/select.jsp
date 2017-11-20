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
<%@taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/select.js"></script>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
<html>
<head>
    <title>查询显示</title>
</head>
<body>
<ul class="nav nav-pills">
    <li><a href="<%=basePath%>/action/customer!changeLanguage.do?request_locale=zh_CN">中文</a></li>
    <li><a href="<%=basePath%>/action/customer!changeLanguage.do?request_locale=en_US">English</a></li>
    <li><a href="#"></a></li>
    <li><a href="#"></a></li>
    <li><a href="#"></a></li>
</ul>
<div  style="margin-left:15%;margin-top: 1%;width: 70%;height: 10%;text-align: center">
        <p class="text-primary"><s:text name="userId"/></p>
        ID:<input style="text-align: center" class="form-control" type="text" id="ID"/>
        <button style="margin-top: 1%" class="btn btn-success" type="button" id="but1"><s:text name="update"/></button>
        <button style="margin-top: 1%" class="btn btn-info" type="button" id="but3"><s:text name="delete"/></button>
        <button style="margin-top: 1%" class="btn btn-primary" type="button" id="but2"><s:text name="select"/></button>
</div>
<div style="margin-left: 33%;width: 30%;display: none" id="update">
    <form class="form-horizontal" role="form" name="myForm" action="<%=basePath%>/action/customer!updateCustomer.do" method="post" style="margin-top: 5%" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="name" class="col-sm-4 control-label"><s:text name="name"/></label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="name" name="name" placeholder=<s:text name="name"/>>
            </div>
        </div>
        <div class="form-group">
            <label for="sex" class="col-sm-4 control-label"><s:text name="sex"/></label>
            <label class="radio-inline">
                <input style="margin-top: 2%" type="radio" id="sex" name="sex" value="男"/><s:text name="male"/>
            </label>
            <label class="radio-inline">
                <input style="margin-top: 2%" type="radio" id="sex1" name="sex" value="女"/><s:text name="female"/>
            </label>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-4 control-label"><s:text name="idCard"/></label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="idCard" name="idCard" placeholder=<s:text name="idCard"/>>
            </div>
        </div>
        <div class="form-group">
            <label for="phoneCode" class="col-sm-4 control-label"><s:text name="phoneCode"/></label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="phoneCode" name="phoneCode" placeholder=<s:text name="phoneCode"/>>
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-4 control-label"><s:text name="address"/></label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="address" name="address" placeholder=<s:text name="address"/>>
            </div>
        </div>
        <div class="form-group">
            <label for="balance" class="col-sm-4 control-label"><s:text name="balance"/></label>
            <div class="col-sm-8">
                <input type="text" class="form-control" value="0" id="balance" name="balance" placeholder=<s:text name="balance"/>>
            </div>
        </div>
        <input id="idUpdate" name="id" type="text" hidden="hidden"/>
        <input class="btn btn-warning  btn-block" id="submit" style="margin-left: 5%;margin-top: 2%;display: none" type="submit" value=<s:text name="updateBut"/>>
        <button class="btn btn-danger  btn-block" id="delete" name="delete" type="button" style="margin-left: 5%;margin-top: 2%;display: none"><s:text name="deleteBut"/></button>
        <input class="btn btn-info  btn-block" id="reset" style="margin-left: 5%;margin-top: 2%;display: none" type="reset" value=<s:text name="reset"/>>
        <button class="btn btn-success btn-block" id="packpurinformation" type="button" style="margin-left: 5%;display: none;margin-top: 1%"><s:text name="view_pur"/></button>
        <button class="btn btn-info btn-block" type="button" id="tellphone" style="margin-left: 5%;display:none;margin-top: 1%"><s:text name="phone_message"/></button>
        <button class="btn btn-primary btn-block" id="sell" type="button" style="margin-left: 5%;display: none;margin-top: 1%"><s:text name="buy_pack"/></button>
        <% request.setCharacterEncoding("utf-8");%>
    </form>
</div>
</body>
</html>
