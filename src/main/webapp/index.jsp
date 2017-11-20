<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="page/common_tag.jsp"%>

<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
<script src="<%=basePath%>/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
<html>
<head>
    <title>首页</title>
</head>
<%--<body>--%>
<%--<c:if test="${name!=null}" >--%>
    <%--${name}--%>
<%--</c:if>--%>
<%--<c:if test="${name==null}" >--%>

<%--</c:if>--%>

<h1>你好</h1><br>
<%--<%=session.getAttribute("testSession")%><br>--%>
<h2><%
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<%=simpleDateFormat.format(new Date(session.getCreationTime()))%>
</h2>
<ul class="nav nav-pills">
    <li><a href="page/mobile_package/customer.jsp">添加客户</a></li>
    <li><a href="page/mobile_package/select.jsp">查询客户</a></li>
    <li><a href="page/mobile_package/packageinformation.jsp">套餐信息</a></li>
    <li><a href="page/angularjs/angualrjs.jsp">Angualrjs</a></li>
    <li><a href="html/angular.html">Angualrjs.html</a></li>
    <li><a href="page/work_10_09/fileupload.jsp">文件上传</a></li>
    <li><a href="html/index.html">新页面</a></li>
    <li><a href="test.jsp">测试</a></li>
</ul>
</body>
</html>
