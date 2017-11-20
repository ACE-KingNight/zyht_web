<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-15
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common_tag.jsp"%>
<html>
<head>
    <title>测试JSP_bean</title>
</head>
<body>
<%--${5 lt 4}--%>
<%--${4 gt 5}--%>
<%--${5 le 5}--%>
<%--${6 ge 6}--%>
<%--${"12".concat("1000")}--%>
<%--${55 += 5}--%>
<%
    List<String> stringList = new ArrayList<String>();
    stringList.add("111");
    stringList.add("222");
    stringList.add("333");
    request.setAttribute("stringList",stringList);
    Integer[] integers ={1,2,3,4,5};
    session.setAttribute("integers",integers);
    Cookie cookie = new Cookie("password","admin");
    response.addCookie(cookie);
%>
${stringList[0]}
${stringList.get(1)}
${integers[4]+stringList.get(2)}
<%--<%=basePath%>/serlvet/testserlvet.htm--%>
<form action="view_bean.jsp" method="post">
    <h1>语言</h1>
    <input type="checkbox" name="languages" value="java">java
    <input type="checkbox" name="languages" value="c++">c++
    <input type="checkbox" name="languages" value="是">c#
    <input type="checkbox" name="languages" value="php">php
    <h1>技术</h1>
    <input type="checkbox" name="tech" value="说">jsp
    <input type="checkbox" name="tech" value="html">html
    <input type="checkbox" name="tech" value="css">css<br>
    <%request.setCharacterEncoding("utf-8");%>
    <input type="submit" value="提交">
    <input type="reset" value="重置">

</form>

</body>
</html>
