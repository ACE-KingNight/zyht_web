<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="common_tag.jsp"%>
<html>
<head>
    <title>测试</title>
</head>
<body>
<%--<jsp:include page="common_tag.jsp">--%>

<%=basePath%>
<%
    for (int i = 0; i < 10 ; i++) {
            %><h1 style="color: green"><%=i+2%></h1><%
        if (i > 5){
            %><h1 style="color: red"><%=i%></h1><%
        }
    }
%>
<%
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String string = simpleDateFormat.format(date);
%>
时间<%=string+"十大"%>

<%
    String dx = request.getParameter("dx");
    String dy = request.getParameter("dy");
    double x = Double.parseDouble(dx);
    double y = Double.parseDouble(dy);
%>

结果等于=<%=x+y%>


</body>
</html>
