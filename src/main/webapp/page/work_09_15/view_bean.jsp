<%--
  Created by IntelliJ IDEA.
  User: Wzx
  Date: 2017-09-15
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示</title>
</head>
<body>
<jsp:useBean id="paper" class="com.demo.Paper"></jsp:useBean>
<jsp:useBean id="addr" class="com.demo.addr"></jsp:useBean>
<jsp:setProperty name="paper" property="*"></jsp:setProperty>
您掌握的语言:<%=addr.addStr(paper.getLanguages())%>
您掌握的技能:<%=paper.getTech()%>
${param.languages}
${cookie.password.value}
${header.connection}
</body>
</html>
