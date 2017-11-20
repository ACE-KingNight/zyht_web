<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-14
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>转发页面</title>
</head>
<body>
正在转发:~~~~
<%
    RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
    rd.forward(request, response);
    request.setCharacterEncoding("utf-8");

%>

</body>
</html>
