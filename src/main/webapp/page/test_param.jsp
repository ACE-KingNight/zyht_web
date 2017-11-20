<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    double dx = 12d;
    double dy = 13d;
%>
<jsp:include page="test_jsp.jsp">
    <jsp:param name="dx" value="<%=dx%>"/>
    <jsp:param name="dy" value="<%=dy%>"/>
</jsp:include>
</body>
</html>
