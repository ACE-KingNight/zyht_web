<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-28
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/page/common_tag.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>国际化测试</title>
</head>
<body>
<a href="<%=basePath%>/action/test-internationalization!message.do?request_locale=zh_CN">中文</a>
<a href="<%=basePath%>/action/test-internationalization!message.do?request_locale=en_US">英文</a>
<form>
    <s:text name="name"/>:<input type="text"/><br>
    <s:text name="sex"/>:<input type="radio" name="sex" value="男"/><s:text name="male"/>
    <input type="radio" name="sex" value="女"/><s:text name="female"/><br>
    <s:text name="age"/>:<input type="text"/><br>
</form>
</body>
</html>
