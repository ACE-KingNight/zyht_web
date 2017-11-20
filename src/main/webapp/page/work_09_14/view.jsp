<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-14
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>展示界面</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
    String sex = request.getParameter("sex");
    sex = new String(sex.getBytes("ISO-8859-1"),"UTF-8");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String birthday = request.getParameter("birthday");
    session.setAttribute("name",name);
    session.setAttribute("sex",sex);
    session.setAttribute("email",email);
    session.setAttribute("phone",phone);
    session.setAttribute("birthday",birthday);
    request.getSession().getAttribute("");

%>
<div>
    <label>姓名:<%=name%></label><br>
    <label>性别:<%=sex%></label><br>
    <label>邮箱:<%=email%></label><br>
    <label>电话:<%=phone%></label><br>
    <label>生日:<%=birthday%>
    </label><br>
    test:<%=request.getContextPath()%>
    test2:<%=request.getServletPath()%>
</div>

</body>
</html>
