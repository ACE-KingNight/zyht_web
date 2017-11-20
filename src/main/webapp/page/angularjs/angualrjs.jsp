<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-10-09
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common_tag.jsp" %>

<html ng-app="myApp">
<head>
    <meta charset="utf-8">
    <title>testAngular</title>
</head>
<body>

<page-header></page-header>
<page-slide></page-slide>

<div ng-controller="changeCase" ng-model="lowCase">
    <h3>大小写过滤器 : {{lowCase | uppercase}}</h3>
    <h3>时间转换过滤器 : {{1490161945000 | date:"yyyy-MM-dd HH:mm:ss"}}</h3>
    <h3>货币格式转换过滤器 : {{ 250 | currency }}  {{ 250 | currency:"RMB ￥ " }}</h3>
</div>
<div ng-controller="timeout" ng-model="myTime">
    <%-- 固定时间后调用 --%>
    <h3>TimeOut服务: 5秒后切换显示内容{{myTime}}</h3>
</div>
<div ng-controller="interval" ng-model="myInterval">
    <%-- 每隔固定时间调用一次方法 --%>
    <h3>interval服务 : 当前时间{{myInterval}}</h3>
</div>
<div ng-controller="customer" ng-model="customers">
    <table class="table table-striped">
       <thead>
       <tr>
           <th>序号</th>
           <th>客户名</th>
           <th>电话号码</th>
           <th>性别</th>
           <th>身份证号</th>
           <th>余额</th>
           <th>地址</th>
       </tr>
       </thead>
        <tr ng-repeat="customer in customers">
            <td>{{$index+1}}</td>
            <td>{{customer.name}}</td>
            <td>{{customer.phoneCode}}</td>
            <td>{{customer.sex}}</td>
            <td>{{customer.idCard}}</td>
            <td>{{customer.balance}}</td>
            <td>{{customer.address}}</td>
        </tr>
    </table>
</div>

<div>
    <a ui-sref="head">head</a>
    <a ui-sref="carouse">carouse</a>
    <a ui-sref="footer">footer</a>
</div>
<div ui-view>
</div>




<page-footer></page-footer>


<script src="<%=basePath%>/js/angular.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/angular-ui-router.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/js/testAngularJs.js" type="text/javascript"></script>
</body>
</html>
