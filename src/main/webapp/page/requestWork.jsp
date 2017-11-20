<%@ page import="java.util.Date" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Enumeration" %>
<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-13
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common_tag.jsp"%>
<html>
<head>
    <title>测试request</title>
</head>

<body>
<form name="test_form" action="" method="post">
    <input type="text" name="qwe">
    <input type="checkbox" name="aihao" value="篮球"/>篮球
    <input type="checkbox" name="aihao" value="足球"/>足球
    <input type="checkbox" name="aihao" value="游泳"/>游泳
    <button style="" value="提交" type="submit" name="test_form">提交</button>
    <button value="重置" type="reset" name="test_form">重置</button>
</form>
请求方式：<%=request.getMethod()%><br>
请求的资源：<%=request.getRequestURI()%><br>
请求用的协议：<%=request.getProtocol()%><br>
请求的文件名：<%=request.getServletPath()%><br>
请求的服务器的IP：<%=request.getServerName()%><br>
客户端IP地址：<%=request.getRemoteAddr()%><br>
客户端主机名：<%=request.getRemoteHost()%><br>
<%request.setCharacterEncoding("utf-8");%>
表单提交来的值：<%=request.getParameter("qwe")%><br>
<%
    String[] aihaoArr = request.getParameterValues("aihao");
%>
表单提交checkbox的值:
<%
    if (aihaoArr !=null && aihaoArr.length>0){
        for (String anAihaoArr : aihaoArr) {
%><%=anAihaoArr%>
<%
        }
    }
%><br>
您的访问端口是:<%=request.getRemotePort()%><br>
服务器所开放的端口是:<%=request.getServerPort()%><br>
客户请求信息的总长度:<%=request.getContentLength()%><br>
请求中位于路径之后的查询字符串:<%=request.getQueryString()%><br>
http头文件中user-agent的值:<%=request.getHeader("User-Agent")%><br>
http头文件中accept的值:<%=request.getHeader("accept")%><br>
http头文件中Host的值:<%=request.getHeader("Host")%><br>
http头文件中accep-encoding的值是<%=request.getHeader("accept-encoding")%><br>
<% request.setAttribute("test",new Date());%>
测试setAttribute:::::<%=request.getAttribute("test")%>
<%--<% session.setAttribute("testSession", "测试Session");%>--%>
<%--<% session.removeAttribute("testSession");%>--%>


<%
    Cookie[] cookies = request.getCookies();
    String userName = "";
    String password = "";
    String data = "";
    if (cookies !=null && cookies.length > 0){
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("fsk1234")) {
                userName = URLDecoder.decode(cooky.getValue().split("#")[0], "utf-8");
                password = cooky.getValue().split("#")[1];
                data = cooky.getValue().split("#")[2];
            }
        }
    }
    if ("".equals(userName) && "".equals(password) && "".equals(data)){
    %>
<p>游客您好</p>
<form action="test_cookies.jsp" id="myForm" name="myForm" method="post">
    请输入用户名:<label>
    <input name="userName" type="text"/>
</label><br>
    请输入密码:<label>
    <input type="password" name="password"/>
</label><br>
    <input type="submit" name="submit" value="注册"/>
</form>
<%} else {%>
    欢迎<b><%=userName%></b>再次光临!<br>
    您注册的时间是:<%=data%><br>
<%}%>
<%--<%--%>
    <%--response.setHeader("refresh","5;URL=../index.jsp");--%>
    <%--response.sendRedirect("../test_jsp.jsp");//页面重定向--%>
<%--%>--%>

<%
    String name = "" ;
    String passwordw = "";
    //获取所有初始属性
    Enumeration<String> enumeration = application.getInitParameterNames();
    while (enumeration.hasMoreElements()){
        name = enumeration.nextElement();
        passwordw = application.getInitParameter(name);
    }
%>
name=<%=name%><br>
password=<%=passwordw%>

</body>
</html>
