<%@ page import="java.net.URLEncoder" %>
<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-14
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    out.println(request.getParameter("userName"));
    String userName = URLEncoder.encode(request.getParameter("userName"),"utf-8");
    String password = request.getParameter("password");
    Cookie myLoginCookie = new Cookie("fsk1234",userName+"#"+password+"#"+new java.util.Date().toLocaleString());
    myLoginCookie.setMaxAge(60*60*24*30);
    response.addCookie(myLoginCookie);
%>
<script type="text/javascript">
    window.location.href="requestWork.jsp";
</script>
</body>
</html>
