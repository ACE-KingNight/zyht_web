<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-24
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common_tag.jsp"%>

<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/packpurinformation.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
<html>
<head>
    <title>套餐购买记录</title>
</head>
<body style="text-align: center">
    <h1>客户的ID是:${param.customerId}</h1>
    <div class="back" style="text-align: center;">
        <table id="myTb" class="table table-striped" style="text-align: center;border-collapse: separate;border-spacing: 20px">
            <thead>
            <tr>
                <th><input type="text" hidden="hidden"></th>
                <th>编号</th>
                <th>购买时间</th>
                <th>客户姓名</th>
                <th>套餐名</th>
                <th>支付金额</th>
                <th>是否支付成功</th>
                <th>执行时间</th>
            </tr>
            </thead>
        </table>
        <div>
            <button id="insertBut" onclick="getback()" type="button" class="btn btn-success">返回</button>
        </div>
    </div>
</body>
</html>
