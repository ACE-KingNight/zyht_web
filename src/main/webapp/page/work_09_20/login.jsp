<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-20
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common_tag.jsp"%>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="<%=basePath%>/serlvet/testtwo.htm" method="post">
    用户名:<input type="text" name="username"/>
    密码:<input type="password" name="password"/>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
