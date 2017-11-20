<%@ page import="java.util.Calendar" %>
<%@ page import="sun.util.resources.CalendarData" %>
<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-10-12
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="common_tag.jsp"%>

<html>
<head>
    <title>struts</title>
</head>
<%
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DATE)+10);
    pageContext.setAttribute("futureDate",calendar.getTime());
%>
<body>
<h3>指定format="yyyy年MM月dd日"</h3>
<s:date name="#attr.futureDate" format="yyyy年MM月dd日"/>
<h3>没有使用format,指定nice=ture</h3>
<s:date name="#attr.futureDate" nice="true"/>
<h3>没有使用format和nice,将以资源包中的struts.date.format键的值作为格式化样式</h3>
<s:date name="#attr.futureDate"/>

</body>
</html>
