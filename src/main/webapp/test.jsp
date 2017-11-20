<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="page/common_tag.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%--<%@ page isErrorPage="true" %>--%>
<html>
<head>
    <title></title>
</head>
<body>
<a href="<%=basePath%>/action/login!test.do">test</a>
<p><s:property value="#request.test"/></p>
<h1><s:property value="#session.testSession"/></h1>
</body>
</html>
