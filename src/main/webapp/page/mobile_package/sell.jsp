<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-22
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common_tag.jsp"%>

<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/sell.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>

<html>
<head>
    <title>套餐购买</title>
</head>
<body>
<div class="back" style="text-align: center;">
    <h2>请选择一款套餐进行购买</h2>
    <table id="myTb" class="table table-striped" style="text-align: center;border-collapse: separate;border-spacing: 20px">
        <thead>
        <tr>
            <th><input type="checkbox" hidden="hidden"></th>
            <th>套餐编号</th>
            <th>套餐名</th>
            <th>套餐描述</th>
            <th>短信数</th>
            <th>通话时长</th>
            <th>流量</th>
            <th>是否有彩铃</th>
            <th>是否有来电显示</th>
            <th>月租</th>
            <th>套餐开始时间</th>
            <th>套餐结束时间</th>
        </tr>
        </thead>
    </table>
    <div>
        <button id="insertBut" onclick="buy()" type="button" class="btn btn-success">购买</button>
    </div>
</div>
</body>
</html>
